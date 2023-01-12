package com.example.preview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.midi.MidiDevice;
import android.media.midi.MidiDeviceInfo;
import android.media.midi.MidiInputPort;
import android.media.midi.MidiManager;
import android.media.midi.MidiManager.DeviceCallback;
import android.media.midi.MidiOutputPort;
import android.media.midi.MidiReceiver;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.leff.midi.*;
import com.leff.midi.event.MidiEvent;
import com.leff.midi.event.NoteOn;
import com.leff.midi.event.NoteOff;
import com.leff.midi.util.MidiEventListener;
import com.leff.midi.util.MidiProcessor;

import jp.kshoji.javax.sound.midi.InvalidMidiDataException;
import jp.kshoji.javax.sound.midi.ShortMessage;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button mBtnCheck;
    private WebView mWebView;
    private MidiManager midiManager;
    private CheckHandler mCheckHandler;

    MidiInputPort inputPort;
    MidiOutputPort outputPort;

    private MyReceiver noteReceiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.txview);
        mBtnCheck = findViewById(R.id.btnCheck);
        mWebView = findViewById(R.id.webview);
        mBtnCheck.setText("调用vue里接口");
        mBtnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checkMidiDevice();
                callJavaScript(mWebView, "nativeCallJS", "[aaaaaaaa],offset=2,cout=3");
            }
        });
        midiManager = (MidiManager)
        this.getSystemService(Context.MIDI_SERVICE);
        mCheckHandler = new CheckHandler(this.getMainLooper());
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new MyJSInterface(this), "JsInterface");
        mWebView.setWebChromeClient(new CustomWebChromeClient());
        //mWebView.loadUrl("file:///android_asset/index.html");
        mWebView.loadUrl("file:///hybrid/html/preview/app/src/main/assets/index.html");
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_MIDI)) {
            showToast("支持midi设备");
            midiManager.registerDeviceCallback(new DeviceCallback(){
                public void onDeviceAdded(MidiDeviceInfo device) {
                    showToast("midi device added");
                }
                public void onDeviceRemoved(MidiDeviceInfo device) {
                    showToast("midi device removed");
                }
            },mCheckHandler);
        }else{
            showToast("不支持midi设备");
        }
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {

        super.onPause();
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    private void checkMidiDevice(){
        ArrayList filteredOutMidiDevices = new ArrayList<>();
        ArrayList filteredInMidiDevices = new ArrayList<>();
        if(midiManager == null){
            return;
        }


        for (MidiDeviceInfo midiDevice : midiManager.getDevices()){
            if (midiDevice.getOutputPortCount() > 0) filteredOutMidiDevices.add(midiDevice);
            if (midiDevice.getInputPortCount() > 0) filteredInMidiDevices.add(midiDevice);
        }
        int count = midiManager.getDevices().length;
        String msg = "total device="+ count +",input="+filteredInMidiDevices.size()+",output="+filteredOutMidiDevices.size();
        showToast(msg);


        if(filteredOutMidiDevices.size() <=0 ){
            return;
        }

        final MidiDeviceInfo outputDevice = (MidiDeviceInfo)filteredOutMidiDevices.get(0);
        MidiDeviceInfo inputDevice = (MidiDeviceInfo)filteredInMidiDevices.get(0);

        midiManager.openDevice(inputDevice, new MidiManager.OnDeviceOpenedListener() {
            @Override
            public void onDeviceOpened(MidiDevice device) {
                showToast("open input device");
                inputPort = device.openInputPort(0);

            }
        },mCheckHandler);

        midiManager.openDevice(outputDevice, new MidiManager.OnDeviceOpenedListener() {
            @Override
            public void onDeviceOpened(MidiDevice device) {
                showToast("open output device");
                outputPort = device.openOutputPort(0);
                outputPort.connect(noteReceiver);
            }
        },mCheckHandler);
    }
    class MyReceiver extends MidiReceiver {
        public void onSend(byte[] data, int offset,
                           int count, long timestamp) throws IOException {
            try {
                if (data == null) {
                    return;
                }
                String value = String.format("_%d_%d",data[offset],data[offset+1]);
                final String note = "offset_" + offset + "_count_" + count+value;
                mCheckHandler.post(new Runnable() {
                    @Override
                    public void run() {
//                        Toast.makeText(MainActivity.this, note, Toast.LENGTH_SHORT).show();
                        try {
                            callJavaScript(mWebView, "nativeCallJS", note);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });

            }catch (Exception e){
                e.printStackTrace();
            }

            /*
            if(data == null){
                return;
            }
            int size = data.length;
            if(size >= 2) {
                StringBuffer sp = new StringBuffer();
                sp.append("[");
                for (int i = 0; i < 2; i++) {
                    String value = String.format("%0x ", data[i]);
                    sp.append(value);
                }
                sp.append("],");
                String extra = "offset=" + offset + ",count=" + count+",size="+size;
                sp.append(extra);
                callJavaScript(mWebView, "nativeCallJS", sp.toString());
            }*/
        }
    }

    private  void sendMidi(){
        byte[] buffer = new byte[32];
        int numBytes = 0;
        int channel = 3; // MIDI channels 1-16 are encoded as 0-15.
        buffer[numBytes++] = (byte)(0x90 + (channel - 1)); // note on
        buffer[numBytes++] = (byte)60; // pitch is middle C
        buffer[numBytes++] = (byte)127; // max velocity
        int offset = 0;
        try {
            inputPort.send(buffer, offset, numBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void playMidi(final MidiInputPort inputPort) throws FileNotFoundException {
        String music = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath();
        File input = new File("/mnt/sdcard/test.mid");
        try {
            MidiFile midi = new MidiFile(input);
            MidiProcessor processor = new MidiProcessor(midi);
            processor.registerEventListener(new MidiEventListener() {
                @Override
                public void onStart(boolean fromBeginning) {
                    showToast("start");
                }

                @Override
                public void onEvent(MidiEvent event, long ms) {
                    if (event.getClass() == NoteOn.class) {
                        NoteOn noteOn = ((NoteOn) event);
                        try {
                            ShortMessage msg = new ShortMessage();
                            msg.setMessage(ShortMessage.NOTE_ON, 1, noteOn.getNoteValue(), noteOn.getVelocity());
                            int len = msg.getLength();
                            byte[] bytes = msg.getMessage();
                            int offset = 0;
                            inputPort.send(bytes, offset, len);
                        } catch (InvalidMidiDataException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else if (event.getClass() == NoteOff.class) {
                        NoteOff noteOff = ((NoteOff) event);
                        try {
                            ShortMessage msg = new ShortMessage();
                            msg.setMessage(ShortMessage.NOTE_ON, 1, noteOff.getNoteValue(), noteOff.getVelocity());
                            int len = msg.getLength();
                            byte[] bytes = msg.getMessage();
                            int offset = 0;
                            inputPort.send(bytes, offset, len);
                        } catch (InvalidMidiDataException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onStop(boolean finished) {
                }
            }, MidiEvent.class);


            processor.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }


    private class CheckHandler extends Handler {
        public static final int MSG_MONITOR = 0x001;

        CheckHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case MSG_MONITOR:

                    break;
            }
            super.handleMessage(msg);
        }
    }

    public class MyJSInterface {
        Context mContext;
        MyJSInterface(Context c) {
            mContext = c;
        }
        @JavascriptInterface
        public void callNative(String cmd) {
            //todo
            if("open_midi_device".equals(cmd)){
                checkMidiDevice();
            }else if("send_midi_note".equals(cmd)){
                sendMidi();
            }
        }
    }

    private void showToast(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void callJavaScript(WebView view, String methodName, Object...params){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:try{");
        stringBuilder.append(methodName);
        stringBuilder.append("(");
        String separator = "";
        for (Object param : params) {
            stringBuilder.append(separator);
            separator = ",";
            if(param instanceof String){
                stringBuilder.append("'");
            }
            stringBuilder.append(param.toString().replace("'", "\\'"));
            if(param instanceof String){
                stringBuilder.append("'");
            }

        }
        stringBuilder.append(")}catch(error){console.error(error.message);}");
        final String call = stringBuilder.toString();

        view.loadUrl(call);
    }

    class CustomWebChromeClient extends WebChromeClient {
        private static final String TAG = "CustomWebChromeClient";

        @Override
        public boolean onConsoleMessage(ConsoleMessage cm) {
            Log.d(TAG, String.format("%s @ %d: %s", cm.message(),
                    cm.lineNumber(), cm.sourceId()));
            return true;
        }
    }


}
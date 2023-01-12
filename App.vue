<script>
	// import {getInfo} from '@/lib/common.js'
	export default {
		// onLaunch: function() {
		// 	const socket = uni.connectSocket({
		// 		url: 'ws://testmusic.thedream.tech:2348/wss',
		// 			success:res=>{
		// 		},
		// 		fail:res=>{},
		// 		complete:res=>{}
		// 	});
		// 	this.ifwifi()
		// 	//加载搜索关键词
		// 	this.Hotkeyword()
		// 	//获取内存信息
		// 	this.getmemory()
		// 	//查看用户缓存
		// 	let user = uni.getStorageSync('user')
		// 	if (user) {
		// 		this.globalData.loginsuccess = true
		// 		this.globalData.logindata = user
		// 	}
		// 	//打开
		// 	uni.onSocketOpen(function (res) {
		// 		// console.log('WebSocket连接已打开！');
		// 	});
		// 	//收到消息
		// 	socket.onMessage(function(res){
		// 		let data = JSON.parse(res.data)
		// 		let mac = getInfo('mac')
		// 		switch (data.type){
		// 			case 'init': //初始化成功，绑定设备
		// 				uni.sendSocketMessage({
		// 					data:JSON.stringify({
		// 						type:'bind',
		// 						mac:mac,
		// 					})
		// 				})
		// 				break;
		// 			case 'bind': //绑定成功，定时发送心跳
		// 				setInterval(() => {
		// 					uni.sendSocketMessage({
		// 						data:JSON.stringify({
		// 							type:'ping',
		// 						})
		// 					})
		// 				}, 50000);
		// 				break;
		// 			case 'login': //登录成功
		// 				getApp().globalData.loginsuccess = true
		// 				getApp().globalData.logindata = data.data
		// 				uni.setStorageSync('user',data.data)
		// 				//判断是否有打开登录页，如果有打开，则返回上一页
		// 				if (getApp().globalData.loginPageOpen) {
		// 					uni.navigateBack({})
		// 				}
		// 				break;
		// 			default:
		// 				break;
		// 		}
				
		// 	}) 
		// 	// 异常，Socket重连或做其它操作
		// 	uni.onSocketError(function (res) {
		// 		console.log('WebSocket连接打开失败，请检查！')
		// 	});
		// 	this.globalData.launch = true
		// },
		onShow: function() {
			// console.log('App Show')
		},
		onHide: function() {
			// console.log('App Hide')
		},
		//全局配置
		globalData: {
			launch:false,
			animationType:'fade-in',//页面切换动画效果
			animationDuration:300,  //页面切换动画时间
			logindata:[], //登录数据
			loginsuccess:false, //登录成功
			loginPageOpen:false ,//是否打开登录页面
			hotkey:'',//搜索关键词列表
			memoryInfo:'',//当前内存
			internalMemSize:'',//总内存
			osVersion:'',//版本
			cpuCount:'',//运行内存
			ramSize:'',//总运行内存
		},
		methods:{
			ifwifi(){
				let network=''
				uni.getNetworkType({
					success: (res) => {
						console.log(res.networkType);
						if(res.networkType === "none"){
						    console.log("当前无网络");
							network="当前无网络"
						}else{
						    console.log("有网络");
							network="有网络"
						}
						uni.setStorage({
							key:"network",
							data:network
						})
					}
				})
			},
			//热门关键词
			Hotkeyword(){
				this.$request({
					url: this.$baseUrl + "/piano/index/hotKeyword.html",
					method: "POST",
				}).then((res) => {
					getApp().globalData.hotkey=res.data.data
					let hotkey=res.data.data[parseInt(Math.random() * (res.data.data.length+1))]
					console.log(hotkey);
					uni.setStorageSync('hotkey',hotkey)
				})
			},
			//获取手机内存和总内存
			getmemory(){
				//手机内存信息
				var memoryInfo = '';  
				if (plus.os.name == "Android") {  
				    var Context = plus.android.importClass("android.content.Context");  
				    var ActivityManager = plus.android.importClass("android.app.ActivityManager");  
				var mi = new ActivityManager.MemoryInfo();  
				var activityService = plus.android.runtimeMainActivity().getSystemService(Context.ACTIVITY_SERVICE);  
			   activityService.getMemoryInfo(mi);  
				  memoryInfo = mi.plusGetAttribute("availMem");  
				console.log(Math.floor(memoryInfo/1024/1024/1024));
				getApp().globalData.memoryInfo=Math.floor(memoryInfo/1024/1024/1024)
				//手机总内存信息
				var environment = plus.android.importClass("android.os.Environment");  
				var statFs = plus.android.importClass("android.os.StatFs");  
				var files = plus.android.importClass("java.io.File");  
				var Files = environment.getDataDirectory();  
				var StatFs = new statFs(Files.getPath());  
				var blockSize = parseFloat(StatFs.getBlockSize());  
				var blockCount = parseFloat(StatFs.getBlockCount());  
				var internalMemSize = blockSize * blockCount; 
				console.log(Math.floor(internalMemSize/1024/1024/1024));
				getApp().globalData.internalMemSize=Math.floor(internalMemSize/1024/1024/1024)
				//运行内存
				var Runtime = plus.android.importClass("java.lang.Runtime");  
				var cpuCount = Runtime.getRuntime().availableProcessors();
				console.log(cpuCount);
				getApp().globalData.cpuCount=cpuCount
				//总运行内存
				var memInfo = '/proc/meminfo';  
				    var temp = '',  
				        ramSize = '',  
				        arrays, initMemory;  
				    var fileReader = plus.android.importClass("java.io.FileReader");  
				    var bufferedReader = plus.android.importClass("java.io.BufferedReader");  
				    var FileReader = new fileReader(memInfo);  
				    var BufferedReader = new bufferedReader(FileReader, 8192);  
				    while ((temp = BufferedReader.readLine()) != null) {  
				        if (-1 != temp.indexOf('MemTotal:')) {  
				            var value = temp.replace(/[^0-9]/ig, "");  
				            ramSize = Math.floor(parseInt(value) / (1024)/ (1024));
				        }  
				    }
					 getApp().globalData.ramSize=ramSize
				//版本
				uni.getSystemInfo({
					success: (res) => {
						console.log(res.osVersion);
						getApp().globalData.osVersion=res.osVersion
					}
				})
				
			 }
			},
		}
	}
</script>

<style>
	/*每个页面公共css */
	page{
		width:100%;
		height:100%;
		overflow: hidden;
		color:#fff;
		font-size:14px;
	}
	ul{
		padding:0;
	}
	ul li{
		list-style: none;
	}
	#app{
		width:100%;
		height:100%;
	}
	uni-page-head{
		display: none;
	}
	.uni-page-head{
		display: none;
	}
	.content{
		width:2106px;
		height:auto;
		margin:0 auto;
	}
	.clearfix:after {
		visibility: hidden;
		display: block;
		font-size: 0;
		content: " ";
		clear: both;
		height: 0;
	}
	.clearfix{
		/* *zoom:1; */
	}
	/* MODEL窗口 */
/* 	.uni-modal{
		background-color: rgba(67,109,192);
		border: #079fff solid 3px;
		width: 100%;
		max-width: 500px;
		box-shadow: 0px 0px 20px 4px #079fff;
	}
	.uni-modal__hd{
		color:#fff;
		border-bottom: 1px solid rgb(255,255,255,0.5);
		padding:1em 1.6em;
	}
	.uni-modal__hd .uni-modal__title{
		font-size:24px;
	}
	.uni-modal__bd{
		font-size:20px;
		color:#fff;
	}
	.uni-modal__ft{
		margin:20px 10% 30px;
	}
	.uni-modal__ft:after{
		border-top:none;
	}
	.uni-modal__btn{
		border:1px #fff solid;
		width:48%;
		margin:0 1%;
	}
	.uni-modal__btn:after{
		border-left:none;
	}
	.uni-modal__btn_default{
		background-color: #fff;
		border-radius: 50px;
	}
	.uni-modal__btn_primary{
		background-color: #0077F1;
		color:#fff !important;
		border-radius: 50px;
	} */
	/* TOAST窗口 */
/* 	.uni-toast{
		width:auto;
		min-width:200px;
		background-color: rgba(67,109,192,0.85);
		padding:0 10px;
	}
	.uni-toast__content{
		font-size:20px;
		display: inline-block;
		position: relative;
		top: -10px;
		padding-left: 10px;
	}
	.uni-simple-toast__text{
		font-size:20px;
		padding:15px 20px;
		background-color: rgba(67,109,192,0.85);
	} */
</style>

<template>
	<view class="details">
		<!-- 直播检测提示页面 -->
		<view class="bg" v-show="remind_show">
			<view class="remind">
				<view class="x" @click="goToLive"><image src="@/static/details_remind_x.png" mode=""></image></view>
				<view class="re_row">
					<image v-show="ishttps_show" src="@/static/details_remind_yes.png" mode=""></image>
					<image v-show="nohttps_show" src="@/static/details_remind_no.png" mode=""></image>
					<view class="re_text">是否开启Https证书访问</view>
				</view>
				<view class="re_row">
					<image v-show="isdevice_show" src="@/static/details_remind_yes.png" mode=""></image>
					<image v-show="nodevice_show" src="@/static/details_remind_no.png" mode=""></image>
					<view class="re_text">是否有摄像头/麦克风</view>
				</view> 
				<view class="re_row">
					<image v-show="islive_show" src="@/static/details_remind_yes.png" mode=""></image>
					<image v-show="nolive_show" src="@/static/details_remind_no.png" mode=""></image>
					<view class="re_text">是否有直播权限</view>
				</view>
				<view class="re_row">
					<image v-show="istalk_show" src="@/static/details_remind_yes.png" mode=""></image>
					<image v-show="notalk_show" src="@/static/details_remind_no.png" mode=""></image>
					<view class="re_text">是否有在线聊天功能</view>
				</view>
				<view class="re_row">
					<image v-show="ischrome_show" src="@/static/details_remind_yes.png" mode=""></image>
					<image v-show="nochrome_show" src="@/static/details_remind_no.png" mode=""></image>
					<view class="re_text">浏览器支持（推荐使用新版谷歌浏览器）</view>
				</view>
				<view class="re_btn" @click="goToLive">进入直播间</view>
			</view>
		</view>

		<!-- 课程详情主页 -->
		<view class="content" v-show="details_show" :class="{ content_bg: remind_show == true }">
			<!-- 学员列表 -->
			<view class="left">
				<view class="l_title">逐梦音乐互动课堂</view>
				<view class="line"></view>
				<view class="l_bottom">
					<view class="l_text">
						<view class="text1">学员列表({{ onlineStudents }}/{{ student.length }})</view>
						<!-- <image src="@/static/details_refresh.png" mode=""></image> -->
					</view>
					<scroll-view scroll-y="true">
						<!-- 学员列表 -->
						<view class="list" v-for="(item, index) in student" :key="index">
							<!-- 头像 -->
							<view class="head" :class="{ lose_img: item.status == 0 }"><image :src="item.u_headimg" mode=""></image></view>
							<!-- 姓名 -->
							<view class="text2">{{ item.u_name }}</view> 
							<!-- 图标 -->
							<view class="icons">
								<!-- <image v-show="item.icon_5 == 0 || !item.icon_5" src="@/static/details_listicon5_no.png" mode=""></image> -->
								<!-- <image v-show="item.icon_5 == 1" src="@/static/details_listicon5.png" mode=""></image> -->
								<!-- <image v-show="item.icon_4 == 0 || !item.icon_4" src="@/static/details_listicon4_no.png" mode=""></image> -->
								<!-- <image v-show="item.icon_4 == 1" src="@/static/details_listicon4.png" mode=""></image> -->
								<image v-show="item.icon_3 == 0 || !item.icon_3" src="@/static/details_listicon3_no.png" mode="" @click="icon_3(item)"></image>
								<image v-show="item.icon_3 == 1" src="@/static/details_listicon3.png" mode="" @click="icon_3(item)"></image>
								<image v-show="item.icon_2 == 0 || !item.icon_2" src="@/static/details_listicon2_no.png" mode="" @click="icon_2(item)"></image>
								<image v-show="item.icon_2 == 1" src="@/static/details_listicon2.png" mode="" @click="icon_2(item)"></image>
								<image v-show="item.icon_1 == 0 || !item.icon_1" src="@/static/details_listicon1_no.png" mode="" @click="icon_1(item)"></image>
								<image v-show="item.icon_1 == 1" src="@/static/details_listicon.png" mode="" @click="icon_1(item.u_id)"></image>
							</view>
							<!-- 提示信息 -->
							<view class="text3">{{ item.receiveMsg }}</view>
						</view>
					</scroll-view>
				</view>
			</view>

			<!-- 顶部 --> 
			<view class="top" v-if="info">
				<view class="head"><image :src="info.u_headimg" mode=""></image></view>
				<view class="text4">
					<view class="onerow">
						<view>老师：{{ info.u_name }}</view>
						<view>时间：{{ info.s_starttime }}-{{ info.s_endtime }}</view>
					</view>
					<view class="tworow">
						<view>班级：{{ info.g_name }}</view>
						<view>人数：{{ student.length }}人</view>
					</view>
				</view>
				<view class="status">
					<!-- 视频 -->
					<image class="video" src="@/static/details_icon_video.png" mode=""></image>
					<view class="text6">视频</view>
					<image v-show="video == 0" src="@/static/details_icon_off.png" mode="" @click="video_ctrl"></image>
					<image v-show="video == 1" src="@/static/details_icon_on.png" mode="" @click="video_ctrl"></image>
					<!-- 视频全屏显示 -->
					<image src="@/static/details_icon_full.png" v-show="video_size==0" @click="sizeCtrl"></image>
					<image src="@/static/details_icon_small.png" v-show="video_size==1" @click="sizeCtrl"></image>
					<image class="speak" src="@/static/details_icon_speak.png" mode=""></image>
					<!-- 聊天 -->
					<view class="text6">聊天</view>
					<image v-show="speak == 0" src="@/static/details_icon_off.png" mode="" @click="speak_ctrl"></image>
					<image v-show="speak == 1" src="@/static/details_icon_on.png" mode="" @click="speak_ctrl"></image>
				</view>
				<view class="ctrl">
					<!-- 返回按钮 -->
					<image src="@/static/details_return.png" mode="" @click="goback"></image>
					<!-- 开始直播按钮 -->
					<image src="@/static/details_startlive.png" @click="startLive()" v-show="liveVideo == false"></image>
					<!-- 关闭直播按钮 -->
					<image src="@/static/details_closelive.png" @click="endLive()" v-show="liveVideo == true"></image>
					<!-- 开始上课按钮 -->
					<image src="@/static/details_startclass.png" v-show="startclass_show" @click="startClass"></image>
					<!-- 结束上课按钮 -->
					<image src="@/static/details_overclass.png" v-show="overclass_show" @click="goback"></image>
				</view>
				<view class="line"></view>
			</view>

			<!-- 中间部分 -->
			<view class="middle">
				<view class="card" v-for="(item, index) in card" :key="index" :class="{ card_bg1: index == 0, card_bg2: index == 1, card_bg3: index == 2, card_bg4: index == 3 }">
					<image :src="item.url" mode=""></image>
					<view class="text7">{{ item.title }}</view>
					<view class="text8">{{ item.num }}</view>
				</view>
			</view>

			<!-- 课程选择 -->
			<view class="choose">
				<view class="title">
					<image src="@/static/details_icon5.png" mode=""></image>
					<view class="text9">课件选择</view>
				</view>
				<!-- 课本数据 -->
				<view class="select">
					<input type="text" placeholder="请选择课本" v-model="book" :class="{selectClass: selectIcon1 == 0}" @click="selectShow1" />
					<image class="selectIcon" v-if="selectIcon1 == 1" src="../../static/details_down.png" mode="" @click="selectShow1"></image>
					<image class="selectIcon" v-if="selectIcon1 == 0" src="../../static/details_up.png" mode="" @click="selectShow1"></image>
					<view class="selectContent" v-show="selectIcon1 == 0"> 
						<scroll-view class="selectScroll" scroll-y="true" >
							<view class="selectList" v-for="(item,index) in textbook" :key="index" @click="getPeriod(item.c_name, item.c_id)">
							    <view class="stlectText" >{{ item.c_name }}</view>
							</view>
						</scroll-view>
					</view>
				</view>  
				<!-- 课时数据 -->
				<view class="select">
					<input type="text" placeholder="请选择课时" v-model="periods" :class="{selectClass: selectIcon2 == 0}" @click="selectShow2" />
					<image class="selectIcon" v-if="selectIcon2 == 1" src="../../static/details_down.png" mode="" @click="selectShow2"></image>
					<image class="selectIcon" v-if="selectIcon2 == 0" src="../../static/details_up.png" mode="" @click="selectShow2"></image>
					<view class="selectContent" v-show="selectIcon2 == 0"> 
						<scroll-view class="selectScroll" scroll-y="true" >
							<view class="selectList" v-for="(item,index) in period" :key="index" @click="getcourseware(item.c_name, item.c_id)">
							    <view class="stlectText" >{{ item.c_name }}</view>
							</view>
						</scroll-view>
					</view>
				</view>  
				<!-- 课件数据 -->
				<view class="content">
					<scroll-view scroll-y="true">
						<view class="list" v-for="(item, index) in courseware" :key="index" @click="chooseCus(item)">
							<image v-if="item.cw_type==1" src="../../static/details_chooseicon2.png" mode=""></image>
							<image v-if="item.cw_type==2" src="../../static/details_chooseicon1.png" mode=""></image>
							<image v-if="item.cw_type==3" src="../../static/details_chooseicon3.png" mode=""></image>
							<view class="name">{{ item.cw_name }}</view>
						</view>
					</scroll-view>
				</view>
			</view>
 
			<!-- 底部 -->
			<view class="bottom">
				<view class="bottom_left">
					<!-- <view class="left1">用时：00:00:00</view> -->
					<view class="left2">课件：{{ course.cw_name }}</view>
					<!-- <view class="left3">
						<view class="text10">模式：</view>
						<image src="@/static/details_radioopen.png" mode="" v-show="model1_open" @click="choosemodel1"></image>
						<view class="checknot" v-show="model1_close" @click="choosemodel1"></view>
						<view class="text10">跟弹</view>
						<image src="@/static/details_radioopen.png" mode="" v-show="model2_open" @click="choosemodel2"></image>
						<view class="checknot" v-show="model2_close" @click="choosemodel2"></view>
						<view class="text10">卡住</view>
					</view>
					<view class="left4" >
						<view class="text10">速度：</view>
						<input type="number" placeholder="100" />
						<view class="font">速度范围30-200，表示设置为原课件速度的百分比</view>
						<view class="font">速度范围30-200</view>
					</view> -->
				</view>
				<!-- <view class="bottom_right">
					<view class="right1">
						<view class="text10">节拍器：</view>
						<image src="@/static/details_radioopen.png" mode="" @click="chooserhythm1" v-show="rhythm1_open"></image>
						<view class="checknot" @click="chooserhythm1" v-show="rhythm1_close"></view>
						<view class="text10">打开</view>
						<image src="@/static/details_radioopen.png" mode="" @click="chooserhythm2" v-show="rhythm2_open"></image>
						<view class="checknot" @click="chooserhythm2" v-show="rhythm2_close"></view>
						<view class="text10">关闭</view>
					</view>
					<view class="right2">
						<view class="text10">左右手：</view>
						<image src="@/static/details_radioopen.png" v-show="hand1_open" mode="" @click="choosehand1"></image>
						<view class="checknot" v-show="hand1_close" @click="choosehand1"></view>
						<view class="text10">双手</view>
						<image src="@/static/details_radioopen.png" v-show="hand2_open" @click="choosehand2" mode=""></image>
						<view class="checknot" v-show="hand2_close" @click="choosehand2"></view>
						<view class="text10">左手</view>
						<image src="@/static/details_radioopen.png" v-show="hand3_open" @click="choosehand3" mode=""></image>
						<view class="checknot" v-show="hand3_close" @click="choosehand3"></view>
						<view class="text10">右手</view>
					</view>
				</view> -->
				<view class="btn1" @click="sendCus">
					<image src="@/static/details_px.png" mode=""></image>
					<view class="btn_text">发送</view>
				</view>
				<view class="btn2" @click="play">
					<image src="@/static/details_px.png" mode=""></image>
					<view class="btn_text">播放</view>
				</view>
				<view class="btn3" @click="pause">
					<image src="@/static/details_px.png" mode=""></image>
					<view class="btn_text">暂停</view>
				</view>
			</view>

			<!-- 直播 -->
			<view class="live">
				<!-- 直播画面 -->
				<view class="frame" name="live" id="live"></view>
				<!-- 直播信息 -->
				<image class="imgIcon" src="@/static/details_liveicon.png" mode="" v-show="liveicon_show"></image>
				<view class="frame_text" v-show="liveicon_show">NO SIGNAL</view>
				<view class="class_time">上课时间：{{ liveHour }}:{{ liveMin }}:{{ liveSec }}</view>
				<uni-section type="line" v-show="load_show">
				</uni-section>
				<!-- 直播功能切换 -->
				<view class="select">
					<!-- <input type="text" placeholder="切换摄像头" v-model="chromes" :class="{selectClass: selectIcon3 == 0}" @click="selectShow3" /> -->
					<image class="selectIcon" v-if="selectIcon3 == 1" src="../../static/details_down.png" mode="" @click="selectShow3"></image>
					<image class="selectIcon" v-if="selectIcon3 == 0" src="../../static/details_up.png" mode="" @click="selectShow3"></image>
					<view class="selectContent" v-show="selectIcon3 == 0">
						<scroll-view class="selectScroll" scroll-y="true" >
							<view class="selectList" v-for="(item,index) in chromeType" :key="index" @click="changeChrome(item.title)">
							    <view class="stlectText" >{{ item.title }}</view>
							</view>
						</scroll-view>
					</view> 
				</view> 
			</view> 

			<!-- 聊天 -->
			<view class="talk">
				<!-- 左边消息记录 -->
				<view class="talk_left">
					<view class="title"><image src="@/static/details_talktitle.png" mode=""></image></view>
					<scroll-view scroll-y="true" :scroll-top="scrollTop" class="scroll-Y" scroll-with-animation="true" show-scrollbar="false">
						<!-- 学员消息 -->
						<!-- <view class="talk_history" v-for="(item, index) in talk" :key="index">
							<view class="his_info">
								<view class="name">{{ item.name }}</view>
								<view class="his_time">{{ item.time }}</view>
							</view>
							<view class="talk_text">{{ item.message }}</view>
						</view> -->
						<!-- 我的消息 -->
						<view class="my_text" v-for="(item, index) in talk" :key="index">
							<view class="myinfo">
								<view class="myname" :class="{hisname: item.name != info.u_name}">{{ item.name }}</view>
								<view class="mytime" :class="{histime: item.name != info.u_name}">{{ item.time }}</view>
							</view>  
							<view class="mytext" :class="{histext: item.name != info.u_name}">{{ item.message }}</view>
						</view>
					</scroll-view>
				</view>
				<!-- 右边输入框 -->
				<view class="talk_right">
					<textarea name="" id="" placeholder="请输入消息" v-model="message" maxlength="34"></textarea>
					<!-- 发送按钮 -->
					<view class="btn1" @click="my_msg(mytalk)">
						<image src="@/static/details_px.png" mode=""></image>
						<view class="btn_text">发送</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>


<script>
//声网互动直播
import AgoraRTC from 'agora-rtc-sdk-ng';
//声网云信令
import AgoraRTM from 'agora-rtm-sdk'; 
export default {
	data() {
		return {
			localPlayerContainer: {},
			//直播计时器
			liveHour: '00',
			liveMin: '00',
			liveSec: '00',
			// RTC
			rtc: {
				localAudioTrack: null,
				localVideoTrack: null,
				client: null
			},
			// 直播Appid,token,channel,chattoken,uid等参数
			options: {},
			// 聊天频道对象
			chatChannel: null,
			chatClient: null,
			// 直播状态，true表示开，false表示关
			liveVideo: false,
			// 视频窗口状态，full表示全屏，small表示小窗口
			videoScreen: 'full',
			// 聊天状态，true表示开，false表示关
			chat: false,
			// 老师信息
			info: [], 
			selectIcon1: 1,
			selectIcon2: 1,
			selectIcon3: 1,
			// 课本数据
			book:'',
			textbook: [],
			// 课时数据
			period: [],
			periods:'',
			// 切换摄像头
			chromeType:[{title:'摄像头A'}, {title:'摄像头B'}, {title:'摄像头C'}],
			chromes:'',
			// 课程id
			course_id: '',
			// 直播检测
			https: '',
			hasWebcam: '',
			hasMicrophone:'',
			chrome: '',
			// 课程检测状态码
			code: '',
			scrollTop: '500',
			// 输入框输入的信息
			message: '',
			// 全部聊天内容
			talk: [],
			// 我的聊天信息
			mytalk: [],
			// 收到的消息
			mes:{},
			// 当前时间
			time: '',
			// 主页切换显示
			remind_show: true,
			details_show: true,
			// 顶部按钮切换显示
			overclass_show: false,
			startclass_show: true,
			// 直播检测图标切换显示
			nohttps_show: true,
			nodevice_show: true,
			nolive_show: true,
			notalk_show: true,
			nochrome_show: true,
			ishttps_show: false,
			isdevice_show: false,
			islive_show: false,
			istalk_show: false,
			ischrome_show: false,
			liveicon_show: true,
		    //直播前加载显示 
			load_show: false,
			// 页面底部控制面板
			model1_open: true,
			model1_close: false,
			model2_open: false,
			model2_close: true,
			rhythm1_open: true,
			rhythm1_close: false,
			rhythm2_open: false,
			rhythm2_close: true,
			hand1_open: true,
			hand1_close: false,
			hand2_open: false,
			hand2_close: true,
			hand3_open: false,
			hand3_close: true,
			// 视频及聊天开关
			video: 0,
			speak: 0,
			// 视频尺寸
			video_size: 1,
			// 学员列表
			student: [],
			// 上线学员数量
			onlineStudents: 0,
			// 上线学员Id
			memberId_1: '',
			// 下线学员Id
			memberId_2: '',			
			card: [
				{ url: '../../static/details_top_icon1.png', title: '完成人数', num: 0 },
				{ url: '../../static/details_top_icon2.png', title: '平均得分', num: 0 },
				{ url: '../../static/details_top_icon3.png', title: '最高得分', num: 0 },
				{ url: '../../static/details_top_icon4.png', title: '最低得分', num: 0 },
			],
			// 课程选择列表
			courseware: [],
			// 课时id
			cid1: null,
			cid2: null,
			// 选择的课件
			course: [],
			// 老师接收到的消息
			receiveMsg:'',
			// 老师id
			teacherId: '' ,//t+id
		};
	},
	onLoad(option) {
		this.course_id = option.id;
		console.log(option);
		this.is_https();
		this.is_chrome();
		this.isdevice();
		this.checkIcon();
		this.getdata();
		this.getTime();
		console.log(1.51.toFixed(0))
	},
	methods: {
		// 选择课本获取课时
		getPeriod(c_name, cid1){
			this.$request({
				url: this.$baseUrl + '/liveteacher/live/period.html',
				method: 'POST',
				data: {
					c_id: cid1,
				}
			}).then(res=>{
				console.log(res);
				this.periods = '';
				this.courseware = [];
				this.book = c_name;
				this.selectIcon1 = 1;
				this.period = res.data.data;
				if(this.period.length == 0){
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '该课本无可选课时',
					})
				}
				
			})
		},
		// 选择课时获取课件
		getcourseware(c_name, cid2){
			this.$request({
				url: this.$baseUrl + '/liveteacher/live/content.html',
				method: 'POST',
				data: {
					c_id: cid2,
				}
			}).then(res=>{
				console.log(res);
				this.periods = c_name;
				this.selectIcon2 = 1;
				this.courseware = res.data.data;
				if(this.courseware.length == 0){
					uni.showModal({
						title: '提示',
						showCancel: false,
						content: '该课时无可选课件',
					})
				}
			})
		},
		// 选择课件
		chooseCus(item){
			this.course = item;
		},
		// 检测本地设备信息
		// 1.是否开启Https证书访问
		is_https() {
			console.log(location.protocol);
			if (location.protocol == 'https') {
				this.https = true;
			} else {
				this.https = false;
			}
			// console.log(this.https);
		},
		// 2.判断是否有摄像头/麦克风
		isdevice() {
			// 校验浏览器是否支持摄像头及麦克风
			navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.msGetUserMedia;
			if (navigator.getUserMedia) {
				console.log('支持调取摄像头麦克风');
				// 如果支持，检测电脑设备是否已经安装了摄像头
				if (navigator.mediaDevices && navigator.mediaDevices.enumerateDevices) {
					navigator.enumerateDevices = function(callback) {
						navigator.mediaDevices.enumerateDevices().then(callback);
					};
				}
				var MediaDevices = [];
				var isHTTPs = location.protocol === 'https:';
				var canEnumerate = false;
				if (typeof MediaStreamTrack !== 'undefined' && 'getSources' in MediaStreamTrack) {
					canEnumerate = true;
				} else if (navigator.mediaDevices && !!navigator.mediaDevices.enumerateDevices) {
					canEnumerate = true;
				}
				var hasMicrophone = false;
				var hasSpeakers = false;
				var hasWebcam = false;
				var isMicrophoneAlreadyCaptured = false;
				var isWebcamAlreadyCaptured = false;
				function checkDeviceSupport(callback) {
					if (!canEnumerate) {
						return;
					}
					if (!navigator.enumerateDevices && window.MediaStreamTrack && window.MediaStreamTrack.getSources) {
						navigator.enumerateDevices = window.MediaStreamTrack.getSources.bind(window.MediaStreamTrack);
					}
					if (!navigator.enumerateDevices && navigator.enumerateDevices) {
						navigator.enumerateDevices = navigator.enumerateDevices.bind(navigator);
					}
					if (!navigator.enumerateDevices) {
						if (callback) {
							callback();
						}
						return;
					}
					MediaDevices = [];
					navigator.enumerateDevices(function(devices) {
						devices.forEach(function(_device) {
							var device = {};
							for (var d in _device) {
								device[d] = _device[d];
							}
							if (device.kind === 'audio') {
								device.kind = 'audioinput';
							}
							if (device.kind === 'video') {
								device.kind = 'videoinput';
							}
							var skip;
							MediaDevices.forEach(function(d) {
								if (d.id === device.id && d.kind === device.kind) {
									skip = true;
								}
							});
							if (skip) {
								return;
							}
							if (!device.deviceId) {
								device.deviceId = device.id;
							}
							if (!device.id) {
								device.id = device.deviceId;
							}
							if (!device.label) {
								device.label = 'Please invoke getUserMedia once.';
								if (!isHTTPs) {
									device.label = 'HTTPs is required to get label of this ' + device.kind + ' device.';
								}
							} else {
								if (device.kind === 'videoinput' && !isWebcamAlreadyCaptured) {
									isWebcamAlreadyCaptured = true;
								}
				
								if (device.kind === 'audioinput' && !isMicrophoneAlreadyCaptured) {
									isMicrophoneAlreadyCaptured = true;
								}
							}
							if (device.kind === 'audioinput') {
								hasMicrophone = true;
							}
							if (device.kind === 'audiooutput') {
								hasSpeakers = true;
							}
							if (device.kind === 'videoinput') {
								hasWebcam = true;
							}
							MediaDevices.push(device);
						});
						if (callback) {
							callback();
						}
					});
				}
				checkDeviceSupport(res => {
					if (hasWebcam == false) {
						console.log('没有摄像头！');
						this.hasWebcam = false;
					} else if (hasWebcam == true) {
						console.log('有摄像头！');
						this.hasWebcam = true;
					} else {
						if (isWebcamAlreadyCaptured == false) {
							console.log('捕获摄像头失败，请重新安装摄像头！');
							return false;
						}
					}
					if (hasMicrophone == false) {
						console.log('没有麦克风！');
						this.hasMicrophone = false;
					} else if (hasMicrophone == true) {
						console.log('有麦克风！');
						this.hasMicrophone = true;
					} else {
						if (isMicrophoneAlreadyCaptured == false) {
							console.log('捕获麦克风失败，请重新安装麦克风！');
							return false;
						}
					}
				});
			} else {
				console.log('抱歉不支持');
			}
		},
		// 5.当前浏览器是否为谷歌
		is_chrome() {
			if (window.navigator.userAgent.indexOf('Chrome') !== -1) {
				this.chrome = true;
			} else {
				this.chrome = false;
			}
		},
		// 检测对应图标显示 
		checkIcon(){
			var check1 = setTimeout(res=>{
				if(this.https == true){
					this.ishttps_show = true;
					this.nohttps_show = false;				
				} 
			},200)
			var check2 = setTimeout(res=>{
				if(this.hasWebcam == true && this.hasMicrophone == true){
					this.isdevice_show = true
					this.nodevice_show = false
				}
			},400)
			var check3 = setTimeout(res=>{
				this.islive_show = true
				this.nolive_show = false
			},600)
			var check4 = setTimeout(res=>{
				this.istalk_show = true
				this.notalk_show = false
			},800)
			var check5 = setTimeout(res=>{
				if(this.chrome == true){
					this.ischrome_show = true;
					this.nochrome_show = false;
				}
			},1000)		
		},	
		// 设备检测完，点击进入直播间按钮时，创建聊天房间
		async goToLive() {
			let that = this
			this.remind_show = false;
			// 初始化声网云信令
			const chatClient = AgoraRTM.createInstance(this.options.appid);
			this.chatClient = chatClient
			// 登录云信令
			await chatClient.login({ 
				uid:'t'+this.options.uid.toString(),
				token:this.options.chattoken,
			}).then(res => {
				console.log('登录成功')
			}).catch(err => {
				console.log('登录失败')
			})
			// 创建频道
			this.chatChannel = chatClient.createChannel(this.options.channel);
			// 加入频道
			await this.chatChannel.join().then(() => {
				console.log('join')
			})
			// 获取频道用户列表
			this.chatChannel.getMembers().then((res) => {
				res = res.filter(item => item != that.teacherId).map(item => parseInt(item))
				console.log(res)
				res.forEach(itema => {
					that.student.forEach(itemb => {
						if(itema == itemb.u_id){
							itemb.status = 1;
						}
					})
				})
				console.log(that.student)
				// 上线学生置顶于列表
				that.student.sort((a,b) => b.status-a.status)
				// 定义已上线学生数组，获取上线学生数量
				let arr = [];
				that.student.forEach(item => {
					if(item.status == 1){
						arr.push(item)
					}
				})
				console.log(arr)
				that.onlineStudents = arr.length;
			})
			// 云信令事件监听
			// 显示对端发送的消息
			chatClient.on('MessageFromPeer', function(message, peerId) {
				console.log('用户标识：' + peerId);
				console.log('用户消息：' + message);
				console.log(message)
				that.student.forEach(item => {
					if(item.u_id == peerId){
						item.receiveMsg = message.text
						if(message.text == '直播画面已开启'){
							item.icon_1 = 1
						}else if(message.text == '直播画面已关闭'){
							item.icon_1 = 0
						}
						if(message.text == '全屏模式'){
							item.icon_2 = 1
						}else if(message.text == '小屏模式'){
							item.icon_2 = 0
						}
						if(message.text == '聊天窗口已开启'){
							item.icon_3 = 1
						}else if(message.text == '聊天窗口已关闭'){
							item.icon_3 = 0
						}
						if((message.text.length == 2 || message.text.length == 3) && typeof(parseInt(message.text)) == 'number'){
							let mes = parseInt(message.text)
							console.log(typeof(mes))
							// 返回分数
							let arr = [81,72,63,90]
							arr.push(mes)
							// 完成人数 
							let people = []
							people.push(message.text)
							that.card[0].num = people.length
							// 取平均值
							let sum = 0, avg = 0
							arr.forEach(item => {
								sum = item + sum
								avg = sum / arr.length
								that.card[1].num = avg.toFixed(0)
							})
							// 取最大值
							let max = Math.max.apply(null,arr)
							that.card[2].num = max
							// 取最小值
							let min = Math.min.apply(null,arr)
							that.card[3].num = min
							console.log(max)
						}
					}
				})
			});
			// 频道消息
			this.chatChannel.on('ChannelMessage', function(message, memberId) {
				console.log(that.chatChannel);
				console.log('频道消息');
				console.log(memberId);
				console.log(message);
				if(message.text){
					let mes = JSON.parse(message.text)
					console.log(mes)
					that.talk = that.talk.concat({ type:mes.type, message:mes.message, time:that.time, name:mes.name})
					// 新消息置底
					that.$nextTick(() => {
						that.scrollTop = that.scrollTop + 100;
					});
				}
			});
			// 显示连接状态变化
			chatClient.on('ConnectionStateChanged', function(state, reason) {
				console.log('用户状态变化');
				console.log(state);
				console.log(reason);
			});
			// 频道成员
			this.chatChannel.on('MemberLeft', function(memberId){
				console.log(memberId);
			})
			// 频道成员加入
			this.chatChannel.on('MemberJoined', function(memberId) {
				console.log(memberId + '已上线');
				that.student.forEach(item => {
					if(item.u_id == memberId){
						item.status = 1;
					}
				})
				// 上线学生置顶于列表
				that.student.sort((a,b) => b.status-a.status)
				// 定义已上线学生数组，获取上线学生数量
				let arr = [];
				that.student.forEach(item => {
					if(item.status == 1){
						arr.push(item)
					}
				})
				console.log(arr)
				that.onlineStudents = arr.length;
			});
			// 频道成员离开
			this.chatChannel.on('MemberLeft', function(memberId) {
				console.log(memberId + '已下线');
				this.memberId_2 = memberId;
				that.student.forEach(item => {
					if(item.u_id == memberId){
						item.status = 0;
						item.receiveMsg ='';
						item.icon_1 = 0
						item.icon_2 = 0
						item.icon_3 = 0
						item.icon_4 = 0
						item.icon_5 = 0
					}
				})
				// 下线学生置底于列表
				that.student.sort((a,b) => b.status-a.status)
				// 定义已上线学生数组，获取上线学生数量
				let arr = [];
				that.student.forEach(item => {
					if(item.status == 1){
						arr.push(item)
					}
				})
				console.log(arr)
				that.onlineStudents = arr.length;
			});
		},
		// 发送点对点消息
		async sendpeerMessage(peerId, peerMessage){
			// 将消息转字符串
			peerMessage = JSON.stringify(peerMessage);
			peerId = JSON.stringify(peerId)
			console.log(peerId, peerMessage)
			await this.chatClient.sendMessageToPeer({ text: peerMessage }, peerId)
			.then(()=>{ 
				console.log('发送消息成功');
			}).catch(() => {
				console.log('发送消息失败');
			}); 
		},
		// 发送频道消息
		async sendMessage(channelMessage) {
			// channelMessage格式
			// type    类型chat表示聊天信息，其它课件信息暂待定义
			// message 消息内容
			// name    发送者名称
			// teacher 是否老师，1是，0否
			// 例：{"type":"chat","message":"你好啊",'name':"黄老师",'teacher':1};
			// 将消息转字符串
			channelMessage = JSON.stringify(channelMessage);
			await this.chatChannel.sendMessage({ text: channelMessage })
			.then(() => {	
				console.log('发送消息成功');
			}).catch(() => {
				console.log('发送消息失败');
			});
		}, 
		// 获取数据
		getdata() {
			this.$request({
				url: this.$baseUrl + '/liveteacher/live/index.html',
				method: 'POST',
				data: {
					s_id: this.course_id
				}
			}).then(res => {
				if (res.data.code == 1000) {
					console.log(res.data.data);
					// 1.获取学员信息
					this.student = res.data.data.student;
					// 给数组添加状态属性status，0表示未上线，1表示已上线
					this.student.forEach(item => item.status = 0)
					console.log(this.student)
					// 2.获取排课及老师信息
					this.info = res.data.data.info;
					console.log(this.info)
					this.teacherId = 't' + this.info.s_teacher
					// 上课结束时间
					let endTime = (this.info.s_endtime.replace(new RegExp(":", "g"), "")+'00')*1
					// console.log(endTime)
					// 当前时间
					let newTime = this.time.replace(new RegExp(":", "g"), "")*1
					// console.log(newTime)
					// 如果 上课结束时间 < 当前时间，则弹出提示框
					if(endTime < newTime){
						uni.showModal({
							title: '提示',
							showCancel: false,
							content: '已超过下课时间',
						}).then( res => {
							console.log(res)
							if (res.confirm) {
								// 用户点击确定，跳转至排课页
								uni.navigateTo({
									url: '/pages/courses/courses'
								})
								console.log('用户点击确定');
							}
						}) 
					}
					// 3.获取直播信息
					this.options = res.data.data.live;
					// 4.获取课本数据 
					this.textbook = res.data.data.textbook;
					// 5.检测摄像头，麦克风，浏览器等
				} else {
					uni.showToast({
						title: res.data.msg,
						icon: 'error'
					});
				}
			}); 
		},		
		// 开启视频直播
		async startLive() {
			this.liveicon_show = false;
			this.load_show = true;
			//初始化RTC
			this.rtc.client = AgoraRTC.createClient({ mode: 'live', codec: 'vp8' });
			//设置角色
			this.rtc.client.setClientRole('host');
			//创建直播间
			await this.rtc.client.join(this.options.appid, this.options.channel, this.options.token, this.options.uid);
			// 通过麦克风采集的音频创建一个音频轨道
			this.rtc.localAudioTrack = await AgoraRTC.createMicrophoneAudioTrack();
			// 通过摄像头采集的视频创建一个视频轨道
			this.rtc.localVideoTrack = await AgoraRTC.createCameraVideoTrack();
			// 将本地音视频轨道发布至频道中
			await this.rtc.client.publish([this.rtc.localAudioTrack, this.rtc.localVideoTrack]);
			console.log(this.rtc.localAudioTrack)
			// 创建视频窗口
			const localPlayerContainer = document.createElement('div');
			this.localPlayerContainer = localPlayerContainer
			console.log(this.localPlayerContainer);
			// localPlayerContainer.id = 'live';
			// localPlayerContainer.textContent = "Local user " + this.options.uid;
			// 设置窗口大小
			localPlayerContainer.style.width = '100%';
			localPlayerContainer.style.height = '100%';
			// 将视频窗口放到指定位置
			document.getElementById('live').append(localPlayerContainer);
			// 开始推流
			this.rtc.localVideoTrack.play(localPlayerContainer);
			// 设置视频直播状态
			this.liveVideo = true;
			console.log('直播已打开');
			// this.host()
			// this.audience()
			// this.leave()
			this.load_show = false;
		},	
		// 关闭视频直播
		async endLive() {
			this.rtc.localAudioTrack.close();
			this.rtc.localVideoTrack.close();
			// 向所有用户发送关闭直播指令，逻辑待完善
			
			// 设置视频直播状态
			this.liveVideo = false;
			// 退出直播频道
			await this.rtc.client.leave();
			document.getElementById('live').innerHTML=''
			this.liveicon_show = true;
		},
		// 上课时间计时
		startClass(){
			this.overclass_show = true;
			this.startclass_show = false;
			// 上课时间计时
			let timeStart = setInterval(() => {
				this.liveSec = this.liveSec * 1;
				if (this.liveSec < 59) {
					this.liveSec += 1;
					// 判断是否为个位数，如果是，在前面加零
					if (this.liveSec < 10) {
						this.liveSec = '0' + this.liveSec;
					} else if (this.liveSec >= 10) {
						this.liveSec = this.liveSec;
					}
				} else if (this.liveSec == 59) {
					this.liveSec = '00';
					this.liveMin = this.liveMin * 1;
					this.liveMin += 1;
					// 判断是否为个位数，如果是，在前面加零
					if (this.liveMin < 10) {
						this.liveMin = '0' + this.liveMin;
					} else if (this.liveMin >= 10) {
						this.liveMin = this.liveMin;
					}
				}
				if (this.liveMin == 60) {
					this.liveMin = '00';
					this.liveHour = this.liveHour * 1;
					this.liveHour += 1;
					// 判断是否为个位数，如果是，在前面加零
					if (this.liveHour < 10) {
						this.liveHour = '0' + this.liveHour;
					} else if (this.liveHour >= 10) {
						this.liveHour = this.liveHour;
					}
				}
			}, 1000);
		},	
		// 返回上一页（结束上课）
		async goback() {
			// 跳转至上一页
			uni.navigateTo({
				url: '/pages/courses/courses'
			});
			this.rtc.localAudioTrack.close();
			this.rtc.localVideoTrack.close();
			// 设置视频直播状态
			this.liveVideo = false;
			// 退出直播频道
			await this.rtc.client.leave();
			document.getElementById('live').innerHTML=''
			this.liveicon_show = true;
			// 关闭定时器
			if (this.liveVideo == false) {
				clearInterval(timeStart);
			}
		},
		// 获取当前本地时间
		getTime(){
			let hh = new Date().getHours() < 10 ? "0" + new Date().getHours() : new Date().getHours();
			let mf = new Date().getMinutes() < 10 ? "0" + new Date().getMinutes() : new Date().getMinutes();
			let ss = new Date().getSeconds() < 10 ? "0" + new Date().getSeconds() : new Date().getSeconds();
			this.time = hh + ':' + mf + ':' + ss
		},
		// 下拉框选择
		selectShow1(){
			if(this.selectIcon1 == 0){
				this.selectIcon1 = 1;
			}else if(this.selectIcon1 == 1){
				this.selectIcon1 = 0;
			}
		},
		selectShow2(){
			if(this.selectIcon2 == 0){
				this.selectIcon2 = 1;
			}else if(this.selectIcon2 == 1){
				this.selectIcon2 = 0;
			}
		},
		selectShow3(){
			if(this.selectIcon3 == 0){
				this.selectIcon3 = 1;
			}else if(this.selectIcon3 == 1){
				this.selectIcon3 = 0;
			}
		},
		// 切换摄像头 
		changeChrome(title){
			this.chromes = title;
			this.selectIcon3 = 1;
		},
		// 发送我的输入内容
		my_msg(mytalk) {
			if (this.message != '') {
				// 我的聊天信息
				mytalk = mytalk.concat({ type:'chat', message:this.message, time:this.time, name:this.info.u_name, teacher:1}).slice(-1);
				// 全部聊天信息
				this.talk = this.talk.concat(mytalk)
				console.log(this.talk)
				// 新消息置底
				this.$nextTick(() => {
					this.scrollTop = this.scrollTop + 100;
				});
				// 发送完输入框清空
				this.message = '';
				// 发送频道聊天消息
				let obj = {};
				obj = Object.assign({}, mytalk)
				this.sendMessage(obj[0]);
			}
		},
		
		// 发送频道消息
		// 直播画面开关
		video_ctrl() {
			if (this.video == 0) {
				this.video = 1;
				let arra = [{type:"video", message:"LiveShow", name:this.info.u_name, uid:1, teacher:1, text:""}];
				let showa = {};
				showa = Object.assign({}, arra)
				this.sendMessage(showa[0]);
			} else if (this.video == 1) {
				this.video = 0;
				let arrb = [{type:"video", message:"LiveHide", name:this.info.u_name, uid:1, teacher:1, text:""}];
				let showb = {};
				showb = Object.assign({}, arrb)
				this.sendMessage(showb[0]);
			}
		},
		// 视频全屏开关
		sizeCtrl(){
			if (this.video_size == 0) {
				this.video_size = 1;
				let arra = [{"type":"screen", "message":"Fullscreen", "name":this.info.u_name, "uid":1, "teacher":1, "text":""}];
				let showa = {};
				showa = Object.assign({}, arra)
				this.sendMessage(showa[0]);
			} else if (this.video_size == 1) {
				this.video_size = 0;
				let arrb = [{"type":"screen", "message":"Smallscreen", "name":this.info.u_name, "uid":1, "teacher":1, "text":""}];
				let showb = {};
				showb = Object.assign({}, arrb)
				this.sendMessage(showb[0]);
			}
		},
		// 聊天开关
		speak_ctrl() {
			if (this.speak == 0) {
				this.speak = 1;
				let arra = [{"type":"video", "message":"ChatShow", "name":this.info.u_name, "uid":1, "teacher":1, "text":""}];
				let showa = {};
				showa = Object.assign({}, arra)
				this.sendMessage(showa[0]);
			} else if (this.speak == 1) {
				this.speak = 0;
				let arrb = [{"type":"video", "message":"ChatHide", "name":this.info.u_name, "uid":1, "teacher":1, "text":""}];
				let showb = {};
				showb = Object.assign({}, arrb)
				this.sendMessage(showb[0]);
			}
		},
		// 发送课件
		sendCus() {
			// 若未选择课件
			if(!this.course.cw_name){
				uni.showModal({
					title: '提示',
					showCancel: false,
					content: '请选择要发送的课件',
				})
			}
			// 视频课件
			if(this.course.cw_type == 1){
				let arra = [{"type":"course", "message":1, "thumb": this.course.cw_content.thumb, "video": this.course.cw_content.video, "name":this.info.u_name, "uid":1, "teacher":1, "text":"进入课件"}];
				let showa = {};
				showa = Object.assign({}, arra)
				this.sendMessage(showa[0]);
			}
			// 曲谱课件
			else if(this.course.cw_type == 2){
				let arrb = [{"type":"course", "message":2, "xml":this.course.cw_content.xml, "pass":this.course.cw_content.pass, "name":this.info.u_name, "uid":1, "teacher":1, "text":"进入课件"}];
				let showb = {};
				showb = Object.assign({}, arrb)
				this.sendMessage(showb[0]);
			}
		},
		// 开始播放视频
		play(){
			let arra = [{"type":"video", "message":"play"}]
			let showa = {};
			showa = Object.assign({}, arra)
			this.sendMessage(showa[0]);
		},
		// 暂停播放视频
		pause(){
			let arra = [{"type":"video", "message":"pause"}]
			let showa = {};
			showa = Object.assign({}, arra)
			this.sendMessage(showa[0]);
		},
		
		// 发送点对点消息
		// 直播画面开启
		icon_1(item){
			if (item.icon_1 == 0) {
				item.icon_1 = 1;
				let arra = [{type:"video", message:"LiveShow", name:this.info.u_name, teacher:1, text:""}];
				let showa = {};
				showa = Object.assign({}, arra)
				this.sendpeerMessage(item.u_id, arra);
			}
		},
		// 全屏模式
		icon_2(item){
			// 全屏模式
			if (item.icon_2 == 0) {
				item.icon_2 = 1;
				let arra = [{type:"screen", message:"Fullscreen", name:this.info.u_name, teacher:1, text:""}];
				let showa = {};
				showa = Object.assign({}, arra)
				this.sendpeerMessage(item.u_id, arra);
			} 
		},
		// 开启聊天窗口
		icon_3(item){
			// 开启聊天窗口
			if (item.icon_3 == 0) {
				item.icon_3 = 1;
				let arra = [{"type":"video", "message":"ChatShow", "name":this.info.u_name, "teacher":1, "text":""}];
				let showa = {};
				showa = Object.assign({}, arra)
				this.sendpeerMessage(item.u_id, arra);
			} 
		},
		// 模式选择
		choosemodel1() {
			if (this.model1_open == false) {
				this.model1_open = true;
				this.model1_close = false;
				this.model2_close = true;
				this.model2_open = false;
			} else if (this.model1_open == true) {
				this.model1_open = true;
			}
		},
		choosemodel2() {
			if (this.model2_open == false) {
				this.model2_open = true;
				this.model2_close = false;
				this.model1_close = true;
				this.model1_open = false;
			} else if (this.model2_open == true) {
				this.model2_open = true;
			}
		},
		// 节拍器选择
		chooserhythm1() {
			if (this.rhythm1_open == false) {
				this.rhythm1_open = true;
				this.rhythm1_close = false;
				this.rhythm2_close = true;
				this.rhythm2_open = false;
			} else if (this.rhythm1_open == true) {
				this.rhythm1_open = true;
			}
		},
		chooserhythm2() {
			if (this.rhythm2_open == false) {
				this.rhythm2_open = true;
				this.rhythm2_close = false;
				this.rhythm1_close = true;
				this.rhythm1_open = false;
			} else if (this.rhythm2_open == true) {
				this.rhythm2_open = true;
			}
		},
		// 左右手选择
		choosehand1() {
			if (this.hand1_open == false) {
				this.hand1_open = true;
				this.hand1_close = false;
				this.hand2_close = true;
				this.hand2_open = false;
				this.hand3_close = true;
				this.hand3_open = false;
			} else if (this.hand1_open == true) {
				this.hand1_open = true;
			}
		},
		choosehand2() {
			if (this.hand2_open == false) {
				this.hand2_open = true;
				this.hand2_close = false;
				this.hand1_close = true;
				this.hand1_open = false;
				this.hand3_close = true;
				this.hand3_open = false;
			} else if (this.hand2_open == true) {
				this.hand2_open = true;
			}
		},
		choosehand3() {
			if (this.hand3_open == false) {
				this.hand3_open = true;
				this.hand3_close = false;
				this.hand1_close = true;
				this.hand1_open = false;
				this.hand2_close = true;
				this.hand2_open = false;
			} else if (this.hand3_open == true) {
				this.hand3_open = true;
			}
		}
	}
};
</script>

<style>
* {
	padding: 0px;
	margin: 0px;
}
/* 直播检测框 */
.remind {
	width: 671px;
	height: 505px;
	background-color: #3c6abb;
	border-radius: 20px;
	box-shadow: 0px 0px 10px 5px #079fff;
	position: relative;
	position: absolute;
	top: 300px;
	left: 625px;
}
.remind .x image {
	width: 37px;
	height: 37px;
	position: absolute;
	right: 40px;
	top: 40px;
}
.remind .re_row {
	width: 600px;
	height: 5px;
	margin-left: 60px;
	margin-top: 60px;
	margin-bottom: 30px;
	margin-right: 10px;
	text-align: left;
}
.remind .re_row image {
	width: 31px;
	height: 31px;
	float: left;
}
.remind .re_row .re_text {
	font-size: 20px;
	float: left;
	width: 500px;
	margin-left: 10px;
}
.remind .re_btn {
	font-size: 20px;
	padding: 12px 70px;
	border-radius: 40px;
	float: left;
	position: absolute;
	bottom: 50px;
	left: 230px;
	color: #0077f1;
	background-color: #fff;
}
/* 课程详情主页 */
.content {
	width: 1920px;
	height: 1080px;
	position: relative;
	overflow: hidden;
	float: left;
}
.content_bg {
	opacity: 0.3;
	z-index: -1;
}
.content ::-webkit-scrollbar {
	/*滚动条整体样式*/
	width: 10px;
	/*高宽分别对应横竖滚动条的尺寸*/
	height: 1px;
}
.content ::-webkit-scrollbar-thumb {
	/*滚动条里面小方块*/
	border-radius: 10px;
	-webkit-box-shadow: inset 0 0 5px rgba(93, 194, 208, 0.8);
	background: #0077f1;
}
.content ::-webkit-scrollbar-track {
	/*滚动条里面轨道*/
	-webkit-box-shadow: inset 0 0 5px rgba(93, 194, 208, 0.2);
	border-radius: 10px;
	background: #ededed;
}
.left {
	width: 270px;
	height: 1080px;
	background-color: #f6f8fc;
	overflow: hidden;
	float: left;
}
.left .l_title {
	width: 224px;
	height: 24px;
	font-size: 28px;
	font-family: Microsoft YaHei, Microsoft YaHei-Bold;
	font-weight: 700;
	color: #040270;
	margin: 49px auto;
}
.left .line {
	width: 270px;
	height: 2px;
	background-color: #fff;
	margin-bottom: 30px;
}
.l_bottom {
	width: 224px;
	height: 1052px;
	/* border: 1px solid #333; */
	margin: 0px auto;
}
.l_text {
	width: 100%;
	float: left;
	margin-bottom: 30px;
}
.l_text .text1 {
	width: 147px;
	height: 9px;
	font-size: 18px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #364064;
	float: left;
}
.left .l_text image {
	width: 17px;
	height: 17px;
	float: right;
	margin-top: 4px;
}
.l_bottom scroll-view {
	width: 110%;
	height: 880px;
}
.list {
	width: 100%;
	float: left;
}
.lose_img {
	transition: all .3s ease;
	filter: grayscale(100%);
	opacity: .6;
}
.list .head image {
	width: 30px;
	height: 30px;
	float: left;
	border-radius: 50%;
}
.list .text2 {
	width: 64px;
	height: 30px;
	font-size: 16px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #364064;
	float: left;
	margin-top: 5px;
	margin-left: 5px;
	overflow: hidden;
	white-space: nowrap;
}
.list .icons image {
	width: 15px;
	height: 15px;
	float: right;
	margin-top: 10px;
	margin-right: 5px;
}
.list .text3 {
	width: 100%;
	height: 30px;
	font-size: 16px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #008000;
	opacity: 0.8;
	overflow: hidden;
	margin-left: 5px;
	margin-bottom: 10px;
	float: left;
}
/* 顶部 */
.top {
	width: 1650px;
	height: 122px;
	/* border: 1px solid #333; */
	position: absolute;
	right: 0px;
}
.top .head image {
	width: 72px;
	height: 72px;
	float: left;
	margin: 30px 33px;
	border-radius: 50%;
}
.top .text4 {
	width: 380px;
	height: 60px;
	font-size: 18px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #333;
	float: left;
	margin: 31px 0px;
}
.text4 .onerow view:first-child,
.text4 .tworow view:first-child {
	width: 200px;
	float: left;
	overflow: hidden;
}
.text4 .onerow view:first-child,
.text4 .onerow view:last-child {
	margin-bottom: 10px;
}
.text4 .onerow view:last-child,
.text4 .tworow view:last-child {
	margin-left: 10px;
}
.top .status {
	width: 550px;
	height: 92px;
	float: left;
	margin-top: 30px;
}
.top .status image:nth-child(1),
.top .status image:nth-child(7) {
	width: 45px;
	height: 45px;
	float: left;
	margin: 20px 20px 0px 50px;
}
.top .status image:nth-child(2),
.top .status image:nth-child(3),
.top .status image:nth-child(4),
.top .status image:nth-child(5),
.top .status image:nth-child(6),
.top .status image:nth-child(8),
.top .status image:nth-child(9),
.top .status image:nth-child(10) {
	width: 46px;
	height: 23px;
	float: left;
	margin-top: 32px;
	margin-left: 30px;
}
.top .status .text6 {
	font-size: 18px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	text-align: left;
	color: #333333;
	line-height: 28px;
	color: #333;
	float: left;
	margin-top: 30px;
}
.top .ctrl image {
	width: 173px;
	height: 77px;
	float: right;
	margin-top: 35px;
	margin-right: 10px;
}
.top .line {
	width: 100%;
	height: 2px;
	background-color: #ecf0f1;
	margin-top: 122px;
}
.middle {
	width: auto;
	height: 160px;
	margin-top: 150px;
	margin-left: 340px;
}
.middle .card {
	width: 360px;
	height: 160px;
	border-radius: 9px;
	float: left;
	margin-right: 30px;
}
.middle .card image {
	width: 50px;
	height: 52px;
	margin: 50px 40px 50px 60px;
	float: left;
}
.middle .card .text7 {
	width: 100px;
	height: 21px;
	font-size: 22px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	float: left;
	margin-top: 30px;
}
.middle .card .text8 {
	width: 170px;
	height: 34px;
	font-size: 40px;
	font-family: Myriad Pro, Myriad Pro-Regular;
	font-weight: 400;
	float: left;
	margin-top: 20px;
}
.card_bg1 {
	background-image: linear-gradient(90deg, #41d9d6 20%, #1099d1);
}
.card_bg2 {
	background-image: linear-gradient(90deg, #669ff8 20%, #f95ea3);
}
.card_bg3 {
	background-image: linear-gradient(90deg, #f7c387 20%, #f3616b);
}
.card_bg4 {
	background-image: linear-gradient(90deg, #7a5afd 20%, #a5c8fe);
}
/* 课程选择 */
.choose {
	width: 750px;
	height: 420px;
	margin-top: 30px;
	margin-left: 340px;
	border-radius: 12px;
	box-shadow: 0px 0px 59px rgba(4, 2, 112, 0.11);
}
/* 头部 */
.choose .title {
	float: left;
	margin-left: 34px;
	margin-top: 24px;
}
.choose .title image {
	width: 38px;
	height: 38px;
	margin-right: 14px;
	float: left;
}
.choose .title .text9 {
	width: 200px;
	height: 23px;
	font-size: 24px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #333;
	margin-top: 4px;
}
.choose .select{
	float: left;
	margin-top: 26px;
	margin-right: 20px;
}
.select input{
	width: 187px;
	height: 36px;
	border-width: 1px;
	border-style: solid;
	border-radius: 5px;
	padding-left: 10px;
	color: #333;
}
.selectClass{
	border-color: #0077f1;
}
.selectIcon{
	width: 30px;
	height: 30px;
	position: absolute;
	margin-left: 160px;
	margin-top: -33px;
}
.selectContent{
	width: 197px;
	height: auto;
	background-color: #fff;
	margin-top: 20px;
	border-radius: 5px;
	box-shadow: 0px 0px 10px rgba(4, 2, 10, 0.1);
	position: absolute;
	z-index: 1;
}
.select .selectScroll{
	height: 100px;
}
.stlectText{
	width: 100%;
	height: 22px;
	font-size: 16px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #333;
	padding: 5px 0px 5px 10px;
}
.selectList:hover{
	background-color: #DCDCDC;
	width: 100%;
	height: 32px;
}
.choose .btn {
	width: 32px;
	height: 22px;
	font-size: 16px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #fff;
	padding: 7px 10px;
	background-color: #0077f1;
	margin-top: 27px;
	margin-right: 25px;
	float: right;
}
/* 课程内容 */
.choose .content {
	width: 690px;
	height: 280px;
	margin-top: 30px;
	margin-left: 34px;
	/* border: 1px solid #333; */
}
.choose scroll-view {
	width: 100%;
	height: 520px;
}
.choose .content .list {
	width: 340px;
	height: 30px;
	float: left;
	margin-bottom: 10px;
}
.choose .content .list image {
	width: 24px;
	height: 24px;
	float: left;
	margin-right: 14px;
}
.choose .content .list .name {
	width: 280px;
	height: 274px;
	font-size: 18px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	text-align: left;
	color: #333;
	float: left;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
/* 底部控制面板 */
.bottom {
	width: 750px;
	height: 250px;
	margin-top: 30px;
	margin-left: 340px;
	border-radius: 12px;
	box-shadow: 0px 0px 59px rgba(4, 2, 112, 0.11);
	position: relative;
}
.bottom .bottom_left {
	width: 250px;
	height: 170px;
	float: left;
	margin-top: 37px;
	margin-left: 37px;
	/* border: 1px solid #333; */
}
.bottom .left1,
.bottom .left2,
.bottom .left3,
.bottom .left4,
.bottom .right1 {
	width: 300px;
	margin-bottom: 20px;
	overflow: hidden;
	white-space: nowrap;   
	text-overflow: ellipsis;
}
.bottom .left1,
.bottom .left2,
.text10 {
	float: left;
	font-size: 18px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #464646;
}       
.checknot {
	width: 20px;
	height: 20px;
	border-radius: 50%;
	border: 1px solid #eaeaea;
	float: left;
	margin-left: 20px;
	margin-right: 10px;
}
.left3 image,
.right1 image,
.right2 image {
	width: 20px;
	height: 20px;
	float: left;
	margin-left: 20px;
	margin-right: 12px;
}
.left4 {
	position: absolute;
	top: 175px;
}
.left4 input {
	width: 82px;
	height: 35px;
	font-size: 18px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	text-align: center;
	color: #464646;
	border: 1px solid rgba(172, 172, 172, 0.35);
	position: absolute;
	top: -5px;
	left: 70px;
}
.left4 .font {
	width: 317px;
	height: 15px;
	font-size: 14px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #acacac;
	position: absolute;
	top: 3px;
	left: 180px;
}
.bottom_right {
	width: 350px;
	height: 66px;
	float: left;
	margin-top: 36px;
	margin-left: 100px;
	/* border: 1px solid #333; */
}
.bottom_right .right1,
.bottom_right .right2 {
	float: left;
}

.btn1, .btn2, .btn3 {
	width: 102px;
	height: 41px;
	background-color: #0077f1;
	position: absolute;
	bottom: 20px;
}
.btn1 {
	right: 20px;
}
.btn2 {
	right: 140px;
}
.btn3 {
	right: 260px;
}

.btn1 image,
.btn2 image,
.btn3 image{
	width: 20px;
	height: 20px;
	float: left;
	margin-top: 10px;
	margin-left: 20px;
}
.btn1 .btn_text,
.btn2 .btn_text,
.btn3 .btn_text{
	font-size: 16px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	text-align: center;
	float: left;
	margin-top: 10px;
	margin-left: 10px;
}
/* 直播 */
.live {
	width: 750px;
	height: 420px;
	margin-top: -700px;
	margin-right: 50px;
	border-radius: 12px;
	/* border: 1px solid #333; */
	float: right;
	position: relative;
}

/* 直播画面 */
.frame {
	width: 750px;
	height: 370px;
	background-color: #000;
	border-radius: 12px;
}
/* 直播信息 */
uni-section{
	/* width: 100px; */
	/* height: 100px; */
	position: absolute;
	top: 165px;
	left: 350px;
	font-size: 50px;
}
.live .imgIcon {
	width: 38px;
	height: 42px;
	position: absolute;
	top: 165px;
	left: 280px;
}
.frame_text {
	width: 135px;
	height: 19px;
	opacity: 0.39;
	font-size: 24px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #fff;
	position: absolute;
	top: 170px;
	left: 360px;
}
.class_time {
	/* width: 183px; */
	/* height: 19px; */
	font-size: 23px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #df122a;
	position: absolute;
	bottom: 80px;
	right: 20px;
}
.live .select {
	float: left;
	margin-top: 15px;
	margin-right: 20px;
}
/* 聊天面板 */
.talk {
	width: 750px;
	height: 250px;
	margin-top: -250px;
	margin-right: 50px;
	border-radius: 12px;
	box-shadow: 0px 0px 59px rgba(4, 2, 112, 0.11);
	float: right;
	position: relative;
}
.talk_left {
	width: 500px;
	height: 250px;
	overflow: hidden;
	/* border: 1px solid #333; */
}
.talk_left ::-webkit-scrollbar {
	display: none;
}
.talk_left .title image {
	width: 439px;
	height: 34px;
	float: left;
	margin-top: 27px;
	margin-left: 25px;
}
.talk_left scroll-view {
	width: 500px;
	height: 170px;
	/* border: 1px solid #000; */
	margin-top: 70px;
	overflow: scroll;
}
/* 我的聊天记录 */
.my_text {
	width: 300px;
	height: 70px;
	float: right;
	margin-right: 25px;
	margin-bottom: 18px;
}
.myinfo {
	height: 20px;
	float: right;
}
.myname {
	/* width: 120px; */
	height: 11px;
	font-size: 13px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #888888;
	float: left;
	margin-right: 10px;
}
.hisname {
	margin-left: -390px;
}
.mytime { 
	width: 50px;
	height: 11px;
	font-size: 13px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #888888;
	float: left;
}
.histime {
	margin-left: -450px;
}
.mytext {
	width: auto;
	height: auto;
	word-break: break-all;
	border-radius: 5px;
	background-color: #0077f1;
	font-size: 16px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #fff;
	float: right;
	text-align: left;
	overflow: hidden;
	clear: both;
	padding: 8px 8px;
}
.histext{
	float: left;
	margin-left: -150px;
}
/* 右边输入框 */
.talk_right {
	width: 250px;
	height: 250px;
	border-left: 1px solid #acacac;
	float: right;
	margin-top: -252px;
}
.talk_right textarea {
	width: 215px;
	height: 130px;
	/* padding-bottom: 120px; */
	/* border: 1px solid #000; */
	font-size: 16px;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	color: #333333;
	margin-top: 37px;
	margin-left: 16px;
}
</style>

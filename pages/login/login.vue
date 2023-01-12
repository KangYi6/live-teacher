<template>
	<view class="content">
		<!-- 左-->
		<view class="left">
			<image src="../../static/login_logo.png" mode=""></image>
			<view class="text">欢迎登录逐梦智能钢琴</view>
		</view> 
		<!-- 右--> 
		<view class="right"> 
			<view class="code"> 
				<!-- 上 -->
				<view class="top"> 
					<view class="text1">登录</view>
					<view class="img" @click="login_type" v-show="person_show">
						<image src="../../static/login_person.png" mode="" ></image>
					</view>
					<view class="img" @click="login_type" v-show="code_show">
						<image src="../../static/login_smallcode.png" mode="" ></image>
					</view>
				</view>
				<!-- 扫码登录 -->
				<view class="middle" v-show="person_show">
					<image src="../../static/login_code.png"></image>
					<view class="text3">请使用微信扫一扫</view>
				</view>
				<!-- 账号登录 -->
				<view class="account" v-show="code_show">
					<image class="icon_user" src="../../static/login_user.png" mode=""></image>
					<image class="icon_ps" src="../../static/login_ps.png" mode=""></image>
					<input class="user" type="text" placeholder="请输入账号" v-model="username" @blur="user_blur" @focus="user_focus" />
					<view class="checkuser" v-show="checkuser_show">* 用户名不能为空</view>
					<input class="ps" type="password" placeholder="请输入密码" v-model="password" @blur="pwd_blur" @focus="pwd_focus"/>
					<view class="checkpwd" v-show="checkpwd_show">* 密码不能为空</view>
					<button @click="login()">立即登录</button>
				</view>
			</view> 
			<!-- 隐私政策 -->
			<view class="bottom">
				<span class="text4">登录即代表同意</span>
				<span class="text5">《隐私政策》</span>
			</view>
			<!-- <msg ref="msgview" :content="msg.content" :icon="msg.icon" v-show="true"></msg> -->
			<!-- <alert ref="alertview" :title="alert.title" :content="alert.content" :cancelBtn="alert.cancelBtn" 
			:cancelText="alert.cancelText" :confirmBtn="alert.confirmBtn" :confirmText="alert.confirmText" v-show="alert.show" 
			@closeAlert="seeking('hide')" @cancelAlert="seeking('hide')" @confirmAlert="seeking('confirm')"></alert>
			</alert> --> 
		</view>

	</view>
</template>

<script>
export default {
	data() {
		return {
			//提示消息
			msg:{
				content:'操作成功',
				icon:'info',
				show:false,
			},
			//弹窗
			alert:{
				cancelText:'取消',
				confirmText:'确认',
				cancelBtn:true,
				confirmBtn:true,
				content:'是否立即发送求谱信息',
				title:'提示',
				show:false,
			},
			// 账号密码验证提示
			checkuser_show: false,
			checkpwd_show: false,
			// 登录的账号密码
			username:'',
			password:'',		
			current:1,
			person_show: false,
			code_show: true,
			erweima: '',//登录二维码
		};
	},
	onLoad() {
		// getApp().globalData.loginPageOpen = true //设置打开登录页
		// this.getData()
		// this.login()
	},
	// onBackPress(){
	// 	getApp().globalData.loginPageOpen = false //设置关闭登录页
	// },

	methods: {
		// 点击切换登录方式 
		login_type(){
			if(this.current == 1){
				this.current = 2;
				this.person_show = false;
				this.code_show = true;
			}
			else if(this.current == 2){
				this.current = 1;
				this.person_show = true;
				this.code_show = false;
			}
		},
		// 登录验证
		user_blur(){
			if(this.username == ''){
				this.checkuser_show = true;
			}
		},
		pwd_blur(){
			if(this.password == ''){
				this.checkpwd_show = true;
			}
		},
		user_focus(){
			this.checkuser_show = false;
		},
		pwd_focus(){
			this.checkpwd_show = false;
		},
		// 登录成功（测试）
		login() {
			// let mac = getInfo('mac');
			this.$request({
				url: this.$baseUrl + '/liveteacher/login/index.html',
				method: 'POST',
				data: { 
					username: this.username,
					password: this.password,
				},
			}).then((res)=>{
				console.log(res.data);
				if(res.data.msg === '登录成功'){
					uni.setStorageSync('user',res.data.data)
					uni.navigateTo({
						url:'/pages/courses/courses', 
						// animationType: this.globalData.animationType,
						// animationDuration: this.globalData.animationDuration,
					})
				}
			});  
		},	
		
		// 获取二维码
		// getData() {
		// 	this.$request({
		// 		url: this.$baseUrl + '/piano/login/getQrcode.html',
		// 		method: 'POST'
		// 	}).then((res) => {
		// 		this.erweima = res.data.data;
		// 		// console.log(res);
		// 		// 解决base64图片不显示问题
		// 		this.erweima=this.erweima.replace(/[\r\n]/g, "")
		// 	});
		// },
	}
};
</script>

<style>
* {
	margin: 0px;
	padding: 0px;
}
.content {
	width: 100%;
	height: 100%;
	position: relative;
}
.left {
	width: 50%;
	height: 100%;
	background: url('@/static/login_bg.png') no-repeat;
	text-align: center;
	float: left;
}
.left image {
	width: 40%;
	height: 9%;
	margin-top: 40%;
}
.left .text {
	font-size: 36px;
	color: #fff;
	margin-top: 50px;
} 
.right {
	width: 50%;
	height: 100%;
	float: right;
}
.code{
	width: 80%;
	height: 70%;
	margin-left: 10%;
	position: relative;
}
.top{
	width: 80%;
	height: 2%;
	margin: 30% auto;

}
.top .text1 {	
	font-size: 51px;
	color: #333333;
	font-family: Hiragino Sans GB, Hiragino Sans GB-W3;
	font-weight: normal;
	float: left;
}
.top image {
	float: right;
	width: 65px;
	height: 65px;
}
.middle {
	width: 100%;
	height: 80%;
	margin-top: -15%;
	text-align: center;
}
.middle image {
	width: 300px;
	height: 301px;
	border: 1px dashed #000000;
}
.middle .text3 {
	font-size: 28px;
	color: #333333;
	margin-top: 5px;
}
/* 账号密码登录 */
.account {
	width: 80%;
	height: 80%;
	position: relative;
	margin-top: -25%;
	margin-left: 10%;
}
.account .icon_user,
.account .icon_ps {
	width: 22px;
	height: 22px;
}
.account .icon_user {
	position: absolute;
	top: 25%;
	left: 20px;
}
.account .icon_ps {
	position: absolute;
	top: 46%;
	left: 20px;
}
/* 账号密码验证 */
.account .checkuser,
.account .checkpwd{
	font-size: 18px;
	color: red;
	position: absolute;
}
.account .checkuser{
	top: 34%;
}
.account .checkpwd{
	top: 55%;
}
.user,
.ps {
	width: 88%;
	height: 13%;
	border: 2px solid #e7e7e7;
	padding-left: 11%;
	font-size: 24px;
	color: #9c9c9c;
}
.user {
	position: absolute;
	top: 20%;
}
.ps {
	position: absolute;
	top: 41%;
}
.account button {
	width: 100%;
	height: 13%;
	background: #0077f1;
	border-radius: 7px;
	text-align: center;
	line-height: 15%;
	font-size: 150%;
	color: #fff;
	padding-top: 6%;
	position: absolute;
	top: 64%;
}
/* 隐私政策 */
.bottom {
	height: 5%;
	/* position: absolute; */
	/* top: 83%; */
	/* left: 67%; */
	text-align: center;
}
.bottom .text4 {
	font-size: 24px;
	color: #9a9a9a;
}
.bottom .text5 {
	font-size: 24px;
	color: #2475f9;
}
</style>

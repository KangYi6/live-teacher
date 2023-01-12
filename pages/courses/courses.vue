<template>
	<view class="content">
		<!-- 顶部导航栏 -->
		<view class="tab">
			<view class="tab_list" v-for="(item, index) in tab" :key="index" @click="Tab(index)" :class="{ cur: current == index }">{{ item.title }}</view>
		</view>
		<view class="line"></view>

		<view class="sug">
			<image src="../../static/courses_sug.png" mode=""></image>
			<span>温馨提示：只能提前15分钟进入直播房间</span>
		</view>

		<!-- 左右按钮 -->
		<view class="pre"><image src="../../static/courses_pre.png" mode="" @click="pre"></image></view>
		<view class="next"><image src="../../static/courses_next.png" mode="" @click="next"></image></view>

		<!-- 直播间 -->
		<view class="room">
			<view class="room_list" v-for="(item, index) in room" :key="index" :class="{ room_bg: item.s_status == 1 }">
				<image src="../../static/courses_icon1.png" mode="" v-show="item.s_video == ''"></image>
				<image src="../../static/courses_icon2.png" mode="" v-show="item.s_video !== ''"></image>
				<view class="time">{{ item.s_starttime }}-{{ item.s_endtime }}</view>
				<view class="date">上课日期：{{ item.s_date }}</view>
				<view class="class">上课班级：{{ item.name }}</view>
				<view class="contents">课程内容：{{ item.g_name }}</view>
				<view class="people">班级人数：{{ item.g_course }}</view>
				<view class="" @click="godetails(item.s_id)">
					<view v-if="item.s_status == 1" class="btn">等待上课</view>
					<view v-if="item.s_status == 2" class="btn">正在上课</view>
					<view v-if="item.s_status == 3" class="btn">已上课</view>
				</view>
			</view>
		</view>

		<!-- 退出按钮 -->
		<div class="exit" @click="quit"><image src="@/static/exit.png" mode="widthFix"></image></div>
	</view>
</template>

<script>
export default {
	data() {
		return {
			// 每页数量
			per_page: '12',
			// 当前页
			page: 1,
			// 最后页
			last_page: '',
			date: 'today',
			tab: [{ title: '今日排课' }, { title: '更多排课' }, { title: '上课记录' }, { title: '布置作业' }, { title: '个人设置' }],
			current: 0,
			room: [],
			// 课程id
			id: '',
			code: '',
			msg: '',
			// 排课id
			s_id: ''
		};
	},

	onLoad() {
		this.getdata();
	},
	methods: {
		getdata() {
			this.$request({
				url: this.$baseUrl + '/liveteacher/schedule/list.html',
				method: 'POST',
				data: {
					page: this.page,
					date: this.date,
					limit: this.per_page
				}
			}).then(res => {
				this.last_page = res.data.data.last_page;
				this.room = res.data.data.data;
				console.log(this.room);
				// console.log(res.data.data.last_page);
			});
		},
		// 上一页
		pre() {
			if (this.page == 1) {
				this.page == this.last_page;
			} else if (this.page > 1) {
				this.page -= 1;
				this.getdata();
			}
			console.log('当前页数：' + this.page);
			console.log('总页数：' + this.last_page);
		},
		// 下一页
		next() {
			if (this.page < this.last_page) {
				this.page += 1;
				this.getdata();
			} else if (this.page >= this.last_page) {
				this.page == this.last_page;
				this.getdata();
			}
			console.log('当前页数：' + this.page);
			console.log('总页数：' + this.last_page);
		},
		// 切换顶部导航栏
		Tab(index) {
			this.current = index;
			if (index == 0) {
				this.date = 'today';
				this.getdata();
				// console.log(555);
			}
			if (index == 1) {
				this.date = 'all';
				this.getdata();
			}
		},
		// 跳转至课程详情
		godetails(s_id) {
			console.log(s_id);
			// 进入课程详情页面前检测课程是否满足条件
			this.$request({
				url: this.$baseUrl + '/liveteacher/live/check.html',
				method: 'POST',
				data: {
					s_id: s_id
				}
			}).then(res => {
				this.code = res.data.code;
				this.msg = res.data.msg;
				console.log(this.code);
				console.log(this.msg);
				if (res.data.code == 1000) {
					//权限检测通过，跳转至课程详情页
					uni.navigateTo({
						url: '/pages/details/details?id=' + s_id
					});
				} else {
					//检测失败，返回到排课页
					return;
				}
			});
		},
		// 退出至登录页面
		quit() {
			uni.navigateTo({
				url: '/pages/login/login'
			});
		}
	}
};
</script>

<style>
.content {
	width: 100%;
	height: 100%;
	position: relative;
}
.tab {
	width: 60%;
	height: 10%;
	float: left;
	margin-top: 3%;
	margin-left: 3%;
	font-size: 24px;
	color: #333;
}
.tab .tab_list {
	float: left;
	margin-right: 5%;
	padding-bottom: 2%;
}
.cur {
	border-bottom: 2px solid #0170e2;
	color: #0170e2;
}
.line {
	width: 100%;
	height: 2px;
	background-color: #ecf0f1;
	margin-top: -2%;
	margin-bottom: 2%;
	float: left;
}
.sug image {
	width: 30px;
	height: 30px;
	margin-left: 3%;
	float: left;
}
.sug span {
	font-size: 18px;
	color: #464646;
	margin-left: 15px;
	float: left;
}
/* 左右按钮 */
.pre image,
.next image {
	width: 5%;
	height: 8%;
	position: absolute;
	top: 55%;
}
.pre image {
	left: 2%;
}
.next image {
	right: 2%;
}
/* 直播间 */
.room {
	width: 85%;
	height: 65%;
	/* border: 1px solid #000; */
	float: left;
	margin-top: 4%;
	margin-left: 2.5%;
}
.room scroll-view {
	width: 100%;
	height: 100%;
}
.room_list {
	width: 23%;
	height: 30%;
	float: left;
	text-align: left;
	background-color: #aa34ea;
	border-radius: 10px;
	position: relative;
	margin: 0px 1% 2% 1%;
}
.room_bg {
	background-color: #1566e8;
}
.room_list image {
	width: 20%;
	height: 35%;
	position: absolute;
	right: 0px;
	top: 0px;
}
.room_list .time {
	font-size: 120%;
	margin-left: 5%;
	margin-top: 5%;
	margin-bottom: 5%;
}
.room_list .date,
.room_list .class,
.room_list .contents,
.room_list .people {
	margin-left: 5%;
	margin-top: 4%;
	font-size: 50%;
	width: 50%;
	height: 11%;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}

.room_list .btn {
	/* width: 35%;
		height: 15%; */
	border: 2px solid;
	border-radius: 18px;
	position: absolute;
	right: 5%;
	bottom: 10%;
	font-size: 50%;
	text-align: center;
	padding: 2% 8%;
}
/* 退出按钮 */
.exit {
	position: absolute;
	top: 4.5%;
	right: 3%;
}
.exit image {
	width: 150px;
	/* height: 72px; */
}
</style>

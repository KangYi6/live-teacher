<template>
	<view class="content">
		<view class="onerow">
			<image src="../../static/into_wait.png" mode=""></image>
			<span>正在等待学生连接 ...</span>
		</view>
		<view class="tworow">
			连接数量：10/15
		</view>
		<view class="btn">
			开始上课
		</view>
		<view class="sug">
			<image src="../../static/gou.png" mode=""></image>
			<span>温馨提示：课件下载过程中，请勿进行课件演示</span>
		</view>
		<view class="return">
			<image src="../../static/return.png" mode=""></image>	
		</view>
		<view class="set">
			<image src="../../static/set.png" mode=""></image>
		</view>
		
	</view>
</template>

<script>
</script>

<style>
	.content{
		width: 100%;
		height: 100%;
		background: url('../../static/bg.png');
		position: relative;
		overflow: hidden;
	} 
	.onerow{
		height: 10%;
		text-align: center;
		margin: 15% auto 0;
		font-size: 300%;
	}
	.onerow image{
		width: 4%;
		height: 70%;
		margin-right: 2%;
		position: relative;
		top: 20%;
	}
	.tworow{
		text-align: center;
		font-size: 200%;
		color: #FFDA75;
		margin-top: 1%;
	}
	.btn{
		width: 15%;
		text-align: center;
		padding: 1% 1%;
		font-size: 36px;
		color: #082880;
		border-radius: 40px;
		background-color: #fff;
		margin: 5% auto 14%;
	}
	.sug{
		text-align: center;
		font-size: 30px;
	}
	.sug image{
		width: 36px;
		height: 36px;
		margin-right: 1%;
		position: relative;
		top: 8px;
	}
	.return image, 
	.set image{
		width: 9%;
		height: 7%;
		position: absolute;
		top: 8%;
		
	}
	.return image{
		right: 13%;
	}
	.set image{
		right: 4%;
	}
</style>
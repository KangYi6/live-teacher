<template>
	<view class="content">
		<view class="head">
			<span class="title">五线谱电教板</span>
			<view class="staffimg1" @click="clearkeyshow">
				<span>清除</span>
			</view>
			<view class="staffimg2" @click="playing()">
				<span>返回</span>
			</view>
		</view>
		
		<view class="center">
			<view class="center1">
				<view class="center2">
					<view class="brackets1">
						<image src="../../static/staff/brackets.svg" class="qutou"></image>
						<view class="xian1">
							<view class="xian"></view>
							<view class="xian"></view>
							<view class="xian"></view>
							<view class="xian"></view>
							<view class="xian"></view>
						</view>
						<view class="title1">
							<image src="../../static/staff/eight.svg" class="eight"></image>
							<span>----------------</span>
						</view>
						<view class="line1">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line2">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line3">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line4">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line5">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line6">
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line7">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line8">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line9">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line10">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line11">
							<span class="line"></span>
						</view>
						<view class="line12">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line13">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line14">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line15">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line16">
							<span class="line"></span>
						</view>
						<view class="line17">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line18">
							<span class="line"></span>
							<span class="line"></span>
							<span class="line"></span>
						</view>
						<view class="line19">
							<span class="line"></span>
						</view>
						<image src="../../static/staff/Treblenote.svg" class="Treblenote"></image>
						
						<image src="../../static/staff/yinfu.svg" class="yinfu1" v-if="keyshow[0]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu2" v-if="keyshow[1]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu3" v-if="keyshow[2]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu4" v-if="keyshow[3]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu5" v-if="keyshow[4]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu6" v-if="keyshow[5]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu7" v-if="keyshow[6]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu8" v-if="keyshow[7]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu9" v-if="keyshow[8]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu10" v-if="keyshow[9]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu11" v-if="keyshow[10]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu12" v-if="keyshow[11]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu13" v-if="keyshow[12]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu14" v-if="keyshow[13]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu15" v-if="keyshow[14]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu16" v-if="keyshow[15]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu17" v-if="keyshow[16]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu18" v-if="keyshow[17]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu19" v-if="keyshow[18]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu20" v-if="keyshow[19]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu21" v-if="keyshow[20]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu22" v-if="keyshow[21]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu23" v-if="keyshow[22]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu24" v-if="keyshow[23]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu25" v-if="keyshow[24]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu26" v-if="keyshow[25]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu27" v-if="keyshow[26]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu28" v-if="keyshow[27]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu29" v-if="keyshow[28]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu30" v-if="keyshow[29]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu31" v-if="keyshow[30]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu32" v-if="keyshow[31]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu33" v-if="keyshow[32]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu34" v-if="keyshow[33]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu35" v-if="keyshow[34]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu36" v-if="keyshow[35]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu37" v-if="keyshow[36]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu38" v-if="keyshow[37]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu39" v-if="keyshow[38]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu40" v-if="keyshow[39]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu41" v-if="keyshow[40]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu42" v-if="keyshow[41]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu43" v-if="keyshow[42]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu44" v-if="keyshow[43]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu45" v-if="keyshow[44]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu46" v-if="keyshow[45]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu47" v-if="keyshow[46]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu48" v-if="keyshow[47]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu49" v-if="keyshow[48]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu50" v-if="keyshow[49]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu51" v-if="keyshow[50]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu52" v-if="keyshow[51]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu53" v-if="keyshow[52]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu54" v-if="keyshow[53]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu55" v-if="keyshow[54]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu56" v-if="keyshow[55]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu57" v-if="keyshow[56]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu58" v-if="keyshow[57]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu59" v-if="keyshow[58]"></image>
						<image src="../../static/staff/yinfu.svg" class="yinfu60" v-if="keyshow[59]"></image>
					</view>
					<view class="brackets2">
						<image src="../../static/staff/brackets.svg" class="qutou"></image>
						<view class="xian1">
							<view class="xian"></view>
							<view class="xian"></view>
							<view class="xian"></view>
							<view class="xian"></view>
							<view class="xian"></view>
						</view>
						<image src="../../static/staff/Bass.svg" class="Bass"></image>
					</view>
					<div class="keyboard">
					    <!-- 88键盘 36个黑键 52个白键 -->
					    <div id="key21" class="key">
					        <div class="whiteKey" @click="keysup(0)">
								  <span class="num">A</span>
								  <div class="numtop">A2</div>
								  <div class="numbottom">La</div>
							  </div>
					    </div>
					    <div id="key23" class="key">
					        <div class="whiteKey" @click="keysup(1)">
								  <span class="num">B</span>
								  <div class="numtop">B2</div>
								  <div class="numbottom">Si</div>
							  </div>
					    </div>
					    <div id="key24" class="key">
					        <div class="whiteKey" @click="keysup(2)">
								  <span class="num">C</span>
								  <div class="numtop">C1</div>
								  <div class="numbottom">Do</div>
							  </div>
					    </div>
					    <div id="key26" class="key">
					        <div class="whiteKey" @click="keysup(3)">
								  <span class="num">D</span>
								  <div class="numtop">D1</div>
								  <div class="numbottom">Re</div>
							  </div>
					    </div>
					    <div id="key28" class="key">
					        <div class="whiteKey" @click="keysup(4)">
								  <span class="num">E</span>
								  <div class="numtop">E1</div>
								  <div class="numbottom">Mi</div>
							  </div>
					    </div>
					    <div id="key29" class="key">
					        <div class="whiteKey" @click="keysup(5)">
								  <span class="num">F</span>
								  <div class="numtop">F1</div>
								  <div class="numbottom">Fa</div>
							  </div>
					    </div>
					    <div id="key31" class="key">
					        <div class="whiteKey" @click="keysup(6)">
								  <span class="num">G</span>
								  <div class="numtop">G1</div>
								  <div class="numbottom">So</div>
							  </div>
					    </div>
					    <div id="key33" class="key">
					        <div class="whiteKey" @click="keysup(7)">
								  <span class="num">A</span>
								  <div class="numtop">A1</div>
								  <div class="numbottom">La</div>
							  </div>
					    </div>
					    <div id="key35" class="key">
					        <div class="whiteKey" @click="keysup(8)">
								  <span class="num">B</span>
								  <div class="numtop">B1</div>
								  <div class="numbottom">Si</div>
							  </div>
					    </div>
					    <div id="key36" class="key">
					        <div class="whiteKey" @click="keysup(9)">
								  <span class="num">C</span>
								  <div class="numtop">C</div>
								  <div class="numbottom">Do</div>
							  </div>
					    </div>
					    <div id="key38" class="key">
					        <div class="whiteKey" @click="keysup(10)">
								  <span class="num">D</span>
								  <div class="numtop">D</div>
								  <div class="numbottom">Re</div>
							  </div>
					    </div>
					    <div id="key40" class="key">
					        <div class="whiteKey" @click="keysup(11)">
								  <span class="num">E</span>
								  <div class="numtop">E</div>
								  <div class="numbottom">Mi</div>
							  </div>
					    </div>
					    <div id="key41" class="key">
					        <div class="whiteKey" @click="keysup(12)">
								  <span class="num">F</span>
								  <div class="numtop">F</div>
								  <div class="numbottom">Fa</div>
							  </div>
					    </div>
					    <div id="key43" class="key">
					        <div class="whiteKey" @click="keysup(13)">
								  <span class="num">G</span>
								  <div class="numtop">G</div>
								  <div class="numbottom">So</div>
							  </div>
					    </div>
					    <div id="key45" class="key">
					        <div class="whiteKey" @click="keysup(14)">
								  <span class="num">A</span>
								  <div class="numtop">A</div>
								  <div class="numbottom">La</div>
							  </div>
					    </div>
					    <div id="key47" class="key">
					        <div class="whiteKey" @click="keysup(15)">
								  <span class="num">B</span>
								  <div class="numtop">B</div>
								  <div class="numbottom">Si</div>
							  </div>
					    </div>
					    <div id="key48" class="key">
					        <div class="whiteKey" @click="keysup(16)">
								  <span class="num">C</span>
								  <div class="numtop">c</div>
								  <div class="numbottom">Do</div>
							  </div>
					    </div>
					    <div id="key50" class="key">
					        <div class="whiteKey" @click="keysup(17)">
								  <span class="num">D</span>
								  <div class="numtop">d</div>
								  <div class="numbottom">Re</div>
							  </div>
					    </div>
					    <div id="key52" class="key">
					        <div class="whiteKey" @click="keysup(18)">
								  <span class="num">E</span>
								  <div class="numtop">e</div>
								  <div class="numbottom">Mi</div>
							  </div>
					    </div>
					    <div id="key53" class="key">
					        <div class="whiteKey" @click="keysup(19)">
								  <span class="num">F</span>
								  <div class="numtop">f</div>
								  <div class="numbottom">Fa</div>
							  </div>
					    </div>
					    <div id="key55" class="key">
					        <div class="whiteKey" @click="keysup(20)">
								  <span class="num">G</span>
								  <div class="numtop">g</div>
								  <div class="numbottom">So</div>
							  </div>
					    </div>
					    <div id="key57" class="key">
					        <div class="whiteKey" @click="keysup(21)">
								  <span class="num">A</span>
								  <div class="numtop">a</div>
								  <div class="numbottom">La</div>
							  </div>
					    </div>
					    <div id="key59" class="key">
					        <div class="whiteKey" @click="keysup(22)">
								  <span class="num">B</span>
								  <div class="numtop">b</div>
								  <div class="numbottom">Si</div>
							  </div>
					    </div>
					    <div id="key60" class="key">
					        <div class="whiteKey" @click="keysup(23)">
								  <span class="num">C</span>
								  <div class="numtop">c²</div>
								  <div class="numbottom">Do</div>
							  </div>
					    </div>
					    <div id="key62" class="key">
					        <div class="whiteKey" @click="keysup(24)">
								  <span class="num">D</span>
								  <div class="numtop">d²</div>
								  <div class="numbottom">Re</div>
							  </div>
					    </div>
					    <div id="key64" class="key">
					        <div class="whiteKey" @click="keysup(25)">
								  <span class="num">E</span>
								  <div class="numtop">e²</div>
								  <div class="numbottom">Mi</div>
							  </div>
					    </div>
					    <div id="key65" class="key">
					        <div class="whiteKey" @click="keysup(26)">
								  <span class="num">F</span>
								  <div class="numtop">f²</div>
								  <div class="numbottom">Fa</div>
							  </div>
					    </div>
					    <div id="key67" class="key">
					        <div class="whiteKey" @click="keysup(27)">
								  <span class="num">G</span>
								  <div class="numtop">g²</div>
								  <div class="numbottom">So</div>
							  </div>
					    </div>
					    <div id="key69" class="key">
					        <div class="whiteKey" @click="keysup(28)">
								  <span class="num">A</span>
								  <div class="numtop">a²</div>
								  <div class="numbottom">La</div>
							  </div>
					    </div>
					    <div id="key71" class="key">
					        <div class="whiteKey" @click="keysup(29)">
								  <span class="num">B</span>
								  <div class="numtop">b²</div>
								  <div class="numbottom">Si</div>
							  </div>
					    </div>
					    <div id="key72" class="key">
					        <div class="whiteKey" @click="keysup(30)">
								  <span class="num">C</span>
								  <div class="numtop">c³</div>
								  <div class="numbottom">Do</div>
							  </div>
					    </div>
					    <div id="key74" class="key">
					        <div class="whiteKey" @click="keysup(31)">
								  <span class="num">D</span>
								  <div class="numtop">d³</div>
								  <div class="numbottom">Re</div>
							  </div>
					    </div>
					    <div id="key76" class="key">
					        <div class="whiteKey" @click="keysup(32)">
								  <span class="num">E</span>
								  <div class="numtop">e³</div>
								  <div class="numbottom">Mi</div>
							  </div>
					    </div>
					    <div id="key77" class="key">
					        <div class="whiteKey" @click="keysup(33)">
								  <span class="num">F</span>
								  <div class="numtop">f³</div>
								  <div class="numbottom">Fa</div>
							  </div>
					    </div>
					    <div id="key79" class="key">
					        <div class="whiteKey" @click="keysup(34)">
								  <span class="num">G</span>
								  <div class="numtop">g³</div>
								  <div class="numbottom">So</div>
							  </div>
					    </div>
					    <div id="key81" class="key">
					        <div class="whiteKey" @click="keysup(35)">
								  <span class="num">A</span>
								  <div class="numtop">a³</div>
								  <div class="numbottom">La</div>
							  </div>
					    </div>
					    <div id="key83" class="key">
					        <div class="whiteKey" @click="keysup(36)">
								  <span class="num">B</span>
								  <div class="numtop">b³</div>
								  <div class="numbottom">Si</div>
							  </div>
					    </div>
					    <div id="key84" class="key">
					        <div class="whiteKey" @click="keysup(37)">
								  <span class="num">C</span>
								  <div class="numtop">c³</div>
								  <div class="numbottom">Do</div>
							  </div>
					    </div>
					    <div id="key86" class="key">
					        <div class="whiteKey" @click="keysup(38)">
								  <span class="num">D</span>
								  <div class="numtop">d³</div>
								  <div class="numbottom">Re</div>
							  </div>
					    </div>
					    <div id="key88" class="key">
					        <div class="whiteKey" @click="keysup(39)">
								  <span class="num">E</span>
								  <div class="numtop">e³</div>
								  <div class="numbottom">Mi</div>
							  </div>
					    </div>
					    <div id="key89" class="key">
					        <div class="whiteKey" @click="keysup(40)">
								  <span class="num">F</span>
								  <div class="numtop">f³</div>
								  <div class="numbottom">Fa</div>
							  </div>
					    </div>
					    <div id="key91" class="key">
					        <div class="whiteKey" @click="keysup(41)">
								  <span class="num">G</span>
								  <div class="numtop">g³</div>
								  <div class="numbottom">So</div>
							  </div>
					    </div>
					    <div id="key93" class="key">
					        <div class="whiteKey" @click="keysup(42)">
								  <span class="num">A</span>
								  <div class="numtop">a³</div>
								  <div class="numbottom">La</div>
							  </div>
					    </div>
					    <div id="key95" class="key">
					        <div class="whiteKey" @click="keysup(43)">
								  <span class="num">B</span>
								  <div class="numtop">b³</div>
								  <div class="numbottom">Si</div>
							  </div>
					    </div>
					    <div id="key96" class="key">
					        <div class="whiteKey" @click="keysup(44)">
								  <span class="num">C</span>
								  <div class="numtop">cⁿ</div>
								  <div class="numbottom">Do</div>
							  </div>
					    </div>
					    <div id="key98" class="key">
					        <div class="whiteKey" @click="keysup(45)">
								  <span class="num">D</span>
								  <div class="numtop">dⁿ</div>
								  <div class="numbottom">Re</div>
							  </div>
					    </div>
					    <div id="key100" class="key">
					        <div class="whiteKey" @click="keysup(46)">
								  <span class="num">E</span>
								  <div class="numtop">eⁿ</div>
								  <div class="numbottom">Mi</div>
							  </div>
					    </div>
					    <div id="key101" class="key">
					        <div class="whiteKey" @click="keysup(47)">
								  <span class="num">F</span>
								  <div class="numtop">fⁿ</div>
								  <div class="numbottom">Fa</div>
							  </div>
					    </div>
					    <div id="key103" class="key">
					        <div class="whiteKey" @click="keysup(48)">
								  <span class="num">G</span>
								  <div class="numtop">gⁿ</div>
								  <div class="numbottom">So</div>
							  </div>
					    </div>
					    <div id="key105" class="key">
					        <div class="whiteKey" @click="keysup(49)">
								  <span class="num">A</span>
								  <div class="numtop">aⁿ</div>
								  <div class="numbottom">La</div>
							  </div>
					    </div>
					    <div id="key107" class="key">
					        <div class="whiteKey" @click="keysup(50)">
								  <span class="num">B</span>
								  <div class="numtop">bⁿ</div>
								  <div class="numbottom">Si</div>
							  </div>
					    </div>
					    <div id="key108" class="key">
					        <div class="whiteKey" @click="keysup(51)">
								  <div class="numtop">cⁿ</div>
							  </div>
					    </div>
					    <div id="key22" class="key">
					        <div class="key blackKey" @click="blackkeysup(0)"></div>
					    </div>
					    <div id="key25" class="key">
					        <div class="key blackKey" @click="blackkeysup(1)"></div>
					    </div>
					    <div id="key27" class="key">
					        <div class="key blackKey" @click="blackkeysup(2)"></div>
					    </div>
					    <div id="key30" class="key">
					        <div class="key blackKey" @click="blackkeysup(3)"></div>
					    </div>
					    <div id="key32" class="key">
					        <div class="key blackKey" @click="blackkeysup(4)"></div>
					    </div>
					    <div id="key34" class="key">
					        <div class="key blackKey" @click="blackkeysup(5)"></div>
					    </div>
					    <div id="key37" class="key">
					        <div class="key blackKey" @click="blackkeysup(6)"></div>
					    </div>
					    <div id="key39" class="key">
					        <div class="key blackKey" @click="blackkeysup(7)"></div>
					    </div>
					    <div id="key42" class="key">
					        <div class="key blackKey" @click="blackkeysup(8)"></div>
					    </div>
					    <div id="key44" class="key">
					        <div class="key blackKey" @click="blackkeysup(9)"></div>
					    </div>
					    <div id="key46" class="key">
					        <div class="key blackKey" @click="blackkeysup(10)"></div>
					    </div>
					    <div id="key49" class="key">
					        <div class="key blackKey" @click="blackkeysup(11)"></div>
					    </div>
					    <div id="key51" class="key">
					        <div class="key blackKey" @click="blackkeysup(12)"></div>
					    </div>
					    <div id="key54" class="key">
					        <div class="key blackKey" @click="blackkeysup(13)"></div>
					    </div>
					    <div id="key56" class="key">
					        <div class="key blackKey" @click="blackkeysup(15)"></div>
					    </div>
					    <div id="key58" class="key">
					        <div class="key blackKey" @click="blackkeysup(17)"></div>
					    </div>
					    <div id="key61" class="key">
					        <div class="key blackKey" @click="blackkeysup(19)"></div>
					    </div>
					    <div id="key63" class="key">
					        <div class="key blackKey" @click="blackkeysup(21)"></div>
					    </div>
					    <div id="key66" class="key">
					        <div class="key blackKey" @click="blackkeysup(23)"></div>
					    </div>
					    <div id="key68" class="key">
					        <div class="key blackKey" @click="blackkeysup(25)"></div>
					    </div>
					    <div id="key70" class="key">
					        <div class="key blackKey" @click="blackkeysup(27)"></div>
					    </div>
					    <div id="key73" class="key">
					        <div class="key blackKey" @click="blackkeysup(28)"></div>
					    </div>
					    <div id="key75" class="key">
					        <div class="key blackKey" @click="blackkeysup(29)"></div>
					    </div>
					    <div id="key78" class="key">
					        <div class="key blackKey" @click="blackkeysup(30)"></div>
					    </div>
					    <div id="key80" class="key">
					        <div class="key blackKey" @click="blackkeysup(31)"></div>
					    </div>
					    <div id="key82" class="key">
					        <div class="key blackKey" @click="blackkeysup(32)"></div>
					    </div>
					    <div id="key85" class="key">
					        <div class="key blackKey" @click="blackkeysup(33)"></div>
					    </div>
					    <div id="key87" class="key">
					        <div class="key blackKey" @click="blackkeysup(34)"></div>
					    </div>
					    <div id="key90" class="key">
					        <div class="key blackKey" @click="blackkeysup(35)"></div>
					    </div>
					    <div id="key92" class="key">
					        <div class="key blackKey" @click="blackkeysup(36)"></div>
					    </div>
					    <div id="key94" class="key">
					        <div class="key blackKey" @click="blackkeysup(37)"></div>
					    </div>
					    <div id="key97" class="key">
					        <div class="key blackKey" @click="blackkeysup(38)"></div>
					    </div>
					    <div id="key99" class="key">
					        <div class="key blackKey" @click="blackkeysup(39)"></div>
					    </div>
					    <div id="key102" class="key">
					        <div class="key blackKey" @click="blackkeysup(40)"></div>
					    </div>
					    <div id="key104" class="key">
					        <div class="key blackKey" @click="blackkeysup(41)"></div>
					    </div>
					    <div id="key106" class="key">
					        <div class="key blackKey" @click="blackkeysup(42)"></div>
					    </div>
						 
						 <image src="../../static/staff/fuhao.jpg" class="jing1" v-if="jingshow[0]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing2" v-if="jingshow[1]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing3" v-if="jingshow[2]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing4" v-if="jingshow[3]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing5" v-if="jingshow[4]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing6" v-if="jingshow[5]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing7" v-if="jingshow[6]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing8" v-if="jingshow[7]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing9" v-if="jingshow[8]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing10" v-if="jingshow[9]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing11" v-if="jingshow[10]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing12" v-if="jingshow[11]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing13" v-if="jingshow[12]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing14" v-if="jingshow[13]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing15" v-if="jingshow[14]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing16" v-if="jingshow[15]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing17" v-if="jingshow[16]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing18" v-if="jingshow[17]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing19" v-if="jingshow[18]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing20" v-if="jingshow[19]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing21" v-if="jingshow[20]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing22" v-if="jingshow[21]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing23" v-if="jingshow[22]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing24" v-if="jingshow[23]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing25" v-if="jingshow[24]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing26" v-if="jingshow[25]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing27" v-if="jingshow[26]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing28" v-if="jingshow[27]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing29" v-if="jingshow[28]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing30" v-if="jingshow[29]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing31" v-if="jingshow[30]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing32" v-if="jingshow[31]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing33" v-if="jingshow[32]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing34" v-if="jingshow[33]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing35" v-if="jingshow[34]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing36" v-if="jingshow[35]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing37" v-if="jingshow[36]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing38" v-if="jingshow[37]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing39" v-if="jingshow[38]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing40" v-if="jingshow[39]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing41" v-if="jingshow[40]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing42" v-if="jingshow[41]"></image>
						 <image src="../../static/staff/fuhao.jpg" class="jing43" v-if="jingshow[42]"></image>
					</div>
				</view>
			</view>
			<image src="../../static/staff/rule.png" class="rule"></image>
		</view>
	</view>
</template>

<script>
	import {MIDI} from '../../static/staff/audio-js/percussion-mp3.js'
	export default {
		data() {
			return {
				//每个音符显示
				keyshow:[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false],
				//每个#号显示
				jingshow:[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false],
				innerAudioContext:'',
			}
		},
		onLoad() {
			console.log(MIDI);
			let base64Mp3=MIDI.G1
			let innerAudioContext = uni.createInnerAudioContext();
								innerAudioContext.autoplay = true;
								innerAudioContext.src = base64Mp3.replace(/[\r\n]/g, "");
								innerAudioContext.onPlay(() => {
									console.log('开始播放');
								});
								innerAudioContext.onCanplay(()=>{
									console.log("正在播放");
								})
								innerAudioContext.onTimeUpdate(()=>{
									console.log('当前播放位置'+this.innerAudioContext.currentTime+'秒');
								})
								this.innerAudioContext=innerAudioContext
		},
		
		methods: {
			playing(){
				this.innerAudioContext.volume=1
				this.innerAudioContext.play();
				console.log(this.innerAudioContext.paused)
				console.log(this.innerAudioContext.duration+'秒')
			},
			//白键按键按下效果
			keysup(index){
				if(index>=19 && index<=27){
					this.keyshow[index+9]=false
					this.keyshow[index]=false
					setTimeout(()=>{
						this.keyshow[index+9]=true
						this.keyshow[index]=true
					},10)
				}else if(index>27){
					this.keyshow[index+9]=false
					setTimeout(()=>{
						this.keyshow[index+9]=true
					},10)
				}else{
					this.keyshow[index]=false
					setTimeout(()=>{
						this.keyshow[index]=true
					},10)
				}
			},
			
			//黑键按键按下效果
			blackkeysup(index){
				if(index>=13 && index<=25){
					this.jingshow[index]=false
					this.jingshow[index+1]=false
					setTimeout(()=>{
						this.jingshow[index]=true
						this.jingshow[index+1]=true
					},10)
				}else{
					this.jingshow[index]=false
					setTimeout(()=>{
						this.jingshow[index]=true
					},10)
				}
			},
			
			//清除所有音符
			clearkeyshow(){
				this.keyshow.forEach((i,n)=>{
					this.keyshow[n]=false
				})
				this.jingshow.forEach((i,n)=>{
					this.jingshow[n]=false
				})
			},
			
		}
	}
</script>

<style>
.content{
	width: 100%;
	height: 100%;
	background-image:linear-gradient(#091b66,#092a71);
	padding-top: 0.8%;
}
.head{
	width: 93%;
	height: 8%;
	margin-left: 3%;
	line-height: 80px;
}
.head .title{
	font-size: 37px;
	color: #ffffff;
}
.staffimg1{
	width: 173px;
	height: 81px;
	background: url("../../static/staff/clear.png");
	float: right;
	line-height: 67px;
	margin-right: -0.7%;
}
.staffimg1 span,.staffimg2 span{
	font-size: 26px;
	padding-left: 50%;
}
.staffimg2{
	width: 173px;
	height: 81px;
	background: url("../../static/staff/load.png");
	float: right;
	line-height: 67px;
}
.center{
	width: 93%;
	height: 88%;
	margin-left: 3%;
	border: 1px solid #000000;
	background-color: #ff9c58;
	margin-top: 0.5%;
	position: relative;
}
.center1{
	width: 98%;
	height: 96%;
	margin-left: 1%;
	margin-top: 0.8%;
	border: 1px solid #000000;
	background-color: #35754A;
}
.center2{
	width: 95%;
	height: 93%;
	margin-left: 2.5%;
	margin-top: 1.5%;
	border: 1px solid #000000;
	background-color: #ffffff;
	position: relative;
}
.rule{
	transform: scale(0.7);
	position: absolute;
	bottom: -3.6%;
	right: -5%;
}

/* 键盘 */
.keyboard{
	width:100%;
	height:170px;
	transform: scale(0.84);
	position: absolute;
	left:1%;
	bottom:4%;
}
.key{
	width:calc(100% / 52);
	height:100%;
	border-top-left-radius:0;
	border-top-right-radius:0;
	border-bottom-left-radius:4px;
	border-bottom-right-radius:4px;
	float: left;
}
.whiteKey {
	background-color:#f2f2f2;
	width: calc(100% - 1px);
	height:100%;
	border-top-left-radius:0;
	border-top-right-radius:0;
	border-bottom-left-radius:4px;
	border-bottom-right-radius:4px;
	margin-right:1px;
	border: 1px solid #7f7f7f;
	text-align: center;
	position: relative;
}
.whiteKey:active{
	transform: scale(0.95);
	background-color: #98ef96;
}
.blackKey {
	width:calc(1.2% - 1px);
	height:100px;
	border-top-left-radius:0;
	border-top-right-radius:0;
	border-bottom-left-radius:4px;
	border-bottom-right-radius:4px;
	top:0;
	background-color: #000;
   position: absolute;
}
.blackKey:active{
	transform: scale(0.9);
	background-color: #98ef96;
}
#key22 .blackKey{left:calc(100% / 52 - 0.6%);}
#key25 .blackKey{left:calc(3*(100% / 52) - 0.6%);}
#key27 .blackKey{left:calc(4*(100% / 52) - 0.6%);}
#key30 .blackKey{left:calc(6*(100% / 52) - 0.6%);}
#key32 .blackKey{left:calc(7*(100% / 52) - 0.6%);}
#key34 .blackKey{left:calc(8*(100% / 52) - 0.6%);}
#key37 .blackKey{left:calc(10*(100% / 52) - 0.6%);}
#key39 .blackKey{left:calc(11*(100% / 52) - 0.6%);}
#key42 .blackKey{left:calc(13*(100% / 52) - 0.6%);}
#key44 .blackKey{left:calc(14*(100% / 52) - 0.6%);}
#key46 .blackKey{left:calc(15*(100% / 52) - 0.6%);}
#key49 .blackKey{left:calc(17*(100% / 52) - 0.6%);}
#key51 .blackKey{left:calc(18*(100% / 52) - 0.6%);}
#key54 .blackKey{left:calc(20*(100% / 52) - 0.6%);}
#key56 .blackKey{left:calc(21*(100% / 52) - 0.6%);}
#key58 .blackKey{left:calc(22*(100% / 52) - 0.6%);}
#key61 .blackKey{left:calc(24*(100% / 52) - 0.6%);}
#key63 .blackKey{left:calc(25*(100% / 52) - 0.6%);}
#key66 .blackKey{left:calc(27*(100% / 52) - 0.6%);}
#key68 .blackKey{left:calc(28*(100% / 52) - 0.6%);}
#key70 .blackKey{left:calc(29*(100% / 52) - 0.6%);}
#key73 .blackKey{left:calc(31*(100% / 52) - 0.6%);}
#key75 .blackKey{left:calc(32*(100% / 52) - 0.6%);}
#key78 .blackKey{left:calc(34*(100% / 52) - 0.6%);}
#key80 .blackKey{left:calc(35*(100% / 52) - 0.6%);}
#key82 .blackKey{left:calc(36*(100% / 52) - 0.6%);}
#key85 .blackKey{left:calc(38*(100% / 52) - 0.6%);}
#key87 .blackKey{left:calc(39*(100% / 52) - 0.6%);}
#key90 .blackKey{left:calc(41*(100% / 52) - 0.6%);}
#key92 .blackKey{left:calc(42*(100% / 52) - 0.6%);}
#key94 .blackKey{left:calc(43*(100% / 52) - 0.6%);}
#key97 .blackKey{left:calc(45*(100% / 52) - 0.6%);}
#key99 .blackKey{left:calc(46*(100% / 52) - 0.6%);}
#key102 .blackKey{left:calc(48*(100% / 52) - 0.6%);}
#key104 .blackKey{left:calc(49*(100% / 52) - 0.6%);}
#key106 .blackKey{left:calc(50*(100% / 52) - 0.6%);}
#key108 .whiteKey{width:100%;margin-right:0;}
.cur{
	background-color: #98ef96;
}
.current{
	background-color: #98ef96;
	border-left:3px #98ef96 solid;
}
.err{
	background-color: #f00 !important;
}
.num{
	font-size: 30px;
	color: #000000;
	line-height: 298px;
}
.numbottom{
	color: #000000;
	font-size: 20px;
	position: absolute;
	left: 14%;
	bottom: -20%;
}
.numtop{
	color: #000000;
	font-size: 20px;
	position: absolute;
	left: 14%;
	top: -19%;
}
.brackets1{
	width: 100%;
	height: 30%;
	margin-top: 9%;
	margin-bottom: -2.5%;
	margin-left: -10%;
	position: relative;
}
.brackets1 .qutou{
	width: 28%;
	height: 40%;
}
.brackets2{
	width: 100%;
	height: 30%;
	margin-left: -10%;
	position: relative;
}
.brackets2 .qutou{
	width: 28%;
	height: 40%;
}
.xian{
	width: 89%;
	height: 1px;
	background-color: #000000;
	margin-bottom: 1.25%;
}
.xian1{
	margin-top: -5.6%;
	transform: translateX(239px);
}
.Treblenote{
	width: 28%;
	height: 58%;
	position: absolute;
	left: 2.6%;
	top: -6%;
}
.Bass{
	width: 28%;
	height: 28%;
	position: absolute;
	left: 2.6%;
	top: 1%;
}
.line1{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 19%;
	bottom: -26%;
}
.line2{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 19%;
	bottom: -33%;
}
.line3{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 19%;
	bottom: -40%;
}
.line4{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 19%;
	bottom: -47%;
}
.line5{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 19%;
	bottom: -54%;
}
.line6{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 19%;
	bottom: -61%;
}
.line7{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 59.4%;
	bottom: 37%;
}
.line8{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 56.1%;
	bottom: 28%;
}
.line9{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 49.2%;
	bottom: 54%;
}
.line10{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 49.2%;
	bottom: 45%;
}
.line11{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 49.2%;
	bottom: 36%;
}
.line12{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 76%;
	bottom: 112%;
}
.line13{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 79.2%;
	bottom: 121%;
}
.line14{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 82.5%;
	bottom: 130%;
}
.line15{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 85.7%;
	bottom: 139%;
}
.line16{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 88.9%;
	bottom: 148%;
}
.line17{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 93.9%;
	bottom: 130%;
}
.line18{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 97.1%;
	bottom: 139%;
}
.line19{
	width: 100%;
	height: 10px;
	position: absolute;
	left: 100.3%;
	bottom: 148%;
}
.line{
	width: 1.3%;
	height: 1px;
	background-color: #000000;
	margin-right: 0.33%;
	display: inline-block;
}
@keyframes tiaodong{
	from {
	        transform: scale3d(1, 1, 1)
	    }
	    10%, 20% {
	        transform: scale3d(.9, .9, .9) rotate3d(0, 0, 1, -10deg)
	    }
	    30%, 50%, 70%, 90% {
	        transform: scale3d(1.1, 1.1, 1.1) rotate3d(0, 0, 1, 10deg)
	    }
	    40%, 60%, 80% {
	        transform: scale3d(1.1, 1.1, 1.1) rotate3d(0, 0, 1, -10deg)
	    }
	    to {
	        transform: scale3d(1, 1, 1)
	    }
}
@keyframes tiaodong1{
	from {
	        transform: scale3d(1, 1, 1) rotate(180deg)
	    }
	    10%, 20% {
	        transform: scale3d(.9, .9, .9) rotate3d(0, 0, 1, -10deg) rotate(180deg)
	    }
	    30%, 50%, 70%, 90% {
	        transform: scale3d(1.1, 1.1, 1.1) rotate3d(0, 0, 1, 10deg) rotate(180deg)
	    }
	    40%, 60%, 80% {
	        transform: scale3d(1.1, 1.1, 1.1) rotate3d(0, 0, 1, -10deg) rotate(180deg)
	    }
	    to {
	        transform: scale3d(1, 1, 1) rotate(180deg)
	    }
}
.yinfu1{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -70%;
	left: 15.6%;
	animation: tiaodong 1.1s;
}
.yinfu2{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -66.3%;
	left: 17.2%;
	animation: tiaodong 1.1s;
}
.yinfu3{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -62.6%;
	left: 18.8%;
	animation: tiaodong 1.1s;
}
.yinfu4{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -58.9%;
	left: 20.4%;
	animation: tiaodong 1.1s;
}
.yinfu5{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -55.2%;
	left: 22%;
	animation: tiaodong 1.1s;
}
.yinfu6{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -51.5%;
	left: 23.6%;
	animation: tiaodong 1.1s;
}
.yinfu7{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -47.8%;
	left: 25.2%;
	animation: tiaodong 1.1s;
}
.yinfu8{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -44.1%;
	left: 26.8%;
	animation: tiaodong 1.1s;
}
.yinfu9{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -40.4%;
	left: 28.4%;
	animation: tiaodong 1.1s;
}
.yinfu10{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -36.7%;
	left: 30%;
	animation: tiaodong 1.1s;
}
.yinfu11{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -33%;
	left: 31.6%;
	animation: tiaodong 1.1s;
}
.yinfu12{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -29.3%;
	left: 33.2%;
	animation: tiaodong 1.1s;
}
.yinfu13{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -25.6%;
	left: 34.8%;
	animation: tiaodong 1.1s;
}
.yinfu14{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -21.9%;
	left: 36.4%;
	animation: tiaodong 1.1s;
}
.yinfu15{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -18.2%;
	left: 38%;
	animation: tiaodong 1.1s;
}
.yinfu16{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -14.5%;
	left: 39.6%;
	animation: tiaodong 1.1s;
}
.yinfu17{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: -10.8%;
	left: 41.2%;
	animation: tiaodong 1.1s;
}
.yinfu18{
	width: 8%;
	height: 21.5%;
	position: absolute;
	bottom: -20%;
	left: 43%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu19{
	width: 8%;
	height: 21.5%;
	position: absolute;
	bottom: -15.5%;
	left: 44.65%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu20{
	width: 8%;
	height: 21.5%;
	position: absolute;
	bottom: -11%;
	left: 46.3%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu21{
	width: 8%;
	height: 21.5%;
	position: absolute;
	bottom: -6.5%;
	left: 47.95%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu22{
	width: 8%;
	height: 21.5%;
	position: absolute;
	bottom: -2%;
	left: 49.6%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu23{
	width: 8%;
	height: 21.5%;
	position: absolute;
	bottom: 2.5%;
	left: 51.25%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu24{
	width: 8%;
	height: 21.5%;
	position: absolute;
	bottom: 7%;
	left: 52.9%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu25{
	width: 8%;
	height: 21.5%;
	position: absolute;
	bottom: 11.5%;
	left: 54.55%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu26{
	width: 8%;
	height: 21.5%;
	position: absolute;
	bottom: 16%;
	left: 56.2%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu27{
	width: 8%;
	height: 21.5%;
	position: absolute;
	bottom: 20.5%;
	left: 57.85%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu28{
	width: 8%;
	height: 21.5%;
	position: absolute;
	bottom: 25%;
	left: 59.5%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu29{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: 31.5%;
	left: 46%;
	animation: tiaodong 1.1s;
}
.yinfu30{
	width: 8%;
	height: 20%;
	position: absolute;
	bottom: 36.2%;
	left: 47.65%;
	animation: tiaodong 1.1s;
}
.yinfu31{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 40.9%;
	left: 49.3%;
	animation: tiaodong 1.1s;
}
.yinfu32{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 45.6%;
	left: 50.95%;
	animation: tiaodong 1.1s;
}
.yinfu33{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 50.3%;
	left: 52.6%;
	animation: tiaodong 1.1s;
}
.yinfu34{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 55%;
	left: 54.25%;
	animation: tiaodong 1.1s;
}
.yinfu35{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 59.7%;
	left: 55.9%;
	animation: tiaodong 1.1s;
}
.yinfu36{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 64.4%;
	left: 57.55%;
	animation: tiaodong 1.1s;
}
.yinfu37{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 69.1%;
	left: 59.2%;
	animation: tiaodong 1.1s;
}
.yinfu38{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 73.8%;
	left: 60.85%;
	animation: tiaodong 1.1s;
}
.yinfu39{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 78.5%;
	left: 62.5%;
	animation: tiaodong 1.1s;
}
.yinfu40{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 66.5%;
	left: 64.15%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu41{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 71.2%;
	left: 65.8%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu42{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 75.9%;
	left: 67.45%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu43{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 80.6%;
	left: 69.1%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu44{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 85.3%;
	left: 70.75%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu45{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 90%;
	left: 72.4%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu46{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 94.7%;
	left: 74.05%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu47{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 99.4%;
	left: 75.7%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu48{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 104.1%;
	left: 77.35%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu49{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 108.8%;
	left: 79%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu50{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 113.5%;
	left: 80.65%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu51{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 118.2%;
	left: 82.3%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu52{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 122.9%;
	left: 83.95%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu53{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 127.6%;
	left: 85.6%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu54{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 99.4%;
	left: 87.25%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu55{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 104.1%;
	left: 88.9%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu56{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 108.8%;
	left: 90.55%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu57{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 113.5%;
	left: 92.2%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu58{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 118.2%;
	left: 93.85%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu59{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 122.9%;
	left: 95.5%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.yinfu60{
	width: 8%;
	height: 22.5%;
	position: absolute;
	bottom: 127.6%;
	left: 97.15%;
	transform: rotate(180deg);
	animation: tiaodong1 1.1s;
}
.title1{
	width: 100%;
	height: 100%;
	position: absolute;
	bottom: 61%;
	left: 90%;
}
.eight{
	width: 2.5%;
	height: 10%;
}
.title1 span{
	display: inline-block;
	color: #000000;
	font-size: 22px;
	transform: translateY(-5px);
}
.jing1{
	width: 1%;
	height: 20%;
	position: absolute;
	left: -0.3%;
	top: -55%;
	animation: tiaodong 1.1s;
}
.jing2{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 3.6%;
	top: -65%;
	animation: tiaodong 1.1s;
}
.jing3{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 5.6%;
	top: -69%;
	animation: tiaodong 1.1s;
}
.jing4{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 9.4%;
	top: -80%;
	animation: tiaodong 1.1s;
}
.jing5{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 11.4%;
	top: -86%;
	animation: tiaodong 1.1s;
}
.jing6{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 13.3%;
	top: -91%;
	animation: tiaodong 1.1s;
}
.jing7{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 17.1%;
	top: -102.6%;
	animation: tiaodong 1.1s;
}
.jing8{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 19%;
	top: -108%;
	animation: tiaodong 1.1s;
}
.jing9{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 22.7%;
	top: -120%;
	animation: tiaodong 1.1s;
}
.jing10{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 24.7%;
	top: -127%;
	animation: tiaodong 1.1s;
}
.jing11{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 26.7%;
	top: -132.6%;
	animation: tiaodong 1.1s;
}
.jing12{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 30.5%;
	top: -143.5%;
	animation: tiaodong 1.1s;
}
.jing13{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 31.7%;
	top: -133%;
	animation: tiaodong 1.1s;
}
.jing14{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 35.6%;
	top: -146%;
	animation: tiaodong 1.1s;
}
.jing15{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 36.2%;
	top: -210%;
	animation: tiaodong 1.1s;
}
.jing16{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 37.6%;
	top: -153%;
	animation: tiaodong 1.1s;
}
.jing17{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 38.15%;
	top: -216.1%;
	animation: tiaodong 1.1s;
}
.jing18{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 39.6%;
	top: -166%;
	animation: tiaodong 1.1s;
}
.jing19{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 40.15%;
	top: -226.8%;
	animation: tiaodong 1.1s;
}
.jing20{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 43.5%;
	top: -177%;
	animation: tiaodong 1.1s;
}
.jing21{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 44.1%;
	top: -242.5%;
	animation: tiaodong 1.1s;
}
.jing22{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 45.5%;
	top: -185%;
	animation: tiaodong 1.1s;
}
.jing23{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 46.1%;
	top: -247.6%;
	animation: tiaodong 1.1s;
}
.jing24{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 49.4%;
	top: -197%;
	animation: tiaodong 1.1s;
}
.jing25{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 50.1%;
	top: -263.2%;
	animation: tiaodong 1.1s;
}
.jing26{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 51.4%;
	top: -205%;
	animation: tiaodong 1.1s;
}
.jing27{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 51.96%;
	top: -270.1%;
	animation: tiaodong 1.1s;
}
.jing28{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 53.94%;
	top: -278%;
	animation: tiaodong 1.1s;
}
.jing29{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 56.8%;
	top: -273%;
	animation: tiaodong 1.1s;
}
.jing30{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 58.92%;
	top: -279%;
	animation: tiaodong 1.1s;
}
.jing31{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 62.7%;
	top: -292%;
	animation: tiaodong 1.1s;
}
.jing32{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 64.8%;
	top: -304%;
	animation: tiaodong 1.1s;
}
.jing33{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 66.8%;
	top: -312%;
	animation: tiaodong 1.1s;
}
.jing34{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 70.7%;
	top: -327%;
	animation: tiaodong 1.1s;
}
.jing35{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 72.6%;
	top: -333%;
	animation: tiaodong 1.1s;
}
.jing36{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 76.3%;
	top: -341%;
	animation: tiaodong 1.1s;
}
.jing37{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 78.5%;
	top: -354%;
	animation: tiaodong 1.1s;
}
.jing38{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 80.6%;
	top: -362%;
	animation: tiaodong 1.1s;
}
.jing39{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 84.2%;
	top: -323%;
	animation: tiaodong 1.1s;
}
.jing40{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 86.4%;
	top: -333%;
	animation: tiaodong 1.1s;
}
.jing41{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 90.4%;
	top: -348%;
	animation: tiaodong 1.1s;
}
.jing42{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 92.3%;
	top: -357%;
	animation: tiaodong 1.1s;
}
.jing43{
	width: 1%;
	height: 20%;
	position: absolute;
	left: 94.3%;
	top: -365%;
	animation: tiaodong 1.1s;
}
</style>

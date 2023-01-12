import App from './App'
//引入封装的axios
import request from './lib/request.js'

// #ifndef VUE3
import Vue from 'vue'
Vue.config.productionTip = false
App.mpType = 'app'
const app = new Vue({
    ...App
})
app.$mount()
// #endif

// #ifdef VUE3
import { createSSRApp } from 'vue'
export function createApp() {
	const app = createSSRApp(App)
	//全局挂载axios
	app.config.globalProperties.$request = request 
	// app.config.globalProperties.$baseUrl = 'http://192.168.101.77:81'
	app.config.globalProperties.$baseUrl = 'http://testmusic.thedream.tech'
	// app.config.globalProperties.$baseUrl = 'http://music.thedream.tech'
	return {
		app
	}
}
// #endif
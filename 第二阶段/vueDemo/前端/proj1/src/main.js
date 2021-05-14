import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import axios from 'axios'
import qs from 'qs'


axios.defaults.baseURL="http://127.0.0.1:8080/"
axios.defaults.withCredentials = true
axios.interceptors.response.use(function (resp) {
	if(resp.data.returnCode==20000){
		console.log("拦截器输出： 没有登录")
		router.push("/login");
	}
    return resp;
}, function (error) {
    return Promise.reject(error);
});


Vue.prototype.$axios = axios
Vue.prototype.$qs = qs

Vue.config.productionTip = false



new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

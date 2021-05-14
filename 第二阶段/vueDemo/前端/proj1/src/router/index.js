import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/login.vue'
/*import Main from '../components/main.vue'
import Welcome from '../components/welcome/welcome.vue'
import Users from '../components/controlpanel/users.vue'
import Menus from '../components/controlpanel/menus.vue'*/

Vue.use(VueRouter)

const routes = [
	{path:'/',redirect:'/login'},
	{path:'/login',component:Login},
	/*{path:'/main',redirect:'/welcome',component:Main,
	      children:[
			  {path:'/welcome',component:Welcome},
			  {path:'/users',component:Users},
			  {path:'/menus',component:Menus}
		  ]}*/
]

const router = new VueRouter({
  routes
})

export default router

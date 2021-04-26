# vue脚手架

## 1.vue脚手架作用

前端开发需要的库文件很多，经常让前端工程的文件结构杂乱无章，并且容易产生代码重复，与工程化思维背道而驰，为了解决这个问题，通常使用webpack等项目构建工具，对使代码格式更规整，并且在js不断演化过程中出现了一些新语法方便编程，但是有一些语法浏览器并没有完全支持，所以出现了babel这种语法转换工具，把语法转换为浏览器可执行的语法。还有其他很多的一些工具，如果由开发人员手动安装、配置，很容易让项目文件结构变得混乱，难于配合。

由此产生的一系列问题，需要**一套工程化，格式化的处理方案**，就是**脚手架**，脚手架可以认为是一个工具集合，把常用的工具都集成起来，方便使用，并且使用工程化、模块化的思维，把文件存放的地址也进行了标准化，让开发人员开发时，文件、语法格式等都有章可循，那么项目开发过程中，多人配合时，代码结构与代码的可读性都会大幅提高。

此外脚手架基于node.js配置了Web服务器，及一些相关解析工具，利用npm（node包管理工具），可以非常方便的下载没有集成进去的额外的工具和包，对开发非常便利。

vue的脚手架便是把跟vue开发相关的一系列工具，以脚手架的方式整合起来，方便通过vue开发前端应用程序，其他前端框架也有对应的脚手架。

## 2.安装

##### 2.1安装node和npm

一系列工具都是基于node.js，所以首先需要安装node.js,node的包管理工具npm会随node安装包一起安装。

官网地址：https://nodejs.org/zh-cn/

![image-20201116095802432](.\image-20201116095802432.png)

安装完成后，需要修改npm下载路径（服务器在国外 速度较慢） 改为淘宝镜像（国内镜像服务器 速度快）

##### 2.2配置npm服务器地址（运行cmd 再在命令行输入）

临时使用
npm --registry https://registry.npm.taobao.org install express

永久使用 直接配置
npm config set registry https://registry.npm.taobao.org

通过如下命令可以查看是否配置成功
npm config get registry
npm info express

如果需要恢复成原来的官方地址只需要执行如下命令:
npm config set registry https://registry.npmjs.org

##### 2.3安装vue脚手架

通过npm命令 安装vue脚手架

npm install -g @vue/cli

等待安装完成，需要时间较长 安装完成后可以通过命令行检查是否安装完成

vue -V 查看vue版本

##### 2.4创建vue项目

安装完成后，可以使用vue脚手架创建项目结构

vue ui     vue图形界面（功能强大 操作方便）

（vue create my-project  命令行创建）

##### 2.5启动图形界面创建

![image-20201116102110467](image-20201116102110467.png)

vue图形界面包括创建项目、安装依赖、安装插件、运行控制台等功能，可以方便的进行相关控制

进入图形界面项目管理器 可以创建vue项目

![image-20201116102554694](image-20201116102554694.png)

![image-20201116102700098](image-20201116102700098.png)

![image-20201116102821323](image-20201116102821323.png)

![image-20201116102915125](image-20201116102915125.png)

手动配置时注意选项：

router（路由）勾上

linter（语法检测）取消勾选

使用配置文件    勾上

![image-20201116103116577](image-20201116103116577.png)

![image-20201116103213574](image-20201116103213574.png)

![image-20201116103426199](image-20201116103426199.png)

点击创建项目 控制台进行创建 （脚手架创建的项目为独立运行项目，会把node依赖的相关环境也现在，需要等待一会）

![image-20201116103537378](image-20201116103537378.png)

##### 2.6安装插件和依赖

开发vue项目时 还需要安装在项目中使用的一些额外的包，分别有插件和依赖

创建完成后到项目仪表盘 

安装elementUI插件

vue-cli-plugin-element

安装使用的依赖

axios    qs  

2.7启动服务

![image-20201116105246428](image-20201116105246428.png)

## 3.导入vue项目到编辑工具

vue项目目录结构如下

<img src="image-20201116105818927.png" alt="image-20201116105818927" style="zoom: 67%;" />

其中 node相关依赖环境文件 一般不需要操作

public中为单页面应用的唯一页面

src为模块化之后的各个模块的代码 使用高级语法导入到单页面中

编码时主要编写src中的内容

增加配置文件 修改启动端口

**<u>vue.config.js</u>**

```javascript
module.exports = {
  devServer: {
    port: 8088, // 端口
  }
}
```



## 4.整理项目结构

项目中有几个示例用的欢迎文件，可以删掉，并把自己的页面配置在路由中

删掉helloword等示例文件

**<u>main.js</u>**为项目根配置文件，之后有全局配置的参数 可以配置到此文件中

```javascript
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
//导入axios组件  qs组件
import axios from 'axios'
import qs from 'qs'

/*为axios配置全局参数*/
//服务器路径
axios.defaults.baseURL="http://127.0.0.1:8080/"
//跨域带cookie
axios.defaults.withCredentials = true
//响应拦截器 统一处理响应数据
axios.interceptors.response.use(function (resp) {
	if(resp.data.returnCode==20000){
         //如果服务器响应码是20000的话 通过路由跳转到登录组件
		console.log("拦截器输出： 没有登录")
		router.push("/login");
	}
    return resp;
}, function (error) {
    return Promise.reject(error);
});

/*为了操作方便 将axios组件扩展到vue对象上  （可选） 
之后在别的地方调用axios时 可以通过vue对象调用axios对象   this.$axios.xxx*/
Vue.prototype.$axios = axios
Vue.prototype.$qs = qs

Vue.config.productionTip = false



new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

```





**<u>app.vue</u>**为根组件 不需要的代码删掉 保留如下结构  在div中加入router-view作为路由占位符

<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>
<script>
export default {
  name: 'app'
}
</script>



**<u>index.js</u>**为路由配置文件 路由组件为vue中单页面替换组件显示内容的工具，作用为替换div中的内容 所以需要router-view作为需要切换div的位置，再通过配置文件 把地址与要显示的组件关联，再显示到对应的router-view中

```javascript
import Vue from 'vue'
import VueRouter from 'vue-router'
import Testpage from '../components/testpage.vue'

Vue.use(VueRouter)

const routes = [
	{path: '/testpage',component: Testpage}
]

const router = new VueRouter({
	routes
})

export default router
```

**<u>testpage.vue</u>**为自定义的组件  中间包含

template标签 用来编辑html代码

script标签       用来编辑js代码

style标签        用来编辑css代码

```vue
<template>
	<div>
		hello 这是我的页面
	</div>
	
</template>

<script>
</script>

<style>
</style>
```



使用组件，配合路由，在单页面环境下完成内容的切换，达到传统多页面的效果

## 5.将之前编写的登录页面与动态菜单导入到当前vue环境

页面部分转为.vue结构 把相应位置文件放入相应的标签（注意 如果有同级组件，需要在template中增加一个div 让同级组件在同一个标签下）

login.vue

```vue
<template>
	
		<el-card class="box-card mydiv">
		  <div slot="header" class="clearfix">
		    <span>登录</span>
		  </div>
		  <div class="text item">
		    <el-form ref="ruleForm" :model="myform" :rules="myroles"  label-width="80px" hide-required-asterisk>
		      <el-form-item label="用户名" prop="username">
		        <el-input v-model="myform.username" suffix-icon="el-icon-user" ></el-input>
		      </el-form-item>
			  <el-form-item label="密码" prop="pwd"> 
			    <el-input v-model="myform.pwd" suffix-icon="el-icon-lock" type="password" show-password></el-input>
			  </el-form-item>
	
		      <el-form-item>
		        <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
				<el-button @click="resetForm('ruleForm')">重置</el-button>
		        
		      </el-form-item>
		    </el-form>
		  </div>
		</el-card>
		
	
</template>

<script>
	export default {
		data(){
			return {
				myform:{
					username:'',
					pwd:''
				},
				myroles:{
					pwd:[
						{ required: true, message: '请输入活动名称', trigger: 'blur' },
						{ min: 6, max: 8, message: '长度在 6 到 8 个字符', trigger: 'blur' }
					]
				}
			}
		},
		methods:{
			submitForm(formName) {
			        this.$refs[formName].validate((valid) => {
			          if (valid) {
			            //alert('submit!');
						this.$axios.post('login', this.$qs.stringify(this.myform))
						.then(response=>{
							    console.log(response);
								if(response.data.returnCode==10000){
									this.$router.push('/main');
									//location.href="main.html";
								}else{
									this.$message.error(response.data.returnMsg);
								}
						}).catch(function (error) {
						    console.log(error);
							this.$message.error("net error!!");
						});
						
			          } else {
			            console.log('error submit!!');
			            return false;
			          }
			        });
			      },
			resetForm(formName) {
			    this.$refs[formName].resetFields();
			}
		}
	}
</script>

<style scoped="scoped">
	.el-input{
		width: 90%;
	}
	.text {
	    font-size: 14px;
	  }
	
	  .item {
	    margin-bottom: 18px;
	  }

	  .clearfix:before,
	  .clearfix:after {
	    display: table;
	    content: "";
	  }
	  .clearfix:after {
	    clear: both
	  }
	
	  .box-card {
	    width: 480px;
	  }
	  .mydiv{
		  margin: 200px auto;
	  }
		
	.wrongmsg{
		color: #F56C6C;
		font-size: 12px;
		padding-left: 20px;
	}
</style>

```

main.vue

```vue
<template>
	<el-container>
		<el-header height="100px">
			xxxxx管理系統
			<el-dropdown @command="handleCommand">
				<el-button type="primary">
					用户操作<i class="el-icon-arrow-down el-icon--right"></i>
				</el-button>
				<el-dropdown-menu slot="dropdown">
					<el-dropdown-item>修改密码</el-dropdown-item>
					<el-dropdown-item command="logout">退出</el-dropdown-item>
				</el-dropdown-menu>
			</el-dropdown>
		</el-header>
		<el-container>
			<el-aside width="200px">
				<el-row class="tac">
					<el-col :span="24">
						<el-menu class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" background-color="#545c64"
						 text-color="#fff" active-text-color="#ffd04b" unique-opened :router="true">
							<el-submenu :index="menu.menuid.toString()" :key="menu.menuid" v-for="(menu,indexo) in menus">
								<template slot="title">
									<i :class="menu.glyphicon"></i>
									<span>{{menu.menuname}}</span>
								</template>
								<el-menu-item-group v-for="(sub,index) in menu.submenu" :key="sub.menuid">
									<el-menu-item :index="sub.menuurl">{{sub.menuname}}</el-menu-item>
								</el-menu-item-group>
							</el-submenu>
						</el-menu>
					</el-col>
				</el-row>


			</el-aside>
			<el-main>
				<div id="mymain">
					<router-view></router-view>
				</div>

			</el-main>
		</el-container>
	</el-container>
</template>

<script>
	export default {
		data() {
			return {
				menus: [{
						menuname: "用戶管理",
						menuid: "11",
						submenu: [{
							menuname: "用户表",
							menuid: "11001",
							menuurl: "user1.html"
						}, {
							menuname: "权限管理",
							menuid: "11002"
						}]
					},
					{
						menuname: "訂單管理",
						menuid: "12",
						submenu: [{
							menuname: "主订单",
							menuid: "12001",
							menuurl: "order1.html"
						}, {
							menuname: "子订单",
							menuid: "12002"
						}]
					},
				]
			}
		},
		methods: {
			handleCommand(command) {
				if (command == 'logout') {
					this.$axios.get('http://127.0.0.1:8080/logout')
						.then(response => {
							console.log(response);
							this.$router.push("/login");
						}).catch(function(error) {
							console.log(error);
						});

				}
			},
			handleOpen(key, keyPath) {
				console.log(key, keyPath);
			},
			handleClose(key, keyPath) {
				console.log(key, keyPath);
			}
		},
		created() {

			this.$axios.get('http://127.0.0.1:8080/getmenu')
				.then(response => {
					console.log(response);

					this.menus = response.data.returnData;
				}).catch(function(error) {
					console.log(error);
				});

		}
	}
</script>

<style>
	html,
	body {
		height: 100%;
		margin: 0px;
	}

	.el-header,
	.el-footer {
		background-color: #B3C0D1;
		color: #333;
		text-align: center;
		line-height: 100px;
	}

	.el-dropdown {
		float: right;
	}

	.el-aside {
		background-color: #D3DCE6;
		color: #333;
		text-align: left;
		line-height: 200px;
	}

	.el-main {
		background-color: #E9EEF3;
		color: #333;
	}

	.el-container:nth-child(5) .el-aside,
	.el-container:nth-child(6) .el-aside {
		line-height: 260px;
	}

	.el-container:nth-child(7) .el-aside {
		line-height: 320px;
	}

	#base {
		height: 100%;
	}

	.el-container {
		height: 100%;
	}

	a {
		text-decoration: none;
		color: white;
	}

	.el-submenu {
		text-align: left;
	}

	ul.el-menu-vertical-demo.el-menu {
		border-right: none;
	}
</style>

```



增加路由配置

```javascript
import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/login.vue'
/*在路由中先导入需要显示的组件
import Main from '../components/main.vue'
import Welcome from '../components/welcome/welcome.vue'
import Users from '../components/controlpanel/users.vue'
import Menus from '../components/controlpanel/menus.vue'*/

Vue.use(VueRouter)

const routes = [
	{path:'/',redirect:'/login'},
	{path:'/login',component:Login},
	/*再在路由规则中 把指定的路径和组件配对
	   redirect为重定向
       children 为子路由 即在当前组件页面中 还需要有div切换，可以再增加router-view 配合子路由进行切换 

	{path:'/main',redirect:'/welcome',component:Main,
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

```

继续编写其他功能即可。


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

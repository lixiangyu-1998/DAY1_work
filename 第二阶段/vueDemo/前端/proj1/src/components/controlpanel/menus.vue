<template>
	<div>
		<el-form :inline="true" ref="myForm" class="demo-form-inline">
			<el-form-item label="菜单名称">
				<el-input v-model="qmname" placeholder="菜单名称"></el-input>
			</el-form-item>
			<el-form-item label="父菜单">
				<el-select v-model="qpid" placeholder="父菜单">
					<el-option label="无" :value="0"></el-option>
					<el-option v-for="option in options" :label="option.menuname" :value="option.menuid"></el-option>

				</el-select>
			</el-form-item>
			<el-form-item>
				<el-button type="warning" plain @click="queryMenu">查询</el-button>
				<el-button @click="resetForm('myForm')">重置</el-button>
				<el-button type="success" plain @click="openAddDialog">添加</el-button>
				<el-button type="primary" plain :disabled="btnStatus" @click="editDialog = true">修改</el-button>
				<el-button type="danger" plain :disabled="btnStatus" @click="removerow">删除</el-button>

			</el-form-item>
		</el-form>

		<template>
			<el-table :data="tableData" highlight-current-row @current-change="handleCurrentChange" style="width: 100%">
				<el-table-column prop="menuid" label="菜单编号" width="180">
				</el-table-column>
				<el-table-column prop="menuname" label="菜单名称" width="180">
				</el-table-column>
				<el-table-column prop="menuurl" label="地址">
				</el-table-column>
				<el-table-column prop="pid" label="父菜单" v-if="false">
				</el-table-column>
				<el-table-column prop="pname" label="父菜单名称">
				</el-table-column>
				<el-table-column prop="glyphicon" label="图标">
					<template v-slot="ttttt">
						<i :class="ttttt.row.glyphicon"></i>
						{{ttttt.row.glyphicon}}
					</template>
				</el-table-column>
			</el-table>
		</template>
		<el-pagination @size-change="handleSizeChange" @current-change="handlePageChange" :current-page="page" :page-sizes="[10, 20, 30]"
		 :page-size="pagesize" layout="total, sizes, prev, pager, next, jumper" :total="total">
		</el-pagination>



		<el-dialog title="添加" :visible.sync="addDialog">
			<el-form ref="addform" :model="addform">
				<el-form-item label="菜单编号" :label-width="formLabelWidth" prop="menuid">
					<el-input v-model="addform.menuid" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="菜单名称" :label-width="formLabelWidth" prop="menuname">
					<el-input v-model="addform.menuname" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="菜单URL" :label-width="formLabelWidth" prop="menuurl">
					<el-input v-model="addform.menuurl" autocomplete="off"></el-input>
				</el-form-item>

				<el-form-item label="父菜单" :label-width="formLabelWidth" prop="pid">
					<el-select v-model="addform.pid" placeholder="父菜单">
						<el-option label="无" :value="0"></el-option>
						<el-option v-for="option in options" :label="option.menuname" :value="option.menuid"></el-option>
					</el-select>
				</el-form-item>

				<el-form-item label="菜单图标" :label-width="formLabelWidth" prop="glyphicon">
					<el-input v-model="addform.glyphicon" autocomplete="off"></el-input>
				</el-form-item>

			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="addDialog = false">取 消</el-button>
				<el-button type="primary" @click="addsubmit">确 定</el-button>
			</div>
		</el-dialog>

		<el-dialog title="修改" :visible.sync="editDialog">
			<el-form :model="editform">
				<el-form-item label="菜单编号" :label-width="formLabelWidth">
					<el-input v-model="editform.menuid" :disabled="true" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="菜单名称" :label-width="formLabelWidth">
					<el-input v-model="editform.menuname" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="菜单URL" :label-width="formLabelWidth">
					<el-input v-model="editform.menuurl" autocomplete="off"></el-input>
				</el-form-item>

				<el-form-item label="父菜单" :label-width="formLabelWidth">
					<el-select v-model="editform.pid" placeholder="父菜单">
						<el-option label="无" :value="0"></el-option>
						<el-option v-for="option in options" :label="option.menuname" :value="option.menuid"></el-option>
					</el-select>
				</el-form-item>

				<el-form-item label="菜单图标" :label-width="formLabelWidth">
					<el-input v-model="editform.glyphicon" autocomplete="off"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="editDialog = false">取 消</el-button>
				<el-button type="primary" @click="editsubmit">确 定</el-button>
			</div>
		</el-dialog>
	</div>
</template>

<script>
	export default {

		data() {
			return {
				tableData: [],
				options: [{
					"text": "无",
					"val": 0
				}, {
					"text": "权限管理",
					"val": 11
				}],
				page: 1,
				total: 1,
				pagesize: 3,
				qmname: "",
				param: "",
				qpid: "",
				btnStatus: true,
				addDialog: false,
				editDialog: false,
				formLabelWidth: '120px',
				addform: {
					glyphicon: "",
					menuid: "",
					menuname: "",
					menuurl: "",
					pid: ""
				},
				editform: {
					glyphicon: "",
					menuid: "",
					menuname: "",
					menuurl: "",
					pid: ""
				}
			}
		},
		methods: {
			handleOpen(key, keyPath) {
				console.log(key, keyPath);
			},
			handleClose(key, keyPath) {
				console.log(key, keyPath);
			},
			handleCurrentChange(val) {
				//console.log(val);
				this.currentRow = val;
				this.btnStatus = false;
				//table数据改变 会触发handleCurrentChange 避免给editform赋空值
				if (val != null) {
					this.editform = JSON.parse(JSON.stringify(val));
				}

			},
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);
				this.pagesize = val;
				this.page = 1;
				var param = "dowhat=query&qmname=" + this.qmname + "&qpid=" + this.qpid + "&page=" + this.page + "&pagesize=" + val;
				this.myquery(param);
			},
			handlePageChange(val) {
				console.log(`当前页: ${val}`);
				var param = "qmname=" + this.qmname + "&qpid=" + this.qpid + "&page=" + val + "&pagesize=" + this.pagesize;
				this.myquery(param);
			},
			queryMenu() {
				console.log("query");
				this.myquery("qmname=" + this.qmname + "&qpid=" + this.qpid);
			},
			resetForm(formName) {
				this.qmname = "";
				this.qpid = "";
			},
			openAddDialog(){
				this.addDialog = true;
				//清空添加form
				this.$nextTick(function(){
					this.$refs['addform'].resetFields();
				})
				
			},
			addsubmit() {

				this.addDialog = false;
				var path = "menu/add"
				var param = this.$qs.stringify(this.addform);
				console.log(param);
				this.cud(path, param);
			},
			editsubmit() {
				this.editDialog = false;
				var path = "menu/edit"
				var param = this.$qs.stringify(this.editform);
				console.log(param);
				this.cud(path, param);
			},
			removerow() {
				this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					var path = "menu/remove"
					var param = "menuid=" + this.currentRow.menuid;
					console.log(param);
					this.cud(path, param);
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					});
				});
			},
			getmenu() {
				//页面首次查询
				this.$axios.get('getmenu')
					.then(response => {
						console.log(response);
						this.menus = response.data.returnData;

					}).catch(function(error) {
						console.log(error);
					});
			},
			cud(path, param) {
				this.$axios.get(path + "?" + param)
					.then(response => {
						console.log(response);
						if (response.data.returnCode == 10000) {
							this.$message({
								type: 'success',
								message: response.data.returnMsg
							});
							//执行成功cud后 重新查询数据
							var qparam = "qmname=" + this.qmname + "&qpid=" + this.qpid + "&page=" + this.page + "&pagesize=" +
								this.pagesize;
							this.myquery(qparam);

						} else {
							this.$message({
								type: 'error',
								message: response.data.returnMsg
							});
						}

					}).catch(function(error) {
						console.log(error);
					});
			},
			myquery(param) {
				this.$axios.get('menu/query?' + param)
					.then(response => {
						console.log(response);
						this.tableData = response.data.returnData;
						this.page = response.data.pageinfo.page;
						this.pagesize = response.data.pageinfo.pagesize;
						this.total = response.data.pageinfo.total;
					}).catch(function(error) {
						console.log(error);
					});

				//查询时 重新获取下拉菜单内容
				this.$axios.get('menu/getmenuselect')
					.then(response => {
						console.log(response);
						this.options = response.data.returnData;
					}).catch(function(error) {
						console.log(error);
					});
			}
		},
		created() {
			this.getmenu();
			this.myquery("");
		},
		watch: {
			tableData: function() {
				console.log("更新了数据")
				this.$nextTick(function() {

					this.btnStatus = true;
				})

			}
		}

	}
</script>

<style>
</style>

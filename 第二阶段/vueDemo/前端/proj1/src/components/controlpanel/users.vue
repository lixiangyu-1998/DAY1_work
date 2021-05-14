<template>
	<div>
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{}">管理中心</el-breadcrumb-item>
			<el-breadcrumb-item>用户管理</el-breadcrumb-item>
		</el-breadcrumb>
		<br />

		<el-form ref="queryForm" :inline="true" :model="queryForm" class="demo-form-inline">
			<el-form-item label="用户id" prop="uid">
				<el-input v-model="queryForm.uid" placeholder="用户id"></el-input>
			</el-form-item>
			<el-form-item label="用户名" prop="uname">
				<el-input v-model="queryForm.uname" placeholder="用户名"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="myQuery">查询</el-button>
				<el-button @click="resetForm('queryForm')">重置</el-button>
				<el-button type="success" @click="openAddForm">新增</el-button>
				<el-button type="warning" :disabled="disBtn" @click="openEditForm">修改</el-button>
				<el-button type="danger" :disabled="disBtn" @click="openDelForm">删除</el-button>
				<el-button type="info" :disabled="disBtn" @click="openAuthForm">授权</el-button>
			</el-form-item>
		</el-form>
		<el-table ref="singleTable" :data="tableData" highlight-current-row @current-change="handleRowchange" style="width: 100%">
			<el-table-column property="uid" label="用户id" width="100">
			</el-table-column>
			<el-table-column property="userName" label="用户姓名" width="150">
			</el-table-column>
			<el-table-column property="isValid" label="是否可用" width="100">
				<template slot-scope="scope">
					<el-tag :type="scope.row.isValid == '1' ? 'primary' : 'danger'" disable-transitions>{{scope.row.isValid==1?'可用':'不可用'}}</el-tag>
				</template>

			</el-table-column>
			<el-table-column property="regTime" label="注册时间" :formatter="dateFormat" width="180">
			</el-table-column>
			<el-table-column property="loginTime" label="最后登录时间" :formatter="dateFormat" width="180">
			</el-table-column>
			<el-table-column property="createUname" label="创建人">
			</el-table-column>
			<el-table-column property="headImg" label="头像">
				<template slot-scope="scope">
					<img :src="scope.row.headImg" />
				</template>
			</el-table-column>
			<el-table-column property="remark" label="备注">
			</el-table-column>
		</el-table>

		<div class="block">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :page-sizes="[3, 5, 10, 20]"
			 :page-size="3" layout="total, sizes, prev, pager, next, jumper" :total="pageinfo.total">
			</el-pagination>
		</div>

		<el-dialog title="添加" :visible.sync="addFormVisable" width="40%">
			<el-form ref="addForm" :model="addform" label-width="80px" hide-required-asterisk>
				<el-form-item label="用户id" prop="uid">
					<el-input v-model="addform.uid"></el-input>
				</el-form-item>
				<el-form-item label="用户名" prop="userName">
					<el-input v-model="addform.userName"></el-input>
				</el-form-item>
				<el-form-item label="是否可用" prop="isValid">
					<el-select v-model="addform.isValid" placeholder="请选择">
						<el-option label="可用" :value="1">
						</el-option>
						<el-option label="不可用" :value="2">
						</el-option>
					</el-select>

				</el-form-item>
				<el-form-item label="头像" prop="headImg">
					<el-upload class="avatar-uploader" 
					action=""
					:http-request="myupload"
					:show-file-list="false"
					 :before-upload="beforeAvatarUpload"
					 name="myfile">
						<img v-if="addform.headImg" :src="addform.headImg" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>

				</el-form-item>
				<el-form-item label="备注" prop="remark">
					<el-input v-model="addform.remark" type="textarea"></el-input>
				</el-form-item>

				<el-form-item>
					<el-button type="primary" @click="addFromSubmit">提交</el-button>
					<el-button @click="resetForm('addForm')">重置</el-button>

				</el-form-item>
			</el-form>
		</el-dialog>
		
		<el-dialog title="修改" :visible.sync="editFormVisable" width="40%">
			<el-form ref="editForm" :model="editform" label-width="80px" hide-required-asterisk>
				<el-form-item label="用户id" prop="uid">
					<el-input v-model="editform.uid"></el-input>
				</el-form-item>
				<el-form-item label="用户名" prop="userName">
					<el-input v-model="editform.userName"></el-input>
				</el-form-item>
				<el-form-item label="是否可用" prop="isValid">
					<el-select v-model="editform.isValid" placeholder="请选择">
						<el-option label="可用" :value="1">
						</el-option>
						<el-option label="不可用" :value="2">
						</el-option>
					</el-select>
		
				</el-form-item>
				<el-form-item label="头像" prop="headImg">
					<el-upload class="avatar-uploader" 
					action=""
					:http-request="myupload2"
					:show-file-list="false"
					 :before-upload="beforeAvatarUpload"
					 name="myfile">
						<img v-if="editform.headImg" :src="editform.headImg" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
		
				</el-form-item>
				<el-form-item label="备注" prop="remark">
					<el-input v-model="editform.remark" type="textarea"></el-input>
				</el-form-item>
		
				<el-form-item>
					<el-button type="primary" @click="editFromSubmit">提交</el-button>
					<el-button @click="resetForm('editForm')">重置</el-button>
		
				</el-form-item>
			</el-form>
		</el-dialog>
		
		<el-dialog title="授权" :visible.sync="authFormVisable" width="40%">
			<el-form ref="authForm" :model="authform" label-width="80px" hide-required-asterisk>
				<el-form-item label="用户id" prop="uid">
					<el-input v-model="authform.uid" readonly></el-input>
				</el-form-item>
				<el-tree
				  :data="authdata"
				  show-checkbox
				  ref="authtree"
				  node-key="menuid"
				  default-expand-all
				  :default-checked-keys="currntAuth"
				  :props="defaultProps">
				</el-tree>
		
				<el-form-item>
					<el-button type="primary" @click="authFromSubmit">提交</el-button>
					<el-button @click="resetAuthTree">重置</el-button>
		
				</el-form-item>
			</el-form>
		</el-dialog>

	</div>
</template>

<script>
	/* {"pageinfo":{"page":1,"pagesize":3},"returnCode":10000,"returnData":[{"createUid":9,"createUname":"测试1","isValid":0,"loginTime":1469444784000,"passWord":"e10adc3949ba59abbe56e057f20f883e","regTime":1469173099000,"remark":"","uid":3,"userName":"wangshaocheng"}],"returnMsg":"操作成功"} 
	{"createUid":9,"createUname":"测试1","headImg":"logo/user1.png","isValid":0,"loginTime":1469444784000,"passWord":"e10adc3949ba59abbe56e057f20f883e","regTime":1469173099000,"remark":"","uid":3,"userName":"wangshaocheng"}	*/
	import moment from 'moment'
	export default {
		data() {
			return {
				
				currntAuth:[],
				authform:{
					uid:''
				},
				authdata: [],
				defaultProps: {
				  children: 'submenu',
				  label: 'menuname'
				},
				
				
				disBtn:true,
				imageUrl:'',
				addFormVisable: false,
				editFormVisable: false,
				authFormVisable:false,
				addform: {
					headImg: '',
					isValid: '',
					remark: '',
					uid: '',
					userName: ''
				},
				editform: {
					headImg: '',
					isValid: '',
					remark: '',
					uid: '',
					userName: ''
				},
				pageinfo: {
					page: 1,
					pagesize: 3,
					total: 10
				},
				queryForm: {
					uid: '',
					uname: ''
				},
				tableData: [],
				currentRow: null
			}
		},

		methods: {
			authFromSubmit(){
				//获取menuid数组 转成字符串
				let menuid = this.$refs.authtree.getCheckedKeys().join(",");
				console.log(menuid);
				//拼接成键值对参数
				let param = "uid="+this.authform.uid+"&menuid="+menuid
				this.$axios.post("user/edituserauth",param)
				.then(resp=>{
					console.log(resp);
					this.$message.success(resp.data.returnMsg);
					this.authFormVisable = false;
					this.myQuery();
				}).catch(err=>{
					console.log(err);
				})
			},
			resetAuthTree(){
				this.$refs.authtree.setCheckedKeys(this.currntAuth);
			},
			//点击授权
			openAuthForm(){
				this.authFormVisable = true;
				if(this.currentRow){
					this.authform = JSON.parse(JSON.stringify(this.currentRow));
				}
				this.$axios.post("user/getauth","uid="+this.currentRow.uid)
				.then(resp=>{
					this.authdata = resp.data.returnData;
					this.currntAuth = resp.data.extData.split(",");
					//console.log(resp.data.extData.split(","));
				}).catch(err=>{
					console.log(err);
				})
				
			},
			//点击删除
			 openDelForm() {
			        this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
			          confirmButtonText: '确定',
			          cancelButtonText: '取消',
			          type: 'warning'
			        }).then(() => {
			          this.$axios.post("user/deluser","uid="+this.currentRow.uid)
			          .then(resp=>{
			          	console.log(resp);
			          	this.$message.success(resp.data.returnMsg);
			          	this.myQuery();
			          }).catch(err=>{
			          	console.log(err);
			          })
			        }).catch(() => {
			          this.$message({
			            type: 'info',
			            message: '已取消删除'
			          });          
			        });
			      },
			//点击提交修改
			openEditForm(){
				this.editFormVisable = true;
				if(this.currentRow){
					this.editform = JSON.parse(JSON.stringify(this.currentRow));
				}
				
			},
			//提交修改保存
			editFromSubmit(){
				console.log(this.editform)
				this.$axios.post("user/edituser",this.$qs.stringify(this.editform))
				.then(resp=>{
					console.log(resp);
					this.$message.success(resp.data.returnMsg);
					this.editFormVisable = false;
					this.myQuery();
				}).catch(err=>{
					console.log(err);
				})
			},
			
			//点击新增
			openAddForm(){
				this.addFormVisable = true;
				this.$nextTick(function(){
					this.resetForm('addForm');
				})
			},
			//提交新增
			addFromSubmit(){
				console.log(this.addform)
				this.$axios.post("user/adduser",this.$qs.stringify(this.addform))
				.then(resp=>{
					console.log(resp);
					this.$message.success(resp.data.returnMsg);
					this.addFormVisable = false;
					this.myQuery();
				}).catch(err=>{
					console.log(err);
				})
			},
			//变更当前行
			handleRowchange(val) {
				this.currentRow = val;
				this.disBtn = false;
				console.log(this.currentRow);
			},
			dateFormat(row, column) {
				var date = row[column.property];
				if (date === undefined) {
					return ''
				};
				return moment(date).format("YYYY-MM-DD HH:mm:ss")
			},
			myQuery() {
				this.$axios.get("user/query?" + this.$qs.stringify(this.queryForm) + "&" + this.$qs.stringify(this.pageinfo))
					.then(resp => {
						console.log(resp.data);
						this.tableData = resp.data.returnData;
						this.pageinfo = resp.data.pageinfo;
					}).catch(function(err) {
						console.log(err)
					})
			},
			resetForm(formName) {
				this.$refs[formName].resetFields();
			},
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);
				this.pageinfo.page = 1;
				this.pageinfo.pagesize = val;
				this.myQuery();
			},
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.pageinfo.page = val;
				this.myQuery();
			},
			//上传成功
			myupload(param) {
				let formData = new FormData();
				formData.append("myfile",param.file);
				this.$axios.post("upload",formData,{headers:{"Content-Type":"multipart/form-data"}})
				.then(resp=>{
					console.log(resp);
					this.addform.headImg = resp.data.imgsrc;
				})
			},
			myupload2(param) {
				let formData = new FormData();
				formData.append("myfile",param.file);
				this.$axios.post("upload",formData,{headers:{"Content-Type":"multipart/form-data"}})
				.then(resp=>{
					console.log(resp);
					this.editform.headImg = resp.data.imgsrc;
				})
			},
			//上传限制
			beforeAvatarUpload(file) {
				const isJPG = file.type === 'image/jpeg';
				const isPNG = file.type === 'image/png';
				const isLt2M = file.size / 1024 / 1024 < 2;

				if (!isJPG&&!isPNG) {
					this.$message.error('上传头像图片只能是 JPG/PNG 格式!');
				}
				if (!isLt2M) {
					this.$message.error('上传头像图片大小不能超过 2MB!');
				}
				return (isJPG||isPNG) && isLt2M;
			}
		},
		mounted() {
			this.myQuery();
		},
		watch:{
			tableData:function(){
				console.log("数据刷新了");
				this.$nextTick(function(){
					this.disBtn=true;
				})
				
			}
		}
	}
</script>

<style>
	img {
		width: 50px;
		height: 50px;
	}

	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>

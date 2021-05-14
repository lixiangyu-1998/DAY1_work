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

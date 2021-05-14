国内cdn加速服务
bootcdn
<script src="https://cdn.bootcdn.net/ajax/libs/vue/2.6.11/vue.min.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/element-ui/2.13.2/index.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/axios/0.19.2/axios.min.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/qs/6.9.4/qs.min.js"></script>
<script src="js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
<link href="https://cdn.bootcdn.net/ajax/libs/element-ui/2.13.2/theme-chalk/index.css" rel="stylesheet">



axios vue推荐的ajax组件

axios.post('提交地址', 提交参数)
.then(response=>{
		console.log(response);

}).catch(function (error) {
	console.log(error);
});

axios.get('提交地址')
.then(response => {
	console.log(response);


}).catch(function(error) {
	console.log(error);
});

window.Qs.stringify("将json拼成键值对")


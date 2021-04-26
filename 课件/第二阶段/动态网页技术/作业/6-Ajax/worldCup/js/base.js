function customShare(){
	//监听分享
	var link = location.href.split('#')[0];
	var shareUrl = "http://wx.10086.cn/xinjiang/activity_xjcj/wycjLogin/oauth";
	var img = "http://wx.10086.cn/xinjiang/activity_xjcj/chicken/images/xiang.png";
	var title = "西安世界杯!";
	var subhead = "一起踢球，赢取流量！";
	
	$.post("../wycjLogin/getJsSignature", {"url" : encodeURIComponent(link)}, function(obj) {
		console.log(obj.appid+"^^"+obj.timestamp+"^^"+obj.nonceStr+"^^"+obj.signature)
//		alert(obj.appid+"^^"+obj.timestamp+"^^"+obj.nonceStr+"^^"+obj.signature);
		wx.config({
		    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		    appId: obj.appid, // 必填，公众号的唯一标识
		    timestamp: obj.timestamp, // 必填，生成签名的时间戳
		    nonceStr: obj.nonceStr, // 必填，生成签名的随机串
		    signature: obj.signature,// 必填，签名，见附录1
		    jsApiList: ['onMenuShareTimeline','onMenuShareAppMessage','onMenuShareQQ','onMenuShareQZone'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
		});
		wx.ready(function(){
//			alert('wx.ready')
			wx.onMenuShareTimeline({
			    title: title, // 分享标题
			    link: shareUrl, // 分享链接
			    imgUrl: img, // 分享图标
			    desc : subhead,
			    success: shareSuccess,
			    cancel: shareCancel
			});
			wx.onMenuShareAppMessage({
			    title: title, // 分享标题
			    desc: subhead, // 分享描述
			    link: shareUrl, // 分享链接
			    imgUrl: img, // 分享图标			    
			    success: shareSuccess,
			    cancel: shareCancel
			});
			wx.onMenuShareQQ({
			    title: title, // 分享标题
			    desc: subhead, // 分享描述
			    link: shareUrl, // 分享链接
			    imgUrl: img, // 分享图标
			    success: shareSuccess,
			    cancel: shareCancel
			});
			wx.onMenuShareQZone({
				title: title, // 分享标题
			    desc: subhead, // 分享描述
			    link: shareUrl, // 分享链接
			    imgUrl: img, // 分享图标
			    success: shareSuccess,
			    cancel: shareCancel
			});
		});
}, "json");
}


function shareSuccess(){
	mui.ajax('../wycj/weChataAddTimes.do',{
		data:{
			taskId:taskId
		},
		dataType:'json',//服务器返回json格式数据
		type:'post',//HTTP请求类型  
//		async:false,
		success:function(data){
			//服务器返回响应，根据响应结果，分析是否登录成功；
			console.log(data)
			var returnCode = data.code
			switch(returnCode)
			{
				case "0":
					mui.alert(data.msg)
				  break;
				case "1":
					
				  break;
				case "-1":
					
				  break;
				case "-2":
					
				  break;
				case "-3":
					
				  break;
				case "00":
					mui.alert(data.msg) 
					  break;
				case "01":
					mui.alert(data.msg)
					  break;
				default:
				  mui.alert('网络错误，请重试！weChataAddTimes')
			}
		},
		error:function(xhr,type,errorThrown){
			//异常处理；
			console.log(type);
		}
	});
}
function shareCancel(){}
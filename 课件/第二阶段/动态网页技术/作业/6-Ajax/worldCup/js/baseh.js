var authToken = authToken || getParam("authToken");
function customShare(myshareurl,title,subhead) {
	//监听分享
	var link = location.href.split('#')[0];
	var shareUrl = myshareurl;
	var img = "http://wx.10086.cn/shXi/sxxa_worldcup/worldCup/img/icon-shared.png";
	var title = title;
	var subhead = subhead;

	$.post("../common/getJsSignature", {"url": encodeURIComponent(link)}, function(obj) {
		console.log(obj.appid + "^^" + obj.timestamp + "^^" + obj.nonceStr + "^^" + obj.signature)
		//		alert(obj.appid+"^^"+obj.timestamp+"^^"+obj.nonceStr+"^^"+obj.signature);
		wx.config({
			debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
			appId: obj.appid, // 必填，公众号的唯一标识
			timestamp: obj.timestamp, // 必填，生成签名的时间戳
			nonceStr: obj.nonceStr, // 必填，生成签名的随机串
			signature: obj.signature, // 必填，签名，见附录1
			jsApiList: ['onMenuShareTimeline', 'onMenuShareAppMessage', 'onMenuShareQQ', 'onMenuShareQZone'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
		});
		wx.ready(function() {
			//			alert('wx.ready')
			wx.onMenuShareTimeline({
				title: title, // 分享标题
				link: shareUrl, // 分享链接
				imgUrl: img, // 分享图标
				desc: subhead,
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

function shareSuccess() {
	//加次数
	mui.ajax('../hltq/addTimes',{
		data:{
			share_flag: 1
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
					
				  break;
				case "1":
//					location.href = 'http://wx.10086.cn/website/personalHome/new/index'
				  break;
				case "-2":
					  mui.alert(data.msg)
					  break;
				case "-1":
					  mui.alert(data.msg)
					  break;
				default:
				  mui.alert('网络错误，请重试！addTimes')
			}
		},
		error:function(xhr,type,errorThrown){
			//异常处理；
			console.log(type);
		}
	});
}

function shareCancel() {}

mui.init();
mui('.mui-scroll-wrapper').scroll({
	deceleration: 0.0005 //flick 减速系数，系数越大，滚动速度越慢，滚动距离越小，默认值0.0006
});

// 获取地址栏参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return escape(r[2]);
	return null;
}

//微信分享
function wxShare() {
	var shareHtml = '<div class="share-weixin-tips-content" style="opacity: 1; transition-property: all; transition-duration: 0s;"><div class="share-weixin-tips-arrow"></div><div class="share-weixin-tips">点击右上角<br>将它分享到朋友圈<br>或指定的朋友</div></div><div class="share-weixin-qrcode-bg" style="opacity: 0.7; transition-property: all; transition-duration: 0s;"></div>'
	$("body").append(shareHtml);
	$('.share-weixin-qrcode-bg').on('tap', function() {
		closews()
	})
}
//微信分享close
function closews() {
	$(".share-weixin-tips-content").remove();
	$(".share-weixin-qrcode-bg").remove();
};
//判断是否是微信浏览器的函数
function isWeiXin() {
	//window.navigator.userAgent属性包含了浏览器类型、版本、操作系统类型、浏览器引擎类型等信息，这个属性可以用来判断浏览器类型
	var ua = window.navigator.userAgent.toLowerCase();
	//通过正则表达式匹配ua中是否含有MicroMessenger字符串
	if(ua.match(/MicroMessenger/i) == 'micromessenger') {
		return true;
	} else {
		return false;
	}
}
if(!isWeiXin()) {
	// location.href = 'please.html'
}
//获取渠道类型
function getChannal() {
	var channal; //渠道
	if(navigator.userAgent.indexOf("10086APP") == -1) {
		if(isWeiXin()) {
			//在微信中执行
			channal = 0;
		} else {
			//其他
			channal = 2;
		}
	} else {
		//在10086app中执行
		channal = 1;
	}
	return channal;
}
//获取86app手机号
function getMobile() {
	var mobile = "";
	if(window.phone) {
		mobile = encodeURIComponent(window.phone.obtainPhone()); // 加密过的手机号
	}
	return mobile;
}

// APP分享
function share(appurl,apptitle,appsubhead) {	
	//alert(url+"   "+title+"   "+subhead);
	var u = navigator.userAgent,
	app = navigator.appVersion;
	var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1; //g
	var isIOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
	//var shareUrl = "http://wx.10086.cn/shanxi/sxmgr/auth/shareOauth?mobile="+id;		
	var str = '{"activityId":"711","type":0,"normaltem":{"id":-1,"name":"10086","title":"'+ apptitle +'","url":"' + appurl + '","content":"'+appsubhead+'"},"specialList":[]}';
	str = encodeURIComponent(str);
	//alert(str);
	if(isAndroid) {				
		window.g_share.clickOnAndroid(str);
	} else if(isIOS) {
		window.location.href = "ios://callShare?data="+str;
	}	 
}

//活动规则
//<div id="rules" class="mask">
//	<div class="layer tc">
//		<h3>活动规则</h3>
//		<div class="mui-scroll-wrapper scroll">
//			<div class="mui-scroll">
//				<p class="guize">1、活动时间：2018年4月12日-2018年4月22日</p>
//				<p class="guize">2、游戏规则介绍：点击开始游戏，点击屏幕中间位置即发射，在规定时间内每打中一只野鸡得1分，没有点中不得分。用户每天默认有一次游戏机会，返回个人主页增加一次游戏机会，分享到朋友圈增加两次游戏机会，每天最多有4次游戏机会！</p>
//				<p class="guize">3、活动仅限新疆移动客户参与，活动期间，需要持续订阅并绑定“中国移动10086”微信公众号，若取消订阅与绑定则无法发放奖品。</p>
//				<p class="guize">4、活动期间, 客户每日初始一次游戏机会,查询个人主页增加一次游戏机会,分享朋友圈增加二次游戏机会。客户每击中一只小鸡得1分。积分满70分兑换70M流量、100分兑换150M流量、500分兑换500M流量、1000分兑换1G流量。活动结束后，未兑换积分将不做保留，直接清零。</p>
//				<p class="guize">5、流量奖品将于5月20日前充值到账，届时会有短信提醒。如若20日后未收到流量到账提醒短信，请不要着急，我们会在2018年6月1日开始10个工作日内为您补充入绑定的手机号码中。</p>
//				<p class="guize">6、赠送的流量为国内流量，2/3/4G通用，当月有效，流量不结转至次月。</p>
//				<p class="guize">7、号码欠费、未进行实名制认证、处于非正常状态的用户，流量可能无法成功到帐。其中携号转网、集团用户暂时无法参与，流量无法到账。</p>
//				<p class="guize">8、对任何通过不正当手段参与者，中国移动有权在不事先通知的情况下取消其参加活动及得奖资格。</p>
//
//			</div>
//		</div>
//		<div class="know"></div>
//	</div>
//</div>

//loading
//<div id="loading" class="mask loadingw">
//    <div class="layer">
//    	<span class="mui-spinner mui-spinner-custom loading"></span>
//    </div>
//</div>

//一键检测
function jiance() {
	var class_name_android = "zz.dela.cmcc.traffic.activity.OneKeyCheckActivity";
	var class_name_ios = "OneKeyCheckoutController";
	var class_name_src = "kefu";
	window.g_service.clickServiceOnMobile(class_name_android, class_name_ios, class_name_src);
}

//套餐余量
function mealAllowance() {
	var class_name_android = "zz.dela.cmcc.traffic.activity.TaoCanYuLiangActivity";
	var class_name_ios = "MyPacketLeftController";
	var class_name_src = "kefu";
	window.g_service.clickServiceOnMobile(class_name_android, class_name_ios, class_name_src);
}

//话费账单
function billCharge() {
	var class_name_android = "zz.dela.cmcc.traffic.activity.DetailsPhoneActivity";
	var class_name_ios = "MyFeeDetailViewController";
	var class_name_src = "kefu";
	window.g_service.clickServiceOnMobile(class_name_android, class_name_ios, class_name_src);
}

//积分兑换
function scoreChange() {
	var class_name_android = "zz.dela.cmcc.traffic.activity.IntegralToTrafficActivity";
	var class_name_ios = "MyPointExchangeViewController";
	var class_name_src = "kefu";
	window.g_service.clickServiceOnMobile(class_name_android, class_name_ios, class_name_src);
}

//是否是移动手机号
function isPoneAvailable(phone) {
	var myreg = /^1(3[4-9]|5[012789]|8[23478]|4[7]|7[8])\d{8}$/;
	if(!myreg.test(phone)) {
		return false;
	} else {
		return true;
	}
}

//判断安卓还是ios A:安卓 I：ios Q: 其它
function isIosa() {
	var u = navigator.userAgent;
	var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1; //android终端
	var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
	if(isAndroid) {
		return "A";
	} else if(isiOS) {
		return "I";
	} else {
		return "Q";
	}
}

// 强制刷新
$(function() {
	var isPageHide = false;
	window.addEventListener('pageshow', function() {
		if(isPageHide) {
			window.location.reload();
		}
	});
	window.addEventListener('pagehide', function() {
		isPageHide = true;
	});
})

//下载10086app地址
//location.href = "http://dx.10086.cn/appqh1";

//返回个人主页
//location.href = 'http://wx.10086.cn/website/personalHome/new/index'

//获取渠道
var channal = getChannal()
//var channal = 1
if(channal != 0 && channal != 1) {
	//	location.href = "tips/please.html"
}

//获取手机号
//var mobile = '"'+ getMobile()+'"'
var mobile = getMobile()
//var mobile = '"'+"fIM1EZHegX6ZEwo5ICRzn4RwhEl%2BCnmm"+'"'
var mobile = "fIM1EZHegX6ZEwo5ICRzn4RwhEl%2BCnmm"

//手机摇一摇开始
function shake(func) {
	//运动事件监听
	if(window.DeviceMotionEvent) {
		window.addEventListener('devicemotion', deviceMotionHandler, false);
	} else {
		mui.alert('抱歉，您的手机不支持摇一摇，请手动点击此处！')
	}

	//获取加速度信息
	//通过监听上一步获取到的x, y, z 值在一定时间范围内的变化率，进行设备是否有进行晃动的判断。
	//而为了防止正常移动的误判，需要给该变化率设置一个合适的临界值。
	var SHAKE_THRESHOLD = 4000;
	var last_update = 0;
	var x, y, z, last_x = 0,
		last_y = 0,
		last_z = 0;

	function deviceMotionHandler(eventData) {
		var acceleration = eventData.accelerationIncludingGravity;
		var curTime = new Date().getTime();
		if((curTime - last_update) > 10) {
			var diffTime = curTime - last_update;
			last_update = curTime;
			x = acceleration.x;
			y = acceleration.y;
			z = acceleration.z;
			var speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;
			if(speed > SHAKE_THRESHOLD) {
				if(typeof func == 'function') {
					func()
				}
			}
			last_x = x;
			last_y = y;
			last_z = z;
		}
	}
}

//手机摇一摇结束

//ajax模板
// 		查询用户信息
//mui.ajax('/activity_xjssq/drawLot/getLotUserInfo.do',{
//	data:{
//		mobile:mobile
//	},
//	dataType:'json',//服务器返回json格式数据
//	type:'post',//HTTP请求类型  
////	async:false,
//	success:function(data){
//		//服务器返回响应，根据响应结果，分析是否登录成功；
//		console.log(data)
//		var returnCode = data.returnCode
//		switch(returnCode)
//		{
//			case "0":
//			
//			  break;
//			case "1":
//			  
//			  break;
//			default:
//			  mui.alert('网络错误，请重试！load')
//		}
//	},
//	error:function(xhr,type,errorThrown){
//		//异常处理；
//		console.log(type);
//	}
//});

//switch
//switch(prize_level) {
//
//	case "1":
//		var ming = "1G"
//		break;
//	case "2":
//		var ming = "500M"
//		break;
//	case "3":
//		var ming = "150M"
//		break;
//	case "4":
//		var ming = "70M"
//		break;
//	default:
//
//}

//$('#go').on('tap', function(){
//	sessionStorage.setItem("flg", 1);
//	location.href = 'goods.html'
//})
//var ssflag = sessionStorage.getItem("flg");
//if(ssflag == 1){
//	sessionStorage.setItem("flg", 0);
//	window.location.reload(); 
//}

//template模板
//<script id="templ" type="text/html">
//	{{each transport value i}}
//		
//	{{/each}}
//</script>

//$('#rongqi').html(template('templ', data))

//var throttled = _.throttle(common, 5000, {trailing: false});

//debugger;

// <body ondragstart="return false;" oncontextmenu="return false;">

// 禁止页面拖动
window.addEventListener('touchmove', function(e) {
	e.preventDefault();
})

/*document.body.ontouchstart = function(e) {
	e.preventDefault();
};*/

window.requestAnimFrame = (function() {
	return window.requestAnimationFrame ||
		window.webkitRequestAnimationFrame ||
		window.mozRequestAnimationFrame ||
		function(callback) {
			window.setTimeout(callback, 1000 / 60);
		};
})();

// location.reload();

//if(typeof headimgurl == "undefined"){
//	  
//}

//<img onerror="this.src='images/1.png'" src=""/>

//关闭分享弹框
$('#fenxiang').on('tap', function() {
	$(this).fadeOut()
})

//分享
//<div id="fenxiang" class="mask">
//	<div class="layer shares">
//		<img class="errow" src="images/errow.png"/>
//		<img class="errow bgdf" src="images/fen.png"/>
//		
//	</div>
//</div>

//gameTime = gameTime < 10 ? '0' + gameTime : gameTime

//是否为正整数
function isPositiveInteger(s) {
	var re = /^[0-9]+$/;
	return re.test(s)
}

//毫秒计时器
//var total = 500;
//var timer = null;

//var tiktock = document.getElementById('tiktock');
//var btn = document.getElementById('btn');

function countdown(){
    timer = setInterval(function(){
        total--;
        if (total<=0) {
            clearInterval(timer);
            tiktock.innerHTML= "0:00";
        }else{
            var ss = Math.floor(total/100);
            var ms = total-Math.floor(total/100)*100;
            tiktock.innerHTML=ss + ":" + ms;
        }
    },10);
};
//btn.addEventListener('click', countdown, false);
/** 
 * 获取指定的URL参数值 
 * URL:http://www.quwan.com/index?name=tyler 
 * 参数：paramName URL参数 
 * 调用方法:getParam("name") 
 * 返回值:tyler 
 */ 
function getParam(paramName) { 
    paramValue = "", isFound = !1; 
    if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) { 
        arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0; 
        while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++ 
    } 
    return paramValue == "" && (paramValue = null), paramValue 
} 



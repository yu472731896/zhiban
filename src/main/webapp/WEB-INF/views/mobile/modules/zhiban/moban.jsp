<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>智能陪伴，快乐成长</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<!--微信不缓存东西  start-->
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<!--微信不缓存东西  end-->
		<%@include file="/WEB-INF/views/include/head.jsp" %>
		<%@include file="/WEB-INF/views/include/zhibanHead.jsp" %>
	</head>

	<body class="bg_index">
		<div class="box_indexcontent">
			<!--公司-->
			<div class="top_nav">
				<svg class="icon" aria-hidden="true">
					<use xlink:href="#icon-mulu"></use>
				</svg>
				<span>${userInfo.entName}</span>
			
			</div>
			<!--个人信息-->
			<div class="info">
				<img class="head" src="${ctxStatic}/zhiban/img/head_default.png" />
				<p>郝斌</p>
				<p>${userInfo.entName}<br /> ${userInfo.position}</p>
				<p>${userInfo.titleInfo}</p>

				<div class="contact_info">
					<a class="contact_type" href="tel:13203509288">
						<svg class="icon" aria-hidden="true">
							<use xlink:href="#icon-dianhua"></use>
						</svg>
						${userInfo.phone}
					</a>
					<div class="contact_type">
						<svg class="icon" aria-hidden="true">
							<use xlink:href="#icon-weixin"></use>
						</svg>
						&nbsp;${userInfo.weixin}
						<button class="btn_add_wechat">加微信</button>
					</div>
				</div>
				
				<a href="${ctx}/f/core/login" >登陆我的名片</a>
				
				<!--浏览量-->
				<div class="view">
					<svg class="icon" aria-hidden="true">
						<use xlink:href="#icon-liulan"></use>
					</svg>
					<span>${userInfo.accessAmount}</span>
				</div>
				
				<!--音乐-->
				<div id="music" class="music play">
					<svg class="icon " aria-hidden="true">
						<use xlink:href="#icon-yinle"></use>
					</svg>
				</div>
				
			</div>
			<!--banner图-->
			<div class="banner_box">
				<div class="swiper-container" id="slide">
					<div class="swiper-wrapper">
					
					<!-- 循环遍历 -->
					<%-- <c:forEach items="${page.list}" var="baseEnt">
					
					</c:forEach> --%>
					
						<a class="swiper-slide" href="#" title="">
							<img src="${ctxStatic}/zhiban/img/banner_01.jpg" />
						</a>
						<a class="swiper-slide" href="#" title="">
							<img src="${ctxStatic}/zhiban/img/banner_01.jpg" />
						</a>
					</div>
					<div class="pagination" style="background:transparent;text-align:center;"></div>
				</div>
			</div>
			<!--关于智伴-->
			<div class="friendly_link_box">
				<p class="common_title">
					<img src="${ctxStatic}/zhiban/img/title_01.png" />
				</p>
				
				<!-- 循环遍历 -->

				<div class="friendly_link" onclick="window.location='http://jinghua.shequnpay.com/ChatRoomMsgUserNewNew.aspx?nRecID=2452737'">
					<svg class="icon friendlylink_icon" aria-hidden="true" style="background: #f9c10c;">
						<use xlink:href="#icon-jieshao"></use>
					</svg>
					<p>智伴介绍</p>
				</div>
				<div class="friendly_link" onclick="window.location='http://jinghua.shequnpay.com/ChatRoomMsgUserNewNew.aspx?nRecID=2222452'">
					<svg class="icon friendlylink_icon" aria-hidden="true" style="background: #fb5b99;">
						<use xlink:href="#icon-BAI-gongneng"></use>
					</svg>
					<p>智伴功能</p>
				</div>
				<div class="friendly_link" onclick="window.location='http://jinghua.shequnpay.com/ChatRoomMsgUserNewNew.aspx?nRecID=2452737'">
					<svg class="icon friendlylink_icon" aria-hidden="true" style="background: #eb7899;">
						<use xlink:href="#icon-shuoming"></use>
					</svg>
					<p>智伴操作说明</p>
				</div>
				<div class="friendly_link" onclick="window.location='http://jinghua.shequnpay.com/ChatRoomMsgUserNewNew.aspx?nRecID=2222452'">
					<svg class="icon friendlylink_icon" aria-hidden="true" style="background: #ff8d57;">
						<use xlink:href="#icon-shipinbofang"></use>
					</svg>
					<p>智伴官方视频</p>
				</div>
				<div class="friendly_link" onclick="window.location='http://jinghua.shequnpay.com/ChatRoomMsgUserNewNew.aspx?nRecID=2452737'">
					<svg class="icon friendlylink_icon" aria-hidden="true" style="background: #5ed2a5;">
						<use xlink:href="#icon-peixunfazhan"></use>
					</svg>
					<p>智伴讲堂</p>
				</div>
				<div class="friendly_link" onclick="window.location='http://jinghua.shequnpay.com/ChatRoomMsgUserNewNew.aspx?nRecID=2222452'">
					<svg class="icon friendlylink_icon" aria-hidden="true" style="background: #88a2f9;">
						<use xlink:href="#icon-icon--"></use>
					</svg>
					<p>智伴培训课堂</p>
				</div>
			</div>

			<!--资讯-->
			<div class="Magazine">
				<p class="common_title">
					<img src="${ctxStatic}/zhiban/img/title_02.png" />
				</p>
				<!--<div class="Magazine_type">
				</div>-->
				<ul class="Magazine_lists">
				<!-- 循环遍历 -->
				<c:forEach items="${newsList}" var="baseNews">
					<li class="news_box">
						<a href="${fctx}/core/mobileform?id=${baseNews.id}">
							<p class="nwes_title">${baseNews.title}</p></a>
						<img class="news_backcover" src="<c:out value="${baseNews.path}"/>"/>
						<%-- <img class="news_backcover" src="<c:out value="${fn:replace('${baseNews.path}', '|','')}"/>"/> --%>
					</li>
				</c:forEach>
				<p style="text-align:center;margin-top: 6px;"><a href="${fctx}/core/userNewsList" style="color:#fff">查看全部</a></p>
					 
				</ul>
			</div>
		</div>
		
		<!--侧栏用户页面--左滑显示-->
		<div class="sidebar_user">
			<div class="sidebar_user_info">
				<!--未登录-->
				<img class="head" src="${ctxStatic}/zhiban/img/head_default.png" />
				<p onclick="window.location='user_login.html'">登录</p>
				<!--登录-->
				<img class="head" src="${ctxStatic}/zhiban/img/head_default.png"/>
				<p>郝斌</p>
			</div>
			<ul class="slidebar_link">
				<li class="slidebar_link_mt" onclick="window.location='user_register.html'">
					<svg class="icon" aria-hidden="true">
						<use xlink:href="#icon-zhizuo"></use>
					</svg>
					<span>我要制作名片</span>
				</li>
				<li class="slidebar_link_mt" onclick="window.location='index.html'">
					<svg class="icon" aria-hidden="true">
						<use xlink:href="#icon-chengyuanyingyonchakanqi"></use>
					</svg>
					<span>查看我的名片</span>
				</li>
				<li class="slidebar_link_mt" onclick="window.location='Magazine_list.html'">
					<svg class="icon" aria-hidden="true">
						<use xlink:href="#icon-yijin04-guanyuwomen"></use>
					</svg>
					<span>关于智伴</span>
				</li>
				<li onclick="window.location='Magazine_list.html'">
					<svg class="icon" aria-hidden="true">
						<use xlink:href="#icon-zixun"></use>
					</svg>
					<span>查看全部资讯</span></li>
				<li class="slidebar_link_mt" onclick="window.location='feedback.html'">
					<svg class="icon" aria-hidden="true">
						<use xlink:href="#icon-yijianfankui"></use>
					</svg>
					<span>反馈建议</span>
				</li>
				<li>
					<svg class="icon" aria-hidden="true">
						<use xlink:href="#icon-fenxiang2"></use>
					</svg>
					<span>分享给好友</span>
				</li>
			</ul>
			<div class="sidebar_user_null"></div>
		</div>
		
		<!--底部-->
		<div class="footer">
			<svg class="icon goleft" aria-hidden="true">
				<use xlink:href="#icon-left"></use>
			</svg>
			<svg class="icon gomenu" aria-hidden="true">
				<use xlink:href="#icon-mulu"></use>
			</svg>
			<svg class="icon goshare" aria-hidden="true">
				<use xlink:href="#icon-fenxiang"></use>
			</svg>
			
		</div>
		<!--音乐-->
		<audio class="audio" autoplay="autoplay">
			<source src="${userInfo.musicFile }" type="audio/mp3" media="">
		</audio>
		
		<!--微信名片-->
		<div class="null_box"></div>
		<div class="wechat_box">
			<div class="code_box">
				<img class="code" src="${userInfo.weixinMa}" />
				<p>长摁识别加微信</p>
			</div>
			<svg class="icon icon_close" aria-hidden="true">
				<use xlink:href="#icon-close"></use>
			</svg>
		</div>

		<script type="text/javascript">
			$(document).ready(function() {
				//轮播
				var mySwiper = new Swiper('#slide', {
					autoplay: 3500,
					autoplayDisableOnInteraction: false,
					visibilityFullFit: true,
					loop: true,
					pagination: '.pagination',
					onSlideChangeStart: function() {
						var h = $(".swiper-slide-active").children().height() * $(".swiper-slide-active").children().length;
						$(".swiper-wrapper").css("height", h);
						$(".swiper-slide").css('height', h);
					}
				});
				$(".wechat_box,.null_box").hide();

			});
			//加微信
			$(".btn_add_wechat").click(function() {
				$(".wechat_box,.null_box").fadeIn(300);
			});
			$(".icon_close").click(function() {
				$(".wechat_box,.null_box").fadeOut(300);
			});
			
			//音乐
			window.onload = function() {
				var music = document.getElementById("music");
				var audio = document.getElementsByTagName("audio")[0];
				audio.addEventListener('ended', function() {
					// Wait 500 milliseconds before next loop  
					setTimeout(function() {
						audio.play();
					}, 500);
				}, false);
				audio.play();
				music.onclick = function() {
					if(audio.paused) {
						audio.play();
						music.setAttribute('class', "play");
						// music.style.animationPlayState="running";
						// music.style.webkitanimationPlayState="running";
					} else {
						audio.pause();
						music.setAttribute("class", "");
						// music.style.animationPlayState="paused";
						// music.style.webkitanimationPlayState="paused";
					}

				};
			};
			
			//侧栏
			$(".top_nav,.gomenu").click(function() {
				$(".null_box").fadeIn(300);
				$(".sidebar_user").animate({
					left: "+=100%"
				}, 600);
			});
			$(".null_box").click(function() {
				if($(".sidebar_user").css("left") == "0px") {
					$(".sidebar_user").animate({
						left: "-=100%"
					}, 600);
				}
				$(".null_box,.wechat_box").fadeOut(300);
			});
			
			//左右滑
			var windowHeight = $(window).height(),
			 	windowwidth = $(window).width(),
			$body = $("body");
			$body.css("height", windowHeight);
			$body.css("width", windowwidth);　
			$("body").on("touchstart", function(e) {　　　　
				e.preventDefault();　　　　
				startX = e.originalEvent.changedTouches[0].pageX, 　　　　startY = e.originalEvent.changedTouches[0].pageY;　　
			});　　
			$("body").on("touchmove", function(e) {　　　　
				e.preventDefault();　　　　
				moveEndX = e.originalEvent.changedTouches[0].pageX, 　　　　moveEndY = e.originalEvent.changedTouches[0].pageY, 　　　　X = moveEndX - startX, 　　　　Y = moveEndY - startY;
				if(Math.abs(X) > Math.abs(Y) && X > 0) {　
					//left-right
					if($(".sidebar_user").css("left") == -windowwidth+"px") {
						$(".sidebar_user").stop().animate({
							left: "+=100%"
						}, 600);
					}　　　　　
					$(".null_box").fadeIn(300);
				}　　　　
				else if(Math.abs(X) > Math.abs(Y) && X < 0) {
					//right-left
					if($(".sidebar_user").css("left") == "0px") {
						$(".sidebar_user").stop().animate({
							left: "-=100%"
						}, 600);
					}
					$(".null_box").fadeOut(300);　　
				}　　　　
				else if(Math.abs(Y) > Math.abs(X) && Y > 0) {　　　　　　
					//top-bottom　　　　
				}　　　　
				else if(Math.abs(Y) > Math.abs(X) && Y < 0) {　　　　　　
					//bottom-top　　　　
				}　　　　
				else {　　　　　　
					//just touch　　　　
				}　　
			});
		</script>
	</body>

</html>
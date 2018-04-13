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
		<script src="//at.alicdn.com/t/font_583524_zxq3knl7iwv78pvi.js"></script>
	</head>

	<body class="bg_index">
		<div style="background: rgba(12, 12, 12, 0.2);padding-bottom: 56px;">
			<!--公司-->
			<div class="top_nav">
				<svg class="icon" aria-hidden="true">
					<use xlink:href="#icon-mulu"></use>
				</svg>
				<span>广州知伴人工智能科技有限公司</span>
			
			</div>
			<!--个人信息-->
			<div class="info">
				<img class="head" src="${ctxStatic}/zhiban/img/head_default.png" />
				<p>郝斌</p>
				<p>广州知伴人工智能科技有限公司<br /> 城市合伙人(执行董事)</p>
				<p>人工智能机器人全国招商</p>

				<div class="contact_info">
					<a class="contact_type" href="tel:13203509288">
						<svg class="icon" aria-hidden="true">
							<use xlink:href="#icon-dianhua"></use>
						</svg>
						13203509288
					</a>
					<div class="contact_type">
						<svg class="icon" aria-hidden="true">
							<use xlink:href="#icon-weixin"></use>
						</svg>
						&nbsp;HYH2013_8
						<button class="btn_add_wechat">加微信</button>
					</div>
				</div>
				<a href="${ctx}/f/core/login" >登陆我的名片</a>
				
				<!--浏览量-->
				<div class="view">
					<svg class="icon" aria-hidden="true">
						<use xlink:href="#icon-liulan"></use>
					</svg>
					<span>123</span>
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
				
					<li class="news_box">
						<p class="nwes_title">1-14岁孩子成长密码，耶鲁大学跟踪研究40年的成果</p>
						<img class="news_backcover" src="http://7xk5td.com1.z0.glb.clouddn.com/weixin_LTE4ODA2NTI3ODk=0.jpg-img200112" />
					</li>
					<li class="news_box">
						<p class="nwes_title">1-14岁孩子成长密码，耶鲁大学跟踪研究40年的成果</p>
						<img class="news_backcover" src="http://7xk5td.com1.z0.glb.clouddn.com/weixin_LTE4ODA2NTI3ODk=0.jpg-img200112" />
					</li>
					<li class="news_box">
						<p class="nwes_title">1-14岁孩子成长密码，耶鲁大学跟踪研究40年的成果</p>
						<img class="news_backcover" src="http://7xk5td.com1.z0.glb.clouddn.com/weixin_LTE4ODA2NTI3ODk=0.jpg-img200112" />
					</li>
					<li class="news_box">
						<p class="nwes_title">1-14岁孩子成长密码，耶鲁大学跟踪研究40年的成果</p>
						<img class="news_backcover" src="http://7xk5td.com1.z0.glb.clouddn.com/weixin_LTE4ODA2NTI3ODk=0.jpg-img200112" />
					</li>
				</ul>
			</div>
		</div>
		
		<!--底部-->
		<div class="footer">
			<svg class="icon goleft" aria-hidden="true">
				<use xlink:href="#icon-left"></use>
			</svg>
			<svg class="icon gohome" aria-hidden="true">
				<use xlink:href="#icon-shouye"></use>
			</svg>
			<svg class="icon goshare" aria-hidden="true">
				<use xlink:href="#icon-fenxiang"></use>
			</svg>
			
		</div>
		<!--音乐-->
		<audio class="audio" autoplay="autoplay">
			<source src="music/AllanTaylorScotty.mp3" type="audio/mp3" media="">
		</audio>
		
		<!--微信名片-->
		<div class="null_box"></div>
		<div class="wechat_box">
			<div class="code_box">
				<img class="code" src="${ctxStatic}/zhiban/img/personal_wechat.jpg" />
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
		</script>
	</body>

</html>
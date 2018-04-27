<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>化妆品生产许可管理</title>
	<meta charset="utf-8">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Viewer</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
  	<link rel="stylesheet" href="css/viewer.css">
  	<link rel="stylesheet" href="css/main.css">
	<script src="js/jquery.min.js"></script>
  	<script src="js/bootstrap.min.js"></script>
  	<script src="js/viewer.js"></script>
  	<script src="js/main.js"></script>
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	
  	<style>
  		.docs-pictures > li{
  			height:auto;
  		}
  		body,html{
  			height:100%;
  			width:100%;
  			margin:0;
  			padding:0;
  			overflow:hidden;
  		}
  		#jbox-content{
  			height:400px;
  			overflow:hidden;
  		}
  		.imgbd{
  			width:80%;
  			margin:20px auto;
  		}
  		#imgfile li{
  			width:20%;
  			height:150px;
  			margin:-1px;
  			border:1px solid #eee;
  		}
  		.imgbd img{
  			width:100%;
  			height:100%;
  		}
  	</style>
</head>
<body>
	<div class="docs-galley imgbd">
          <ul id="imgfile" class="docs-pictures clearfix">
          </ul>
   </div>
   <script>  
		var thisURL = document.URL; 
		var getval = thisURL.split('?')[1];
		var showval= getval.split("=")[1];
		var showimg = showval.split("&")[0];
		var imglist = "";
		function  showvalf(){
			if(showimg.indexOf("~")==-1){
				imglist += "<li><img src=\'"+showimg+"\'></li>";
      	  	}
			if(showimg.indexOf("~")!=-1){
				var a = showimg.split("~");
				for(var i=1;i<a.length;i++){
					imglist += "<li><img src=\'"+a[i]+"\'></li>";
				}
			}
			 $("#imgfile").append(imglist);
		}
		showvalf();
		$("#imgfile").viewer();
	</script>
</body>
</html>
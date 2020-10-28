<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<style>
li {
	text-decoration: none;
	height: 50px;
	margin: 20px, 40px, 10px, 40px;
	font-size: 18px;
}
body{
background:url(../images/frame_bg.gif);
}
</style>
</head>
<!-- <body class="frame-bd"> -->
<body class="header-bd">
	<ul class="left-menu">
			<c:if test="${loginer.issupper >= 1}">	
				<li><a href="showUser" target="mainFrame"><img src="images/btn_users.gif" /></a></li>
			</c:if>
		<li><a href="ShowBillServlet" target="mainFrame"><img src="images/btn_bill.gif" /></a></li>
		<li><a href="goods.jsp" target="mainFrame"><img src="images/good_mag.gif" height="40" width="180px" style" /></a></li>
		
		<li><a href="person_info?&userName=${loginer.username}" target="mainFrame"><img src="images/person_info.gif" height="40" width="180px" />
		</a>
		</li>  

	
	</ul>
</body>
</html>

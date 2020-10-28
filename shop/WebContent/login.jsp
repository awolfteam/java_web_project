<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录 - 超市管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body class="blue-style">
	<div id="login">
		<div class="icon"></div>
		<div class="login-box">
			<!-- 前端代码中跳转也支持绝对路径和相对路径	绝对路径是从http://ip开始的路径，我们简写"/"在前端代码中"/"是达到tomcat的目录下. 
			 只要在前端，比如a标签,js跳转,img的src他们的值如果是"/"开头的都是表示达到tomcat的根目录
  
	 -->
			<form method="get" action="login">
				<dl>
					<dt>用户名：</dt>
					<dd>
						<input type="text" name="userName" class="input-text" />
					</dd>
					<dt>密 码：</dt>
					<dd>
						<input type="password" name="passWord" class="input-text" />
					</dd>
					<dt>验证码</dt>
					<dd>
						<input type="text" name="check_code" class="input-text" />&nbsp;
						<img alt="" src="/shop/CheckServlet">
					</dd>
<!-- 					float:left; -->
				</dl>
				<div class="buttons">
					<input type="submit" name="submit" value="登录系统"
						class="input-button" /> <input type="reset" name="reset"
						value="重　　填" class="input-button" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>

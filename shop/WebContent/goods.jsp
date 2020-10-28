<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function doit(flag, id) {
		if (flag == "del") {
			if (confirm("确认删除吗？") != true)
				return;
		}
		window.location = "provider.do?id=" + id + "&flag=" + flag;
	}
</script>
</head>
<body>
	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form method="get" action="SelectProviderServlet">
							<input name="flag" value="search" type="hidden"> 商品名称：<input
								name="providerName" class="input-text" type="text">
							&nbsp;&nbsp;&nbsp;&nbsp;商品描述：<input name="providerDesc"
								class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;<input
								value="组 合 查 询" type="submit">
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='providerAdd.jsp'" type="button"></em>
			<div class="title">库存管理&gt;&gt;</div>
		</div>

		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="80"><div class="STYLE1" align="center">商品id</div></td>
						<td width="80"><div class="STYLE1" align="center">商品名称</div></td>
						<td width="100"><div class="STYLE1" align="center">商品描述</div></td>
						<td width="100"><div class="STYLE1" align="center">商品进价</div></td>
						<td width="100"><div class="STYLE1" align="center">出价</div></td>

					</tr>
					<c:choose>
						<c:when test="${count==1}">
							<c:forEach var="pro" items="${provider}">
								<tr>
									<td width="80"><span class="STYLE1">${pro.proName}</span></td>
									<td width="100"><span class="STYLE1">${pro.proDesc}</span></td>
									<td width="100"><span class="STYLE1">${pro.contact}</span></td>
									<td width="100"><span class="STYLE1">${pro.fax}</span></td>
									<td width="100"><span class="STYLE1">${pro.phone}</span></td>
									<td width="100"><span class="STYLE1">${pro.address}</span></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:when test="${count==2 && pro!= null}">
							<c:forEach var="pro" items="${pro}">
								<tr>
									<td width="80"><span class="STYLE1">${pro.proName}</span></td>
									<td width="100"><span class="STYLE1">${pro.proDesc}</span></td>
									<td width="100"><span class="STYLE1">${pro.contact}</span></td>
									<td width="100"><span class="STYLE1">${pro.fax}</span></td>
									<td width="100"><span class="STYLE1">${pro.phone}</span></td>
									<td width="100"><span class="STYLE1">${pro.address}</span></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:when test="${pro == null}">
							<tr>
								<td width="100" colspan="6"><span class="STYLE1"><h3>没有记录</h3></span></td>
							</tr>
						</c:when>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
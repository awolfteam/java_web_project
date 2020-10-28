<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="menu">
		<form method="get" action="SelectBillServlet">
			商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
			商品id <input type="text" name="bid" class="input-text" />
&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="submit"
				value="单个查询" class="button" />
		</form>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input type="button" name="button" value="添加数据"
				class="input-button" onclick="location.href='addBill.jsp'" /></em>
			
<!-- 				<em><input type="button" name="button" value="修改数据" -->
<!-- 				class="input-button" onclick="location.href='admin_bill_modify.jsp'" /></em> -->
				
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		
		<div class="content">
			<table class="list">
				<tr>
					<td>账单编号</td>
					<td>收银员</td>
					<td>是商品名称</td>
					<td>商品数量</td>
					<td>交易金额</td>
					<td>账单时间</td>
				</tr>
				<c:choose>
					<c:when test="${count==1}">
						<c:forEach var="bill" items="${bill}">
							<tr>
								<td>${bill.bid}</td>
								<td><a
									href="modify.jsp?bid=${bill.bid}&productName=${bill.productName}&productNum=${bill.productNum}
						&productPrice=${bill.productPrice}&productmoney=${bill.productmoney}&billDate=${bill.billDate}">${bill.productName}</a></td>
								<td>${bill.cashier}</td>
								<td>${bill.productName}</td>
								<td>${bill.productNum}</td>
								<td>${bill.productPrice}</td>
								<td>${bill.productmoney}</td>
								<td>${bill.billDate}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:when test="${count==2 && bill!=null}">
						<c:forEach var="bill" items="${bill}">
							<tr>
							<td>${bill.bid}</td>
								<td><a
									href="modify.jsp?bid=${bill.bid}&productName=${bill.productName}&productNum=${bill.productNum}
						&isPay=${bill.isPay}&
						tradeNum=${bill.tradeNum}&proName=${bill.proName}&productDesc=
						${bill.productDesc}&billDate=${bill.billDate}">${bill.productName}</a></td>
								<td>${bill.productNum}</td>
								<td>${bill.tradeNum}</td>
								<td>${bill.proName}</td>
								<td>${bill.productDesc}</td>
								<td>${bill.billDate}</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
		</div>
	</div>
</body>
</html>

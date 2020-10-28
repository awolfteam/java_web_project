<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.orgs/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.8.3.js"></script>
<script>
	$(function() {		
			$.ajax({
			type : "get",
			url : "showProname",
			async : true,
			success : function(data) {
			for (i = 0; i < data.length; i++) {
				var option = $("<option></option>").val(data[i].pid).text(data[i].proName)																																
				$("[name=proName]").append(option)
			}
		}
	});
})
</script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<em><input type="button" name="button" value="添加数据"
				class="input-button" onclick="location.href='addBill.jsp'" /></em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<form method="post" action="AddBillServlet">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" name="billName" class="text" /></td>
					</tr>
					<tr>
						<td class="field">商品数量：</td>
						<td><input type="text" name="billNum" class="text" /></td>
					</tr>
					<tr>
						<td class="field">交易金额：</td>
						<td><input type="text" name="money" class="text" /></td>
					</tr>
					<tr>
						<td class="field">账单时间：</td>
						<td><input type="text" name="billDate" class="text" /></td>
					</tr>
					<!-- <tr>
					<td class="field">供应商名称：</td>
					<td><input type="text" name="proName" class="text" /></td>
				</tr> -->
					<tr>
						<td class="field">供应商名称：</td>
						<td><select name="proName">
							
						</select></td>
					</tr>
					<tr>
						<td class="field">商品描述：</td>
						<td><textarea name="discription"></textarea></td>
					</tr>
					<tr>
						<td class="field">是否付款：</td>
						<td><select name="isPay">
								<option value="1">是</option>
								<option value="0">否</option>
						</select></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" name="submit" value="确认" class="input-button" />
				<input type="button" name="button" value="返回" class="input-button"
					onclick="history.back();" />
			</div>
		</form>
	</div>
</body>
</html>

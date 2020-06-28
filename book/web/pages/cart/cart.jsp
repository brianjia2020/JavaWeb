<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function(){
			$("a.deleteItem").click(function () {
				return confirm("Are you sure to delete this item" + $(this).parent().parent().find("td:first").text() +"?")
			})

			$("#cleanCart").click(function () {
				return confirm("Are you sure to clean the cart?")
			})

			$(".updateCount").change(function () {
				let name = $(this).parent().parent().find("td:first").text()
				let count = this.value
				let id = $(this).attr("itemid")
				// console.log(name)
				if( confirm("Are you sure to change "+ name +" quantity to "+count+"?")){
					//send request to
					location.href = "http://localhost:8080/book/cartServlet?action=updateCount&count="+count+"&id=" + id
				} else {
					this.value = this.defaultValue;
				}
			})
		})

	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<div>
				<span>欢迎<span class="um_span">韩总</span>光临尚硅谷书城</span>
				<a href="pages/order/order.jsp">我的订单</a>
				<a href="index.jsp">注销</a>&nbsp;&nbsp;
				<a href="index.jsp">返回</a>
			</div>
	</div>
	
	<div id="main">

		<c:if test="${not empty sessionScope.cart.items}">
			<table>
				<tr>
					<td>商品名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input type="text" itemid="${entry.value.id}" class="updateCount" style="width: 80px" value="${entry.value.count}">
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</table>

			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a id="cleanCart" href="cartServlet?action=clean">清空购物车</a></span>
				<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
			</div>
		</c:if>
		<c:if test="${empty sessionScope.cart.items}">
			<table>
				<tr>
					<td>商品名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
					<td>操作</td>
				</tr>
				<tr>
					<td colspan="5"><a href="index.jsp">亲，当前购物车为空。快给我买起来。</a></td>
				</tr>
			</table>
		</c:if>
	</div>
	
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
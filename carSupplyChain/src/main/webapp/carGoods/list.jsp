<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/list.css">
    <title>汽车供应链列表</title>
</head>
<body>
<div class="w">
    <header>
        <a href="${pageContext.request.contextPath }/cargoods/getCart" >
            <input type="button" οnclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/cargoods/getCart'" value="我的购物车" class="btn">
        </a>
    </header>
    <div class="list">
        <div class="list-bd">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
                <tr>
                    <th width="10%">名称</th>
                    <th width="10%">价格</th>
                    <th width="10%">生产商</th>
                    <th width="10%">描述</th>
                    <th width="10%">数量</th>
                    <th width="10%">操作</th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td>${item.produce}</td>
                        <td>${item.description}</td>
                        <td>${item.num}</td>
                        <td><a href="${pageContext.request.contextPath}/cargoods/addGoodsToCart?goodsId=${item.id}">加入购物车</a></td>

                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
</body>
</html>
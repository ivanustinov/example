<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="613V"/>
</jsp:include>
<hr>
<div id="product" style="margin-left: 20px">
    <h1>Шина ${product.toString()} </h1>
    <a href="picture?picture=${image}" target="_blank">
        <img src="picture?picture=${image}" alt="bridgestone">
    </a>
    <h2>Характеристики товара:</h2>
    <ul>
        <li>Производитель: ${product.manufacturer.toString()}</li>
        <li>Модель: ${product.model}</li>
        <li>Сезон: ${product.seazon.toString()}</li>
        <li>Ширина: ${product.width} мм.</li>
        <li>Высота профиля: ${product.profile_height}%</li>
        <li>Радиус: ${product.radius}"</li>
        <li>Цена: ${product.price} р.</li>
    </ul>
</div>
<hr>
<jsp:include page="../views/footer.jsp"/>


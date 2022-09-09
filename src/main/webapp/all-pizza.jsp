<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Пицца</title>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="css/all-pizza.css">
</head>
<body>
<h1 class="ms-3">Доставка и заказ пиццы</h1>
<div class="list">
    <c:forEach var="pizza" items="${pizzas}">
        <div class="pizza">
            <img class="mb-2" src="${pizza.getUrlImage()}" width="250" alt="None">
            <h4 class="mb-2">${pizza.getName()}</h4>
            <a class="btn btn-success" href="pizza-details?id=${pizza.getId()}">Заказать</a>
        </div>
    </c:forEach>

</div>
</body>
</html>

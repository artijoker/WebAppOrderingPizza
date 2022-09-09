<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${pizza.getName()}</title>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="css/pizza-details.css">
</head>
<body>
<div class="row">
    <div class="col-6">
        <div class="info">
            <img src="${pizza.getUrlImage()}" width="350" alt="None">
            <div class="row mt-4 fw-bold">Название:</div>
            <div class="row">${pizza.getName()}</div>

            <div class="row mt-4 fw-bold">Описание:</div>
            <div class="row">${pizza.getInfo()}</div>

            <div class="row mt-4 fw-bold">Цена:</div>
            <div class="row">${pizza.getPrice()}</div>
        </div>

    </div>
    <div class="col">
        <div class="form">
            <form action="order" class="m-3" method="post">
                <div class="mb-3 mt-3">
                    <label for="name" class="form-label">Имя:</label>
                    <input type="text" class="form-control" id="name" placeholder="Введите имя" name="name">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" class="form-control" id="email" placeholder="Введите email" name="email">
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">Телефон:</label>
                    <input type="tel" class="form-control" id="phone"
                           placeholder="Введите телофон"
                           pattern="8[0-9]{10}" required
                           name="phone">
                    <small>Формат: 89112223344</small>
                </div>
                <div class="mb-3 mt-3">
                    <label for="address" class="form-label">Имя:</label>
                    <input type="text" class="form-control" id="address" placeholder="Введите адресс" name="address">
                </div>
                <input type="hidden" name="pizzaId" value="${pizza.getId()}">
                <button type="submit" class="btn btn-primary">Оформить заказ</button>
            </form>
        </div>

    </div>
</div>



</body>
</html>

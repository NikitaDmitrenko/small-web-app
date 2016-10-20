<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="utf-8" contentType="text/html; utf-8" language="java" %>
<!Doctype>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/mask.js" type="text/javascript"></script>
</head>
<body>
<div>
    <form method="post" action="${pageContext.request.contextPath}/order">
        Введите ваше ФИО <br><input type="text" name="name" placeholder="Ф.И.О"><br>
        Введите ваш номер мобильного телефона<br> <input id="phone" name="phone" type="tel" placeholder="Телефон"><br>
        <label>
            Выберите апартаменты<br>
            <select name="apartmentId">
                <c:forEach var="apartment" items="${apartments}">
                    <option value="${apartment.id}">${apartment.description}</option>
                </c:forEach>
            </select>
        </label> <br>
        <label for="date">Выберите дату просмотра апартаментов<br></label><input required id="date" name="date" max='2016-12-31' type="date">
        <br>
        <br>
        <button type="submit">Забронировать</button>
    </form>
</div>
<div>
    <c:if test="${status != null && status==false}">
        <b>
            Апартаменты <b>${apartment}</b> на ${date} заняты для просмотра , выберите другую дату.</b>
        </p>
    </c:if>
    <c:if test="${status !=null && status==true}">
        Уважаемый <b>${name}</b> ваша заявка на апартаменты <b>${apartment}</b> , на <b>${date}</b> принята.<br>
        По вашему номеру телефона <b>${phone}</b> с вами свяжется менеджер для выяснения деталей<br>
    </c:if>
</div>
</body>
<script type="text/javascript">
    console.log(10);
    jQuery(function ($) {
        $("#phone").mask("+38(999)999-99-99");
    });
</script>
</html>

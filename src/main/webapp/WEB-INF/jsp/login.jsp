<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Zaloguj się do bramki</title>
        <style>
            body {
                background-image: linear-gradient(to bottom left, #db545a, #478ac9)
            }
            .horizontal-center {
              margin: auto;
              width: 40%;
            }

            h1 {
                text-align: center;
                color: white;
                font-size: 48px;
                font-family: 'Trebuchet MS', sans-serif;
            }

            a {
                color: white;
                font-size: 20px;
                font-family: 'Trebuchet MS', sans-serif;
            }

            .field-description {
                text-align: left;
                color: white;
                font-size: 20px;
                font-family: 'Trebuchet MS', sans-serif;
            }

            input[type=text] {
                width: 100%;
                height: 40px;
                border: 1px;
                padding: 10px;
                background-color: #f2f2f2
            }

            input[type=submit] {
                width: 100%;
                height: 50px;
                border: 1px;
                padding: 5px;
                color: white;
                font-size: 20px;
                font-family: 'Trebuchet MS', sans-serif;
                background-image: linear-gradient(#00A9E2 0%, #5BC4BB 100%)
            }

            .center-img {
                display: block;
                margin: auto;
            }

            .error-message {
                color: white;
                font-size: 16px;
                font-family: 'Trebuchet MS', sans-serif;
                padding: 10px;
                background: rgb(148,52,52);
                background: linear-gradient(0deg, rgba(148,52,52,1) 0%, rgba(255,0,0,1) 100%);
                border-style: hidden;
            }

        </style>
    </head>

    <body>
        <div class="horizontal-center">
            <img src="https://cdn-icons-png.flaticon.com/512/3945/3945590.png" class="center-img" height="150" >
            <h1>Wprowadź podświadczenia</h1>
            <form method="post">
                <div class="field-description">Adres IP</div>
                <input type="text" name="ip" placeholder="Wprowadź adres IP bramki lub zaznacz pole poniżej"/>
                <div class="field-description"><input type="checkbox" name="autoIP"> Znajdź adres IP bramki za mnie (Ta opcja może potrwać kilka minut)<br></div>

                <div class="field-description"><br>Identyfikator</div>
                <input type="text" name="identity" placeholder="Wprowadź identyfikator"/><br>

                <div class="field-description"><br>Klucz</div>
                <input type="text" name="key" placeholder="Wprowadź klucz"/><br>

                <c:if test="${not empty errorMessage}">
                    <br>
                    <div class="error-message">
                        Nieprawidłowe dane logowania, bramka nie jest podłączona do sieci lub nie ma podłączonych urządzeń. Wprowadź dane jeszcze raz, aby spróbować ponownie.
                    </div>
                </c:if>

                <br>
                <input type="submit" value="Połącz się z bramką"/>
            </form>
            <a href="/firstConnect"><br>Identyfikator? Klucz? Ale o co chodzi?</a>
        </div>

    </body>

</html>
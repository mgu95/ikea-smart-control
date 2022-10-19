<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>Połącz się po raz pierwszy</title>

    <style>

        body {
            background-image: linear-gradient(to bottom left, #db545a, #478ac9)
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

        .horizontal-center {
              margin: auto;
              width: 40%;
        }

        .field-description {
                text-align: left;
                color: white;
                font-size: 20px;
                font-family: 'Trebuchet MS', sans-serif;
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

    </style>

</head>

<body>

    <div class="horizontal-center">
        <h1>Aby połączyć się z bramką po raz pierwszy wypełnij poniższy formularz:</h1>
        <form method="post">

            <div class="field-description">Adres IP</div>
            <input type="text" name="ip" placeholder="Wprowadź adres IP bramki">

            <div class="field-description"><br>Kod bezpieczeństwa</div>
            <input type="text" name="securityCode" placeholder="Wprowadź kod bezpieczeństwa">
            <div class="field-description">Kod bezpieczeństwa znajduje się na spodzie bramki IKEA TRÅDFRI.</div>

            <c:if test="${not empty errorMessage}">
                <br>
                <div class="error-message">
                Nie można nawiązać połączenia z bramką. Upewnij się, że wprowadzono prawidłowe dane i spróbuj ponownie.
                </div>
            </c:if>

            <br>
            <input type="submit" value="Poproś bramkę o identyfikator i klucz"/>

        </form>

        <a href="/login"><br>Wróć na stonę logowania</a>
    </div>

</body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

    <head>
        <title>Połączono z bramką!</title>

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

            h2 {
                text-align: center;
                font-size: 20px;
                font-family: 'Trebuchet MS', sans-serif;
                margin: 0;
            }

            h3 {
                text-align: center;
                color: white;
                font-size: 48px;
                font-family: 'Trebuchet MS', sans-serif;
                margin: 0;
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

            .message {
                color: white;
                font-size: 16px;
                font-family: 'Trebuchet MS', sans-serif;
                padding: 10px;
                background: linear-gradient(#00A9E2 0%, #5BC4BB 100%);
                border-style: hidden;
            }

            .center-img {
                display: block;
                margin: auto;
            }

        </style>
    </head>

    <body>

        <div class="horizontal-center">

            <img src="https://cdn-icons-png.flaticon.com/512/5818/5818345.png" class="center-img" height="150" >
            <h1>Udało się połączyć z bramką!</h1>

            <div class="message">
                <h2>Adres IP</h2>
                <h3>${ip}</h3>
                <br>
                <h2>Identyfikator</h2>
                <h3>${identity}</h3>
                <br>
                <h2>Klucz</h2>
                <h3>${key}</h3>
            </div>

            <br>
            <a href="/home">Kliknij tutaj, aby rozpocząć.</a>
        </div>

    </body>

</html>
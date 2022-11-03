<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <title>406</title>
        <style>
            body {
                background-color: #DADBDD
            }

            h1 {
                text-align: center;
                color: white;
                font-size: 240px;
                font-family: 'Trebuchet MS', sans-serif;
                margin: 0
            }

            h2 {
                text-align: center;
                font-size: 72px;
                font-family: 'Trebuchet MS', sans-serif;
                margin: 0;
            }

            p {
                text-align: center;
                font-size: 48px;
                font-family: 'Trebuchet MS', sans-serif;
                margin: 0;
                padding-left: 100px;
                padding-right: 100px;
                padding-bottom: 30px;
            }

            .btn {
                text-align: center;
                font-size: 48px;
                font-family: 'Trebuchet MS', sans-serif;
                background-color: #555555;
                color: white;
                border: 2px solid #555555;
                transition-duration: 0.4s;
                padding: 20px;
                border-radius: 20px;;
            }

            .btn:hover {
                background-color: #e7e7e7;
                color: black;
            }

        </style>
    </head>
    <body>
        <h1>406</h1>
        <h2>Hola! Hola! Tak nie wolno!</h2>
        <p>Podane przez Ciebie dane są niedozwolone! Wprowadź prawidłowe dane inaczej serwer nie przetworzy żądania.</p>

        <div style="text-align:center">
            <form action="/home">
                <input type="submit" value="Wróć do strony głównej" class="btn"/>
            </form>
        </div>
    </body>
</html>
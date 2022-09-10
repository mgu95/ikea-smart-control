<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

    <head>
        <title>Login to Gateway</title>
    </head>

    <body>
        <font color="red">${errorMessage}</font>
        <form method="post">
            IP: <input type="text" name="ip" />
            Identity: <input type="text" name="identity" />
            Key: <input type="text" name="key" />
            <input type="submit" />
        </form>
    </body>

</html>
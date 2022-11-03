<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="nl.stijngroenen.tradfri.device.Device" %>

<html>

    <head>
        <title>Home</title>
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>

        <h1>${ip}
        
        <h1>Lights</h1>

        <table style="width:100%">
            <tr>
                <th>ID</th>
                <th>POWER</th>
                <th>HEX</th>
                <th>BRIGHTNESS</th>
                <th>LINK</th>
            </tr>
            <c:forEach items="${lights}" var="light">
                <tr>
                    <td>${light.getDeviceId()}</td>
                    <td>${light.isPower()}</td>
                    <td>${light.getColourHex()}</td>
                    <td>${light.getBrightness()}</td>
                    <td><a href="/device/${device.getInstanceId()}">manage</a></td>
                </tr>
            </c:forEach>
        </table>

</html>
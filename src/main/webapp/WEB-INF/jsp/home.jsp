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
        
        <h1>Podłączone urządzenia:</h1>

        <table style="width:100%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Type</th>
                <th>Manage</th>
            </tr>
            <c:forEach items="${devices}" var="device">
                <tr>
                    <td>${device.getInstanceId()}</td>
                    <td>${device.getName()}</td>
                    <td>${device.getType()}</td>
                    <td><a href="/device/${device.getInstanceId()}">manage</a></td>
                </tr>
            </c:forEach>
        </table>

</html>
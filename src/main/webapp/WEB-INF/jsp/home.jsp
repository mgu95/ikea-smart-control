<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.Random" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="nl.stijngroenen.tradfri.device.Device" %>

<html>

    <head>
        <title>Treść dynamiczna</title>
    </head>
        
        <h1>Podłączone urządzenia:</h1>

        <c:forEach items="${devices}" var="device" varStatus="lp">
            ${lp.index + 1}</br>
            ${device.getName()}</td>
            ${device.getType()}</td>
        </c:forEach>

</html>
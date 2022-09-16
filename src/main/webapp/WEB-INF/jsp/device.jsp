<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="nl.stijngroenen.tradfri.device.*" %>

<html>

    <head>
        <title>Device</title>
        <style> table, th, td {border: 1px solid black;} </style>
    </head>

    <body>

        <h1>${device.getName()}</h1>
        <a href="/home">Back to home</a>

        <h2>Device info</h2>
            <table style="width:100%">
                <tr>
                    <th>MODEL NAME</th>
                    <th>MANUFACTURER</th>
                    <th>SERIAL</th>
                    <th>FIRMWARE VERSION</th>
                    <th>POWER SOURCE</th>
                    <th>BATTERY LEVEL</th>
                </tr>
                <tr>
                    <th>${device.getDeviceInfo().getModelName()}</th>
                    <th>${device.getDeviceInfo().getManufacturer()}</th>
                    <th>${device.getDeviceInfo().getSerial()}</th>
                    <th>${device.getDeviceInfo().getFirmwareVersion()}</th>
                    <th>${device.getDeviceInfo().getPowerSource()}</th>
                    <th>${device.getDeviceInfo().getBatteryLevel()}</th>
                </tr>
            </table>

        <h2>Light status</h2>
            <table style="width:100%">
                <tr>
                    <th>STATUS</th>
                    <th>HUE</th>
                    <th>COLOUR HEX</th>
                    <th>COLOUR RGB</th>
                    <th>COLOUR XY</th>
                    <th>COLOUR TEMPERATURE</th>
                    <th>SATURATION</th>
                    <th>BRIGHTNESS</th>
                </tr>
                <tr>
                    <td>
                        <c:if test="${not device.toLight().getOn()}">OFF</c:if>
                        <c:if test="${device.toLight().getOn()}">ON</c:if>
                    </td>
                    <td>${device.toLight().getHue()}</td>
                    <td>${device.toLight().getColourHex()}</td>
                    <td>
                        RED: ${device.toLight().getColourRGB().getRed()}<br>
                        GREEN: ${device.toLight().getColourRGB().getGreen()}<br>
                        BLUE: ${device.toLight().getColourRGB().getBlue()}
                    </td>
                    <td>
                        X: ${device.toLight().getColourX()}<br>
                        Y: ${device.toLight().getColourY()}
                    </td>
                    <td>${device.toLight().getColourTemperature()}</td>
                    <td>${device.toLight().getSaturation()}</td>
                    <td>${device.toLight().getBrightness()}</td>
                <tr>
            </table>

        <h2>Change status</h2>
        <a href="/device/${deviceId}/on">On</a><br>
        <a href="/device/${deviceId}/off">Off</a><br>

        <h2>Change colour</h2>
        <a href="/device/${deviceId}/colourHex/WHITE">WHITE</a><br>
        <a href="/device/${deviceId}/colourHex/WARM">WARM</a><br>
        <a href="/device/${deviceId}/colourHex/GLOW">GLOW</a><br>
        <a href="/device/${deviceId}/colourHex/BLUE">BLUE</a><br>
        <a href="/device/${deviceId}/colourHex/LIGHT_BLUE">LIGHT_BLUE</a><br>
        <a href="/device/${deviceId}/colourHex/SATURATED_PURPLE">SATURATED_PURPLE</a><br>
        <a href="/device/${deviceId}/colourHex/LIME">LIME</a><br>
        <a href="/device/${deviceId}/colourHex/LIGHT_PURPLE">LIGHT_PURPLE</a><br>
        <a href="/device/${deviceId}/colourHex/YELLOW">YELLOW</a><br>
        <a href="/device/${deviceId}/colourHex/SATURATED_PINK">SATURATED_PINK</a><br>
        <a href="/device/${deviceId}/colourHex/DARK_PEACH">DARK_PEACH</a><br>
        <a href="/device/${deviceId}/colourHex/SATURATED_RED">SATURATED_RED</a><br>
        <a href="/device/${deviceId}/colourHex/COLD_SKY">COLD_SKY</a><br>
        <a href="/device/${deviceId}/colourHex/PINK">PINK</a><br>
        <a href="/device/${deviceId}/colourHex/PEACH">PEACH</a><br>
        <a href="/device/${deviceId}/colourHex/WARM_AMBER">WARM_AMBER</a><br>
        <a href="/device/${deviceId}/colourHex/LIGHT_PINK">LIGHT_PINK</a><br>
        <a href="/device/${deviceId}/colourHex/COOL_DAYLIGHT">COOL_DAYLIGHT</a><br>
        <a href="/device/${deviceId}/colourHex/CANDLELIGHT">CANDLELIGHT</a><br>
        <a href="/device/${deviceId}/colourHex/WARM_GLOW">WARM_GLOW</a><br>
        <a href="/device/${deviceId}/colourHex/WARM_WHITE">WARM_WHITE</a><br>
        <a href="/device/${deviceId}/colourHex/SUNRISE">SUNRISE</a><br>
        <a href="/device/${deviceId}/colourHex/COOL_WHITE">COOL_WHITE</a><br>
        

        <h2>Change colour</h2>
        Enter a value between 2 and 254:
        <form method="post">
            Value: <input type="text" name="value" />
            <input type="submit" />
        </form>
        <font color="red">${errorMessage}</font>

        <br>
        <a href="/home">Back to home</a>

    </body>

</html>
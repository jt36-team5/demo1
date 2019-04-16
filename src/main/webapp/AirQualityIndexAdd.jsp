<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加空气质量信息</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<body>
    <form id="myFrm" name="myFrm" method="post">
        <table align="center">
            <tr>
                <td colspan="2"><h1>添加空气质量信息</h1></td>
            </tr>
                <td>监测区域：</td>
                <td>
                    <select name="districtId">
                        <c:if test="${districtList != null }">
                            <option value="0">--请选择--</option>
                            <c:forEach var="dis" items="${districtList}">
                                <option <c:if test="${dis.id == queryDistrictName }">selected="selected"</c:if>
                                        value="${dis.id}">${dis.name}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </td>
            </tr>
            <tr>
                <td>监测日期：</td>
                <td>
                    <input type="text" name="monitorTime" Class="Wdate" readonly="readonly" onclick="WdatePicker();">
                </td>
            </tr>
            <tr>
                <td>PM10值：</td>
                <td>
                    <input type="text" name="pm10" >
                </td>
            </tr>
            <tr>
                <td>PM2.5值：</td>
                <td>
                    <input type="text" name="pm25" >
                </td>
            </tr>
            <tr>
                <td>监测站：</td>
                <td>
                    <input type="text" name="monitoringStation" >
                </td>
            </tr>
            <tr align="center" height="50">
                <td colspan="2">
                    <input type="submit" value="保存" onclick="document.myFrm.action='/addAirQualityIndex'">
                    <input type="reset" value="重置">
                    <input type="submit" value="返回" onclick="document.myFrm.action='/showAirQualityIndexs'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

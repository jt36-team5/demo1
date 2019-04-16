<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<body>
<form id="myFrm" name="myFrm" method="post">
    <table align="center">
        <input type="hidden" name="id" value="${id}">
        <tr>
            <td colspan="2"><h1>空气质量信息维护页面</h1></td>
        </tr>
        <td>监测区域：</td>
        <td>
            <input type="hidden" value="${airQualityIndex.districtId }" id="rid" />
            <select name="districtId">
                <c:if test="${districtList != null }">
                    <option value="0">--请选择--</option>
                    <c:forEach var="dis" items="${districtList}">
                        <option <c:if test="${dis.id == airQualityIndex.districtId }">selected="selected"</c:if>
                                value="${dis.id}">${dis.name}</option>
                    </c:forEach>
                </c:if>
            </select>
        </td>
        </tr>
        <tr>
            <td>监测日期：</td>
            <td>
                <%--<fmt:formatDate value="${airQualityIndex.monitorTime}" pattern="yyyy-MM-dd" Class="Wdate" readonly="readonly" onclick="WdatePicker();"/>--%>
                <input type="text"  value="${airQualityIndex.monitorTime}"  Class="Wdate" readonly="readonly" onclick="WdatePicker();">
            </td>
        </tr>
        <tr>
            <td>PM10值：</td>
            <td>
                <input type="text" name="pm10" value="${airQualityIndex.pm10}">
            </td>
        </tr>
        <tr>
            <td>PM2.5值：</td>
            <td>
                <input type="text" name="pm25" value="${airQualityIndex.pm25}">
            </td>
        </tr>
        <tr>
            <td>监测站：</td>
            <td>
                <input type="text" name="monitoringStation" value="${airQualityIndex.monitoringStation}">
            </td>
        </tr>
        <tr  align="center">
            <td colspan="2">
                <label for="date">最后修改时间：</label>
                <fmt:formatDate value="${airQualityIndex.lastModifyTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                <%--<input type="text" name="lastModifyTime" value="${airQualityIndex.lastModifyTime}">--%>
            </td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="修改" onclick="document.myFrm.action='/modifyAirQualityIndex'">
                <input type="submit" value="删除" onclick="document.myFrm.action='/deleteAirQualityIndexs'">
                <input type="reset" value="返回" onclick="javascript:history.back(-1);">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

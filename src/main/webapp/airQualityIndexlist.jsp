<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>空气质量指数页面</title>
</head>
<body>
    <form action="" method="post">
        <table align="center">
            <tr align="center">
                <td colspan="6" align="center"><h1>空气质量检测信息库</h1></td>
            </tr>
            <input type="hidden" name="pageIndex" value="1"/>
            <tr>
                <td colspan="4" align="center">
                    <lable>按区域查询</lable>
                    <select name="queryDistrictName">
                        <c:if test="${districtList != null }">
                            <option value="0">--请选择--</option>
                            <c:forEach var="dis" items="${districtList}">
                                <option <c:if test="${dis.id == queryDistrictName }">selected="selected"</c:if>
                                        value="${dis.id}">${dis.name}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                    <input type="submit" value="查找">
                </td>
                <td colspan="2" align="center">
                    <a href="/toadd">添加空气质量信息</a>
                </td>
            </tr>
            <tr align="center" style="background-color: cornflowerblue">
                <td width="100">序号</td>
                <td width="200">区域</td>
                <td width="200">检测时间</td>
                <td width="100">PM10数据</td>
                <td width="100">PM2.5数据</td>
                <td width="200">检测站</td>
            </tr>
            <c:forEach items="${pager.datas}" var="air" varStatus="status">
                <c:if test="${status.index % 2 == 0}">
                    <tr style="background-color:lavender" align="center">
                        <%--<td width="200">${status.index+1}</td>--%>
                        <td width="200">${air.id}</td>
                        <td width="200"><a href="/toupdate/${air.id}">${air.district.name}</a></td>
                        <td width="200">
                            <fmt:formatDate value="${air.monitorTime}" pattern="yyyy-MM-dd" />
                        </td>
                        <td width="100">${air.pm10}</td>
                        <td width="100">${air.pm25}</td>
                        <td width="200">${air.monitoringStation}</td>
                    </tr>
                </c:if>
                <c:if test="${status.index % 2 == 1}">
                    <tr style="background-color:azure" align="center">
                        <%--<td width="200">${status.index+1}</td>--%>
                        <td width="200">${air.id}</td>
                        <td width="200"><a href="/toupdate/${air.id}">${air.district.name}</a></td>
                        <td width="200">
                            <fmt:formatDate value="${air.monitorTime}" pattern="yyyy-MM-dd" />
                        </td>
                        <td width="100">${air.pm10}</td>
                        <td width="100">${air.pm25}</td>
                        <td width="200">${air.monitoringStation}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
        <div style="text-align: center">
            <input type="hidden" id="totalPageCount" value="${pager.totalPage}"/>
            <c:import url="rollpage.jsp">
                <c:param name="totalCount" value="${pager.totalRows}"/>
                <c:param name="currentPageNo" value="${pager.pageNo}"/>
                <c:param name="totalPageCount" value="${pager.totalPage}"/>
            </c:import>
        </div>
    </form>
</body>
</html>

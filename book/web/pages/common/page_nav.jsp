<%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-06-19
  Time: 10:37 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNO > 1}">
        <a href="${requestScope.page.url}&pageNO=1">首页</a>
        <a href="${requestScope.page.url}&pageNO=${requestScope.page.pageNO -1 }">上一页</a>
    </c:if>
    <%--			<a href="${requestScope.page.url}&pageNO=${requestScope.page.pageNO -1 }">${requestScope.page.pageNO -1 }</a>--%>
    <%--			【${requestScope.page.pageNO}】--%>
    <%--			--%>
    <%--			<a href="${requestScope.page.url}&pageNO=${requestScope.page.pageNO +1 }">${requestScope.page.pageNO +1 }</a>--%>
    <c:choose>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1" />
            <c:set var="end" value="${requestScope.page.pageTotal}" />
        </c:when>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <c:when test="${requestScope.page.pageNO <= 3}">
                    <c:set var="begin" value="1" />
                    <c:set var="end" value="5" />
                </c:when>
                <c:when test="${requestScope.page.pageNO > requestScope.page.pageTotal -3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal -4}" />
                    <c:set var="end" value="${requestScope.page.pageTotal}" />
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNO -2}" />
                    <c:set var="end" value="${requestScope.page.pageNO + 2}" />
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNO}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.page.pageNO}">
            <a href="${requestScope.page.url}&pageNO=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pageNO < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNO=${requestScope.page.pageNO + 1 }">下一页</a>
        <a href="${requestScope.page.url}&pageNO=${requestScope.page.pageTotal }">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${param.pageNO}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script type="text/javascript">
        $(function(){
            //redirect to the
            $("#searchPageBtn").click(function(){
                var pageNO = $("#pn_input").val();
                var pageTotal = ${requestScope.page.pageTotal};
                if(pageNO < 1){
                    alert("Page number is smaller than 1");
                } else if (pageNO > pageTotal){
                    alert("Page number is greater than maximum number of pages")
                } else{
                    location.href = "${pageScope.basePath}${requestScope.page.url}&pageNO=" + pageNO;
                }
            });
        });
    </script>
</div>


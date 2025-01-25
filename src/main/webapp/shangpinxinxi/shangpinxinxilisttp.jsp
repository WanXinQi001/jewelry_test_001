<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/popup.js"></script>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <title>商品信息</title>

    <link href="../qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="../qtimages/css/index.css">
</head>

<%

%>

<body>
<jsp:include page="../qttop.jsp"></jsp:include>
<jsp:include page="../bht.jsp"></jsp:include>
<section id="introduce">
    <div class="container">
        <div class="head text-center">
            <h3>商品信息</h3>
        </div>

        <link rel="stylesheet" href="../images/hsgcommon/divqt.css" type="text/css">
        <form action="spxxListtp.do" name="myform" method="post" style="width:100%">
            查询&nbsp;&nbsp;&nbsp;&nbsp;
<%--            商品编号：<input name="shangpinbianhao" type="text" id="shangpinbianhao" class="form-control2"/>--%>
            商品名称：<input name="shangpinmingcheng" type="text" id="shangpinmingcheng" class="form-control2"/>
            材质：
<%--            <input name="caizhi" type="text" id="caizhi" class="form-control2"/>--%>
            <select name="caizhi"  id="caizhi" class="form-control2">
                <option value="">请选择</option>
                <c:forEach var="m" items="${spxxcaizhi}">
                    <option value="${m}">${m}</option>
                </c:forEach>
            </select>
            克重：从<input name="kezhong1" type="number" step="0.001" id="kezhong1" class="form-control2" placeholder="不低于"/>克
                到<input name="kezhong2" type="number" step="0.001"  id="kezhong2" class="form-control2" placeholder="不高于"/>克
            &nbsp;&nbsp;&nbsp;&nbsp;
            价格：从<input name="jiage1" type="number"  step="0.001" id="jiage1" class="form-control2" placeholder="不低于"/>元
                    到<input name="jiage2" type="number" step="0.001" id="jiage2" class="form-control2" placeholder="不高于"/>元
<%--            工号：<input name="gonghao" type="text" id="gonghao" class="form-control2"/>--%>
<%--            部门：<input name="bumen" type="text" id="bumen" class="form-control2"/>--%>
            <input type="submit" value="查询"/>
            <input type="button" name="Submit2" value="切换视图" onClick="javascript:location.href='spxxList.do';"/>
        </form>
        <br/>

        <table width="100%" height="12%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <%
                    int i = 0;
                %>
                <c:forEach items="${list}" var="u">
                    <%
                        i++;
                    %>
                    <td height="316" align="center">
                        <table width="225" height="285" border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td height="250" align="center"><a href="spxxDetail.do?id=${u.id}"><img
                                        src="${u.tupian}" width="210" height="250" border="0"/></a></td>
                            </tr>
                            <tr>
                                <td height="26" align="center">${u.shangpinmingcheng}</td>
                            </tr>
                        </table>
                    </td>
                    <%
                        if (i == 4) {
                            i = 0;
                            out.print("</tr><tr>");
                        }


                    %>
                </c:forEach>


            </tr>
        </table>
        <br>

        <p align="center"><c:if test="${sessionScope.p==1}">
            <c:if test="${page.page>1}">
                <a href="spxxListtp.do?page=1">首页</a>
                <a href="spxxListtp.do?page=${page.page-1}"> 上一页</a> </c:if>
            <c:if test="${page.page<page.totalPage}">
                <a href="spxxListtp.do?page=${page.page+1}">下一页</a>
                <a href="spxxListtp.do?page=${page.totalPage}">末页</a> </c:if>
        </c:if>
        </p>

    </div>
</section>
<jsp:include page="../qtdown.jsp"></jsp:include>
<jsp:include page="../qtuserlog.jsp"></jsp:include>
<script src="../qtimages/lib/jquery/jquery.min.js"></script>
<script src="../qtimages/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="../qtimages/js/index.js"></script>

</body>
</html>

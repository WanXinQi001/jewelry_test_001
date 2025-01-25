<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<section id="slider" class="carousel slide" data-ride="carousel">
    <!-- 小圆点-->
    <ol class="carousel-indicators">
        <li data-target="#slider" data-slide-to="0" class="active"></li>
        <li data-target="#slider" data-slide-to="1"></li>
        <li data-target="#slider" data-slide-to="2"></li>
        <li data-target="#slider" data-slide-to="3"></li>
        <li data-target="#slider" data-slide-to="4"></li>
    </ol>

    <!-- 图片轮播 -->
    <div class="carousel-inner" role="listbox">
        <%
            int xxbhti = 0;
            String sqlbht = "select id, shouyetupian from xinwentongzhi where leibie='变幻图'  order by id desc limit 0,5";
            ResultSet RS_resultbht = connDbBean.executeQuery(sqlbht);
            while (RS_resultbht.next()) {
                xxbhti++;
        %>

        <div class="item <%if(xxbhti==1){out.print("active");}%>">
            <img onClick="javascript:location.href='../xwtzDetail.do?id=<%=RS_resultbht.getString("id")%>';"
                 style="cursor:pointer" src="../<%=RS_resultbht.getString("shouyetupian")%>" alt="">
        </div>
        <%
            }
        %>

    </div>

    <!-- 左右按钮控制 -->
    <a class="left carousel-control" href="#slider" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#slider" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</section>
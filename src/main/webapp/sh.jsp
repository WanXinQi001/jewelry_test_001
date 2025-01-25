<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ page isELIgnored="false" %>


<%
    String yuan = request.getParameter("yuan");
    String id = request.getParameter("id");
    String status = request.getParameter("status");
    String tablename = request.getParameter("tablename");
    String sql = "";
    sql = "update " + request.getParameter("tablename") + " set issh='是', status='待收货' where id=" + request.getParameter("id");


    connDbBean.hsgexecute(sql);
    if (request.getParameter("tablename").equals("shangpingoumai")) {
        out.print("<script>javascript:alert('审核成功！');location.href='" + request.getParameter("tablename") + "/" + request.getParameter("tablename") + "List.do';</script>");

    } else {
        out.print("<script>javascript:alert('审核成功！');location.href='" + request.getParameter("tablename") + "List.do';</script>");

    }

%>




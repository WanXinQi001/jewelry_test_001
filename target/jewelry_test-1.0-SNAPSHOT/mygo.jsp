<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%
if(request.getSession().getAttribute("cx").equals("厂商")){response.sendRedirect("leftlist/left_changshang.jsp");}
if(request.getSession().getAttribute("cx").equals("超级管理员") || request.getSession().getAttribute("cx").equals("普通管理员")){response.sendRedirect("leftlist/left_guanliyuan.jsp");}
if(request.getSession().getAttribute("cx").equals("会员")){response.sendRedirect("leftlist/left_huiyuan.jsp");}
if(request.getSession().getAttribute("cx").equals("员工")){response.sendRedirect("leftlist/left_yuangong.jsp");}
if(request.getSession().getAttribute("cx").equals("注册用户")){response.sendRedirect("leftlist/left_zhuceyonghu.jsp");}

 %>
  </body>
</html>
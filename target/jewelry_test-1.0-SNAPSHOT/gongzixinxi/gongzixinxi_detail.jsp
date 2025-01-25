<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>工资信息详细</title>
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">

  </head>

  <body >

  工资信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${gongzixinxi.bianhao}</td>
     <td width='11%'>名称：</td><td width='39%'>${gongzixinxi.mingcheng}</td></tr><tr>
     <td width='11%'>工号：</td><td width='39%'>${gongzixinxi.gonghao}</td>
     <td width='11%'>姓名：</td><td width='39%'>${gongzixinxi.xingming}</td></tr><tr>
     <td width='11%'>性别：</td><td width='39%'>${gongzixinxi.xingbie}</td>
     <td width='11%'>部门：</td><td width='39%'>${gongzixinxi.bumen}</td></tr><tr>
     <td width='11%'>基本工资：</td><td width='39%'>${gongzixinxi.jibengongzi}</td>
<%--     <td width='11%'>提成：</td><td width='39%'>${gongzixinxi.ticheng}</td></tr><tr>--%>
     <td width='11%'>补贴：</td><td width='39%'>${gongzixinxi.butie}</td>
     <td width='11%'>实发工资：</td><td width='39%'>${gongzixinxi.shifagongzi}</td></tr><tr>
     <td width='11%'>工资日期：</td><td width='39%'>${gongzixinxi.gongziriqi}</td>
     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>


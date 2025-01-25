<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>财务收入详细</title>
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">

  </head>

  <body >

  财务收入详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${caiwushouru.bianhao}</td>
     <td width='11%'>名称：</td><td width='39%'>${caiwushouru.mingcheng}</td></tr><tr>
     <td width='11%'>销售收入：</td><td width='39%'>${caiwushouru.xiaoshoushouru}</td>
     <td width='11%'>政府补贴：</td><td width='39%'>${caiwushouru.zhengfubutie}</td></tr><tr>
     <td width='11%'>其他收入：</td><td width='39%'>${caiwushouru.qitashouru}</td>
     <td width='11%'>总收入：</td><td width='39%'>${caiwushouru.zongshouru}</td></tr><tr>
     <td width='11%'>日期：</td><td width='39%'>${caiwushouru.riqi}</td>
     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>


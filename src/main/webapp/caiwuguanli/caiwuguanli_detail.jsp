<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>财务管理详细</title>
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">

  </head>

  <body >

  财务管理详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${caiwuguanli.bianhao}</td>
     <td width='11%'>名称：</td><td width='39%'>${caiwuguanli.mingcheng}</td></tr><tr>
     <td width='11%'>总收入：</td><td width='39%'>${caiwuguanli.zongshouru}</td>
     <td width='11%'>总支出：</td><td width='39%'>${caiwuguanli.zongzhichu}</td></tr><tr>
     <td width='11%'>总利润：</td><td width='39%'>${caiwuguanli.zonglirun}</td>
     <td width='11%'>发布日期：</td><td width='39%'>${caiwuguanli.faburiqi}</td></tr><tr>
     <td width='11%'>发布人：</td><td width='39%'>${caiwuguanli.faburen}</td>
     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>


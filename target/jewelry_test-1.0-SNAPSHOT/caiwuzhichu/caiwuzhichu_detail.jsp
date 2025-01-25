<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>财务支出详细</title>
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">

  </head>

  <body >

  财务支出详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${caiwuzhichu.bianhao}</td>
     <td width='11%'>名称：</td><td width='39%'>${caiwuzhichu.mingcheng}</td></tr><tr>
     <td width='11%'>采购支出：</td><td width='39%'>${caiwuzhichu.caigouzhichu}</td>
     <td width='11%'>工资支出：</td><td width='39%'>${caiwuzhichu.gongzizhichu}</td></tr><tr>
     <td width='11%'>回收成本：</td><td width='39%'>${caiwuzhichu.huishouchengben}</td>
     <td width='11%'>其他支出：</td><td width='39%'>${caiwuzhichu.qitazhichu}</td></tr><tr>
     <td width='11%'>总支出：</td><td width='39%'>${caiwuzhichu.zongzhichu}</td>
     <td width='11%'>日期：</td><td width='39%'>${caiwuzhichu.riqi}</td>
     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>


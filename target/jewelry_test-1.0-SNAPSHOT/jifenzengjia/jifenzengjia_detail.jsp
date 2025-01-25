<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>积分增加详细</title>
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">

  </head>

  <body >

  积分增加详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>销售单号：</td><td width='39%'>${jifenzengjia.xiaoshoudanhao}</td>
     <td width='11%'>获得积分：</td><td width='39%'>${jifenzengjia.huodejifen}</td></tr><tr>
     <td width='11%'>卡号：</td><td width='39%'>${jifenzengjia.kahao}</td>
     <td width='11%'>姓名：</td><td width='39%'>${jifenzengjia.xingming}</td></tr><tr>
     <td width='11%'>积分：</td><td width='39%'>${jifenzengjia.jifen}</td>
     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>


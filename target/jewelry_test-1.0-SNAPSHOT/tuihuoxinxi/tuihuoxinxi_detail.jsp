﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>退货信息详细</title>
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">

  </head>

  <body >

  退货信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>销售单号：</td><td width='39%'>${tuihuoxinxi.xiaoshoudanhao}</td>
     <td width='11%'>商品名称：</td><td width='39%'>${tuihuoxinxi.shangpinmingcheng}</td></tr><tr>
     <td width='11%'>材质：</td><td width='39%'>${tuihuoxinxi.caizhi}</td>
     <td width='11%'>克重：</td><td width='39%'>${tuihuoxinxi.kezhong}</td></tr><tr>
     <td width='11%'>退货原因：</td><td width='39%'>${tuihuoxinxi.tuihuoyuanyin}</td>
     <td width='11%'>回复：</td><td width='39%'>${tuihuoxinxi.huifu}</td></tr><tr>
     <td width='11%'>退货日期：</td><td width='39%'>${tuihuoxinxi.tuihuoriqi}</td>
     <td width='11%'>卡号：</td><td width='39%'>${tuihuoxinxi.kahao}</td></tr><tr>
     <td width='11%'>姓名：</td><td width='39%'>${tuihuoxinxi.xingming}</td>
     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>


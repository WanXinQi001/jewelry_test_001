<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>采购信息详细</title>
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">

  </head>

  <body >

  采购信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>入库单号：</td><td width='39%'>${caigouxinxi.rukudanhao}</td>
     <td width='11%'>商品名称：</td><td width='39%'>${caigouxinxi.shangpinmingcheng}</td></tr><tr>
     <td width='11%'>材质：</td><td width='39%'>${caigouxinxi.caizhi}</td>
     <td width='11%'>库存：</td><td width='39%'>${caigouxinxi.kucun}</td></tr><tr>
     <td width='11%'>采购价格：</td><td width='39%'>${caigouxinxi.caigoujiage}</td>
     <td width='11%'>采购数量：</td><td width='39%'>${caigouxinxi.caigoushuliang}</td></tr><tr>
     <td width='11%'>总价格：</td><td width='39%'>${caigouxinxi.zongjiage}</td>
     <td width='11%'>账号：</td><td width='39%'>${caigouxinxi.zhanghao}</td></tr><tr>
     <td width='11%'>公司名称：</td><td width='39%'>${caigouxinxi.gongsimingcheng}</td>
     <td width='11%'>采购日期：</td><td width='39%'>${caigouxinxi.caigouriqi}</td></tr><tr>
     <td width='11%'>工号：</td><td width='39%'>${caigouxinxi.gonghao}</td>
     <td width='11%'>姓名：</td><td width='39%'>${caigouxinxi.xingming}</td></tr><tr>
     <td width='11%'>部门：</td><td width='39%'>${caigouxinxi.bumen}</td>
     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>


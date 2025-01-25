<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>员工信息详细</title>
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">

  </head>

  <body >

  员工信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>工号：</td><td width='39%'>${yuangongxinxi.gonghao}</td>
<td  rowspan=8 align=center><a href=${yuangongxinxi.zhaopian} target=_blank><img src=${yuangongxinxi.zhaopian} width=228 height=215 border=0></a></td></tr><tr>
<td width='11%' height=44>密码：</td><td width='39%'>${yuangongxinxi.mima}</td>
</tr><tr>
<td width='11%' height=44>姓名：</td><td width='39%'>${yuangongxinxi.xingming}</td>
</tr><tr>
<td width='11%' height=44>性别：</td><td width='39%'>${yuangongxinxi.xingbie}</td>
</tr><tr>

<td width='11%' height=44>部门：</td><td width='39%'>${yuangongxinxi.bumen}</td>
</tr><tr>
<td width='11%' height=44>身份证：</td><td width='39%'>${yuangongxinxi.shenfenzheng}</td>
</tr><tr>
<td width='11%' height=44>手机：</td><td width='39%'>${yuangongxinxi.shouji}</td>
</tr><tr>
<td width='11%' height=44>住址：</td><td width='39%'>${yuangongxinxi.zhuzhi}</td>
</tr><tr>
<td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>


<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/popup.js"></script>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <title>采购信息</title>

    <link href="../qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="../qtimages/css/index.css">
</head>
<script language=javascript src='../js/popup.js'></script>
<script language=javascript> 
function hsgpinglun(nbiao,nid){ 
popheight=450;
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'在线评论',550,250) ;
}
</script> 
<%
	String id=request.getParameter("id");
	
     %>
<body>
<jsp:include page="../qttop.jsp"></jsp:include>
<jsp:include page="../bht.jsp"></jsp:include>
    <section id="introduce">
        <div class="container">
			<div class="head text-center">
                    <h3>采购信息</h3>
            </div>
          
		
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
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
     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />
<input type=button name=Submit52 value=打印 onClick="javascript:window.print()"  /> <!--jixaaxnnxiu-->
</td></tr>
    
  </table>
						  
        </div>
    </section>
<jsp:include page="../qtdown.jsp"></jsp:include>
<jsp:include page="../qtuserlog.jsp"></jsp:include>
    <script src="../qtimages/lib/jquery/jquery.min.js"></script>
    <script src="../qtimages/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="../qtimages/js/index.js"></script>
  
</body> 
</html>

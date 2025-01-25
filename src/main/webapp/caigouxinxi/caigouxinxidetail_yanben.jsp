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
    <title>�ɹ���Ϣ</title>

    <link href="../qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="../qtimages/css/index.css">
</head>
<script language=javascript src='../js/popup.js'></script>
<script language=javascript> 
function hsgpinglun(nbiao,nid){ 
popheight=450;
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'��������',550,250) ;
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
                    <h3>�ɹ���Ϣ</h3>
            </div>
          
		
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%'>��ⵥ�ţ�</td><td width='39%'>${caigouxinxi.rukudanhao}</td>
     <td width='11%'>��Ʒ���ƣ�</td><td width='39%'>${caigouxinxi.shangpinmingcheng}</td></tr><tr>
     <td width='11%'>���ʣ�</td><td width='39%'>${caigouxinxi.caizhi}</td>
     <td width='11%'>��棺</td><td width='39%'>${caigouxinxi.kucun}</td></tr><tr>
     <td width='11%'>�ɹ��۸�</td><td width='39%'>${caigouxinxi.caigoujiage}</td>
     <td width='11%'>�ɹ�������</td><td width='39%'>${caigouxinxi.caigoushuliang}</td></tr><tr>
     <td width='11%'>�ܼ۸�</td><td width='39%'>${caigouxinxi.zongjiage}</td>
     <td width='11%'>�˺ţ�</td><td width='39%'>${caigouxinxi.zhanghao}</td></tr><tr>
     <td width='11%'>��˾���ƣ�</td><td width='39%'>${caigouxinxi.gongsimingcheng}</td>
     <td width='11%'>�ɹ����ڣ�</td><td width='39%'>${caigouxinxi.caigouriqi}</td></tr><tr>
     <td width='11%'>���ţ�</td><td width='39%'>${caigouxinxi.gonghao}</td>
     <td width='11%'>������</td><td width='39%'>${caigouxinxi.xingming}</td></tr><tr>
     <td width='11%'>���ţ�</td><td width='39%'>${caigouxinxi.bumen}</td>
     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=���� onClick="javascript:history.back()" />
<input type=button name=Submit52 value=��ӡ onClick="javascript:window.print()"  /> <!--jixaaxnnxiu-->
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


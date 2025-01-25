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
    <title>��Ʒ��Ϣ</title>

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
                    <h3>��Ʒ��Ϣ</h3>
            </div>
          
		
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%' height=44>��Ʒ��ţ�</td><td width='39%'>${shangpinxinxi.shangpinbianhao}</td><td  rowspan=11 align=center><a href=${shangpinxinxi.tupian} target=_blank><img src=${shangpinxinxi.tupian}  width=228 height=215 border=0></a></td></tr><tr>
         <td width='11%' height=44>��Ʒ���ƣ�</td><td width='39%'>${shangpinxinxi.shangpinmingcheng}</td></tr><tr>
         <td width='11%' height=44>���ʣ�</td><td width='39%'>${shangpinxinxi.caizhi}</td></tr><tr>
         <td width='11%' height=44>���أ�</td><td width='39%'>${shangpinxinxi.kezhong}</td></tr><tr>
         <td width='11%' height=44>��Ʒ���ۣ�</td><td width='39%'>${shangpinxinxi.wupindanjia}</td></tr><tr>
         
         
         <td width='11%' height=44>���ţ�</td><td width='39%'>${shangpinxinxi.gonghao}</td></tr><tr>
         <td width='11%' height=44>������</td><td width='39%'>${shangpinxinxi.xingming}</td></tr><tr>
         <td width='11%' height=44>���ţ�</td><td width='39%'>${shangpinxinxi.bumen}</td></tr><tr>
         <td width='11%' height=44>�۸�</td><td width='39%'>${shangpinxinxi.jiage}</td></tr><tr>
         <td width='11%' height=44>��棺</td><td width='39%'>${shangpinxinxi.kucun}</td></tr><tr>
         <td width='11%' height=44>��û��֣�</td><td width='39%'>${shangpinxinxi.huodejifen}</td></tr><tr>
         <td width='11%' height=100  >������</td><td width='39%' colspan=2 height=100 >${shangpinxinxi.huodejifen}</td></tr><tr>							 
                                <td colspan="3"><table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse" class="newsline">
                                  <tr>
                                    <td width="30" align="center" bgcolor="CCFFFF">���</td>
                                    <td width="471" bgcolor='#CCFFFF'>��������</td>
                                    <td width="88" bgcolor='#CCFFFF'>����</td>
                                    <td width="88" bgcolor='#CCFFFF'>������</td>
                                    <td width="138" align="center" bgcolor="CCFFFF">����ʱ��</td>
                                  </tr>
								  <%@page import="com.util.db"%>
                                   <%
								   int pli=0;
    for(HashMap map:new db().getpinglun("shangpinxinxi",id)){
	pli=pli+1;
     %>
                                   <tr>
                                    <td width="30" align="center" bgcolor='#CCFF99'><%=pli%></td>
                                    <td width="471" bgcolor='#CCFF99'><%=map.get("pinglunneirong") %></td>
                                    <td width="88" bgcolor='#CCFF99'><%=map.get("pingfen") %></td>
                                    <td width="88" bgcolor='#CCFF99'><%=map.get("pinglunren") %></td>
                                    <td width="138" align="center" bgcolor="CCFF99"><%=map.get("addtime") %></td>
                                  </tr>
                                  <%
								 
								  }
								   %>
                                </table></td>
                                </tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=���� onClick="javascript:history.back()" />
<input type=button name=Submit52 value=��ӡ onClick="javascript:window.print()" /> <!--jixaaxnnxiu-->
<input type=button name=Submit53 value=���� onClick="javascript:hsgpinglun('shangpinxinxi','<%=id%>')"/>
<input type=button name=Submit52 value=�ղ� onClick="javascript:location.href='jrsc.jsp?id=<%=id%>&biaoj=spxx&biao=shangpinxinxi&ziduan=shangpinmingcheng';" />
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


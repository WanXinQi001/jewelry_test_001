<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/popup.js"></script>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>��Ʒ��Ϣ��ѯ</TITLE>
	<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">��Ʒ��Ϣ�б�</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="shangpinxinxiList.do" name="myform" method="post">
									��ѯ   ��Ʒ��ţ�<input name="shangpinbianhao" type="text" id="shangpinbianhao" class="form-control2" />  ��Ʒ���ƣ�<input name="shangpinmingcheng" type="text" id="shangpinmingcheng" class="form-control2" />  ���ʣ�<input name="caizhi" type="text" id="caizhi" class="form-control2" />  ���أ�<input name="kezhong" type="text" id="kezhong" class="form-control2" />  ��Ʒ���ۣ�<input name="wupindanjia" type="text" id="wupindanjia" class="form-control2" />  ���ţ�<input name="gonghao" type="text" id="gonghao" class="form-control2" />  ���ţ�<input name="bumen" type="text" id="bumen" class="form-control2" />
									<input type="submit" value="��ѯ" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">���</td>
                            <td align='center' bgcolor='#ebf0f7'>��Ʒ���</td>
    <td align='center' bgcolor='#ebf0f7'>��Ʒ����</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td align='center' bgcolor='#ebf0f7'>��Ʒ����</td>
    <td  width='90' align='center' bgcolor='#ebf0f7'>ͼƬ</td>
    
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td align='center' bgcolor='#ebf0f7'>�۸�</td>
    <td align='center' bgcolor='#ebf0f7'>���</td>
    <td align='center' bgcolor='#ebf0f7'>��û���</td>
    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> ���ʱ�� </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> ���� </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.shangpinbianhao}</td>
    <td>${u.shangpinmingcheng}</td>
    <td>${u.caizhi}</td>
    <td>${u.kezhong}</td>
    <td>${u.wupindanjia}</td>
    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.tupian}' target='_blank'><img src='${u.tupian}' width=88 height=99 border=0 /></a></td>
    
    <td>${u.gonghao}</td>
    <td>${u.xingming}</td>
    <td>${u.bumen}</td>
    <td>${u.jiage}</td>
    <td>${u.kucun}</td>
    <td>${u.huodejifen}</td>
    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"> <!--lianjie1--> <a class="btn btn-info btn-small" href="spxxDetail.do?id=${u.id}" target="_blank">��ϸ</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from shangpinxinxi where 1=1 ";
				
if(request.getParameter("shangpinbianhao")=="" ||request.getParameter("shangpinbianhao")==null ){}else{String nshangpinbianhao=new String(request.getParameter("shangpinbianhao").getBytes("8859_1"));if(nshangpinbianhao.contains("?")){nshangpinbianhao=request.getParameter("shangpinbianhao");}sql=sql+" and shangpinbianhao like '%"+nshangpinbianhao+"%'";}
if(request.getParameter("shangpinmingcheng")=="" ||request.getParameter("shangpinmingcheng")==null ){}else{String nshangpinmingcheng=new String(request.getParameter("shangpinmingcheng").getBytes("8859_1"));if(nshangpinmingcheng.contains("?")){nshangpinmingcheng=request.getParameter("shangpinmingcheng");}sql=sql+" and shangpinmingcheng like '%"+nshangpinmingcheng+"%'";}
if(request.getParameter("caizhi")=="" ||request.getParameter("caizhi")==null ){}else{String ncaizhi=new String(request.getParameter("caizhi").getBytes("8859_1"));if(ncaizhi.contains("?")){ncaizhi=request.getParameter("caizhi");}sql=sql+" and caizhi like '%"+ncaizhi+"%'";}
if(request.getParameter("kezhong")=="" ||request.getParameter("kezhong")==null ){}else{String nkezhong=new String(request.getParameter("kezhong").getBytes("8859_1"));if(nkezhong.contains("?")){nkezhong=request.getParameter("kezhong");}sql=sql+" and kezhong like '%"+nkezhong+"%'";}
if(request.getParameter("wupindanjia")=="" ||request.getParameter("wupindanjia")==null ){}else{String nwupindanjia=new String(request.getParameter("wupindanjia").getBytes("8859_1"));if(nwupindanjia.contains("?")){nwupindanjia=request.getParameter("wupindanjia");}sql=sql+" and wupindanjia like '%"+nwupindanjia+"%'";}
if(request.getParameter("gonghao")=="" ||request.getParameter("gonghao")==null ){}else{String ngonghao=new String(request.getParameter("gonghao").getBytes("8859_1"));if(ngonghao.contains("?")){ngonghao=request.getParameter("gonghao");}sql=sql+" and gonghao like '%"+ngonghao+"%'";}
if(request.getParameter("bumen")=="" ||request.getParameter("bumen")==null ){}else{String nbumen=new String(request.getParameter("bumen").getBytes("8859_1"));if(nbumen.contains("?")){nbumen=request.getParameter("bumen");}sql=sql+" and bumen like '%"+nbumen+"%'";}
			sql+=" order by id desc";

							
							int kucuntx=0;
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						
						if(Float.valueOf(RS_result.getString("kucun")).floatValue()<50){kucuntx=kucuntx+1;}

						
			 }
			%>
		 
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="shangpinxinxiList.do?page=1" >��ҳ</a>
             <a href="shangpinxinxiList.do?page=${page.page-1 }"> ��һҳ</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="shangpinxinxiList.do?page=${page.page+1 }">��һҳ</a>
			<a href="shangpinxinxiList.do?page=${page.totalPage }">ĩҳ</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
 <%
 if(kucuntx>0)
{
%>
 <style>
#winpop { width:200px; height:0px; position:absolute; right:0; bottom:0; border:1px solid #666; margin:0; padding:1px; overflow:hidden; display:none;} 
#winpop .title { width:100%; height:22px; line-height:20px; background:#FFCC00; font-weight:bold; text-align:center; font-size:12px;} 
#winpop .con { width:100%; height:90px; line-height:20px; font-weight:bold; font-size:12px; color:#FF0000; text-align:center} 
#silu { font-size:12px; color:#666; position:absolute; right:0; text-align:right; text-decoration:underline; line-height:22px;} 
.close { position:absolute; right:4px; top:-1px; color:#FFF; cursor:pointer} 
</style> 
<script type="text/javascript"> 
function tips_pop(){ 
var MsgPop=document.getElementById("winpop"); 
var popH=parseInt(MsgPop.style.height);//������ĸ߶�ת��Ϊ���� 
if (popH==0){ 
MsgPop.style.display="block";//��ʾ���صĴ��� 
show=setInterval("changeH('up')",2); 
} 
else { 
hide=setInterval("changeH('down')",2); 
} 
} 
function changeH(str) { 
var MsgPop=document.getElementById("winpop"); 
var popH=parseInt(MsgPop.style.height); 
if(str=="up"){ 
if (popH <=100){ 
MsgPop.style.height=(popH+4).toString()+"px"; 
} 
else{ 
clearInterval(show); 
} 
} 
if(str=="down"){ 
if (popH>=4){ 
MsgPop.style.height=(popH-4).toString()+"px"; 
} 
else{ 
clearInterval(hide);  
MsgPop.style.display="none"; //����DIV 
} 
} 
} 
window.onload=function(){ //���� 
document.getElementById('winpop').style.height='0px'; 
setTimeout("tips_pop()",500); //3������tips_pop()������� 
} 
</script> <div id="silu"> 
<body>
</div> 
<div id="winpop"> 
<div class="title">ϵͳ���ѣ� <span class="close" onClick="tips_pop()">X </span> </div> 
<div class="con">��ǰ��<%=kucuntx%>�����ֵ��¼С��50��лл��</div>
<%
}
%>

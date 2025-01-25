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
	<TITLE>�ɹ���Ϣ��ѯ</TITLE>
	<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">�ɹ���Ϣ�б�</td>
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
								<form action="caigouxinxiList.do" name="myform" method="post">
									��ѯ   ��ⵥ�ţ�<input name="rukudanhao" type="text" id="rukudanhao" class="form-control2" />  ��Ʒ���ƣ�<input name="shangpinmingcheng" type="text" id="shangpinmingcheng" class="form-control2" />  ���ʣ�<input name="caizhi" type="text" id="caizhi" class="form-control2" />  �˺ţ�<input name="zhanghao" type="text" id="zhanghao" class="form-control2" />  ��˾���ƣ�<input name="gongsimingcheng" type="text" id="gongsimingcheng" class="form-control2" />  ���ţ�<input name="gonghao" type="text" id="gonghao" class="form-control2" />  ������<input name="xingming" type="text" id="xingming" class="form-control2" />  ���ţ�<input name="bumen" type="text" id="bumen" class="form-control2" />
									<input type="submit" value="��ѯ" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">���</td>
                            <td align='center' bgcolor='#ebf0f7'>��ⵥ��</td>
    <td align='center' bgcolor='#ebf0f7'>��Ʒ����</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td align='center' bgcolor='#ebf0f7'>���</td>
    <td align='center' bgcolor='#ebf0f7'>�ɹ��۸�</td>
    <td align='center' bgcolor='#ebf0f7'>�ɹ�����</td>
    <td align='center' bgcolor='#ebf0f7'>�ܼ۸�</td>
    <td align='center' bgcolor='#ebf0f7'>�˺�</td>
    <td align='center' bgcolor='#ebf0f7'>��˾����</td>
    <td  width='65' align='center' bgcolor='#ebf0f7'>�ɹ�����</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td  width='80' align='center' bgcolor='#ebf0f7'>�Ƿ�֧��</td>
    <td  width='80' align='center' bgcolor='#ebf0f7'>�Ƿ����</td>
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
                             <td>${u.rukudanhao}</td>
    <td>${u.shangpinmingcheng}</td>
    <td>${u.caizhi}</td>
    <td>${u.kucun}</td>
    <td>${u.caigoujiage}</td>
    <td>${u.caigoushuliang}</td>
    <td>${u.zongjiage}</td>
    <td>${u.zhanghao}</td>
    <td>${u.gongsimingcheng}</td>
    <td>${u.caigouriqi}</td>
    <td>${u.gonghao}</td>
    <td>${u.xingming}</td>
    <td>${u.bumen}</td>
    <td align='center' bgcolor='#ebf0f7'>${u.iszf} </td>
    <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=caigouxinxi'"/></td>
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"> <!--lianjie1--> <a class="btn btn-info btn-small" href="caigouxinxiDetail.do?id=${u.id}">��ϸ</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from caigouxinxi where 1=1 ";
				
if(request.getParameter("rukudanhao")=="" ||request.getParameter("rukudanhao")==null ){}else{String nrukudanhao=new String(request.getParameter("rukudanhao").getBytes("8859_1"));if(nrukudanhao.contains("?")){nrukudanhao=request.getParameter("rukudanhao");}sql=sql+" and rukudanhao like '%"+nrukudanhao+"%'";}
if(request.getParameter("shangpinmingcheng")=="" ||request.getParameter("shangpinmingcheng")==null ){}else{String nshangpinmingcheng=new String(request.getParameter("shangpinmingcheng").getBytes("8859_1"));if(nshangpinmingcheng.contains("?")){nshangpinmingcheng=request.getParameter("shangpinmingcheng");}sql=sql+" and shangpinmingcheng like '%"+nshangpinmingcheng+"%'";}
if(request.getParameter("caizhi")=="" ||request.getParameter("caizhi")==null ){}else{String ncaizhi=new String(request.getParameter("caizhi").getBytes("8859_1"));if(ncaizhi.contains("?")){ncaizhi=request.getParameter("caizhi");}sql=sql+" and caizhi like '%"+ncaizhi+"%'";}
if(request.getParameter("zhanghao")=="" ||request.getParameter("zhanghao")==null ){}else{String nzhanghao=new String(request.getParameter("zhanghao").getBytes("8859_1"));if(nzhanghao.contains("?")){nzhanghao=request.getParameter("zhanghao");}sql=sql+" and zhanghao like '%"+nzhanghao+"%'";}
if(request.getParameter("gongsimingcheng")=="" ||request.getParameter("gongsimingcheng")==null ){}else{String ngongsimingcheng=new String(request.getParameter("gongsimingcheng").getBytes("8859_1"));if(ngongsimingcheng.contains("?")){ngongsimingcheng=request.getParameter("gongsimingcheng");}sql=sql+" and gongsimingcheng like '%"+ngongsimingcheng+"%'";}
if(request.getParameter("gonghao")=="" ||request.getParameter("gonghao")==null ){}else{String ngonghao=new String(request.getParameter("gonghao").getBytes("8859_1"));if(ngonghao.contains("?")){ngonghao=request.getParameter("gonghao");}sql=sql+" and gonghao like '%"+ngonghao+"%'";}
if(request.getParameter("xingming")=="" ||request.getParameter("xingming")==null ){}else{String nxingming=new String(request.getParameter("xingming").getBytes("8859_1"));if(nxingming.contains("?")){nxingming=request.getParameter("xingming");}sql=sql+" and xingming like '%"+nxingming+"%'";}
if(request.getParameter("bumen")=="" ||request.getParameter("bumen")==null ){}else{String nbumen=new String(request.getParameter("bumen").getBytes("8859_1"));if(nbumen.contains("?")){nbumen=request.getParameter("bumen");}sql=sql+" and bumen like '%"+nbumen+"%'";}
			sql+=" order by id desc";
double zongjiagez=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						zongjiagez=zongjiagez+Float.valueOf(RS_result.getString("zongjiage")).floatValue();

						
						
			 }
			%>
		�����ܼ۸�:<%=zongjiagez%>�� 
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="caigouxinxiList.do?page=1" >��ҳ</a>
             <a href="caigouxinxiList.do?page=${page.page-1 }"> ��һҳ</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="caigouxinxiList.do?page=${page.page+1 }">��һҳ</a>
			<a href="caigouxinxiList.do?page=${page.totalPage }">ĩҳ</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>


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
	<TITLE>������Ϣ��ѯ</TITLE>
	<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">������Ϣ�б�</td>
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
								<form action="gongzixinxiList.do" name="myform" method="post">
									��ѯ   ��ţ�<input name="bianhao" type="text" id="bianhao" class="form-control2" />  ���ƣ�<input name="mingcheng" type="text" id="mingcheng" class="form-control2" />  ���ţ�<input name="gonghao" type="text" id="gonghao" class="form-control2" />  ������<input name="xingming" type="text" id="xingming" class="form-control2" />  �Ա�<input name="xingbie" type="text" id="xingbie" class="form-control2" />  ���ţ�<input name="bumen" type="text" id="bumen" class="form-control2" />
									<input type="submit" value="��ѯ" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">���</td>
                            <td align='center' bgcolor='#ebf0f7'>���</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td  width='40' align='center' bgcolor='#ebf0f7'>�Ա�</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td align='center' bgcolor='#ebf0f7'>��������</td>
    <td align='center' bgcolor='#ebf0f7'>���</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>
    <td align='center' bgcolor='#ebf0f7'>ʵ������</td>
    <td  width='65' align='center' bgcolor='#ebf0f7'>��������</td>
    
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
                             <td>${u.bianhao}</td>
    <td>${u.mingcheng}</td>
    <td>${u.gonghao}</td>
    <td>${u.xingming}</td>
    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>
    <td>${u.bumen}</td>
    <td>${u.jibengongzi}</td>
    <td>${u.ticheng}</td>
    <td>${u.butie}</td>
    <td>${u.shifagongzi}</td>
    <td>${u.gongziriqi}</td>
    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"> <!--lianjie1--> <a class="btn btn-info btn-small" href="gongzixinxiDetail.do?id=${u.id}">��ϸ</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from gongzixinxi where 1=1 ";
				
if(request.getParameter("bianhao")=="" ||request.getParameter("bianhao")==null ){}else{String nbianhao=new String(request.getParameter("bianhao").getBytes("8859_1"));if(nbianhao.contains("?")){nbianhao=request.getParameter("bianhao");}sql=sql+" and bianhao like '%"+nbianhao+"%'";}
if(request.getParameter("mingcheng")=="" ||request.getParameter("mingcheng")==null ){}else{String nmingcheng=new String(request.getParameter("mingcheng").getBytes("8859_1"));if(nmingcheng.contains("?")){nmingcheng=request.getParameter("mingcheng");}sql=sql+" and mingcheng like '%"+nmingcheng+"%'";}
if(request.getParameter("gonghao")=="" ||request.getParameter("gonghao")==null ){}else{String ngonghao=new String(request.getParameter("gonghao").getBytes("8859_1"));if(ngonghao.contains("?")){ngonghao=request.getParameter("gonghao");}sql=sql+" and gonghao like '%"+ngonghao+"%'";}
if(request.getParameter("xingming")=="" ||request.getParameter("xingming")==null ){}else{String nxingming=new String(request.getParameter("xingming").getBytes("8859_1"));if(nxingming.contains("?")){nxingming=request.getParameter("xingming");}sql=sql+" and xingming like '%"+nxingming+"%'";}
if(request.getParameter("xingbie")=="" ||request.getParameter("xingbie")==null ){}else{String nxingbie=new String(request.getParameter("xingbie").getBytes("8859_1"));if(nxingbie.contains("?")){nxingbie=request.getParameter("xingbie");}sql=sql+" and xingbie like '%"+nxingbie+"%'";}
if(request.getParameter("bumen")=="" ||request.getParameter("bumen")==null ){}else{String nbumen=new String(request.getParameter("bumen").getBytes("8859_1"));if(nbumen.contains("?")){nbumen=request.getParameter("bumen");}sql=sql+" and bumen like '%"+nbumen+"%'";}
			sql+=" order by id desc";
double shifagongziz=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						shifagongziz=shifagongziz+Float.valueOf(RS_result.getString("shifagongzi")).floatValue();

						
						
			 }
			%>
		����ʵ������:<%=shifagongziz%>�� 
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="gongzixinxiList.do?page=1" >��ҳ</a>
             <a href="gongzixinxiList.do?page=${page.page-1 }"> ��һҳ</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="gongzixinxiList.do?page=${page.page+1 }">��һҳ</a>
			<a href="gongzixinxiList.do?page=${page.totalPage }">ĩҳ</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>


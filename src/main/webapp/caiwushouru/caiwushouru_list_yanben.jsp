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
	<TITLE>���������ѯ</TITLE>
	<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">���������б�</td>
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
								<form action="caiwushouruList.do" name="myform" method="post">
									��ѯ   ��ţ�<input name="bianhao" type="text" id="bianhao" class="form-control2" />  ���ƣ�<input name="mingcheng" type="text" id="mingcheng" class="form-control2" />
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
    <td align='center' bgcolor='#ebf0f7'>��������</td>
    <td align='center' bgcolor='#ebf0f7'>��������</td>
    <td align='center' bgcolor='#ebf0f7'>��������</td>
    <td align='center' bgcolor='#ebf0f7'>������</td>
    <td  width='65' align='center' bgcolor='#ebf0f7'>����</td>
    
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
    <td>${u.xiaoshoushouru}</td>
    <td>${u.zhengfubutie}</td>
    <td>${u.qitashouru}</td>
    <td>${u.zongshouru}</td>
    <td>${u.riqi}</td>
    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"> <!--lianjie1--> <a class="btn btn-info btn-small" href="caiwushouruDetail.do?id=${u.id}">��ϸ</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from caiwushouru where 1=1 ";
				
if(request.getParameter("bianhao")=="" ||request.getParameter("bianhao")==null ){}else{String nbianhao=new String(request.getParameter("bianhao").getBytes("8859_1"));if(nbianhao.contains("?")){nbianhao=request.getParameter("bianhao");}sql=sql+" and bianhao like '%"+nbianhao+"%'";}
if(request.getParameter("mingcheng")=="" ||request.getParameter("mingcheng")==null ){}else{String nmingcheng=new String(request.getParameter("mingcheng").getBytes("8859_1"));if(nmingcheng.contains("?")){nmingcheng=request.getParameter("mingcheng");}sql=sql+" and mingcheng like '%"+nmingcheng+"%'";}
			sql+=" order by id desc";
double zongshouruz=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						zongshouruz=zongshouruz+Float.valueOf(RS_result.getString("zongshouru")).floatValue();

						
						
			 }
			%>
		����������:<%=zongshouruz%>�� 
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="caiwushouruList.do?page=1" >��ҳ</a>
             <a href="caiwushouruList.do?page=${page.page-1 }"> ��һҳ</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="caiwushouruList.do?page=${page.page+1 }">��һҳ</a>
			<a href="caiwushouruList.do?page=${page.totalPage }">ĩҳ</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>


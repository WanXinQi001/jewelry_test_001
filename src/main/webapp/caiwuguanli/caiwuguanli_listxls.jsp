<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="caiwuguanlihsgb" scope="page" class="com.bean.CaiwuguanliBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=caiwuguanli.xls");
%>
<html>
  <head>
    <title>财务管理</title>
  </head>

  <body >
 <%
			String sql="select * from caiwuguanli  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>编号</td>
    <td align='center' bgcolor='#ebf0f7'>名称</td>
    <td align='center' bgcolor='#ebf0f7'>总收入</td>
    <td align='center' bgcolor='#ebf0f7'>总支出</td>
    <td align='center' bgcolor='#ebf0f7'>总利润</td>
    <td  width='65' align='center' bgcolor='#ebf0f7'>发布日期</td>
    <td align='center' bgcolor='#ebf0f7'>发布人</td>
    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=caiwuguanlihsgb.getAllCaiwuguanli(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>
    <td>${u.mingcheng}</td>
    <td>${u.zongshouru}</td>
    <td>${u.zongzhichu}</td>
    <td>${u.zonglirun}</td>
    <td>${u.faburiqi}</td>
    <td>${u.faburen}</td>
    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


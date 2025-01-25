<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="jifenzengjiahsgb" scope="page" class="com.bean.JifenzengjiaBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=jifenzengjia.xls");
%>
<html>
  <head>
    <title>积分增加</title>
  </head>

  <body >
 <%
			String sql="select * from jifenzengjia  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>销售单号</td>
    <td align='center' bgcolor='#ebf0f7'>获得积分</td>
    <td align='center' bgcolor='#ebf0f7'>卡号</td>
    <td align='center' bgcolor='#ebf0f7'>姓名</td>
    <td align='center' bgcolor='#ebf0f7'>积分</td>
    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=jifenzengjiahsgb.getAllJifenzengjia(7);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xiaoshoudanhao}</td>
    <td>${u.huodejifen}</td>
    <td>${u.kahao}</td>
    <td>${u.xingming}</td>
    <td>${u.jifen}</td>
    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


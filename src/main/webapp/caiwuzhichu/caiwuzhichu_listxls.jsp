<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="caiwuzhichuhsgb" scope="page" class="com.bean.CaiwuzhichuBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=caiwuzhichu.xls");
%>
<html>
  <head>
    <title>财务支出</title>
  </head>

  <body >
 <%
			String sql="select * from caiwuzhichu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>编号</td>
    <td align='center' bgcolor='#ebf0f7'>名称</td>
    <td align='center' bgcolor='#ebf0f7'>采购支出</td>
    <td align='center' bgcolor='#ebf0f7'>工资支出</td>
    <td align='center' bgcolor='#ebf0f7'>回收成本</td>
    <td align='center' bgcolor='#ebf0f7'>其他支出</td>
    <td align='center' bgcolor='#ebf0f7'>总支出</td>
    <td  width='65' align='center' bgcolor='#ebf0f7'>日期</td>
    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=caiwuzhichuhsgb.getAllCaiwuzhichu(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>
    <td>${u.mingcheng}</td>
    <td>${u.caigouzhichu}</td>
    <td>${u.gongzizhichu}</td>
    <td>${u.huishouchengben}</td>
    <td>${u.qitazhichu}</td>
    <td>${u.zongzhichu}</td>
    <td>${u.riqi}</td>
    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


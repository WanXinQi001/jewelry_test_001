<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="dengjixinxihsgb" scope="page" class="com.bean.DengjixinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=dengjixinxi.xls");
%>
<html>
  <head>
    <title>等级信息</title>
  </head>

  <body >
 <%
			String sql="select * from dengjixinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>会员等级</td>
    <td align='center' bgcolor='#ebf0f7'>折扣</td>
    <td align='center' bgcolor='#ebf0f7'>折扣价格</td>
    <td align='center' bgcolor='#ebf0f7'>备注</td>
    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=dengjixinxihsgb.getAllDengjixinxi(6);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.huiyuandengji}</td>
    <td>${u.zhekou}</td>
    <td>${u.zhekoujiage}</td>
    <td>${u.beizhu}</td>
    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


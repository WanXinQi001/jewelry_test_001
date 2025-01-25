<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="tuihuoxinxihsgb" scope="page" class="com.bean.TuihuoxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=tuihuoxinxi.xls");
%>
<html>
  <head>
    <title>退货信息</title>
  </head>

  <body >
 <%
			String sql="select * from tuihuoxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>销售单号</td>
    <td align='center' bgcolor='#ebf0f7'>商品名称</td>
    <td align='center' bgcolor='#ebf0f7'>材质</td>
    <td align='center' bgcolor='#ebf0f7'>克重</td>
    
    
    <td  width='65' align='center' bgcolor='#ebf0f7'>退货日期</td>
    <td align='center' bgcolor='#ebf0f7'>卡号</td>
    <td align='center' bgcolor='#ebf0f7'>姓名</td>
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
  </tr>
   <%		
				List pagelist3=tuihuoxinxihsgb.getAllTuihuoxinxi(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xiaoshoudanhao}</td>
    <td>${u.shangpinmingcheng}</td>
    <td>${u.caizhi}</td>
    <td>${u.kezhong}</td>
    
    
    <td>${u.tuihuoriqi}</td>
    <td>${u.kahao}</td>
    <td>${u.xingming}</td>
  </tr>
  	<%
  }}
   %>
</table>
<br>
  </body>
</html>


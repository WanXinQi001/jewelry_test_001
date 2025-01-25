<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="jiuliaohuishouhsgb" scope="page" class="com.bean.JiuliaohuishouBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=jiuliaohuishou.xls");
%>
<html>
  <head>
    <title>旧料回收</title>
  </head>

  <body >
 <%
			String sql="select * from jiuliaohuishou  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>回收单号</td>
    <td align='center' bgcolor='#ebf0f7'>物品名称</td>
    <td align='center' bgcolor='#ebf0f7'>材质</td>
    <td align='center' bgcolor='#ebf0f7'>克重</td>
    <td align='center' bgcolor='#ebf0f7'>数量</td>
    <td  width='90' align='center' bgcolor='#ebf0f7'>图片</td>
    
    
    
    <td align='center' bgcolor='#ebf0f7'>卡号</td>
    <td align='center' bgcolor='#ebf0f7'>姓名</td>
    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>
    <td align='center' bgcolor='#ebf0f7'>手机</td>
    <td  width='80' align='center' bgcolor='#ebf0f7'>是否支付</td>
    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=jiuliaohuishouhsgb.getAllJiuliaohuishou(16);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.huishoudanhao}</td>
    <td>${u.wupinmingcheng}</td>
    <td>${u.caizhi}</td>
    <td>${u.kezhong}</td>
    <td>${u.shuliang}</td>
    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.tupian}' target='_blank'><img src='${u.tupian}' width=88 height=99 border=0 /></a></td>
    
    
    
    <td>${u.kahao}</td>
    <td>${u.xingming}</td>
    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>
    <td>${u.shouji}</td>
    <td align='center' bgcolor='#ebf0f7'>${u.iszf} </td>
    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="yuangongxinxihsgb" scope="page" class="com.bean.YuangongxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=yuangongxinxi.xls");
%>
<html>
  <head>
    <title>员工信息</title>
  </head>

  <body >
 <%
			String sql="select * from yuangongxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>工号</td>
    <td align='center' bgcolor='#ebf0f7'>密码</td>
    <td align='center' bgcolor='#ebf0f7'>姓名</td>
    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>
    <td  width='90' align='center' bgcolor='#ebf0f7'>照片</td>
    <td align='center' bgcolor='#ebf0f7'>部门</td>
    <td align='center' bgcolor='#ebf0f7'>身份证</td>
    <td align='center' bgcolor='#ebf0f7'>手机</td>
    <td align='center' bgcolor='#ebf0f7'>住址</td>
    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=yuangongxinxihsgb.getAllYuangongxinxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.gonghao}</td>
    <td>${u.mima}</td>
    <td>${u.xingming}</td>
    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>
    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.zhaopian}' target='_blank'><img src='${u.zhaopian}' width=88 height=99 border=0 /></a></td>
    <td>${u.bumen}</td>
    <td>${u.shenfenzheng}</td>
    <td>${u.shouji}</td>
    <td>${u.zhuzhi}</td>
    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


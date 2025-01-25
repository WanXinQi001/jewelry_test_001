<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="gongzixinxihsgb" scope="page" class="com.bean.GongzixinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=gongzixinxi.xls");
%>
<html>
  <head>
    <title>工资信息</title>
  </head>

  <body >
 <%
			String sql="select * from gongzixinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>编号</td>
    <td align='center' bgcolor='#ebf0f7'>名称</td>
    <td align='center' bgcolor='#ebf0f7'>工号</td>
    <td align='center' bgcolor='#ebf0f7'>姓名</td>
    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>
    <td align='center' bgcolor='#ebf0f7'>部门</td>
    <td align='center' bgcolor='#ebf0f7'>基本工资</td>
    <td align='center' bgcolor='#ebf0f7'>提成</td>
    <td align='center' bgcolor='#ebf0f7'>补贴</td>
    <td align='center' bgcolor='#ebf0f7'>实发工资</td>
    <td  width='65' align='center' bgcolor='#ebf0f7'>工资日期</td>
    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=gongzixinxihsgb.getAllGongzixinxi(13);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
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
    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


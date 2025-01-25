<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shangpinxinxihsgb" scope="page" class="com.bean.ShangpinxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shangpinxinxi.xls");
%>
<html>
  <head>
    <title>商品信息</title>
  </head>

  <body >
 <%
			String sql="select * from shangpinxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>商品编号</td>
    <td align='center' bgcolor='#ebf0f7'>商品名称</td>
    <td align='center' bgcolor='#ebf0f7'>材质</td>
    <td align='center' bgcolor='#ebf0f7'>克重</td>
    <td align='center' bgcolor='#ebf0f7'>物品单价</td>
    <td  width='90' align='center' bgcolor='#ebf0f7'>图片</td>
    
    <td align='center' bgcolor='#ebf0f7'>工号</td>
    <td align='center' bgcolor='#ebf0f7'>姓名</td>
    <td align='center' bgcolor='#ebf0f7'>部门</td>
    <td align='center' bgcolor='#ebf0f7'>价格</td>
    <td align='center' bgcolor='#ebf0f7'>库存</td>
    <td align='center' bgcolor='#ebf0f7'>获得积分</td>
    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shangpinxinxihsgb.getAllShangpinxinxi(15);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shangpinbianhao}</td>
    <td>${u.shangpinmingcheng}</td>
    <td>${u.caizhi}</td>
    <td>${u.kezhong}</td>
    <td>${u.wupindanjia}</td>
    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.tupian}' target='_blank'><img src='${u.tupian}' width=88 height=99 border=0 /></a></td>
    
    <td>${u.gonghao}</td>
    <td>${u.xingming}</td>
    <td>${u.bumen}</td>
    <td>${u.jiage}</td>
    <td>${u.kucun}</td>
    <td>${u.huodejifen}</td>
    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


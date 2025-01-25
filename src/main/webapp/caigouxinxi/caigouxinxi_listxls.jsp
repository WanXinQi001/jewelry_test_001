<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="caigouxinxihsgb" scope="page" class="com.bean.CaigouxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=caigouxinxi.xls");
%>
<html>
  <head>
    <title>采购信息</title>
  </head>

  <body >
 <%
			String sql="select * from caigouxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>入库单号</td>
    <td align='center' bgcolor='#ebf0f7'>商品名称</td>
    <td align='center' bgcolor='#ebf0f7'>材质</td>
    <td align='center' bgcolor='#ebf0f7'>库存</td>
    <td align='center' bgcolor='#ebf0f7'>采购价格</td>
    <td align='center' bgcolor='#ebf0f7'>采购数量</td>
    <td align='center' bgcolor='#ebf0f7'>总价格</td>
    <td align='center' bgcolor='#ebf0f7'>账号</td>
    <td align='center' bgcolor='#ebf0f7'>公司名称</td>
    <td  width='65' align='center' bgcolor='#ebf0f7'>采购日期</td>
    <td align='center' bgcolor='#ebf0f7'>工号</td>
    <td align='center' bgcolor='#ebf0f7'>姓名</td>
    <td align='center' bgcolor='#ebf0f7'>部门</td>
    <td  width='80' align='center' bgcolor='#ebf0f7'>是否支付</td>
    <td  width='80' align='center' bgcolor='#ebf0f7'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=caigouxinxihsgb.getAllCaigouxinxi(17);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.rukudanhao}</td>
    <td>${u.shangpinmingcheng}</td>
    <td>${u.caizhi}</td>
    <td>${u.kucun}</td>
    <td>${u.caigoujiage}</td>
    <td>${u.caigoushuliang}</td>
    <td>${u.zongjiage}</td>
    <td>${u.zhanghao}</td>
    <td>${u.gongsimingcheng}</td>
    <td>${u.caigouriqi}</td>
    <td>${u.gonghao}</td>
    <td>${u.xingming}</td>
    <td>${u.bumen}</td>
    <td align='center' bgcolor='#ebf0f7'>${u.iszf} </td>
    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=caigouxinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


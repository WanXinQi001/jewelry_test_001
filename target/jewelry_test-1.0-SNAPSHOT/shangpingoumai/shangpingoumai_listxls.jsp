<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shangpingoumaihsgb" scope="page" class="com.bean.ShangpingoumaiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shangpingoumai.xls");
%>
<html>
  <head>
    <title>商品购买</title>
  </head>

  <body >
 <%
			String sql="select * from shangpingoumai  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>销售单号</td>
    <td align='center' bgcolor='#ebf0f7'>商品名称</td>
    <td align='center' bgcolor='#ebf0f7'>材质</td>
    <td align='center' bgcolor='#ebf0f7'>克重</td>
    <td align='center' bgcolor='#ebf0f7'>工号</td>
    <td align='center' bgcolor='#ebf0f7'>部门</td>
    <td align='center' bgcolor='#ebf0f7'>获得积分</td>
    <td align='center' bgcolor='#ebf0f7'>库存</td>
    <td align='center' bgcolor='#ebf0f7'>价格</td>
    <td align='center' bgcolor='#ebf0f7'>购买数量</td>
    <td align='center' bgcolor='#ebf0f7'>总价格</td>
    <td  width='65' align='center' bgcolor='#ebf0f7'>购买日期</td>
    <td align='center' bgcolor='#ebf0f7'>卡号</td>
    <td align='center' bgcolor='#ebf0f7'>姓名</td>
    <td align='center' bgcolor='#ebf0f7'>会员等级</td>
    <td align='center' bgcolor='#ebf0f7'>折扣</td>
    <td align='center' bgcolor='#ebf0f7'>手机</td>
    <td align='center' bgcolor='#ebf0f7'>收货地址</td>
    <td  width='80' align='center' bgcolor='#ebf0f7'>是否支付</td>
    <td  width='80' align='center' bgcolor='#ebf0f7'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shangpingoumaihsgb.getAllShangpingoumai(22);
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
    <td>${u.gonghao}</td>
    <td>${u.bumen}</td>
    <td>${u.huodejifen}</td>
    <td>${u.kucun}</td>
    <td>${u.jiage}</td>
    <td>${u.goumaishuliang}</td>
    <td>${u.zongjiage}</td>
    <td>${u.goumairiqi}</td>
    <td>${u.kahao}</td>
    <td>${u.xingming}</td>
    <td>${u.huiyuandengji}</td>
    <td>${u.zhekou}</td>
    <td>${u.shouji}</td>
    <td>${u.shouhuodizhi}</td>
    <td align='center' bgcolor='#ebf0f7'>${u.iszf} </td>
    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=shangpingoumai'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


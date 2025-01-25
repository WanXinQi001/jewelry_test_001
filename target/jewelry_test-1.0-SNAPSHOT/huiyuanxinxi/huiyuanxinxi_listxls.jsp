<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="huiyuanxinxihsgb" scope="page" class="com.bean.HuiyuanxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=huiyuanxinxi.xls");
%>
<html>
  <head>
    <title>会员信息</title>
  </head>

  <body >
 <%
			String sql="select * from huiyuanxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>卡号</td>
    <td align='center' bgcolor='#ebf0f7'>密码</td>
    <td align='center' bgcolor='#ebf0f7'>姓名</td>
    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>
    <td  width='90' align='center' bgcolor='#ebf0f7'>照片</td>
    <td align='center' bgcolor='#ebf0f7'>会员等级</td>
    <td align='center' bgcolor='#ebf0f7'>折扣</td>
    <td align='center' bgcolor='#ebf0f7'>身份证</td>
    <td align='center' bgcolor='#ebf0f7'>手机</td>
    <td align='center' bgcolor='#ebf0f7'>收货地址</td>
    <td align='center' bgcolor='#ebf0f7'>消费金额</td>
    <td align='center' bgcolor='#ebf0f7'>积分</td>
    <td  width='80' align='center' bgcolor='#ebf0f7'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
  </tr>
   <%		
				List pagelist3=huiyuanxinxihsgb.getAllHuiyuanxinxi(16);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.kahao}</td>
    <td>${u.mima}</td>
    <td>${u.xingming}</td>
    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>
    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.zhaopian}' target='_blank'><img src='${u.zhaopian}' width=88 height=99 border=0 /></a></td>
    <td>${u.huiyuandengji}</td>
    <td>${u.zhekou}</td>
    <td>${u.shenfenzheng}</td>
    <td>${u.shouji}</td>
    <td>${u.shouhuodizhi}</td>
    <td>${u.xiaofeijine}</td>
    <td>${u.jifen}</td>
    <td align='center'>${u.issh} <input type="button" value="审核" onClick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=huiyuanxinxi'"/></td>
  </tr>
  	<%
  }}
   %>
</table>
<br>
  </body>
</html>


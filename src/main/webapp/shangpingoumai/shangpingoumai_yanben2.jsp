<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/popup.js"></script>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>商品购买查询</TITLE>
	<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">商品购买列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="shangpingoumaiList.do" name="myform" method="post">
									查询   销售单号：<input name="xiaoshoudanhao" type="text" id="xiaoshoudanhao" class="form-control2" />  商品名称：<input name="shangpinmingcheng" type="text" id="shangpinmingcheng" class="form-control2" />  部门：<input name="bumen" type="text" id="bumen" class="form-control2" />
									<input type="submit" value="查询" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>销售单号</td>
    <td align='center' bgcolor='#ebf0f7'>商品名称</td>
    <td align='center' bgcolor='#ebf0f7'>材质</td>
    <td align='center' bgcolor='#ebf0f7'>克重</td>
    <td align='center' bgcolor='#ebf0f7'>工号</td>
    <td align='center' bgcolor='#ebf0f7'>部门</td>
    <td align='center' bgcolor='#ebf0f7'>库存</td>
    <td align='center' bgcolor='#ebf0f7'>价格</td>
    <td align='center' bgcolor='#ebf0f7'>购买数量</td>
    <td align='center' bgcolor='#ebf0f7'>总价格</td>
    <td  width='65' align='center' bgcolor='#ebf0f7'>购买日期</td>
    <td align='center' bgcolor='#ebf0f7'>卡号</td>
    <td align='center' bgcolor='#ebf0f7'>姓名</td>
    <td align='center' bgcolor='#ebf0f7'>会员等级</td>
    <td align='center' bgcolor='#ebf0f7'>折扣价格</td>
    <td align='center' bgcolor='#ebf0f7'>手机</td>
    <td align='center' bgcolor='#ebf0f7'>收货地址</td>
    <td align='center' bgcolor='#ebf0f7'>消费金额</td>
    <td align='center' bgcolor='#ebf0f7'>积分</td>
    <td  width='80' align='center' bgcolor='#ebf0f7'>是否支付</td>
    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.xiaoshoudanhao}</td>
    <td>${u.shangpinmingcheng}</td>
    <td>${u.caizhi}</td>
    <td>${u.kezhong}</td>
    <td>${u.gonghao}</td>
    <td>${u.bumen}</td>
    <td>${u.kucun}</td>
    <td>${u.jiage}</td>
    <td>${u.goumaishuliang}</td>
    <td>${u.zongjiage}</td>
    <td>${u.goumairiqi}</td>
    <td>${u.kahao}</td>
    <td>${u.xingming}</td>
    <td>${u.huiyuandengji}</td>
    <td>${u.zhekoujiage}</td>
    <td>${u.shouji}</td>
    <td>${u.shouhuodizhi}</td>
    <td>${u.xiaofeijine}</td>
    <td>${u.jifen}</td>
    <td align='center' bgcolor='#ebf0f7'>${u.iszf} </td>
    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"> <a class="btn btn-info btn-small" href='../tuihuoxinxi/tuihuoxinxi_add.jsp?id=${u.id}'>添加退货信息</a> <a class="btn btn-info btn-small" href="shangpingoumaiDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from shangpingoumai where 1=1 ";
				
if(request.getParameter("xiaoshoudanhao")=="" ||request.getParameter("xiaoshoudanhao")==null ){}else{String nxiaoshoudanhao=new String(request.getParameter("xiaoshoudanhao").getBytes("8859_1"));if(nxiaoshoudanhao.contains("?")){nxiaoshoudanhao=request.getParameter("xiaoshoudanhao");}sql=sql+" and xiaoshoudanhao like '%"+nxiaoshoudanhao+"%'";}
if(request.getParameter("shangpinmingcheng")=="" ||request.getParameter("shangpinmingcheng")==null ){}else{String nshangpinmingcheng=new String(request.getParameter("shangpinmingcheng").getBytes("8859_1"));if(nshangpinmingcheng.contains("?")){nshangpinmingcheng=request.getParameter("shangpinmingcheng");}sql=sql+" and shangpinmingcheng like '%"+nshangpinmingcheng+"%'";}
if(request.getParameter("bumen")=="" ||request.getParameter("bumen")==null ){}else{String nbumen=new String(request.getParameter("bumen").getBytes("8859_1"));if(nbumen.contains("?")){nbumen=request.getParameter("bumen");}sql=sql+" and bumen like '%"+nbumen+"%'";}
			sql+=" order by id desc";
double zongjiagez=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						zongjiagez=zongjiagez+Float.valueOf(RS_result.getString("zongjiage")).floatValue();

						
						
			 }
			%>
		共计总价格:<%=zongjiagez%>； 
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="shangpingoumaiList.do?page=1" >首页</a>
             <a href="shangpingoumaiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="shangpingoumaiList.do?page=${page.page+1 }">下一页</a>
			<a href="shangpingoumaiList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>


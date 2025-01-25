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
	<TITLE>厂商信息查询</TITLE>
	<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
	</head>
	   <script language="javascript">
		   function zhifu(id,biao)
           {
                   window.location.href="zhifu/index.jsp?id="+id+"&biao="+biao;
           }
       </script>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">厂商信息列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="changshangxinxiList2.do" name="myform" method="post">
									查询   账号：<input name="zhanghao" type="text" id="zhanghao" class="form-control2" />  公司名称：<input name="gongsimingcheng" type="text" id="gongsimingcheng" class="form-control2" />  负责人：<input name="fuzeren" type="text" id="fuzeren" class="form-control2" /> 性别：<select name='xingbie' id='xingbie' class="form-control2"><option value="">所有</option><option value="男">男</option><option value="女">女</option></select>  职位：<input name="zhiwei" type="text" id="zhiwei" class="form-control2" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td width="30px" height="30" align="center" bgcolor="#ebf0f7">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>账号</td>
    <td align='center' bgcolor='#ebf0f7'>密码</td>
    <td align='center' bgcolor='#ebf0f7'>公司名称</td>
    <td align='center' bgcolor='#ebf0f7'>负责人</td>
    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>
    <td  width='90' align='center' bgcolor='#ebf0f7'>照片</td>
    <td align='center' bgcolor='#ebf0f7'>身份证</td>
    <td align='center' bgcolor='#ebf0f7'>职位</td>
    <td align='center' bgcolor='#ebf0f7'>联系电话</td>
    <td align='center' bgcolor='#ebf0f7'>邮箱</td>
    <td align='center' bgcolor='#ebf0f7'>地址</td>
    
    
                            <td width="150px" height="30" align="center" bgcolor="#ebf0f7"> 添加时间 </td>
                            <td width="150px" height="30" align="center" bgcolor="#ebf0f7"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td height="45" align="center"><%=i%></td>
                             <td>${u.zhanghao}</td>
    <td>${u.mima}</td>
    <td>${u.gongsimingcheng}</td>
    <td>${u.fuzeren}</td>
    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>
    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.zhaopian}' target='_blank'><img src='${u.zhaopian}' width=88 height=99 border=0 /></a></td>
    <td>${u.shenfenzheng}</td>
    <td>${u.zhiwei}</td>
    <td>${u.lianxidianhua}</td>
    <td>${u.youxiang}</td>
    <td>${u.dizhi}</td>
    
    
                              <td height="45" align="center"> ${u.addtime } </td>
                              <td height="45" align="center"><a class="btn btn-info btn-small" href="doUpdateChangshangxinxi.do?id=${u.id }">编辑</a>  <a class="btn btn-info btn-small" href="changshangxinxiDetail.do?id=${u.id }">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="changshangxinxiList2.do?page=1" >首页</a>
             <a href="changshangxinxiList2.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="changshangxinxiList2.do?page=${page.page+1 }">下一页</a>
			<a href="changshangxinxiList2.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>

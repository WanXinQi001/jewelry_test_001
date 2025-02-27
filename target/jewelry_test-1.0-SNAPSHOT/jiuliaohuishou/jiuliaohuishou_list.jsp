﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/popup.js"></script>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <TITLE>旧料回收查询</TITLE>
    <link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
    <link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr valign="top">
        <td>
            <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
                <tr align="left" bgcolor="#F2FDFF">
                    <td height="30" colspan="17" background="images/table_header.gif">旧料回收列表</td>
                </tr>
            </table>
        </td>
    </tr>

    <tr valign="top">
        <td bgcolor="#FFFFFF">
            <table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">

                <tr align="right" bgcolor="#ebf0f7">
                    <td colspan="21">
                        <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1">
                            <tr align="left">
                                <td colspan="17">
                                    <form action="jiuliaohuishouList.do" name="myform" method="post">
                                        查询 回收单号：<input name="huishoudanhao" type="text" id="huishoudanhao"
                                                       class="form-control2"/> 物品名称：<input name="wupinmingcheng"
                                                                                           type="text"
                                                                                           id="wupinmingcheng"
                                                                                           class="form-control2"/>
                                        性别：<input name="xingbie" type="text" id="xingbie" class="form-control2"/>
                                        <input type="submit" value="查询" class="btn btn-info btn-small"/>
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>

                <tr align="center">
                    <td style="padding-left:0px; padding-right:0px;">
                        <table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                            <tr>
                                <td align="center" bgcolor="#ebf0f7" width="30px" height="30">序号</td>
                                <td align='center' bgcolor='#ebf0f7'>回收单号</td>
                                <td align='center' bgcolor='#ebf0f7'>物品名称</td>
                                <td align='center' bgcolor='#ebf0f7'>材质</td>
                                <td align='center' bgcolor='#ebf0f7'>克重</td>
                                <td align='center' bgcolor='#ebf0f7'>数量</td>
                                <td width='90' align='center' bgcolor='#ebf0f7'>图片</td>


                                <td align='center' bgcolor='#ebf0f7'>卡号</td>
                                <td align='center' bgcolor='#ebf0f7'>姓名</td>
                                <td width='40' align='center' bgcolor='#ebf0f7'>性别</td>
                                <td align='center' bgcolor='#ebf0f7'>手机</td>
                                <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间</td>
                                <td align="center" bgcolor="#ebf0f7" width="150px"> 操作</td>
                            </tr>
                            <%
                                int i = 0;
                            %>
                            <c:forEach items="${list }" var="u">
                                <%
                                    i++;
                                %>
                                <tr align="center" bgcolor="#FFFFFF">
                                    <td align="center"><%=i%>
                                    </td>
                                    <td>${u.huishoudanhao}</td>
                                    <td>${u.wupinmingcheng}</td>
                                    <td>${u.caizhi}</td>
                                    <td>${u.kezhong}</td>
                                    <td>${u.shuliang}</td>
                                    <td width='90' align='center' bgcolor='#ebf0f7'><a href='../${u.tupian}'
                                                                                       target='_blank'><img
                                            src='../${u.tupian}' width=88 height=99 border=0/></a></td>


                                    <td>${u.kahao}</td>
                                    <td>${u.xingming}</td>
                                    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>
                                    <td>${u.shouji}</td>
                                    <td align="center"> ${u.addtime } </td>
                                    <td align="center"><a class="btn btn-info btn-small"
                                                          href="doUpdateJiuliaohuishoulb.do?id=${u.id }">回复</a> <a
                                            class="btn btn-info btn-small" href="deleteJiuliaohuishou.do?id=${u.id }"
                                            onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a
                                            class="btn btn-info btn-small"
                                            href="jiuliaohuishouDetail.do?id=${u.id}">详细</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </table>


        </td>
    </tr>
</table>


<p align="center" class="fy"><c:if test="${sessionScope.p==1 }">
    <c:if test="${page.page>1}">
        <a href="jiuliaohuishouList.do?page=1">首页</a>
        <a href="jiuliaohuishouList.do?page=${page.page-1 }"> 上一页</a> </c:if>
    <c:if test="${page.page<page.totalPage}">
        <a href="jiuliaohuishouList.do?page=${page.page+1 }">下一页</a>
        <a href="jiuliaohuishouList.do?page=${page.totalPage }">末页</a> </c:if>
</c:if>
</p>


</body>
</html>

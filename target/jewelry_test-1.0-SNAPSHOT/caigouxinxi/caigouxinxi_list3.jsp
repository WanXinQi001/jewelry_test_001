<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
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
    <TITLE>采购信息查询</TITLE>
    <link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
    <link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
</head>
<script language="javascript">
    function zhifu(id, biao) {
        window.location.href = "../zhifu/index.jsp?id=" + id + "&biao=" + biao;
    }
</script>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr valign="top">
        <td>
            <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
                <tr align="left" bgcolor="#F2FDFF">
                    <td colspan="17" background="images/table_header.gif">采购信息列表</td>
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
                                    <form action="../caigouxinxiList2.do" name="myform" method="post">
                                        查询 入库单号：<input name="rukudanhao" type="text" id="rukudanhao"
                                                       class="form-control2"/> 商品名称：<input name="shangpinmingcheng"
                                                                                           type="text"
                                                                                           id="shangpinmingcheng"
                                                                                           class="form-control2"/>
                                        材质：<input name="caizhi" type="text" id="caizhi" class="form-control2"/>
                                        账号：<input name="zhanghao" type="text" id="zhanghao" class="form-control2"/>
                                        公司名称：<input name="gongsimingcheng" type="text" id="gongsimingcheng"
                                                    class="form-control2"/> 工号：<input name="gonghao" type="text"
                                                                                      id="gonghao"
                                                                                      class="form-control2"/> 姓名：<input
                                            name="xingming" type="text" id="xingming" class="form-control2"/> 部门：<input
                                            name="bumen" type="text" id="bumen" class="form-control2"/>
                                        <input type="submit" value="查询"/>
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
                                <td width="30px" height="30" align="center" bgcolor="#ebf0f7">序号</td>
                                <td align='center' bgcolor='#ebf0f7'>入库单号</td>
                                <td align='center' bgcolor='#ebf0f7'>商品名称</td>
                                <td align='center' bgcolor='#ebf0f7'>材质</td>
                                <td align='center' bgcolor='#ebf0f7'>库存</td>
                                <td align='center' bgcolor='#ebf0f7'>采购价格</td>
                                <td align='center' bgcolor='#ebf0f7'>采购数量</td>
                                <td align='center' bgcolor='#ebf0f7'>总价格</td>
                                <td align='center' bgcolor='#ebf0f7'>账号</td>
                                <td align='center' bgcolor='#ebf0f7'>公司名称</td>
                                <td width='65' align='center' bgcolor='#ebf0f7'>采购日期</td>
                                <td align='center' bgcolor='#ebf0f7'>工号</td>
                                <td align='center' bgcolor='#ebf0f7'>姓名</td>
                                <td align='center' bgcolor='#ebf0f7'>部门</td>
                                <td width='80' align='center' bgcolor='#ebf0f7'>是否支付</td>
                                <td width='80' align='center' bgcolor='#ebf0f7'>是否审核</td>
                                <td width="150px" height="30" align="center" bgcolor="#ebf0f7"> 添加时间</td>
                                <td width="150px" height="30" align="center" bgcolor="#ebf0f7"> 操作</td>
                            </tr>
                            <%
                                int i = 0;
                            %>
                            <c:forEach items="${list }" var="u">
                                <%
                                    i++;
                                %>
                                <tr align="center" bgcolor="#FFFFFF">
                                    <td height="45" align="center"><%=i%>
                                    </td>
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
                                    <td align='center' bgcolor='#ebf0f7'>${u.iszf}
                                        <c:if test="${u.iszf=='否'}"></c:if></td>
                                    <td align='center'>${u.issh} </td>
                                    <td height="45" align="center"> ${u.addtime } </td>
                                    <td height="45" align="center">
<%--                                        <a class="btn btn-info btn-small"--%>
<%--                                           href="doUpdateCaigouxinxi.do?id=${u.id }">编辑</a>--%>
                                        <a class="btn btn-info btn-small" href="deleteCaigouxinxi.do?id=${u.id }"
                                           onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a
                                            class="btn btn-info btn-small"
                                            href="caigouxinxiDetail.do?id=${u.id }">详细</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </table>


        </td>
    </tr>
</table>

<%
    String sql = "select * from caigouxinxi where 1=1 ";

    if (request.getParameter("rukudanhao") == "" || request.getParameter("rukudanhao") == null) {
    } else {
        String nrukudanhao = new String(request.getParameter("rukudanhao").getBytes("8859_1"));
        if (nrukudanhao.contains("?")) {
            nrukudanhao = request.getParameter("rukudanhao");
        }
        sql = sql + " and rukudanhao like '%" + nrukudanhao + "%'";
    }
    if (request.getParameter("shangpinmingcheng") == "" || request.getParameter("shangpinmingcheng") == null) {
    } else {
        String nshangpinmingcheng = new String(request.getParameter("shangpinmingcheng").getBytes("8859_1"));
        if (nshangpinmingcheng.contains("?")) {
            nshangpinmingcheng = request.getParameter("shangpinmingcheng");
        }
        sql = sql + " and shangpinmingcheng like '%" + nshangpinmingcheng + "%'";
    }
    if (request.getParameter("caizhi") == "" || request.getParameter("caizhi") == null) {
    } else {
        String ncaizhi = new String(request.getParameter("caizhi").getBytes("8859_1"));
        if (ncaizhi.contains("?")) {
            ncaizhi = request.getParameter("caizhi");
        }
        sql = sql + " and caizhi like '%" + ncaizhi + "%'";
    }
    if (request.getParameter("zhanghao") == "" || request.getParameter("zhanghao") == null) {
    } else {
        String nzhanghao = new String(request.getParameter("zhanghao").getBytes("8859_1"));
        if (nzhanghao.contains("?")) {
            nzhanghao = request.getParameter("zhanghao");
        }
        sql = sql + " and zhanghao like '%" + nzhanghao + "%'";
    }
    if (request.getParameter("gongsimingcheng") == "" || request.getParameter("gongsimingcheng") == null) {
    } else {
        String ngongsimingcheng = new String(request.getParameter("gongsimingcheng").getBytes("8859_1"));
        if (ngongsimingcheng.contains("?")) {
            ngongsimingcheng = request.getParameter("gongsimingcheng");
        }
        sql = sql + " and gongsimingcheng like '%" + ngongsimingcheng + "%'";
    }
    if (request.getParameter("gonghao") == "" || request.getParameter("gonghao") == null) {
    } else {
        String ngonghao = new String(request.getParameter("gonghao").getBytes("8859_1"));
        if (ngonghao.contains("?")) {
            ngonghao = request.getParameter("gonghao");
        }
        sql = sql + " and gonghao like '%" + ngonghao + "%'";
    }
    if (request.getParameter("xingming") == "" || request.getParameter("xingming") == null) {
    } else {
        String nxingming = new String(request.getParameter("xingming").getBytes("8859_1"));
        if (nxingming.contains("?")) {
            nxingming = request.getParameter("xingming");
        }
        sql = sql + " and xingming like '%" + nxingming + "%'";
    }
    if (request.getParameter("bumen") == "" || request.getParameter("bumen") == null) {
    } else {
        String nbumen = new String(request.getParameter("bumen").getBytes("8859_1"));
        if (nbumen.contains("?")) {
            nbumen = request.getParameter("bumen");
        }
        sql = sql + " and bumen like '%" + nbumen + "%'";
    }
    sql += " order by id desc";
    double zongjiagez = 0;


    ResultSet RS_result = connDbBean.executeQuery(sql);
    while (RS_result.next()) {


        zongjiagez = zongjiagez + Float.valueOf(RS_result.getString("zongjiage")).floatValue();


    }
%>
共计总价格:<%=zongjiagez%>；

<p align="center" class="fy"><c:if test="${sessionScope.p==1 }">
    <c:if test="${page.page>1}">
        <a href="caigouxinxiList2.do?page=1">首页</a>
        <a href="caigouxinxiList2.do?page=${page.page-1 }"> 上一页</a> </c:if>
    <c:if test="${page.page<page.totalPage}">
        <a href="caigouxinxiList2.do?page=${page.page+1 }">下一页</a>
        <a href="caigouxinxiList2.do?page=${page.totalPage }">末页</a> </c:if>
</c:if>
</p>


</body>
</html>

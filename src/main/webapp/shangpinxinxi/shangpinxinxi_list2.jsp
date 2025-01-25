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
    <TITLE>商品信息查询</TITLE>
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
                    <td colspan="17" background="../images/table_header.gif">商品信息列表</td>
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
                                    <form action="shangpinxinxiList2.do" name="myform" method="post">
                                        查询 商品编号：<input name="shangpinbianhao" type="text" id="shangpinbianhao"
                                                       class="form-control2"/> 商品名称：<input name="shangpinmingcheng"
                                                                                           type="text"
                                                                                           id="shangpinmingcheng"
                                                                                           class="form-control2"/>
                                        材质：<input name="caizhi" type="text" id="caizhi" class="form-control2"/>
                                        克重：<input name="kezhong" type="text" id="kezhong" class="form-control2"/>
                                        物品单价：<input name="wupindanjia" type="text" id="wupindanjia"
                                                    class="form-control2"/> 工号：<input name="gonghao" type="text"
                                                                                      id="gonghao"
                                                                                      class="form-control2"/> 部门：<input
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
                                <td align='center' bgcolor='#ebf0f7'>商品编号</td>
                                <td align='center' bgcolor='#ebf0f7'>商品名称</td>
                                <td align='center' bgcolor='#ebf0f7'>材质</td>
                                <td align='center' bgcolor='#ebf0f7'>克重</td>
                                <td align='center' bgcolor='#ebf0f7'>物品单价</td>
                                <td width='90' align='center' bgcolor='#ebf0f7'>图片</td>

                                <td align='center' bgcolor='#ebf0f7'>工号</td>
                                <td align='center' bgcolor='#ebf0f7'>姓名</td>
                                <td align='center' bgcolor='#ebf0f7'>部门</td>
                                <td align='center' bgcolor='#ebf0f7'>价格</td>
                                <td align='center' bgcolor='#ebf0f7'>库存</td>
                                <td align='center' bgcolor='#ebf0f7'>获得积分</td>

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
                                    <td>${u.shangpinbianhao}</td>
                                    <td>${u.shangpinmingcheng}</td>
                                    <td>${u.caizhi}</td>
                                    <td>${u.kezhong}</td>
                                    <td>${u.wupindanjia}</td>
                                    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.tupian}'
                                                                                       target='_blank'><img
                                            src='${u.tupian}' width=88 height=99 border=0/></a></td>

                                    <td>${u.gonghao}</td>
                                    <td>${u.xingming}</td>
                                    <td>${u.bumen}</td>
                                    <td>${u.jiage}</td>
                                    <td>${u.kucun}</td>
                                    <td>${u.huodejifen}</td>

                                    <td height="45" align="center"> ${u.addtime } </td>
                                    <td height="45" align="center">
                                        <a class="btn btn-info btn-small"
                                           href="doUpdateShangpinxinxi.do?id=${u.id }">编辑</a>
                                        <a class="btn btn-info btn-small" href="deleteShangpinxinxi.do?id=${u.id }"
                                           onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a
                                            class="btn btn-info btn-small" href="spxxDetail.do?id=${u.id }"
                                            target="_blank">详细</a></td>
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
    String sql = "select * from shangpinxinxi where 1=1 ";

    if (request.getParameter("shangpinbianhao") == "" || request.getParameter("shangpinbianhao") == null) {
    } else {
        String nshangpinbianhao = new String(request.getParameter("shangpinbianhao").getBytes("8859_1"));
        if (nshangpinbianhao.contains("?")) {
            nshangpinbianhao = request.getParameter("shangpinbianhao");
        }
        sql = sql + " and shangpinbianhao like '%" + nshangpinbianhao + "%'";
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
    if (request.getParameter("kezhong") == "" || request.getParameter("kezhong") == null) {
    } else {
        String nkezhong = new String(request.getParameter("kezhong").getBytes("8859_1"));
        if (nkezhong.contains("?")) {
            nkezhong = request.getParameter("kezhong");
        }
        sql = sql + " and kezhong like '%" + nkezhong + "%'";
    }
    if (request.getParameter("wupindanjia") == "" || request.getParameter("wupindanjia") == null) {
    } else {
        String nwupindanjia = new String(request.getParameter("wupindanjia").getBytes("8859_1"));
        if (nwupindanjia.contains("?")) {
            nwupindanjia = request.getParameter("wupindanjia");
        }
        sql = sql + " and wupindanjia like '%" + nwupindanjia + "%'";
    }
    if (request.getParameter("gonghao") == "" || request.getParameter("gonghao") == null) {
    } else {
        String ngonghao = new String(request.getParameter("gonghao").getBytes("8859_1"));
        if (ngonghao.contains("?")) {
            ngonghao = request.getParameter("gonghao");
        }
        sql = sql + " and gonghao like '%" + ngonghao + "%'";
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


    int kucuntx = 0;
    ResultSet RS_result = connDbBean.executeQuery(sql);
    while (RS_result.next()) {


        if (Float.valueOf(RS_result.getString("kucun")).floatValue() < 50) {
            kucuntx = kucuntx + 1;
        }


    }
%>


<p align="center" class="fy"><c:if test="${sessionScope.p==1 }">
    <c:if test="${page.page>1}">
        <a href="shangpinxinxiList2.do?page=1">首页</a>
        <a href="shangpinxinxiList2.do?page=${page.page-1 }"> 上一页</a> </c:if>
    <c:if test="${page.page<page.totalPage}">
        <a href="shangpinxinxiList2.do?page=${page.page+1 }">下一页</a>
        <a href="shangpinxinxiList2.do?page=${page.totalPage }">末页</a> </c:if>
</c:if>
</p>


</body>
</html>
<%
    if (kucuntx > 0) {
%>
<style>
    #winpop {
        width: 200px;
        height: 0px;
        position: absolute;
        right: 0;
        bottom: 0;
        border: 1px solid #666;
        margin: 0;
        padding: 1px;
        overflow: hidden;
        display: none;
    }

    #winpop .title {
        width: 100%;
        height: 22px;
        line-height: 20px;
        background: #FFCC00;
        font-weight: bold;
        text-align: center;
        font-size: 12px;
    }

    #winpop .con {
        width: 100%;
        height: 90px;
        line-height: 20px;
        font-weight: bold;
        font-size: 12px;
        color: #FF0000;
        text-align: center
    }

    #silu {
        font-size: 12px;
        color: #666;
        position: absolute;
        right: 0;
        text-align: right;
        text-decoration: underline;
        line-height: 22px;
    }

    .close {
        position: absolute;
        right: 4px;
        top: -1px;
        color: #FFF;
        cursor: pointer
    }
</style>
<script type="text/javascript">
    function tips_pop() {
        var MsgPop = document.getElementById("winpop");
        var popH = parseInt(MsgPop.style.height);//将对象的高度转化为数字
        if (popH == 0) {
            MsgPop.style.display = "block";//显示隐藏的窗口
            show = setInterval("changeH('up')", 2);
        } else {
            hide = setInterval("changeH('down')", 2);
        }
    }

    function changeH(str) {
        var MsgPop = document.getElementById("winpop");
        var popH = parseInt(MsgPop.style.height);
        if (str == "up") {
            if (popH <= 100) {
                MsgPop.style.height = (popH + 4).toString() + "px";
            } else {
                clearInterval(show);
            }
        }
        if (str == "down") {
            if (popH >= 4) {
                MsgPop.style.height = (popH - 4).toString() + "px";
            } else {
                clearInterval(hide);
                MsgPop.style.display = "none"; //隐藏DIV
            }
        }
    }

    window.onload = function () { //加载
        document.getElementById('winpop').style.height = '0px';
        setTimeout("tips_pop()", 500); //3秒后调用tips_pop()这个函数
    }
</script>
<div id="silu">
    <body>
</div>
<div id="winpop">
    <div class="title">系统提醒！ <span class="close" onClick="tips_pop()">X </span></div>
    <div class="con">当前有<%=kucuntx%>条库存值记录小于50，谢谢！</div>
<%
    }
%>
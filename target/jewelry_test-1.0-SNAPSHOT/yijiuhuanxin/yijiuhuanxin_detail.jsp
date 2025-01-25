<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
<head>
    <title>以旧换新详细</title>
    <link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
    <link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">

</head>

<body>

以旧换新详细:
<br><br>

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC"
       style="border-collapse:collapse">
    <tr>
        <td width='11%' height=44>编号：</td>
        <td width='39%'>${yijiuhuanxin.bianhao}</td>
        <td rowspan=9 align=center><a href=../${yijiuhuanxin.tupian} target=_blank><img
                src=../${yijiuhuanxin.tupian} width=228 height=215 border=0></a></td>
    </tr>
    <tr>
        <td width='11%' height=44>物品名称：</td>
        <td width='39%'>${yijiuhuanxin.wupinmingcheng}</td>
    </tr>
    <tr>
        <td width='11%' height=44>材质：</td>
        <td width='39%'>${yijiuhuanxin.caizhi}</td>
    </tr>
    <tr>
        <td width='11%' height=44>克重：</td>
        <td width='39%'>${yijiuhuanxin.kezhong}</td>
    </tr>
    <tr>
        <td width='11%' height=44>数量：</td>
        <td width='39%'>${yijiuhuanxin.shuliang}</td>
    </tr>
    <tr>


        <td width='11%' height=44>发布日期：</td>
        <td width='39%'>${yijiuhuanxin.faburiqi}</td>
    </tr>
    <tr>
        <td width='11%' height=44>卡号：</td>
        <td width='39%'>${yijiuhuanxin.kahao}</td>
    </tr>
    <tr>
        <td width='11%' height=44>姓名：</td>
        <td width='39%'>${yijiuhuanxin.xingming}</td>
    </tr>
    <tr>
        <td width='11%' height=44>手机：</td>
        <td width='39%'>${yijiuhuanxin.shouji}</td>
    </tr>
    <tr>
        <td width='11%' height=100>物品情况：</td>
        <td width='39%' colspan=2 height=100>${yijiuhuanxin.wupinqingkuang}</td>
    </tr>
    <tr>
        <td width='11%' height=100>兑换物品：</td>
        <td width='39%' colspan=2 height=100>${yijiuhuanxin.duihuanwupin}</td>
    </tr>
    <tr>
        <td width='11%' height=100>回复：</td>
        <td width='39%' colspan=2 height=100>${yijiuhuanxin.huifu}</td>
    </tr>
    <tr>
        <td colspan=3 align=center><input type=button name=Submit5 value=返回
                                          onClick="javascript:history.back()"/>&nbsp;<input type=button name=Submit5
                                                                                            value=打印
                                                                                            onClick="javascript:window.print()"/>
        </td>
    </tr>

</table>

</body>
</html>


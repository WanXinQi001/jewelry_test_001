<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
<head>
    <title>商品信息详细</title>
    <link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
    <link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">

</head>

<body>

商品信息详细:
<br><br>

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC"
       style="border-collapse:collapse">
    <tr>
        <td width='11%' height=44>商品编号：</td>
        <td width='39%'>${shangpinxinxi.shangpinbianhao}</td>
        <td rowspan=11 align=center><a href=${shangpinxinxi.tupian} target=_blank><img
                src=${shangpinxinxi.tupian} width=228 height=215 border=0></a></td>
    </tr>
    <tr>
        <td width='11%' height=44>商品名称：</td>
        <td width='39%'>${shangpinxinxi.shangpinmingcheng}</td>
    </tr>
    <tr>
        <td width='11%' height=44>材质：</td>
        <td width='39%'>${shangpinxinxi.caizhi}</td>
    </tr>
    <tr>
        <td width='11%' height=44>克重：</td>
        <td width='39%'>${shangpinxinxi.kezhong}</td>
    </tr>
    <tr>
        <td width='11%' height=44>物品单价：</td>
        <td width='39%'>${shangpinxinxi.wupindanjia}</td>
    </tr>
    <tr>


        <td width='11%' height=44>工号：</td>
        <td width='39%'>${shangpinxinxi.gonghao}</td>
    </tr>
    <tr>
        <td width='11%' height=44>姓名：</td>
        <td width='39%'>${shangpinxinxi.xingming}</td>
    </tr>
    <tr>
        <td width='11%' height=44>部门：</td>
        <td width='39%'>${shangpinxinxi.bumen}</td>
    </tr>
    <tr>
        <td width='11%' height=44>价格：</td>
        <td width='39%'>${shangpinxinxi.jiage}</td>
    </tr>
    <tr>
        <td width='11%' height=44>库存：</td>
        <td width='39%'>${shangpinxinxi.kucun}</td>
    </tr>
    <tr>
        <td width='11%' height=44>获得积分：</td>
        <td width='39%'>${shangpinxinxi.huodejifen}</td>
    </tr>
    <tr>
        <td width='11%' height=100>简述：</td>
        <td width='39%' colspan=2 height=100>${shangpinxinxi.jianshu}</td>
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


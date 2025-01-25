<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
<head>
    <title>商品购买详细</title>
    <link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
    <link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">

</head>

<body>

商品购买详细:
<br><br>

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC"
       style="border-collapse:collapse">
    <tr>
        <td width='11%'>销售单号：</td>
        <td width='39%'>${shangpingoumai.xiaoshoudanhao}</td>
        <td width='11%'>商品名称：</td>
        <td width='39%'>${shangpingoumai.shangpinmingcheng}</td>
    </tr>
    <tr>
        <td width='11%'>材质：</td>
        <td width='39%'>${shangpingoumai.caizhi}</td>
        <td width='11%'>克重：</td>
        <td width='39%'>${shangpingoumai.kezhong}</td>
    </tr>
    <tr>
        <td width='11%'>工号：</td>
        <td width='39%'>${shangpingoumai.gonghao}</td>
        <td width='11%'>部门：</td>
        <td width='39%'>${shangpingoumai.bumen}</td>
    </tr>
    <tr>
        <td width='11%'>获得积分：</td>
        <td width='39%'>${shangpingoumai.huodejifen}</td>
        <td width='11%'>库存：</td>
        <td width='39%'>${shangpingoumai.kucun}</td>
    </tr>
    <tr>
        <td width='11%'>价格：</td>
        <td width='39%'>${shangpingoumai.jiage}</td>
        <td width='11%'>购买数量：</td>
        <td width='39%'>${shangpingoumai.goumaishuliang}</td>
    </tr>
    <tr>
        <td width='11%'>总价格：</td>
        <td width='39%'>${shangpingoumai.zongjiage}</td>
        <td width='11%'>购买日期：</td>
        <td width='39%'>${shangpingoumai.goumairiqi}</td>
    </tr>
    <tr>
        <td width='11%'>卡号：</td>
        <td width='39%'>${shangpingoumai.kahao}</td>
        <td width='11%'>姓名：</td>
        <td width='39%'>${shangpingoumai.xingming}</td>
    </tr>
    <tr>
        <td width='11%'>会员等级：</td>
        <td width='39%'>${shangpingoumai.huiyuandengji}</td>
        <td width='11%'>折扣：</td>
        <td width='39%'>${shangpingoumai.zhekou}</td>
    </tr>
    <tr>
        <td width='11%'>手机：</td>
        <td width='39%'>${shangpingoumai.shouji}</td>
        <td width='11%'>收货地址：</td>
        <td width='39%'>${shangpingoumai.shouhuodizhi}</td>
    </tr>
    <tr>
        <td colspan=4 align=center><input type=button name=Submit5 value=返回
                                          onClick="javascript:history.back()"/>&nbsp;<input type=button name=Submit5
                                                                                            value=打印
                                                                                            onClick="javascript:window.print()"/>
        </td>
    </tr>

</table>

</body>
</html>


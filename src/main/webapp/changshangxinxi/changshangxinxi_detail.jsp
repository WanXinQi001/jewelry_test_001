<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
<head>
    <title>厂商信息详细</title>
    <link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
    <link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">

</head>

<body>

厂商信息详细:
<br><br>

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC"
       style="border-collapse:collapse">
    <tr>
        <td width='11%' height=44>账号：</td>
        <td width='39%'>${changshangxinxi.zhanghao}</td>
        <td rowspan=10 align=center><a href=${changshangxinxi.zhaopian} target=_blank><img
                src=${changshangxinxi.zhaopian} width=228 height=215 border=0></a></td>
    </tr>
    <tr>
        <td width='11%' height=44>密码：</td>
        <td width='39%'>${changshangxinxi.mima}</td>
    </tr>
    <tr>
        <td width='11%' height=44>公司名称：</td>
        <td width='39%'>${changshangxinxi.gongsimingcheng}</td>
    </tr>
    <tr>
        <td width='11%' height=44>负责人：</td>
        <td width='39%'>${changshangxinxi.fuzeren}</td>
    </tr>
    <tr>
        <td width='11%' height=44>性别：</td>
        <td width='39%'>${changshangxinxi.xingbie}</td>
    </tr>
    <tr>

        <td width='11%' height=44>身份证：</td>
        <td width='39%'>${changshangxinxi.shenfenzheng}</td>
    </tr>
    <tr>
        <td width='11%' height=44>职位：</td>
        <td width='39%'>${changshangxinxi.zhiwei}</td>
    </tr>
    <tr>
        <td width='11%' height=44>联系电话：</td>
        <td width='39%'>${changshangxinxi.lianxidianhua}</td>
    </tr>
    <tr>
        <td width='11%' height=44>邮箱：</td>
        <td width='39%'>${changshangxinxi.youxiang}</td>
    </tr>
    <tr>
        <td width='11%' height=44>地址：</td>
        <td width='39%'>${changshangxinxi.dizhi}</td>
    </tr>
    <tr>

        <td width='11%' height=100>备注：</td>
        <td width='39%' colspan=2 height=100>${changshangxinxi.beizhu}</td>
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


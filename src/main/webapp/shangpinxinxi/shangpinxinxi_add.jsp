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
    <TITLE>添加商品信息</TITLE>

    <link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
    <link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
</head>
<%
    String id = request.getParameter("id");
%>

<script language="javascript">

    function gows() {
        document.location.href = "../shangpinxinxi/shangpinxinxi_add.jsp?id=<%=id%>&gonghao=" + document.form1.gonghao.value;
    }

    function hsgxia2shxurxu(nstr, nwbk) {
        if (eval("form1." + nwbk).value.indexOf(nstr) >= 0) {
            eval("form1." + nwbk).value = eval("form1." + nwbk).value.replace(nstr + "；", "");
        } else {
            eval("form1." + nwbk).value = eval("form1." + nwbk).value + nstr + "；";
        }
    }
</script>
<body>
<form action="../addShangpinxinxi.do" name="form1" method="post">
    <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" style="border-collapse:collapse"
           bgcolor="#F2FDFF">
        <tr bgcolor="#E7E7E7">
            <td height="30" colspan="2" background="images/table_header.gif">添加商品信息</td>
        </tr>
        <tr>
            <td width="200">商品编号：</td>
            <td><input name='shangpinbianhao' type='text' id='shangpinbianhao' value='<%=connDbBean.getID()%>' onblur=''
                       class="form-control"/></td>
        </tr>
        <tr>
            <td width="200">商品名称：</td>
            <td><input name='shangpinmingcheng' type='text' id='shangpinmingcheng' value='' onblur='checkform()'
                       class="form-control"/>&nbsp;*<label id='clabelshangpinmingcheng' style='margin-top:16px;'/></td>
        </tr>
        <tr>
            <td width="200">材质：</td>
            <td><input name='caizhi' type='text' id='caizhi' value='' onblur='' class="form-control"/></td>
        </tr>
        <tr>
            <td width="200">克重：</td>
            <td><input name='kezhong' type='text' id='kezhong' value='' onblur='' class="form-control"/></td>
        </tr>
        <tr>
            <td width="200">物品单价：</td>
            <td><input name='wupindanjia' type='text' id='wupindanjia' value='' onblur='checkform()'
                       class="form-control"/>&nbsp;<label id='clabelwupindanjia' style='margin-top:16px;'/>必需数字型
            </td>
        </tr>
        <tr>
            <td width="200">图片：</td>
            <td><input name='tupian' type='text' id='tupian' size='50' value='' onblur='' class="form-control"/>
                <div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('tupian')"/></div>
            </td>
        </tr>
        <tr>
            <td width="200">简述：</td>
            <td><textarea name='jianshu' cols='50' rows='5' id='jianshu' onblur='' class="form-control"
                          style="width:600px; height:80px;"></textarea></td>
        </tr>
        <tr>
            <td width="200">工号：</td>
            <td><select name='gonghao' id='gonghao' class="form-control"
                        onChange='gows();'><%=connDbBean.hsggetoption2("yuangongxinxi", "gonghao")%>
            </select></td>
        </tr>
        <tr>
            <td width="200">姓名：</td>
            <td><input name='xingming' type='text' id='xingming' class="form-control"></td>
        </tr>
        <tr 0>
            <td width="200">部门：</td>
            <td><input name='bumen' type='text' id='bumen' class="form-control"></td>
        </tr>
        <tr 1>
            <td width="200">价格：</td>
            <td><input name='jiage' type='text' id='jiage' value='' onblur='checkform()'
                       class="form-control"/>&nbsp;*<label id='clabeljiage' style='margin-top:16px;'/></td>
        </tr>
        <tr 2>
            <td width="200">库存：</td>
            <td><input name='kucun' type='text' id='kucun' value='' onblur='checkform()'
                       class="form-control"/>&nbsp;*<label id='clabelkucun' style='margin-top:16px;'/></td>
        </tr>
        <tr 3>
            <td width="200">获得积分：</td>
            <td><input name='huodejifen' type='text' id='huodejifen' value='' onblur='checkform()'
                       class="form-control"/>&nbsp;<label id='clabelhuodejifen' style='margin-top:16px;'/>必需数字型
            </td>
        </tr>


        <tr align='center' height="22">
            <td height="45" align="right">&nbsp;</td>
            <td width="75%" align="left">
                <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"
                       class="btn btn-info btn-small"/>
                <input type="reset" value="重置" name="Submit2" class="btn btn-info btn-small"/>&nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
</html>

<%
    if (request.getParameter("gonghao") == null || request.getParameter("gonghao").equals("")) {
    } else {
%>
<script language="javascript">
    document.form1.gonghao.value = "<%=connDbBean.readzd("yuangongxinxi","gonghao","gonghao",request.getParameter("gonghao"))%>";
    document.form1.xingming.value = "<%=connDbBean.readzd("yuangongxinxi","xingming","gonghao",request.getParameter("gonghao"))%>";
    document.form1.bumen.value = "<%=connDbBean.readzd("yuangongxinxi","bumen","gonghao",request.getParameter("gonghao"))%>";


</script>
<%
    }
%>


<script language=javascript>

    function checkform() {

        var shangpinmingchengobj = document.getElementById("shangpinmingcheng");
        if (shangpinmingchengobj.value == "") {
            document.getElementById("clabelshangpinmingcheng").innerHTML = "&nbsp;&nbsp;<font color=red>请输入商品名称</font>";
            return false;
        } else {
            document.getElementById("clabelshangpinmingcheng").innerHTML = "  ";
        }
        var wupindanjiaobj = document.getElementById("wupindanjia");
        if (wupindanjiaobj.value != "") {
            if (/^[0-9]+.?[0-9]*$/.test(wupindanjiaobj.value)) {
                document.getElementById("clabelwupindanjia").innerHTML = "";
            } else {
                document.getElementById("clabelwupindanjia").innerHTML = "&nbsp;&nbsp;<font color=red>必需数字型</font>";
                return false;
            }
        }
        var jiageobj = document.getElementById("jiage");
        if (jiageobj.value == "") {
            document.getElementById("clabeljiage").innerHTML = "&nbsp;&nbsp;<font color=red>请输入价格</font>";
            return false;
        } else {
            document.getElementById("clabeljiage").innerHTML = "  ";
        }
        var jiageobj = document.getElementById("jiage");
        if (jiageobj.value != "") {
            if (/^[0-9]+.?[0-9]*$/.test(jiageobj.value)) {
                document.getElementById("clabeljiage").innerHTML = "";
            } else {
                document.getElementById("clabeljiage").innerHTML = "&nbsp;&nbsp;<font color=red>必需数字型</font>";
                return false;
            }
        }
        var kucunobj = document.getElementById("kucun");
        if (kucunobj.value == "") {
            document.getElementById("clabelkucun").innerHTML = "&nbsp;&nbsp;<font color=red>请输入库存</font>";
            return false;
        } else {
            document.getElementById("clabelkucun").innerHTML = "  ";
        }
        var kucunobj = document.getElementById("kucun");
        if (kucunobj.value != "") {
            if (/^[0-9]+.?[0-9]*$/.test(kucunobj.value)) {
                document.getElementById("clabelkucun").innerHTML = "";
            } else {
                document.getElementById("clabelkucun").innerHTML = "&nbsp;&nbsp;<font color=red>必需数字型</font>";
                return false;
            }
        }
        var huodejifenobj = document.getElementById("huodejifen");
        if (huodejifenobj.value != "") {
            if (/^[0-9]+.?[0-9]*$/.test(huodejifenobj.value)) {
                document.getElementById("clabelhuodejifen").innerHTML = "";
            } else {
                document.getElementById("clabelhuodejifen").innerHTML = "&nbsp;&nbsp;<font color=red>必需数字型</font>";
                return false;
            }
        }


        return true;
    }

    popheight = 450;
</script>
<script src="../images/hsgcommon/jq.js"></script>
<script src="../images/hsgcommon/common.js"></script>
<script src="../images/hsgcommon/bootbox.js"></script>
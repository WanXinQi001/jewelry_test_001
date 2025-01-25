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
    <TITLE>修改等级信息</TITLE>

    <link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
    <link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">

</head>
<%
    String id = "";

%>
<script language="javascript">

    function gows() {
        document.location.href = "dengjixinxi_add.jsp?id=<%=id%>";
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
<form action="updateDengjixinxi.do" name="form1" method="post">
    <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" style="border-collapse:collapse"
           bgcolor="#F2FDFF">
        <tr bgcolor="#E7E7E7">
            <td height="30" colspan="2" background="images/table_header.gif">修改等级信息<input type="hidden" name="id"
                                                                                          value="${dengjixinxi.id}"/>
            </td>
        </tr>
        <tr>
            <td width="200">会员等级：</td>
            <td><input name='huiyuandengji' type='text' id='huiyuandengji' value='' onblur='checkform()'
                       class="form-control"/>&nbsp;*<label id='clabelhuiyuandengji' style='margin-top:16px;'/></td>
        </tr>
        <tr>
            <td width="200">折扣：</td>
            <td><input name='zhekou' type='text' id='zhekou' value='' onblur='checkform()' class="form-control"/>&nbsp;*<label
                    id='clabelzhekou' style='margin-top:16px;'/></td>
        </tr>


        <tr align='center' height="22">
            <td width="200" height="45" align="right">&nbsp;</td>
            <td width="75%" align="left">
                <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"
                       class="btn btn-info btn-small"/>
                <input type="reset" value="重置" class="btn btn-info btn-small"/>&nbsp;
            </td>
        </tr>
        <script language="javascript">document.form1.huiyuandengji.value = '${dengjixinxi.huiyuandengji}';</script>
        <script language="javascript">document.form1.zhekou.value = '${dengjixinxi.zhekou}';</script>
        <script language="javascript">document.form1.zhekoujiage.value = '${dengjixinxi.zhekoujiage}';</script>
        <script language="javascript">document.form1.beizhu.value = '${dengjixinxi.beizhu}';</script>
    </table>
</form>
</body>
</html>


<script language=javascript>

    function checkform() {

        var huiyuandengjiobj = document.getElementById("huiyuandengji");
        if (huiyuandengjiobj.value == "") {
            document.getElementById("clabelhuiyuandengji").innerHTML = "&nbsp;&nbsp;<font color=red>请输入会员等级</font>";
            return false;
        } else {
            document.getElementById("clabelhuiyuandengji").innerHTML = "  ";
        }
        var zhekouobj = document.getElementById("zhekou");
        if (zhekouobj.value == "") {
            document.getElementById("clabelzhekou").innerHTML = "&nbsp;&nbsp;<font color=red>请输入折扣</font>";
            return false;
        } else {
            document.getElementById("clabelzhekou").innerHTML = "  ";
        }


        return true;
    }

    popheight = 450;
</script>  

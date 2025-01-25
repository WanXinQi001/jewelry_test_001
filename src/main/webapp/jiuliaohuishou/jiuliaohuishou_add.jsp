<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page import="com.util.db" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/popup.js"></script>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <TITLE>添加旧料回收</TITLE>

    <link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
    <link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
</head>
<%
    String id = "";
%>

<script language="javascript">

    function gows() {
        document.location.href = "jiuliaohuishou_add.jsp?id=<%=id%>";
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
<form action="addJiuliaohuishou.do" name="form1" method="post">
    <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" style="border-collapse:collapse"
           bgcolor="#F2FDFF">
        <tr bgcolor="#E7E7E7">
            <td height="30" colspan="2" background="../images/table_header.gif">添加旧料回收</td>
        </tr>
        <tr>
            <td width="200">回收单号：</td>
            <td><input name='huishoudanhao' type='text' id='huishoudanhao' value='<%=db.getID()%>' onblur=''
                       class="form-control"/></td>
        </tr>
        <tr>
            <td width="200">物品名称：</td>
            <td><input name='wupinmingcheng' type='text' id='wupinmingcheng' value='' onblur='checkform()'
                       class="form-control"/>&nbsp;*<label id='clabelwupinmingcheng' style='margin-top:16px;'/></td>
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
            <td width="200">数量：</td>
            <td><input name='shuliang' type='text' id='shuliang' value='' onblur='checkform()' class="form-control"/>&nbsp;<label
                    id='clabelshuliang' style='margin-top:16px;'/>必需数字型
            </td>
        </tr>
        <tr>
            <td width="200">图片：</td>
            <td><input name='tupian' type='text' id='tupian' size='50' value='' onblur='' class="form-control"/>
                <div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('tupian')"/></div>
            </td>
        </tr>
        <tr>
            <td width="200">详细情况：</td>
            <td><textarea name='xiangxiqingkuang' cols='50' rows='5' id='xiangxiqingkuang' onblur=''
                          class="form-control" style="width:600px; height:80px;"></textarea></td>
        </tr>
        <tr>
            <td width="200">内容：</td>
            <td><textarea name='neirong' cols='50' rows='5' id='neirong' onblur='' class="form-control"
                          style="width:600px; height:80px;"></textarea></td>
        </tr>
        <tr style='display:none'>
            <td width="200">回复：</td>
            <td><textarea name='huifu' cols='50' rows='5' id='huifu' onblur='' class="form-control"
                          style="width:600px; height:80px;"></textarea></td>
        </tr>
        <tr 0>
            <td width="200">卡号：</td>
            <td><input name='kahao' type='text' id='kahao' onblur='' class="form-control"
                       value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly"/></td>
        </tr>
        <script language="javascript">document.form1.kahao.value = '<%=connDbBean.readzd("huiyuanxinxi","kahao","kahao",(String)request.getSession().getAttribute("username"))%>';
        document.form1.kahao.setAttribute("readOnly", 'true');</script>
        <tr 1>
            <td width="200">姓名：</td>
            <td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control"/></td>
        </tr>
        <script language="javascript">document.form1.xingming.value = '<%=connDbBean.readzd("huiyuanxinxi","xingming","kahao",(String)request.getSession().getAttribute("username"))%>';
        document.form1.xingming.setAttribute("readOnly", 'true');</script>
        <tr 2>
            <td width="200">性别：</td>
            <td><input name='xingbie' type='text' id='xingbie' value='' onblur='' class="form-control"/></td>
        </tr>
        <script language="javascript">document.form1.xingbie.value = '<%=connDbBean.readzd("huiyuanxinxi","xingbie","kahao",(String)request.getSession().getAttribute("username"))%>';
        document.form1.xingbie.setAttribute("readOnly", 'true');</script>
        <tr 3>
            <td width="200">手机：</td>
            <td><input name='shouji' type='text' id='shouji' value='' onblur='' class="form-control"/></td>
        </tr>
        <script language="javascript">document.form1.shouji.value = '<%=connDbBean.readzd("huiyuanxinxi","shouji","kahao",(String)request.getSession().getAttribute("username"))%>';
        document.form1.shouji.setAttribute("readOnly", 'true');</script>


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


<script language=javascript>

    function checkform() {

        var wupinmingchengobj = document.getElementById("wupinmingcheng");
        if (wupinmingchengobj.value == "") {
            document.getElementById("clabelwupinmingcheng").innerHTML = "&nbsp;&nbsp;<font color=red>请输入物品名称</font>";
            return false;
        } else {
            document.getElementById("clabelwupinmingcheng").innerHTML = "  ";
        }
        var shuliangobj = document.getElementById("shuliang");
        if (shuliangobj.value != "") {
            if (/^[0-9]+.?[0-9]*$/.test(shuliangobj.value)) {
                document.getElementById("clabelshuliang").innerHTML = "";
            } else {
                document.getElementById("clabelshuliang").innerHTML = "&nbsp;&nbsp;<font color=red>必需数字型</font>";
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
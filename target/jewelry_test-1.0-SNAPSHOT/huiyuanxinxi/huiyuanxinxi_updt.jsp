﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/popup.js"></script>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>修改会员信息</TITLE>
	    
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
       
	</head>
<%
String id= request.getParameter("id");
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="huiyuanxinxi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateHuiyuanxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改会员信息<input type="hidden" name="id" value="${huiyuanxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">卡号：</td><td><input name='kahao' type='text' id='kahao' onblur='hsgcheck()' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabelkahao' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmima' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelxingming' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">性别：</td><td><select name='xingbie' id='xingbie' class="form-control"><option value="男">男</option><option value="女">女</option></select></td></tr>
		<tr ><td width="200">照片：</td><td><input name='zhaopian' type='text' id='zhaopian' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('zhaopian')"/></div></td></tr>
		<tr ><td width="200">会员等级：</td><td><input name='huiyuandengji' id='huiyuandengji' class="form-control" onChange=''></td></tr>
		<tr ><td width="200">折扣：</td><td><input name='zhekou' type='text' id='zhekou'  class="form-control" ></td></tr>
		<tr ><td width="200">身份证：</td><td><input name='shenfenzheng' type='text' id='shenfenzheng' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelshenfenzheng' style='margin-top:16px;' />必需身份证格式</td></tr>
		<tr 0><td width="200">手机：</td><td><input name='shouji' type='text' id='shouji' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelshouji' style='margin-top:16px;' />必需电话格式[7或8位电话，或11位手机]</td></tr>
		<tr 1><td width="200">收货地址：</td><td><input name='shouhuodizhi' type='text' id='shouhuodizhi' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>
		<tr 2><td width="200">消费金额：</td><td><input name='xiaofeijine' type='text' id='xiaofeijine' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelxiaofeijine' style='margin-top:16px;' />必需数字型</td></tr>
		<tr 3><td width="200">积分：</td><td><input name='jifen' type='text' id='jifen' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabeljifen' style='margin-top:16px;' />必需数字型</td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="200" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;						    </td>
						</tr>
						<script language="javascript">document.form1.kahao.value='${huiyuanxinxi.kahao}';</script>
	<script language="javascript">document.form1.mima.value='${huiyuanxinxi.mima}';</script>
	<script language="javascript">document.form1.xingming.value='${huiyuanxinxi.xingming}';</script>
	<script language="javascript">document.form1.xingbie.value='${huiyuanxinxi.xingbie}';</script>
	<script language="javascript">document.form1.zhaopian.value='${huiyuanxinxi.zhaopian}';</script>
	<script language="javascript">document.form1.huiyuandengji.value='${huiyuanxinxi.huiyuandengji}';</script>
	<script language="javascript">document.form1.zhekou.value='${huiyuanxinxi.zhekou}';</script>
	<script language="javascript">document.form1.zhekoujiage.value='${huiyuanxinxi.zhekoujiage}';</script>
	<script language="javascript">document.form1.shenfenzheng.value='${huiyuanxinxi.shenfenzheng}';</script>
	<script language="javascript">document.form1.shouji.value='${huiyuanxinxi.shouji}';</script>
	<script language="javascript">document.form1.shouhuodizhi.value='${huiyuanxinxi.shouhuodizhi}';</script>
	<script language="javascript">document.form1.xiaofeijine.value='${huiyuanxinxi.xiaofeijine}';</script>
	<script language="javascript">document.form1.jifen.value='${huiyuanxinxi.jifen}';</script>
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var kahaoobj = document.getElementById("kahao"); if(kahaoobj.value==""){document.getElementById("clabelkahao").innerHTML="&nbsp;&nbsp;<font color=red>请输入卡号</font>";return false;}else{document.getElementById("clabelkahao").innerHTML="  "; } 
	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 
	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入姓名</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 
	var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value!=""){ if(/^\d{15}$|^\d{18}$|^\d{17}[xX]$/.test(shenfenzhengobj.value)){document.getElementById("clabelshenfenzheng").innerHTML=""; }else{document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>必需身份证格式</font>"; return false;}}  
    var shoujiobj = document.getElementById("shouji"); if(shoujiobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(shoujiobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(shoujiobj.value)){document.getElementById("clabelshouji").innerHTML=""; }else{document.getElementById("clabelshouji").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}  
    
    
    


return true;   
}   
popheight=450;
</script>  

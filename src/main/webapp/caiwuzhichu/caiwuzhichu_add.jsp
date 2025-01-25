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
		<TITLE>添加财务支出</TITLE>
	    
 	<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="caiwuzhichu_add.jsp?id=<%=id%>";
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
			<form action="addCaiwuzhichu.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加财务支出</td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">名称：</td><td><input name='mingcheng' type='text' id='mingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmingcheng' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">采购支出：</td><td><input name='caigouzhichu' type='text' id='caigouzhichu' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelcaigouzhichu' style='margin-top:16px;' />必需数字型</td></tr>
		<tr ><td width="200">工资支出：</td><td><input name='gongzizhichu' type='text' id='gongzizhichu' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelgongzizhichu' style='margin-top:16px;' />必需数字型</td></tr>
		<tr ><td width="200">回收成本：</td><td><input name='huishouchengben' type='text' id='huishouchengben' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelhuishouchengben' style='margin-top:16px;' />必需数字型</td></tr>
		<tr ><td width="200">其他支出：</td><td><input name='qitazhichu' type='text' id='qitazhichu' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelqitazhichu' style='margin-top:16px;' />必需数字型</td></tr>
		<tr ><td width="200">总支出：</td><td><input name='zongzhichu' type='text' id='zongzhichu' value='' onblur='' class="form-control" readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>
		<tr ><td width="200">日期：</td><td><input name='riqi' type='text' id='riqi' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small"/>
						       <input type="reset" value="重置" name="Submit2" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var mingchengobj = document.getElementById("mingcheng"); if(mingchengobj.value==""){document.getElementById("clabelmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入名称</font>";return false;}else{document.getElementById("clabelmingcheng").innerHTML="  "; } 
	var caigouzhichuobj = document.getElementById("caigouzhichu"); if(caigouzhichuobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(caigouzhichuobj.value)){document.getElementById("clabelcaigouzhichu").innerHTML=""; }else{document.getElementById("clabelcaigouzhichu").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var gongzizhichuobj = document.getElementById("gongzizhichu"); if(gongzizhichuobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(gongzizhichuobj.value)){document.getElementById("clabelgongzizhichu").innerHTML=""; }else{document.getElementById("clabelgongzizhichu").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var huishouchengbenobj = document.getElementById("huishouchengben"); if(huishouchengbenobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(huishouchengbenobj.value)){document.getElementById("clabelhuishouchengben").innerHTML=""; }else{document.getElementById("clabelhuishouchengben").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var qitazhichuobj = document.getElementById("qitazhichu"); if(qitazhichuobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(qitazhichuobj.value)){document.getElementById("clabelqitazhichu").innerHTML=""; }else{document.getElementById("clabelqitazhichu").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var zongzhichuh=0;if(document.getElementById("caigouzhichu").value!=""){zongzhichuh=zongzhichuh+parseFloat(document.getElementById("caigouzhichu").value);}if(document.getElementById("gongzizhichu").value!=""){zongzhichuh=zongzhichuh+parseFloat(document.getElementById("gongzizhichu").value);}if(document.getElementById("huishouchengben").value!=""){zongzhichuh=zongzhichuh+parseFloat(document.getElementById("huishouchengben").value);}if(document.getElementById("qitazhichu").value!=""){zongzhichuh=zongzhichuh+parseFloat(document.getElementById("qitazhichu").value);}document.getElementById("zongzhichu").value=zongzhichuh;;
	


return true;   
}   
popheight=450;
</script>  
<script src="../images/hsgcommon/jq.js"></script>
<script src="../images/hsgcommon/common.js"></script>
<script src="../images/hsgcommon/bootbox.js"></script>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<TITLE>添加财务收入</TITLE>
	    
 	<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="caiwushouru_add.jsp?id=<%=id%>";
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
			<form action="../addCaiwushouru.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加财务收入</td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">名称：</td><td><input name='mingcheng' type='text' id='mingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmingcheng' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">销售收入：</td><td><input name='xiaoshoushouru' type='text' id='xiaoshoushouru' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelxiaoshoushouru' style='margin-top:16px;' />必需数字型</td></tr>
		<tr ><td width="200">政府补贴：</td><td><input name='zhengfubutie' type='text' id='zhengfubutie' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelzhengfubutie' style='margin-top:16px;' />必需数字型</td></tr>
		<tr ><td width="200">其他收入：</td><td><input name='qitashouru' type='text' id='qitashouru' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelqitashouru' style='margin-top:16px;' />必需数字型</td></tr>
		<tr ><td width="200">总收入：</td><td><input name='zongshouru' type='text' id='zongshouru' value='' onblur='' class="form-control" readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>
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
	var xiaoshoushouruobj = document.getElementById("xiaoshoushouru"); if(xiaoshoushouruobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(xiaoshoushouruobj.value)){document.getElementById("clabelxiaoshoushouru").innerHTML=""; }else{document.getElementById("clabelxiaoshoushouru").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var zhengfubutieobj = document.getElementById("zhengfubutie"); if(zhengfubutieobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(zhengfubutieobj.value)){document.getElementById("clabelzhengfubutie").innerHTML=""; }else{document.getElementById("clabelzhengfubutie").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var qitashouruobj = document.getElementById("qitashouru"); if(qitashouruobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(qitashouruobj.value)){document.getElementById("clabelqitashouru").innerHTML=""; }else{document.getElementById("clabelqitashouru").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var zongshouruh=0;if(document.getElementById("xiaoshoushouru").value!=""){zongshouruh=zongshouruh+parseFloat(document.getElementById("xiaoshoushouru").value);}if(document.getElementById("zhengfubutie").value!=""){zongshouruh=zongshouruh+parseFloat(document.getElementById("zhengfubutie").value);}if(document.getElementById("qitashouru").value!=""){zongshouruh=zongshouruh+parseFloat(document.getElementById("qitashouru").value);}document.getElementById("zongshouru").value=zongshouruh;;
	


return true;   
}   
popheight=450;
</script>  
<script src="../images/hsgcommon/jq.js"></script>
<script src="../images/hsgcommon/common.js"></script>
<script src="../images/hsgcommon/bootbox.js"></script>
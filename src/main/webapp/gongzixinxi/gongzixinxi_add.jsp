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
		<TITLE>添加工资信息</TITLE>
	    
 	<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="gongzixinxi_add.jsp?id=<%=id%>&gonghao="+document.form1.gonghao.value;
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
			<form action="../addGongzixinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加工资信息</td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">名称：</td><td><input name='mingcheng' type='text' id='mingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmingcheng' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">工号：</td><td><select name='gonghao' id='gonghao' class="form-control" onChange='gows();'><%=connDbBean.hsggetoption2("yuangongxinxi","gonghao")%></select></td></tr>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming'  class="form-control" ></td></tr>
		<tr ><td width="200">性别：</td><td><input name='xingbie' type='text' id='xingbie'  class="form-control" ></td></tr>
		<tr ><td width="200">部门：</td><td><input name='bumen' type='text' id='bumen'  class="form-control" ></td></tr>
		<tr ><td width="200">基本工资：</td><td><input name='jibengongzi' type='text' id='jibengongzi' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabeljibengongzi' style='margin-top:16px;' />必需数字型</td></tr>
<%--		<tr ><td width="200">提成：</td><td><input name='ticheng' type='text' id='ticheng' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelticheng' style='margin-top:16px;' />必需数字型</td></tr>--%>
		<tr ><td width="200">补贴：</td><td><input name='butie' type='text' id='butie' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelbutie' style='margin-top:16px;' />必需数字型</td></tr>
		<tr 0><td width="200">实发工资：</td><td><input name='shifagongzi' type='text' id='shifagongzi' value='' onblur='' class="form-control" readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>
		<tr 1><td width="200">工资日期：</td><td><input name='gongziriqi' type='text' id='gongziriqi' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" /></td></tr>
		
		
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

<%
if(request.getParameter("gonghao")==null || request.getParameter("gonghao").equals("")){}else{
%>
<script language="javascript">
document.form1.gonghao.value="<%=connDbBean.readzd("yuangongxinxi","gonghao","gonghao",request.getParameter("gonghao"))%>";
document.form1.xingming.value="<%=connDbBean.readzd("yuangongxinxi","xingming","gonghao",request.getParameter("gonghao"))%>";
document.form1.xingbie.value="<%=connDbBean.readzd("yuangongxinxi","xingbie","gonghao",request.getParameter("gonghao"))%>";
document.form1.bumen.value="<%=connDbBean.readzd("yuangongxinxi","bumen","gonghao",request.getParameter("gonghao"))%>";


</script>
<%
}
%>





<script language=javascript >  
 
 function checkform(){  
 
	var mingchengobj = document.getElementById("mingcheng"); if(mingchengobj.value==""){document.getElementById("clabelmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入名称</font>";return false;}else{document.getElementById("clabelmingcheng").innerHTML="  "; } 
	var jibengongziobj = document.getElementById("jibengongzi"); if(jibengongziobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(jibengongziobj.value)){document.getElementById("clabeljibengongzi").innerHTML=""; }else{document.getElementById("clabeljibengongzi").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var tichengobj = document.getElementById("ticheng"); if(tichengobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(tichengobj.value)){document.getElementById("clabelticheng").innerHTML=""; }else{document.getElementById("clabelticheng").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var butieobj = document.getElementById("butie"); if(butieobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(butieobj.value)){document.getElementById("clabelbutie").innerHTML=""; }else{document.getElementById("clabelbutie").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var shifagongzih=0;if(document.getElementById("jibengongzi").value!=""){shifagongzih=shifagongzih+parseFloat(document.getElementById("jibengongzi").value);}if(document.getElementById("ticheng").value!=""){shifagongzih=shifagongzih+parseFloat(document.getElementById("ticheng").value);}if(document.getElementById("butie").value!=""){shifagongzih=shifagongzih+parseFloat(document.getElementById("butie").value);}document.getElementById("shifagongzi").value=shifagongzih;;
	


return true;   
}   
popheight=450;
</script>  
<script src="../images/hsgcommon/jq.js"></script>
<script src="../images/hsgcommon/common.js"></script>
<script src="../images/hsgcommon/bootbox.js"></script>
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
		<TITLE>修改财务管理</TITLE>
	    
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="caiwuguanli_add.jsp?id=<%=id%>";
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
			<form action="updateCaiwuguanli.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改财务管理<input type="hidden" name="id" value="${caiwuguanli.id}" /></td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">名称：</td><td><input name='mingcheng' type='text' id='mingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmingcheng' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">总收入：</td><td><input name='zongshouru' type='text' id='zongshouru' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelzongshouru' style='margin-top:16px;' />必需数字型</td></tr>
		<tr ><td width="200">总支出：</td><td><input name='zongzhichu' type='text' id='zongzhichu' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelzongzhichu' style='margin-top:16px;' />必需数字型</td></tr>
		<tr ><td width="200">总利润：</td><td><input name='zonglirun' type='text' id='zonglirun' value='' onblur='' class="form-control" readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>
		<tr ><td width="200">发布日期：</td><td><input name='faburiqi' type='text' id='faburiqi' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" /></td></tr>
		<tr ><td width="200">发布人：</td><td><input name='faburen' type='text' id='faburen' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bianhao.value='${caiwuguanli.bianhao}';</script>
	<script language="javascript">document.form1.mingcheng.value='${caiwuguanli.mingcheng}';</script>
	<script language="javascript">document.form1.zongshouru.value='${caiwuguanli.zongshouru}';</script>
	<script language="javascript">document.form1.zongzhichu.value='${caiwuguanli.zongzhichu}';</script>
	<script language="javascript">document.form1.zonglirun.value='${caiwuguanli.zonglirun}';</script>
	<script language="javascript">document.form1.faburiqi.value='${caiwuguanli.faburiqi}';</script>
	<script language="javascript">document.form1.faburen.value='${caiwuguanli.faburen}';</script>
	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var mingchengobj = document.getElementById("mingcheng"); if(mingchengobj.value==""){document.getElementById("clabelmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入名称</font>";return false;}else{document.getElementById("clabelmingcheng").innerHTML="  "; } 
	
    
    var zonglirunh=0;if(document.getElementById("zongshouru").value!=""){zonglirunh=zonglirunh+parseFloat(document.getElementById("zongshouru").value);}if(document.getElementById("zongzhichu").value!=""){zonglirunh=zonglirunh-parseFloat(document.getElementById("zongzhichu").value);}document.getElementById("zonglirun").value=zonglirunh;;
	


return true;   
}   
popheight=450;
</script>  

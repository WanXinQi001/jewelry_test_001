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
		<TITLE>修改金额计算</TITLE>
	    
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="jinejisuan_add.jsp?id=<%=id%>";
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
			<form action="updateJinejisuan.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改金额计算<input type="hidden" name="id" value="${jinejisuan.id}" /></td>
						</tr>
						<tr ><td width="200">销售单号：</td><td><input name='xiaoshoudanhao' type='text' id='xiaoshoudanhao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">总价格：</td><td><input name='zongjiage' type='text' id='zongjiage' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">卡号：</td><td><input name='kahao' type='text' id='kahao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">消费金额：</td><td><input name='xiaofeijine' type='text' id='xiaofeijine' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.xiaoshoudanhao.value='${jinejisuan.xiaoshoudanhao}';</script>
	<script language="javascript">document.form1.zongjiage.value='${jinejisuan.zongjiage}';</script>
	<script language="javascript">document.form1.kahao.value='${jinejisuan.kahao}';</script>
	<script language="javascript">document.form1.xingming.value='${jinejisuan.xingming}';</script>
	<script language="javascript">document.form1.xiaofeijine.value='${jinejisuan.xiaofeijine}';</script>
	
					 </table>
			</form>
   </body>
</html>







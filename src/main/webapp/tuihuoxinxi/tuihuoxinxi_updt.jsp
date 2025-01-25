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
		<TITLE>修改退货信息</TITLE>
	    
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="tuihuoxinxi_add.jsp?id=<%=id%>";
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
			<form action="updateTuihuoxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改退货信息<input type="hidden" name="id" value="${tuihuoxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">销售单号：</td><td><input name='xiaoshoudanhao' type='text' id='xiaoshoudanhao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">商品名称：</td><td><input name='shangpinmingcheng' type='text' id='shangpinmingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">材质：</td><td><input name='caizhi' type='text' id='caizhi' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">克重：</td><td><input name='kezhong' type='text' id='kezhong' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">退货原因：</td><td><textarea name='tuihuoyuanyin' cols='50' rows='5' id='tuihuoyuanyin' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>
		<tr style='display:none'><td width="200">回复：</td><td><textarea name='huifu' cols='50' rows='5' id='huifu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>
		<tr ><td width="200">退货日期：</td><td><input name='tuihuoriqi' type='text' id='tuihuoriqi' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" /></td></tr>
		<tr ><td width="200">卡号：</td><td><input name='kahao' type='text' id='kahao' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr><script language="javascript">document.form1.kahao.value='<%=connDbBean.readzd("huiyuanxinxi","kahao","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.kahao.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("huiyuanxinxi","xingming","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>
		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.xiaoshoudanhao.value='${tuihuoxinxi.xiaoshoudanhao}';</script>
	<script language="javascript">document.form1.shangpinmingcheng.value='${tuihuoxinxi.shangpinmingcheng}';</script>
	<script language="javascript">document.form1.caizhi.value='${tuihuoxinxi.caizhi}';</script>
	<script language="javascript">document.form1.kezhong.value='${tuihuoxinxi.kezhong}';</script>
	<script language="javascript">document.form1.tuihuoyuanyin.value='${tuihuoxinxi.tuihuoyuanyin}';</script>
	<script language="javascript">document.form1.huifu.value='${tuihuoxinxi.huifu}';</script>
	<script language="javascript">document.form1.tuihuoriqi.value='${tuihuoxinxi.tuihuoriqi}';</script>
	<script language="javascript">document.form1.kahao.value='${tuihuoxinxi.kahao}';</script>
	<script language="javascript">document.form1.xingming.value='${tuihuoxinxi.xingming}';</script>
	
					 </table>
			</form>
   </body>
</html>







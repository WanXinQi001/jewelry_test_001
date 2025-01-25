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
		<TITLE>修改厂商信息</TITLE>
	    
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="changshangxinxi_add.jsp?id=<%=id%>";
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
			<form action="updateChangshangxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改厂商信息<input type="hidden" name="id" value="${changshangxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">账号：</td><td><input name='zhanghao' type='text' id='zhanghao' onblur='hsgcheck()' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabelzhanghao' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmima' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">公司名称：</td><td><input name='gongsimingcheng' type='text' id='gongsimingcheng' value='' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">负责人：</td><td><input name='fuzeren' type='text' id='fuzeren' value='' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">性别：</td><td><select name='xingbie' id='xingbie' class="form-control"><option value="男">男</option><option value="女">女</option></select></td></tr>
		<tr ><td width="200">照片：</td><td><input name='zhaopian' type='text' id='zhaopian' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('zhaopian')"/></div></td></tr>
		<tr ><td width="200">身份证：</td><td><input name='shenfenzheng' type='text' id='shenfenzheng' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelshenfenzheng' style='margin-top:16px;' />必需身份证格式</td></tr>
		<tr ><td width="200">职位：</td><td><input name='zhiwei' type='text' id='zhiwei' value='' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabellianxidianhua' style='margin-top:16px;' />必需电话格式[7或8位电话，或11位手机]</td></tr>
		<tr 0><td width="200">邮箱：</td><td><input name='youxiang' type='text' id='youxiang' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelyouxiang' style='margin-top:16px;' />必需邮箱格式</td></tr>
		<tr 1><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>
		<tr 2><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.zhanghao.value='${changshangxinxi.zhanghao}';</script>
	<script language="javascript">document.form1.mima.value='${changshangxinxi.mima}';</script>
	<script language="javascript">document.form1.gongsimingcheng.value='${changshangxinxi.gongsimingcheng}';</script>
	<script language="javascript">document.form1.fuzeren.value='${changshangxinxi.fuzeren}';</script>
	<script language="javascript">document.form1.xingbie.value='${changshangxinxi.xingbie}';</script>
	<script language="javascript">document.form1.zhaopian.value='${changshangxinxi.zhaopian}';</script>
	<script language="javascript">document.form1.shenfenzheng.value='${changshangxinxi.shenfenzheng}';</script>
	<script language="javascript">document.form1.zhiwei.value='${changshangxinxi.zhiwei}';</script>
	<script language="javascript">document.form1.lianxidianhua.value='${changshangxinxi.lianxidianhua}';</script>
	<script language="javascript">document.form1.youxiang.value='${changshangxinxi.youxiang}';</script>
	<script language="javascript">document.form1.dizhi.value='${changshangxinxi.dizhi}';</script>
	<script language="javascript">document.form1.beizhu.value='${changshangxinxi.beizhu}';</script>
	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var zhanghaoobj = document.getElementById("zhanghao"); if(zhanghaoobj.value==""){document.getElementById("clabelzhanghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入账号</font>";return false;}else{document.getElementById("clabelzhanghao").innerHTML="  "; } 
	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 
	var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value!=""){ if(/^\d{15}$|^\d{18}$|^\d{17}[xX]$/.test(shenfenzhengobj.value)){document.getElementById("clabelshenfenzheng").innerHTML=""; }else{document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>必需身份证格式</font>"; return false;}}  
    var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(lianxidianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxidianhuaobj.value)){document.getElementById("clabellianxidianhua").innerHTML=""; }else{document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}  
    var youxiangobj = document.getElementById("youxiang"); if(youxiangobj.value!=""){ if(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/.test(youxiangobj.value)){document.getElementById("clabelyouxiang").innerHTML=""; }else{document.getElementById("clabelyouxiang").innerHTML="&nbsp;&nbsp;<font color=red>必需邮箱格式</font>"; return false;}}  
    


return true;   
}   
popheight=450;
</script>  

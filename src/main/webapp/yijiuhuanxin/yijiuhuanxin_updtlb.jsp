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
		<TITLE>设置以旧换新</TITLE>
	    
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
       
	</head>
<%
  String id="";
//islbd1q 
   %>
<script language="javascript">

function gows()
{
	document.location.href="yijiuhuanxin_add.jsp?id=<%=id%>";
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
			<form action="updateYijiuhuanxin.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">设置以旧换新<input type="hidden" name="id" value="${yijiuhuanxin.id}" /></td>
						</tr>
		<tr ><td width="200">回复：</td><td><textarea name='huifu' cols='50' rows='5' id='huifu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr><script language="javascript">document.form1.kahao.value='<%=connDbBean.readzd("huiyuanxinxi","kahao","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.kahao.setAttribute("readOnly",'true');</script><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("huiyuanxinxi","xingming","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script><script language="javascript">document.form1.shouji.value='<%=connDbBean.readzd("huiyuanxinxi","shouji","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.shouji.setAttribute("readOnly",'true');</script>
		
		
						<tr align='center'   height="22">
						    <td width="200"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;						    </td>
						</tr>
						<script language="javascript">document.form1.bianhao.value='${yijiuhuanxin.bianhao}';</script>
	<script language="javascript">document.form1.wupinmingcheng.value='${yijiuhuanxin.wupinmingcheng}';</script>
	<script language="javascript">document.form1.caizhi.value='${yijiuhuanxin.caizhi}';</script>
	<script language="javascript">document.form1.kezhong.value='${yijiuhuanxin.kezhong}';</script>
	<script language="javascript">document.form1.shuliang.value='${yijiuhuanxin.shuliang}';</script>
	<script language="javascript">document.form1.tupian.value='${yijiuhuanxin.tupian}';</script>
	<script language="javascript">document.form1.wupinqingkuang.value='${yijiuhuanxin.wupinqingkuang}';</script>
	<script language="javascript">document.form1.duihuanwupin.value='${yijiuhuanxin.duihuanwupin}';</script>
	<script language="javascript">document.form1.huifu.value='${yijiuhuanxin.huifu}';</script>
	<script language="javascript">document.form1.faburiqi.value='${yijiuhuanxin.faburiqi}';</script>
	<script language="javascript">document.form1.kahao.value='${yijiuhuanxin.kahao}';</script>
	<script language="javascript">document.form1.xingming.value='${yijiuhuanxin.xingming}';</script>
	<script language="javascript">document.form1.shouji.value='${yijiuhuanxin.shouji}';</script>
					 </table>
			</form>
   </body>
</html>





<script language=javascript >  
 
 function checkform(){  
 
	var wupinmingchengobj = document.getElementById("wupinmingcheng"); if(wupinmingchengobj.value==""){document.getElementById("clabelwupinmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入物品名称</font>";return false;}else{document.getElementById("clabelwupinmingcheng").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  

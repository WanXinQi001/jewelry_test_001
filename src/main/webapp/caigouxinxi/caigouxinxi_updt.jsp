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
		<TITLE>修改采购信息</TITLE>
	    
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

<%--function gows()--%>
<%--{--%>
<%--	document.location.href="../caigouxinxi/caigouxinxi_add.jsp?id=<%=id%>";--%>
<%--}--%>
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
			<form action="../updateCaigouxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改采购信息<input type="hidden" name="id" value="${caigouxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">入库单号：</td><td><input name='rukudanhao' type='text' id='rukudanhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">商品名称：</td><td><input name='shangpinmingcheng' type='text' id='shangpinmingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">材质：</td><td><input name='caizhi' type='text' id='caizhi' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">库存：</td><td><input name='kucun' type='text' id='kucun' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">采购价格：</td><td><input name='caigoujiage' type='text' id='caigoujiage' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelcaigoujiage' style='margin-top:16px;' />必需数字型</td></tr>
		<tr ><td width="200">采购数量：</td><td><input name='caigoushuliang' type='text' id='caigoushuliang' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelcaigoushuliang' style='margin-top:16px;' />必需数字型</td></tr>
		<tr ><td width="200">总价格：</td><td><input name='zongjiage' type='text' id='zongjiage' value='' onblur='' class="form-control" readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>
		<tr ><td width="200">账号：</td><td><select name='zhanghao' id='zhanghao' class="form-control" onChange='gows();'><%=connDbBean.hsggetoption2("changshangxinxi","zhanghao")%></select></td></tr>
		<tr ><td width="200">公司名称：</td><td><input name='gongsimingcheng' type='text' id='gongsimingcheng'  class="form-control" ></td></tr>
		<tr 0><td width="200">采购日期：</td><td><input name='caigouriqi' type='text' id='caigouriqi' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" /></td></tr>
		<tr 1><td width="200">工号：</td><td><input name='gonghao' type='text' id='gonghao' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr><script language="javascript">document.form1.gonghao.value='<%=connDbBean.readzd("yuangongxinxi","gonghao","gonghao",(String)request.getSession().getAttribute("username"))%>';document.form1.gonghao.setAttribute("readOnly",'true');</script>
		<tr 2><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("yuangongxinxi","xingming","gonghao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>
		<tr 3><td width="200">部门：</td><td><input name='bumen' type='text' id='bumen' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.bumen.value='<%=connDbBean.readzd("yuangongxinxi","bumen","gonghao",(String)request.getSession().getAttribute("username"))%>';document.form1.bumen.setAttribute("readOnly",'true');</script>
		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.rukudanhao.value='${caigouxinxi.rukudanhao}';</script>
	<script language="javascript">document.form1.shangpinmingcheng.value='${caigouxinxi.shangpinmingcheng}';</script>
	<script language="javascript">document.form1.caizhi.value='${caigouxinxi.caizhi}';</script>
	<script language="javascript">document.form1.kucun.value='${caigouxinxi.kucun}';</script>
	<script language="javascript">document.form1.caigoujiage.value='${caigouxinxi.caigoujiage}';</script>
	<script language="javascript">document.form1.caigoushuliang.value='${caigouxinxi.caigoushuliang}';</script>
	<script language="javascript">document.form1.zongjiage.value='${caigouxinxi.zongjiage}';</script>
	<script language="javascript">document.form1.zhanghao.value='${caigouxinxi.zhanghao}';</script>
	<script language="javascript">document.form1.gongsimingcheng.value='${caigouxinxi.gongsimingcheng}';</script>
	<script language="javascript">document.form1.caigouriqi.value='${caigouxinxi.caigouriqi}';</script>
	<script language="javascript">document.form1.gonghao.value='${caigouxinxi.gonghao}';</script>
	<script language="javascript">document.form1.xingming.value='${caigouxinxi.xingming}';</script>
	<script language="javascript">document.form1.bumen.value='${caigouxinxi.bumen}';</script>
	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	
    
    var zongjiagej=1;if(document.getElementById("caigoujiage").value!=""){zongjiagej=zongjiagej*parseFloat(document.getElementById("caigoujiage").value);}if(document.getElementById("caigoushuliang").value!=""){zongjiagej=zongjiagej*parseFloat(document.getElementById("caigoushuliang").value);}document.getElementById("zongjiage").value=zongjiagej;
	


return true;   
}   
popheight=450;
</script>  

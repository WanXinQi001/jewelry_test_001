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
		<TITLE>修改商品购买</TITLE>
	    
<link rel="stylesheet" href="../images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="../images/hsgcommon/div.css" type="text/css">
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="shangpingoumai_add.jsp?id=<%=id%>";
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
			<form action="updateShangpingoumai.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改商品购买<input type="hidden" name="id" value="${shangpingoumai.id}" /></td>
						</tr>
						<tr ><td width="200">销售单号：</td><td><input name='xiaoshoudanhao' type='text' id='xiaoshoudanhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">商品名称：</td><td><input name='shangpinmingcheng' type='text' id='shangpinmingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">材质：</td><td><input name='caizhi' type='text' id='caizhi' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">克重：</td><td><input name='kezhong' type='text' id='kezhong' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">工号：</td><td><input name='gonghao' type='text' id='gonghao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">部门：</td><td><input name='bumen' type='text' id='bumen' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">获得积分：</td><td><input name='huodejifen' type='text' id='huodejifen' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">库存：</td><td><input name='kucun' type='text' id='kucun' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr 0><td width="200">购买数量：</td><td><input name='goumaishuliang' type='text' id='goumaishuliang' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelgoumaishuliang' style='margin-top:16px;' />必需数字型</td></tr>
		<tr 1><td width="200">总价格：</td><td><input name='zongjiage' type='text' id='zongjiage' value='' onblur='' class="form-control" readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>
		<tr 2><td width="200">购买日期：</td><td><input name='goumairiqi' type='text' id='goumairiqi' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" /></td></tr>
		<tr 3><td width="200">卡号：</td><td><input name='kahao' type='text' id='kahao' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr><script language="javascript">document.form1.kahao.value='<%=connDbBean.readzd("huiyuanxinxi","kahao","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.kahao.setAttribute("readOnly",'true');</script>
		<tr 4><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("huiyuanxinxi","xingming","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>
		<tr 5><td width="200">会员等级：</td><td><input name='huiyuandengji' type='text' id='huiyuandengji' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.huiyuandengji.value='<%=connDbBean.readzd("huiyuanxinxi","huiyuandengji","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.huiyuandengji.setAttribute("readOnly",'true');</script>
		<tr 6><td width="200">折扣：</td><td><input name='zhekou' type='text' id='zhekou' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.zhekou.value='<%=connDbBean.readzd("huiyuanxinxi","zhekou","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.zhekou.setAttribute("readOnly",'true');</script>
		<tr 7><td width="200">手机：</td><td><input name='shouji' type='text' id='shouji' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.shouji.value='<%=connDbBean.readzd("huiyuanxinxi","shouji","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.shouji.setAttribute("readOnly",'true');</script>
		<tr 8><td width="200">收货地址：</td><td><input name='shouhuodizhi' type='text' id='shouhuodizhi' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.shouhuodizhi.value='<%=connDbBean.readzd("huiyuanxinxi","shouhuodizhi","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.shouhuodizhi.setAttribute("readOnly",'true');</script>
		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.xiaoshoudanhao.value='${shangpingoumai.xiaoshoudanhao}';</script>
	<script language="javascript">document.form1.shangpinmingcheng.value='${shangpingoumai.shangpinmingcheng}';</script>
	<script language="javascript">document.form1.caizhi.value='${shangpingoumai.caizhi}';</script>
	<script language="javascript">document.form1.kezhong.value='${shangpingoumai.kezhong}';</script>
	<script language="javascript">document.form1.gonghao.value='${shangpingoumai.gonghao}';</script>
	<script language="javascript">document.form1.bumen.value='${shangpingoumai.bumen}';</script>
	<script language="javascript">document.form1.huodejifen.value='${shangpingoumai.huodejifen}';</script>
	<script language="javascript">document.form1.kucun.value='${shangpingoumai.kucun}';</script>
	<script language="javascript">document.form1.jiage.value='${shangpingoumai.jiage}';</script>
	<script language="javascript">document.form1.goumaishuliang.value='${shangpingoumai.goumaishuliang}';</script>
	<script language="javascript">document.form1.zongjiage.value='${shangpingoumai.zongjiage}';</script>
	<script language="javascript">document.form1.goumairiqi.value='${shangpingoumai.goumairiqi}';</script>
	<script language="javascript">document.form1.kahao.value='${shangpingoumai.kahao}';</script>
	<script language="javascript">document.form1.xingming.value='${shangpingoumai.xingming}';</script>
	<script language="javascript">document.form1.huiyuandengji.value='${shangpingoumai.huiyuandengji}';</script>
	<script language="javascript">document.form1.zhekou.value='${shangpingoumai.zhekou}';</script>
	<script language="javascript">document.form1.shouji.value='${shangpingoumai.shouji}';</script>
	<script language="javascript">document.form1.shouhuodizhi.value='${shangpingoumai.shouhuodizhi}';</script>
	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	
    if(parseInt(document.form1.kucun.value)<parseInt(document.form1.goumaishuliang.value)){bootbox.alert("对不起，库存必需大于购买数量");return false;}
	var zongjiagej=1;if(document.getElementById("jiage").value!=""){zongjiagej=zongjiagej*parseFloat(document.getElementById("jiage").value);}if(document.getElementById("goumaishuliang").value!=""){zongjiagej=zongjiagej*parseFloat(document.getElementById("goumaishuliang").value);}document.getElementById("zongjiage").value=zongjiagej;
	


return true;   
}   
popheight=450;
</script>  

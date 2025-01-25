<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/popup.js"></script>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <title>旧料回收</title>

    <link href="../qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="../qtimages/css/index.css">
</head>
<%
if(request.getSession().getAttribute("username")==null)
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='../index.do';</script>");
	return;
}
  String id="";


 



   %>


	
	<script language="javascript">
function checkform()
{
	var wupinmingchengobj = document.getElementById("wupinmingcheng"); if(wupinmingchengobj.value==""){document.getElementById("clabelwupinmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入物品名称</font>";return false;}else{document.getElementById("clabelwupinmingcheng").innerHTML="  "; } 
	var shuliangobj = document.getElementById("shuliang"); if(shuliangobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(shuliangobj.value)){document.getElementById("clabelshuliang").innerHTML=""; }else{document.getElementById("clabelshuliang").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    
}
function gow()
{
	document.location.href="jiuliaohuishouadd.jsp?id=<%=id%>";
}
</script>


<body>
<jsp:include page="../qttop.jsp"></jsp:include>
<jsp:include page="../bht.jsp"></jsp:include>
    <section id="introduce">
        <div class="container">
			<div class="head text-center">
                    <h3>旧料回收</h3>
            </div>
          
		<link rel="stylesheet" href="../images/hsgcommon/divqt.css" type="text/css">
<link rel="stylesheet" href="../images/hsgcommon/commonqt.css" type="text/css">
<script src="../images/hsgcommon/jq.js"></script>
<script src="../images/hsgcommon/common.js"></script>
<script src="../images/hsgcommon/bootbox.js"></script>
<% 





%>

  

				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						<form action="addJiuliaohuishou.do" name="form1" method="post">
						<tr ><td width="200">回收单号：</td><td><input name='huishoudanhao' type='text' id='huishoudanhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">物品名称：</td><td><input name='wupinmingcheng' type='text' id='wupinmingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelwupinmingcheng' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">材质：</td><td><input name='caizhi' type='text' id='caizhi' value='' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">克重：</td><td><input name='kezhong' type='text' id='kezhong' value='' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">数量：</td><td><input name='shuliang' type='text' id='shuliang' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelshuliang' style='margin-top:16px;' />必需数字型</td></tr>
		<tr ><td width="200">图片：</td><td><input name='tupian' type='text' id='tupian' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('tupian')"/></div></td></tr>
		<tr ><td width="200">详细情况：</td><td><textarea name='xiangxiqingkuang' cols='50' rows='5' id='xiangxiqingkuang' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>
		<tr ><td width="200">内容：</td><td><textarea name='neirong' cols='50' rows='5' id='neirong' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>
		<tr style='display:none'><td width="200">回复：</td><td><textarea name='huifu' cols='50' rows='5' id='huifu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>
		<tr 0><td width="200">卡号：</td><td><input name='kahao' type='text' id='kahao' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr><script language="javascript">document.form1.kahao.value='<%=connDbBean.readzd("huiyuanxinxi","kahao","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.kahao.setAttribute("readOnly",'true');</script>
		<tr 1><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("huiyuanxinxi","xingming","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>
		<tr 2><td width="200">性别：</td><td><input name='xingbie' type='text' id='xingbie' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.xingbie.value='<%=connDbBean.readzd("huiyuanxinxi","xingbie","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingbie.setAttribute("readOnly",'true');</script>
		<tr 3><td width="200">手机：</td><td><input name='shouji' type='text' id='shouji' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.shouji.value='<%=connDbBean.readzd("huiyuanxinxi","shouji","kahao",(String)request.getSession().getAttribute("username"))%>';document.form1.shouji.setAttribute("readOnly",'true');</script>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						      <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						</form>
					 </table>
			
			<script language="javascript">popheight = 450;</script>
						  
        </div>
    </section>
<jsp:include page="../qtdown.jsp"></jsp:include>
<jsp:include page="../qtuserlog.jsp"></jsp:include>
    <script src="../qtimages/lib/jquery/jquery.min.js"></script>
    <script src="../qtimages/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="../qtimages/js/index.js"></script>
  
</body> 
</html>

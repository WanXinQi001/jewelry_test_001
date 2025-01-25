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
    <title>会员信息</title>

    <link href="../qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="../qtimages/css/index.css">
</head>
<%
  String id="";
   %>


	
<script language=javascript >  
function hsgcheck() {
		var kahao = $("#kahao").val();
		if(kahao==""||(kahao.length<3||kahao.length>12)){
			 $("#clabelkahao").html("<font color=red>卡号不能为空且长度在3～12位之间！</font>");
			 $("input[id=kahao]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelkahao").html("");
			$.ajax({
				url : "quchongHuiyuanxinxi.do",
				type : "post",
				data : "kahao=" + kahao,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelkahao").html("<font color=red>卡号已存在，请更换！</font>");
					$("input[id=kahao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelkahao").html("系统异常，请检查错误！");
					$("input[id=kahao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>
	<script language="javascript">
function checkform()
{
	var kahaoobj = document.getElementById("kahao"); if(kahaoobj.value==""){document.getElementById("clabelkahao").innerHTML="&nbsp;&nbsp;<font color=red>请输入卡号</font>";return false;}else{document.getElementById("clabelkahao").innerHTML="  "; } 
	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 
	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入姓名</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 
	var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value!=""){ if(/^\d{15}$|^\d{18}$|^\d{17}[xX]$/.test(shenfenzhengobj.value)){document.getElementById("clabelshenfenzheng").innerHTML=""; }else{document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>必需身份证格式</font>"; return false;}}  
    var shoujiobj = document.getElementById("shouji"); if(shoujiobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(shoujiobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(shoujiobj.value)){document.getElementById("clabelshouji").innerHTML=""; }else{document.getElementById("clabelshouji").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}  
    var xiaofeijineobj = document.getElementById("xiaofeijine"); if(xiaofeijineobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(xiaofeijineobj.value)){document.getElementById("clabelxiaofeijine").innerHTML=""; }else{document.getElementById("clabelxiaofeijine").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var jifenobj = document.getElementById("jifen"); if(jifenobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(jifenobj.value)){document.getElementById("clabeljifen").innerHTML=""; }else{document.getElementById("clabeljifen").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    
}
function gow()
{
	document.location.href="huiyuanxinxiadd.jsp?id=<%=id%>&huiyuandengji="+document.form1.huiyuandengji.value;
}
</script>


<body>
<jsp:include page="../qttop.jsp"></jsp:include>
<jsp:include page="../bht.jsp"></jsp:include>
    <section id="introduce">
        <div class="container">
			<div class="head text-center">
                    <h3>会员信息</h3>
            </div>
          
		<link rel="stylesheet" href="../images/hsgcommon/divqt.css" type="text/css">
<link rel="stylesheet" href="../images/hsgcommon/commonqt.css" type="text/css">
<script src="../images/hsgcommon/jq.js"></script>
<script src="../images/hsgcommon/common.js"></script>
<script src="../images/hsgcommon/bootbox.js"></script>
<% 





%>

  

				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						<form action="addHuiyuanxinxi.do" name="form1" method="post">
						<tr ><td width="200">卡号：</td><td><input name='kahao' type='text' id='kahao' onblur='hsgcheck()' class="form-control" value='' />&nbsp;*<label id='clabelkahao' style='margin-top:10px;' /></td></tr>
		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmima' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelxingming' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">性别：</td><td><select name='xingbie' id='xingbie' class="form-control"><option value="男">男</option><option value="女">女</option></select></td></tr>
		<tr ><td width="200">照片：</td><td><input name='zhaopian' type='text' id='zhaopian' size='50' value='' onblur=''  class="form-control" />
		  <span style="margin-top:16px;">
		  <input name="button" type='button' onClick="up('zhaopian')" value='上传'/>
		  </span></td></tr>
		<tr ><td width="200">会员等级：</td><td><select name='huiyuandengji' id='huiyuandengji' class="form-control"><option value="铜牌会员">铜牌会员</option></select></td></tr>
		<tr ><td width="200">折扣：</td><td><select name='zhekou' id='zhekou' class="form-control"><option value="无">无</option></select></td></tr>
		<tr ><td width="200">身份证：</td><td><input name='shenfenzheng' type='text' id='shenfenzheng' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelshenfenzheng' style='margin-top:16px;' />必需身份证格式</td></tr>
		<tr 0><td width="200">手机：</td><td><input name='shouji' type='text' id='shouji' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelshouji' style='margin-top:16px;' />必需电话格式[7或8位电话，或11位手机]</td></tr>
		<tr 1><td width="200">收货地址：</td><td><input name='shouhuodizhi' type='text' id='shouhuodizhi' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="200"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						      <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;						    </td>
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
<%
if(request.getParameter("huiyuandengji")==null || request.getParameter("huiyuandengji").equals("")){}else{
%>
<script language="javascript">
document.form1.huiyuandengji.value="<%=connDbBean.readzd("dengjixinxi","huiyuandengji","huiyuandengji",request.getParameter("huiyuandengji"))%>";
document.form1.zhekou.value="<%=connDbBean.readzd("dengjixinxi","zhekou","huiyuandengji",request.getParameter("huiyuandengji"))%>";
document.form1.zhekoujiage.value="<%=connDbBean.readzd("dengjixinxi","zhekoujiage","huiyuandengji",request.getParameter("huiyuandengji"))%>";
//suilafuzhi

</script>
<%
}
%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/popup.js"></script>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <title>商品购买</title>

    <link href="../qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="../qtimages/css/index.css">
</head>
<%
    if (request.getSession().getAttribute("username") == null) {
        out.print("<script>alert('对不起,请您先登陆!');location.href='../index.do';</script>");
        return;
    }
    String id = "";


%>


<script language="javascript">
    function checkform() {
        var goumaishuliangobj = document.getElementById("goumaishuliang");
        if (goumaishuliangobj.value != "") {
            if (/^[0-9]+.?[0-9]*$/.test(goumaishuliangobj.value)) {
                document.getElementById("clabelgoumaishuliang").innerHTML = "";
            } else {
                document.getElementById("clabelgoumaishuliang").innerHTML = "&nbsp;&nbsp;<font color=red>必需数字型</font>";
                return false;
            }
        }
        if (parseInt(document.form1.kucun.value) < parseInt(document.form1.goumaishuliang.value)) {
            bootbox.alert("对不起，库存必需大于购买数量");
            return false;
        }
        var zongjiagej = 1;
        if (document.getElementById("jiage").value != "") {
            zongjiagej = zongjiagej * parseFloat(document.getElementById("jiage").value);
        }
        if (document.getElementById("goumaishuliang").value != "") {
            zongjiagej = zongjiagej * parseFloat(document.getElementById("goumaishuliang").value);
        }
        document.getElementById("zongjiage").value = zongjiagej;

    }

    function gow() {
        document.location.href = "shangpingoumaiadd.jsp?id=<%=id%>";
    }
</script>


<body>
<jsp:include page="../qttop.jsp"></jsp:include>
<jsp:include page="../bht.jsp"></jsp:include>
<section id="introduce">
    <div class="container">
        <div class="head text-center">
            <h3>商品购买</h3>
        </div>

        <link rel="stylesheet" href="../images/hsgcommon/divqt.css" type="text/css">
        <link rel="stylesheet" href="../images/hsgcommon/commonqt.css" type="text/css">
        <script src="../images/hsgcommon/jq.js"></script>
        <script src="../images/hsgcommon/common.js"></script>
        <script src="../images/hsgcommon/bootbox.js"></script>
        <%


        %>


        <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC"
               style="border-collapse:collapse" class="newsline">
            <form action="addShangpingoumai.do" name="form1" method="post">
                <tr>
                    <td width="200">销售单号：</td>
                    <td><input name='xiaoshoudanhao' type='text' id='xiaoshoudanhao' value='<%=connDbBean.getID()%>'
                               onblur='' class="form-control"/></td>
                </tr>
                <tr>
                    <td width="200">商品名称：</td>
                    <td><input name='shangpinmingcheng' type='text' id='shangpinmingcheng' value='' onblur=''
                               class="form-control" readonly='readonly'/></td>
                </tr>
                <script language="javascript">document.form1.shangpinmingcheng.value = '<%=connDbBean.readzd("shangpinxinxi","shangpinmingcheng","id",request.getParameter("id"))%>';
                document.form1.shangpinmingcheng.setAttribute("readOnly", 'true');</script>
                <tr>
                    <td width="200">材质：</td>
                    <td><input name='caizhi' type='text' id='caizhi' value='' onblur='' class="form-control"
                               readonly='readonly'/></td>
                </tr>
                <script language="javascript">document.form1.caizhi.value = '<%=connDbBean.readzd("shangpinxinxi","caizhi","id",request.getParameter("id"))%>';
                document.form1.caizhi.setAttribute("readOnly", 'true');</script>
                <tr>
                    <td width="200">克重：</td>
                    <td><input name='kezhong' type='text' id='kezhong' value='' onblur='' class="form-control"
                               readonly='readonly'/></td>
                </tr>
                <script language="javascript">document.form1.kezhong.value = '<%=connDbBean.readzd("shangpinxinxi","kezhong","id",request.getParameter("id"))%>';
                document.form1.kezhong.setAttribute("readOnly", 'true');</script>
                <tr>
                    <td width="200">工号：</td>
                    <td><input name='gonghao' type='text' id='gonghao' value='' onblur='' class="form-control"
                               readonly='readonly'/></td>
                </tr>
                <script language="javascript">document.form1.gonghao.value = '<%=connDbBean.readzd("shangpinxinxi","gonghao","id",request.getParameter("id"))%>';
                document.form1.gonghao.setAttribute("readOnly", 'true');</script>
                <tr>
                    <td width="200">部门：</td>
                    <td><input name='bumen' type='text' id='bumen' value='' onblur='' class="form-control"
                               readonly='readonly'/></td>
                </tr>
                <script language="javascript">document.form1.bumen.value = '<%=connDbBean.readzd("shangpinxinxi","bumen","id",request.getParameter("id"))%>';
                document.form1.bumen.setAttribute("readOnly", 'true');</script>
                <tr>
                    <td width="200">获得积分：</td>
                    <td><input name='huodejifen' type='text' id='huodejifen' value='' onblur='' class="form-control"
                               readonly='readonly'/></td>
                </tr>
                <script language="javascript">document.form1.huodejifen.value = '<%=connDbBean.readzd("shangpinxinxi","huodejifen","id",request.getParameter("id"))%>';
                document.form1.huodejifen.setAttribute("readOnly", 'true');</script>
                <tr>
                    <td width="200">库存：</td>
                    <td><input name='kucun' type='text' id='kucun' value='' onblur='' class="form-control"
                               readonly='readonly'/></td>
                </tr>
                <script language="javascript">document.form1.kucun.value = '<%=connDbBean.readzd("shangpinxinxi","kucun","id",request.getParameter("id"))%>';
                document.form1.kucun.setAttribute("readOnly", 'true');</script>
                <tr>
                    <td width="200">价格：</td>
                    <td><input name='jiage' type='text' id='jiage' value='' onblur='' class="form-control"
                               readonly='readonly'/></td>
                </tr>
                <script language="javascript">document.form1.jiage.value = '<%=connDbBean.readzd("shangpinxinxi","jiage","id",request.getParameter("id"))%>';
                document.form1.jiage.setAttribute("readOnly", 'true');</script>
                <tr 0>
                    <td width="200">购买数量：</td>
                    <td><input name='goumaishuliang' type='text' id='goumaishuliang' value='' onblur='checkform()'
                               class="form-control"/>&nbsp;<label id='clabelgoumaishuliang' style='margin-top:16px;'/>必需数字型
                    </td>
                </tr>
                <tr 1>
                    <td width="200">总价格：</td>
                    <td><input name='zongjiage' type='text' id='zongjiage' value='' onblur='' class="form-control"
                               readonly='readonly'/> 此项不必填写，系统自动计算
                    </td>
                </tr>
                <tr 2>
                    <td width="200">购买日期：</td>
                    <td><input name='goumairiqi' type='text' id='goumairiqi' value='<%=connDbBean.getdate()%>' onblur=''
                               readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"
                               class="form-control"/></td>
                </tr>
                <tr 3>
                    <td width="200">卡号：</td>
                    <td><input name='kahao' type='text' id='kahao' onblur='' class="form-control"
                               value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly"/>
                    </td>
                </tr>
                <script language="javascript">document.form1.kahao.value = '<%=connDbBean.readzd("huiyuanxinxi","kahao","kahao",(String)request.getSession().getAttribute("username"))%>';
                document.form1.kahao.setAttribute("readOnly", 'true');</script>
                <tr 4>
                    <td width="200">姓名：</td>
                    <td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control"/></td>
                </tr>
                <script language="javascript">document.form1.xingming.value = '<%=connDbBean.readzd("huiyuanxinxi","xingming","kahao",(String)request.getSession().getAttribute("username"))%>';
                document.form1.xingming.setAttribute("readOnly", 'true');</script>
                <tr 5>
                    <td width="200">会员等级：</td>
                    <td><input name='huiyuandengji' type='text' id='huiyuandengji' value='' onblur=''
                               class="form-control"/></td>
                </tr>
                <script language="javascript">document.form1.huiyuandengji.value = '<%=connDbBean.readzd("huiyuanxinxi","huiyuandengji","kahao",(String)request.getSession().getAttribute("username"))%>';
                document.form1.huiyuandengji.setAttribute("readOnly", 'true');</script>
                <tr 6>
                    <td width="200">折扣：</td>
                    <td><input name='zhekou' type='text' id='zhekou' value='' onblur='' class="form-control"/></td>
                </tr>
                <script language="javascript">document.form1.zhekou.value = '<%=connDbBean.readzd("huiyuanxinxi","zhekou","kahao",(String)request.getSession().getAttribute("username"))%>';
                document.form1.zhekou.setAttribute("readOnly", 'true');</script>
                <tr 7>
                    <td width="200">手机：</td>
                    <td><input name='shouji' type='text' id='shouji' value='' onblur='' class="form-control"/></td>
                </tr>
                <script language="javascript">document.form1.shouji.value = '<%=connDbBean.readzd("huiyuanxinxi","shouji","kahao",(String)request.getSession().getAttribute("username"))%>';
                document.form1.shouji.setAttribute("readOnly", 'true');</script>
                <tr 8>
                    <td width="200">收货地址：</td>
                    <td><input name='shouhuodizhi' type='text' id='shouhuodizhi' value='' onblur=''
                               class="form-control"/></td>
                </tr>
                <script language="javascript">document.form1.shouhuodizhi.value = '<%=connDbBean.readzd("huiyuanxinxi","shouhuodizhi","kahao",(String)request.getSession().getAttribute("username"))%>';
                document.form1.shouhuodizhi.setAttribute("readOnly", 'true');</script>


                <tr align='center' height="22">
                    <td width="25%" align="right">&nbsp;

                    </td>
                    <td width="75%" align="left">
                        <input type="submit" name="querenzhuce" id="querenzhuce" value="提交"
                               onClick="return checkform();"/>
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

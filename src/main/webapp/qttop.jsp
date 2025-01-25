<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<!--顶部通栏-->
<header class="wjs_topBar">
    <div class="container">
        <div class="row">
            <div class="col-md-3 hidden-xs topBar-brand">
                <img src="../qtimages/code.png" class="logo">
                <span class="name">珍宝阁珠宝销售管理系统</span>
            </div>
            <div class="input-group col-md-6 col-xs-6">
                <!--<input type="text" class="form-control" placeholder="Search for...">-->
                <span class="input-group-btn">
<!--                      <button class="btn btn-default" type="button"></button>
-->                    </span>
            </div>
            <div class="col-md-3 col-xs-6">
                <%
                    if ((String) request.getSession().getAttribute("username") == null || (String) request.getSession().getAttribute("username") == "") {
                %>
                <button class="btn btn-primary" data-toggle="modal" data-target="#myLoginModal">登录</button>
                <a href="../huiyuanxinxi/huiyuanxinxiadd.jsp" class="btn btn-danger">注册</a>
                <%} else { %>
                <%=request.getSession().getAttribute("username")%>,[<%=request.getSession().getAttribute("cx")%>]&nbsp;
                <a href="../logout.jsp" onclick="return confirm('确定要退出？')" class="btn btn-primary">退出</a>&nbsp; <a
                    href="../main.jsp" class="btn btn-danger">后台</a>
                <%} %>


            </div>
        </div>
    </div>
</header>

<!--导航栏-->
<nav class="navbar wjs_nav" data-spy="affix" data-offset-top="200">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class='nav navbar-nav ml'>
                <li class=''><a href='../index.do'>首页</a></li>
                <li class='show'><a>新闻信息</a>
                    <div class='pa'><a href='../xwtzList.do?lb=站内新闻'>站内新闻</a> <a href='../xwtzList.do?lb=通知公告'>通知公告</a>
                    </div>
                    <!--<li><a href='huiyuanxinxiadd.jsp'>会员注册</a></li>
                    -->
                <li><a href='../spxxListtp.do'>商品信息</a></li>
                <li><a href='../yijiuhuanxin/yijiuhuanxinadd.jsp'>以旧换新</a></li>

                <li><a href='../jiuliaohuishou/jiuliaohuishouadd.jsp'>旧料回收</a></li>
                <li><a href='../dx_detail.jsp?lb=系统简介'>系统简介</a></li>
                <!-- <li class='show'><a >系统概要</a>
            <div class='pa'><a href='dx_detail.jsp?lb=系统简介'>系统简介</a> </div>
        </li>-->
                <li class='show'><a>在线留言</a>
                    <div class='pa'><a href='../lyb.jsp'>在线留言</a> <a href='../lybList.do'>查看留言</a></div>
                </li>
                </li><!--yoxulixuyaxn-->
                <li><a href='../login.jsp'>后台管理</a></li>
            </ul>


        </div>
    </div>
</nav>
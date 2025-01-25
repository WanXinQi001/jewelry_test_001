<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台左侧导航（管理员）</title>
    <link rel="stylesheet" type="text/css" href="../images/public.css"/>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/public.js"></script>
    <meta http-equiv="Content - Type" content="text/html; charset=utf-8"/>
</head>
<body id="bg">
<div class="container">
    <div class="leftsidebar_box">
        <div class="line"><img src="../images/coin01.png"/>&nbsp;&nbsp;首页</div>

        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                系统用户管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="/staff/allusersList.do" target="hsgmain">管理员用户</a><img class="icon5"
                                                                                 src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../mod.jsp" target="hsgmain">修改密码</a><img class="icon5" src="../images/coin21.png"/>
            </dd>

        </dl>
        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                新闻公告管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../xinwentongzhi/xinwentongzhi_add.jsp?lb=站内新闻" target="hsgmain">站内新闻添加</a><img class="icon5"
                                                                                                          src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../xinwentongzhiList.do?lb=站内新闻" target="hsgmain">站内新闻查询</a><img class="icon5"
                                                                                           src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../xinwentongzhi/xinwentongzhi_add.jsp?lb=通知公告" target="hsgmain">通知公告添加</a><img class="icon5"
                                                                                                          src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../xinwentongzhiList.do?lb=通知公告" target="hsgmain">通知公告查询</a><img class="icon5"
                                                                                           src="../images/coin21.png"/>
            </dd>

        </dl>


        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                厂商信息管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../changshangxinxi/changshangxinxi_add.jsp" target="hsgmain">厂商信息添加</a><img class="icon5"
                                                                                                      src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../changshangxinxiList.do" target="hsgmain">厂商信息查询</a><img class="icon5"
                                                                                     src="../images/coin21.png"/>
            </dd>
        </dl>


        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                报表信息管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
<%--            <dd>--%>
<%--                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a--%>
<%--                    href="../gongzixinxi/gongzixinxi_add.jsp" target="hsgmain">工资报表添加</a><img class="icon5"--%>
<%--                                                                                              src="../images/coin21.png"/>--%>
<%--            </dd>--%>
<%--            <dd>--%>
<%--                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a--%>
<%--                    href="../gongzixinxiList.do" target="hsgmain">工资报表查询</a><img class="icon5"--%>
<%--                                                                                 src="../images/coin21.png"/>--%>
<%--            </dd>--%>


            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../caigouxinxiList.do" target="hsgmain">采购报表查询</a><img class="icon5"
                                                                                 src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../shangpingoumai/shangpingoumaiList.do" target="hsgmain">销售报表查询</a><img class="icon5"
                                                                                                   src="../images/coin21.png"/>
            </dd>
        </dl>


        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                财务信息管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../caiwushouru/caiwushouru_add.jsp" target="hsgmain">财务收入添加</a><img class="icon5"
                                                                                              src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../caiwushouruList.do" target="hsgmain">财务收入报表</a><img class="icon5"
                                                                                 src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../caiwuzhichu/caiwuzhichu_add.jsp" target="hsgmain">财务支出添加</a><img class="icon5"
                                                                                              src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../caiwuzhichuList.do" target="hsgmain">财务支出报表</a><img class="icon5"
                                                                                 src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../caiwuguanliList.do" target="hsgmain">财务信息查询</a><img class="icon5"
                                                                                 src="../images/coin21.png"/>
            </dd>

        </dl>


        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                系统简介设置<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../dx.jsp?lb=系统简介" target="hsgmain">系统简介设置</a><img class="icon5"
                                                                             src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../dx.jsp?lb=关于我们" target="hsgmain">关于我们设置</a><img class="icon5"
                                                                             src="../images/coin21.png"/>
            </dd>

        </dl>


    </div>
</div>
</body>
</html>
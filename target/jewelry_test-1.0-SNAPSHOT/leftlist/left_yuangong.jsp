<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台左侧导航（员工）</title>
    <link rel="stylesheet" type="text/css" href="../images/public.css"/>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/public.js"></script>
    <meta http-equiv="Content - Type" content="text/html; charset=utf - 8"/>
</head>
<body id="bg">
<div class="container">
    <div class="leftsidebar_box">
        <div class="line"><img src="../images/coin01.png"/>&nbsp;&nbsp;首页</div>


        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                员工信息管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../staff/yuangongxinxi_add.jsp" target="hsgmain">员工信息添加</a><img class="icon5"
                                                                                          src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../yuangongxinxiList.do" target="hsgmain">员工信息查询</a><img class="icon5"
                                                                                   src="../images/coin21.png"/>
            </dd>
        </dl>


        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                会员信息管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../huiyuanxinxiList.do" target="hsgmain">会员信息查询</a><img class="icon5"
                                                                                  src="../images/coin21.png"/>
            </dd>

        </dl>


        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                库存信息管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../shangpinxinxiList.do" target="hsgmain">库存信息管理</a><img class="icon5"
                                                                                   src="../images/coin21.png"/>
            </dd>

        </dl>


        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                退货信息管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../tuihuoxinxi/tuihuoxinxiList.do" target="hsgmain">退货信息查询</a><img class="icon5"
                                                                                             src="../images/coin21.png"/>
            </dd>

        </dl>


        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                销售信息管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../yijiuhuanxin/yijiuhuanxinList.do" target="hsgmain">以旧换新查询</a><img class="icon5"
                                                                                               src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../jiuliaohuishou/jiuliaohuishouList.do" target="hsgmain">旧料回收查询</a><img class="icon5"
                                                                                                   src="../images/coin21.png"/>
            </dd>
        </dl>


        <dl class="system_log">
            <dt>            <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                销售统计管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../shangpingoumai/shangpingoumai_tj_caizhi.jsp" target="hsgmain">按商品材质统计</a><img class="icon5"
                                                                                                           src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../shangpingoumai/shangpingoumai_tj_shangpinmingcheng.jsp" target="hsgmain">按商品名称统计</a><img
                    class="icon5" src="../images/coin21.png"/>
            </dd>

        </dl>


        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                采购统计管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../caigouxinxi/caigouxinxi_tj_shangpinmingcheng.jsp" target="hsgmain">按商品名称统计</a><img
                    class="icon5" src="../images/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../caigouxinxi/caigouxinxi_tj_caizhi.jsp" target="hsgmain">按商品材质统计</a><img class="icon5"
                                                                                                     src="../images/coin21.png"/>
            </dd>
        </dl>


        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                留言信息管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../liuyanbanList.do" target="hsgmain">留言信息查看</a><img class="icon5" src="../images/coin21.png"/>
            </dd>

        </dl>


    </div>
</div>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台左侧导航</title>
    <link rel="stylesheet" type="text/css" href="../images/public.css"/>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/public.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <head></head>
<body id="bg">
<div class="container">
    <div class="leftsidebar_box">
        <div class="line"><img src="../images/coin01.png"/>&nbsp;&nbsp;首页</div>

        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                个人资料管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../huiyuanxinxiList2.do" target="hsgmain">修改个人资料</a><img class="icon5"
                                                                                   src="../images/coin21.png"/>
            </dd>

        </dl>
        <!--<dl class="system_log">
                        <dt>
                            <img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 员工管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
                        </dt>
                        <dd>
                            <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../yuangongxinxi_add.jsp" target="hsgmain">员工添加</a><img class="icon5" src="images/coin21.png" />
                        </dd>
        <dd>
                            <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../yuangongxinxiList2.do" target="hsgmain">员工查询</a><img class="icon5" src="images/coin21.png" />
                        </dd>

                    </dl>
        <dl class="system_log">
                        <dt>
                            <img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 会员管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
                        </dt>
                        <dd>
                            <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../huiyuanxinxi_add.jsp" target="hsgmain">会员添加</a><img class="icon5" src="images/coin21.png" />
                        </dd>
        <dd>
                            <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../huiyuanxinxiList2.do" target="hsgmain">会员查询</a><img class="icon5" src="images/coin21.png" />
                        </dd>

                    </dl>
        <dl class="system_log">
                        <dt>
                            <img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 商品管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
                        </dt>
                        <dd>
                            <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../shangpinxinxi_add.jsp" target="hsgmain">商品添加</a><img class="icon5" src="images/coin21.png" />
                        </dd>
        <dd>
                            <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../shangpinxinxiList2.do" target="hsgmain">商品查询</a><img class="icon5" src="images/coin21.png" />
                        </dd>

                    </dl>
        <dl class="system_log">
                        <dt>
                            <img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 厂商管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
                        </dt>
                        <dd>
                            <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../changshangxinxi_add.jsp" target="hsgmain">厂商添加</a><img class="icon5" src="images/coin21.png" />
                        </dd>
        <dd>
                            <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../changshangxinxiList2.do" target="hsgmain">厂商查询</a><img class="icon5" src="images/coin21.png" />
                        </dd>

                    </dl>-->
        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                商品购买管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../shangpingoumai/shangpingoumaiList2.do" target="hsgmain">商品购买查询</a><img class="icon5"
                                                                                     src="../images/coin21.png"/>
            </dd>

        </dl>
        <!--<dl class="system_log">
                        <dt>
                            <img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 商品购买管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
                        </dt>
                        <dd>
                            <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../shangpingoumaiList2.do" target="hsgmain">商品购买查询</a><img class="icon5" src="images/coin21.png" />
                        </dd>

                    </dl>
        <dl class="system_log">
                        <dt>
                            <img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 财务管理管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
                        </dt>
                        <dd>
                            <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../caiwuguanli_add.jsp" target="hsgmain">财务管理添加</a><img class="icon5" src="images/coin21.png" />
                        </dd>
        <dd>
                            <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../caiwuguanliList2.do" target="hsgmain">财务管理查询</a><img class="icon5" src="images/coin21.png" />
                        </dd>

                    </dl>-->
        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                退货信息管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <!--<dd>
                <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../shangpingoumai_yanben6.do" target="hsgmain">退货添加</a><img class="icon5" src="images/coin21.png" />
            </dd>-->
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../tuihuoxinxi/tuihuoxinxiList2.do" target="hsgmain">退货信息查询</a><img class="icon5"
                                                                                  src="../images/coin21.png"/>
            </dd>

        </dl>
        <!--<dl class="system_log">
                        <dt>
                            <img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 采购管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
                        </dt>
                        <dd>
                            <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../shangpinxinxi_yanben7.do" target="hsgmain">采购添加</a><img class="icon5" src="images/coin21.png" />
                        </dd>
        <dd>
                            <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../caigouxinxiList2.do" target="hsgmain">采购查询</a><img class="icon5" src="images/coin21.png" />
                        </dd>

                    </dl>
        -->
        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                旧料回收管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <!--<dd>
                <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../jiuliaohuishou_add.jsp" target="hsgmain">旧料回收添加</a><img class="icon5" src="images/coin21.png" />
            </dd>-->
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../jiuliaohuishou/jiuliaohuishouList2.do" target="hsgmain">旧料回收查询</a><img class="icon5"
                                                                                     src="../images/coin21.png"/>
            </dd>

        </dl>
        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/>
                以旧换新管理<img class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <!--<dd>
                <img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a href="../yijiuhuanxin_add.jsp" target="hsgmain">以旧换新添加</a><img class="icon5" src="images/coin21.png" />
            </dd>-->
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../yijiuhuanxin/yijiuhuanxinList2.do" target="hsgmain">以旧换新查询</a><img class="icon5"
                                                                                   src="../images/coin21.png"/>
            </dd>

        </dl>
        <dl class="system_log">
            <dt>
                <img class="icon1" src="../images/coin01.png"/><img class="icon2" src="../images/coin02.png"/> 我的收藏<img
                    class="icon3" src="../images/coin19.png"/><img class="icon4" src="../images/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../images/coin111.png"/><img class="coin22" src="../images/coin222.png"/><a
                    href="../shoucangjilu/shoucangjilu_list2.jsp" target="hsgmain">我的收藏</a><img class="icon5"
                                                                                                src="../images/coin21.png"/>
            </dd>

        </dl>


    </div>
</div>
</body>
</html>
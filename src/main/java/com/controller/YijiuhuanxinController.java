package com.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Yijiuhuanxin;
import com.server.YijiuhuanxinServer;
import com.util.PageBean;

import java.sql.SQLException;

@Controller
@RequestMapping("yijiuhuanxin")
public class YijiuhuanxinController {
    @Resource
    private YijiuhuanxinServer yijiuhuanxinService;



    @RequestMapping("addYijiuhuanxin.do")
    public String addYijiuhuanxin(HttpServletRequest request,Yijiuhuanxin yijiuhuanxin,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());

        yijiuhuanxin.setAddtime(time.toString().substring(0, 19));
        yijiuhuanxinService.add(yijiuhuanxin);

        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "yijiuhuanxinList.do");

        return "redirect:../postback.jsp";
        //return "redirect:yijiuhuanxinList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateYijiuhuanxin.do")
    public String doUpdateYijiuhuanxin(int id,ModelMap map,Yijiuhuanxin yijiuhuanxin){
        yijiuhuanxin=yijiuhuanxinService.getById(id);
        map.put("yijiuhuanxin", yijiuhuanxin);
        return "yijiuhuanxin/yijiuhuanxin_updt";
    }



    @RequestMapping("doUpdateYijiuhuanxinlb.do")
    public String doUpdateYijiuhuanxinlb(int id,ModelMap map,Yijiuhuanxin yijiuhuanxin){
        yijiuhuanxin=yijiuhuanxinService.getById(id);
        map.put("yijiuhuanxin", yijiuhuanxin);
        return "yijiuhuanxin/yijiuhuanxin_updtlb";
    }

    @RequestMapping("updateYijiuhuanxinlb.do")
    public String updateYijiuhuanxinlb(int id,ModelMap map,Yijiuhuanxin yijiuhuanxin){
        yijiuhuanxinService.updatelb(yijiuhuanxin);
        return "redirect:yijiuhuanxinList.do";
    }

    //	后台详细
    @RequestMapping("yijiuhuanxinDetail.do")
    public String yijiuhuanxinDetail(int id,ModelMap map,Yijiuhuanxin yijiuhuanxin){
        yijiuhuanxin=yijiuhuanxinService.getById(id);
        map.put("yijiuhuanxin", yijiuhuanxin);
        return "yijiuhuanxin/yijiuhuanxin_detail";
    }
    //	前台详细
    @RequestMapping("yjhxDetail.do")
    public String yjhxDetail(int id,ModelMap map,Yijiuhuanxin yijiuhuanxin){
        yijiuhuanxin=yijiuhuanxinService.getById(id);
        map.put("yijiuhuanxin", yijiuhuanxin);
        return "yijiuhuanxin/yijiuhuanxindetail";
    }
    //
    @RequestMapping("updateYijiuhuanxin.do")
    public String updateYijiuhuanxin(int id,ModelMap map,Yijiuhuanxin yijiuhuanxin,HttpServletRequest request,HttpSession session){
        yijiuhuanxinService.update(yijiuhuanxin);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:../postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:yijiuhuanxinList.do";
    }

    //	分页查询
    @RequestMapping("yijiuhuanxinList.do")
    public String yijiuhuanxinList(@RequestParam(value="page",required=false)String page,
                                   ModelMap map,HttpSession session,Yijiuhuanxin yijiuhuanxin, String bianhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang, String tupian, String wupinqingkuang, String duihuanwupin, String huifu, String faburiqi1,String faburiqi2, String kahao, String xingming, String shouji){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(shuliang==null||shuliang.equals("")){pmap.put("shuliang", null);}else{pmap.put("shuliang", shuliang);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(wupinqingkuang==null||wupinqingkuang.equals("")){pmap.put("wupinqingkuang", null);}else{pmap.put("wupinqingkuang", wupinqingkuang);}
        if(duihuanwupin==null||duihuanwupin.equals("")){pmap.put("duihuanwupin", null);}else{pmap.put("duihuanwupin", duihuanwupin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}

        int total=yijiuhuanxinService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yijiuhuanxin> list=yijiuhuanxinService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yijiuhuanxin/yijiuhuanxin_list";
    }

    @RequestMapping("yijiuhuanxin_yanben1.do")
    public String yijiuhuanxin_yanben1(@RequestParam(value="page",required=false)String page,
                                       ModelMap map,HttpSession session,Yijiuhuanxin yijiuhuanxin, String bianhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang, String tupian, String wupinqingkuang, String duihuanwupin, String huifu, String faburiqi1,String faburiqi2, String kahao, String xingming, String shouji){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(shuliang==null||shuliang.equals("")){pmap.put("shuliang", null);}else{pmap.put("shuliang", shuliang);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(wupinqingkuang==null||wupinqingkuang.equals("")){pmap.put("wupinqingkuang", null);}else{pmap.put("wupinqingkuang", wupinqingkuang);}
        if(duihuanwupin==null||duihuanwupin.equals("")){pmap.put("duihuanwupin", null);}else{pmap.put("duihuanwupin", duihuanwupin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}

        int total=yijiuhuanxinService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yijiuhuanxin> list=yijiuhuanxinService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yijiuhuanxin/yijiuhuanxin_yanben1";
    }
    @RequestMapping("yijiuhuanxin_yanben2.do")
    public String yijiuhuanxin_yanben2(@RequestParam(value="page",required=false)String page,
                                       ModelMap map,HttpSession session,Yijiuhuanxin yijiuhuanxin, String bianhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang, String tupian, String wupinqingkuang, String duihuanwupin, String huifu, String faburiqi1,String faburiqi2, String kahao, String xingming, String shouji){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(shuliang==null||shuliang.equals("")){pmap.put("shuliang", null);}else{pmap.put("shuliang", shuliang);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(wupinqingkuang==null||wupinqingkuang.equals("")){pmap.put("wupinqingkuang", null);}else{pmap.put("wupinqingkuang", wupinqingkuang);}
        if(duihuanwupin==null||duihuanwupin.equals("")){pmap.put("duihuanwupin", null);}else{pmap.put("duihuanwupin", duihuanwupin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}

        int total=yijiuhuanxinService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yijiuhuanxin> list=yijiuhuanxinService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yijiuhuanxin/yijiuhuanxin_yanben2";
    }
    @RequestMapping("yijiuhuanxin_yanben3.do")
    public String yijiuhuanxin_yanben3(@RequestParam(value="page",required=false)String page,
                                       ModelMap map,HttpSession session,Yijiuhuanxin yijiuhuanxin, String bianhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang, String tupian, String wupinqingkuang, String duihuanwupin, String huifu, String faburiqi1,String faburiqi2, String kahao, String xingming, String shouji){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(shuliang==null||shuliang.equals("")){pmap.put("shuliang", null);}else{pmap.put("shuliang", shuliang);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(wupinqingkuang==null||wupinqingkuang.equals("")){pmap.put("wupinqingkuang", null);}else{pmap.put("wupinqingkuang", wupinqingkuang);}
        if(duihuanwupin==null||duihuanwupin.equals("")){pmap.put("duihuanwupin", null);}else{pmap.put("duihuanwupin", duihuanwupin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}

        int total=yijiuhuanxinService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yijiuhuanxin> list=yijiuhuanxinService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yijiuhuanxin/yijiuhuanxin_yanben3";
    }
    @RequestMapping("yijiuhuanxin_yanben4.do")
    public String yijiuhuanxin_yanben4(@RequestParam(value="page",required=false)String page,
                                       ModelMap map,HttpSession session,Yijiuhuanxin yijiuhuanxin, String bianhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang, String tupian, String wupinqingkuang, String duihuanwupin, String huifu, String faburiqi1,String faburiqi2, String kahao, String xingming, String shouji){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(shuliang==null||shuliang.equals("")){pmap.put("shuliang", null);}else{pmap.put("shuliang", shuliang);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(wupinqingkuang==null||wupinqingkuang.equals("")){pmap.put("wupinqingkuang", null);}else{pmap.put("wupinqingkuang", wupinqingkuang);}
        if(duihuanwupin==null||duihuanwupin.equals("")){pmap.put("duihuanwupin", null);}else{pmap.put("duihuanwupin", duihuanwupin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}

        int total=yijiuhuanxinService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yijiuhuanxin> list=yijiuhuanxinService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yijiuhuanxin/yijiuhuanxin_yanben4";
    }
    @RequestMapping("yijiuhuanxin_yanben5.do")
    public String yijiuhuanxin_yanben5(@RequestParam(value="page",required=false)String page,
                                       ModelMap map,HttpSession session,Yijiuhuanxin yijiuhuanxin, String bianhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang, String tupian, String wupinqingkuang, String duihuanwupin, String huifu, String faburiqi1,String faburiqi2, String kahao, String xingming, String shouji){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(shuliang==null||shuliang.equals("")){pmap.put("shuliang", null);}else{pmap.put("shuliang", shuliang);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(wupinqingkuang==null||wupinqingkuang.equals("")){pmap.put("wupinqingkuang", null);}else{pmap.put("wupinqingkuang", wupinqingkuang);}
        if(duihuanwupin==null||duihuanwupin.equals("")){pmap.put("duihuanwupin", null);}else{pmap.put("duihuanwupin", duihuanwupin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}

        int total=yijiuhuanxinService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yijiuhuanxin> list=yijiuhuanxinService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yijiuhuanxin/yijiuhuanxin_yanben5";
    }

    @RequestMapping("yijiuhuanxinList2.do")
    public String yijiuhuanxinList2(@RequestParam(value="page",required=false)String page,
                                    ModelMap map,HttpSession session,Yijiuhuanxin yijiuhuanxin, String bianhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang, String tupian, String wupinqingkuang, String duihuanwupin, String huifu, String faburiqi1,String faburiqi2, String kahao, String xingming, String shouji,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);

        pmap.put("kahao", (String)request.getSession().getAttribute("username"));
        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(shuliang==null||shuliang.equals("")){pmap.put("shuliang", null);}else{pmap.put("shuliang", shuliang);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(wupinqingkuang==null||wupinqingkuang.equals("")){pmap.put("wupinqingkuang", null);}else{pmap.put("wupinqingkuang", wupinqingkuang);}
        if(duihuanwupin==null||duihuanwupin.equals("")){pmap.put("duihuanwupin", null);}else{pmap.put("duihuanwupin", duihuanwupin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}


        int total=yijiuhuanxinService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yijiuhuanxin> list=yijiuhuanxinService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yijiuhuanxin/yijiuhuanxin_list2";
    }


    @RequestMapping("yjhxList.do")
    public String yjhxList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Yijiuhuanxin yijiuhuanxin, String bianhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang, String tupian, String wupinqingkuang, String duihuanwupin, String huifu, String faburiqi1,String faburiqi2, String kahao, String xingming, String shouji){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(shuliang==null||shuliang.equals("")){pmap.put("shuliang", null);}else{pmap.put("shuliang", shuliang);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(wupinqingkuang==null||wupinqingkuang.equals("")){pmap.put("wupinqingkuang", null);}else{pmap.put("wupinqingkuang", wupinqingkuang);}
        if(duihuanwupin==null||duihuanwupin.equals("")){pmap.put("duihuanwupin", null);}else{pmap.put("duihuanwupin", duihuanwupin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}

        int total=yijiuhuanxinService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yijiuhuanxin> list=yijiuhuanxinService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yijiuhuanxin/yijiuhuanxinlist";
    }
    @RequestMapping("yjhxListtp.do")
    public String yjhxListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,HttpSession session,Yijiuhuanxin yijiuhuanxin, String bianhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang, String tupian, String wupinqingkuang, String duihuanwupin, String huifu, String faburiqi1,String faburiqi2, String kahao, String xingming, String shouji){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(shuliang==null||shuliang.equals("")){pmap.put("shuliang", null);}else{pmap.put("shuliang", shuliang);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(wupinqingkuang==null||wupinqingkuang.equals("")){pmap.put("wupinqingkuang", null);}else{pmap.put("wupinqingkuang", wupinqingkuang);}
        if(duihuanwupin==null||duihuanwupin.equals("")){pmap.put("duihuanwupin", null);}else{pmap.put("duihuanwupin", duihuanwupin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}

        int total=yijiuhuanxinService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yijiuhuanxin> list=yijiuhuanxinService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yijiuhuanxin/yijiuhuanxinlisttp";
    }

    @RequestMapping("deleteYijiuhuanxin.do")
    public String deleteYijiuhuanxin(int id,HttpServletRequest request){
        yijiuhuanxinService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:yijiuhuanxinList.do";
    }


}

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

import com.entity.Caiwushouru;
import com.server.CaiwushouruServer;
import com.util.PageBean;

import java.sql.SQLException;

@Controller
public class CaiwushouruController {
    @Resource
    private CaiwushouruServer caiwushouruService;



    @RequestMapping("addCaiwushouru.do")
    public String addCaiwushouru(HttpServletRequest request,Caiwushouru caiwushouru,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());

        caiwushouru.setAddtime(time.toString().substring(0, 19));
        caiwushouruService.add(caiwushouru);

        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "caiwushouruList.do");

        return "redirect:postback.jsp";
        //return "redirect:caiwushouruList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateCaiwushouru.do")
    public String doUpdateCaiwushouru(int id,ModelMap map,Caiwushouru caiwushouru){
        caiwushouru=caiwushouruService.getById(id);
        map.put("caiwushouru", caiwushouru);
        return "caiwushouru/caiwushouru_updt";
    }





    //	后台详细
    @RequestMapping("caiwushouruDetail.do")
    public String caiwushouruDetail(int id,ModelMap map,Caiwushouru caiwushouru){
        caiwushouru=caiwushouruService.getById(id);
        map.put("caiwushouru", caiwushouru);
        return "caiwushouru/caiwushouru_detail";
    }
    //	前台详细
    @RequestMapping("cwsrDetail.do")
    public String cwsrDetail(int id,ModelMap map,Caiwushouru caiwushouru){
        caiwushouru=caiwushouruService.getById(id);
        map.put("caiwushouru", caiwushouru);
        return "caiwushouru/caiwushourudetail";
    }
    //
    @RequestMapping("updateCaiwushouru.do")
    public String updateCaiwushouru(int id,ModelMap map,Caiwushouru caiwushouru,HttpServletRequest request,HttpSession session){
        caiwushouruService.update(caiwushouru);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:caiwushouruList.do";
    }

    //	分页查询
    @RequestMapping("caiwushouruList.do")
    public String caiwushouruList(@RequestParam(value="page",required=false)String page,
                                  ModelMap map,HttpSession session,Caiwushouru caiwushouru, String bianhao, String mingcheng, String xiaoshoushouru1,String xiaoshoushouru2, String zhengfubutie1,String zhengfubutie2, String qitashouru1,String qitashouru2, String zongshouru, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(xiaoshoushouru1==null||xiaoshoushouru1.equals("")){pmap.put("xiaoshoushouru1", null);}else{pmap.put("xiaoshoushouru1", xiaoshoushouru1);}
        if(xiaoshoushouru2==null||xiaoshoushouru2.equals("")){pmap.put("xiaoshoushouru2", null);}else{pmap.put("xiaoshoushouru2", xiaoshoushouru2);}
        if(zhengfubutie1==null||zhengfubutie1.equals("")){pmap.put("zhengfubutie1", null);}else{pmap.put("zhengfubutie1", zhengfubutie1);}
        if(zhengfubutie2==null||zhengfubutie2.equals("")){pmap.put("zhengfubutie2", null);}else{pmap.put("zhengfubutie2", zhengfubutie2);}
        if(qitashouru1==null||qitashouru1.equals("")){pmap.put("qitashouru1", null);}else{pmap.put("qitashouru1", qitashouru1);}
        if(qitashouru2==null||qitashouru2.equals("")){pmap.put("qitashouru2", null);}else{pmap.put("qitashouru2", qitashouru2);}
        if(zongshouru==null||zongshouru.equals("")){pmap.put("zongshouru", null);}else{pmap.put("zongshouru", zongshouru);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwushouruService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwushouru> list=caiwushouruService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwushouru/caiwushouru_list";
    }

    @RequestMapping("caiwushouru_yanben1.do")
    public String caiwushouru_yanben1(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwushouru caiwushouru, String bianhao, String mingcheng, String xiaoshoushouru1,String xiaoshoushouru2, String zhengfubutie1,String zhengfubutie2, String qitashouru1,String qitashouru2, String zongshouru, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(xiaoshoushouru1==null||xiaoshoushouru1.equals("")){pmap.put("xiaoshoushouru1", null);}else{pmap.put("xiaoshoushouru1", xiaoshoushouru1);}
        if(xiaoshoushouru2==null||xiaoshoushouru2.equals("")){pmap.put("xiaoshoushouru2", null);}else{pmap.put("xiaoshoushouru2", xiaoshoushouru2);}
        if(zhengfubutie1==null||zhengfubutie1.equals("")){pmap.put("zhengfubutie1", null);}else{pmap.put("zhengfubutie1", zhengfubutie1);}
        if(zhengfubutie2==null||zhengfubutie2.equals("")){pmap.put("zhengfubutie2", null);}else{pmap.put("zhengfubutie2", zhengfubutie2);}
        if(qitashouru1==null||qitashouru1.equals("")){pmap.put("qitashouru1", null);}else{pmap.put("qitashouru1", qitashouru1);}
        if(qitashouru2==null||qitashouru2.equals("")){pmap.put("qitashouru2", null);}else{pmap.put("qitashouru2", qitashouru2);}
        if(zongshouru==null||zongshouru.equals("")){pmap.put("zongshouru", null);}else{pmap.put("zongshouru", zongshouru);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwushouruService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwushouru> list=caiwushouruService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwushouru/caiwushouru_yanben1";
    }
    @RequestMapping("caiwushouru_yanben2.do")
    public String caiwushouru_yanben2(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwushouru caiwushouru, String bianhao, String mingcheng, String xiaoshoushouru1,String xiaoshoushouru2, String zhengfubutie1,String zhengfubutie2, String qitashouru1,String qitashouru2, String zongshouru, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(xiaoshoushouru1==null||xiaoshoushouru1.equals("")){pmap.put("xiaoshoushouru1", null);}else{pmap.put("xiaoshoushouru1", xiaoshoushouru1);}
        if(xiaoshoushouru2==null||xiaoshoushouru2.equals("")){pmap.put("xiaoshoushouru2", null);}else{pmap.put("xiaoshoushouru2", xiaoshoushouru2);}
        if(zhengfubutie1==null||zhengfubutie1.equals("")){pmap.put("zhengfubutie1", null);}else{pmap.put("zhengfubutie1", zhengfubutie1);}
        if(zhengfubutie2==null||zhengfubutie2.equals("")){pmap.put("zhengfubutie2", null);}else{pmap.put("zhengfubutie2", zhengfubutie2);}
        if(qitashouru1==null||qitashouru1.equals("")){pmap.put("qitashouru1", null);}else{pmap.put("qitashouru1", qitashouru1);}
        if(qitashouru2==null||qitashouru2.equals("")){pmap.put("qitashouru2", null);}else{pmap.put("qitashouru2", qitashouru2);}
        if(zongshouru==null||zongshouru.equals("")){pmap.put("zongshouru", null);}else{pmap.put("zongshouru", zongshouru);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwushouruService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwushouru> list=caiwushouruService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwushouru/caiwushouru_yanben2";
    }
    @RequestMapping("caiwushouru_yanben3.do")
    public String caiwushouru_yanben3(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwushouru caiwushouru, String bianhao, String mingcheng, String xiaoshoushouru1,String xiaoshoushouru2, String zhengfubutie1,String zhengfubutie2, String qitashouru1,String qitashouru2, String zongshouru, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(xiaoshoushouru1==null||xiaoshoushouru1.equals("")){pmap.put("xiaoshoushouru1", null);}else{pmap.put("xiaoshoushouru1", xiaoshoushouru1);}
        if(xiaoshoushouru2==null||xiaoshoushouru2.equals("")){pmap.put("xiaoshoushouru2", null);}else{pmap.put("xiaoshoushouru2", xiaoshoushouru2);}
        if(zhengfubutie1==null||zhengfubutie1.equals("")){pmap.put("zhengfubutie1", null);}else{pmap.put("zhengfubutie1", zhengfubutie1);}
        if(zhengfubutie2==null||zhengfubutie2.equals("")){pmap.put("zhengfubutie2", null);}else{pmap.put("zhengfubutie2", zhengfubutie2);}
        if(qitashouru1==null||qitashouru1.equals("")){pmap.put("qitashouru1", null);}else{pmap.put("qitashouru1", qitashouru1);}
        if(qitashouru2==null||qitashouru2.equals("")){pmap.put("qitashouru2", null);}else{pmap.put("qitashouru2", qitashouru2);}
        if(zongshouru==null||zongshouru.equals("")){pmap.put("zongshouru", null);}else{pmap.put("zongshouru", zongshouru);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwushouruService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwushouru> list=caiwushouruService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwushouru/caiwushouru_yanben3";
    }
    @RequestMapping("caiwushouru_yanben4.do")
    public String caiwushouru_yanben4(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwushouru caiwushouru, String bianhao, String mingcheng, String xiaoshoushouru1,String xiaoshoushouru2, String zhengfubutie1,String zhengfubutie2, String qitashouru1,String qitashouru2, String zongshouru, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(xiaoshoushouru1==null||xiaoshoushouru1.equals("")){pmap.put("xiaoshoushouru1", null);}else{pmap.put("xiaoshoushouru1", xiaoshoushouru1);}
        if(xiaoshoushouru2==null||xiaoshoushouru2.equals("")){pmap.put("xiaoshoushouru2", null);}else{pmap.put("xiaoshoushouru2", xiaoshoushouru2);}
        if(zhengfubutie1==null||zhengfubutie1.equals("")){pmap.put("zhengfubutie1", null);}else{pmap.put("zhengfubutie1", zhengfubutie1);}
        if(zhengfubutie2==null||zhengfubutie2.equals("")){pmap.put("zhengfubutie2", null);}else{pmap.put("zhengfubutie2", zhengfubutie2);}
        if(qitashouru1==null||qitashouru1.equals("")){pmap.put("qitashouru1", null);}else{pmap.put("qitashouru1", qitashouru1);}
        if(qitashouru2==null||qitashouru2.equals("")){pmap.put("qitashouru2", null);}else{pmap.put("qitashouru2", qitashouru2);}
        if(zongshouru==null||zongshouru.equals("")){pmap.put("zongshouru", null);}else{pmap.put("zongshouru", zongshouru);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwushouruService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwushouru> list=caiwushouruService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwushouru_yanben4";
    }
    @RequestMapping("caiwushouru_yanben5.do")
    public String caiwushouru_yanben5(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwushouru caiwushouru, String bianhao, String mingcheng, String xiaoshoushouru1,String xiaoshoushouru2, String zhengfubutie1,String zhengfubutie2, String qitashouru1,String qitashouru2, String zongshouru, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(xiaoshoushouru1==null||xiaoshoushouru1.equals("")){pmap.put("xiaoshoushouru1", null);}else{pmap.put("xiaoshoushouru1", xiaoshoushouru1);}
        if(xiaoshoushouru2==null||xiaoshoushouru2.equals("")){pmap.put("xiaoshoushouru2", null);}else{pmap.put("xiaoshoushouru2", xiaoshoushouru2);}
        if(zhengfubutie1==null||zhengfubutie1.equals("")){pmap.put("zhengfubutie1", null);}else{pmap.put("zhengfubutie1", zhengfubutie1);}
        if(zhengfubutie2==null||zhengfubutie2.equals("")){pmap.put("zhengfubutie2", null);}else{pmap.put("zhengfubutie2", zhengfubutie2);}
        if(qitashouru1==null||qitashouru1.equals("")){pmap.put("qitashouru1", null);}else{pmap.put("qitashouru1", qitashouru1);}
        if(qitashouru2==null||qitashouru2.equals("")){pmap.put("qitashouru2", null);}else{pmap.put("qitashouru2", qitashouru2);}
        if(zongshouru==null||zongshouru.equals("")){pmap.put("zongshouru", null);}else{pmap.put("zongshouru", zongshouru);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwushouruService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwushouru> list=caiwushouruService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwushouru/caiwushouru_yanben5";
    }



    @RequestMapping("cwsrList.do")
    public String cwsrList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Caiwushouru caiwushouru, String bianhao, String mingcheng, String xiaoshoushouru1,String xiaoshoushouru2, String zhengfubutie1,String zhengfubutie2, String qitashouru1,String qitashouru2, String zongshouru, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(xiaoshoushouru1==null||xiaoshoushouru1.equals("")){pmap.put("xiaoshoushouru1", null);}else{pmap.put("xiaoshoushouru1", xiaoshoushouru1);}
        if(xiaoshoushouru2==null||xiaoshoushouru2.equals("")){pmap.put("xiaoshoushouru2", null);}else{pmap.put("xiaoshoushouru2", xiaoshoushouru2);}
        if(zhengfubutie1==null||zhengfubutie1.equals("")){pmap.put("zhengfubutie1", null);}else{pmap.put("zhengfubutie1", zhengfubutie1);}
        if(zhengfubutie2==null||zhengfubutie2.equals("")){pmap.put("zhengfubutie2", null);}else{pmap.put("zhengfubutie2", zhengfubutie2);}
        if(qitashouru1==null||qitashouru1.equals("")){pmap.put("qitashouru1", null);}else{pmap.put("qitashouru1", qitashouru1);}
        if(qitashouru2==null||qitashouru2.equals("")){pmap.put("qitashouru2", null);}else{pmap.put("qitashouru2", qitashouru2);}
        if(zongshouru==null||zongshouru.equals("")){pmap.put("zongshouru", null);}else{pmap.put("zongshouru", zongshouru);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwushouruService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwushouru> list=caiwushouruService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwushouru/caiwushourulist";
    }
    @RequestMapping("cwsrListtp.do")
    public String cwsrListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,HttpSession session,Caiwushouru caiwushouru, String bianhao, String mingcheng, String xiaoshoushouru1,String xiaoshoushouru2, String zhengfubutie1,String zhengfubutie2, String qitashouru1,String qitashouru2, String zongshouru, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(xiaoshoushouru1==null||xiaoshoushouru1.equals("")){pmap.put("xiaoshoushouru1", null);}else{pmap.put("xiaoshoushouru1", xiaoshoushouru1);}
        if(xiaoshoushouru2==null||xiaoshoushouru2.equals("")){pmap.put("xiaoshoushouru2", null);}else{pmap.put("xiaoshoushouru2", xiaoshoushouru2);}
        if(zhengfubutie1==null||zhengfubutie1.equals("")){pmap.put("zhengfubutie1", null);}else{pmap.put("zhengfubutie1", zhengfubutie1);}
        if(zhengfubutie2==null||zhengfubutie2.equals("")){pmap.put("zhengfubutie2", null);}else{pmap.put("zhengfubutie2", zhengfubutie2);}
        if(qitashouru1==null||qitashouru1.equals("")){pmap.put("qitashouru1", null);}else{pmap.put("qitashouru1", qitashouru1);}
        if(qitashouru2==null||qitashouru2.equals("")){pmap.put("qitashouru2", null);}else{pmap.put("qitashouru2", qitashouru2);}
        if(zongshouru==null||zongshouru.equals("")){pmap.put("zongshouru", null);}else{pmap.put("zongshouru", zongshouru);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwushouruService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwushouru> list=caiwushouruService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwushouru/caiwushourulisttp";
    }

    @RequestMapping("deleteCaiwushouru.do")
    public String deleteCaiwushouru(int id,HttpServletRequest request){
        caiwushouruService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:caiwushouruList.do";
    }


}

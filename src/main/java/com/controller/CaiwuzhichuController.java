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

import com.entity.Caiwuzhichu;
import com.server.CaiwuzhichuServer;
import com.util.PageBean;

import java.sql.SQLException;

@Controller
public class CaiwuzhichuController {
    @Resource
    private CaiwuzhichuServer caiwuzhichuService;



    @RequestMapping("addCaiwuzhichu.do")
    public String addCaiwuzhichu(HttpServletRequest request,Caiwuzhichu caiwuzhichu,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());

        caiwuzhichu.setAddtime(time.toString().substring(0, 19));
        caiwuzhichuService.add(caiwuzhichu);

        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "caiwuzhichuList.do");

        return "redirect:postback.jsp";
        //return "redirect:caiwuzhichuList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateCaiwuzhichu.do")
    public String doUpdateCaiwuzhichu(int id,ModelMap map,Caiwuzhichu caiwuzhichu){
        caiwuzhichu=caiwuzhichuService.getById(id);
        map.put("caiwuzhichu", caiwuzhichu);
        return "caiwuzhichu/caiwuzhichu_updt";
    }





    //	后台详细
    @RequestMapping("caiwuzhichuDetail.do")
    public String caiwuzhichuDetail(int id,ModelMap map,Caiwuzhichu caiwuzhichu){
        caiwuzhichu=caiwuzhichuService.getById(id);
        map.put("caiwuzhichu", caiwuzhichu);
        return "caiwuzhichu/caiwuzhichu_detail";
    }
    //	前台详细
    @RequestMapping("cwzcDetail.do")
    public String cwzcDetail(int id,ModelMap map,Caiwuzhichu caiwuzhichu){
        caiwuzhichu=caiwuzhichuService.getById(id);
        map.put("caiwuzhichu", caiwuzhichu);
        return "caiwuzhichu/caiwuzhichudetail";
    }
    //
    @RequestMapping("updateCaiwuzhichu.do")
    public String updateCaiwuzhichu(int id,ModelMap map,Caiwuzhichu caiwuzhichu,HttpServletRequest request,HttpSession session){
        caiwuzhichuService.update(caiwuzhichu);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:caiwuzhichuList.do";
    }

    //	分页查询
    @RequestMapping("caiwuzhichuList.do")
    public String caiwuzhichuList(@RequestParam(value="page",required=false)String page,
                                  ModelMap map,HttpSession session,Caiwuzhichu caiwuzhichu, String bianhao, String mingcheng, String caigouzhichu1,String caigouzhichu2, String gongzizhichu1,String gongzizhichu2, String huishouchengben1,String huishouchengben2, String qitazhichu1,String qitazhichu2, String zongzhichu, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(caigouzhichu1==null||caigouzhichu1.equals("")){pmap.put("caigouzhichu1", null);}else{pmap.put("caigouzhichu1", caigouzhichu1);}
        if(caigouzhichu2==null||caigouzhichu2.equals("")){pmap.put("caigouzhichu2", null);}else{pmap.put("caigouzhichu2", caigouzhichu2);}
        if(gongzizhichu1==null||gongzizhichu1.equals("")){pmap.put("gongzizhichu1", null);}else{pmap.put("gongzizhichu1", gongzizhichu1);}
        if(gongzizhichu2==null||gongzizhichu2.equals("")){pmap.put("gongzizhichu2", null);}else{pmap.put("gongzizhichu2", gongzizhichu2);}
        if(huishouchengben1==null||huishouchengben1.equals("")){pmap.put("huishouchengben1", null);}else{pmap.put("huishouchengben1", huishouchengben1);}
        if(huishouchengben2==null||huishouchengben2.equals("")){pmap.put("huishouchengben2", null);}else{pmap.put("huishouchengben2", huishouchengben2);}
        if(qitazhichu1==null||qitazhichu1.equals("")){pmap.put("qitazhichu1", null);}else{pmap.put("qitazhichu1", qitazhichu1);}
        if(qitazhichu2==null||qitazhichu2.equals("")){pmap.put("qitazhichu2", null);}else{pmap.put("qitazhichu2", qitazhichu2);}
        if(zongzhichu==null||zongzhichu.equals("")){pmap.put("zongzhichu", null);}else{pmap.put("zongzhichu", zongzhichu);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwuzhichuService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuzhichu> list=caiwuzhichuService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuzhichu/caiwuzhichu_list";
    }

    @RequestMapping("caiwuzhichu_yanben1.do")
    public String caiwuzhichu_yanben1(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwuzhichu caiwuzhichu, String bianhao, String mingcheng, String caigouzhichu1,String caigouzhichu2, String gongzizhichu1,String gongzizhichu2, String huishouchengben1,String huishouchengben2, String qitazhichu1,String qitazhichu2, String zongzhichu, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(caigouzhichu1==null||caigouzhichu1.equals("")){pmap.put("caigouzhichu1", null);}else{pmap.put("caigouzhichu1", caigouzhichu1);}
        if(caigouzhichu2==null||caigouzhichu2.equals("")){pmap.put("caigouzhichu2", null);}else{pmap.put("caigouzhichu2", caigouzhichu2);}
        if(gongzizhichu1==null||gongzizhichu1.equals("")){pmap.put("gongzizhichu1", null);}else{pmap.put("gongzizhichu1", gongzizhichu1);}
        if(gongzizhichu2==null||gongzizhichu2.equals("")){pmap.put("gongzizhichu2", null);}else{pmap.put("gongzizhichu2", gongzizhichu2);}
        if(huishouchengben1==null||huishouchengben1.equals("")){pmap.put("huishouchengben1", null);}else{pmap.put("huishouchengben1", huishouchengben1);}
        if(huishouchengben2==null||huishouchengben2.equals("")){pmap.put("huishouchengben2", null);}else{pmap.put("huishouchengben2", huishouchengben2);}
        if(qitazhichu1==null||qitazhichu1.equals("")){pmap.put("qitazhichu1", null);}else{pmap.put("qitazhichu1", qitazhichu1);}
        if(qitazhichu2==null||qitazhichu2.equals("")){pmap.put("qitazhichu2", null);}else{pmap.put("qitazhichu2", qitazhichu2);}
        if(zongzhichu==null||zongzhichu.equals("")){pmap.put("zongzhichu", null);}else{pmap.put("zongzhichu", zongzhichu);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwuzhichuService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuzhichu> list=caiwuzhichuService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuzhichu/caiwuzhichu_yanben1";
    }
    @RequestMapping("caiwuzhichu_yanben2.do")
    public String caiwuzhichu_yanben2(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwuzhichu caiwuzhichu, String bianhao, String mingcheng, String caigouzhichu1,String caigouzhichu2, String gongzizhichu1,String gongzizhichu2, String huishouchengben1,String huishouchengben2, String qitazhichu1,String qitazhichu2, String zongzhichu, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(caigouzhichu1==null||caigouzhichu1.equals("")){pmap.put("caigouzhichu1", null);}else{pmap.put("caigouzhichu1", caigouzhichu1);}
        if(caigouzhichu2==null||caigouzhichu2.equals("")){pmap.put("caigouzhichu2", null);}else{pmap.put("caigouzhichu2", caigouzhichu2);}
        if(gongzizhichu1==null||gongzizhichu1.equals("")){pmap.put("gongzizhichu1", null);}else{pmap.put("gongzizhichu1", gongzizhichu1);}
        if(gongzizhichu2==null||gongzizhichu2.equals("")){pmap.put("gongzizhichu2", null);}else{pmap.put("gongzizhichu2", gongzizhichu2);}
        if(huishouchengben1==null||huishouchengben1.equals("")){pmap.put("huishouchengben1", null);}else{pmap.put("huishouchengben1", huishouchengben1);}
        if(huishouchengben2==null||huishouchengben2.equals("")){pmap.put("huishouchengben2", null);}else{pmap.put("huishouchengben2", huishouchengben2);}
        if(qitazhichu1==null||qitazhichu1.equals("")){pmap.put("qitazhichu1", null);}else{pmap.put("qitazhichu1", qitazhichu1);}
        if(qitazhichu2==null||qitazhichu2.equals("")){pmap.put("qitazhichu2", null);}else{pmap.put("qitazhichu2", qitazhichu2);}
        if(zongzhichu==null||zongzhichu.equals("")){pmap.put("zongzhichu", null);}else{pmap.put("zongzhichu", zongzhichu);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwuzhichuService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuzhichu> list=caiwuzhichuService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuzhichu/caiwuzhichu_yanben2";
    }
    @RequestMapping("caiwuzhichu_yanben3.do")
    public String caiwuzhichu_yanben3(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwuzhichu caiwuzhichu, String bianhao, String mingcheng, String caigouzhichu1,String caigouzhichu2, String gongzizhichu1,String gongzizhichu2, String huishouchengben1,String huishouchengben2, String qitazhichu1,String qitazhichu2, String zongzhichu, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(caigouzhichu1==null||caigouzhichu1.equals("")){pmap.put("caigouzhichu1", null);}else{pmap.put("caigouzhichu1", caigouzhichu1);}
        if(caigouzhichu2==null||caigouzhichu2.equals("")){pmap.put("caigouzhichu2", null);}else{pmap.put("caigouzhichu2", caigouzhichu2);}
        if(gongzizhichu1==null||gongzizhichu1.equals("")){pmap.put("gongzizhichu1", null);}else{pmap.put("gongzizhichu1", gongzizhichu1);}
        if(gongzizhichu2==null||gongzizhichu2.equals("")){pmap.put("gongzizhichu2", null);}else{pmap.put("gongzizhichu2", gongzizhichu2);}
        if(huishouchengben1==null||huishouchengben1.equals("")){pmap.put("huishouchengben1", null);}else{pmap.put("huishouchengben1", huishouchengben1);}
        if(huishouchengben2==null||huishouchengben2.equals("")){pmap.put("huishouchengben2", null);}else{pmap.put("huishouchengben2", huishouchengben2);}
        if(qitazhichu1==null||qitazhichu1.equals("")){pmap.put("qitazhichu1", null);}else{pmap.put("qitazhichu1", qitazhichu1);}
        if(qitazhichu2==null||qitazhichu2.equals("")){pmap.put("qitazhichu2", null);}else{pmap.put("qitazhichu2", qitazhichu2);}
        if(zongzhichu==null||zongzhichu.equals("")){pmap.put("zongzhichu", null);}else{pmap.put("zongzhichu", zongzhichu);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwuzhichuService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuzhichu> list=caiwuzhichuService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuzhichu/caiwuzhichu_yanben3";
    }
    @RequestMapping("caiwuzhichu_yanben4.do")
    public String caiwuzhichu_yanben4(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwuzhichu caiwuzhichu, String bianhao, String mingcheng, String caigouzhichu1,String caigouzhichu2, String gongzizhichu1,String gongzizhichu2, String huishouchengben1,String huishouchengben2, String qitazhichu1,String qitazhichu2, String zongzhichu, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(caigouzhichu1==null||caigouzhichu1.equals("")){pmap.put("caigouzhichu1", null);}else{pmap.put("caigouzhichu1", caigouzhichu1);}
        if(caigouzhichu2==null||caigouzhichu2.equals("")){pmap.put("caigouzhichu2", null);}else{pmap.put("caigouzhichu2", caigouzhichu2);}
        if(gongzizhichu1==null||gongzizhichu1.equals("")){pmap.put("gongzizhichu1", null);}else{pmap.put("gongzizhichu1", gongzizhichu1);}
        if(gongzizhichu2==null||gongzizhichu2.equals("")){pmap.put("gongzizhichu2", null);}else{pmap.put("gongzizhichu2", gongzizhichu2);}
        if(huishouchengben1==null||huishouchengben1.equals("")){pmap.put("huishouchengben1", null);}else{pmap.put("huishouchengben1", huishouchengben1);}
        if(huishouchengben2==null||huishouchengben2.equals("")){pmap.put("huishouchengben2", null);}else{pmap.put("huishouchengben2", huishouchengben2);}
        if(qitazhichu1==null||qitazhichu1.equals("")){pmap.put("qitazhichu1", null);}else{pmap.put("qitazhichu1", qitazhichu1);}
        if(qitazhichu2==null||qitazhichu2.equals("")){pmap.put("qitazhichu2", null);}else{pmap.put("qitazhichu2", qitazhichu2);}
        if(zongzhichu==null||zongzhichu.equals("")){pmap.put("zongzhichu", null);}else{pmap.put("zongzhichu", zongzhichu);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwuzhichuService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuzhichu> list=caiwuzhichuService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuzhichu/caiwuzhichu_yanben4";
    }
    @RequestMapping("caiwuzhichu_yanben5.do")
    public String caiwuzhichu_yanben5(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwuzhichu caiwuzhichu, String bianhao, String mingcheng, String caigouzhichu1,String caigouzhichu2, String gongzizhichu1,String gongzizhichu2, String huishouchengben1,String huishouchengben2, String qitazhichu1,String qitazhichu2, String zongzhichu, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(caigouzhichu1==null||caigouzhichu1.equals("")){pmap.put("caigouzhichu1", null);}else{pmap.put("caigouzhichu1", caigouzhichu1);}
        if(caigouzhichu2==null||caigouzhichu2.equals("")){pmap.put("caigouzhichu2", null);}else{pmap.put("caigouzhichu2", caigouzhichu2);}
        if(gongzizhichu1==null||gongzizhichu1.equals("")){pmap.put("gongzizhichu1", null);}else{pmap.put("gongzizhichu1", gongzizhichu1);}
        if(gongzizhichu2==null||gongzizhichu2.equals("")){pmap.put("gongzizhichu2", null);}else{pmap.put("gongzizhichu2", gongzizhichu2);}
        if(huishouchengben1==null||huishouchengben1.equals("")){pmap.put("huishouchengben1", null);}else{pmap.put("huishouchengben1", huishouchengben1);}
        if(huishouchengben2==null||huishouchengben2.equals("")){pmap.put("huishouchengben2", null);}else{pmap.put("huishouchengben2", huishouchengben2);}
        if(qitazhichu1==null||qitazhichu1.equals("")){pmap.put("qitazhichu1", null);}else{pmap.put("qitazhichu1", qitazhichu1);}
        if(qitazhichu2==null||qitazhichu2.equals("")){pmap.put("qitazhichu2", null);}else{pmap.put("qitazhichu2", qitazhichu2);}
        if(zongzhichu==null||zongzhichu.equals("")){pmap.put("zongzhichu", null);}else{pmap.put("zongzhichu", zongzhichu);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwuzhichuService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuzhichu> list=caiwuzhichuService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuzhichu/caiwuzhichu_yanben5";
    }



    @RequestMapping("cwzcList.do")
    public String cwzcList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Caiwuzhichu caiwuzhichu, String bianhao, String mingcheng, String caigouzhichu1,String caigouzhichu2, String gongzizhichu1,String gongzizhichu2, String huishouchengben1,String huishouchengben2, String qitazhichu1,String qitazhichu2, String zongzhichu, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(caigouzhichu1==null||caigouzhichu1.equals("")){pmap.put("caigouzhichu1", null);}else{pmap.put("caigouzhichu1", caigouzhichu1);}
        if(caigouzhichu2==null||caigouzhichu2.equals("")){pmap.put("caigouzhichu2", null);}else{pmap.put("caigouzhichu2", caigouzhichu2);}
        if(gongzizhichu1==null||gongzizhichu1.equals("")){pmap.put("gongzizhichu1", null);}else{pmap.put("gongzizhichu1", gongzizhichu1);}
        if(gongzizhichu2==null||gongzizhichu2.equals("")){pmap.put("gongzizhichu2", null);}else{pmap.put("gongzizhichu2", gongzizhichu2);}
        if(huishouchengben1==null||huishouchengben1.equals("")){pmap.put("huishouchengben1", null);}else{pmap.put("huishouchengben1", huishouchengben1);}
        if(huishouchengben2==null||huishouchengben2.equals("")){pmap.put("huishouchengben2", null);}else{pmap.put("huishouchengben2", huishouchengben2);}
        if(qitazhichu1==null||qitazhichu1.equals("")){pmap.put("qitazhichu1", null);}else{pmap.put("qitazhichu1", qitazhichu1);}
        if(qitazhichu2==null||qitazhichu2.equals("")){pmap.put("qitazhichu2", null);}else{pmap.put("qitazhichu2", qitazhichu2);}
        if(zongzhichu==null||zongzhichu.equals("")){pmap.put("zongzhichu", null);}else{pmap.put("zongzhichu", zongzhichu);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwuzhichuService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuzhichu> list=caiwuzhichuService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuzhichu/caiwuzhichulist";
    }
    @RequestMapping("cwzcListtp.do")
    public String cwzcListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,HttpSession session,Caiwuzhichu caiwuzhichu, String bianhao, String mingcheng, String caigouzhichu1,String caigouzhichu2, String gongzizhichu1,String gongzizhichu2, String huishouchengben1,String huishouchengben2, String qitazhichu1,String qitazhichu2, String zongzhichu, String riqi1,String riqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(caigouzhichu1==null||caigouzhichu1.equals("")){pmap.put("caigouzhichu1", null);}else{pmap.put("caigouzhichu1", caigouzhichu1);}
        if(caigouzhichu2==null||caigouzhichu2.equals("")){pmap.put("caigouzhichu2", null);}else{pmap.put("caigouzhichu2", caigouzhichu2);}
        if(gongzizhichu1==null||gongzizhichu1.equals("")){pmap.put("gongzizhichu1", null);}else{pmap.put("gongzizhichu1", gongzizhichu1);}
        if(gongzizhichu2==null||gongzizhichu2.equals("")){pmap.put("gongzizhichu2", null);}else{pmap.put("gongzizhichu2", gongzizhichu2);}
        if(huishouchengben1==null||huishouchengben1.equals("")){pmap.put("huishouchengben1", null);}else{pmap.put("huishouchengben1", huishouchengben1);}
        if(huishouchengben2==null||huishouchengben2.equals("")){pmap.put("huishouchengben2", null);}else{pmap.put("huishouchengben2", huishouchengben2);}
        if(qitazhichu1==null||qitazhichu1.equals("")){pmap.put("qitazhichu1", null);}else{pmap.put("qitazhichu1", qitazhichu1);}
        if(qitazhichu2==null||qitazhichu2.equals("")){pmap.put("qitazhichu2", null);}else{pmap.put("qitazhichu2", qitazhichu2);}
        if(zongzhichu==null||zongzhichu.equals("")){pmap.put("zongzhichu", null);}else{pmap.put("zongzhichu", zongzhichu);}
        if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
        if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}

        int total=caiwuzhichuService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuzhichu> list=caiwuzhichuService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuzhichu/caiwuzhichulisttp";
    }

    @RequestMapping("deleteCaiwuzhichu.do")
    public String deleteCaiwuzhichu(int id,HttpServletRequest request){
        caiwuzhichuService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:caiwuzhichuList.do";
    }


}

package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Caiwuguanli;
import com.server.CaiwuguanliServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class CaiwuguanliController {
    @Resource
    private CaiwuguanliServer caiwuguanliService;



    @RequestMapping("addCaiwuguanli.do")
    public String addCaiwuguanli(HttpServletRequest request,Caiwuguanli caiwuguanli,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());

        caiwuguanli.setAddtime(time.toString().substring(0, 19));
        caiwuguanliService.add(caiwuguanli);

        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "caiwuguanliList.do");

        return "redirect:postback.jsp";
        //return "redirect:caiwuguanliList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateCaiwuguanli.do")
    public String doUpdateCaiwuguanli(int id,ModelMap map,Caiwuguanli caiwuguanli){
        caiwuguanli=caiwuguanliService.getById(id);
        map.put("caiwuguanli", caiwuguanli);
        return "caiwuguanli/caiwuguanli_updt";
    }





    //	后台详细
    @RequestMapping("caiwuguanliDetail.do")
    public String caiwuguanliDetail(int id,ModelMap map,Caiwuguanli caiwuguanli){
        caiwuguanli=caiwuguanliService.getById(id);
        map.put("caiwuguanli", caiwuguanli);
        return "caiwuguanli/caiwuguanli_detail";
    }
    //	前台详细
    @RequestMapping("cwglDetail.do")
    public String cwglDetail(int id,ModelMap map,Caiwuguanli caiwuguanli){
        caiwuguanli=caiwuguanliService.getById(id);
        map.put("caiwuguanli", caiwuguanli);
        return "caiwuguanli/caiwuguanlidetail";
    }
    //
    @RequestMapping("updateCaiwuguanli.do")
    public String updateCaiwuguanli(int id,ModelMap map,Caiwuguanli caiwuguanli,HttpServletRequest request,HttpSession session){
        caiwuguanliService.update(caiwuguanli);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:caiwuguanliList.do";
    }

    //	分页查询
    @RequestMapping("caiwuguanliList.do")
    public String caiwuguanliList(@RequestParam(value="page",required=false)String page,
                                  ModelMap map,HttpSession session,Caiwuguanli caiwuguanli, String bianhao, String mingcheng, String zongshouru1,String zongshouru2, String zongzhichu1,String zongzhichu2, String zonglirun, String faburiqi1,String faburiqi2, String faburen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(zongshouru1==null||zongshouru1.equals("")){pmap.put("zongshouru1", null);}else{pmap.put("zongshouru1", zongshouru1);}
        if(zongshouru2==null||zongshouru2.equals("")){pmap.put("zongshouru2", null);}else{pmap.put("zongshouru2", zongshouru2);}
        if(zongzhichu1==null||zongzhichu1.equals("")){pmap.put("zongzhichu1", null);}else{pmap.put("zongzhichu1", zongzhichu1);}
        if(zongzhichu2==null||zongzhichu2.equals("")){pmap.put("zongzhichu2", null);}else{pmap.put("zongzhichu2", zongzhichu2);}
        if(zonglirun==null||zonglirun.equals("")){pmap.put("zonglirun", null);}else{pmap.put("zonglirun", zonglirun);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}

        int total=caiwuguanliService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuguanli> list=caiwuguanliService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuguanli/caiwuguanli_list";
    }

    @RequestMapping("caiwuguanli_yanben1.do")
    public String caiwuguanli_yanben1(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwuguanli caiwuguanli, String bianhao, String mingcheng, String zongshouru1,String zongshouru2, String zongzhichu1,String zongzhichu2, String zonglirun, String faburiqi1,String faburiqi2, String faburen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(zongshouru1==null||zongshouru1.equals("")){pmap.put("zongshouru1", null);}else{pmap.put("zongshouru1", zongshouru1);}
        if(zongshouru2==null||zongshouru2.equals("")){pmap.put("zongshouru2", null);}else{pmap.put("zongshouru2", zongshouru2);}
        if(zongzhichu1==null||zongzhichu1.equals("")){pmap.put("zongzhichu1", null);}else{pmap.put("zongzhichu1", zongzhichu1);}
        if(zongzhichu2==null||zongzhichu2.equals("")){pmap.put("zongzhichu2", null);}else{pmap.put("zongzhichu2", zongzhichu2);}
        if(zonglirun==null||zonglirun.equals("")){pmap.put("zonglirun", null);}else{pmap.put("zonglirun", zonglirun);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}

        int total=caiwuguanliService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuguanli> list=caiwuguanliService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuguanli/caiwuguanli_yanben1";
    }
    @RequestMapping("caiwuguanli_yanben2.do")
    public String caiwuguanli_yanben2(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwuguanli caiwuguanli, String bianhao, String mingcheng, String zongshouru1,String zongshouru2, String zongzhichu1,String zongzhichu2, String zonglirun, String faburiqi1,String faburiqi2, String faburen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(zongshouru1==null||zongshouru1.equals("")){pmap.put("zongshouru1", null);}else{pmap.put("zongshouru1", zongshouru1);}
        if(zongshouru2==null||zongshouru2.equals("")){pmap.put("zongshouru2", null);}else{pmap.put("zongshouru2", zongshouru2);}
        if(zongzhichu1==null||zongzhichu1.equals("")){pmap.put("zongzhichu1", null);}else{pmap.put("zongzhichu1", zongzhichu1);}
        if(zongzhichu2==null||zongzhichu2.equals("")){pmap.put("zongzhichu2", null);}else{pmap.put("zongzhichu2", zongzhichu2);}
        if(zonglirun==null||zonglirun.equals("")){pmap.put("zonglirun", null);}else{pmap.put("zonglirun", zonglirun);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}

        int total=caiwuguanliService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuguanli> list=caiwuguanliService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuguanli/caiwuguanli_yanben2";
    }
    @RequestMapping("caiwuguanli_yanben3.do")
    public String caiwuguanli_yanben3(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwuguanli caiwuguanli, String bianhao, String mingcheng, String zongshouru1,String zongshouru2, String zongzhichu1,String zongzhichu2, String zonglirun, String faburiqi1,String faburiqi2, String faburen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(zongshouru1==null||zongshouru1.equals("")){pmap.put("zongshouru1", null);}else{pmap.put("zongshouru1", zongshouru1);}
        if(zongshouru2==null||zongshouru2.equals("")){pmap.put("zongshouru2", null);}else{pmap.put("zongshouru2", zongshouru2);}
        if(zongzhichu1==null||zongzhichu1.equals("")){pmap.put("zongzhichu1", null);}else{pmap.put("zongzhichu1", zongzhichu1);}
        if(zongzhichu2==null||zongzhichu2.equals("")){pmap.put("zongzhichu2", null);}else{pmap.put("zongzhichu2", zongzhichu2);}
        if(zonglirun==null||zonglirun.equals("")){pmap.put("zonglirun", null);}else{pmap.put("zonglirun", zonglirun);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}

        int total=caiwuguanliService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuguanli> list=caiwuguanliService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuguanli/caiwuguanli_yanben3";
    }
    @RequestMapping("caiwuguanli_yanben4.do")
    public String caiwuguanli_yanben4(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwuguanli caiwuguanli, String bianhao, String mingcheng, String zongshouru1,String zongshouru2, String zongzhichu1,String zongzhichu2, String zonglirun, String faburiqi1,String faburiqi2, String faburen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(zongshouru1==null||zongshouru1.equals("")){pmap.put("zongshouru1", null);}else{pmap.put("zongshouru1", zongshouru1);}
        if(zongshouru2==null||zongshouru2.equals("")){pmap.put("zongshouru2", null);}else{pmap.put("zongshouru2", zongshouru2);}
        if(zongzhichu1==null||zongzhichu1.equals("")){pmap.put("zongzhichu1", null);}else{pmap.put("zongzhichu1", zongzhichu1);}
        if(zongzhichu2==null||zongzhichu2.equals("")){pmap.put("zongzhichu2", null);}else{pmap.put("zongzhichu2", zongzhichu2);}
        if(zonglirun==null||zonglirun.equals("")){pmap.put("zonglirun", null);}else{pmap.put("zonglirun", zonglirun);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}

        int total=caiwuguanliService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuguanli> list=caiwuguanliService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuguanli/caiwuguanli_yanben4";
    }
    @RequestMapping("caiwuguanli_yanben5.do")
    public String caiwuguanli_yanben5(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caiwuguanli caiwuguanli, String bianhao, String mingcheng, String zongshouru1,String zongshouru2, String zongzhichu1,String zongzhichu2, String zonglirun, String faburiqi1,String faburiqi2, String faburen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(zongshouru1==null||zongshouru1.equals("")){pmap.put("zongshouru1", null);}else{pmap.put("zongshouru1", zongshouru1);}
        if(zongshouru2==null||zongshouru2.equals("")){pmap.put("zongshouru2", null);}else{pmap.put("zongshouru2", zongshouru2);}
        if(zongzhichu1==null||zongzhichu1.equals("")){pmap.put("zongzhichu1", null);}else{pmap.put("zongzhichu1", zongzhichu1);}
        if(zongzhichu2==null||zongzhichu2.equals("")){pmap.put("zongzhichu2", null);}else{pmap.put("zongzhichu2", zongzhichu2);}
        if(zonglirun==null||zonglirun.equals("")){pmap.put("zonglirun", null);}else{pmap.put("zonglirun", zonglirun);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}

        int total=caiwuguanliService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuguanli> list=caiwuguanliService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuguanli/caiwuguanli_yanben5";
    }

    @RequestMapping("caiwuguanliList2.do")
    public String caiwuguanliList2(@RequestParam(value="page",required=false)String page,
                                   ModelMap map,HttpSession session,Caiwuguanli caiwuguanli, String bianhao, String mingcheng, String zongshouru1,String zongshouru2, String zongzhichu1,String zongzhichu2, String zonglirun, String faburiqi1,String faburiqi2, String faburen,HttpServletRequest request){
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

        pmap.put("faburen", (String)request.getSession().getAttribute("username"));
        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(zongshouru1==null||zongshouru1.equals("")){pmap.put("zongshouru1", null);}else{pmap.put("zongshouru1", zongshouru1);}
        if(zongshouru2==null||zongshouru2.equals("")){pmap.put("zongshouru2", null);}else{pmap.put("zongshouru2", zongshouru2);}
        if(zongzhichu1==null||zongzhichu1.equals("")){pmap.put("zongzhichu1", null);}else{pmap.put("zongzhichu1", zongzhichu1);}
        if(zongzhichu2==null||zongzhichu2.equals("")){pmap.put("zongzhichu2", null);}else{pmap.put("zongzhichu2", zongzhichu2);}
        if(zonglirun==null||zonglirun.equals("")){pmap.put("zonglirun", null);}else{pmap.put("zonglirun", zonglirun);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}


        int total=caiwuguanliService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuguanli> list=caiwuguanliService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuguanli/caiwuguanli_list2";
    }


    @RequestMapping("cwglList.do")
    public String cwglList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Caiwuguanli caiwuguanli, String bianhao, String mingcheng, String zongshouru1,String zongshouru2, String zongzhichu1,String zongzhichu2, String zonglirun, String faburiqi1,String faburiqi2, String faburen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(zongshouru1==null||zongshouru1.equals("")){pmap.put("zongshouru1", null);}else{pmap.put("zongshouru1", zongshouru1);}
        if(zongshouru2==null||zongshouru2.equals("")){pmap.put("zongshouru2", null);}else{pmap.put("zongshouru2", zongshouru2);}
        if(zongzhichu1==null||zongzhichu1.equals("")){pmap.put("zongzhichu1", null);}else{pmap.put("zongzhichu1", zongzhichu1);}
        if(zongzhichu2==null||zongzhichu2.equals("")){pmap.put("zongzhichu2", null);}else{pmap.put("zongzhichu2", zongzhichu2);}
        if(zonglirun==null||zonglirun.equals("")){pmap.put("zonglirun", null);}else{pmap.put("zonglirun", zonglirun);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}

        int total=caiwuguanliService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuguanli> list=caiwuguanliService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuguanli/caiwuguanlilist";
    }
    @RequestMapping("cwglListtp.do")
    public String cwglListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,HttpSession session,Caiwuguanli caiwuguanli, String bianhao, String mingcheng, String zongshouru1,String zongshouru2, String zongzhichu1,String zongzhichu2, String zonglirun, String faburiqi1,String faburiqi2, String faburen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(zongshouru1==null||zongshouru1.equals("")){pmap.put("zongshouru1", null);}else{pmap.put("zongshouru1", zongshouru1);}
        if(zongshouru2==null||zongshouru2.equals("")){pmap.put("zongshouru2", null);}else{pmap.put("zongshouru2", zongshouru2);}
        if(zongzhichu1==null||zongzhichu1.equals("")){pmap.put("zongzhichu1", null);}else{pmap.put("zongzhichu1", zongzhichu1);}
        if(zongzhichu2==null||zongzhichu2.equals("")){pmap.put("zongzhichu2", null);}else{pmap.put("zongzhichu2", zongzhichu2);}
        if(zonglirun==null||zonglirun.equals("")){pmap.put("zonglirun", null);}else{pmap.put("zonglirun", zonglirun);}
        if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}
        if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}
        if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}

        int total=caiwuguanliService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caiwuguanli> list=caiwuguanliService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caiwuguanli/caiwuguanlilisttp";
    }

    @RequestMapping("deleteCaiwuguanli.do")
    public String deleteCaiwuguanli(int id,HttpServletRequest request){
        caiwuguanliService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:caiwuguanliList.do";
    }


}

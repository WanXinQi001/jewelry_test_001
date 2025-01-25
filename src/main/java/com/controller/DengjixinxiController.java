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

import com.entity.Dengjixinxi;
import com.server.DengjixinxiServer;
import com.util.PageBean;

import java.sql.SQLException;

@Controller
public class DengjixinxiController {
    @Resource
    private DengjixinxiServer dengjixinxiService;



    @RequestMapping("addDengjixinxi.do")
    public String addDengjixinxi(HttpServletRequest request,Dengjixinxi dengjixinxi,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());

        dengjixinxi.setAddtime(time.toString().substring(0, 19));
        dengjixinxiService.add(dengjixinxi);

        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "dengjixinxiList.do");

        return "redirect:postback.jsp";
        //return "redirect:dengjixinxiList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateDengjixinxi.do")
    public String doUpdateDengjixinxi(int id,ModelMap map,Dengjixinxi dengjixinxi){
        dengjixinxi=dengjixinxiService.getById(id);
        map.put("dengjixinxi", dengjixinxi);
        return "dengjixinxi/dengjixinxi_updt";
    }





    //	后台详细
    @RequestMapping("dengjixinxiDetail.do")
    public String dengjixinxiDetail(int id,ModelMap map,Dengjixinxi dengjixinxi){
        dengjixinxi=dengjixinxiService.getById(id);
        map.put("dengjixinxi", dengjixinxi);
        return "dengjixinxi_detail";
    }
    //	前台详细
    @RequestMapping("djxxDetail.do")
    public String djxxDetail(int id,ModelMap map,Dengjixinxi dengjixinxi){
        dengjixinxi=dengjixinxiService.getById(id);
        map.put("dengjixinxi", dengjixinxi);
        return "dengjixinxidetail";
    }
    //
    @RequestMapping("updateDengjixinxi.do")
    public String updateDengjixinxi(int id,ModelMap map,Dengjixinxi dengjixinxi,HttpServletRequest request,HttpSession session){
        dengjixinxiService.update(dengjixinxi);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:dengjixinxiList.do";
    }

    //	分页查询
    @RequestMapping("dengjixinxiList.do")
    public String dengjixinxiList(@RequestParam(value="page",required=false)String page,
                                  ModelMap map,HttpSession session,Dengjixinxi dengjixinxi, String huiyuandengji, String zhekou, String zhekoujiage1,String zhekoujiage2, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(zhekoujiage1==null||zhekoujiage1.equals("")){pmap.put("zhekoujiage1", null);}else{pmap.put("zhekoujiage1", zhekoujiage1);}
        if(zhekoujiage2==null||zhekoujiage2.equals("")){pmap.put("zhekoujiage2", null);}else{pmap.put("zhekoujiage2", zhekoujiage2);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=dengjixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Dengjixinxi> list=dengjixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "dengjixinxi/dengjixinxi_list";
    }

    @RequestMapping("dengjixinxi_yanben1.do")
    public String dengjixinxi_yanben1(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Dengjixinxi dengjixinxi, String huiyuandengji, String zhekou, String zhekoujiage1,String zhekoujiage2, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(zhekoujiage1==null||zhekoujiage1.equals("")){pmap.put("zhekoujiage1", null);}else{pmap.put("zhekoujiage1", zhekoujiage1);}
        if(zhekoujiage2==null||zhekoujiage2.equals("")){pmap.put("zhekoujiage2", null);}else{pmap.put("zhekoujiage2", zhekoujiage2);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=dengjixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Dengjixinxi> list=dengjixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "dengjixinxi_yanben1";
    }
    @RequestMapping("dengjixinxi_yanben2.do")
    public String dengjixinxi_yanben2(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Dengjixinxi dengjixinxi, String huiyuandengji, String zhekou, String zhekoujiage1,String zhekoujiage2, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(zhekoujiage1==null||zhekoujiage1.equals("")){pmap.put("zhekoujiage1", null);}else{pmap.put("zhekoujiage1", zhekoujiage1);}
        if(zhekoujiage2==null||zhekoujiage2.equals("")){pmap.put("zhekoujiage2", null);}else{pmap.put("zhekoujiage2", zhekoujiage2);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=dengjixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Dengjixinxi> list=dengjixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "dengjixinxi_yanben2";
    }
    @RequestMapping("dengjixinxi_yanben3.do")
    public String dengjixinxi_yanben3(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Dengjixinxi dengjixinxi, String huiyuandengji, String zhekou, String zhekoujiage1,String zhekoujiage2, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(zhekoujiage1==null||zhekoujiage1.equals("")){pmap.put("zhekoujiage1", null);}else{pmap.put("zhekoujiage1", zhekoujiage1);}
        if(zhekoujiage2==null||zhekoujiage2.equals("")){pmap.put("zhekoujiage2", null);}else{pmap.put("zhekoujiage2", zhekoujiage2);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=dengjixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Dengjixinxi> list=dengjixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "dengjixinxi_yanben3";
    }
    @RequestMapping("dengjixinxi_yanben4.do")
    public String dengjixinxi_yanben4(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Dengjixinxi dengjixinxi, String huiyuandengji, String zhekou, String zhekoujiage1,String zhekoujiage2, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(zhekoujiage1==null||zhekoujiage1.equals("")){pmap.put("zhekoujiage1", null);}else{pmap.put("zhekoujiage1", zhekoujiage1);}
        if(zhekoujiage2==null||zhekoujiage2.equals("")){pmap.put("zhekoujiage2", null);}else{pmap.put("zhekoujiage2", zhekoujiage2);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=dengjixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Dengjixinxi> list=dengjixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "dengjixinxi_yanben4";
    }
    @RequestMapping("dengjixinxi_yanben5.do")
    public String dengjixinxi_yanben5(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Dengjixinxi dengjixinxi, String huiyuandengji, String zhekou, String zhekoujiage1,String zhekoujiage2, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(zhekoujiage1==null||zhekoujiage1.equals("")){pmap.put("zhekoujiage1", null);}else{pmap.put("zhekoujiage1", zhekoujiage1);}
        if(zhekoujiage2==null||zhekoujiage2.equals("")){pmap.put("zhekoujiage2", null);}else{pmap.put("zhekoujiage2", zhekoujiage2);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=dengjixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Dengjixinxi> list=dengjixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "dengjixinxi_yanben5";
    }



    @RequestMapping("djxxList.do")
    public String djxxList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Dengjixinxi dengjixinxi, String huiyuandengji, String zhekou, String zhekoujiage1,String zhekoujiage2, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(zhekoujiage1==null||zhekoujiage1.equals("")){pmap.put("zhekoujiage1", null);}else{pmap.put("zhekoujiage1", zhekoujiage1);}
        if(zhekoujiage2==null||zhekoujiage2.equals("")){pmap.put("zhekoujiage2", null);}else{pmap.put("zhekoujiage2", zhekoujiage2);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=dengjixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Dengjixinxi> list=dengjixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "dengjixinxilist";
    }
    @RequestMapping("djxxListtp.do")
    public String djxxListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,HttpSession session,Dengjixinxi dengjixinxi, String huiyuandengji, String zhekou, String zhekoujiage1,String zhekoujiage2, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(zhekoujiage1==null||zhekoujiage1.equals("")){pmap.put("zhekoujiage1", null);}else{pmap.put("zhekoujiage1", zhekoujiage1);}
        if(zhekoujiage2==null||zhekoujiage2.equals("")){pmap.put("zhekoujiage2", null);}else{pmap.put("zhekoujiage2", zhekoujiage2);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=dengjixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Dengjixinxi> list=dengjixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "dengjixinxilisttp";
    }

    @RequestMapping("deleteDengjixinxi.do")
    public String deleteDengjixinxi(int id,HttpServletRequest request){
        dengjixinxiService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:dengjixinxiList.do";
    }


}

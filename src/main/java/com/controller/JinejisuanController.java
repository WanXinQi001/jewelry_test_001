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

import com.entity.Jinejisuan;
import com.server.JinejisuanServer;
import com.util.PageBean;
import com.util.db;
import java.sql.SQLException;

@Controller
public class JinejisuanController {
    @Resource
    private JinejisuanServer jinejisuanService;



    @RequestMapping("addJinejisuan.do")
    public String addJinejisuan(HttpServletRequest request,Jinejisuan jinejisuan,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());

        jinejisuan.setAddtime(time.toString().substring(0, 19));
        jinejisuanService.add(jinejisuan);
        db dbo = new db();dbo.hsgexecute("update shangpingoumai set xiaofeijine=xiaofeijine+"+jinejisuan.getZongjiage()+" where kahao='"+jinejisuan.getKahao()+"'");
        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "jinejisuanList.do");

        return "redirect:postback.jsp";
        //return "redirect:jinejisuanList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateJinejisuan.do")
    public String doUpdateJinejisuan(int id,ModelMap map,Jinejisuan jinejisuan){
        jinejisuan=jinejisuanService.getById(id);
        map.put("jinejisuan", jinejisuan);
        return "jinejisuan/jinejisuan_updt";
    }





    //	后台详细
    @RequestMapping("jinejisuanDetail.do")
    public String jinejisuanDetail(int id,ModelMap map,Jinejisuan jinejisuan){
        jinejisuan=jinejisuanService.getById(id);
        map.put("jinejisuan", jinejisuan);
        return "jinejisuan_detail";
    }
    //	前台详细
    @RequestMapping("jejsDetail.do")
    public String jejsDetail(int id,ModelMap map,Jinejisuan jinejisuan){
        jinejisuan=jinejisuanService.getById(id);
        map.put("jinejisuan", jinejisuan);
        return "jinejisuandetail";
    }
    //
    @RequestMapping("updateJinejisuan.do")
    public String updateJinejisuan(int id,ModelMap map,Jinejisuan jinejisuan,HttpServletRequest request,HttpSession session){
        jinejisuanService.update(jinejisuan);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:jinejisuanList.do";
    }

    //	分页查询
    @RequestMapping("jinejisuanList.do")
    public String jinejisuanList(@RequestParam(value="page",required=false)String page,
                                 ModelMap map,HttpSession session,Jinejisuan jinejisuan, String xiaoshoudanhao, String zongjiage, String kahao, String xingming, String xiaofeijine){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xiaofeijine==null||xiaofeijine.equals("")){pmap.put("xiaofeijine", null);}else{pmap.put("xiaofeijine", xiaofeijine);}

        int total=jinejisuanService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jinejisuan> list=jinejisuanService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jinejisuan/jinejisuan_list";
    }

    @RequestMapping("jinejisuan_yanben1.do")
    public String jinejisuan_yanben1(@RequestParam(value="page",required=false)String page,
                                     ModelMap map,HttpSession session,Jinejisuan jinejisuan, String xiaoshoudanhao, String zongjiage, String kahao, String xingming, String xiaofeijine){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xiaofeijine==null||xiaofeijine.equals("")){pmap.put("xiaofeijine", null);}else{pmap.put("xiaofeijine", xiaofeijine);}

        int total=jinejisuanService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jinejisuan> list=jinejisuanService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jinejisuan_yanben1";
    }
    @RequestMapping("jinejisuan_yanben2.do")
    public String jinejisuan_yanben2(@RequestParam(value="page",required=false)String page,
                                     ModelMap map,HttpSession session,Jinejisuan jinejisuan, String xiaoshoudanhao, String zongjiage, String kahao, String xingming, String xiaofeijine){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xiaofeijine==null||xiaofeijine.equals("")){pmap.put("xiaofeijine", null);}else{pmap.put("xiaofeijine", xiaofeijine);}

        int total=jinejisuanService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jinejisuan> list=jinejisuanService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jinejisuan_yanben2";
    }
    @RequestMapping("jinejisuan_yanben3.do")
    public String jinejisuan_yanben3(@RequestParam(value="page",required=false)String page,
                                     ModelMap map,HttpSession session,Jinejisuan jinejisuan, String xiaoshoudanhao, String zongjiage, String kahao, String xingming, String xiaofeijine){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xiaofeijine==null||xiaofeijine.equals("")){pmap.put("xiaofeijine", null);}else{pmap.put("xiaofeijine", xiaofeijine);}

        int total=jinejisuanService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jinejisuan> list=jinejisuanService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jinejisuan_yanben3";
    }
    @RequestMapping("jinejisuan_yanben4.do")
    public String jinejisuan_yanben4(@RequestParam(value="page",required=false)String page,
                                     ModelMap map,HttpSession session,Jinejisuan jinejisuan, String xiaoshoudanhao, String zongjiage, String kahao, String xingming, String xiaofeijine){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xiaofeijine==null||xiaofeijine.equals("")){pmap.put("xiaofeijine", null);}else{pmap.put("xiaofeijine", xiaofeijine);}

        int total=jinejisuanService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jinejisuan> list=jinejisuanService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jinejisuan_yanben4";
    }
    @RequestMapping("jinejisuan_yanben5.do")
    public String jinejisuan_yanben5(@RequestParam(value="page",required=false)String page,
                                     ModelMap map,HttpSession session,Jinejisuan jinejisuan, String xiaoshoudanhao, String zongjiage, String kahao, String xingming, String xiaofeijine){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xiaofeijine==null||xiaofeijine.equals("")){pmap.put("xiaofeijine", null);}else{pmap.put("xiaofeijine", xiaofeijine);}

        int total=jinejisuanService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jinejisuan> list=jinejisuanService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jinejisuan_yanben5";
    }



    @RequestMapping("jejsList.do")
    public String jejsList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Jinejisuan jinejisuan, String xiaoshoudanhao, String zongjiage, String kahao, String xingming, String xiaofeijine){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xiaofeijine==null||xiaofeijine.equals("")){pmap.put("xiaofeijine", null);}else{pmap.put("xiaofeijine", xiaofeijine);}

        int total=jinejisuanService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jinejisuan> list=jinejisuanService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jinejisuanlist";
    }
    @RequestMapping("jejsListtp.do")
    public String jejsListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,HttpSession session,Jinejisuan jinejisuan, String xiaoshoudanhao, String zongjiage, String kahao, String xingming, String xiaofeijine){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xiaofeijine==null||xiaofeijine.equals("")){pmap.put("xiaofeijine", null);}else{pmap.put("xiaofeijine", xiaofeijine);}

        int total=jinejisuanService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jinejisuan> list=jinejisuanService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jinejisuanlisttp";
    }

    @RequestMapping("deleteJinejisuan.do")
    public String deleteJinejisuan(int id,HttpServletRequest request){
        jinejisuanService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:jinejisuanList.do";
    }


}

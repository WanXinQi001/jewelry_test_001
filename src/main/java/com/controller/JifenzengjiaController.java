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

import com.entity.Jifenzengjia;
import com.server.JifenzengjiaServer;
import com.util.PageBean;
import com.util.db;
import java.sql.SQLException;

@Controller
public class JifenzengjiaController {
    @Resource
    private JifenzengjiaServer jifenzengjiaService;



    @RequestMapping("addJifenzengjia.do")
    public String addJifenzengjia(HttpServletRequest request,Jifenzengjia jifenzengjia,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());

        jifenzengjia.setAddtime(time.toString().substring(0, 19));
        jifenzengjiaService.add(jifenzengjia);
        db dbo = new db();dbo.hsgexecute("update shangpingoumai set jifen=jifen+"+jifenzengjia.getHuodejifen()+" where kahao='"+jifenzengjia.getKahao()+"'");
        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "jifenzengjiaList.do");

        return "redirect:postback.jsp";
        //return "redirect:jifenzengjiaList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateJifenzengjia.do")
    public String doUpdateJifenzengjia(int id,ModelMap map,Jifenzengjia jifenzengjia){
        jifenzengjia=jifenzengjiaService.getById(id);
        map.put("jifenzengjia", jifenzengjia);
        return "jifenzengjia/jifenzengjia_updt";
    }





    //	后台详细
    @RequestMapping("jifenzengjiaDetail.do")
    public String jifenzengjiaDetail(int id,ModelMap map,Jifenzengjia jifenzengjia){
        jifenzengjia=jifenzengjiaService.getById(id);
        map.put("jifenzengjia", jifenzengjia);
        return "jifenzengjia/jifenzengjia_detail";
    }
    //	前台详细
    @RequestMapping("jfzjDetail.do")
    public String jfzjDetail(int id,ModelMap map,Jifenzengjia jifenzengjia){
        jifenzengjia=jifenzengjiaService.getById(id);
        map.put("jifenzengjia", jifenzengjia);
        return "jifenzengjiadetail";
    }
    //
    @RequestMapping("updateJifenzengjia.do")
    public String updateJifenzengjia(int id,ModelMap map,Jifenzengjia jifenzengjia,HttpServletRequest request,HttpSession session){
        jifenzengjiaService.update(jifenzengjia);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:jifenzengjiaList.do";
    }

    //	分页查询
    @RequestMapping("jifenzengjiaList.do")
    public String jifenzengjiaList(@RequestParam(value="page",required=false)String page,
                                   ModelMap map,HttpSession session,Jifenzengjia jifenzengjia, String xiaoshoudanhao, String huodejifen, String kahao, String xingming, String jifen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}

        int total=jifenzengjiaService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jifenzengjia> list=jifenzengjiaService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jifenzengjia/jifenzengjia_list";
    }

    @RequestMapping("jifenzengjia_yanben1.do")
    public String jifenzengjia_yanben1(@RequestParam(value="page",required=false)String page,
                                       ModelMap map,HttpSession session,Jifenzengjia jifenzengjia, String xiaoshoudanhao, String huodejifen, String kahao, String xingming, String jifen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}

        int total=jifenzengjiaService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jifenzengjia> list=jifenzengjiaService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jifenzengjia_yanben1";
    }
    @RequestMapping("jifenzengjia_yanben2.do")
    public String jifenzengjia_yanben2(@RequestParam(value="page",required=false)String page,
                                       ModelMap map,HttpSession session,Jifenzengjia jifenzengjia, String xiaoshoudanhao, String huodejifen, String kahao, String xingming, String jifen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}

        int total=jifenzengjiaService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jifenzengjia> list=jifenzengjiaService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jifenzengjia_yanben2";
    }
    @RequestMapping("jifenzengjia_yanben3.do")
    public String jifenzengjia_yanben3(@RequestParam(value="page",required=false)String page,
                                       ModelMap map,HttpSession session,Jifenzengjia jifenzengjia, String xiaoshoudanhao, String huodejifen, String kahao, String xingming, String jifen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}

        int total=jifenzengjiaService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jifenzengjia> list=jifenzengjiaService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jifenzengjia_yanben3";
    }
    @RequestMapping("jifenzengjia_yanben4.do")
    public String jifenzengjia_yanben4(@RequestParam(value="page",required=false)String page,
                                       ModelMap map,HttpSession session,Jifenzengjia jifenzengjia, String xiaoshoudanhao, String huodejifen, String kahao, String xingming, String jifen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}

        int total=jifenzengjiaService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jifenzengjia> list=jifenzengjiaService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jifenzengjia_yanben4";
    }
    @RequestMapping("jifenzengjia_yanben5.do")
    public String jifenzengjia_yanben5(@RequestParam(value="page",required=false)String page,
                                       ModelMap map,HttpSession session,Jifenzengjia jifenzengjia, String xiaoshoudanhao, String huodejifen, String kahao, String xingming, String jifen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}

        int total=jifenzengjiaService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jifenzengjia> list=jifenzengjiaService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jifenzengjia_yanben5";
    }

    @RequestMapping("jifenzengjiaList2.do")
    public String jifenzengjiaList2(@RequestParam(value="page",required=false)String page,
                                    ModelMap map,HttpSession session,Jifenzengjia jifenzengjia, String xiaoshoudanhao, String huodejifen, String kahao, String xingming, String jifen,HttpServletRequest request){
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
        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}


        int total=jifenzengjiaService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jifenzengjia> list=jifenzengjiaService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jifenzengjia/jifenzengjia_list2";
    }


    @RequestMapping("jfzjList.do")
    public String jfzjList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Jifenzengjia jifenzengjia, String xiaoshoudanhao, String huodejifen, String kahao, String xingming, String jifen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}

        int total=jifenzengjiaService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jifenzengjia> list=jifenzengjiaService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jifenzengjialist";
    }
    @RequestMapping("jfzjListtp.do")
    public String jfzjListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,HttpSession session,Jifenzengjia jifenzengjia, String xiaoshoudanhao, String huodejifen, String kahao, String xingming, String jifen){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}

        int total=jifenzengjiaService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jifenzengjia> list=jifenzengjiaService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jifenzengjialisttp";
    }

    @RequestMapping("deleteJifenzengjia.do")
    public String deleteJifenzengjia(int id,HttpServletRequest request){
        jifenzengjiaService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:jifenzengjiaList.do";
    }


}

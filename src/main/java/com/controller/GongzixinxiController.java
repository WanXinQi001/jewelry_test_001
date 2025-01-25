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

import com.entity.Gongzixinxi;
import com.server.GongzixinxiServer;
import com.util.PageBean;

import java.sql.SQLException;

@Controller
public class GongzixinxiController {
    @Resource
    private GongzixinxiServer gongzixinxiService;



    @RequestMapping("addGongzixinxi.do")
    public String addGongzixinxi(HttpServletRequest request,Gongzixinxi gongzixinxi,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());

        gongzixinxi.setAddtime(time.toString().substring(0, 19));
        gongzixinxiService.add(gongzixinxi);

        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "gongzixinxiList.do");

        return "redirect:postback.jsp";
        //return "redirect:gongzixinxiList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateGongzixinxi.do")
    public String doUpdateGongzixinxi(int id,ModelMap map,Gongzixinxi gongzixinxi){
        gongzixinxi=gongzixinxiService.getById(id);
        map.put("gongzixinxi", gongzixinxi);
        return "gongzixinxi/gongzixinxi_updt";
    }





    //	后台详细
    @RequestMapping("gongzixinxiDetail.do")
    public String gongzixinxiDetail(int id,ModelMap map,Gongzixinxi gongzixinxi){
        gongzixinxi=gongzixinxiService.getById(id);
        map.put("gongzixinxi", gongzixinxi);
        return "gongzixinxi/gongzixinxi_detail";
    }
    //	前台详细
    @RequestMapping("gzxxDetail.do")
    public String gzxxDetail(int id,ModelMap map,Gongzixinxi gongzixinxi){
        gongzixinxi=gongzixinxiService.getById(id);
        map.put("gongzixinxi", gongzixinxi);
        return "gongzixinxidetail";
    }
    //
    @RequestMapping("updateGongzixinxi.do")
    public String updateGongzixinxi(int id,ModelMap map,Gongzixinxi gongzixinxi,HttpServletRequest request,HttpSession session){
        gongzixinxiService.update(gongzixinxi);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:gongzixinxiList.do";
    }

    //	分页查询
    @RequestMapping("gongzixinxiList.do")
    public String gongzixinxiList(@RequestParam(value="page",required=false)String page,
                                  ModelMap map,HttpSession session,Gongzixinxi gongzixinxi, String bianhao, String mingcheng, String gonghao, String xingming, String xingbie, String bumen, String jibengongzi1,String jibengongzi2, String ticheng1,String ticheng2, String butie1,String butie2, String shifagongzi, String gongziriqi1,String gongziriqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jibengongzi1==null||jibengongzi1.equals("")){pmap.put("jibengongzi1", null);}else{pmap.put("jibengongzi1", jibengongzi1);}
        if(jibengongzi2==null||jibengongzi2.equals("")){pmap.put("jibengongzi2", null);}else{pmap.put("jibengongzi2", jibengongzi2);}
        if(ticheng1==null||ticheng1.equals("")){pmap.put("ticheng1", null);}else{pmap.put("ticheng1", ticheng1);}
        if(ticheng2==null||ticheng2.equals("")){pmap.put("ticheng2", null);}else{pmap.put("ticheng2", ticheng2);}
        if(butie1==null||butie1.equals("")){pmap.put("butie1", null);}else{pmap.put("butie1", butie1);}
        if(butie2==null||butie2.equals("")){pmap.put("butie2", null);}else{pmap.put("butie2", butie2);}
        if(shifagongzi==null||shifagongzi.equals("")){pmap.put("shifagongzi", null);}else{pmap.put("shifagongzi", shifagongzi);}
        if(gongziriqi1==null||gongziriqi1.equals("")){pmap.put("gongziriqi1", null);}else{pmap.put("gongziriqi1", gongziriqi1);}
        if(gongziriqi2==null||gongziriqi2.equals("")){pmap.put("gongziriqi2", null);}else{pmap.put("gongziriqi2", gongziriqi2);}

        int total=gongzixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Gongzixinxi> list=gongzixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "gongzixinxi/gongzixinxi_list";
    }

    @RequestMapping("gongzixinxi_yanben1.do")
    public String gongzixinxi_yanben1(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Gongzixinxi gongzixinxi, String bianhao, String mingcheng, String gonghao, String xingming, String xingbie, String bumen, String jibengongzi1,String jibengongzi2, String ticheng1,String ticheng2, String butie1,String butie2, String shifagongzi, String gongziriqi1,String gongziriqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jibengongzi1==null||jibengongzi1.equals("")){pmap.put("jibengongzi1", null);}else{pmap.put("jibengongzi1", jibengongzi1);}
        if(jibengongzi2==null||jibengongzi2.equals("")){pmap.put("jibengongzi2", null);}else{pmap.put("jibengongzi2", jibengongzi2);}
        if(ticheng1==null||ticheng1.equals("")){pmap.put("ticheng1", null);}else{pmap.put("ticheng1", ticheng1);}
        if(ticheng2==null||ticheng2.equals("")){pmap.put("ticheng2", null);}else{pmap.put("ticheng2", ticheng2);}
        if(butie1==null||butie1.equals("")){pmap.put("butie1", null);}else{pmap.put("butie1", butie1);}
        if(butie2==null||butie2.equals("")){pmap.put("butie2", null);}else{pmap.put("butie2", butie2);}
        if(shifagongzi==null||shifagongzi.equals("")){pmap.put("shifagongzi", null);}else{pmap.put("shifagongzi", shifagongzi);}
        if(gongziriqi1==null||gongziriqi1.equals("")){pmap.put("gongziriqi1", null);}else{pmap.put("gongziriqi1", gongziriqi1);}
        if(gongziriqi2==null||gongziriqi2.equals("")){pmap.put("gongziriqi2", null);}else{pmap.put("gongziriqi2", gongziriqi2);}

        int total=gongzixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Gongzixinxi> list=gongzixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "gongzixinxi_yanben1";
    }
    @RequestMapping("gongzixinxi_yanben2.do")
    public String gongzixinxi_yanben2(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Gongzixinxi gongzixinxi, String bianhao, String mingcheng, String gonghao, String xingming, String xingbie, String bumen, String jibengongzi1,String jibengongzi2, String ticheng1,String ticheng2, String butie1,String butie2, String shifagongzi, String gongziriqi1,String gongziriqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jibengongzi1==null||jibengongzi1.equals("")){pmap.put("jibengongzi1", null);}else{pmap.put("jibengongzi1", jibengongzi1);}
        if(jibengongzi2==null||jibengongzi2.equals("")){pmap.put("jibengongzi2", null);}else{pmap.put("jibengongzi2", jibengongzi2);}
        if(ticheng1==null||ticheng1.equals("")){pmap.put("ticheng1", null);}else{pmap.put("ticheng1", ticheng1);}
        if(ticheng2==null||ticheng2.equals("")){pmap.put("ticheng2", null);}else{pmap.put("ticheng2", ticheng2);}
        if(butie1==null||butie1.equals("")){pmap.put("butie1", null);}else{pmap.put("butie1", butie1);}
        if(butie2==null||butie2.equals("")){pmap.put("butie2", null);}else{pmap.put("butie2", butie2);}
        if(shifagongzi==null||shifagongzi.equals("")){pmap.put("shifagongzi", null);}else{pmap.put("shifagongzi", shifagongzi);}
        if(gongziriqi1==null||gongziriqi1.equals("")){pmap.put("gongziriqi1", null);}else{pmap.put("gongziriqi1", gongziriqi1);}
        if(gongziriqi2==null||gongziriqi2.equals("")){pmap.put("gongziriqi2", null);}else{pmap.put("gongziriqi2", gongziriqi2);}

        int total=gongzixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Gongzixinxi> list=gongzixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "gongzixinxi_yanben2";
    }
    @RequestMapping("gongzixinxi_yanben3.do")
    public String gongzixinxi_yanben3(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Gongzixinxi gongzixinxi, String bianhao, String mingcheng, String gonghao, String xingming, String xingbie, String bumen, String jibengongzi1,String jibengongzi2, String ticheng1,String ticheng2, String butie1,String butie2, String shifagongzi, String gongziriqi1,String gongziriqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jibengongzi1==null||jibengongzi1.equals("")){pmap.put("jibengongzi1", null);}else{pmap.put("jibengongzi1", jibengongzi1);}
        if(jibengongzi2==null||jibengongzi2.equals("")){pmap.put("jibengongzi2", null);}else{pmap.put("jibengongzi2", jibengongzi2);}
        if(ticheng1==null||ticheng1.equals("")){pmap.put("ticheng1", null);}else{pmap.put("ticheng1", ticheng1);}
        if(ticheng2==null||ticheng2.equals("")){pmap.put("ticheng2", null);}else{pmap.put("ticheng2", ticheng2);}
        if(butie1==null||butie1.equals("")){pmap.put("butie1", null);}else{pmap.put("butie1", butie1);}
        if(butie2==null||butie2.equals("")){pmap.put("butie2", null);}else{pmap.put("butie2", butie2);}
        if(shifagongzi==null||shifagongzi.equals("")){pmap.put("shifagongzi", null);}else{pmap.put("shifagongzi", shifagongzi);}
        if(gongziriqi1==null||gongziriqi1.equals("")){pmap.put("gongziriqi1", null);}else{pmap.put("gongziriqi1", gongziriqi1);}
        if(gongziriqi2==null||gongziriqi2.equals("")){pmap.put("gongziriqi2", null);}else{pmap.put("gongziriqi2", gongziriqi2);}

        int total=gongzixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Gongzixinxi> list=gongzixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "gongzixinxi_yanben3";
    }
    @RequestMapping("gongzixinxi_yanben4.do")
    public String gongzixinxi_yanben4(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Gongzixinxi gongzixinxi, String bianhao, String mingcheng, String gonghao, String xingming, String xingbie, String bumen, String jibengongzi1,String jibengongzi2, String ticheng1,String ticheng2, String butie1,String butie2, String shifagongzi, String gongziriqi1,String gongziriqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jibengongzi1==null||jibengongzi1.equals("")){pmap.put("jibengongzi1", null);}else{pmap.put("jibengongzi1", jibengongzi1);}
        if(jibengongzi2==null||jibengongzi2.equals("")){pmap.put("jibengongzi2", null);}else{pmap.put("jibengongzi2", jibengongzi2);}
        if(ticheng1==null||ticheng1.equals("")){pmap.put("ticheng1", null);}else{pmap.put("ticheng1", ticheng1);}
        if(ticheng2==null||ticheng2.equals("")){pmap.put("ticheng2", null);}else{pmap.put("ticheng2", ticheng2);}
        if(butie1==null||butie1.equals("")){pmap.put("butie1", null);}else{pmap.put("butie1", butie1);}
        if(butie2==null||butie2.equals("")){pmap.put("butie2", null);}else{pmap.put("butie2", butie2);}
        if(shifagongzi==null||shifagongzi.equals("")){pmap.put("shifagongzi", null);}else{pmap.put("shifagongzi", shifagongzi);}
        if(gongziriqi1==null||gongziriqi1.equals("")){pmap.put("gongziriqi1", null);}else{pmap.put("gongziriqi1", gongziriqi1);}
        if(gongziriqi2==null||gongziriqi2.equals("")){pmap.put("gongziriqi2", null);}else{pmap.put("gongziriqi2", gongziriqi2);}

        int total=gongzixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Gongzixinxi> list=gongzixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "gongzixinxi_yanben4";
    }
    @RequestMapping("gongzixinxi_yanben5.do")
    public String gongzixinxi_yanben5(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Gongzixinxi gongzixinxi, String bianhao, String mingcheng, String gonghao, String xingming, String xingbie, String bumen, String jibengongzi1,String jibengongzi2, String ticheng1,String ticheng2, String butie1,String butie2, String shifagongzi, String gongziriqi1,String gongziriqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jibengongzi1==null||jibengongzi1.equals("")){pmap.put("jibengongzi1", null);}else{pmap.put("jibengongzi1", jibengongzi1);}
        if(jibengongzi2==null||jibengongzi2.equals("")){pmap.put("jibengongzi2", null);}else{pmap.put("jibengongzi2", jibengongzi2);}
        if(ticheng1==null||ticheng1.equals("")){pmap.put("ticheng1", null);}else{pmap.put("ticheng1", ticheng1);}
        if(ticheng2==null||ticheng2.equals("")){pmap.put("ticheng2", null);}else{pmap.put("ticheng2", ticheng2);}
        if(butie1==null||butie1.equals("")){pmap.put("butie1", null);}else{pmap.put("butie1", butie1);}
        if(butie2==null||butie2.equals("")){pmap.put("butie2", null);}else{pmap.put("butie2", butie2);}
        if(shifagongzi==null||shifagongzi.equals("")){pmap.put("shifagongzi", null);}else{pmap.put("shifagongzi", shifagongzi);}
        if(gongziriqi1==null||gongziriqi1.equals("")){pmap.put("gongziriqi1", null);}else{pmap.put("gongziriqi1", gongziriqi1);}
        if(gongziriqi2==null||gongziriqi2.equals("")){pmap.put("gongziriqi2", null);}else{pmap.put("gongziriqi2", gongziriqi2);}

        int total=gongzixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Gongzixinxi> list=gongzixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "gongzixinxi_yanben5";
    }

    @RequestMapping("gongzixinxiList2.do")
    public String gongzixinxiList2(@RequestParam(value="page",required=false)String page,
                                   ModelMap map,HttpSession session,Gongzixinxi gongzixinxi, String bianhao, String mingcheng, String gonghao, String xingming, String xingbie, String bumen, String jibengongzi1,String jibengongzi2, String ticheng1,String ticheng2, String butie1,String butie2, String shifagongzi, String gongziriqi1,String gongziriqi2,HttpServletRequest request){
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

        pmap.put("gonghao", (String)request.getSession().getAttribute("username"));
        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jibengongzi1==null||jibengongzi1.equals("")){pmap.put("jibengongzi1", null);}else{pmap.put("jibengongzi1", jibengongzi1);}
        if(jibengongzi2==null||jibengongzi2.equals("")){pmap.put("jibengongzi2", null);}else{pmap.put("jibengongzi2", jibengongzi2);}
        if(ticheng1==null||ticheng1.equals("")){pmap.put("ticheng1", null);}else{pmap.put("ticheng1", ticheng1);}
        if(ticheng2==null||ticheng2.equals("")){pmap.put("ticheng2", null);}else{pmap.put("ticheng2", ticheng2);}
        if(butie1==null||butie1.equals("")){pmap.put("butie1", null);}else{pmap.put("butie1", butie1);}
        if(butie2==null||butie2.equals("")){pmap.put("butie2", null);}else{pmap.put("butie2", butie2);}
        if(shifagongzi==null||shifagongzi.equals("")){pmap.put("shifagongzi", null);}else{pmap.put("shifagongzi", shifagongzi);}
        if(gongziriqi1==null||gongziriqi1.equals("")){pmap.put("gongziriqi1", null);}else{pmap.put("gongziriqi1", gongziriqi1);}
        if(gongziriqi2==null||gongziriqi2.equals("")){pmap.put("gongziriqi2", null);}else{pmap.put("gongziriqi2", gongziriqi2);}


        int total=gongzixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Gongzixinxi> list=gongzixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "gongzixinxi/gongzixinxi_list2";
    }


    @RequestMapping("gzxxList.do")
    public String gzxxList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Gongzixinxi gongzixinxi, String bianhao, String mingcheng, String gonghao, String xingming, String xingbie, String bumen, String jibengongzi1,String jibengongzi2, String ticheng1,String ticheng2, String butie1,String butie2, String shifagongzi, String gongziriqi1,String gongziriqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jibengongzi1==null||jibengongzi1.equals("")){pmap.put("jibengongzi1", null);}else{pmap.put("jibengongzi1", jibengongzi1);}
        if(jibengongzi2==null||jibengongzi2.equals("")){pmap.put("jibengongzi2", null);}else{pmap.put("jibengongzi2", jibengongzi2);}
        if(ticheng1==null||ticheng1.equals("")){pmap.put("ticheng1", null);}else{pmap.put("ticheng1", ticheng1);}
        if(ticheng2==null||ticheng2.equals("")){pmap.put("ticheng2", null);}else{pmap.put("ticheng2", ticheng2);}
        if(butie1==null||butie1.equals("")){pmap.put("butie1", null);}else{pmap.put("butie1", butie1);}
        if(butie2==null||butie2.equals("")){pmap.put("butie2", null);}else{pmap.put("butie2", butie2);}
        if(shifagongzi==null||shifagongzi.equals("")){pmap.put("shifagongzi", null);}else{pmap.put("shifagongzi", shifagongzi);}
        if(gongziriqi1==null||gongziriqi1.equals("")){pmap.put("gongziriqi1", null);}else{pmap.put("gongziriqi1", gongziriqi1);}
        if(gongziriqi2==null||gongziriqi2.equals("")){pmap.put("gongziriqi2", null);}else{pmap.put("gongziriqi2", gongziriqi2);}

        int total=gongzixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Gongzixinxi> list=gongzixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "gongzixinxilist";
    }
    @RequestMapping("gzxxListtp.do")
    public String gzxxListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,HttpSession session,Gongzixinxi gongzixinxi, String bianhao, String mingcheng, String gonghao, String xingming, String xingbie, String bumen, String jibengongzi1,String jibengongzi2, String ticheng1,String ticheng2, String butie1,String butie2, String shifagongzi, String gongziriqi1,String gongziriqi2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
        if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jibengongzi1==null||jibengongzi1.equals("")){pmap.put("jibengongzi1", null);}else{pmap.put("jibengongzi1", jibengongzi1);}
        if(jibengongzi2==null||jibengongzi2.equals("")){pmap.put("jibengongzi2", null);}else{pmap.put("jibengongzi2", jibengongzi2);}
        if(ticheng1==null||ticheng1.equals("")){pmap.put("ticheng1", null);}else{pmap.put("ticheng1", ticheng1);}
        if(ticheng2==null||ticheng2.equals("")){pmap.put("ticheng2", null);}else{pmap.put("ticheng2", ticheng2);}
        if(butie1==null||butie1.equals("")){pmap.put("butie1", null);}else{pmap.put("butie1", butie1);}
        if(butie2==null||butie2.equals("")){pmap.put("butie2", null);}else{pmap.put("butie2", butie2);}
        if(shifagongzi==null||shifagongzi.equals("")){pmap.put("shifagongzi", null);}else{pmap.put("shifagongzi", shifagongzi);}
        if(gongziriqi1==null||gongziriqi1.equals("")){pmap.put("gongziriqi1", null);}else{pmap.put("gongziriqi1", gongziriqi1);}
        if(gongziriqi2==null||gongziriqi2.equals("")){pmap.put("gongziriqi2", null);}else{pmap.put("gongziriqi2", gongziriqi2);}

        int total=gongzixinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Gongzixinxi> list=gongzixinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "gongzixinxilisttp";
    }

    @RequestMapping("deleteGongzixinxi.do")
    public String deleteGongzixinxi(int id,HttpServletRequest request){
        gongzixinxiService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:gongzixinxiList.do";
    }


}

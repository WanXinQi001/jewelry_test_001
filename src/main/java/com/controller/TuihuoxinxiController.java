package com.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.server.ShangpingoumaiServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Tuihuoxinxi;
import com.server.TuihuoxinxiServer;
import com.util.PageBean;

import java.sql.SQLException;

@Controller
@RequestMapping("/tuihuoxinxi")
public class TuihuoxinxiController {
    @Resource
    private TuihuoxinxiServer tuihuoxinxiService;
    @Resource
    private ShangpingoumaiServer shangpingoumaiServer;



    @RequestMapping("addTuihuoxinxi.do")
    public String addTuihuoxinxi(HttpServletRequest request,Tuihuoxinxi tuihuoxinxi,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());

        tuihuoxinxi.setAddtime(time.toString().substring(0, 19));
        tuihuoxinxiService.add(tuihuoxinxi);



        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "tuihuoxinxiList.do");

        return "redirect:../postback.jsp";
        //return "redirect:tuihuoxinxiList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateTuihuoxinxi.do")
    public String doUpdateTuihuoxinxi(int id,ModelMap map,Tuihuoxinxi tuihuoxinxi){
        tuihuoxinxi=tuihuoxinxiService.getById(id);
        map.put("tuihuoxinxi", tuihuoxinxi);
        return "tuihuoxinxi/tuihuoxinxi_updt";
    }



    @RequestMapping("doUpdateTuihuoxinxilb.do")
    public String doUpdateTuihuoxinxilb(int id,ModelMap map,Tuihuoxinxi tuihuoxinxi){
        tuihuoxinxi=tuihuoxinxiService.getById(id);
        map.put("tuihuoxinxi", tuihuoxinxi);
        return "tuihuoxinxi/tuihuoxinxi_updtlb";
    }

    @RequestMapping("updateTuihuoxinxilb.do")
    public String updateTuihuoxinxilb(int id,ModelMap map,Tuihuoxinxi tuihuoxinxi){
        tuihuoxinxiService.updatelb(tuihuoxinxi);
        return "redirect:tuihuoxinxiList.do";
    }

    //	后台详细
    @RequestMapping("tuihuoxinxiDetail.do")
    public String tuihuoxinxiDetail(int id,ModelMap map,Tuihuoxinxi tuihuoxinxi){
        tuihuoxinxi=tuihuoxinxiService.getById(id);
        map.put("tuihuoxinxi", tuihuoxinxi);
        return "tuihuoxinxi/tuihuoxinxi_detail";
    }
    //	前台详细
    @RequestMapping("thxxDetail.do")
    public String thxxDetail(int id,ModelMap map,Tuihuoxinxi tuihuoxinxi){
        tuihuoxinxi=tuihuoxinxiService.getById(id);
        map.put("tuihuoxinxi", tuihuoxinxi);
        return "tuihuoxinxi/tuihuoxinxidetail";
    }
    //
    @RequestMapping("updateTuihuoxinxi.do")
    public String updateTuihuoxinxi(int id,ModelMap map,Tuihuoxinxi tuihuoxinxi,HttpServletRequest request,HttpSession session){
        tuihuoxinxiService.update(tuihuoxinxi);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:../postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:tuihuoxinxiList.do";
    }

    //	分页查询
    @RequestMapping("tuihuoxinxiList.do")
    public String tuihuoxinxiList(@RequestParam(value="page",required=false)String page,
                                  ModelMap map,HttpSession session,Tuihuoxinxi tuihuoxinxi, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String tuihuoyuanyin, String huifu, String tuihuoriqi1,String tuihuoriqi2, String kahao, String xingming){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(tuihuoriqi1==null||tuihuoriqi1.equals("")){pmap.put("tuihuoriqi1", null);}else{pmap.put("tuihuoriqi1", tuihuoriqi1);}
        if(tuihuoriqi2==null||tuihuoriqi2.equals("")){pmap.put("tuihuoriqi2", null);}else{pmap.put("tuihuoriqi2", tuihuoriqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}

        int total=tuihuoxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Tuihuoxinxi> list=tuihuoxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "tuihuoxinxi/tuihuoxinxi_list";
    }

    @RequestMapping("tuihuoxinxi_yanben1.do")
    public String tuihuoxinxi_yanben1(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Tuihuoxinxi tuihuoxinxi, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String tuihuoyuanyin, String huifu, String tuihuoriqi1,String tuihuoriqi2, String kahao, String xingming){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(tuihuoriqi1==null||tuihuoriqi1.equals("")){pmap.put("tuihuoriqi1", null);}else{pmap.put("tuihuoriqi1", tuihuoriqi1);}
        if(tuihuoriqi2==null||tuihuoriqi2.equals("")){pmap.put("tuihuoriqi2", null);}else{pmap.put("tuihuoriqi2", tuihuoriqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}

        int total=tuihuoxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Tuihuoxinxi> list=tuihuoxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "tuihuoxinxi/tuihuoxinxi_yanben1";
    }
    @RequestMapping("tuihuoxinxi_yanben2.do")
    public String tuihuoxinxi_yanben2(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Tuihuoxinxi tuihuoxinxi, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String tuihuoyuanyin, String huifu, String tuihuoriqi1,String tuihuoriqi2, String kahao, String xingming){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(tuihuoriqi1==null||tuihuoriqi1.equals("")){pmap.put("tuihuoriqi1", null);}else{pmap.put("tuihuoriqi1", tuihuoriqi1);}
        if(tuihuoriqi2==null||tuihuoriqi2.equals("")){pmap.put("tuihuoriqi2", null);}else{pmap.put("tuihuoriqi2", tuihuoriqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}

        int total=tuihuoxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Tuihuoxinxi> list=tuihuoxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "tuihuoxinxi/tuihuoxinxi_yanben2";
    }
    @RequestMapping("tuihuoxinxi_yanben3.do")
    public String tuihuoxinxi_yanben3(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Tuihuoxinxi tuihuoxinxi, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String tuihuoyuanyin, String huifu, String tuihuoriqi1,String tuihuoriqi2, String kahao, String xingming){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(tuihuoriqi1==null||tuihuoriqi1.equals("")){pmap.put("tuihuoriqi1", null);}else{pmap.put("tuihuoriqi1", tuihuoriqi1);}
        if(tuihuoriqi2==null||tuihuoriqi2.equals("")){pmap.put("tuihuoriqi2", null);}else{pmap.put("tuihuoriqi2", tuihuoriqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}

        int total=tuihuoxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Tuihuoxinxi> list=tuihuoxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "tuihuoxinxi/tuihuoxinxi_yanben3";
    }
    @RequestMapping("tuihuoxinxi_yanben4.do")
    public String tuihuoxinxi_yanben4(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Tuihuoxinxi tuihuoxinxi, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String tuihuoyuanyin, String huifu, String tuihuoriqi1,String tuihuoriqi2, String kahao, String xingming){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(tuihuoriqi1==null||tuihuoriqi1.equals("")){pmap.put("tuihuoriqi1", null);}else{pmap.put("tuihuoriqi1", tuihuoriqi1);}
        if(tuihuoriqi2==null||tuihuoriqi2.equals("")){pmap.put("tuihuoriqi2", null);}else{pmap.put("tuihuoriqi2", tuihuoriqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}

        int total=tuihuoxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Tuihuoxinxi> list=tuihuoxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "tuihuoxinxi/tuihuoxinxi_yanben4";
    }
    @RequestMapping("tuihuoxinxi_yanben5.do")
    public String tuihuoxinxi_yanben5(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Tuihuoxinxi tuihuoxinxi, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String tuihuoyuanyin, String huifu, String tuihuoriqi1,String tuihuoriqi2, String kahao, String xingming){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(tuihuoriqi1==null||tuihuoriqi1.equals("")){pmap.put("tuihuoriqi1", null);}else{pmap.put("tuihuoriqi1", tuihuoriqi1);}
        if(tuihuoriqi2==null||tuihuoriqi2.equals("")){pmap.put("tuihuoriqi2", null);}else{pmap.put("tuihuoriqi2", tuihuoriqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}

        int total=tuihuoxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Tuihuoxinxi> list=tuihuoxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "tuihuoxinxi/tuihuoxinxi_yanben5";
    }

    @RequestMapping("tuihuoxinxiList2.do")
    public String tuihuoxinxiList2(@RequestParam(value="page",required=false)String page,
                                   ModelMap map,HttpSession session,Tuihuoxinxi tuihuoxinxi, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String tuihuoyuanyin, String huifu, String tuihuoriqi1,String tuihuoriqi2, String kahao, String xingming,HttpServletRequest request){
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
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(tuihuoriqi1==null||tuihuoriqi1.equals("")){pmap.put("tuihuoriqi1", null);}else{pmap.put("tuihuoriqi1", tuihuoriqi1);}
        if(tuihuoriqi2==null||tuihuoriqi2.equals("")){pmap.put("tuihuoriqi2", null);}else{pmap.put("tuihuoriqi2", tuihuoriqi2);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}


        int total=tuihuoxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Tuihuoxinxi> list=tuihuoxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "tuihuoxinxi/tuihuoxinxi_list2";
    }


    @RequestMapping("thxxList.do")
    public String thxxList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Tuihuoxinxi tuihuoxinxi, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String tuihuoyuanyin, String huifu, String tuihuoriqi1,String tuihuoriqi2, String kahao, String xingming){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(tuihuoriqi1==null||tuihuoriqi1.equals("")){pmap.put("tuihuoriqi1", null);}else{pmap.put("tuihuoriqi1", tuihuoriqi1);}
        if(tuihuoriqi2==null||tuihuoriqi2.equals("")){pmap.put("tuihuoriqi2", null);}else{pmap.put("tuihuoriqi2", tuihuoriqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}

        int total=tuihuoxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Tuihuoxinxi> list=tuihuoxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "tuihuoxinxi/tuihuoxinxilist";
    }
    @RequestMapping("thxxListtp.do")
    public String thxxListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,HttpSession session,Tuihuoxinxi tuihuoxinxi, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String tuihuoyuanyin, String huifu, String tuihuoriqi1,String tuihuoriqi2, String kahao, String xingming){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(tuihuoyuanyin==null||tuihuoyuanyin.equals("")){pmap.put("tuihuoyuanyin", null);}else{pmap.put("tuihuoyuanyin", tuihuoyuanyin);}
        if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
        if(tuihuoriqi1==null||tuihuoriqi1.equals("")){pmap.put("tuihuoriqi1", null);}else{pmap.put("tuihuoriqi1", tuihuoriqi1);}
        if(tuihuoriqi2==null||tuihuoriqi2.equals("")){pmap.put("tuihuoriqi2", null);}else{pmap.put("tuihuoriqi2", tuihuoriqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}

        int total=tuihuoxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Tuihuoxinxi> list=tuihuoxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "tuihuoxinxi/tuihuoxinxilisttp";
    }

    @RequestMapping("deleteTuihuoxinxi.do")
    public String deleteTuihuoxinxi(int id,HttpServletRequest request){
        tuihuoxinxiService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:tuihuoxinxiList.do";
    }


}

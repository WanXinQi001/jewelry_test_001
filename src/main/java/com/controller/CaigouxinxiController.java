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

import com.entity.Caigouxinxi;
import com.server.CaigouxinxiServer;
import com.util.PageBean;
import com.util.db;
import java.sql.SQLException;

@Controller
public class CaigouxinxiController {
    @Resource
    private CaigouxinxiServer caigouxinxiService;



    @RequestMapping("addCaigouxinxi.do")
    public String addCaigouxinxi(HttpServletRequest request,Caigouxinxi caigouxinxi,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());

        caigouxinxi.setAddtime(time.toString().substring(0, 19));
        caigouxinxiService.add(caigouxinxi);
        db dbo = new db();dbo.hsgexecute("update shangpinxinxi set kucun=kucun+"+caigouxinxi.getCaigoushuliang()+" where shangpinmingcheng='"+caigouxinxi.getShangpinmingcheng()+"'");
        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "caigouxinxiList.do");

        return "redirect:postback.jsp";
        //return "redirect:caigouxinxiList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateCaigouxinxi.do")
    public String doUpdateCaigouxinxi(int id,ModelMap map,Caigouxinxi caigouxinxi){
        caigouxinxi=caigouxinxiService.getById(id);
        map.put("caigouxinxi", caigouxinxi);
        return "caigouxinxi/caigouxinxi_updt";
    }





    //	后台详细
    @RequestMapping("caigouxinxiDetail.do")
    public String caigouxinxiDetail(int id,ModelMap map,Caigouxinxi caigouxinxi){
        caigouxinxi=caigouxinxiService.getById(id);
        map.put("caigouxinxi", caigouxinxi);
        return "caigouxinxi/caigouxinxi_detail";
    }
    //	前台详细
    @RequestMapping("cgxxDetail.do")
    public String cgxxDetail(int id,ModelMap map,Caigouxinxi caigouxinxi){
        caigouxinxi=caigouxinxiService.getById(id);
        map.put("caigouxinxi", caigouxinxi);
        return "caigouxinxi/caigouxinxidetail";
    }
    //
    @RequestMapping("updateCaigouxinxi.do")
    public String updateCaigouxinxi(int id,ModelMap map,Caigouxinxi caigouxinxi,HttpServletRequest request,HttpSession session){
        caigouxinxiService.update(caigouxinxi);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:caigouxinxiList.do";
    }

    //	分页查询
    @RequestMapping("caigouxinxiList.do")
    public String caigouxinxiList(@RequestParam(value="page",required=false)String page,
                                  ModelMap map,HttpSession session,Caigouxinxi caigouxinxi, String rukudanhao, String shangpinmingcheng, String caizhi, String kucun, String caigoujiage1,String caigoujiage2, String caigoushuliang1,String caigoushuliang2, String zongjiage, String zhanghao, String gongsimingcheng, String caigouriqi1,String caigouriqi2, String gonghao, String xingming, String bumen, String issh){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(rukudanhao==null||rukudanhao.equals("")){pmap.put("rukudanhao", null);}else{pmap.put("rukudanhao", rukudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(caigoujiage1==null||caigoujiage1.equals("")){pmap.put("caigoujiage1", null);}else{pmap.put("caigoujiage1", caigoujiage1);}
        if(caigoujiage2==null||caigoujiage2.equals("")){pmap.put("caigoujiage2", null);}else{pmap.put("caigoujiage2", caigoujiage2);}
        if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
        if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}
        if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}

        int total=caigouxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caigouxinxi> list=caigouxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caigouxinxi/caigouxinxi_list";
    }

    @RequestMapping("caigouxinxi_yanben1.do")
    public String caigouxinxi_yanben1(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caigouxinxi caigouxinxi, String rukudanhao, String shangpinmingcheng, String caizhi, String kucun, String caigoujiage1,String caigoujiage2, String caigoushuliang1,String caigoushuliang2, String zongjiage, String zhanghao, String gongsimingcheng, String caigouriqi1,String caigouriqi2, String gonghao, String xingming, String bumen, String issh){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(rukudanhao==null||rukudanhao.equals("")){pmap.put("rukudanhao", null);}else{pmap.put("rukudanhao", rukudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(caigoujiage1==null||caigoujiage1.equals("")){pmap.put("caigoujiage1", null);}else{pmap.put("caigoujiage1", caigoujiage1);}
        if(caigoujiage2==null||caigoujiage2.equals("")){pmap.put("caigoujiage2", null);}else{pmap.put("caigoujiage2", caigoujiage2);}
        if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
        if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}
        if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}

        int total=caigouxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caigouxinxi> list=caigouxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caigouxinxi/caigouxinxi_yanben1";
    }
    @RequestMapping("caigouxinxi_yanben2.do")
    public String caigouxinxi_yanben2(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caigouxinxi caigouxinxi, String rukudanhao, String shangpinmingcheng, String caizhi, String kucun, String caigoujiage1,String caigoujiage2, String caigoushuliang1,String caigoushuliang2, String zongjiage, String zhanghao, String gongsimingcheng, String caigouriqi1,String caigouriqi2, String gonghao, String xingming, String bumen, String issh){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(rukudanhao==null||rukudanhao.equals("")){pmap.put("rukudanhao", null);}else{pmap.put("rukudanhao", rukudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(caigoujiage1==null||caigoujiage1.equals("")){pmap.put("caigoujiage1", null);}else{pmap.put("caigoujiage1", caigoujiage1);}
        if(caigoujiage2==null||caigoujiage2.equals("")){pmap.put("caigoujiage2", null);}else{pmap.put("caigoujiage2", caigoujiage2);}
        if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
        if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}
        if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}

        int total=caigouxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caigouxinxi> list=caigouxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caigouxinxi/caigouxinxi_yanben2";
    }
    @RequestMapping("caigouxinxi_yanben3.do")
    public String caigouxinxi_yanben3(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caigouxinxi caigouxinxi, String rukudanhao, String shangpinmingcheng, String caizhi, String kucun, String caigoujiage1,String caigoujiage2, String caigoushuliang1,String caigoushuliang2, String zongjiage, String zhanghao, String gongsimingcheng, String caigouriqi1,String caigouriqi2, String gonghao, String xingming, String bumen, String issh){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(rukudanhao==null||rukudanhao.equals("")){pmap.put("rukudanhao", null);}else{pmap.put("rukudanhao", rukudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(caigoujiage1==null||caigoujiage1.equals("")){pmap.put("caigoujiage1", null);}else{pmap.put("caigoujiage1", caigoujiage1);}
        if(caigoujiage2==null||caigoujiage2.equals("")){pmap.put("caigoujiage2", null);}else{pmap.put("caigoujiage2", caigoujiage2);}
        if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
        if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}
        if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}

        int total=caigouxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caigouxinxi> list=caigouxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caigouxinxi/caigouxinxi_yanben3";
    }
    @RequestMapping("caigouxinxi_yanben4.do")
    public String caigouxinxi_yanben4(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caigouxinxi caigouxinxi, String rukudanhao, String shangpinmingcheng, String caizhi, String kucun, String caigoujiage1,String caigoujiage2, String caigoushuliang1,String caigoushuliang2, String zongjiage, String zhanghao, String gongsimingcheng, String caigouriqi1,String caigouriqi2, String gonghao, String xingming, String bumen, String issh){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(rukudanhao==null||rukudanhao.equals("")){pmap.put("rukudanhao", null);}else{pmap.put("rukudanhao", rukudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(caigoujiage1==null||caigoujiage1.equals("")){pmap.put("caigoujiage1", null);}else{pmap.put("caigoujiage1", caigoujiage1);}
        if(caigoujiage2==null||caigoujiage2.equals("")){pmap.put("caigoujiage2", null);}else{pmap.put("caigoujiage2", caigoujiage2);}
        if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
        if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}
        if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}

        int total=caigouxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caigouxinxi> list=caigouxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caigouxinxi/caigouxinxi_yanben4";
    }
    @RequestMapping("caigouxinxi_yanben5.do")
    public String caigouxinxi_yanben5(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Caigouxinxi caigouxinxi, String rukudanhao, String shangpinmingcheng, String caizhi, String kucun, String caigoujiage1,String caigoujiage2, String caigoushuliang1,String caigoushuliang2, String zongjiage, String zhanghao, String gongsimingcheng, String caigouriqi1,String caigouriqi2, String gonghao, String xingming, String bumen, String issh){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(rukudanhao==null||rukudanhao.equals("")){pmap.put("rukudanhao", null);}else{pmap.put("rukudanhao", rukudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(caigoujiage1==null||caigoujiage1.equals("")){pmap.put("caigoujiage1", null);}else{pmap.put("caigoujiage1", caigoujiage1);}
        if(caigoujiage2==null||caigoujiage2.equals("")){pmap.put("caigoujiage2", null);}else{pmap.put("caigoujiage2", caigoujiage2);}
        if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
        if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}
        if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}

        int total=caigouxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caigouxinxi> list=caigouxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caigouxinxi/caigouxinxi_yanben5";
    }

    @RequestMapping("caigouxinxiList3.do")
    public String caigouxinxiList3(@RequestParam(value="page",required=false)String page,
                                   ModelMap map,HttpSession session,Caigouxinxi caigouxinxi, String rukudanhao, String shangpinmingcheng, String caizhi, String kucun, String caigoujiage1,String caigoujiage2, String caigoushuliang1,String caigoushuliang2, String zongjiage, String zhanghao, String gongsimingcheng, String caigouriqi1,String caigouriqi2, String gonghao, String xingming, String bumen, String issh,HttpServletRequest request){
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

        pmap.put("zhanghao", (String)request.getSession().getAttribute("username"));
        if(rukudanhao==null||rukudanhao.equals("")){pmap.put("rukudanhao", null);}else{pmap.put("rukudanhao", rukudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(caigoujiage1==null||caigoujiage1.equals("")){pmap.put("caigoujiage1", null);}else{pmap.put("caigoujiage1", caigoujiage1);}
        if(caigoujiage2==null||caigoujiage2.equals("")){pmap.put("caigoujiage2", null);}else{pmap.put("caigoujiage2", caigoujiage2);}
        if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
        if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}
        if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}


        int total=caigouxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caigouxinxi> list=caigouxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caigouxinxi/caigouxinxi_list3";
    }
    @RequestMapping("caigouxinxiList2.do")
    public String caigouxinxiList2(@RequestParam(value="page",required=false)String page,
                                   ModelMap map,HttpSession session,Caigouxinxi caigouxinxi, String rukudanhao, String shangpinmingcheng, String caizhi, String kucun, String caigoujiage1,String caigoujiage2, String caigoushuliang1,String caigoushuliang2, String zongjiage, String zhanghao, String gongsimingcheng, String caigouriqi1,String caigouriqi2, String gonghao, String xingming, String bumen, String issh,HttpServletRequest request){
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
        if(rukudanhao==null||rukudanhao.equals("")){pmap.put("rukudanhao", null);}else{pmap.put("rukudanhao", rukudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(caigoujiage1==null||caigoujiage1.equals("")){pmap.put("caigoujiage1", null);}else{pmap.put("caigoujiage1", caigoujiage1);}
        if(caigoujiage2==null||caigoujiage2.equals("")){pmap.put("caigoujiage2", null);}else{pmap.put("caigoujiage2", caigoujiage2);}
        if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
        if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}
        if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}


        int total=caigouxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caigouxinxi> list=caigouxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caigouxinxi/caigouxinxi_list2";
    }


    @RequestMapping("cgxxList.do")
    public String cgxxList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Caigouxinxi caigouxinxi, String rukudanhao, String shangpinmingcheng, String caizhi, String kucun, String caigoujiage1,String caigoujiage2, String caigoushuliang1,String caigoushuliang2, String zongjiage, String zhanghao, String gongsimingcheng, String caigouriqi1,String caigouriqi2, String gonghao, String xingming, String bumen, String issh){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(rukudanhao==null||rukudanhao.equals("")){pmap.put("rukudanhao", null);}else{pmap.put("rukudanhao", rukudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(caigoujiage1==null||caigoujiage1.equals("")){pmap.put("caigoujiage1", null);}else{pmap.put("caigoujiage1", caigoujiage1);}
        if(caigoujiage2==null||caigoujiage2.equals("")){pmap.put("caigoujiage2", null);}else{pmap.put("caigoujiage2", caigoujiage2);}
        if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
        if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}
        if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}

        int total=caigouxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caigouxinxi> list=caigouxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caigouxinxi/caigouxinxilist";
    }
    @RequestMapping("cgxxListtp.do")
    public String cgxxListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,HttpSession session,Caigouxinxi caigouxinxi, String rukudanhao, String shangpinmingcheng, String caizhi, String kucun, String caigoujiage1,String caigoujiage2, String caigoushuliang1,String caigoushuliang2, String zongjiage, String zhanghao, String gongsimingcheng, String caigouriqi1,String caigouriqi2, String gonghao, String xingming, String bumen, String issh){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);


        if(rukudanhao==null||rukudanhao.equals("")){pmap.put("rukudanhao", null);}else{pmap.put("rukudanhao", rukudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(caigoujiage1==null||caigoujiage1.equals("")){pmap.put("caigoujiage1", null);}else{pmap.put("caigoujiage1", caigoujiage1);}
        if(caigoujiage2==null||caigoujiage2.equals("")){pmap.put("caigoujiage2", null);}else{pmap.put("caigoujiage2", caigoujiage2);}
        if(caigoushuliang1==null||caigoushuliang1.equals("")){pmap.put("caigoushuliang1", null);}else{pmap.put("caigoushuliang1", caigoushuliang1);}
        if(caigoushuliang2==null||caigoushuliang2.equals("")){pmap.put("caigoushuliang2", null);}else{pmap.put("caigoushuliang2", caigoushuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}
        if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}

        int total=caigouxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Caigouxinxi> list=caigouxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "caigouxinxi/caigouxinxilisttp";
    }

    @RequestMapping("deleteCaigouxinxi.do")
    public String deleteCaigouxinxi(int id,HttpServletRequest request){
        caigouxinxiService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:caigouxinxiList.do";
    }


}

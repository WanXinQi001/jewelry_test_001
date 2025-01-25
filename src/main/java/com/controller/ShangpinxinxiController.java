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

import com.entity.Shangpinxinxi;
import com.server.ShangpinxinxiServer;
import com.util.PageBean;

import java.sql.SQLException;

@Controller
public class ShangpinxinxiController {
    @Resource
    private ShangpinxinxiServer shangpinxinxiService;



    @RequestMapping("addShangpinxinxi.do")
    public String addShangpinxinxi(HttpServletRequest request,Shangpinxinxi shangpinxinxi,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());

        shangpinxinxi.setAddtime(time.toString().substring(0, 19));
        shangpinxinxiService.add(shangpinxinxi);

        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "shangpinxinxiList.do");

        return "redirect:postback.jsp";
        //return "redirect:shangpinxinxiList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateShangpinxinxi.do")
    public String doUpdateShangpinxinxi(int id,ModelMap map,Shangpinxinxi shangpinxinxi){
        shangpinxinxi=shangpinxinxiService.getById(id);
        map.put("shangpinxinxi", shangpinxinxi);
        return "shangpinxinxi/shangpinxinxi_updt";
    }





    //	后台详细
    @RequestMapping("shangpinxinxiDetail.do")
    public String shangpinxinxiDetail(int id,ModelMap map,Shangpinxinxi shangpinxinxi){
        shangpinxinxi=shangpinxinxiService.getById(id);
        map.put("shangpinxinxi", shangpinxinxi);
        return "shangpinxinxi/shangpinxinxi_detail";
    }
    //	前台详细
    @RequestMapping("spxxDetail.do")
    public String spxxDetail(int id,ModelMap map,Shangpinxinxi shangpinxinxi){
        shangpinxinxi=shangpinxinxiService.getById(id);
        map.put("shangpinxinxi", shangpinxinxi);
        return "shangpinxinxi/shangpinxinxidetail";
    }
    //
    @RequestMapping("updateShangpinxinxi.do")
    public String updateShangpinxinxi(int id,ModelMap map,Shangpinxinxi shangpinxinxi,HttpServletRequest request,HttpSession session){
        shangpinxinxiService.update(shangpinxinxi);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:shangpinxinxiList.do";
    }

    //	分页查询
    @RequestMapping("shangpinxinxiList.do")
    public String shangpinxinxiList(@RequestParam(value="page",required=false)String page,
                                    ModelMap map,HttpSession session,Shangpinxinxi shangpinxinxi, String shangpinbianhao, String shangpinmingcheng, String caizhi, String kezhong, String wupindanjia1,String wupindanjia2, String tupian, String jianshu, String gonghao, String xingming, String bumen, String jiage1,String jiage2, String kucun1,String kucun2, String huodejifen1,String huodejifen2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(wupindanjia1==null||wupindanjia1.equals("")){pmap.put("wupindanjia1", null);}else{pmap.put("wupindanjia1", wupindanjia1);}
        if(wupindanjia2==null||wupindanjia2.equals("")){pmap.put("wupindanjia2", null);}else{pmap.put("wupindanjia2", wupindanjia2);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
        if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
        if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
        if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
        if(huodejifen1==null||huodejifen1.equals("")){pmap.put("huodejifen1", null);}else{pmap.put("huodejifen1", huodejifen1);}
        if(huodejifen2==null||huodejifen2.equals("")){pmap.put("huodejifen2", null);}else{pmap.put("huodejifen2", huodejifen2);}

        int total=shangpinxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpinxinxi> list=shangpinxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpinxinxi/shangpinxinxi_list";
    }

    @RequestMapping("shangpinxinxi_yanben1.do")
    public String shangpinxinxi_yanben1(@RequestParam(value="page",required=false)String page,
                                        ModelMap map,HttpSession session,Shangpinxinxi shangpinxinxi, String shangpinbianhao, String shangpinmingcheng, String caizhi, String kezhong, String wupindanjia1,String wupindanjia2, String tupian, String jianshu, String gonghao, String xingming, String bumen, String jiage1,String jiage2, String kucun1,String kucun2, String huodejifen1,String huodejifen2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(wupindanjia1==null||wupindanjia1.equals("")){pmap.put("wupindanjia1", null);}else{pmap.put("wupindanjia1", wupindanjia1);}
        if(wupindanjia2==null||wupindanjia2.equals("")){pmap.put("wupindanjia2", null);}else{pmap.put("wupindanjia2", wupindanjia2);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
        if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
        if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
        if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
        if(huodejifen1==null||huodejifen1.equals("")){pmap.put("huodejifen1", null);}else{pmap.put("huodejifen1", huodejifen1);}
        if(huodejifen2==null||huodejifen2.equals("")){pmap.put("huodejifen2", null);}else{pmap.put("huodejifen2", huodejifen2);}

        int total=shangpinxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpinxinxi> list=shangpinxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpinxinxi/shangpinxinxi_yanben1";
    }
    @RequestMapping("shangpinxinxi_yanben2.do")
    public String shangpinxinxi_yanben2(@RequestParam(value="page",required=false)String page,
                                        ModelMap map,HttpSession session,Shangpinxinxi shangpinxinxi, String shangpinbianhao, String shangpinmingcheng, String caizhi, String kezhong, String wupindanjia1,String wupindanjia2, String tupian, String jianshu, String gonghao, String xingming, String bumen, String jiage1,String jiage2, String kucun1,String kucun2, String huodejifen1,String huodejifen2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(wupindanjia1==null||wupindanjia1.equals("")){pmap.put("wupindanjia1", null);}else{pmap.put("wupindanjia1", wupindanjia1);}
        if(wupindanjia2==null||wupindanjia2.equals("")){pmap.put("wupindanjia2", null);}else{pmap.put("wupindanjia2", wupindanjia2);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
        if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
        if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
        if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
        if(huodejifen1==null||huodejifen1.equals("")){pmap.put("huodejifen1", null);}else{pmap.put("huodejifen1", huodejifen1);}
        if(huodejifen2==null||huodejifen2.equals("")){pmap.put("huodejifen2", null);}else{pmap.put("huodejifen2", huodejifen2);}

        int total=shangpinxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpinxinxi> list=shangpinxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpinxinxi_yanben2";
    }
    @RequestMapping("shangpinxinxi_yanben3.do")
    public String shangpinxinxi_yanben3(@RequestParam(value="page",required=false)String page,
                                        ModelMap map,HttpSession session,Shangpinxinxi shangpinxinxi, String shangpinbianhao, String shangpinmingcheng, String caizhi, String kezhong, String wupindanjia1,String wupindanjia2, String tupian, String jianshu, String gonghao, String xingming, String bumen, String jiage1,String jiage2, String kucun1,String kucun2, String huodejifen1,String huodejifen2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(wupindanjia1==null||wupindanjia1.equals("")){pmap.put("wupindanjia1", null);}else{pmap.put("wupindanjia1", wupindanjia1);}
        if(wupindanjia2==null||wupindanjia2.equals("")){pmap.put("wupindanjia2", null);}else{pmap.put("wupindanjia2", wupindanjia2);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
        if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
        if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
        if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
        if(huodejifen1==null||huodejifen1.equals("")){pmap.put("huodejifen1", null);}else{pmap.put("huodejifen1", huodejifen1);}
        if(huodejifen2==null||huodejifen2.equals("")){pmap.put("huodejifen2", null);}else{pmap.put("huodejifen2", huodejifen2);}

        int total=shangpinxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpinxinxi> list=shangpinxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpinxinxi_yanben3";
    }
    @RequestMapping("shangpinxinxi_yanben4.do")
    public String shangpinxinxi_yanben4(@RequestParam(value="page",required=false)String page,
                                        ModelMap map,HttpSession session,Shangpinxinxi shangpinxinxi, String shangpinbianhao, String shangpinmingcheng, String caizhi, String kezhong, String wupindanjia1,String wupindanjia2, String tupian, String jianshu, String gonghao, String xingming, String bumen, String jiage1,String jiage2, String kucun1,String kucun2, String huodejifen1,String huodejifen2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(wupindanjia1==null||wupindanjia1.equals("")){pmap.put("wupindanjia1", null);}else{pmap.put("wupindanjia1", wupindanjia1);}
        if(wupindanjia2==null||wupindanjia2.equals("")){pmap.put("wupindanjia2", null);}else{pmap.put("wupindanjia2", wupindanjia2);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
        if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
        if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
        if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
        if(huodejifen1==null||huodejifen1.equals("")){pmap.put("huodejifen1", null);}else{pmap.put("huodejifen1", huodejifen1);}
        if(huodejifen2==null||huodejifen2.equals("")){pmap.put("huodejifen2", null);}else{pmap.put("huodejifen2", huodejifen2);}

        int total=shangpinxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpinxinxi> list=shangpinxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpinxinxi_yanben4";
    }
    @RequestMapping("shangpinxinxi_yanben5.do")
    public String shangpinxinxi_yanben5(@RequestParam(value="page",required=false)String page,
                                        ModelMap map,HttpSession session,Shangpinxinxi shangpinxinxi, String shangpinbianhao, String shangpinmingcheng, String caizhi, String kezhong, String wupindanjia1,String wupindanjia2, String tupian, String jianshu, String gonghao, String xingming, String bumen, String jiage1,String jiage2, String kucun1,String kucun2, String huodejifen1,String huodejifen2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(wupindanjia1==null||wupindanjia1.equals("")){pmap.put("wupindanjia1", null);}else{pmap.put("wupindanjia1", wupindanjia1);}
        if(wupindanjia2==null||wupindanjia2.equals("")){pmap.put("wupindanjia2", null);}else{pmap.put("wupindanjia2", wupindanjia2);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
        if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
        if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
        if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
        if(huodejifen1==null||huodejifen1.equals("")){pmap.put("huodejifen1", null);}else{pmap.put("huodejifen1", huodejifen1);}
        if(huodejifen2==null||huodejifen2.equals("")){pmap.put("huodejifen2", null);}else{pmap.put("huodejifen2", huodejifen2);}

        int total=shangpinxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpinxinxi> list=shangpinxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpinxinxi/shangpinxinxi_yanben5";
    }

    @RequestMapping("shangpinxinxiList2.do")
    public String shangpinxinxiList2(@RequestParam(value="page",required=false)String page,
                                     ModelMap map,HttpSession session,Shangpinxinxi shangpinxinxi, String shangpinbianhao, String shangpinmingcheng, String caizhi, String kezhong, String wupindanjia1,String wupindanjia2, String tupian, String jianshu, String gonghao, String xingming, String bumen, String jiage1,String jiage2, String kucun1,String kucun2, String huodejifen1,String huodejifen2,HttpServletRequest request){
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

        pmap.put("xingming", (String)request.getSession().getAttribute("username"));
        if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(wupindanjia1==null||wupindanjia1.equals("")){pmap.put("wupindanjia1", null);}else{pmap.put("wupindanjia1", wupindanjia1);}
        if(wupindanjia2==null||wupindanjia2.equals("")){pmap.put("wupindanjia2", null);}else{pmap.put("wupindanjia2", wupindanjia2);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
        if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
        if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
        if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
        if(huodejifen1==null||huodejifen1.equals("")){pmap.put("huodejifen1", null);}else{pmap.put("huodejifen1", huodejifen1);}
        if(huodejifen2==null||huodejifen2.equals("")){pmap.put("huodejifen2", null);}else{pmap.put("huodejifen2", huodejifen2);}


        int total=shangpinxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpinxinxi> list=shangpinxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpinxinxi/shangpinxinxi_list2";
    }


    @RequestMapping("spxxList.do")
    public String spxxList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Shangpinxinxi shangpinxinxi, String shangpinbianhao, String shangpinmingcheng, String caizhi, String kezhong, String wupindanjia1,String wupindanjia2, String tupian, String jianshu, String gonghao, String xingming, String bumen, String jiage1,String jiage2, String kucun1,String kucun2, String huodejifen1,String huodejifen2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(wupindanjia1==null||wupindanjia1.equals("")){pmap.put("wupindanjia1", null);}else{pmap.put("wupindanjia1", wupindanjia1);}
        if(wupindanjia2==null||wupindanjia2.equals("")){pmap.put("wupindanjia2", null);}else{pmap.put("wupindanjia2", wupindanjia2);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
        if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
        if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
        if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
        if(huodejifen1==null||huodejifen1.equals("")){pmap.put("huodejifen1", null);}else{pmap.put("huodejifen1", huodejifen1);}
        if(huodejifen2==null||huodejifen2.equals("")){pmap.put("huodejifen2", null);}else{pmap.put("huodejifen2", huodejifen2);}

        int total=shangpinxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpinxinxi> list=shangpinxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpinxinxi/shangpinxinxilist";
    }
    @RequestMapping("spxxListtp.do")
    public String spxxListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,
                             HttpSession session,
                             Shangpinxinxi shangpinxinxi,
                             String shangpinbianhao,
                             String shangpinmingcheng,
                             String caizhi,
                             String kezhong,
                             String wupindanjia1,
                             String wupindanjia2,
                             String tupian,
                             String jianshu,
                             String gonghao,
                             String xingming,
                             String bumen,
                             String jiage1,
                             String jiage2,
                             String kucun1,
                             String kucun2,
                             String huodejifen1,
                             String huodejifen2,
                             String kezhong1,
                             String kezhong2){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong1==null||kezhong1.equals("")){pmap.put("kezhong1", null);}else{pmap.put("kezhong1", kezhong1);}
        if(kezhong2==null||kezhong2.equals("")){pmap.put("kezhong2", null);}else{pmap.put("kezhong2", kezhong2);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(wupindanjia1==null||wupindanjia1.equals("")){pmap.put("wupindanjia1", null);}else{pmap.put("wupindanjia1", wupindanjia1);}
        if(wupindanjia2==null||wupindanjia2.equals("")){pmap.put("wupindanjia2", null);}else{pmap.put("wupindanjia2", wupindanjia2);}
        if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
        if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
        if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
        if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
        if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
        if(huodejifen1==null||huodejifen1.equals("")){pmap.put("huodejifen1", null);}else{pmap.put("huodejifen1", huodejifen1);}
        if(huodejifen2==null||huodejifen2.equals("")){pmap.put("huodejifen2", null);}else{pmap.put("huodejifen2", huodejifen2);}

        int total=shangpinxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpinxinxi> list=shangpinxinxiService.getByPage(pmap);
        List<String> caizhi2 = shangpinxinxiService.getCaizhi();
        map.put("page", pageBean);
        map.put("list", list);
        map.put("spxxcaizhi", caizhi2);
        session.setAttribute("p", 1);
        return "shangpinxinxi/shangpinxinxilisttp";
    }

    @RequestMapping("deleteShangpinxinxi.do")
    public String deleteShangpinxinxi(int id,HttpServletRequest request){
        shangpinxinxiService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:shangpinxinxiList.do";
    }


}

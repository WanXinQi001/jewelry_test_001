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

import com.entity.Shangpingoumai;
import com.server.ShangpingoumaiServer;
import com.util.PageBean;
import com.util.db;
import java.sql.SQLException;

@Controller
@RequestMapping("/shangpingoumai")
public class ShangpingoumaiController {
    @Resource
    private ShangpingoumaiServer shangpingoumaiService;



    @RequestMapping("addShangpingoumai.do")
    public String addShangpingoumai(HttpServletRequest request,Shangpingoumai shangpingoumai,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());
        shangpingoumai.setIstj(0);
        shangpingoumai.setStatus("待支付");
        shangpingoumai.setAddtime(time.toString().substring(0, 19));
        shangpingoumaiService.add(shangpingoumai);
        db dbo = new db();dbo.hsgexecute("update shangpinxinxi set kucun=kucun-"+shangpingoumai.getGoumaishuliang()+" where shangpinmingcheng='"+shangpingoumai.getShangpinmingcheng()+"'");
        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "shangpingoumaiList.do");

        return "redirect:../postback.jsp";
        //return "redirect:shangpingoumaiList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateShangpingoumai.do")
    public String doUpdateShangpingoumai(int id,ModelMap map,Shangpingoumai shangpingoumai){
        shangpingoumai=shangpingoumaiService.getById(id);
        map.put("shangpingoumai", shangpingoumai);
        return "shangpingoumai/shangpingoumai_updt";
    }





    //	后台详细
    @RequestMapping("shangpingoumaiDetail.do")
    public String shangpingoumaiDetail(int id,ModelMap map,Shangpingoumai shangpingoumai){
        shangpingoumai=shangpingoumaiService.getById(id);
        map.put("shangpingoumai", shangpingoumai);
        return "shangpingoumai/shangpingoumai_detail";
    }
    //	前台详细
    @RequestMapping("spgmDetail.do")
    public String spgmDetail(int id,ModelMap map,Shangpingoumai shangpingoumai){
        shangpingoumai=shangpingoumaiService.getById(id);
        map.put("shangpingoumai", shangpingoumai);
        return "shangpingoumai/shangpingoumaidetail";
    }
    //
    @RequestMapping("updateShangpingoumai.do")
    public String updateShangpingoumai(int id,ModelMap map,Shangpingoumai shangpingoumai,HttpServletRequest request,HttpSession session){
        shangpingoumaiService.update(shangpingoumai);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:../postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:shangpingoumaiList.do";
    }

    //	分页查询
    @RequestMapping("shangpingoumaiList.do")
    public String shangpingoumaiList(@RequestParam(value="page",required=false)String page,
                                     ModelMap map,HttpSession session,Shangpingoumai shangpingoumai, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String gonghao, String bumen, String huodejifen, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String zongjiage, String goumairiqi1,String goumairiqi2, String kahao, String xingming, String huiyuandengji, String zhekou, String shouji, String shouhuodizhi, String issh,  String status){
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
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
        if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
        if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(goumairiqi1==null||goumairiqi1.equals("")){pmap.put("goumairiqi1", null);}else{pmap.put("goumairiqi1", goumairiqi1);}
        if(goumairiqi2==null||goumairiqi2.equals("")){pmap.put("goumairiqi2", null);}else{pmap.put("goumairiqi2", goumairiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}

        if(status==null||status.equals("")){pmap.put("status", null);}else{pmap.put("status", status);}

        int total=shangpingoumaiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpingoumai> list=shangpingoumaiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpingoumai/shangpingoumai_list";
    }

    @RequestMapping("shangpingoumai_yanben1.do")
    public String shangpingoumai_yanben1(@RequestParam(value="page",required=false)String page,
                                         ModelMap map,HttpSession session,Shangpingoumai shangpingoumai, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String gonghao, String bumen, String huodejifen, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String zongjiage, String goumairiqi1,String goumairiqi2, String kahao, String xingming, String huiyuandengji, String zhekou, String shouji, String shouhuodizhi, String issh){
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
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
        if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
        if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(goumairiqi1==null||goumairiqi1.equals("")){pmap.put("goumairiqi1", null);}else{pmap.put("goumairiqi1", goumairiqi1);}
        if(goumairiqi2==null||goumairiqi2.equals("")){pmap.put("goumairiqi2", null);}else{pmap.put("goumairiqi2", goumairiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}

        int total=shangpingoumaiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpingoumai> list=shangpingoumaiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpingoumai/shangpingoumai_yanben1";
    }
    @RequestMapping("shangpingoumai_yanben2.do")
    public String shangpingoumai_yanben2(@RequestParam(value="page",required=false)String page,
                                         ModelMap map,HttpSession session,Shangpingoumai shangpingoumai, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String gonghao, String bumen, String huodejifen, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String zongjiage, String goumairiqi1,String goumairiqi2, String kahao, String xingming, String huiyuandengji, String zhekou, String shouji, String shouhuodizhi, String issh){
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
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
        if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
        if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(goumairiqi1==null||goumairiqi1.equals("")){pmap.put("goumairiqi1", null);}else{pmap.put("goumairiqi1", goumairiqi1);}
        if(goumairiqi2==null||goumairiqi2.equals("")){pmap.put("goumairiqi2", null);}else{pmap.put("goumairiqi2", goumairiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}

        int total=shangpingoumaiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpingoumai> list=shangpingoumaiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpingoumai/shangpingoumai_yanben2";
    }
    @RequestMapping("shangpingoumai_yanben3.do")
    public String shangpingoumai_yanben3(@RequestParam(value="page",required=false)String page,
                                         ModelMap map,HttpSession session,Shangpingoumai shangpingoumai, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String gonghao, String bumen, String huodejifen, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String zongjiage, String goumairiqi1,String goumairiqi2, String kahao, String xingming, String huiyuandengji, String zhekou, String shouji, String shouhuodizhi, String issh){
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
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
        if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
        if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(goumairiqi1==null||goumairiqi1.equals("")){pmap.put("goumairiqi1", null);}else{pmap.put("goumairiqi1", goumairiqi1);}
        if(goumairiqi2==null||goumairiqi2.equals("")){pmap.put("goumairiqi2", null);}else{pmap.put("goumairiqi2", goumairiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}

        int total=shangpingoumaiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpingoumai> list=shangpingoumaiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpingoumai/shangpingoumai_yanben3";
    }
    @RequestMapping("shangpingoumai_yanben4.do")
    public String shangpingoumai_yanben4(@RequestParam(value="page",required=false)String page,
                                         ModelMap map,HttpSession session,Shangpingoumai shangpingoumai, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String gonghao, String bumen, String huodejifen, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String zongjiage, String goumairiqi1,String goumairiqi2, String kahao, String xingming, String huiyuandengji, String zhekou, String shouji, String shouhuodizhi, String issh){
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
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
        if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
        if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(goumairiqi1==null||goumairiqi1.equals("")){pmap.put("goumairiqi1", null);}else{pmap.put("goumairiqi1", goumairiqi1);}
        if(goumairiqi2==null||goumairiqi2.equals("")){pmap.put("goumairiqi2", null);}else{pmap.put("goumairiqi2", goumairiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}

        int total=shangpingoumaiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpingoumai> list=shangpingoumaiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpingoumai/shangpingoumai_yanben4";
    }
    @RequestMapping("shangpingoumai_yanben5.do")
    public String shangpingoumai_yanben5(@RequestParam(value="page",required=false)String page,
                                         ModelMap map,HttpSession session,Shangpingoumai shangpingoumai, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String gonghao, String bumen, String huodejifen, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String zongjiage, String goumairiqi1,String goumairiqi2, String kahao, String xingming, String huiyuandengji, String zhekou, String shouji, String shouhuodizhi, String issh){
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
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
        if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
        if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(goumairiqi1==null||goumairiqi1.equals("")){pmap.put("goumairiqi1", null);}else{pmap.put("goumairiqi1", goumairiqi1);}
        if(goumairiqi2==null||goumairiqi2.equals("")){pmap.put("goumairiqi2", null);}else{pmap.put("goumairiqi2", goumairiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}

        int total=shangpingoumaiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpingoumai> list=shangpingoumaiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpingoumai/shangpingoumai_yanben5";
    }

    @RequestMapping("shangpingoumaiList3.do")
    public String shangpingoumaiList3(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Shangpingoumai shangpingoumai, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String gonghao, String bumen, String huodejifen, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String zongjiage, String goumairiqi1,String goumairiqi2, String kahao, String xingming, String huiyuandengji, String zhekou, String shouji, String shouhuodizhi, String issh,HttpServletRequest request){
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
        if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
        if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
        if(caizhi==null||caizhi.equals("")){pmap.put("caizhi", null);}else{pmap.put("caizhi", caizhi);}
        if(kezhong==null||kezhong.equals("")){pmap.put("kezhong", null);}else{pmap.put("kezhong", kezhong);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
        if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
        if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(goumairiqi1==null||goumairiqi1.equals("")){pmap.put("goumairiqi1", null);}else{pmap.put("goumairiqi1", goumairiqi1);}
        if(goumairiqi2==null||goumairiqi2.equals("")){pmap.put("goumairiqi2", null);}else{pmap.put("goumairiqi2", goumairiqi2);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}


        int total=shangpingoumaiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpingoumai> list=shangpingoumaiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpingoumai/shangpingoumai_list3";
    }
    @RequestMapping("shangpingoumaiList2.do")
    public String shangpingoumaiList2(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Shangpingoumai shangpingoumai, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String gonghao, String bumen, String huodejifen, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String zongjiage, String goumairiqi1,String goumairiqi2, String kahao, String xingming, String huiyuandengji, String zhekou, String shouji, String shouhuodizhi, String issh,HttpServletRequest request){
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
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
        if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
        if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(goumairiqi1==null||goumairiqi1.equals("")){pmap.put("goumairiqi1", null);}else{pmap.put("goumairiqi1", goumairiqi1);}
        if(goumairiqi2==null||goumairiqi2.equals("")){pmap.put("goumairiqi2", null);}else{pmap.put("goumairiqi2", goumairiqi2);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}


        int total=shangpingoumaiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpingoumai> list=shangpingoumaiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpingoumai/shangpingoumai_list2";
    }


    @RequestMapping("spgmList.do")
    public String spgmList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Shangpingoumai shangpingoumai, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String gonghao, String bumen, String huodejifen, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String zongjiage, String goumairiqi1,String goumairiqi2, String kahao, String xingming, String huiyuandengji, String zhekou, String shouji, String shouhuodizhi, String issh){
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
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
        if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
        if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(goumairiqi1==null||goumairiqi1.equals("")){pmap.put("goumairiqi1", null);}else{pmap.put("goumairiqi1", goumairiqi1);}
        if(goumairiqi2==null||goumairiqi2.equals("")){pmap.put("goumairiqi2", null);}else{pmap.put("goumairiqi2", goumairiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}

        int total=shangpingoumaiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpingoumai> list=shangpingoumaiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpingoumai/shangpingoumailist";
    }
    @RequestMapping("spgmListtp.do")
    public String spgmListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,HttpSession session,Shangpingoumai shangpingoumai, String xiaoshoudanhao, String shangpinmingcheng, String caizhi, String kezhong, String gonghao, String bumen, String huodejifen, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String zongjiage, String goumairiqi1,String goumairiqi2, String kahao, String xingming, String huiyuandengji, String zhekou, String shouji, String shouhuodizhi, String issh){
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
        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(huodejifen==null||huodejifen.equals("")){pmap.put("huodejifen", null);}else{pmap.put("huodejifen", huodejifen);}
        if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
        if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
        if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
        if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
        if(zongjiage==null||zongjiage.equals("")){pmap.put("zongjiage", null);}else{pmap.put("zongjiage", zongjiage);}
        if(goumairiqi1==null||goumairiqi1.equals("")){pmap.put("goumairiqi1", null);}else{pmap.put("goumairiqi1", goumairiqi1);}
        if(goumairiqi2==null||goumairiqi2.equals("")){pmap.put("goumairiqi2", null);}else{pmap.put("goumairiqi2", goumairiqi2);}
        if(kahao==null||kahao.equals("")){pmap.put("kahao", null);}else{pmap.put("kahao", kahao);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
        if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}

        int total=shangpingoumaiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Shangpingoumai> list=shangpingoumaiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "shangpingoumai/shangpingoumailisttp";
    }

    @RequestMapping("deleteShangpingoumai.do")
    public String deleteShangpingoumai(int id,HttpServletRequest request){
        shangpingoumaiService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:shangpingoumaiList.do";
    }


}

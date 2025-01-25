package com.controller;

import java.io.IOException;

import java.sql.Timestamp;
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

import com.entity.Yuangongxinxi;
import com.server.YuangongxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;

import java.sql.SQLException;

@Controller
public class YuangongxinxiController {
    @Resource
    private YuangongxinxiServer yuangongxinxiService;



    @RequestMapping("addYuangongxinxi.do")
    public String addYuangongxinxi(HttpServletRequest request,Yuangongxinxi yuangongxinxi,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());

        yuangongxinxi.setAddtime(time.toString().substring(0, 19));
        yuangongxinxiService.add(yuangongxinxi);

        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "yuangongxinxiList.do");

        return "redirect:postback.jsp";
        //return "redirect:yuangongxinxiList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateYuangongxinxi.do")
    public String doUpdateYuangongxinxi(int id,ModelMap map,Yuangongxinxi yuangongxinxi){
        yuangongxinxi=yuangongxinxiService.getById(id);
        map.put("yuangongxinxi", yuangongxinxi);
        return "staff/yuangongxinxi_updt";
    }

    @RequestMapping("doUpdateYuangongxinxi2.do")
    public String doUpdateYuangongxinxi2(ModelMap map,Yuangongxinxi yuangongxinxi,HttpServletRequest request){
        yuangongxinxi=yuangongxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
        map.put("yuangongxinxi", yuangongxinxi);
        return "staff/yuangongxinxi_updt2";
    }

    @RequestMapping("updateYuangongxinxi2.do")
    public String updateYuangongxinxi2(int id,ModelMap map,Yuangongxinxi yuangongxinxi){
        yuangongxinxiService.update(yuangongxinxi);
        return "redirect:doUpdateYuangongxinxi2.do";
    }



    //	后台详细
    @RequestMapping("yuangongxinxiDetail.do")
    public String yuangongxinxiDetail(int id,ModelMap map,Yuangongxinxi yuangongxinxi){
        yuangongxinxi=yuangongxinxiService.getById(id);
        map.put("yuangongxinxi", yuangongxinxi);
        return "staff/yuangongxinxi_detail";
    }
    //	前台详细
    @RequestMapping("ygxxDetail.do")
    public String ygxxDetail(int id,ModelMap map,Yuangongxinxi yuangongxinxi){
        yuangongxinxi=yuangongxinxiService.getById(id);
        map.put("yuangongxinxi", yuangongxinxi);
        return "yuangongxinxidetail";
    }
    //
    @RequestMapping("updateYuangongxinxi.do")
    public String updateYuangongxinxi(int id,ModelMap map,Yuangongxinxi yuangongxinxi,HttpServletRequest request,HttpSession session){
        yuangongxinxiService.update(yuangongxinxi);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:yuangongxinxiList.do";
    }

    //	分页查询
    @RequestMapping("yuangongxinxiList.do")
    public String yuangongxinxiList(@RequestParam(value="page",required=false)String page,
                                    ModelMap map,HttpSession session,Yuangongxinxi yuangongxinxi, String gonghao, String mima, String xingming, String xingbie, String zhaopian, String bumen, String shenfenzheng, String shouji, String zhuzhi){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(zhuzhi==null||zhuzhi.equals("")){pmap.put("zhuzhi", null);}else{pmap.put("zhuzhi", zhuzhi);}

        int total=yuangongxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yuangongxinxi> list=yuangongxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "staff/yuangongxinxi_list";
    }

    @RequestMapping("yuangongxinxi_yanben1.do")
    public String yuangongxinxi_yanben1(@RequestParam(value="page",required=false)String page,
                                        ModelMap map,HttpSession session,Yuangongxinxi yuangongxinxi, String gonghao, String mima, String xingming, String xingbie, String zhaopian, String bumen, String shenfenzheng, String shouji, String zhuzhi){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(zhuzhi==null||zhuzhi.equals("")){pmap.put("zhuzhi", null);}else{pmap.put("zhuzhi", zhuzhi);}

        int total=yuangongxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yuangongxinxi> list=yuangongxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yuangongxinxi_yanben1";
    }
    @RequestMapping("yuangongxinxi_yanben2.do")
    public String yuangongxinxi_yanben2(@RequestParam(value="page",required=false)String page,
                                        ModelMap map,HttpSession session,Yuangongxinxi yuangongxinxi, String gonghao, String mima, String xingming, String xingbie, String zhaopian, String bumen, String shenfenzheng, String shouji, String zhuzhi){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(zhuzhi==null||zhuzhi.equals("")){pmap.put("zhuzhi", null);}else{pmap.put("zhuzhi", zhuzhi);}

        int total=yuangongxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yuangongxinxi> list=yuangongxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yuangongxinxi_yanben2";
    }
    @RequestMapping("yuangongxinxi_yanben3.do")
    public String yuangongxinxi_yanben3(@RequestParam(value="page",required=false)String page,
                                        ModelMap map,HttpSession session,Yuangongxinxi yuangongxinxi, String gonghao, String mima, String xingming, String xingbie, String zhaopian, String bumen, String shenfenzheng, String shouji, String zhuzhi){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(zhuzhi==null||zhuzhi.equals("")){pmap.put("zhuzhi", null);}else{pmap.put("zhuzhi", zhuzhi);}

        int total=yuangongxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yuangongxinxi> list=yuangongxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yuangongxinxi_yanben3";
    }
    @RequestMapping("yuangongxinxi_yanben4.do")
    public String yuangongxinxi_yanben4(@RequestParam(value="page",required=false)String page,
                                        ModelMap map,HttpSession session,Yuangongxinxi yuangongxinxi, String gonghao, String mima, String xingming, String xingbie, String zhaopian, String bumen, String shenfenzheng, String shouji, String zhuzhi){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(zhuzhi==null||zhuzhi.equals("")){pmap.put("zhuzhi", null);}else{pmap.put("zhuzhi", zhuzhi);}

        int total=yuangongxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yuangongxinxi> list=yuangongxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yuangongxinxi_yanben4";
    }
    @RequestMapping("yuangongxinxi_yanben5.do")
    public String yuangongxinxi_yanben5(@RequestParam(value="page",required=false)String page,
                                        ModelMap map,HttpSession session,Yuangongxinxi yuangongxinxi, String gonghao, String mima, String xingming, String xingbie, String zhaopian, String bumen, String shenfenzheng, String shouji, String zhuzhi){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(zhuzhi==null||zhuzhi.equals("")){pmap.put("zhuzhi", null);}else{pmap.put("zhuzhi", zhuzhi);}

        int total=yuangongxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yuangongxinxi> list=yuangongxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yuangongxinxi_yanben5";
    }

    @RequestMapping("yuangongxinxiList2.do")
    public String yuangongxinxiList2(@RequestParam(value="page",required=false)String page,
                                     ModelMap map,HttpSession session,Yuangongxinxi yuangongxinxi, String gonghao, String mima, String xingming, String xingbie, String zhaopian, String bumen, String shenfenzheng, String shouji, String zhuzhi,HttpServletRequest request){
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
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(zhuzhi==null||zhuzhi.equals("")){pmap.put("zhuzhi", null);}else{pmap.put("zhuzhi", zhuzhi);}


        int total=yuangongxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yuangongxinxi> list=yuangongxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "staff/yuangongxinxi_list2";
    }


    @RequestMapping("ygxxList.do")
    public String ygxxList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Yuangongxinxi yuangongxinxi, String gonghao, String mima, String xingming, String xingbie, String zhaopian, String bumen, String shenfenzheng, String shouji, String zhuzhi){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(zhuzhi==null||zhuzhi.equals("")){pmap.put("zhuzhi", null);}else{pmap.put("zhuzhi", zhuzhi);}

        int total=yuangongxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yuangongxinxi> list=yuangongxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yuangongxinxilist";
    }
    @RequestMapping("ygxxListtp.do")
    public String ygxxListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,HttpSession session,Yuangongxinxi yuangongxinxi, String gonghao, String mima, String xingming, String xingbie, String zhaopian, String bumen, String shenfenzheng, String shouji, String zhuzhi){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
        if(zhuzhi==null||zhuzhi.equals("")){pmap.put("zhuzhi", null);}else{pmap.put("zhuzhi", zhuzhi);}

        int total=yuangongxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Yuangongxinxi> list=yuangongxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "yuangongxinxilisttp";
    }

    @RequestMapping("deleteYuangongxinxi.do")
    public String deleteYuangongxinxi(int id,HttpServletRequest request){
        yuangongxinxiService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:yuangongxinxiList.do";
    }

    @RequestMapping("quchongYuangongxinxi.do")
    public void quchongYuangongxinxi(Yuangongxinxi yuangongxinxi,HttpServletResponse response){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("gonghao", yuangongxinxi.getGonghao());
        System.out.println("gonghao==="+yuangongxinxi.getGonghao());
        System.out.println("gonghao222==="+yuangongxinxiService.quchongYuangongxinxi(map));
        JSONObject obj=new JSONObject();
        if(yuangongxinxiService.quchongYuangongxinxi(map)!=null){
            obj.put("info", "ng");
        }else{
            obj.put("info", "工号可以用！");

        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=null;
        try {
            out=response.getWriter();
            out.print(obj);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            out.close();
        }
    }
}

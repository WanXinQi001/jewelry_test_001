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

import com.entity.Changshangxinxi;
import com.server.ChangshangxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;

import java.sql.SQLException;

@Controller
public class ChangshangxinxiController {
    @Resource
    private ChangshangxinxiServer changshangxinxiService;



    @RequestMapping("addChangshangxinxi.do")
    public String addChangshangxinxi(HttpServletRequest request,Changshangxinxi changshangxinxi,HttpSession session) throws SQLException{
        Timestamp time=new Timestamp(System.currentTimeMillis());

        changshangxinxi.setAddtime(time.toString().substring(0, 19));
        changshangxinxiService.add(changshangxinxi);

        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "changshangxinxiList.do");

        return "redirect:postback.jsp";
        //return "redirect:changshangxinxiList.do";



    }

    //	处理编辑
    @RequestMapping("doUpdateChangshangxinxi.do")
    public String doUpdateChangshangxinxi(int id,ModelMap map,Changshangxinxi changshangxinxi){
        changshangxinxi=changshangxinxiService.getById(id);
        map.put("changshangxinxi", changshangxinxi);
        return "changshangxinxi/changshangxinxi_updt";
    }

    @RequestMapping("doUpdateChangshangxinxi2.do")
    public String doUpdateChangshangxinxi2(ModelMap map,Changshangxinxi changshangxinxi,HttpServletRequest request){
        changshangxinxi=changshangxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
        map.put("changshangxinxi", changshangxinxi);
        return "changshangxinxi/changshangxinxi_updt2";
    }

    @RequestMapping("updateChangshangxinxi2.do")
    public String updateChangshangxinxi2(int id,ModelMap map,Changshangxinxi changshangxinxi){
        changshangxinxiService.update(changshangxinxi);
        return "redirect:doUpdateChangshangxinxi2.do";
    }



    //	后台详细
    @RequestMapping("changshangxinxiDetail.do")
    public String changshangxinxiDetail(int id,ModelMap map,Changshangxinxi changshangxinxi){
        changshangxinxi=changshangxinxiService.getById(id);
        map.put("changshangxinxi", changshangxinxi);
        return "changshangxinxi/changshangxinxi_detail";
    }
    //	前台详细
    @RequestMapping("csxxDetail.do")
    public String csxxDetail(int id,ModelMap map,Changshangxinxi changshangxinxi){
        changshangxinxi=changshangxinxiService.getById(id);
        map.put("changshangxinxi", changshangxinxi);
        return "changshangxinxidetail";
    }
    //
    @RequestMapping("updateChangshangxinxi.do")
    public String updateChangshangxinxi(int id,ModelMap map,Changshangxinxi changshangxinxi,HttpServletRequest request,HttpSession session){
        changshangxinxiService.update(changshangxinxi);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:changshangxinxiList.do";
    }

    //	分页查询
    @RequestMapping("changshangxinxiList.do")
    public String changshangxinxiList(@RequestParam(value="page",required=false)String page,
                                      ModelMap map,HttpSession session,Changshangxinxi changshangxinxi, String zhanghao, String mima, String gongsimingcheng, String fuzeren, String xingbie, String zhaopian, String shenfenzheng, String zhiwei, String lianxidianhua, String youxiang, String dizhi, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(zhiwei==null||zhiwei.equals("")){pmap.put("zhiwei", null);}else{pmap.put("zhiwei", zhiwei);}
        if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
        if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
        if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=changshangxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Changshangxinxi> list=changshangxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "changshangxinxi/changshangxinxi_list";
    }

    @RequestMapping("changshangxinxi_yanben1.do")
    public String changshangxinxi_yanben1(@RequestParam(value="page",required=false)String page,
                                          ModelMap map,HttpSession session,Changshangxinxi changshangxinxi, String zhanghao, String mima, String gongsimingcheng, String fuzeren, String xingbie, String zhaopian, String shenfenzheng, String zhiwei, String lianxidianhua, String youxiang, String dizhi, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(zhiwei==null||zhiwei.equals("")){pmap.put("zhiwei", null);}else{pmap.put("zhiwei", zhiwei);}
        if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
        if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
        if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=changshangxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Changshangxinxi> list=changshangxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "changshangxinxi_yanben1";
    }
    @RequestMapping("changshangxinxi_yanben2.do")
    public String changshangxinxi_yanben2(@RequestParam(value="page",required=false)String page,
                                          ModelMap map,HttpSession session,Changshangxinxi changshangxinxi, String zhanghao, String mima, String gongsimingcheng, String fuzeren, String xingbie, String zhaopian, String shenfenzheng, String zhiwei, String lianxidianhua, String youxiang, String dizhi, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(zhiwei==null||zhiwei.equals("")){pmap.put("zhiwei", null);}else{pmap.put("zhiwei", zhiwei);}
        if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
        if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
        if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=changshangxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Changshangxinxi> list=changshangxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "changshangxinxi_yanben2";
    }
    @RequestMapping("changshangxinxi_yanben3.do")
    public String changshangxinxi_yanben3(@RequestParam(value="page",required=false)String page,
                                          ModelMap map,HttpSession session,Changshangxinxi changshangxinxi, String zhanghao, String mima, String gongsimingcheng, String fuzeren, String xingbie, String zhaopian, String shenfenzheng, String zhiwei, String lianxidianhua, String youxiang, String dizhi, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(zhiwei==null||zhiwei.equals("")){pmap.put("zhiwei", null);}else{pmap.put("zhiwei", zhiwei);}
        if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
        if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
        if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=changshangxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Changshangxinxi> list=changshangxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "changshangxinxi_yanben3";
    }
    @RequestMapping("changshangxinxi_yanben4.do")
    public String changshangxinxi_yanben4(@RequestParam(value="page",required=false)String page,
                                          ModelMap map,HttpSession session,Changshangxinxi changshangxinxi, String zhanghao, String mima, String gongsimingcheng, String fuzeren, String xingbie, String zhaopian, String shenfenzheng, String zhiwei, String lianxidianhua, String youxiang, String dizhi, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(zhiwei==null||zhiwei.equals("")){pmap.put("zhiwei", null);}else{pmap.put("zhiwei", zhiwei);}
        if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
        if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
        if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=changshangxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Changshangxinxi> list=changshangxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "changshangxinxi_yanben4";
    }
    @RequestMapping("changshangxinxi_yanben5.do")
    public String changshangxinxi_yanben5(@RequestParam(value="page",required=false)String page,
                                          ModelMap map,HttpSession session,Changshangxinxi changshangxinxi, String zhanghao, String mima, String gongsimingcheng, String fuzeren, String xingbie, String zhaopian, String shenfenzheng, String zhiwei, String lianxidianhua, String youxiang, String dizhi, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(zhiwei==null||zhiwei.equals("")){pmap.put("zhiwei", null);}else{pmap.put("zhiwei", zhiwei);}
        if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
        if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
        if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=changshangxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Changshangxinxi> list=changshangxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "changshangxinxi_yanben5";
    }

    @RequestMapping("changshangxinxiList2.do")
    public String changshangxinxiList2(@RequestParam(value="page",required=false)String page,
                                       ModelMap map,HttpSession session,Changshangxinxi changshangxinxi, String zhanghao, String mima, String gongsimingcheng, String fuzeren, String xingbie, String zhaopian, String shenfenzheng, String zhiwei, String lianxidianhua, String youxiang, String dizhi, String beizhu,HttpServletRequest request){
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
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(zhiwei==null||zhiwei.equals("")){pmap.put("zhiwei", null);}else{pmap.put("zhiwei", zhiwei);}
        if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
        if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
        if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}


        int total=changshangxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Changshangxinxi> list=changshangxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "changshangxinxi/changshangxinxi_list2";
    }


    @RequestMapping("csxxList.do")
    public String csxxList(@RequestParam(value="page",required=false)String page,
                           ModelMap map,HttpSession session,Changshangxinxi changshangxinxi, String zhanghao, String mima, String gongsimingcheng, String fuzeren, String xingbie, String zhaopian, String shenfenzheng, String zhiwei, String lianxidianhua, String youxiang, String dizhi, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(zhiwei==null||zhiwei.equals("")){pmap.put("zhiwei", null);}else{pmap.put("zhiwei", zhiwei);}
        if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
        if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
        if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=changshangxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Changshangxinxi> list=changshangxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "changshangxinxilist";
    }
    @RequestMapping("csxxListtp.do")
    public String csxxListtp(@RequestParam(value="page",required=false)String page,
                             ModelMap map,HttpSession session,Changshangxinxi changshangxinxi, String zhanghao, String mima, String gongsimingcheng, String fuzeren, String xingbie, String zhaopian, String shenfenzheng, String zhiwei, String lianxidianhua, String youxiang, String dizhi, String beizhu){
        if(page==null||page.equals("")){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
        if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
        if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}
        if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}
        if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
        if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
        if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
        if(zhiwei==null||zhiwei.equals("")){pmap.put("zhiwei", null);}else{pmap.put("zhiwei", zhiwei);}
        if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
        if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
        if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
        if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}

        int total=changshangxinxiService.getCount(pmap);
        pageBean.setTotal(total);
        List<Changshangxinxi> list=changshangxinxiService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "changshangxinxilisttp";
    }

    @RequestMapping("deleteChangshangxinxi.do")
    public String deleteChangshangxinxi(int id,HttpServletRequest request){
        changshangxinxiService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:"+url;
        //return "redirect:changshangxinxiList.do";
    }

    @RequestMapping("quchongChangshangxinxi.do")
    public void quchongChangshangxinxi(Changshangxinxi changshangxinxi,HttpServletResponse response){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("zhanghao", changshangxinxi.getZhanghao());
        System.out.println("zhanghao==="+changshangxinxi.getZhanghao());
        System.out.println("zhanghao222==="+changshangxinxiService.quchongChangshangxinxi(map));
        JSONObject obj=new JSONObject();
        if(changshangxinxiService.quchongChangshangxinxi(map)!=null){
            obj.put("info", "ng");
        }else{
            obj.put("info", "账号可以用！");

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

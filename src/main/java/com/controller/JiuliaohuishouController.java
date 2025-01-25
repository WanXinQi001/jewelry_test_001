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

import com.entity.Jiuliaohuishou;
import com.server.JiuliaohuishouServer;
import com.util.PageBean;

import java.sql.SQLException;

@Controller
@RequestMapping("/jiuliaohuishou")
public class JiuliaohuishouController {
    @Resource
    private JiuliaohuishouServer jiuliaohuishouService;


    @RequestMapping("addJiuliaohuishou.do")
    public String addJiuliaohuishou(HttpServletRequest request, Jiuliaohuishou jiuliaohuishou, HttpSession session) throws SQLException {
        Timestamp time = new Timestamp(System.currentTimeMillis());

        jiuliaohuishou.setAddtime(time.toString().substring(0, 19));
        jiuliaohuishouService.add(jiuliaohuishou);

        session.setAttribute("backxx", "添加成功");
        session.setAttribute("backurl", request.getHeader("Referer"));

        //session.setAttribute("backurl", "jiuliaohuishouList.do");

        return "redirect:../postback.jsp";
        //return "redirect:jiuliaohuishouList.do";


    }

    //	处理编辑
    @RequestMapping("doUpdateJiuliaohuishou.do")
    public String doUpdateJiuliaohuishou(int id, ModelMap map, Jiuliaohuishou jiuliaohuishou) {
        jiuliaohuishou = jiuliaohuishouService.getById(id);
        map.put("jiuliaohuishou", jiuliaohuishou);
        return "jiuliaohuishou/jiuliaohuishou_updt";
    }


    @RequestMapping("doUpdateJiuliaohuishoulb.do")
    public String doUpdateJiuliaohuishoulb(int id, ModelMap map, Jiuliaohuishou jiuliaohuishou) {
        jiuliaohuishou = jiuliaohuishouService.getById(id);
        map.put("jiuliaohuishou", jiuliaohuishou);
        return "jiuliaohuishou/jiuliaohuishou_updtlb";
    }

    @RequestMapping("updateJiuliaohuishoulb.do")
    public String updateJiuliaohuishoulb(int id, ModelMap map, Jiuliaohuishou jiuliaohuishou) {
        jiuliaohuishouService.updatelb(jiuliaohuishou);
        return "redirect:jiuliaohuishouList.do";
    }

    //	后台详细
    @RequestMapping("jiuliaohuishouDetail.do")
    public String jiuliaohuishouDetail(int id, ModelMap map, Jiuliaohuishou jiuliaohuishou) {
        jiuliaohuishou = jiuliaohuishouService.getById(id);
        map.put("jiuliaohuishou", jiuliaohuishou);
        return "jiuliaohuishou/jiuliaohuishou_detail";
    }

    //	前台详细
    @RequestMapping("jlhsDetail.do")
    public String jlhsDetail(int id, ModelMap map, Jiuliaohuishou jiuliaohuishou) {
        jiuliaohuishou = jiuliaohuishouService.getById(id);
        map.put("jiuliaohuishou", jiuliaohuishou);
        return "jiuliaohuishou/jiuliaohuishoudetail";
    }

    //
    @RequestMapping("updateJiuliaohuishou.do")
    public String updateJiuliaohuishou(int id, ModelMap map, Jiuliaohuishou jiuliaohuishou, HttpServletRequest request, HttpSession session) {
        jiuliaohuishouService.update(jiuliaohuishou);
        session.setAttribute("backxx", "修改成功");
        session.setAttribute("backurl", request.getHeader("Referer"));
        return "redirect:../postback.jsp";
        //String url = request.getHeader("Referer");
        //return "redirect:"+url;
        //return "redirect:jiuliaohuishouList.do";
    }

    //	分页查询
    @RequestMapping("jiuliaohuishouList.do")
    public String jiuliaohuishouList(@RequestParam(value = "page", required = false) String page,
                                     ModelMap map, HttpSession session, Jiuliaohuishou jiuliaohuishou, String huishoudanhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang1, String shuliang2, String tupian, String xiangxiqingkuang, String neirong, String huifu, String kahao, String xingming, String xingbie, String shouji) {
        if (page == null || page.equals("")) {
            page = "1";
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap = new HashMap<String, Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if (huishoudanhao == null || huishoudanhao.equals("")) {
            pmap.put("huishoudanhao", null);
        } else {
            pmap.put("huishoudanhao", huishoudanhao);
        }
        if (wupinmingcheng == null || wupinmingcheng.equals("")) {
            pmap.put("wupinmingcheng", null);
        } else {
            pmap.put("wupinmingcheng", wupinmingcheng);
        }
        if (caizhi == null || caizhi.equals("")) {
            pmap.put("caizhi", null);
        } else {
            pmap.put("caizhi", caizhi);
        }
        if (kezhong == null || kezhong.equals("")) {
            pmap.put("kezhong", null);
        } else {
            pmap.put("kezhong", kezhong);
        }
        if (shuliang1 == null || shuliang1.equals("")) {
            pmap.put("shuliang1", null);
        } else {
            pmap.put("shuliang1", shuliang1);
        }
        if (shuliang2 == null || shuliang2.equals("")) {
            pmap.put("shuliang2", null);
        } else {
            pmap.put("shuliang2", shuliang2);
        }
        if (tupian == null || tupian.equals("")) {
            pmap.put("tupian", null);
        } else {
            pmap.put("tupian", tupian);
        }
        if (xiangxiqingkuang == null || xiangxiqingkuang.equals("")) {
            pmap.put("xiangxiqingkuang", null);
        } else {
            pmap.put("xiangxiqingkuang", xiangxiqingkuang);
        }
        if (neirong == null || neirong.equals("")) {
            pmap.put("neirong", null);
        } else {
            pmap.put("neirong", neirong);
        }
        if (huifu == null || huifu.equals("")) {
            pmap.put("huifu", null);
        } else {
            pmap.put("huifu", huifu);
        }
        if (kahao == null || kahao.equals("")) {
            pmap.put("kahao", null);
        } else {
            pmap.put("kahao", kahao);
        }
        if (xingming == null || xingming.equals("")) {
            pmap.put("xingming", null);
        } else {
            pmap.put("xingming", xingming);
        }
        if (xingbie == null || xingbie.equals("")) {
            pmap.put("xingbie", null);
        } else {
            pmap.put("xingbie", xingbie);
        }
        if (shouji == null || shouji.equals("")) {
            pmap.put("shouji", null);
        } else {
            pmap.put("shouji", shouji);
        }

        int total = jiuliaohuishouService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jiuliaohuishou> list = jiuliaohuishouService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jiuliaohuishou/jiuliaohuishou_list";
    }

    @RequestMapping("jiuliaohuishou_yanben1.do")
    public String jiuliaohuishou_yanben1(@RequestParam(value = "page", required = false) String page,
                                         ModelMap map, HttpSession session, Jiuliaohuishou jiuliaohuishou, String huishoudanhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang1, String shuliang2, String tupian, String xiangxiqingkuang, String neirong, String huifu, String kahao, String xingming, String xingbie, String shouji) {
        if (page == null || page.equals("")) {
            page = "1";
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap = new HashMap<String, Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if (huishoudanhao == null || huishoudanhao.equals("")) {
            pmap.put("huishoudanhao", null);
        } else {
            pmap.put("huishoudanhao", huishoudanhao);
        }
        if (wupinmingcheng == null || wupinmingcheng.equals("")) {
            pmap.put("wupinmingcheng", null);
        } else {
            pmap.put("wupinmingcheng", wupinmingcheng);
        }
        if (caizhi == null || caizhi.equals("")) {
            pmap.put("caizhi", null);
        } else {
            pmap.put("caizhi", caizhi);
        }
        if (kezhong == null || kezhong.equals("")) {
            pmap.put("kezhong", null);
        } else {
            pmap.put("kezhong", kezhong);
        }
        if (shuliang1 == null || shuliang1.equals("")) {
            pmap.put("shuliang1", null);
        } else {
            pmap.put("shuliang1", shuliang1);
        }
        if (shuliang2 == null || shuliang2.equals("")) {
            pmap.put("shuliang2", null);
        } else {
            pmap.put("shuliang2", shuliang2);
        }
        if (tupian == null || tupian.equals("")) {
            pmap.put("tupian", null);
        } else {
            pmap.put("tupian", tupian);
        }
        if (xiangxiqingkuang == null || xiangxiqingkuang.equals("")) {
            pmap.put("xiangxiqingkuang", null);
        } else {
            pmap.put("xiangxiqingkuang", xiangxiqingkuang);
        }
        if (neirong == null || neirong.equals("")) {
            pmap.put("neirong", null);
        } else {
            pmap.put("neirong", neirong);
        }
        if (huifu == null || huifu.equals("")) {
            pmap.put("huifu", null);
        } else {
            pmap.put("huifu", huifu);
        }
        if (kahao == null || kahao.equals("")) {
            pmap.put("kahao", null);
        } else {
            pmap.put("kahao", kahao);
        }
        if (xingming == null || xingming.equals("")) {
            pmap.put("xingming", null);
        } else {
            pmap.put("xingming", xingming);
        }
        if (xingbie == null || xingbie.equals("")) {
            pmap.put("xingbie", null);
        } else {
            pmap.put("xingbie", xingbie);
        }
        if (shouji == null || shouji.equals("")) {
            pmap.put("shouji", null);
        } else {
            pmap.put("shouji", shouji);
        }

        int total = jiuliaohuishouService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jiuliaohuishou> list = jiuliaohuishouService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jiuliaohuishou/jiuliaohuishou_yanben1";
    }

    @RequestMapping("jiuliaohuishou_yanben2.do")
    public String jiuliaohuishou_yanben2(@RequestParam(value = "page", required = false) String page,
                                         ModelMap map, HttpSession session, Jiuliaohuishou jiuliaohuishou, String huishoudanhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang1, String shuliang2, String tupian, String xiangxiqingkuang, String neirong, String huifu, String kahao, String xingming, String xingbie, String shouji) {
        if (page == null || page.equals("")) {
            page = "1";
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap = new HashMap<String, Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if (huishoudanhao == null || huishoudanhao.equals("")) {
            pmap.put("huishoudanhao", null);
        } else {
            pmap.put("huishoudanhao", huishoudanhao);
        }
        if (wupinmingcheng == null || wupinmingcheng.equals("")) {
            pmap.put("wupinmingcheng", null);
        } else {
            pmap.put("wupinmingcheng", wupinmingcheng);
        }
        if (caizhi == null || caizhi.equals("")) {
            pmap.put("caizhi", null);
        } else {
            pmap.put("caizhi", caizhi);
        }
        if (kezhong == null || kezhong.equals("")) {
            pmap.put("kezhong", null);
        } else {
            pmap.put("kezhong", kezhong);
        }
        if (shuliang1 == null || shuliang1.equals("")) {
            pmap.put("shuliang1", null);
        } else {
            pmap.put("shuliang1", shuliang1);
        }
        if (shuliang2 == null || shuliang2.equals("")) {
            pmap.put("shuliang2", null);
        } else {
            pmap.put("shuliang2", shuliang2);
        }
        if (tupian == null || tupian.equals("")) {
            pmap.put("tupian", null);
        } else {
            pmap.put("tupian", tupian);
        }
        if (xiangxiqingkuang == null || xiangxiqingkuang.equals("")) {
            pmap.put("xiangxiqingkuang", null);
        } else {
            pmap.put("xiangxiqingkuang", xiangxiqingkuang);
        }
        if (neirong == null || neirong.equals("")) {
            pmap.put("neirong", null);
        } else {
            pmap.put("neirong", neirong);
        }
        if (huifu == null || huifu.equals("")) {
            pmap.put("huifu", null);
        } else {
            pmap.put("huifu", huifu);
        }
        if (kahao == null || kahao.equals("")) {
            pmap.put("kahao", null);
        } else {
            pmap.put("kahao", kahao);
        }
        if (xingming == null || xingming.equals("")) {
            pmap.put("xingming", null);
        } else {
            pmap.put("xingming", xingming);
        }
        if (xingbie == null || xingbie.equals("")) {
            pmap.put("xingbie", null);
        } else {
            pmap.put("xingbie", xingbie);
        }
        if (shouji == null || shouji.equals("")) {
            pmap.put("shouji", null);
        } else {
            pmap.put("shouji", shouji);
        }

        int total = jiuliaohuishouService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jiuliaohuishou> list = jiuliaohuishouService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jiuliaohuishou/jiuliaohuishou_yanben2";
    }

    @RequestMapping("jiuliaohuishou_yanben3.do")
    public String jiuliaohuishou_yanben3(@RequestParam(value = "page", required = false) String page,
                                         ModelMap map, HttpSession session, Jiuliaohuishou jiuliaohuishou, String huishoudanhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang1, String shuliang2, String tupian, String xiangxiqingkuang, String neirong, String huifu, String kahao, String xingming, String xingbie, String shouji) {
        if (page == null || page.equals("")) {
            page = "1";
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap = new HashMap<String, Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if (huishoudanhao == null || huishoudanhao.equals("")) {
            pmap.put("huishoudanhao", null);
        } else {
            pmap.put("huishoudanhao", huishoudanhao);
        }
        if (wupinmingcheng == null || wupinmingcheng.equals("")) {
            pmap.put("wupinmingcheng", null);
        } else {
            pmap.put("wupinmingcheng", wupinmingcheng);
        }
        if (caizhi == null || caizhi.equals("")) {
            pmap.put("caizhi", null);
        } else {
            pmap.put("caizhi", caizhi);
        }
        if (kezhong == null || kezhong.equals("")) {
            pmap.put("kezhong", null);
        } else {
            pmap.put("kezhong", kezhong);
        }
        if (shuliang1 == null || shuliang1.equals("")) {
            pmap.put("shuliang1", null);
        } else {
            pmap.put("shuliang1", shuliang1);
        }
        if (shuliang2 == null || shuliang2.equals("")) {
            pmap.put("shuliang2", null);
        } else {
            pmap.put("shuliang2", shuliang2);
        }
        if (tupian == null || tupian.equals("")) {
            pmap.put("tupian", null);
        } else {
            pmap.put("tupian", tupian);
        }
        if (xiangxiqingkuang == null || xiangxiqingkuang.equals("")) {
            pmap.put("xiangxiqingkuang", null);
        } else {
            pmap.put("xiangxiqingkuang", xiangxiqingkuang);
        }
        if (neirong == null || neirong.equals("")) {
            pmap.put("neirong", null);
        } else {
            pmap.put("neirong", neirong);
        }
        if (huifu == null || huifu.equals("")) {
            pmap.put("huifu", null);
        } else {
            pmap.put("huifu", huifu);
        }
        if (kahao == null || kahao.equals("")) {
            pmap.put("kahao", null);
        } else {
            pmap.put("kahao", kahao);
        }
        if (xingming == null || xingming.equals("")) {
            pmap.put("xingming", null);
        } else {
            pmap.put("xingming", xingming);
        }
        if (xingbie == null || xingbie.equals("")) {
            pmap.put("xingbie", null);
        } else {
            pmap.put("xingbie", xingbie);
        }
        if (shouji == null || shouji.equals("")) {
            pmap.put("shouji", null);
        } else {
            pmap.put("shouji", shouji);
        }

        int total = jiuliaohuishouService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jiuliaohuishou> list = jiuliaohuishouService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jiuliaohuishou/jiuliaohuishou_yanben3";
    }

    @RequestMapping("jiuliaohuishou_yanben4.do")
    public String jiuliaohuishou_yanben4(@RequestParam(value = "page", required = false) String page,
                                         ModelMap map, HttpSession session, Jiuliaohuishou jiuliaohuishou, String huishoudanhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang1, String shuliang2, String tupian, String xiangxiqingkuang, String neirong, String huifu, String kahao, String xingming, String xingbie, String shouji) {
        if (page == null || page.equals("")) {
            page = "1";
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap = new HashMap<String, Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if (huishoudanhao == null || huishoudanhao.equals("")) {
            pmap.put("huishoudanhao", null);
        } else {
            pmap.put("huishoudanhao", huishoudanhao);
        }
        if (wupinmingcheng == null || wupinmingcheng.equals("")) {
            pmap.put("wupinmingcheng", null);
        } else {
            pmap.put("wupinmingcheng", wupinmingcheng);
        }
        if (caizhi == null || caizhi.equals("")) {
            pmap.put("caizhi", null);
        } else {
            pmap.put("caizhi", caizhi);
        }
        if (kezhong == null || kezhong.equals("")) {
            pmap.put("kezhong", null);
        } else {
            pmap.put("kezhong", kezhong);
        }
        if (shuliang1 == null || shuliang1.equals("")) {
            pmap.put("shuliang1", null);
        } else {
            pmap.put("shuliang1", shuliang1);
        }
        if (shuliang2 == null || shuliang2.equals("")) {
            pmap.put("shuliang2", null);
        } else {
            pmap.put("shuliang2", shuliang2);
        }
        if (tupian == null || tupian.equals("")) {
            pmap.put("tupian", null);
        } else {
            pmap.put("tupian", tupian);
        }
        if (xiangxiqingkuang == null || xiangxiqingkuang.equals("")) {
            pmap.put("xiangxiqingkuang", null);
        } else {
            pmap.put("xiangxiqingkuang", xiangxiqingkuang);
        }
        if (neirong == null || neirong.equals("")) {
            pmap.put("neirong", null);
        } else {
            pmap.put("neirong", neirong);
        }
        if (huifu == null || huifu.equals("")) {
            pmap.put("huifu", null);
        } else {
            pmap.put("huifu", huifu);
        }
        if (kahao == null || kahao.equals("")) {
            pmap.put("kahao", null);
        } else {
            pmap.put("kahao", kahao);
        }
        if (xingming == null || xingming.equals("")) {
            pmap.put("xingming", null);
        } else {
            pmap.put("xingming", xingming);
        }
        if (xingbie == null || xingbie.equals("")) {
            pmap.put("xingbie", null);
        } else {
            pmap.put("xingbie", xingbie);
        }
        if (shouji == null || shouji.equals("")) {
            pmap.put("shouji", null);
        } else {
            pmap.put("shouji", shouji);
        }

        int total = jiuliaohuishouService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jiuliaohuishou> list = jiuliaohuishouService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jiuliaohuishou/jiuliaohuishou_yanben4";
    }

    @RequestMapping("jiuliaohuishou_yanben5.do")
    public String jiuliaohuishou_yanben5(@RequestParam(value = "page", required = false) String page,
                                         ModelMap map, HttpSession session, Jiuliaohuishou jiuliaohuishou, String huishoudanhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang1, String shuliang2, String tupian, String xiangxiqingkuang, String neirong, String huifu, String kahao, String xingming, String xingbie, String shouji) {
        if (page == null || page.equals("")) {
            page = "1";
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap = new HashMap<String, Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if (huishoudanhao == null || huishoudanhao.equals("")) {
            pmap.put("huishoudanhao", null);
        } else {
            pmap.put("huishoudanhao", huishoudanhao);
        }
        if (wupinmingcheng == null || wupinmingcheng.equals("")) {
            pmap.put("wupinmingcheng", null);
        } else {
            pmap.put("wupinmingcheng", wupinmingcheng);
        }
        if (caizhi == null || caizhi.equals("")) {
            pmap.put("caizhi", null);
        } else {
            pmap.put("caizhi", caizhi);
        }
        if (kezhong == null || kezhong.equals("")) {
            pmap.put("kezhong", null);
        } else {
            pmap.put("kezhong", kezhong);
        }
        if (shuliang1 == null || shuliang1.equals("")) {
            pmap.put("shuliang1", null);
        } else {
            pmap.put("shuliang1", shuliang1);
        }
        if (shuliang2 == null || shuliang2.equals("")) {
            pmap.put("shuliang2", null);
        } else {
            pmap.put("shuliang2", shuliang2);
        }
        if (tupian == null || tupian.equals("")) {
            pmap.put("tupian", null);
        } else {
            pmap.put("tupian", tupian);
        }
        if (xiangxiqingkuang == null || xiangxiqingkuang.equals("")) {
            pmap.put("xiangxiqingkuang", null);
        } else {
            pmap.put("xiangxiqingkuang", xiangxiqingkuang);
        }
        if (neirong == null || neirong.equals("")) {
            pmap.put("neirong", null);
        } else {
            pmap.put("neirong", neirong);
        }
        if (huifu == null || huifu.equals("")) {
            pmap.put("huifu", null);
        } else {
            pmap.put("huifu", huifu);
        }
        if (kahao == null || kahao.equals("")) {
            pmap.put("kahao", null);
        } else {
            pmap.put("kahao", kahao);
        }
        if (xingming == null || xingming.equals("")) {
            pmap.put("xingming", null);
        } else {
            pmap.put("xingming", xingming);
        }
        if (xingbie == null || xingbie.equals("")) {
            pmap.put("xingbie", null);
        } else {
            pmap.put("xingbie", xingbie);
        }
        if (shouji == null || shouji.equals("")) {
            pmap.put("shouji", null);
        } else {
            pmap.put("shouji", shouji);
        }

        int total = jiuliaohuishouService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jiuliaohuishou> list = jiuliaohuishouService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jiuliaohuishou/jiuliaohuishou_yanben5";
    }

    @RequestMapping("jiuliaohuishouList2.do")
    public String jiuliaohuishouList2(@RequestParam(value = "page", required = false) String page,
                                      ModelMap map, HttpSession session, Jiuliaohuishou jiuliaohuishou, String huishoudanhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang1, String shuliang2, String tupian, String xiangxiqingkuang, String neirong, String huifu, String kahao, String xingming, String xingbie, String shouji, HttpServletRequest request) {
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
        if (page == null || page.equals("")) {
            page = "1";
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), 15);
        Map<String, Object> pmap = new HashMap<String, Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 15);

        pmap.put("kahao", (String) request.getSession().getAttribute("username"));
        if (huishoudanhao == null || huishoudanhao.equals("")) {
            pmap.put("huishoudanhao", null);
        } else {
            pmap.put("huishoudanhao", huishoudanhao);
        }
        if (wupinmingcheng == null || wupinmingcheng.equals("")) {
            pmap.put("wupinmingcheng", null);
        } else {
            pmap.put("wupinmingcheng", wupinmingcheng);
        }
        if (caizhi == null || caizhi.equals("")) {
            pmap.put("caizhi", null);
        } else {
            pmap.put("caizhi", caizhi);
        }
        if (kezhong == null || kezhong.equals("")) {
            pmap.put("kezhong", null);
        } else {
            pmap.put("kezhong", kezhong);
        }
        if (shuliang1 == null || shuliang1.equals("")) {
            pmap.put("shuliang1", null);
        } else {
            pmap.put("shuliang1", shuliang1);
        }
        if (shuliang2 == null || shuliang2.equals("")) {
            pmap.put("shuliang2", null);
        } else {
            pmap.put("shuliang2", shuliang2);
        }
        if (tupian == null || tupian.equals("")) {
            pmap.put("tupian", null);
        } else {
            pmap.put("tupian", tupian);
        }
        if (xiangxiqingkuang == null || xiangxiqingkuang.equals("")) {
            pmap.put("xiangxiqingkuang", null);
        } else {
            pmap.put("xiangxiqingkuang", xiangxiqingkuang);
        }
        if (neirong == null || neirong.equals("")) {
            pmap.put("neirong", null);
        } else {
            pmap.put("neirong", neirong);
        }
        if (huifu == null || huifu.equals("")) {
            pmap.put("huifu", null);
        } else {
            pmap.put("huifu", huifu);
        }
        if (xingming == null || xingming.equals("")) {
            pmap.put("xingming", null);
        } else {
            pmap.put("xingming", xingming);
        }
        if (xingbie == null || xingbie.equals("")) {
            pmap.put("xingbie", null);
        } else {
            pmap.put("xingbie", xingbie);
        }
        if (shouji == null || shouji.equals("")) {
            pmap.put("shouji", null);
        } else {
            pmap.put("shouji", shouji);
        }


        int total = jiuliaohuishouService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jiuliaohuishou> list = jiuliaohuishouService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jiuliaohuishou/jiuliaohuishou_list2";
    }


    @RequestMapping("jlhsList.do")
    public String jlhsList(@RequestParam(value = "page", required = false) String page,
                           ModelMap map, HttpSession session, Jiuliaohuishou jiuliaohuishou, String huishoudanhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang1, String shuliang2, String tupian, String xiangxiqingkuang, String neirong, String huifu, String kahao, String xingming, String xingbie, String shouji) {
        if (page == null || page.equals("")) {
            page = "1";
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap = new HashMap<String, Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if (huishoudanhao == null || huishoudanhao.equals("")) {
            pmap.put("huishoudanhao", null);
        } else {
            pmap.put("huishoudanhao", huishoudanhao);
        }
        if (wupinmingcheng == null || wupinmingcheng.equals("")) {
            pmap.put("wupinmingcheng", null);
        } else {
            pmap.put("wupinmingcheng", wupinmingcheng);
        }
        if (caizhi == null || caizhi.equals("")) {
            pmap.put("caizhi", null);
        } else {
            pmap.put("caizhi", caizhi);
        }
        if (kezhong == null || kezhong.equals("")) {
            pmap.put("kezhong", null);
        } else {
            pmap.put("kezhong", kezhong);
        }
        if (shuliang1 == null || shuliang1.equals("")) {
            pmap.put("shuliang1", null);
        } else {
            pmap.put("shuliang1", shuliang1);
        }
        if (shuliang2 == null || shuliang2.equals("")) {
            pmap.put("shuliang2", null);
        } else {
            pmap.put("shuliang2", shuliang2);
        }
        if (tupian == null || tupian.equals("")) {
            pmap.put("tupian", null);
        } else {
            pmap.put("tupian", tupian);
        }
        if (xiangxiqingkuang == null || xiangxiqingkuang.equals("")) {
            pmap.put("xiangxiqingkuang", null);
        } else {
            pmap.put("xiangxiqingkuang", xiangxiqingkuang);
        }
        if (neirong == null || neirong.equals("")) {
            pmap.put("neirong", null);
        } else {
            pmap.put("neirong", neirong);
        }
        if (huifu == null || huifu.equals("")) {
            pmap.put("huifu", null);
        } else {
            pmap.put("huifu", huifu);
        }
        if (kahao == null || kahao.equals("")) {
            pmap.put("kahao", null);
        } else {
            pmap.put("kahao", kahao);
        }
        if (xingming == null || xingming.equals("")) {
            pmap.put("xingming", null);
        } else {
            pmap.put("xingming", xingming);
        }
        if (xingbie == null || xingbie.equals("")) {
            pmap.put("xingbie", null);
        } else {
            pmap.put("xingbie", xingbie);
        }
        if (shouji == null || shouji.equals("")) {
            pmap.put("shouji", null);
        } else {
            pmap.put("shouji", shouji);
        }

        int total = jiuliaohuishouService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jiuliaohuishou> list = jiuliaohuishouService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jiuliaohuishou/jiuliaohuishoulist";
    }

    @RequestMapping("jlhsListtp.do")
    public String jlhsListtp(@RequestParam(value = "page", required = false) String page,
                             ModelMap map, HttpSession session, Jiuliaohuishou jiuliaohuishou, String huishoudanhao, String wupinmingcheng, String caizhi, String kezhong, String shuliang1, String shuliang2, String tupian, String xiangxiqingkuang, String neirong, String huifu, String kahao, String xingming, String xingbie, String shouji) {
        if (page == null || page.equals("")) {
            page = "1";
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), 5);
        Map<String, Object> pmap = new HashMap<String, Object>();
        pmap.put("pageno", pageBean.getStart());
        pmap.put("pageSize", 5);


        if (huishoudanhao == null || huishoudanhao.equals("")) {
            pmap.put("huishoudanhao", null);
        } else {
            pmap.put("huishoudanhao", huishoudanhao);
        }
        if (wupinmingcheng == null || wupinmingcheng.equals("")) {
            pmap.put("wupinmingcheng", null);
        } else {
            pmap.put("wupinmingcheng", wupinmingcheng);
        }
        if (caizhi == null || caizhi.equals("")) {
            pmap.put("caizhi", null);
        } else {
            pmap.put("caizhi", caizhi);
        }
        if (kezhong == null || kezhong.equals("")) {
            pmap.put("kezhong", null);
        } else {
            pmap.put("kezhong", kezhong);
        }
        if (shuliang1 == null || shuliang1.equals("")) {
            pmap.put("shuliang1", null);
        } else {
            pmap.put("shuliang1", shuliang1);
        }
        if (shuliang2 == null || shuliang2.equals("")) {
            pmap.put("shuliang2", null);
        } else {
            pmap.put("shuliang2", shuliang2);
        }
        if (tupian == null || tupian.equals("")) {
            pmap.put("tupian", null);
        } else {
            pmap.put("tupian", tupian);
        }
        if (xiangxiqingkuang == null || xiangxiqingkuang.equals("")) {
            pmap.put("xiangxiqingkuang", null);
        } else {
            pmap.put("xiangxiqingkuang", xiangxiqingkuang);
        }
        if (neirong == null || neirong.equals("")) {
            pmap.put("neirong", null);
        } else {
            pmap.put("neirong", neirong);
        }
        if (huifu == null || huifu.equals("")) {
            pmap.put("huifu", null);
        } else {
            pmap.put("huifu", huifu);
        }
        if (kahao == null || kahao.equals("")) {
            pmap.put("kahao", null);
        } else {
            pmap.put("kahao", kahao);
        }
        if (xingming == null || xingming.equals("")) {
            pmap.put("xingming", null);
        } else {
            pmap.put("xingming", xingming);
        }
        if (xingbie == null || xingbie.equals("")) {
            pmap.put("xingbie", null);
        } else {
            pmap.put("xingbie", xingbie);
        }
        if (shouji == null || shouji.equals("")) {
            pmap.put("shouji", null);
        } else {
            pmap.put("shouji", shouji);
        }

        int total = jiuliaohuishouService.getCount(pmap);
        pageBean.setTotal(total);
        List<Jiuliaohuishou> list = jiuliaohuishouService.getByPage(pmap);
        map.put("page", pageBean);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "jiuliaohuishou/jiuliaohuishoulisttp";
    }

    @RequestMapping("deleteJiuliaohuishou.do")
    public String deleteJiuliaohuishou(int id, HttpServletRequest request) {
        jiuliaohuishouService.delete(id);
        String url = request.getHeader("Referer");
        return "redirect:" + url;
        //return "redirect:jiuliaohuishouList.do";
    }


}

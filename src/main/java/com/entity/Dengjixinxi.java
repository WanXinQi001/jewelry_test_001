package com.entity;

public class Dengjixinxi {
    private Integer id;
    private String huiyuandengji;
    private String zhekou;
    private String zhekoujiage;
    private String beizhu;

    private String addtime;



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getHuiyuandengji() {
        return huiyuandengji;
    }
    public void setHuiyuandengji(String huiyuandengji) {
        this.huiyuandengji = huiyuandengji == null ? null : huiyuandengji.trim();
    }
    public String getZhekou() {
        return zhekou;
    }
    public void setZhekou(String zhekou) {
        this.zhekou = zhekou == null ? null : zhekou.trim();
    }
    public String getZhekoujiage() {
        return zhekoujiage;
    }
    public void setZhekoujiage(String zhekoujiage) {
        this.zhekoujiage = zhekoujiage == null ? null : zhekoujiage.trim();
    }
    public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }



    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息

package com.entity;

public class Jinejisuan {
    private Integer id;
    private String xiaoshoudanhao;
    private String zongjiage;
    private String kahao;
    private String xingming;
    private String xiaofeijine;

    private String addtime;



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getXiaoshoudanhao() {
        return xiaoshoudanhao;
    }
    public void setXiaoshoudanhao(String xiaoshoudanhao) {
        this.xiaoshoudanhao = xiaoshoudanhao == null ? null : xiaoshoudanhao.trim();
    }
    public String getZongjiage() {
        return zongjiage;
    }
    public void setZongjiage(String zongjiage) {
        this.zongjiage = zongjiage == null ? null : zongjiage.trim();
    }
    public String getKahao() {
        return kahao;
    }
    public void setKahao(String kahao) {
        this.kahao = kahao == null ? null : kahao.trim();
    }
    public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }
    public String getXiaofeijine() {
        return xiaofeijine;
    }
    public void setXiaofeijine(String xiaofeijine) {
        this.xiaofeijine = xiaofeijine == null ? null : xiaofeijine.trim();
    }



    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息

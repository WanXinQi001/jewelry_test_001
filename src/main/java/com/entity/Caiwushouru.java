package com.entity;

public class Caiwushouru {
    private Integer id;
    private String bianhao;
    private String mingcheng;
    private String xiaoshoushouru;
    private String zhengfubutie;
    private String qitashouru;
    private String zongshouru;
    private String riqi;

    private String addtime;



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getBianhao() {
        return bianhao;
    }
    public void setBianhao(String bianhao) {
        this.bianhao = bianhao == null ? null : bianhao.trim();
    }
    public String getMingcheng() {
        return mingcheng;
    }
    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng == null ? null : mingcheng.trim();
    }
    public String getXiaoshoushouru() {
        return xiaoshoushouru;
    }
    public void setXiaoshoushouru(String xiaoshoushouru) {
        this.xiaoshoushouru = xiaoshoushouru == null ? null : xiaoshoushouru.trim();
    }
    public String getZhengfubutie() {
        return zhengfubutie;
    }
    public void setZhengfubutie(String zhengfubutie) {
        this.zhengfubutie = zhengfubutie == null ? null : zhengfubutie.trim();
    }
    public String getQitashouru() {
        return qitashouru;
    }
    public void setQitashouru(String qitashouru) {
        this.qitashouru = qitashouru == null ? null : qitashouru.trim();
    }
    public String getZongshouru() {
        return zongshouru;
    }
    public void setZongshouru(String zongshouru) {
        this.zongshouru = zongshouru == null ? null : zongshouru.trim();
    }
    public String getRiqi() {
        return riqi;
    }
    public void setRiqi(String riqi) {
        this.riqi = riqi == null ? null : riqi.trim();
    }



    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息

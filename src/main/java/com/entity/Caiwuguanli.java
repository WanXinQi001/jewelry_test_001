package com.entity;

public class Caiwuguanli {
    private Integer id;
    private String bianhao;
    private String mingcheng;
    private String zongshouru;
    private String zongzhichu;
    private String zonglirun;
    private String faburiqi;
    private String faburen;

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
    public String getZongshouru() {
        return zongshouru;
    }
    public void setZongshouru(String zongshouru) {
        this.zongshouru = zongshouru == null ? null : zongshouru.trim();
    }
    public String getZongzhichu() {
        return zongzhichu;
    }
    public void setZongzhichu(String zongzhichu) {
        this.zongzhichu = zongzhichu == null ? null : zongzhichu.trim();
    }
    public String getZonglirun() {
        return zonglirun;
    }
    public void setZonglirun(String zonglirun) {
        this.zonglirun = zonglirun == null ? null : zonglirun.trim();
    }
    public String getFaburiqi() {
        return faburiqi;
    }
    public void setFaburiqi(String faburiqi) {
        this.faburiqi = faburiqi == null ? null : faburiqi.trim();
    }
    public String getFaburen() {
        return faburen;
    }
    public void setFaburen(String faburen) {
        this.faburen = faburen == null ? null : faburen.trim();
    }



    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息

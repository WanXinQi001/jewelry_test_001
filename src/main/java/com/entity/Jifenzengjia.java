package com.entity;

public class Jifenzengjia {
    private Integer id;
    private String xiaoshoudanhao;
    private String huodejifen;
    private String kahao;
    private String xingming;
    private String jifen;

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
    public String getHuodejifen() {
        return huodejifen;
    }
    public void setHuodejifen(String huodejifen) {
        this.huodejifen = huodejifen == null ? null : huodejifen.trim();
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
    public String getJifen() {
        return jifen;
    }
    public void setJifen(String jifen) {
        this.jifen = jifen == null ? null : jifen.trim();
    }



    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息

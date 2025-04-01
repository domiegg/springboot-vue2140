package com.entity;

public class Gongwenxinxi {
    private Integer id;
	private String gongwenbianhao;
	private String gongwenbiaoti;
	private String zhaiyao;
	private String zhengwen;
	private String laiwendanwei;
	private String shouwenriqi;
	private String fujian;
	private String tianjiaren;
	private String issh;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getGongwenbianhao() {
        return gongwenbianhao;
    }
    public void setGongwenbianhao(String gongwenbianhao) {
        this.gongwenbianhao = gongwenbianhao == null ? null : gongwenbianhao.trim();
    }
	public String getGongwenbiaoti() {
        return gongwenbiaoti;
    }
    public void setGongwenbiaoti(String gongwenbiaoti) {
        this.gongwenbiaoti = gongwenbiaoti == null ? null : gongwenbiaoti.trim();
    }
	public String getZhaiyao() {
        return zhaiyao;
    }
    public void setZhaiyao(String zhaiyao) {
        this.zhaiyao = zhaiyao == null ? null : zhaiyao.trim();
    }
	public String getZhengwen() {
        return zhengwen;
    }
    public void setZhengwen(String zhengwen) {
        this.zhengwen = zhengwen == null ? null : zhengwen.trim();
    }
	public String getLaiwendanwei() {
        return laiwendanwei;
    }
    public void setLaiwendanwei(String laiwendanwei) {
        this.laiwendanwei = laiwendanwei == null ? null : laiwendanwei.trim();
    }
	public String getShouwenriqi() {
        return shouwenriqi;
    }
    public void setShouwenriqi(String shouwenriqi) {
        this.shouwenriqi = shouwenriqi == null ? null : shouwenriqi.trim();
    }
	public String getFujian() {
        return fujian;
    }
    public void setFujian(String fujian) {
        this.fujian = fujian == null ? null : fujian.trim();
    }
	public String gettianjiaren() {
        return tianjiaren;
    }
    public void settianjiaren(String tianjiaren) {
        this.tianjiaren = tianjiaren == null ? null : tianjiaren.trim();
    }
	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息

package com.entity;

public class Zoufangxinxi {
    private Integer id;
	private String biaoti;	private String shijian;	private String didian;	private String zoufangrenyuan;	private String xiangqing;	private String faburen;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBiaoti() {
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti == null ? null : biaoti.trim();
    }	public String getShijian() {
        return shijian;
    }
    public void setShijian(String shijian) {
        this.shijian = shijian == null ? null : shijian.trim();
    }	public String getDidian() {
        return didian;
    }
    public void setDidian(String didian) {
        this.didian = didian == null ? null : didian.trim();
    }	public String getZoufangrenyuan() {
        return zoufangrenyuan;
    }
    public void setZoufangrenyuan(String zoufangrenyuan) {
        this.zoufangrenyuan = zoufangrenyuan == null ? null : zoufangrenyuan.trim();
    }	public String getXiangqing() {
        return xiangqing;
    }
    public void setXiangqing(String xiangqing) {
        this.xiangqing = xiangqing == null ? null : xiangqing.trim();
    }	public String getFaburen() {
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

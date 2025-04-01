package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Weiquanxinxi;

public interface WeiquanxinxiServer {

  public int add(Weiquanxinxi po);

  public int update(Weiquanxinxi po);
  
  public int updatelb(Weiquanxinxi po);
  
  public int delete(int id);

  public List<Weiquanxinxi> getAll(Map<String,Object> map);
  public List<Weiquanxinxi> getsyweiquanxinxi1(Map<String,Object> map);
  public List<Weiquanxinxi> getsyweiquanxinxi2(Map<String,Object> map);
  public List<Weiquanxinxi> getsyweiquanxinxi3(Map<String,Object> map);
  public Weiquanxinxi quchongWeiquanxinxi(Map<String, Object> acount);

  public Weiquanxinxi getById( int id);

  public List<Weiquanxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Weiquanxinxi> select(Map<String, Object> map);
}
//	所有List

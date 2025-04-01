package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Gongwenxinxi;

public interface GongwenxinxiServer {

  public int add(Gongwenxinxi po);

  public int update(Gongwenxinxi po);
  
  
  
  public int delete(int id);

  public List<Gongwenxinxi> getAll(Map<String,Object> map);
  public List<Gongwenxinxi> getsygongwenxinxi1(Map<String,Object> map);
  public List<Gongwenxinxi> getsygongwenxinxi2(Map<String,Object> map);
  public List<Gongwenxinxi> getsygongwenxinxi3(Map<String,Object> map);
  public Gongwenxinxi quchongGongwenxinxi(Map<String, Object> acount);

  public Gongwenxinxi getById( int id);

  public List<Gongwenxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Gongwenxinxi> select(Map<String, Object> map);
}
//	所有List

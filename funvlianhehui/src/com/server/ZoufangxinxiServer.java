package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zoufangxinxi;

public interface ZoufangxinxiServer {

  public int add(Zoufangxinxi po);

  public int update(Zoufangxinxi po);
  
  
  
  public int delete(int id);

  public List<Zoufangxinxi> getAll(Map<String,Object> map);
  public List<Zoufangxinxi> getsyzoufangxinxi1(Map<String,Object> map);
  public List<Zoufangxinxi> getsyzoufangxinxi2(Map<String,Object> map);
  public List<Zoufangxinxi> getsyzoufangxinxi3(Map<String,Object> map);
  public Zoufangxinxi quchongZoufangxinxi(Map<String, Object> acount);

  public Zoufangxinxi getById( int id);

  public List<Zoufangxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zoufangxinxi> select(Map<String, Object> map);
}
//	所有List

package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zoufangxinxi;

public interface ZoufangxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zoufangxinxi record);

    int insertSelective(Zoufangxinxi record);

    Zoufangxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zoufangxinxi record);
	
    int updateByPrimaryKey(Zoufangxinxi record);
	public Zoufangxinxi quchongZoufangxinxi(Map<String, Object> faburen);
	public List<Zoufangxinxi> getAll(Map<String, Object> map);
	public List<Zoufangxinxi> getsyzoufangxinxi1(Map<String, Object> map);
	public List<Zoufangxinxi> getsyzoufangxinxi3(Map<String, Object> map);
	public List<Zoufangxinxi> getsyzoufangxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zoufangxinxi> getByPage(Map<String, Object> map);
	public List<Zoufangxinxi> select(Map<String, Object> map);
//	所有List
}


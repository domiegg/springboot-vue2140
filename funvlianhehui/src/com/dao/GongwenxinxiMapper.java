package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Gongwenxinxi;

public interface GongwenxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gongwenxinxi record);

    int insertSelective(Gongwenxinxi record);

    Gongwenxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gongwenxinxi record);
	
    int updateByPrimaryKey(Gongwenxinxi record);
	public Gongwenxinxi quchongGongwenxinxi(Map<String, Object> tianjiaren);
	public List<Gongwenxinxi> getAll(Map<String, Object> map);
	public List<Gongwenxinxi> getsygongwenxinxi1(Map<String, Object> map);
	public List<Gongwenxinxi> getsygongwenxinxi3(Map<String, Object> map);
	public List<Gongwenxinxi> getsygongwenxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Gongwenxinxi> getByPage(Map<String, Object> map);
	public List<Gongwenxinxi> select(Map<String, Object> map);
//	所有List
}


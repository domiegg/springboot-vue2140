package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Weiquanxinxi;

public interface WeiquanxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Weiquanxinxi record);

    int insertSelective(Weiquanxinxi record);

    Weiquanxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Weiquanxinxi record);
	int updateByPrimaryKeySelectivelb(Weiquanxinxi record);
    int updateByPrimaryKey(Weiquanxinxi record);
	public Weiquanxinxi quchongWeiquanxinxi(Map<String, Object> tianjiaren);
	public List<Weiquanxinxi> getAll(Map<String, Object> map);
	public List<Weiquanxinxi> getsyweiquanxinxi1(Map<String, Object> map);
	public List<Weiquanxinxi> getsyweiquanxinxi3(Map<String, Object> map);
	public List<Weiquanxinxi> getsyweiquanxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Weiquanxinxi> getByPage(Map<String, Object> map);
	public List<Weiquanxinxi> select(Map<String, Object> map);
//	所有List
}


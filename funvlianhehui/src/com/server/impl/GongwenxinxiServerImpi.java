package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GongwenxinxiMapper;
import com.entity.Gongwenxinxi;
import com.server.GongwenxinxiServer;
@Service
public class GongwenxinxiServerImpi implements GongwenxinxiServer {
   @Resource
   private GongwenxinxiMapper gdao;
	@Override
	public int add(Gongwenxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Gongwenxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Gongwenxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Gongwenxinxi> getsygongwenxinxi1(Map<String, Object> map) {
		return gdao.getsygongwenxinxi1(map);
	}
	public List<Gongwenxinxi> getsygongwenxinxi2(Map<String, Object> map) {
		return gdao.getsygongwenxinxi2(map);
	}
	public List<Gongwenxinxi> getsygongwenxinxi3(Map<String, Object> map) {
		return gdao.getsygongwenxinxi3(map);
	}
	
	@Override
	public Gongwenxinxi quchongGongwenxinxi(Map<String, Object> account) {
		return gdao.quchongGongwenxinxi(account);
	}

	@Override
	public List<Gongwenxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Gongwenxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Gongwenxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


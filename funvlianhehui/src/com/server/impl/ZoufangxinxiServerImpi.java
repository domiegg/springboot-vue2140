package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZoufangxinxiMapper;
import com.entity.Zoufangxinxi;
import com.server.ZoufangxinxiServer;
@Service
public class ZoufangxinxiServerImpi implements ZoufangxinxiServer {
   @Resource
   private ZoufangxinxiMapper gdao;
	@Override
	public int add(Zoufangxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zoufangxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zoufangxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zoufangxinxi> getsyzoufangxinxi1(Map<String, Object> map) {
		return gdao.getsyzoufangxinxi1(map);
	}
	public List<Zoufangxinxi> getsyzoufangxinxi2(Map<String, Object> map) {
		return gdao.getsyzoufangxinxi2(map);
	}
	public List<Zoufangxinxi> getsyzoufangxinxi3(Map<String, Object> map) {
		return gdao.getsyzoufangxinxi3(map);
	}
	
	@Override
	public Zoufangxinxi quchongZoufangxinxi(Map<String, Object> account) {
		return gdao.quchongZoufangxinxi(account);
	}

	@Override
	public List<Zoufangxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zoufangxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zoufangxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.WeiquanxinxiMapper;
import com.entity.Weiquanxinxi;
import com.server.WeiquanxinxiServer;
@Service
public class WeiquanxinxiServerImpi implements WeiquanxinxiServer {
   @Resource
   private WeiquanxinxiMapper gdao;
	@Override
	public int add(Weiquanxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Weiquanxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Weiquanxinxi po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Weiquanxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Weiquanxinxi> getsyweiquanxinxi1(Map<String, Object> map) {
		return gdao.getsyweiquanxinxi1(map);
	}
	public List<Weiquanxinxi> getsyweiquanxinxi2(Map<String, Object> map) {
		return gdao.getsyweiquanxinxi2(map);
	}
	public List<Weiquanxinxi> getsyweiquanxinxi3(Map<String, Object> map) {
		return gdao.getsyweiquanxinxi3(map);
	}
	
	@Override
	public Weiquanxinxi quchongWeiquanxinxi(Map<String, Object> account) {
		return gdao.quchongWeiquanxinxi(account);
	}

	@Override
	public List<Weiquanxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Weiquanxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Weiquanxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


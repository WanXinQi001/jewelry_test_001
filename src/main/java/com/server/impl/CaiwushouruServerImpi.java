package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CaiwushouruMapper;
import com.entity.Caiwushouru;
import com.server.CaiwushouruServer;
@Service
public class CaiwushouruServerImpi implements CaiwushouruServer {
   @Resource
   private CaiwushouruMapper gdao;
	@Override
	public int add(Caiwushouru po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Caiwushouru po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Caiwushouru> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Caiwushouru> getsycaiwushouru1(Map<String, Object> map) {
		return gdao.getsycaiwushouru1(map);
	}
	public List<Caiwushouru> getsycaiwushouru2(Map<String, Object> map) {
		return gdao.getsycaiwushouru2(map);
	}
	public List<Caiwushouru> getsycaiwushouru3(Map<String, Object> map) {
		return gdao.getsycaiwushouru3(map);
	}
	
	@Override
	public Caiwushouru quchongCaiwushouru(Map<String, Object> account) {
		return gdao.quchongCaiwushouru(account);
	}

	@Override
	public List<Caiwushouru> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Caiwushouru> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Caiwushouru getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


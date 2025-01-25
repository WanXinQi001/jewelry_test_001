package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CaiwuzhichuMapper;
import com.entity.Caiwuzhichu;
import com.server.CaiwuzhichuServer;
@Service
public class CaiwuzhichuServerImpi implements CaiwuzhichuServer {
   @Resource
   private CaiwuzhichuMapper gdao;
	@Override
	public int add(Caiwuzhichu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Caiwuzhichu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Caiwuzhichu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Caiwuzhichu> getsycaiwuzhichu1(Map<String, Object> map) {
		return gdao.getsycaiwuzhichu1(map);
	}
	public List<Caiwuzhichu> getsycaiwuzhichu2(Map<String, Object> map) {
		return gdao.getsycaiwuzhichu2(map);
	}
	public List<Caiwuzhichu> getsycaiwuzhichu3(Map<String, Object> map) {
		return gdao.getsycaiwuzhichu3(map);
	}
	
	@Override
	public Caiwuzhichu quchongCaiwuzhichu(Map<String, Object> account) {
		return gdao.quchongCaiwuzhichu(account);
	}

	@Override
	public List<Caiwuzhichu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Caiwuzhichu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Caiwuzhichu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


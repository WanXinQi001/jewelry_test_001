package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JifenzengjiaMapper;
import com.entity.Jifenzengjia;
import com.server.JifenzengjiaServer;
@Service
public class JifenzengjiaServerImpi implements JifenzengjiaServer {
   @Resource
   private JifenzengjiaMapper gdao;
	@Override
	public int add(Jifenzengjia po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jifenzengjia po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jifenzengjia> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jifenzengjia> getsyjifenzengjia1(Map<String, Object> map) {
		return gdao.getsyjifenzengjia1(map);
	}
	public List<Jifenzengjia> getsyjifenzengjia2(Map<String, Object> map) {
		return gdao.getsyjifenzengjia2(map);
	}
	public List<Jifenzengjia> getsyjifenzengjia3(Map<String, Object> map) {
		return gdao.getsyjifenzengjia3(map);
	}
	
	@Override
	public Jifenzengjia quchongJifenzengjia(Map<String, Object> account) {
		return gdao.quchongJifenzengjia(account);
	}

	@Override
	public List<Jifenzengjia> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jifenzengjia> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jifenzengjia getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


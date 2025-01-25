package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GongzixinxiMapper;
import com.entity.Gongzixinxi;
import com.server.GongzixinxiServer;
@Service
public class GongzixinxiServerImpi implements GongzixinxiServer {
   @Resource
   private GongzixinxiMapper gdao;
	@Override
	public int add(Gongzixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Gongzixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Gongzixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Gongzixinxi> getsygongzixinxi1(Map<String, Object> map) {
		return gdao.getsygongzixinxi1(map);
	}
	public List<Gongzixinxi> getsygongzixinxi2(Map<String, Object> map) {
		return gdao.getsygongzixinxi2(map);
	}
	public List<Gongzixinxi> getsygongzixinxi3(Map<String, Object> map) {
		return gdao.getsygongzixinxi3(map);
	}
	
	@Override
	public Gongzixinxi quchongGongzixinxi(Map<String, Object> account) {
		return gdao.quchongGongzixinxi(account);
	}

	@Override
	public List<Gongzixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Gongzixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Gongzixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


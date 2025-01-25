package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DengjixinxiMapper;
import com.entity.Dengjixinxi;
import com.server.DengjixinxiServer;
@Service
public class DengjixinxiServerImpi implements DengjixinxiServer {
   @Resource
   private DengjixinxiMapper gdao;
	@Override
	public int add(Dengjixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Dengjixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Dengjixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Dengjixinxi> getsydengjixinxi1(Map<String, Object> map) {
		return gdao.getsydengjixinxi1(map);
	}
	public List<Dengjixinxi> getsydengjixinxi2(Map<String, Object> map) {
		return gdao.getsydengjixinxi2(map);
	}
	public List<Dengjixinxi> getsydengjixinxi3(Map<String, Object> map) {
		return gdao.getsydengjixinxi3(map);
	}
	
	@Override
	public Dengjixinxi quchongDengjixinxi(Map<String, Object> account) {
		return gdao.quchongDengjixinxi(account);
	}

	@Override
	public List<Dengjixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Dengjixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Dengjixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


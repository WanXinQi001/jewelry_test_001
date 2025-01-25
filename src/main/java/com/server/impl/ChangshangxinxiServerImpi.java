package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ChangshangxinxiMapper;
import com.entity.Changshangxinxi;
import com.server.ChangshangxinxiServer;
@Service
public class ChangshangxinxiServerImpi implements ChangshangxinxiServer {
   @Resource
   private ChangshangxinxiMapper gdao;
	@Override
	public int add(Changshangxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Changshangxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Changshangxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Changshangxinxi> getsychangshangxinxi1(Map<String, Object> map) {
		return gdao.getsychangshangxinxi1(map);
	}
	public List<Changshangxinxi> getsychangshangxinxi2(Map<String, Object> map) {
		return gdao.getsychangshangxinxi2(map);
	}
	public List<Changshangxinxi> getsychangshangxinxi3(Map<String, Object> map) {
		return gdao.getsychangshangxinxi3(map);
	}
	
	@Override
	public Changshangxinxi quchongChangshangxinxi(Map<String, Object> account) {
		return gdao.quchongChangshangxinxi(account);
	}

	@Override
	public List<Changshangxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Changshangxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Changshangxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


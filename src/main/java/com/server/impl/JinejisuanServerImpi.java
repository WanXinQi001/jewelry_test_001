package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JinejisuanMapper;
import com.entity.Jinejisuan;
import com.server.JinejisuanServer;
@Service
public class JinejisuanServerImpi implements JinejisuanServer {
   @Resource
   private JinejisuanMapper gdao;
	@Override
	public int add(Jinejisuan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jinejisuan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jinejisuan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jinejisuan> getsyjinejisuan1(Map<String, Object> map) {
		return gdao.getsyjinejisuan1(map);
	}
	public List<Jinejisuan> getsyjinejisuan2(Map<String, Object> map) {
		return gdao.getsyjinejisuan2(map);
	}
	public List<Jinejisuan> getsyjinejisuan3(Map<String, Object> map) {
		return gdao.getsyjinejisuan3(map);
	}
	
	@Override
	public Jinejisuan quchongJinejisuan(Map<String, Object> account) {
		return gdao.quchongJinejisuan(account);
	}

	@Override
	public List<Jinejisuan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jinejisuan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jinejisuan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


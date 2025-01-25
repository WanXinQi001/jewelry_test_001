package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JiuliaohuishouMapper;
import com.entity.Jiuliaohuishou;
import com.server.JiuliaohuishouServer;
@Service
public class JiuliaohuishouServerImpi implements JiuliaohuishouServer {
   @Resource
   private JiuliaohuishouMapper gdao;
	@Override
	public int add(Jiuliaohuishou po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jiuliaohuishou po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Jiuliaohuishou po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jiuliaohuishou> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jiuliaohuishou> getsyjiuliaohuishou1(Map<String, Object> map) {
		return gdao.getsyjiuliaohuishou1(map);
	}
	public List<Jiuliaohuishou> getsyjiuliaohuishou2(Map<String, Object> map) {
		return gdao.getsyjiuliaohuishou2(map);
	}
	public List<Jiuliaohuishou> getsyjiuliaohuishou3(Map<String, Object> map) {
		return gdao.getsyjiuliaohuishou3(map);
	}
	
	@Override
	public Jiuliaohuishou quchongJiuliaohuishou(Map<String, Object> account) {
		return gdao.quchongJiuliaohuishou(account);
	}

	@Override
	public List<Jiuliaohuishou> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jiuliaohuishou> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jiuliaohuishou getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


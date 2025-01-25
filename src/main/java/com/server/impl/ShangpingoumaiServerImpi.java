package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShangpingoumaiMapper;
import com.entity.Shangpingoumai;
import com.server.ShangpingoumaiServer;
@Service
public class ShangpingoumaiServerImpi implements ShangpingoumaiServer {
   @Resource
   private ShangpingoumaiMapper gdao;
	@Override
	public int add(Shangpingoumai po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shangpingoumai po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shangpingoumai> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shangpingoumai> getsyshangpingoumai1(Map<String, Object> map) {
		return gdao.getsyshangpingoumai1(map);
	}
	public List<Shangpingoumai> getsyshangpingoumai2(Map<String, Object> map) {
		return gdao.getsyshangpingoumai2(map);
	}
	public List<Shangpingoumai> getsyshangpingoumai3(Map<String, Object> map) {
		return gdao.getsyshangpingoumai3(map);
	}
	
	@Override
	public Shangpingoumai quchongShangpingoumai(Map<String, Object> account) {
		return gdao.quchongShangpingoumai(account);
	}

	@Override
	public List<Shangpingoumai> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shangpingoumai> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shangpingoumai getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


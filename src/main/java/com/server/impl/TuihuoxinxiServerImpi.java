package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TuihuoxinxiMapper;
import com.entity.Tuihuoxinxi;
import com.server.TuihuoxinxiServer;
@Service
public class TuihuoxinxiServerImpi implements TuihuoxinxiServer {
   @Resource
   private TuihuoxinxiMapper gdao;
	@Override
	public int add(Tuihuoxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Tuihuoxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Tuihuoxinxi po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Tuihuoxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Tuihuoxinxi> getsytuihuoxinxi1(Map<String, Object> map) {
		return gdao.getsytuihuoxinxi1(map);
	}
	public List<Tuihuoxinxi> getsytuihuoxinxi2(Map<String, Object> map) {
		return gdao.getsytuihuoxinxi2(map);
	}
	public List<Tuihuoxinxi> getsytuihuoxinxi3(Map<String, Object> map) {
		return gdao.getsytuihuoxinxi3(map);
	}
	
	@Override
	public Tuihuoxinxi quchongTuihuoxinxi(Map<String, Object> account) {
		return gdao.quchongTuihuoxinxi(account);
	}

	@Override
	public List<Tuihuoxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Tuihuoxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Tuihuoxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


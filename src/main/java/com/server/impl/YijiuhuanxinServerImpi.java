package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YijiuhuanxinMapper;
import com.entity.Yijiuhuanxin;
import com.server.YijiuhuanxinServer;
@Service
public class YijiuhuanxinServerImpi implements YijiuhuanxinServer {
   @Resource
   private YijiuhuanxinMapper gdao;
	@Override
	public int add(Yijiuhuanxin po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yijiuhuanxin po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Yijiuhuanxin po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yijiuhuanxin> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yijiuhuanxin> getsyyijiuhuanxin1(Map<String, Object> map) {
		return gdao.getsyyijiuhuanxin1(map);
	}
	public List<Yijiuhuanxin> getsyyijiuhuanxin2(Map<String, Object> map) {
		return gdao.getsyyijiuhuanxin2(map);
	}
	public List<Yijiuhuanxin> getsyyijiuhuanxin3(Map<String, Object> map) {
		return gdao.getsyyijiuhuanxin3(map);
	}
	
	@Override
	public Yijiuhuanxin quchongYijiuhuanxin(Map<String, Object> account) {
		return gdao.quchongYijiuhuanxin(account);
	}

	@Override
	public List<Yijiuhuanxin> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yijiuhuanxin> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yijiuhuanxin getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Caiwushouru;

public interface CaiwushouruMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Caiwushouru record);

    int insertSelective(Caiwushouru record);

    Caiwushouru selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Caiwushouru record);
	
    int updateByPrimaryKey(Caiwushouru record);
	public Caiwushouru quchongCaiwushouru(Map<String, Object> bianhao);
	public List<Caiwushouru> getAll(Map<String, Object> map);
	public List<Caiwushouru> getsycaiwushouru1(Map<String, Object> map);
	public List<Caiwushouru> getsycaiwushouru3(Map<String, Object> map);
	public List<Caiwushouru> getsycaiwushouru2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Caiwushouru> getByPage(Map<String, Object> map);
	public List<Caiwushouru> select(Map<String, Object> map);
//	所有List
}


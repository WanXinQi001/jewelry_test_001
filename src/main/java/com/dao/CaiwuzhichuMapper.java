package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Caiwuzhichu;

public interface CaiwuzhichuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Caiwuzhichu record);

    int insertSelective(Caiwuzhichu record);

    Caiwuzhichu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Caiwuzhichu record);
	
    int updateByPrimaryKey(Caiwuzhichu record);
	public Caiwuzhichu quchongCaiwuzhichu(Map<String, Object> bianhao);
	public List<Caiwuzhichu> getAll(Map<String, Object> map);
	public List<Caiwuzhichu> getsycaiwuzhichu1(Map<String, Object> map);
	public List<Caiwuzhichu> getsycaiwuzhichu3(Map<String, Object> map);
	public List<Caiwuzhichu> getsycaiwuzhichu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Caiwuzhichu> getByPage(Map<String, Object> map);
	public List<Caiwuzhichu> select(Map<String, Object> map);
//	所有List
}


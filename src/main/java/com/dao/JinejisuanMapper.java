package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jinejisuan;

public interface JinejisuanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jinejisuan record);

    int insertSelective(Jinejisuan record);

    Jinejisuan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jinejisuan record);
	
    int updateByPrimaryKey(Jinejisuan record);
	public Jinejisuan quchongJinejisuan(Map<String, Object> xiaoshoudanhao);
	public List<Jinejisuan> getAll(Map<String, Object> map);
	public List<Jinejisuan> getsyjinejisuan1(Map<String, Object> map);
	public List<Jinejisuan> getsyjinejisuan3(Map<String, Object> map);
	public List<Jinejisuan> getsyjinejisuan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jinejisuan> getByPage(Map<String, Object> map);
	public List<Jinejisuan> select(Map<String, Object> map);
//	所有List
}


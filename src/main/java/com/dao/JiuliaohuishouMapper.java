package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jiuliaohuishou;

public interface JiuliaohuishouMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiuliaohuishou record);

    int insertSelective(Jiuliaohuishou record);

    Jiuliaohuishou selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jiuliaohuishou record);
	int updateByPrimaryKeySelectivelb(Jiuliaohuishou record);
    int updateByPrimaryKey(Jiuliaohuishou record);
	public Jiuliaohuishou quchongJiuliaohuishou(Map<String, Object> kahao);
	public List<Jiuliaohuishou> getAll(Map<String, Object> map);
	public List<Jiuliaohuishou> getsyjiuliaohuishou1(Map<String, Object> map);
	public List<Jiuliaohuishou> getsyjiuliaohuishou3(Map<String, Object> map);
	public List<Jiuliaohuishou> getsyjiuliaohuishou2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jiuliaohuishou> getByPage(Map<String, Object> map);
	public List<Jiuliaohuishou> select(Map<String, Object> map);
//	所有List
}


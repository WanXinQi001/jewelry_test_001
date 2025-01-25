package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shangpingoumai;

public interface ShangpingoumaiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shangpingoumai record);

    int insertSelective(Shangpingoumai record);

    Shangpingoumai selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shangpingoumai record);
	
    int updateByPrimaryKey(Shangpingoumai record);
	public Shangpingoumai quchongShangpingoumai(Map<String, Object> kahao);
	public List<Shangpingoumai> getAll(Map<String, Object> map);
	public List<Shangpingoumai> getsyshangpingoumai1(Map<String, Object> map);
	public List<Shangpingoumai> getsyshangpingoumai3(Map<String, Object> map);
	public List<Shangpingoumai> getsyshangpingoumai2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shangpingoumai> getByPage(Map<String, Object> map);
	public List<Shangpingoumai> select(Map<String, Object> map);
//	所有List
}


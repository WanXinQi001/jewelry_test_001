package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Changshangxinxi;

public interface ChangshangxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Changshangxinxi record);

    int insertSelective(Changshangxinxi record);

    Changshangxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Changshangxinxi record);
	
    int updateByPrimaryKey(Changshangxinxi record);
	public Changshangxinxi quchongChangshangxinxi(Map<String, Object> zhanghao);
	public List<Changshangxinxi> getAll(Map<String, Object> map);
	public List<Changshangxinxi> getsychangshangxinxi1(Map<String, Object> map);
	public List<Changshangxinxi> getsychangshangxinxi3(Map<String, Object> map);
	public List<Changshangxinxi> getsychangshangxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Changshangxinxi> getByPage(Map<String, Object> map);
	public List<Changshangxinxi> select(Map<String, Object> map);
//	所有List
}


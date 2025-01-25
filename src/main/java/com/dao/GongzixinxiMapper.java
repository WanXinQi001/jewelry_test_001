package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Gongzixinxi;

public interface GongzixinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gongzixinxi record);

    int insertSelective(Gongzixinxi record);

    Gongzixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gongzixinxi record);
	
    int updateByPrimaryKey(Gongzixinxi record);
	public Gongzixinxi quchongGongzixinxi(Map<String, Object> bianhao);
	public List<Gongzixinxi> getAll(Map<String, Object> map);
	public List<Gongzixinxi> getsygongzixinxi1(Map<String, Object> map);
	public List<Gongzixinxi> getsygongzixinxi3(Map<String, Object> map);
	public List<Gongzixinxi> getsygongzixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Gongzixinxi> getByPage(Map<String, Object> map);
	public List<Gongzixinxi> select(Map<String, Object> map);
//	所有List
}


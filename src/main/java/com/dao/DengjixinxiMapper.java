package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Dengjixinxi;

public interface DengjixinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dengjixinxi record);

    int insertSelective(Dengjixinxi record);

    Dengjixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dengjixinxi record);
	
    int updateByPrimaryKey(Dengjixinxi record);
	public Dengjixinxi quchongDengjixinxi(Map<String, Object> huiyuandengji);
	public List<Dengjixinxi> getAll(Map<String, Object> map);
	public List<Dengjixinxi> getsydengjixinxi1(Map<String, Object> map);
	public List<Dengjixinxi> getsydengjixinxi3(Map<String, Object> map);
	public List<Dengjixinxi> getsydengjixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Dengjixinxi> getByPage(Map<String, Object> map);
	public List<Dengjixinxi> select(Map<String, Object> map);
//	所有List
}


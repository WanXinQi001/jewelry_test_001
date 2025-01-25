package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Tuihuoxinxi;

public interface TuihuoxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tuihuoxinxi record);

    int insertSelective(Tuihuoxinxi record);

    Tuihuoxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tuihuoxinxi record);
	int updateByPrimaryKeySelectivelb(Tuihuoxinxi record);
    int updateByPrimaryKey(Tuihuoxinxi record);
	public Tuihuoxinxi quchongTuihuoxinxi(Map<String, Object> kahao);
	public List<Tuihuoxinxi> getAll(Map<String, Object> map);
	public List<Tuihuoxinxi> getsytuihuoxinxi1(Map<String, Object> map);
	public List<Tuihuoxinxi> getsytuihuoxinxi3(Map<String, Object> map);
	public List<Tuihuoxinxi> getsytuihuoxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Tuihuoxinxi> getByPage(Map<String, Object> map);
	public List<Tuihuoxinxi> select(Map<String, Object> map);
//	所有List
}


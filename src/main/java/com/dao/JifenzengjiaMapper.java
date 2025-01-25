package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jifenzengjia;

public interface JifenzengjiaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jifenzengjia record);

    int insertSelective(Jifenzengjia record);

    Jifenzengjia selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jifenzengjia record);
	
    int updateByPrimaryKey(Jifenzengjia record);
	public Jifenzengjia quchongJifenzengjia(Map<String, Object> kahao);
	public List<Jifenzengjia> getAll(Map<String, Object> map);
	public List<Jifenzengjia> getsyjifenzengjia1(Map<String, Object> map);
	public List<Jifenzengjia> getsyjifenzengjia3(Map<String, Object> map);
	public List<Jifenzengjia> getsyjifenzengjia2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jifenzengjia> getByPage(Map<String, Object> map);
	public List<Jifenzengjia> select(Map<String, Object> map);
//	所有List
}


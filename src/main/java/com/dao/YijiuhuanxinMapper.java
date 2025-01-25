package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yijiuhuanxin;

public interface YijiuhuanxinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yijiuhuanxin record);

    int insertSelective(Yijiuhuanxin record);

    Yijiuhuanxin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yijiuhuanxin record);
	int updateByPrimaryKeySelectivelb(Yijiuhuanxin record);
    int updateByPrimaryKey(Yijiuhuanxin record);
	public Yijiuhuanxin quchongYijiuhuanxin(Map<String, Object> kahao);
	public List<Yijiuhuanxin> getAll(Map<String, Object> map);
	public List<Yijiuhuanxin> getsyyijiuhuanxin1(Map<String, Object> map);
	public List<Yijiuhuanxin> getsyyijiuhuanxin3(Map<String, Object> map);
	public List<Yijiuhuanxin> getsyyijiuhuanxin2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yijiuhuanxin> getByPage(Map<String, Object> map);
	public List<Yijiuhuanxin> select(Map<String, Object> map);
//	所有List
}


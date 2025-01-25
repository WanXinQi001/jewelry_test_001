package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yijiuhuanxin;

public interface YijiuhuanxinServer {

  public int add(Yijiuhuanxin po);

  public int update(Yijiuhuanxin po);
  
  public int updatelb(Yijiuhuanxin po);
  
  public int delete(int id);

  public List<Yijiuhuanxin> getAll(Map<String,Object> map);
  public List<Yijiuhuanxin> getsyyijiuhuanxin1(Map<String,Object> map);
  public List<Yijiuhuanxin> getsyyijiuhuanxin2(Map<String,Object> map);
  public List<Yijiuhuanxin> getsyyijiuhuanxin3(Map<String,Object> map);
  public Yijiuhuanxin quchongYijiuhuanxin(Map<String, Object> acount);

  public Yijiuhuanxin getById( int id);

  public List<Yijiuhuanxin> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yijiuhuanxin> select(Map<String, Object> map);
}
//	所有List

package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Caiwuzhichu;

public interface CaiwuzhichuServer {

  public int add(Caiwuzhichu po);

  public int update(Caiwuzhichu po);
  
  
  
  public int delete(int id);

  public List<Caiwuzhichu> getAll(Map<String,Object> map);
  public List<Caiwuzhichu> getsycaiwuzhichu1(Map<String,Object> map);
  public List<Caiwuzhichu> getsycaiwuzhichu2(Map<String,Object> map);
  public List<Caiwuzhichu> getsycaiwuzhichu3(Map<String,Object> map);
  public Caiwuzhichu quchongCaiwuzhichu(Map<String, Object> acount);

  public Caiwuzhichu getById( int id);

  public List<Caiwuzhichu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Caiwuzhichu> select(Map<String, Object> map);
}
//	所有List

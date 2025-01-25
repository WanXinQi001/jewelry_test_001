package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Changshangxinxi;

public interface ChangshangxinxiServer {

  public int add(Changshangxinxi po);

  public int update(Changshangxinxi po);
  
  
  
  public int delete(int id);

  public List<Changshangxinxi> getAll(Map<String,Object> map);
  public List<Changshangxinxi> getsychangshangxinxi1(Map<String,Object> map);
  public List<Changshangxinxi> getsychangshangxinxi2(Map<String,Object> map);
  public List<Changshangxinxi> getsychangshangxinxi3(Map<String,Object> map);
  public Changshangxinxi quchongChangshangxinxi(Map<String, Object> acount);

  public Changshangxinxi getById( int id);

  public List<Changshangxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Changshangxinxi> select(Map<String, Object> map);
}
//	所有List

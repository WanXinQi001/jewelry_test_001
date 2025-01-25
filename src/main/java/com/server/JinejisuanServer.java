package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jinejisuan;

public interface JinejisuanServer {

  public int add(Jinejisuan po);

  public int update(Jinejisuan po);
  
  
  
  public int delete(int id);

  public List<Jinejisuan> getAll(Map<String,Object> map);
  public List<Jinejisuan> getsyjinejisuan1(Map<String,Object> map);
  public List<Jinejisuan> getsyjinejisuan2(Map<String,Object> map);
  public List<Jinejisuan> getsyjinejisuan3(Map<String,Object> map);
  public Jinejisuan quchongJinejisuan(Map<String, Object> acount);

  public Jinejisuan getById( int id);

  public List<Jinejisuan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jinejisuan> select(Map<String, Object> map);
}
//	所有List

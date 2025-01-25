package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jiuliaohuishou;

public interface JiuliaohuishouServer {

  public int add(Jiuliaohuishou po);

  public int update(Jiuliaohuishou po);
  
  public int updatelb(Jiuliaohuishou po);
  
  public int delete(int id);

  public List<Jiuliaohuishou> getAll(Map<String,Object> map);
  public List<Jiuliaohuishou> getsyjiuliaohuishou1(Map<String,Object> map);
  public List<Jiuliaohuishou> getsyjiuliaohuishou2(Map<String,Object> map);
  public List<Jiuliaohuishou> getsyjiuliaohuishou3(Map<String,Object> map);
  public Jiuliaohuishou quchongJiuliaohuishou(Map<String, Object> acount);

  public Jiuliaohuishou getById( int id);

  public List<Jiuliaohuishou> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jiuliaohuishou> select(Map<String, Object> map);
}
//	所有List

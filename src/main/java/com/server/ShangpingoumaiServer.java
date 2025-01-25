package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shangpingoumai;

public interface ShangpingoumaiServer {

  public int add(Shangpingoumai po);

  public int update(Shangpingoumai po);
  
  
  
  public int delete(int id);

  public List<Shangpingoumai> getAll(Map<String,Object> map);
  public List<Shangpingoumai> getsyshangpingoumai1(Map<String,Object> map);
  public List<Shangpingoumai> getsyshangpingoumai2(Map<String,Object> map);
  public List<Shangpingoumai> getsyshangpingoumai3(Map<String,Object> map);
  public Shangpingoumai quchongShangpingoumai(Map<String, Object> acount);

  public Shangpingoumai getById( int id);

  public List<Shangpingoumai> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shangpingoumai> select(Map<String, Object> map);
}
//	所有List

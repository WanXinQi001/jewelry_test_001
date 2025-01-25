package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jifenzengjia;

public interface JifenzengjiaServer {

  public int add(Jifenzengjia po);

  public int update(Jifenzengjia po);
  
  
  
  public int delete(int id);

  public List<Jifenzengjia> getAll(Map<String,Object> map);
  public List<Jifenzengjia> getsyjifenzengjia1(Map<String,Object> map);
  public List<Jifenzengjia> getsyjifenzengjia2(Map<String,Object> map);
  public List<Jifenzengjia> getsyjifenzengjia3(Map<String,Object> map);
  public Jifenzengjia quchongJifenzengjia(Map<String, Object> acount);

  public Jifenzengjia getById( int id);

  public List<Jifenzengjia> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jifenzengjia> select(Map<String, Object> map);
}
//	所有List

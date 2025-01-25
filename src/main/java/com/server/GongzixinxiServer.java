package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Gongzixinxi;

public interface GongzixinxiServer {

  public int add(Gongzixinxi po);

  public int update(Gongzixinxi po);
  
  
  
  public int delete(int id);

  public List<Gongzixinxi> getAll(Map<String,Object> map);
  public List<Gongzixinxi> getsygongzixinxi1(Map<String,Object> map);
  public List<Gongzixinxi> getsygongzixinxi2(Map<String,Object> map);
  public List<Gongzixinxi> getsygongzixinxi3(Map<String,Object> map);
  public Gongzixinxi quchongGongzixinxi(Map<String, Object> acount);

  public Gongzixinxi getById( int id);

  public List<Gongzixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Gongzixinxi> select(Map<String, Object> map);
}
//	所有List

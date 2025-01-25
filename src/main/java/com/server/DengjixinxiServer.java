package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Dengjixinxi;

public interface DengjixinxiServer {

  public int add(Dengjixinxi po);

  public int update(Dengjixinxi po);
  
  
  
  public int delete(int id);

  public List<Dengjixinxi> getAll(Map<String,Object> map);
  public List<Dengjixinxi> getsydengjixinxi1(Map<String,Object> map);
  public List<Dengjixinxi> getsydengjixinxi2(Map<String,Object> map);
  public List<Dengjixinxi> getsydengjixinxi3(Map<String,Object> map);
  public Dengjixinxi quchongDengjixinxi(Map<String, Object> acount);

  public Dengjixinxi getById( int id);

  public List<Dengjixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Dengjixinxi> select(Map<String, Object> map);
}
//	所有List

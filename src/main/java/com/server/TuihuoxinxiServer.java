package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Tuihuoxinxi;

public interface TuihuoxinxiServer {

  public int add(Tuihuoxinxi po);

  public int update(Tuihuoxinxi po);
  
  public int updatelb(Tuihuoxinxi po);
  
  public int delete(int id);

  public List<Tuihuoxinxi> getAll(Map<String,Object> map);
  public List<Tuihuoxinxi> getsytuihuoxinxi1(Map<String,Object> map);
  public List<Tuihuoxinxi> getsytuihuoxinxi2(Map<String,Object> map);
  public List<Tuihuoxinxi> getsytuihuoxinxi3(Map<String,Object> map);
  public Tuihuoxinxi quchongTuihuoxinxi(Map<String, Object> acount);

  public Tuihuoxinxi getById( int id);

  public List<Tuihuoxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Tuihuoxinxi> select(Map<String, Object> map);
}
//	所有List

package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Caiwushouru;

public interface CaiwushouruServer {

  public int add(Caiwushouru po);

  public int update(Caiwushouru po);
  
  
  
  public int delete(int id);

  public List<Caiwushouru> getAll(Map<String,Object> map);
  public List<Caiwushouru> getsycaiwushouru1(Map<String,Object> map);
  public List<Caiwushouru> getsycaiwushouru2(Map<String,Object> map);
  public List<Caiwushouru> getsycaiwushouru3(Map<String,Object> map);
  public Caiwushouru quchongCaiwushouru(Map<String, Object> acount);

  public Caiwushouru getById( int id);

  public List<Caiwushouru> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Caiwushouru> select(Map<String, Object> map);
}
//	所有List

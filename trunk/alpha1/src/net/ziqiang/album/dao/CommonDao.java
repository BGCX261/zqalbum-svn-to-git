package net.ziqiang.album.dao;

import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

public interface CommonDao {
	SqlMapClientTemplate sqlMapClientTemplate=null;
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate);
	public int getInt(String sqlType) throws DataAccessException;
	public int getIntByInt(int integer,String sqlType) throws DataAccessException;
	public int getIntByString(String str,String sqlType) throws DataAccessException;
	public int getIntByMap(HashMap map,String sqlType) throws DataAccessException;
	
	public String getString(String sqlType) throws DataAccessException;
	public String getStringByInt(int integer,String sqlType) throws DataAccessException;
	public String getStringByString(String str,String sqlType) throws DataAccessException;
	public String getStringByMap(HashMap map,String sqlType) throws DataAccessException;
	public String getStringByObject(Object object,String sqlType)throws DataAccessException;
	
	public Object getObject(String sqlType) throws DataAccessException;
	public Object getObjectByInt(int integer,String sqlType) throws DataAccessException;
	public Object getObjectByString(String str,String sqlType) throws DataAccessException;
	public Object getObjectByMap(HashMap map,String sqlType) throws DataAccessException;

	public List getList(String sqlType) throws DataAccessException;
	public List getListByInt(int integer,String sqlType) throws DataAccessException;
	public List getListByString(String str,String sqlType) throws DataAccessException;
	public List getListByMap(HashMap map,String sqlType) throws DataAccessException;

	public boolean insert(String sqlType);
	public boolean insertObject(Object obj,String sqlType);
	public boolean insertByInt(int integer,String sqlType);
	public boolean insertByString(String str,String sqlType);
	public boolean insertByMap(HashMap map,String sqlType);
	
	public boolean update(String sqlType);
	public boolean updateObject(Object obj,String sqlType);
	public boolean updateByInt(int integer,String sqlType);
	public boolean updateByString(String str, String sqlType);
	public boolean updateByMap(HashMap map,String sqlType);
	
	public boolean delete(String sqlType);
	public boolean deleteByInt(int integer,String sqlType);
	public boolean deleteByString(String str,String sqlType);
	public boolean deleteByMap(HashMap map,String sqlType);

}

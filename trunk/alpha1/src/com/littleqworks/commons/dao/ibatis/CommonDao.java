/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.dao.ibatis;

/*
 * iBatisͨ�÷������Ͻӿ�
 * ���ߣ�̷����
 * �汾��0.02
 * ����޸����ڣ�20071020
 * ������iBatisͨ�÷������Ͻӿڣ���������ݿ�ͨ�ò������������ʵ�ִ˽ӿڡ�
 */

import java.util.*;

/**
 * CommonDao
 * @author ̷����
 * @version 0.02
 * Last Date: 20-Oct-07
 * Description: iBatisͨ�÷����ӿ�.
 */

public interface CommonDao {
	public void setSqlMapTemplateFactory(SqlMapClientFactory sqlMapTemplateFactory);

	public int getInt(String sqlType) throws DataAccessException;
	public int getIntByInt(int integer,String sqlType) throws DataAccessException;
	public int getIntByString(String str,String sqlType) throws DataAccessException;
	public int getIntByMap(HashMap hashMap,String sqlType) throws DataAccessException;
	
	public String getString(String sqlType) throws DataAccessException;
	public String getStringByInt(int integer,String sqlType) throws DataAccessException;
	public String getStringByString(String str,String sqlType) throws DataAccessException;
	public String getStringByMap(HashMap hashMap,String sqlType) throws DataAccessException;
	
	public Object getObject(String sqlType) throws DataAccessException;
	public Object getObjectByInt(int integer,String sqlType) throws DataAccessException;
	public Object getObjectByString(String str,String sqlType) throws DataAccessException;
	public Object getObjectByMap(HashMap hashMap,String sqlType) throws DataAccessException;

	public List getList(String sqlType) throws DataAccessException;
	public List getListByInt(int integer,String sqlType) throws DataAccessException;
	public List getListByString(String str,String sqlType) throws DataAccessException;
	public List getListByMap(HashMap hashMap,String sqlType) throws DataAccessException;

	public boolean insert(String sqlType);
	public boolean insertObject(Object obj,String sqlType);
	public boolean insertByInt(int integer,String sqlType);
	public boolean insertByString(String str,String sqlType);
	public boolean insertByMap(HashMap hashMap,String sqlType);
	
	public boolean update(String sqlType);
	public boolean updateObject(Object obj,String sqlType);
	public boolean updateByInt(int integer,String sqlType);
	public boolean updateByString(String str, String sqlType);
	public boolean updateByMap(HashMap hashMap,String sqlType);
	
	public boolean delete(String sqlType);
	public boolean deleteByInt(int integer,String sqlType);
	public boolean deleteByString(String str,String sqlType);
	public boolean deleteByMap(HashMap hashMap,String sqlType);

}

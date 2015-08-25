/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.dao.ibatis.spring;

/*
 * DAOͨ�÷������Ϸ��ͷ����ӿ� - Spring��
 * ���ߣ�̷����
 * �汾��0.001
 * ����޸����ڣ�20070928
 * ������DAOͨ�÷������Ͻӿڣ���������ݿ�ͨ�ò������������ʵ�ִ˽ӿڡ�
 */

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import java.util.List;
public interface CommonDaoGeneric {
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate);
	
	public <R> R get(String sqlType) throws DataAccessException;
	public <R> List<R> getList(String sqlType) throws DataAccessException;
	public <R,P> R getByParameter(P parameter,String sqlType) throws DataAccessException;
	public <R,P> List<R> getListByParameter(P parameter,String sqlType) throws DataAccessException;
	
	public boolean insert(String sqlType) throws DataAccessException;
	public <O> boolean insertObject(O obj,String sqlType) throws DataAccessException;
	public <P> boolean insertByParameter(P parameter,String sqlType) throws DataAccessException;
	
	public boolean update(String sqlType) throws DataAccessException;
	public <O> boolean updateObject(O obj,String sqlType) throws DataAccessException;
	public <P> boolean updateByParameter(P parameter,String sqlType) throws DataAccessException;
	
	public boolean delete(String sqlType) throws DataAccessException;
	public <P> boolean deleteByParameter(P parameter,String sqlType) throws DataAccessException;
}

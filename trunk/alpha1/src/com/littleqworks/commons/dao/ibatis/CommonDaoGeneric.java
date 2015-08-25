/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.dao.ibatis;

/*
 * iBatisͨ�÷��ͷ������Ͻӿ�
 * ���ߣ�̷����
 * �汾��0.02
 * ����޸����ڣ�20071020
 * ������iBatisͨ�÷������Ͻӿڣ���������ݿ�ͨ�÷��Ͳ������������ʵ�ִ˽ӿڡ�
 */

/**
 * CommonDao
 * @author ̷����
 * @version 0.02
 * Last Date: 20-Oct-07
 * Description: iBatisͨ�÷��ͷ����ӿ�.
 */

public interface CommonDaoGeneric {
	public void setSqlMapTemplateFactory(SqlMapClientFactory sqlMapTemplateFactory);

	public <RETURN> int get(String sqlType) throws DataAccessException;
	public <RETURN,PARAMETER> int getByParameter(PARAMETER parameter,String sqlType) throws DataAccessException;

	public boolean insert(String sqlType);
	public <OBJ> boolean insertObject(OBJ obj,String sqlType);
	public <PARAMETER> boolean insertByParameter(PARAMETER Parameter,String sqlType);
	
	public boolean update(String sqlType);
	public <OBJ> boolean updateObject(OBJ obj,String sqlType);
	public <PARAMETER> boolean updateByParameter(PARAMETER parameter,String sqlType);
	
	public boolean delete(String sqlType);
	public <PARAMETER> boolean deleteByParameter(PARAMETER parameter,String sqlType);
}

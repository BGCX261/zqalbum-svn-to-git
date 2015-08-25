/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.dao.ibatis;

/*
 * iBatis通用泛型方法集合接口
 * 作者：谭孟泷
 * 版本：0.02
 * 最后修改日期：20071020
 * 描述：iBatis通用方法集合接口，具体的数据库通用泛型操作方法类必须实现此接口。
 */

/**
 * CommonDao
 * @author 谭孟泷
 * @version 0.02
 * Last Date: 20-Oct-07
 * Description: iBatis通用泛型方法接口.
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

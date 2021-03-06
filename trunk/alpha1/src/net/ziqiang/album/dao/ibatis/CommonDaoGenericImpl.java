/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package net.ziqiang.album.dao.ibatis;

/*
 * DAO通用方法集合的iBatis实现 - Spring版
 * 作者：谭孟泷
 * 版本：0.002
 * 最后修改日期：20070929
 * 描述：DAO通用方法集合的iBatis实现。
 */

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import java.util.List;
import net.ziqiang.album.dao.CommonDaoGeneric;

public class CommonDaoGenericImpl implements CommonDaoGeneric{
	private SqlMapClientTemplate sqlMapClientTemplate;

	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	public <R> R get(String sqlType) throws DataAccessException{
		try{
			return (R)sqlMapClientTemplate.queryForObject(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public <R> List<R> getList(String sqlType) throws DataAccessException{
		try{
			return (List<R>)sqlMapClientTemplate.queryForList(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public <R,P> List<R> getListByParameter(P parameter,String sqlType) throws DataAccessException{
		try{
			return (List<R>)sqlMapClientTemplate.queryForList(sqlType,parameter);
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public <R,P> R getByParameter(P parameter,String sqlType) throws DataAccessException{
		try{
			return (R)sqlMapClientTemplate.queryForObject(sqlType,parameter);
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}

	public boolean insert(String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.insert(sqlType);
		}catch(DataAccessException e){
			return false;
		}
		return true;
	}
	
	public <O> boolean insertObject(O obj,String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.insert(sqlType, obj);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	
	public <P> boolean insertByParameter(P parameter,String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.insert(sqlType, parameter);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	
	public boolean update(String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.update(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	
	public <O> boolean updateObject(O obj,String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.update(sqlType, obj);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	
	public <P> boolean updateByParameter(P parameter,String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.update(sqlType, parameter);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	
	public boolean delete(String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.delete(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	
	public <P> boolean deleteByParameter(P parameter,String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.delete(sqlType, parameter);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}

}

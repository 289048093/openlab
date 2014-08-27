package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.entity.CommonTechPlatformCatEntity;
import com.cloudking.openlab.entity.CommonTechPlatformEntity;

@Repository("commonTechPlatformCatDAO")
public class CommonTechPlatformCatDAO extends
		BaseDAO<CommonTechPlatformCatEntity> {
	/**
	 * 查询出所有的分类
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<CommonTechPlatformCatEntity> getallCat() throws SQLException {
		return list();
	}

	/**
	 * 通过公共技术服务平台分类ID查询旗下的单元
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<CommonTechPlatformEntity> getCommonTechPlatformById(Long id)
			throws SQLException {
		String hql = "select common_ from CommonTechPlatformEntity common_ where common_.cat.id=:id";
		return list(hql, "id", id);
	}

	/**
	 * 查询出公开的类别
	 * 
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<CommonTechPlatformCatEntity> listPubliced() throws SQLException {
		String hql = "select catEntity_ from CommonTechPlatformCatEntity catEntity_ where  catEntity_.publiced=1 ";
		return list(hql);
	}
}

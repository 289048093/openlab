package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.entity.DownloadFileCatEntity;
import com.cloudking.openlab.entity.DownloadFileEntity;

@Repository("downloadFileCatDAO")
public class DownloadFileCatDAO extends BaseDAO<DownloadFileCatEntity> {
	/**
	 * 分类查询
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<DownloadFileCatEntity> getallCat() throws SQLException {
		return list();
	}

	/**
	 * 分类下的单元
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<DownloadFileEntity> getCommonTechPlatformById(Long id)
			throws SQLException {
		String hql = "select downFile_ from DownloadFileEntity downFile_ where downFile_.cat.id=:id";
		return list(hql, "id", id);
	}

	/**
	 * 查询出公开的类别
	 * 
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<DownloadFileCatEntity> listPubliced() throws SQLException {
		String hql = "select catEntity_ from DownloadFileCatEntity catEntity_ where  catEntity_.publiced=1 ";
		return (List<DownloadFileCatEntity>) list(hql);
	}
}

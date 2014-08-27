package com.cloudking.openlab.vo;

import java.util.List;

import com.cloudking.openlab.BaseVO;

/**
 * 首页所需的数据
 * 
 * @author Administrator
 * 
 */

public class IndexVO extends BaseVO {
	/**
	 * 第一行
	 */
	/*
	 * 2-1：新闻
	 */
	private List<NewsVO> newsList;
	/*
	 * 2-2：政策法规
	 */
	private List<PolicyVO> policyList;

	/*
	 * 2-3:通知公告。还不知道怎么搞
	 */
	private List<NewsVO> newsNoticeList;
	/**
	 * 第二行
	 */
	/*
	 * 4:统计，各种站点录入的设备，实体的统计
	 */
	private List<String> equipmentStatList;
	/*
	 * 5:设备的类别。
	 */
	private List<EquipmentCatVO> equipmentCatList;

	/*
	 * 6:指南，不知道需不需要后台取值。还是固定页面去。
	 */
	public List<String> eqmulpxList;
	/**
	 * 第三行
	 */
	/*
	 * 7：仪器展示，取出最新的一条的详细信息。其他出去6条标题，id。点击跳转站内设备。
	 */
	private EquipmentVO equipmentVO;
	private List<EquipmentVO> equipmentVoList;

	/*
	 * 8:科研成果。
	 */
	private List<ResearchAchieveVO> researchAhieveList;
	/*
	 * 9:展示在前台的专家
	 */
	private List<ExpertVO> viewExperts;
	// 仪器设备数量
	private List<ApplyOrderVO> applyOrderVO;
	// 行业检测数量
	private List<ApplyOrderVO> applyOrderVOIndustryTest;

	public List<ApplyOrderVO> getApplyOrderVO() {
		return applyOrderVO;
	}

	public void setApplyOrderVO(List<ApplyOrderVO> applyOrderVO) {
		this.applyOrderVO = applyOrderVO;
	}

	public List<ApplyOrderVO> getApplyOrderVOIndustryTest() {
		return applyOrderVOIndustryTest;
	}

	public void setApplyOrderVOIndustryTest(
			List<ApplyOrderVO> applyOrderVOIndustryTest) {
		this.applyOrderVOIndustryTest = applyOrderVOIndustryTest;
	}

	public List<NewsVO> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<NewsVO> newsList) {
		this.newsList = newsList;
	}

	public List<PolicyVO> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(List<PolicyVO> policyList) {
		this.policyList = policyList;
	}

	public List<String> getEquipmentStatList() {
		return equipmentStatList;
	}

	public void setEquipmentStatList(List<String> equipmentStatList) {
		this.equipmentStatList = equipmentStatList;
	}

	public List<EquipmentCatVO> getEquipmentCatList() {
		return equipmentCatList;
	}

	public void setEquipmentCatList(List<EquipmentCatVO> equipmentCatList) {
		this.equipmentCatList = equipmentCatList;
	}

	public EquipmentVO getEquipmentVO() {
		return equipmentVO;
	}

	public void setEquipmentVO(EquipmentVO equipmentVO) {
		this.equipmentVO = equipmentVO;
	}

	public List<EquipmentVO> getEquipmentVoList() {
		return equipmentVoList;
	}

	public void setEquipmentVoList(List<EquipmentVO> equipmentVoList) {
		this.equipmentVoList = equipmentVoList;
	}
	public List<ResearchAchieveVO> getResearchAhieveList() {
		return researchAhieveList;
	}

	public void setResearchAhieveList(List<ResearchAchieveVO> researchAhieveList) {
		this.researchAhieveList = researchAhieveList;
	}


	public List<ExpertVO> getViewExperts() {
		return viewExperts;
	}

	public void setViewExperts(List<ExpertVO> viewExperts) {
		this.viewExperts = viewExperts;
	}

	public List<NewsVO> getNewsNoticeList() {
		return newsNoticeList;
	}

	public void setNewsNoticeList(List<NewsVO> newsNoticeList) {
		this.newsNoticeList = newsNoticeList;
	}

	public List<String> getEqmulpxList() {
		return eqmulpxList;
	}

	public void setEqmulpxList(List<String> eqmulpxList) {
		this.eqmulpxList = eqmulpxList;
	}

}

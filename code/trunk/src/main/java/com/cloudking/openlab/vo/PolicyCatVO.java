package com.cloudking.openlab.vo;

import java.util.List;

import com.cloudking.openlab.BaseVO;

/**
 * 
 * @author cloudKing
 * 
 */
public class PolicyCatVO extends BaseVO {
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 描述
	 */
	private String desc;
	/**
	 * 政策类别下的所有政策单元
	 */
	private List<PolicyVO> policyUnits;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<PolicyVO> getPolicyUnits() {
		return policyUnits;
	}

	public void setPolicyUnits(List<PolicyVO> policyUnits) {
		this.policyUnits = policyUnits;
	}
}

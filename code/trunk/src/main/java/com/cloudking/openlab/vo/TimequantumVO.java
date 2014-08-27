package com.cloudking.openlab.vo;

import java.util.Date;

import com.cloudking.openlab.BaseVO;

public class TimequantumVO  extends BaseVO{

	
	private static final long serialVersionUID = 2971747306351925970L;

	private Date benginDate;
	
	private Date endDate;
	
	private  Long equipmentId;
	
	private Double  rent;//租金
	
	

	

	
	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public Date getBenginDate() {
		return benginDate;
	}

	public void setBenginDate(Date benginDate) {
		this.benginDate = benginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	
	
	
}

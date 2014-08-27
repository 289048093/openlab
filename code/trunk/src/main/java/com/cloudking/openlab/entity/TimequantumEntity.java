package com.cloudking.openlab.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 *仪器使用时间段
 * @author CloudKing
 */
@Entity
@Table(name = "tb_time_quantum")
public class TimequantumEntity  extends BaseEntity{


	@Column(name = "BENGIN_DATE_")
	private Date benginDate;              
	
	@Column(name = "END_DATE_")
	private Date endDate;

	// 仪器设备
	@ManyToOne(fetch = FetchType.LAZY)
	private EquipmentEntity entity;
	
	//租金
	@Column(name="RENT")
	private Double  rent; 
	
	
	
	@Column(name = "STATUS_")
	private String status;
	
	
	
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public EquipmentEntity getEntity() {
		return entity;
	}

	public void setEntity(EquipmentEntity entity) {
		this.entity = entity;
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





	
	
	
	
	

}

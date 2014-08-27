package com.cloudking.openlab.vo;

import java.util.Date;

 

import com.cloudking.openlab.BaseVO;


public class EquipmentLogVO extends BaseVO{

	
    private String desc;
    /**
     * 添加时间
     */
    private Date addDate;
    /**
     * 仪器设备
     */
    
    private Long equipmentId;
    
    private String  equipmentName;
    /**
     * 操作人
     */

    private Long userId;
    
    private String realname;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	
    
}

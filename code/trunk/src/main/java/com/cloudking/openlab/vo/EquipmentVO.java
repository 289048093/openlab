package com.cloudking.openlab.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.cloudking.openlab.BaseVO;

public class EquipmentVO extends BaseVO {
	/**
	 * 设备名称
	 */
	private String name;

	/**
	 * 设备描述
	 */
	private String desc;
	/**
	 * 型号
	 */
	private String model;

	/**
	 * 生产商
	 */
	private String producer;

	/**
	 * 价格
	 */
	private BigDecimal price;

	/**
	 * 等级
	 */

	private String grade;

	/**
	 * 图片
	 */

	private String pic;

	/**
	 * 联系人
	 */

	private String contact;

	/**
	 * 联系人电话
	 */

	private String phone;
	/**
	 * 登记时间
	 */

	private Date addTime;

	/**
	 * 修改时间
	 */
	private Date modifyTime;
	
	private PointLabVO pointLabVO;
	private DeptVO deptVO;
    private EquipmentCatVO equipmentCatVO;
    private CommonTechPlatformVO commonTechPlatformVO;
    
    private Long deptId;
    private String deptName;
    private String commName;
    private Long commId;
	private Long labId;

	private Long catId;

	private String labName;

	private String catName;

	private byte status;


    
    public PointLabVO getPointLabVO() {
		return pointLabVO;
	}

	public void setPointLabVO(PointLabVO pointLabVO) {
		this.pointLabVO = pointLabVO;
	}

	public DeptVO getDeptVO() {
		return deptVO;
	}

	public void setDeptVO(DeptVO deptVO) {
		this.deptVO = deptVO;
	}

	public EquipmentCatVO getEquipmentCatVO() {
		return equipmentCatVO;
	}

	public void setEquipmentCatVO(EquipmentCatVO equipmentCatVO) {
		this.equipmentCatVO = equipmentCatVO;
	}

	public CommonTechPlatformVO getCommonTechPlatformVO() {
		return commonTechPlatformVO;
	}

	public void setCommonTechPlatformVO(CommonTechPlatformVO commonTechPlatformVO) {
		this.commonTechPlatformVO = commonTechPlatformVO;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public Long getCommId() {
		return commId;
	}

	public void setCommId(Long commId) {
		this.commId = commId;
	}

	public String getLabName() {
		return labName;
	}

	private Date purchaseDate; //购置时间
    
    
    
  
    public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
     * 是否公开
     */
    private Boolean publiced;
	private Integer timeCount;

    
    
    

  

	/**
	 * 是否可预约
	 */
	private Boolean applicable;
	
	/**
	 * 预约时，跳转的url。用于不在本系统预约的设备
	 */
	private String redirectURL;
	
	public Boolean getApplicable() {
		return applicable;
	}

	public void setApplicable(Boolean applicable) {
		this.applicable = applicable;
	}
	
	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}

	public Boolean getPubliced() {
		return publiced;
	}

	public void setPubliced(Boolean publiced) {
		this.publiced = publiced;
	}

	public Integer getTimeCount() {
		return timeCount;
	}

	public void setTimeCount(Integer timeCount) {
		this.timeCount = timeCount;
	}

	public EquipmentVO(Long id, String name, String desc, String model,
			String producer, BigDecimal price, String grade, String pic,
			String contact, String phone, Date addTime, Date modifyTime,
			Long labId, Long catId, String labName, String catName, byte status) {
		this.setId(id);
		this.name = name;
		this.desc = desc;
		this.model = model;
		this.producer = producer;
		this.price = price;
		this.grade = grade;
		this.pic = pic;
		this.contact = contact;
		this.phone = phone;
		this.addTime = addTime;
		this.modifyTime = modifyTime;
		this.labId = labId;
		this.catId = catId;
		this.labName = labName;
		this.catName = catName;
		this.status = status;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

 

	public EquipmentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getLabId() {
		return labId;
	}

	public void setLabId(Long labId) {
		this.labId = labId;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

}

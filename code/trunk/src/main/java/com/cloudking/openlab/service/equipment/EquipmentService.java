package com.cloudking.openlab.service.equipment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.dao.CommonTechPlatformDAO;
import com.cloudking.openlab.dao.DeptDAO;
import com.cloudking.openlab.dao.EquipmentCatDAO;
import com.cloudking.openlab.dao.EquipmentDAO;
import com.cloudking.openlab.dao.PointLabDAO;
import com.cloudking.openlab.dao.TimequantumDAO;
import com.cloudking.openlab.entity.CommonTechPlatformEntity;
import com.cloudking.openlab.entity.DeptEntity;
import com.cloudking.openlab.entity.EquipmentCatEntity;
import com.cloudking.openlab.entity.EquipmentEntity;
import com.cloudking.openlab.entity.PointLabEntity;
import com.cloudking.openlab.entity.UserEntity;
import com.cloudking.openlab.util.ProjectUtil;
import com.cloudking.openlab.vo.EquipmentVO;

@Service("equipmentService")
public class EquipmentService extends BaseService {

    @Resource
    private EquipmentDAO equipmentDAO;
    @SuppressWarnings("unused")
    @Resource
    private EquipmentCatDAO equipmentCatDAO;
    @SuppressWarnings("unused")
    @Resource
    private PointLabDAO pointLabDAO;

    @Resource
    private TimequantumDAO timequantumDAO;

    @Resource
    private DeptDAO deptDAO;

    @Resource
    private CommonTechPlatformDAO commonTechPlatformDAO;

    /**
     * 查询所有的仪器设备信息
     * 
     * @return
     * @throws SQLException
     */

    public List<EquipmentVO> query(CloudContext<EquipmentVO> cloudContext) throws SQLException {

        List<Object[]> equipmentEntities = equipmentDAO.query(cloudContext.getVo().getName(), cloudContext.getVo()
                        .getModel(), cloudContext.getVo().getCatId(), cloudContext.getVo().getLabId(), cloudContext
                        .getVo().getCommId(), cloudContext.getPageInfo());

        List<EquipmentVO> equipmentVOs = new ArrayList<EquipmentVO>();
        EquipmentVO equipmentVO = null;
        for (Object[] ob : equipmentEntities) {
            equipmentVO = new EquipmentVO();
            EquipmentEntity e = (EquipmentEntity) ob[0];
            if (e != null) {
                BeanUtils.copyProperties(e, equipmentVO);
            }
            EquipmentCatEntity cat = (EquipmentCatEntity) ob[1];
            if (cat != null) {
                equipmentVO.setCatId(cat.getId());
                equipmentVO.setCatName(cat.getName());
            }
            PointLabEntity lab = (PointLabEntity) ob[2];
            if (lab != null) {
                equipmentVO.setLabId(lab.getId());
                equipmentVO.setLabName(lab.getName());
                DeptEntity dept = pointLabDAO.queryDept(lab.getId());
                if (dept != null) {
                    equipmentVO.setDeptName(dept.getName());
                }
            }
            CommonTechPlatformEntity comm = (CommonTechPlatformEntity) ob[3];
            if (comm != null) {
                equipmentVO.setCommId(comm.getId());
                equipmentVO.setCommName(comm.getName());
                if (commonTechPlatformDAO.queryDept(comm.getId()) != null) {
                    equipmentVO.setDeptName(commonTechPlatformDAO.queryDept(comm.getId()).getName());
                }
            }
            String pic = "";
            if (equipmentVO.getPic() == "" || equipmentVO.getPic() == null) {
                pic = PropertyManager.getInstance().getDbProperty(PropertyManager.DB_EQUIPMENTPIC_DEFAULT);
            } else {
                pic = equipmentVO.getPic();
            }
            equipmentVO.setPic("equipmentManager/equipment!showPic.action?cloudContext.params.pic=" + pic);
            equipmentVOs.add(equipmentVO);

        }
        return equipmentVOs;
    }

    /**
     * 根据编号查询
     * 
     * @param cloudContext
     * @throws SQLExceptionx
     */
    public void queryById(CloudContext<EquipmentVO> cloudContext) throws SQLException {
        EquipmentEntity equipmentEntity = equipmentDAO.queryById(cloudContext);

        // List<TimequantumEntity> entities=
        // timequantumDAO.queryByEquipmentId(equipmentEntity.getId());
        //    	
        // List<TimequantumVO> timequantumVos=new ArrayList<TimequantumVO>();
        // TimequantumVO timequantumVO=null;
        // for (TimequantumEntity t : entities) {
        //    		
        // if(t.getStatus().equals(Constant.TIMEQUANTUM_STATUS_YES) ){
        // timequantumVO=new TimequantumVO();
        // BeanUtils.copyProperties(t, timequantumVO);
        // timequantumVos.add(timequantumVO);
        // }
        // }
        if (equipmentEntity == null) {
            cloudContext.addErrorMsg("仪器设备信息不存在，请刷新后重试！");
            return;
        }
        // 描述

        String pic = "";
        if (equipmentEntity.getPic() == "" || equipmentEntity.getPic() == null) {
            pic = PropertyManager.getInstance().getDbProperty(PropertyManager.DB_EQUIPMENTPIC_DEFAULT);
        } else {
            pic = equipmentEntity.getPic();
        }
        equipmentEntity.setPic("equipmentManager/equipment!showPic.action?cloudContext.params.pic=" + pic);
        PointLabEntity pl = equipmentEntity.getLab();
        if (pl != null) {
            DeptEntity dept = pl.getDept();
            if (dept != null) {
                cloudContext.getVo().setDeptName(dept.getName());
            }
            cloudContext.getVo().setLabName(pl.getName());

        }
        CommonTechPlatformEntity common = equipmentEntity.getCommonTechPlatform();
        if (common != null) {
            DeptEntity dept = common.getDept();
            if (dept != null) {
                cloudContext.getVo().setDeptName(dept.getName());
            }
            cloudContext.getVo().setCommName(common.getName());
        }

        EquipmentCatEntity ece = equipmentEntity.getCat();
        if (ece != null) {
            cloudContext.getVo().setCatName(ece.getName());
        }
        BeanUtils.copyProperties(equipmentEntity, cloudContext.getVo());// 把entity中的值赋给vo
    }

    /**
     * 查询仪器设备管理员
     * 
     * @param id
     * @return
     * @throws BeansException
     * @throws SQLException
     */
    public UserEntity queryEquipmentSystem(Long id) throws BeansException, SQLException {

        return equipmentDAO.queryEquipmentSystem(id);
    }

}

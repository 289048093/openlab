-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user`(ID_,ADD_TIME_,PASSWORD_,REALNAME_,USERNAME_,SEX_,STATUS_) VALUES ('1', '2013-10-23 18:42:46', 'a66abb5684c45962d887564f08346e8d', '系统管理员', 'admin','1', '1');

-- ----------------------------
-- Records of tb_role
-- ----------------------------


INSERT INTO `tb_role`(ID_,ADD_TIME_,DESC_,NAME_,PERSISTENCE_) VALUES ('1', '2013-10-12 10:27:04', '', '管理员', 1);
INSERT INTO `tb_role`(ID_,ADD_TIME_,DESC_,NAME_,PERSISTENCE_) VALUES ('2', '2013-10-12 10:27:11', '', '设备管理员', 1);
INSERT INTO `tb_role`(ID_,ADD_TIME_,DESC_,NAME_,PERSISTENCE_) VALUES ('3', '2013-10-12 10:27:35', '', '普通用户', 1);



-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('1', null, '门户菜单', null, null, null, null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('2', null, '管理菜单', null, null, null, null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('3', '前台页面菜单', '首页', '(/openlab/?)?(/index.jsp)?', 'index.jsp', '1', 'images/icons/icon_index.png');
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('4', '前台页面菜单', '重点实验室', null, 'pointLabCatManager/pointLabCat!receptionQuery.action', '1', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('5', '前台页面菜单', '公共技术服务平台', null, 'commonTechPlatformCatManager/commonTechPlatformCat!receptionQuery.action', '1', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('6', '前台页面菜单', '科技文献', null, 'literature/Literature_list.jsp', '1', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('7', '前台页面菜单', '新闻通知', null, 'newsCatManager/newsCat!receptionQuery.action', '1', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('8', '前台页面菜单', '政策法规', null, 'policyCatManager/policyCat!receptionQuery.action', '1', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('9', '前台页面菜单', '仪器设备', null, 'equipmentManager/equipment!query.action', '1', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('10', '前台页面菜单', '行业检测', null, 'industryTestManager/industryTest!query.action', '1', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('11', '前台页面菜单', '专家咨询', null, 'expertQuestionManager/expertQuestion!gainQTcount.action', '1', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('12', '前台页面菜单', '科技成果与技术转移', null, 'public/example_list.jsp', '1', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('13', '前台页面菜单', '下载中心', null, 'downloadFileManager/downloadFile!query.action', '1', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('14', '', '信息管理', null, null, '2', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('15', null, '仪器设备共享管理', null, null, '2', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('16', null, '行业检测管理', null, null, '2', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('17', null, '科技成果与技术转移', null, null, '2', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('18', null, '日志管理', null, null, '2', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('19', null, '用户、角色、权限管理', null, null, '2', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('20', null, '系统管理', null, null, '2', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('21', null, '重点实验室', null, 'Information/PointLab.jsp', '14', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('22', null, '重点实验室分类', null, 'Information/PointLabCat.jsp', '14', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('23', null, '政策法规', null, 'Information/Policy.jsp', '14', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('24', null, '政策法规分类', null, 'Information/PolicyCat.jsp', '14', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('25', null, '新闻通知', null, 'Information/News.jsp', '14', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('26', null, '新闻类别', null, 'Information/NewsCat.jsp', '14', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('27', null, '公共技术服务平台', null, 'Information/CommonTechPlatform.jsp', '14', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('28', null, '公共技术服务平台分类', null, 'Information/CommonTechPlatformCat.jsp', '14', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('29', null, '下载中心', null, 'Information/Download.jsp', '14', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('30', null, '下载中心分类', null, 'Information/DownloadCat.jsp', '14', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('31', null, '仪器设备', null, 'Equipment/Equipment.jsp', '15', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('32', null, '使用预约', null, 'Equipment/ApplyOrder.jsp', '15', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('34', null, '仪器设备分类', null, 'Equipment/EquipmentCat.jsp', '15', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('35', null, '行业检测', null, 'IndustryTest/IndustryTest.jsp', '16', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('36', null, '检测预约', null, 'IndustryTest/ApplyOrder.jsp', '16', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('38', null, '行业检测领域', null, 'IndustryTest/IndustryTestCat.jsp', '16', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('39', null, '科技成果', null, 'ResearchAchieve/ResearchAchieve.jsp', '17', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('40', null, '科技成果领域', null, 'ResearchAchieve/ResearchLevel.jsp', '17', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('41', null, '技术转移', null, 'TechTransfer/TechTransfer.jsp', '17', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('42', null, '技术转移分类', null, 'TechTransfer/TechTransferCat.jsp', '17', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('43', null, '仪器设备日志', null, 'log/equipmentLog.jsp', '18', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('44', null, '行业检测日志', null, 'log/IndustryTestLog.jsp', '18', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('45', null, '用户', null, 'System/User.jsp', '19', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('46', null, '角色', null, 'System/Role.jsp', '19', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('47', null, '权限', null, 'System/permission.jsp', '19', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('48', null, '菜单管理', null, 'syscfg/menu.jsp', '20', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('49', NULL, '刷卡和扫描', NULL,'Equipment/SwipingCard.jsp', 15,  NULL);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('50', NULL, '仪器设备维护记录', NULL,'Equipment/EquipmentMaintain.jsp', 15, NULL);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('51', NULL, '使用记录', NULL,'Equipment/UseRecord.jsp', 15,NULL);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('52', NULL, '全局属性设置',NULL, 'syscfg/property.jsp', 15,NULL);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('53', null, '专家咨询审核与管理', null, 'expert/Expert.jsp', '15', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('54', null, '专家', null, 'expert/ExpertUser.jsp', '19', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('55', null, '部门', null, 'Information/dept.jsp', '14', null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('56', null, '统计报表', null,  null, '2',null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('57', null, '仪器设备报表',null, 'Equipment/equipmentReport.jsp', '56',  null);
INSERT INTO `tb_menu`(ID_,DESC_,NAME_,REGEX_,URL_,PARENT_MENU_ID_,ICON_) VALUES ('58', null, '仪器设备统计报表',null,'Equipment/equipmentReportTable.jsp', '56',  null);
-- ----------------------------
-- Records of tb_rights
-- ----------------------------
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('1', '信息管理', null, '父菜单', null);
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('2', '重点实验室', '/Information/PointLab.jsp', null, '1');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('3', '重点实验室分类', '/Information/PointLabCat.jsp', null, '1');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('4', '政策法规', '/Information/Policy.jsp', null, '1');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('5', '政策法规分类', '/Information/PolicyCat.jsp', null, '1');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('6', '新闻通知', '/Information/News.jsp', null, '1');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('7', '新闻类别', '/Information/NewsCat.jsp', null, '1');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('8', '公共技术服务平台', '/Information/CommonTechPlatform.jsp', null, '1');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('9', '公共技术服务平台分类', '/Information/CommonTechPlatformCat.jsp', null, '1');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('10', '下载中心', '/Information/Download.jsp', null, '1');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('11', '下载中心分类', '/Information/DownloadCat.jsp', null, '1');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('12', '仪器设备共享管理', null, '父菜单', null);
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('15', '仪器设备', '/Equipment/Equipment.jsp', null, '12');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('16', '使用预约', '/Equipment/ApplyOrder.jsp', null, '12');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('17', '仪器设备维护记录', '/Equipment/EquipmentMaintain.jsp', null, '12');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('18', '预约计划管理', '/Equipment/TimeQuantum.jsp', null, '12');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('19', '仪器设备分类', '/Equipment/EquipmentCat.jsp', null, '12');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('20', '行业检测管理', null, '父菜单', null);
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('21', '行业检测', '/IndustryTest/IndustryTest.jsp', null, '20');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('22', '检测预约', '/IndustryTest/ApplyOrder.jsp', null, '20');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('23', '预约计划管理', '/IndustryTest/TimeQuantum.jsp', null, '20');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('24', '行业检测领域', '/IndustryTest/IndustryTestCat.jsp', null, '20');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('25', '科技成果与技术转移', null, '父菜单', null);
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('26', '科技成果', '/ResearchAchieve/ResearchAchieve.jsp', null, '25');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('27', '科技成果领域', '/ResearchAchieve/ResearchLevel.jsp', null, '25');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('28', '技术转移', '/TechTransfer/TechTransfer.jsp', null, '25');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('29', '技术转移分类', '/TechTransfer/TechTransferCat.jsp', null, '25');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('30', '日志管理', null, '父菜单', null);
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('31', '仪器设备日志', '/log/equipmentLog.jsp', null, '30');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('32', '行业检测日志', '/log/IndustryTestLog.jsp', null, '30');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('33', '用户、角色、权限管理', null, '父菜单', null);
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('34', '用户', '/System/User.jsp', null, '33');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('35', '角色', '/System/Role.jsp', null, '33');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('36', '权限', '/System/permission.jsp', null, '33');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('37', '系统管理', null, '父菜单', null);
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('38', '菜单管理', '/syscfg/menu.jsp', null, '37');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('39', '全局属性管理', '/syscfg/property.jsp', null, '37');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('58', '实验室查询所有', 'openlabManager/openlab!PointLabViewAll.action', null, '2');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('59', '仪器设备查询所有', 'openlabManager/openlab!EquipmentViewAll.action', null, '15');

INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('40', '新闻审核', 'newsManager/news!updatePubliced.action', '新闻标识', '6');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('41', '新闻类别审核', 'newsCatManager/newsCat!updatePubliced.action', '新闻类别标识', '7');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('42', '公共技术服务平台审核', 'commonTechPlatformManager/commonTechPlatform!updatePubliced.action', '公共技术服务平台标识', '8');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('43', '公共技术服务平台分类审核', 'commonTechPlatformCatManager/commonTechPlatformCat!updatePubliced.action', '公共技术服务平台类别标识', '9');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('44', '下载中心审核', 'downloadFileManager/downloadFile!updatePubliced.action', '下载中心标识', '10');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('45', '下载中心分类审核', 'downloadFileCatManager/downloadFileCat!updatePubliced.action', '下载中心分类标识', '11');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('46', '重点实验室审核', 'pointLabManager/pointLab!updatePubliced.action', '重点实验室标识', '2');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('47', '重点实验室分类审核', 'pointLabCatManager/pointLabCat!updatePubliced.action', '重点实验室分类标识', '3');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('48', '政策法规审核', 'policyManager/policy!updatePubliced.action', '政策法规标识', '4');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('49', '政策法规分类审核', 'policyCatManager/policyCat!updatePubliced.action', '政策法规分类标识', '5');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('50', '仪器设备审核', 'equipmentManager/equipment!updatePubliced.action', '仪器设备标识', '15');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('51', '仪器设备分类审核', 'equipmentCatManager/equipmentCat!updatePubliced.action', '仪器设备分类标识', '19');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('52', '行业检测审核', 'industryTestManager/industryTest!updatePubliced.action', '行业检测标识', '21');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('53', '行业检测领域审核', 'industryTestCatManager/industryTestCat!updatePubliced.action', '行业检测分类标识', '24');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('54', '科技成果审核', 'researchAchieveManager/researchAchieve!updatePubliced.action', '科技成果标识', '26');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('55', '科技成果领域审核', 'researchLevelManager/researchLevel!updatePubliced.action', '科技成果级别标识', '27');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('56', '技术转移审核', 'techTransferManager/techTransfer!updatePubliced.action', '技术转移标识', '28');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('57', '技术转移分类审核', 'techTransferCatManager/techTransferCat!updatePubliced.action', '技术转移分类标识', '29');

INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('60', '新闻添加', 'newsManager/news!addNews.action', '新闻cud标识', '6');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('61', '新闻修改', 'newsManager/news!updateNews.action', '新闻cud标识', '6');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('62', '新闻删除', 'newsManager/news!deleteNews.action', '新闻cud标识', '6');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('63', '仪器设备添加', 'equipmentManager/equipment!addEquipment.action', '仪器设备添加标识', '15');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('64', '仪器设备修改', 'equipmentManager/equipment!updateEquipment.action', '仪器设备修改标识', '15');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('65', '仪器设备删除', 'equipmentManager/equipment!deleteEquipments.action', '仪器设备删除标识', '15');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('66', '仪器设备添加维护、使用、使用、预约计划权限', 'equipmentMaintainManager/equipmentMaintain!add.action', '仪器设备维护、使用、使用计划标识', '15');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('67', '使用预约修改', 'applyOrderManager/applyOrder!initUpdateApplyOrder.action', '使用预约修改标识', '16');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('68', '使用预约删除', 'applyOrderManager/applyOrder!deleteApplyOrder.action', '使用预约删除标识', '16');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('69', '预约计划管理修改', 'timeQuantumManager/timeQuantum!initUpdate.action', '预约计划管理修改标识', '18');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('70', '预约计划管理删除', 'timeQuantumManager/timeQuantum!delete.action', '预约计划管理删除标识', '18');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('71', '仪器设备分类添加', 'equipmentCatManager/equipmentCat!addEquipmentCat.action', '仪器设备分类添加标识', '19');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('72', '仪器设备分类修改', 'equipmentCatManager/equipmentCat!updateEquipmentCat.action', '仪器设备分类修改标识', '19');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('73', '仪器设备分类删除', 'equipmentCatManager/equipmentCat!deleteEquipmentsCat.action', '仪器设备分类删除标识', '19');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('74', '行业检测添加', 'industryTestManager/industryTest!addIndustryTest.action', '行业检测添加标识', '21');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('75', '行业检测修改', 'industryTestManager/industryTest!initUpdateIndustryTest.action', '行业检测修改标识', '21');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('76', '行业检测删除', 'industryTestManager/industryTest!deleteIndustryTests.action', '行业检测删除标识', '21');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('77', '行业检测添加用户记录和预约权限', 'applyOrderManager/applyOrder!addUseRecordByIndustryTest.action', '行业检测添加用户记录标识', '21');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('78', '行业检测领域添加', 'industryTestCatManager/industryTestCat!addIndustryTestCat.action', '行业检测分类添加标识', '24');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('79', '行业检测领域修改', 'industryTestCatManager/industryTestCat!initUpdateIndustryTestCat.action', '行业检测分类修改标识', '24');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('80', '行业检测领域删除', 'industryTestCatManager/industryTestCat!deleteIndustryTestsCat.action', '行业检测分类删除标识', '24');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('81', '预约计划管理删除', 'industryTestTimeQuantumManager/industryTestTimeQuantum!delete.action', '预约管理计划删除标识', '23');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('82', '检测预约删除', 'applyOrderManager/applyOrder!deleteApplyOrder.action', '检测预约删除标识', '22');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('83', '检测预约修改', 'applyOrderManager/applyOrder!initUpdateApplyOrderByTest.action', '检测预约修改标识', '22');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('84', '技术转移添加', 'techTransferManager/techTransfer!add.action', '技术转移添加标识', '28');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('85', '技术转移修改', 'techTransferManager/techTransfer!initUpdate.action', '技术转移修改标识', '28');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('86', '技术转移删除', 'techTransferManager/techTransfer!delete.action', '技术转移删除标识', '28');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('87', '技术转移修改状态', 'techTransferManager/techTransfer!initUpdate.action', '技术转移修改状态标识', '28');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('88', '科技成果添加', 'researchAchieveManager/researchAchieve!add.action', '科技成果添加标识', '26');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('89', '科技成果修改', 'researchAchieveManager/researchAchieve!initUpdate.action', '科技成果修改权限', '26');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('90', '科技成果删除', 'researchAchieveManager/researchAchieve!delete.action', '科技成果删除权限', '26');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('91', '科技成果领域添加', 'researchLevelManager/researchLevel!add.action', '科技成果级别添加标识', '27');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('92', '科技成果领域修改', 'researchLevelManager/researchLevel!initUpdate.action', '科技成果级别修改标识', '27');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('93', '科技成果领域删除', 'researchLevelManager/researchLevel!delete.action', '科技成果级别删除标识', '27');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('94', '技术转移分类添加', 'techTransferCatManager/techTransferCat!add.action', '技术转移分类添加标识', '29');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('95', '技术转移分类修改', 'techTransferCatManager/techTransferCat!initUpdate.action', '技术转移分类修改标识', '29');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('96', '技术转移分类删除', 'techTransferCatManager/techTransferCat!delete.action', '技术转移分类删除标识', '29');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('97', '重点实验室添加', 'pointLabManager/pointLab!addPointLab.action', '重点实验室添加标识', '2');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('98', '重点实验室修改', 'pointLabManager/pointLab!initUpdatePointLab.action', '重点实验室修改标识', '2');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('99', '重点实验室删除', 'pointLabManager/pointLab!deletePointLab.action', '重点实验室删除标识', '2');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('100', '重点实验室成员管理', 'pointLabManager/pointLab!initPointLabMenbers.action', '重点实验室成员管理标识', '2');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('101', '重点实验室分类添加', 'pointLabCatManager/pointLabCat!addPointLabCat.action', '重点实验室分类添加标识', '3');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('102', '重点实验室分类修改', 'pointLabCatManager/pointLabCat!initUpdatePointLabCat.action', '重点实验室分类修改标识', '3');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('103', '重点实验室分类删除', 'pointLabCatManager/pointLabCat!deletePointLabCat.action', '重点实验室分类删除标识', '3');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('104', '公共技术服务平台添加', 'commonTechPlatformManager/commonTechPlatform!addCommonTechPlatform.action', '公共技术服务平台add标识', '8');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('105', '公共技术服务平台修改', 'commonTechPlatformManager/commonTechPlatform!initUpdateCommonTechPlatform.action', '公共技术服务平台update标识', '8');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('106', '公共技术服务平台删除', 'commonTechPlatformManager/commonTechPlatform!deleteCommonTechPlatform.action', '公共技术服务平台delete标识', '8');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('107', '公共技术服务平台分类添加', 'commonTechPlatformCatManager/commonTechPlatformCat!addCommonTechPlatformCat.action', '服务平台addauth标识', '9');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('108', '公共技术服务平台分类修改', 'commonTechPlatformCatManager/commonTechPlatformCat!initUpdateCommonTechPlatformCat.action', '服务平台updateAuth标识', '9');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('109', '公共技术服务平台分类删除', 'commonTechPlatformCatManager/commonTechPlatformCat!deleteCommonTechPlatformCat.action', '服务平台deleteAuth标识', '9');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('110', '下载中心添加', 'downloadFileManager/downloadFile!addDownloadFile.action', '下载中心add标识', '10');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('111', '下载中心修改', 'downloadFileManager/downloadFile!initUpdateDownloadFile.action', '下载中心update标识', '10');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('112', '下载中心删除', 'downloadFileManager/downloadFile!deleteDownloadFile.action', '下载中心delete标识', '10');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('113', '下载中心分类添加', 'downloadFileCatManager/downloadFileCat!addDownloadFileCat.action', '下载中心分类ADD标识', '11');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('114', '下载中心分类修改', 'downloadFileCatManager/downloadFileCat!initUpdateDownloadFileCat.action', '下载中心分类update标识', '11');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('115', '下载中心删除', 'downloadFileCatManager/downloadFileCat!deleteDownloadFileCat.action', '下载中心分类delete标识', '11');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('116', '新闻分类添加', 'newsCatManager/newsCat!addNewsCat.action', '新闻分类add标识', '7');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('117', '新闻分类修改', 'newsCatManager/newsCat!initUpdateNewsCat.action', '新闻分类update标识', '7');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('118', '新闻分类删除', 'newsCatManager/newsCat!deleteNewsCat.action', '新闻分类delete标识', '7');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('119', '政策法规分类添加', 'policyCatManager/policyCat!addPolicyCat.action', '政策法规分类add标识', '5');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('120', '政策法规分类修改', 'policyCatManager/policyCat!initUpdatePolicyCat.action', '政策法规分类update标识', '5');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('121', '政策法规分类删除', 'policyCatManager/policyCat!deletePolicyCat.action', '政策法规分类delete标识', '5');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('122', '政策法规添加', 'policyManager/policy!addPolicy.action', '政策法规add标识', '4');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('123', '政策法规修改', 'policyManager/policy!initUpdatePolicy.action', '政策法规update标识', '4');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('124', '政策法规删除', 'policyManager/policy!deletePolicys.action', '政策法规delete标识', '4');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('125', '用户添加', 'userManager/user!addUser.action', '用户add标识', '34');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('126', '用户修改', 'userManager/user!initUpdateUser.action', '用户update标识', '34');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('127', '用户删除', 'userManager/user!deleteUser.action', '用户delete标识', '34');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('128', '角色添加', 'roleManager/role!addRole.action', '角色add标识', '35');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('129', '角色复制', 'roleManager/role!addCopyRole.action', '角色copy标识', '35');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('130', '角色删除', 'roleManager/role!deleteRoles.action', '角色delete标识', '35');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('131', '角色人员管理', 'roleManager/role!initRoleUsers.action', '角色manager标识', '35');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('132', '角色授权', 'roleManager/role!addRightsAndModule.action', '角色授权标识', '35');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('134', '权限添加', 'rightsManager/rights!insert.action', '权限添加标识', '36');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('135', '权限修改', 'rightsManager/rights!initUpdate.action', '权限修改标识', '36');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('136', '权限删除', 'rightsManager/rights!delete.action', '权限删除标识', '36');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('137', '权限批量删除', 'rightsManager/rights!deleteMulti.action', '权限批量删除标识', '36');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('138', '菜单修改', 'menuManager/menu!initUpdate.action', '菜单修改标识', '38');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('139', '角色修改', 'roleManager/role!initUpdateRole.action', '角色修改标识', '35');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('140', '新闻置顶', 'newsManager/news!updateTop.action', '新闻置顶标识', '6');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('141', '政策法规置顶', 'policyManager/policy!updateTop.action', '政策法规置顶标识', '4');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('142', '部门', 'Information/dept.jsp', '部门菜单', '1');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('143', '部门添加', 'deptManager/dept!addDept.action', '部门添加标识', '142');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('144', '部门修改', 'deptManager/dept!updateDept.action', '部门修改标识', '142');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('145', '部门删除', 'deptManager/dept!deleteDept.action', '部门删除标识', '142');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('168', '专家添加权限', 'expertManager/expert!addExpert.action', '专家添加权限', '171');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('169', '专家修改权限', 'expertManager/expert!updateExpert.action', '专家修改权限', '171');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('170', '专家删除权限', 'expertManager/expert!deleteExpert.action', '专家删除权限', '171');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('171', '专家', 'expert/ExpertUser.jsp', null, '33');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('172', '刷卡和扫描', 'Equipment/SwipingCard.jsp', null, '12');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('173', '使用记录', 'Equipment/UseRecord.jsp', null, '12');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('174', '统计报表', 'Equipment/UseRecord.jsp', null, '1');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('175', '仪器设备统计报表', 'Equipment/equipmentReport.jsp', null, '174');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('176', '订单用户检测报告权限', 'applyOrderManager/applyOrder!saveReport.action', '上传订单用户检测报告权限', '22');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('177', '公共技术服务平台成员管理权限', 'commonTechPlatformManager/commonTechPlatform!initCommonTechPlatFormMenbers.action', '公共技术服务平台成员管理权限', '8');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('174', '系统报表', null, '父菜单', null);
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('175', '仪器设备明细', 'Equipment/equipmentReport.jsp', null, '174');
INSERT INTO `tb_rights`(ID_,NAME_,URL_,DESC_,SUPER_RIGHTS_ID_) VALUES ('176', '仪器设备统计报表', 'Equipment/equipmentReportTable.jsp', null, '174');
-- ----------------------------
-- Table structure for tb_property
-- ----------------------------
DROP TABLE IF EXISTS `tb_property`;
CREATE TABLE `tb_property` (
  `ID_` bigint(20) NOT NULL AUTO_INCREMENT,
  `DEFAULTVALUE_` varchar(255) DEFAULT NULL,
  `DESC_` varchar(255) DEFAULT NULL,
  `ERRORMSG_` varchar(255) DEFAULT NULL,
  `KEY_` varchar(255) NOT NULL,
  `REGEX_` varchar(255) DEFAULT NULL,
  `TYPE_` varchar(20) DEFAULT NULL,
  `VALUE_` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `KEY_` (`KEY_`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_property
-- ----------------------------
INSERT INTO `tb_property` VALUES ('3', '0', '是否开启邮件发送功能', '值必须为0或1(0代表否，1代表是)', 'email_enable', '^[01]$', 'Boolean', '1');
INSERT INTO `tb_property` VALUES ('4', 'xxx@xx.com', '邮件服务器用户名', '', 'email_username', '.*', 'String', '52673406@qq.com');
INSERT INTO `tb_property` VALUES ('5', 'xxxx', '邮件服务器密码', '', 'email_password', '.*', 'Password', 'chao123jing');
INSERT INTO `tb_property` VALUES ('6', 'smtp.xx.com', '邮件服务器地址', '', 'email_host', '.*', 'String', 'smtp.qq.com');
INSERT INTO `tb_property` VALUES ('7', '25', '邮件服务器端口', '端口号必须为有效整数', 'email_port', '^\\d{2,5}$', 'Integer', '25');
INSERT INTO `tb_property` VALUES ('8', 'xxx@xx.com', '邮件服务器发送地址', '邮箱格式不对，格式必须为xxxx@xx.xx', 'email_from', '[0-9a-zA-Z_\\.]+@\\w+\\.\\w+', 'String', '52673406@qq.com');
INSERT INTO `tb_property` VALUES ('9', '24', '找回密码邮件有效时间(小时)', '时间必须小于1000小时', 'reset_user_password_email_invalid_time', '^\\d{1,3}$', 'Integer', '24');
INSERT INTO `tb_property` VALUES ('11', '0', '是否自动删除无效的预约时间计划', '必须为true或者false', 'db_delete_record_flag', '^[01]$', 'Boolean', '0');
INSERT INTO `tb_property` VALUES ('12', 'default-equpment.jpg', '当仪器设备未上传图片时的默认图片', '文件不能为空', 'db_equipmentpic_default', '.+', 'File', 'default-equpment.jpg');
INSERT INTO `tb_property` VALUES ('13', '0', '首页专家信息轮换间隔时间(毫秒)', '间隔时间', 'index_expert_change_time', '^\d+$', 'Integer', '7200');
INSERT INTO `tb_property` VALUES ('14', '0', '首页专家信息是否随机展示', '专家展示顺序', 'index_experts_is_random', '^[01]$', 'Boolean', '0');
--INSERT INTO `tb_property` VALUES ('11', '0', '是否自动删除无效的预约时间计划', '必须为true或者false', 'db_delete_record_flag', '^[01]$', 'Boolean', '0');
INSERT INTO `tb_property` VALUES ('20', 'default_head_pic.jpg', '用户默认头像', '默认头像不能为空', 'db_user_default_head_pic', '.+', 'Image', 'default_head_pic.jpg');
INSERT INTO `tb_property` VALUES ('21', '0', '访问数量统计', '访问数量统计不能为空', 'visitor_count', '.+', 'Integer', '0');

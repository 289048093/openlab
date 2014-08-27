// 全局用户密码保存变量

Ext.Loader.setConfig( {
	enabled : true
});
Ext.Loader.setPath('Ext.ux', 'extjs/ux');

Ext.require( [ 'Ext.grid.*', 'Ext.data.*', 'Ext.ux.RowExpander',
		'Ext.selection.CheckboxModel' ]);

/**
 *订单管理
 */
var applyOrdersStore;
var addOrUpdateApplyOrderWindow;
var addOrUpdateApplyOrderPanel;

var timeStore;
var statusStore;

Ext.onReady(function() {

	Ext.QuickTips.init();
	// ##########################################################
		// 数据源存储块 开始
		// ##########################################################

		// 订单列表存储块
		applyOrdersStore = Ext
				.create(
						"Ext.data.Store",
						{
							autoLoad : true,
							fields : [ "ordrNum", "pic", "equipmentName",
									"model", "rent", "applyDate", "status",
									"desc", "subBeginDate", "subEndDate", "id",
									"contact", "phone", "sysDesc" ],
							pageSize : DEFAULT_EACH_PAGE_DATA,
							proxy : {
								pageParam : "cloudContext.pageInfo.nowPage",
								limitParam : "cloudContext.pageInfo.eachPageData",
								type : "ajax",
								actionMethods : {
									read : 'POST'
								},
								url : "applyOrderManager/applyOrder!queryEquipmentOrderByUser.action",
								reader : {
									type : "json",
									root : "cloudContext.params.equipmentOrders",
									totalProperty : 'cloudContext.pageInfo.dataCount'
								}
							}
						});

		// 搜索栏设备
		timeStore = Ext.create("Ext.data.Store", {
			fields : [ "id", "beginAndEnd" ]
		});

		// 订单状态 Store
		statusStore = Ext.create('Ext.data.Store', {
			fields : [ 'id', 'name' ]

		});

		var applyOrdersGrid = new Ext.grid.Panel(
				{
					layout : "fit",
					//title : parent.getTitle(jq("#requesturlId").val()),
					//iconCls : parent.getIcoCls(jq("#requesturlId").val()),
					multiSelect : true,// 支持多选
					selType : 'rowmodel',// 设置为单元格选择模式Ext.selection.RowModel
					id : "applyOrdersGridId",
					renderTo : Ext.getBody(),
					collapsible : true,
					autoScroll : true,
					store : applyOrdersStore,
					ckCollapsed : true,
					toggleCollapse : function() {
						this.collapseTool.disable();
						var items = this.dockedItems;
						for ( var i = 0; i < items.length; i++) {
							if (!Ext.isEmpty(items.get(i).hideFlag)
									&& items.get(i).hideFlag) {
								if (!this.ckCollapsed) {
									items.get(i).hide();
								} else {
									items.get(i).show();
								}
							}
						}
						this.update();
						this.getView().refresh();
						if (this.ckCollapsed) {
							// 设置图标箭头向上
							this.collapseTool.setType("collapse-top");
						} else {
							// 设置图标箭头向下
							this.collapseTool.setType("expand-bottom")
						}
						this.ckCollapsed = !this.ckCollapsed;
						this.collapseTool.enable();
						return this;
					},
					listeners : {
						afterrender : function() {
							// 设置开始的图标箭头向下
							this.collapseTool.setType("expand-bottom");
						}
					},

					loadMask : {
						msg : "正在加载数据,请稍等..."
					},
					plugins : [ {
						ptype : 'rowexpander',
						rowBodyTpl : new Ext.XTemplate(
								"<div class='detail_wrapper'>",
								"<div><b>其他信息：</b></div><p/>",
								"<div class='detail_item'>使用需求: {desc}</div>",
								"<div class='detail_item'>审核信息: {sysDesc}</div>",
								"<div class='detail_item'>联系人: {contact}</div>",
								"<div class='detail_item'>电话  : {phone}</div>",

								"</div>",
								{
									formatDate : function(dateVal) {
										if (dateVal != null) {
											dateVal = dateVal.replace("T", " ");
										}
										return dateVal;
									}
								})
					} ],
					columns : [
							Ext.create("Ext.grid.RowNumberer"),
							{
								text : "订单编号",
								width : 200,
								dataIndex : "ordrNum"
							},
							{
								text : "仪器名称",
								width : 150,

								dataIndex : "equipmentName"
							},
							{
								text : "图片",
								width : 32,
								dataIndex : "pic",
								renderer : icon,
								hidden : true
							},
							{
								text : "型号",
								width : 80,
								dataIndex : "model"

							},
							{
								header : "价格",
								width : 40,
								dataIndex : "rent",
								hidden : true,
								renderer : function(value) {
									if (value == null) {
										return "<label style='color:red'>--</label>";
									}
									return "<label style='color:red'>" + value
											+ "</label>";

								}

							},
							{
								text : "使用开始时间",
								width : 130,
								dataIndex : "subBeginDate",
								renderer : function(value) {

									return subStringDate(value);
								}

							},
							{
								text : "使用结束时间",
								width : 130,
								dataIndex : "subEndDate",
								renderer : function(value) {
									return subStringDate(value);
								}

							},
							{
								text : "下单时间",
								flex : 1,
								dataIndex : "applyDate",
								hidden : true,
								renderer : function(value) {
									return subStringDate(value);
								}

							},
							{
								text : "状态",
								width : 60,
								dataIndex : "status",
								renderer : function(value) {
									if (value == 0) {
										return "<label style='color:red'>待审核</label>";
									} else if (value == 1) {
										return "<label style='color:red'>已拒绝</label>";
									} else if (value == 2) {
										return "<label style='color:red'>已通过</label>";
									} else if (value == 3) {
										return "<label style='color:red'>已付款(待核实)</label>";
									} else if (value == 4) {
										return "<label style='color:red'>使用中</label>";

									} else if (value == 5) {
										return "<label style='color:red'>已结束</label>";
									} else if (value == 6) {
										return "<label style='color:red'>已付款(已核实)</label>";
									} else if (value == 7) {
										return "<label style='color:red'>已关闭</label>";
									}
								}
							},
							{
								header : "操作",
								width : 150,
								align : 'center',
								xtype : 'templatecolumn',
								tpl : '<tpl if="status == 1 || status == 2 || status == 0 || status == 3 ||  status == 4 || status == 5 || status == 6">'
										+ '<a style="text-decoration:none;margin-right:5px;" href="javascript:closeApplyOrderOrder({id});"><img src="extjs/resources/icons/closeworkorder.png"  title="关闭订单" alt="关闭订单" class="actionColumnImg" />&nbsp;</a>'
										+ '</tpl>'
										+ '<tpl if=" status==2 || status==3 ||status==4 ||status==6 ">'
										+ '<a style="text-decoration:none;margin-right:5px;" href="javascript:showDetail({id});"><img src="extjs/resources/icons/application_view_detail.png"  title="查看二维码" alt="" class="查看二维码" />&nbsp;</a>'
										+ '</tpl>'
							}

					],
					dockedItems : [
							{
								xtype : "pagingtoolbar",
								store : applyOrdersStore,
								dock : "bottom",
								displayInfo : true,
								items : [
										'-',
										'&nbsp;&nbsp;',
										new Ext.form.field.ComboBox(
												{
													id : 'pagesize_combo',
													hiddenName : 'pagesize',
													typeAhead : true,
													triggerAction : 'all',
													lazyRender : true,
													queryMode : 'local',
													store : new Ext.data.ArrayStore(
															{
																fields : [
																		'value',
																		'text' ],
																data : [
																		[ 20,
																				'20条/页' ],
																		[ 40,
																				'40条/页' ],
																		[ 60,
																				'60条/页' ],
																		[ 80,
																				'80条/页' ],
																		[ 100,
																				'100条/页' ] ]
															}),
													valueField : 'value',
													displayField : 'text',
													value : DEFAULT_EACH_PAGE_DATA,
													editable : false,
													width : 85,
													listeners : {
														"select" : function(
																comboBox) {
															var pageSize = parseInt(comboBox
																	.getValue());
															applyOrdersStore.pageSize = pageSize;
															applyOrdersStore.currentPage = 1;
															applyOrdersStore
																	.load();
														}
													}
												}) ]
							},
							{
								xtype : "toolbar",
								style : 'border-width:0px 1px 1px 1px;background-image: none',
								hideFlag : true,
								hidden : true,
								items : [
										{
											xtype : "textfield",
											fieldLabel : '订单号',
											name : 'searchOrderNum',
											id : "searchOrderNumId",
											labelWidth : 50
										},
										"-",
										{
											text : "搜索",
											icon : "extjs/resources/icons/zoom.png",
											handler : function() {
												query();
											}
										},
										{
											text : "重置",
											icon : "extjs/resources/icons/arrow_rotate_anticlockwise.png",
											handler : function() {
												Ext.getCmp('searchOrderNumId')
														.setValue('');

												// 刷新列表
												query();
											}
										} ]
							} ]
				});

		/**
		 * 布局
		 */
		var viewport = new Ext.Viewport( {
			layout : "fit",
			items : [ applyOrdersGrid ]
		});

	});

// 关闭工单
function closeApplyOrderOrder(id) {
	Ext.MessageBox
			.prompt(
					"是否关闭订单",
					"请输入理由",
					function(e, value) {
						if (e == "ok") {
							CKGobal
									.ajax( {
										url : 'applyOrderManager/applyOrder!saveCloseApplyOrder.action',
										params : {
											"cloudContext.vo.id" : id,
											"cloudContext.vo.desc" : value
										},
										async : false,
										success : function(response, options,
												resultJSON) {
											Ext.Msg.alert("提示", "操作成功");
											applyOrdersStore.load();
										}
									});
						}
					}, this, true);
}
function showDetail(id) {
	window
			.open("applyOrderManager/applyOrder!showEquipmentOrderDetail.action?cloudContext.vo.id="
					+ id);
}

// 日期转换器
function subStringDate(value) {

	if (value == null || value == 'undefined') {
		return "";
	} else {
		return value.replace("T", " ");
	}
}

function query() {
	var params = {
		
		"cloudContext.vo.ordrNum" : Ext.getCmp('searchOrderNumId').getValue()
	};
	applyOrdersStore.proxy.extraParams = params;
	applyOrdersStore.load();
}
　function icon(val){   

　　　　return '<img src="'+val+'"  style="width:30px; height:30px;"/>'  

　　}  




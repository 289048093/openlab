$(function() {
			$('#insertequipment').click(function() {
						$.dialog({
									url : "resource/equipment/add_.jsp",
									title : "添加设备",
									confirmStr: "添加",
									cancelStr:"取消",
									action:"equipmentManager/equipment!addEquipment.action",
									method:"post"
								});
					});
		});

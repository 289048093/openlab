<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<title>����ͼ��ݼ�����</title>
		<style type="text/css">
#top_menu11 {
	PADDING-RIGHT: 0px;
	PADDING-LEFT: 12px;
	FONT-SIZE: 12px;
	FLOAT: left;
	PADDING-BOTTOM: 0px; /*OVERFLOW: hidden; WIDTH: 200px;*/
	PADDING-TOP: 0px;
	HEIGHT: 16px;
	TEXT-ALIGN: left
}

#top_menu11 UL {
	PADDING-RIGHT: 0px;
	PADDING-LEFT: 0px;
	FLOAT: left;
	PADDING-BOTTOM: 0px;
	MARGIN: 0px; /*OVERFLOW: hidden; WIDTH: 200px;*/
	PADDING-TOP: 0px;
	LIST-STYLE-TYPE: none;
	HEIGHT: 16px
}

#top_menu11 LI {
	FLOAT: left;
	OVERFLOW: hidden;
	MARGIN-RIGHT: 5px
}

.mod14 {
	WIDTH: 400px;
	HEIGHT: 66px;
	FONT-SIZE: 12px
}

.logo_sz {
	
}

.mod14_right {
	width: 480px;
	padding-left: 0px;
	float: left;
}

.mod14_2 {
	width: 480px;
	padding-left: 0px;
	padding-top: 0px;
	text-align: left;
}

.mod14_3 {
	width: 480px;
	padding-left: 0px;
	padding-top: 3px;
	text-align: left;
}

#top_menu11 a {
	text-decoration: none;
}
</style>
		<script type="text/javascript">
	<!--
	var boottype="<INPUT type=radio CHECKED value=all name=Field id=slt0> <LABEL for=slt0>ȫ���ֶ�</LABEL><INPUT type=radio value=1 name=Field id=slt1> <LABEL for=slt1 id='bookn'>����</LABEL><INPUT type=radio value=2 name=Field id=slt2><LABEL for=slt2>����</LABEL>";
	var magtype="<INPUT id=slt3 type=radio value=3 name=Field ><label for=slt3>����</label><INPUT id=slt4 type=radio value=4 name=Field ><label for=slt4>�ؼ���</label>";
	var hylwtype="<INPUT id=slt3 type=radio value=3 name=Field ><label for=slt3>�ؼ���</label><INPUT id=slt4 type=radio value=4 name=Field ><label for=slt4>�������� </label>";
	var xwlwtype="<INPUT id=slt4 type=radio value=4 name=Field ><label for=slt4>���赥λ</label><INPUT id=slt3 type=radio value=3 name=Field ><label for=slt3>�ؼ���</label>";
	var baozhi="<INPUT type=radio CHECKED value=all name=Field id=slt0> <LABEL for=slt0>ȫ���ֶ�</LABEL><INPUT type=radio value=1 name=Field id=slt1> <LABEL for=slt1 id='bookn'>����</LABEL><INPUT type=radio value=2 name=Field id=slt2><LABEL for=slt2>����</LABEL><INPUT type=radio value=3 name=Field id=slt3><LABEL for=slt3>��Դ</LABEL>";
	var gnbz="<INPUT type=radio CHECKED value=all name=Field id=slt0> <LABEL for=slt0>ȫ���ֶ�</LABEL><INPUT type=radio value=1 name=Field id=slt1> <LABEL for=slt1 id='bookn'>��׼��</LABEL><INPUT type=radio value=2 name=Field id=slt2><LABEL for=slt2>��׼������</LABEL><INPUT type=radio value=3 name=Field id=slt3><LABEL for=slt3>��׼Ӣ����</LABEL>";
	var zl="<INPUT type=radio CHECKED value=all name=Field id=slt0> <LABEL for=slt0>ȫ���ֶ�</LABEL><INPUT type=radio value=1 name=Field id=slt1> <LABEL for=slt1 id='bookn'>�����</LABEL><INPUT type=radio value=2 name=Field id=slt2><LABEL for=slt2>ר������</LABEL><INPUT type=radio value=3 name=Field id=slt3><LABEL for=slt3>������</LABEL><INPUT type=radio value=4 name=Field id=slt4><LABEL for=slt4>IPC��</LABEL>";
	var morenid = "me_0";
	function changeTag(id,channel){
		document.getElementById(morenid).style.display = "block";
		document.getElementById(morenid+"_1").style.display = "none";
		document.getElementById(id).style.display = "none";
		document.getElementById(id+"_1").style.display = "block";
		if(document.getElementById("me_0_1_1"))
			document.getElementById("me_0_1_1").style.display = "block";
			
		
		switch(channel){
		case "search":{
				document.getElementById("me_0_1_1").innerHTML=boottype;
				break;
			}
			case "goqw.jsp":{
				document.getElementById("me_0_1_1").style.display="none";
				break;
			}
			case "searchJour":{
				document.getElementById("me_0_1_1").innerHTML=boottype+magtype;
				break;
			}
			case "searchCP":{
				document.getElementById("me_0_1_1").innerHTML=boottype+hylwtype;
				break;
			}
			case "searchThesis":{
				document.getElementById("me_0_1_1").innerHTML=boottype+xwlwtype;
				break;
			}
			case "searchPatent":{
				document.getElementById("me_0_1_1").innerHTML=zl;
				break;
			}
			case "searchNP":{
				document.getElementById("me_0_1_1").innerHTML=baozhi;
				break;
			}
			case "searchStd":{
				document.getElementById("me_0_1_1").innerHTML=gnbz;
				break;
			}
			default:{
				document.getElementById("me_0_1_1").style.display="none";;
				break;
			}
	}
		morenid = id;
		document.getElementById("channel").value = channel;
	}
	function clean(e){
		e.value="";
	}
	//-->
	</script>
	</head>
	<body>
		<DIV class=mod14>
			<DIV class="logo_sz">
			</DIV>
			<DIV class="mod14_right" style="margin-top: 6px">
				<form id=form1
					action="http://www.szdnet.org.cn/login/duxiuquery.action"
					method="get" target="_blank">
					<DIV id=top_menu11>
						<UL>
							<LI id=me_1_1
								style="DISPLAY: none; FONT-WEIGHT: bold; WIDTH: 60px">
								<A style="WIDTH: 56px; TEXT-DECORATION: none"><FONT
									color=#000000>ȫ�ļ���</FONT>
								</A>
							</LI>
							<LI id=me_1 style="WIDTH: 56px">
								<A style="WIDTH: 60px" onclick="changeTag('me_1','goqw.jsp');"
									href="javascript:">ȫ�ļ���</A>
							</LI>
							<LI id=me_0_1
								style="DISPLAY: block; FONT-WEIGHT: bold; WIDTH: 34px">
								<A style="WIDTH: 30px; TEXT-DECORATION: none"><FONT
									color=#000000>ͼ��</FONT>
								</A>
							</LI>
							<LI id=me_0 style="DISPLAY: none; WIDTH: 34px; HEIGHT: 20px">
								<A style="WIDTH: 30px" onClick="changeTag('me_0','search');"
									href="javascript:">ͼ��</A>
							</LI>
							<LI id=me_2_1
								style="DISPLAY: none; FONT-WEIGHT: bold; WIDTH: 32px">
								<A style="WIDTH: 32px; TEXT-DECORATION: none"><FONT
									color=#000000>�ڿ�</FONT>
								</A>
							</LI>
							<LI id=me_2 style="WIDTH: 30px">
								<A style="WIDTH: 30px" onclick="changeTag('me_2','searchJour');"
									href="javascript:">�ڿ�</A>
							</LI>
							<LI id=me_3_1
								style="DISPLAY: none; FONT-WEIGHT: bold; WIDTH: 32px">
								<A style="WIDTH: 32px; TEXT-DECORATION: none"><FONT
									color=#000000>��ֽ</FONT>
								</A>
							</LI>
							<LI id=me_3 style="WIDTH: 30px">
								<A style="WIDTH: 30px" onclick="changeTag('me_3','searchNP');"
									href="javascript:">��ֽ</A>
							</LI>
							<LI id=me_4_1
								style="DISPLAY: none; FONT-WEIGHT: bold; WIDTH: 58px">
								<A style="WIDTH: 58px; TEXT-DECORATION: none"><FONT
									color=#000000>ѧλ����</FONT>
								</A>
							</LI>
							<LI id=me_4 style="WIDTH: 55px">
								<A style="WIDTH: 55px"
									onclick="changeTag('me_4','searchThesis');" href="javascript:">ѧλ����</A>
							</LI>
							<LI id=me_5_1
								style="DISPLAY: none; FONT-WEIGHT: bold; WIDTH: 58px">
								<A style="WIDTH: 58px; TEXT-DECORATION: none"><FONT
									color=#000000>��������</FONT>
								</A>
							</LI>
							<LI id=me_5 style="WIDTH: 55px">
								<A style="WIDTH: 55px" onclick="changeTag('me_5','searchCP');"
									href="javascript:">��������</A>
							</LI>
							<LI id=me_6_1
								style="DISPLAY: none; FONT-WEIGHT: bold; WIDTH: 32px">
								<A style="WIDTH: 32px; TEXT-DECORATION: none"><FONT
									color=#000000>ר��</FONT>
								</A>
							</LI>
							<LI id=me_6 style="WIDTH: 30px">
								<A style="WIDTH: 30px"
									onclick="changeTag('me_6','searchPatent');" href="javascript:">ר��</A>
							</LI>
							<LI id=me_7_1
								style="DISPLAY: none; FONT-WEIGHT: bold; WIDTH: 32px">
								<A style="WIDTH: 32px; TEXT-DECORATION: none"><FONT
									color=#000000>��׼</FONT>
								</A>
							</LI>
							<LI id=me_7 style="WIDTH: 30px">
								<A style="WIDTH: 30px" onclick="changeTag('me_7','searchStd');"
									href="javascript:">��׼</A>
							</LI>
						</UL>
					</DIV>
					<DIV class=mod14_2>
						<INPUT id=channel type=hidden value=search name=channel />
						<input name="ec" value="GBK" type="hidden" />
						<input name="sn" value="0101010101" type="hidden" />
						<input name="gid" value="1" type="hidden" />
						<input id=sw
							style="FONT-SIZE: 14px; WIDTH: 348px; height: 18px; padding-top: 4px;"
							maxlength=64
							onClick="if(value=='���������')value='';style.color='#333'"
							onBlur="if(value=='')value='���������';style.color='#333'"
							value="���������" name=sw />
							&nbsp; 
						<INPUT type=submit value=���� name=Submit
							style="font-size: 14px; vertical-align: top" />
					</DIV>
					<DIV id=me_0_1_1 class=mod14_3>
						<INPUT type=radio CHECKED value=all name=Field id=slt0 />
						<LABEL for=slt0>
							ȫ���ֶ�
						</LABEL>
						<INPUT type=radio value=1 name=Field id=slt1 />
						<LABEL for=slt1 id='bookn'>
							����
						</LABEL>
						<INPUT type=radio value=2 name=Field id=slt2 />
						<LABEL for=slt2>
							����
						</LABEL>
					</div>
				</form>
			</DIV>
		</DIV>
	</body>
</html>

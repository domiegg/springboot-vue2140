<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>修改公文信息</TITLE>
	    <link rel="stylesheet" href="kindeditor_a5/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor_a5/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor_a5/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor_a5/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor_a5/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="zhengwen"]', {
				cssPath : 'kindeditor_a5/plugins/code/prettify.css',
				uploadJson : 'kindeditor_a5/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor_a5/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="gongwenxinxi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateGongwenxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改公文信息<input type="hidden" name="id" value="${gongwenxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">公文编号：</td><td><input name='gongwenbianhao' type='text' id='gongwenbianhao' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelgongwenbianhao' /></td></tr>
		<tr ><td width="200">公文标题：</td><td><input name='gongwenbiaoti' type='text' id='gongwenbiaoti' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelgongwenbiaoti' /></td></tr>
		<tr ><td width="200">摘要：</td><td><input name='zhaiyao' type='text' id='zhaiyao' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr ><td width="200">正文：</td><td><textarea name="zhengwen" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea></td></tr>
		<tr ><td width="200">来文单位：</td><td><input name='laiwendanwei' type='text' id='laiwendanwei' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr ><td width="200">收文日期：</td><td><input name='shouwenriqi' type='text' id='shouwenriqi' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/></td></tr>
		<tr ><td width="200">附件：</td><td><input name='fujian' type='text' id='fujian' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('fujian')" style='border:solid 1px #000000; color:#666666'/></td></tr>
		<tr ><td width="200">添加 人：</td><td><input name='tianjiaren' type='text' id='tianjiaren' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.gongwenbianhao.value='${gongwenxinxi.gongwenbianhao}';</script>
	<script language="javascript">document.form1.gongwenbiaoti.value='${gongwenxinxi.gongwenbiaoti}';</script>
	<script language="javascript">document.form1.zhaiyao.value='${gongwenxinxi.zhaiyao}';</script>
	<script language="javascript">document.form1.zhengwen.value='${gongwenxinxi.zhengwen}';</script>
	<script language="javascript">document.form1.laiwendanwei.value='${gongwenxinxi.laiwendanwei}';</script>
	<script language="javascript">document.form1.shouwenriqi.value='${gongwenxinxi.shouwenriqi}';</script>
	<script language="javascript">document.form1.fujian.value='${gongwenxinxi.fujian}';</script>
	<script language="javascript">document.form1.tianjiaren.value='${gongwenxinxi.tianjiaren}';</script>
	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var gongwenbianhaoobj = document.getElementById("gongwenbianhao"); if(gongwenbianhaoobj.value==""){document.getElementById("clabelgongwenbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入公文编号</font>";return false;}else{document.getElementById("clabelgongwenbianhao").innerHTML="  "; } 
	var gongwenbiaotiobj = document.getElementById("gongwenbiaoti"); if(gongwenbiaotiobj.value==""){document.getElementById("clabelgongwenbiaoti").innerHTML="&nbsp;&nbsp;<font color=red>请输入公文标题</font>";return false;}else{document.getElementById("clabelgongwenbiaoti").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  

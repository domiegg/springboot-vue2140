<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="weiquanxinxihsgb" scope="page" class="com.bean.WeiquanxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=weiquanxinxi.xls");
%>
<html>
  <head>
    <title>维权信息</title>
  </head>

  <body >
 <%
			String sql="select * from weiquanxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>标题</td>        <td  width='90' align='center'>材料</td>    <td align='center'>姓名</td>    <td align='center'>联系电话</td>    <td align='center'>状态</td>    <td align='center'>回复</td>    <td align='center'>添加人</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=weiquanxinxihsgb.getAllWeiquanxinxi(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.biaoti}</td>        <td width='90' align='center'><a href='${u.cailiao}' target='_blank'>下载</a></td>    <td>${u.xingming}</td>    <td>${u.lianxidianhua}</td>    <td>${u.zhuangtai}</td>    <td>${u.huifu}</td>    <td>${u.tianjiaren}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


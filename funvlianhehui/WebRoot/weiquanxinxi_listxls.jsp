<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="weiquanxinxihsgb" scope="page" class="com.bean.WeiquanxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=weiquanxinxi.xls");
%>
<html>
  <head>
    <title>άȨ��Ϣ</title>
  </head>

  <body >
 <%
			String sql="select * from weiquanxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>����</td>        <td  width='90' align='center'>����</td>    <td align='center'>����</td>    <td align='center'>��ϵ�绰</td>    <td align='center'>״̬</td>    <td align='center'>�ظ�</td>    <td align='center'>�����</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=weiquanxinxihsgb.getAllWeiquanxinxi(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.biaoti}</td>        <td width='90' align='center'><a href='${u.cailiao}' target='_blank'>����</a></td>    <td>${u.xingming}</td>    <td>${u.lianxidianhua}</td>    <td>${u.zhuangtai}</td>    <td>${u.huifu}</td>    <td>${u.tianjiaren}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="gongwenxinxihsgb" scope="page" class="com.bean.GongwenxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=gongwenxinxi.xls");
%>
<html>
  <head>
    <title>������Ϣ</title>
  </head>

  <body >
 <%
			String sql="select * from gongwenxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>���ı��</td>
    <td align='center'>���ı���</td>
    <td align='center'>ժҪ</td>
    
    <td align='center'>���ĵ�λ</td>
    <td  width='65' align='center'>��������</td>
    <td  width='90' align='center'>����</td>
    <td align='center'>��� ��</td>
    <td  width='80' align='center'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=gongwenxinxihsgb.getAllGongwenxinxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.gongwenbianhao}</td>
    <td>${u.gongwenbiaoti}</td>
    <td>${u.zhaiyao}</td>
    
    <td>${u.laiwendanwei}</td>
    <td>${u.shouwenriqi}</td>
    <td width='90' align='center'><a href='${u.fujian}' target='_blank'>����</a></td>
    <td>${u.tianjiaren}</td>
    <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=gongwenxinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>走访信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  走访信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>标题：</td><td width='39%'>${zoufangxinxi.biaoti}</td>     <td width='11%'>时间：</td><td width='39%'>${zoufangxinxi.shijian}</td></tr><tr>     <td width='11%'>地点：</td><td width='39%'>${zoufangxinxi.didian}</td>     <td width='11%'>走访人员：</td><td width='39%'>${zoufangxinxi.zoufangrenyuan}</td></tr><tr>     <td width='11%'>详情：</td><td width='39%'>${zoufangxinxi.xiangqing}</td>     <td width='11%'>发布人：</td><td width='39%'>${zoufangxinxi.faburen}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>


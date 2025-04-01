<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>公文信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  公文信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>公文编号：</td><td width='39%'>${gongwenxinxi.gongwenbianhao}</td>
     <td width='11%'>公文标题：</td><td width='39%'>${gongwenxinxi.gongwenbiaoti}</td></tr><tr>
     <td width='11%'>摘要：</td><td width='39%'>${gongwenxinxi.zhaiyao}</td>
     <td width='11%'>正文：</td><td width='39%'>${gongwenxinxi.zhengwen}</td></tr><tr>
     <td width='11%'>来文单位：</td><td width='39%'>${gongwenxinxi.laiwendanwei}</td>
     <td width='11%'>收文日期：</td><td width='39%'>${gongwenxinxi.shouwenriqi}</td></tr><tr>
     <td width='11%'>附件：</td><td width='39%'><a href="${gongwenxinxi.fujian}">点此下载</a></td>
     <td width='11%'>添加 人：</td><td width='39%'>${gongwenxinxi.tianjiaren}</td>
     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>


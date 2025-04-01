<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>维权信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  维权信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>标题：</td><td width='39%'>${weiquanxinxi.biaoti}</td>     <td width='11%'>维权内容：</td><td width='39%'>${weiquanxinxi.weiquanneirong}</td></tr><tr>     <td width='11%'>材料：</td><td width='39%'><a href="${weiquanxinxi.cailiao}">点此下载</a></td>     <td width='11%'>姓名：</td><td width='39%'>${weiquanxinxi.xingming}</td></tr><tr>     <td width='11%'>联系电话：</td><td width='39%'>${weiquanxinxi.lianxidianhua}</td>     <td width='11%'>状态：</td><td width='39%'>${weiquanxinxi.zhuangtai}</td></tr><tr>     <td width='11%'>回复：</td><td width='39%'>${weiquanxinxi.huifu}</td>     <td width='11%'>添加人：</td><td width='39%'>${weiquanxinxi.tianjiaren}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>


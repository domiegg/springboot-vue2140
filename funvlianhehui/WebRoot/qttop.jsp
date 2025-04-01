<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<div class="itop">
  <div class="itopc">
    <div class="itopcl"><span>欢迎进入妇女联合会管理系统公司官网!</span></div>
    <div class="itopcr">
	  <div align="right">
	   <%
    if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")==""){
     %>
	      <a href="userlog.jsp">用户登陆</a><span>|</span><a href="userreg.jsp">用户注册</a>
        <%
							}
				  else
				  {
				 %>
	    当前用户:<%=request.getSession().getAttribute("username")%>,权限:<%=request.getSession().getAttribute("cx")%>;&nbsp;&nbsp; <a href="logout.jsp">退出</a><span>|</span><a href="main.jsp">个人后台</a>
	     <% } %>
        </div>
    </div>
  </div>
</div>
<div class="ilogo">
  <div class="ilogoc">
    <div class="ilogol"><img src="qtimages/timg.jpg" width="70" height="65" />
      <p><strong>妇女联合会管理系统</strong><br>
        <span>全力打造,精心呵护</span></p>
    </div>
    <div class="ilogor">
      <p>全国咨询热线：<br>
        <strong>400-xxxx-xxxx</strong></p>
    </div>
    <div class="clear"></div>
  </div>
</div>

<div id="hsgbanner">
		<div  class="navgrp">
		
			<ul class="nav" id="nav">
				
			  <li class="cur" ><a href="index.do">网站首页</a></li>
			<!--  <li ><a href="dx_detail.jsp?lb=系统简介">系统简介</a> </li>-->
			  <li><a href="userreg.jsp">用户注册</a></li>
			  <li><a href="xwtzList.do?lb=法律法规">法律法规</a> </li>
			  <li><a href="gwxxList.do">公文信息</a> </li>
			  <li><a style="cursor:pointer">在线留言</a>
				<div id="navChild"> <a href="lyb.jsp">我要留言</a> <a href="lybList.do">查看留言</a> </div>
			  </li>
			  
			   <li><a style="cursor:pointer">走进妇联</a>
				<div id="navChild"> <a href="dx_detail.jsp?lb=妇联简介">妇联简介</a> <a href="dx_detail.jsp?lb=组织机构">组织机构</a> </div>
			  </li>
			  <li><a href="zfxxList.do">走访动态</a> </li>
			  <li><a href="weiquanxinxiadd.jsp">妇女维权</a> </li>


			   <li><a href="login.jsp">后台管理</a> </li>
			</ul>
        </div>
 </div>
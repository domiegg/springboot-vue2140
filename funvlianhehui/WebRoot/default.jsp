<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.db"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>妇女联合会管理系统网站首页</title>
<link rel="stylesheet" type="text/css" href="qtimages/css/fxke.css"/>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

<body>

<!--新头部的开始-->

<jsp:include page="qttop.jsp"></jsp:include>
<!--新头部的结束--> 

<!--ban图片切换开始-->

<jsp:include page="bht.jsp"></jsp:include>
<!--ban图片切换结束--> 

<!--视频和关于我们的开始-->
<div class="spgy"> 
  <!--视频的开始-->
  <div class="sspzx">
    <div class="sspzx1"> <strong class="bt1">走访视频</strong><span class="bt2">Video Introduction</span></div>
    <div class="sspzx2"> 
      
      <embed pluginspage="http://www.macromedia.com/go/getflashplayer" src="http://player.youku.com/player.php/sid/XNDA5MjYxOTEy/v.swf" type="application/x-shockwave-flash" name="ssss" allowfullscreen="true" allowscriptaccess="always" width="340" height="245"> 
    </div>
  </div>
  <!--视频的结束--> 
  <!--关于我们的开始-->
  <div class="gywm">
    <div class="gywm1"> <strong class="bt1">关于我们</strong><span class="bt2">About Us</span><a class="gd" href="dx_detail.php?lb=关于我们"
                    target="_blank">更多&gt;&gt;</a></div>
    <div class="gywm2"> <img src="qtimages/damen.jpg" width="244" height="240" />
      <h2> 妇女联合会管理系统</h2>
      <p>  妇女联合会管理系统妇女联合会管理系统妇女联合会管理系统妇女联合会管理系统妇女联合会管理系统妇女联合会管理系统妇女联合会管理系统妇女联合会管理系统妇女联合会管理系统妇女联合会管理系统妇女联合会管理系统!<a
                        href="" target="_blank">[详情]</a> </p>
      <div style="clear: both;"> </div>
    </div>
  </div>
  <!--关于我们的结束-->
  <div style="clear: both;"> </div>
</div>
<!--视频和关于我们的结束--> 



<!--新闻中心的开始-->
<div class="jxwzx"> 
  <!--左侧新闻的开始-->
  <div class="jnews fl"> 
    <!--标题的开始-->
    <div class="jnews_title">
      <ul>
        <li style="border-right:1px solid #d6d6d6;" id="lm1" onmousemove="setTabb(1)" class="selectTab4"><a href="#"><strong>法律法规</strong><span>COMPANY NEWS</span></a></li>
     
      </ul>
    </div>
    <!--标题的开始--> 
    <!--内容的开始-->
    <div class="jnews_nr">
      <div class="newsxian" id="Setln1"> 
        <!--单个的开始-->
        <div class="newsc">
		
          
          <!--推荐新闻的结束-->
          <div class="newss_list">
            <ul>
			 <c:forEach items="${syxinwentongzhi1 }" var="a">
        <li><a href="xwtzDetail.do?id=${a.id}">${fn:substring(a.biaoti, 0, 24)}</a><span>${fn:substring(a.addtime, 0, 10)}</span></li>
          </c:forEach>
             
            </ul>
          </div>
        </div>
        <!--单个的结束--> 
      </div>
      <div class="newsyin" id="Setln2"> 
        <!--单个的开始-->
        <div class="newsc">
		 
          <!--推荐新闻的开始--> 
          
          <!--推荐新闻的结束-->
          <div class="newss_list">
            <ul>
			   <c:forEach items="${syxinwentongzhi2 }" var="a">
        <li><a href="xwtzDetail.do?id=${a.id}">${fn:substring(a.biaoti, 0, 24)}</a><span>${fn:substring(a.addtime, 0, 10)}</span></li>
          </c:forEach>
             
            </ul>
          </div>
        </div>
        <!--单个的结束--> 
      </div>
    </div>
    <!--内容的结束--> 
  </div>
  <script src="js/sy.js" type="text/javascript"></script>
  <!--左侧新闻的结束--> 
  <!--右侧联系我们的开始-->
  <div class="jlxwm fr">
    <div class="jlxwm1" ><strong class="bt1">联系我们</strong><span class="bt2">Contact Us</span><a class="gd" href="dx_detail.php?lb=联系我们" >更多&gt;&gt;</a></div>
    <div class="slxwmc">
      <div class="dianhua">全国服务电话：<br>
        <span style="font-size:20px;">400-008-0378</span></div>
      <p><strong>妇女联合会管理系统有限公司</strong><br />
      
        传真：0371-xxxxxx <br />
        电子邮箱：xxxxxx@126.com<br />
        地址：xxxxxxxx<br />
        办事处电话：0991-xxxxxx<br />
        传真：0991-xxxxxx<br />
        地址：xxxxxxxxxxxxxxxx号</p>
    </div>
  </div>
  <!--右侧联系我们结束-->
  <div class="clear"></div>
</div>

<!--新闻中心的结束--> 

<!--友情链接的开始-->

<jsp:include page="qtdown.jsp"></jsp:include>
<!--底部的结束-->

</body>

<!--图片切换-->


</html>

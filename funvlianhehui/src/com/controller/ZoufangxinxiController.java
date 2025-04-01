package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Zoufangxinxi;
import com.server.ZoufangxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZoufangxinxiController {
	@Resource
	private ZoufangxinxiServer zoufangxinxiService;


   
	@RequestMapping("addZoufangxinxi.do")
	public String addZoufangxinxi(HttpServletRequest request,Zoufangxinxi zoufangxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		zoufangxinxi.setAddtime(time.toString().substring(0, 19));
		zoufangxinxiService.add(zoufangxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "zoufangxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:zoufangxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateZoufangxinxi.do")
	public String doUpdateZoufangxinxi(int id,ModelMap map,Zoufangxinxi zoufangxinxi){
		zoufangxinxi=zoufangxinxiService.getById(id);
		map.put("zoufangxinxi", zoufangxinxi);
		return "zoufangxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("zoufangxinxiDetail.do")
	public String zoufangxinxiDetail(int id,ModelMap map,Zoufangxinxi zoufangxinxi){
		zoufangxinxi=zoufangxinxiService.getById(id);
		map.put("zoufangxinxi", zoufangxinxi);
		return "zoufangxinxi_detail";
	}
//	前台详细
	@RequestMapping("zfxxDetail.do")
	public String zfxxDetail(int id,ModelMap map,Zoufangxinxi zoufangxinxi){
		zoufangxinxi=zoufangxinxiService.getById(id);
		map.put("zoufangxinxi", zoufangxinxi);
		return "zoufangxinxidetail";
	}
//	
	@RequestMapping("updateZoufangxinxi.do")
	public String updateZoufangxinxi(int id,ModelMap map,Zoufangxinxi zoufangxinxi,HttpServletRequest request,HttpSession session){
		zoufangxinxiService.update(zoufangxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zoufangxinxiList.do";
	}

//	分页查询
	@RequestMapping("zoufangxinxiList.do")
	public String zoufangxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zoufangxinxi zoufangxinxi, String biaoti, String shijian1,String shijian2, String didian, String zoufangrenyuan, String xiangqing, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(shijian1==null||shijian1.equals("")){pmap.put("shijian1", null);}else{pmap.put("shijian1", shijian1);}		if(shijian2==null||shijian2.equals("")){pmap.put("shijian2", null);}else{pmap.put("shijian2", shijian2);}		if(didian==null||didian.equals("")){pmap.put("didian", null);}else{pmap.put("didian", didian);}		if(zoufangrenyuan==null||zoufangrenyuan.equals("")){pmap.put("zoufangrenyuan", null);}else{pmap.put("zoufangrenyuan", zoufangrenyuan);}		if(xiangqing==null||xiangqing.equals("")){pmap.put("xiangqing", null);}else{pmap.put("xiangqing", xiangqing);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=zoufangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zoufangxinxi> list=zoufangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zoufangxinxi_list";
	}
	
	@RequestMapping("zoufangxinxiList2.do")
	public String zoufangxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zoufangxinxi zoufangxinxi, String biaoti, String shijian1,String shijian2, String didian, String zoufangrenyuan, String xiangqing, String faburen,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("faburen", (String)request.getSession().getAttribute("username"));
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(shijian1==null||shijian1.equals("")){pmap.put("shijian1", null);}else{pmap.put("shijian1", shijian1);}		if(shijian2==null||shijian2.equals("")){pmap.put("shijian2", null);}else{pmap.put("shijian2", shijian2);}		if(didian==null||didian.equals("")){pmap.put("didian", null);}else{pmap.put("didian", didian);}		if(zoufangrenyuan==null||zoufangrenyuan.equals("")){pmap.put("zoufangrenyuan", null);}else{pmap.put("zoufangrenyuan", zoufangrenyuan);}		if(xiangqing==null||xiangqing.equals("")){pmap.put("xiangqing", null);}else{pmap.put("xiangqing", xiangqing);}		
		
		int total=zoufangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zoufangxinxi> list=zoufangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zoufangxinxi_list2";
	}	
	
	@RequestMapping("zfxxList.do")
	public String zfxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zoufangxinxi zoufangxinxi, String biaoti, String shijian1,String shijian2, String didian, String zoufangrenyuan, String xiangqing, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(shijian1==null||shijian1.equals("")){pmap.put("shijian1", null);}else{pmap.put("shijian1", shijian1);}		if(shijian2==null||shijian2.equals("")){pmap.put("shijian2", null);}else{pmap.put("shijian2", shijian2);}		if(didian==null||didian.equals("")){pmap.put("didian", null);}else{pmap.put("didian", didian);}		if(zoufangrenyuan==null||zoufangrenyuan.equals("")){pmap.put("zoufangrenyuan", null);}else{pmap.put("zoufangrenyuan", zoufangrenyuan);}		if(xiangqing==null||xiangqing.equals("")){pmap.put("xiangqing", null);}else{pmap.put("xiangqing", xiangqing);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=zoufangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zoufangxinxi> list=zoufangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zoufangxinxilist";
	}
	
	@RequestMapping("deleteZoufangxinxi.do")
	public String deleteZoufangxinxi(int id,HttpServletRequest request){
		zoufangxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zoufangxinxiList.do";
	}
	
	@RequestMapping("quchongZoufangxinxi.do")
	public void quchongZoufangxinxi(Zoufangxinxi zoufangxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("biaoti", zoufangxinxi.getBiaoti());
		   System.out.println("biaoti==="+zoufangxinxi.getBiaoti());
		   System.out.println("biaoti222==="+zoufangxinxiService.quchongZoufangxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(zoufangxinxiService.quchongZoufangxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "标题可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}

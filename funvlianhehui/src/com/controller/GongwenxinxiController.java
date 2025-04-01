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

import com.entity.Gongwenxinxi;
import com.server.GongwenxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class GongwenxinxiController {
	@Resource
	private GongwenxinxiServer gongwenxinxiService;


   
	@RequestMapping("addGongwenxinxi.do")
	public String addGongwenxinxi(HttpServletRequest request,Gongwenxinxi gongwenxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		gongwenxinxi.setAddtime(time.toString().substring(0, 19));
		gongwenxinxiService.add(gongwenxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "gongwenxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:gongwenxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateGongwenxinxi.do")
	public String doUpdateGongwenxinxi(int id,ModelMap map,Gongwenxinxi gongwenxinxi){
		gongwenxinxi=gongwenxinxiService.getById(id);
		map.put("gongwenxinxi", gongwenxinxi);
		return "gongwenxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("gongwenxinxiDetail.do")
	public String gongwenxinxiDetail(int id,ModelMap map,Gongwenxinxi gongwenxinxi){
		gongwenxinxi=gongwenxinxiService.getById(id);
		map.put("gongwenxinxi", gongwenxinxi);
		return "gongwenxinxi_detail";
	}
//	前台详细
	@RequestMapping("gwxxDetail.do")
	public String gwxxDetail(int id,ModelMap map,Gongwenxinxi gongwenxinxi){
		gongwenxinxi=gongwenxinxiService.getById(id);
		map.put("gongwenxinxi", gongwenxinxi);
		return "gongwenxinxidetail";
	}
//	
	@RequestMapping("updateGongwenxinxi.do")
	public String updateGongwenxinxi(int id,ModelMap map,Gongwenxinxi gongwenxinxi,HttpServletRequest request,HttpSession session){
		gongwenxinxiService.update(gongwenxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:gongwenxinxiList.do";
	}

//	分页查询
	@RequestMapping("gongwenxinxiList.do")
	public String gongwenxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongwenxinxi gongwenxinxi, String gongwenbianhao, String gongwenbiaoti, String zhaiyao, String zhengwen, String laiwendanwei, String shouwenriqi1,String shouwenriqi2, String fujian, String tianjiaren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gongwenbianhao==null||gongwenbianhao.equals("")){pmap.put("gongwenbianhao", null);}else{pmap.put("gongwenbianhao", gongwenbianhao);}
		if(gongwenbiaoti==null||gongwenbiaoti.equals("")){pmap.put("gongwenbiaoti", null);}else{pmap.put("gongwenbiaoti", gongwenbiaoti);}
		if(zhaiyao==null||zhaiyao.equals("")){pmap.put("zhaiyao", null);}else{pmap.put("zhaiyao", zhaiyao);}
		if(zhengwen==null||zhengwen.equals("")){pmap.put("zhengwen", null);}else{pmap.put("zhengwen", zhengwen);}
		if(laiwendanwei==null||laiwendanwei.equals("")){pmap.put("laiwendanwei", null);}else{pmap.put("laiwendanwei", laiwendanwei);}
		if(shouwenriqi1==null||shouwenriqi1.equals("")){pmap.put("shouwenriqi1", null);}else{pmap.put("shouwenriqi1", shouwenriqi1);}
		if(shouwenriqi2==null||shouwenriqi2.equals("")){pmap.put("shouwenriqi2", null);}else{pmap.put("shouwenriqi2", shouwenriqi2);}
		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}
		if(tianjiaren==null||tianjiaren.equals("")){pmap.put("tianjiaren", null);}else{pmap.put("tianjiaren", tianjiaren);}
		
		int total=gongwenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongwenxinxi> list=gongwenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongwenxinxi_list";
	}
	
	@RequestMapping("gongwenxinxiList2.do")
	public String gongwenxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongwenxinxi gongwenxinxi, String gongwenbianhao, String gongwenbiaoti, String zhaiyao, String zhengwen, String laiwendanwei, String shouwenriqi1,String shouwenriqi2, String fujian, String tianjiaren, String issh,HttpServletRequest request){
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
		
		pmap.put("tianjiaren", (String)request.getSession().getAttribute("username"));
		if(gongwenbianhao==null||gongwenbianhao.equals("")){pmap.put("gongwenbianhao", null);}else{pmap.put("gongwenbianhao", gongwenbianhao);}
		if(gongwenbiaoti==null||gongwenbiaoti.equals("")){pmap.put("gongwenbiaoti", null);}else{pmap.put("gongwenbiaoti", gongwenbiaoti);}
		if(zhaiyao==null||zhaiyao.equals("")){pmap.put("zhaiyao", null);}else{pmap.put("zhaiyao", zhaiyao);}
		if(zhengwen==null||zhengwen.equals("")){pmap.put("zhengwen", null);}else{pmap.put("zhengwen", zhengwen);}
		if(laiwendanwei==null||laiwendanwei.equals("")){pmap.put("laiwendanwei", null);}else{pmap.put("laiwendanwei", laiwendanwei);}
		if(shouwenriqi1==null||shouwenriqi1.equals("")){pmap.put("shouwenriqi1", null);}else{pmap.put("shouwenriqi1", shouwenriqi1);}
		if(shouwenriqi2==null||shouwenriqi2.equals("")){pmap.put("shouwenriqi2", null);}else{pmap.put("shouwenriqi2", shouwenriqi2);}
		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}
		
		
		int total=gongwenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongwenxinxi> list=gongwenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongwenxinxi_list2";
	}
	
	
	@RequestMapping("gwxxList.do")
	public String gwxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongwenxinxi gongwenxinxi, String gongwenbianhao, String gongwenbiaoti, String zhaiyao, String zhengwen, String laiwendanwei, String shouwenriqi1,String shouwenriqi2, String fujian, String tianjiaren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gongwenbianhao==null||gongwenbianhao.equals("")){pmap.put("gongwenbianhao", null);}else{pmap.put("gongwenbianhao", gongwenbianhao);}
		if(gongwenbiaoti==null||gongwenbiaoti.equals("")){pmap.put("gongwenbiaoti", null);}else{pmap.put("gongwenbiaoti", gongwenbiaoti);}
		if(zhaiyao==null||zhaiyao.equals("")){pmap.put("zhaiyao", null);}else{pmap.put("zhaiyao", zhaiyao);}
		if(zhengwen==null||zhengwen.equals("")){pmap.put("zhengwen", null);}else{pmap.put("zhengwen", zhengwen);}
		if(laiwendanwei==null||laiwendanwei.equals("")){pmap.put("laiwendanwei", null);}else{pmap.put("laiwendanwei", laiwendanwei);}
		if(shouwenriqi1==null||shouwenriqi1.equals("")){pmap.put("shouwenriqi1", null);}else{pmap.put("shouwenriqi1", shouwenriqi1);}
		if(shouwenriqi2==null||shouwenriqi2.equals("")){pmap.put("shouwenriqi2", null);}else{pmap.put("shouwenriqi2", shouwenriqi2);}
		if(fujian==null||fujian.equals("")){pmap.put("fujian", null);}else{pmap.put("fujian", fujian);}
		if(tianjiaren==null||tianjiaren.equals("")){pmap.put("tianjiaren", null);}else{pmap.put("tianjiaren", tianjiaren);}
		
		int total=gongwenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongwenxinxi> list=gongwenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongwenxinxilist";
	}
	
	@RequestMapping("deleteGongwenxinxi.do")
	public String deleteGongwenxinxi(int id,HttpServletRequest request){
		gongwenxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:gongwenxinxiList.do";
	}
	
	@RequestMapping("quchongGongwenxinxi.do")
	public void quchongGongwenxinxi(Gongwenxinxi gongwenxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("gongwenbianhao", gongwenxinxi.getGongwenbianhao());
		   System.out.println("gongwenbianhao==="+gongwenxinxi.getGongwenbianhao());
		   System.out.println("gongwenbianhao222==="+gongwenxinxiService.quchongGongwenxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(gongwenxinxiService.quchongGongwenxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "公文编号可以用！");
				  
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

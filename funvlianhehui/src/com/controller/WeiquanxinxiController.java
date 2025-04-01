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

import com.entity.Weiquanxinxi;
import com.server.WeiquanxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class WeiquanxinxiController {
	@Resource
	private WeiquanxinxiServer weiquanxinxiService;


   
	@RequestMapping("addWeiquanxinxi.do")
	public String addWeiquanxinxi(HttpServletRequest request,Weiquanxinxi weiquanxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		weiquanxinxi.setAddtime(time.toString().substring(0, 19));
		weiquanxinxiService.add(weiquanxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "weiquanxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:weiquanxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateWeiquanxinxi.do")
	public String doUpdateWeiquanxinxi(int id,ModelMap map,Weiquanxinxi weiquanxinxi){
		weiquanxinxi=weiquanxinxiService.getById(id);
		map.put("weiquanxinxi", weiquanxinxi);
		return "weiquanxinxi_updt";
	}
	
	
	
	@RequestMapping("doUpdateWeiquanxinxilb.do")
	public String doUpdateWeiquanxinxilb(int id,ModelMap map,Weiquanxinxi weiquanxinxi){
		weiquanxinxi=weiquanxinxiService.getById(id);
		map.put("weiquanxinxi", weiquanxinxi);
		return "weiquanxinxi_updtlb";
	}
	
@RequestMapping("updateWeiquanxinxilb.do")
	public String updateWeiquanxinxilb(int id,ModelMap map,Weiquanxinxi weiquanxinxi){
		weiquanxinxiService.updatelb(weiquanxinxi);
		return "redirect:weiquanxinxiList.do";
	}
	
//	后台详细
	@RequestMapping("weiquanxinxiDetail.do")
	public String weiquanxinxiDetail(int id,ModelMap map,Weiquanxinxi weiquanxinxi){
		weiquanxinxi=weiquanxinxiService.getById(id);
		map.put("weiquanxinxi", weiquanxinxi);
		return "weiquanxinxi_detail";
	}
//	前台详细
	@RequestMapping("wqxxDetail.do")
	public String wqxxDetail(int id,ModelMap map,Weiquanxinxi weiquanxinxi){
		weiquanxinxi=weiquanxinxiService.getById(id);
		map.put("weiquanxinxi", weiquanxinxi);
		return "weiquanxinxidetail";
	}
//	
	@RequestMapping("updateWeiquanxinxi.do")
	public String updateWeiquanxinxi(int id,ModelMap map,Weiquanxinxi weiquanxinxi,HttpServletRequest request,HttpSession session){
		weiquanxinxiService.update(weiquanxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:weiquanxinxiList.do";
	}

//	分页查询
	@RequestMapping("weiquanxinxiList.do")
	public String weiquanxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weiquanxinxi weiquanxinxi, String biaoti, String weiquanneirong, String cailiao, String xingming, String lianxidianhua, String zhuangtai, String huifu, String tianjiaren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(weiquanneirong==null||weiquanneirong.equals("")){pmap.put("weiquanneirong", null);}else{pmap.put("weiquanneirong", weiquanneirong);}		if(cailiao==null||cailiao.equals("")){pmap.put("cailiao", null);}else{pmap.put("cailiao", cailiao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}		if(tianjiaren==null||tianjiaren.equals("")){pmap.put("tianjiaren", null);}else{pmap.put("tianjiaren", tianjiaren);}		
		int total=weiquanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weiquanxinxi> list=weiquanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weiquanxinxi_list";
	}
	
	@RequestMapping("weiquanxinxiList2.do")
	public String weiquanxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weiquanxinxi weiquanxinxi, String biaoti, String weiquanneirong, String cailiao, String xingming, String lianxidianhua, String zhuangtai, String huifu, String tianjiaren,HttpServletRequest request){
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
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(weiquanneirong==null||weiquanneirong.equals("")){pmap.put("weiquanneirong", null);}else{pmap.put("weiquanneirong", weiquanneirong);}		if(cailiao==null||cailiao.equals("")){pmap.put("cailiao", null);}else{pmap.put("cailiao", cailiao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}		
		
		int total=weiquanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weiquanxinxi> list=weiquanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weiquanxinxi_list2";
	}	
	
	@RequestMapping("wqxxList.do")
	public String wqxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weiquanxinxi weiquanxinxi, String biaoti, String weiquanneirong, String cailiao, String xingming, String lianxidianhua, String zhuangtai, String huifu, String tianjiaren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(weiquanneirong==null||weiquanneirong.equals("")){pmap.put("weiquanneirong", null);}else{pmap.put("weiquanneirong", weiquanneirong);}		if(cailiao==null||cailiao.equals("")){pmap.put("cailiao", null);}else{pmap.put("cailiao", cailiao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}		if(tianjiaren==null||tianjiaren.equals("")){pmap.put("tianjiaren", null);}else{pmap.put("tianjiaren", tianjiaren);}		
		int total=weiquanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weiquanxinxi> list=weiquanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weiquanxinxilist";
	}
	
	@RequestMapping("deleteWeiquanxinxi.do")
	public String deleteWeiquanxinxi(int id,HttpServletRequest request){
		weiquanxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:weiquanxinxiList.do";
	}
	
	
}

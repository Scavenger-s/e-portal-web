package com.cusx.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cusx.content.service.ContentService;
import com.cusx.pojo.TbContent;


/**
 * 首页展示Controller 
 * @version 1.0
 */
@Controller
public class IndexController {
	
	@Value("${CONTENT_LUNBO_ID}")
	private Long CONTENT_LUNBO_ID;
	
	@Autowired
	private ContentService contentService;

	@RequestMapping("/index")
	public String showIndex(Model model) {
		List<TbContent> ad1List = contentService.getContentListByCid(CONTENT_LUNBO_ID);
		// 把结果传递给页面
		model.addAttribute("ad1List", ad1List);
		return "index";
	}
}

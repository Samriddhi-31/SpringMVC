package com.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("reports")
public class JasperReportsController {
	
	@RequestMapping(value="/pdf",method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> getReportPDF(){	
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", "Success");
		return map;
	}
}

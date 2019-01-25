package com.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.entities.UserDetails;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Users;
import com.servicesapi.UsersService;

@Controller
@RequestMapping("users")
public class UsersController {
	private static final Logger logger = Logger.getLogger("UserController");
	@Autowired
	UsersService userServices;

	@RequestMapping(value="/page", method = RequestMethod.GET)
	@ApiOperation(value = "create lead", produces ="application/json", consumes = "application/json")
	public ModelAndView getPage(){
		logger.info(" getPage ");
		ModelAndView view =new ModelAndView("users");
		return view;
	}
	//@ApiOperation(value = "create lead", produces = "application/json", consumes = "application/json")
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(/*@RequestBody*/ Users users){
		logger.info(" getsaved ");
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(users.getEmail());
		if(userServices.saveOrUpdate(users)){
			map.put("status","200");
			map.put("message","Your record have been saved successfully");
		}
		
		return map;
	}

	@ApiOperation(value = "create lead", produces = "application/json", consumes = "application/json")
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(Users users){
		logger.info(" getall ");
		Map<String,Object> map = new HashMap<String,Object>();
	
			List<Users> list = userServices.list();
			
			if (list != null){
				map.put("status","200");
				map.put("message","Data found");
				map.put("data", list);
			}else{
				map.put("status","404");
				map.put("message","Data not found");
				
			}
		
		return map;
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> delete(Users users){
		logger.info(" delete ");
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(userServices.delete(users)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}

	@ResponseBody
	@RequestMapping (value="/get", method = RequestMethod.GET)
	public ArrayList<Users> getUsers(){
		logger.info(" getUsers ");
		Users user1 =new Users();
		user1.setEmail("aa");
		user1.setUser_id(10);
		user1.setUser_name("bb");

		Users user2 =new Users();
		user2.setEmail("ab");
		user2.setUser_id(11);
		user2.setUser_name("bc");
		ArrayList<Users> a=new ArrayList<Users>();
		a.add(user1);
		a.add(user2);

		return a;
	}

	@RequestMapping(value="/getdetails", method = RequestMethod.GET)
	@ResponseBody
	public List<UserDetails> getDetails(){
		List<UserDetails> list = userServices.list2();
		return list;
	}

	/*public Users getUserByName(String name){


	}

	@ResponseBody
	@RequestMapping (value="/updateUser/{name}", method = RequestMethod.PUT)
	public Users updateUser(@PathVariable("name") String name, @RequestBody Users user){
		//get record by name
		//update and store modified record

	}*/
}

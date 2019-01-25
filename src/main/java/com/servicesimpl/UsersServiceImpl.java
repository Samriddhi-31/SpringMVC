package com.servicesimpl;

import java.util.List;

import com.entities.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoapi.UsersDao;
import com.entities.Users;
import com.servicesapi.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	UsersDao userDao;
	
	public boolean saveOrUpdate(Users users) {
		System.out.println(users.getUser_name());
		return userDao.saveOrUpdate(users);
	}

	public List<Users> list() {
		// TODO Auto-generated method stub
		return userDao.list();
	}

	public boolean delete(Users users) {
		// TODO Auto-generated method stub
		return userDao.delete(users);
	}	

	public List<UserDetails> list2(){
		return userDao.list2();
	}
}

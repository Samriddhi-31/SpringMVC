package com.daoimpl;

import java.util.List;

import com.entities.UserDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoapi.UsersDao;
import com.entities.Users;


@Repository
@Transactional
public class UsersImpl implements UsersDao{

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(Users users) {
		// TODO Auto-generated method stub
		System.out.println(users.getUser_id());
		session.getCurrentSession().saveOrUpdate(users);
		System.out.println(users.getUser_id());
		return true;
	}

	public List<Users> list() {
		return session.getCurrentSession().createQuery("from Users").list();
	}

	public boolean delete(Users users) {
		try{
			session.getCurrentSession().delete(users);
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}

	@Override
	public List<UserDetails> list2() {
		return session.getCurrentSession().createQuery("from userdetails").list();
	}


}

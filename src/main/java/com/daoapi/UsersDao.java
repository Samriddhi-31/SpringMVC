package com.daoapi;

import java.util.List;

import com.entities.UserDetails;
import com.entities.Users;

public interface UsersDao {
	public boolean saveOrUpdate(Users users);
	public List<Users> list();
	public boolean delete(Users users);
	public List<UserDetails> list2();
}

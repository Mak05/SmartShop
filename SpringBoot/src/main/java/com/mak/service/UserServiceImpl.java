package com.mak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mak.dao.UsersDao;
import com.mak.model.Roles;
import com.mak.model.Users;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UsersDao usersDao;
	
	@Override
	public void saveUser(Users users) {
		usersDao.save(users);
	}

	public Object findByRole(String userName) {
		// TODO Auto-generated method stub
		return usersDao.findByRole(userName);
	}

}

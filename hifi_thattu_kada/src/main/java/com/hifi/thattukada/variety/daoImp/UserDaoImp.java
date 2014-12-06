package com.hifi.thattukada.variety.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hifi.thattukada.variety.dao.UserDao;
import com.hifi.thattukada.variety.entity.UserEntity;

@Repository
public class UserDaoImp implements UserDao{

	@Autowired
    private SessionFactory sessionFactory;
     
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    } 
    
	@Override
	@SuppressWarnings("unchecked")
	public List<UserEntity> userLogin() {
		System.out.println("INSIDE USERDAO IMP");
		// TODO Auto-generated method stub
		 return getCurrentSession().createQuery("from UserEntity").list();
	}

}

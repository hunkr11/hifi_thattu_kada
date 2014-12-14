package com.hifi.thattukada.variety.daoImp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hifi.thattukada.variety.dao.UserDao;
import com.hifi.thattukada.variety.entity.UserEntity;


@Repository
public class UserDaoImp implements UserDao{

	/*@Autowired
	private HibernateTemplate  hibernateTemplate;*/
	
	@Autowired
    private SessionFactory sessionFactory;

	 /* public UserDAOImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	 
	   private Session getCurrentSession() {
	        return sessionFactory.getCurrentSession();
	    }*/
    
	public UserDaoImp() {
		// TODO Auto-generated constructor stub
	}

	public UserDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional	
	public List<UserEntity> userLogin() {
		
		System.out.println("INSIDE USERDAO IMP");
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		 List<UserEntity> listUser = sessionFactory.getCurrentSession()
	                .createCriteria(UserEntity.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		 return listUser;
	}

}

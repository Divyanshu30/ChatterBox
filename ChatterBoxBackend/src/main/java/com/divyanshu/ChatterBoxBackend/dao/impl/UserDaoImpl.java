package com.divyanshu.ChatterBoxBackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.divyanshu.ChatterBoxBackend.dao.UserDao;
import com.divyanshu.ChatterBoxBackend.model.User;

@Repository(value = "userDao")
@Transactional
public class UserDaoImpl implements UserDao {


	@Autowired
	private SessionFactory sessionFactory;

	public User getUserByUserName(String user) {
		try {
			// System.out.println("1");
			Session session = sessionFactory.getCurrentSession();
			// System.out.println("2");
			Query query = session.createQuery("from User where userName= :username");
			query.setString("username", user);
			// System.out.println("3");

			System.out.println("4");
			return (User) query.uniqueResult();

		} catch (Exception e) {
			return null;
		}

	}

	public boolean validUser(User user) {
		return true;
	}

	public boolean addUser(User user) {

		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(int userId) {
		boolean flag = false;
		try {
			User user = getUserbyUserId(userId);
			user.setUserStatus(false);
			Session session = sessionFactory.getCurrentSession();
			session.update(user);
			session.flush();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}

		return flag;

	}

	public boolean editUser(User user) {
		boolean flag = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(user);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public User getUserbyUserId(int userId) {
		try {
			return (User) sessionFactory.getCurrentSession().get(User.class, userId);
		} catch (Exception e) {
			return null;
		}
	}

	public List<User> getAllUsers() {
		try {
			return (List<User>) sessionFactory.getCurrentSession().createQuery("from User").list();
		} catch (Exception ex) {
			return null;
		}
	}

}

package com.divyanshu.ChatterBoxBackend.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.divyanshu.ChatterBoxBackend.dao.ForumMemberDao;
import com.divyanshu.ChatterBoxBackend.model.Blog;
import com.divyanshu.ChatterBoxBackend.model.ForumMember;
import com.divyanshu.ChatterBoxBackend.model.User;

@Repository(value = "forumMemberDao")
@Transactional
public class ForumMemberDaoImpl implements ForumMemberDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean addForumMember(ForumMember member) {
		boolean flag = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(member);
			session.flush();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public boolean deleteForumMember(String emailId) {
		boolean flag = false;
		try {
			ForumMember forumMember = getMemberByEmailId(emailId);
			forumMember.setForumStatus("inactive");
			Session session = sessionFactory.getCurrentSession();
			session.update(forumMember);
			session.flush();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public boolean editForumMember(ForumMember member) {
		boolean flag;
		try {
			sessionFactory.getCurrentSession().update(member);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public ForumMember getMemberByEmailId(String emailId) {
		try {
			return (ForumMember) sessionFactory.getCurrentSession().createQuery("from ForumMember where memberEmailId= :emailId").setParameter("emailId", emailId).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ForumMember> getAllMembersByForumId(int forumId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ForumMember where forumId = :forumid and forumStatus= :active");
			query.setParameter("forumid", forumId);
			query.setParameter("active", "active");
			return (List<ForumMember>) query.list();
		} catch (Exception ex) {
			return null;
		}
	}
}

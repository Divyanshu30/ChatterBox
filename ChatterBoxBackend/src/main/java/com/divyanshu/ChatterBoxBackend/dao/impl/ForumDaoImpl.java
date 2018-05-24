package com.divyanshu.ChatterBoxBackend.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.divyanshu.ChatterBoxBackend.dao.ForumDao;
import com.divyanshu.ChatterBoxBackend.dao.ForumMemberDao;
import com.divyanshu.ChatterBoxBackend.model.Blog;
import com.divyanshu.ChatterBoxBackend.model.Forum;
import com.divyanshu.ChatterBoxBackend.model.ForumMember;
import com.divyanshu.ChatterBoxBackend.model.User;

@Repository(value = "forumDao")
@Transactional
public class ForumDaoImpl implements ForumDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Forum forum;
	@Autowired
	ForumMemberDao forumMemberDao;
	
	public Forum getForumById(int forumId) {
		try {
			return (Forum) sessionFactory.getCurrentSession().get(Forum.class, forumId);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean addForum(Forum forum) {
		boolean flag = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(forum);
			session.flush();
			ForumMember forumMember=new ForumMember();
			forumMember.setForumStatus("active");
			forumMember.setMemberEmailId(forum.getUserEmailId());
			forumMember.setForumId(forum.getForumId());
			session.save(forumMember);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean deleteForum(int forumId) {
		boolean flag = false;
		try {
			forum = getForumById(forumId);
			forum.setStatus("inactive");
			Session session = sessionFactory.getCurrentSession();
			session.update(forum);
			session.flush();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public boolean updateForum(Forum forum) {
		boolean flag = false;
		try {
			forum.setStatus("edited");
			sessionFactory.getCurrentSession().update(forum);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public boolean updateLikes(int forumId) {
		boolean flag = false;
		try {
			forum = getForumById(forumId);
			forum.setForumLikes(forum.getForumLikes() + 1);
			sessionFactory.getCurrentSession().update(forum);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public List<Forum> getAllForum(String userEmailId) {
		try {

			Query query = sessionFactory.getCurrentSession().createQuery("from Forum where userEmailId = ? and (status= 'active' or status = 'edited')");
			query.setParameter(0, userEmailId);
			return (List<Forum>) query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Forum getForumByName(String forumName) {
		try {
		return (Forum) sessionFactory.getCurrentSession().createQuery("from Forum where forumName = :name").setParameter("name", forumName).uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}
}

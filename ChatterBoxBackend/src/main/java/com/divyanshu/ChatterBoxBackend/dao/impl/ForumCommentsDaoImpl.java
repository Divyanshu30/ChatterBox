package com.divyanshu.ChatterBoxBackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.divyanshu.ChatterBoxBackend.dao.ForumCommentsDao;
import com.divyanshu.ChatterBoxBackend.model.ForumComments;

@Repository(value = "forumCommentsDao")
@Transactional
public class ForumCommentsDaoImpl implements ForumCommentsDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ForumComments forumComments;

	public ForumComments getForumCommentById(int forumCommentId) {

		try {
			return (ForumComments) sessionFactory.getCurrentSession().get(ForumComments.class, forumCommentId);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean addForumComment(ForumComments forumComments) {
		boolean flag = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(forumComments);
			session.flush();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean deleteForumComment(int forumCommentId) {

		try {
			forumComments = getForumCommentById(forumCommentId);
			forumComments.setStatus("inactive");
			sessionFactory.getCurrentSession().update(forumComments);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public List<ForumComments> getAllComments(int forumId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(
					"from ForumComments where (forumId = :forumid and (forumStatus = :active or forumStatus = :edited))");
			query.setParameter("forumid", forumId);
			query.setParameter("active", "active");
			query.setParameter("edited", "edited");
			return (List<ForumComments>) query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;

		}
	}

	public boolean editForumComment(ForumComments forumComments) {
		boolean flag = false;
		try {
			forumComments.setStatus("edited");
			Session session = sessionFactory.getCurrentSession();
			session.update(forumComments);
			session.flush();
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateForumCommentLikes(int forumCommentsId) {
		boolean flag = false;
		try {
			forumComments = getForumCommentById(forumCommentsId);
			forumComments.setLikes(forumComments.getLikes() + 1);
			sessionFactory.getCurrentSession().update(forumComments);
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;

	}

}

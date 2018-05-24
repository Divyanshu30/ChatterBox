package com.divyanshu.ChatterBoxBackend.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.divyanshu.ChatterBoxBackend.dao.FriendRequestDao;
import com.divyanshu.ChatterBoxBackend.model.FriendRequest;

@Repository(value = "friendRequestDao")
@Transactional
public class FriendRequestDaoImpl implements FriendRequestDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean sendRequest(FriendRequest request) {
		boolean flag = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			request.setRequestStatus("pending");
			session.save(request);
			session.flush();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public List<FriendRequest> allFriends(String userEmailId) {

		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from FriendRequest where (fromEmailId= :fromemailId or toEmailId= :toemailId)");
			query.setParameter("fromemailId", userEmailId);
			query.setParameter("toemailId", userEmailId);
			List<FriendRequest> listFriends = (List<FriendRequest>) query.list();
			return listFriends;
		} catch (Exception ex) {
			return null;
		}
	}

	public boolean editRequest(FriendRequest request) {
		boolean flag = false;
		try {
			sessionFactory.getCurrentSession().update(request);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

}
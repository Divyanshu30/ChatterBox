package com.divyanshu.ChatterBoxBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.divyanshu.ChatterBoxBackend.dao.FriendRequestDao;
import com.divyanshu.ChatterBoxBackend.model.FriendRequest;

public class FriendRequestTestCase {

	AnnotationConfigApplicationContext context;
	private FriendRequest friendRequest;
	private FriendRequestDao friendRequestDao;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.divyanshu");
		context.refresh();
		friendRequestDao = (FriendRequestDao) context.getBean("friendRequestDao");
		friendRequest = (FriendRequest) context.getBean("friendRequest");
	}

	@Test
	public void testsendRequest() {
		boolean flag;
		if (friendRequestDao.allFriends("testAdmin@gmail.com").size() == 0) {
			friendRequest.setFromEmailId("testAdmin@gmail.com");
			friendRequest.setRequestStatus("pending");
			friendRequest.setToEmailId("test@gmail.com");
			flag = friendRequestDao.sendRequest(friendRequest);
		} else {
			friendRequest = friendRequestDao.allFriends("testAdmin@gmail.com").get(0);
			friendRequest.setRequestStatus("pending");
			flag = friendRequestDao.editRequest(friendRequest);
		}
		assertEquals(true, flag);
	}

	@Test
	public void testallFriends() {
		assertNotNull(friendRequestDao.allFriends("testAdmin@gmail.com").size());
	}

	@Test
	public void testeditRequest() {
		friendRequest = friendRequestDao.allFriends("testAdmin@gmail.com").get(0);
		friendRequest.setRequestStatus("accepted");
	}
}

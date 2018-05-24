package com.divyanshu.ChatterBoxBackend;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.divyanshu.ChatterBoxBackend.dao.UserDao;
import com.divyanshu.ChatterBoxBackend.model.User;

//@RunWith(SpringRunner.class)
//@SpringJUnitConfig(classes =AppContext.class)
public class UserTestCase {

	AnnotationConfigApplicationContext context;
	private UserDao userDao;

	// @Autowired
	private User user;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.divyanshu");
		context.refresh();
		user = (User) context.getBean("user");
		userDao = (UserDao) context.getBean("userDao");
	}

	@Test
	public void testAddUser() {
		// User user =new User();
		boolean flag= false;
		if(userDao.getUserByUserName("testAdmin")!= null)
		{
			user = userDao.getUserByUserName("testAdmin");
			user.setUserJoinDate(Date.valueOf("1994-02-11"));
			user.setUserStatus(true);
			flag = userDao.editUser(user);
		}
		else {
		user.setUserEmailId("test@gmail.com");
		user.setUserName("testAdmin");
		user.setUserPassword("india");
		user.setUserStatus(true);
		user.setUserGender("test");
		user.setUserPhoneNumber(9876543210L);
		user.setUserJoinDate(Date.valueOf("1994-02-13"));
		flag =userDao.addUser(user);
		}
		assertEquals(true, flag);
	}

	@Test
	public void testGetUserByUserName() {
		assertNotNull(userDao.getUserByUserName("testAdmin"));
	}

	@Test
	public void testEditUser() {
		user = userDao.getUserByUserName("testAdmin");
		user.setUserGender("female");
		assertEquals(true, userDao.editUser(user));
	}

	@Test
	public void testGetUserbyUserId() {
		user = userDao.getUserByUserName("testAdmin");
		assertNotNull(userDao.getUserbyUserId(user.getUserId()));
	}


	@Test
	public void testDeleteUser() {
		User user = new User();
		user = userDao.getUserByUserName("testAdmin");
		assertEquals(true, userDao.deleteUser(user.getUserId()));
	}

}

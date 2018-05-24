package com.divyanshu.ChatterBoxBackend.dao;

import java.util.List;
import com.divyanshu.ChatterBoxBackend.model.Forum;

public interface ForumDao {
Forum getForumById(int forumId);
Forum getForumByName(String forumName);
boolean addForum(Forum forum);
boolean deleteForum(int forumId);
boolean updateForum(Forum forum);
boolean updateLikes(int forumId);
List<Forum>getAllForum(String userEmailId);
	
}

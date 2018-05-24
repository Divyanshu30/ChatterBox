package com.divyanshu.ChatterBoxBackend.dao;

import java.util.List;

import com.divyanshu.ChatterBoxBackend.model.ForumMember;

public interface ForumMemberDao {

	boolean addForumMember(ForumMember member);
	boolean deleteForumMember(String emailId);
	boolean editForumMember(ForumMember member);
	ForumMember getMemberByEmailId(String emailId);
	List<ForumMember> getAllMembersByForumId(int forumId);
	
}

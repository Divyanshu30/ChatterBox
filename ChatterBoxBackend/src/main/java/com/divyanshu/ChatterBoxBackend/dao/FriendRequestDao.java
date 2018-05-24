package com.divyanshu.ChatterBoxBackend.dao;
import java.util.List;

import com.divyanshu.ChatterBoxBackend.model.*;
public interface FriendRequestDao {
boolean sendRequest(FriendRequest request);
List<FriendRequest> allFriends(String userEmailId);
boolean editRequest(FriendRequest request);
}

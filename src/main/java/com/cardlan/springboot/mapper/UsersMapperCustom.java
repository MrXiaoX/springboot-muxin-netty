package com.cardlan.springboot.mapper;


import com.cardlan.springboot.pojo.Users;
import com.cardlan.springboot.pojo.vo.FriendRequestVO;
import com.cardlan.springboot.pojo.vo.MyFriendsVO;
import com.cardlan.springboot.utils.MyMapper;

import java.util.List;

public interface UsersMapperCustom extends MyMapper<Users> {
	
	public List<FriendRequestVO> queryFriendRequestList(String acceptUserId);
	
	public List<MyFriendsVO> queryMyFriends(String userId);
	
	public void batchUpdateMsgSigned(List<String> msgIdList);
	
}
package com.cardlan.springboot.service;

import com.cardlan.springboot.pojo.Users;

public interface UserService {
    /**
     * @Description: 判断用户名是否存在
     */
    boolean queryUsernameIsExist(String username);

    /**
     * @Description: 查询用户是否存在
     */
    Users queryUserForLogin(String username, String pwd);

    /**
     * @Description: 用户注册
     */
    Users saveUser(Users user);

    Users updateUserInfo(Users user);


    Integer preconditionSearchFriends(String myUserId, String friendUsername);

    Users queryUserInfoByUsername(String username);

}

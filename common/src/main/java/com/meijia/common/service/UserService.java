package com.meijia.common.service;

import com.meijia.common.result.model.User;

import java.util.List;

/**
 * @author kaiser
 */
public interface UserService {
    /**
     * 查询用户列表
     * @return
     */
    List<User> findUserList();
}

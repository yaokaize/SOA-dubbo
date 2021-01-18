package com.meijia.provider.impl;

import com.meijia.common.result.model.User;
import com.meijia.common.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kaiser
 */
@DubboService(version = "${dubbo.service.version}")
public class UserServiceImpl implements UserService {

    @Override
    public List<User> findUserList() {
        List<User> list = new ArrayList<>();
        list.add(new User(1L, "kaiser", 27));
        list.add(new User(2L, "h.", 27));
        return list;
    }
}

package com.meijia.consumer.api;

import com.meijia.common.result.model.User;
import com.meijia.common.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kaiser
 */
@RestController
public class UserApis {

    @DubboReference(version = "${dubbo.service.version}", loadbalance = "roundrobin")
    private UserService userService;

    @GetMapping("/user/list")
    public List<User> findUserList() {
        return userService.findUserList();
    }
}

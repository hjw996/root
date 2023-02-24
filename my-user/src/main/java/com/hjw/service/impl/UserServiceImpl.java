package com.hjw.service.impl;

import com.hjw.domain.LoginInfo;
import com.hjw.domain.User;
import com.hjw.mapper.UserMapper;
import com.hjw.service.UserService;
import com.hjw.utils.Result;
import com.hjw.utils.ReturnEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result checkLogin(LoginInfo loginInfo) {
        User user = new User();
        user.setUsername(loginInfo.getUsername());
        user.setPassword(loginInfo.getPassword());
        User findUser = userMapper.findUser(user);

        int loginStatus = loginInfo.getStatus();
        int findStatus = findUser.getStatus();

        if (findUser == null) {
            return Result.error(ReturnEnum.LOGIN_ERR);
        }
        if (loginStatus == 0 && findStatus != 1 ) {
            return Result.warn(ReturnEnum.LOGIN_STATUS_WARN).put("user", findUser);
        }
        findUser.setStatus(2);
        try {
            Boolean update = userMapper.updateUserStatus(findUser);
            return Result.ok().put("user", findUser);
        } catch (Exception e) {
            return Result.error(ReturnEnum.DB_ERR);
        }
    }
}

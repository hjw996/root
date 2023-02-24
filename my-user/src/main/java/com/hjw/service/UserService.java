package com.hjw.service;

import com.hjw.domain.LoginInfo;
import com.hjw.utils.Result;

public interface UserService {
    /**
     * 检查用户密码是否正确 返回用户信息
     * @param loginInfo
     * @return
     */
    Result checkLogin(LoginInfo loginInfo);
}

package com.hjw.mapper;

import com.hjw.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {
    /**
     * 根据用户信息查询用户
     * @param loginUser
     * @return
     */
    User findUser(User loginUser);


    /**
     * 根据用户id修改用户登录状态
     * @param user
     * @return
     */
    Boolean updateUserStatus(User user);

}

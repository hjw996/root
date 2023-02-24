package com.hjw.controller;


import com.hjw.domain.LoginInfo;
import com.hjw.service.UserService;
import com.hjw.utils.ReturnEnum;
import com.hjw.utils.Result;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Result login(HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        LoginInfo loginInfo = new LoginInfo();
        //封装登录数据
        try {
            BeanUtils.populate(loginInfo,parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //校验session中的验证码和用户上送的验证码
        String checkcode = (String) request.getSession().getAttribute("checkcode");
        if (checkcode == null || !checkcode.equals(loginInfo.getCheckcode())){
            return Result.error(ReturnEnum.CHECKCODE_ERR);
        }
        //检查用户名密码登录
        return  userService.checkLogin(loginInfo);
    }
}

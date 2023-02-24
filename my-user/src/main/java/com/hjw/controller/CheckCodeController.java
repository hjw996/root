package com.hjw.controller;


import com.hjw.utils.CheckCode;
import com.hjw.utils.Result;
import com.hjw.utils.ReturnEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/checkcode")
public class CheckCodeController {


    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public Result createCode(HttpServletRequest request){
        String checkcode = CheckCode.generateVerifyCode(5);
        HttpSession session = request.getSession();
        System.out.println("aaa");
        if (checkcode!=null){
            session.setAttribute("checkcode",checkcode);
            return  Result.ok().put("checkcode",checkcode);
        }else {
            return Result.error(ReturnEnum.CREATE_CHECKCODE_ERR);
        }
    }
}

package com.makehair.shop.user;

import com.makehair.shop.common.constants.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

  private UserService userService;

  @Autowired
  public LoginController(UserService userService) {
    this.userService = userService;
  }


  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginDefault() {
    return "login/join";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String loginForm(@ModelAttribute UserVo userVo) {
    System.out.println(userVo);
    userService.inserUser(userVo);

    return "login/login";
  }
}
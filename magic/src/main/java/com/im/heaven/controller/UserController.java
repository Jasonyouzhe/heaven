package com.im.heaven.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@RequestMapping(value = "/tologin", method = RequestMethod.GET)
	public String loginPage(Model model) {
		System.out.println("UserController.loginPage()");
		return "login";
	}

	@RequestMapping(value = "/login")
	public String home(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {
		try {
			System.out.println("UserController.home()");
			// 使用权限工具进行用户登录，登录成功后跳到shiro配置的successUrl中，与下面的return没什么关系！
			SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));
			return "index";
		} catch (AuthenticationException e) {
			// redirectAttributes.addFlashAttribute("message","用户名或密码错误");
			return "login";
		}
	}
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String index(Model model) {
		System.out.println("UserController.index()");
		return "index";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		// 使用权限管理工具进行用户的退出，跳出登录，给出提示信息
		SecurityUtils.getSubject().logout();
		return "redirect:/tologin";
	}

	@RequestMapping("/403")
	public String unauthorizedRole() {
		return "/403";
	}
}

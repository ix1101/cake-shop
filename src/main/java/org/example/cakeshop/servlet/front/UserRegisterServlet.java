package org.example.cakeshop.servlet.front;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import org.example.cakeshop.model.User;
import org.example.cakeshop.service.UserService;


@WebServlet("/user_register")
public class UserRegisterServlet extends HttpServlet {
	
	private UserService uService = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User user = new User();
		try {
			BeanUtils.copyProperties(user, request.getParameterMap());
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		}
		if(uService.register(user)) {
			request.setAttribute("msg", "注册成功，请登录！");
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "用户名或邮箱重复，请重新填写！");
			request.getRequestDispatcher("user_register.jsp").forward(request, response);
		}
		
	}

}

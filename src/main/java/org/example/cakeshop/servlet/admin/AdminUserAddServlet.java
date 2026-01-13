package org.example.cakeshop.servlet.admin;

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


@WebServlet("/admin/user_add")
public class AdminUserAddServlet extends HttpServlet {
	
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
			request.setAttribute("msg", "客户添加成功！");
			request.getRequestDispatcher("/admin/user_list").forward(request, response);
		}else {
			request.setAttribute("failMsg", "用户名或邮箱重复，请重新填写！");
			request.setAttribute("u",user);
			request.getRequestDispatcher("/admin/user_add.jsp").forward(request, response);
		}
	}

}

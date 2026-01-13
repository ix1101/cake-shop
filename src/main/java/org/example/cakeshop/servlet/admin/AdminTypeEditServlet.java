package org.example.cakeshop.servlet.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import org.example.cakeshop.model.Type;
import org.example.cakeshop.service.TypeService;


@WebServlet("/admin/type_edit")
public class AdminTypeEditServlet extends HttpServlet {
	
	private TypeService tService = new TypeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Type t = new Type();
		try {
			BeanUtils.copyProperties(t, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {

			e.printStackTrace();
		}
		tService.update(t);
		request.getRequestDispatcher("/admin/type_list").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

package org.example.cakeshop.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.cakeshop.model.Type;
import org.example.cakeshop.service.TypeService;


@WebServlet("/admin/type_add")
public class AdminTypeAddServlet extends HttpServlet {
	
	private TypeService tService = new TypeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		tService.insert(new Type(name));
		request.getRequestDispatcher("/admin/type_list").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

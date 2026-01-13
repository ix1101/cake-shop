package org.example.cakeshop.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.cakeshop.model.Type;
import org.example.cakeshop.service.TypeService;


@WebServlet("/admin/type_list")
public class AdminTypeListServlet extends HttpServlet {
	
	private TypeService tService = new TypeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Type> list= tService.selectAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/type_list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

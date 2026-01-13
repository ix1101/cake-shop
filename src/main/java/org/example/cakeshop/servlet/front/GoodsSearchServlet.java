package org.example.cakeshop.servlet.front;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.cakeshop.model.Page;
import org.example.cakeshop.service.GoodsService;


@WebServlet("/goods_search")
public class GoodsSearchServlet extends HttpServlet {
	
	private GoodsService gService = new GoodsService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		int pageNo = 1;
		if(request.getParameter("pageNo") != null) {
			pageNo=Integer.parseInt(request.getParameter("pageNo") ) ;
		}
		Page p =gService.getSearchGoodsPage(keyword,pageNo);
		request.setAttribute("p", p);
		request.setAttribute("keyword", URLEncoder.encode(keyword,"utf-8"));
		request.getRequestDispatcher("/goods_search.jsp").forward(request, response);
	}

}

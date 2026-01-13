package org.example.cakeshop.servlet.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.cakeshop.model.Goods;
import org.example.cakeshop.model.Order;
import org.example.cakeshop.service.GoodsService;


@WebServlet("/goods_buy")
public class GoodsBuyServlet extends HttpServlet {
	
	private GoodsService gService = new GoodsService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Map<String, String[]> map =request.getParameterMap();
//		for(String key : map.keySet()) {
//			System.out.println(key+":"+map.get(key));
//		}
		Order o = null;
		if(request.getSession().getAttribute("order") != null) {
			o = (Order) request.getSession().getAttribute("order");
		}else {
			o = new Order();
			request.getSession().setAttribute("order", o);
		}
		int goodsid = Integer.parseInt(request.getParameter("goodsid"));
		Goods goods = gService.getById(goodsid);
		if(goods.getStock()>0) {
			o.addGoods(goods);
			response.getWriter().print("ok");
		}else {
			response.getWriter().print("fail");
		}
	}

}

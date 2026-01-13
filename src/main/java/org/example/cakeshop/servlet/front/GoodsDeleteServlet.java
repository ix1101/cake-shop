package org.example.cakeshop.servlet.front;

import org.example.cakeshop.model.Order;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goods_delete")
public class GoodsDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Order o = (Order) request.getSession().getAttribute("order");
        if (o != null) {
            int goodsid = Integer.parseInt(request.getParameter("goodsid"));
            o.deleteGoods(goodsid);
            response.getWriter().print("ok");
        } else {
            response.getWriter().print("login");
        }
    }
}

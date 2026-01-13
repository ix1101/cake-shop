package org.example.cakeshop.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.example.cakeshop.model.Type;
import org.example.cakeshop.service.TypeService;



@WebListener
public class ApplicationListener implements ServletContextListener {

	private TypeService tService = new TypeService();

    public void contextDestroyed(ServletContextEvent arg0)  { 

    }


    public void contextInitialized(ServletContextEvent arg0)  { 
    	List<Type> list = tService.selectAll();
    	arg0.getServletContext().setAttribute("typeList", list);
    }
	
}

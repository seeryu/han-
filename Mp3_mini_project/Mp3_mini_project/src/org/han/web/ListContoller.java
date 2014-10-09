package org.han.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.han.util.Criteria;
import org.han.util.PageMaker;
import org.han.util.SimpleCriteria;


/**
 * Servlet implementation class ListController
 */
@WebServlet("/list")
public class ListContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PageMaker pm = new PageMaker();
		
		Criteria cri = new SimpleCriteria(
				request.getParameter("page"),
				request.getParameterValues("types"),
				request.getParameter("keyword"));
		
		request.setAttribute("pageMaker", pm);
		
		request.getRequestDispatcher("/jsp/list.jsp").forward(request, response);
		
	}

}

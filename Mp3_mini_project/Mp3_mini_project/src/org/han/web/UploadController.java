package org.han.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.han.service.Mp3Service;
import org.han.util.UploadUtill;
import org.han.vo.Mp3Vo;

/**
 * Servlet implementation class UploadController
 */
@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadController() {
        super();
        // TODO Auto-generated constructor stub
    }
    private Mp3Service service;

  	/**
  	 * @see Servlet#init(ServletConfig)
  	 */
  	public void init(ServletConfig config) throws ServletException {
  		
  		service =(Mp3Service)config.getServletContext().getAttribute("Mp3service");
  	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/Mp3upload.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Post��� �ѱ� ���� ����
		request.setCharacterEncoding("UTF-8");
		
		//���޹��� value Ȯ���� ���� 
		String userid = request.getParameter("userid");
		String title = request.getParameter("title");
		String dsc = request.getParameter("dsc");
		String cate = request.getParameter("cate");
		
		//vo�� Setting
		  Mp3Vo vo = new Mp3Vo();
		  Part filePart = request.getPart("file");
	         
	      
	       
	      		
		//���� �� ���� 
	      
	      try {
	    	 vo.setTitle(title);
	         vo.setDsc(dsc);
	         vo.setCate(cate);
	         vo.setUserid(userid);
	         vo.setfileName(UploadUtill.upload(filePart, "C:\\zzz\\"));
	    	 service.setList(vo);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
	}

}

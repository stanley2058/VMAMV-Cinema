package Cinema;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CinemaController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/")
    public void index(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException 
    {
    	RequestDispatcher view;
    	view = request.getRequestDispatcher("index.html");
		view.forward(request, response);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
    public void shop(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException 
    {
    	RequestDispatcher view;
    	view = request.getRequestDispatcher("shop.html");
		view.forward(request, response);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/grocery_files", method = RequestMethod.GET)
    public void grocery_files(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException 
    {
    	RequestDispatcher view;
    	view = request.getRequestDispatcher("grocery_files");
		view.forward(request, response);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/HK_movies", method = RequestMethod.GET)
    public void HK_movies(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException 
    {
    	RequestDispatcher view;
    	view = request.getRequestDispatcher("HK_movies");
		view.forward(request, response);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/TW_movies", method = RequestMethod.GET)
    public void TW_movies(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException 
    {
    	RequestDispatcher view;
    	view = request.getRequestDispatcher("TW_movies");
		view.forward(request, response);
    }
	
}




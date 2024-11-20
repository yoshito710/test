package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.keisan;

@WebServlet("/keisanservlet")
public class keisanservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gamen = (String) request.getSession().getAttribute("gamen");
        ArrayList<String> hantei = (ArrayList<String>)request.getSession().getAttribute("hantei");
        ArrayList<String> history = (ArrayList<String>) request.getSession().getAttribute("history");
        ArrayList<String> history_siki = (ArrayList<String>) request.getSession().getAttribute("history_siki");
        
        if (gamen == null) {
            gamen = ""; 
        }else {
        	
        }
        if (hantei == null) {
            hantei = new ArrayList<>();  
        }else {
        	
        }
        if (history == null) {
            history = new ArrayList<>();
        }else {
        	
        }
        if (history_siki == null) {
            history_siki = new ArrayList<>();
        }else {
        	
        }
        String kazu = request.getParameter("kazu");  
        String kigo = request.getParameter("kigo");  
        String re = request.getParameter("re"); 
        String equal = request.getParameter("equal"); 

        if (kazu != null) {
        	hantei.add(kazu);
            gamen += kazu; 
        } else if (kigo != null) {
        	 if (hantei.isEmpty()) {
        		 
        	 }
        	else if(
        	   "+".equals(hantei.get(hantei.size() - 1))||
        	   "-".equals(hantei.get(hantei.size() - 1))||
        	   "*".equals(hantei.get(hantei.size() - 1))||
        	   "/".equals(hantei.get(hantei.size() - 1))) {
        	}else {
        	    hantei.add(kigo);
                gamen += " " + kigo + " ";  
        	}
        }  else if (re != null) {
        	hantei.clear();
            gamen = "";  
        }  else if (equal != null) {
        	if (hantei.isEmpty()) {
        		 
        	 }else if("+".equals(hantei.get(hantei.size() - 1))||
             	   "-".equals(hantei.get(hantei.size() - 1))||
            	   "*".equals(hantei.get(hantei.size() - 1))||
            	   "/".equals(hantei.get(hantei.size() - 1))) {
        	}else {
        	history_siki.add(gamen);
            keisan keisanObj = new keisan();
            double result = keisanObj.keisan(gamen);
            gamen = String.valueOf(result);  
            history.add(gamen);
        	}
        }
        request.getSession().setAttribute("gamen", gamen);
        request.getSession().setAttribute("hantei", hantei);
        request.getSession().setAttribute("history", history);
        request.getSession().setAttribute("history_siki", history_siki);
        
        request.setAttribute("gamen", gamen);
        request.setAttribute("history", history);
        request.setAttribute("history_siki", history_siki);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

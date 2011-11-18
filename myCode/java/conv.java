
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class conv extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        float am = 0;
        
        try {
           String s1 = request.getParameter("from-currency");
           String s2 = request.getParameter("to-currency");
           String s3 = request.getParameter("amount");
           String encoding = "UTF-8";
           
           am=Float.parseFloat(s3);
           
           String s4;
           String s = "http://www.google.com/ig/calculator?hl=en&q=";
           
           URL convert = new URL(s+ s3 + s1 + "%3D%3F" + s2);
           
           BufferedReader in = new BufferedReader(new InputStreamReader(convert.openStream(),encoding));
           
           s4=in.readLine();
           in.close();
           
           
           String[] tok = s4.split("\"");
           
           s4=tok[1]+" = "+tok[3];
           
           s4=s4.replaceAll(" "," ");
           
           response.sendRedirect("convRes.jsp?param1="+s4);
                   } 
        finally
        {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

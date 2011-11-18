
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class repCtxListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        
        ServletContext sc = event.getServletContext();
        
        String rep = sc.getInitParameter("link");
        
        myRep report = new myRep(rep);
        
        sc.setAttribute("thereport", report);
        
     
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

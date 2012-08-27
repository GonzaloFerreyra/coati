package ar.com.dubix.coati;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class CoatiInitServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		if (req.getParameterMap().containsKey("cleanClass")) {
			try {
				Class<?> clazz = Class.forName(req.getParameter("cleanClass"));
				TestDataStoreCleaner.deleteAll(clazz);
		        resp.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = resp.getWriter();
		        try {
		            out.print("OK");
		        } finally {
		            out.close();
		        }
			} catch (ClassNotFoundException ce) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
						"Clase " + req.getParameter("cleanClass") + "no encontrada");
			} catch (Exception ex) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
						ex.getMessage());
			}
		}
	}
}

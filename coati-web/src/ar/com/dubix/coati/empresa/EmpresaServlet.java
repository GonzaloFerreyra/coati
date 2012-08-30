package ar.com.dubix.coati.empresa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.dubix.coati.CoatiBaseServlet;

public class EmpresaServlet extends CoatiBaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	static final String NUEVA_EMPRESA = "NUEVA_EMPRESA"; 

	/**
	 * Processes requests for HTTP <code>POST</code>
	 * methods. <code>GET</code> is not supported 
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(final HttpServletRequest request, 
			final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String accion = request.getParameter("accion");
        String mensaje = "Acción desconocida.";
        if (accion.equals(NUEVA_EMPRESA)) {
        	mensaje = nuevaEmpresa(request);
        }
        try {
            out.print(mensaje);
        } finally {
            out.close();
        }
    }

	private String nuevaEmpresa(final HttpServletRequest request) {
		return null;
	}
}

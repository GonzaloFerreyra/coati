package ar.com.dubix.coati.seguridad;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.dubix.coati.CoatiBaseServlet;



public class UsuariosServlet extends CoatiBaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	static final String NUEVO_ADMINISTRADOR = "NUEVO_ADMINISTRADOR"; 

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
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String accion = request.getParameter("accion");
        String mensaje = "Acción desconocida.";
        if (accion.equals(NUEVO_ADMINISTRADOR)) {
        	mensaje = nuevoAdministrador(request);
        }
        try {
            out.print(mensaje);
        } finally {
            out.close();
        }
    }

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private String nuevoAdministrador(HttpServletRequest request) {
		try {
			UsuarioAdministrador usuario =  UsuarioDAO.crearUsuarioAdministrador(
					request.getParameter("username"), request.getParameter("password"),
					request.getParameter("validacionPassword"), request.getParameter("nombre"),
					request.getParameter("email"), request.getParameter("telefono"));
		    return usuario.getId() != null ? "Usuario Administrador guardado. Id: " + usuario.getId() :
		    	"Error.";
		} catch (UsuarioException ue) {
			return ue.getMessage();
		}
	}
}

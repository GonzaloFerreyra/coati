package ar.com.dubix.coati.seguridad;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UsuariosServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	static final String NUEVO_ADMINISTRADOR = "NUEVO_ADMINISTRADOR"; 

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
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

	/**
	 * Handles the HTTP <code>GET</code> method.
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
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Coati</title>");
            out.println("</head>");
            out.println("<body>");
            out.print("<h2>");
            out.print("Operación no permitida");
            out.println("</h2>");
            out.println("</body>");
            out.println("</html>");
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

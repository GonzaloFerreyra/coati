package ar.com.dubix.coati.cliente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.dubix.coati.dao.DAOException;

/**
 * 
 * @author gferreyra
 */
public class ClienteServlet extends HttpServlet {

	/*
	 * url de prueba:
	 * http://localhost:8888/cliente?accion=nuevo&codigo=1a&nombre=Gonzalo&domicilio=casa&condicionIVA=Exento&numeroLista=1&localidad=SantaFe&provincia=SantaFe&codigoPostal=3000&cuit=20239299556&diaDeVisita=lunes
	 */
	private static final String ALTA = "nuevo";

	private static final String BAJA = "borrar";

	
	
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
        if (accion.equals(ALTA)) {
        	mensaje = guardarCliente(request);
        } else if (accion.equals(BAJA)) {
        	mensaje = borrarCliente(request);
        }
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
/*            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.print("<h1>");*/
            out.print(mensaje);
            /*out.println("</h1>");
            out.println("</body>");
            out.println("</html>");*/
        } finally {
            out.close();
        }
    }

	private String borrarCliente(final HttpServletRequest request) {
		Long id;
		String codigo;
		try {
			id = Long.parseLong(request.getParameter("id").toString());
			ClienteDAO.borrarCliente(id, null);
			return "El cliente ha sido dado de baja";
		} catch (NullPointerException npe) {
		} catch (NumberFormatException nfe) {
			return "El id del cliente es inválido";
		} catch( DAOException daoe) {
			return daoe.getMessage();
		}
		try {
			codigo = request.getParameter("codigo").toString();
			ClienteDAO.borrarCliente(null, codigo);
			return "El cliente ha sido dado de baja";
		} catch (NullPointerException npe) {
		} catch( DAOException daoe) {
			return daoe.getMessage();
		}
		return "Debe ingresar el id o el código del cliente";
		
	}
	
	private String guardarCliente(final HttpServletRequest request) {
		String mensaje;
		try {
		    Cliente cliente = ClienteDAO.buscarOCrearCliente(
		            request.getParameter("codigo").toString(),
		            request.getParameter("nombre").toString(),
		            request.getParameter("domicilio").toString(),
		            request.getParameter("condicionIVA").toString(),
		            request.getParameter("numeroLista").toString(),
		            request.getParameter("localidad").toString(),
		            request.getParameter("provincia").toString(),
		            request.getParameter("codigoPostal").toString(),
		            request.getParameter("cuit").toString(),
		            request.getParameter("diaDeVisita").toString());
		    mensaje = cliente.getId() != null ? "Cliente guardado. Id: " + cliente.getId() :
		    	"Error.";
		} catch (ClienteException ce) {
			mensaje = ce.getMessage();
		}
		return mensaje;
	}

	// <editor-fold defaultstate="collapsed"
	// desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 * 
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}

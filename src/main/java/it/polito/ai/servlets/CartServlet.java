package it.polito.ai.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polito.ai.businesslogic.CartService;
import it.polito.ai.businesslogic.TravelDocument;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart/actions")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CartService cartService = (CartService) request.getSession().getAttribute("cartService");
		Set<TravelDocument> travelDocuments = (Set<TravelDocument>) request.getServletContext().getAttribute("travelDocuments");
		
		String actionType = request.getParameter("type");
		String travelDocumentId = request.getParameter("travelDocumentId");
		String quantity = request.getParameter("quantity");

		if (actionType.equals("add")) {
			System.out.println("Adding " + quantity+" "+ travelDocumentId);
			// create a checkout from the cart
			cartService.addItem(travelDocumentId, Integer.parseInt(quantity));
			
			for(TravelDocument td: travelDocuments)
			{
				if (td.getId().equals(travelDocumentId) == true)
				{
					cartService.addTravelDocument(td);
					break;
				}
			}
			
			// send the client to the checkout page
			response.sendRedirect(request.getContextPath() + "/cart.jsp");
		}else if(actionType.equals("modify")){
			System.out.println("Updating: " + quantity+" "+ travelDocumentId);
			cartService.updateItem(travelDocumentId, Integer.parseInt(quantity));
			// send the client to the checkout page
			response.sendRedirect(request.getContextPath() + "/cart.jsp");
		}else if(actionType.equals("remove")){
			System.out.println("Remove: "+ travelDocumentId);
			cartService.removeItem(travelDocumentId);
			// send the client to the checkout page
			response.sendRedirect(request.getContextPath() + "/cart.jsp");
		}else{
			//Fail
			System.out.println("CartServlet operation failed");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}

	}

}

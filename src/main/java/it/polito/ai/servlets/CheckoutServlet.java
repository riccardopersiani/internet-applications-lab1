package it.polito.ai.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polito.ai.businesslogic.CartService;
import it.polito.ai.businesslogic.PaymentInfo;
import it.polito.ai.businesslogic.PaymentService;

@WebServlet("/private/checkout/actions")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionType = request.getParameter("type");
		CartService cartService = (CartService)request.getSession().getAttribute("cartService");
		PaymentService paymentService = (PaymentService)request.getSession().getAttribute("paymentService");
		if (actionType.equals("create")) {
			// create a checkout from the cart
			paymentService.setCartItem(cartService.getItems());
			// send the client to the checkout page
			response.sendRedirect(request.getContextPath() + "/private/checkout.jsp");
		} else if(actionType.equals("do")) {
			// get the payment info from the form
			String method = request.getParameter("method");
			String creditCard = request.getParameter("creditCard");
			String billingAddress = request.getParameter("billingAddress");
			String city = request.getParameter("city");
			String cap = request.getParameter("cap");
			String organization = request.getParameter("organization");
			
			PaymentInfo paymentInfo = PaymentInfo.createPaymentInfo(method, creditCard, billingAddress, city, cap, organization);
			paymentService.setPaymentInfo(paymentInfo);
			if (paymentService.getPaymentInfo() == null) {
				// TODO provide an error message, payment info are required and must be valid
				response.sendRedirect(request.getContextPath() + "/private/checkout.jsp");
			} else {
				// proceed with payment
				if (paymentService.pay()) {
					// succeeded
					System.out.println("payed");
					// remove the items from the cart
					cartService.removeAll();
					// the list of elements to be bought is cleaned
					paymentService.setCartItem(null);
					response.sendRedirect(request.getContextPath() + "/private/payed.jsp");
				} else {
					// payment failed
					response.sendRedirect(request.getContextPath() + "/private/checkout.jsp");
				}
				
			}
		}
	}

}

package it.polito.ai.businesslogic;

import java.util.Map;

public interface CartService {
	/**
	 * @param travelDocumentId
	 * @param quantity
	 * @return
	 */
	boolean addItem(String travelDocumentId, int quantity);
	
	public void addTravelDocument(TravelDocument td);
	/**
	 * @param travelDocumentId
	 * @return
	 */
	boolean removeItem(String travelDocumentId);
	/**
	 * @param travelDocumentId
	 * @param quantity
	 * @return
	 */
	boolean updateItem(String travelDocumentId, int quantity);
	/**
	 * @return
	 */
	boolean removeAll();
	
	/**
	 * @return
	 */
	Map<String, Integer> getItems();
	/**
	 * @return
	 */
	float getTotal();
}

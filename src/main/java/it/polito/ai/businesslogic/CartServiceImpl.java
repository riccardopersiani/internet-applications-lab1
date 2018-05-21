package it.polito.ai.businesslogic;

import java.util.*;

public class CartServiceImpl implements CartService {
	
	private Map<String, Integer> items;
	private Set<TravelDocument> travelDocs;
	
	public CartServiceImpl() {
		items = new HashMap<String, Integer>();
		travelDocs = new HashSet<TravelDocument>();
	}
	
	public CartServiceImpl(Map<String, Integer> items, Set<TravelDocument> travelDocs) {
		this.items = items;
		this.travelDocs = travelDocs;
	}

	public boolean addItem(String travelDocumentId, int quantity) {
		if (items.containsKey(travelDocumentId)) {
			int oldQuantity = items.get(travelDocumentId);
			items.put(travelDocumentId, oldQuantity + quantity);
		}
		else {
			items.put(travelDocumentId, quantity);
		}
		
		return true;
	}
	
	public void addTravelDocument(TravelDocument td)
	{
		travelDocs.add(td);
	}
	
	public boolean removeItem(String travelDocumentId) {
		return items.remove(travelDocumentId) != null;
	}

	public boolean updateItem(String travelDocumentId, int quantity) {
		items.put(travelDocumentId, quantity);
		return true;
	}

	public boolean removeAll() {
		items.clear();
		return true;
	}

	public Map<String, Integer> getItems() {
		return new HashMap<String, Integer>(items);
	}

	public float getTotal() {
		float total = 0;
		
		for(Map.Entry<String, Integer> entry : items.entrySet()) {
			float price = 0;
			
			for(TravelDocument td: travelDocs)
			{
				if (td.getId().equals(entry.getKey()) == true)
				{
					price = td.getPrice();
					break;
				}
			}
			
			total += entry.getValue() * price;
		}
		
		return total;
	}
}

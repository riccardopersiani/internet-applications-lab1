/**
 * 
 */
package it.polito.ai.businesslogic;

import java.time.Duration;

/**
 *
 */
public class TravelDocument {
	private TravelDocumentTypes type;
	private String id, name, description, recap;
	private Duration duration;
	private float price;
	
	public TravelDocument(){
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param recap
	 * @param duration
	 */
	public TravelDocument(String id, String name, String description, String recap, Duration duration, float price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.recap = recap;
		this.duration = duration;
		this.price = price;
	}
	/**
	 * @return the type
	 */
	public TravelDocumentTypes getType() {
		return type;
	}
	public float getPrice() {
		return this.price;
	}
	/**
	 * @param id the id to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the recap
	 */
	public String getRecap() {
		return recap;
	}
	/**
	 * @param recap the recap to set
	 */
	public void setRecap(String recap) {
		this.recap = recap;
	}
	/**
	 * @return the duration
	 */
	public Duration getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	
	public void initializeTravelDocument(TravelDocumentTypes types){
		this.type = types;
		switch(types){
		
		case CORSA_SINGOLA_URBANA:
			System.out.println("Corsa singola urbana");
			this.id = "1";
			this.name = "Corsa singola urbana";
			this.description = "Corsa singola urbana della durata di 90 minuti, valida su tutti i tram, bus della GTT";
			this.recap = "Corsa singola urbana della durata di 90 minuti";
			this.duration = Duration.ofMinutes(90);
			this.price = 1.5f;
			break;
		
		case CORSA_SINGOLA_SUBURBANA:
			System.out.println("Corsa singola suburbana");
			this.id = "2";
			this.name = "Corsa singola suburbana";
			this.description = "Corsa singola suburbana della durata di 90 minuti, valida su tutti i tram, bus della GTT";
			this.recap = "Corsa singola suburbana della durata di 90 minuti";
			this.duration = Duration.ofMinutes(90);	
			this.price = 2.0f;
			break;
		
		case BIGLIETTO_GIORNALIERO:
			System.out.println("Biglietto giornaliero");
			this.id = "3";
			this.name = "Biglietto giornaliero";
			this.description = "Biglietto giornaliero della durata di 24 ore, valido su tutti i tram, bus della GTT";
			this.recap = "Biglietto giornaliero della durata di 24 ore";
			this.duration = Duration.ofHours(24);	
			this.price = 5.0f;
			break;
		
		case ABBONAMENTO_SETTIMANALE:
			System.out.println("Abbonamento settimanale");
			this.id = "4";
			this.name = "Abbonamento settimanale";
			this.description = "Abbonamento settimanale della durata di 7 giorni, valido su tutti i tram, bus della GTT";
			this.recap = "Abbonamento settimanale della durata di 7 giorni";
			this.duration = Duration.ofDays(7);
			this.price = 15.50f;
			break;
		
		case ABBONAMENTO_MENSILE:
			System.out.println("Abbonamento mensile");
			this.id = "5";
			this.name = "Abbonamento mensile";
			this.description = "Abbonamento mensile della durata di 1 mese, valido su tutti i tram, bus della GTT";
			this.recap = "Abbonamento mensile della durata di 1 mese";
			this.duration = Duration.ofDays(28);
			this.price = 30.50f;
			break;
		}
	}
	
}

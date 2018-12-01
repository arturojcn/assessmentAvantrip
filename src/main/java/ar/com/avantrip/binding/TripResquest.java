package ar.com.avantrip.binding;

import java.util.Date;

public class TripResquest {
	
	private boolean isOneWay;
	
	private String origen;
	
	private String destiny;
	
	private Date departureDate;
	
	private Date returnDate;


	/**
	 * @return the isOneWay
	 */
	public boolean isOneWay() {
		return isOneWay;
	}

	/**
	 * @param isOneWay the isOneWay to set
	 */
	public void setOneWay(boolean isOneWay) {
		this.isOneWay = isOneWay;
	}

	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * @return the destiny
	 */
	public String getDestiny() {
		return destiny;
	}

	/**
	 * @param destiny the destiny to set
	 */
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	/**
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the returnDate
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
		

}

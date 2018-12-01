package ar.com.avantrip.binding;

import java.util.List;

public class FraudulentFlightRequest {
	
	private UserResquest user;
	
	private List<PersonRequest> passengers;
	
	private PayementResquest detailPaymentOption;
	
	private TripResquest detailTrip;

	/**
	 * @return the user
	 */
	public UserResquest getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserResquest user) {
		this.user = user;
	}

	/**
	 * @return the passengers
	 */
	public List<PersonRequest> getPassengers() {
		return passengers;
	}

	/**
	 * @param passengers the passengers to set
	 */
	public void setPassengers(List<PersonRequest> passengers) {
		this.passengers = passengers;
	}

	/**
	 * @return the detailPaymentOption
	 */
	public PayementResquest getDetailPaymentOption() {
		return detailPaymentOption;
	}

	/**
	 * @param detailPaymentOption the detailPaymentOption to set
	 */
	public void setDetailPaymentOption(PayementResquest detailPaymentOption) {
		this.detailPaymentOption = detailPaymentOption;
	}

	/**
	 * @return the detailTrip
	 */
	public TripResquest getDetailTrip() {
		return detailTrip;
	}

	/**
	 * @param detailTrip the detailTrip to set
	 */
	public void setDetailTrip(TripResquest detailTrip) {
		this.detailTrip = detailTrip;
	}


}

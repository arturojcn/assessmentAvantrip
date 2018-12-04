package ar.com.avantrip.binding;

public class CalculateScoringRequest {
	
	private int scoring;
	
	private FraudulentFlightRequest flightDetail;

	
	public CalculateScoringRequest() {
	}
	
	public CalculateScoringRequest(int scoring, FraudulentFlightRequest flightDetail) {
		this.scoring = scoring;
		this.flightDetail = flightDetail;
	}



	public int getScoring() {
		return scoring;
	}

	public void setScoring(int scoring) {
		this.scoring = scoring;
	}

	public FraudulentFlightRequest getFlightDetail() {
		return flightDetail;
	}

	public void setFlightDetail(FraudulentFlightRequest flightDetail) {
		this.flightDetail = flightDetail;
	}
	
	
}

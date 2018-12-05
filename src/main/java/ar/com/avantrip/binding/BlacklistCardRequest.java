package ar.com.avantrip.binding;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlacklistCardRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cardNumberFront;
	
	private int cardNumberCVC;

	private int status;
	
	

	public BlacklistCardRequest() {
	}

	public BlacklistCardRequest(String cardNumberFront, int cardNumberCVC, int status) {
		this.cardNumberFront = cardNumberFront;
		this.cardNumberCVC = cardNumberCVC;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumberFront() {
		return cardNumberFront;
	}

	public void setCardNumberFront(String cardNumberFront) {
		this.cardNumberFront = cardNumberFront;
	}

	public int getCardNumberCVC() {
		return cardNumberCVC;
	}

	public void setCardNumberCVC(int cardNumberCVC) {
		this.cardNumberCVC = cardNumberCVC;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}	
	
	
}

package ar.com.avantrip.binding;

import java.util.Date;

public class PayementResquest {

	private Date datePurchase;
	
	private PersonRequest titularDetail;
	
	private String cardNumberFront;
	
	private int cardNumberCVC;
	
	private float amount;
	
	private PersonRequest billing;
	

	/**
	 * @return the validateDatePurchase
	 */
	public boolean validateDatePurchase() {
		return this.datePurchase.after(new Date());		
	}
	
	/**
	 * @return the datePurchase
	 */
	public Date getDatePurchase() {
		return datePurchase;
	}

	/**
	 * @param datePurchase the datePurchase to set
	 */
	public void setDatePurchase(Date datePurchase) {
		this.datePurchase = datePurchase;
	}

	/**
	 * @return the titularDetail
	 */
	public PersonRequest getTitularDetail() {
		return titularDetail;
	}

	/**
	 * @param titularDetail the titularDetail to set
	 */
	public void setTitularDetail(PersonRequest titularDetail) {
		this.titularDetail = titularDetail;
	}

	/**
	 * @return the cardNumberFront
	 */
	public String getCardNumberFront() {
		return cardNumberFront;
	}

	/**
	 * @param cardNumberFront the cardNumberFront to set
	 */
	public void setCardNumberFront(String cardNumberFront) {
		this.cardNumberFront = cardNumberFront;
	}

	/**
	 * @return the cardNumberCVC
	 */
	public int getCardNumberCVC() {
		return cardNumberCVC;
	}

	/**
	 * @param cardNumberCVC the cardNumberCVC to set
	 */
	public void setCardNumberCVC(int cardNumberCVC) {
		this.cardNumberCVC = cardNumberCVC;
	}

	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	/**
	 * @return the billing
	 */
	public PersonRequest getBilling() {
		return billing;
	}

	/**
	 * @param billing the billing to set
	 */
	public void setBilling(PersonRequest billing) {
		this.billing = billing;
	}
	
	
}

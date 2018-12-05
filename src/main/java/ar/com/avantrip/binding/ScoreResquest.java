package ar.com.avantrip.binding;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ScoreResquest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int score;
	
	private int scoreMaxFraud;
	
	private Date creationDate; 
	

	public ScoreResquest() {
	}

	public ScoreResquest(int score, int scoreMaxFraud) {
		this.score = score;
		this.scoreMaxFraud = scoreMaxFraud;
		this.creationDate = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	public int getScoreMaxFraud() {
		return scoreMaxFraud;
	}

	public void setScoreMaxFraud(int scoreMaxFraud) {
		this.scoreMaxFraud = scoreMaxFraud;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}	
}

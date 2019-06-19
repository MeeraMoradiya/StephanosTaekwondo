package ca.uwindsor.mac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="RANK")
public class Rank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RANK_ID")
	private long rankId;
	
	@Column(name="BELTCOLOUR")
	private String beltColour;

	public long getRankId() {
		return rankId;
	}

	public void setRankId(long rankId) {
		this.rankId = rankId;
	}

	public String getBeltColour() {
		return beltColour;
	}

	public void setBeltColour(String beltColour) {
		this.beltColour = beltColour;
	}

	@Override
	public String toString() {
		return "Rank [rankId=" + rankId + ", beltColour=" + beltColour + "]";
	}
	
	

}

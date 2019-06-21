package ca.uwindsor.mac.model;

public class FeesWrapper {
	
	private long mId;
	private double cost;
	private long sid;
	public long getmId() {
		return mId;
	}
	public void setmId(long mId) {
		this.mId = mId;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "FeesWrapper [mId=" + mId + ", cost=" + cost + ", sid=" + sid + "]";
	}
	
	
	

}

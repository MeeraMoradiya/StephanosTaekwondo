package ca.uwindsor.mac.model;

public class OrderWrapper {
	
	
	private Double price;
	private String name;
	private Integer qty;
	private Long sid;
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "OrderWrapper [price=" + price + ", name=" + name + ", qty=" + qty + ", sid=" + sid + "]";
	}
	

}

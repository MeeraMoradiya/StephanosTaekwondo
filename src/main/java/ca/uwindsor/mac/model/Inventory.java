package ca.uwindsor.mac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="INVENTORY")
public class Inventory {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="INVENTORY_ID")
	private long inventory_Id;
	
	@Column(name="INVENTORY_NAME")
	private String inventory_name;
	
	@Column(name="INVENTORY_DESC")
	private String inventory_desc;
	
	@Column(name="COST_PRICE")
	private double cost_price;
	
	@Column(name="SELLING_PRICE")
	private double selling_price;
	
	@Column(name="STOCK")
	private int stock;

	public long getInventory_Id() {
		return inventory_Id;
	}

	public void setInventory_Id(long inventory_Id) {
		this.inventory_Id = inventory_Id;
	}

	public String getInventory_name() {
		return inventory_name;
	}

	public void setInventory_name(String inventory_name) {
		this.inventory_name = inventory_name;
	}

	public String getInventory_desc() {
		return inventory_desc;
	}

	public void setInventory_desc(String inventory_desc) {
		this.inventory_desc = inventory_desc;
	}

	public double getCost_price() {
		return cost_price;
	}

	public void setCost_price(double cost_price) {
		this.cost_price = cost_price;
	}

	public double getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(double selling_price) {
		this.selling_price = selling_price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Inventory [inventory_Id=" + inventory_Id + ", inventory_name=" + inventory_name + ", inventory_desc="
				+ inventory_desc + ", cost_price=" + cost_price + ", selling_price=" + selling_price + ", stock="
				+ stock + "]";
	}
	
	

}

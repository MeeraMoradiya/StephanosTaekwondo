package ca.uwindsor.mac.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "ORDERD_ITEMS")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private long order_id;

	@Column(name = "ORDER_DATE")
	private Date order_date;

	@Column(name = "ORDER_QUONTITY")
	private int qty;
	
	@OneToOne
	private Student student;
	
	@OneToOne
	private Inventory inv;

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_date=" + order_date + ", qty=" + qty + ", student="
				+ student.toString() + ", inv=" + inv.toString() + "]";
	}

}

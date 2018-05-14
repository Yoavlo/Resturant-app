package backend.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="order2")
public class Order {

	
	int idOrder;
	

	String comment;
	
	
	String time;
	
	int tableNumber;
	
	
	String orderDishes;
	
	double price;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	
	@Column
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Column
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Column(name="tablenumber")
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	@Column
	public String getOrderDishes() {
		return orderDishes;
	}
	public void setOrderDishes(String order) {
		this.orderDishes = order;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double prince) {
		this.price = prince;
	}
	
	
	
	

}

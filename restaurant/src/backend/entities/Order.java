package backend.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="order")
public class Order {

	int idOrder;
	

	String comment;
	
	
	String timeOfOrder;
	
	
	int tableNumber;
	
	
	String order;
	
	float prince;
	
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
	public String getTimeOfOrder() {
		return timeOfOrder;
	}
	public void setTimeOfOrder(String timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
	}
	
	@Column
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	@Column
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public float getPrince() {
		return prince;
	}
	public void setPrince(float prince) {
		this.prince = prince;
	}
	
	
	
	

}

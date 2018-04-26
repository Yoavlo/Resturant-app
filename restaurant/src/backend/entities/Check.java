package backend.entities;

import javax.persistence.*;

@Entity
@Table(name="check")
public class Check {
	
    @Id
	@Column(name="idCheck")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idCheck; //primary key
    
//    @Column
//	int TableNumber;
//    
    @Column
	String time;
    
//    @Column
//	float price;
 

    @ManyToOne
    @JoinColumn(name = "order")
	Order order; //foreign key
	public int getIdCheck() {
		return idCheck;
	}
	public void setIdCheck(int idCheck) {
		this.idCheck = idCheck;
	}
//	public int getTableNumber() {
//		return TableNumber;
//	}
//	public void setTableNumber(int tableNumber) {
//		TableNumber = tableNumber;
//	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
//	public float getPrice() {
//		return price;
//	}
//	public void setPrice(float price) {
//		this.price = price;
//	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
}

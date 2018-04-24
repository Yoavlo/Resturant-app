package backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="waiterhelp2")
public class WaiterHelp {
	int idWaiterHelp; //primary key
	int tableNumber;
	String time;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	public int getIdWaiterHelp() {
		return idWaiterHelp;
	}
	public void setIdWaiterHelp(int idWaiterHelp) {
		this.idWaiterHelp = idWaiterHelp;
	}
	
	@Column
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	@Column
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	

}

package backend.entities;

import javax.persistence.*;

@Entity
@Table(name="check")
public class Check {
	
    @Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idCheck; //primary key

    @Column
	String time;

    @OneToOne
    @JoinColumn
	Order idorder; //foreign key
    
    
	public int getIdCheck() {
		return idCheck;
	}
	public void setIdCheck(int idCheck) {
		this.idCheck = idCheck;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	public Order getidorder() {
		return idorder;
	}
	public void setidorder(Order idorder) {
		this.idorder = idorder;
	}
	
	
	
	
}

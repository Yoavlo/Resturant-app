package backend.entities;

import javax.persistence.*;

@Entity
@Table(name="checkcustomer")
public class Check {
	

	int idCheck; //primary key


	String time;



	int idorder; //foreign key
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column
	public int getIdCheck() {
		return idCheck;
	}
	public void setIdCheck(int idCheck) {
		this.idCheck = idCheck;
	}

    @Column
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
    @Column
//    @OneToOne
//    @JoinColumn(name="idorder")
	public int getidorder() {
		return idorder;
	}
	public void setidorder(int idorder) {
		this.idorder = idorder;
	}
	
	
	
	
}

package backend.entities;

import java.sql.Time;
import javax.persistence.*;


@Entity
@Table(name="dish") 
public class Dish {
	int idDish; //primary key
	boolean available;
	float price;
	String info;
	int idCategory; //foreign key 
	String name;
	//int translation_id; //apper in Trello. 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	public int getIdDish() {
		return idDish;
	}
	public void setIdDish(int idDish) {
		this.idDish = idDish;
	}
	
	@Column
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	@Column
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Column
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	@Column
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

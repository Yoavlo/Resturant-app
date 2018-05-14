package backend.entities;

import java.sql.Time;
import javax.persistence.*;


@Entity
@Table(name="dish2") 
public class Dish {
	int idDish; //primary key
	boolean available;
	double price;
	String info;
	String name;
	String imagePath;
	String category;
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
	
	
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Column
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	@Column
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

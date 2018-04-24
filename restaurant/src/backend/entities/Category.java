package backend.entities;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {
	int idCategory; //primary key
	int idDish; //foreign key
	String category;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
//	@Column(name= "idcategory")
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	
	//ManyToOne
	// @JoinColumn(name = "iddish")
//	@Column(name="iddish")
	@Column
	public int getIdDish() {
		return idDish;
	}
	public void setIdDish(int idDish) {
		this.idDish = idDish;
	}
	
	@Column
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}

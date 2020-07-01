package challenge.commons.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import challenge.commons.models.Product;


@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long clientId;
	
	@Column(nullable=false, unique=true)
	private Date date;
	
	@Column(nullable=false, unique=true)
	private String direction;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
	private List<Product> products;
	
	@Column(nullable=true, unique=true)
	private Long Total;

	
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", date=" + date + ", direction=" + direction + ", products=" + products
				+ ", Total=" + Total + "]";
	}



	public Long getTotal() {
		return Total;
	}



	public void setTotal(Long total) {
		Total = total;
	}



	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setPoducts(List<Product> products) {
		this.products = products;
	}
	
}

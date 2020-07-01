package challenge.commons.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(nullable=false, unique=true)
	private Long quantity;
	
	@Column(nullable=false, unique=true)
	private Long cost;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="clientId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Client clientId;

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", quantity=" + quantity + ", cost=" + cost + "]";
	}

	
	
	public Client getClientId() {
		return clientId;
	}



	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}



	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}
}

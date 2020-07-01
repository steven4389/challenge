package challenge.BillService.models;

public class Product {
	
	private Long productId;
	
	private Long quantity;
	
	private Long cost;
	

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", quantity=" + quantity + ", cost=" + cost + "]";
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

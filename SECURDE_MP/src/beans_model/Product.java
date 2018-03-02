package beans_model;

public class Product {
	
	int productId, quantity;
	double price;
	String productName, productDescription, productImage;
	
	public Product(int productId, int quantity, String productName, String productDescription, String productImage, double price) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.price = price;
	}
	
	public Product(int quantity, String productName, String productDescription, String productImage, double price) {
		super();
		this.quantity = quantity;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

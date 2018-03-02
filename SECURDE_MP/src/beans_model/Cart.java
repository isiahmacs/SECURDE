package beans_model;

public class Cart {

	int transId, productId, userId, quantity;
	String productName, image;
	double productPrice, subPrice;

	public Cart(int productId, int userId) {
		super();
		this.productId = productId;
		this.userId = userId;
	}

	public Cart(int transId, int productId, int userId, String image, String productName, double productPrice, int quantity, double subPrice) {
		super();
		this.transId = transId;
		this.productId = productId;
		this.userId = userId;
		this.image = image;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.subPrice = subPrice;
	}

	
	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubPrice() {
		return subPrice;
	}

	public void setSubPrice(double subPrice) {
		this.subPrice = subPrice;
	}
	
}

package beans_model;

public class Order {
	
	private String productName, productBuyer, productBuyerEmail, productImage;
	private double retailPrice, totalPrice;
	private int productQuantity, transactionId, productId;
	
	public Order(String productImage, int transactionId, String productName, String productBuyer, String productBuyerEmail, double retailPrice,
			double totalPrice, int productQuantity, int productId) {
		super();
		this.productImage = productImage;
		this.transactionId = transactionId;
		this.productName = productName;
		this.productBuyer = productBuyer;
		this.productBuyerEmail = productBuyerEmail;
		this.retailPrice = retailPrice;
		this.totalPrice = totalPrice;
		this.productQuantity = productQuantity;
		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBuyer() {
		return productBuyer;
	}

	public void setProductBuyer(String productBuyer) {
		this.productBuyer = productBuyer;
	}

	public String getProductBuyerEmail() {
		return productBuyerEmail;
	}

	public void setProductBuyerEmail(String productBuyerEmail) {
		this.productBuyerEmail = productBuyerEmail;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	
}

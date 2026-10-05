package productTrackingProject;

public class ProductDelivery {
	
    private int productId;
	private String productName;
	private String productShippingAddress;
	private double productPrice;
	private int productQuantity;
	private String productPlaceData;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductShippingAddress() {
		return productShippingAddress;
	}
	
	public void setProductShippingAddress(String productShippingAddress) {
		this.productShippingAddress = productShippingAddress;
	}
	public double getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int quantity) {
		this.productQuantity = quantity;
	}
	public String getProductPlaceData() {
		return productPlaceData;
	}
	
	public void setProductPlaceData(String productPlaceData) {
		this.productPlaceData = productPlaceData;
	}
	
	@Override
	public String toString() {
		return "ProductDelivery [productId=" + productId + ", productName=" + productName + ", productShippingAddress="
				+ productShippingAddress + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity
				+ ", productPlaceData=" + productPlaceData + "]";
	}
	
	
}

package dto;


public class ProductRequest {
	private int productId;
	private String name;
    private String description;
    private double price;
    private double discountedPrice;
    private String imageUrl;
    private int categoryId;
    private int sellerId;
    private int stockQuantity;
    private int thresholdQuantity;

    public ProductRequest(String name, String description, double price, double discountedPrice , String imageUrl, int categoryId, int sellerId, int stockQuantity,
			int  thresholdQuantity) {
		// TODO Auto-generated constructor stub
    	super();
		
		this.name = name;
		this.description = description;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.imageUrl = imageUrl;
		this.categoryId = categoryId;
		this.sellerId = sellerId;
		this.stockQuantity = stockQuantity;
		this.thresholdQuantity = thresholdQuantity;
	
	}
	
    public ProductRequest(String name, String description, double price, double discountedPrice , String imageUrl, int categoryId, int sellerId, int stockQuantity,
			int  thresholdQuantity,int productId) {
		// TODO Auto-generated constructor stub
    	super();
		
		this.name = name;
		this.description = description;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.imageUrl = imageUrl;
		this.categoryId = categoryId;
		this.sellerId = sellerId;
		this.stockQuantity = stockQuantity;
		this.thresholdQuantity = thresholdQuantity;
		this.productId=productId;
	
	}
	

	@Override
	public String toString() {
		return "ProductRequest [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", discountedPrice=" + discountedPrice + ", imageUrl=" + imageUrl + ", categoryId="
				+ categoryId + ", sellerId=" + sellerId + ", stockQuantity=" + stockQuantity + ", thresholdQuantity="
				+ thresholdQuantity + "]";
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	// Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getDiscountedPrice() {
        return discountedPrice;
    }
    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public int getSellerId() {
        return sellerId;
    }
    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public int getThresholdQuantity() {
        return thresholdQuantity;
    }
    public void setThresholdQuantity(int thresholdQuantity) {
        this.thresholdQuantity = thresholdQuantity;
    }
	public int getPrdouctid() {
		return productId;
	}
	public void setPrdouctid(int prdouctid) {
		this.productId = prdouctid;
	}
}

package crud;

/**
 * Date: Nov 16, 2009
 */
public class _Product {
    static final long serialVersionUID = 103844514947365244L;

    private int productId;
    private String name;
    private String description;
    private String image;
    private String category;
    private double price;
    private int qtyInStock;

    public _Product() {

    }

    public _Product(int productId, String name, String description, String image, String category, double price, int qtyInStock) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.image = image;
		this.category = category;
		this.price = price;
		this.qtyInStock = qtyInStock;
	}

    public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQtyInStock() {
		return qtyInStock;
	}
	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}
}

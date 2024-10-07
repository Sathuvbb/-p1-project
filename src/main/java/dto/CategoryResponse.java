package dto;

public class CategoryResponse {

	private int categoryId;

	private String name;

	public CategoryResponse(int categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


@Override
public String toString() {
    return "CategoryResponse[" +
           " categoryId=" +  categoryId +
           ", name='" + name + '\'' +
           ']';
}
}

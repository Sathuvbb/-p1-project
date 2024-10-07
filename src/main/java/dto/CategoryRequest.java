package dto;

public class CategoryRequest {


		private int categoryId;
	    

		private String name;
		public CategoryRequest(String name,int  categoryId ) {
			super();
			
			this.name=name;
			this.categoryId = categoryId;
			
		}

	    public CategoryRequest(String name) {
				// TODO Auto-generated constructor stub
		    	this.name=name;
			}

		// Getters and Setters
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



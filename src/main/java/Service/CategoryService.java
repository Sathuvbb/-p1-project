package Service;

import java.util.List;
import dao.CategoryDaoClass;
import dao.CategoryDao;
import dto.CategoryRequest;
import dto.CategoryResponse;

public class CategoryService {

    private final CategoryDaoClass categoryDAO;

    public CategoryService() {
        categoryDAO = new CategoryDaoClass();
    }

    public boolean createCategory(CategoryRequest categoryRequest) {
        try {
            boolean result = categoryDAO.createCategory(categoryRequest);
            System.out.println("Create category operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error creating category: " + e.getMessage());
            return false;
        }
    }

    public CategoryResponse getCategoryById(int id) {
        try {
            CategoryResponse category = categoryDAO.getCategoryById(id);
            if (category != null) {
                System.out.println("Fetched category by ID: " + id);
            } else {
                System.out.println("No category found with ID: " + id);
            }
            return category;
        } catch (Exception e) {
            System.out.println("Error fetching category by ID: " + e.getMessage());
            return null;
        }
    }

    public boolean updateCategory(CategoryRequest categoryRequest) {
        try {
            boolean result = categoryDAO.updateCategory(categoryRequest);
            System.out.println("Update category operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error updating category: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteCategoryById(int id) {
        try {
            boolean result = categoryDAO.deleteCategoryById(id);
            System.out.println("Delete category operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error deleting category: " + e.getMessage());
            return false;
        }
    }

    public List<CategoryResponse> getAllCategories() {
        try {
            List<CategoryResponse> categories = categoryDAO.getAllCategories();
            if (!categories.isEmpty()) {
                System.out.println("Fetched all categories.");
            } else {
                System.out.println("No categories found.");
            }
            return categories;
        } catch (Exception e) {
            System.out.println("Error fetching all categories: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Create an instance of the CategoryService
        CategoryService service = new CategoryService();

        // Create a new category
        CategoryRequest newCategory = new CategoryRequest("car");
        boolean isCreated = service.createCategory(newCategory);
        System.out.println("Category creation status: " + isCreated);

        // Fetch a category by ID
        CategoryResponse category = service.getCategoryById(1);
        if (category != null) {
            System.out.println("Category found: " + category);
        } else {
            System.out.println("Category with ID 1 not found."+category );
        }

        // Update a category
        CategoryRequest categoryUpdate = new CategoryRequest( "MOBILE",1);
        boolean isUpdated = service.updateCategory(categoryUpdate);
        System.out.println("Category update status: " + isUpdated);

        // Delete a category by ID
        boolean isDeleted = service.deleteCategoryById(1);
        System.out.println("Category deletion status: " + isDeleted);

        // Fetch all categories
        List<CategoryResponse> allCategories = service.getAllCategories();
        if (allCategories != null && !allCategories.isEmpty()) {
            allCategories.forEach(System.out::println);
        } else {
            System.out.println("No categories found.");
        }
    }
}

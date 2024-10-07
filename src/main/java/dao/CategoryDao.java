package dao;

import dto.CategoryRequest;
import dto.CategoryResponse;
import Exception.CategoryDaoException;

import java.util.List;

public interface CategoryDao {

    // Method to create a new category
    boolean createCategory(CategoryRequest categoryRequest) throws CategoryDaoException;

    // Method to get a category by its ID
    CategoryResponse getCategoryById(int id) throws CategoryDaoException;

    // Method to update an existing category
    boolean updateCategory(CategoryRequest categoryRequest) throws CategoryDaoException;

    // Method to delete a category by its ID
    boolean deleteCategoryById(int id) throws CategoryDaoException;

    // Method to retrieve all categories
    List<CategoryResponse> getAllCategories() throws CategoryDaoException;
}

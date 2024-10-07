package dao;

import dto.ProductRequest;
import dto.ProductResponse;
import Exception.ProductException;
import java.util.List;

public interface ProductDAO {

    boolean createProduct(ProductRequest productRequest) throws ProductException;

    ProductResponse getProductById(int productId) throws ProductException;

    boolean updateProduct(int productId, ProductRequest productRequest) throws ProductException;

    boolean deleteProductById(int productId) throws ProductException;

    List<ProductResponse> getAllProducts() throws ProductException;

    List<ProductResponse> getProductsByCategoryId(int categoryId) throws ProductException;

    List<ProductResponse> getProductsBySellerId(int sellerId) throws ProductException;

    List<ProductResponse> searchProductsByName(String query) throws ProductException;

    List<ProductResponse> getProductsBelowThreshold() throws ProductException;

    List<ProductResponse> getLowStockProducts() throws ProductException;

  
}

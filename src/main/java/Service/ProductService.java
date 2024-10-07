package Service;

import dao.ProductDAOImpl;
import dto.ProductRequest;
import dto.ProductResponse;

import java.util.List;

public class ProductService {

    private final ProductDAOImpl productDAO;

    public ProductService() {
        this.productDAO = new ProductDAOImpl();
    }

    public ProductResponse getProductById(int id) {
        try {
        	  
            ProductResponse product = productDAO.getProductById(id);
       
            if (product != null) {
                System.out.println("Product retrieved successfully: " + product);
            } else {
                System.out.println("No product found with id: " + id);
            }
            return product;
        } catch (Exception e) {
            System.out.println("Error fetching product by id: " + e.getMessage());
            return null;
        }
    }

    public boolean createProduct(ProductRequest request) {
        try {
        	//System.out.print("dummy....."+request);
            boolean result = productDAO.createProduct(request);
            System.out.println("Create product operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error creating product: " + e.getMessage());
            return false;
        }
    }

    public List<ProductResponse> getAllProducts() {
        try {
            List<ProductResponse> products = productDAO.getAllProducts();
            System.out.println("Retrieved all products: " + products.size() + " items");
            return products;
        } catch (Exception e) {
            System.out.println("Error fetching all products: " + e.getMessage());
            return null;
        }
    }

    public List<ProductResponse> getProductsByCategoryId(int categoryId) {
        try {
            List<ProductResponse> products = productDAO.getProductsByCategoryId(categoryId);
            System.out.println("Retrieved products for category id: " + categoryId + ", count: " + products.size());
            return products;
        } catch (Exception e) {
            System.out.println("Error fetching products by category id: " + e.getMessage());
            return null;
        }
    }

    public List<ProductResponse> getProductsBySellerId(int sellerId) {
        try {
            List<ProductResponse> products = productDAO.getProductsBySellerId(sellerId);
            System.out.println("Retrieved products for seller id: " + sellerId + ", count: " + products.size());
            return products;
        } catch (Exception e) {
            System.out.println("Error fetching products by seller id: " + e.getMessage());
            return null;
        }
    }

    public boolean updateProduct(int productId, ProductRequest request) {
        try {
            boolean result = productDAO.updateProduct(productId, request);
            System.out.println("Update product operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error updating product with id: " + productId + ", " + e.getMessage());
            return false;
        }
    }

    public boolean deleteProduct(int productId) {
        try {
            boolean result = productDAO.deleteProductById(productId);
            System.out.println("Delete product operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error deleting product with id: " + productId + ", " + e.getMessage());
            return false;
        }
    }

    public List<ProductResponse> searchProductsByName(String name) {
        try {
            List<ProductResponse> products = productDAO.searchProductsByName(name);
            System.out.println("Searched products by name: " + name + ", count: " + products.size());
            return products;
        } catch (Exception e) {
            System.out.println("Error searching products by name: " + e.getMessage());
            return null;
        }
    }

    public List<ProductResponse> getLowStockProducts() {
        try {
            List<ProductResponse> products = productDAO.getLowStockProducts();
            System.out.println("Retrieved low stock products, count: " + products.size());
            return products;
        } catch (Exception e) {
            System.out.println("Error fetching low stock products: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        ProductService productService = new ProductService();

        // Create a new product
        ProductRequest newProduct = new ProductRequest(
            "car",
            "good car",
            65000,
            10000,
            "http/sai/image",
            2,
            2,
            50,
            40
        );

        boolean isCreated = productService.createProduct(newProduct);
        System.out.println("Product creation status: " + isCreated);

        // Retrieve and display a product by ID
        ProductResponse product = productService.getProductById(1);
        System.out.println("Product details: " + product);

        // Retrieve and display all products
        List<ProductResponse> allProducts = productService.getAllProducts();
        System.out.println("All products: " + allProducts);

        // Retrieve and display products by category ID
        List<ProductResponse> categoryProducts = productService.getProductsByCategoryId(2);
        System.out.println("Products by category: " + categoryProducts);

        // Retrieve and display products by seller ID
        List<ProductResponse> sellerProducts = productService.getProductsBySellerId(2);
        System.out.println("Products by seller: " + sellerProducts);

        // Update a product
        ProductRequest updateRequest = new ProductRequest(
            "updated car",
            "updated good car",
            70000,
            12000,
            "http/sai/updated-image",
            1,
            2,
            60,
            50,
            1
        );
        boolean isUpdated = productService.updateProduct(1, updateRequest);
        System.out.println("Product update status: " + isUpdated);

        // Delete a product
        boolean isDeleted = productService.deleteProduct(0);
        System.out.println("Product deletion status: " + isDeleted);

        // Search for products by name
        List<ProductResponse> searchedProducts = productService.searchProductsByName("Laptop");
        System.out.println("Searched products: " + searchedProducts);

        // Get low stock products
        List<ProductResponse> lowStockProducts = productService.getLowStockProducts();
        System.out.println("Low stock products: " + lowStockProducts);
    }
}

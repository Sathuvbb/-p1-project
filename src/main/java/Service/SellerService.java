package Service;

import dao.SellerDaoClass;
import dto.SellerRequest;
import dto.SellerResponse;
import java.util.List;

public class SellerService {

    private final SellerDaoClass sellerDao;

    public SellerService() {
        sellerDao = new SellerDaoClass();
    }

    public boolean createSeller(SellerRequest sellerRequest) {
        try {
            boolean result = sellerDao.createSeller(sellerRequest);
            System.out.println("Create seller operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error creating seller: " + e.getMessage());
            return false;
        }
    }

    public SellerResponse getSellerById(int id) {
        try {
            SellerResponse seller = sellerDao.getSellerById(id);
            if (seller != null) {
                System.out.println("Fetched seller by ID: " + id);
            } else {
                System.out.println("No seller found with ID: " + id);
            }
            return seller;
        } catch (Exception e) {
            System.out.println("Error fetching seller by ID: " + e.getMessage());
            return null;
        }
    }

   

    public boolean updateSeller(SellerRequest sellerRequest) {
        try {
            boolean result = sellerDao.updateSeller(sellerRequest);
            System.out.println("Update seller operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error updating seller: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteSellerById(int id) {
        try {
            boolean result = sellerDao.deleteSellerById(id);
            System.out.println("Delete seller operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error deleting seller: " + e.getMessage());
            return false;
        }
    }

    public List<SellerResponse> getAllSellers() {
        try {
            List<SellerResponse> sellers = sellerDao.getAllSellers();
            if (!sellers.isEmpty()) {
                System.out.println("Fetched all sellers.");
            } else {
                System.out.println("No sellers found.");
            }
            return sellers;
        } catch (Exception e) {
            System.out.println("Error fetching all sellers: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        SellerService service = new SellerService();

        // Fetch a seller by ID
        SellerResponse seller = service.getSellerById(1);
        if (seller != null) {
            System.out.println(seller.toString());
        } else {
            System.out.println("Seller not found.");
        }

        // Update a seller
        SellerRequest sellerUpdate = new SellerRequest("updated_email@example.com", "newpassword", "Updated Business Name", "Updated Business Details",0);
        boolean isUpdate = service.updateSeller(sellerUpdate);
        System.out.println("Seller update status: " + isUpdate);

        // Create a new seller
        SellerRequest newSeller = new SellerRequest("Sai@example.yoo", "P123", "mobiles", "All mobiles are available");
        boolean isCreated = service.createSeller(newSeller);
        System.out.println("Seller creation status: " + isCreated);

       

        // Delete a seller by ID
        boolean isDeleted = service.deleteSellerById(13);
        System.out.println("Seller deletion status: " + isDeleted);

        // Fetch all sellers
        List<SellerResponse> allSellers = service.getAllSellers();
        if (allSellers != null && !allSellers.isEmpty()) {
            allSellers.forEach(System.out::println);
        } else {
            System.out.println("No sellers found.");
        }
    }
}

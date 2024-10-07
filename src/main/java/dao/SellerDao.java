package dao;



import java.util.List;

import Exception.SellerOperationException;
import dto.SellerRequest;
import dto.SellerResponse;
import entity.Seller;

public interface SellerDao {
	
	    SellerResponse getSellerById(int id) throws SellerOperationException;
	    boolean createSeller(SellerRequest sellerRequest)throws SellerOperationException;
	    boolean updateSeller(SellerRequest sellerRequest)throws SellerOperationException;
	    boolean deleteSellerById(int id)throws SellerOperationException;
	    List<SellerResponse> getAllSellers()throws SellerOperationException;
	

}

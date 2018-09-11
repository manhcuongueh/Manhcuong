package albert.com.hibernate.services;

import java.util.List;

import albert.com.hibernate.models.Product;

public interface ProductService {

	void saveProduct(Product pro);
	
	void updateProduct(Product pro);
	
	Product findByCode(String code);
	
	List<Product> listProduct();
	
	void delete(String code);
	
	List<Product> searchProduct(String str);
	
}

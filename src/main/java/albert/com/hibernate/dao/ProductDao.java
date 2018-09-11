package albert.com.hibernate.dao;

import java.util.List;

import albert.com.hibernate.models.Product;

public interface ProductDao {
	
	void saveProduct(Product pro);
	
	void updateProduct(Product pro);
	
	Product findByCode(String code);
	
	public List<Product> listInfo();
	
	void delete(String code);
	
	public List<Product> searchProduct(String str);
	
}

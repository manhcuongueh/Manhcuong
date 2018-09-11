package albert.com.hibernate.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import albert.com.hibernate.dao.ProductDao;
import albert.com.hibernate.models.Product;


@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public Product findByCode(String code){
		return this.productDao.findByCode(code);
	}

	public void saveProduct(Product pro){
		productDao.saveProduct(pro);
	}
	
	public void updateProduct(Product pro){
		productDao.updateProduct(pro);
	}
	
	public List<Product> listProduct() {
		return this.productDao.listInfo();
	}

	public void delete(String code){
		productDao.delete(code);
	}
	
	public List<Product> searchProduct(String str) {
		return this.productDao.searchProduct(str);
	}


}

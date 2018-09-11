package albert.com.hibernate.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import albert.com.hibernate.models.Product;


@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {
	
	public void saveProduct(Product pro){
		persist(pro);
	}
	public void updateProduct(Product pro){
		update(pro);
		
	}
	
	
	public Product findByCode(String code) {
		return getByCode(code);
	}
	public void delete(String code){
		getSession().createQuery("DELETE FROM Product WHERE code = :code")
		.setParameter("code", code)
		.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> listInfo() {
		List<Product> infoList = getSession().createQuery("from Product").list();
		return infoList;
	}

	@SuppressWarnings("unchecked")
	public List<Product> searchProduct(String str) {
		List<Product> infoList = getSession().createQuery("FROM Product WHERE name LIKE :str")
				.setParameter("str", "%" + str + "%")
				.list();
		return infoList;
		
	}


}

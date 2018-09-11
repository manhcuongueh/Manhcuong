package albert.com.hibernate.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import albert.com.hibernate.models.Order;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Integer, Order> implements OrderDao {
	public void getId(){
		
	}
	
	public Order findById(int id){
		return getByKey(id);
		
	}
	
	public void saveOrder(Order order){
		persist(order);
	}
	
	public void deleteOrder(int orderId){
		getSession().createQuery("DELETE FROM Order WHERE orderId = :orderId")
		.setParameter("orderId", orderId)
		.executeUpdate();
	}
	
	public void updateStatus(int orderId, String status){
		getSession().createQuery("UPDATE FROM Order set status= :status WHERE orderId= :orderId")
		.setParameter("status", status)
		.setParameter("orderId", orderId)
		.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public  List<Order> getAllOrder(){
		return  getSession().createQuery("from Order").list();	
	}
	
}

package albert.com.hibernate.dao;

import java.util.List;
import albert.com.hibernate.models.Order;

public interface OrderDao {
	
	void getId();
	
	void updateStatus(int orderId, String status);
	
	Order findById(int id);
	
	void saveOrder(Order order);
	
	void deleteOrder(int orderId);
	
	List<Order> getAllOrder();

}

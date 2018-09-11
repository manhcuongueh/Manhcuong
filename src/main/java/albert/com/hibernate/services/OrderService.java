package albert.com.hibernate.services;

import java.util.List;
import albert.com.hibernate.models.Order;


public interface OrderService {
	
	Order findById(int id);
	
	void updateStatus(int orderId, String status);
	
	void saveOrder(Order order);
	
	void deleteOrder(int orderId);
	
	List<Order> getAllOrder();

}
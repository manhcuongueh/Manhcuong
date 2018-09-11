package albert.com.hibernate.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import albert.com.hibernate.dao.OrderDao;
import albert.com.hibernate.models.Order;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	public Order findById(int id){
		return orderDao.findById(id);
	}
	
	public void saveOrder(Order order){
		orderDao.saveOrder(order);
	}
	
	public void deleteOrder(int orderId){
		orderDao.deleteOrder(orderId);
	}
	public void updateStatus(int orderId, String status){
		orderDao.updateStatus(orderId, status);
	}
	public List<Order> getAllOrder(){
		return orderDao.getAllOrder();
	}
}

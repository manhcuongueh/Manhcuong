package albert.com.hibernate.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import albert.com.hibernate.models.Order;
import albert.com.hibernate.models.OrderDetail;
import albert.com.hibernate.services.OrderService;


@RestController
@RequestMapping("/")
public class OrderController {
 
    @Autowired
    OrderService orderService;
    
    //Get all orders
   	@RequestMapping(value = "/order", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
       public List<Order> listOrder() {
           List<Order> order = orderService.getAllOrder();
           return order;
       }
    
    //Get an order
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order  getSingleOrder(@PathVariable("id") int id) {
        Order order=orderService.findById(id);
        return order;
    }
    
    //Create an order
    @RequestMapping(value = "/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createOrder(@RequestBody Order order) throws JsonProcessingException {
    	ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode x = objectMapper.createObjectNode();
        System.out.println("Creating order infomation with id " +order.getOrderDetail().get(0).getCode());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        order.setOrderDate(dateFormat.format(date));
        order.setOrderDetail(order.getOrderDetail());
        order.setStatus("new order");
        for(OrderDetail orderD : order.getOrderDetail()){ 	
            orderD.setOrder(order);
        	}
        orderService.saveOrder(order);
        
         x.put("code",1000);
         x.put("message", "OK");
         
        return objectMapper.writeValueAsString(x);
    }
    //Set status for a product
    @RequestMapping(value = "/order", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateStatus(@RequestBody Order order) throws JsonProcessingException {
    	ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode x = objectMapper.createObjectNode();
        System.out.println("Updating order status with id " +order.getOrderId());
        orderService.updateStatus(order.getOrderId(), order.getStatus());
         x.put("code",1000);
         x.put("message", "OK");
         
        return objectMapper.writeValueAsString(x);
    }
 
    //Delete an order
    
    
    
    
    
}
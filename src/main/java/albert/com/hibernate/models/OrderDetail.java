package albert.com.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ORDER_DETAIL")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_DETAIL_ID", nullable = false)
	private int orderDetailId;
	
	@JsonIgnore 
	@ManyToOne
	@JoinColumn(name = "ORDERID", nullable = false)
	private Order order;
	
	@Column(name = "QUANTITY", nullable = false)
    private int quantity;

	@Column(name = "AMOUNT", nullable = false)
    private double amount;
	
	@Column(name = "PRICE", nullable = false)
    private double price;
	
	@Column(name = "Name", nullable = false)
    private String  name;
	
	@Column(name = "CODE", nullable = false)
    private String  code;

	
	public int getOderDetailId() {
		return orderDetailId;
	}

	public void setOderId(int oderDetailId) {
		this.orderDetailId = oderDetailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
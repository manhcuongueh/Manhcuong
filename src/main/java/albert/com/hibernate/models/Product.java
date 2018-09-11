package albert.com.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PRODUCT")
public class Product{
	@Id
    private String code;
	
	@Column(name = "NAME", nullable = false)
    private String name;
	
	@Column(name="PRICE", nullable = false)
    private double price;
	
	@Lob
    @Column(name = "SCR", length = Integer.MAX_VALUE, nullable = true)
    private String scr;

    // For sort.
    @Column(name = "Create_Date", nullable = false)
    private String createDate;
	
	@Column(name = "INFO")
    private String info;
	
	@Column(name = "CATEGORY")
    private String category;

    public Product() {
    }

    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String date) {
        this.createDate = date;
    }

    public String getScr() {
        return scr;
    }

    public void setScr(String scr) {
        this.scr =scr;
    }


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
    

}
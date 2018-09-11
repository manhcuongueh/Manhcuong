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
import albert.com.hibernate.models.Product;
import albert.com.hibernate.services.ProductService;


@RestController
@RequestMapping("/")
public class ProductController {
 
    @Autowired
    ProductService productService;
    
    //get all Product
	@RequestMapping(value = "/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> listInfo() {
        List<Product> products = productService.listProduct();
        return products;
    }

    //get a product
    @RequestMapping(value = "/product/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getSingleProduct(@PathVariable("code") String code) {
        System.out.println("Fetching Product with id " + code);
        Product product = productService.findByCode(code);
        return product;
    }
    
    //Create a product
    @RequestMapping(value = "/product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String CreateProduct(@RequestBody Product pro) throws JsonProcessingException {
    	System.out.println("Creating Product " + pro.getName());
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode x = objectMapper.createObjectNode();
        if (productService.findByCode(pro.getCode())!=null) {
            System.out.println("A Product with name " + pro.getCode() + " already exist");
            
            x.put("code",-1000);
            x.put("message", "Product exists");
            return objectMapper.writeValueAsString(x);
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        pro.setCreateDate(dateFormat.format(date));
        productService.saveProduct(pro);
        x.put("code",1000);
        x.put("message", "OK");
        return objectMapper.writeValueAsString(x);
       }
    
    //Update a product 
    @RequestMapping(value = "/product", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public String UpdateProduct(@RequestBody Product pro) throws JsonProcessingException {
    	ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode x = objectMapper.createObjectNode();
        System.out.println("Updatting Product with id " + pro.getCode());
        productService.updateProduct(pro);
        x.put("code",1000);
        x.put("message","SC_OK");
        return objectMapper.writeValueAsString(x);
    }
    
    //Delete a product
    @RequestMapping(value = "/product/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void DeleteProduct(@PathVariable("code") String code) {
        System.out.println("Deleting Product with id " + code);
        productService.delete(code);
    }
    
    //Search a product
	@RequestMapping(value = "/search/{str}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Product> searchInfo(@PathVariable("str") String str) {
	        List<Product> search = productService.searchProduct(str);
	        return search;
	    }
	
    
    
}
   
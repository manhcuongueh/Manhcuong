package albert.com.hibernate.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import albert.com.hibernate.models.Account;
import albert.com.hibernate.services.AccountService;



@RestController
@RequestMapping("/")
public class AccountController {
 
    @Autowired
    AccountService accountService;
    
    //Get all accounts
	@RequestMapping(value = "/account", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> listAllAccount() {
        List<Account> accs = accountService.getAllAccount();
        return accs;
    }
	
    //Get an account
	@RequestMapping(value = "/account/{accId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Account getSingleAccount(@PathVariable("accId") int accId) {
        System.out.println("Fetching Account with id " + accId);
        Account acc = accountService.findById(accId);
        return acc;
    }
	
    //Create an account
	@RequestMapping(value = "/account", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String Register(@RequestBody Account acc  ) throws JsonProcessingException {
    	System.out.println("Creating User " + acc.getEmail() + " " + acc.getFirstName());
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode x = objectMapper.createObjectNode();
        if (accountService.isAccountExist(acc.getEmail())!=0) {
            System.out.println("A User with name " + acc.getEmail() + " already exist");
            
            x.put("code",-1000);
            x.put("message", "account exists");
            return objectMapper.writeValueAsString(x);
        }
 
        accountService.saveAccount(acc);
        
        int id=accountService.isAccountExist(acc.getEmail());
 
        x.put("code",1000);
        x.put("message", id);
        return objectMapper.writeValueAsString(x);
       }
	
    //Update an account
	@RequestMapping(value = "/account", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public String Update(@RequestBody Account acc  ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode x = objectMapper.createObjectNode();
        System.out.println("Updating Account " + acc.getAccId());
        accountService.updateAccount(acc);;
        x.put("code",1000);
        x.put("message","SC_OK");
        return objectMapper.writeValueAsString(x);
    }
	
    //Delete an account
	@RequestMapping(value = "/account/{accId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void  DeleteAccount(@PathVariable("accId") int accId) {
        accountService.deleteAccount(accId);
    }
	
	//login
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String Login(@RequestBody Account acc  ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode x = objectMapper.createObjectNode();
        int id=accountService.login(acc.getEmail(), acc.getPassword());
        if (id!=0) {
            System.out.println("login success");
            
            x.put("code",1000);
            x.put("message", id  );
            return objectMapper.writeValueAsString(x);
        }
 
        else{
        	System.out.println("login fail");
        	x.put("code",-1000);
        	x.put("message","Account's not found");
        	return objectMapper.writeValueAsString(x);
        }
       }
    //login admin
    @RequestMapping(value = "/admin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String Admin(@RequestBody Account acc  ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode x = objectMapper.createObjectNode();
        if (accountService.adminLogin(acc.getEmail(), acc.getPassword())) {
            System.out.println("login success");
            
            x.put("code",1000);
            x.put("message", "Login success");
            return objectMapper.writeValueAsString(x);
        }
 
        else{
        	System.out.println("login fail");
        	x.put("code",-1000);
        	x.put("message","Account's not found");
        	return objectMapper.writeValueAsString(x);
        }
       }   
}
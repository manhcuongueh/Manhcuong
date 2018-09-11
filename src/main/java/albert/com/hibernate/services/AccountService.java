package albert.com.hibernate.services;

import java.util.List;
import albert.com.hibernate.models.Account;


public interface AccountService {

	Account findById(int id);
	
	int isAccountExist(String email);
	
	void saveAccount(Account account);
	
	void updateAccount(Account account);
	
	void deleteAccount(int accId);
	
	List<Account> getAllAccount();
	
	int login(String email, String password);
	
	boolean adminLogin(String email, String password);

	
}

package albert.com.hibernate.dao;

import java.util.List;

import albert.com.hibernate.models.Account;

	public interface AccountDao {

		Account findById(int id);
		
		int isAccountExist(String email);
		
		void saveAccount(Account account);
		
		void updateAccount(Account account);
		
		void deleteAccount(int accId);
		
		List<Account> getAllAccount();
		
		int login(String email, String password);
	
}

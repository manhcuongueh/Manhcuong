package albert.com.hibernate.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import albert.com.hibernate.dao.AccountDao;
import albert.com.hibernate.models.Account;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	public Account findById(int id) {
		return accountDao.findById(id);
	}
	
	public int isAccountExist(String email) {
		return accountDao.isAccountExist(email);
	}
	
	public void saveAccount(Account account) {
		accountDao.saveAccount(account);

	}
	
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	public void deleteAccount(int accId) {
		accountDao.deleteAccount(accId);

	}
	
	public List<Account> getAllAccount() {
		return accountDao.getAllAccount();
	}
	
	public int login(String email, String password){
		return accountDao.login(email, password);
	}
	public boolean adminLogin(String email, String password){
		if(email.equals("admin@ctproject.com") && password.equals("123456")){
			return true;
		}
		return false;
	}

}

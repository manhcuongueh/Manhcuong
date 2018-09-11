package albert.com.hibernate.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import albert.com.hibernate.models.Account;



	@Repository("accountDao")
	public class AccountDaoImpl extends AbstractDao<Integer, Account>implements AccountDao  {
	
	public Account findById(int id) {
			return getByKey(id);
		}
	
	public void saveAccount(Account account){
		persist(account);
	}
	
	public void updateAccount(Account account){
		update(account);
		
	}

	public void deleteAccount(int accId){
		getSession().createQuery("DELETE FROM Account WHERE accId = :accId")
		.setParameter("accId", accId)
		.executeUpdate();
	}
		
	@SuppressWarnings("unchecked")
	public int isAccountExist(String email){
		List<Account> infoList = getSession().createQuery("FROM Account WHERE email= :email")
				.setParameter("email", email)
				.list();
		if (infoList.size()>=1){
			int id=infoList.get(0).getAccId();
			return id;}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public  List<Account> getAllAccount(){
		return  getSession().createQuery("from Account").list();
		
	}
	@SuppressWarnings("unchecked")
	public int login(String email, String password){
		String Que="FROM Account WHERE email = :email AND password = :password";
		List<Account> list = getSession().createQuery(Que)
				.setParameter("email", email)
				.setParameter("password", password)
				.list();
		if(list.size()>0){
			int id=list.get(0).getAccId();
			return id;
		}
		return 0;
	}


}

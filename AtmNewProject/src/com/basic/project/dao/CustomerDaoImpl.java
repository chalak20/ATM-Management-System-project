package com.basic.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.basic.project.entity.Account;
import com.basic.project.entity.AtmCard;
import com.basic.project.entity.Customer;

public class CustomerDaoImpl implements CustomerDao{

	EntityManager entityManager = MyConnection.getEntityManagerObject();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	@Override
	public Customer findCardNumber(String cardNo) {
		Customer customer1 = null;
		Account account1 = null;
		
		String jpql = "select a from Account a";
		Query query = entityManager.createQuery(jpql);
		List<Account> accounts = query.getResultList();
		
		for(Account account : accounts)
		{
			AtmCard atmCard = account.getAtmCard();
			if(atmCard.getCardNo().equals(cardNo))
			{
				account = atmCard.getAccount();
				if(atmCard.getCardNo().equals(cardNo))
				{
					account1 = atmCard.getAccount();
					//System.out.println(atmCard.getCardNo());
					customer1 = account.getCustomer();
					break;
				}
			}
		}
		if(customer1 != null)
		{
			customer1 = entityManager.find(Customer.class, customer1.getCustomerId());
		}

		return customer1;
	}

	@Override
	public String cardStatus(Customer customer) {
		entityTransaction.begin();
		customer.getAccount().get(0).getAtmCard().setCardStatus("Deactive");
		entityTransaction.commit();
		return "Your card is now blocked for security Reasons";
	}


/*	@Override
	public String cardStatus(Account account) {
		entityTransaction.begin();
		account.getAtmCard().setCardStatus("Deactive");
		entityTransaction.commit();
		return "Card is Blocked";
	}*/

}




/*

@Override
public String cardStatus(Customer customer) {
	AtmCard atmCard = customer.getAccount().get(0).getAtmCard();
	if(customer != null && customer.getAccount() != null && !customer.getAccount().isEmpty())
	{
		atmCard.setCardStatus("Blocked");
		entityTransaction.begin();
		entityManager.persist(atmCard);
		entityTransaction.commit();
	}
	return "Sorry your card is bloacked";
}

*/
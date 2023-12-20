package com.basic.project.presentation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.basic.project.entity.Account;
import com.basic.project.entity.AtmCard;
import com.basic.project.entity.Bank;
import com.basic.project.entity.Customer;

public class BankDummyData {

	public static void main(String[] args) {
		
		Bank bank1 = new Bank();
		Bank bank2 = new Bank();
		//Bank bank3 = new Bank();
		
		Customer customer1 = new Customer();
		Customer customer2 = new Customer();
		Customer customer3 = new Customer();
		Customer customer4 = new Customer();
		Customer customer5 = new Customer();
		Customer customer6 = new Customer();
		Customer customer7 = new Customer();
		Customer customer8 = new Customer();
		Customer customer9 = new Customer();
		Customer customer10 = new Customer();
		
		AtmCard atmCard1 = new AtmCard();
		AtmCard atmCard2 = new AtmCard();
		AtmCard atmCard3 = new AtmCard();
		AtmCard atmCard4 = new AtmCard();
		AtmCard atmCard5 = new AtmCard();
		AtmCard atmCard6 = new AtmCard();
		AtmCard atmCard7 = new AtmCard();
		AtmCard atmCard8 = new AtmCard();
		AtmCard atmCard9 = new AtmCard();
		AtmCard atmCard10 = new AtmCard();
		
		Account account1 = new Account();
		Account account2 = new Account();
		Account account3 = new Account();
		Account account4 = new Account();
		Account account5 = new Account();
		Account account6 = new Account();
		Account account7 = new Account();
		Account account8 = new Account();
		Account account9 = new Account();
		Account account10 = new Account();
		
		List<Account> listAccount1 = List.of(account1,account2,account3,account4,account5);
		List<Account> listAccount2 = List.of(account6,account7,account9,account8,account10);
		//List<Account> lisAccount3 = List.of(account6,account7);
		
		List<Customer> listCustomer1 = List.of(customer1,customer2,customer3,customer4,customer5);
		List<Customer> listCustomer2 = List.of(customer7,customer9,customer6,customer8,customer10);
		//List<Customer> listCustomer3 = List.of(customer6,customer7);
		
		bank1.setIfscCode("ICIC0001096");
		bank1.setBankName("ICICI Bank");
		bank1.setBranchCode("001096");
		bank1.setCustomer(listCustomer1);

		bank2.setIfscCode("HDFC0001784");
		bank2.setBankName("HDFC Bank");
		bank2.setBranchCode("001784 ");
		bank2.setCustomer(listCustomer2);
		
		/*bank3.setIfscCode("SBIN0020885");
		bank3.setBankName("SBI Bank");
		bank3.setBranchCode("006756 ");
		bank3.setCustomer(listCustomer3);*/
		
		customer1.setCustomerId(581692841);
		customer1.setCustomerName("Rahul Chalak");
		customer1.setAddress("Beed 431123");
		customer1.setCustomerContact("9766220440");
		customer1.setDateOfBirth(LocalDate.of(1994,05,02));
		customer1.setGeneder('M');
		customer1.setEmailId("rahulchalak94@gmail.com");
		customer1.setPanNumber("BCZPC0097H");
		customer1.setAdharNumber("772273260188");
		customer1.setBank(bank1);
		customer1.setAccount(listAccount1);
		
		
		customer2.setCustomerId(872953219);
		customer2.setCustomerName("Ganesh Chalak");
		customer2.setAddress("Beed 431123");
		customer2.setCustomerContact("9766103403");
		customer2.setDateOfBirth(LocalDate.of(1992,05,17));
		customer2.setGeneder('M');
		customer2.setEmailId("ganeshchalak07@gmail.com");
		customer2.setPanNumber("PCQER5729P");
		customer2.setAdharNumber("944832007122");
		customer2.setBank(bank1);
		customer2.setAccount(listAccount1);
		
		customer3.setCustomerId(859327106);
		customer3.setCustomerName("Priyanka Chalak");
		customer3.setAddress("Beed 431122");
		customer3.setCustomerContact("8605959086");
		customer3.setDateOfBirth(LocalDate.of(2001,07,20));
		customer3.setGeneder('F');
		customer3.setEmailId("priyankachalak08@gmail.com");
		customer3.setPanNumber("BOVPC2055P");
		customer3.setAdharNumber("512144832009");
		customer3.setBank(bank1);
		customer3.setAccount(listAccount1);
		
		customer4.setCustomerId(174249777);
		customer4.setCustomerName("Simran Jain");
		customer4.setAddress("Shirpur");
		customer4.setCustomerContact("992286790");
		customer4.setDateOfBirth(LocalDate.of(1999, 12, 24));
		customer4.setGeneder('F');
		customer4.setEmailId("simranjain241@gmail.com");
		customer4.setPanNumber("CKJPJ2395E");
		customer4.setAdharNumber("571233742026");
		customer4.setBank(bank2);
		customer4.setAccount(listAccount2);

		customer5.setCustomerId(593018730);
		customer5.setCustomerName("Shraddha Kandle");
		customer5.setAddress("L.I.C. Colony Latur");
		customer5.setCustomerContact("9730710368");
		customer5.setDateOfBirth(LocalDate.of(2002,02,8));
		customer5.setGeneder('F');
		customer5.setEmailId("shraddhakandle7@gmail.com");
		customer5.setPanNumber("KLAPK7085N");
		customer5.setAdharNumber("645921345471");
		customer5.setBank(bank1);
		customer5.setAccount(listAccount1);
		
		customer6.setCustomerId(732891806);
		customer6.setCustomerName("Rahul Chalak");
		customer6.setAddress("Beed 431123");
		customer6.setCustomerContact("9766220440");
		customer6.setDateOfBirth(LocalDate.of(1994,05,02));
		customer6.setGeneder('M');
		customer6.setEmailId("rahulchalak94@gmail.com");
		customer6.setPanNumber("BCZPC0097H");
		customer6.setAdharNumber("772273260188");
		customer6.setBank(bank1);
		customer6.setAccount(listAccount1);
		
		
		customer7.setCustomerId(248129624);
		customer7.setCustomerName("Ganesh Chalak");
		customer7.setAddress("Beed 431123");
		customer7.setCustomerContact("9766103403");
		customer7.setDateOfBirth(LocalDate.of(1992,05,17));
		customer7.setGeneder('M');
		customer7.setEmailId("ganeshchalak07@gmail.com");
		customer7.setPanNumber("PCQER5729P");
		customer7.setAdharNumber("944832007122");
		customer7.setBank(bank2);
		customer7.setAccount(listAccount2);
		
		customer8.setCustomerId(593018765);
		customer8.setCustomerName("Shraddha Kandle");
		customer8.setAddress("L.I.C. Colony Latur");
		customer8.setCustomerContact("9730710368");
		customer8.setDateOfBirth(LocalDate.of(2002,02,8));
		customer8.setGeneder('F');
		customer8.setEmailId("shraddhakandle7@gmail.com");
		customer8.setPanNumber("KLAPK7085N");
		customer8.setAdharNumber("645921345471");
		customer8.setBank(bank2);
		customer8.setAccount(listAccount2);
		
		customer9.setCustomerId(923223377);
		customer9.setCustomerName("Madhuri Rodage");
		customer9.setAddress("Osmanabad");
		customer9.setCustomerContact("9067718645");
		customer9.setDateOfBirth(LocalDate.of(2000,10,11));
		customer9.setGeneder('F');
		customer9.setEmailId("madhuri@gmail.com");
		customer9.setPanNumber("PUVRC3035X");
		customer9.setAdharNumber("971599490146");
		customer9.setBank(bank2);
		customer9.setAccount(listAccount2);
		
		customer10.setCustomerId(784759873);
		customer10.setCustomerName("Priyanka Chalak");
		customer10.setAddress("Beed 431122");
		customer10.setCustomerContact("8605959086");
		customer10.setDateOfBirth(LocalDate.of(2001,07,20));
		customer10.setGeneder('F');
		customer10.setEmailId("priyankachalak08@gmail.com");
		customer10.setPanNumber("BOVPC2055P");
		customer10.setAdharNumber("512144832009");
		customer10.setBank(bank1);
		customer10.setAccount(listAccount1);
		
		atmCard1.setCardNo("4035620367319009");
		atmCard1.setCardPin("2735");
		atmCard1.setCardStatus("Active");
		atmCard1.setCardType("Atm Card");
		atmCard1.setCvvNo("236");
		atmCard1.setIssueDate(LocalDate.now());
		atmCard1.setExpiryDate(LocalDate.of(2025, 11, 22));
		atmCard1.setAccount(account1);
		
		atmCard2.setCardNo("7951926185390520");
		atmCard2.setCardPin("4592");
		atmCard2.setCardStatus("Active");
		atmCard2.setCardType("Atm Card");
		atmCard2.setCvvNo("569");
		atmCard2.setIssueDate(LocalDate.now());
		atmCard2.setExpiryDate(LocalDate.of(2025, 11, 22));
		atmCard2.setAccount(account10);
		
		atmCard3.setCardNo("9372106293517280");
		atmCard3.setCardPin("8293");
		atmCard3.setCardStatus("Active");
		atmCard3.setCardType("Debit Card");
		atmCard3.setCvvNo("895");
		atmCard3.setIssueDate(LocalDate.now());
		atmCard3.setExpiryDate(LocalDate.of(2025, 11, 22));
		atmCard3.setAccount(account2);
		
		atmCard4.setCardNo("3555602363918219");
		atmCard4.setCardPin("4578");
		atmCard4.setCardStatus("Active");
		atmCard4.setCardType("Atm Card");
		atmCard4.setCvvNo("974");
		atmCard4.setIssueDate(LocalDate.now());
		atmCard4.setExpiryDate(LocalDate.of(2025, 11, 22));
		atmCard4.setAccount(account9);
				
		atmCard5.setCardNo("5419190535912508");
		atmCard5.setCardPin("7645");
		atmCard5.setCardStatus("Active");
		atmCard5.setCardType("Debit Card");
		atmCard5.setCvvNo("308");
		atmCard5.setIssueDate(LocalDate.now());
		atmCard5.setExpiryDate(LocalDate.of(2026, 07, 06));
		atmCard5.setAccount(account8);
		
		atmCard6.setCardNo("4539890694174101");
		atmCard6.setCardPin("1035");
		atmCard6.setCardStatus("Active");
		atmCard6.setCardType("Atm Card");
		atmCard6.setCvvNo("865");
		atmCard6.setIssueDate(LocalDate.now());
		atmCard6.setExpiryDate(LocalDate.of(2025, 11, 21));
		atmCard6.setAccount(account3);
		
		atmCard7.setCardNo("8174060132287837");
		atmCard7.setCardPin("2093");
		atmCard7.setCardStatus("Active");
		atmCard7.setCardType("Atm Card");
		atmCard7.setCvvNo("372");
		atmCard7.setIssueDate(LocalDate.now());
		atmCard7.setExpiryDate(LocalDate.of(2027, 07, 01));
		atmCard7.setAccount(account7);
		
		atmCard8.setCardNo("7319009403562036");
		atmCard8.setCardPin("6754");
		atmCard8.setCardStatus("Active");
		atmCard8.setCardType("Debit Card");
		atmCard8.setCvvNo("786");
		atmCard8.setIssueDate(LocalDate.now());
		atmCard8.setExpiryDate(LocalDate.of(2028, 01, 12));
		atmCard8.setAccount(account4);
		
		atmCard9.setCardNo("3905207951926185");
		atmCard9.setCardPin("7521");
		atmCard9.setCardStatus("Active");
		atmCard9.setCardType("Debit Card");
		atmCard9.setCvvNo("806");
		atmCard9.setIssueDate(LocalDate.now());
		atmCard9.setExpiryDate(LocalDate.of(2024, 11, 20));
		atmCard9.setAccount(account6);
		
		atmCard10.setCardNo("8520795193905261");
		atmCard10.setCardPin("6943");
		atmCard10.setCardStatus("Active");
		atmCard10.setCardType("Atm Card");
		atmCard10.setCvvNo("521");
		atmCard10.setIssueDate(LocalDate.now());
		atmCard10.setExpiryDate(LocalDate.of(2024, 07, 10));
		atmCard10.setAccount(account5);
		
		account1.setAccountNumber("10960100562");
		account1.setAccountOpeningDate(Date.valueOf(LocalDate.now()));
		account1.setAccountStatus("Active");
		account1.setAccountType("Saving");
		account1.setBalance(45000);
		account1.setCustomer(customer1);
		account1.setAtmCard(atmCard1);
		account1.setTransaction(null);
		
		account2.setAccountNumber("50100920319407");
		account2.setAccountOpeningDate(Date.valueOf(LocalDate.now()));
		account2.setAccountStatus("Active");
		account2.setAccountType("Current");
		account2.setBalance(65000);
		account2.setCustomer(customer2);
		account2.setAtmCard(atmCard2);
		account2.setTransaction(null);
		
		account3.setAccountNumber("10960659059");
		account3.setAccountOpeningDate(Date.valueOf(LocalDate.now()));
		account3.setAccountStatus("Active");
		account3.setAccountType("Saving");
		account3.setBalance(39000);
		account3.setCustomer(customer6);
		account3.setAtmCard(atmCard6);
		account3.setTransaction(null);
		
		account4.setAccountNumber("50100386357831");
		account4.setAccountOpeningDate(Date.valueOf(LocalDate.now()));
		account4.setAccountStatus("Active");
		account4.setAccountType("Current");
		account4.setBalance(79000);
		account4.setCustomer(customer7);
		account4.setAtmCard(atmCard7);
		account4.setTransaction(null);
		
		account5.setAccountNumber("50100441134660");
		account5.setAccountOpeningDate(Date.valueOf(LocalDate.now()));
		account5.setAccountStatus("Active");
		account5.setAccountType("Saving");
		account5.setBalance(3000);
		account5.setCustomer(customer4);
		account5.setAtmCard(atmCard4);
		account5.setTransaction(null);
		
		account6.setAccountNumber("62123456769");
		account6.setAccountOpeningDate(Date.valueOf(LocalDate.now()));
		account6.setAccountStatus("Active");
		account6.setAccountType("Current");
		account6.setBalance(15000);
		account6.setCustomer(customer3);
		account6.setAtmCard(atmCard3);
		account6.setTransaction(null);
		
		account7.setAccountNumber("46605010044113");
		account7.setAccountOpeningDate(Date.valueOf(LocalDate.now()));
		account7.setAccountStatus("Active");
		account7.setAccountType("Saving");
		account7.setBalance(2000);
		account7.setCustomer(customer9);
		account7.setAtmCard(atmCard9);
		account7.setTransaction(null);
		 
		account8.setAccountNumber("37213420602");
		account8.setAccountOpeningDate(Date.valueOf(LocalDate.now()));
		account8.setAccountStatus("Active");
		account8.setAccountType("Current");
		account8.setBalance(39000);
		account8.setCustomer(customer5);
		account8.setAtmCard(atmCard5);
		account8.setTransaction(null);
		
		account9.setAccountNumber("41134660501004");
		account9.setAccountOpeningDate(Date.valueOf(LocalDate.now()));
		account9.setAccountStatus("Active");
		account9.setAccountType("Saving");
		account9.setBalance(25000);
		account9.setCustomer(customer8);
		account9.setAtmCard(atmCard8);
		account9.setTransaction(null);
		
		account10.setAccountNumber("20602372134");
		account10.setAccountOpeningDate(Date.valueOf(LocalDate.now()));
		account10.setAccountStatus("Active");
		account10.setAccountType("Saving");
		account10.setBalance(4000);
		account10.setCustomer(customer10);
		account10.setAtmCard(atmCard10);
		account10.setTransaction(null);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("priya");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
			entityManager.persist(bank1);
			entityManager.persist(bank2);
			//entityManager.persist(bank3);
		entityTransaction.commit();
		
		System.out.println("Object Saved Successfully !!!!");
		
		entityManager.close();
		entityManagerFactory.close();
		
		
	}

}

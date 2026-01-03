package com.ecommerce.service;

import java.util.*;

import com.ecommerce.repo.ProductRepo;
import com.ecommerce.repo.UserRepo;
import com.ecommerce.to.ProductTO;
import com.ecommerce.to.UserTO;

public class UserService {
	static int orderID=1;
	UserRepo userRepo = new UserRepo();
	ProductRepo productRepo = new ProductRepo();
	Scanner sc = new Scanner(System.in);
//method for login to admin or user inside it we are calling method of UserRepo

	public void register() {
		System.out.println("Enter your role");
		String role = sc.next();
		System.out.println("Enter your Id!!");
		int id = sc.nextInt();
		System.out.println("Enter your FirstName");
		String fname = sc.nextLine();
		sc.next();
		System.out.println("Enter your lastName");
		String lname = sc.nextLine();
		sc.next();
		System.out.println("Enter your Email");
		String email = sc.nextLine();
		sc.next();
		System.out.println("Enter your password!!");
		String password = sc.next();

		UserTO user = new UserTO(id, fname, lname, email, password, role);
		userRepo.register(user);

	}

//method for login to admin or user inside it we are calling method of UserRepo

	public int login() {

		System.out.println("Enter the your role you want to login");
		String role = sc.next();
		System.out.println("Enter your Password");

		String password = sc.next();

		userRepo.login(password);// userRepo login method is called

		if (role.equalsIgnoreCase("admin")) {

			return 1;

		} else if (role.equalsIgnoreCase("user")) {

			return 0;

		}

		return 0;

	}
//this method id used for add products
	public void addProducts() {

//while(true) {

		System.out.println("Enter your product id!!");

		int pId = sc.nextInt();

		sc.nextLine();

		System.out.println("Enter The productName");

		String productName = sc.nextLine();

		System.out.println("Enter The category");

		String category = sc.next();

		System.out.println("Enter The Price of the product");

		int price = sc.nextInt();

		ProductTO productInfo = new ProductTO(pId, productName, price, category);

		userRepo.addProducts(productInfo);

	}
//this method is used for search product by id 
	public void searchProductById() {

		System.out.println("Enter The product_id");

		int pId = sc.nextInt();

		userRepo.searchProductById(pId);

	}
//this is for update product method
	public void updateproduct() {

		System.out.println("Enter Pid of the Product you Want to update!!");

		int pId = sc.nextInt();

		sc.nextLine();

		System.out.println("Enter The ProductName to be Updated");

		String productName = sc.nextLine();

		System.out.println("Enter The Category to be Updated");

		String category = sc.next();

		System.out.println("Enter The Author to be Updated");

		String publication = sc.next();

		System.out.println("Enter The Price to be Updated");

		int price = sc.nextInt();

		ProductTO productInfo = new ProductTO(pId, productName, price, category);

		userRepo.updateProduct(productInfo);

	}
//this is for deleting products
	public void deleteProducts() {

		System.out.println("Enter your product Id!!");

		int pId = sc.nextInt();

		userRepo.removeProduct(pId);

	}
//is is for repeating or not 
	public boolean repeatOrNot(String s) {

		System.out.println("Do you want to Continue the Operation: " + s);

		String userOption = sc.next();

		if (userOption.equalsIgnoreCase("No")) {

			return true;

		}

		return false;

	}

//method for logout

	public void logout() {

		System.exit(0);

	}
	public void placeOrder() {
        System.out.println("Enter your product id!!");
        int pId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter The productName");
        String productName = sc.nextLine();
        System.out.println("Enter The category");
        String category = sc.next();
        System.out.println("Enter The Price of the product");
        int price=sc.nextInt();
        
        System.out.println("Enter The userId");
        int userID=sc.nextInt();
        
        ProductTO productInfo = new ProductTO(pId,productName,price,category);
        userRepo.placeOrder(productInfo, orderID, userID);
    }
    public void seeAllOrder() {
        productRepo.seeAllOrder();
    }

//

// public int countTotalBook() {

// return userRepo.countTotalBook();

// }

}

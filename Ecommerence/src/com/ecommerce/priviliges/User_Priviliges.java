package com.ecommerce.priviliges;

import java.util.List;
import java.util.Scanner;

import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserService;

public class User_Priviliges {
public void userRun() {
	UserService service = new UserService();
	ProductService productService=new ProductService();
	
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Press 1 for searchProductById , 2 for searchProductById ,3 for searchBookBypublicationNamehb, 4 searchBookByTitleName, 5 to addtofav,6 for addto complete");

	int mainMenuChoice = sc.nextInt();

	switch (mainMenuChoice) {

	case 1:
		while(true) {
			service.searchProductById();
			if(service.repeatOrNot("searchProduct")) {
				break;
			}
		}
		break;
	case 2:
		while(true) {
			service.placeOrder();
			if(service.repeatOrNot("placeorder")) {
				break;
			}
		}
		break;
	case 3:
		while(true) {
			service.seeAllOrder();
			if(service.repeatOrNot("seeAllOrder")) {
				break;
			}
		}
		break;
	}
}
}

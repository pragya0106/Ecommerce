package com.ecommerce.priviliges;

import java.util.List;
import java.util.Scanner;

import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserService;
import com.ecommerce.to.ProductTO;


public class Admin_Priviliges {
public void adminRun() {
	UserService userService = new UserService();
	ProductService productService = new ProductService();
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Press 1 for adding product\n 2 for deleting product\n, 3 for searchproductById ,"
			+"\n5 to updateProduct,\n 7 to arrangeProductHighToLow "+" \n7 6 to arrangeProductLowToHigh");

	int mainMenuChoice = sc.nextInt();

	switch (mainMenuChoice) {

	case 1:
		while(true) {
		userService.addProducts();
		if(userService.repeatOrNot("addProduct")) {
			break;
		}
		}
		break;
	case 2:
		while(true) {
			userService.deleteProducts();
			if(userService.repeatOrNot("deleteProduct")) {
				break;
			}
		}
		
		break;
	case 3:
		while(true) {
			userService.searchProductById();
			if(userService.repeatOrNot("searchProduct")) {
				break;
			}
		}
		break;
	case 5:
		userService.addProducts();
		if(userService.repeatOrNot("updateProduct")) {
			break;
		}
		break;
	case 6:
		List<ProductTO> product=productService.arrangeProductLowToHighByPrice();
		productService.DisplayAllInfo(product);
		break;
	case 7:
		List<ProductTO> products=productService.arrangeProductHighToLowByPrice();
		productService.DisplayAllInfo(products);
		break;
	}
}
}

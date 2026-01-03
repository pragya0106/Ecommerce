package com.ecommerce.rurrner;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.*;

import com.ecommerce.priviliges.Admin_Priviliges;
import com.ecommerce.priviliges.User_Priviliges;
import com.ecommerce.service.*;
import com.ecommerce.to.ProductTO;

public class MainRunner {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		UserService service = new UserService();
		ProductService productService = new ProductService();
		User_Priviliges user=new User_Priviliges();
		Admin_Priviliges admin = new Admin_Priviliges();

//this is the runner class of my project in which user and admin can login ,register and logout

		Scanner sc = new Scanner(System.in);

		System.out.println("Press\n1 for Registration\n2 for login \n 3 for logout");

		int mainMenuChoice = sc.nextInt();

		switch (mainMenuChoice) {

		case 1:

			service.register();// calling method for register by creating object of userService class and
								// calling by that reference

			break;
		case 2:
			int operation = service.login();// calling method for login by creating object of userService class and
											// calling by that reference
			if (operation == 1) {
				System.out.println("Welcome Admin to GlobalLogic BookStore");
				List<ProductTO> products = productService.getAllproducts();
				productService.DisplayAllInfo(products);
				admin.adminRun();
// userHome.userRun();
			} else if (operation == 0) {
				System.out.println("Welcome User to GlobalLogic BookStore");
				user.userRun();
// adminHome.adminRun();
			}
			break;
		case 3:
			System.out.println("You Have been Sucessfully logged out");
			service.logout();// calling method for logout by creating object of userService class and calling
								// by that reference

		}

	}
}

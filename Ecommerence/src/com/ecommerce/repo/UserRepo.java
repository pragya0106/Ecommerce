package com.ecommerce.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ecommerce.db.DBconnection;
import com.ecommerce.to.ProductTO;
import com.ecommerce.to.UserTO;

public class UserRepo {
	Connection connection = DBconnection.getConnection();

//this is method inside the UserRepo for registering
	public void register(UserTO user) {

		try {

			PreparedStatement statement = connection.prepareStatement("insert into user values(?, ?,?,?,?,?,?)");

			statement.setInt(1, user.getId());
			statement.setString(2, user.getFirst_name());
			statement.setString(3, user.getLast_name());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getRole());
			statement.setString(7, "false");

			int rowAffected = statement.executeUpdate();
			if (rowAffected > 0) {
				System.out.println("You Have Been Registered Succesfully as " + user.getRole());
			}
		} catch (Exception e) {
			System.out.println("inside regsiter of UserRepository");
			e.printStackTrace();
		}

	}
//this method is for login
	public void login(String password) {
		try {
			PreparedStatement statement = connection.prepareStatement("select * from user where password = ?");
			statement.setString(1, password);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String isBlocked = resultSet.getString(7);
				if (isBlocked == "true") {
					System.out.println("you are bolcked by admin you can not login  ");
				}
			}

		} catch (Exception e) {
			System.out.println("invalid login credential");
		}

	}
//this method is used for add products
	public void addProducts(ProductTO info) {
		try {
			PreparedStatement statement = connection.prepareStatement("insert into product values(?, ?, ?,?)");
			statement.setInt(1, info.getProductId());
			statement.setString(2, info.getProductName());
			statement.setInt(3, info.getPrice());
			statement.setString(4, info.getProductCategory());

			int rowAdded = statement.executeUpdate();
			if (rowAdded > 0) {
				System.out.println("A new product  has been!");
			}

		} catch (Exception e) {
			System.out.println("inside catch of addProduct");
		}

	}
//this method is used for remove product
	public void removeProduct(int p_id) {
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM product WHERE p_id=?");
			statement.setInt(1, p_id);

			int rowDeleted = statement.executeUpdate();
			if (rowDeleted > 0) {
				System.out.println("product has Been deleted");
			}

		} catch (Exception e) {
			System.out.println("inside catch of removeBook");
		}

	}
//this method is used for update product 
	public void updateProduct(ProductTO product) {
		try {
			PreparedStatement statement = connection
					.prepareStatement("UPDATE book SET p_name=?, p_category=?, p_price=? WHERE p_id=?");

			statement.setInt(1, product.getProductId());
			statement.setString(2, product.getProductName());
			statement.setInt(3, product.getPrice());
			statement.setString(4, product.getProductCategory());

			int rowUpdated = statement.executeUpdate();
			if (rowUpdated > 0) {
				System.out.println("Product  has Been Updated");
			}

		} catch (Exception e) {
			System.out.println("inside catch of updateProduct");
		}

	}
//this method is used for place order
	public void placeOrder(ProductTO info, int orderId, int productId, int userId) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"insert into order_details(order_id ,product_id,user_id, p_name, p_category) values(?, ?, ?,?,?)");
			statement.setInt(1, orderId);
			statement.setInt(2, productId);
			statement.setInt(3, userId);
			statement.setString(4, info.getProductName());
			statement.setString(5, info.getProductCategory());

			int rowAdded = statement.executeUpdate();
			if (rowAdded > 0) {
				System.out.println("A new order has been placed!");
			}

		} catch (Exception e) {
			System.out.println("inside catch of placeOrder");
		}

	}
//this method is used for search product by id
	public void searchProductById(int pId) {
		try {
			PreparedStatement statement = connection.prepareStatement("select * from product where p_id = ?");
			statement.setInt(1, pId);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int productId = resultSet.getInt(1);
				String productName = resultSet.getString(2);
				int price = resultSet.getInt(3);
				String category = resultSet.getString(5);
				System.out.println("The product details  " + productId + "   " + productName + "   " + price
						+ " with price " + category);
			}

		} catch (Exception e) {
			System.out.println("catch under search block");
		}

	}
	public void placeOrder(ProductTO info,int orderId,int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into order_details(order_id ,product_id,user_id, p_name, p_category) values(?, ?, ?,?,?)");
            statement.setInt(1, orderId);
            statement.setInt(2, info.getProductId());
            statement.setInt(3, userId);
            statement.setString(4, info.getProductName());
            statement.setString(5, info.getProductCategory());
            
            int rowAdded=statement.executeUpdate();
            if(rowAdded>0){
                System.out.println("A new order has been placed!");
            }
            
        }catch(Exception e) {
            System.out.println("inside catch of placeOrder");
        }
        
    }
    
    

}
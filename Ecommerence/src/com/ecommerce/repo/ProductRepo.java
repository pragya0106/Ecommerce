package com.ecommerce.repo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ecommerce.db.DBconnection;
import com.ecommerce.to.ProductTO;
public class ProductRepo {
    Connection connection  = DBconnection.getConnection();
public List<ProductTO> arrangeProductLowToHighByPrice() {
        
        List<ProductTO> products = new ArrayList<ProductTO>();
        
        try {
            
            PreparedStatement statement = connection.prepareStatement("select * from product order by p_price asc");
            
            ResultSet resultSet =  statement.executeQuery();
            while(resultSet.next()) {
                
                int pId = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                int price = resultSet.getInt(3);
                String category = resultSet.getString(4);
                
                ProductTO productInfo = new ProductTO(pId,productName,price,category);
                products.add(productInfo);
            }
            
        }
        
        catch (Exception e) {
            System.out.println("inside catch of BooKRepo");
        }
        
        return products;
        
        
    }
public List<ProductTO> arrangeProductHighToLowByPrice() {
    
    List<ProductTO> products = new ArrayList<ProductTO>();
    
    try {
        
        PreparedStatement statement = connection.prepareStatement("select * from product order by p_price desc");
        
        ResultSet resultSet =  statement.executeQuery();
        while(resultSet.next()) {
            
            int pId = resultSet.getInt(1);
            String productName = resultSet.getString(2);
            int price = resultSet.getInt(3);
            String category = resultSet.getString(4);
            
            ProductTO productInfo = new ProductTO(pId,productName,price,category);
            products.add(productInfo);
        }
        
    }
    
    catch (Exception e) {
        System.out.println("inside catch of BooKRepo");
    }
    
    return products;
    
    
}
public List<ProductTO> findAllProducts() {
    
    List<ProductTO> products = new ArrayList<ProductTO>();
    
    try {
        
        PreparedStatement statement = connection.prepareStatement("select * from product");
        
        ResultSet resultSet =  statement.executeQuery();
        while(resultSet.next()) {
            
            int pId = resultSet.getInt(1);
            String productName = resultSet.getString(2);
            int price = resultSet.getInt(3);
            String category = resultSet.getString(4);
            
            ProductTO productInfo = new ProductTO(pId,productName,price,category);
            products.add(productInfo);
        }
        
    }
    
    catch (Exception e) {
        System.out.println("inside catch of ProductRepo");
    }
    
    return products;
    
    
}
public void seeAllOrder() {
    
    try {
        
        PreparedStatement statement = connection.prepareStatement("select * from order_details");
        
        ResultSet resultSet =  statement.executeQuery();
        while(resultSet.next()) {
            
            int orderId=resultSet.getInt(1);
            int productId=resultSet.getInt(2);
            int userId=resultSet.getInt(3);
            String productName=resultSet.getString(4);
            String productCategory=resultSet.getString(5);
            String date=resultSet.getString(6);
            
            System.out.println("order details" +orderId+", "+productId+", "+userId+","+productName);
        }
        
    }
    
    catch (Exception e) {
        System.out.println("inside catch of ProductRepo");
    }
    
    
    
}
    
}
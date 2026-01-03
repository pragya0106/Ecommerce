package com.ecommerce.service;

import java.util.List;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.to.ProductTO;

public class ProductService {

	ProductRepo productRepo = new ProductRepo();

	public List<ProductTO> arrangeProductLowToHighByPrice() {

		return productRepo.arrangeProductLowToHighByPrice();

	}

	public List<ProductTO> arrangeProductHighToLowByPrice() {

		return productRepo.arrangeProductHighToLowByPrice();

	}

	public List<ProductTO> getAllproducts() {

		return productRepo.findAllProducts();

	}

	public static void DisplayAllInfo(List<ProductTO> products) {

		for (ProductTO to : products) {

			System.out.println(
					to.getProductId() + ", " + to.getProductName() + ", " + to.getProductCategory() + "," + to.getPrice());

		}

	}

}

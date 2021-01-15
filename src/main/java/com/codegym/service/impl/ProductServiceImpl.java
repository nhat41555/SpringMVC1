package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.model.Product;
import com.codegym.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl  implements ProductService {
    private static List<Product> products;

    static {

        products = new ArrayList<>();
        products.add( new Product(1, "nhat", "22342322"));
        products.add( new Product(2, "long", "22234322"));
        products.add( new Product(3, "linh", "24234222"));
        products.add( new Product(4, "chem", "23423"));
        products.add( new Product(5, "cantin", "3423"));
        products.add( new Product(6, "hung", "23242422"));
    }


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {

        products.add( product);
    }

    @Override
    public Product findById(int id) {
        for (Product product:products) {
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        Product productEdit = findById(id);
        productEdit.setName(product.getName());
        productEdit.setPrice(product.getPrice());
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }


}

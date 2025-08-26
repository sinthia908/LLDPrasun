package com.interview.practice.services;

import com.interview.practice.enums.ProductCategory;
import com.interview.practice.models.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchService {

    private final Collection<Product> productCatalog;

    public SearchService(Collection<Product> productCatalog){
          this.productCatalog = productCatalog;

    }

    // search by product catalog

    public List<Product> searchByName(String name){
           List<Product> result = new ArrayList<>();
           productCatalog.stream()
                   .filter(p->p.getName().toLowerCase().equals(name.toLowerCase()))
                   .forEach(result::add);
           return result;
    }

    // Search by product catalog
    public List<Product> searchByCategory(ProductCategory productCategory){
           List<Product> result = new ArrayList<>();
           productCatalog.stream()
                   .filter(p->p.getProductCategory() == productCategory)
                   .forEach(result::add);
           return result;

    }


}

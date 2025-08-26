package com.interview.practice.models;

import com.interview.practice.enums.ProductCategory;

import java.util.UUID;

public abstract class Product {
    protected String id;
    protected String name;
    protected String description;
    protected double price;
    protected ProductCategory productCategory;

    public abstract String getId();
    public abstract String getName();
    public abstract String getDescription();
    public abstract double getPrice();
    public abstract ProductCategory getProductCategory();

    // Base Implementation for the builder

    public static class BaseProduct extends Product{

        @Override
        public String getId() {
            return id;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public ProductCategory getProductCategory() {
            return productCategory;
        }
    }

    // Builder pattern for creating products

    public static class Builder{
        private final String name;
        private final double price;
        private String description = "";
        private ProductCategory productCategory;

        public Builder(String name,double price){
             this.name = name;
             this.price = price;
        }

        public Builder withDescription(String description){
               this.description = description;
               return this;
        }

        public Builder withProductCategory(ProductCategory productCategory){
            this.productCategory = productCategory;
            return this;
        }

        public Product build(){
              return new BaseProduct(UUID.randomUUID().toString(),name,price,description,productCategory);
        }

    }

}

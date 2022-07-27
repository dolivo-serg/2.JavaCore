package com.javarush.task.task18.task1828;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static class Product {
        int id;
        String productName;
        String price;
        String quantity;

        public Product(int id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, productName, price, quantity);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length > 0){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            List<Product> products = new ArrayList<>();
            while (fileReader.ready()){
                products.add(getProduct(fileReader.readLine()));
            }
            List<Product> productsCopy = new ArrayList<>(products);
            switch (args[0]){
                case "-u":
                    for (int i = 0; i < products.size(); i++) {
                        if (productsCopy.get(i).id == Integer.parseInt(args[1])) {
                            products.set(i, new Product(Integer.parseInt(args[1]), args[2], args[3], args[4]));
                        }
                    }
                    break;
                case "-d":
                    for (Product product : productsCopy){
                        if (product.id == Integer.parseInt(args[1])){
                            products.remove(product);
                        }
                    }
                    break;
            }
            FileWriter fileWriter = new FileWriter(file);
            for (Product product : products) {
                fileWriter.write(product.toString());
                fileWriter.write('\n');
            }
            reader.close();
            fileReader.close();
            fileWriter.close();
        }
    }
    public static Product getProduct(String string){
        String id = string.substring(0, 8).trim();
        String productName = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46, 50).trim();
        return new Product(Integer.parseInt(id),productName, price, quantity);
    }
}

package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 0){
            if (args[0].equals("-c")){
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String file = reader.readLine();
                BufferedReader fileReader = new BufferedReader (new FileReader(file));
                List<String> products = new ArrayList<>();

                while (fileReader.ready()){
                    products.add(fileReader.readLine());
                }

                int newID = 0;
                for (String product : products){
                    int tmp;
                    if ((tmp = Integer.parseInt(product.substring(0, 8).trim())) > newID)
                        newID = tmp;
                }
                newID++;
                StringBuilder id = new StringBuilder();
                if (String.valueOf(newID).length() < 8) {
                    id.append(newID);
                    while (id.length() != 8) {
                        id.append(" ");
                    }
                }
                else
                    id.append(String.valueOf(newID), 0, 8);

                StringBuilder productName = new StringBuilder();
                if (args[1].length() < 30) {
                    productName.append(args[1]);
                    while (productName.length() != 30) {
                        productName.append(" ");
                    }
                }
                else
                    productName.append(args[1], 0, 30);


                StringBuilder prise = new StringBuilder();
                if (args[2].length() < 8) {
                    prise.append(args[2]);
                    while (prise.length() != 8) {
                        prise.append(" ");
                    }
                }
                else
                    prise.append(args[2], 0, 8);

                StringBuilder quantity = new StringBuilder();
                if (args[3].length() < 4) {
                    quantity.append(args[3]);
                    while (quantity.length() != 4) {
                        quantity.append(" ");
                    }
                }
                else
                    quantity.append(args[3], 0, 4);

                StringBuilder newProduct = new StringBuilder();
                newProduct.append(newID).append(productName).append(prise).append(quantity);
                products.add(newProduct.toString());

                FileWriter fileWriter = new FileWriter(file);
                for (String product : products) {
                    fileWriter.write(product);
                    fileWriter.write('\n');
                }
                reader.close();
                fileReader.close();
                fileWriter.close();
            }
        }
    }
}

package org.example.advanced.product;

import java.util.HashMap;

public class PriceList {

    HashMap<String, Double> priceList = new HashMap<>();

     public void addItem(Product product) {
        priceList.put(product.getItem(), product.getPrice());
     }

     public HashMap<String, Double> getPriceList() {
         return priceList;
     }

     public void printPriceList() {
         System.out.println("Price list: "+ priceList);
     }


     public Double getPriceByItem(String item) {

         Double price = priceList.get(item);
        if (price != null) {
            System.out.println("The item is found: " + item+ ", " + "price is: " + price);
        } else {
            System.out.println("The item is not found");
        }
        return price;
     }

//     public void changePrice(String item, double newPrice) {
//
//         if (priceList.get(item) == null) {
//             System.out.println("Item is not found");
//         } else {
//             priceList.put(item, newPrice);
//     }


    public static void main(String[] args) {

         HashMap<String, Double> priceList = new HashMap<>();

         PriceList priceList1 = new PriceList();

         // Create Product objects
        Product apple = new Product("Apple", 4.00);
        Product orange = new Product("Orange", 3.25);
        Product banana = new Product("Banana", 3.50);
        Product plum = new Product("Plum", 5.25);

        //Add product items to the priceList
        priceList.put(apple.getItem(), apple.getPrice());
        priceList.put(orange.getItem(), orange.getPrice());
        priceList1.addItem(banana);
        priceList1.addItem(plum);


        System.out.println("Price List: " + priceList);
        priceList1.printPriceList();

        priceList1.getPriceByItem(plum.getItem());
//        priceList1.changePrice(plum.getItem(), 10.00);
        priceList.put("Apple", 10.50);
        System.out.println("Price List: " + priceList);


    }



}

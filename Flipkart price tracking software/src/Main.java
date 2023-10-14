import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;

public class Main {

    private static final String URL = "https://www.flipkart.com/asus-vivobook-15-core-i5-11th-gen-1135g7-16-gb-512-gb-ssd-windows-11-home-x515ea-ej542ws-thin-light-laptop/p/itm25e841aadb777?pid=COMGZ3MYRYGBHCAV&lid=LSTCOMGZ3MYRYGBHCAVP0RKKF&marketplace=FLIPKART&q=asus+laptop&store=6bo%2Fb5g&spotlightTagId=BestsellerId_6bo%2Fb5g&srno=s_1_4&otracker=AS_QueryStore_OrganicAutoSuggest_1_4_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_4_na_na_na&fm=search-autosuggest&iid=bfc6a295-91ac-449c-921b-9b6c422c614d.COMGZ3MYRYGBHCAV.SEARCH&ppt=sp&ppn=sp&ssid=bnslvlya1c0000001697281347368&qH=cda2435f700c2043";
    private static final double PRICE = 60000.0;
    static String productName;
    static double currentPrice;

    public static void main(String[] args) throws IOException{

        Document document = Jsoup.connect(URL).timeout(6000).get();
        Elements title = document.getElementsByClass("B_NuCI");
        productName = title.text().trim();
        Elements priceTag = document.getElementsByClass("_30jeq3 _16Jk6d");
        currentPrice = Double.parseDouble(priceTag.text().replaceAll("[^0-9]",""));

        if(currentPrice<=PRICE){
            System.out.println("Price of " + productName + " is now drop to Rs " + currentPrice);
            System.out.println("Go and buy now Mr.Asif");
            sendNotification();
        }
        else{
            System.out.println("Wait sir, price is not in your budget...");
        }
    }

    public static void sendNotification() {

        String message = "Price of " + productName + " is now drop to Rs " + currentPrice;

        String title = "Flipkart Spider";

        // The type of message (information, warning, error, etc.)
        int messageType = JOptionPane.INFORMATION_MESSAGE;

        // Show the pop-up message
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
}

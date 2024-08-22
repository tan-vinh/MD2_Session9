package ra.entity;

import ra.IShop;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop {
    private String productId;
    private String productName;
    private float price;
    private String title;
    private int catalogId;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float price, String title, int catalogId, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.catalogId = catalogId;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void inputData(Scanner scanner, List list) {
        System.out.println("Enter product ID: ");
        this.productId = sc.nextLine();
        System.out.println("Enter product name: ");
        this.productName = sc.nextLine();
        System.out.println("Enter product price: ");
        this.price = sc.nextFloat();
        System.out.println("Enter product title: ");
        this.title = sc.nextLine();
        System.out.println("Enter product catalog ID: ");
        this.catalogId = sc.nextInt();
        System.out.println("Enter product status: ");
        this.status = sc.nextBoolean();
    }

    @Override
    public void displayData() {
        System.out.println("Product ID: " + this.productId);
        System.out.println("Product Name: " + this.productName);
        System.out.println("Product Price: " + this.price);
        System.out.println("Product Title: " + this.title);
        System.out.println("Product Catalog ID: " + this.catalogId);
        System.out.println("Product Status: " + this.status);
    }
}

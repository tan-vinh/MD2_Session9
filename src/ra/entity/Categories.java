package ra.entity;

import ra.IShop;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Categories implements IShop {
    Scanner sc = new Scanner(System.in);
    private int catalogId;
    private String catalogName;
    private boolean status;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.status = status;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public <E> void inputData(Scanner scanner, List<E> list) {
        do {
            System.out.print("Nhập mã danh mục: ");
            String id = sc.nextLine();
            if (Pattern.matches("[1-9]{1,100}", id)){
                this.catalogId=Integer.parseInt(id);
                if (!checkId(this.catalogId, (List<Categories>) list)){
                    break;
                }
                System.err.println("ID đã tồn tại");
            }else {
                System.out.println("Phải là số nguyên dương");
            }
        }while (true);
        do {
            System.out.print("Nhập tên danh mục: ");
            String name = sc.nextLine();
            if (!checkName(name, (List<Categories>) list)){
                this.catalogName = name;
                break;
            }
            System.err.println("Tên đã tồn tại");
        }while (true);
        System.out.print("Nhập trạng thái danh mục: ");
        this.status = sc.nextBoolean();
    }

    @Override
    public void displayData() {
        System.out.println("Mã danh mục: " + this.catalogId);
        System.out.println("Tên danh mục: " + this.catalogName);
        System.out.println("Trạng thái danh mục: " + this.status);
    }

    public boolean checkId(int id, List<Categories> categoriesList) {
        for (Categories c : categoriesList) {
            if (c.getCatalogId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean checkName(String name, List<Categories> categoriesList) {
        for (Categories c : categoriesList) {
            if (c.getCatalogName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}

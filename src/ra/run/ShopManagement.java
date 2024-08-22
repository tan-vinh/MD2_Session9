package ra.run;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    public static List<Categories> categories = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("*************************SHOP MANAGEMENT***************\n" +
                    "1. Quản lý danh mục sản phẩm\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Thoát");
            System.out.println("Mời bạn chọn từ 1 đến 3: ");
            int choice = sc.nextInt();
            boolean check = true;

            switch (choice) {
                case 1:
                    do {
                        System.out.println("***************** CATALOG MANAGEMENT**************\n" +
                                "1. Thêm mới danh mục\n" +
                                "2. Hiển thị thông tin các danh mục\n" +
                                "3. Cập nhật tên danh mục theo mã danh mục\n" +
                                "4. Xóa danh mục theo mã danh mục (Danh mục chưa chứa sản phẩm)\n" +
                                "5. Thoát (Quay lại Shop Management)\n");
                        System.out.println("Mời bạn chọn từ 1 đến 5: ");
                        choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                Categories cate = new Categories();
                                int n = sc.nextInt();
                                for (int i = 0; i < n; i++) {
                                    cate.inputData(sc, categories);
                                    categories.add(cate);
                                }
                                break;
                            case 2:
                                for (Categories cat : categories) {
                                    cat.displayData();
                                }
                                break;
                            case 3:
                                int updateID = sc.nextInt();
                                for (Categories cat : categories) {
                                    if (cat.getCatalogId()==updateID){
                                        cat.inputData(sc, categories);
                                    }
                                }
                                break;
                            case 4:
                                int deleteID = sc.nextInt();
                                for (Categories cat : categories) {
                                    if (cat.getCatalogId()==deleteID){
                                        categories.remove(cat);
                                    }
                                }
                                break;
                            case 5:
                                check = false;
                                break;
                        }
                    }while (check);
                    break;
                case 2:
                    do {
                        System.out.println("***************** PRODUCT MANAGEMENT**************\n" +
                                "1. Thêm mới sản phẩm (Khi thêm cho phép chọn danh mục sản phẩm\n" +
                                "mà sản phẩm thuộc về)\n" +
                                "2. Hiển thị thông tin sản phẩm\n" +
                                "3. Cập nhật giá sản phẩm theo mã sản phẩm\n" +
                                "4. Xóa sản phẩm theo mã sản phẩm\n" +
                                "5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần\n" +
                                "6. Sắp xếp sản phẩm theo tên tăng dần\n" +
                                "7. Thống kê số lượng sản phẩm theo danh mục sản phẩm\n" +
                                "8. Tìm kiếm sản phẩm theo tên sản phẩm\n" +
                                "9. Thoát (Quay lại Shop Management)");
                        System.out.println("Mời bạn chọn từ 1 đến 9: ");
                        choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                Product prod = new Product();
                                int n = sc.nextInt();
                                for (int i = 0; i < n; i++) {
                                    prod.inputData(sc, products);;
                                    products.add(prod);
                                }
                                break;
                            case 2:
                                for (Product p : products) {
                                    p.displayData();
                                }
                                break;
                            case 3:
                                String updateID = sc.nextLine();
                                for (Product product : products) {
                                    if (product.getProductId().equals(updateID)){
                                        product.inputData(sc, products);
                                        products.add(product);
                                    }
                                }
                                break;
                            case 4:
                                String deleteID = sc.nextLine();
                                for (Product product : products) {
                                    if (product.getProductId().equals(deleteID)){
                                        products.remove(product);
                                    }
                                }
                                break;
                            case 5:
                                products.sort(Comparator.comparing(Product::getPrice));
                                for (Product product : products) {
                                    product.displayData();
                                }
                                break;
                            case 6:
                                products.sort((emp1, emp2) -> emp2.getProductName().compareTo(emp1.getProductName()));
                                for (Product product : products) {
                                    product.displayData();
                                }
                                break;
                            case 7:
                                System.out.println("Thống kê số lượng sản phẩm theo danh mục:");
                                products.forEach(cat -> {
                                    long count = products.stream().filter(p -> p.getCatalogId() == cat.getCatalogId()).count();
                                    System.out.println("Danh mục ID " + cat.getCatalogId() + ": " + count + " sản phẩm.");
                                });
                                break;
                            case 8:
                                System.out.print("Nhập tên sản phẩm cần tìm kiếm: ");
                                String searchName = sc.nextLine();
                                products.stream().filter(p -> p.getProductName().contains(searchName)).forEach(Product::displayData);
                                break;
                            case 9:
                                check = false;
                                break;
                        }
                    }while (check);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Mời bạn nhập lại.");
            }
        }while (true);
    }
}

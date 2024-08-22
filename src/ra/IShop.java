package ra;

import ra.entity.Categories;

import java.util.List;
import java.util.Scanner;

public interface IShop {
    <E> void inputData(Scanner scanner, List<E> list);
    void displayData();
}

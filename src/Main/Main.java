package Main;

import Manager.ManagerPhone;
import Model.Phone;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerPhone managerPhone = new ManagerPhone();
        try {
            do {
                System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI ----");
                System.out.println("Select the number of function (to continue)");
                System.out.println("1. Watch List");
                System.out.println("2. Add new");
                System.out.println("3. Delete");
                System.out.println("4. Search");
                System.out.println("5. Exit");
                System.out.println("Select function");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 5) {
                    System.out.println();
                    System.err.println("Selection does not exist, please re-enter!!!");
                }
                switch (choice) {
                    case 1:
                        managerPhone.displayAllPhoneNumber();
                        break;
                    case 2:
                        managerPhone.addPhone();
                        managerPhone.writeFile(managerPhone.getContactList(), ManagerPhone.PATH_NAME);
                        break;
                    case 3:
                        managerPhone.deleteContact();
                        break;
                    case 4:
                        System.out.println("Search by name or id");
                        managerPhone.searchPhoneByNameOrId();

                        break;
                    case 5:
                        System.exit(5);
                }
            } while (true);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

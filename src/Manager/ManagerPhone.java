package Manager;

import Model.AuthPhone;
import Model.CellPhone;
import Model.Phone;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerPhone {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Phone> listPhone;
    public static String PATH_NAME = "src/data/mobiles.csv";

    public ManagerPhone() {
        if (new File(PATH_NAME).length() == 0) {
            this.listPhone = new ArrayList<>();
        }
        else {
            this.listPhone = readFile(PATH_NAME);
        }
    }

    public ArrayList<Phone> getContactList() {
        return listPhone;
    }

    public Phone createPhone() {
        String phoneName = "";
        double price = 0;
        int count = 0;
        String vender = "";
        String timeMaintain = "0";
        String region = "";
        String status = "";

        while (phoneName ==""){
            System.out.println("Enter phone name");
            phoneName = scanner.nextLine();
        }

        while (price==0 || price<0){
            System.out.println("Enter price");
            price = scanner.nextDouble();
        }

        while (count ==0 || count<0){
            System.out.println("Enter amount");
            count = scanner.nextInt();
        }

        while (vender.equals("")){
            System.out.println("Enter vender: ");
            vender = scanner.nextLine();
        }

        System.out.println("Authphone (y), cell phone (n): ");
        String authphone = scanner.nextLine();

        if (authphone.equals("y")){
            while (Integer.parseInt(timeMaintain)>730 || Integer.parseInt(timeMaintain)<=0){
                System.out.println("Time maintain: ");
                timeMaintain = scanner.nextLine();
            }

            while (!region.equals("Toan Quoc") && !region.equals("Quoc Te")){
                System.out.println("Region: ");
                region = scanner.nextLine();
            }

            AuthPhone authPhone = new AuthPhone(0,phoneName,price,count,vender,Integer.parseInt(timeMaintain),region);
            return authPhone;

        }
        else{
            while (region == "" || region.equals("Viet Nam") ){
                System.out.println("Region: ");
                region = scanner.nextLine();
            }

            while (!status.equals("Da sua chua") && !region.equals("Khong sua chua")){
                System.out.println("Status: ");
                status = scanner.nextLine();
            }

            CellPhone cellPhone = new CellPhone(0,phoneName,price,count,vender,region,status);
            return cellPhone;
        }

    }

    public void addPhone(){
        Phone phone = createPhone();
        if (phone != null) {
            listPhone.add(phone);
            writeFile(listPhone, PATH_NAME);
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }
    }

    public void deleteContact() {
        int count = 0;
        System.out.println("Enter the phone id");
        int phone = scanner.nextInt();
        for (int i = 0; i < listPhone.size(); i++) {
            if (listPhone.get(i).getId() == phone){
                System.out.println("Are you absolutely sure?");
                System.out.println("1. I understand the consequences, delete this phone number");
                System.out.println("2. Cancel");
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Deleted " + listPhone.get(i));
                        listPhone.remove(i);
                        writeFile(listPhone, PATH_NAME);
                        count++;
                        break;
                    case 2:
                        count++;
                        break;
                }
            }
        }
        if (count == 0){
            System.err.println("Invalid number of phone!!");
        }
    }

    public void searchPhoneByNameOrId() {
        System.out.println("Enter name or id");
        String name = scanner.nextLine();
        System.out.println("You are search: " + name);
        int count = 0;
        for (int i = 0; i < listPhone.size(); i++) {
            if (listPhone.get(i).getName().indexOf(name)!=-1){
                System.out.println(listPhone.get(i));
                count++;
            }
            else{
                try{
                    if (listPhone.get(i).getId() == Integer.parseInt(name)){
                        System.out.println(listPhone.get(i));
                        count++;
                    }
                }
                catch (Exception e){

                }
            }
        }
        if (count == 0){
            System.err.println("Invalid name of phone!!");
        }
    }

    public void displayAllPhoneNumber() {
        for (Phone phone: listPhone) {
            System.out.println(phone);
        }
    }

    public void writeFile(ArrayList<Phone> listPhone, String path) {
            try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            int num = 1;
            for (Phone phone : listPhone) {
                if (phone instanceof CellPhone){
                    bufferedWriter.write(num+","+phone.getName()+ ","+phone.getPrice()+ "," +phone.getAmount()+ ","+phone.getVendor()+ ","+((CellPhone) phone).getRegion()+ ","+((CellPhone) phone).getStatus()+"\n");
                }
                else{
                    bufferedWriter.write(num+","+phone.getName()+ ","+phone.getPrice()+ "," +phone.getAmount()+ ","+phone.getVendor()+ ","+String.valueOf(((AuthPhone) phone).getTimeMaintain())+ ","+((AuthPhone) phone).getRegion()+"\n");
                }

                num++;

            }

            bufferedWriter.close();
            System.out.println("Write file successfully !");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Phone> readFile(String path) {
        ArrayList<Phone> phone = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            System.out.println("Read file");
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                System.out.println();

                if (strings[6].equals("Da sua chua") || strings[6].equals("Chua sua chua")){
                    phone.add(new CellPhone(Integer.parseInt(strings[0]),strings[1],Double.parseDouble(strings[2]),Integer.parseInt(strings[3]),strings[4],strings[5],strings[6]));
                }
                else{
                    phone.add(new AuthPhone(Integer.parseInt(strings[0]),strings[1],Double.parseDouble(strings[2]),Integer.parseInt(strings[3]),strings[4],Integer.parseInt(strings[5]),strings[6]));
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return phone;
    }
}

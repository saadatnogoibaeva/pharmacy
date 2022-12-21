package Aibolit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Pharmacy> medicaments = new ArrayList<>();
    public static void main(String[] args) {





        File file = new File("src/medicaments.txt");
        int Length = 0;
        try {

            Scanner sc = new Scanner(file);
            Length = Integer.parseInt(sc.nextLine());
            //count = sc.nextInt();

            for(int i = 0;i < Length;i++){
                Pharmacy pharmacy = new Pharmacy();

                pharmacy.setName(sc.nextLine());
                pharmacy.setDescription(sc.nextLine());
                String in = sc.nextLine();
                pharmacy.setAmount(Integer.parseInt(in));
                String d = sc.nextLine();
                pharmacy.setPrice(Double.parseDouble(d));
                pharmacy.setname(sc.nextLine());
                pharmacy.setAddress(sc.nextLine());
                pharmacy.setTown(sc.nextLine());
                pharmacy.setNumber(sc.nextLine());

                medicaments.add(i, pharmacy);


            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Information(medicaments);
        Menu(medicaments);

    }



    public static void Menu(ArrayList<Pharmacy> medicaments){

        Scanner sc = new Scanner(System.in);
        System.out.println("\nПожалуйста выберите номер меню, для выхода нажмите цифру 7:");
        System.out.println("(1) Продажа лекарств");
        System.out.println("(2) Пополнить запасы лекарств");
        System.out.println("(3) Изменить информацию о поставщике ");
        System.out.println("(4) Отображение информации о лекарствах ");
        System.out.println("(5) Income ");

        System.out.println("(6) Справка о программе");
        System.out.println("(7) Выйти ");
        do {
            System.out.print("");
            String choose = sc.nextLine();
            switch (choose) {
                case "1" -> {
                    MedicamentSale(medicaments);
                    Menu(medicaments);
                }
                case "2" -> {
                    ReplenishMedicament(medicaments);
                    Menu(medicaments);
                }
                case "3" -> {
                    ChangeSupplierInformation(medicaments);
                    Menu(medicaments);
                }
                case "4" -> {
                    TheMedicamentInformation(medicaments);
                    Menu(medicaments);
                }
                case "5" -> {
                    DisplayIncome(medicaments);
                    Menu(medicaments);
                }
                case "6" -> {
                    ProgramInfo();
                    Menu(medicaments);
                }
                case "7" -> System.exit(0);
                default -> System.out.println("Reload the program pls");
            }
            break;
        } while (true);
    }
    static ArrayList<Pharmacy> soldPharmacy = new ArrayList<>();

    private static void ProgramInfo() {
        System.out.println("Это онлайн аптека)");
    }

    private static void DisplayIncome(ArrayList<Pharmacy> medicaments) {

        System.out.println("""
                (1)Посмотреть доход:
                (2)Посмотреть суммарную продажу для определенного лекарства:
                (3)Посмотреть суммарную продажу для всех лекарств
                """);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> forSpecificDate();
            case "2" -> forSpecificProduct();
            case "3" -> forAll();
        }
    }

    private static void forAll() {
        for (Pharmacy pharmacy : soldPharmacy) {
            System.out.println(pharmacy.toString());
        }
    }

    private static void forSpecificProduct() {
        Scanner scanner = new Scanner(System.in);

        for (Pharmacy medicament : medicaments) {
            System.out.println(medicament.getName());
        }
        System.out.println("Enter medicament name: ");
        String str = scanner.nextLine();
        boolean b = true;
        for (Pharmacy pharmacy : soldPharmacy) {
            if (pharmacy.getName().equals(str)) {
                System.out.println(pharmacy);
                b = false;
            }

        }
        if(b){

                System.out.println("Такой препарат не продан!, repeat");
                forSpecificProduct();

        }

    }
    static float sum = 0;

    private static void forSpecificDate() {
        System.out.println(sum);

    }

    private static void TheMedicamentInformation(ArrayList<Pharmacy> medicaments) {
        System.out.println("Выберите название лекарства для получения информации:");
        for (Pharmacy medicament : medicaments) {
            System.out.println(medicament.getName());
        }
        Scanner scanner = new Scanner(System.in);
        String nameDrug = scanner.nextLine();
        for(Pharmacy name: medicaments){
            if(name.getName().equals(nameDrug)) {

                System.out.println(name.getName());
                System.out.println(name.getDescription());
                System.out.println(name.getAmount());
                System.out.println(name.getPrice());
                System.out.println(name.getname());
                System.out.println(name.getAddress());
                System.out.println(name.getTown());
                System.out.println(name.getNumber());

            }
        }
    }

    private static void ChangeSupplierInformation(ArrayList<Pharmacy> medicaments) {
        System.out.println("Выберите имя поставщика для изменения:");
        for (Pharmacy pharmacy : medicaments) {
            System.out.println(pharmacy.getname());
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for(Pharmacy name: medicaments){

            if(name.getSupplie().getname().equals(input)){
                System.out.println("Напишите новую информацию про поставщика:");
                System.out.println("""
                        •\tВведите новое имя для поставщика:
                        •\tВведите новый адрес поставщика
                        •\tВведите город для поставщика
                        •\tВведите номер телефона поставщика
                        """);
                String nameSupp = scanner.nextLine();
                String addressSupp = scanner.nextLine();
                String townSupp = scanner.nextLine();
                String numberSupp = scanner.nextLine();
                name.setname(nameSupp);
                name.setAddress(addressSupp);
                name.setTown(townSupp);
                name.setNumber(numberSupp);
                System.out.println("Успешно Изменено!");

            }

        }
    }

    private static void ReplenishMedicament(ArrayList<Pharmacy> medicaments) {
        System.out.println("Выберите название препарата для пополнения запаса:");
        for (Pharmacy pharmacy : medicaments) {
            System.out.println(pharmacy.getName());
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for(Pharmacy name: medicaments){
            if(name.getName().equals(input)){
                System.out.println("Напишите количество для пополнения запаса:");
                int countForsale = scanner.nextInt();
                name.setAmount(name.getAmount()+countForsale);
                System.out.println("Успешно пополнено!");

            }

        }
    }


    private static void Information(ArrayList<Pharmacy> medicaments) {
        System.out.println("The information:");
        for (Pharmacy pharmacy : medicaments) {
            System.out.println("Medicament name: " + pharmacy.getName());
            System.out.println("Medicament description: " + pharmacy.getDescription());
            System.out.println("Medicament amount: " + pharmacy.getAmount());
            System.out.println("Medicament price: " + pharmacy.getPrice());
            System.out.println("Provider name: " + pharmacy.getname());
            System.out.println("Provider address: " + pharmacy.getAddress());
            System.out.println("Town: " + pharmacy.getTown());
            System.out.println("Number: " + pharmacy.getNumber() + "\n");
        }
    }

    private static void MedicamentSale(ArrayList<Pharmacy> medicaments) {
        System.out.println("Выберите название препарата для продажи: ");
        for (Pharmacy pharmacy : medicaments) {
            System.out.println(pharmacy.getName());
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for(Pharmacy name: medicaments){
            if(name.getName().equals(input)){
                System.out.println("Напишите количество для продажи:");
                int countForsale = scanner.nextInt();
                if(countForsale > name.getAmount()){
                    System.out.println("данный препарат отсутствует и необходимо пополнение запаса.");
                }
                else {
                    name.setAmount(name.getAmount() - countForsale);
                    System.out.println("Продано успешно!");
                    soldPharmacy.add(name);
                    sum += name.getPrice() * countForsale;

                }

            }

        }


    }

}


package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rent {
    public final List<Order> orderList;

    public Rent() {
        orderList = new ArrayList<>();
    }

    public void CreateOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ім'я:");
        String Name = scanner.nextLine();

        System.out.println("Виберіть вид техніки:");
        ShowTypesEquipment();
        int TypesEquipmentIndex = scanner.nextInt();
        Equipment TypesEquipment = Equipment.values()[TypesEquipmentIndex - 1];

        double PriceHour = GetPriceHour(TypesEquipment);

        System.out.println("Виберіть тип оренди:");
        System.out.println("1. Подобова");
        System.out.println("2. Довгострокова");
        int TypesRentIndex = scanner.nextInt();
        boolean DailyRent = (TypesRentIndex == 1);

        int Duration;
        if (DailyRent) {
            Duration = 24; // Подобова оренда на 24 години
        } else {
            System.out.println("Введіть тривалість (кількість діб):");
            Duration = scanner.nextInt() * 24;
        }

        System.out.println("Чи є постійний клієнт? (Так/Ні)");
        boolean RegularCustomer = scanner.next().equalsIgnoreCase("Так");

        Order order = new Order(Name, TypesEquipment, Duration, PriceHour, RegularCustomer);
        orderList.add(order);
        System.out.println("Замовлення створено успішно!");
    }

    public void ViewOrder() {
        if (orderList.isEmpty()) {
            System.out.println("У вас немає жодного замовлення.");
        } else {
            System.out.println("Список замовлень:");
            for (Order order : orderList) {
                System.out.println(order);
            }
        }
    }

    private void ShowTypesEquipment() {
        Equipment[] TypesEquipment = Equipment.values();
        for (int i = 0; i < TypesEquipment.length; i++) {
            System.out.println((i + 1) + ". " + TypesEquipment[i]);
        }
    }

    double GetPriceHour(Equipment TypesEquipment) {
        double PriceHour;
        switch (TypesEquipment) {
            case Кран:
                PriceHour = 100.0;
                break;
            case Бульдозер:
                PriceHour = 80.0;
                break;
            case Екскаватор:
                PriceHour = 90.0;
                break;
            default:
                PriceHour = 0.0;
                break;
        }
        return PriceHour;
    }

    public static void main(String[] args) {
        Rent rent = new Rent();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Створити замовлення");
            System.out.println("2. Переглянути замовлення");
            System.out.println("3. Вийти");

            int Choice = scanner.nextInt();

            switch (Choice) {
                case 1:
                    rent.CreateOrder();
                    break;
                case 2:
                    rent.ViewOrder();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
                    break;
            }
        }
    }
}

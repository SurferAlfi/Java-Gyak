/*e
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.secondhanddbcars;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kovacs.mark
 */
public class SecondHandDbCars {

    public static void main(String[] args) {
        CarManager cm = new CarManager();
        Scanner scanner = new Scanner(System.in);

9o        String input = null;
        do {
            
            input = scanner.next();

            switch (input) {
                case "a":
                    List<CarQuery> carQueries = cm.getAll();
                    for (CarQuery c : carQueries) {
                        System.out.println(c.toString());
                    }
                    break;
                case "b":
                    System.out.println("Legdrágább autó:");
                    System.out.println(cm.maxPrice().toString());
                    break;
                case "c":
                    cm.insertCar(new Car("ASD-323", "Fabia",
                    500000, 2005, 11));
                    break;
                case "d":
                    updateCarPrice(scanner, cm);
                    break;
                case "e":
                    deleteCar(scanner, cm);
                    break;
            }
        } while (input == null || !input.equals("q"));

        /*List<Car> cars = new ArrayList<>();
        cars = cm.getAllCars();

        for (Car c : cars) {
            System.out.println(c.toString());
        }

        List<CarBrand> carBrands = new ArrayList<>();
        carBrands = cm.getAllCarBrands();
        for (CarBrand cb : carBrands) {
            System.out.println(cb.toString());
        }*/ 
    }

    private static void deleteCar(Scanner scanner,
            CarManager manager) {
        System.out.println("--- Autó törlés ---");
        System.out.println("Rendszám:");
        String plateNumber = scanner.next();

        boolean result = manager.deleteCar(plateNumber);

        if (result) {
            System.out.println("Törlés sikeresen megtörtént!");
        } else {
            System.out.println("Törlés sikertelen!");
        }
    }

    private static void updateCarPrice(Scanner scanner,
            CarManager manager) {
        System.out.println("--- Árcsökkentés ---");
        System.out.println("Adja meg a rendszámot:");
        String plateNumber = scanner.next();
        System.out.println("Adja meg az új árat:");
        int discount = scanner.nextInt();
        boolean result = manager.updateCarPrice(plateNumber,
                discount);
        if (result) {
            System.out.println("Sikeres volt az ár módosítása!");
        } else {
            System.out.println("Az ár módosítása sikertelen!");
        }
    }
    
    private static void printMenu() {
        System.out.println("-----------------");
        System.out.println("--- Válasszon ---");
        System.out.println("a - Autók -------");
        System.out.println("b - Legdrágább --");
        System.out.println("c - Hozzáadás ---");
        System.out.println("d - Árcsökkentés ");
        System.out.println("e - Törlés ----- ");
        System.out.println("-----------------");
        System.out.println("q - Kilépés -----");
        System.out.println("-----------------");
    }
}

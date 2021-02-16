package Application;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Enum.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    private static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");


    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);



        System.out.println("Enter Cliente data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date data = SDF.parse(sc.next());
        sc.nextLine();
        System.out.print("Status: ");
        String status = sc.nextLine();


        Date moments = new Date();


        Order order = new Order(moments, OrderStatus.valueOf(status), new Client(name, email, data));


        System.out.print("How many items to this order? ");
        int countOrder = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= countOrder; i++){

            System.out.println("Enter #" + i + " item data:");

            System.out.print("Product name: ");
            String ProductName = sc.nextLine();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            OrderItem orderItem = new OrderItem(quantity, price, new Product(ProductName, price));

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println(order);


        sc.close();

    }

}

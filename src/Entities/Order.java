package Entities;

import Enum.OrderStatus;
import Entities.Client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private SimpleDateFormat SDF_MOMENT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    private Date moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> items = new ArrayList<>();


    public Order(){
    }
    public Order(Date moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public void setMoment(Date moment) throws ParseException {
        this.moment = moment;
    }
    public Date getMoment(){
        return moment;
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }
    public OrderStatus getStatus(){
        return status;
    }

    public List<OrderItem> getItem(){
        return items;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }
    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total(){
        double value = 0.0;

        for(OrderItem c: items){
            value += c.subTotal();
        }
        return value;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY: \n");
        sb.append("Order moment: ");
        sb.append(SDF_MOMENT.format(getMoment()) + "\n");
        sb.append("Client: ");
        sb.append(client.getName() + " ");
        sb.append("(" + SDF.format(client.getBirthDate()) + ") - " );
        sb.append(client.getEmail() +"\n");
        sb.append("Order items: \n");

        for (OrderItem c: items){
            sb.append(c.getProduct().getName() + ", ");
            sb.append(c.getProduct().getPrice() + ", ");
            sb.append("Quantity: ");
            sb.append(c.getQuantity() + ", ");
            sb.append("Subtotal: ");
            sb.append("$" + String.format("%.2f", c.subTotal())  + "\n");

        }
        sb.append("Total price: ");
        sb.append("$" + String.format("%.2f", total()));

        return sb.toString();
    }


}

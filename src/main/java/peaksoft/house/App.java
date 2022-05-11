package peaksoft.house;

import peaksoft.house.enums.OrderStatus;
import peaksoft.house.models.Address;
import peaksoft.house.models.Customer;
import peaksoft.house.models.Order;
import peaksoft.house.models.Supplier;
import peaksoft.house.services.CustomerService;
import peaksoft.house.services.OrderService;
import peaksoft.house.services.SupplierService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static peaksoft.house.enums.OrderStatus.REQUEST;
import static peaksoft.house.enums.SupplierStatus.FREE;

public class App {
    public static void main( String[] args ) {
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();
        SupplierService  supplierService = new SupplierService();

//        customerService.save(new Customer("Chynara", 123456789L));
//        customerService.save(new Customer("Sultan", 130520090L));
//        customerService.save(new Customer("Alymbek", 020320121L));
//        customerService.save(new Customer("Malika", 230920155L));
//        customerService.save(new Customer("Sulaiman", 181220198L));
//
//        customerService.makeAnOrder(1L, new Order(LocalDateTime.now(), BigDecimal.valueOf(4300), OrderStatus.DELIVERED));
//
//        customerService.cancelOrder(1L, 1L);
//
//        customerService.deleteById(1L);
//
//        customerService.update(2L, new Customer("Darika", 104042007L));
//
//        customerService.findAll().forEach(System.out::println);

        //customerService.findAllOrders(1L, OrderStatus.DELIVERED);
//        System.out.println( "Hello World!" );

//        orderService.save(new Order(LocalDateTime.now(),BigDecimal.valueOf(5500),OrderStatus.DELIVERED));
//        System.out.println(orderService.findById(2L));

        Address address = new Address("Kyrgyzstan", "Osh", "Osh", "Alieva, 10");
        Order order = new Order(LocalDateTime.now(), BigDecimal.valueOf(4000), OrderStatus.REQUEST);
        Supplier supplier = new Supplier("Almaz", 120619829, FREE, List.of(order));

        //Customer customer = new Customer("Kunzaada",23112982L, List.of(order), address);
        //Supplier supplier = new Supplier("Aichurok", 48373920L, FREE, List.of(order));
        Customer customer1 = new Customer("Tazagul", 83783783L, List.of(order), address);
        Order order1 = new Order(LocalDateTime.now(), BigDecimal.valueOf(1500), REQUEST, new Address("Kyrgyzstan", "Chui", "Bishkek","Ahunbaeva,69"),
                new Address("Kazakhstan","Astana", "Astana","Kurmanbekova,77"), customer1, supplier);
        customerService.save(customer1);
        supplierService.save(supplier);
        orderService.save(order1);
    }
}

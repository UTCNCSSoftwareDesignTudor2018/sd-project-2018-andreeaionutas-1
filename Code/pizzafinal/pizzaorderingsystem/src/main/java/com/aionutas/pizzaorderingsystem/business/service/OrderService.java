package com.aionutas.pizzaorderingsystem.service;


import com.aionutas.pizzaorderingsystem.model.entity.Drink;
import com.aionutas.pizzaorderingsystem.model.entity.Order;
import com.aionutas.pizzaorderingsystem.model.entity.Pizza;
import com.aionutas.pizzaorderingsystem.model.repository.OrderRepo;
import com.aionutas.pizzaorderingsystem.model.utils.OrderStatus;

import com.aionutas.pizzaorderingsystem.model.utils.PaymentStrategy;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import java.util.Observable;

import java.util.*;

@EnableMongoRepositories(basePackageClasses = OrderRepo.class)
@Configuration
public class OrderService extends Observable {

    @Autowired
    OrderRepo orderRepo;
    @Autowired
    PizzaService pizzaService;
    @Autowired
    DrinkService drinkService;

    public Order addOrder(Order order) throws JSONException {

        List<Pizza> pizzas = new ArrayList<>();
        Long price = Long.valueOf(0);
        for (Pizza pizza : order.getPizzas()) {
            if ((pizza.getName() != null && !pizza.getName().isEmpty())) {
                pizza = pizzaService.getByName(pizza.getName());
                price = price + pizza.getPrice();
                pizzas.add(pizza);
            } else {
                System.out.println("Could not find pizza");
            }
        }


        List<Drink> drinks = new ArrayList<>();
        if (!order.getDrinks().isEmpty()) {
            for (Drink drink : order.getDrinks()) {
                if (drink.getName() != null && !drink.getName().isEmpty() && drinkService.getByName(drink.getName()) != null) {
                    drink = drinkService.getByName(drink.getName());
                    price = price + drink.getPrice();
                    drinks.add(drink);
                } else {
                    System.out.println("Could not find drink");
                }
            }
        }
        if (!drinks.isEmpty()) {
            order.setDrinks(drinks);
        }
        order.setPizzas(pizzas);
        order.setTotal(price);
        order.setOrderStatus(OrderStatus.PROCESSED);
        Order order1 = orderRepo.save(order);
        setChanged();
        return order1;
    }

    public Optional<Order> getById(Long id) {
        return orderRepo.findById(id);
    }

    public void deleteOrder(Long id) {
        Order deleteOrder = orderRepo.findById(id).get();

        if (deleteOrder.getId() != null) {
            orderRepo.delete(deleteOrder);
        } else {
            System.out.println("Could not delete order!");
        }

    }

    public List<Order> findAllOrders() {
        return orderRepo.findAll();
    }

    public Order updateOrder(Order order) {
        return orderRepo.save(order);
    }

    public String pay(PaymentStrategy paymentMethod, Long orderId){
        Long amount = calculateTotal(orderId);
       return paymentMethod.pay(amount);
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    private Long calculateTotal(Long orderId) {
        Order order = orderRepo.findById(orderId).get();
        if(!Objects.isNull(order))
            return order.getTotal();
        return Long.valueOf(0);
    }



}

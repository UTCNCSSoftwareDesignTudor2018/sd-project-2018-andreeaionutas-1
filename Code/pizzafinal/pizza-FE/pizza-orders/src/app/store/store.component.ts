import {Component, OnInit} from '@angular/core';
import {MatSnackBar} from "@angular/material";
import {AppService} from "../app.service";

@Component({
    selector: 'app-store',
    templateUrl: './store.component.html',
    styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {

    ingredientName;
    ingredientPrice;
    toppingName;
    toppingPrice;
    drinkName;
    drinkPrice;
    pizzaName;
    pizzaIngredients;
    pizzaToppings;


    constructor(private service: AppService, public snackBar: MatSnackBar) {
    }

    ngOnInit() {
        this.ingredientName = '';
        this.ingredientPrice = '';
        this.toppingName = '';
        this.toppingPrice = '';
        this.drinkName = '';
        this.drinkPrice = '';
        this.pizzaName = '';
        this.pizzaIngredients = '';
        this.pizzaToppings = '';

    }

    addIngredient() {
        let obj = {};
        obj['name'] = this.ingredientName;
        obj['price'] = this.ingredientPrice;
        this.service.addIngredient(JSON.stringify(obj))
            .subscribe(res => {
                    this.openSnackBar('Ingredient successfully addded!', '');
                },
                err => {
                    console.log(err);
                })

    }

    addTopping() {
        let obj = {};
        obj['name'] = this.toppingName;
        obj['price'] = this.toppingPrice;
        this.service.addTopping(JSON.stringify(obj))
            .subscribe(res => {
                    this.openSnackBar('Topping successfully addded!', '')
                },
                err => {
                    console.log(err);
                })
    }

    addDrink() {
        let obj = {};
        obj['name'] = this.drinkName;
        obj['price'] = this.drinkPrice;
        this.service.addDrink(JSON.stringify(obj))
            .subscribe(res => {
                    this.openSnackBar('Drink successfully addded!', '');
                },
                err => {
                    console.log(err);
                })
    }

    addPizza() {
        let obj = {};
        obj['name'] = this.pizzaName;
        obj['ingredients'] = [];
        obj['toppings'] = [];
        this.pizzaIngredients.split(", ").forEach(i => {
            obj['ingredients'].push({ "name": i });
        });
        this.pizzaToppings.split(", ").forEach(t => {
            obj['toppings'].push({ "name": t });
        });

        this.service.addPizza(JSON.stringify(obj))
            .subscribe(res => {
                    this.openSnackBar('Pizza successfully addded!', '')
                },
                err => {
                    console.log(err);
                })
    }

    openSnackBar(message: string, action: string) {
        this.snackBar.open(message, action, {
            duration: 2000,
            direction: 'ltr',
            horizontalPosition: 'end',
            verticalPosition: 'bottom'
        });
    }
}

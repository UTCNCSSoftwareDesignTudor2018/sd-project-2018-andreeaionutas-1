import {Component, OnInit} from '@angular/core';
import {AppService} from "../app.service";

@Component({
    selector: 'app-client',
    templateUrl: './client.component.html',
    styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {
    flag = 0 ;
    address;
    pizzas = [];
    drinks =[];

    constructor(private appService: AppService) {
    }

    ngOnInit() {
        this.flag=0;
        this.address = "";
        this.pizzas = [];
        this.drinks = [];

        this.appService.getPizzas()
            .subscribe(res => {
                    this.pizzas = res;
                    this.pizzas.forEach(pizza => {
                        pizza['checked']=false;
                    });
                },
                err => {
                    console.log("Could not load pizzas")
                });

        this.appService.getDrinks()
            .subscribe(res => {
                    this.drinks = res;
                    this.drinks.forEach(drink => {
                        drink['checked']=false;
                    });
                },
                err => {
                    console.log("Could not load drinks")
                });
    }


    addPizza() {
        this.flag = 1;
        let obj = { };
        obj['address'] = this.address;
        obj['pizzas'] = this.pizzas.filter(opt => opt.checked);
        obj['drinks'] = this.drinks.filter(opt => opt.checked);

        this.appService.orderPizza(JSON.stringify(obj))
            .subscribe(res => {
                    console.log(res);
                },
                err => {
                    console.log("Could not order pizza")
                });
    }



}

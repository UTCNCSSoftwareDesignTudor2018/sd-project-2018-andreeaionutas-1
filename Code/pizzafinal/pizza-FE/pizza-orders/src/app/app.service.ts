import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/internal/Observable';
import {map, filter, catchError, mergeMap} from 'rxjs/operators';
import {Headers, RequestOptions} from "@angular/http";

@Injectable()

export class AppService {

    private loginPath = 'http://localhost:8082/login/login';
    private addIngredientPath = 'http://localhost:8082/ingredients/addIngredient';
    private addToppingPath = 'http://localhost:8082/toppings/addTopping';
    private addDrinkPath = 'http://localhost:8082/drinks/addDrink';
    private addPizzaPath = 'http://localhost:8082/pizzas/addPizza';
    private getPizzasPath = 'http://localhost:8082/pizzas/pizzas';
    private getDrinksPath = 'http://localhost:8082/drinks/drinks';
    private orderPizzaPath = 'http://localhost:8082/orders/addOrder';

    constructor(private http: HttpClient) {
    }

    login(username, password): Observable<any> {
        this.loginPath += "?username=" + username + "&password=" + password;

        return this.http.get(this.loginPath, {responseType: 'text'})
            .pipe(
                map((res) => {
                    console.log("be response", res);
                    return res;
                })
            )
    }

    addIngredient(ingredient): Observable<any> {
        console.log(ingredient);
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };

        return this.http.post(this.addIngredientPath, ingredient, httpOptions)
            .pipe(
                map((res) => {
                    console.log("add ingredient response", res);
                    return res;
                })
            )
    }

    addTopping(topping): Observable<any> {
        console.log(topping);
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };

        return this.http.post(this.addToppingPath, topping, httpOptions)
            .pipe(
                map((res) => {
                    console.log("add topping response", res);
                    return res;
                })
            )
    }

    addDrink(drink): Observable<any> {
        console.log(drink);
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };

        return this.http.post(this.addDrinkPath, drink, httpOptions)
            .pipe(
                map((res) => {
                    console.log("add drink response", res);
                    return res;
                })
            )
    }

    addPizza(pizza): Observable<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };

        return this.http.post(this.addPizzaPath, pizza, httpOptions)
            .pipe(
                map((res) => {
                    console.log("add pizza response", res);
                    return res;
                })
            )
    }

    getPizzas(): Observable<any> {
        return this.http.get(this.getPizzasPath)
            .pipe(
                map((res) => {
                    console.log("get pizzza response", res);
                    return res;
                })
            )
    }

    getDrinks(): Observable<any> {
        return this.http.get(this.getDrinksPath)
            .pipe(
                map((res) => {
                    console.log("get drinks response", res);
                    return res;
                })
            )
    }

    orderPizza(pizzaOrder): Observable<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };
        return this.http.post(this.orderPizzaPath, pizzaOrder, httpOptions)
            .pipe(
                map((res) => {
                    console.log("get pizza order response", res);
                    return res;
                })
            )
    }
}


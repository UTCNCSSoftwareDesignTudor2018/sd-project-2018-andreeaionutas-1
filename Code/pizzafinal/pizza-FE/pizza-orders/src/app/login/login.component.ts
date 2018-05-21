import {Component, OnInit} from '@angular/core';
import {AppService} from "../app.service";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    public username;
    public password;

    constructor(private service: AppService, private router: Router, public snackBar: MatSnackBar) {
    }

    ngOnInit() {
        this.username = '';
        this.password = '';
    }

    login() {
        this.service.login(this.username, this.password)
            .subscribe((res) => {
                    console.log(res);
                    if (res === 'Not a user') {
                        this.openSnackBar('Wrong username or password', '');
                    }
                    else {
                        this.router.navigate(res === 'Is client' ? ['/client'] : ['/store']);
                        this.openSnackBar('Login successfull!', '');
                    }
                },
                (err) => {
                    console.error(err);
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

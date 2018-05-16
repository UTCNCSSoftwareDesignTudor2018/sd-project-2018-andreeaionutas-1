import {Component, OnInit} from '@angular/core';
import {AppService} from "./app.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public username;
  public password;

  constructor(private service: AppService) {
  }

  ngOnInit() {
    this.username = '';
    this.password = '';
  }

  login() {
    this.service.login(this.username, this.password)
      .subscribe((res) => {
          console.log(res);
        },
        (err) => {
          console.log(err);
        })
  }

}

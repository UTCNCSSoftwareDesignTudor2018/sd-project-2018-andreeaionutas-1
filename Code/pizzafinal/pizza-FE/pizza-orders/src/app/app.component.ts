import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  img = 'http://7wallpapers.net/wp-content/uploads/6_Pizza.jpg';

    constructor(private router: Router) {
        console.log(this.router.url)
    }
}

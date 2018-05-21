import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from '../../../../pizza-FE/pizza-orders/src/app/login/login.component';
import {AppRoutingModule} from "../../../../pizza-FE/pizza-orders/src/app/app-routing.module";

import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule, MatInputModule} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {AppService} from "../../../../pizza-FE/pizza-orders/src/app/app.service";

@NgModule({
  // components
  declarations: [
    AppComponent,
    LoginComponent,

  ],

  // Modules
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    BrowserAnimationsModule,
    FormsModule,
    CommonModule,
    HttpClientModule
  ],

  // Services
  providers: [
    AppService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

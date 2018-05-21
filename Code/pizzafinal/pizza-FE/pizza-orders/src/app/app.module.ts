import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LoginComponent} from "./login/login.component";
import {AppRoutingModule} from "./app-routing.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {HttpModule} from '@angular/http';
import {
    MatButtonModule,
    MatCardModule,
    MatCheckboxModule,
    MatFormFieldModule, MatIconModule,
    MatInputModule,
    MatListModule, MatProgressSpinnerModule,
    MatSnackBarModule
} from "@angular/material";
import {AppService} from "./app.service";
import {StoreComponent} from './store/store.component';
import {ClientComponent} from './client/client.component';

@NgModule({
    declarations: [
        AppComponent,
        LoginComponent,
        StoreComponent,
        ClientComponent,
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        FormsModule,
        CommonModule,
        HttpClientModule,
        HttpModule,

        AppRoutingModule,

        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        MatSnackBarModule,
        MatCardModule,
        MatListModule,
        MatCheckboxModule,
        MatIconModule,
        MatProgressSpinnerModule
    ],
    providers: [AppService],
    bootstrap: [AppComponent]
})
export class AppModule {
}

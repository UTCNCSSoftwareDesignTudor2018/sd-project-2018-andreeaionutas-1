import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {NgModule} from "@angular/core";
import {StoreComponent} from "./store/store.component";
import {ClientComponent} from "./client/client.component";


const appRoutes: Routes = [
  { path: '', redirectTo: '/login',  pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'client', component: ClientComponent },
  { path: 'store', component: StoreComponent }
];

@NgModule({
  imports :[
    RouterModule.forRoot(
      appRoutes
    )
  ],
  exports: [
    RouterModule
  ]
})

export class AppRoutingModule {

}

import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {NgModule} from "@angular/core";


const appRoutes: Routes = [
  {
    path: 'login', component: LoginComponent
  }
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

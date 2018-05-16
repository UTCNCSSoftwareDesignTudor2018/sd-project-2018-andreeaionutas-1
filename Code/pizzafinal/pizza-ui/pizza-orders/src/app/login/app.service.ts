import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/internal/Observable';
import 'rxjs/add/operator/map'
import "rxjs/add/operator/catch";
@Injectable()

export class AppService {

  private loginPath = 'http://localhost:8082/login/login';

  constructor(private http: HttpClient){ }

  login(username,password): Observable<any> {

    return this.http.get(this.loginPath)
      .map((res) =>{
        return res;
      })
      .catch((error)=> error)
  }


}

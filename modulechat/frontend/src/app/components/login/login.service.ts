import { Injectable, Inject, forwardRef } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import { ActivatedRoute, Router } from '@angular/router';
//import { ConstantsService} from './constants.service';

import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class LoginService {

  private apiUrl:String = 'http://localhost:9090/';

  constructor(private http:Http, private router: Router) { }

  login(loginObj:any):any{
    return  this.http.get(this.apiUrl+'users/login/'+loginObj.userName+'/'+loginObj.password).toPromise()
    .then(
      (res:Response) => {
        var data:any = res.json();
        if(data.success){
          localStorage.setItem("user",data.responseObject)
          this.router.navigateByUrl("/chat");        
        }else{
          console.log("Error");
          //this._setLoginError(this.cons.LOGIN_FAILED);
        }
      }
    )
    .catch((this.handleError)) ;
  }

  private handleError(error: any): Promise<any> {
     console.error('An error occurred', error);
     return Promise.reject(error.message || error);
  }
}

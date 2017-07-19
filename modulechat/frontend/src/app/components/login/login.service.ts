import { Injectable, Inject, forwardRef } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import { ActivatedRoute, Router } from '@angular/router';
//import { ConstantsService} from './constants.service';

//import { Observable } from 'rxjs/Observable';//j
import { Observable } from 'rxjs/Rx';//car
import { Subject } from 'rxjs/Subject';
import 'rxjs/add/operator/map';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class LoginService {

  private apiUrl:String = 'http://localhost:9090/';

  constructor(
            private route: ActivatedRoute, 
            private router: Router,
            private http:Http ) { }

  
  getClients():string[]{
    return['car','demo','sa','ss']
  }
  login(loginObj:any):any{

    /*
    return  this.http.get(this.apiUrl+'api/users/find/'+loginObj.email).toPromise()
    .then(
      (res:Response) => {
        var data:any = res.json();
        console.log(res.json())
    
        if(data.success){
          console.log("yes");
          //localStorage.setItem("user",data.responseObject)
          //this.router.navigateByUrl("/chat");        
        }else{
          console.log("Error");
          //this._setLoginError(this.cons.LOGIN_FAILED);
        }
    
      }
    )
    .catch((this.handleError)) ;
    */
  }
  private handleError(error: any): Promise<any> {
     console.error('An error occurred', error);
     return Promise.reject(error.message || error);
  }
}

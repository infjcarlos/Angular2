import { Component, OnInit,Inject } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './login.service';
import { NgForm, Validators, AbstractControl } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers:[LoginService]
})
export class LoginComponent implements OnInit {

  constructor( private router: Router/*, @Inject(LoginService) private chatService:LoginService*/ ) { }
  /*
  goToLogin(){
    this.router.navigate( ['/login'], {queryParams: {sessionId: new Date().getTime()}} );
  }
  goToRegister(){
    this.router.navigate( ['/register'], {queryParams: {sessionId: new Date().getTime()}} );
  }*/
  onSubmitLogin(form:any){
    /*
    var res = this.chatService.login({
                "email":   form.email,
                "psw":   form.psw
          });
              */
    //console.log(res);
  }

  goToHome(){
    this.router.navigate( ['/'] );
  }

  ngOnInit() {
  }

}

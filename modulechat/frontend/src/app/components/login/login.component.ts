import { Component, OnInit,Inject } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm, Validators, AbstractControl } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router) { }
  /*
  goToLogin(){
    this.router.navigate( ['/login'], {queryParams: {sessionId: new Date().getTime()}} );
  }
  goToRegister(){
    this.router.navigate( ['/register'], {queryParams: {sessionId: new Date().getTime()}} );
  }*/
  onSubmitLogin(form:any){
    alert("car");
  }

  goToHome(){
    this.router.navigate( ['/'] );
  }

  ngOnInit() {
  }

}

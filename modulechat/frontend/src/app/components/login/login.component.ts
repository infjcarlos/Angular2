import { Component, OnInit,Inject } from '@angular/core';
import { NgForm, Validators, AbstractControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers:[LoginService]
})
export class LoginComponent implements OnInit {

  list =[];
  constructor( 
    private chatService:LoginService,
    private route: ActivatedRoute, 
    private router: Router) { /**/
      //this.list = chatService.getClients();
     }
  /*
  goToLogin(){
    this.router.navigate( ['/login'], {queryParams: {sessionId: new Date().getTime()}} );
  }
  goToRegister(){
    this.router.navigate( ['/register'], {queryParams: {sessionId: new Date().getTime()}} );
  }*/
  onSubmitLogin(form:any){
    var res = this.chatService.login({
                "email":   form.email,
                "psw":   form.psw
          });
  }

  goToHome(){
    this.router.navigate( ['/'] );
  }

  ngOnInit() {
    //localStorage.setItem("user",null);
  }

}

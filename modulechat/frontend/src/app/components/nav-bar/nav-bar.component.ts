import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private router: Router) {   }

  goToLogin(){
    this.router.navigate( ['/login'], {queryParams: {sessionId: new Date().getTime()}} );
  }
  goToRegister(){
    this.router.navigate( ['/register'], {queryParams: {sessionId: new Date().getTime()}} );
  }
  ngOnInit() {
  }

}

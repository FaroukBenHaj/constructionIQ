import { Component } from '@angular/core';
import {AuthenticationRequest} from "../../services/models/authentication-request";
import {register} from "../../services/fn/authentification/register";
import {Router} from "@angular/router";
import {AuthentificationService} from "../../services/services/authentification.service";
import {AuthenticationResponse} from "../../services/models/authentication-response";
import {TokenService} from "../../services/token/token.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
authRequest: AuthenticationRequest = { email: '' , password: ''};
errorMsg: Array<string> = [];

constructor(
  private router: Router,
  private authService: AuthentificationService,
  private tokenService: TokenService
) {}

  login() {
  this.errorMsg=[];
  this.authService.authenticate({
    body: this.authRequest
  }).subscribe({
    next: (res : AuthenticationResponse) : void =>{
      this.tokenService.token = res.token as string;
      this.router.navigate(['home']);
    },

    error:(err): void =>{
      console.log(err);
      if(err.error.validationErrors){
        this.errorMsg = err.error.validationErrors;
      }else if (err.error.error) {
        this.errorMsg.push(err.error.error);
      }
    }
  });
  }

  protected readonly register = register;

  register_user() {
this.router.navigate(['register'])
  }
}

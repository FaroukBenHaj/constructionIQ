import { Component } from '@angular/core';
import {RegistrationRequest} from "../../services/models/registration-request";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registerRequest: RegistrationRequest ={ email:'' , firstName:'' ,lastName:'' , password:''};
  errorMsg: Array<string> =[];
}

import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { Userr } from '../../modules/Userr';
import { Api } from '../services/api';

@Component({
  selector:'app-fromtemplate',
  standalone:true,
  imports:[FormsModule],
  templateUrl:'./fromtemplate.html',
  styleUrls:['./fromtemplate.css']
})
export class FromtemplateComponent{

  private api=inject(Api);
  
  userr:Userr=new Userr();

  register(){

    this.api.register(this.userr).subscribe({

      next:(res)=>{
        console.log(res);
        alert("User Registered Successfully");

        this.userr=new Userr();
      },

      error:(err)=>{
        console.log(err);
      }

    });
    

  }

}
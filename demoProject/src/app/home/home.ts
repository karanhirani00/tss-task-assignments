import { NgClass } from '@angular/common';
import { Component } from '@angular/core';
import { Admin } from '../admin/admin';
import { Member } from '../member/member';

@Component({
  selector: 'app-home',
  imports: [NgClass , Admin ,Member],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  
  isadmin: boolean = true;

  switchRole(role: string) {

    if (role === 'admin') {
      this.isadmin = true;
    } else {
      this.isadmin = false;
    }

    console.log(this.isadmin);
  }


}

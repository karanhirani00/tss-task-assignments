import { NgClass } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin/admin';
import { Member } from '../member/member';
import { Api } from '../services/api';

@Component({
  selector: 'app-home',
  imports: [NgClass , Admin ,Member ],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit {
  
  isadmin: boolean = true;

  switchRole(role: string) {

    if (role === 'admin') {
      this.isadmin = true;
    } else {
      this.isadmin = false;
    }

    console.log(this.isadmin);
  }




  constructor(private api: Api) {}

users: any[] = [];

ngOnInit(): void {
  this.api.getUsers().subscribe({
    next: (data: any[]) => {
      this.users = data;
       console.log(data);
    },
    error: (err) => {
      console.log(err);
    }
  });
}



}


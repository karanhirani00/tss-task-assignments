import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-generdemo',
  imports: [FormsModule],
  templateUrl: './generdemo.html',
  styleUrl: './generdemo.css',
})
export class Generdemo {
  
  MovieId: number = 101;
  MovieName: string = 'Pushpa 2';
  Rating: number = 4.8;
  ReleaseDate: string = '05-12-2024';

  num : number = 5211;
  
  getstrig() : string{
    return "hiii"
  }

  updnumber() : void{
    this.num = this.num*2;
  }

  
   

}

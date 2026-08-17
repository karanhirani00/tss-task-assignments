import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Generdemo } from './generdemo/generdemo';
import { DirectiveDemo } from './directive-demo/directive-demo';
import { Home } from './home/home';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet ,Generdemo,DirectiveDemo ,Home],
 templateUrl: './app.html',

 styleUrl: './app.css'

})
export class App {
  protected readonly title = signal('demoProject');
}

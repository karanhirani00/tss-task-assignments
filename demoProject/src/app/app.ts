import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Generdemo } from './generdemo/generdemo';
import { DirectiveDemo } from './directive-demo/directive-demo';
import { Home } from './home/home';
import { FromtemplateComponent } from './fromtemplate/fromtemplate';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet ,Generdemo,DirectiveDemo ,Home ,FromtemplateComponent],
 templateUrl: './app.html',

 styleUrl: './app.css'

})
export class App {
  protected readonly title = signal('demoProject');
}

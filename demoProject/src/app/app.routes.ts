import { Routes } from '@angular/router';
import { Home } from './home/home';
import { ReviewComponent } from './review/review';

export const routes: Routes = [
     {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },

  {
    path: 'home',
    component: Home
  },

  {
    path: 'review',
    component: ReviewComponent
  }




];

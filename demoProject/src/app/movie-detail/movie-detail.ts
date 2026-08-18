import { Component ,Input, Output ,EventEmitter } from '@angular/core';
import { Movie } from '../../modules/Movie';


@Component({
  selector: 'app-movie-detail',
  imports: [],
  templateUrl: './movie-detail.html',
  styleUrl: './movie-detail.css',
})
export class MovieDetail {
  @Input()
movieFromParent: Movie = {
  movieId: 0,
  movieTitle: '',
  movieRating: 0,
  releaseDate: new Date(),
  genreId: 0
};


  @Output()
   dataToParent = new EventEmitter<string>();

  sendDataToParent() {
    this.dataToParent.emit("Hello Parent from Child");
  }
}

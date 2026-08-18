import { Component ,Input } from '@angular/core';
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
}

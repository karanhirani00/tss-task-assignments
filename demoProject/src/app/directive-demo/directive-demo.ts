import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Movie } from '../../modules/Movie';
import { MovieTypePipe } from '../pipes/movie-type-pipe';
import { MovieDetail } from '../movie-detail/movie-detail';

@Component({
  selector: 'app-directive-demo',
  imports: [CommonModule , MovieTypePipe ,MovieDetail],
  templateUrl: './directive-demo.html',
  styleUrl: './directive-demo.css',
})
export class DirectiveDemo {

    listMovie : Movie[] = [
    {movieId: 1, movieTitle: 'Movie 1', movieRating: 4.5, releaseDate: new Date('2022-01-01'), genreId: 1},
    {movieId: 2, movieTitle: 'Movie 2', movieRating: 3.5, releaseDate: new Date('2022-02-01'), genreId: 2},
    {movieId: 3, movieTitle: 'Movie 3', movieRating: 4.0, releaseDate: new Date('2022-03-01'), genreId: 3},
    {movieId: 4, movieTitle: 'Movie 4', movieRating: 2.5, releaseDate: new Date('2022-04-01'), genreId: 4},
    {movieId: 5, movieTitle: 'Movie 5', movieRating: 5.0, releaseDate: new Date('2022-05-01'), genreId: 5}
  ];
    movieToChild: Movie = {
    movieId: 0,
    movieTitle: '',
    movieRating: 0,
    releaseDate: new Date(),
    genreId: 0
  };

updMovieToChild(index: number) {
    this.movieToChild = this.listMovie[index];
  }
}

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  Validators
} from '@angular/forms';
import { ReviewService } from '../services/review';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-review',

  imports: [CommonModule, ReactiveFormsModule ],
  templateUrl: './review.html',
  styleUrls: ['./review.css']
})
export class ReviewComponent {

  reviewForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private reviewService: ReviewService
  ) {

    this.reviewForm = this.fb.group({
      userId: ['', Validators.required],
      bookId: ['', Validators.required],
      rating: [
        '',
        [
          Validators.required,
          Validators.min(1),
          Validators.max(5)
        ]
      ],
      comment: [
        '',
        [
          Validators.maxLength(2000)
        ]
      ]
    });

  }

  onSubmit(): void {

    if (this.reviewForm.valid) {

      this.reviewService.addReview(this.reviewForm.value).subscribe({
        next: (response) => {
          console.log('Review added successfully', response);
          this.reviewForm.reset();
        },
        error: (error) => {
          console.error('Error adding review', error);
        }
      });

    } else {
      this.reviewForm.markAllAsTouched();
    }

  }

}
export interface ReviewRequest {
  userId: number;
  bookId: number;
  rating: number;
  comment: string;
}
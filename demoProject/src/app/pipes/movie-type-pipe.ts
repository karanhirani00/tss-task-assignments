import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'movieType',
})
export class MovieTypePipe implements PipeTransform {
   transform(value: number, ...args: any[]): string {

    if (value > 3) {
      return value + ' - HIT MOVIE - DISC ' + (args[0] * 10);
    }
    else if (value == 3) {
      return value + ' - AVERAGE MOVIE - DISC ' + (args[0] * 10);
    }
    else {
      return value + ' - FLOP MOVIE - DISC ' + (args[0] * 10);
    }

  }
}

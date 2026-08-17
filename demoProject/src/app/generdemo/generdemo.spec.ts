import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Generdemo } from './generdemo';

describe('Generdemo', () => {
  let component: Generdemo;
  let fixture: ComponentFixture<Generdemo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Generdemo],
    }).compileComponents();

    fixture = TestBed.createComponent(Generdemo);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

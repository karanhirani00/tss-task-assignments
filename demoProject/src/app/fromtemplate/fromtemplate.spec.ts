import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Fromtemplate } from './fromtemplate';

describe('Fromtemplate', () => {
  let component: Fromtemplate;
  let fixture: ComponentFixture<Fromtemplate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Fromtemplate],
    }).compileComponents();

    fixture = TestBed.createComponent(Fromtemplate);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

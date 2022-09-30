import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormMatricolaComponent } from './form-matricola.component';

describe('FormMatricolaComponent', () => {
  let component: FormMatricolaComponent;
  let fixture: ComponentFixture<FormMatricolaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormMatricolaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormMatricolaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

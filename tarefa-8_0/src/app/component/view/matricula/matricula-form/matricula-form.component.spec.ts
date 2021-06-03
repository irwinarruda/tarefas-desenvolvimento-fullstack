import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatriculaFormComponent } from './matricula-form.component';

describe('MatriculaFormComponent', () => {
  let component: MatriculaFormComponent;
  let fixture: ComponentFixture<MatriculaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatriculaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatriculaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestrictedWordsComponent } from './restricted-words.component';

describe('RestrictedWordsComponent', () => {
  let component: RestrictedWordsComponent;
  let fixture: ComponentFixture<RestrictedWordsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestrictedWordsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestrictedWordsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestrictedWordListComponent } from './restricted-word-list.component';

describe('RestrictedWordListComponent', () => {
  let component: RestrictedWordListComponent;
  let fixture: ComponentFixture<RestrictedWordListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestrictedWordListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestrictedWordListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

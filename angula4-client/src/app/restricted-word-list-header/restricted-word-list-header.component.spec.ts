import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestrictedWordListHeaderComponent } from './restricted-word-list-header.component';

describe('RestrictedWordListHeaderComponent', () => {
  let component: RestrictedWordListHeaderComponent;
  let fixture: ComponentFixture<RestrictedWordListHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestrictedWordListHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestrictedWordListHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

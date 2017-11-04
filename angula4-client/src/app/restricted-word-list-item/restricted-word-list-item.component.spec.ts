import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestrictedWordListItemComponent } from './restricted-word-list-item.component';

describe('RestrictedWordListItemComponent', () => {
  let component: RestrictedWordListItemComponent;
  let fixture: ComponentFixture<RestrictedWordListItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestrictedWordListItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestrictedWordListItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

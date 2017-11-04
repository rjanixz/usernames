import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestrictedWordListFooterComponent } from './restricted-word-list-footer.component';

describe('RestrictedWordListFooterComponent', () => {
  let component: RestrictedWordListFooterComponent;
  let fixture: ComponentFixture<RestrictedWordListFooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestrictedWordListFooterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestrictedWordListFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

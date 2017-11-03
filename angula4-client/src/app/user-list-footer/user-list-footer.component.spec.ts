import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserListFooterComponent } from './user-list-footer.component';

describe('UserListFooterComponent', () => {
  let component: UserListFooterComponent;
  let fixture: ComponentFixture<UserListFooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserListFooterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserListFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

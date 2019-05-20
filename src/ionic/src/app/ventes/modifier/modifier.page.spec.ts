import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierPage } from './modifier.page';

describe('ModifierPage', () => {
  let component: ModifierPage;
  let fixture: ComponentFixture<ModifierPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifierPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifierPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterPage } from './ajouter.page';

describe('AjouterPage', () => {
  let component: AjouterPage;
  let fixture: ComponentFixture<AjouterPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

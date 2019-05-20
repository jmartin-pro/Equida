import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterLotPage } from './ajouter-lot.page';

describe('AjouterLotPage', () => {
  let component: AjouterLotPage;
  let fixture: ComponentFixture<AjouterLotPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterLotPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterLotPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

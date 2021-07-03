import {CommonModule} from '@angular/common';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {OwnerListComponent} from "./owner-list/owner-list.component";
import {SharedModule} from "../../shared/shared.module";
import {OwnerRoutingModule} from "./owner-routing.module";

@NgModule({
  declarations: [
      OwnerListComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    OwnerRoutingModule
  ],
  entryComponents: [
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class OwnerModule { }

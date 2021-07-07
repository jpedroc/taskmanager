import {CommonModule} from '@angular/common';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {OwnerListComponent} from "./owner-list/owner-list.component";
import {SharedModule} from "../../shared/shared.module";
import {OwnerRoutingModule} from "./owner-routing.module";
import {OwnerFormComponent} from './owner-form/owner-form.component';
import {OwnerFormModalComponent} from "./owner-form/owner-form-modal.component";

@NgModule({
    declarations: [
        OwnerListComponent,
        OwnerFormComponent,
        OwnerFormModalComponent
    ],
    imports: [
        CommonModule,
        SharedModule,
        OwnerRoutingModule,
    ],
    entryComponents: [OwnerFormModalComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class OwnerModule {
}

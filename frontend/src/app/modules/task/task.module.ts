import {CommonModule} from '@angular/common';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {OwnerListComponent} from "./owner-list/owner-list.component";
import {SharedModule} from "../../shared/shared.module";
import {TaskRoutingModule} from "./task-routing.module";

@NgModule({
    declarations: [
        OwnerListComponent
    ],
    imports: [
        CommonModule,
        SharedModule,
        TaskRoutingModule,
    ],
    entryComponents: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TaskModule {
}

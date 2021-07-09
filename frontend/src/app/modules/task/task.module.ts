import {CommonModule} from '@angular/common';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {SharedModule} from "../../shared/shared.module";
import {TaskRoutingModule} from "./task-routing.module";
import {TaskListComponent} from "./task-list/task-list.component";

@NgModule({
    declarations: [
        TaskListComponent
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

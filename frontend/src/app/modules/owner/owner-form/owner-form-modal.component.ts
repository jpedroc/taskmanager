import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {OwnerFormComponent} from "./owner-form.component";
import {DynamicDialogConfig, DynamicDialogRef} from "primeng";

@Component({
    selector: 'app-owner-form-modal',
    template: '<app-owner-form [modal]="true" (done)="ref.close($event)"></app-owner-form>'
})
export class OwnerFormModalComponent implements AfterViewInit {
    constructor(public config: DynamicDialogConfig,
                public ref: DynamicDialogRef) {
    }

    @ViewChild(OwnerFormComponent) form: OwnerFormComponent;

    ngAfterViewInit() {
        if (this.config.data) {
            this.form.editing = this.config.data.editing;
            this.form.entityId = this.config.data.entityId;
        }
    }
}

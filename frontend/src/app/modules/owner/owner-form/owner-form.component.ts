import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {BaseEntityForm} from "../../../shared/base-entity-form";
import {OwnerModel} from "../../../models/owner.model";
import {ConfirmationService, DialogService} from "primeng";
import {PageNotificationService} from "@nuvem/primeng-components";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ModalService} from "../../../shared/modal.service";
import {OwnerService} from "../../../shared/services/owner.service";

@Component({
    selector: 'app-owner-form',
    templateUrl: './owner-form.component.html',
    styleUrls: ['./owner-form.component.css'],
    providers: [DialogService, ModalService]
})
export class OwnerFormComponent extends BaseEntityForm<OwnerModel> implements OnInit {

    constructor( protected confirmationService: ConfirmationService,
                 protected pageNotificationService: PageNotificationService,
                 protected formBuilder: FormBuilder,
                 protected modalService: ModalService,
                 private ownerService: OwnerService) {
        super(confirmationService, pageNotificationService, formBuilder, modalService);
    }

    SERVICE = this.ownerService;

    ngOnInit(): void {
        super.ngOnInit();
    }

    buildReactiveForm(): FormGroup {
        return null;
    }

    onLoadEntity(entity: OwnerModel) {
        this.form.patchValue(entity);
    }

    sendForm(entity: OwnerModel) {
    }

}

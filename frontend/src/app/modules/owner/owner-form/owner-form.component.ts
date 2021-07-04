import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {BaseEntityForm} from "../../../shared/base-entity-form";
import {OwnerModel} from "../../../models/owner.model";
import {ConfirmationService} from "primeng";
import {PageNotificationService} from "@nuvem/primeng-components";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ModalService} from "../../../shared/modal.service";
import {OwnerService} from "../../../shared/services/owner.service";

@Component({
    selector: 'app-owner-form',
    templateUrl: './owner-form.component.html',
    styleUrls: ['./owner-form.component.css']
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

    @Input() modal: boolean = false;
    @Output() done = new EventEmitter();

    ngOnInit(): void {
        super.ngOnInit()
    }

    buildReactiveForm(): FormGroup {
        return undefined;
    }

    onLoadEntity(entity: OwnerModel) {
    }

    sendForm(entity: OwnerModel) {
    }

}

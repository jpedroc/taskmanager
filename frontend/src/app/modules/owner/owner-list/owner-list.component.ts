import {Component, OnInit} from '@angular/core';
import {OwnerService} from "../../../shared/services/owner.service";
import {OwnerUtil} from "../util/owner.util";
import {OwnerModel} from "../../../models/owner.model";
import {PageNotificationService} from "@nuvem/primeng-components";
import {DynamicDialogRef} from "primeng";
import {ModalService} from "../../../shared/modal.service";
import {OwnerFormModalComponent} from "../owner-form/owner-form-modal.component";

@Component({
    selector: 'app-owner-list',
    templateUrl: './owner-list.component.html',
    styleUrls: ['./owner-list.component.css']
})
export class OwnerListComponent implements OnInit {

    constructor(
        private ownerService: OwnerService,
        private pageNotificationService: PageNotificationService,
        private modalService: ModalService
    ) {
    }

    ownerList = [];
    columns = OwnerUtil.DEFAULT_COLUMNS;

    ngOnInit(): void {
        this.refreshTable();
    }

    refreshTable() {
        this.ownerService.getAll().subscribe(res => {
            this.ownerList = res;
        })
    }

    getSelectedOnwer() {
        const owner: OwnerModel = JSON.parse(localStorage.getItem("activeOwner"));
        if (owner) {
            return owner.id + " - " + owner.name;
        }
        return "";
    }

    setOwnerActive(owner: OwnerModel) {
        this.pageNotificationService.addSuccessMessage("Owner selecionado com sucesso", "Sucesso!");
        localStorage.setItem("activeOwner", JSON.stringify(owner));
        this.getSelectedOnwer();
    }

    openDialog(){
        const form = this.modalService.openModal(OwnerFormModalComponent, {}, {editing: true, entityId: null});
        form.onClose
            .subscribe(res => {
                if (res) {
                    this.refreshTable();
                }
            });
    }

}

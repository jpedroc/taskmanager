import {Component, OnInit, ViewChild} from '@angular/core';
import {OwnerService} from "../../../shared/services/owner.service";
import {OwnerUtil} from "../util/owner.util";
import {OwnerModel} from "../../../models/owner.model";
import {PageNotificationService} from "@nuvem/primeng-components";
import {DynamicDialogRef, Table} from "primeng";
import {ModalService} from "../../../shared/modal.service";
import {OwnerFormModalComponent} from "../owner-form/owner-form-modal.component";
import {DefaultFilter} from "../../../shared/models/default-filter";
import {Page} from "../../../shared/page";

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

    ownerList = new Page<any>();
    columns = OwnerUtil.DEFAULT_COLUMNS;
    filter: DefaultFilter = new DefaultFilter();

    @ViewChild(Table) table: Table;

    ngOnInit(): void {
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

    // openDialog(){
    //     const form = this.modalService.openModal(OwnerFormModalComponent, {}, {editing: true, entityId: null});
    //     form.onClose
    //         .subscribe(res => {
    //             if (res) {
    //                 this.refreshTable();
    //             }
    //         });
    // }

    search() {
        this.ownerService.search(this.table, {query: this.filter.query}).subscribe(res => {
            this.ownerList = res;
        });
    }

}

import {Component, OnInit} from '@angular/core';
import {OwnerService} from "../../../shared/services/owner.service";
import {OwnerUtil} from "../util/owner.util";
import {OwnerListModel} from "../../../models/listing/owner-list.model";
import {OwnerModel} from "../../../models/owner.model";
import {PageNotificationService} from "@nuvem/primeng-components";

@Component({
  selector: 'app-owner-list',
  templateUrl: './owner-list.component.html',
  styleUrls: ['./owner-list.component.css']
})
export class OwnerListComponent implements OnInit {

    constructor(
        private ownerService: OwnerService,
        private pageNotificationService: PageNotificationService
        ) { }

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
        if(owner) {
            return owner.id + " - " + owner.name;
        }
        return "";
    }

    setOwnerActive(owner: OwnerModel) {
        this.pageNotificationService.addSuccessMessage("Owner selecionado com sucesso", "Sucesso!");
        localStorage.setItem("activeOwner", JSON.stringify(owner));
        this.getSelectedOnwer();
    }

}

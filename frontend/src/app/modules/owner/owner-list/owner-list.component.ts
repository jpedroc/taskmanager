import {Component, OnInit} from '@angular/core';
import {OwnerService} from "../../../shared/services/owner.service";

@Component({
  selector: 'app-owner-list',
  templateUrl: './owner-list.component.html',
  styleUrls: ['./owner-list.component.css']
})
export class OwnerListComponent implements OnInit {

  constructor(private ownerService: OwnerService) { }

  ownerList = [];
  // @BlockUI() blockUI: NgBlockUI;

  ngOnInit(): void {
      this.refreshTable();
  }

    refreshTable() {
        this.ownerService.getAll().subscribe(res => {
            this.ownerList = res;
            console.log(this.ownerList);
        })
    }

}

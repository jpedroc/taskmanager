import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {BaseEntityService} from "../base-entity-service";
import {OwnerModel} from "../../models/owner.model";
import {HttpClient} from "@angular/common/http";
import {OwnerListModel} from "../../models/listing/owner-list.model";

@Injectable({
    providedIn: 'root'
})
export class OwnerService extends BaseEntityService<OwnerModel, OwnerListModel> {

    constructor(protected http: HttpClient) { super(http); }

    getEntity(): string {
        return "owners";
    }

    getAll(): Observable<OwnerModel[]> {
        return this.http.get<any[]>(this.resourceUrl);
    }
}

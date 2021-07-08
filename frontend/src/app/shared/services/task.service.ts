import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {BaseEntityService} from "../base-entity-service";
import {HttpClient} from "@angular/common/http";
import {TaskModel} from "../../models/task.model";

@Injectable({
    providedIn: 'root'
})
export class TaskService extends BaseEntityService<TaskModel, TaskListModel> {

    constructor(protected http: HttpClient) { super(http); }

    getEntity(): string {
        return "tasks";
    }

    getAll(): Observable<TaskModel[]> {
        return this.http.get<any[]>(this.resourceUrl);
    }
}

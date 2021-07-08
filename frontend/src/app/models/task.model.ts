import {CommentModel} from "./comment.model";
import {DocumentModel} from "./document.model";

export class TaskModel {
    public id?: number;
    public title?: string;
    public description?: string;
    public expectedStartDate?: Date;
    public expectedEndDate?: Date;
    public startDate?: Date;
    public endDate?: Date;
    public statusId?: number;
    public ownerId?: number;
    public comments?: CommentModel[] = [];
    public documents?: DocumentModel[] = [];
}

import {OwnerModel} from "../../../models/owner.model";

export class OwnerUtil {

    public static DEFAULT_COLUMNS=  [
        {
            field: 'name',
            header: 'Name'
        },
        {
            field: 'email',
            header: 'Email'
        },
        {
            field: 'birthDate',
            header: 'Birth Date',
            sortField: 'birthDate.sort'
        },
        {
            field: 'status',
            header: 'Status'
        }
    ]

    public static getSelectOwner(): number {
        const owner: OwnerModel = JSON.parse(localStorage.getItem("activeOwner"));

        return owner ? owner.id : null;
    }

}

export class TaskUtil {

    public static DEFAULT_COLUMNS=  [
        {
            field: 'title',
            header: 'Title'
        },
        {
            field: 'expectedStartDate',
            header: 'Expected Start Date',
            sortField: 'expectedStartDate.sort'
        },
        {
            field: 'expectedEndDate',
            header: 'Expected End Date',
            sortField: 'expectedEndDate.sort'
        },
        {
            field: 'startDate',
            header: 'Start Date',
            sortField: 'startDate.sort'
        },
        {
            field: 'endDate',
            header: 'End Date',
            sortField: 'endDate.sort'
        },
        {
            field: 'owner',
            header: 'Owner'
        },
        {
            field: 'status',
            header: 'Status'
        }
    ]

}

import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
    {
        path: 'owners',
        loadChildren: './modules/owner/owner.module#OwnerModule'
    },
    {
        path: 'tasks',
        loadChildren: './modules/task/task.module#TaskModule'
    },
];

@NgModule({
    imports: [RouterModule.forRoot(routes, { scrollPositionRestoration: 'enabled' })],
    exports: [RouterModule]
})
export class AppRoutingModule { }

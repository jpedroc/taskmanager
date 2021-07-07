import { NgModule } from '@angular/core';
import { PRIMENG_IMPORTS } from './primeng-imports';
import {ModalService} from "./modal.service";
import {ConfirmationService, DialogService} from "primeng";

@NgModule({
    imports: [
        PRIMENG_IMPORTS,
    ],
    providers: [ModalService, DialogService, ConfirmationService],
    exports: [
        PRIMENG_IMPORTS,
    ]
})
export class SharedModule { }

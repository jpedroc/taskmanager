import {EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {PageNotificationService} from '@nuvem/primeng-components';
import {BlockUI, NgBlockUI} from 'ng-block-ui';
import {ConfirmationService} from 'primeng/api';
import {catchError, finalize, map, take, takeWhile} from 'rxjs/operators';
import {ModalService} from "./modal.service";
import {ValidationUtil} from "./validation-util";
import {BaseEntityService} from "./base-entity-service";
import {Observable} from "rxjs";

export abstract class BaseEntityForm<T> implements OnInit, OnDestroy {

    protected constructor(protected confirmationService: ConfirmationService,
                          protected pageNotificationService: PageNotificationService,
                          protected formBuilder: FormBuilder,
                          protected modalService: ModalService) {
    }

    @BlockUI() blockUI: NgBlockUI;
    @Output() done = new EventEmitter<T | undefined>();
    @Input() modal = false;

    abstract SERVICE: BaseEntityService<T, any>;
    form: FormGroup;
    entityId: number;
    editing = false;
    _alive = true;

    ngOnInit() {
        this.form = this.buildReactiveForm();
        if (!this.editing) {
            this.form.disable();
        }
        this.loadEntity();
    }

    abstract buildReactiveForm(): FormGroup;

    uploadFile(event, onload) {
        const file = event.files[0];
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => {
            onload({name: file.name, base64: reader.result});
        };
    }

    uploadMultipleFiles(event, onload) {
        event.files.forEach(file => {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => {
                onload({name: file.name, base64: reader.result});
            };
        })
    }

    loadEntity() {
        if (this.entityId) {
            this.blockUI.start("Loading...");
            return this.SERVICE.findById(this.entityId)
                .pipe(
                    takeWhile(_ => this._alive),
                    catchError(err => {
                        this.close();
                        throw err;
                    }),
                    finalize(() => {
                        this.blockUI.stop();
                    }),
                    map(entity => this.onLoadEntity(entity)),
                ).subscribe();
        }
    }

    abstract onLoadEntity(entity: T);

    saveForm(event) {
        if (event) {
            event.preventDefault();
        }

        ValidationUtil.validateForm(this.form);

        if (this.form.valid) {
            const entity: T = this.form.value;
            this.sendForm(entity);
        }
    }

    abstract sendForm(entity: T);

    postAndShowNotification(result: Observable<T>, messageKey: string) {
        this.blockUI.start("Loading...");

        return result
            .pipe(
                take(1),
                catchError(err => {
                    this.close();
                    throw err;
                }),
                finalize(() => {
                    this.blockUI.stop();
                }),
                map(res => {
                    this.close(res);

                    this.pageNotificationService.addSuccessMessage(messageKey);
                    return res;
                })
            ).subscribe();
    }

    isInsert() {
        return this.form.get('id').value === null;
    }

    close(entity?: T) {
        this.done.emit(entity);
    }

    ngOnDestroy() {
        this._alive = false;
    }

    isEdition() {
        return this.isInsert() || this.editing;
    }

    isMobile() {
        return window.screen.width <= 641;
    }

    formatToDate(date: any): Date {
        if (!date) {
            return null;
        }

        return new Date(`${date} EDT`);
    }
}

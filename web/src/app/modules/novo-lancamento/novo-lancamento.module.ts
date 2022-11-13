import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NovoLancamentoComponent } from './novo-lancamento.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    NovoLancamentoComponent
  ],
  imports: [
    CommonModule,
    MatDialogModule,
    MatButtonModule,
    ReactiveFormsModule,
  ],
  exports: [
    NovoLancamentoComponent
  ]
})
export class NovoLancamentoModule { }

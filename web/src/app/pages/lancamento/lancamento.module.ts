import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LancamentoRoutingModule } from './lancamento-routing.module';
import { LancamentoComponent } from './lancamento.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import {MatSelectModule} from '@angular/material/select';
import { ReactiveFormsModule } from '@angular/forms';
import { NovoLancamentoModule } from 'src/app/modules/novo-lancamento/novo-lancamento.module';


@NgModule({
  declarations: [
    LancamentoComponent
  ],
  imports: [
    CommonModule,
    LancamentoRoutingModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    MatButtonModule,
    MatIconModule,
    MatListModule,
    MatSelectModule,
    NovoLancamentoModule,
  ]
})
export class LancamentoModule { }

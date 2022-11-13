import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContaRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatIconModule } from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { CartaoModule } from 'src/app/modules/cartao/cartao.module';
import { ContaModule } from 'src/app/modules/conta/conta.module';
import {MatDialogModule} from '@angular/material/dialog';
import {MatCardModule} from '@angular/material/card';



@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    CommonModule,
    ContaRoutingModule,
    FlexLayoutModule,
    MatIconModule,
    MatListModule,
    MatButtonModule,
    CartaoModule,
    ContaModule,
    MatDialogModule,
    MatCardModule,
  ]
})
export class HomeModule { }

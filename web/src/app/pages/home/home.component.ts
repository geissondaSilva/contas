import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { Conta } from 'src/app/models/conta';
import { CartaoComponent } from 'src/app/modules/cartao/cartao.component';
import { ContaComponent } from 'src/app/modules/conta/conta.component';
import { ContaService } from 'src/app/services/conta.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  public contas: Conta[] = [];

  constructor(
    private service: ContaService,
    private activatedRoute: ActivatedRoute,
    public dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.contas = this.activatedRoute.snapshot.data['contas'];
  }

  novoCartao() {
    let dialogCartao = this.dialog.open(CartaoComponent, {
      height: '400px',
      width: '600px'
    });
  }

  novaConta() {
    let dialogConta = this.dialog.open(ContaComponent, {
      width: '600px'
    });
    dialogConta.afterClosed().subscribe(res => {
      if (res) {
        this.contas.push(res);
      }
    });
  }

}

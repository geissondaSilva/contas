import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { LancamentoDia } from '../models/lancamento-dia';
import { Api } from './api';

@Injectable({
  providedIn: 'root'
})
export class LancamentoService extends Api {

  constructor(
    public override http: HttpClient,
  ) {
    super('lancamento', http);
  }

  public buscarLancamentos(ano: number, mes: number): Observable<LancamentoDia[]> {
    return of([
      {
        descricao: 'Domingo 13',
        lancamentos: [
          {
            id: 1,
            dataHora: new Date(),
            contaNome: 'Nubank',
            valor: 100
          },
          {
            id: 1,
            dataHora: new Date(),
            contaNome: 'Sicred',
            valor: 800
          }
        ]
      },
      {
        descricao: 'Segunda-feira 14',
        lancamentos: [
          {
            id: 1,
            dataHora: new Date(),
            contaNome: 'Nubank',
            valor: 100
          },
          {
            id: 1,
            dataHora: new Date(),
            contaNome: 'Sicred',
            valor: 800
          }
        ]
      }
    ] as LancamentoDia[]);
  }

  public getAnos(): number[] {
    let ano = new Date().getFullYear();
    const anos: number[] = [];
    for(let i = ano - 1; i >= ano - 10;i--) {
      anos.unshift(i);
    }
    anos.push(ano);
    for(let i = ano + 1;i <= ano + 10;i++) {
      anos.push(i);
    }
    return anos;
  }
}

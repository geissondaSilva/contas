import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { LancamentoDia } from '../models/lancamento-dia';
import { LancamentoResult } from '../models/lancamento-result';
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

  public buscarLancamentos(ano: number, mes: number) {
    const params = new HttpParams().append('ano', ano).append('mes', mes);
    return this.http.get<LancamentoResult[]>(this.url, {params: params});
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

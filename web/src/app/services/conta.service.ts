import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';
import { Conta } from '../models/conta';
import { Api } from './api';

@Injectable({
  providedIn: 'root'
})
export class ContaService extends Api implements Resolve<Conta[]> {

  constructor(
    public override http: HttpClient,
  ) {
    super('conta', http);
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Conta[]> {
    return this.get();
  }

  // public getMock(): Observable<Conta[]> {
  //   return of([
  //     {
  //       id: 1,
  //       nome: 'Nubank',
  //       valor: 100
  //     },
  //     {
  //       id: 2,
  //       nome: 'Caixa',
  //       valor: 1600
  //     }
  //   ] as Conta[]);
  // }
}

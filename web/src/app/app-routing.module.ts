import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContaService } from './services/conta.service';

const routes: Routes = [
  {
    path: 'lancamento',
    loadChildren: () => import('./pages/lancamento/lancamento.module').then(m => m.LancamentoModule)
  },
  { 
    path: 'home',
    loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule),
    resolve: {
      contas: ContaService,
    }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }

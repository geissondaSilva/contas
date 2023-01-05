import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { LancamentoDia } from 'src/app/models/lancamento-dia';
import { LancamentoResult } from 'src/app/models/lancamento-result';
import { NovoLancamentoComponent } from 'src/app/modules/novo-lancamento/novo-lancamento.component';
import { LancamentoService } from 'src/app/services/lancamento.service';

@Component({
  selector: 'app-lancamento',
  templateUrl: './lancamento.component.html',
  styleUrls: ['./lancamento.component.scss']
})
export class LancamentoComponent implements OnInit {

  public form: FormGroup;

  public dias: LancamentoResult[] = [];

  public anos: number[];

  constructor(
    private service: LancamentoService,
    private formBuilder: FormBuilder,
    private dialog: MatDialog,
  ) {
    this.form = this.criarForm();
    this.anos = service.getAnos();
  }

  ngOnInit(): void {
    this.buscar();
    this.form.valueChanges.subscribe(() => {
      this.buscar();
    });
  }

  public buscar() {
    const formValue = this.form.value;
    this.service.buscarLancamentos(formValue.ano, formValue.mes).subscribe(result => {
      this.dias = result;
    });
  }

  private criarForm() {
    return this.formBuilder.group({
      ano: [new Date().getFullYear()],
      mes: [new Date().getMonth()]
    });
  }

  public avancar() {
    const mes = this.form.get('mes')?.value;
    const ano = this.form.get('ano')?.value;
    if (mes === 11) {
      this.form.patchValue({
        ano: ano + 1,
        mes: 0
      });
    } else {
      this.form.get('mes')?.setValue(mes + 1);
    }
  }

  public voltar() {
    const mes = this.form.get('mes')?.value;
    const ano = this.form.get('ano')?.value;
    if (mes === 0) {
      this.form.patchValue({
        ano: ano + -1,
        mes: 11
      });
    } else {
      this.form.get('mes')?.setValue(mes - 1);
    }
  }

  novoLancamento() {
    this.dialog.open(NovoLancamentoComponent);
  }

}

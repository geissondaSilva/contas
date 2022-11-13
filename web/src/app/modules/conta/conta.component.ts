import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { ContaService } from 'src/app/services/conta.service';

@Component({
  selector: 'app-conta',
  templateUrl: './conta.component.html',
  styleUrls: ['./conta.component.scss']
})
export class ContaComponent implements OnInit {

  public form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private contaService: ContaService,
    public dialogRef: MatDialogRef<ContaComponent>
  ) {
    this.form = this.criarForm();
  }

  private criarForm(): FormGroup {
    return this.formBuilder.group({
      nome: [null, Validators.required],
      valor: [null, Validators.required],
    });
  }

  ngOnInit(): void {
  }

  public salvar() {
    if (this.form.valid) {
      this.contaService.post(this.form.value).subscribe((res) => {
        this.dialogRef.close(res);
      });
    }
  }

}

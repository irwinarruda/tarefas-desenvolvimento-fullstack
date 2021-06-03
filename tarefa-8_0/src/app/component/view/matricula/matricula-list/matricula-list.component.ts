import { Matricula } from '../../../../model/matricula.model';
import { MatriculaService } from './../../../../service/matricula.service';
import { Aluno } from '../../../../model/aluno.model';
import { AlunoService } from './../../../../service/aluno.service';
import { Oferta } from '../../../../model/oferta.model';
import { OfertaService } from './../../../../service/oferta.service';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DeleteConfirmComponent } from 'src/app/component/template/delete-confirm/delete-confirm.component';

@Component({
  selector: 'app-matricula-list',
  templateUrl: './matricula-list.component.html',
  styleUrls: ['./matricula-list.component.css'],
})
export class MatriculaListComponent implements OnInit {
  matriculas: Matricula[] = [];
  displayedColumns: string[] = ['id', 'aluno', 'oferta', 'acao'];
  constructor(private service: MatriculaService, public dialog: MatDialog) {}

  atualizarTabela(): void {
    this.service.findAll().subscribe((matriculas) => {
      this.matriculas = matriculas;
      console.log(this.matriculas);
    });
  }
  ngOnInit(): void {
    this.atualizarTabela();
  }

  excluir(matricula: Matricula): void {
    const dialogRef = this.dialog.open(DeleteConfirmComponent, {
      data: {
        message: `Deseja realmente excluir a Matricula?`,
        buttonText: {
          ok: 'Excluir',
          cancel: 'Desistir',
        },
      },
    });

    dialogRef.afterClosed().subscribe((confirmed: boolean) => {
      if (confirmed) {
        this.service.delete(matricula).subscribe(() => {
          this.service.showMessage('Matricula excluída com sucesso');
          this.atualizarTabela();
        });
      }
    });
  }
}

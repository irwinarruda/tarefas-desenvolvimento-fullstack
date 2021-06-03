import { Aluno } from '../../../../model/aluno.model';
import { AlunoService } from './../../../../service/aluno.service';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DeleteConfirmComponent } from 'src/app/component/template/delete-confirm/delete-confirm.component';

@Component({
  selector: 'app-aluno-list',
  templateUrl: './aluno-list.component.html',
  styleUrls: ['./aluno-list.component.css'],
})
export class AlunoListComponent implements OnInit {
  alunos: Aluno[] = [];
  displayedColumns: string[] = [
    'id',
    'ativo',
    'dtInicio',
    'curso',
    'pessoa',
    'acao',
  ];
  constructor(private service: AlunoService, public dialog: MatDialog) {}

  atualizarTabela(): void {
    this.service.findAll().subscribe((alunos) => {
      this.alunos = alunos;
      console.log(this.alunos);
    });
  }
  ngOnInit(): void {
    this.atualizarTabela();
  }

  excluir(aluno: Aluno): void {
    const dialogRef = this.dialog.open(DeleteConfirmComponent, {
      data: {
        message: `Deseja realmente excluir o Aluno?`,
        buttonText: {
          ok: 'Excluir',
          cancel: 'Desistir',
        },
      },
    });

    dialogRef.afterClosed().subscribe((confirmed: boolean) => {
      if (confirmed) {
        this.service.delete(aluno).subscribe(() => {
          this.service.showMessage('Aluno excluído com sucesso');
          this.atualizarTabela();
        });
      }
    });
  }
}

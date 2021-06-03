import { Curso } from './../../../../model/curso.model';
import { CursoService } from './../../../../service/curso.service';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DeleteConfirmComponent } from 'src/app/component/template/delete-confirm/delete-confirm.component';

@Component({
  selector: 'app-curso-list',
  templateUrl: './curso-list.component.html',
  styleUrls: ['./curso-list.component.css'],
})
export class CursoListComponent implements OnInit {
  cursos: Curso[] = [];
  displayedColumns: string[] = ['id', 'nmCurso', 'acao'];
  constructor(private service: CursoService, public dialog: MatDialog) {}

  atualizarTabela(): void {
    this.service.findAll().subscribe((cursos: Curso[]) => {
      this.cursos = cursos;
      console.log(this.cursos);
    });
  }
  ngOnInit(): void {
    this.atualizarTabela();
  }

  excluir(curso: Curso): void {
    const dialogRef = this.dialog.open(DeleteConfirmComponent, {
      data: {
        message: `Deseja realmente excluir a disciplina ${curso.nmCurso}?`,
        buttonText: {
          ok: 'Excluir',
          cancel: 'Desistir',
        },
      },
    });

    dialogRef.afterClosed().subscribe((confirmed: boolean) => {
      if (confirmed) {
        this.service.delete(curso).subscribe(() => {
          this.service.showMessage('Disciplina excluída com sucesso');
          this.atualizarTabela();
        });
      }
    });
  }
}

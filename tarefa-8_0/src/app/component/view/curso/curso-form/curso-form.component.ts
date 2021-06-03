import { CursoService } from './../../../../service/curso.service';
import { Curso } from './../../../../model/curso.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-curso-form',
  templateUrl: './curso-form.component.html',
  styleUrls: ['./curso-form.component.css'],
})
export class CursoFormComponent implements OnInit {
  titulo: string = 'Cadastrar novo Curso';
  curso: Curso = {
    nmCurso: '',
  };

  constructor(private service: CursoService, private router: Router) {}

  ngOnInit(): void {}

  salvar(): void {
    this.service.create(this.curso).subscribe(() => {
      this.service.showMessage('Curso cadastrado com sucesso.');
      this.router.navigate(['/curso/list']);
    });
  }
}

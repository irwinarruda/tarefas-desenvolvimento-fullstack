import { Aluno } from '../../../../model/aluno.model';
import { Curso } from '../../../../model/curso.model';
import { Pessoa } from '../../../../model/pessoa.model';
import { AlunoService } from '../../../../service/aluno.service';
import { CursoService } from '../../../../service/curso.service';
import { PessoaService } from '../../../../service/pessoa.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-aluno-form',
  templateUrl: './aluno-form.component.html',
  styleUrls: ['./aluno-form.component.css'],
})
export class AlunoFormComponent implements OnInit {
  titulo: string = 'Cadastrar novo Aluno';
  aluno: Aluno = {
    ativo: false,
    dtInicio: null,
    curso: null,
    pessoa: null,
  };
  isChecked = false;
  cursos: Curso[] = [];
  pessoas: Pessoa[] = [];
  dtInicio: string;

  constructor(
    private service: AlunoService,
    private pessoaService: PessoaService,
    private cursoService: CursoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cursoService.findAll().subscribe((curso) => {
      this.cursos = curso;
    });

    this.pessoaService.findAll().subscribe((pessoas) => {
      this.pessoas = pessoas;
    });
  }

  salvar(): void {
    this.aluno.dtInicio = new Date(this.dtInicio);
    this.aluno.ativo = this.isChecked;

    this.service.create(this.aluno).subscribe(() => {
      this.service.showMessage('Aluno cadastrado com sucesso.');
      this.router.navigate(['/aluno/list']);
    });
  }

  onChange(): void {
    this.isChecked = !this.isChecked;
  }
}

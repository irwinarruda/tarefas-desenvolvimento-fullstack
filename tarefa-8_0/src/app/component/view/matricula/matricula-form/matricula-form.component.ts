import { Matricula } from '../../../../model/matricula.model';
import { MatriculaService } from './../../../../service/matricula.service';
import { Aluno } from '../../../../model/aluno.model';
import { AlunoService } from './../../../../service/aluno.service';
import { Oferta } from '../../../../model/oferta.model';
import { OfertaService } from './../../../../service/oferta.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-matricula-form',
  templateUrl: './matricula-form.component.html',
  styleUrls: ['./matricula-form.component.css'],
})
export class MatriculaFormComponent implements OnInit {
  titulo: string = 'Cadastrar nova Matrícula';
  matricula: Matricula = {
    aluno: null,
    oferta: null,
  };
  alunos: Aluno[] = [];
  ofertas: Oferta[] = [];
  dtInicio: string;

  constructor(
    private service: MatriculaService,
    private alunoService: AlunoService,
    private ofertaService: OfertaService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.alunoService.findAll().subscribe((aluno) => {
      this.alunos = aluno;
    });

    this.ofertaService.findAll().subscribe((oferta) => {
      this.ofertas = oferta;
    });
  }

  salvar(): void {
    this.service.create(this.matricula).subscribe(() => {
      this.service.showMessage('Matrícula cadastrada com sucesso.');
      this.router.navigate(['/matricula/list']);
    });
  }
}

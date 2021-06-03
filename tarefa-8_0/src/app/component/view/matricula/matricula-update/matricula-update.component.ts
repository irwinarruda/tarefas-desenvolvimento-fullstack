import { Matricula } from '../../../../model/matricula.model';
import { MatriculaService } from './../../../../service/matricula.service';
import { Aluno } from '../../../../model/aluno.model';
import { AlunoService } from './../../../../service/aluno.service';
import { Oferta } from '../../../../model/oferta.model';
import { OfertaService } from './../../../../service/oferta.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-matricula-update',
  templateUrl: './../matricula-form/matricula-form.component.html',
  styleUrls: ['./../matricula-form/matricula-form.component.css'],
})
export class MatriculaUpdateComponent implements OnInit {
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
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.alunoService.findAll().subscribe((aluno) => {
      this.alunos = aluno;
    });

    this.ofertaService.findAll().subscribe((oferta) => {
      this.ofertas = oferta;
    });

    let id = this.route.snapshot.paramMap.get('id');
    this.service.findById(id).subscribe((matricula) => {
      this.matricula = matricula;
    });
  }

  salvar(): void {
    this.service.create(this.matricula).subscribe(() => {
      this.service.showMessage('Matrícula cadastrada com sucesso.');
      this.router.navigate(['/matricula/list']);
    });
  }
}

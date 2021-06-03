import { Curso } from './../../../../model/curso.model';
import { CursoService } from './../../../../service/curso.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-curso-update',
  templateUrl: './../curso-form/curso-form.component.html',
  styleUrls: ['./../curso-form/curso-form.component.css'],
})
export class CursoUpdateComponent implements OnInit {
  curso: Curso;

  titulo: string = 'Alterar Dados do Curso';
  constructor(
    private route: ActivatedRoute,
    private service: CursoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    let id = this.route.snapshot.paramMap.get('id');
    this.service.findById(id).subscribe((curso) => {
      this.curso = curso;
    });
  }
  salvar(): void {
    this.service.update(this.curso).subscribe(() => {
      this.service.showMessage('Curso alterado com sucesso!');
      this.router.navigate(['/curso/list']);
    });
  }
}

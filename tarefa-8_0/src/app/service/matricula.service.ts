import { Matricula } from './../model/matricula.model';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root',
})
export class MatriculaService {
  urlBase: string = 'http://localhost:8080/matriculas/';
  constructor(private http: HttpClient, private snackBar: MatSnackBar) {}

  showMessage(msg: string, isError: boolean = false): void {
    this.snackBar.open(msg, 'Fechar', {
      verticalPosition: 'top',
      horizontalPosition: 'right',
      duration: 3000,
      panelClass: isError ? ['msg-error'] : ['msg-sucess'],
    });
  }

  // READ
  // FindAll

  findAll(): Observable<Matricula[]> {
    return this.http.get<Matricula[]>(this.urlBase);
  }
  // FindById

  findById(id: string): Observable<Matricula> {
    let url = `${this.urlBase}/${id}`;
    return this.http.get<Matricula>(url);
  }

  //CREATE

  create(matricula: Matricula): Observable<Matricula> {
    return this.http.post<Matricula>(this.urlBase, matricula);
  }

  // UPDATE

  update(matricula: Matricula): Observable<Matricula> {
    return this.http.put<Matricula>(this.urlBase, matricula);
  }

  // DELETE

  delete(matricula: Matricula): Observable<Matricula> {
    let url = `${this.urlBase}/${matricula.idMatricula}`;
    return this.http.delete<Matricula>(url);
  }
}

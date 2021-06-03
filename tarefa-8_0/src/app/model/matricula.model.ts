import { Aluno } from './aluno.model';
import { Oferta } from './oferta.model';

export interface Matricula {
  idMatricula?: number;
  aluno: Aluno;
  oferta: Oferta;
}

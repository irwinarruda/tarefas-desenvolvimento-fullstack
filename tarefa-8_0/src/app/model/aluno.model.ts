import { Curso } from './curso.model';
import { Pessoa } from './pessoa.model';

export interface Aluno {
  idAluno?: number;
  ativo: boolean;
  dtInicio: Date;
  curso: Curso;
  pessoa: Pessoa;
}

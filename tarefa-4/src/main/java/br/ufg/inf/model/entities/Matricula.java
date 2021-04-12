package br.ufg.inf.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_matricula")
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_matricula")
	private Integer idMatricula;
	@ManyToOne
	@JoinColumn(name="id_aluno")
	private Aluno aluno;
	@ManyToOne
	@JoinColumn(name="id_oferta")
	private Oferta oferta;

	public Matricula(Integer idMatricula, Aluno aluno, Oferta oferta) {
		super();
		this.idMatricula = idMatricula;
		this.aluno = aluno;
		this.oferta = oferta;
	}

	public Integer getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	@Override
	public String toString() {
		return "Matricula [idMatricula=" + idMatricula + ", aluno=" + aluno + ", oferta=" + oferta + "]";
	}

}

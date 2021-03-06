package ar.edu.uade.model;

import java.util.SortedSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import ar.edu.uade.dto.ColegioDTO;
import ar.edu.uade.dto.CursoDTO;

@Entity
public class Curso {


	private int id;
	private String descripcion;
	private int grado;
	private int vacantesDisponibles;
	private Colegio colegio;
	private SortedSet<Vacante> vacantes;

	
	public Curso() {
		
	}
	
	public Curso(CursoDTO dto) {
		this.id = dto.getId();
		this.descripcion = dto.getDescripcion();
		this.grado = dto.getGrado();
		this.vacantesDisponibles = dto.getVacantesDisponibles();
	}
	
	public Curso(CursoDTO dto, ColegioDTO colegioDTO) {
		this.id = dto.getId();
		this.descripcion = dto.getDescripcion();
		this.grado = dto.getGrado();
		this.vacantesDisponibles = dto.getVacantesDisponibles();
		this.colegio = new Colegio(colegioDTO);
	}
	
	public Curso(String descripcion, int grado, int vacanteDisponibles, Colegio colegio) {
		this.descripcion = descripcion;
		this.grado = grado;
		this.vacantesDisponibles = vacanteDisponibles;
		this.colegio = colegio;
	}
	
	public int grabar() {
		return 0;
	}
	
	public void modificar() {
		
	}
	
	public void eliminar() {
		
	}
	
	public CursoDTO toDTO() {
		CursoDTO dto = new CursoDTO(this.getDescripcion(), this.getGrado(), this.getVacantesDisponibles());
		dto.setId(this.id);
		dto.setColegio(new ColegioDTO(this.colegio.getId(), this.colegio.getNombre(), this.colegio.getDireccion(), null));
		return dto;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public int getVacantesDisponibles() {
		return vacantesDisponibles;
	}

	public void setVacantesDisponibles(int vacantesDisponibles) {
		this.vacantesDisponibles = vacantesDisponibles;
	}

	@ManyToOne
    @JoinColumn(name = "colegio_id")
	public Colegio getColegio() {
		return colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	@OneToMany(mappedBy = "curso")
	@OrderBy
	public SortedSet<Vacante> getVacantes() {
		return vacantes;
	}

	public void setVacantes(SortedSet<Vacante> vacantes) {
		this.vacantes = vacantes;
	}
}

package ar.edu.uade.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ar.edu.uade.dto.ColegioDTO;
import ar.edu.uade.dto.CursoDTO;

@Entity
public class Colegio {


	private int id;
	
	private String nombre;
	private String direccion;
	private Set<Curso> cursos;
	
	public Colegio() {
		
	}
	
	public Colegio(int id) {
		this.id = id;
	}
	
	public Colegio(ColegioDTO dto) {
		this.id = dto.getId();
		this.nombre = dto.getNombre();
		this.direccion = dto.getDireccion();
		
		if ( dto.getCursos() != null && dto.getCursos().size() > 0 ) {
			Set<Curso> cursos = new HashSet<Curso>();
			for (CursoDTO curso : dto.getCursos()) {
				Curso c = new Curso(curso);
				c.setColegio(new Colegio(dto.getId()));
				cursos.add(c);
			}
			this.cursos = cursos;
		}
	}
	
	public Colegio(String nombre, String direccion, Set<Curso> cursos) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.cursos = cursos;
	}
	
	public int grabar() {
		return 0;
	}
	
	public void modificar() {
		
	}
	
	public void eliminar() {
		
	}
	
	public void modificarVacantes(ColegioDTO dto) {
		
	}
	
	private Curso buscarCursoPorCodigo(int codigo) {
		return null;
	}
	
	public ColegioDTO toDTO() {
		Set<CursoDTO> dtoCursos = new HashSet<CursoDTO>();
		for (Curso curso : cursos) {
			dtoCursos.add(curso.toDTO());
		}
		ColegioDTO dto = new ColegioDTO(this.getId(), this.getNombre(), this.getDireccion(), dtoCursos);
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@OneToMany(mappedBy = "colegio", cascade = CascadeType.ALL)
	public Set<Curso> getCursos() {
		return cursos; 
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}	
}

package ar.edu.uade;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uade.dao.ColegioRepository;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.Curso;

@RestController
@RequestMapping("process")
public class GeneradorCursosMain {
	
	@Autowired
	ColegioRepository colRepo;
	
	@RequestMapping(value = "/cursos")
	public void cursos() {
		
		System.out.println("Empezado proceso generacion de cursos");
		
		List<Colegio> colegios = colRepo.findAll();
		System.out.println("Cant colegios: " + colegios.size());
		int i = 1;
		for (Colegio colegio : colegios) {
			System.out.println("Proceso colegio n " + i + " de " + colegios.size());
			
			Curso c1 = new Curso("Primer Grado", 1, 10, colegio);
			Curso c2 = new Curso("Segundo Grado", 2, 10, colegio);
			Curso c3 = new Curso("Tercero Grado", 3, 10, colegio);
			Curso c4 = new Curso("Cuarto Grado", 4, 10, colegio);
			Curso c5 = new Curso("Quinto Grado", 5, 10, colegio);
			Curso c6 = new Curso("Sexto Grado", 6, 10, colegio);
			Curso c7 = new Curso("Septimo Grado", 7, 10, colegio);
			
			Set<Curso> cursos = new HashSet<Curso>();
			cursos.add(c1);
			cursos.add(c2);
			cursos.add(c3);
			cursos.add(c4);
			cursos.add(c5);
			cursos.add(c6);
			cursos.add(c7);
			
			colegio.setCursos(cursos);
			
			colRepo.save(colegio);	
			i++;
		}
		
		System.out.println("Fin proceso generacion de cursos");
		
	}

}

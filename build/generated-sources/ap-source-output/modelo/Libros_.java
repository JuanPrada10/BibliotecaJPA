package modelo;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Autores;
import modelo.Editoriales;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-02T12:17:54", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Libros.class)
public class Libros_ { 

    public static volatile SingularAttribute<Libros, Integer> idLibro;
    public static volatile SingularAttribute<Libros, Autores> idAutor;
    public static volatile SingularAttribute<Libros, String> titulo;
    public static volatile SingularAttribute<Libros, Editoriales> idEditorial;
    public static volatile SingularAttribute<Libros, Date> fechaPublicacion;

}
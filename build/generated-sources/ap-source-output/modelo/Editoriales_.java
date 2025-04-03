package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Libros;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-02T21:16:02", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Editoriales.class)
public class Editoriales_ { 

    public static volatile ListAttribute<Editoriales, Libros> librosList;
    public static volatile SingularAttribute<Editoriales, Integer> idEditorial;
    public static volatile SingularAttribute<Editoriales, String> nombre;
    public static volatile SingularAttribute<Editoriales, String> pais;

}
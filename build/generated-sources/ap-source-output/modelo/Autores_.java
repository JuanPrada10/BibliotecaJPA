package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Libros;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-04-02T12:17:54", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Autores.class)
public class Autores_ { 

    public static volatile SingularAttribute<Autores, Integer> idAutor;
    public static volatile ListAttribute<Autores, Libros> librosList;
    public static volatile SingularAttribute<Autores, String> nombre;
    public static volatile SingularAttribute<Autores, String> pais;

}
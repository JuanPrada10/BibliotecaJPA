/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Estudiante
 */
@Entity
@Table(name = "libros")
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l"),
    @NamedQuery(name = "Libros.findByIdLibro", query = "SELECT l FROM Libros l WHERE l.idLibro = :idLibro"),
    @NamedQuery(name = "Libros.findByTitulo", query = "SELECT l FROM Libros l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libros.findByFechaPublicacion", query = "SELECT l FROM Libros l WHERE l.fechaPublicacion = :fechaPublicacion")})
public class Libros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_libro")
    private Integer idLibro;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @JoinColumn(name = "id_autor", referencedColumnName = "id_autor")
    @ManyToOne
    private Autores idAutor;
    @JoinColumn(name = "id_editorial", referencedColumnName = "id_editorial")
    @ManyToOne
    private Editoriales idEditorial;

    public Libros() {
    }

    public Libros(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Libros(Integer idLibro, String titulo) {
        this.idLibro = idLibro;
        this.titulo = titulo;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Autores getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autores idAutor) {
        this.idAutor = idAutor;
    }

    public Editoriales getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Editoriales idEditorial) {
        this.idEditorial = idEditorial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Libros[ idLibro=" + idLibro + " ]";
    }
    
}

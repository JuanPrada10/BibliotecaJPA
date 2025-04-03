/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Estudiante
 */
@Entity
@Table(name = "editoriales")
@NamedQueries({
    @NamedQuery(name = "Editoriales.findAll", query = "SELECT e FROM Editoriales e"),
    @NamedQuery(name = "Editoriales.findByIdEditorial", query = "SELECT e FROM Editoriales e WHERE e.idEditorial = :idEditorial"),
    @NamedQuery(name = "Editoriales.findByNombre", query = "SELECT e FROM Editoriales e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Editoriales.findByPais", query = "SELECT e FROM Editoriales e WHERE e.pais = :pais")})
public class Editoriales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_editorial")
    private Integer idEditorial;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "pais")
    private String pais;
    @OneToMany(mappedBy = "idEditorial")
    private List<Libros> librosList;

    public Editoriales() {
    }

    public Editoriales(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public Editoriales(String nombre, String pais) {
        this.pais=pais;
        this.nombre = nombre;
    }

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Libros> getLibrosList() {
        return librosList;
    }

    public void setLibrosList(List<Libros> librosList) {
        this.librosList = librosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEditorial != null ? idEditorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editoriales)) {
            return false;
        }
        Editoriales other = (Editoriales) object;
        if ((this.idEditorial == null && other.idEditorial != null) || (this.idEditorial != null && !this.idEditorial.equals(other.idEditorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Editoriales[ idEditorial=" + idEditorial + " ]";
    }
    
}

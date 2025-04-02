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
@Table(name = "autores")
@NamedQueries({
    @NamedQuery(name = "Autores.findAll", query = "SELECT a FROM Autores a"),
    @NamedQuery(name = "Autores.findByIdAutor", query = "SELECT a FROM Autores a WHERE a.idAutor = :idAutor"),
    @NamedQuery(name = "Autores.findByNombre", query = "SELECT a FROM Autores a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Autores.findByPais", query = "SELECT a FROM Autores a WHERE a.pais = :pais")})
public class Autores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_autor")
    private Integer idAutor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "pais")
    private String pais;
    @OneToMany(mappedBy = "idAutor")
    private List<Libros> librosList;

    public Autores() {
    }

    public Autores(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public Autores(Integer idAutor, String nombre) {
        this.idAutor = idAutor;
        this.nombre = nombre;
    }

    public Autores(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
    
    

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
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
        hash += (idAutor != null ? idAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autores)) {
            return false;
        }
        Autores other = (Autores) object;
        if ((this.idAutor == null && other.idAutor != null) || (this.idAutor != null && !this.idAutor.equals(other.idAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Autores[ idAutor=" + idAutor + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nemishappy
 */
@Entity
@Table(name = "VACCINELOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vaccinelog.findAll", query = "SELECT v FROM Vaccinelog v"),
    @NamedQuery(name = "Vaccinelog.findByVaccineid", query = "SELECT v FROM Vaccinelog v WHERE v.vaccineid = :vaccineid"),
    @NamedQuery(name = "Vaccinelog.findByName", query = "SELECT v FROM Vaccinelog v WHERE v.name = :name")})
public class Vaccinelog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VACCINEID")
    private Integer vaccineid;
    @Size(max = 10)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccineid")
    private Collection<Student> studentCollection;

    public Vaccinelog() {
    }

    public Vaccinelog(Integer vaccineid) {
        this.vaccineid = vaccineid;
    }

    public Integer getVaccineid() {
        return vaccineid;
    }

    public void setVaccineid(Integer vaccineid) {
        this.vaccineid = vaccineid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vaccineid != null ? vaccineid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vaccinelog)) {
            return false;
        }
        Vaccinelog other = (Vaccinelog) object;
        if ((this.vaccineid == null && other.vaccineid != null) || (this.vaccineid != null && !this.vaccineid.equals(other.vaccineid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vaccinelog[ vaccineid=" + vaccineid + " ]";
    }
    
}

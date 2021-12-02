/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nemishappy
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentid", query = "SELECT s FROM Student s WHERE s.studentid = :studentid"),
    @NamedQuery(name = "Student.findByVaccineno", query = "SELECT s FROM Student s WHERE s.vaccineno = :vaccineno")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENTID")
    private Integer studentid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VACCINENO")
    private int vaccineno;
    @JoinColumn(name = "VACCINEID", referencedColumnName = "VACCINEID")
    @ManyToOne(optional = false)
    private Vaccinelog vaccineid;

    public Student() {
    }

    public Student(Integer studentid) {
        this.studentid = studentid;
    }

    public Student(Integer studentid, int vaccineno) {
        this.studentid = studentid;
        this.vaccineno = vaccineno;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public int getVaccineno() {
        return vaccineno;
    }

    public void setVaccineno(int vaccineno) {
        this.vaccineno = vaccineno;
    }

    public Vaccinelog getVaccineid() {
        return vaccineid;
    }

    public void setVaccineid(Vaccinelog vaccineid) {
        this.vaccineid = vaccineid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Student[ studentid=" + studentid + " ]";
    }
    
}

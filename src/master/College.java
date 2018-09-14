package master;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import master.Student;
@Entity
public class College {
	@Id
	@Column(length=3)
	int clg_id;
	@Column(length=20)
	String clg_name;
	
	@OneToMany(targetEntity=Student.class, mappedBy="clgs")
	List<Student> students;

	public int getClg_id() {
		return clg_id;
	}

	public void setClg_id(int clg_id) {
		this.clg_id = clg_id;
	}

	public String getClg_name() {
		return clg_name;
	}

	public void setClg_name(String clg_name) {
		this.clg_name = clg_name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}

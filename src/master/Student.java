package master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@Column(length=3)
	int rollno;
	@Column(length=20)
	String sname;
	
	@ManyToOne
	@JoinColumn(name="clg_id") // names of the column
	College clgs;
	
	public College getClgs() {
		return clgs;
	}
	public void setClgs(College clgs) {
		this.clgs = clgs;
	}
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}

package master;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientApp {

	public static void main(String[] args) {
		
		Student student = new Student();
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		
		College college = new College();
		College college1 = new College();
		
		student.setRollno(1);
		student.setSname("Mitsuha Chan");
		student.setClgs(college1);
		
		student1.setRollno(2);
		student1.setSname("Airi");
		student1.setClgs(college1);
		
		student2.setRollno(3);
		student2.setSname("Light Yagmi");
		student2.setClgs(college);
		
		student3.setRollno(4);
		student3.setSname("Saitama");
		student3.setClgs(college);
		
		college.setClg_id(1);
		college.setClg_name("Tokyo University");
		
		college1.setClg_id(2);
		college1.setClg_name("Osaka University");
		
		SessionFactory sessfact=new Configuration().configure().buildSessionFactory();
		Session session=sessfact.openSession();
		session.beginTransaction();
		
		session.save(student);
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		session.save(college);
		session.save(college1);
		
		session.getTransaction().commit();
		String hql="select s.sname,c.clg_name from Student s join s.clgs c";
		Query query=session.createQuery(hql);
		List results=query.list();
		Iterator itr=results.iterator();
		while(itr.hasNext())
		{
			Object[] row=(Object[])itr.next();
			System.out.println(row[0]+"============>"+row[1]);
		}
	}

}

package dasturlash.uz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        // courses
        CourseEntity math = new CourseEntity();
        math.setTitle("Math");
        math.setDuration(6);
        session.save(math);

        CourseEntity java = new CourseEntity();
        java.setTitle("Java");
        java.setDuration(10);
        session.save(java);

        CourseEntity english = new CourseEntity();
        english.setTitle("English");
        english.setDuration(6);
        session.save(english);
        // students
        StudentEntity student1 = new StudentEntity();
        student1.setName("Alish");
        student1.setSurname("Aliyev");
        session.save(student1);

        StudentEntity student2 = new StudentEntity();
        student2.setName("Valish");
        student2.setSurname("Valiyev");
        session.save(student2);

        StudentEntity student3 = new StudentEntity();
        student3.setName("Toshmat");
        student3.setSurname("Toshmatov");
        session.save(student3);
        // student 1 courses
        StudentCourseEntity sc1 = new StudentCourseEntity();
        sc1.setStudent(student1);
        sc1.setCourse(math);
        sc1.setStartDate(LocalDate.now());
        session.save(sc1);

        StudentCourseEntity sc2 = new StudentCourseEntity();
        sc2.setStudent(student1);
        sc2.setCourse(java);
        sc2.setStartDate(LocalDate.now());
        session.save(sc2);

        StudentCourseEntity sc3 = new StudentCourseEntity();
        sc3.setStudent(student1);
        sc3.setCourse(english);
        sc3.setStartDate(LocalDate.now());
        session.save(sc3);

        // student 2 courses
        StudentCourseEntity sc4 = new StudentCourseEntity();
        sc4.setStudent(student2);
        sc4.setCourse(math);
        sc4.setStartDate(LocalDate.now());
        session.save(sc4);

        StudentCourseEntity sc5 = new StudentCourseEntity();
        sc5.setStudent(student2);
        sc5.setCourse(english);
        sc5.setStartDate(LocalDate.now());
        session.save(sc5);

        // student 3 courses
        StudentCourseEntity sc6 = new StudentCourseEntity();
        sc6.setStudent(student3);
        sc6.setCourse(math);
        sc6.setStartDate(LocalDate.now());
        session.save(sc6);

        StudentCourseEntity sc7 = new StudentCourseEntity();
        sc7.setStudent(student3);
        sc7.setCourse(java);
        sc7.setStartDate(LocalDate.now());
        session.save(sc7);

        t.commit();

        factory.close();
        session.close();
    }
}
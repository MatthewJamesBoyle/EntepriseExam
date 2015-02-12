package uk.boyle.examprep;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 * 
 */
public class App {

	public static SessionFactory sessionFactory = null;

	public static void main(String[] args) {

		try {
			// have we loaded the postgres driver?
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}

		try {
			// prepare a configuration file
			Configuration configuration = new Configuration();
			configuration.configure(); // useing hibernate.cfg.xml
			// create a service registry (for the factory)
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			// build the factory itself
			App.sessionFactory = configuration
					.buildSessionFactory(serviceRegistry);

			// App.enrolPatient("trialtest", "matt", "boyle", "MALE",
			// "06/10/1992");

			// App.patientVisit(1, 1, 100);
			App.patientReport(1);

		} catch (JDBCConnectionException e) {
			System.err.println(e.getSQLException().getMessage());
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			// close the factory
			if (App.sessionFactory != null) {
				App.sessionFactory.close();
			}
		}
		System.out.println("this worked");
	}

	public static void enrolPatient(String trialName, String pxName,
			String pxSurname, String gender, String dob) {
		Transaction tx = null;
		Date dobCheck = null;
		Patient patientToEnrol;
		Gender genderEnum = Gender.valueOf(gender.toUpperCase());
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dobCheck = date.parse(dob);
		} catch (ParseException e1) {
			System.out.println("date wasn't in a valid format");
		}

		// create a database session
		Session session = App.sessionFactory.openSession();
		Query q = session.createQuery("from Trial where name=:tname");
		q.setString("tname", trialName);
		List trial = q.list();
		if (trial.size() < 1) {
			throw new IllegalArgumentException("Trial wasn't a real one");

		}
		try {
			tx = session.beginTransaction();
			patientToEnrol = new Patient();
			patientToEnrol.setFirstName(pxName);
			patientToEnrol.setLastName(pxSurname);
			patientToEnrol.setDob(dobCheck);
			patientToEnrol.setGender(genderEnum);
			patientToEnrol.setTrial((Trial) trial.get(0));
			session.save(patientToEnrol);
			tx.commit();

			System.out
					.println("Enrolled the patient on the trial successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}

			throw e;
		} finally {
			session.close();
		}

	}

	public static void patientVisit(long idPx, long idDrug, long doseDrug) {
		Transaction tx = null;
		Session session = App.sessionFactory.openSession();
		Visit visit = null;

		// Check to see if the drug exists
		// Notice it is Drug and not drugs- it checks the class not db table
		Query q = session.createQuery("from Drug where id=:did");
		q.setLong("did", idDrug);
		List drug = q.list();
		if (drug.size() < 1) {
			throw new IllegalArgumentException(
					"Drug isn't registered in the database");
		}

		// Check to see if the patient exists
		// Object not tables
		Query q1 = session.createQuery("from Patient where id=:pid");
		q1.setLong("pid", idPx);
		List patient = q1.list();
		if (patient.size() < 1) {
			throw new IllegalArgumentException(
					"Patient isn't registered in the database");
		}

		try {
			tx = session.beginTransaction();
			visit = new Visit();
			// All things from db are returned as objects so must be cast
			visit.setPatient((Patient) patient.get(0));
			visit.setDrug((Drug) drug.get(0));
			visit.setDose(doseDrug);
			session.save(visit);
			tx.commit();

			System.out
					.println("Enrolled the patient on the trial successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}

			throw e;
		} finally {
			session.close();
			System.out.println("vist added");
		}

	}

	public static void patientReport(long id) {
		Session session = App.sessionFactory.openSession();
		Visit visit = null;

		// Check to see if the drug exists
		// Notice it is Drug and not drugs- it checks the class not db table
		Query q = session.createQuery("from Patient where id=:id");
		q.setLong("id", id);
		List px = q.list();
		if (px.size() < 1) {
			throw new IllegalArgumentException("Patient doesn't exist");
		}
		try {

			Patient p = (Patient) px.get(0);

			System.out.println(p.toString());

		} catch (HibernateException e) {
			throw e;
		} finally {
			session.close();
			System.out.println("px report should of printed");
		}

	}
}

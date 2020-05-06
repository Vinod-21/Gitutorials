package com.bridgelabz.fundoo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoo.model.Label;
import com.bridgelabz.fundoo.model.Login;
import com.bridgelabz.fundoo.model.Notes;
import com.bridgelabz.fundoo.model.User;

@SuppressWarnings("deprecation")
@Repository
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	private EntityManager entityManager;

	public RegisterDaoImpl() {
		System.out.println("RegisterDAOImpl working..!!");
	}

	@Override
	public void saves(User entity) {

		Session session = entityManager.unwrap(Session.class);

		session.save(entity);

		System.out.println("data saved succesfully into the server");

	}

	// like getByEmailAndPassword//
	public User login(Login login) {
		System.out.println("login DAO invoked");
		Session session = entityManager.unwrap(Session.class);

		String email = login.getEmail();
		String password = login.getPassword();
		Query query = session.createQuery("select t from User t where t.email= :email and t.password = :password");

		query.setParameter("email", login.getEmail());

		query.setParameter("password", login.getPassword());

		User user = (User) query.uniqueResult();

		System.out.println(user);

		return user;
	}

	public User getByEmail(String email) {
		System.out.println("getbyemail started in register dao");
		Session session = entityManager.unwrap(Session.class);
		User theUser = session.get(User.class, email);
		System.out.println("printing the getByEmail object");
		System.out.println(theUser);
		return theUser;

	}

	public List<User> getAllUser() {
		Session session = entityManager.unwrap(Session.class);
		Query<User> query = session.createQuery("FROM User", User.class);
		return query.getResultList();

	}

	public User findById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		User theUser = session.get(User.class, id);
		System.out.println("printing the getByid object******************************");
		System.out.println(theUser);
		return theUser;
	}

	public void save(List<Label> label) {
		System.out.println("save label method started in registerDAO");
		Session session = entityManager.unwrap(Session.class);

		session.save(label);

		System.out.println(" label data saved succesfully into the server");

	}

}

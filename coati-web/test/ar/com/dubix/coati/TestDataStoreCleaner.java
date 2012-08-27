package ar.com.dubix.coati;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;

import ar.com.dubix.coati.dao.CoatiDAO;

public class TestDataStoreCleaner extends CoatiDAO {

	public static void deleteAll(Class clazz) {
		java.util.Date iniciando = new java.util.Date();
		System.out.println("Iniciando en " + iniciando.getTime() + "...");
		Objectify ofy = getObjectifyService();
		System.out.println("Borrando la clase" + clazz.getCanonicalName() +
				" ...");
		Iterable<Key> allKeys = ofy.query(clazz).fetchKeys();
		ofy.delete(allKeys);
		java.util.Date terminando = new java.util.Date();
		long tiempo = terminando.getTime() - iniciando.getTime();
		System.out.println("Borradas todas las instancias en " + tiempo +
				"ms.");
	}
}

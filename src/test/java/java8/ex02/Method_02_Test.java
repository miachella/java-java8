package java8.ex02;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 02 - Redéfinition
 */
public class Method_02_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();

        public default String format() {
        	int nbPerson = 0;
        	for (Person person : findAll()) {
        		nbPerson = nbPerson + 1;
        	}
        	return "[" + nbPerson + " persons]";
        }
    }
    // end::IDao[]

    // tag::DaoA[]
    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

        @Override
        public String format() {
        	return "DaoA" + IDao.super.format();
        }

    }
    // end::DaoA[]

    @Test
    public void test_daoA_format() throws Exception {

        DaoA daoA = new DaoA();
        String result = daoA.format();

        assert "DaoA[20 persons]".equals(result);
    }
}

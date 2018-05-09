Aem-TU
========
TEST Unit est un framework open source pour le développement et l'exécution de tests unitaires automatisables. Le principal intérêt est de s'assurer que le code répond toujours aux besoins même après d'éventuelles modifications. Plus généralement, ce type de tests est appelé tests unitaires de non-régression.

JUnit propose :

Un Framework pour le développement des tests unitaires reposant sur des assertions qui testent les résultats attendus

Des applications pour permettre l'exécution des tests et afficher les résultats

Exemple :
--
        import static org.junit.jupiter.api.Assertions.assertEquals;

        import org.junit.jupiter.api.Test;

        public class MyTests {

         @Test
        public void multiplicationOfZeroIntegersShouldReturnZero() {
                MyClass tester = new MyClass(); // MyClass is tested

                // assert statements
                assertEquals(0, tester.multiply(10, 0), "10 x 0 must be 0");
                assertEquals(0, tester.multiply(0, 10), "0 x 10 must be 0");
                assertEquals(0, tester.multiply(0, 0), "0 x 0 must be 0");
             }
        }

Table 1. Annotations  JUnit 4	Description
--

import org.junit.*

Import statement for using the following annotations.

@Test

Identifies a method as a test method.

@Before

Executed before each test. It is used to prepare the test environment (e.g., read input data, initialize the class).

@After

Executed after each test. It is used to cleanup the test environment (e.g., delete temporary data, restore defaults). It can also save memory by cleaning up expensive memory structures.

@BeforeClass

Executed once, before the start of all tests. It is used to perform time intensive activities, for example, to connect to a database. Methods marked with this annotation need to be defined as static to work with JUnit.

@AfterClass

Executed once, after all tests have been finished. It is used to perform clean-up activities, for example, to disconnect from a database. Methods annotated with this annotation need to be defined as static to work with JUnit.

@Ignore or @Ignore("Why disabled")

Marks that the test should be disabled. This is useful when the underlying code has been changed and the test case has not yet been adapted. Or if the execution time of this test is too long to be included. It is best practice to provide the optional description, why the test is disabled.

@Test (expected = Exception.class)

Fails if the method does not throw the named exception.

@Test(timeout=100)

Fails if the method takes longer than 100 milliseconds

@Rule 

annotation. You can create objects which can be used and configured in your test methods. This adds more flexibility to your tests. You could, for example, specify which exception message you expect during the execution of your test code.


Practice
==

In this project we will show you how to test an AEM project
especially :

        -usesClass
        -slingModels


We have used slingMock and Mockito ans AssertJ to make assertion.

http://www.vogella.com/tutorials/Mockito/article.html

And AemContext to load Mock JCR Context with Json file (identite-jcr.json)

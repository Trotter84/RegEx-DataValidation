package CSC180.Trotter.Daniel;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest
		extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}


	public void test_isValidHumanName_Happy() {
		String testString = "Mr Daniel A Trotter";
		boolean result = new DataValidator().isValidHumanName(testString);
		assertTrue(result);
	}

	public void test_isValidHumanName_Sad() {
		String testString = "jane Mrs a Doe";
		boolean result = new DataValidator().isValidHumanName(testString);
		assertFalse(result);
	}

	public void test_isValidEmailAddress_Happy() {
		String testString = "dtrotter@neumont.edu";
		boolean result = new DataValidator().isValidEmailAddress(testString);
		assertTrue(result);
	}

	public void test_isValidEmailAddress_Sad() {
		String testString = "1two@three.com";
		boolean result = new DataValidator().isValidEmailAddress(testString);
		assertFalse(result);
	}

	public void test_isValidMovieBefore1995_Happy() {
		String testString = "Star Wars (1977)";
		boolean result = new DataValidator().isValidMovieBefore1995(testString);
		assertTrue(result);
	}

	public void test_isValidMovieBefore1995_Sad() {
		String testString = "Superbad (2007)";
		boolean result = new DataValidator().isValidMovieBefore1995(testString);
		assertFalse(result);
	}

	public void test_isValidSSN_Happy() {
		String testString = "123-45-6789";
		boolean result = new DataValidator().isValidSSN(testString);
		assertTrue(result);
	}

	public void test_isValidSSN_Sad() {
		String testString = "666-00-0000";
		boolean result = new DataValidator().isValidSSN(testString);
		assertFalse(result);
	}

	public void test_validatePasswordComplexity_Happy() {
		String testPassword = "hEl!0_t43rE";
		int testMinLength = 8;
		int testMinUpper = 2;
		int testMinLower = 2;
		int testNumeric = 2;
		int testMinSymbols = 2;

		boolean result = new DataValidator().validatePasswordComplexity(testPassword, testMinLength, testMinUpper, testMinLower, testNumeric, testMinSymbols);
		assertTrue(result);
	}

	public void test_validatePasswordComplexity_Sad() {
		String testPassword = "thisismypassword_12345";
		int testMinLength = 8;
		int testMinUpper = 2;
		int testMinLower = 2;
		int testNumeric = 2;
		int testMinSymbols = 2;

		boolean result = new DataValidator().validatePasswordComplexity(testPassword, testMinLength, testMinUpper, testMinLower, testNumeric, testMinSymbols);
		assertFalse(result);
	}

	public void test_getHTMLTagsContents_Happy() {
		String testString = "<div class=\"description user_content enhanced\" data-resource-type=\"assignment.body\" data-resource-id=\"39783302\"><div class=\"description user_content teacher-version enhanced\">\n" +
				"<p>For this assignment you will be creating a data validation class using Regular Expressions</p>\n" +
				"<p>There are 7 validations which your class must implement. You will find the specific functionality, name, and method signature for each required validator in this file:<a>RegExUtilityV2.java</a></p>\n" +
				"<p>Each validation method should have unit tests designed to test valid and invalid input into the method.</p>\n" +
				"<p>Please submit your entire project code:</p>\n" +
				"<p>&nbsp;</p>\n" +
				"</div></div>";
		String testTag = "p";

		String expectedString = "[For this assignment you will be creating a data validation class using Regular Expressions, There are 7 validations which your class must implement. You will find the specific functionality, name, and method signature for each required validator in this file:<a>RegExUtilityV2.java</a>, Each validation method should have unit tests designed to test valid and invalid input into the method., Please submit your entire project code:, &nbsp;]";

		String results = Arrays.toString(new DataValidator().getHTMLTagsContents(testString, testTag));

		assertEquals(expectedString, results);
	}

	public void test_getHTMLTagsContents_Sad() {
		String testString = "<div class=\"description user_content enhanced\" data-resource-type=\"assignment.body\" data-resource-id=\"39783302\"><div class=\"description user_content teacher-version enhanced\">\n" +
				"<h4>For this assignment you will be creating a data validation class using Regular Expressions</p>\n" +
				"<h4>There are 7 validations which your class must implement. You will find the specific functionality, name, and method signature for each required validator in this file:<a>RegExUtilityV2.java</a></p>\n" +
				"<h4>Each validation method should have unit tests designed to test valid and invalid input into the method.</p>\n" +
				"<h4>Please submit your entire project code:</h4>\n" +
				"<h4>&nbsp;</h4>\n" +
				"</div></div>";
		String testTag = "p";

		String expectedString = "[For this assignment you will be creating a data validation class using Regular Expressions, There are 7 validations which your class must implement. You will find the specific functionality, name, and method signature for each required validator in this file:<a>RegExUtilityV2.java</a>, Each validation method should have unit tests designed to test valid and invalid input into the method., Please submit your entire project code:, &nbsp;]";

		String results = Arrays.toString(new DataValidator().getHTMLTagsContents(testString, testTag));

		assertFalse(expectedString.equals(results));
	}

	public void test_getHTMLLinkURL_Happy() {
		String testString = "<div class=\"ic-app-nav-toggle-and-crumbs no-print\">\n" +
				"<button type=\"button\" id=\"courseMenuToggle\" class=\"Button Button--link ic-app-course-nav-toggle\" aria-live=\"polite\" aria-label=\"Show Courses Navigation Menu\">\n" +
				"<i class=\"icon-hamburger\" aria-hidden=\"true\"></i>\n" +
				"</button>\n" +
				"<div class=\"ic-app-crumbs ic-app-crumbs-enhanced-rubrics\">\n" +
				"<nav id=\"breadcrumbs\" role=\"navigation\" aria-label=\"breadcrumbs\"><ol><li class=\"home\"><a href=\"/\"><span class=\"ellipsible\"><i class=\"icon-home\" title=\"My Dashboard\"><span class=\"screenreader-only\">My Dashboard</span></i></span></a></li><li><a href=\"/courses/3631212\"><span class=\"ellipsible\">CSC180</span></a></li><li><a href=\"/courses/3631212/assignments\"><span class=\"ellipsible\">Assignments</span></a></li><li aria-current=\"page\"><a href=\"https://lms.neumont.edu/courses/3631212/assignments/39783302\"><span class=\"ellipsible\">RegEx - Data Validation [L2] </span></a></li></ol></nav>\n" +
				"</div>\n" +
				"<div id=\"nutrition_facts_container\"></div>\n" +
				"<div class=\"right-of-crumbs right-of-crumbs-no-reverse\">\n" +
				"<div id=\"ai-information-mount\"></div>\n" +
				"</div>\n" +
				"</div>";

		String expectedString = "[/, /courses/3631212, /courses/3631212/assignments, https://lms.neumont.edu/courses/3631212/assignments/39783302]";

		String results = Arrays.toString(new DataValidator().getHTMLLinkURL(testString));

		assertEquals(expectedString, results);
	}

	public void test_getHTMLLinkURL_Sad() {
		String testString = "<div class=\"ic-app-nav-toggle-and-crumbs no-print\">\n" +
				"<button type=\"button\" id=\"courseMenuToggle\" class=\"Button Button--link ic-app-course-nav-toggle\" aria-live=\"polite\" aria-label=\"Show Courses Navigation Menu\">\n" +
				"<i class=\"icon-hamburger\" aria-hidden=\"true\"></i>\n" +
				"</button>\n" +
				"<div class=\"ic-app-crumbs ic-app-crumbs-enhanced-rubrics\">\n" +
				"<div id=\"nutrition_facts_container\"></div>\n" +
				"<div class=\"right-of-crumbs right-of-crumbs-no-reverse\">\n" +
				"<div id=\"ai-information-mount\"></div>\n" +
				"</div>\n" +
				"</div>";

		String expectedString = "[/, /courses/3631212, /courses/3631212/assignments, https://lms.neumont.edu/courses/3631212/assignments/39783302]";

		String results = Arrays.toString(new DataValidator().getHTMLLinkURL(testString));

		assertFalse(expectedString.equals(results));
	}

}

package CSC180.Trotter.Daniel;

public interface RegExUtilityV2 {

	/**
	 * Be sure to account for middle name, middle initial, and prefix (Mr, Ms, Miss, Mrs, Dr).  Ensure proper capitalization.
	 *
	 * @param name the name to check
	 *
	 * @return true if valid; otherwise false
	 */
	boolean isValidHumanName(String name);


	/**
	 * Username must be at least 1 non-numeric character.  After the first character and before the '@' can be any alpha (any case)
	 * any numeric, and only the symbols '_' and '.'.
	 * The domain name section must contain at least a 1 character sub-domain.  Again the first character must be alpha (in either case)
	 * and the remaining characters can be alpha or numeric.  The top-level domain can be 3-4 alphanumeric characters of either case.
	 *
	 * @param email the email address to check
	 *
	 * @return true if valid; otherwise false
	 */
	boolean isValidEmailAddress(String email);


	/**
	 * Returns if movie title has a release year before 1995.
	 *
	 * @param movie in format: "Star Wars (1977)"
	 *
	 * @return true if valid; else false
	 */
	boolean isValidMovieBefore1995(String movie);


	/**
	 * A US compliant SSN
	 * Area (first 3 digits): 000 < n < 666 or 900-999
	 * Group (middle 2 digits): can't be 00
	 * Serial (last 4 digits): can't be 0000
	 *
	 * @param ssn
	 *
	 * @return
	 */
	boolean isValidSSN(String ssn);


	/**
	 * Validate that a given password matches the given complexity requirements
	 *
	 * @param password   the password to check
	 * @param minLength  the minimum length the password is allowed to be
	 * @param minUpper   the minimum number of upper case alpha characters the password must have
	 * @param minLower   the minimum number of lower case alpha characters the password must have
	 * @param minNumeric the minimum number of numeric characters the password must have
	 * @param minSymbols the minimum number of non-alphanumeric characters the password must have
	 *
	 * @return
	 */
	boolean validatePasswordComplexity(String password, int minLength, int minUpper, int minLower, int minNumeric, int minSymbols);


	/**
	 * Get the content of all occurrences of an HTML tag given its name and the html string in which it occurs
	 *
	 * @param html    the HTML string to be searched
	 * @param tagName the tagName for which the inner content should be returned
	 *
	 * @return
	 */
	String[] getHTMLTagsContents(String html, String tagName);


	/**
	 * For all occurrences of a link tag ("<a href=...") in the string html
	 * return the URL to which the link goes
	 *
	 * @param html the string to be searched
	 *
	 * @return an array of link destinations
	 */
	String[] getHTMLLinkURL(String html);
}

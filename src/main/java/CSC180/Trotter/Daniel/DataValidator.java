package CSC180.Trotter.Daniel;


public class DataValidator implements RegExUtilityV2 {
	public void run() {

	}

	@Override
	public boolean isValidHumanName(String name) {
		return false;
	}

	@Override
	public boolean isValidEmailAddress(String email) {
		return false;
	}

	@Override
	public boolean isValidMovieBefore1995(String movie) {
		return false;
	}

	@Override
	public boolean isValidSSN(String ssn) {
		return false;
	}

	@Override
	public boolean validatePasswordComplexity(String password, int minLength, int minUpper, int minLower, int minNumeric, int minSymbols) {
		return false;
	}

	@Override
	public String[] getHTMLTagsContents(String html, String tagName) {
		return new String[0];
	}

	@Override
	public String[] getHTMLLinkURL(String html) {
		return new String[0];
	}
}

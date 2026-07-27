package CSC180.Trotter.Daniel;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator implements RegExUtilityV2 {

	@Override
	public boolean isValidHumanName(String name) {
		String regex = "^(?:(Mrs|Miss|Ms|Mr|Dr)\\.? )?([A-Z][a-z]+)(?: ([A-Z][a-z]+|[A-Z]\\.?))? ([A-Z][a-z]+)$";
		return name.matches(regex);
	}

	@Override
	public boolean isValidEmailAddress(String email) {
		String regex = "^([A-Za-z][\\w.]*)@([A-Za-z][A-Za-z0-9]*)\\.([A-Za-z0-9]{3,4})$";
		return email.matches(regex);
	}

	@Override
	public boolean isValidMovieBefore1995(String movie) {
		String regex = "^.+\\((0\\d{3}|1[0-8]\\d{2}|19[0-8]\\d|199[0-4])\\)$";
		return movie.matches(regex);
	}

	@Override
	public boolean isValidSSN(String ssn) {
		String regex = "^(?!000|666)([0-8]\\d{2})-(?!00)(\\d{2})-(?!0000)(\\d{4})$";
		return ssn.matches(regex);
	}

	@Override
	public boolean validatePasswordComplexity(String password, int minLength, int minUpper, int minLower, int minNumeric, int minSymbols) {
		String regex = String.format(
				"^(?=(?:.*[A-Z]){%d,})(?=(?:.*[a-z]){%d,})(?=(?:.*[0-9]){%d,})(?=(?:.*[^A-Za-z0-9]){%d,}).{%d,}$",
				Math.max(0, minUpper), Math.max(0, minLower), Math.max(0, minNumeric),
				Math.max(0, minSymbols), Math.max(0, minLength)
		);
		return password.matches(regex);
	}

	@Override
	public String[] getHTMLTagsContents(String html, String tagName) {
		String escapedTag = Pattern.quote(tagName);
		String regex = "<" + escapedTag + "(?:\\s[^>]*)?>(.*?)</" + escapedTag + ">";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(html);

		List<String> htmlContents = new ArrayList<>();
		while (matcher.find()) {
			htmlContents.add(matcher.group(1));
		}

		return htmlContents.toArray(new String[0]);
	}

	@Override
	public String[] getHTMLLinkURL(String html) {
		String regex = "<a\\s+[^>]*?(?<![\\w-])href\\s*=\\s*([\";])(.*?)\\1[^>]*>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(html);

		List<String> urls = new ArrayList<>();
		while (matcher.find()) {
			urls.add(matcher.group(2));
		}

		return urls.toArray(new String[0]);
	}
}

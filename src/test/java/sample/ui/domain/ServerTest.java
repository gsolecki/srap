package sample.ui.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.util.ResourceUtils;

@RunWith(Parameterized.class)
public class ServerTest {

	@Parameter(0)
	public Boolean shouldRun;

	@Parameter(1)
	public Boolean shouldMatch;

	@Parameter(2)
	public String url;

	@Parameters(name = "Is run ''{0}'' and should match ''{1}'' for URL ''{2}'' ")
	public static Collection<Object[]> data() throws FileNotFoundException, IOException {

		Collection<Object[]> data = new ArrayList<>();

		List<String> lines = IOUtils.readLines(ResourceUtils.getURL("classpath:url_list.csv").openStream());
		for (String line : lines) {
			int index01 = line.indexOf(",");
			int index02 = line.indexOf(",", index01 + 1);
			Boolean shouldRun = Boolean.valueOf(line.substring(0, index01));
			Boolean shouldMatch = Boolean.valueOf(line.substring(index01, index02));
			String urlString = line.substring(index02 + 1, line.length());
			data.add(new Object[] { shouldRun, shouldMatch, urlString });
		}

		return data;
	}

	@Test
	public void shouldMatchThePattern() {

		// Given
		String urlRegex = "\\b(https?|ftp|file|ldap)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]*[-A-Za-z0-9+&@#/%=~_|]";

		// When
		boolean matches = url.matches(urlRegex);

		// Then
		if (shouldRun) {
			assertEquals(matches, shouldMatch);
		}
		assertFalse(!shouldRun && matches == shouldMatch);

	}
}

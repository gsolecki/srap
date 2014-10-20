package sample.ui.domain;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.util.ResourceUtils;

@RunWith(Parameterized.class)
public class ServerTest {

	@Parameter(0)
	public String url;

	@Parameter(1)
	public Boolean match;

	@Parameters(name = "URL ''{0}'' should match ''{1}''")
	public static Collection<Object[]> data() throws FileNotFoundException, IOException {

		Collection<Object[]> data = new ArrayList<>();

		List<String> lines = IOUtils.readLines(ResourceUtils.getURL("classpath:url_list.csv").openStream());
		for (String line : lines) {
			int index = line.indexOf(",");
			data.add(new Object[] { line.substring(index + 1, line.length()), Boolean.valueOf(line.substring(0, index))});
		}

		return data;
	}

	@Test
	@Ignore
	public void shouldMatchThePattern() {

		// Given
		String urlRegex = "\\b(https?|ftp|file|ldap)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]*[-A-Za-z0-9+&@#/%=~_|]";

		// When
		boolean matches = url.matches(urlRegex);

		// Then
		assertEquals(matches, match);

	}
}

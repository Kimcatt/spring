package examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class SimpleMovieLister {
	private MovieFinder movieFinder;
	private String defaultLocale;

	@Autowired
	public void configure(MovieFinder movieFinder,
			@Value("#{ systemProperties['user.region'] }") String defaultLocale) {
		this.movieFinder = movieFinder;
		this.defaultLocale = defaultLocale;
	}
	// ...
}

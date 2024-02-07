package com.upstream_mobility_itacademy.bored.boredShell;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BoredShellIntegrationTests {

    @Autowired
	ShellTestClient client;

	@Test
	void test() {
		InteractiveShellSession session = client
				.interactive()
				.run();

		await().atMost(2, TimeUnit.SECONDS).untilAsserted(() -> {
			ShellAssertions.assertThat(session.screen())
				.containsText("shell");
		});

		session.write(session.writeSequence().text("help").carriageReturn().build());
		await().atMost(2, TimeUnit.SECONDS).untilAsserted(() -> {
			ShellAssertions.assertThat(session.screen())
				.containsText("AVAILABLE COMMANDS");
		});
	}
}
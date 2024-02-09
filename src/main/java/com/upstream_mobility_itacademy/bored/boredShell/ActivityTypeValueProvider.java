 package com.upstream_mobility_itacademy.bored.boredShell;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.shell.CompletionContext;
import org.springframework.shell.CompletionProposal;
import org.springframework.shell.standard.ValueProvider;
import org.springframework.stereotype.Component;

@Component
public class ActivityTypeValueProvider implements ValueProvider{

	@Override
	public List<CompletionProposal> complete(CompletionContext completionContext) {
		return Arrays.asList("education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music", "busywork").stream()
			.map(CompletionProposal::new)
			.collect(Collectors.toList());
	}

    
}
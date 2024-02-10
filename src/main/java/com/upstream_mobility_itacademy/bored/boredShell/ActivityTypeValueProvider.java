package com.upstream_mobility_itacademy.bored.boredShell;

import com.upstream_mobility_itacademy.bored.model.ActivitiyTypes;
import com.upstream_mobility_itacademy.bored.util.Generated;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.shell.CompletionContext;
import org.springframework.shell.CompletionProposal;
import org.springframework.shell.standard.ValueProvider;
import org.springframework.stereotype.Component;

@Generated
@Component
public class ActivityTypeValueProvider implements ValueProvider {

  @Override
  public List<CompletionProposal> complete(
    CompletionContext completionContext
  ) {
    return Arrays
      .asList(
        ActivitiyTypes.EDUCATION.toString(),
        ActivitiyTypes.RECREATIONAL.toString(),
        ActivitiyTypes.SOCIAL.toString(),
        ActivitiyTypes.DIY.toString(),
        ActivitiyTypes.CHARITY.toString(),
        ActivitiyTypes.COOKING.toString(),
        ActivitiyTypes.RELAXATION.toString(),
        ActivitiyTypes.MUSIC.toString(),
        ActivitiyTypes.BUSYWORK.toString()
      )
      .stream()
      .map(CompletionProposal::new)
      .collect(Collectors.toList());
  }
}

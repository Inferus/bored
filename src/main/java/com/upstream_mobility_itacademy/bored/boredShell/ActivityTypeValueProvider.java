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
        ActivitiyTypes.EDUCATION.getType(),
        ActivitiyTypes.RECREATIONAL.getType(),
        ActivitiyTypes.SOCIAL.getType(),
        ActivitiyTypes.DIY.getType(),
        ActivitiyTypes.CHARITY.getType(),
        ActivitiyTypes.COOKING.getType(),
        ActivitiyTypes.RELAXATION.getType(),
        ActivitiyTypes.MUSIC.getType(),
        ActivitiyTypes.BUSYWORK.getType()
      )
      .stream()
      .map(CompletionProposal::new)
      .collect(Collectors.toList());
  }
}

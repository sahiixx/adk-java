package com.google.adk.tools;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class ToolConfirmationTest {

  @Test
  public void builder_setsDefaultValues() {
    ToolConfirmation toolConfirmation = ToolConfirmation.builder().build();

    assertThat(toolConfirmation.hint()).isEmpty();
    assertThat(toolConfirmation.confirmed()).isFalse();
    assertThat(toolConfirmation.payload()).isNull();
  }

  @Test
  public void builder_setsValues() {
    ToolConfirmation toolConfirmation =
        ToolConfirmation.builder().hint("hint").confirmed(true).payload("payload").build();

    assertThat(toolConfirmation.hint()).isEqualTo("hint");
    assertThat(toolConfirmation.confirmed()).isTrue();
    assertThat(toolConfirmation.payload()).isEqualTo("payload");
  }

  @Test
  public void toBuilder_createsBuilderWithSameValues() {
    ToolConfirmation toolConfirmation =
        ToolConfirmation.builder().hint("hint").confirmed(true).payload("payload").build();
    ToolConfirmation copiedToolConfirmation = toolConfirmation.toBuilder().build();

    assertThat(copiedToolConfirmation).isEqualTo(toolConfirmation);
  }
}

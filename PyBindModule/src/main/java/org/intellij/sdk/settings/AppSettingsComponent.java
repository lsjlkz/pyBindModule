// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.settings;

import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Supports creating and managing a {@link JPanel} for the Settings Dialog.
 */
public class AppSettingsComponent {

  private final JPanel myMainPanel;
  private final JBTextField myObjectSetting_1 = new JBTextField();
  private final JBTextField myObjectSetting_2 = new JBTextField();
  private final JBTextField myObjectSetting_3 = new JBTextField();
  private final JBTextField myObjectSetting_4 = new JBTextField();
  private final JBTextField myObjectSetting_5 = new JBTextField();
  private final JBTextField myObjectSetting_6 = new JBTextField();
  private final JBTextField myObjectSetting_7 = new JBTextField();
  private final JBTextField myObjectSetting_8 = new JBTextField();
  private final JBTextField myObjectSetting_9 = new JBTextField();
  private final JBTextField myObjectSetting_10 = new JBTextField();
  private final JBTextField myObjectSetting_11 = new JBTextField();
  private final JBTextField myObjectSetting_12 = new JBTextField();
  private final JBTextField myObjectSetting_13 = new JBTextField();
  private final JBTextField myObjectSetting_14 = new JBTextField();
  private final JBTextField myObjectSetting_15 = new JBTextField();

  public AppSettingsComponent() {
    myMainPanel = FormBuilder.createFormBuilder()
            .addLabeledComponent(new JBLabel("设置后应重启"), new JBLabel(),1, false)
            .addLabeledComponent(new JBLabel("绑定1"), myObjectSetting_1, 1, false)
            .addLabeledComponent(new JBLabel("绑定2"), myObjectSetting_2, 1, false)
            .addLabeledComponent(new JBLabel("绑定3"), myObjectSetting_3, 1, false)
            .addLabeledComponent(new JBLabel("绑定4"), myObjectSetting_4, 1, false)
            .addLabeledComponent(new JBLabel("绑定5"), myObjectSetting_5, 1, false)
            .addLabeledComponent(new JBLabel("绑定6"), myObjectSetting_6, 1, false)
            .addLabeledComponent(new JBLabel("绑定7"), myObjectSetting_7, 1, false)
            .addLabeledComponent(new JBLabel("绑定8"), myObjectSetting_8, 1, false)
            .addLabeledComponent(new JBLabel("绑定9"), myObjectSetting_9, 1, false)
            .addLabeledComponent(new JBLabel("绑定10"), myObjectSetting_10, 1, false)
            .addLabeledComponent(new JBLabel("绑定11"), myObjectSetting_11, 1, false)
            .addLabeledComponent(new JBLabel("绑定12"), myObjectSetting_12, 1, false)
            .addLabeledComponent(new JBLabel("绑定13"), myObjectSetting_13, 1, false)
            .addLabeledComponent(new JBLabel("绑定14"), myObjectSetting_14, 1, false)
            .addLabeledComponent(new JBLabel("绑定15"), myObjectSetting_15, 1, false)
            .addComponentFillVertically(new JPanel(), 0)
            .getPanel();
  }

  public JPanel getPanel() {
    return myMainPanel;
  }

  public JComponent getPreferredFocusedComponent() {
    return myObjectSetting_1;
  }

  @NotNull
  public String getObjectSetting_1() {
    return myObjectSetting_1.getText();
  }

  public void setObjectSetting_1(@NotNull String newText) {
    myObjectSetting_1.setText(newText);
  }

  @NotNull
  public String getObjectSetting_2() {
    return myObjectSetting_2.getText();
  }

  public void setObjectSetting_2(@NotNull String newText) {
    myObjectSetting_2.setText(newText);
  }

  @NotNull
  public String getObjectSetting_3() {
    return myObjectSetting_3.getText();
  }

  public void setObjectSetting_3(@NotNull String newText) {
    myObjectSetting_3.setText(newText);
  }

  @NotNull
  public String getObjectSetting_4() {
    return myObjectSetting_4.getText();
  }

  public void setObjectSetting_4(@NotNull String newText) {
    myObjectSetting_4.setText(newText);
  }

  @NotNull
  public String getObjectSetting_5() {
    return myObjectSetting_5.getText();
  }

  public void setObjectSetting_5(@NotNull String newText) {
    myObjectSetting_5.setText(newText);
  }

  @NotNull
  public String getObjectSetting_6() {
    return myObjectSetting_6.getText();
  }

  public void setObjectSetting_6(@NotNull String newText) {
    myObjectSetting_6.setText(newText);
  }

  @NotNull
  public String getObjectSetting_7() {
    return myObjectSetting_7.getText();
  }

  public void setObjectSetting_7(@NotNull String newText) {
    myObjectSetting_7.setText(newText);
  }

  @NotNull
  public String getObjectSetting_8() {
    return myObjectSetting_8.getText();
  }

  public void setObjectSetting_8(@NotNull String newText) {
    myObjectSetting_8.setText(newText);
  }

  @NotNull
  public String getObjectSetting_9() {
    return myObjectSetting_9.getText();
  }

  public void setObjectSetting_9(@NotNull String newText) {
    myObjectSetting_9.setText(newText);
  }

  @NotNull
  public String getObjectSetting_10() {
    return myObjectSetting_10.getText();
  }

  public void setObjectSetting_10(@NotNull String newText) {
    myObjectSetting_10.setText(newText);
  }

  @NotNull
  public String getObjectSetting_11() {
    return myObjectSetting_11.getText();
  }

  public void setObjectSetting_11(@NotNull String newText) {
    myObjectSetting_11.setText(newText);
  }

  @NotNull
  public String getObjectSetting_12() {
    return myObjectSetting_12.getText();
  }

  public void setObjectSetting_12(@NotNull String newText) {
    myObjectSetting_12.setText(newText);
  }

  @NotNull
  public String getObjectSetting_13() {
    return myObjectSetting_13.getText();
  }

  public void setObjectSetting_13(@NotNull String newText) {
    myObjectSetting_13.setText(newText);
  }

  @NotNull
  public String getObjectSetting_14() {
    return myObjectSetting_14.getText();
  }

  public void setObjectSetting_14(@NotNull String newText) {
    myObjectSetting_14.setText(newText);
  }

  @NotNull
  public String getObjectSetting_15() {
    return myObjectSetting_15.getText();
  }

  public void setObjectSetting_15(@NotNull String newText) {
    myObjectSetting_15.setText(newText);
  }

}


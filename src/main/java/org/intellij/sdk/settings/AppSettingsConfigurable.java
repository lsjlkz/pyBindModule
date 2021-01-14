// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Provides controller functionality for application settings.
 */
public class AppSettingsConfigurable implements Configurable {

  private AppSettingsComponent mySettingsComponent;

  // A default constructor with no arguments is required because this implementation
  // is registered as an applicationConfigurable EP

  @Nls(capitalization = Nls.Capitalization.Title)
  @Override
  public String getDisplayName() {
    return "PyBindModule";
  }

  @Override
  public JComponent getPreferredFocusedComponent() {
    return mySettingsComponent.getPreferredFocusedComponent();
  }

  @Nullable
  @Override
  public JComponent createComponent() {
    mySettingsComponent = new AppSettingsComponent();
    return mySettingsComponent.getPanel();
  }

  @Override
  public boolean isModified() {
    AppSettingsState settings = AppSettingsState.getInstance();
    boolean modified = !mySettingsComponent.getObjectSetting_1().equals(settings.myObjectSetting_1);
    modified |= !mySettingsComponent.getObjectSetting_2().equals(settings.myObjectSetting_2);
    modified |= !mySettingsComponent.getObjectSetting_3().equals(settings.myObjectSetting_3);
    modified |= !mySettingsComponent.getObjectSetting_4().equals(settings.myObjectSetting_4);
    modified |= !mySettingsComponent.getObjectSetting_5().equals(settings.myObjectSetting_5);
    modified |= !mySettingsComponent.getObjectSetting_6().equals(settings.myObjectSetting_6);
    modified |= !mySettingsComponent.getObjectSetting_7().equals(settings.myObjectSetting_7);
    modified |= !mySettingsComponent.getObjectSetting_8().equals(settings.myObjectSetting_8);
    modified |= !mySettingsComponent.getObjectSetting_9().equals(settings.myObjectSetting_9);
    modified |= !mySettingsComponent.getObjectSetting_10().equals(settings.myObjectSetting_10);
    modified |= !mySettingsComponent.getObjectSetting_11().equals(settings.myObjectSetting_11);
    modified |= !mySettingsComponent.getObjectSetting_12().equals(settings.myObjectSetting_12);
    modified |= !mySettingsComponent.getObjectSetting_13().equals(settings.myObjectSetting_13);
    modified |= !mySettingsComponent.getObjectSetting_14().equals(settings.myObjectSetting_14);
    modified |= !mySettingsComponent.getObjectSetting_15().equals(settings.myObjectSetting_15);
    return modified;
  }

  @Override
  public void apply() {
    AppSettingsState settings = AppSettingsState.getInstance();
    settings.myObjectSetting_1 = mySettingsComponent.getObjectSetting_1();
    settings.myObjectSetting_2 = mySettingsComponent.getObjectSetting_2();
    settings.myObjectSetting_3 = mySettingsComponent.getObjectSetting_3();
    settings.myObjectSetting_4 = mySettingsComponent.getObjectSetting_4();
    settings.myObjectSetting_5 = mySettingsComponent.getObjectSetting_5();
    settings.myObjectSetting_6 = mySettingsComponent.getObjectSetting_6();
    settings.myObjectSetting_7 = mySettingsComponent.getObjectSetting_7();
    settings.myObjectSetting_8 = mySettingsComponent.getObjectSetting_8();
    settings.myObjectSetting_9 = mySettingsComponent.getObjectSetting_9();
    settings.myObjectSetting_10 = mySettingsComponent.getObjectSetting_10();
    settings.myObjectSetting_11 = mySettingsComponent.getObjectSetting_11();
    settings.myObjectSetting_12 = mySettingsComponent.getObjectSetting_12();
    settings.myObjectSetting_13 = mySettingsComponent.getObjectSetting_13();
    settings.myObjectSetting_14 = mySettingsComponent.getObjectSetting_14();
    settings.myObjectSetting_15 = mySettingsComponent.getObjectSetting_15();
  }

  @Override
  public void reset() {
    AppSettingsState settings = AppSettingsState.getInstance();
    mySettingsComponent.setObjectSetting_1(settings.myObjectSetting_1);
    mySettingsComponent.setObjectSetting_2(settings.myObjectSetting_2);
    mySettingsComponent.setObjectSetting_3(settings.myObjectSetting_3);
    mySettingsComponent.setObjectSetting_4(settings.myObjectSetting_4);
    mySettingsComponent.setObjectSetting_5(settings.myObjectSetting_5);
    mySettingsComponent.setObjectSetting_6(settings.myObjectSetting_6);
    mySettingsComponent.setObjectSetting_7(settings.myObjectSetting_7);
    mySettingsComponent.setObjectSetting_8(settings.myObjectSetting_8);
    mySettingsComponent.setObjectSetting_9(settings.myObjectSetting_9);
    mySettingsComponent.setObjectSetting_10(settings.myObjectSetting_10);
    mySettingsComponent.setObjectSetting_11(settings.myObjectSetting_11);
    mySettingsComponent.setObjectSetting_12(settings.myObjectSetting_12);
    mySettingsComponent.setObjectSetting_13(settings.myObjectSetting_13);
    mySettingsComponent.setObjectSetting_14(settings.myObjectSetting_14);
    mySettingsComponent.setObjectSetting_15(settings.myObjectSetting_15);
  }

  @Override
  public void disposeUIResources() {
    mySettingsComponent = null;
  }

}
// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Supports storing the application settings in a persistent way.
 * The {@link State} and {@link Storage} annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 */
@State(
        name = "org.intellij.sdk.settings.AppSettingsState",
        storages = {@Storage("SdkSettingsPlugin.xml")}
)
public class AppSettingsState implements PersistentStateComponent<AppSettingsState> {
  public String myObjectSetting_1 = "role;Develop/PyHelp/C/cRoleClass.py;cRoleClass;false;2";
  public String myObjectSetting_2 = "union;Develop/PyCode/Logic/Game/Union/UnionClass/UnionClass.py;UnionClass;false;0";
  public String myObjectSetting_3 = "hero;Develop/PyCode/Logic/Game/Hero/HeroClass.py;HeroClass;false;0";
  public String myObjectSetting_4 = "bag;Develop/PyCode/Logic/Game/Bag/BagClass.py;SimpleBag;false;0";
  public String myObjectSetting_5 = "";
  public String myObjectSetting_6 = "";
  public String myObjectSetting_7 = "";
  public String myObjectSetting_8 = "";
  public String myObjectSetting_9 = "";
  public String myObjectSetting_10 = "";

  public static AppSettingsState getInstance() {
    return ServiceManager.getService(AppSettingsState.class);
  }

  @Nullable
  @Override
  public AppSettingsState getState() {
    return this;
  }

  @Override
  public void loadState(@NotNull AppSettingsState state) {
    XmlSerializerUtil.copyBean(state, this);
  }

}

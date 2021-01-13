package org.intellij.sdk.language;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.apache.commons.lang.StringUtils;
import org.intellij.sdk.settings.AppSettingsComponent;
import org.intellij.sdk.settings.AppSettingsState;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.intellij.sdk.language.CommonString.*;


public class PyCompletionContributor extends CompletionContributor {
    public PyCompletionContributor(){
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                if(parameters.getOffset() < 5){
                    System.out.println();
                    return;
                }
                TextRange t = TextRange.from(parameters.getOffset() - 1, 1);
                if(!parameters.getEditor().getDocument().getText(t).equals(DOT)){
                    return;
                }
                AppSettingsState settings = AppSettingsState.getInstance();
                //String[] config = settings.myObjectSetting_1.split(":");
                String[] config = getConfig(parameters.getEditor().getDocument(), parameters.getOffset());
                if(config == null){
                    //System.out.println();
                    return;
                }
                String projectPath = parameters.getOriginalFile().getVirtualFile().getPresentableUrl().toString();
                String developPath = "";
                String cRolePath = "";
                if(Boolean.parseBoolean(config[3])){
                    cRolePath = config[1];
                }else{
                    int idx = projectPath.indexOf(DEVELOP);
                    if(idx != -1){
                        developPath = projectPath.substring(0, idx);
                    }else{
                        developPath = projectPath;
                    }
                    cRolePath = developPath + config[1];
                }
                String cRoleFilePath = cRolePath.replace("/", "\\");
                File f = new File(cRoleFilePath);
                if(f.canRead()){
                    try {
                        InputStreamReader reader = new InputStreamReader(new FileInputStream(f), Charset.forName("UTF-8"));
                        BufferedReader bufferedReader = new BufferedReader(reader);
                        String line = "";
                        line = bufferedReader.readLine();
                        int lineIdx = -1;
                        int lastFuncIdx = 10000;
                        String lastFuncName = "";
                        boolean flag = false;
                        while (line != null) {
                            //System.out.println();
                            lineIdx ++;
                            line = bufferedReader.readLine();
                            if(line == null){
                                //System.out.println();
                                break;
                            }
                            if(line.indexOf(CLASS)!= -1){
                                if(flag){
                                    //System.out.println();
                                    break;
                                }else{
                                    int idx_l = line.indexOf(CLASS);
                                    int idx_r = line.indexOf(LEFT);
                                    if(line.substring(idx_l + CLASS.length() + 1, idx_r).equals(config[2])){
                                        //System.out.println();
                                        flag = true;
                                    }
                                }
                            }
                            if(!flag){
                                //System.out.println();
                                continue;
                            }
                            String funcName = "";
                            if(line.indexOf(DEF) != -1){
                                funcName = getDef(line);
                                //System.out.println();
                                if(funcName == null){
                                    continue;
                                }
                                //System.out.println();
                                lastFuncName = funcName;
                                lastFuncIdx = lineIdx;
                            }
                            if(lineIdx != lastFuncIdx + Integer.parseInt(config[4])){
                                //System.out.println();
                                continue;
                            }
                            //System.out.println();
                            //System.out.println(funcName);
                            result.addElement(LookupElementBuilder.create(lastFuncName).withTypeText(line));
                        }
                    } catch (IOException e) {
                        //System.out.println();
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    private String getDef(String line){
        int defIdx = line.indexOf(DEF);
        int idx = line.indexOf(LEFT);
        return line.substring(defIdx + 4, idx).concat(LEFT + RIGHT);
    }

    private String[] getConfig(Document input, int offset){
        AppSettingsState settings = AppSettingsState.getInstance();
        List<String> configList = new ArrayList<String>();
        configList.add(settings.myObjectSetting_1);
        configList.add(settings.myObjectSetting_2);
        configList.add(settings.myObjectSetting_3);
        configList.add(settings.myObjectSetting_4);
        configList.add(settings.myObjectSetting_5);
        configList.add(settings.myObjectSetting_6);
        configList.add(settings.myObjectSetting_7);
        configList.add(settings.myObjectSetting_8);
        configList.add(settings.myObjectSetting_9);
        configList.add(settings.myObjectSetting_10);
        for(String config: configList) {
            if (config.equals("")) {
                continue;
            } else {
                String[] tmp;
                tmp = config.split(SEPARATOR);
                TextRange t = TextRange.from(offset - (tmp[0].length() + 1), tmp[0].length() + 1);
                if (!input.getText(t).equals(tmp[0] + DOT)) {
                    continue;
                } else {
                    return tmp;
                }
            }
        }
        return null;
    }
}


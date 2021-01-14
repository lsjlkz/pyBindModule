package org.intellij.sdk.language;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.settings.AppSettingsState;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.intellij.sdk.language.CommonString.*;


public class PyCompletionContributor extends CompletionContributor {
    public PyCompletionContributor(){
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                TextRange t = TextRange.from(parameters.getOffset() - 1, 1);
                if(!parameters.getEditor().getDocument().getText(t).equals(DOT)){
                    return;
                }
                process(parameters, result);
            }
        });
    }

    private void process(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        ArrayList<String[]> config_array = getConfig(parameters);
        for(String[] config:config_array) {
            if(config == null){
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
            ArrayList<String[]> ele = new ArrayList<String[]>();
            String lastFuncName = "";
            String line = "";
            int offSet = Integer.parseInt(config[4]);
            if(f.canRead()){
                try {
                    InputStreamReader reader = new InputStreamReader(new FileInputStream(f), Charset.forName("UTF-8"));
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    line = bufferedReader.readLine();
                    int lineIdx = -1;
                    int lastFuncIdx = 10000;
                    boolean flag = false;
                    int t = 0;
                    while (line != null) {
                        lineIdx ++;
                        line = bufferedReader.readLine();
                        if(line == null){
                            break;
                        }
                        if(line.contains(CLASS)){
                            if(flag){
                                break;
                            }else{
                                int idx_l = line.indexOf(CLASS);
                                int idx_r = line.indexOf(LEFT);
                                if(line.substring(idx_l + CLASS.length() + 1, idx_r).equals(config[2])){
                                    flag = true;
                                }
                            }
                        }
                        if(!flag){
                            continue;
                        }
                        String funcName = "";
                        if(line.contains(DEF)){
                            if(t == 0){
                                t = line.indexOf(DEF);
                            }else if(t != line.indexOf(DEF)){
                                break;
                            }
                            funcName = getDef(line, t);
                            if(funcName == null || funcName.startsWith(UNDER)){
                                continue;
                            }
                            lastFuncName = funcName;
                            lastFuncIdx = lineIdx;
                        }
                        if(lineIdx != lastFuncIdx + offSet){
                            continue;
                        }
                        ele.add(new String[]{lastFuncName, line});
                        lastFuncName = "";
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            for(String[] e:ele){
                result.addElement(LookupElementBuilder.create(e[0]).withTypeText(e[1]));
            }
            if(!lastFuncName.isEmpty()){
                result.addElement(LookupElementBuilder.create(lastFuncName));
            }
        }
    }

    private String getDef(String line, int defIdx){
        int idx = line.indexOf(LEFT);
        return line.substring(defIdx + 4, idx).concat(LEFT + RIGHT);
    }

    private ArrayList<String[]> getConfig(@NotNull CompletionParameters parameters){
        ArrayList<String[]> res = new ArrayList<String[]>();
        Document input = parameters.getEditor().getDocument();
        int offset = parameters.getOffset();
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
        configList.add(settings.myObjectSetting_11);
        configList.add(settings.myObjectSetting_12);
        configList.add(settings.myObjectSetting_13);
        configList.add(settings.myObjectSetting_14);
        configList.add(settings.myObjectSetting_15);
        for(String config: configList) {
            if (config.isEmpty()) {
                continue;
            }
            String[] tmp;
            tmp = config.split(SEPARATOR);
            if(tmp.length > 5){
                String path = parameters.getOriginalFile().getVirtualFile().getPresentableUrl().toString();
                if(!canAddToRes(path, tmp[5])){
                    continue;
                }
            }
            if(offset - 1 < tmp[0].length()){
                continue;
            }
            TextRange t = TextRange.from(offset - (tmp[0].length() + 1), tmp[0].length());
            if (!input.getText(t).equals(tmp[0])) {
                continue;
            }
            res.add(tmp);
        }
        return res;
    }

    private boolean canAddToRes(String path, String s) {
        String[] con;
        con = s.split(COMMA);
        for(String c: con){
            if(c.startsWith(EXC) && path.contains(c.substring(1, c.length()))){
                // not include
                return false;
            }else if(!c.startsWith(EXC) && !path.contains(c)){
                // should include
                return false;
            }
        }
        return true;
    }
}


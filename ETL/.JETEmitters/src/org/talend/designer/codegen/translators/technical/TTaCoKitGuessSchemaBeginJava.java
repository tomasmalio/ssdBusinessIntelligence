package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.components.IComponent;
import org.talend.core.model.process.INode;
import org.talend.core.runtime.IAdditionalInfo;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.core.model.components.EParameterName;
import org.talend.designer.core.model.components.ElementParameter;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.EParameterFieldType;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class TTaCoKitGuessSchemaBeginJava
{
  protected static String nl;
  public static synchronized TTaCoKitGuessSchemaBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTaCoKitGuessSchemaBeginJava result = new TTaCoKitGuessSchemaBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "final java.io.PrintStream out = System.out;" + NL + "System.setOut(System.err);" + NL + "System.setOut(new java.io.PrintStream(new java.io.OutputStream() {" + NL + "        @Override" + NL + "        public void write(final int b) {" + NL + "            // deactivate System.out for guess schema" + NL + "            // This stream is used to transfer the schema between process" + NL + "        }" + NL + "}));" + NL + NL;
  protected final String TEXT_3 = NL + "final java.util.Map<String, String> configuration_";
  protected final String TEXT_4 = " = new java.util.HashMap<>();";
  protected final String TEXT_5 = NL + "                        configuration_";
  protected final String TEXT_6 = ".put(\"";
  protected final String TEXT_7 = "\",";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "                        configuration_";
  protected final String TEXT_10 = ".put(\"";
  protected final String TEXT_11 = "[";
  protected final String TEXT_12 = "]\"," + NL + "                                \"";
  protected final String TEXT_13 = "\");";
  protected final String TEXT_14 = NL + "                    configuration_";
  protected final String TEXT_15 = ".put(\"";
  protected final String TEXT_16 = "\", ";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL + NL + "    final org.talend.sdk.component.runtime.manager.ComponentManager mgr_";
  protected final String TEXT_23 = " = org.talend.sdk.component.runtime.manager.ComponentManager.instance();" + NL;
  protected final String TEXT_24 = NL + "final java.util.Map<String, String> configuration_";
  protected final String TEXT_25 = " = new java.util.HashMap<>();";
  protected final String TEXT_26 = NL + "                        configuration_";
  protected final String TEXT_27 = ".put(\"";
  protected final String TEXT_28 = "\",";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "                        configuration_";
  protected final String TEXT_31 = ".put(\"";
  protected final String TEXT_32 = "[";
  protected final String TEXT_33 = "]\"," + NL + "                                \"";
  protected final String TEXT_34 = "\");";
  protected final String TEXT_35 = NL + "                    configuration_";
  protected final String TEXT_36 = ".put(\"";
  protected final String TEXT_37 = "\", ";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL;
  protected final String TEXT_40 = NL + NL + "    final String chunkSizeStr_";
  protected final String TEXT_41 = " = \"";
  protected final String TEXT_42 = "\";" + NL + "" + NL + "    int chunkSize_";
  protected final String TEXT_43 = " = chunkSizeStr_";
  protected final String TEXT_44 = " == null || chunkSizeStr_";
  protected final String TEXT_45 = ".trim().isEmpty() ? 100 : Integer.parseInt(chunkSizeStr_";
  protected final String TEXT_46 = ".trim());" + NL + "" + NL + "    final org.talend.sdk.component.runtime.output.Processor processorImpl_";
  protected final String TEXT_47 = " = mgr_";
  protected final String TEXT_48 = ".findProcessor(\"";
  protected final String TEXT_49 = "\", \"";
  protected final String TEXT_50 = "\", ";
  protected final String TEXT_51 = ", configuration_";
  protected final String TEXT_52 = ")" + NL + "                                                                                 .orElseThrow(() -> new IllegalArgumentException(\"Can't find ";
  protected final String TEXT_53 = "#";
  protected final String TEXT_54 = "\"));" + NL + "    final javax.json.bind.Jsonb jsonb_";
  protected final String TEXT_55 = " = (javax.json.bind.Jsonb)mgr_";
  protected final String TEXT_56 = ".findPlugin(processorImpl_";
  protected final String TEXT_57 = ".plugin()).get()" + NL + "                     .get(org.talend.sdk.component.runtime.manager.ComponentManager.AllServices.class)" + NL + "                     .getServices().get(javax.json.bind.Jsonb.class);" + NL + "    final org.talend.sdk.component.runtime.di.AutoChunkProcessor processor_";
  protected final String TEXT_58 = " = new org.talend.sdk.component.runtime.di.AutoChunkProcessor(chunkSize_";
  protected final String TEXT_59 = ", processorImpl_";
  protected final String TEXT_60 = ");" + NL + "" + NL + "    org.talend.sdk.component.runtime.di.JobStateAware.init(processorImpl_";
  protected final String TEXT_61 = ", globalMap);" + NL + "    processor_";
  protected final String TEXT_62 = ".start();" + NL + "    globalMap.put(\"processor_";
  protected final String TEXT_63 = "\", processor_";
  protected final String TEXT_64 = ");" + NL + "" + NL + "    int nbLineInput_";
  protected final String TEXT_65 = " = 0;";
  protected final String TEXT_66 = NL;
  protected final String TEXT_67 = NL;
  protected final String TEXT_68 = NL + NL + "    final org.talend.sdk.component.runtime.di.InputsHandler inputsHandler_";
  protected final String TEXT_69 = " = new org.talend.sdk.component.runtime.di.InputsHandler(jsonb_";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL + NL + "    java.util.Map<String, Object> inputIterMap_";
  protected final String TEXT_72 = " = new java.util.HashMap<String, Object>();" + NL;
  protected final String TEXT_73 = NL + "        Class<?> inputsClass_";
  protected final String TEXT_74 = "_";
  protected final String TEXT_75 = " = Object.class;" + NL + "        java.util.Map<Object, Object> ";
  protected final String TEXT_76 = "_map = (java.util.Map<Object, Object>)globalMap.get(\"tHash_";
  protected final String TEXT_77 = "\");" + NL + "        java.util.Iterator<Object> ";
  protected final String TEXT_78 = "_iter = null;" + NL + "        if (";
  protected final String TEXT_79 = "_map != null) {" + NL + "            if(";
  protected final String TEXT_80 = "_map.values().iterator().hasNext()) {" + NL + "                Object firstObj = ";
  protected final String TEXT_81 = "_map.values().iterator().next();" + NL + "                if(firstObj != null) {" + NL + "                    inputsClass_";
  protected final String TEXT_82 = "_";
  protected final String TEXT_83 = " = firstObj.getClass();" + NL + "                }" + NL + "            }";
  protected final String TEXT_84 = NL + "            ";
  protected final String TEXT_85 = "_iter = ";
  protected final String TEXT_86 = "_map.values().iterator();" + NL + "            inputIterMap_";
  protected final String TEXT_87 = ".put(\"";
  protected final String TEXT_88 = "\", ";
  protected final String TEXT_89 = "_iter);" + NL + "        }";
  protected final String TEXT_90 = NL;
  protected final String TEXT_91 = NL + "        inputsHandler_";
  protected final String TEXT_92 = ".addConnection(\"";
  protected final String TEXT_93 = "\", inputsClass_";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "            inputsHandler_";
  protected final String TEXT_97 = ".addConnection(\"";
  protected final String TEXT_98 = "\", ";
  protected final String TEXT_99 = ".getClass());";
  protected final String TEXT_100 = NL + "    final org.talend.sdk.component.runtime.output.InputFactory inputs_";
  protected final String TEXT_101 = " = inputsHandler_";
  protected final String TEXT_102 = ".asInputFactory();";
  protected final String TEXT_103 = NL + NL + "        final org.talend.sdk.component.runtime.di.OutputsHandler outputHandler_";
  protected final String TEXT_104 = " = new org.talend.sdk.component.runtime.di.OutputsHandler(jsonb_";
  protected final String TEXT_105 = ");" + NL + "        outputHandler_";
  protected final String TEXT_106 = ".addConnection(\"";
  protected final String TEXT_107 = "\", Object.class);" + NL + "        final org.talend.sdk.component.runtime.output.OutputFactory outputs_";
  protected final String TEXT_108 = " = outputHandler_";
  protected final String TEXT_109 = ".asOutputFactory();";
  protected final String TEXT_110 = NL + NL + "    org.talend.sdk.component.runtime.di.schema.TaCoKitGuessSchema tacokitGuessSchema =" + NL + "                            new org.talend.sdk.component.runtime.di.schema.TaCoKitGuessSchema(out, globalMap, configuration_";
  protected final String TEXT_111 = "," + NL + "                                                                                    \"";
  protected final String TEXT_112 = "\"," + NL + "                                                                                    \"";
  protected final String TEXT_113 = "\"," + NL + "                                                                                    \"";
  protected final String TEXT_114 = "\",";
  protected final String TEXT_115 = " null ";
  protected final String TEXT_116 = " \"";
  protected final String TEXT_117 = "\" ";
  protected final String TEXT_118 = NL + "                                                                                    );";
  protected final String TEXT_119 = NL + "            try {" + NL + "                tacokitGuessSchema.guessInputComponentSchema();" + NL + "            } finally {" + NL + "                tacokitGuessSchema.close();" + NL + "            }";
  protected final String TEXT_120 = NL + "        globalMap.put(\"___tacokitGuessSchema___\", tacokitGuessSchema);" + NL + "        int _recordsCount_";
  protected final String TEXT_121 = " = 0;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    /*
  Copyright (C) 2006-2018 Talend Inc. - www.talend.com
   Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
    stringBuffer.append(TEXT_1);
    
    final CodeGeneratorArgument guessSchemaCodeGenArgument = CodeGeneratorArgument.class.cast(argument);
    final INode guessSchemaNode = INode.class.cast(guessSchemaCodeGenArgument.getArgument());
    if(guessSchemaNode == null) {
        throw new IllegalArgumentException("node cannot be null");
    }
    final String guessSchemaCid = guessSchemaNode.getUniqueName();
    final String guessSchemaOriginalName = (String)guessSchemaNode.getElementParameter(EParameterName.COMPONENT_NAME.getName()).getValue();
    final String guessSchemaFamily = (String)guessSchemaNode.getElementParameter(EParameterName.FAMILY.getName()).getValue();
    final String guessSchemaVersion = (String)guessSchemaNode.getElementParameter(EParameterName.VERSION.getName()).getValue();
    final String pluginName = (String)guessSchemaNode.getElementParameter("___TACOKIT_GUESS_SCHEMA_PARAMETER_PLUGIN_NAME___").getValue();
    final String actionName = (String)guessSchemaNode.getElementParameter("___TACOKIT_GUESS_SCHEMA_PARAMETER_ACTION_NAME___").getValue();
    final String tacokitComponentType = (String)guessSchemaNode.getElementParameter("___TACOKIT_GUESS_SCHEMA_PARAMETER_COMPONENT_TYPE___").getValue();
    final String outputConnectionName = (String)guessSchemaNode.getElementParameter("___TACOKIT_GUESS_SCHEMA_PARAMETER_OUTPUT_CONNECTION_NAME___").getValue();
    final IComponent guessSchemaComponent = guessSchemaNode.getComponent();
    final boolean guessSchemaUseLookup = guessSchemaComponent.useLookup();

    stringBuffer.append(TEXT_2);
    
    if ("input".equalsIgnoreCase(tacokitComponentType)) {
        final CodeGeneratorArgument codeGenArgument = CodeGeneratorArgument.class.cast(argument);
        final INode node = INode.class.cast(codeGenArgument.getArgument());
        if(node == null) {
            throw new IllegalArgumentException("node cannot be null");
        }
        final String cid = node.getUniqueName();
        final String originalName = (String)node.getElementParameter(EParameterName.COMPONENT_NAME.getName()).getValue();
        final String family = (String)node.getElementParameter(EParameterName.FAMILY.getName()).getValue();
        final String version = (String)node.getElementParameter(EParameterName.VERSION.getName()).getValue();

    /*
  Copyright (C) 2006-2018 Talend Inc. - www.talend.com
   Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
    final List<ElementParameter> params = List.class.cast(node.getElementParametersWithChildrens());
    if (params != null && !params.isEmpty()) {
        for (final ElementParameter p : params) {
            Object pluginValue = p.getTaggedValue("org.talend.sdk.component.source");
            if(pluginValue == null || !String.class.cast(pluginValue).equalsIgnoreCase("tacokit")) {
                continue;
            }
            //TODO: modify this part for Maps and nested lists.
            if (p.getFieldType() == EParameterFieldType.TABLE) {
				java.util.List<java.util.Map<String, String>> tableValues = ElementParameterParser.createTableValues((java.util.List<java.util.Map<String, Object>>) p.getValue(), p);
                String[] items = p.getListItemsDisplayCodeName();
                String tableName = p.getName().replace('$', '.');
                boolean primitiveTable = items.length == 1 && items[0].equals(tableName + "[]");
                String tableNamePrefix = tableName + "[]";
                for (int i = 0; i < tableValues.size(); i++) {
                    java.util.Map<String, String> lineValues = tableValues.get(i);
                    for (int j = 0; j < items.length; j++) {
                        String key = tableName + "[" + i + "]";
                        if (!primitiveTable) {
                            final String columnName = items[j].substring(tableNamePrefix.length(), items[j].length());
                            key = key + columnName;
                        }
                        String value = lineValues.get(items[j]);
                        if (!org.talend.core.model.utils.ContextParameterUtils.isDynamic(value)) {
                            value = org.talend.core.model.utils.TalendTextUtils.removeQuotes(value);
                            value = org.talend.core.model.utils.TalendTextUtils.addQuotes(value);
                        }

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_8);
    
                    }
                }
            } else if(p.getFieldType() == EParameterFieldType.SCHEMA_TYPE) {
                final String schemaName = p.getName();
                if(schemaName == null || !schemaName.contains("$$")) {
                    continue;
                }
                final String[] splitName = schemaName.split(java.util.regex.Pattern.quote("$$"));
                if(splitName.length < 2) {
                    continue;
                }
                final String parameterName = splitName[1];
                //EConnectionType type = EConnectionType.getTypeFromName(p.getContext());
                IConnection connection = null;
                if("in".equalsIgnoreCase(splitName[0])) {
                    if(node.getComponent().useLookup()) {
                        for (final IConnection conn : node.getIncomingConnections()) {
                            String input_name = null;
                            if (!(conn instanceof IAdditionalInfo)) {
                                continue;
                            }
                            input_name = (String)IAdditionalInfo.class.cast(conn).getInfo("INPUT_NAME");
                            if(input_name != null && input_name.equals(p.getContext())) {
                                connection = conn;
                                break;
                            }
                        }
                    } else {
                        final List<? extends IConnection> connections = NodeUtil.getIncomingConnections(node, p.getContext());
                        if(connections != null && !connections.isEmpty()) {
                            connection = connections.get(0);
                        }
                    }
                } else {
                    final List<? extends IConnection> connections = NodeUtil.getOutgoingConnections(node, p.getContext());
                    if(connections != null && !connections.isEmpty()) {
                        connection = connections.get(0);
                    }
                }
                if(connection != null) {
                    IMetadataTable metaTable = connection.getMetadataTable();
                    List<IMetadataColumn> columns = metaTable.getListColumns();
                    for(int i = 0; i < columns.size(); i++) {
                        IMetadataColumn column = columns.get(i);
                    
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_13);
    
                    }
                }
            } else {
                final String key = p.getName().replace('$', '.');
                String value = null;
                if(p.getFieldType() == EParameterFieldType.PASSWORD) {
                    value = ElementParameterParser.getPasswordValue(node, p.getVariableName());
                    if (value == null || value.trim().isEmpty()) {
                        value = null;
                    }
                } else {
                    value = ElementParameterParser.getStringElementParameterValue(p);
                    if (!org.talend.core.model.utils.ContextParameterUtils.isDynamic(value)) {
                        value = org.talend.core.model.utils.TalendTextUtils.removeQuotes(value);
                        value = org.talend.core.model.utils.TalendTextUtils.addQuotes(value);
                    }
                }
                if (value != null) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_17);
    
                } // else do not put value in configuration
            }
        }
    }

    stringBuffer.append(TEXT_18);
      } else { 
    /*
  Copyright (C) 2006-2018 Talend Inc. - www.talend.com
   Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
    stringBuffer.append(TEXT_19);
    
        final CodeGeneratorArgument processorBeginCodeGenArgument = CodeGeneratorArgument.class.cast(argument);
        final INode processorBeginNode = INode.class.cast(processorBeginCodeGenArgument.getArgument());
        if(processorBeginNode == null) {
            throw new IllegalArgumentException("node cannot be null");
        }
        final String processorBeginCid = processorBeginNode.getUniqueName();
        final String processorBeginOriginalName = (String)processorBeginNode.getElementParameter(EParameterName.COMPONENT_NAME.getName()).getValue();
        final String processorBeginFamily = (String)processorBeginNode.getElementParameter(EParameterName.FAMILY.getName()).getValue();
        final String processorBeginVersion = (String)processorBeginNode.getElementParameter(EParameterName.VERSION.getName()).getValue();
        final String processorBeginPluginName = (String)processorBeginNode.getElementParameter("___TACOKIT_GUESS_SCHEMA_PARAMETER_PLUGIN_NAME___").getValue();
        final String processorBeginActionName = (String)processorBeginNode.getElementParameter("___TACOKIT_GUESS_SCHEMA_PARAMETER_ACTION_NAME___").getValue();
        final String processorBeginTacokitComponentType = (String)processorBeginNode.getElementParameter("___TACOKIT_GUESS_SCHEMA_PARAMETER_COMPONENT_TYPE___").getValue();
        final String processorBeginOutputConnectionName = (String)processorBeginNode.getElementParameter("___TACOKIT_GUESS_SCHEMA_PARAMETER_OUTPUT_CONNECTION_NAME___").getValue();
        final IComponent processorBeginComponent = processorBeginNode.getComponent();
        final boolean processorBeginUseLookup = guessSchemaComponent.useLookup();

    
    { 
        // 1. use code block to avoid variables conflict
        // 2. initialization part for processor begin

    stringBuffer.append(TEXT_20);
    /*
  Copyright (C) 2006-2018 Talend Inc. - www.talend.com
   Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
    stringBuffer.append(TEXT_21);
    
    final CodeGeneratorArgument codeGenArgument = CodeGeneratorArgument.class.cast(argument);
    final INode node = INode.class.cast(codeGenArgument.getArgument());
    final String cid = node.getUniqueName();
    final String originalName = (String)node.getElementParameter(EParameterName.COMPONENT_NAME.getName()).getValue();
    final String family = (String)node.getElementParameter(EParameterName.FAMILY.getName()).getValue();
    final String version = (String)node.getElementParameter(EParameterName.VERSION.getName()).getValue();
    final IComponent component = node.getComponent();
    final boolean useLookup = component.useLookup();

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    /*
  Copyright (C) 2006-2018 Talend Inc. - www.talend.com
   Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
    final List<ElementParameter> params = List.class.cast(node.getElementParametersWithChildrens());
    if (params != null && !params.isEmpty()) {
        for (final ElementParameter p : params) {
            Object pluginValue = p.getTaggedValue("org.talend.sdk.component.source");
            if(pluginValue == null || !String.class.cast(pluginValue).equalsIgnoreCase("tacokit")) {
                continue;
            }
            //TODO: modify this part for Maps and nested lists.
            if (p.getFieldType() == EParameterFieldType.TABLE) {
				java.util.List<java.util.Map<String, String>> tableValues = ElementParameterParser.createTableValues((java.util.List<java.util.Map<String, Object>>) p.getValue(), p);
                String[] items = p.getListItemsDisplayCodeName();
                String tableName = p.getName().replace('$', '.');
                boolean primitiveTable = items.length == 1 && items[0].equals(tableName + "[]");
                String tableNamePrefix = tableName + "[]";
                for (int i = 0; i < tableValues.size(); i++) {
                    java.util.Map<String, String> lineValues = tableValues.get(i);
                    for (int j = 0; j < items.length; j++) {
                        String key = tableName + "[" + i + "]";
                        if (!primitiveTable) {
                            final String columnName = items[j].substring(tableNamePrefix.length(), items[j].length());
                            key = key + columnName;
                        }
                        String value = lineValues.get(items[j]);
                        if (!org.talend.core.model.utils.ContextParameterUtils.isDynamic(value)) {
                            value = org.talend.core.model.utils.TalendTextUtils.removeQuotes(value);
                            value = org.talend.core.model.utils.TalendTextUtils.addQuotes(value);
                        }

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_29);
    
                    }
                }
            } else if(p.getFieldType() == EParameterFieldType.SCHEMA_TYPE) {
                final String schemaName = p.getName();
                if(schemaName == null || !schemaName.contains("$$")) {
                    continue;
                }
                final String[] splitName = schemaName.split(java.util.regex.Pattern.quote("$$"));
                if(splitName.length < 2) {
                    continue;
                }
                final String parameterName = splitName[1];
                //EConnectionType type = EConnectionType.getTypeFromName(p.getContext());
                IConnection connection = null;
                if("in".equalsIgnoreCase(splitName[0])) {
                    if(node.getComponent().useLookup()) {
                        for (final IConnection conn : node.getIncomingConnections()) {
                            String input_name = null;
                            if (!(conn instanceof IAdditionalInfo)) {
                                continue;
                            }
                            input_name = (String)IAdditionalInfo.class.cast(conn).getInfo("INPUT_NAME");
                            if(input_name != null && input_name.equals(p.getContext())) {
                                connection = conn;
                                break;
                            }
                        }
                    } else {
                        final List<? extends IConnection> connections = NodeUtil.getIncomingConnections(node, p.getContext());
                        if(connections != null && !connections.isEmpty()) {
                            connection = connections.get(0);
                        }
                    }
                } else {
                    final List<? extends IConnection> connections = NodeUtil.getOutgoingConnections(node, p.getContext());
                    if(connections != null && !connections.isEmpty()) {
                        connection = connections.get(0);
                    }
                }
                if(connection != null) {
                    IMetadataTable metaTable = connection.getMetadataTable();
                    List<IMetadataColumn> columns = metaTable.getListColumns();
                    for(int i = 0; i < columns.size(); i++) {
                        IMetadataColumn column = columns.get(i);
                    
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_34);
    
                    }
                }
            } else {
                final String key = p.getName().replace('$', '.');
                String value = null;
                if(p.getFieldType() == EParameterFieldType.PASSWORD) {
                    value = ElementParameterParser.getPasswordValue(node, p.getVariableName());
                    if (value == null || value.trim().isEmpty()) {
                        value = null;
                    }
                } else {
                    value = ElementParameterParser.getStringElementParameterValue(p);
                    if (!org.talend.core.model.utils.ContextParameterUtils.isDynamic(value)) {
                        value = org.talend.core.model.utils.TalendTextUtils.removeQuotes(value);
                        value = org.talend.core.model.utils.TalendTextUtils.addQuotes(value);
                    }
                }
                if (value != null) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_38);
    
                } // else do not put value in configuration
            }
        }
    }

    stringBuffer.append(TEXT_39);
    
    final IElementParameter chunkSizeParam = node.getElementParameter("CHUNK_SIZE");
    final String chunkSizeStr = (chunkSizeParam == null) ? "" : ElementParameterParser.getStringElementParameterValue(chunkSizeParam);

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(chunkSizeStr);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(family);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(originalName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(family);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(originalName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
    }

    
    {
        // 1. use code block to avoid variables conflict
        // 2. generate inputs part for processor begin

    stringBuffer.append(TEXT_66);
    /*
  Copyright (C) 2006-2018 Talend Inc. - www.talend.com
   Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
    stringBuffer.append(TEXT_67);
    
    final CodeGeneratorArgument codeGenArgument = CodeGeneratorArgument.class.cast(argument);
    final INode node = INode.class.cast(codeGenArgument.getArgument());
    final String cid = node.getUniqueName();
    final String originalName = (String)node.getElementParameter(EParameterName.COMPONENT_NAME.getName()).getValue();
    final String family = (String)node.getElementParameter(EParameterName.FAMILY.getName()).getValue();
    final String version = (String)node.getElementParameter(EParameterName.VERSION.getName()).getValue();
    final IComponent component = node.getComponent();
    final boolean useLookup = component.useLookup();

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
    if (useLookup) {

    /*
  Copyright (C) 2006-2018 Talend Inc. - www.talend.com
   Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
    for (final IConnection connection : node.getIncomingConnections()) {
        String row_name = connection.getName();

    stringBuffer.append(TEXT_73);
    stringBuffer.append(row_name);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(row_name );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(row_name );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(row_name );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(row_name );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(row_name );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(row_name );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(row_name);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(row_name );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(row_name );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(row_name.toLowerCase(java.util.Locale.ROOT) );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(row_name );
    stringBuffer.append(TEXT_89);
    
    }

    stringBuffer.append(TEXT_90);
    
    for (final IConnection connection : node.getIncomingConnections()) {
        String row_name = connection.getName();
        String input_name = null;
        if (connection instanceof IAdditionalInfo) {
            input_name = (String)IAdditionalInfo.class.cast(connection).getInfo("INPUT_NAME");
        }
        if (input_name == null || input_name.trim().isEmpty()) {
            input_name = row_name.toLowerCase(Locale.ROOT);
        }

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append( input_name );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(row_name);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
    }

    
    } else {
        for (final IConnection connection : node.getIncomingConnections(EConnectionType.FLOW_MAIN)) {
            String connName = connection.getConnectorName();
            if(connection instanceof IAdditionalInfo) {
                String additionalName = (String)IAdditionalInfo.class.cast(connection).getInfo("INPUT_NAME");
                if(additionalName != null && !additionalName.isEmpty()) {
                    connName = additionalName;
                }
            }

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append( connName );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_99);
    
        }
    }

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
    }

    
    {
        // 1. use code block to avoid variables conflict
        // 2. generate outputs part for processor begin

    stringBuffer.append(TEXT_103);
    stringBuffer.append(processorBeginCid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(processorBeginCid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(processorBeginCid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append( processorBeginOutputConnectionName );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(processorBeginCid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(processorBeginCid);
    stringBuffer.append(TEXT_109);
    
    }

      } 
    stringBuffer.append(TEXT_110);
    stringBuffer.append(guessSchemaCid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(pluginName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(guessSchemaFamily);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(guessSchemaOriginalName);
    stringBuffer.append(TEXT_114);
     if(actionName == null || actionName.isEmpty()){
    stringBuffer.append(TEXT_115);
    }else {
    stringBuffer.append(TEXT_116);
    stringBuffer.append(actionName);
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
     if ("input".equalsIgnoreCase(tacokitComponentType)) {  
    stringBuffer.append(TEXT_119);
     } else { 
    stringBuffer.append(TEXT_120);
    stringBuffer.append(guessSchemaCid);
    stringBuffer.append(TEXT_121);
     } 
    return stringBuffer.toString();
  }
}

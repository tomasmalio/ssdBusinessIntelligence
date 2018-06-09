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

public class TTaCoKitGuessSchemaMainJava
{
  protected static String nl;
  public static synchronized TTaCoKitGuessSchemaMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTaCoKitGuessSchemaMainJava result = new TTaCoKitGuessSchemaMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "    inputsHandler_";
  protected final String TEXT_6 = ".reset();";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL + NL + "    java.util.Iterator<Object> rowIter = null;" + NL + "    Object rowObj = null;";
  protected final String TEXT_9 = NL + "            if (";
  protected final String TEXT_10 = " != null) {" + NL + "                inputsHandler_";
  protected final String TEXT_11 = ".setInputValue(\"";
  protected final String TEXT_12 = "\", ";
  protected final String TEXT_13 = ");" + NL + "            }";
  protected final String TEXT_14 = NL + "            rowIter = (java.util.Iterator<Object>)inputIterMap_";
  protected final String TEXT_15 = ".get(\"";
  protected final String TEXT_16 = "\");" + NL + "            rowObj = null;" + NL + "            if (rowIter != null && rowIter.hasNext()) {" + NL + "                rowObj = rowIter.next();" + NL + "            }" + NL + "            if (rowObj != null) {" + NL + "                inputsHandler_";
  protected final String TEXT_17 = ".setInputValue(\"";
  protected final String TEXT_18 = "\", rowObj);" + NL + "            }";
  protected final String TEXT_19 = NL + "          inputsHandler_";
  protected final String TEXT_20 = ".setInputValue(\"";
  protected final String TEXT_21 = "\", ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = NL + NL + "    outputHandler_";
  protected final String TEXT_25 = ".reset();" + NL + "    processor_";
  protected final String TEXT_26 = ".onElement(inputs_";
  protected final String TEXT_27 = ", outputs_";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "        ";
  protected final String TEXT_30 = " = outputHandler_";
  protected final String TEXT_31 = ".getValue(\"";
  protected final String TEXT_32 = "\", ";
  protected final String TEXT_33 = ".getClass());";
  protected final String TEXT_34 = NL + NL + "    nbLineInput_";
  protected final String TEXT_35 = "++;" + NL + "    globalMap.put(\"";
  protected final String TEXT_36 = "_NB_LINE\", nbLineInput_";
  protected final String TEXT_37 = ");" + NL + "        Object rowObject_";
  protected final String TEXT_38 = " = outputHandler_";
  protected final String TEXT_39 = ".getValue(\"";
  protected final String TEXT_40 = "\", Object.class);" + NL + "        if (Object.class == rowObject_";
  protected final String TEXT_41 = ".getClass()) {" + NL + "            // means we will not find it through data" + NL + "            // try by reflection" + NL + "            tacokitGuessSchema.fromOutputEmitterPojo(processorImpl_";
  protected final String TEXT_42 = ", \"";
  protected final String TEXT_43 = "\");" + NL + "            return;" + NL + "        }" + NL + "        if (tacokitGuessSchema.guessSchemaThroughResult(rowObject_";
  protected final String TEXT_44 = ")) {" + NL + "            return;" + NL + "        }" + NL + "" + NL + "        _recordsCount_";
  protected final String TEXT_45 = "++;" + NL + "        if(_recordsCount_";
  protected final String TEXT_46 = " > 100){" + NL + "            return; //stop reading. a sort of timeout" + NL + "        }" + NL;

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
     if (!"input".equalsIgnoreCase(tacokitComponentType)) { 
    stringBuffer.append(TEXT_3);
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
    stringBuffer.append(TEXT_4);
    
    final CodeGeneratorArgument codeGenArgument = CodeGeneratorArgument.class.cast(argument);
    final INode node = INode.class.cast(codeGenArgument.getArgument());
    final String cid = node.getUniqueName();
    final String originalName = (String)node.getElementParameter(EParameterName.COMPONENT_NAME.getName()).getValue();
    final String family = (String)node.getElementParameter(EParameterName.FAMILY.getName()).getValue();
    final String version = (String)node.getElementParameter(EParameterName.VERSION.getName()).getValue();
    final IComponent component = node.getComponent();
    final boolean useLookup = component.useLookup();

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
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
    stringBuffer.append(TEXT_7);
    
    // refer to org.talend.designer.codegen/jet_stub/subprocess_header_java.skeleton
    java.util.Set<String> rowsInCurrentProcess = new java.util.HashSet<String>();
    for (IConnection conn : node.getIncomingConnections()) {
        if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN)) {
            INode startNode = conn.getSource();
            if ((startNode.isSubProcessStart() || !(NodeUtil.isDataAutoPropagated(startNode)))) {
                // new Instance
                if (!rowsInCurrentProcess.contains(conn.getName())) {
                  rowsInCurrentProcess.add(conn.getName());
                }
            } else {
                // copy
                if (!rowsInCurrentProcess.contains(conn.getName())) {
                  rowsInCurrentProcess.add(conn.getName());
                }
            }
        }
    }

    stringBuffer.append(TEXT_8);
    
    for (final IConnection connection : node.getIncomingConnections()) {
        String row_name = connection.getName();
        String input_name = null;
        if (connection instanceof IAdditionalInfo) {
            input_name = (String)IAdditionalInfo.class.cast(connection).getInfo("INPUT_NAME");
        }
        if (input_name == null || input_name.trim().isEmpty()) {
            input_name = row_name.toLowerCase(Locale.ROOT);
        }
        if (rowsInCurrentProcess.contains(row_name)) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append( row_name );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append( input_name );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( row_name );
    stringBuffer.append(TEXT_13);
    
        } else {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( row_name.toLowerCase(Locale.ROOT) );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( input_name );
    stringBuffer.append(TEXT_18);
    
        }

    
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

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append( connName );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_22);
    
        }
    }

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
    // once processed update all outputs
    for (final IConnection connection : node.getOutgoingSortedConnections()) {
        if (connection.getLineStyle() != EConnectionType.FLOW_MAIN) {
            continue;
        }

    stringBuffer.append(TEXT_29);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append( connection.getConnectorName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_33);
    
    }

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(guessSchemaCid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(guessSchemaCid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append( outputConnectionName );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(guessSchemaCid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append( outputConnectionName );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(guessSchemaCid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(guessSchemaCid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(guessSchemaCid);
    stringBuffer.append(TEXT_46);
     } 
    return stringBuffer.toString();
  }
}

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

public class TTaCoKitGuessSchemaEnd_bodyJava
{
  protected static String nl;
  public static synchronized TTaCoKitGuessSchemaEnd_bodyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTaCoKitGuessSchemaEnd_bodyJava result = new TTaCoKitGuessSchemaEnd_bodyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;

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

     if (!"input".equalsIgnoreCase(tacokitComponentType)) { 
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
    stringBuffer.append(TEXT_2);
    
    final CodeGeneratorArgument codeGenArgument = CodeGeneratorArgument.class.cast(argument);
    final INode node = INode.class.cast(codeGenArgument.getArgument());
    final String cid = node.getUniqueName();
    final IComponent component = node.getComponent();
    final boolean useLookup = component.useLookup();

    stringBuffer.append(TEXT_3);
    
    if (!useLookup) {
        // nothing to do
    } else {
        // nothing to do
    }

     } 
    return stringBuffer.toString();
  }
}

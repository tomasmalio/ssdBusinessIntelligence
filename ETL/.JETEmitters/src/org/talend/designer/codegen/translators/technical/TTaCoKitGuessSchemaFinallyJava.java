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

public class TTaCoKitGuessSchemaFinallyJava
{
  protected static String nl;
  public static synchronized TTaCoKitGuessSchemaFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTaCoKitGuessSchemaFinallyJava result = new TTaCoKitGuessSchemaFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "        org.talend.sdk.component.runtime.di.schema.TaCoKitGuessSchema tacokitGuessSchema =" + NL + "        (org.talend.sdk.component.runtime.di.schema.TaCoKitGuessSchema) globalMap.remove(\"___tacokitGuessSchema___\");" + NL + "        tacokitGuessSchema.close();";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + "    final org.talend.sdk.component.runtime.di.AutoChunkProcessor processor_";
  protected final String TEXT_7 = " = org.talend.sdk.component.runtime.di.AutoChunkProcessor.class.cast(globalMap.remove(\"processor_";
  protected final String TEXT_8 = "\"));" + NL + "    try {" + NL + "        if (processor_";
  protected final String TEXT_9 = " != null) {" + NL + "            processor_";
  protected final String TEXT_10 = ".stop();" + NL + "        }" + NL + "    } catch (final RuntimeException re) {" + NL + "        throw new TalendException(re, currentComponent, globalMap);" + NL + "    }";

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
    final String tacokitComponentType = (String)guessSchemaNode.getElementParameter("___TACOKIT_GUESS_SCHEMA_PARAMETER_COMPONENT_TYPE___").getValue();


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
    final IComponent component = node.getComponent();
    final boolean useLookup = component.useLookup();

    stringBuffer.append(TEXT_5);
    
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
    
    }

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
     } 
    return stringBuffer.toString();
  }
}

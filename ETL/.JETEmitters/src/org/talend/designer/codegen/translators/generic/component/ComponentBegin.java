package org.talend.designer.codegen.translators.generic.component;

import org.talend.designer.core.generic.model.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.talend.components.api.component.ComponentDefinition;
import org.talend.components.api.component.ConnectorTopology;
import org.talend.components.api.container.RuntimeContainer;
import org.talend.components.api.properties.ComponentProperties;
import org.talend.components.api.properties.ComponentReferenceProperties;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.EParameterFieldType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.core.model.utils.ContextParameterUtils;
import org.talend.daikon.NamedThing;
import org.talend.daikon.properties.property.Property;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.core.generic.constants.IGenericConstants;

public class ComponentBegin
{
  protected static String nl;
  public static synchronized ComponentBegin create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponentBegin result = new ComponentBegin();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            boolean ";
  protected final String TEXT_2 = " = false;" + NL + "            routines.system.Dynamic ";
  protected final String TEXT_3 = " = new routines.system.Dynamic();";
  protected final String TEXT_4 = NL + "        org.talend.codegen.enforcer.OutgoingSchemaEnforcer ";
  protected final String TEXT_5 = " = org.talend.codegen.enforcer.EnforcerCreator.createOutgoingEnforcer(";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ");" + NL + "" + NL + "        // Create a reusable factory that converts the output of the reader to an IndexedRecord." + NL + "        org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord> ";
  protected final String TEXT_8 = " = null;";
  protected final String TEXT_9 = NL + "        // Construct the factory once when the first data arrives." + NL + "        if (";
  protected final String TEXT_10 = " == null) {";
  protected final String TEXT_11 = NL + "            ";
  protected final String TEXT_12 = " = (org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord>)" + NL + "                    new org.talend.daikon.avro.AvroRegistry()" + NL + "                            .createIndexedRecordConverter(";
  protected final String TEXT_13 = ".getClass());" + NL + "        }" + NL + "" + NL + "        // Enforce the outgoing schema on the input.";
  protected final String TEXT_14 = NL + "        ";
  protected final String TEXT_15 = ".setWrapped(";
  protected final String TEXT_16 = ".convertToAvro(";
  protected final String TEXT_17 = "));";
  protected final String TEXT_18 = NL + "            if (!";
  protected final String TEXT_19 = ") {" + NL + "                org.apache.avro.Schema dynSchema_";
  protected final String TEXT_20 = " = ((org.talend.codegen.enforcer.OutgoingDynamicSchemaEnforcer) ";
  protected final String TEXT_21 = ").getDynamicFieldsSchema();" + NL + "                for (org.apache.avro.Schema.Field dynamicField_";
  protected final String TEXT_22 = " : dynSchema_";
  protected final String TEXT_23 = ".getFields()){" + NL + "                    routines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_24 = " = new routines.system.DynamicMetadata();" + NL + "                    org.apache.avro.Schema dynamicFieldSchema_";
  protected final String TEXT_25 = " = dynamicField_";
  protected final String TEXT_26 = ".schema();" + NL + "                    // set name" + NL + "                    dynamicMetadata_";
  protected final String TEXT_27 = ".setName(dynamicField_";
  protected final String TEXT_28 = ".name());" + NL + "                    // set db name" + NL + "                    dynamicMetadata_";
  protected final String TEXT_29 = ".setDbName(dynamicField_";
  protected final String TEXT_30 = ".name());" + NL + "                    // set nullable" + NL + "                    if (org.talend.daikon.avro.AvroUtils.isNullable(dynamicFieldSchema_";
  protected final String TEXT_31 = ")) {" + NL + "                        dynamicMetadata_";
  protected final String TEXT_32 = ".setNullable(true);" + NL + "                    }" + NL + "                    // set type" + NL + "                    String talendType_";
  protected final String TEXT_33 = " = org.talend.codegen.converter.TypeConverter.avroToDi(dynamicFieldSchema_";
  protected final String TEXT_34 = ");" + NL + "                    dynamicMetadata_";
  protected final String TEXT_35 = ".setType(talendType_";
  protected final String TEXT_36 = ");" + NL + "                    // set pattern" + NL + "                    String pattern_";
  protected final String TEXT_37 = " = dynamicField_";
  protected final String TEXT_38 = ".getProp(org.talend.daikon.avro.SchemaConstants.TALEND_COLUMN_PATTERN);" + NL + "                    if (pattern_";
  protected final String TEXT_39 = " != null && !pattern_";
  protected final String TEXT_40 = ".trim().isEmpty()) {" + NL + "                        dynamicMetadata_";
  protected final String TEXT_41 = ".setFormat(pattern_";
  protected final String TEXT_42 = ");" + NL + "                    }" + NL + "                    // set logical type" + NL + "                    org.apache.avro.Schema unwrappedSchema_";
  protected final String TEXT_43 = " = org.talend.daikon.avro.AvroUtils.unwrapIfNullable(dynamicFieldSchema_";
  protected final String TEXT_44 = ");" + NL + "                    String logicalType_";
  protected final String TEXT_45 = " = org.talend.daikon.avro.LogicalTypeUtils.getLogicalTypeName(unwrappedSchema_";
  protected final String TEXT_46 = ");" + NL + "                    dynamicMetadata_";
  protected final String TEXT_47 = ".setLogicalType(logicalType_";
  protected final String TEXT_48 = ");" + NL + "                    // set length" + NL + "                    Object length_";
  protected final String TEXT_49 = " = dynamicField_";
  protected final String TEXT_50 = ".getProp(org.talend.daikon.avro.SchemaConstants.TALEND_COLUMN_DB_LENGTH);" + NL + "                    if (length_";
  protected final String TEXT_51 = " != null) {" + NL + "                        dynamicMetadata_";
  protected final String TEXT_52 = ".setLength(Integer.parseInt(String.valueOf(length_";
  protected final String TEXT_53 = ")));" + NL + "                    }" + NL + "                    // set DbType" + NL + "                    Object dbType_";
  protected final String TEXT_54 = " = dynamicField_";
  protected final String TEXT_55 = ".getProp(org.talend.daikon.avro.SchemaConstants.TALEND_COLUMN_DB_TYPE);" + NL + "                    if (dbType_";
  protected final String TEXT_56 = " != null) {" + NL + "                        dynamicMetadata_";
  protected final String TEXT_57 = ".setDbType(String.valueOf(dbType_";
  protected final String TEXT_58 = "));" + NL + "                    }" + NL + "                    // set precision" + NL + "                    Object precision_";
  protected final String TEXT_59 = " = dynamicField_";
  protected final String TEXT_60 = ".getProp(org.talend.daikon.avro.SchemaConstants.TALEND_COLUMN_PRECISION); " + NL + "                    if (precision_";
  protected final String TEXT_61 = " != null) {" + NL + "                        dynamicMetadata_";
  protected final String TEXT_62 = ".setPrecision(Integer.parseInt(String.valueOf(precision_";
  protected final String TEXT_63 = ")));" + NL + "                    } " + NL + "                    // add dynamic field metadata to dynamic variable";
  protected final String TEXT_64 = NL + "                    ";
  protected final String TEXT_65 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_66 = ");" + NL + "                }" + NL + "                initDyn_";
  protected final String TEXT_67 = " = true;" + NL + "            }";
  protected final String TEXT_68 = NL + "            ";
  protected final String TEXT_69 = ".clearColumnValues();";
  protected final String TEXT_70 = NL + "                java.util.Map<String, Object> dynamicValue_";
  protected final String TEXT_71 = " = (java.util.Map<String, Object>) ";
  protected final String TEXT_72 = ".get(";
  protected final String TEXT_73 = ");" + NL + "                for (java.util.Map.Entry<String, Object> dynamicValueEntry_";
  protected final String TEXT_74 = " : dynamicValue_";
  protected final String TEXT_75 = ".entrySet()) {";
  protected final String TEXT_76 = NL + "                    ";
  protected final String TEXT_77 = ".setColumnValue(";
  protected final String TEXT_78 = ".getIndex(dynamicValueEntry_";
  protected final String TEXT_79 = ".getKey()), dynamicValueEntry_";
  protected final String TEXT_80 = ".getValue());" + NL + "                }";
  protected final String TEXT_81 = NL + "                ";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = " = ";
  protected final String TEXT_84 = ";";
  protected final String TEXT_85 = NL + "                Object columnValue_";
  protected final String TEXT_86 = "_";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = ".get(";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "                        ";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = ParserUtils.parseTo_Document(String.valueOf(columnValue_";
  protected final String TEXT_93 = "_";
  protected final String TEXT_94 = "));";
  protected final String TEXT_95 = NL + "                        ";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = " = (";
  protected final String TEXT_98 = ") (columnValue_";
  protected final String TEXT_99 = "_";
  protected final String TEXT_100 = ");";
  protected final String TEXT_101 = NL + "                    if (columnValue_";
  protected final String TEXT_102 = "_";
  protected final String TEXT_103 = " == null) {";
  protected final String TEXT_104 = NL + "                        ";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = " = ";
  protected final String TEXT_107 = ";" + NL + "                    } else {";
  protected final String TEXT_108 = NL + "                            ";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = " = ParserUtils.parseTo_Document(String.valueOf(columnValue_";
  protected final String TEXT_111 = "_";
  protected final String TEXT_112 = "));";
  protected final String TEXT_113 = NL + "                            ";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = " = (";
  protected final String TEXT_116 = ") (columnValue_";
  protected final String TEXT_117 = "_";
  protected final String TEXT_118 = ");";
  protected final String TEXT_119 = NL + "                    }";
  protected final String TEXT_120 = NL + " \t\t                    java.util.List<Object> ";
  protected final String TEXT_121 = " = new java.util.ArrayList<Object>();" + NL + " \t\t                    ";
  protected final String TEXT_122 = NL + " \t\t                    ";
  protected final String TEXT_123 = " = new java.util.ArrayList<Object>();" + NL + " \t\t                    ";
  protected final String TEXT_124 = NL + " \t\t                            ";
  protected final String TEXT_125 = ".add(\"";
  protected final String TEXT_126 = "\");" + NL + " \t\t                            ";
  protected final String TEXT_127 = NL + " \t\t                                ";
  protected final String TEXT_128 = ".add(";
  protected final String TEXT_129 = ");" + NL + " \t\t                                ";
  protected final String TEXT_130 = NL + " \t\t                            ";
  protected final String TEXT_131 = ".add(\"\");" + NL + " \t\t                            ";
  protected final String TEXT_132 = NL + " \t\t                    ((org.talend.daikon.properties.Properties)props_";
  protected final String TEXT_133 = ").setValue(\"";
  protected final String TEXT_134 = "\",";
  protected final String TEXT_135 = ");" + NL + " \t\t                    ";
  protected final String TEXT_136 = NL + " \t\t                        props_";
  protected final String TEXT_137 = ".setValue(\"";
  protected final String TEXT_138 = "\"," + NL + " \t\t                        routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_139 = "));" + NL + " \t\t                        ";
  protected final String TEXT_140 = NL + " \t\t                    props_";
  protected final String TEXT_141 = ".setValue(\"";
  protected final String TEXT_142 = "\"," + NL + " \t\t                        TalendDate.parseDate(\"yyyy-MM-dd HH:mm:ss\",";
  protected final String TEXT_143 = "));" + NL + " \t\t                    ";
  protected final String TEXT_144 = NL + " \t\t                    props_";
  protected final String TEXT_145 = ".setValue(\"";
  protected final String TEXT_146 = "\"," + NL + " \t\t                        ";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = ");" + NL + " \t\t                    ";
  protected final String TEXT_149 = NL + " \t\t                    props_";
  protected final String TEXT_150 = ".setValue(\"";
  protected final String TEXT_151 = "\"," + NL + " \t\t                        new org.apache.avro.Schema.Parser().parse(";
  protected final String TEXT_152 = "));" + NL + " \t\t                    ";
  protected final String TEXT_153 = NL + " \t\t                    props_";
  protected final String TEXT_154 = ".setValue(\"";
  protected final String TEXT_155 = "\"," + NL + " \t\t                    ";
  protected final String TEXT_156 = ");" + NL + " \t\t                    ";
  protected final String TEXT_157 = NL + " \t\t                props_";
  protected final String TEXT_158 = ".setValue(\"";
  protected final String TEXT_159 = "\", null);" + NL + " \t\t            ";
  protected final String TEXT_160 = NL + NL + "org.talend.components.api.component.ComponentDefinition def_";
  protected final String TEXT_161 = " =" + NL + "        new ";
  protected final String TEXT_162 = "();";
  protected final String TEXT_163 = NL;
  protected final String TEXT_164 = NL;
  protected final String TEXT_165 = " props_";
  protected final String TEXT_166 = " =" + NL + "        (";
  protected final String TEXT_167 = ") def_";
  protected final String TEXT_168 = ".createRuntimeProperties();";
  protected final String TEXT_169 = NL + "    if (org.talend.components.api.properties.ComponentReferenceProperties.ReferenceType.COMPONENT_INSTANCE == props_";
  protected final String TEXT_170 = ".referenceType.getValue()) {" + NL + "        final String referencedComponentInstanceId_";
  protected final String TEXT_171 = " = props_";
  protected final String TEXT_172 = ".componentInstanceId.getStringValue();" + NL + "        if (referencedComponentInstanceId_";
  protected final String TEXT_173 = " != null) {" + NL + "            org.talend.daikon.properties.Properties referencedComponentProperties_";
  protected final String TEXT_174 = " = (org.talend.daikon.properties.Properties) globalMap.get(" + NL + "                referencedComponentInstanceId_";
  protected final String TEXT_175 = " + \"_COMPONENT_RUNTIME_PROPERTIES\");" + NL + "            props_";
  protected final String TEXT_176 = ".setReference(referencedComponentProperties_";
  protected final String TEXT_177 = ");" + NL + "        }" + NL + "    }";
  protected final String TEXT_178 = NL + "globalMap.put(\"";
  protected final String TEXT_179 = "_COMPONENT_RUNTIME_PROPERTIES\", props_";
  protected final String TEXT_180 = ");" + NL;
  protected final String TEXT_181 = NL + "final String buffersSizeKey_";
  protected final String TEXT_182 = " = \"buffersSizeKey_";
  protected final String TEXT_183 = "_\" + Thread.currentThread().getId(); ";
  protected final String TEXT_184 = NL + "java.net.URL mappings_url_";
  protected final String TEXT_185 = "= this.getClass().getResource(\"/xmlMappings\");" + NL + "globalMap.put(\"";
  protected final String TEXT_186 = "_MAPPINGS_URL\", mappings_url_";
  protected final String TEXT_187 = ");" + NL + "" + NL + "org.talend.components.api.container.RuntimeContainer container_";
  protected final String TEXT_188 = " = new org.talend.components.api.container.RuntimeContainer() {" + NL + "    public Object getComponentData(String componentId, String key) {" + NL + "        return globalMap.get(componentId + \"_\" + key);" + NL + "    }" + NL + "" + NL + "    public void setComponentData(String componentId, String key, Object data) {" + NL + "        globalMap.put(componentId + \"_\" + key, data);" + NL + "    }" + NL + "" + NL + "    public String getCurrentComponentId() {" + NL + "        return \"";
  protected final String TEXT_189 = "\";" + NL + "    }" + NL + "" + NL + "    public Object getGlobalData(String key) {" + NL + "    \treturn globalMap.get(key);" + NL + "    }" + NL + "};" + NL + "" + NL + "int nb_line_";
  protected final String TEXT_190 = " = 0;" + NL + "" + NL + "org.talend.components.api.component.ConnectorTopology topology_";
  protected final String TEXT_191 = " = null;";
  protected final String TEXT_192 = NL + "topology_";
  protected final String TEXT_193 = " = org.talend.components.api.component.ConnectorTopology.INCOMING_AND_OUTGOING;";
  protected final String TEXT_194 = NL + "topology_";
  protected final String TEXT_195 = " = org.talend.components.api.component.ConnectorTopology.INCOMING;";
  protected final String TEXT_196 = NL + "topology_";
  protected final String TEXT_197 = " = org.talend.components.api.component.ConnectorTopology.OUTGOING;";
  protected final String TEXT_198 = NL + "topology_";
  protected final String TEXT_199 = " = org.talend.components.api.component.ConnectorTopology.NONE;";
  protected final String TEXT_200 = NL + NL + "org.talend.daikon.runtime.RuntimeInfo runtime_info_";
  protected final String TEXT_201 = " = def_";
  protected final String TEXT_202 = ".getRuntimeInfo(" + NL + "    org.talend.components.api.component.runtime.ExecutionEngine.DI, props_";
  protected final String TEXT_203 = ", topology_";
  protected final String TEXT_204 = ");" + NL + "java.util.Set<org.talend.components.api.component.ConnectorTopology> supported_connector_topologies_";
  protected final String TEXT_205 = " = def_";
  protected final String TEXT_206 = ".getSupportedConnectorTopologies();" + NL + "" + NL + "org.talend.components.api.component.runtime.RuntimableRuntime componentRuntime_";
  protected final String TEXT_207 = " = (org.talend.components.api.component.runtime.RuntimableRuntime)(Class.forName(runtime_info_";
  protected final String TEXT_208 = ".getRuntimeClassName()).newInstance());" + NL + "org.talend.daikon.properties.ValidationResult initVr_";
  protected final String TEXT_209 = " = componentRuntime_";
  protected final String TEXT_210 = ".initialize(container_";
  protected final String TEXT_211 = ", props_";
  protected final String TEXT_212 = ");" + NL + "" + NL + "if (initVr_";
  protected final String TEXT_213 = ".getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR ) {" + NL + "    throw new RuntimeException(initVr_";
  protected final String TEXT_214 = ".getMessage());" + NL + "}" + NL + "" + NL + "if(componentRuntime_";
  protected final String TEXT_215 = " instanceof org.talend.components.api.component.runtime.ComponentDriverInitialization) {" + NL + "\torg.talend.components.api.component.runtime.ComponentDriverInitialization compDriverInitialization_";
  protected final String TEXT_216 = " = (org.talend.components.api.component.runtime.ComponentDriverInitialization)componentRuntime_";
  protected final String TEXT_217 = ";" + NL + "\tcompDriverInitialization_";
  protected final String TEXT_218 = ".runAtDriver(container_";
  protected final String TEXT_219 = ");" + NL + "}" + NL + "" + NL + "org.talend.components.api.component.runtime.SourceOrSink sourceOrSink_";
  protected final String TEXT_220 = " = null;" + NL + "if(componentRuntime_";
  protected final String TEXT_221 = " instanceof org.talend.components.api.component.runtime.SourceOrSink) {" + NL + "\tsourceOrSink_";
  protected final String TEXT_222 = " = (org.talend.components.api.component.runtime.SourceOrSink)componentRuntime_";
  protected final String TEXT_223 = ";" + NL + "\torg.talend.daikon.properties.ValidationResult vr_";
  protected final String TEXT_224 = " = sourceOrSink_";
  protected final String TEXT_225 = ".validate(container_";
  protected final String TEXT_226 = ");" + NL + "\tif (vr_";
  protected final String TEXT_227 = ".getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR ) {" + NL + "    \tthrow new RuntimeException(vr_";
  protected final String TEXT_228 = ".getMessage());" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_229 = NL + "    org.talend.components.api.component.runtime.Source source_";
  protected final String TEXT_230 = " =" + NL + "            (org.talend.components.api.component.runtime.Source)sourceOrSink_";
  protected final String TEXT_231 = ";" + NL + "    org.talend.components.api.component.runtime.Reader reader_";
  protected final String TEXT_232 = " =" + NL + "            source_";
  protected final String TEXT_233 = ".createReader(container_";
  protected final String TEXT_234 = ");" + NL + "\treader_";
  protected final String TEXT_235 = " = new org.talend.codegen.flowvariables.runtime.FlowVariablesReader(reader_";
  protected final String TEXT_236 = ", container_";
  protected final String TEXT_237 = ");" + NL;
  protected final String TEXT_238 = NL + "        boolean multi_output_is_allowed_";
  protected final String TEXT_239 = " = false;";
  protected final String TEXT_240 = NL + "        org.talend.components.api.component.Connector c_";
  protected final String TEXT_241 = " = null;" + NL + "        for (org.talend.components.api.component.Connector currentConnector : props_";
  protected final String TEXT_242 = ".getAvailableConnectors(null, true)) {" + NL + "            if (currentConnector.getName().equals(\"";
  protected final String TEXT_243 = "\")) {" + NL + "                c_";
  protected final String TEXT_244 = " = currentConnector;" + NL + "            }" + NL + "" + NL + "            if (currentConnector.getName().equals(\"REJECT\")) {//it's better to move the code to javajet" + NL + "                multi_output_is_allowed_";
  protected final String TEXT_245 = " = true;" + NL + "            }" + NL + "        }" + NL + "        org.apache.avro.Schema schema_";
  protected final String TEXT_246 = " = props_";
  protected final String TEXT_247 = ".getSchema(c_";
  protected final String TEXT_248 = ", true);" + NL;
  protected final String TEXT_249 = NL + NL + "    // Iterate through the incoming data." + NL + "    boolean available_";
  protected final String TEXT_250 = " = reader_";
  protected final String TEXT_251 = ".start();" + NL + "" + NL + "    resourceMap.put(\"reader_";
  protected final String TEXT_252 = "\", reader_";
  protected final String TEXT_253 = ");" + NL + "" + NL + "    for (; available_";
  protected final String TEXT_254 = "; available_";
  protected final String TEXT_255 = " = reader_";
  protected final String TEXT_256 = ".advance()) {" + NL + "    \tnb_line_";
  protected final String TEXT_257 = "++;" + NL + "" + NL + "    \t";
  protected final String TEXT_258 = NL + "        if (multi_output_is_allowed_";
  protected final String TEXT_259 = ") {";
  protected final String TEXT_260 = NL + "                ";
  protected final String TEXT_261 = " = null;";
  protected final String TEXT_262 = NL;
  protected final String TEXT_263 = NL + "                ";
  protected final String TEXT_264 = " = null;";
  protected final String TEXT_265 = NL + "        }";
  protected final String TEXT_266 = NL + NL + "        try {" + NL + "            Object data_";
  protected final String TEXT_267 = " = reader_";
  protected final String TEXT_268 = ".getCurrent();";
  protected final String TEXT_269 = NL + NL + "                if(multi_output_is_allowed_";
  protected final String TEXT_270 = ") {";
  protected final String TEXT_271 = NL + "                    ";
  protected final String TEXT_272 = " = new ";
  protected final String TEXT_273 = "Struct();" + NL + "                }" + NL;
  protected final String TEXT_274 = NL + "        } catch (org.talend.components.api.exception.DataRejectException e_";
  protected final String TEXT_275 = ") {" + NL + "        \tjava.util.Map<String,Object> info_";
  protected final String TEXT_276 = " = e_";
  protected final String TEXT_277 = ".getRejectInfo();";
  protected final String TEXT_278 = NL + "                Object data_";
  protected final String TEXT_279 = " = info_";
  protected final String TEXT_280 = ".get(\"talend_record\");" + NL + "" + NL + "                if (multi_output_is_allowed_";
  protected final String TEXT_281 = ") {";
  protected final String TEXT_282 = NL + "                    ";
  protected final String TEXT_283 = " = new ";
  protected final String TEXT_284 = "Struct();" + NL + "                }" + NL + "\t\t\t\ttry{";
  protected final String TEXT_285 = NL + "                }catch(java.lang.Exception e){" + NL + "                \t// do nothing" + NL + "                }";
  protected final String TEXT_286 = NL + "                        ";
  protected final String TEXT_287 = ".";
  protected final String TEXT_288 = " = (";
  protected final String TEXT_289 = ")info_";
  protected final String TEXT_290 = ".get(\"";
  protected final String TEXT_291 = "\");";
  protected final String TEXT_292 = NL + "            \t//TODO use a method instead of getting method by the special key \"error/errorMessage\"" + NL + "            \tObject errorMessage_";
  protected final String TEXT_293 = " = null;" + NL + "            \tif(info_";
  protected final String TEXT_294 = ".containsKey(\"error\")){" + NL + "            \t\terrorMessage_";
  protected final String TEXT_295 = " = info_";
  protected final String TEXT_296 = ".get(\"error\");" + NL + "        \t\t}else if(info_";
  protected final String TEXT_297 = ".containsKey(\"errorMessage\")){" + NL + "            \t\terrorMessage_";
  protected final String TEXT_298 = " = info_";
  protected final String TEXT_299 = ".get(\"errorMessage\");" + NL + "        \t\t}else{" + NL + "        \t\t\terrorMessage_";
  protected final String TEXT_300 = " = \"Rejected but error message missing\";" + NL + "        \t\t}" + NL + "        \t\terrorMessage_";
  protected final String TEXT_301 = " = \"Row \"+ nb_line_";
  protected final String TEXT_302 = " + \": \"+errorMessage_";
  protected final String TEXT_303 = ";" + NL + "    \t\t\tSystem.err.println(errorMessage_";
  protected final String TEXT_304 = ");";
  protected final String TEXT_305 = NL + "            \t// If the record is reject, the main line record should put NULL" + NL + "            \t";
  protected final String TEXT_306 = " = null;";
  protected final String TEXT_307 = NL + "    }";
  protected final String TEXT_308 = NL + "    org.talend.components.api.component.runtime.Sink sink_";
  protected final String TEXT_309 = " =" + NL + "            (org.talend.components.api.component.runtime.Sink)sourceOrSink_";
  protected final String TEXT_310 = ";" + NL + "    org.talend.components.api.component.runtime.WriteOperation writeOperation_";
  protected final String TEXT_311 = " = sink_";
  protected final String TEXT_312 = ".createWriteOperation();" + NL + "    writeOperation_";
  protected final String TEXT_313 = ".initialize(container_";
  protected final String TEXT_314 = ");" + NL + "    org.talend.components.api.component.runtime.Writer writer_";
  protected final String TEXT_315 = " = writeOperation_";
  protected final String TEXT_316 = ".createWriter(container_";
  protected final String TEXT_317 = ");" + NL + "    writer_";
  protected final String TEXT_318 = ".open(\"";
  protected final String TEXT_319 = "\");" + NL + "" + NL + "    resourceMap.put(\"writer_";
  protected final String TEXT_320 = "\", writer_";
  protected final String TEXT_321 = ");" + NL + "" + NL + "    org.talend.components.api.component.Connector c_";
  protected final String TEXT_322 = " = null;" + NL + "    for (org.talend.components.api.component.Connector currentConnector : props_";
  protected final String TEXT_323 = ".getAvailableConnectors(null, false)) {" + NL + "        if (currentConnector.getName().equals(\"MAIN\")) {" + NL + "            c_";
  protected final String TEXT_324 = " = currentConnector;" + NL + "            break;" + NL + "        }" + NL + "    }" + NL + "    org.apache.avro.Schema designSchema_";
  protected final String TEXT_325 = " = props_";
  protected final String TEXT_326 = ".getSchema(c_";
  protected final String TEXT_327 = ", false);" + NL + "    org.talend.codegen.enforcer.IncomingSchemaEnforcer incomingEnforcer_";
  protected final String TEXT_328 = NL + "            = new org.talend.codegen.enforcer.IncomingSchemaEnforcer(designSchema_";
  protected final String TEXT_329 = ");";
  protected final String TEXT_330 = NL + "                c_";
  protected final String TEXT_331 = " = null;" + NL + "                for (org.talend.components.api.component.Connector currentConnector : props_";
  protected final String TEXT_332 = ".getAvailableConnectors(null, true)) {" + NL + "                    if (currentConnector.getName().equals(\"MAIN\")) {" + NL + "                        c_";
  protected final String TEXT_333 = " = currentConnector;" + NL + "                    }" + NL + "                }" + NL + "                org.apache.avro.Schema mainSchema_";
  protected final String TEXT_334 = " = props_";
  protected final String TEXT_335 = ".getSchema(c_";
  protected final String TEXT_336 = ", true);";
  protected final String TEXT_337 = NL + "                c_";
  protected final String TEXT_338 = " = null;" + NL + "                for (org.talend.components.api.component.Connector currentConnector : props_";
  protected final String TEXT_339 = ".getAvailableConnectors(null, true)) {" + NL + "                    if (currentConnector.getName().equals(\"REJECT\")) {" + NL + "                        c_";
  protected final String TEXT_340 = " = currentConnector;" + NL + "                    }" + NL + "                }" + NL + "                org.apache.avro.Schema rejectSchema_";
  protected final String TEXT_341 = " = props_";
  protected final String TEXT_342 = ".getSchema(c_";
  protected final String TEXT_343 = ", true);";
  protected final String TEXT_344 = NL + "                java.lang.Iterable<?> outgoingMainRecordsList_";
  protected final String TEXT_345 = " = new java.util.ArrayList<Object>();" + NL + "                java.util.Iterator outgoingMainRecordsIt_";
  protected final String TEXT_346 = " = null;" + NL;
  protected final String TEXT_347 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

/**
 * Utility for generating code that can turn an IndexedRecording coming from a
 * generic component into a rowStruct expected by the Studio.
 */
class IndexedRecordToRowStructGenerator {

    /** A unique tag for generating code variables, usually based on the cid
     *  of the node. */
    private final String cid;

    /** The columns in the rowStruct to generate. */
    private final List<IMetadataColumn> columns;

    /** The connection that we're generating code for. */
    private final IConnection connection;

    /** If there is a dynamic column, its name.  Null if none. */
    private final String dynamicColName;

    /** Variable names generated in code used by this utility. */
    private final String codeVarSchemaEnforcer;
    private final String codeVarIsDynamicInitialized;
    private final String codeVarDynamic;
    private final String codeVarIndexedRecordAdapter;

    public IndexedRecordToRowStructGenerator(String cid, IConnection connection) {
        this(cid, connection, connection.getMetadataTable().getListColumns());
    }

    public IndexedRecordToRowStructGenerator(String cid, IConnection connection, List<IMetadataColumn> columns) {
        this.cid = cid;
        this.connection = connection;
        this.columns = columns;

        String tmpDynamicColName = null;
        for (IMetadataColumn column : columns) {
            if (column.getTalendType().equals("id_Dynamic")) {
                tmpDynamicColName = column.getLabel();
                break;
            }
        }
        dynamicColName = tmpDynamicColName;

        this.codeVarSchemaEnforcer = "outgoingEnforcer_" + cid;
        this.codeVarIsDynamicInitialized = "initDyn_" + cid;
        this.codeVarDynamic = "dynamic_" + cid;
        this.codeVarIndexedRecordAdapter = "factory_" + cid;
    }

    public IConnection getConnection() {
        return connection;
    }

    /**
     * Generate code that declares and initializes the variables that are used
     * in the code generated by this utility.
     */
    public void generateInitialVariables(String codeVarSchemaToEnforce, boolean dynamicByPosition) {
        if (dynamicColName != null) {
            
    stringBuffer.append(TEXT_1);
    stringBuffer.append(codeVarIsDynamicInitialized);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_3);
    
        }

        
    stringBuffer.append(TEXT_4);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(codeVarSchemaToEnforce);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dynamicByPosition);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_8);
    
    }

    /**
     * Generate code that copies data from the IndexedRecord to the rowStruct.
     *
     * @param codeVarIndexedRecord the name of the variable that contains the
     *    IndexedRecord.
     * @param codeVarRowStruct the name of the variable that contains the
     *    rowStruct.
     */
    public void generateConvertRecord(String codeVarIndexedRecord, String codeVarRowStruct) {
        generateConvertRecord(codeVarIndexedRecord, codeVarRowStruct, columns);
    }

    /**
     * Generate code that copies data from the IndexedRecord to the rowStruct.
     *
     * @param codeVarIndexedRecord the name of the variable that contains the
     *    IndexedRecord.
     * @param codeVarRowStruct the name of the variable that contains the
     *    rowStruct.
     * @param columnsToGenerate the list of columns in the rowStruct to generate
     *    code for.
     */
    public void generateConvertRecord(String codeVarIndexedRecord, String codeVarRowStruct, List<IMetadataColumn> columnsToGenerate) {
        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(codeVarIndexedRecord);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(codeVarIndexedRecord);
    stringBuffer.append(TEXT_17);
    

        if (dynamicColName != null) {
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(codeVarIsDynamicInitialized);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
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
    stringBuffer.append(TEXT_64);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_69);
    
        }

        for (int i = 0; i < columnsToGenerate.size(); i++) {
            IMetadataColumn column = columnsToGenerate.get(i);
            String columnName = column.getLabel();
            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
            if (columnName.equals(dynamicColName)) {
            
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(dynamicColName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_84);
    
            } else {
            
    stringBuffer.append(TEXT_85);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_89);
    
                if (JavaTypesManager.NULL.equals(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate))) {
                    // there is no default value, so just assign data value to RowStruct
                
    
                    if ("id_Document".equals(column.getTalendType())) {
                    
    stringBuffer.append(TEXT_90);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
                    } else {
                    
    stringBuffer.append(TEXT_95);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
                    }
                } else {
                    // there is default value, so check on null and set default value instead of null
                
    stringBuffer.append(TEXT_101);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_107);
    
                        if ("id_Document".equals(column.getTalendType())) {
                        
    stringBuffer.append(TEXT_108);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
                        } else {
                        
    stringBuffer.append(TEXT_113);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
                        }
                        
    stringBuffer.append(TEXT_119);
    
                }
            }
        }
    }
}

    
 
 /**
  * Utility for generating code that set values for the properties of the component.
  */
 class ProcessPropertiesGenerator {
 
     /** A unique tag for generating code variables, usually based on the cid
      *  of the node. */
     private final String cid;
 
     private final Component component;
     
     public ProcessPropertiesGenerator(String cid, Component component) {
         this.cid = cid;
         this.component = component;    
     }
 
     /**
      * Generate code that set value for component properties
      */
     public void setPropertyValues(Property property, Component.CodegenPropInfo propInfo, String connName, boolean setDynamicTags, boolean firstCall) {
     
 		            Object value = property.getStoredValue();
 		            if (value != null) {
 		            	if (setDynamicTags && (value instanceof String) && isDynamicValue(String.valueOf(value), connName)) {
 		            		property.setTaggedValue(IGenericConstants.DYNAMIC_PROPERTY_VALUE, "true");
 		            	}
 		                if (value instanceof List) { // if
 		                    // added for the support of tables
 		                    String tmpVarName = cid+propInfo.fieldName.replace('.','_')+"_"+property.getName();
 		                    if(firstCall) {
 		                    
    stringBuffer.append(TEXT_120);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_121);
    
 		                    } else {
 		                    
    stringBuffer.append(TEXT_122);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_123);
    
 		                    }
 		                    for (Object subPropertyValue : (java.util.List<Object>)property.getValue()) {
 		                        if ((property.getPossibleValues() != null && property.getPossibleValues().size() > 0)||
 		                        	Boolean.valueOf(String.valueOf(property.getTaggedValue(IGenericConstants.ADD_QUOTES)))) {
 		                            
    stringBuffer.append(TEXT_124);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(subPropertyValue );
    stringBuffer.append(TEXT_126);
    
 		                        } else if(!"".equals(subPropertyValue)) {
 		                        	if(setDynamicTags && isDynamicValue(String.valueOf(subPropertyValue), connName)) {
 		                        		property.setTaggedValue(IGenericConstants.DYNAMIC_PROPERTY_VALUE, "true");
 		                        	}
 		                                
    stringBuffer.append(TEXT_127);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(subPropertyValue );
    stringBuffer.append(TEXT_129);
    
 		                        } else {
 		                            
    stringBuffer.append(TEXT_130);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_131);
    
 		                        }
 		                    }
 		                    
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_135);
    
 		                } else if (value instanceof String && property.isFlag(Property.Flags.ENCRYPT) && ElementParameterParser.canEncryptValue((String) value)) {
 		                    if (!"".equals(property.getStringValue())) {
 		                        
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(component.getCodegenValue(property, (String) value));
    stringBuffer.append(TEXT_139);
    
 		                    }
 		                } else if (value != null && "java.util.Date".equals(property.getType())){
 		                    
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(component.getCodegenValue(property, value.toString()));
    stringBuffer.append(TEXT_143);
    
 		                } else if (property instanceof org.talend.daikon.properties.property.EnumProperty) {
 		                    
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(property.getType().replaceAll("<.*>", ""));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(property.getValue());
    stringBuffer.append(TEXT_148);
    
 		                } else if (property instanceof org.talend.daikon.properties.property.SchemaProperty) {
 		                    
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(component.getCodegenValue(property, property.getStringValue()));
    stringBuffer.append(TEXT_152);
    
 		                } else if (!(value instanceof String) || !((String)value).equals("")) {
 		                    
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(component.getCodegenValue(property, value.toString()));
    stringBuffer.append(TEXT_156);
    
 		                }
 		            }
 		            if("java.lang.Integer".equals(property.getType()) && (value == null || ((value instanceof String) && ((String)value).isEmpty()))) {//need to overwrite the default value when the passed value is null or empty string from the model
 		        	
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_159);
    
 		            }
     }
     
     private boolean isDynamicValue(String value, String connName) {
		if(value == null) {
			return false;
		}
		boolean dynamicByGlobals = ContextParameterUtils.isContainContextParam(value) || ContextParameterUtils.containCodeVariable(value, "globalMap.");
		if(connName == null || dynamicByGlobals) {
			return dynamicByGlobals;
		}
		return ContextParameterUtils.containCodeVariable(value, connName + ".");
	}
 
 }
 
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
Component component = (Component)node.getComponent();
ComponentProperties componentProps = node.getComponentProperties();
ComponentDefinition def = component.getComponentDefinition();

List<IMetadataTable> metadatas = node.getMetadataList();
IMetadataTable metadata = null;
List<IMetadataColumn> columnList = null;
if ((metadatas != null) && (metadatas.size() > 0)) { // metadata
    metadata = metadatas.get(0);
    if(metadata != null){
        columnList = metadata.getListColumns();
    }
}

// Set up the component definition, and the properties for all types of
// components.


    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append( def.getClass().getName());
    stringBuffer.append(TEXT_162);
    
List<Component.CodegenPropInfo> propsToProcess = component.getCodegenPropInfos(componentProps);

    stringBuffer.append(TEXT_163);
    stringBuffer.append(TEXT_164);
    stringBuffer.append( componentProps.getClass().getName());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append( componentProps.getClass().getName());
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    

final Set<String> referenceProperties = new HashSet<String>();

boolean hasInput = !NodeUtil.getIncomingConnections(node, IConnectionCategory.DATA).isEmpty();

String connName = null;
if(hasInput) {
	IConnection main = null;
    List<? extends IConnection> mains = NodeUtil.getIncomingConnections(node, IConnectionCategory.DATA);
    if (mains!=null && !mains.isEmpty()) {
        main = mains.get(0);
        connName = main.getName();
    }
}
ProcessPropertiesGenerator generator = new ProcessPropertiesGenerator(cid, component);
List<String> referenceableProperties = new ArrayList<String>();

for (Component.CodegenPropInfo propInfo : propsToProcess) { // propInfo
    List<NamedThing> properties = propInfo.props.getProperties();
    for (NamedThing prop : properties) { // property
        if (prop instanceof Property) { // if, only deal with valued Properties
            Property property = (Property)prop;
            if (property.getFlags() != null && (property.getFlags().contains(Property.Flags.DESIGN_TIME_ONLY) || property.getFlags().contains(Property.Flags.HIDDEN)))
                continue;
            generator.setPropertyValues(property, propInfo, connName, true, true);
        } else if (prop instanceof ComponentReferenceProperties) {
            final String fieldString = propInfo.fieldName + "." + prop.getName();
            referenceProperties.add(fieldString);
            referenceableProperties.add(propInfo.fieldName);
        } //else may be a ComponentProperties so ignore
    } // property
} // propInfo

// Now that we know all ComponentReferenceProperties, we can re-itereate to remove tags for related properties.
// So it removes tag for context variables for properties such as connection.
for (Component.CodegenPropInfo propInfo : propsToProcess) {
    for (NamedThing prop : propInfo.props.getProperties()) {
        if (prop instanceof Property) {
            Property property = (Property)prop;
            if (property.getFlags() != null &&
                (property.getFlags().contains(Property.Flags.DESIGN_TIME_ONLY) || property.getFlags().contains(Property.Flags.HIDDEN)) &&
                (property.getTaggedValue(IGenericConstants.DYNAMIC_PROPERTY_VALUE) == null)){
                continue;
            }
            boolean referenced = false;
            for(String r: referenceableProperties){
            		if(r == null || r.isEmpty()) {
            			continue;
            		}
                referenced = referenced || propInfo.fieldName.startsWith(r);
            }
            if (referenced){
                property.setTaggedValue(IGenericConstants.DYNAMIC_PROPERTY_VALUE, "false");
            }
        }
    }
}

for (final String fieldString : referenceProperties) {
    
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(fieldString );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(fieldString );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(fieldString );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    
}

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    
boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
if (isParallelize) {

    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
}

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
boolean hasOutput = !NodeUtil.getOutgoingConnections(node, IConnectionCategory.DATA).isEmpty();
boolean hasOutputOnly = hasOutput && !hasInput;

if (hasInput && hasOutput) {

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
} else if (hasInput) {

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    
} else if (hasOutput) {

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
} else {

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
}

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    
// Return at this point if there is no metadata.
if (metadata == null) {
    return stringBuffer.toString();
}

Set<ConnectorTopology> connectorTopologies = def.getSupportedConnectorTopologies();
boolean asInputComponent = connectorTopologies!=null && (connectorTopologies.size() < 3) && connectorTopologies.contains(ConnectorTopology.OUTGOING);

List< ? extends IConnection> iterateLine = node.getOutgoingConnections(EConnectionType.ITERATE);
boolean hasIterateLine = iterateLine!=null && !iterateLine.isEmpty();
boolean isTopologyNone = !hasOutput && !hasInput && !hasIterateLine;

if(isTopologyNone) {
    return stringBuffer.toString();
}

if (hasOutputOnly || asInputComponent) {
    
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    
    IConnection main = null;
    List<? extends IConnection> mains = node.getOutgoingConnections("MAIN");
    if (mains!=null && !mains.isEmpty()) {
        main = mains.get(0);
    }

    IConnection reject = null;
    List<? extends IConnection> rejects = node.getOutgoingConnections("REJECT");
    if (rejects != null && !rejects.isEmpty()) {
        reject = rejects.get(0);
    }

	boolean hasDataOutput = (main != null || reject != null);
	IndexedRecordToRowStructGenerator irToRow = null;

	if(hasDataOutput) {
    	IConnection schemaSourceConnector = (main!=null ? main : reject);
    	String schemaSourceConnectorName = schemaSourceConnector.getMetadataTable().getAttachedConnector();
	
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
     //take care SourceOrSink.validate will change the schema if it contains include-all-fields, so need to get design Avro schema before validate 
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(schemaSourceConnectorName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
    	irToRow = new IndexedRecordToRowStructGenerator(cid, null, columnList);
    	irToRow.generateInitialVariables("schema_" + cid, false);
    }
    
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    if(hasDataOutput) {
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    if(main!=null){
    stringBuffer.append(TEXT_260);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_261);
    }
    stringBuffer.append(TEXT_262);
    if(reject!=null){
    stringBuffer.append(TEXT_263);
    stringBuffer.append(reject.getName());
    stringBuffer.append(TEXT_264);
    }
    stringBuffer.append(TEXT_265);
    }
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    
            if (main != null) {
                
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_272);
    stringBuffer.append(main.getName() );
    stringBuffer.append(TEXT_273);
    
                irToRow.generateConvertRecord("data_" + cid, main.getName(), main.getMetadataTable().getListColumns());
            }
            
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    
            if (reject!=null) {
                
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(reject.getName());
    stringBuffer.append(TEXT_283);
    stringBuffer.append(reject.getName() );
    stringBuffer.append(TEXT_284);
    
                irToRow.generateConvertRecord("data_" + cid, reject.getName());
                
    stringBuffer.append(TEXT_285);
    
                Set<String> commonColumns = new HashSet<String>();

                for (IMetadataColumn column : columnList) {
                    commonColumns.add(column.getLabel());
                }

                //pass error columns
                List<IMetadataColumn> rejectColumns = reject.getMetadataTable().getListColumns();
                for(IMetadataColumn column : rejectColumns) {
                    String columnName = column.getLabel();

                    // JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

                    //error columns
                    if(!commonColumns.contains(columnName)) {
                        
    stringBuffer.append(TEXT_286);
    stringBuffer.append(reject.getName());
    stringBuffer.append(TEXT_287);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_291);
    
                    }
                }
            } else {
            
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
            }
            if (main != null) {
            
    stringBuffer.append(TEXT_305);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_306);
    
            }
        
    stringBuffer.append(TEXT_307);
    
    // The for loop around the incoming records from the reader is left open.


} else if (hasInput) {
    
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    
    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    if (outgoingConns!=null){
        for (IConnection outgoingConn : outgoingConns) {
            if ("MAIN".equals(outgoingConn.getConnectorName())) {
                
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    
                IndexedRecordToRowStructGenerator mainIrToRow = new IndexedRecordToRowStructGenerator(
                        cid + "OutMain", outgoingConn);
                mainIrToRow.generateInitialVariables("mainSchema_" + cid, false);
            }
            if ("REJECT".equals(outgoingConn.getConnectorName())) {
                
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    
                IndexedRecordToRowStructGenerator rejectIrToRow = new IndexedRecordToRowStructGenerator(
                        cid + "OutReject", outgoingConn);
                rejectIrToRow.generateInitialVariables("rejectSchema_" + cid, false);
            }
        }
    }
}

    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(TEXT_347);
    return stringBuffer.toString();
  }
}

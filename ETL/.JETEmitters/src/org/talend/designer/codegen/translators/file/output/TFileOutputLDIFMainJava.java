package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TFileOutputLDIFMainJava
{
  protected static String nl;
  public static synchronized TFileOutputLDIFMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputLDIFMainJava result = new TFileOutputLDIFMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + "\t\t//////////////////////////" + NL + "\t\tboolean encodingBase64_";
  protected final String TEXT_32 = " = false;" + NL + "\t\tboolean encodedBase64_";
  protected final String TEXT_33 = " = false;";
  protected final String TEXT_34 = NL + "        \t\tStringBuilder sb_";
  protected final String TEXT_35 = " = new StringBuilder();" + NL + "        \t\tboolean needSeparator_";
  protected final String TEXT_36 = " = false;" + NL + "        \t\tboolean canOutput_";
  protected final String TEXT_37 = " = false;" + NL + "        \t\tboolean isPrintable_";
  protected final String TEXT_38 = " = false;";
  protected final String TEXT_39 = NL + "            \t\tencodingBase64_";
  protected final String TEXT_40 = " = false;" + NL + "            \t\tencodedBase64_";
  protected final String TEXT_41 = " = false;" + NL + "            \t\tString value_";
  protected final String TEXT_42 = "_";
  protected final String TEXT_43 = " = \"\";" + NL + "            \t\t";
  protected final String TEXT_44 = NL + "            \t\t\tif(needSeparator_";
  protected final String TEXT_45 = "){" + NL + "            \t\t\t\tsb_";
  protected final String TEXT_46 = ".append(\"-\\n\");" + NL + "            \t\t\t\tneedSeparator_";
  protected final String TEXT_47 = " = false;" + NL + "            \t\t\t}" + NL + "            \t\t";
  protected final String TEXT_48 = NL + "\t    if(";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = " != null && !(\"\").equals(";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = ")) {";
  protected final String TEXT_53 = NL + "    \tvalue_";
  protected final String TEXT_54 = "_";
  protected final String TEXT_55 = " =";
  protected final String TEXT_56 = NL + "\t\tFormatterUtils.format_Date(";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = ", ";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "\t\t";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = ";";
  protected final String TEXT_63 = NL + "\t\tString.valueOf(";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t\torg.apache.commons.codec.binary.Base64.encodeBase64String(";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = ");" + NL + "\t\tencodedBase64_";
  protected final String TEXT_68 = " = true;";
  protected final String TEXT_69 = NL + "\t\tString.valueOf(";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "         if(util_";
  protected final String TEXT_73 = ".needBase64ForDN(value_";
  protected final String TEXT_74 = "_";
  protected final String TEXT_75 = ")){" + NL + "               dn_";
  protected final String TEXT_76 = " = \"dn:: \";" + NL + "               value_";
  protected final String TEXT_77 = "_";
  protected final String TEXT_78 = " = org.apache.commons.codec.binary.Base64.encodeBase64String(" + NL + "                                                         value_";
  protected final String TEXT_79 = "_";
  protected final String TEXT_80 = ".getBytes(";
  protected final String TEXT_81 = ")" + NL + "                                                         );" + NL + "         }";
  protected final String TEXT_82 = NL + "        util_";
  protected final String TEXT_83 = ".breakString(sb_";
  protected final String TEXT_84 = ", dn_";
  protected final String TEXT_85 = " + value_";
  protected final String TEXT_86 = "_";
  protected final String TEXT_87 = ", wrap_";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = NL + "        util_";
  protected final String TEXT_90 = ".breakString(sb_";
  protected final String TEXT_91 = ", changetype_";
  protected final String TEXT_92 = " + \"";
  protected final String TEXT_93 = "\", wrap_";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL;
  protected final String TEXT_96 = NL + "\tcanOutput_";
  protected final String TEXT_97 = " = true;";
  protected final String TEXT_98 = NL;
  protected final String TEXT_99 = NL + "\t    }  ";
  protected final String TEXT_100 = NL + "\t    }";
  protected final String TEXT_101 = NL + "//////////////////////////////////////////////////" + NL + "Please check \"isBase64\" for column ";
  protected final String TEXT_102 = " when \"isBianry\" is checked." + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_103 = NL + "\t\t\t\t\t\t// Convert binary or Base64 value to Base64 encoded string" + NL + "\t\t\t\t\t\tencodingBase64_";
  protected final String TEXT_104 = " = true;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_105 = NL;
  protected final String TEXT_106 = NL + "\tutil_";
  protected final String TEXT_107 = ".breakString(sb_";
  protected final String TEXT_108 = ", \"";
  protected final String TEXT_109 = ": \" + \"";
  protected final String TEXT_110 = "\", wrap_";
  protected final String TEXT_111 = ");" + NL + "\t";
  protected final String TEXT_112 = NL + "\t\tString[] values_";
  protected final String TEXT_113 = "_";
  protected final String TEXT_114 = " = value_";
  protected final String TEXT_115 = "_";
  protected final String TEXT_116 = ".split(";
  protected final String TEXT_117 = ");" + NL + "\t\tfor(String item_";
  protected final String TEXT_118 = " : values_";
  protected final String TEXT_119 = "_";
  protected final String TEXT_120 = "){" + NL + "\t\t\t// follow LDIF rules or not";
  protected final String TEXT_121 = NL + "               \t\t   isPrintable_";
  protected final String TEXT_122 = " = !(util_";
  protected final String TEXT_123 = ".needEncodeBase64(item_";
  protected final String TEXT_124 = "));" + NL + "               \t\t";
  protected final String TEXT_125 = NL + "               \t\t   isPrintable_";
  protected final String TEXT_126 = " =  netscape.ldap.util.LDIF.isPrintable(item_";
  protected final String TEXT_127 = ".getBytes(";
  protected final String TEXT_128 = "));" + NL + "               \t\t";
  protected final String TEXT_129 = NL + "\t\t\t\t// If content doesn't follow LDIF rules, it must be base64 encoded" + NL + "\t\t\t\tif(!isPrintable_";
  protected final String TEXT_130 = "){" + NL + "\t\t\t\t\tencodingBase64_";
  protected final String TEXT_131 = " = true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\telse{" + NL + "\t\t\t\t\tencodingBase64_";
  protected final String TEXT_132 = " = false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_133 = NL + "\t\t\t\titem_";
  protected final String TEXT_134 = " = util_";
  protected final String TEXT_135 = ".getBase64StringOrNot(encodingBase64_";
  protected final String TEXT_136 = ",encodedBase64_";
  protected final String TEXT_137 = ",item_";
  protected final String TEXT_138 = ",";
  protected final String TEXT_139 = ");" + NL + "\t\t\t\tutil_";
  protected final String TEXT_140 = ".breakString(sb_";
  protected final String TEXT_141 = ", \"";
  protected final String TEXT_142 = "\" + item_";
  protected final String TEXT_143 = ", wrap_";
  protected final String TEXT_144 = ");" + NL + "\t\t}";
  protected final String TEXT_145 = NL + "\t\t// follow LDIF rules or not" + NL + "\t\t";
  protected final String TEXT_146 = NL + "\t\t   \t\t   isPrintable_";
  protected final String TEXT_147 = " = !(util_";
  protected final String TEXT_148 = ".needEncodeBase64(value_";
  protected final String TEXT_149 = "_";
  protected final String TEXT_150 = "));" + NL + "\t\t   \t\t";
  protected final String TEXT_151 = NL + "\t\t   \t\t   isPrintable_";
  protected final String TEXT_152 = " =  netscape.ldap.util.LDIF.isPrintable(value_";
  protected final String TEXT_153 = "_";
  protected final String TEXT_154 = ".getBytes(";
  protected final String TEXT_155 = "));" + NL + "\t\t   \t\t";
  protected final String TEXT_156 = NL + "\t\t\t// If content doesn't follow LDIF rules, it must be base64 encoded" + NL + "\t\t\tif(!isPrintable_";
  protected final String TEXT_157 = "){" + NL + "\t\t\t\tencodingBase64_";
  protected final String TEXT_158 = " = true;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_159 = NL + "\t\t\tvalue_";
  protected final String TEXT_160 = "_";
  protected final String TEXT_161 = " = util_";
  protected final String TEXT_162 = ".getBase64StringOrNot(encodingBase64_";
  protected final String TEXT_163 = ",encodedBase64_";
  protected final String TEXT_164 = ",value_";
  protected final String TEXT_165 = "_";
  protected final String TEXT_166 = ",";
  protected final String TEXT_167 = ");" + NL + "\t\t\tutil_";
  protected final String TEXT_168 = ".breakString(sb_";
  protected final String TEXT_169 = ", \"";
  protected final String TEXT_170 = "\" + value_";
  protected final String TEXT_171 = "_";
  protected final String TEXT_172 = ", wrap_";
  protected final String TEXT_173 = ");";
  protected final String TEXT_174 = NL + "\tneedSeparator_";
  protected final String TEXT_175 = " = true;" + NL + "\tcanOutput_";
  protected final String TEXT_176 = " = true;";
  protected final String TEXT_177 = NL + "sb_";
  protected final String TEXT_178 = ".append(\"-\\n\");";
  protected final String TEXT_179 = NL + "//////////////////////////////////////////////////" + NL + "Please check \"isBase64\" for column ";
  protected final String TEXT_180 = " when \"isBinary\" is checked." + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_181 = NL + "\t\t\t\t\t\t// Convert binary or Base64 value to Base64 encoded string" + NL + "\t\t\t\t\t\tencodingBase64_";
  protected final String TEXT_182 = " = true;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_183 = NL + "\t";
  protected final String TEXT_184 = NL + "\t\tString[] values_";
  protected final String TEXT_185 = "_";
  protected final String TEXT_186 = " = value_";
  protected final String TEXT_187 = "_";
  protected final String TEXT_188 = ".split(";
  protected final String TEXT_189 = ");" + NL + "\t\tfor(String item_";
  protected final String TEXT_190 = " : values_";
  protected final String TEXT_191 = "_";
  protected final String TEXT_192 = "){" + NL + "\t\t        //follow LDIF rules or not" + NL + "\t\t        ";
  protected final String TEXT_193 = NL + "\t\t           \t\t   isPrintable_";
  protected final String TEXT_194 = " = !(util_";
  protected final String TEXT_195 = ".needEncodeBase64(item_";
  protected final String TEXT_196 = "));" + NL + "\t\t           \t\t";
  protected final String TEXT_197 = NL + "\t\t           \t\t   isPrintable_";
  protected final String TEXT_198 = " =  netscape.ldap.util.LDIF.isPrintable(item_";
  protected final String TEXT_199 = ".getBytes(";
  protected final String TEXT_200 = "));" + NL + "\t\t           \t\t";
  protected final String TEXT_201 = NL + "\t\t\t\t\t// If content doesn't follow LDIF rules, it must be base64 encoded" + NL + "\t\t\t\t\tif(!isPrintable_";
  protected final String TEXT_202 = "){" + NL + "\t\t\t\t\t\tencodingBase64_";
  protected final String TEXT_203 = " = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\telse{" + NL + "\t\t\t\t\t\tencodingBase64_";
  protected final String TEXT_204 = " = false;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_205 = NL + "\t                item_";
  protected final String TEXT_206 = " = util_";
  protected final String TEXT_207 = ".getBase64StringOrNot(encodingBase64_";
  protected final String TEXT_208 = ",encodedBase64_";
  protected final String TEXT_209 = ",item_";
  protected final String TEXT_210 = ",";
  protected final String TEXT_211 = ");" + NL + "\t                util_";
  protected final String TEXT_212 = ".breakString(sb_";
  protected final String TEXT_213 = ", \"";
  protected final String TEXT_214 = "\" + item_";
  protected final String TEXT_215 = ", wrap_";
  protected final String TEXT_216 = ");" + NL + "\t\t}";
  protected final String TEXT_217 = NL + "                // follow LDIF rules or not";
  protected final String TEXT_218 = NL + "                   \t\t   isPrintable_";
  protected final String TEXT_219 = " = !(util_";
  protected final String TEXT_220 = ".needEncodeBase64(value_";
  protected final String TEXT_221 = "_";
  protected final String TEXT_222 = "));" + NL + "                   \t\t";
  protected final String TEXT_223 = NL + "                   \t\t   isPrintable_";
  protected final String TEXT_224 = " =  netscape.ldap.util.LDIF.isPrintable(value_";
  protected final String TEXT_225 = "_";
  protected final String TEXT_226 = ".getBytes(";
  protected final String TEXT_227 = "));" + NL + "                   \t\t";
  protected final String TEXT_228 = NL + "\t\t\t\t\t// If content doesn't follow LDIF rules, it must be base64 encoded" + NL + "\t\t\t\t\tif(!isPrintable_";
  protected final String TEXT_229 = "){" + NL + "\t\t\t\t\t\tencodingBase64_";
  protected final String TEXT_230 = " = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_231 = NL + "\t\t\t\tvalue_";
  protected final String TEXT_232 = "_";
  protected final String TEXT_233 = " = util_";
  protected final String TEXT_234 = ".getBase64StringOrNot(encodingBase64_";
  protected final String TEXT_235 = ",encodedBase64_";
  protected final String TEXT_236 = ",value_";
  protected final String TEXT_237 = "_";
  protected final String TEXT_238 = ",";
  protected final String TEXT_239 = ");" + NL + "\t\t\t\tutil_";
  protected final String TEXT_240 = ".breakString(sb_";
  protected final String TEXT_241 = ", \"";
  protected final String TEXT_242 = "\" + value_";
  protected final String TEXT_243 = "_";
  protected final String TEXT_244 = ", wrap_";
  protected final String TEXT_245 = ");";
  protected final String TEXT_246 = NL + "\t\tcanOutput_";
  protected final String TEXT_247 = " = true;";
  protected final String TEXT_248 = NL + "\t\tutil_";
  protected final String TEXT_249 = ".breakString(sb_";
  protected final String TEXT_250 = ", \"";
  protected final String TEXT_251 = ": \" + value_";
  protected final String TEXT_252 = "_";
  protected final String TEXT_253 = ", wrap_";
  protected final String TEXT_254 = ");" + NL + "\t\tcanOutput_";
  protected final String TEXT_255 = " = true;";
  protected final String TEXT_256 = NL;
  protected final String TEXT_257 = NL + "\t    }";
  protected final String TEXT_258 = NL + "\t\tsb_";
  protected final String TEXT_259 = ".append('\\n');" + NL + "" + NL + "\tif(canOutput_";
  protected final String TEXT_260 = "){" + NL + "\t\tpw_";
  protected final String TEXT_261 = ".write(sb_";
  protected final String TEXT_262 = ".toString());" + NL + "\t\t";
  protected final String TEXT_263 = NL + "            if(nb_line_";
  protected final String TEXT_264 = "%";
  protected final String TEXT_265 = " == 0) {" + NL + "    \t\tpw_";
  protected final String TEXT_266 = ".flush();" + NL + "    \t\t}" + NL + "\t\t";
  protected final String TEXT_267 = NL + NL + "    \tnb_line_";
  protected final String TEXT_268 = "++;" + NL + "    }";
  protected final String TEXT_269 = NL + "    \t//////////////////////////";
  protected final String TEXT_270 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_30);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
boolean willValidateDN = "true".equals(ElementParameterParser.getValue(node,"__VALIDATE_DISTINGUISHED_NAME__"));

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        String cid = node.getUniqueName();
        String changetype = ElementParameterParser.getValue(node, "__CHANGETYPE__");
        boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
        String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");

        List<Map<String, String>> multiValueColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MULTIVALUECOLUMNS__");
        List<Map<String, String>> modifyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MODIFYCONFIG__");
        
        class LDIFUtil{
        	public String getAttributeType(IMetadataTable metadata, String columnName,boolean isBinary){
            	List<IMetadataColumn> columns_sub = metadata.getListColumns();
                for (int j = 0; j < columns_sub.size(); j++) {
                    IMetadataColumn column_sub = columns_sub.get(j);
                    JavaType javaType_sub = JavaTypesManager.getJavaTypeFromId(column_sub.getTalendType());
                    if(column_sub.getLabel().equals(columnName)){
                    	if(javaType_sub == JavaTypesManager.BYTE_ARRAY && isBinary){
                    		return columnName+";binary";
                    	}else{
                    		return columnName;
                    	}
                    }
                }
                throw new IllegalArgumentException("Specified column name \""+columnName+"\" not exist in metadata!");
        	}
        }
        LDIFUtil ldifUtil = new LDIFUtil();

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
    	List<? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    
    			boolean generateOneAlready = false; //only for Modify append the char '-'
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			boolean firstLoop = true;
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    //For bug TDI-26863
            		String modify_operation = null;
            		for(Map<String, String> line:modifyColumns){
            			String columnName = line.get("SCHEMA_COLUMN");
            			if(column.getLabel().equals(columnName)){
            				modify_operation = line.get("OPERATION");
            				break;
            			}
            		}
            		if(i > 1 && "modify".equals(changetype) && !("none".equals(modify_operation))) {
            		
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    
            		}
					if(!isPrimitive) {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_52);
    
} // closure for if(!isPrimitive) Line: 76

    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_59);
    
					} else if(javaType == JavaTypesManager.STRING) {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_62);
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_64);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
					} else {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_71);
    
					}
	if(i==0) {
  if(willValidateDN){
      
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( encoding );
    stringBuffer.append(TEXT_81);
    
  }
 
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    if(!"none".equals(changetype)){
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(changetype );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    if("delete".equals(changetype)){
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    
	if(!isPrimitive) {

    stringBuffer.append(TEXT_99);
     /* closure for Line: 78 */ 
    
	} // closure for if(!isPrimitive) Line: 118
	continue;
 } //Line:52 "for (int i = 0; i < sizeColumns; i++)"
if ("delete".equals(changetype)) {
	if(firstLoop){
	if(!isPrimitive) {

    stringBuffer.append(TEXT_100);
    
	}
	}
	firstLoop = false;
	break;
}
if ("modify".equals(changetype)) {
		String operation = null;
		boolean isMultiValue = false;
		String separator = null;
		boolean isBinary = false;
		boolean isBase64 = false;
		for(Map<String, String> line:modifyColumns){// search in the configuration table
				String columnName = line.get("SCHEMA_COLUMN");
				if(column.getLabel().equals(columnName)){
					operation = line.get("OPERATION");
					isMultiValue = "true".equals(line.get("ISMULTIVALUE"));
					separator = line.get("SEPARATOR");
					isBinary = "true".equals(line.get("BINARY"));
					isBase64 = "true".equals(line.get("BASE64"));
					// Binary content --> always Base64 encoded
					// Explicit base64 encoding : base64 checkbox checked for this column
					if(isBinary && !isBase64){

    stringBuffer.append(TEXT_101);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_102);
    
					}
					if(isBinary || isBase64){
						
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
					}
					break;
				}
		}

    stringBuffer.append(TEXT_105);
    if(!"none".equals(operation)){
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(operation );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(ldifUtil.getAttributeType(metadata,column.getLabel(),isBinary).replaceAll(":","") );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    if(isMultiValue){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(separator );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    
               if(willValidateDN){
               		
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    
               }else{
               		
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_128);
    
               }
			// Not binary and no explicit base64 encoding --> check if base 64 encoding needed
			if(!isBinary && !isBase64){
				
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
			}
			
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(ldifUtil.getAttributeType(metadata,column.getLabel(),isBinary) );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    
	}else{

    stringBuffer.append(TEXT_145);
    
		   if(willValidateDN){
		   		
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    
		   }else{
		   		
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_155);
    
		   }
		// Not binary and no explicit base64 encoding --> check if base 64 encoding needed
		if(!isBinary && !isBase64){

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
		}
		
    stringBuffer.append(TEXT_159);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(ldifUtil.getAttributeType(metadata,column.getLabel(),isBinary) );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    
	}

    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    }
  if(i==sizeColumns - 1){

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    }
}// here end the if modify

     if ("add".equals(changetype) || "none".equals(changetype)) {
		boolean isMultiValue = false;
		String separator = null;
		boolean isBinary = false;
		boolean isBase64 = false;
		for(Map<String, String> line:multiValueColumns){// search in the configuration table
				String columnName = line.get("SCHEMA_COLUMN");
				if(column.getLabel().equals(columnName)){
					isMultiValue = "true".equals(line.get("ISMULTIVALUE"));
					separator = line.get("SEPARATOR");
					isBinary = "true".equals(line.get("BINARY"));
					isBase64 = "true".equals(line.get("BASE64"));
					// Binary content --> always Base64 encoded
					// Explicit base64 encoding : base64 checkbox checked for this column
                    if(isBinary && !isBase64){

    stringBuffer.append(TEXT_179);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_180);
    
                    }
					if(isBinary || isBase64){
						
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
					}
					break;
				}
		}

    stringBuffer.append(TEXT_183);
    if(isMultiValue){
    stringBuffer.append(TEXT_184);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(separator );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    
		           if(willValidateDN){
		           		
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    
		           }else{
		           		
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_200);
    
		           }
				// Not binary and no explicit base64 encoding --> check if base 64 encoding needed
				if(!isBinary && !isBase64){
					
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    
				}
				
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(ldifUtil.getAttributeType(metadata,column.getLabel(),isBinary) );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    
	}else{

    stringBuffer.append(TEXT_217);
    
                   if(willValidateDN){
                   		
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    
                   }else{
                   		
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_227);
    
                   }
				// Not binary and no explicit base64 encoding --> check if base 64 encoding needed
				if(!isBinary && !isBase64){

    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
				}
			
    stringBuffer.append(TEXT_231);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(ldifUtil.getAttributeType(metadata,column.getLabel(),isBinary) );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    
	}

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    
}// here end the if add

     if ("modrdn".equals(changetype)) {

    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    
}// here end the if modrdn

    stringBuffer.append(TEXT_256);
    
	if(!isPrimitive) {

    stringBuffer.append(TEXT_257);
    
	}

    
}//here end the last for, the List "columns"

    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
     if(flushOnRow) { 
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    
			}
		
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    
		log4jFileUtil.debugWriteData(node);
	}
}//here end the first for, the List "conns"

    stringBuffer.append(TEXT_269);
    
  }
}

    stringBuffer.append(TEXT_270);
    return stringBuffer.toString();
  }
}

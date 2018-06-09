package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;
import java.util.Map;

public class TFileInputPositionalBeginJava
{
  protected static String nl;
  public static synchronized TFileInputPositionalBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputPositionalBeginJava result = new TFileInputPositionalBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
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
  protected final String TEXT_30 = NL + "    \t\tboolean useStar_";
  protected final String TEXT_31 = " = false;" + NL + "    \t\t";
  protected final String TEXT_32 = NL + "            \tString pattern_";
  protected final String TEXT_33 = " = \"";
  protected final String TEXT_34 = "\";" + NL + "            \t";
  protected final String TEXT_35 = NL + "            \tString pattern_";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = ";" + NL + "            \t";
  protected final String TEXT_38 = NL + "                final String[] positions_";
  protected final String TEXT_39 = " = pattern_";
  protected final String TEXT_40 = ".trim().split(\",\");" + NL + "                for(int i_";
  protected final String TEXT_41 = "=0;i_";
  protected final String TEXT_42 = "<positions_";
  protected final String TEXT_43 = ".length;i_";
  protected final String TEXT_44 = "++){" + NL + "                \tif(\"\".equals(positions_";
  protected final String TEXT_45 = "[i_";
  protected final String TEXT_46 = "])){" + NL + "                   \t \tpositions_";
  protected final String TEXT_47 = "[i_";
  protected final String TEXT_48 = "]=\"0\";" + NL + "                \t}" + NL + "                \tif(\"*\".equals(positions_";
  protected final String TEXT_49 = "[i_";
  protected final String TEXT_50 = "])){" + NL + "                \t\tuseStar_";
  protected final String TEXT_51 = " = true;" + NL + "                \t}" + NL + "                }";
  protected final String TEXT_52 = NL + "\t\t\t\tuseStar_";
  protected final String TEXT_53 = " = true;" + NL + "\t\t\t\t" + NL + "\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_54 = " = (routines.system.Dynamic)globalMap.get(\"";
  protected final String TEXT_55 = "\");" + NL + "\t\t\t\tint maxColumnCount_";
  protected final String TEXT_56 = " = dynamic_";
  protected final String TEXT_57 = ".getColumnCount();" + NL + "\t\t\t\tdynamic_";
  protected final String TEXT_58 = ".clearColumnValues();" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "            int nb_line_";
  protected final String TEXT_60 = " = 0;" + NL + "            int footer_";
  protected final String TEXT_61 = "  = ";
  protected final String TEXT_62 = ";" + NL + "            int nb_limit_";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ";" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_65 = NL + "                class Arrays_";
  protected final String TEXT_66 = "{" + NL + "                    public byte[] copyOfRange(byte[] original, int from, int to) {" + NL + "                        int newLength = to - from;" + NL + "                        if (newLength < 0)" + NL + "                            throw new IllegalArgumentException(from + \" > \" + to);" + NL + "                        byte[] copy = new byte[newLength];" + NL + "                        System.arraycopy(original, from, copy, 0," + NL + "                                         Math.min(original.length - from, newLength));" + NL + "                        return copy;" + NL + "                    }" + NL + "                }" + NL + "                Arrays_";
  protected final String TEXT_67 = " arrays_";
  protected final String TEXT_68 = " = new Arrays_";
  protected final String TEXT_69 = "();" + NL + "\t\t\t";
  protected final String TEXT_70 = NL + NL + "\t\t\tclass PositionalUtil_";
  protected final String TEXT_71 = "{" + NL + "\t\t\t\tprivate boolean useStar = false;" + NL + "                \t\t\t\t" + NL + "\t\t\t\tpublic void setUseStar(boolean useStar) {" + NL + "\t\t\t\t\tthis.useStar = useStar;" + NL + "\t\t\t\t}";
  protected final String TEXT_72 = NL + "                \t\t\t\tprivate final int sizeListColumns = ";
  protected final String TEXT_73 = ";" + NL + "                \t\t\t\tprivate int currentRow = 0;" + NL + "                \t\t\t\t";
  protected final String TEXT_74 = NL + "                  \t\t\t\t\t\tvoid setValue_";
  protected final String TEXT_75 = "(";
  protected final String TEXT_76 = "Struct ";
  protected final String TEXT_77 = ",int[] begins_";
  protected final String TEXT_78 = ",int[] ends_";
  protected final String TEXT_79 = ",int rowLen_";
  protected final String TEXT_80 = "," + NL + "                  \t\t\t\t\t\t";
  protected final String TEXT_81 = "byte[] byteArray_";
  protected final String TEXT_82 = ",Arrays_";
  protected final String TEXT_83 = " arrays_";
  protected final String TEXT_84 = ",";
  protected final String TEXT_85 = "String column_";
  protected final String TEXT_86 = ",String row_";
  protected final String TEXT_87 = ")throws java.lang.Exception {  " + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tcurrentRow = ";
  protected final String TEXT_89 = ";" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tif((currentRow == (sizeListColumns-1)) && useStar) {" + NL + "    \t\t\t\t\t\t\t\t\tif(begins_";
  protected final String TEXT_90 = "[";
  protected final String TEXT_91 = "] < rowLen_";
  protected final String TEXT_92 = "){" + NL + "        \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_93 = NL + "                                            \tbyteArray_";
  protected final String TEXT_94 = "=arrays_";
  protected final String TEXT_95 = ".copyOfRange(row_";
  protected final String TEXT_96 = ".getBytes(";
  protected final String TEXT_97 = "),begins_";
  protected final String TEXT_98 = "[";
  protected final String TEXT_99 = "],rowLen_";
  protected final String TEXT_100 = ");" + NL + "                                            \tcolumn_";
  protected final String TEXT_101 = " = TalendString.talendTrim(new String(byteArray_";
  protected final String TEXT_102 = ",";
  protected final String TEXT_103 = "), ";
  protected final String TEXT_104 = ", ";
  protected final String TEXT_105 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_107 = " = TalendString.talendTrim(row_";
  protected final String TEXT_108 = ".substring(begins_";
  protected final String TEXT_109 = "[";
  protected final String TEXT_110 = "]), ";
  protected final String TEXT_111 = ", ";
  protected final String TEXT_112 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_113 = NL + "                                        }else{" + NL + "                                        \tcolumn_";
  protected final String TEXT_114 = " = \"\";" + NL + "                                        }" + NL + "                                    } else {" + NL + "                                    \t";
  protected final String TEXT_115 = NL + "\t\t\t\t\t\t\t\t\t\t\tif(begins_";
  protected final String TEXT_116 = "[";
  protected final String TEXT_117 = "] < rowLen_";
  protected final String TEXT_118 = "){" + NL + "        \t\t\t\t\t\t\t\t\t\tif(ends_";
  protected final String TEXT_119 = "[";
  protected final String TEXT_120 = "] <= rowLen_";
  protected final String TEXT_121 = "){" + NL + "        \t\t\t\t\t\t\t\t\t\t\tbyteArray_";
  protected final String TEXT_122 = " = arrays_";
  protected final String TEXT_123 = ".copyOfRange(row_";
  protected final String TEXT_124 = ".getBytes(";
  protected final String TEXT_125 = "),begins_";
  protected final String TEXT_126 = "[";
  protected final String TEXT_127 = "],ends_";
  protected final String TEXT_128 = "[";
  protected final String TEXT_129 = "]);" + NL + "        \t\t\t\t\t\t\t\t\t\t}else{" + NL + "        \t\t\t\t\t\t\t\t\t\t\tbyteArray_";
  protected final String TEXT_130 = " = arrays_";
  protected final String TEXT_131 = ".copyOfRange(row_";
  protected final String TEXT_132 = ".getBytes(";
  protected final String TEXT_133 = "),begins_";
  protected final String TEXT_134 = "[";
  protected final String TEXT_135 = "],rowLen_";
  protected final String TEXT_136 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_137 = " = TalendString.talendTrim(new String(byteArray_";
  protected final String TEXT_138 = ",";
  protected final String TEXT_139 = "), ";
  protected final String TEXT_140 = ", ";
  protected final String TEXT_141 = ");" + NL + "    \t\t\t\t\t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_142 = " = \"\";" + NL + "    \t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\t\t\t\t\t\t\t\tif(begins_";
  protected final String TEXT_144 = "[";
  protected final String TEXT_145 = "] < rowLen_";
  protected final String TEXT_146 = "){" + NL + "        \t\t\t\t\t\t\t\t\t\tif(ends_";
  protected final String TEXT_147 = "[";
  protected final String TEXT_148 = "] <= rowLen_";
  protected final String TEXT_149 = "){" + NL + "        \t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_150 = " = TalendString.talendTrim(row_";
  protected final String TEXT_151 = ".substring(begins_";
  protected final String TEXT_152 = "[";
  protected final String TEXT_153 = "], ends_";
  protected final String TEXT_154 = "[";
  protected final String TEXT_155 = "]), ";
  protected final String TEXT_156 = ", ";
  protected final String TEXT_157 = ");" + NL + "        \t\t\t\t\t\t\t\t\t\t}else{" + NL + "        \t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_158 = " = TalendString.talendTrim(row_";
  protected final String TEXT_159 = ".substring(begins_";
  protected final String TEXT_160 = "[";
  protected final String TEXT_161 = "]), ";
  protected final String TEXT_162 = ", ";
  protected final String TEXT_163 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_164 = " = \"\";" + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_165 = NL + "                                    }" + NL + "                                        " + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_167 = " = column_";
  protected final String TEXT_168 = ".trim();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_170 = ".";
  protected final String TEXT_171 = " = column_";
  protected final String TEXT_172 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_173 = NL + "                \t\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_174 = " = (routines.system.Dynamic)globalMap.get(\"";
  protected final String TEXT_175 = "\");" + NL + "                \t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_176 = ".clearColumnValues();" + NL + "\t\t\t\t\t\t\t\t\t\t\tint maxColumnCount_";
  protected final String TEXT_177 = " = dynamic_";
  protected final String TEXT_178 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t\t\t\tint substringBegin";
  protected final String TEXT_179 = " = begins_";
  protected final String TEXT_180 = "[";
  protected final String TEXT_181 = "]; int substringEnd";
  protected final String TEXT_182 = " =0;" + NL + "\t\t\t\t\t\t\t\t\t\t\tfor (int i";
  protected final String TEXT_183 = "=0;i";
  protected final String TEXT_184 = "<maxColumnCount_";
  protected final String TEXT_185 = ";i";
  protected final String TEXT_186 = "++) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadataColumn_";
  protected final String TEXT_187 = " = dynamic_";
  protected final String TEXT_188 = ".getColumnMetadata(i";
  protected final String TEXT_189 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tint currentFieldLength_";
  protected final String TEXT_190 = " = dynamicMetadataColumn_";
  protected final String TEXT_191 = ".getLength();";
  protected final String TEXT_192 = NL + "                                                    substringEnd";
  protected final String TEXT_193 = " = substringBegin";
  protected final String TEXT_194 = "+currentFieldLength_";
  protected final String TEXT_195 = ";" + NL + "                                                    if(substringEnd";
  protected final String TEXT_196 = " > rowLen_";
  protected final String TEXT_197 = "){" + NL + "                                                        substringEnd";
  protected final String TEXT_198 = " = rowLen_";
  protected final String TEXT_199 = ";" + NL + "                                                    }";
  protected final String TEXT_200 = NL + "                                                    int codePointCount = currentFieldLength_";
  protected final String TEXT_201 = ";" + NL + "                                                    int codePointCountLeft = row_";
  protected final String TEXT_202 = ".codePointCount(substringBegin";
  protected final String TEXT_203 = ", rowLen_";
  protected final String TEXT_204 = ");" + NL + "                                                    if(codePointCountLeft < codePointCount){" + NL + "                                                        codePointCount = codePointCountLeft;" + NL + "                                                    }" + NL + "                                                    substringEnd";
  protected final String TEXT_205 = " = row_";
  protected final String TEXT_206 = ".offsetByCodePoints(substringBegin";
  protected final String TEXT_207 = ", codePointCount);";
  protected final String TEXT_208 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tbyte[] temp_byteArray_";
  protected final String TEXT_209 = " = arrays_";
  protected final String TEXT_210 = ".copyOfRange(row_";
  protected final String TEXT_211 = ".getBytes(";
  protected final String TEXT_212 = "),substringBegin";
  protected final String TEXT_213 = ", substringEnd";
  protected final String TEXT_214 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_215 = " = new String(temp_byteArray_";
  protected final String TEXT_216 = ",";
  protected final String TEXT_217 = ");\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_218 = NL + "                \t\t\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_219 = " = row_";
  protected final String TEXT_220 = ".substring(substringBegin";
  protected final String TEXT_221 = ", substringEnd";
  protected final String TEXT_222 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_223 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_224 = " = TalendString.talendTrim(currentColumnValue_";
  protected final String TEXT_225 = ", ";
  protected final String TEXT_226 = ", ";
  protected final String TEXT_227 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_228 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_229 = " = currentColumnValue_";
  protected final String TEXT_230 = ".trim();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_231 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tString type_";
  protected final String TEXT_232 = " = dynamicMetadataColumn_";
  protected final String TEXT_233 = ".getType();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tif(\"id_Short\".equals(type_";
  protected final String TEXT_234 = ") || \"id_Integer\".equals(type_";
  protected final String TEXT_235 = ") || \"id_Double\".equals(type_";
  protected final String TEXT_236 = ") || \"id_Float\".equals(type_";
  protected final String TEXT_237 = ") || \"id_Long\".equals(type_";
  protected final String TEXT_238 = ") || \"id_BigDecimal\".equals(type_";
  protected final String TEXT_239 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_240 = " = ParserUtils.parseTo_Number(currentColumnValue_";
  protected final String TEXT_241 = ", ";
  protected final String TEXT_242 = ", ";
  protected final String TEXT_243 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_244 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_245 = ".addColumnValue(currentColumnValue_";
  protected final String TEXT_246 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tsubstringBegin";
  protected final String TEXT_247 = " = substringEnd";
  protected final String TEXT_248 = "; " + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = " = dynamic_";
  protected final String TEXT_251 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_252 = NL + "\t\t\t\t\t\t\t\t\t\tif(column_";
  protected final String TEXT_253 = ".length() > 0) {" + NL + "        \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_254 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = " = ParserUtils.parseTo_Date(column_";
  protected final String TEXT_257 = ", ";
  protected final String TEXT_258 = ",false);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_259 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_260 = ".";
  protected final String TEXT_261 = " = ParserUtils.parseTo_Date(column_";
  protected final String TEXT_262 = ", ";
  protected final String TEXT_263 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_264 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_265 = ".";
  protected final String TEXT_266 = " = ParserUtils.parseTo_";
  protected final String TEXT_267 = "(ParserUtils.parseTo_Number(column_";
  protected final String TEXT_268 = ", ";
  protected final String TEXT_269 = ", ";
  protected final String TEXT_270 = "));" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_271 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_272 = ".";
  protected final String TEXT_273 = " = column_";
  protected final String TEXT_274 = ".getBytes(";
  protected final String TEXT_275 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_276 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_277 = ".";
  protected final String TEXT_278 = " = ParserUtils.parseTo_";
  protected final String TEXT_279 = "(column_";
  protected final String TEXT_280 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_281 = NL + "    \t\t\t\t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_282 = ".";
  protected final String TEXT_283 = " = ";
  protected final String TEXT_284 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_285 = NL + "            \t\t\t\t\t\t\t}" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_286 = NL + "                \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_287 = NL + "                        \t\t    \tint parseValue_";
  protected final String TEXT_288 = "(String row_";
  protected final String TEXT_289 = ", int substringBegin";
  protected final String TEXT_290 = ", int substringEnd";
  protected final String TEXT_291 = ", int rowLen_";
  protected final String TEXT_292 = ", String[] columnValue";
  protected final String TEXT_293 = " ";
  protected final String TEXT_294 = ", Arrays_";
  protected final String TEXT_295 = " arrays_";
  protected final String TEXT_296 = ", byte[][] byteArray_";
  protected final String TEXT_297 = ", routines.system.Dynamic dynamic_";
  protected final String TEXT_298 = ")throws java.lang.Exception{" + NL + "                        \t\t    ";
  protected final String TEXT_299 = " \t" + NL + "                        \t\t\t\tdynamic_";
  protected final String TEXT_300 = ".clearColumnValues();" + NL + "                        \t\t\t\tint maxColumnCount_";
  protected final String TEXT_301 = " = dynamic_";
  protected final String TEXT_302 = ".getColumnCount();" + NL + "                        \t\t\t\tfor (int i";
  protected final String TEXT_303 = "=0;i";
  protected final String TEXT_304 = "<maxColumnCount_";
  protected final String TEXT_305 = ";i";
  protected final String TEXT_306 = "++) {" + NL + "                        \t\t\t\t\troutines.system.DynamicMetadata dynamicMetadataColumn_";
  protected final String TEXT_307 = " = dynamic_";
  protected final String TEXT_308 = ".getColumnMetadata(i";
  protected final String TEXT_309 = ");" + NL + "                        \t\t\t\t\tint currentFieldLength_";
  protected final String TEXT_310 = " = dynamicMetadataColumn_";
  protected final String TEXT_311 = ".getLength();";
  protected final String TEXT_312 = NL + "                                                substringEnd";
  protected final String TEXT_313 = " = substringBegin";
  protected final String TEXT_314 = "+currentFieldLength_";
  protected final String TEXT_315 = ";" + NL + "                                                if(substringEnd";
  protected final String TEXT_316 = " > rowLen_";
  protected final String TEXT_317 = "){" + NL + "                                                    substringEnd";
  protected final String TEXT_318 = " = rowLen_";
  protected final String TEXT_319 = ";" + NL + "                                                }";
  protected final String TEXT_320 = NL + "                                                int codePointCount = currentFieldLength_";
  protected final String TEXT_321 = ";" + NL + "                                                int codePointCountLeft = row_";
  protected final String TEXT_322 = ".codePointCount(substringBegin";
  protected final String TEXT_323 = ", rowLen_";
  protected final String TEXT_324 = ");" + NL + "                                                if(codePointCountLeft < codePointCount){" + NL + "                                                    codePointCount = codePointCountLeft;" + NL + "                                                }" + NL + "                                                substringEnd";
  protected final String TEXT_325 = " = row_";
  protected final String TEXT_326 = ".offsetByCodePoints(substringBegin";
  protected final String TEXT_327 = ", codePointCount);";
  protected final String TEXT_328 = NL + "                    \t\t\t\t\t\t\tbyte[] temp_byteArray_";
  protected final String TEXT_329 = "= arrays_";
  protected final String TEXT_330 = ".copyOfRange(row_";
  protected final String TEXT_331 = ".getBytes(";
  protected final String TEXT_332 = "),substringBegin";
  protected final String TEXT_333 = ", substringEnd";
  protected final String TEXT_334 = ");" + NL + "\t                    \t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_335 = " = new String(temp_byteArray_";
  protected final String TEXT_336 = ",";
  protected final String TEXT_337 = ");\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_338 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_339 = " = row_";
  protected final String TEXT_340 = ".substring(substringBegin";
  protected final String TEXT_341 = ", substringEnd";
  protected final String TEXT_342 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_343 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_344 = " = currentColumnValue_";
  protected final String TEXT_345 = ".trim();" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_346 = " " + NL + "\t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_347 = " = TalendString.talendTrim(currentColumnValue_";
  protected final String TEXT_348 = ", ";
  protected final String TEXT_349 = ", ";
  protected final String TEXT_350 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_351 = NL + "                        \t\t\t\t\t\tString type_";
  protected final String TEXT_352 = " = dynamicMetadataColumn_";
  protected final String TEXT_353 = ".getType();" + NL + "                        \t\t\t\t\t\tif(\"id_Short\".equals(type_";
  protected final String TEXT_354 = ") || \"id_Integer\".equals(type_";
  protected final String TEXT_355 = ") || \"id_Double\".equals(type_";
  protected final String TEXT_356 = ") || \"id_Float\".equals(type_";
  protected final String TEXT_357 = ") || \"id_Long\".equals(type_";
  protected final String TEXT_358 = ") || \"id_BigDecimal\".equals(type_";
  protected final String TEXT_359 = ")){" + NL + "                        \t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_360 = " = ParserUtils.parseTo_Number(currentColumnValue_";
  protected final String TEXT_361 = ", ";
  protected final String TEXT_362 = ", ";
  protected final String TEXT_363 = ");" + NL + "\t                    \t\t\t\t\t\t}\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_364 = NL + "                        \t\t\t\t\tdynamic_";
  protected final String TEXT_365 = ".addColumnValue(currentColumnValue_";
  protected final String TEXT_366 = ");" + NL + "                        \t\t\t\t\tsubstringBegin";
  protected final String TEXT_367 = " = substringEnd";
  protected final String TEXT_368 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "                    \t\t\t\t";
  protected final String TEXT_369 = NL + "\t\t\t\t\t\t\t\t\t\tif(positions_";
  protected final String TEXT_370 = ".length <= ";
  protected final String TEXT_371 = ") {" + NL + "\t\t\t\t\t\t\t\t\t\t\tcolumnValue";
  protected final String TEXT_372 = "[";
  protected final String TEXT_373 = "]=\"\";" + NL + "\t\t\t\t\t\t\t\t\t\t} else if(substringBegin";
  protected final String TEXT_374 = " >= rowLen_";
  protected final String TEXT_375 = "){" + NL + "                            \t\t    \tcolumnValue";
  protected final String TEXT_376 = "[";
  protected final String TEXT_377 = "]= \"\";" + NL + "                                \t\t}else{" + NL + "                                \t\t\tif(\"*\".equals(positions_";
  protected final String TEXT_378 = "[";
  protected final String TEXT_379 = "])){" + NL + "        \t\t\t \t\t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_380 = "=rowLen_";
  protected final String TEXT_381 = ";" + NL + "            \t\t\t\t\t\t\t\t} else {";
  protected final String TEXT_382 = NL + "                                                    substringEnd";
  protected final String TEXT_383 = " = substringEnd";
  protected final String TEXT_384 = " + Integer.parseInt(positions_";
  protected final String TEXT_385 = "[";
  protected final String TEXT_386 = "]);" + NL + "                                                    if(substringEnd";
  protected final String TEXT_387 = " > rowLen_";
  protected final String TEXT_388 = "){" + NL + "                                                        substringEnd";
  protected final String TEXT_389 = " = rowLen_";
  protected final String TEXT_390 = ";" + NL + "                                                    }";
  protected final String TEXT_391 = NL + "                                                    int codePointCount = Integer.parseInt(positions_";
  protected final String TEXT_392 = "[";
  protected final String TEXT_393 = "]);" + NL + "                                                    int codePointCountLeft = row_";
  protected final String TEXT_394 = ".codePointCount(substringBegin";
  protected final String TEXT_395 = ", rowLen_";
  protected final String TEXT_396 = ");" + NL + "                                                    if(codePointCountLeft < codePointCount){" + NL + "                                                        codePointCount = codePointCountLeft;" + NL + "                                                    }" + NL + "                                                    substringEnd";
  protected final String TEXT_397 = " = row_";
  protected final String TEXT_398 = ".offsetByCodePoints(substringBegin";
  protected final String TEXT_399 = ", codePointCount);";
  protected final String TEXT_400 = NL + "                        \t\t\t\t    }" + NL + "    \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_401 = NL + "                            \t\t\t\t\tbyteArray_";
  protected final String TEXT_402 = "[";
  protected final String TEXT_403 = "] = arrays_";
  protected final String TEXT_404 = ".copyOfRange(row_";
  protected final String TEXT_405 = ".getBytes(";
  protected final String TEXT_406 = "),substringBegin";
  protected final String TEXT_407 = ", substringEnd";
  protected final String TEXT_408 = ");" + NL + "                            \t\t\t\t\tcolumnValue";
  protected final String TEXT_409 = "[";
  protected final String TEXT_410 = "] = new String(byteArray_";
  protected final String TEXT_411 = "[";
  protected final String TEXT_412 = "],";
  protected final String TEXT_413 = ");" + NL + "    \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_414 = NL + "            \t\t\t\t\t\t\t\t\tcolumnValue";
  protected final String TEXT_415 = "[";
  protected final String TEXT_416 = "] = row_";
  protected final String TEXT_417 = ".substring(substringBegin";
  protected final String TEXT_418 = ", substringEnd";
  protected final String TEXT_419 = ");" + NL + "    \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_420 = NL + "    \t\t\t\t\t\t\t\t\t\t\tcolumnValue";
  protected final String TEXT_421 = "[";
  protected final String TEXT_422 = "] = columnValue";
  protected final String TEXT_423 = "[";
  protected final String TEXT_424 = "].trim();" + NL + "    \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_425 = "    \t" + NL + "            \t\t\t\t\t\t\t\tsubstringBegin";
  protected final String TEXT_426 = " = substringEnd";
  protected final String TEXT_427 = ";" + NL + "    \t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_428 = NL + "                        \t\t    \t\treturn substringBegin";
  protected final String TEXT_429 = ";" + NL + "                        \t\t    \t}" + NL + "                    \t\t    \t";
  protected final String TEXT_430 = NL + "\t\t\t\t\t\t\t\t\t\treturn substringBegin";
  protected final String TEXT_431 = ";" + NL + "                     \t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_432 = NL + "                                    \tvoid setValue_";
  protected final String TEXT_433 = "(";
  protected final String TEXT_434 = "Struct ";
  protected final String TEXT_435 = ",String[] columnValue";
  protected final String TEXT_436 = ")throws java.lang.Exception{" + NL + "                \t\t\t\t\t";
  protected final String TEXT_437 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_438 = NL + "\t                    \t\t\t\t";
  protected final String TEXT_439 = ".";
  protected final String TEXT_440 = " = columnValue";
  protected final String TEXT_441 = "[";
  protected final String TEXT_442 = "];" + NL + "\t\t\t\t\t                ";
  protected final String TEXT_443 = NL + "\t                    \t\t\t\tif(columnValue";
  protected final String TEXT_444 = "[";
  protected final String TEXT_445 = "].length() > 0) {" + NL + "\t\t\t\t\t\t                \t";
  protected final String TEXT_446 = "\t" + NL + "\t\t                            \t\t\t\t";
  protected final String TEXT_447 = ".";
  protected final String TEXT_448 = " = ParserUtils.parseTo_Date(columnValue";
  protected final String TEXT_449 = "[";
  protected final String TEXT_450 = "], ";
  protected final String TEXT_451 = ",false);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_452 = NL + "\t\t                            \t\t\t\t";
  protected final String TEXT_453 = ".";
  protected final String TEXT_454 = " = ParserUtils.parseTo_Date(columnValue";
  protected final String TEXT_455 = "[";
  protected final String TEXT_456 = "], ";
  protected final String TEXT_457 = ");\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_458 = NL + "\t\t                        \t\t\t\t";
  protected final String TEXT_459 = ".";
  protected final String TEXT_460 = " = ParserUtils.parseTo_";
  protected final String TEXT_461 = "(ParserUtils.parseTo_Number(columnValue";
  protected final String TEXT_462 = "[";
  protected final String TEXT_463 = "], ";
  protected final String TEXT_464 = ", ";
  protected final String TEXT_465 = "));" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_466 = "\t" + NL + "\t\t                        \t\t\t\t";
  protected final String TEXT_467 = ".";
  protected final String TEXT_468 = " = columnValue";
  protected final String TEXT_469 = "[";
  protected final String TEXT_470 = "].getBytes(";
  protected final String TEXT_471 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_472 = "\t" + NL + "\t\t                        \t\t\t\t";
  protected final String TEXT_473 = ".";
  protected final String TEXT_474 = " = ParserUtils.parseTo_";
  protected final String TEXT_475 = "(columnValue";
  protected final String TEXT_476 = "[";
  protected final String TEXT_477 = "].trim());" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_478 = NL + "                        \t\t\t\t}else{" + NL + "        \t                \t\t\t\t";
  protected final String TEXT_479 = ".";
  protected final String TEXT_480 = " = ";
  protected final String TEXT_481 = ";" + NL + "                        \t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_482 = NL + "\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_483 = NL + "                     \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_484 = NL + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_485 = NL + "                     \t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_486 = NL + "\t" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_487 = NL + "\t\t\t}" + NL + "" + NL + "\t\t\tPositionalUtil_";
  protected final String TEXT_488 = " positionalUtil_";
  protected final String TEXT_489 = "=new PositionalUtil_";
  protected final String TEXT_490 = "();" + NL + "\t\t\tpositionalUtil_";
  protected final String TEXT_491 = ".setUseStar(useStar_";
  protected final String TEXT_492 = ");" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_493 = NL + NL + "                int[] sizes_";
  protected final String TEXT_494 = " = new int[";
  protected final String TEXT_495 = "];" + NL + "                int[] begins_";
  protected final String TEXT_496 = " = new int[";
  protected final String TEXT_497 = "];" + NL + "                int[] ends_";
  protected final String TEXT_498 = " = new int[";
  protected final String TEXT_499 = "];";
  protected final String TEXT_500 = NL + "                    int[] surrogateBegins_";
  protected final String TEXT_501 = " = new int[begins_";
  protected final String TEXT_502 = ".length];" + NL + "                    int[] surrogateEnds_";
  protected final String TEXT_503 = " = new int[ends_";
  protected final String TEXT_504 = ".length];";
  protected final String TEXT_505 = NL + "    \t\t\t\t\tuseStar_";
  protected final String TEXT_506 = " = true;" + NL + "    \t\t\t\t\tpositionalUtil_";
  protected final String TEXT_507 = ".setUseStar(useStar_";
  protected final String TEXT_508 = ");" + NL + "    \t\t\t\t\tsizes_";
  protected final String TEXT_509 = "[";
  protected final String TEXT_510 = "] = -1;" + NL + "    \t\t\t\t\t";
  protected final String TEXT_511 = NL + "    \t\t\t\t\tsizes_";
  protected final String TEXT_512 = "[";
  protected final String TEXT_513 = "] = ";
  protected final String TEXT_514 = ";" + NL + "    \t\t\t\t\t";
  protected final String TEXT_515 = NL + "\t\t\t\t\t\tsizes_";
  protected final String TEXT_516 = "[";
  protected final String TEXT_517 = "] = ";
  protected final String TEXT_518 = ";\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_519 = NL + "\t\t\t\t\t\tbegins_";
  protected final String TEXT_520 = "[";
  protected final String TEXT_521 = "] = 0;" + NL + "\t\t\t\t\t\tends_";
  protected final String TEXT_522 = "[";
  protected final String TEXT_523 = "] = sizes_";
  protected final String TEXT_524 = "[";
  protected final String TEXT_525 = "];" + NL + "\t\t\t\t\t";
  protected final String TEXT_526 = NL + "\t\t\t\t\t\tif(useStar_";
  protected final String TEXT_527 = ") {" + NL + "\t\t\t\t\t\t\tbegins_";
  protected final String TEXT_528 = "[";
  protected final String TEXT_529 = "] = begins_";
  protected final String TEXT_530 = "[";
  protected final String TEXT_531 = "] + sizes_";
  protected final String TEXT_532 = "[";
  protected final String TEXT_533 = "];" + NL + "\t\t\t\t\t\t\tends_";
  protected final String TEXT_534 = "[";
  protected final String TEXT_535 = "] = -1;" + NL + "\t\t\t\t\t\t} else {" + NL + "    \t\t\t\t\t\tbegins_";
  protected final String TEXT_536 = "[";
  protected final String TEXT_537 = "] = begins_";
  protected final String TEXT_538 = "[";
  protected final String TEXT_539 = "] + sizes_";
  protected final String TEXT_540 = "[";
  protected final String TEXT_541 = "];" + NL + "                            ends_";
  protected final String TEXT_542 = "[";
  protected final String TEXT_543 = "] = ends_";
  protected final String TEXT_544 = "[";
  protected final String TEXT_545 = "] + sizes_";
  protected final String TEXT_546 = "[";
  protected final String TEXT_547 = "];" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_548 = NL + "                        begins_";
  protected final String TEXT_549 = "[";
  protected final String TEXT_550 = "] = begins_";
  protected final String TEXT_551 = "[";
  protected final String TEXT_552 = "] + sizes_";
  protected final String TEXT_553 = "[";
  protected final String TEXT_554 = "];" + NL + "                        ends_";
  protected final String TEXT_555 = "[";
  protected final String TEXT_556 = "] = ends_";
  protected final String TEXT_557 = "[";
  protected final String TEXT_558 = "] + sizes_";
  protected final String TEXT_559 = "[";
  protected final String TEXT_560 = "];" + NL + "\t\t\t\t\t";
  protected final String TEXT_561 = NL + "            Object filename_";
  protected final String TEXT_562 = " = ";
  protected final String TEXT_563 = ";" + NL + "            java.io.BufferedReader in_";
  protected final String TEXT_564 = " = null;" + NL + "" + NL + "            org.talend.fileprocess.delimited.RowParser reader_";
  protected final String TEXT_565 = " = null; " + NL + "            org.talend.fileprocess.delimited.RowParserByByte byteReader_";
  protected final String TEXT_566 = " = null; " + NL + "" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_567 = NL + NL + "\t\t\t";
  protected final String TEXT_568 = NL + "                java.util.zip.ZipInputStream zis_";
  protected final String TEXT_569 = " = null;" + NL + "                try {" + NL + "                \tif(filename_";
  protected final String TEXT_570 = " instanceof java.io.InputStream){" + NL + "                \t\tzis_";
  protected final String TEXT_571 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream((java.io.InputStream)filename_";
  protected final String TEXT_572 = "));" + NL + "                \t}else{" + NL + "                \t\tzis_";
  protected final String TEXT_573 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_574 = "))));" + NL + "                \t}" + NL + "                } catch(java.lang.Exception e) {" + NL + "                \t";
  protected final String TEXT_575 = NL + "                \t\tthrow e;" + NL + "                \t";
  protected final String TEXT_576 = NL + "                \t\t";
  protected final String TEXT_577 = NL + "                \t\t\tlog.error(\"";
  protected final String TEXT_578 = " - \" +e.getMessage());" + NL + "                \t\t";
  protected final String TEXT_579 = NL + "                \t\t\tSystem.err.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_580 = NL + "                }" + NL + "                java.util.zip.ZipEntry entry_";
  protected final String TEXT_581 = " = null;" + NL + "                while (true) {" + NL + "                \ttry {" + NL + "                \t\tentry_";
  protected final String TEXT_582 = " = zis_";
  protected final String TEXT_583 = ".getNextEntry();" + NL + "                \t} catch(java.lang.Exception e) {" + NL + "                \t\t";
  protected final String TEXT_584 = NL + "                \t\t\tthrow e;" + NL + "                \t\t";
  protected final String TEXT_585 = NL + "                \t\t\t";
  protected final String TEXT_586 = NL + "                \t\t\t\tlog.error(\"";
  protected final String TEXT_587 = " - \" +e.getMessage());" + NL + "                \t\t\t";
  protected final String TEXT_588 = NL + "                    \t\tSystem.err.println(e.getMessage());" + NL + "                    \t\tbreak;" + NL + "                \t\t";
  protected final String TEXT_589 = NL + "                \t}" + NL + "                \tif(entry_";
  protected final String TEXT_590 = " == null) {" + NL + "                \t\tbreak;" + NL + "                \t}" + NL + "                \tif(entry_";
  protected final String TEXT_591 = ".isDirectory()){ //directory" + NL + "                \t\tcontinue;" + NL + "                \t}" + NL + "                \tString row_";
  protected final String TEXT_592 = " = null;" + NL + "                \tint rowLen_";
  protected final String TEXT_593 = " = 0;" + NL + "                \t";
  protected final String TEXT_594 = NL + "                \t\t\tbyte[] byteArray_";
  protected final String TEXT_595 = " = new byte[0];" + NL + "                    \t";
  protected final String TEXT_596 = NL + "                \t\tString column_";
  protected final String TEXT_597 = " = null;" + NL + "                \t";
  protected final String TEXT_598 = NL + "                \t\t\tbyte[][] byteArray_";
  protected final String TEXT_599 = " = new byte[";
  protected final String TEXT_600 = "][];" + NL + "                \t\t";
  protected final String TEXT_601 = NL + "                \t\tString[] columnValue";
  protected final String TEXT_602 = "=new String[";
  protected final String TEXT_603 = "];" + NL + "                \t";
  protected final String TEXT_604 = NL + "                \ttry {//TD110 begin" + NL + "                \t\tin_";
  protected final String TEXT_605 = " = new java.io.BufferedReader(new java.io.InputStreamReader(zis_";
  protected final String TEXT_606 = ", ";
  protected final String TEXT_607 = "));" + NL + "    \t\t";
  protected final String TEXT_608 = NL + "                String row_";
  protected final String TEXT_609 = " = null;" + NL + "                int rowLen_";
  protected final String TEXT_610 = " = 0;";
  protected final String TEXT_611 = NL + "            \t\t\tbyte[] byteArray_";
  protected final String TEXT_612 = " = new byte[0];";
  protected final String TEXT_613 = NL + "\t\t\t\t\tString column_";
  protected final String TEXT_614 = " = null;";
  protected final String TEXT_615 = NL + "\t\t                byte[][] byteArray_";
  protected final String TEXT_616 = " = new byte[";
  protected final String TEXT_617 = "][];" + NL + "        \t        ";
  protected final String TEXT_618 = NL + "                \tString[] columnValue";
  protected final String TEXT_619 = "=new String[";
  protected final String TEXT_620 = "];";
  protected final String TEXT_621 = " " + NL + "                try {//TD110 begin" + NL + "                \tif(filename_";
  protected final String TEXT_622 = " instanceof java.io.InputStream){" + NL + "                \t\tin_";
  protected final String TEXT_623 = " = " + NL + "                \t\t\t\tnew java.io.BufferedReader(new java.io.InputStreamReader((java.io.InputStream)filename_";
  protected final String TEXT_624 = ", ";
  protected final String TEXT_625 = "));" + NL + "                \t}else{" + NL + "                \t\tin_";
  protected final String TEXT_626 = " = " + NL + "                \t\t\tnew java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_627 = ")), ";
  protected final String TEXT_628 = "));" + NL + "                \t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_629 = NL + "\t\t\t\tint rowLength_";
  protected final String TEXT_630 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_631 = NL + "\t\t\t\t\t\trowLength_";
  protected final String TEXT_632 = " += sizes_";
  protected final String TEXT_633 = "[";
  protected final String TEXT_634 = "];" + NL + "\t\t\t\t\t";
  protected final String TEXT_635 = NL + "\t\t\t\t\tfor(int i_";
  protected final String TEXT_636 = "=0;i_";
  protected final String TEXT_637 = "<positions_";
  protected final String TEXT_638 = ".length;i_";
  protected final String TEXT_639 = "++){" + NL + "\t\t\t\t\t\trowLength_";
  protected final String TEXT_640 = " += Integer.parseInt(positions_";
  protected final String TEXT_641 = "[i_";
  protected final String TEXT_642 = "]);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_643 = NL + "                              byteReader_";
  protected final String TEXT_644 = " = new org.talend.fileprocess.delimited.RowParserByByte(zis_";
  protected final String TEXT_645 = ", rowLength_";
  protected final String TEXT_646 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_647 = NL + "\t\t\t\t" + NL + "                              byteReader_";
  protected final String TEXT_648 = " = new org.talend.fileprocess.delimited.RowParserByByte(String.valueOf(filename_";
  protected final String TEXT_649 = "), rowLength_";
  protected final String TEXT_650 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_651 = NL + "\t\t\t\treader_";
  protected final String TEXT_652 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_653 = ", rowLength_";
  protected final String TEXT_654 = ");" + NL + "\t\t\t";
  protected final String TEXT_655 = NL + "\t\t\t\treader_";
  protected final String TEXT_656 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_657 = ", ";
  protected final String TEXT_658 = ", ";
  protected final String TEXT_659 = ");" + NL + "\t\t\t";
  protected final String TEXT_660 = NL + "\t\t\t\t";
  protected final String TEXT_661 = NL + "                    byteReader_";
  protected final String TEXT_662 = ".setSafetySwitch(";
  protected final String TEXT_663 = ");" + NL + "                    byteReader_";
  protected final String TEXT_664 = ".skipHeaders(";
  protected final String TEXT_665 = ");";
  protected final String TEXT_666 = NL + "            \t\treader_";
  protected final String TEXT_667 = ".setSafetySwitch(";
  protected final String TEXT_668 = ");" + NL + "            \t\treader_";
  protected final String TEXT_669 = ".skipHeaders(";
  protected final String TEXT_670 = ");" + NL + "            \t";
  protected final String TEXT_671 = NL + "            if(footer_";
  protected final String TEXT_672 = " > 0){" + NL + "            \t";
  protected final String TEXT_673 = NL + "            \tint available_";
  protected final String TEXT_674 = " = (int)byteReader_";
  protected final String TEXT_675 = ".getAvailableRowCount(footer_";
  protected final String TEXT_676 = ");" + NL + "            \tbyteReader_";
  protected final String TEXT_677 = ".close();" + NL + "            \t";
  protected final String TEXT_678 = NL + "            \tint available_";
  protected final String TEXT_679 = " = (int)reader_";
  protected final String TEXT_680 = ".getAvailableRowCount(footer_";
  protected final String TEXT_681 = ");" + NL + "            \treader_";
  protected final String TEXT_682 = ".close();" + NL + "            \t";
  protected final String TEXT_683 = NL + "            \tif(filename_";
  protected final String TEXT_684 = " instanceof java.io.InputStream){" + NL + "            \t\tthrow new java.lang.RuntimeException(\"When the input source is a stream,footer shouldn't be bigger than 0.\");" + NL + "            \t}else{" + NL + "            \t\tin_";
  protected final String TEXT_685 = " = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_686 = ")), ";
  protected final String TEXT_687 = "));" + NL + "            \t}" + NL + "\t\t\t\t";
  protected final String TEXT_688 = NL + "                               byteReader_";
  protected final String TEXT_689 = " = new org.talend.fileprocess.delimited.RowParserByByte(zis_";
  protected final String TEXT_690 = ", rowLength_";
  protected final String TEXT_691 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_692 = NL + "                              byteReader_";
  protected final String TEXT_693 = " = new org.talend.fileprocess.delimited.RowParserByByte(String.valueOf(filename_";
  protected final String TEXT_694 = "), rowLength_";
  protected final String TEXT_695 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_696 = NL + "\t\t\t\t\treader_";
  protected final String TEXT_697 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_698 = ", ";
  protected final String TEXT_699 = ", ";
  protected final String TEXT_700 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_701 = "\t";
  protected final String TEXT_702 = NL + "                      byteReader_";
  protected final String TEXT_703 = ".skipHeaders(";
  protected final String TEXT_704 = ");";
  protected final String TEXT_705 = NL + "                \treader_";
  protected final String TEXT_706 = ".skipHeaders(";
  protected final String TEXT_707 = ");" + NL + "            \t";
  protected final String TEXT_708 = NL + "\t" + NL + "            \tif ( nb_limit_";
  protected final String TEXT_709 = " >= 0 ){" + NL + "            \t\tnb_limit_";
  protected final String TEXT_710 = " = ( nb_limit_";
  protected final String TEXT_711 = " > available_";
  protected final String TEXT_712 = ") ? available_";
  protected final String TEXT_713 = " : nb_limit_";
  protected final String TEXT_714 = ";" + NL + "            \t}else{" + NL + "            \t\tnb_limit_";
  protected final String TEXT_715 = " = available_";
  protected final String TEXT_716 = ";" + NL + "            \t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t} catch(java.lang.Exception e) {//TD110 end" + NL + "        \t";
  protected final String TEXT_717 = NL + "        \t\tthrow e;" + NL + "        \t";
  protected final String TEXT_718 = NL + "        \t\t";
  protected final String TEXT_719 = NL + "        \t\t\tlog.error(\"";
  protected final String TEXT_720 = " - \" +e.getMessage());" + NL + "        \t\t";
  protected final String TEXT_721 = NL + "    \t\t\tSystem.err.println(e.getMessage());" + NL + "        \t";
  protected final String TEXT_722 = NL + "        }";
  protected final String TEXT_723 = NL + "                    while (nb_limit_";
  protected final String TEXT_724 = " != 0 && byteReader_";
  protected final String TEXT_725 = "!=null && byteReader_";
  protected final String TEXT_726 = ".readRecord()) {" + NL + "        \t            row_";
  protected final String TEXT_727 = " = new String(byteReader_";
  protected final String TEXT_728 = ".getBuffer(),";
  protected final String TEXT_729 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_730 = NL + "                    while (nb_limit_";
  protected final String TEXT_731 = " != 0 && reader_";
  protected final String TEXT_732 = "!=null && reader_";
  protected final String TEXT_733 = ".readRecord()) {" + NL + "        \t            row_";
  protected final String TEXT_734 = " = reader_";
  protected final String TEXT_735 = ".getRowRecord();" + NL + "            \t";
  protected final String TEXT_736 = NL + NL + "\t\t\t";
  protected final String TEXT_737 = NL + "\t\t\t\trowLen_";
  protected final String TEXT_738 = " = row_";
  protected final String TEXT_739 = ".getBytes(";
  protected final String TEXT_740 = ").length;" + NL + "\t\t\t";
  protected final String TEXT_741 = NL + "\t\t\t\trowLen_";
  protected final String TEXT_742 = " = row_";
  protected final String TEXT_743 = ".length();" + NL + "\t\t\t";
  protected final String TEXT_744 = NL + "\t\t\t";
  protected final String TEXT_745 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_746 = " = null;\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_747 = NL + "        \t\t\t" + NL + "            \t\t\tboolean whetherReject_";
  protected final String TEXT_748 = " = false;" + NL + "            \t\t\t";
  protected final String TEXT_749 = " = new ";
  protected final String TEXT_750 = "Struct();" + NL + "            \t\t\ttry {" + NL + "    \t\t\t" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_751 = NL + "                                            int surrogateRowLen_";
  protected final String TEXT_752 = " = row_";
  protected final String TEXT_753 = ".codePointCount(0, rowLen_";
  protected final String TEXT_754 = ");" + NL + "                                            for (int index = 0; index < begins_";
  protected final String TEXT_755 = ".length; index++){" + NL + "                                                if (index > 0){" + NL + "                                                    surrogateBegins_";
  protected final String TEXT_756 = "[index] = surrogateEnds_";
  protected final String TEXT_757 = "[index-1];" + NL + "                                                }else{" + NL + "                                                    surrogateBegins_";
  protected final String TEXT_758 = "[index] = begins_";
  protected final String TEXT_759 = "[index];" + NL + "                                                }" + NL + "                                                if (ends_";
  protected final String TEXT_760 = "[index] > 0 && ends_";
  protected final String TEXT_761 = "[index] <= surrogateRowLen_";
  protected final String TEXT_762 = "){" + NL + "                                                    int codePoints = ends_";
  protected final String TEXT_763 = "[index] - begins_";
  protected final String TEXT_764 = "[index];" + NL + "                                                    surrogateEnds_";
  protected final String TEXT_765 = "[index] = row_";
  protected final String TEXT_766 = ".offsetByCodePoints(surrogateBegins_";
  protected final String TEXT_767 = "[index], codePoints);" + NL + "                                                }else{" + NL + "                                                    surrogateEnds_";
  protected final String TEXT_768 = "[index] = rowLen_";
  protected final String TEXT_769 = ";" + NL + "                                                }" + NL + "                                            }" + NL + "                                            positionalUtil_";
  protected final String TEXT_770 = ".setValue_";
  protected final String TEXT_771 = "(";
  protected final String TEXT_772 = ",surrogateBegins_";
  protected final String TEXT_773 = ",surrogateEnds_";
  protected final String TEXT_774 = ",rowLen_";
  protected final String TEXT_775 = ",column_";
  protected final String TEXT_776 = ",row_";
  protected final String TEXT_777 = ");";
  protected final String TEXT_778 = NL + "                                            positionalUtil_";
  protected final String TEXT_779 = ".setValue_";
  protected final String TEXT_780 = "(";
  protected final String TEXT_781 = ",begins_";
  protected final String TEXT_782 = ",ends_";
  protected final String TEXT_783 = ",rowLen_";
  protected final String TEXT_784 = ",";
  protected final String TEXT_785 = "byteArray_";
  protected final String TEXT_786 = ",arrays_";
  protected final String TEXT_787 = ",";
  protected final String TEXT_788 = "column_";
  protected final String TEXT_789 = ",row_";
  protected final String TEXT_790 = ");";
  protected final String TEXT_791 = NL + "                            \tint substringBegin";
  protected final String TEXT_792 = "=0,substringEnd";
  protected final String TEXT_793 = "=0;" + NL + "                            \tint[]begin_end_";
  protected final String TEXT_794 = "=new int[2];" + NL + "                            \t" + NL + "        \t\t\t\t\t\t";
  protected final String TEXT_795 = NL + "                        \t\t\t\tsubstringBegin";
  protected final String TEXT_796 = " = positionalUtil_";
  protected final String TEXT_797 = ".parseValue_";
  protected final String TEXT_798 = "(row_";
  protected final String TEXT_799 = ", substringBegin";
  protected final String TEXT_800 = ", substringEnd";
  protected final String TEXT_801 = ", rowLen_";
  protected final String TEXT_802 = ", columnValue";
  protected final String TEXT_803 = " ";
  protected final String TEXT_804 = ", arrays_";
  protected final String TEXT_805 = ", byteArray_";
  protected final String TEXT_806 = ", dynamic_";
  protected final String TEXT_807 = ");" + NL + "                        \t\t\t\tsubstringEnd";
  protected final String TEXT_808 = " = substringBegin";
  protected final String TEXT_809 = ";" + NL + "                    \t\t\t\t";
  protected final String TEXT_810 = NL + "      \t \t\t\t\t\t\t\t\tpositionalUtil_";
  protected final String TEXT_811 = ".setValue_";
  protected final String TEXT_812 = "(";
  protected final String TEXT_813 = ",columnValue";
  protected final String TEXT_814 = ");" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_815 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_816 = ".";
  protected final String TEXT_817 = "=dynamic_";
  protected final String TEXT_818 = ";" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_819 = NL + "    \t\t" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_820 = " ";
  protected final String TEXT_821 = " = null; ";
  protected final String TEXT_822 = "        \t\t\t" + NL + "            \t\t\t" + NL + "    \t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "        \t\t\t\t\twhetherReject_";
  protected final String TEXT_823 = " = true;";
  protected final String TEXT_824 = NL + "                                throw(e);";
  protected final String TEXT_825 = NL + "                                    ";
  protected final String TEXT_826 = " = new ";
  protected final String TEXT_827 = "Struct();";
  protected final String TEXT_828 = NL + "                                        ";
  protected final String TEXT_829 = ".";
  protected final String TEXT_830 = " = ";
  protected final String TEXT_831 = ".";
  protected final String TEXT_832 = ";";
  protected final String TEXT_833 = NL + "                                    ";
  protected final String TEXT_834 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_835 = ";";
  protected final String TEXT_836 = NL + "                                    ";
  protected final String TEXT_837 = " = null;";
  protected final String TEXT_838 = NL + "                    \t\t\t\t\tlog.error(\"";
  protected final String TEXT_839 = " - \" +e.getMessage());" + NL + "                    \t\t\t\t";
  protected final String TEXT_840 = NL + "                                    System.err.println(e.getMessage());";
  protected final String TEXT_841 = NL + "                                    ";
  protected final String TEXT_842 = " = null;";
  protected final String TEXT_843 = NL + "                                \t";
  protected final String TEXT_844 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_845 = ";";
  protected final String TEXT_846 = NL + "                        }" + NL + "        \t\t\t" + NL + "        \t\t\t";
  protected final String TEXT_847 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_848 = "if(!whetherReject_";
  protected final String TEXT_849 = ") { ";
  protected final String TEXT_850 = "      " + NL + "         \t\t\t\t\t\tif(";
  protected final String TEXT_851 = " == null){ " + NL + "            \t \t\t\t\t\t";
  protected final String TEXT_852 = " = new ";
  protected final String TEXT_853 = "Struct();" + NL + "         \t\t\t\t\t\t}\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_854 = NL + "\t    \t \t\t\t\t\t\t";
  protected final String TEXT_855 = ".";
  protected final String TEXT_856 = " = ";
  protected final String TEXT_857 = ".";
  protected final String TEXT_858 = ";    \t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_859 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_860 = " } ";
  protected final String TEXT_861 = "\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_862 = NL;

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
	
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	List<? extends IConnection> connsFlow = node.getOutgoingConnections("FLOW");

    String rejectConnName = "";
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
			
			List<Map<String, String>> formats =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__FORMATS__"
            );
            
            List<Map<String, String>> trimSelects =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__TRIMSELECT__"
            );
            
            String pattern1 = ElementParameterParser.getValue(node, "__PATTERN__");
            
            String patternUnits = ElementParameterParser.getValue(node, "__PATTERN_UNITS__");
            boolean advanced = ("true").equals(ElementParameterParser.getValue(node, "__ADVANCED_OPTION__"));
            
			String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
			
			String trimAll = ElementParameterParser.getValue(node,"__TRIMALL__");
			boolean isTrimAll = true;
			if(trimAll != null && ("false").equals(trimAll)){
				isTrimAll = false;
			}
			
   			String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
   			
    		String header = ElementParameterParser.getValue(node, "__HEADER__");
    		
    		String limit = ElementParameterParser.getValue(node, "__LIMIT__");    		
    		if ("".equals(limit.trim())) limit = "-1";
    		
    		String removeEmptyRow = ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
    		
        	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
    		
    		//need to process rows longger than 100 000 characters, the property SafetySwitch(in talend_file_enhanced_20070724.jar) should be sent to false.(the default is true)
    		//that means if check the option(true), the logic value of bSafetySwitch should be changed to false (XOR with 'true')
    		boolean bSafetySwitch = (("true").equals(ElementParameterParser.getValue(node, "__PROCESS_LONG_ROW__")) ^ true);    		
    		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);    		  
			
			String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
			boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
			
			boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
			String footer = uncompress?"0":ElementParameterParser.getValue(node, "__FOOTER__");
			
			final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			log4jFileUtil.componentStartInfo(node);
			
    		if(("").equals(header)){
    			header = "0";
    		}
    			
    		if(("").equals(footer)){
    			footer = "0";
    		}
    		
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
    		//now we have to support the three kinds of setting, but it's not good:
    		//"1,2,*"
    		//1,2,*
    		//context.var
            if(!advanced) {
            	if(java.util.regex.Pattern.compile("[0-9,*].*").matcher(pattern1).matches()) {
            	
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(pattern1);
    stringBuffer.append(TEXT_34);
    
            	} else {
            	
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(pattern1);
    stringBuffer.append(TEXT_37);
    
            	}
            	
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
    
            }
            
			boolean hasDynamic = metadata.isDynamicSchema();
			String dynamic = ElementParameterParser.getValue(node, "__DYNAMIC__");
			boolean useExistingDynamic = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_DYNAMIC__"));
            String dyn = dynamic+"_DYNAMIC";
			if(useExistingDynamic){
				
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
			}
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(footer);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_64);
    
			if("BYTES".equals(patternUnits)){
			
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    
			}
			
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
                String firstConnName = "";
                if (conns!=null) {
            		if (conns.size()>0) {
            			IConnection conn = conns.get(0);
            			firstConnName = conn.getName();
            			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                            List<IMetadataColumn> listColumns = metadata.getListColumns();
            				int sizeListColumns = listColumns.size();
                			if(advanced){// custom part start
                				
    stringBuffer.append(TEXT_72);
    stringBuffer.append(sizeListColumns);
    stringBuffer.append(TEXT_73);
    
                				for (int valueN=0; valueN<sizeListColumns; valueN++) {
                					String paddingChar = formats.get(valueN).get("PADDING_CHAR");
                					String align = formats.get(valueN).get("ALIGN");
                					if(("'L'").equals(align)){
                						align = "-1";
                					}else if(("'C'").equals(align)){
                						align = "0";
                					}else{
                						align = "1";
                					}
                					if(valueN%100==0){
    						        
    stringBuffer.append(TEXT_74);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
     if("BYTES".equals(patternUnits)){ 
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
     } 
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    
									}
									
    stringBuffer.append(TEXT_88);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    
        									if("BYTES".equals(patternUnits)){
											
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_105);
    
											}else{
											
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_112);
    
											}
											
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    
                                    	if("BYTES".equals(patternUnits)){
										
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    
										}else{
										
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    
										}
                                    	
    stringBuffer.append(TEXT_165);
    
									if(isTrimAll || ("true").equals(trimSelects.get(valueN).get("TRIM"))){
									
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    
									}
									IMetadataColumn column = listColumns.get(valueN);
									String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
									JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
									String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
									if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
									
    stringBuffer.append(TEXT_169);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    
									} else if("id_Dynamic".equals(column.getTalendType())){
										if(useExistingDynamic){
										
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
                                                if(!"RARE_SYMBOLS".equals(patternUnits)){
                                                
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    
                                                } else {
                                                
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    
                                                }
        										if("BYTES".equals(patternUnits)){
												
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_217);
    
                								}else{
                								
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    
												}
												if(advanced){
												
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_227);
    
												}
												if(isTrimAll || (hasDynamic &&(("true").equals(trimSelects.get(trimSelects.size()-1).get("TRIM"))))){
												
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
												}
												if(advancedSeparator) { 
												
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_242);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_243);
    
												}
												
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    
                						}
                					} else {
									
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    
        									if(javaType == JavaTypesManager.DATE) {
												if(checkDate) {
												
    stringBuffer.append(TEXT_254);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_258);
    
												} else {
												
    stringBuffer.append(TEXT_259);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_263);
    
												}
											}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
											
    stringBuffer.append(TEXT_264);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_266);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_269);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_270);
    
											}else if(javaType == JavaTypesManager.BYTE_ARRAY) {
											
    stringBuffer.append(TEXT_271);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_275);
    
											} else {
											
    stringBuffer.append(TEXT_276);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_278);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    
											}
											
    stringBuffer.append(TEXT_281);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_284);
    					
									}
									if((valueN+1)%100==0){
									
    stringBuffer.append(TEXT_285);
    
        							}
        						}//end for_
        						if(sizeListColumns>0&&(sizeListColumns%100)>0){
        						
    stringBuffer.append(TEXT_286);
    
								}
							}//custom end
							else{//custom not check
								List<IMetadataColumn> columnList = metadata.getListColumns();
								for(int i=0;i <	columnList.size();i++){
									if(i % 100 == 0){
                        		    
    stringBuffer.append(TEXT_287);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    if("BYTES".equals(patternUnits)){
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    }
    if(useExistingDynamic){
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_298);
    
                        		    }
                        		    IMetadataColumn column = columnList.get(i);
									boolean isDynamic = "id_Dynamic".equals(column.getTalendType()) && useExistingDynamic;
                        		    if(isDynamic){
                        				String paddingChar = formats.get(i).get("PADDING_CHAR");
                        				String align = formats.get(i).get("ALIGN");
										
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    
                                            if(!"RARE_SYMBOLS".equals(patternUnits)){
                                            
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    
                                            } else {
                                            
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    
                                            }
											if("BYTES".equals(patternUnits)){
											
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_337);
    
											}else{
											
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    
                        					}
                        					if(isTrimAll || (hasDynamic &&(("true").equals(trimSelects.get(trimSelects.size()-1).get("TRIM"))))){
											
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    
											}
											if(advanced){
											
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_350);
    
											}
											if(advancedSeparator) { 
											
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_362);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_363);
    
											}
											
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    
                    				} else {
									
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    
                                                if(!"RARE_SYMBOLS".equals(patternUnits)){
                                                
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    
                                                } else {
                                                
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    
                                                }
                                                
    stringBuffer.append(TEXT_400);
    
                        					if("BYTES".equals(patternUnits)){
    										
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_413);
    
    										}else{
    										
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_419);
     
    										}
           									if(isTrimAll || ("true").equals(trimSelects.get(i).get("TRIM"))){
    										
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_421);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_424);
    
    										}
    										
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    
									}
									if((i+1) % 100 == 0){
                        		    
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    
                        		    }
								}//for(...)
            					if(columnList.size()>0&&(columnList.size()%100)>0){
								
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    
         						}
         						
                				for (int valueN=0; valueN<sizeListColumns; valueN++) {	
                				    if(valueN%100==0){
                					
    stringBuffer.append(TEXT_432);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_436);
    
                                    }	
                					
    stringBuffer.append(TEXT_437);
    
                                    IMetadataColumn column = listColumns.get(valueN);
                					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
									
    stringBuffer.append(TEXT_438);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_442);
    
                					}else if("id_Dynamic".equals(column.getTalendType())){
                					
                					} else {
                					
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_445);
    
                					        if(javaType == JavaTypesManager.DATE) {
                								if(checkDate) {
                								
    stringBuffer.append(TEXT_446);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_447);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_450);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_451);
    
												} else {
												
    stringBuffer.append(TEXT_452);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_456);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_457);
    
												}
											}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
											
    stringBuffer.append(TEXT_458);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_460);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_463);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_464);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_465);
    
					        				}else if(javaType == JavaTypesManager.BYTE_ARRAY) {
											
    stringBuffer.append(TEXT_466);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_471);
    
											} else {
											
    stringBuffer.append(TEXT_472);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_474);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_477);
    
											}
											
    stringBuffer.append(TEXT_478);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_481);
    
        							}
									
    stringBuffer.append(TEXT_482);
    
             						if((valueN+1)%100==0){
									
    stringBuffer.append(TEXT_483);
    
             						}
 								}
								
    stringBuffer.append(TEXT_484);
    
            					if(sizeListColumns>0&&(sizeListColumns%100)>0){
								
    stringBuffer.append(TEXT_485);
    
         						}
								
    stringBuffer.append(TEXT_486);
    
        					}//custom not check
                		}
                	}
                }
                
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    
			if(advanced){
			
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_494);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_499);
    
                if("RARE_SYMBOLS".equals(patternUnits)){
                
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_504);
    
                }
				for(int i = 0; i < formats.size(); i++){ 
    				if(i == formats.size() - 1 && !(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator))){
    					//now we have to treat the empty string as star, please check the tujs. It's not good.
    					if("*".equals(formats.get(i).get("SIZE")) || "".equals(formats.get(i).get("SIZE"))){
    					
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_510);
    
    					} else {
    					
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(formats.get(i).get("SIZE"));
    stringBuffer.append(TEXT_514);
    
    					}
					}else{
					
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(formats.get(i).get("SIZE") );
    stringBuffer.append(TEXT_518);
    
    				}
    			}
				for(int i = 0; i < formats.size(); i++){ 
					if(i == 0){
					
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_524);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_525);
    
					}else if(i == formats.size() - 1){
					
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_530);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_536);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_540);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_544);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_546);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_547);
    
					}else{
					
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_549);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_551);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_553);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_555);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_557);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_560);
    
    				}
    			}
			}//end if(advanced)
			
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_566);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_567);
    
			if(uncompress){
			
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_574);
     if(dieOnError) {
    stringBuffer.append(TEXT_575);
     } else { 
    stringBuffer.append(TEXT_576);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    }
    stringBuffer.append(TEXT_579);
     } 
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_583);
     if(dieOnError) {
    stringBuffer.append(TEXT_584);
     } else { 
    stringBuffer.append(TEXT_585);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    }
    stringBuffer.append(TEXT_588);
     } 
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_593);
    
                	if(advanced){
                		if("BYTES".equals(patternUnits)){
                		
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_595);
    
                    	}
                    	
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_597);
    
                	}else{
                		if("BYTES".equals(patternUnits)){
                		
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_599);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_600);
    
                		}
                		
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_602);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_603);
    
                	}
                	
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_606);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_607);
    
    		}else{
    		
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_610);
    
                if(advanced){
                	if("BYTES".equals(patternUnits)){
               		
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_612);
    
                    }
                    
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_614);
    
                }else{
                	if("BYTES".equals(patternUnits)){
                    
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_616);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_617);
    
                	}
            	    
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_619);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_620);
    
                }
                
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_624);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_627);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_628);
    
			}
			if(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator) ){
			
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_630);
    
				if(advanced){ 
					for(int i = 0; i < formats.size(); i++){ 
					
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_633);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_634);
    
					}
				}else{
					
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    
				}
				if("BYTES".equals(patternUnits)){
						if(uncompress){
				
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_646);
    
                        }else{
				
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_650);
    
                        }
                }else{	
				
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_654);
    
				}
			}else{
			
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_657);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_658);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_659);
    
			}
			
    stringBuffer.append(TEXT_660);
    
            	if("BYTES".equals(patternUnits)&&(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator))){
                
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_662);
    stringBuffer.append(bSafetySwitch);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_664);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_665);
    
            	}else{
            	
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_667);
    stringBuffer.append(bSafetySwitch);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_669);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_670);
    
            	}
            	
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_672);
    
            	if("BYTES".equals(patternUnits)&&(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator))){
            	
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_677);
    
            	}else{
            	
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_682);
    
            	}
            	
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_686);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_687);
    
				if("BYTES".equals(patternUnits)&&(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator))){
						if(uncompress){
				
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_691);
    
                        }else{
				
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_695);
    
                        }
				}else{
				
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_698);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_699);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_700);
    
				}
				
    stringBuffer.append(TEXT_701);
    
            	if("BYTES".equals(patternUnits)&&(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator)) ){
                
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_703);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_704);
    
            	}else{
            	
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_706);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_707);
    
            	}
            	
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_716);
     if(dieOnError) {
    stringBuffer.append(TEXT_717);
     } else { 
    stringBuffer.append(TEXT_718);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    }
    stringBuffer.append(TEXT_721);
     } 
    stringBuffer.append(TEXT_722);
    
            	if("BYTES".equals(patternUnits)&&(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator))){
                
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_728);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_729);
    
            	}else{
            	
    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_733);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_735);
    
            	}
            	
    stringBuffer.append(TEXT_736);
    
			if("BYTES".equals(patternUnits)){
			
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_739);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_740);
    	
			}else{
			
    stringBuffer.append(TEXT_741);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_743);
    
			}
			
    stringBuffer.append(TEXT_744);
    
            if(rejectConns != null && rejectConns.size() > 0) {
                IConnection rejectConn = rejectConns.get(0);
                rejectConnName = rejectConn.getName();
            }
            List<IMetadataColumn> rejectColumnList = null;
            IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
            if(metadataTable != null) {
                rejectColumnList = metadataTable.getListColumns();      
            }

        	if (conns!=null) {
        		if (conns.size()>0) {
        			for (int i=0;i<conns.size();i++) {
        				IConnection connTemp = conns.get(i);
        				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
						
    stringBuffer.append(TEXT_745);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_746);
    
        				}
        			}
        		}
        	}
    	
        	if (conns!=null) {
        		if (conns.size()>0) {
        			IConnection conn = conns.get(0);
        			firstConnName = conn.getName();
        			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    stringBuffer.append(TEXT_747);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_748);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_749);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_750);
    
    						List<IMetadataColumn> listColumns = metadata.getListColumns();
           				    int sizeListColumns = listColumns.size();
                			if(advanced){
                				for (int valueN=0; valueN<sizeListColumns; valueN++) {
                					String paddingChar = formats.get(valueN).get("PADDING_CHAR");
                					String align = formats.get(valueN).get("ALIGN");
                					if(("'L'").equals(align)){
                						align = "-1";
                					}else if(("'C'").equals(align)){
                						align = "0";
                					}else{
                						align = "1";
                					}
                       				if(valueN%100==0){
                                        if("RARE_SYMBOLS".equals(patternUnits)){
                                        
    stringBuffer.append(TEXT_751);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_754);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_755);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_756);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_759);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_760);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_761);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_763);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_764);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_765);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_766);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_767);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_768);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_769);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_770);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_771);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_772);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_774);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_776);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_777);
    
                                        } else {
                                        
    stringBuffer.append(TEXT_778);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_779);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_781);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_782);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_783);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_784);
     if("BYTES".equals(patternUnits)){ 
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_786);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_787);
     } 
    stringBuffer.append(TEXT_788);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_789);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_790);
    
                                        }
                      				}
        						}
        					}else{// end if(advance)
    						
    stringBuffer.append(TEXT_791);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_794);
    
                        	    List<IMetadataColumn> columnList = metadata.getListColumns();
                        		for(int i=0; i < columnList.size(); i++){
                        			IMetadataColumn column = columnList.get(i);
                    				if(i % 100 == 0){
                    				
    stringBuffer.append(TEXT_795);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_796);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_797);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_798);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_799);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_800);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_801);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_803);
    if("BYTES".equals(patternUnits)){
    stringBuffer.append(TEXT_804);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_805);
    stringBuffer.append(cid);
    }
    if(useExistingDynamic){
    stringBuffer.append(TEXT_806);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_807);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_808);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_809);
    
                        			}
                        		}
                            	
                            	for (int valueN=0; valueN<sizeListColumns; valueN++) {	
                            		if(valueN%100==0){
    								
    stringBuffer.append(TEXT_810);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_811);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_814);
    
                            	    }
                               	}
       	 
    							if(useExistingDynamic && !advanced){
    							
    stringBuffer.append(TEXT_815);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_816);
    stringBuffer.append(metadata.getDynamicColumn().getLabel());
    stringBuffer.append(TEXT_817);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_818);
    		
                        		}
                            }
        
        					log4jFileUtil.debugRetriveData(node,false);
    						
    stringBuffer.append(TEXT_819);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_820);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_821);
    }
    stringBuffer.append(TEXT_822);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_823);
    
                            if (dieOnError) {
                            
    stringBuffer.append(TEXT_824);
    
                            } else {
                                if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
                                
    stringBuffer.append(TEXT_825);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_826);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_827);
    
                                    for(IMetadataColumn column : metadata.getListColumns()) {
                                    
    stringBuffer.append(TEXT_828);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_830);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_831);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_832);
    
                                    }
                                    
    stringBuffer.append(TEXT_833);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_834);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_835);
    stringBuffer.append(TEXT_836);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_837);
    
                                } else if(("").equals(rejectConnName)){
                    	        	if(isLog4jEnabled){
                    	        	
    stringBuffer.append(TEXT_838);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_839);
    
                    				}
                                    
    stringBuffer.append(TEXT_840);
    stringBuffer.append(TEXT_841);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_842);
    
                                } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_843);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_844);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_845);
    
                                }
                            } 
                            
    stringBuffer.append(TEXT_846);
            			
    				}
            		if (conns.size()>0) {	
            			boolean isFirstEnter = true;
            			for (int i=0;i<conns.size();i++) {
            				conn = conns.get(i);
            				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
							
    stringBuffer.append(TEXT_847);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_848);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_849);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_850);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_851);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_852);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_853);
    
		    	 				for (IMetadataColumn column: metadata.getListColumns()) {
								
    stringBuffer.append(TEXT_854);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_855);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_856);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_857);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_858);
    
            				 	}
            				}
            			}
						
    stringBuffer.append(TEXT_859);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_860);
     } 
    stringBuffer.append(TEXT_861);
    
					}
            	}
    		}
    	}
    }
	
    stringBuffer.append(TEXT_862);
    return stringBuffer.toString();
  }
}

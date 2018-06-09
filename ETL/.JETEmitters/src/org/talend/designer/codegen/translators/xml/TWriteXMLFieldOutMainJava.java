package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.EConnectionType;

/**
 * add by xzhang
 */
public class TWriteXMLFieldOutMainJava {

  protected static String nl;
  public static synchronized TWriteXMLFieldOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteXMLFieldOutMainJava result = new TWriteXMLFieldOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\tvalueMap_";
  protected final String TEXT_30 = ".get(\"";
  protected final String TEXT_31 = "\")";
  protected final String TEXT_32 = NL + "\t(";
  protected final String TEXT_33 = NL + "\t\t";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " != null?";
  protected final String TEXT_36 = NL + "    \t\tFormatterUtils.format_Number(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ".toPlainString(), ";
  protected final String TEXT_39 = ",";
  protected final String TEXT_40 = ")\t\t\t\t\t";
  protected final String TEXT_41 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = "), ";
  protected final String TEXT_44 = ",";
  protected final String TEXT_45 = ")\t\t\t\t\t\t";
  protected final String TEXT_46 = NL + "            String.valueOf(";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ")";
  protected final String TEXT_49 = NL + "            FormatterUtils.format_Date(";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = ",";
  protected final String TEXT_52 = ")";
  protected final String TEXT_53 = NL + "\t\t\t";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = NL + "\t\t\t";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = ".toPlainString()";
  protected final String TEXT_58 = NL + "            new String(";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = ")";
  protected final String TEXT_61 = NL + "            ";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = ".toString()";
  protected final String TEXT_64 = ":";
  protected final String TEXT_65 = "null";
  protected final String TEXT_66 = NL + "\t\t)";
  protected final String TEXT_67 = NL + "\t\t\t";
  protected final String TEXT_68 = "_";
  protected final String TEXT_69 = ".setName(\"";
  protected final String TEXT_70 = "\");";
  protected final String TEXT_71 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_72 = "_";
  protected final String TEXT_73 = ";" + NL + "\t\tif (";
  protected final String TEXT_74 = "_";
  protected final String TEXT_75 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_76 = "\") == null) {";
  protected final String TEXT_77 = NL + "            ";
  protected final String TEXT_78 = "_";
  protected final String TEXT_79 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_80 = "\");" + NL + "        } else {" + NL + "        \t";
  protected final String TEXT_81 = "_";
  protected final String TEXT_82 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_83 = "\");" + NL + "        }";
  protected final String TEXT_84 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_85 = "_";
  protected final String TEXT_86 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_87 = "\");";
  protected final String TEXT_88 = NL + "        if(orders_";
  protected final String TEXT_89 = "[";
  protected final String TEXT_90 = "]==0){" + NL + "        \torders_";
  protected final String TEXT_91 = "[";
  protected final String TEXT_92 = "] = ";
  protected final String TEXT_93 = ";" + NL + "        }" + NL + "        if(";
  protected final String TEXT_94 = " < orders_";
  protected final String TEXT_95 = ".length){" + NL + "        \t\torders_";
  protected final String TEXT_96 = "[";
  protected final String TEXT_97 = "] = 0;" + NL + "        }";
  protected final String TEXT_98 = NL + "        ";
  protected final String TEXT_99 = "_";
  protected final String TEXT_100 = ".elements().add(orders_";
  protected final String TEXT_101 = "[";
  protected final String TEXT_102 = "]++,";
  protected final String TEXT_103 = "_";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = ";" + NL + "\t\tif (";
  protected final String TEXT_108 = "_";
  protected final String TEXT_109 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_110 = "\") == null) {";
  protected final String TEXT_111 = NL + "            ";
  protected final String TEXT_112 = "_";
  protected final String TEXT_113 = " = ";
  protected final String TEXT_114 = "_";
  protected final String TEXT_115 = ".addElement(\"";
  protected final String TEXT_116 = "\");" + NL + "        } else {" + NL + "        \t";
  protected final String TEXT_117 = "_";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = "_";
  protected final String TEXT_120 = ".addElement(\"";
  protected final String TEXT_121 = "\");" + NL + "        }";
  protected final String TEXT_122 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_123 = "_";
  protected final String TEXT_124 = " = ";
  protected final String TEXT_125 = "_";
  protected final String TEXT_126 = ".addElement(\"";
  protected final String TEXT_127 = "\");";
  protected final String TEXT_128 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_129 = " = ";
  protected final String TEXT_130 = "_";
  protected final String TEXT_131 = ";";
  protected final String TEXT_132 = NL + "\t\tif(";
  protected final String TEXT_133 = "!=null){" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_134 = " .parseAndAdd(";
  protected final String TEXT_135 = "_";
  protected final String TEXT_136 = ",";
  protected final String TEXT_137 = ");" + NL + "\t\t}";
  protected final String TEXT_138 = NL + "\t\telse{" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_139 = " .parseAndAdd(";
  protected final String TEXT_140 = "_";
  protected final String TEXT_141 = ",\"\");" + NL + "\t\t\t";
  protected final String TEXT_142 = "_";
  protected final String TEXT_143 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_144 = NL + "\t\tif(";
  protected final String TEXT_145 = "!=null){" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_146 = " .setText(";
  protected final String TEXT_147 = "_";
  protected final String TEXT_148 = ",";
  protected final String TEXT_149 = ");";
  protected final String TEXT_150 = NL + "            ";
  protected final String TEXT_151 = "_";
  protected final String TEXT_152 = ".addAttribute(\"type\", \"boolean\");";
  protected final String TEXT_153 = NL + "            ";
  protected final String TEXT_154 = "_";
  protected final String TEXT_155 = ".addAttribute(\"type\", \"number\");";
  protected final String TEXT_156 = NL + "\t\t}";
  protected final String TEXT_157 = NL + "\t\telse{" + NL + "\t\t\t";
  protected final String TEXT_158 = "_";
  protected final String TEXT_159 = ".setText(\"\");" + NL + "\t\t\t";
  protected final String TEXT_160 = "_";
  protected final String TEXT_161 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_162 = NL + "\t\tnestXMLTool_";
  protected final String TEXT_163 = ".parseAndAdd(";
  protected final String TEXT_164 = "_";
  protected final String TEXT_165 = ",\"";
  protected final String TEXT_166 = "\");";
  protected final String TEXT_167 = NL + "\t\tif(";
  protected final String TEXT_168 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_169 = "_";
  protected final String TEXT_170 = ".addAttribute(\"";
  protected final String TEXT_171 = "\",";
  protected final String TEXT_172 = ");" + NL + "\t\t}";
  protected final String TEXT_173 = NL + "\t\t";
  protected final String TEXT_174 = "_";
  protected final String TEXT_175 = ".addAttribute(\"";
  protected final String TEXT_176 = "\", \"";
  protected final String TEXT_177 = "\");";
  protected final String TEXT_178 = NL + "\t\tif(";
  protected final String TEXT_179 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_180 = "_";
  protected final String TEXT_181 = ".addNamespace(\"";
  protected final String TEXT_182 = "\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_183 = "));";
  protected final String TEXT_184 = NL + "        \t";
  protected final String TEXT_185 = "_";
  protected final String TEXT_186 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_187 = "_";
  protected final String TEXT_188 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_189 = "))));";
  protected final String TEXT_190 = NL + "\t\t}";
  protected final String TEXT_191 = NL + "\t\t\t";
  protected final String TEXT_192 = "_";
  protected final String TEXT_193 = ".addNamespace(\"";
  protected final String TEXT_194 = "\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_195 = "\"));";
  protected final String TEXT_196 = NL + "        \t";
  protected final String TEXT_197 = "_";
  protected final String TEXT_198 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_199 = "_";
  protected final String TEXT_200 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_201 = "\"))));";
  protected final String TEXT_202 = NL + "    \t// buffer the start tabs to group buffer" + NL + "    \tgroupBuffer_";
  protected final String TEXT_203 = "[";
  protected final String TEXT_204 = "] = buf_";
  protected final String TEXT_205 = ".toString();" + NL + "        buf_";
  protected final String TEXT_206 = " = new StringBuffer();";
  protected final String TEXT_207 = NL + "\t\tstartTabs_";
  protected final String TEXT_208 = "[";
  protected final String TEXT_209 = "] = buf_";
  protected final String TEXT_210 = ".toString();" + NL + "        buf_";
  protected final String TEXT_211 = " = new StringBuffer();";
  protected final String TEXT_212 = NL + "\t\tout_";
  protected final String TEXT_213 = ".write(buf_";
  protected final String TEXT_214 = ".toString());" + NL + "        buf_";
  protected final String TEXT_215 = " = new StringBuffer();";
  protected final String TEXT_216 = NL + "\t\tif( false";
  protected final String TEXT_217 = " || valueMap_";
  protected final String TEXT_218 = ".get(\"";
  protected final String TEXT_219 = "\") != null";
  protected final String TEXT_220 = " || true " + NL + "                    \t";
  protected final String TEXT_221 = NL + "\t\t){";
  protected final String TEXT_222 = NL + "\t\t}";
  protected final String TEXT_223 = NL + "\t\tbuf_";
  protected final String TEXT_224 = ".append(\"";
  protected final String TEXT_225 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_226 = ".append(\"";
  protected final String TEXT_227 = "<";
  protected final String TEXT_228 = "\");";
  protected final String TEXT_229 = NL + "\t\tbuf_";
  protected final String TEXT_230 = ".append(\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\"\");" + NL + "\t\tbuf_";
  protected final String TEXT_231 = ".append(\" xsi:noNamespaceSchemaLocation= \\\"\"+";
  protected final String TEXT_232 = "+\"\\\"\");";
  protected final String TEXT_233 = NL + "\t\tif(";
  protected final String TEXT_234 = "==null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_235 = ".append(\" xsi:nil=\\\"true\\\"\");" + NL + "\t\t}";
  protected final String TEXT_236 = NL + "\t\tbuf_";
  protected final String TEXT_237 = ".append(\">\");";
  protected final String TEXT_238 = NL + "\t\tbuf_";
  protected final String TEXT_239 = ".append(\"";
  protected final String TEXT_240 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_241 = ".append(\"";
  protected final String TEXT_242 = "</";
  protected final String TEXT_243 = ">\");";
  protected final String TEXT_244 = NL + "\t\tbuf_";
  protected final String TEXT_245 = ".append(\"</";
  protected final String TEXT_246 = ">\");";
  protected final String TEXT_247 = NL + "\t\tif(";
  protected final String TEXT_248 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_249 = ".append(";
  protected final String TEXT_250 = ");" + NL + "\t\t}";
  protected final String TEXT_251 = NL + "\t\tif(";
  protected final String TEXT_252 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_253 = ".append(TalendString.checkCDATAForXML(";
  protected final String TEXT_254 = "));" + NL + "\t\t}";
  protected final String TEXT_255 = NL + "\t\tbuf_";
  protected final String TEXT_256 = ".append(\"";
  protected final String TEXT_257 = "\");";
  protected final String TEXT_258 = NL + "\t\tif(";
  protected final String TEXT_259 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_260 = ".append(\" ";
  protected final String TEXT_261 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_262 = ")+\"\\\"\");" + NL + "\t\t}";
  protected final String TEXT_263 = NL + "\t\tbuf_";
  protected final String TEXT_264 = ".append(\" ";
  protected final String TEXT_265 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_266 = "\")+\"\\\"\");";
  protected final String TEXT_267 = NL + "\t\tif(";
  protected final String TEXT_268 = "!=null){";
  protected final String TEXT_269 = NL + "        \tbuf_";
  protected final String TEXT_270 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_271 = ")+\"\\\"\");";
  protected final String TEXT_272 = NL + "\t\t\tbuf_";
  protected final String TEXT_273 = ".append(\" xmlns:";
  protected final String TEXT_274 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_275 = ")+\"\\\"\");";
  protected final String TEXT_276 = NL + "\t\t}";
  protected final String TEXT_277 = NL + "        \tbuf_";
  protected final String TEXT_278 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_279 = "\")+\"\\\"\");";
  protected final String TEXT_280 = NL + "\t\t\tbuf_";
  protected final String TEXT_281 = ".append(\" xmlns:";
  protected final String TEXT_282 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_283 = "\")+\"\\\"\");";
  protected final String TEXT_284 = NL + "\tif(txf_";
  protected final String TEXT_285 = ".getLastException()!=null) {" + NL + "\t\tcurrentComponent = txf_";
  protected final String TEXT_286 = ".getCurrentComponent();" + NL + "\t\tthrow txf_";
  protected final String TEXT_287 = ".getLastException();" + NL + "\t}";
  protected final String TEXT_288 = NL + "\tnb_line_";
  protected final String TEXT_289 = "++;";
  protected final String TEXT_290 = NL + "\tvalueMap_";
  protected final String TEXT_291 = ".clear();";
  protected final String TEXT_292 = NL + "\tvalueMap_";
  protected final String TEXT_293 = ".put(\"";
  protected final String TEXT_294 = "\",";
  protected final String TEXT_295 = ");";
  protected final String TEXT_296 = NL + "\tflowValues_";
  protected final String TEXT_297 = " = new java.util.HashMap<String,String>();" + NL + "\tflowValues_";
  protected final String TEXT_298 = ".putAll(valueMap_";
  protected final String TEXT_299 = ");" + NL + "\tflows_";
  protected final String TEXT_300 = ".add(flowValues_";
  protected final String TEXT_301 = ");";
  protected final String TEXT_302 = NL + "\t\tString strTemp_";
  protected final String TEXT_303 = " = \"\";";
  protected final String TEXT_304 = "\t\tstrTemp_";
  protected final String TEXT_305 = " = strTemp_";
  protected final String TEXT_306 = " + valueMap_";
  protected final String TEXT_307 = ".get(\"";
  protected final String TEXT_308 = "\")" + NL + "\t\t\t\t\t\t\t+ valueMap_";
  protected final String TEXT_309 = ".get(\"";
  protected final String TEXT_310 = "\").length();";
  protected final String TEXT_311 = NL + "\tif(strCompCache_";
  protected final String TEXT_312 = "==null){" + NL + "\t\tstrCompCache_";
  protected final String TEXT_313 = "=strTemp_";
  protected final String TEXT_314 = ";" + NL + "\t\t";
  protected final String TEXT_315 = NL + "            \trowStructOutput_";
  protected final String TEXT_316 = ".";
  protected final String TEXT_317 = " = ";
  protected final String TEXT_318 = ".";
  protected final String TEXT_319 = ";" + NL + "            \t";
  protected final String TEXT_320 = NL + "\t}else{";
  protected final String TEXT_321 = NL + "\t\t//the data read is different from the data read last time. " + NL + "\t\tif(!strCompCache_";
  protected final String TEXT_322 = ".equals(strTemp_";
  protected final String TEXT_323 = ")){\t";
  protected final String TEXT_324 = NL + "\t\t\tdoc_";
  protected final String TEXT_325 = ".getRootElement().addAttribute(\"xsi:noNamespaceSchemaLocation\", ";
  protected final String TEXT_326 = ");" + NL + "\t\t    doc_";
  protected final String TEXT_327 = ".getRootElement().addNamespace(\"xsi\", \"http://www.w3.org/2001/XMLSchema-instance\");";
  protected final String TEXT_328 = "  " + NL + "    \t\tnestXMLTool_";
  protected final String TEXT_329 = ".replaceDefaultNameSpace(doc_";
  protected final String TEXT_330 = ".getRootElement());";
  protected final String TEXT_331 = NL + "    \t\tnestXMLTool_";
  protected final String TEXT_332 = ".removeEmptyElement(doc_";
  protected final String TEXT_333 = ".getRootElement());";
  protected final String TEXT_334 = "\t\t\t" + NL + "\t\t\tjava.io.StringWriter strWriter_";
  protected final String TEXT_335 = " = new java.io.StringWriter();\t" + NL + "\t\t\torg.dom4j.io.XMLWriter output_";
  protected final String TEXT_336 = " = new org.dom4j.io.XMLWriter(strWriter_";
  protected final String TEXT_337 = ", format_";
  protected final String TEXT_338 = ");" + NL + "\t\t\toutput_";
  protected final String TEXT_339 = ".write(doc_";
  protected final String TEXT_340 = ");" + NL + "\t\t    output_";
  protected final String TEXT_341 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_342 = NL + "\t\t\tString removeHeader_";
  protected final String TEXT_343 = " = strWriter_";
  protected final String TEXT_344 = ".toString();" + NL + "\t\t\tif(removeHeader_";
  protected final String TEXT_345 = ".indexOf(\"<?xml\") >=0 ){" + NL + "\t\t\t\tremoveHeader_";
  protected final String TEXT_346 = " = removeHeader_";
  protected final String TEXT_347 = ".substring(removeHeader_";
  protected final String TEXT_348 = ".indexOf(\"?>\")+3);" + NL + "\t\t\t}" + NL + "\t\t\tlistGroupby_";
  protected final String TEXT_349 = ".add(removeHeader_";
  protected final String TEXT_350 = ");";
  protected final String TEXT_351 = NL + "                map_";
  protected final String TEXT_352 = ".put(\"json_";
  protected final String TEXT_353 = "\",strWriter_";
  protected final String TEXT_354 = ".toString());" + NL + "                listGroupby_";
  protected final String TEXT_355 = ".add(map_";
  protected final String TEXT_356 = ");";
  protected final String TEXT_357 = NL + "\t\t\t\t  \t\t  ";
  protected final String TEXT_358 = " row_";
  protected final String TEXT_359 = " = new ";
  protected final String TEXT_360 = "();" + NL + "\t\t\t\t\t\t  ";
  protected final String TEXT_361 = NL + "\t\t\t\t\t\t\t\trow_";
  protected final String TEXT_362 = ".";
  protected final String TEXT_363 = " = rowStructOutput_";
  protected final String TEXT_364 = ".";
  protected final String TEXT_365 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_366 = NL + "\t\t\t\t\t     \t\trow_";
  protected final String TEXT_367 = ".";
  protected final String TEXT_368 = " = strWriter_";
  protected final String TEXT_369 = ".toString();" + NL + "\t\t\t\t\t     \t\tlistGroupby_";
  protected final String TEXT_370 = ".add(row_";
  protected final String TEXT_371 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_372 = NL + "\t\t\t\t\t\t\t\t\t\t    listGroupby_";
  protected final String TEXT_373 = ".add(strWriter_";
  protected final String TEXT_374 = ".toString());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_375 = NL + "\t\t    doc_";
  protected final String TEXT_376 = ".clearContent();" + NL + "\t\t\tneedRoot_";
  protected final String TEXT_377 = " = true;" + NL + "\t\t\tfor(int i_";
  protected final String TEXT_378 = "=0;i_";
  protected final String TEXT_379 = "<orders_";
  protected final String TEXT_380 = ".length;i_";
  protected final String TEXT_381 = "++){" + NL + "\t\t\t\torders_";
  protected final String TEXT_382 = "[i_";
  protected final String TEXT_383 = "] = 0;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(groupbyList_";
  protected final String TEXT_384 = " != null && groupbyList_";
  protected final String TEXT_385 = ".size() >= 0){" + NL + "\t\t\t\tgroupbyList_";
  protected final String TEXT_386 = ".clear();" + NL + "\t\t\t}" + NL + "\t\t\tstrCompCache_";
  protected final String TEXT_387 = "=strTemp_";
  protected final String TEXT_388 = ";";
  protected final String TEXT_389 = NL + "            \trowStructOutput_";
  protected final String TEXT_390 = ".";
  protected final String TEXT_391 = " = ";
  protected final String TEXT_392 = ".";
  protected final String TEXT_393 = ";" + NL + "            \t";
  protected final String TEXT_394 = NL + "\t\t}";
  protected final String TEXT_395 = NL + "\t}" + NL;
  protected final String TEXT_396 = NL + "                map_";
  protected final String TEXT_397 = "  = new java.util.HashMap();";
  protected final String TEXT_398 = NL + "                    map_";
  protected final String TEXT_399 = ".put(\"";
  protected final String TEXT_400 = "\",";
  protected final String TEXT_401 = ".";
  protected final String TEXT_402 = ");";
  protected final String TEXT_403 = NL + "\torg.dom4j.Element subTreeRootParent_";
  protected final String TEXT_404 = " = null;" + NL + "\t" + NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_405 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_406 = "=false;";
  protected final String TEXT_407 = NL + "\t\troot4Group_";
  protected final String TEXT_408 = " = subTreeRootParent_";
  protected final String TEXT_409 = ";" + NL + "\t}else{" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_410 = "=root4Group_";
  protected final String TEXT_411 = ";" + NL + "\t}" + NL + "\t// build group xml tree ";
  protected final String TEXT_412 = NL + "\tboolean isNewElememt = false;";
  protected final String TEXT_413 = NL + "\tif(isNewElememt || groupbyList_";
  protected final String TEXT_414 = ".size()<=";
  protected final String TEXT_415 = " || groupbyList_";
  protected final String TEXT_416 = ".get(";
  protected final String TEXT_417 = ")==null";
  protected final String TEXT_418 = NL + "\t|| ( groupbyList_";
  protected final String TEXT_419 = ".get(";
  protected final String TEXT_420 = ").get(";
  protected final String TEXT_421 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_422 = ".get(";
  protected final String TEXT_423 = ").get(";
  protected final String TEXT_424 = ").equals(";
  protected final String TEXT_425 = ") " + NL + "\t\t: ";
  protected final String TEXT_426 = "!=null )";
  protected final String TEXT_427 = NL + "\t){";
  protected final String TEXT_428 = NL + "\t\tif(groupbyList_";
  protected final String TEXT_429 = ".size()<=";
  protected final String TEXT_430 = "){" + NL + "        \tgroupbyList_";
  protected final String TEXT_431 = ".add(new java.util.ArrayList<String>());" + NL + "        }else{" + NL + "        \tgroupbyList_";
  protected final String TEXT_432 = ".get(";
  protected final String TEXT_433 = ").clear();" + NL + "        }";
  protected final String TEXT_434 = NL + "\t\tgroupbyList_";
  protected final String TEXT_435 = ".get(";
  protected final String TEXT_436 = ").add(";
  protected final String TEXT_437 = ");";
  protected final String TEXT_438 = NL + "        isNewElememt=true;" + NL + "        if(groupElementList_";
  protected final String TEXT_439 = ".size()<=";
  protected final String TEXT_440 = "){" + NL + "\t\t\tgroupElementList_";
  protected final String TEXT_441 = ".add(group";
  protected final String TEXT_442 = "__";
  protected final String TEXT_443 = ");" + NL + "        }else{" + NL + "        \tgroupElementList_";
  protected final String TEXT_444 = ".set(";
  protected final String TEXT_445 = ",group";
  protected final String TEXT_446 = "__";
  protected final String TEXT_447 = ");" + NL + "        }" + NL + "        " + NL + "\t}else{" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_448 = "=groupElementList_";
  protected final String TEXT_449 = ".get(";
  protected final String TEXT_450 = ");" + NL + "\t}";
  protected final String TEXT_451 = NL + "\t// build loop xml tree";
  protected final String TEXT_452 = NL + "\t\t//the data read is different from the data read last time. " + NL + "\t\tif(!strCompCache_";
  protected final String TEXT_453 = ".equals(strTemp_";
  protected final String TEXT_454 = ")){";
  protected final String TEXT_455 = NL + NL + "\t\t // write the endtag to the StringWriter:strWriter_tWriteXMLField_1_Out" + NL + "\t\t // close the bufferWriter" + NL + "\t\t // add the data in strWriter_tWriteXMLField_1_Out to listGroupby\t\t\t\t\t\t\t " + NL + "" + NL + "\t\tif (preUnNullMaxIndex_";
  protected final String TEXT_456 = " >= 0) {" + NL + "\t        // output all buffer" + NL + "\t        for (int j_";
  protected final String TEXT_457 = " = 0; j_";
  protected final String TEXT_458 = " <= preUnNullMaxIndex_";
  protected final String TEXT_459 = "; j_";
  protected final String TEXT_460 = "++) {" + NL + "\t            if (startTabs_";
  protected final String TEXT_461 = "[j_";
  protected final String TEXT_462 = "] != null)" + NL + "\t                out_";
  protected final String TEXT_463 = ".write(startTabs_";
  protected final String TEXT_464 = "[j_";
  protected final String TEXT_465 = "]);" + NL + "\t        }" + NL + "\t" + NL + "\t        if (preUnNullMaxIndex_";
  protected final String TEXT_466 = " < preNewTabIndex_";
  protected final String TEXT_467 = " ) {" + NL + "\t\t\t\tfor (int i_";
  protected final String TEXT_468 = " = preNewTabIndex_";
  protected final String TEXT_469 = " - 1; i_";
  protected final String TEXT_470 = " >= 0; i_";
  protected final String TEXT_471 = "--) {" + NL + "                \tif(endTabs_";
  protected final String TEXT_472 = "[i_";
  protected final String TEXT_473 = "]!=null){" + NL + "                \t\tout_";
  protected final String TEXT_474 = ".write(endTabs_";
  protected final String TEXT_475 = "[i_";
  protected final String TEXT_476 = "]);" + NL + "                \t}                \t" + NL + "\t                out_";
  protected final String TEXT_477 = ".write(\"";
  protected final String TEXT_478 = "\");" + NL + "\t                out_";
  protected final String TEXT_479 = ".write(endTabStrs_";
  protected final String TEXT_480 = ".get(i_";
  protected final String TEXT_481 = "));" + NL + "\t            }" + NL + "\t        } else {" + NL + "\t            for (int i_";
  protected final String TEXT_482 = " = preUnNullMaxIndex_";
  protected final String TEXT_483 = "; i_";
  protected final String TEXT_484 = " >= 0; i_";
  protected final String TEXT_485 = "--) {" + NL + "                \tif(endTabs_";
  protected final String TEXT_486 = "[i_";
  protected final String TEXT_487 = "]!=null){" + NL + "                \t\tout_";
  protected final String TEXT_488 = ".write(endTabs_";
  protected final String TEXT_489 = "[i_";
  protected final String TEXT_490 = "]);" + NL + "                \t}" + NL + "                \tout_";
  protected final String TEXT_491 = ".write(\"";
  protected final String TEXT_492 = "\");" + NL + "\t                out_";
  protected final String TEXT_493 = ".write(endTabStrs_";
  protected final String TEXT_494 = ".get(i_";
  protected final String TEXT_495 = "));" + NL + "\t            }" + NL + "\t        }" + NL + "\t    }";
  protected final String TEXT_496 = NL + "\t\tfor (int i_";
  protected final String TEXT_497 = " = endTabStrs_";
  protected final String TEXT_498 = ".size() - 1; i_";
  protected final String TEXT_499 = " >= 0; i_";
  protected final String TEXT_500 = "--) {" + NL + "        \tif(endTabs_";
  protected final String TEXT_501 = "[i_";
  protected final String TEXT_502 = "]!=null){" + NL + "        \t\tout_";
  protected final String TEXT_503 = ".write(endTabs_";
  protected final String TEXT_504 = "[i_";
  protected final String TEXT_505 = "]);" + NL + "        \t}" + NL + "\t        out_";
  protected final String TEXT_506 = ".write(\"";
  protected final String TEXT_507 = "\");" + NL + "\t        out_";
  protected final String TEXT_508 = ".write(endTabStrs_";
  protected final String TEXT_509 = ".get(i_";
  protected final String TEXT_510 = "));" + NL + "\t    }";
  protected final String TEXT_511 = NL + "\t\tfor (int i_";
  protected final String TEXT_512 = " = 0; i_";
  protected final String TEXT_513 = " < endTabs_";
  protected final String TEXT_514 = ".length; i_";
  protected final String TEXT_515 = "++) {" + NL + "\t\t\tstartTabs_";
  protected final String TEXT_516 = "[i_";
  protected final String TEXT_517 = "] = null;" + NL + "\t\t\tendTabs_";
  protected final String TEXT_518 = "[i_";
  protected final String TEXT_519 = "] = null;" + NL + "\t\t}" + NL + "//\t\tendTabStrs_";
  protected final String TEXT_520 = ".clear();" + NL + "\t\tout_";
  protected final String TEXT_521 = ".write(\"";
  protected final String TEXT_522 = "\");" + NL + "\t\tout_";
  protected final String TEXT_523 = ".close();" + NL + "\t\tlistGroupby_";
  protected final String TEXT_524 = ".add(strWriter_";
  protected final String TEXT_525 = ".toString());" + NL + "" + NL + "\t\t//create a new StringWriter and BufferWriter" + NL + "\t\t//write the head title to the StringWriter\t\t" + NL + "\t\tstrWriter_";
  protected final String TEXT_526 = " = new java.io.StringWriter();" + NL + "\t\tout_";
  protected final String TEXT_527 = " = new java.io.BufferedWriter(strWriter_";
  protected final String TEXT_528 = ");";
  protected final String TEXT_529 = NL + "\t\tout_";
  protected final String TEXT_530 = ".write(\"<?xml version=\\\"1.0\\\" encoding=\\\"\"+";
  protected final String TEXT_531 = "+\"\\\"?>\");" + NL + "\t\tout_";
  protected final String TEXT_532 = ".write(\"";
  protected final String TEXT_533 = "\");";
  protected final String TEXT_534 = NL + NL + "\t\tneedRoot_";
  protected final String TEXT_535 = " = true;" + NL + "\t\tstrCompCache_";
  protected final String TEXT_536 = "=strTemp_";
  protected final String TEXT_537 = ";" + NL + "\t\tpreNewTabIndex_";
  protected final String TEXT_538 = " = -1;";
  protected final String TEXT_539 = NL + "\t\t}";
  protected final String TEXT_540 = "\t" + NL + "\t}\t" + NL + "\t" + NL + "\tStringBuffer buf_";
  protected final String TEXT_541 = " = new StringBuffer();" + NL + "\t//init value is 0 not -1, because it will output the root tab when all the row value is null." + NL + "\tint unNullMaxIndex_";
  protected final String TEXT_542 = " = 0;" + NL + "" + NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_543 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_544 = "=false;";
  protected final String TEXT_545 = NL + "\t\tif( false";
  protected final String TEXT_546 = " || valueMap_";
  protected final String TEXT_547 = ".get(\"";
  protected final String TEXT_548 = "\") != null";
  protected final String TEXT_549 = NL + "\t\t){" + NL + "\t\t\tunNullMaxIndex_";
  protected final String TEXT_550 = " = ";
  protected final String TEXT_551 = ";" + NL + "\t\t}";
  protected final String TEXT_552 = NL + "\t\tendTabs_";
  protected final String TEXT_553 = "[";
  protected final String TEXT_554 = "] = buf_";
  protected final String TEXT_555 = ".toString();" + NL + "\t\tbuf_";
  protected final String TEXT_556 = " = new StringBuffer();";
  protected final String TEXT_557 = NL + "\t}" + NL + "\t" + NL + "\t// build group xml tree ";
  protected final String TEXT_558 = NL + "\tboolean isNewElememt = false;" + NL + "\t//The index of group element which is the first new group in groups." + NL + "\tint newTabIndex_";
  protected final String TEXT_559 = " = -1;" + NL + "\t//Buffer all group tab XML, then set to startTabBuffer." + NL + "    String[] groupBuffer_";
  protected final String TEXT_560 = " = new String[";
  protected final String TEXT_561 = "];" + NL + "    String[] groupEndBuffer_";
  protected final String TEXT_562 = " = new String[";
  protected final String TEXT_563 = "];";
  protected final String TEXT_564 = NL + NL + "\t// need a new group element ";
  protected final String TEXT_565 = " or not" + NL + "\tif(isNewElememt || groupbyList_";
  protected final String TEXT_566 = ".size()<=";
  protected final String TEXT_567 = " || groupbyList_";
  protected final String TEXT_568 = ".get(";
  protected final String TEXT_569 = ")==null";
  protected final String TEXT_570 = NL + "\t|| ( groupbyList_";
  protected final String TEXT_571 = ".get(";
  protected final String TEXT_572 = ").get(";
  protected final String TEXT_573 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_574 = ".get(";
  protected final String TEXT_575 = ").get(";
  protected final String TEXT_576 = ").equals(";
  protected final String TEXT_577 = ") " + NL + "\t\t: ";
  protected final String TEXT_578 = "!=null )";
  protected final String TEXT_579 = NL + "\t){" + NL + "\t\t// Is the first new element in groups." + NL + "\t\tif(!isNewElememt && groupbyList_";
  protected final String TEXT_580 = ".size()>";
  protected final String TEXT_581 = "){" + NL + "\t\t\tnewTabIndex_";
  protected final String TEXT_582 = " = ";
  protected final String TEXT_583 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t// count the groupby element" + NL + "\t\tif(groupbyList_";
  protected final String TEXT_584 = ".size()<=";
  protected final String TEXT_585 = "){" + NL + "        \tgroupbyList_";
  protected final String TEXT_586 = ".add(new java.util.ArrayList<String>());" + NL + "        }else{" + NL + "        \tgroupbyList_";
  protected final String TEXT_587 = ".get(";
  protected final String TEXT_588 = ").clear();" + NL + "        }";
  protected final String TEXT_589 = NL + "\t\tgroupbyList_";
  protected final String TEXT_590 = ".get(";
  protected final String TEXT_591 = ").add(";
  protected final String TEXT_592 = ");";
  protected final String TEXT_593 = NL + "        isNewElememt=true;" + NL + "\t}" + NL + "\t" + NL + "\t// subtree XML string generate";
  protected final String TEXT_594 = NL + "\tif( false";
  protected final String TEXT_595 = " || valueMap_";
  protected final String TEXT_596 = ".get(\"";
  protected final String TEXT_597 = "\") != null";
  protected final String TEXT_598 = NL + "\t){" + NL + "\t\tunNullMaxIndex_";
  protected final String TEXT_599 = " = ";
  protected final String TEXT_600 = ";" + NL + "\t}";
  protected final String TEXT_601 = NL + "\t// buffer the end tabs to group buffer" + NL + "\tgroupEndBuffer_";
  protected final String TEXT_602 = "[";
  protected final String TEXT_603 = "] = buf_";
  protected final String TEXT_604 = ".toString();" + NL + "    buf_";
  protected final String TEXT_605 = " = new StringBuffer();";
  protected final String TEXT_606 = NL + "\t//output the previous groups as there's a new group" + NL + "    if (newTabIndex_";
  protected final String TEXT_607 = " >= 0 && preNewTabIndex_";
  protected final String TEXT_608 = "!=-1) {" + NL + "        //out_";
  protected final String TEXT_609 = ".newLine();//Track code";
  protected final String TEXT_610 = NL + "\t\t// output unNull tabs in start tabs buffer" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_611 = " >= 0) {" + NL + "            for (int i_";
  protected final String TEXT_612 = " = 0; i_";
  protected final String TEXT_613 = " < startTabs_";
  protected final String TEXT_614 = ".length; i_";
  protected final String TEXT_615 = "++) {" + NL + "                if (i_";
  protected final String TEXT_616 = " <= preUnNullMaxIndex_";
  protected final String TEXT_617 = ") {" + NL + "                    if (startTabs_";
  protected final String TEXT_618 = "[i_";
  protected final String TEXT_619 = "] != null) {" + NL + "                        out_";
  protected final String TEXT_620 = ".write(startTabs_";
  protected final String TEXT_621 = "[i_";
  protected final String TEXT_622 = "]);" + NL + "                    }" + NL + "                    startTabs_";
  protected final String TEXT_623 = "[i_";
  protected final String TEXT_624 = "] = null;" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_625 = NL + "\t\t//output all start tabs buffer" + NL + "\t\tfor (int i_";
  protected final String TEXT_626 = " = 0; i_";
  protected final String TEXT_627 = " < startTabs_";
  protected final String TEXT_628 = ".length; i_";
  protected final String TEXT_629 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_630 = "[i_";
  protected final String TEXT_631 = "] != null) {" + NL + "                out_";
  protected final String TEXT_632 = ".write(startTabs_";
  protected final String TEXT_633 = "[i_";
  protected final String TEXT_634 = "]);" + NL + "            }" + NL + "            startTabs_";
  protected final String TEXT_635 = "[i_";
  protected final String TEXT_636 = "] = null;" + NL + "        }";
  protected final String TEXT_637 = NL + "        // output endtabs" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_638 = " >= preNewTabIndex_";
  protected final String TEXT_639 = NL + "            && preUnNullMaxIndex_";
  protected final String TEXT_640 = " >= ";
  protected final String TEXT_641 = " + newTabIndex_";
  protected final String TEXT_642 = ") {" + NL + "            for (int i_";
  protected final String TEXT_643 = " = preUnNullMaxIndex_";
  protected final String TEXT_644 = "; i_";
  protected final String TEXT_645 = " >= ";
  protected final String TEXT_646 = " + newTabIndex_";
  protected final String TEXT_647 = "; i_";
  protected final String TEXT_648 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_649 = "[i_";
  protected final String TEXT_650 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_651 = ".write(endTabs_";
  protected final String TEXT_652 = "[i_";
  protected final String TEXT_653 = "]);" + NL + "            \t}" + NL + "            \tendTabs_";
  protected final String TEXT_654 = "[i_";
  protected final String TEXT_655 = "] = null;" + NL + "                out_";
  protected final String TEXT_656 = ".write(\"";
  protected final String TEXT_657 = "\");" + NL + "                out_";
  protected final String TEXT_658 = ".write(endTabStrs_";
  protected final String TEXT_659 = NL + "                        .get(i_";
  protected final String TEXT_660 = "));" + NL + "            }" + NL + "        } else {";
  protected final String TEXT_661 = NL + "            for (int i_";
  protected final String TEXT_662 = " = preNewTabIndex_";
  protected final String TEXT_663 = " - 1; i_";
  protected final String TEXT_664 = " >= ";
  protected final String TEXT_665 = " + newTabIndex_";
  protected final String TEXT_666 = "; i_";
  protected final String TEXT_667 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_668 = "[i_";
  protected final String TEXT_669 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_670 = ".write(endTabs_";
  protected final String TEXT_671 = "[i_";
  protected final String TEXT_672 = "]);" + NL + "            \t}" + NL + "            \tendTabs_";
  protected final String TEXT_673 = "[i_";
  protected final String TEXT_674 = "] = null;" + NL + "                out_";
  protected final String TEXT_675 = ".write(\"";
  protected final String TEXT_676 = "\");" + NL + "                out_";
  protected final String TEXT_677 = ".write(endTabStrs_";
  protected final String TEXT_678 = NL + "                        .get(i_";
  protected final String TEXT_679 = "));" + NL + "            }";
  protected final String TEXT_680 = NL + "        }";
  protected final String TEXT_681 = NL + "        preNewTabIndex_";
  protected final String TEXT_682 = " = newTabIndex_";
  protected final String TEXT_683 = " + ";
  protected final String TEXT_684 = ";" + NL + "    }" + NL + "" + NL + "    // set new element groupbuffer to startbuffer" + NL + "    for (int i_";
  protected final String TEXT_685 = " = 0; i_";
  protected final String TEXT_686 = " < groupBuffer_";
  protected final String TEXT_687 = ".length; i_";
  protected final String TEXT_688 = "++) {" + NL + "        // when newTabIndex is null, must use the perNewTabIndex" + NL + "        if (i_";
  protected final String TEXT_689 = " >= preNewTabIndex_";
  protected final String TEXT_690 = " - ";
  protected final String TEXT_691 = ") {" + NL + "            startTabs_";
  protected final String TEXT_692 = "[i_";
  protected final String TEXT_693 = " + ";
  protected final String TEXT_694 = "] = groupBuffer_";
  protected final String TEXT_695 = "[i_";
  protected final String TEXT_696 = "];" + NL + "            endTabs_";
  protected final String TEXT_697 = "[i_";
  protected final String TEXT_698 = " + ";
  protected final String TEXT_699 = "] = groupEndBuffer_";
  protected final String TEXT_700 = "[i_";
  protected final String TEXT_701 = "];" + NL + "        }" + NL + "    }";
  protected final String TEXT_702 = NL + "\t//reset the preUnNullMaxIndex" + NL + "\tif(unNullMaxIndex_";
  protected final String TEXT_703 = ">=0){" + NL + "    \tpreUnNullMaxIndex_";
  protected final String TEXT_704 = "=unNullMaxIndex_";
  protected final String TEXT_705 = ";" + NL + "\t}else{" + NL + "\t\tif(preUnNullMaxIndex_";
  protected final String TEXT_706 = ">";
  protected final String TEXT_707 = "){" + NL + "\t\t\tpreUnNullMaxIndex_";
  protected final String TEXT_708 = "=";
  protected final String TEXT_709 = ";" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_710 = NL + "\t// build loop xml tree";
  protected final String TEXT_711 = NL + "\t\tif( false";
  protected final String TEXT_712 = " || valueMap_";
  protected final String TEXT_713 = ".get(\"";
  protected final String TEXT_714 = "\") != null";
  protected final String TEXT_715 = " || true " + NL + "    \t";
  protected final String TEXT_716 = NL + "\t\t){";
  protected final String TEXT_717 = NL + "\t\t// output all buffer" + NL + "\t\tfor (int i_";
  protected final String TEXT_718 = " = 0; i_";
  protected final String TEXT_719 = " < startTabs_";
  protected final String TEXT_720 = ".length; i_";
  protected final String TEXT_721 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_722 = "[i_";
  protected final String TEXT_723 = "] != null && startTabs_";
  protected final String TEXT_724 = "[i_";
  protected final String TEXT_725 = "].length() > 0) {" + NL + "                out_";
  protected final String TEXT_726 = ".write(startTabs_";
  protected final String TEXT_727 = "[i_";
  protected final String TEXT_728 = "]);" + NL + "                startTabs_";
  protected final String TEXT_729 = "[i_";
  protected final String TEXT_730 = "] = null;" + NL + "            }" + NL + "        }" + NL + "\t\tout_";
  protected final String TEXT_731 = ".write(buf_";
  protected final String TEXT_732 = ".toString());" + NL + "\t\tpreNewTabIndex_";
  protected final String TEXT_733 = " = ";
  protected final String TEXT_734 = ";";
  protected final String TEXT_735 = NL + "            preUnNullMaxIndex_";
  protected final String TEXT_736 = " = ";
  protected final String TEXT_737 = ";" + NL + "\t\t}";
  protected final String TEXT_738 = NL;

    static class XMLNode {

        // table parameter of component
        public String name = null;

        public String path = null;

        public String type = null;

        public String column = null;
        
        public String defaultValue = null;
        
        public int order = 0;
        
        public boolean hasDefaultValue = false;

        // special node
        public int special = 0; // 1 is subtree root, 2 is subtree root parent, 4 is main

        // column
        public IMetadataColumn relatedColumn = null;

        public List<IMetadataColumn> childrenColumnList = new ArrayList<IMetadataColumn>();

        // tree variable
        public XMLNode parent = null;

        public List<XMLNode> attributes = new LinkedList<XMLNode>();

        public List<XMLNode> namespaces = new LinkedList<XMLNode>();

        public List<XMLNode> elements = new LinkedList<XMLNode>(); // the main element is the last element

        public XMLNode(String path, String type, XMLNode parent, String column, String value, int order) {
        	this.order = order;
            this.path = path;
            this.parent = parent;
            this.type = type;
            this.column = column;
            this.defaultValue = value;
            if (type.equals("ELEMENT")) {
                this.name = path.substring(path.lastIndexOf("/") + 1);
            } else {
                this.name = path;
            }
        }
        
        public boolean isMainNode(){
            return 4 == (special & 4);
        }
        
        public boolean isSubTreeRoot(){
            return 1 == (special & 1);
        }
        
        public boolean isSubTreeParent(){
            return 2 == (special & 2);
        }
    
        public int getNodeInsertIndex(){
        	int insertIndex =0;
        	if(5==(special & 5)){//group and loop main node
        		if(parent!=null && parent.elements!=null){
            		for(XMLNode tmpNode: parent.elements){
            			if(order <= tmpNode.order){
            				break;
            			}
            			insertIndex++;
            		}
        		}
        	}
        	return insertIndex;
        }
        
        public int getCurrGroupPos(){
        	int currPos =0;
        	if(5==(special & 5)){//group and loop main node
    			XMLNode tmpNode = parent;
    			while(tmpNode!=null && (5==(tmpNode.special & 5))){
    				currPos++;
    				tmpNode = tmpNode.parent;
    			}
        	}
        	return currPos;
        }
    }

    
    // return [0] is root(XMLNode), [1] is groups(List<XMLNode>), [2] loop(XMLNode)
    public Object[] getTree(List<Map<String, String>> rootTable, List<Map<String, String>> groupTable,
            List<Map<String, String>> loopTable, List<IMetadataColumn> colList) {
        List<List<Map<String, String>>> tables = new ArrayList<List<Map<String, String>>>();
        tables.add(rootTable);
        tables.add(groupTable);
        tables.add(loopTable);

        XMLNode root = null;
        List<XMLNode> mains = new ArrayList<XMLNode>();
        List<XMLNode> groups = new ArrayList<XMLNode>();
        XMLNode loop = null;

        XMLNode tmpParent = null;
        XMLNode tmpMainNode = null;
        if (loopTable == null || loopTable.size() == 0) {
            return null;
        }
        int index =0;
        int currOrder = 0;
        String mainPath = loopTable.get(0).get("PATH");
        for (List<Map<String, String>> tmpTable : tables) {
            tmpParent = tmpMainNode;
            for (Map<String, String> tmpMap : tmpTable) {
            	index++;
            	if(tmpMap.get("ORDER")!=null && !"".equals(tmpMap.get("ORDER").trim())){
            		currOrder = Integer.parseInt(tmpMap.get("ORDER"));
            	}else{
            		currOrder = index;
            	}
                XMLNode tmpNew = null;
                if (tmpMap.get("ATTRIBUTE").equals("attri")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "ATTRIBUTE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                    tmpParent.attributes.add(tmpNew);
                } else if (tmpMap.get("ATTRIBUTE").equals("ns")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "NAMESPACE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                    tmpParent.namespaces.add(tmpNew);
                } else {
                    if (tmpParent == null) {
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
//                        tmpNew.special |= 1;
                        root = tmpNew;
                        mains.add(root);
                    } else {
                        String tmpParentPath = tmpMap.get("PATH").substring(0, tmpMap.get("PATH").lastIndexOf("/"));
                        while (tmpParent != null && !tmpParentPath.equals(tmpParent.path)) {
                            tmpParent = tmpParent.parent;
                        }
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                        tmpParent.elements.add(tmpNew);
                        if (tmpMap.get("ATTRIBUTE").equals("main")) {
                            if (tmpTable == groupTable) {
                                tmpNew.special |= 1;
                                tmpParent.special |= 2;
                                groups.add(tmpNew);
                            } else if (tmpTable == loopTable) {
                                tmpNew.special |= 1;
                                tmpParent.special |= 2;
                                loop = tmpNew;
                            }else if (tmpTable == rootTable){
                                mains.add(tmpNew);
                            }
                        }
                    }
                    if (tmpMap.get("ATTRIBUTE").equals("main")) {
                        tmpMainNode = tmpNew;
                        tmpNew.special |= 4;
                    }
                    tmpParent = tmpNew;
                }
                setIMetadataColumn(tmpNew, colList);
                setDefaultValues(tmpNew);//add by wliu
            }
        }
        return new Object[] { mains, groups, loop };
    }
    
    private void setDefaultValues(XMLNode node){
    	if(node.defaultValue != null && !"".equals(node.defaultValue)){
    		XMLNode tmp = node;
    		while(tmp !=null){
    			tmp.hasDefaultValue = true;
    			if(tmp.isMainNode()){
    				break;
    			}
    			tmp = tmp.parent;
    		}
    	}
    }

    private void setIMetadataColumn(XMLNode node, List<IMetadataColumn> colList) {
        String value = null;
        JavaType javaType = null;
        if (node.column != null && node.column.length() > 0) {
            for (IMetadataColumn column : colList) {
                if (column.getLabel().equals(node.column)) {
                    node.relatedColumn = column;
                    XMLNode tmp = node;
                    while (tmp != null) {
                        if (!tmp.childrenColumnList.contains(column)) {
                            tmp.childrenColumnList.add(column);
                        }
                        if(tmp.isMainNode()){
                            break;
                        }
                        tmp = tmp.parent;
                    }
                }
            }
        }
    }

    public List<XMLNode> getGroupByNodeList(XMLNode group) {
        List<XMLNode> list = new ArrayList<XMLNode>();
        for (XMLNode attri : group.attributes) {
            if (attri.column != null && attri.column.length() != 0) {
                list.add(attri);
            }
        }
        if (group.relatedColumn != null) {
            list.add(group);
        } else {
            for (XMLNode element : group.elements) {
                if (!element.isMainNode()) {
                    list.addAll(getGroupByNodeList(element));
                }
            }
        }
        return list;
    }

    public XMLNode removeEmptyElement(XMLNode root) {
        List<XMLNode> removeNodes = new LinkedList<XMLNode>();
        for (XMLNode attri : root.attributes) {
            if ((attri.column == null || attri.column.length() == 0) && 
            		(attri.defaultValue == null || "".equals(attri.defaultValue)) ) {
                attri.parent = null;
                removeNodes.add(attri);
            }
        }
        root.attributes.removeAll(removeNodes);

        removeNodes.clear();
        for (XMLNode ns : root.namespaces) {
            if ( (ns.column == null || ns.column.length() == 0)
            		&& (ns.defaultValue == null || "".equals(ns.defaultValue)) ) {
                ns.parent = null;
                removeNodes.add(ns);
            }
        }
        root.namespaces.removeAll(removeNodes);

        removeNodes.clear();
        for (XMLNode child : root.elements) {
            removeNodes.add(removeEmptyElement(child));
        }
        root.elements.removeAll(removeNodes);

        if (root.attributes.size() == 0 && root.namespaces.size() == 0 && root.elements.size() == 0
                && (root.column == null || root.column.length() == 0)
                && (root.defaultValue == null || "".equals(root.defaultValue)) ) {
            return root;
        } else {
            return null;
        }
    }

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
//==========common part 1 begin===================================================================
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String jsonField = ElementParameterParser.getValue(node, "__JSONFIELD__");
String destination4JSON = ElementParameterParser.getValue(node, "__DESTINATION__");
boolean istWriteJSONField = destination4JSON == null ? false : destination4JSON.contains("tWriteJSONField_");
boolean isQuoteAllValues = ("true").equals(ElementParameterParser.getValue(node, "__QUOTE_ALL_VALUES__"));
boolean isCompactFormat = ("true").equals(ElementParameterParser.getValue(node, "__COMPACT_FORMAT__"));
final String whiteSpace;
final String rowSeparator;
if(!isCompactFormat) { // pretty format
	whiteSpace = "  ";
	rowSeparator = "\\n";
} else { // compact format
	whiteSpace = "";
	rowSeparator = "";
}
//===========common part 1 end=============================================================

    
//XMLTool
class XMLTool{
	public boolean advancedSeparator = false;
	public String thousandsSeparator = null;
 	public String decimalSeparator =null;
	public String connName = null;
	public String cid = null;
	
	public void getValue(XMLNode node){

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(node.relatedColumn.getLabel());
    stringBuffer.append(TEXT_31);
    
	}

	public void getValue(IMetadataColumn column){
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String defaultValue=column.getDefault();
		boolean isNotSetDefault = false;
		if(defaultValue!=null){
			isNotSetDefault = defaultValue.length()==0;
		}else{
			isNotSetDefault=true;
		}

    stringBuffer.append(TEXT_32);
    
		if(column.isNullable()){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    
		}
		
        if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        	if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_38);
    stringBuffer.append( thousandsSeparator);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_40);
    
    		} else {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_43);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_45);
    
	   		}
        } else if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_48);
    
        }else if(javaType == JavaTypesManager.DATE){
            if( column.getPattern() != null && column.getPattern().trim().length() != 0 ){

    stringBuffer.append(TEXT_49);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_52);
    
            }else{

    stringBuffer.append(TEXT_53);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel());
    
           }
        }else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_57);
    
        }else if (javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
    
        }else{

    stringBuffer.append(TEXT_61);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_63);
    
		}
		if(column.isNullable()){
			
    stringBuffer.append(TEXT_64);
     
			if(!isNotSetDefault){
				
    stringBuffer.append(column.getDefault());
    
			}else{
				
    stringBuffer.append(TEXT_65);
    
			}
		}

    stringBuffer.append(TEXT_66);
    
	}
}

// ------------------- *** Dom4j generation mode start *** ------------------- //
class GenerateToolByDom4j{
	String cid = null;
	boolean allowEmpty = false;
	boolean outputAsXSD = false;
    boolean istWriteJSONField = false;
    boolean isQuoteAllValues = false;
	XMLTool tool = null;
	public void generateCode(XMLNode node, String currEleName, String parentName){
		if(("ELEMENT").equals(node.type)){
			createElement(currEleName,node,parentName);
			setText(currEleName,node);
			for(XMLNode ns:node.namespaces){
				addNameSpace(currEleName,ns);
			}
			for(XMLNode attri:node.attributes){
				addAttribute(currEleName,attri);
			}
			if(node.name.indexOf(":")>0){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_70);
    
			}
			int index = 0;
			for(XMLNode child:node.elements){
				if(0==(child.special & 1)){
					generateCode(child,currEleName+"_"+index++,currEleName);
				}
			}
		}
	}
	private void createElement(String currEleName, XMLNode node, String parentName){
		int index = node.name.indexOf(":");
		if(5==(node.special & 5)){
			int currPos = node.getCurrGroupPos();
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_71);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_83);
    
			}else{

    stringBuffer.append(TEXT_84);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_87);
    
			}

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(node.getNodeInsertIndex() );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
		}else{
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_105);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_121);
    
			}else{

    stringBuffer.append(TEXT_122);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_127);
    
			}
		}
		if(0!=(node.special & 2)){

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
		}
	}
	private void setText(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_132);
    tool.getValue(node);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    tool.getValue(node);
    stringBuffer.append(TEXT_137);
    
				if(outputAsXSD){

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
				}
			}else{

    stringBuffer.append(TEXT_144);
    tool.getValue(node);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    tool.getValue(node);
    stringBuffer.append(TEXT_149);
    
                boolean hasCustomAttrs = false;
                for (XMLNode attribute : node.attributes) {
                    if (!"type".equals(attribute.name) && !"class".equals(attribute.name)) {
                        hasCustomAttrs = true;
                        break;
                    }
                }

                if (istWriteJSONField && !isQuoteAllValues && !hasCustomAttrs) {
                    if (javaType == JavaTypesManager.BOOLEAN) {

    stringBuffer.append(TEXT_150);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
                    } else if (JavaTypesManager.isNumberType(javaType)) {

    stringBuffer.append(TEXT_153);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
                    }
                }

    stringBuffer.append(TEXT_156);
    
				if(outputAsXSD){

    stringBuffer.append(TEXT_157);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
				}
			}
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_166);
    
		}
	}
	private void addAttribute(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_167);
    tool.getValue(node);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_171);
    tool.getValue(node);
    stringBuffer.append(TEXT_172);
    
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_173);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_177);
    
		}
	}
	private void addNameSpace(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_178);
    tool.getValue(node);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_182);
    tool.getValue(node);
    stringBuffer.append(TEXT_183);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_184);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    tool.getValue(node);
    stringBuffer.append(TEXT_189);
    
			}

    stringBuffer.append(TEXT_190);
    
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_191);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(node.path );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_195);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_196);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_201);
    
			}
		}
	}
}
// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Null generation mode start *** ------------------- //
class GenerateToolByNull{
	String cid = null;
	boolean allowEmpty = false;
	boolean outputAsXSD = false;
	String fileNameXSD = "";
	XMLTool tool = null;
	
	public void generateCode(XMLNode node, String emptySpace){	
		if(("ELEMENT").equals(node.type)){
			startElement(node,emptySpace);
			setText(node);
			XMLNode mainChild = null;
			for(XMLNode child:node.elements){
				if(child.isMainNode()){ //loop dosen't have a main child node
					mainChild = child;
					break;
				}
			}
			for(XMLNode child:node.elements){
				if(mainChild!=null && mainChild.order<=child.order){ //loop dosen't have a main child node
					if(1==(node.special & 1)){ // group

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(node.getCurrGroupPos());
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    
					}else{// root
    					int num = node.path.split("/").length-2;
    					if(!outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(num);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
						}else{

    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
						}
					}
					mainChild = null;
				}
				if(!child.isMainNode()){ //make the main node output last
					if(!outputAsXSD && !allowEmpty && (child.relatedColumn != null || child.childrenColumnList.size()>0 || child.hasDefaultValue == true)){

    stringBuffer.append(TEXT_216);
    
                    	for(IMetadataColumn column : child.childrenColumnList){
                    		
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_219);
    
                    	}
                    	if(child.hasDefaultValue == true){
    stringBuffer.append(TEXT_220);
    }
    stringBuffer.append(TEXT_221);
    
						generateCode(child,emptySpace+whiteSpace);

    stringBuffer.append(TEXT_222);
    
            		}else{
            			generateCode(child,emptySpace+whiteSpace);
            		}
				}
			}

			if(!node.isMainNode()){ // is not main node
				endElement(node,emptySpace);
			}
		}
	}
	private void startElement(XMLNode node, String emptySpace){

    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_228);
    
		if(outputAsXSD && node.parent==null){

    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(fileNameXSD);
    stringBuffer.append(TEXT_232);
    
		}
		for(XMLNode ns:node.namespaces){
			addNameSpace(ns);
		}
		for(XMLNode attri:node.attributes){
			addAttribute(attri);
		}
		if(outputAsXSD && node.relatedColumn != null){

    stringBuffer.append(TEXT_233);
    tool.getValue(node);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    
		}

    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    
	}
	
	public void endElement(XMLNode node, String emptySpace){
		if(node.elements.size()>0){

    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_243);
    
		}else{

    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_246);
    
		}
	}
	private void setText(XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_247);
    tool.getValue(node);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    tool.getValue(node);
    stringBuffer.append(TEXT_250);
    
			}else{

    stringBuffer.append(TEXT_251);
    tool.getValue(node);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    tool.getValue(node);
    stringBuffer.append(TEXT_254);
    
			}
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_257);
    
		}
	}
	private void addAttribute(XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_258);
    tool.getValue(node);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_261);
    tool.getValue(node);
    stringBuffer.append(TEXT_262);
    
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_266);
    
		}
	}
	private void addNameSpace(XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_267);
    tool.getValue(node);
    stringBuffer.append(TEXT_268);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    tool.getValue(node);
    stringBuffer.append(TEXT_271);
    
			}else{

    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_274);
    tool.getValue(node);
    stringBuffer.append(TEXT_275);
    
			}

    stringBuffer.append(TEXT_276);
    
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_279);
    
			}else{

    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_283);
    
			}
		}
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

// ------------------- *** Common code start *** ------------------- //
IMetadataTable metadata = null;
IConnection inConn = null;
for (IConnection conn : node.getIncomingConnections()) {
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.FLOW)) {
		inConn = conn;
		break;
	}
}
if (inConn != null) {
	metadata = inConn.getMetadataTable();
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	List< ? extends IConnection> connsOut = NodeUtil.getOutgoingConnections(node,EConnectionType.ON_COMPONENT_OK);
    	String rowStructNameOutput = null;
    	if (connsOut != null && connsOut.size() > 0 && istWriteJSONField) {
    		List< ? extends IConnection> connsTarget = connsOut.get(0).getTarget().getOutgoingConnections();
			if(connsTarget != null && connsTarget.size()>0){
				rowStructNameOutput = connsTarget.get(0).getName();
	    		rowStructNameOutput += "Struct";
			}
    	}
    	String rowNameInput = null;
    	String rowStructNameInput = null;
    	if(conns!=null && conns.size()>0){
    		IConnection conn = conns.get(0);
    		rowNameInput = conn.getName();
    		rowStructNameInput = rowNameInput + "Struct";
    		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){ 
    		
            	List<Map<String, String>> rootTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
                List<Map<String, String>> groupTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
                List<Map<String, String>> loopTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
                
                IMetadataTable inputMetadataTable= conn.getMetadataTable();
                List<IMetadataColumn> inputColumns= inputMetadataTable.getListColumns();
                
                List<Map<String,String>> groupbys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
				
				String removeHeader = ElementParameterParser.getValue(node, "__REMOVE_HEADER__"); // add for feature7788
                String allowEmpty = ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__");
                String outputAsXSD = ElementParameterParser.getValue(node, "__OUTPUT_AS_XSD__");
                String fileNameXSD = ElementParameterParser.getValue(node, "__XSD_FILE__");
                String encoding = ElementParameterParser.getValue(node, "__ENCODING__");                
                
	            String rowNumber = ElementParameterParser.getValue(node, "__ROW_NUMBER__");
                
                String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
        		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
        		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
        		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
        		
        		String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
        		
        		boolean storeFlow = ("true").equals(ElementParameterParser.getValue(node, "__STORE_FLOW__"));
        		                
                java.util.Map<String,IMetadataColumn> inputKeysColumns = new java.util.HashMap<String,IMetadataColumn>();
                if(inputColumns!=null){
                	for(IMetadataColumn column :inputColumns){
                		for(int i=0;i<groupbys.size();i++){
                			String columnName=groupbys.get(i).get("INPUT_COLUMN");
                			if(column.getLabel().equals(columnName)){
                				inputKeysColumns.put(columnName,column);
                				break;
                			}
                		}
                	}
                }
        		
                String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
        		// init tool
                XMLTool tool = new XMLTool();
                tool.connName = conn.getName();
                tool.advancedSeparator=advancedSeparator;
                tool.thousandsSeparator=thousandsSeparator;
                tool.decimalSeparator=decimalSeparator;
                tool.cid=cid;
                
                // change tables to a tree 
				Object[] treeObjs = getTree(rootTable, groupTable, loopTable, metadata.getListColumns());
            	List<XMLNode> mainList = (ArrayList<XMLNode>)treeObjs[0];
                List<XMLNode> groupList = (ArrayList<XMLNode>)treeObjs[1];
                XMLNode root = mainList.get(0);
            	XMLNode loop = (XMLNode)treeObjs[2];
                
                if(!("true").equals(allowEmpty)){
                	removeEmptyElement(root);
                }
                
                List<List<XMLNode>> groupbyNodeList = new ArrayList<List<XMLNode>>();
                for(XMLNode group:groupList){
                	groupbyNodeList.add(getGroupByNodeList(group));
                }
                IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
				if(nextMergeConn == null || nextMergeConn.getInputId()==1){

    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    
				}

    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    
	log4jFileUtil.logCurrentRowNumberInfo();

    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    
				for(IMetadataColumn column :inputColumns){

    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_294);
    tool.getValue(column);
    stringBuffer.append(TEXT_295);
    
				}

    if(storeFlow){
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
    }
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    
	if(inputKeysColumns.size() !=0){
		for (IMetadataColumn column : inputColumns) {
			if(inputKeysColumns.containsKey(column.getLabel())) {

    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_310);
    			}
		}
	}

    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    
		if(istWriteJSONField){
            for(Map<String,String> map : groupbys){
            	String groupByColumnName = map.get("INPUT_COLUMN");
            	String outputColumnName = map.get("OUTPUT_COLUMN");
            	if (!outputColumnName.equals(jsonField)) {
            	
    stringBuffer.append(TEXT_315);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append( groupByColumnName );
    stringBuffer.append(TEXT_317);
    stringBuffer.append( rowNameInput );
    stringBuffer.append(TEXT_318);
    stringBuffer.append( groupByColumnName );
    stringBuffer.append(TEXT_319);
    
            	}
            }
		}
		
    stringBuffer.append(TEXT_320);
    
// ------------------- *** Common code end *** ------------------- //

// ------------------- *** Dom4j generation mode start *** ------------------- //
if(("Dom4j").equals(mode)){
		if(inputKeysColumns.size() !=0){

    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    		}
		if(("true").equals(outputAsXSD)){

    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(fileNameXSD);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    
		}

    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    
		}

    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    
		if(("true").equals(removeHeader)){

    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    
		}else{
            if(destination!=null && (destination.indexOf("tCouchbaseOutput_")==0) || destination.indexOf("tCouchDBOutput_")==0){

    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    
            }else{
				if(istWriteJSONField){
					
    stringBuffer.append(TEXT_357);
    stringBuffer.append( rowStructNameOutput );
    stringBuffer.append(TEXT_358);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append( rowStructNameOutput );
    stringBuffer.append(TEXT_360);
    
					      for(Map<String,String> map : groupbys){
								String groupByColumnName = map.get("INPUT_COLUMN");
								String outputColumnName = map.get("OUTPUT_COLUMN");
								if (!outputColumnName.equals(jsonField)) {
								
    stringBuffer.append(TEXT_361);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append( outputColumnName );
    stringBuffer.append(TEXT_363);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append( groupByColumnName );
    stringBuffer.append(TEXT_365);
    
								}
					     }
					
    stringBuffer.append(TEXT_366);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append( jsonField );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_371);
    
				}else{
								
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    
				}
            }
		}

    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    
		if(istWriteJSONField){
			for(Map<String,String> map : groupbys){
            	String groupByColumnName = map.get("INPUT_COLUMN");
            	String outputColumnName = map.get("OUTPUT_COLUMN");
            	if (!outputColumnName.equals(jsonField)) {
            	
    stringBuffer.append(TEXT_389);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append( groupByColumnName );
    stringBuffer.append(TEXT_391);
    stringBuffer.append( rowNameInput );
    stringBuffer.append(TEXT_392);
    stringBuffer.append( groupByColumnName );
    stringBuffer.append(TEXT_393);
    
            	}
            }
		}
		if(inputKeysColumns.size() !=0){

    stringBuffer.append(TEXT_394);
    
		}

    stringBuffer.append(TEXT_395);
    
	//init the generate tool.
	GenerateToolByDom4j generateToolByDom4j = new GenerateToolByDom4j();
    if(("true").equals(outputAsXSD)){
    	generateToolByDom4j.outputAsXSD = true;
    }
    if(("true").equals(allowEmpty)){
    	generateToolByDom4j.allowEmpty = true;
    }
    generateToolByDom4j.istWriteJSONField = istWriteJSONField;
    generateToolByDom4j.isQuoteAllValues = isQuoteAllValues;
    generateToolByDom4j.cid = cid;
    generateToolByDom4j.tool = tool;
    
    //start generate code
    if(destination!=null && (destination.indexOf("tCouchbaseOutput_")==0 || destination.indexOf("tCouchDBOutput_")==0)){
        INode previousNode = conn.getSource();
        List<IMetadataTable> previous_metadatas = previousNode.getMetadataList();
        if ((previous_metadatas!=null)&&(previous_metadatas.size()>0)) {
            IMetadataTable previous_metadata = previous_metadatas.get(0);
            if (previous_metadata!=null) {
                List<IMetadataColumn> columnList = previous_metadata.getListColumns();

    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    
                for(IMetadataColumn colum: columnList){

    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(colum.getLabel());
    stringBuffer.append(TEXT_400);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_401);
    stringBuffer.append(colum.getLabel());
    stringBuffer.append(TEXT_402);
    
                }
            }
        }
    }

    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    
	generateToolByDom4j.generateCode(root,"root","doc");

    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_412);
    
	}
	for(int i=0;i<groupList.size();i++){
		XMLNode groupRootNode = groupList.get(i);

    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_417);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);
			if(attr.relatedColumn!=null){

    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_424);
    tool.getValue(attr);
    stringBuffer.append(TEXT_425);
    tool.getValue(attr);
    stringBuffer.append(TEXT_426);
    
			}
		}

    stringBuffer.append(TEXT_427);
    
		generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");

    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_433);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);

    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_436);
    tool.getValue(attr);
    stringBuffer.append(TEXT_437);
    
		}

    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_450);
    
	}

    stringBuffer.append(TEXT_451);
    
	generateToolByDom4j.generateCode(loop,"loop","subTreeRootParent");
}
// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Null generation mode start *** ------------------- //
else if(("Null").equals(mode)){
//	String fileNameXSD = ElementParameterParser.getValue(node, "__XSD_FILE__");
	//init the generate tool.
	GenerateToolByNull generateToolByNull = new GenerateToolByNull();
    if(("true").equals(outputAsXSD)){
    	generateToolByNull.outputAsXSD = true;
    	generateToolByNull.fileNameXSD = fileNameXSD;
    }
    if(("true").equals(allowEmpty)){
    	generateToolByNull.allowEmpty = true;
    }
    generateToolByNull.cid = cid;
    generateToolByNull.tool = tool;

	if(inputKeysColumns.size() !=0){
	
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    	}
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_491);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    
		}else{
			if(loopTable.size()>0){

    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    
			}
		}

    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    
	if(!("true").equals(removeHeader)){

    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_530);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_533);
    
	}

    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    	if(inputKeysColumns.size() !=0){
    stringBuffer.append(TEXT_539);
    	}
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    
	String rootEmptySpace = "";
	for(int i=0;i<mainList.size();i++){
		generateToolByNull.generateCode(mainList.get(i),rootEmptySpace);
		rootEmptySpace+=whiteSpace;
		
		if(!generateToolByNull.outputAsXSD && !generateToolByNull.allowEmpty){
			if(mainList.get(i).relatedColumn != null || mainList.get(i).childrenColumnList.size()>0){

    stringBuffer.append(TEXT_545);
    
                	for(IMetadataColumn column : mainList.get(i).childrenColumnList){
                		
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_548);
    
                	}

    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_551);
    
			}
		}

    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_553);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    

	}

    stringBuffer.append(TEXT_557);
    
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(groupList.size());
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(groupList.size());
    stringBuffer.append(TEXT_563);
    
	}
	for(int i=0;i<groupList.size();i++){
		XMLNode groupRootNode = groupList.get(i);

    stringBuffer.append(TEXT_564);
    stringBuffer.append(groupRootNode.name);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_569);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);
			if(attr.relatedColumn!=null){

    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_576);
    tool.getValue(attr);
    stringBuffer.append(TEXT_577);
    tool.getValue(attr);
    stringBuffer.append(TEXT_578);
    
			}
		}

    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_588);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);

    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_591);
    tool.getValue(attr);
    stringBuffer.append(TEXT_592);
    
		}

    stringBuffer.append(TEXT_593);
    
		String emptySpace = "";
		for(int len = groupList.get(i).path.split("/").length-1;len>1;len--){
			emptySpace +=whiteSpace;
		}
		generateToolByNull.generateCode(groupList.get(i),emptySpace);
		
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){
			if((groupList.get(i).relatedColumn != null || groupList.get(i).childrenColumnList.size()>0)){

    stringBuffer.append(TEXT_594);
    
            	for(IMetadataColumn column : groupList.get(i).childrenColumnList){
            		
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_597);
    
            	}

    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(i+mainList.size());
    stringBuffer.append(TEXT_600);
    
			}
		}

    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    
	}//End of groupList loop
	
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    
		}else{

    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    
		}
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_656);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    
		}

    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_675);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_680);
    
		}

    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    
	}
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_706);
    stringBuffer.append(mainList.size()-1);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(mainList.size()-1);
    stringBuffer.append(TEXT_709);
    
	}

    stringBuffer.append(TEXT_710);
    
	String emptySpace = "";
	for(int len =loop.path.split("/").length-1;len>1;len--){
		emptySpace +=whiteSpace;
	}
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_711);
    
    	for(IMetadataColumn column : loop.childrenColumnList){
    		
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_713);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_714);
    
    	}
    	if(loop.hasDefaultValue == true){
    stringBuffer.append(TEXT_715);
    }
    stringBuffer.append(TEXT_716);
    
	}
	generateToolByNull.generateCode(loop,emptySpace);
	generateToolByNull.endElement(loop,emptySpace);

    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_728);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(groupList.size()+mainList.size());
    stringBuffer.append(TEXT_734);
    
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(groupList.size()+mainList.size()-1);
    stringBuffer.append(TEXT_737);
    
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

// ------------------- *** Common code start *** ------------------- //
			}
		}
	}
}
// ------------------- *** Common code end *** ------------------- //

    stringBuffer.append(TEXT_738);
    return stringBuffer.toString();
  }
}

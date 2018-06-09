package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.ArrayList;
import java.util.LinkedList;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;

/**
 * add by xzhang
 */
public class TAdvancedFileOutputXMLBeginJava {

  protected static String nl;
  public static synchronized TAdvancedFileOutputXMLBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedFileOutputXMLBeginJava result = new TAdvancedFileOutputXMLBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tvalueMap_";
  protected final String TEXT_3 = ".get(\"";
  protected final String TEXT_4 = "\")";
  protected final String TEXT_5 = NL + "\t(";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " != null?";
  protected final String TEXT_9 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_10 = "), ";
  protected final String TEXT_11 = ",";
  protected final String TEXT_12 = ")\t\t\t\t\t";
  protected final String TEXT_13 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = "), ";
  protected final String TEXT_16 = ",";
  protected final String TEXT_17 = ")\t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "            String.valueOf(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ")";
  protected final String TEXT_21 = NL + "            FormatterUtils.format_Date(";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = ",";
  protected final String TEXT_24 = ")";
  protected final String TEXT_25 = NL + "\t\t\t";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = NL + "\t\t\tString.valueOf(";
  protected final String TEXT_28 = ")";
  protected final String TEXT_29 = NL + "\t\t\t";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ".formatXMLString(compactFormat_";
  protected final String TEXT_32 = ")";
  protected final String TEXT_33 = NL + "            ";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = ".toString()";
  protected final String TEXT_36 = ":";
  protected final String TEXT_37 = "null";
  protected final String TEXT_38 = NL + "\t\t)";
  protected final String TEXT_39 = NL + "\t\t";
  protected final String TEXT_40 = "_";
  protected final String TEXT_41 = NL + "\t\t";
  protected final String TEXT_42 = "_";
  protected final String TEXT_43 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_44 = "\");";
  protected final String TEXT_45 = NL + "\t\t";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_48 = "\");";
  protected final String TEXT_49 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_50 = "_";
  protected final String TEXT_51 = " = null;";
  protected final String TEXT_52 = NL + "\t\t";
  protected final String TEXT_53 = "_";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = "_";
  protected final String TEXT_56 = ".addElement(\"";
  protected final String TEXT_57 = "\");";
  protected final String TEXT_58 = NL + "\t\t";
  protected final String TEXT_59 = "_";
  protected final String TEXT_60 = " = ";
  protected final String TEXT_61 = "_";
  protected final String TEXT_62 = ".addElement(\"";
  protected final String TEXT_63 = "\");";
  protected final String TEXT_64 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_65 = " = ";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = ";";
  protected final String TEXT_68 = NL + "\t\torg.dom4j.Element subTreeRootParent_";
  protected final String TEXT_69 = " = null;";
  protected final String TEXT_70 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_71 = " =  tempElem;";
  protected final String TEXT_72 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_73 = "=root4Group_";
  protected final String TEXT_74 = ";";
  protected final String TEXT_75 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_76 = " = firstGroupPathElement_";
  protected final String TEXT_77 = ";";
  protected final String TEXT_78 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_79 = "=group";
  protected final String TEXT_80 = "__";
  protected final String TEXT_81 = ";";
  protected final String TEXT_82 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_83 = "=groupElementList_";
  protected final String TEXT_84 = ".get(";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_87 = "=loop_";
  protected final String TEXT_88 = ";";
  protected final String TEXT_89 = NL + "\t\tnameToElement_";
  protected final String TEXT_90 = ".get(\"";
  protected final String TEXT_91 = "\")";
  protected final String TEXT_92 = NL + "\t\t((org.dom4j.Element)(nameToElement_";
  protected final String TEXT_93 = ".get(\"";
  protected final String TEXT_94 = "\")))";
  protected final String TEXT_95 = NL + "\t\tnameToElement_";
  protected final String TEXT_96 = ".put(\"";
  protected final String TEXT_97 = "\",org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_98 = "\"));";
  protected final String TEXT_99 = NL + "\t\tnameToElement_";
  protected final String TEXT_100 = ".put(\"";
  protected final String TEXT_101 = "\",org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_102 = "\"));";
  protected final String TEXT_103 = NL + "\t\tnameToElement_";
  protected final String TEXT_104 = ".put(\"";
  protected final String TEXT_105 = "\",";
  protected final String TEXT_106 = ".addElement(\"";
  protected final String TEXT_107 = "\"));";
  protected final String TEXT_108 = NL + "\t\tnameToElement_";
  protected final String TEXT_109 = ".put(\"";
  protected final String TEXT_110 = "\",";
  protected final String TEXT_111 = ".addElement(\"";
  protected final String TEXT_112 = "\"));";
  protected final String TEXT_113 = NL + "\t\tnameToElement_";
  protected final String TEXT_114 = ".put(\"subTreeRootParent\",";
  protected final String TEXT_115 = ");";
  protected final String TEXT_116 = NL + "\t\tnameToElement_";
  protected final String TEXT_117 = ".put(\"subTreeRootParent\",null);";
  protected final String TEXT_118 = NL + "\t\tnameToElement_";
  protected final String TEXT_119 = ".put(\"subTreeRootParent\",tempElem);";
  protected final String TEXT_120 = NL + "\t\tnameToElement_";
  protected final String TEXT_121 = ".put(\"doc\",doc_";
  protected final String TEXT_122 = ");";
  protected final String TEXT_123 = NL + "\t\tnameToElement_";
  protected final String TEXT_124 = ".put(\"subTreeRootParent\",root4Group_";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "\t\tnameToElement_";
  protected final String TEXT_127 = ".put(\"subTreeRootParent\",firstGroupPathElement_";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "\t\tnameToElement_";
  protected final String TEXT_130 = ".put(\"subTreeRootParent\",group";
  protected final String TEXT_131 = "__";
  protected final String TEXT_132 = ");";
  protected final String TEXT_133 = NL + "\t\tnameToElement_";
  protected final String TEXT_134 = ".put(\"subTreeRootParent\",groupElementList_";
  protected final String TEXT_135 = ".get(";
  protected final String TEXT_136 = "));";
  protected final String TEXT_137 = NL + "\t\tnameToElement_";
  protected final String TEXT_138 = ".put(\"subTreeRootParent\",loop_";
  protected final String TEXT_139 = ");";
  protected final String TEXT_140 = NL;
  protected final String TEXT_141 = NL + "\t\t\tclass TalendXMLGenerateTool_";
  protected final String TEXT_142 = "_";
  protected final String TEXT_143 = " {";
  protected final String TEXT_144 = NL + "\t\t\t}";
  protected final String TEXT_145 = NL + "\t\t\t\tpublic void generateDocument_";
  protected final String TEXT_146 = "() throws java.lang.Exception{";
  protected final String TEXT_147 = NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void generateDocument_";
  protected final String TEXT_148 = "() throws java.lang.Exception{";
  protected final String TEXT_149 = NL + "\t\t\tTalendXMLGenerateTool_";
  protected final String TEXT_150 = "_";
  protected final String TEXT_151 = " talendXMLGenerateTool_";
  protected final String TEXT_152 = "_";
  protected final String TEXT_153 = " = new TalendXMLGenerateTool_";
  protected final String TEXT_154 = "_";
  protected final String TEXT_155 = "();";
  protected final String TEXT_156 = NL + "\t\t\t\t\ttalendXMLGenerateTool_";
  protected final String TEXT_157 = "_";
  protected final String TEXT_158 = ".generateDocument_";
  protected final String TEXT_159 = "();";
  protected final String TEXT_160 = NL;
  protected final String TEXT_161 = NL + "\t\t\t";
  protected final String TEXT_162 = ".setName(\"";
  protected final String TEXT_163 = "\");";
  protected final String TEXT_164 = NL + "\t\t\tif (";
  protected final String TEXT_165 = ".content().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_166 = ".attributes().size() == 0 " + NL + "\t\t\t\t&& ";
  protected final String TEXT_167 = ".declaredNamespaces().size() == 0) {";
  protected final String TEXT_168 = ".remove(";
  protected final String TEXT_169 = ");" + NL + "            }" + NL + "\t\t\t";
  protected final String TEXT_170 = NL + "\t\tif (";
  protected final String TEXT_171 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_172 = "\") == null) {" + NL + "\t\t\t";
  protected final String TEXT_173 = NL + "        } else {" + NL + "        \t";
  protected final String TEXT_174 = NL + "        }";
  protected final String TEXT_175 = NL + "\t\t";
  protected final String TEXT_176 = NL + "\t\tList currentList_";
  protected final String TEXT_177 = " =  ";
  protected final String TEXT_178 = ".elements(\"";
  protected final String TEXT_179 = "\");" + NL + "\t\tint app_size_";
  protected final String TEXT_180 = " = currentList_";
  protected final String TEXT_181 = ".size();" + NL + "\t\tif(app_size_";
  protected final String TEXT_182 = " > 0){" + NL + "\t\t\torders_";
  protected final String TEXT_183 = "[";
  protected final String TEXT_184 = "] =1+ ";
  protected final String TEXT_185 = ".elements().indexOf(currentList_";
  protected final String TEXT_186 = ".get(app_size_";
  protected final String TEXT_187 = "-1));" + NL + "\t\t}else{//when the group or loop element appear first time";
  protected final String TEXT_188 = NL + "\t\t\tList allList_";
  protected final String TEXT_189 = " = ";
  protected final String TEXT_190 = ".elements();" + NL + "\t\t\t//append tail as default action" + NL + "\t\t\torders_";
  protected final String TEXT_191 = "[";
  protected final String TEXT_192 = "] = allList_";
  protected final String TEXT_193 = ".size();";
  protected final String TEXT_194 = NL + "\t\t\tList siblingList_";
  protected final String TEXT_195 = " = null;" + NL + "\t\t\tboolean findInsertPosition_";
  protected final String TEXT_196 = " = false;";
  protected final String TEXT_197 = NL + "\t\t\tif(!findInsertPosition_";
  protected final String TEXT_198 = " && allList_";
  protected final String TEXT_199 = ".size()!=0) {" + NL + "\t\t\t\tsiblingList_";
  protected final String TEXT_200 = " = ";
  protected final String TEXT_201 = ".elements(\"";
  protected final String TEXT_202 = "\");" + NL + "\t\t\t\tif(siblingList_";
  protected final String TEXT_203 = ".size() > 0) {" + NL + "\t\t\t\t\tfindInsertPosition_";
  protected final String TEXT_204 = " = true;" + NL + "\t\t\t\t\torders_";
  protected final String TEXT_205 = "[";
  protected final String TEXT_206 = "] = allList_";
  protected final String TEXT_207 = ".indexOf(siblingList_";
  protected final String TEXT_208 = ".get(0));" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_209 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_210 = ".elements().add(orders_";
  protected final String TEXT_211 = "[";
  protected final String TEXT_212 = "],";
  protected final String TEXT_213 = ");";
  protected final String TEXT_214 = NL + "        if(orders_";
  protected final String TEXT_215 = "[";
  protected final String TEXT_216 = "]==0){" + NL + "        \torders_";
  protected final String TEXT_217 = "[";
  protected final String TEXT_218 = "] = ";
  protected final String TEXT_219 = ";" + NL + "        }" + NL + "        if(";
  protected final String TEXT_220 = " < orders_";
  protected final String TEXT_221 = ".length){" + NL + "        \t\torders_";
  protected final String TEXT_222 = "[";
  protected final String TEXT_223 = "] = 0;" + NL + "        }";
  protected final String TEXT_224 = ".elements().add(orders_";
  protected final String TEXT_225 = "[";
  protected final String TEXT_226 = "]++,";
  protected final String TEXT_227 = ");";
  protected final String TEXT_228 = NL + "\t\tif (";
  protected final String TEXT_229 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_230 = "\") == null) {";
  protected final String TEXT_231 = NL + "        } else {" + NL + "        \t";
  protected final String TEXT_232 = NL + "        }";
  protected final String TEXT_233 = NL + "\t\t";
  protected final String TEXT_234 = NL + "\t\t";
  protected final String TEXT_235 = NL + "\t\tif(";
  protected final String TEXT_236 = "!=null){" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_237 = " .parseAndAdd(";
  protected final String TEXT_238 = ",";
  protected final String TEXT_239 = ");" + NL + "\t\t}";
  protected final String TEXT_240 = NL + "\t\telse{" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_241 = " .parseAndAdd(";
  protected final String TEXT_242 = ",\"\");" + NL + "\t\t\t";
  protected final String TEXT_243 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_244 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_245 = "!=null){";
  protected final String TEXT_246 = NL + "\t\t\t\t\t\t\tnestXMLTool_";
  protected final String TEXT_247 = " .appendContent(";
  protected final String TEXT_248 = "_";
  protected final String TEXT_249 = ", ParserUtils.parseTo_Document(";
  protected final String TEXT_250 = ").getDocument());";
  protected final String TEXT_251 = NL + "\t\t\t\t\t\t\tnestXMLTool_";
  protected final String TEXT_252 = " .setText(";
  protected final String TEXT_253 = "_";
  protected final String TEXT_254 = ", ParserUtils.parseTo_Document(";
  protected final String TEXT_255 = ").getDocument().getRootElement().asXML());";
  protected final String TEXT_256 = NL + "\t\t\t\t\t}";
  protected final String TEXT_257 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_258 = "!=null){" + NL + "\t\t\t\t\t\tnestXMLTool_";
  protected final String TEXT_259 = " .setText(";
  protected final String TEXT_260 = ",";
  protected final String TEXT_261 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_262 = NL + "\t\telse{" + NL + "\t\t\t";
  protected final String TEXT_263 = ".setText(\"\");" + NL + "\t\t\t";
  protected final String TEXT_264 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_265 = NL + "\t\tnestXMLTool_";
  protected final String TEXT_266 = ".parseAndAdd(";
  protected final String TEXT_267 = ",\"";
  protected final String TEXT_268 = "\");" + NL;
  protected final String TEXT_269 = " " + NL + "\t\t  if (";
  protected final String TEXT_270 = " != null){" + NL + "\t\t\t";
  protected final String TEXT_271 = ".addAttribute(\"";
  protected final String TEXT_272 = "\", ";
  protected final String TEXT_273 = ");" + NL + "\t\t  } ";
  protected final String TEXT_274 = " else {" + NL + "\t\t    ";
  protected final String TEXT_275 = ".addAttribute(\"";
  protected final String TEXT_276 = "\", \"\");" + NL + "          }";
  protected final String TEXT_277 = NL + "\t\t    ";
  protected final String TEXT_278 = ".addAttribute(\"";
  protected final String TEXT_279 = "\", \"";
  protected final String TEXT_280 = "\");";
  protected final String TEXT_281 = NL + "\t\t    ";
  protected final String TEXT_282 = ".addAttribute(\"";
  protected final String TEXT_283 = "\", \"\");" + NL + "\t\t  ";
  protected final String TEXT_284 = NL + "\t\tif(";
  protected final String TEXT_285 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_286 = ".addNamespace(\"";
  protected final String TEXT_287 = "\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_288 = "));";
  protected final String TEXT_289 = NL + "        \t";
  protected final String TEXT_290 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_291 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_292 = "))));";
  protected final String TEXT_293 = NL + "\t\t}";
  protected final String TEXT_294 = NL + "\t\t\t";
  protected final String TEXT_295 = ".addNamespace(\"";
  protected final String TEXT_296 = "\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_297 = "\"));";
  protected final String TEXT_298 = NL + "        \t";
  protected final String TEXT_299 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_300 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_301 = "\"))));";
  protected final String TEXT_302 = "true";
  protected final String TEXT_303 = " && (";
  protected final String TEXT_304 = "(";
  protected final String TEXT_305 = "==null && ";
  protected final String TEXT_306 = " == null) || (true &&";
  protected final String TEXT_307 = "!=null";
  protected final String TEXT_308 = NL + " && ";
  protected final String TEXT_309 = ".hasContent()" + NL + " && ((org.dom4j.Node)";
  protected final String TEXT_310 = ".content().get(0)).asXML().equals(";
  protected final String TEXT_311 = ")";
  protected final String TEXT_312 = NL + " && ";
  protected final String TEXT_313 = ".getText()!=null" + NL + " && ";
  protected final String TEXT_314 = ".getText().equals(";
  protected final String TEXT_315 = ")";
  protected final String TEXT_316 = ")";
  protected final String TEXT_317 = NL + ")";
  protected final String TEXT_318 = " && (";
  protected final String TEXT_319 = "(";
  protected final String TEXT_320 = "==null && ";
  protected final String TEXT_321 = ".attribute(\"";
  protected final String TEXT_322 = "\") == null) || (true && ";
  protected final String TEXT_323 = ".attribute(\"";
  protected final String TEXT_324 = "\")!=null" + NL + "&& ";
  protected final String TEXT_325 = ".attribute(\"";
  protected final String TEXT_326 = "\").getText()!=null" + NL + "&& ";
  protected final String TEXT_327 = ".attribute(\"";
  protected final String TEXT_328 = "\").getText().equals(";
  protected final String TEXT_329 = ")";
  protected final String TEXT_330 = ")";
  protected final String TEXT_331 = ")";
  protected final String TEXT_332 = NL + "\t\tnestXMLTool_";
  protected final String TEXT_333 = ".getElement(";
  protected final String TEXT_334 = ",new String[]{" + NL + "\t\t";
  protected final String TEXT_335 = NL + "\t\t\t\t,\"";
  protected final String TEXT_336 = "\"" + NL + "\t\t\t";
  protected final String TEXT_337 = "\t\t" + NL + "\t\t\t\t\"";
  protected final String TEXT_338 = "\"" + NL + "\t\t\t";
  protected final String TEXT_339 = NL + "\t\t})" + NL + "\t\t";
  protected final String TEXT_340 = NL + "    \t// buffer the start tabs to group buffer" + NL + "    \tgroupBuffer_";
  protected final String TEXT_341 = "[";
  protected final String TEXT_342 = "] = buf_";
  protected final String TEXT_343 = ".toString();" + NL + "        buf_";
  protected final String TEXT_344 = " = new StringBuffer();";
  protected final String TEXT_345 = NL + "\t\tstartTabs_";
  protected final String TEXT_346 = "[";
  protected final String TEXT_347 = "] = buf_";
  protected final String TEXT_348 = ".toString();" + NL + "        buf_";
  protected final String TEXT_349 = " = new StringBuffer();";
  protected final String TEXT_350 = NL + "\t\tout_";
  protected final String TEXT_351 = ".write(buf_";
  protected final String TEXT_352 = ".toString());" + NL + "        buf_";
  protected final String TEXT_353 = " = new StringBuffer();";
  protected final String TEXT_354 = NL + "\t\tif( false";
  protected final String TEXT_355 = " || valueMap_";
  protected final String TEXT_356 = ".get(\"";
  protected final String TEXT_357 = "\") != null";
  protected final String TEXT_358 = " || true " + NL + "                    \t";
  protected final String TEXT_359 = NL + "\t\t){";
  protected final String TEXT_360 = NL + "\t\t}";
  protected final String TEXT_361 = NL + "\t\tbuf_";
  protected final String TEXT_362 = ".append(\"";
  protected final String TEXT_363 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_364 = ".append(\"";
  protected final String TEXT_365 = "<";
  protected final String TEXT_366 = "\");";
  protected final String TEXT_367 = NL + "\t\tbuf_";
  protected final String TEXT_368 = ".append(\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\"\");" + NL + "\t\tbuf_";
  protected final String TEXT_369 = ".append(\" xsi:noNamespaceSchemaLocation= \\\"\"+ file_";
  protected final String TEXT_370 = ".substring(file_";
  protected final String TEXT_371 = ".lastIndexOf(\"/\")+1)+\".xsd\"+\"\\\"\");";
  protected final String TEXT_372 = NL + "\t\tif(";
  protected final String TEXT_373 = " == null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_374 = ".append(\" xsi:nil=\\\"true\\\"\");" + NL + "\t\t}";
  protected final String TEXT_375 = NL + "\t\tbuf_";
  protected final String TEXT_376 = ".append(\">\");";
  protected final String TEXT_377 = NL + "\t\tbuf_";
  protected final String TEXT_378 = ".append(\"";
  protected final String TEXT_379 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_380 = ".append(\"";
  protected final String TEXT_381 = "</";
  protected final String TEXT_382 = ">\");";
  protected final String TEXT_383 = NL + "\t\tbuf_";
  protected final String TEXT_384 = ".append(\"</";
  protected final String TEXT_385 = ">\");";
  protected final String TEXT_386 = NL + "\t\tif(";
  protected final String TEXT_387 = "!=null){" + NL + "\t\t\tif(routines.system.XMLHelper.getInstance().isValid(";
  protected final String TEXT_388 = ")){" + NL + "\t\t\t\tbuf_";
  protected final String TEXT_389 = ".append(";
  protected final String TEXT_390 = ");" + NL + "\t\t\t} else {" + NL + "\t\t\t\tbuf_";
  protected final String TEXT_391 = ".append(TalendString.checkCDATAForXML(";
  protected final String TEXT_392 = "));" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_393 = NL + "\t\tif(";
  protected final String TEXT_394 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_395 = ".append(TalendString.checkCDATAForXML(";
  protected final String TEXT_396 = "));" + NL + "\t\t}";
  protected final String TEXT_397 = NL + "\t\tif(routines.system.XMLHelper.getInstance().isValid(\"";
  protected final String TEXT_398 = "\")){" + NL + "\t\t\tbuf_";
  protected final String TEXT_399 = ".append(\"";
  protected final String TEXT_400 = "\");" + NL + "\t\t} else {" + NL + "\t\t\tbuf_";
  protected final String TEXT_401 = ".append(TalendString.checkCDATAForXML(\"";
  protected final String TEXT_402 = "\"));" + NL + "\t\t}";
  protected final String TEXT_403 = NL + "\t\t  if (";
  protected final String TEXT_404 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_405 = ".append(\" ";
  protected final String TEXT_406 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_407 = ")+\"\\\"\");" + NL + "\t\t  } ";
  protected final String TEXT_408 = " else{" + NL + "\t\t    buf_";
  protected final String TEXT_409 = ".append(\" ";
  protected final String TEXT_410 = "=\\\"\\\"\");" + NL + "\t\t  }";
  protected final String TEXT_411 = NL + "\t\t    buf_";
  protected final String TEXT_412 = ".append(\" ";
  protected final String TEXT_413 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_414 = "\")+\"\\\"\");";
  protected final String TEXT_415 = NL + "\t\t    buf_";
  protected final String TEXT_416 = ".append(\" ";
  protected final String TEXT_417 = "=\\\"\\\"\");" + NL + "\t\t  ";
  protected final String TEXT_418 = NL + "\t\tif(";
  protected final String TEXT_419 = "!=null){";
  protected final String TEXT_420 = NL + "        \tbuf_";
  protected final String TEXT_421 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_422 = ")+\"\\\"\");";
  protected final String TEXT_423 = NL + "\t\t\tbuf_";
  protected final String TEXT_424 = ".append(\" xmlns:";
  protected final String TEXT_425 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_426 = ")+\"\\\"\");";
  protected final String TEXT_427 = NL + "\t\t}";
  protected final String TEXT_428 = NL + "        \tbuf_";
  protected final String TEXT_429 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_430 = "\")+\"\\\"\");";
  protected final String TEXT_431 = NL + "\t\t\tbuf_";
  protected final String TEXT_432 = ".append(\" xmlns:";
  protected final String TEXT_433 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_434 = "\")+\"\\\"\");";
  protected final String TEXT_435 = NL;
  protected final String TEXT_436 = NL + "\t\t\tint nb_line_";
  protected final String TEXT_437 = " = 0;" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_438 = NL + "\t\t\t\tboolean needRoot_";
  protected final String TEXT_439 = "  = false;" + NL + "\t\t\t";
  protected final String TEXT_440 = NL + "\t\t\t\tboolean\tneedRoot_";
  protected final String TEXT_441 = " = true;" + NL + "\t\t\t";
  protected final String TEXT_442 = NL + "\t\t\tString fileName_";
  protected final String TEXT_443 = " = ";
  protected final String TEXT_444 = ";" + NL + "\t\t\tBoolean alreadyExistsFile_";
  protected final String TEXT_445 = " = new java.io.File(fileName_";
  protected final String TEXT_446 = ").exists();" + NL + "\t\t\tfileName_";
  protected final String TEXT_447 = " = new java.io.File(fileName_";
  protected final String TEXT_448 = ").getAbsolutePath().replace(\"\\\\\", \"/\");" + NL + "\t\t\t" + NL + "\t\t\tString fileNameWithoutSuffix_";
  protected final String TEXT_449 = " = \"\";" + NL + "\t\t\t" + NL + "\t\t\tif (fileName_";
  protected final String TEXT_450 = ".indexOf(\"/\") < 0) {" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"not a correct file name.\");\t\t\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t\tString tail_";
  protected final String TEXT_451 = " = fileName_";
  protected final String TEXT_452 = ".substring(fileName_";
  protected final String TEXT_453 = ".lastIndexOf(\"/\"));" + NL + "\t\t\t\tfileNameWithoutSuffix_";
  protected final String TEXT_454 = " = tail_";
  protected final String TEXT_455 = ".lastIndexOf(\".\") > 0 ? fileName_";
  protected final String TEXT_456 = ".substring(0, fileName_";
  protected final String TEXT_457 = ".lastIndexOf(\".\")) : fileName_";
  protected final String TEXT_458 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tfinal String file_";
  protected final String TEXT_459 = " = fileNameWithoutSuffix_";
  protected final String TEXT_460 = ";" + NL + "\t\t\t" + NL + "\t\t\tjava.io.File createFile";
  protected final String TEXT_461 = " = new java.io.File(fileName_";
  protected final String TEXT_462 = "); " + NL + "" + NL + "\t\t\t";
  protected final String TEXT_463 = NL + "\t\t\t\tif (!createFile";
  protected final String TEXT_464 = ".exists()) { " + NL + "\t\t\t\t\t(new java.io.File(fileName_";
  protected final String TEXT_465 = ".substring(0,fileName_";
  protected final String TEXT_466 = ".lastIndexOf(\"/\")))).mkdirs(); " + NL + "\t\t\t\t\tneedRoot_";
  protected final String TEXT_467 = "=true;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_468 = NL + "\t\t\t\tif (!createFile";
  protected final String TEXT_469 = ".exists() || (createFile";
  protected final String TEXT_470 = ".isFile() && createFile";
  protected final String TEXT_471 = ".length() < 1)) {" + NL + "\t\t\t\t\tneedRoot_";
  protected final String TEXT_472 = " = true;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_473 = NL + "\t\t\t\tint currentRowCount_";
  protected final String TEXT_474 = " = 0;" + NL + "\t\t\t\tint currentFileCount_";
  protected final String TEXT_475 = " = 0;" + NL + "\t\t\t\tString suffix_";
  protected final String TEXT_476 = " = \"\";" + NL + "" + NL + "\t\t\t\tif (fileName_";
  protected final String TEXT_477 = ".substring(fileName_";
  protected final String TEXT_478 = ".lastIndexOf(\"/\")).lastIndexOf(\".\") > 0) {" + NL + "\t\t\t\t\tsuffix_";
  protected final String TEXT_479 = " = fileName_";
  protected final String TEXT_480 = ".substring(fileName_";
  protected final String TEXT_481 = ".lastIndexOf(\".\"));" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfileName_";
  protected final String TEXT_482 = " = file_";
  protected final String TEXT_483 = "+\"0\" + suffix_";
  protected final String TEXT_484 = ";" + NL + "\t\t\t";
  protected final String TEXT_485 = NL + "\t\t\tint nb_line_";
  protected final String TEXT_486 = " = 0;" + NL + "\t\t\tboolean\tneedRoot_";
  protected final String TEXT_487 = " = true;" + NL + "\t\t";
  protected final String TEXT_488 = NL + "\t\tjava.util.List<java.util.List<String>> groupbyList_";
  protected final String TEXT_489 = " = new java.util.ArrayList<java.util.List<String>>();" + NL + "\t\tfinal java.util.Map<String,String> valueMap_";
  protected final String TEXT_490 = " = new java.util.HashMap<String,String>();" + NL + "\t\t";
  protected final String TEXT_491 = NL + "\t\t\torg.dom4j.io.OutputFormat compactFormat_";
  protected final String TEXT_492 = " = org.dom4j.io.OutputFormat.createCompactFormat();" + NL + "\t\t\tcompactFormat_";
  protected final String TEXT_493 = ".setSuppressDeclaration(true); " + NL + "\t\t";
  protected final String TEXT_494 = NL + NL + "\t\t";
  protected final String TEXT_495 = NL + NL + "\t\t\tclass NestXMLTool_";
  protected final String TEXT_496 = " {" + NL + "\t\t\t\tpublic void parseAndAdd(org.dom4j.Element nestRoot, String value) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\torg.dom4j.Document doc4Str = org.dom4j.DocumentHelper.parseText(\"<root>\"+ value + \"</root>\");" + NL + "\t\t\t\t\t\tnestRoot.setContent(doc4Str.getRootElement().content());" + NL + "\t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\t\tnestRoot.setText(value);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void setText(org.dom4j.Element element, String value) {" + NL + "\t\t\t\t\tif (value.startsWith(\"<![CDATA[\") && value.endsWith(\"]]>\")) {" + NL + "\t\t\t\t\t\tString text = value.substring(9, value.length()-3);" + NL + "\t\t\t\t\t\telement.addCDATA(text);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\telement.setText(value);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void appendContent(org.dom4j.Element element, org.dom4j.Document doc) {" + NL + "\t\t\t\t\telement.appendContent(doc);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void replaceDefaultNameSpace(org.dom4j.Element nestRoot){" + NL + "\t\t\t\t\tif (nestRoot != null) {" + NL + "\t\t\t\t\t\tboolean isDefaultNameSpaceAtRoot = \"\".equals(nestRoot.getQName().getNamespace().getPrefix());" + NL + "\t\t\t\t\t\tfor (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) nestRoot.elements()) {" + NL + "\t\t\t\t\t\t\tif ((\"\").equals(tmp.getQName().getNamespace().getURI()) && (\"\").equals(tmp.getQName().getNamespace().getPrefix()) && isDefaultNameSpaceAtRoot) {" + NL + "\t\t\t\t\t\t\t\ttmp.setQName(org.dom4j.DocumentHelper.createQName(tmp.getName(), nestRoot.getQName().getNamespace()));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\treplaceDefaultNameSpace(tmp);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void removeEmptyElement(org.dom4j.Element root) {" + NL + "\t\t\t\t\tif (root != null) {" + NL + "\t\t\t\t\t\tfor (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) root.elements()) {" + NL + "\t\t\t\t\t\t\tremoveEmptyElement(tmp);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif (root.content().size() == 0 " + NL + "\t\t\t\t\t\t\t&& root.attributes().size() == 0 " + NL + "\t\t\t\t\t\t\t\t&& root.declaredNamespaces().size() == 0) {" + NL + "\t\t\t\t\t\t\tif (root.getParent() != null) {" + NL + "\t\t\t\t\t\t\t\troot.getParent().remove(root);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\t/**" + NL + "\t\t\t\t * remove the whiteSpace Node between the elements when appending the source file under dom4j" + NL + "\t\t\t\t * @param root" + NL + "\t\t\t\t */" + NL + "\t\t\t\tpublic void removeWhiteSpaceTextNode(org.dom4j.Element root) {" + NL + "\t\t\t\t\tif(root != null) {" + NL + "\t\t\t\t\t\tList<org.dom4j.Node> textNodes = new java.util.ArrayList<org.dom4j.Node>();" + NL + "\t\t\t\t\t\tfor (int i=0; i< root.nodeCount(); i++) {" + NL + "\t\t\t\t\t\t\tif (root.node(i).getNodeType()==org.dom4j.Node.ELEMENT_NODE) {" + NL + "\t\t\t\t\t\t\t\tremoveWhiteSpaceTextNode((org.dom4j.Element)root.node(i));" + NL + "\t\t\t\t\t\t\t} else if(root.node(i).getNodeType()==org.dom4j.Node.TEXT_NODE) {" + NL + "\t\t\t\t\t\t\t\ttextNodes.add(root.node(i));" + NL + "\t\t\t\t\t\t\t} " + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(root.nodeCount() > 1) { // when root.nodeCount==1, that means the text node is the content of the element" + NL + "\t\t\t\t\t\t\tfor (org.dom4j.Node textNode: textNodes) {" + NL + "\t\t\t\t\t\t\t\tif(textNode.getText()==null || \"\".equals(textNode.getText().trim())) {" + NL + "\t\t\t\t\t\t\t\t\troot.remove(textNode);" + NL + "\t\t\t\t\t\t\t\t} " + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t/**" + NL + "\t\t\t\t * Get element by QNames which get from the path" + NL + "\t\t\t\t */" + NL + "\t\t\t\tpublic org.dom4j.Element getElement(org.dom4j.Element parent,String[] elemNames){" + NL + "\t\t\t\t\tif(parent==null){" + NL + "\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\torg.dom4j.Element tempElem = parent;" + NL + "\t\t\t\t\tfor(int i=0;elemNames != null && i<elemNames.length; i++){" + NL + "\t\t\t\t\t\ttempElem=tempElem.element(parent.getQName(elemNames[i]));" + NL + "\t\t\t\t\t\tif(tempElem==null){" + NL + "\t\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn tempElem;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tfinal NestXMLTool_";
  protected final String TEXT_497 = " nestXMLTool_";
  protected final String TEXT_498 = " = new NestXMLTool_";
  protected final String TEXT_499 = "();" + NL + "\t\t\t// sort group root element for judgement of group" + NL + "\t\t\tjava.util.List<org.dom4j.Element> groupElementList_";
  protected final String TEXT_500 = " = new java.util.ArrayList<org.dom4j.Element>();" + NL + "\t\t\torg.dom4j.Element root4Group_";
  protected final String TEXT_501 = " = null;" + NL + "\t\t\torg.dom4j.Document doc_";
  protected final String TEXT_502 = "=null;" + NL + "\t\t\t" + NL + "\t\t\tfinal java.util.Map<String,org.dom4j.Branch> nameToElement_";
  protected final String TEXT_503 = " = new java.util.HashMap<String,org.dom4j.Branch>();" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_504 = NL + "\t\t\t\tif (needRoot_";
  protected final String TEXT_505 = " == false) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\torg.dom4j.io.SAXReader saxReader_";
  protected final String TEXT_506 = "= new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\t\tdoc_";
  protected final String TEXT_507 = " = saxReader_";
  protected final String TEXT_508 = ".read(createFile";
  protected final String TEXT_509 = ");" + NL + "\t\t\t\t\t\tnestXMLTool_";
  protected final String TEXT_510 = ".removeWhiteSpaceTextNode(doc_";
  protected final String TEXT_511 = ".getRootElement());" + NL + "\t\t\t\t\t} catch (java.lang.Exception ex) {" + NL + "\t\t\t\t\t\tex.printStackTrace();" + NL + "\t\t\t\t\t\tthrow new java.lang.Exception(\"can not find the file:\" + fileName_";
  protected final String TEXT_512 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdoc_";
  protected final String TEXT_513 = "=org.dom4j.DocumentHelper.createDocument();" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_514 = NL + "\t\t\t\t\torg.dom4j.Element firstGroupPathElement_";
  protected final String TEXT_515 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_516 = NL + "\t\t\t";
  protected final String TEXT_517 = NL + "\t\t\t\tdoc_";
  protected final String TEXT_518 = "=org.dom4j.DocumentHelper.createDocument();" + NL + "\t\t\t";
  protected final String TEXT_519 = NL + "\t\t\t\t\t\tdoc_";
  protected final String TEXT_520 = ".addDocType(";
  protected final String TEXT_521 = ", null, ";
  protected final String TEXT_522 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_523 = NL + "\t\t\t\t\t\tjava.util.Map<String, String> inMap_";
  protected final String TEXT_524 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t\t\tinMap_";
  protected final String TEXT_525 = ".put(\"type\",";
  protected final String TEXT_526 = ");" + NL + "\t\t\t\t\t\tinMap_";
  protected final String TEXT_527 = ".put(\"href\",";
  protected final String TEXT_528 = ");" + NL + "\t\t\t\t\t\tdoc_";
  protected final String TEXT_529 = ".addProcessingInstruction(\"xml-stylesheet\", inMap_";
  protected final String TEXT_530 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_531 = NL + "\t\t\t\torg.dom4j.io.OutputFormat format_";
  protected final String TEXT_532 = " = org.dom4j.io.OutputFormat.createCompactFormat();" + NL + "\t\t\t";
  protected final String TEXT_533 = NL + "\t\t\t\torg.dom4j.io.OutputFormat format_";
  protected final String TEXT_534 = " = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "\t\t\t";
  protected final String TEXT_535 = NL + "\t\t\tformat_";
  protected final String TEXT_536 = ".setTrimText(";
  protected final String TEXT_537 = ");" + NL + "\t\t\tformat_";
  protected final String TEXT_538 = ".setEncoding(";
  protected final String TEXT_539 = ");" + NL + "\t\t\t";
  protected final String TEXT_540 = NL + "\t\t\tfinal int[] orders_";
  protected final String TEXT_541 = " = new int[";
  protected final String TEXT_542 = "];" + NL + "\t\t";
  protected final String TEXT_543 = NL + "\t\t\tjava.util.List<String> endTabStrs_";
  protected final String TEXT_544 = " = new java.util.ArrayList<String>();" + NL + "\t\t\tjava.util.List<String> startTabStrs_";
  protected final String TEXT_545 = " = new java.util.ArrayList<String>();" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_546 = NL + "\t\t\t\t\tendTabStrs_";
  protected final String TEXT_547 = ".add(\"";
  protected final String TEXT_548 = "</";
  protected final String TEXT_549 = ">\");" + NL + "\t\t\t\t\tstartTabStrs_";
  protected final String TEXT_550 = ".add(\"";
  protected final String TEXT_551 = "<";
  protected final String TEXT_552 = ">\");" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_553 = NL + "\t\t\tint preUnNullMaxIndex_";
  protected final String TEXT_554 = " = -1;" + NL + "\t\t\tint preNewTabIndex_";
  protected final String TEXT_555 = " = -1;" + NL + "\t\t\tString[] startTabs_";
  protected final String TEXT_556 = " = new String[endTabStrs_";
  protected final String TEXT_557 = ".size()];" + NL + "\t\t\tString[] endTabs_";
  protected final String TEXT_558 = " = new String[endTabStrs_";
  protected final String TEXT_559 = ".size()];" + NL + "\t\t\t";
  protected final String TEXT_560 = NL + "\t\t\t//String[] mainEndTabs_";
  protected final String TEXT_561 = " = new String[";
  protected final String TEXT_562 = "];" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_563 = NL + "\t\t\t\tjava.io.BufferedWriter out_";
  protected final String TEXT_564 = " = new java.io.BufferedWriter(" + NL + "\t\t\t\tnew java.io.OutputStreamWriter(new java.io.FileOutputStream(fileName_";
  protected final String TEXT_565 = "), ";
  protected final String TEXT_566 = "));" + NL + "\t\t\t";
  protected final String TEXT_567 = NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_568 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_569 = ", ";
  protected final String TEXT_570 = ");" + NL + "\t\t\t\tjava.io.BufferedWriter out_";
  protected final String TEXT_571 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_572 = ");" + NL + "\t\t\t";
  protected final String TEXT_573 = NL + "\t\t\tout_";
  protected final String TEXT_574 = ".write(\"<?xml version=\\\"1.0\\\" encoding=\\\"\"+";
  protected final String TEXT_575 = "+\"\\\"?>\");" + NL + "\t\t\tout_";
  protected final String TEXT_576 = ".newLine();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_577 = NL + "\t\t\t\t\tout_";
  protected final String TEXT_578 = ".write(\"<!DOCTYPE \"+";
  protected final String TEXT_579 = "+\" SYSTEM \\\"\" + ";
  protected final String TEXT_580 = " + \"\\\">\");" + NL + "\t\t\t\t\tout_";
  protected final String TEXT_581 = ".newLine();" + NL + "\t\t\t\t";
  protected final String TEXT_582 = NL + "\t\t\t\t\tout_";
  protected final String TEXT_583 = ".write(\"<?xml-stylesheet type=\\\"\"+";
  protected final String TEXT_584 = "+\"\\\" href=\\\"\"+";
  protected final String TEXT_585 = "+\"\\\">\");" + NL + "\t\t\t\t\tout_";
  protected final String TEXT_586 = ".newLine();" + NL + "\t\t\t\t";
  protected final String TEXT_587 = NL + "\t\t\tclass AdvancedXMLUtil_";
  protected final String TEXT_588 = "{";
  protected final String TEXT_589 = NL + "\t\t\t\tpublic void putValue_";
  protected final String TEXT_590 = "(";
  protected final String TEXT_591 = "Struct ";
  protected final String TEXT_592 = ",java.util.Map<String,String> valueMap_";
  protected final String TEXT_593 = ",org.dom4j.io.OutputFormat compactFormat_";
  protected final String TEXT_594 = "){";
  protected final String TEXT_595 = NL + "\t\t\t\t\tvalueMap_";
  protected final String TEXT_596 = ".put(\"";
  protected final String TEXT_597 = "\", ";
  protected final String TEXT_598 = ");";
  protected final String TEXT_599 = NL + "\t\t\t\t}";
  protected final String TEXT_600 = NL + "\t\t\t\t}";
  protected final String TEXT_601 = NL + "\t\tpublic boolean getValue_";
  protected final String TEXT_602 = "_";
  protected final String TEXT_603 = "(java.util.List<java.util.List<String>> groupbyList_";
  protected final String TEXT_604 = ",java.util.Map<String,String> valueMap_";
  protected final String TEXT_605 = "){" + NL + "\t\t\treturn false";
  protected final String TEXT_606 = NL + "\t\t\t|| ( groupbyList_";
  protected final String TEXT_607 = ".get(";
  protected final String TEXT_608 = ").get(";
  protected final String TEXT_609 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_610 = ".get(";
  protected final String TEXT_611 = ").get(";
  protected final String TEXT_612 = ").equals(";
  protected final String TEXT_613 = ") " + NL + "\t\t: ";
  protected final String TEXT_614 = "!=null )";
  protected final String TEXT_615 = NL + "\t\t;" + NL + "\t\t}";
  protected final String TEXT_616 = NL + "\t   ;" + NL + "\t   }";
  protected final String TEXT_617 = NL + "\t\t\t\tpublic void setValue_";
  protected final String TEXT_618 = "_";
  protected final String TEXT_619 = "(java.util.List<java.util.List<String>> groupbyList_";
  protected final String TEXT_620 = ",java.util.Map<String,String> valueMap_";
  protected final String TEXT_621 = "){";
  protected final String TEXT_622 = NL + "\t\t\t\t\tgroupbyList_";
  protected final String TEXT_623 = ".get(";
  protected final String TEXT_624 = ").add(";
  protected final String TEXT_625 = ");";
  protected final String TEXT_626 = NL + "\t\t\t\t}";
  protected final String TEXT_627 = NL + "\t   \t\t\t}";
  protected final String TEXT_628 = NL + "\t\t\t\tpublic boolean generateCodeDom4j_FindInsertNode";
  protected final String TEXT_629 = "(org.dom4j.Element tempElem,java.util.Map<String,String> valueMap_";
  protected final String TEXT_630 = "){" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_631 = ";" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic org.dom4j.Element generateCodeDom4j_UnFindInsertNode";
  protected final String TEXT_632 = "(final NestXMLTool_";
  protected final String TEXT_633 = " nestXMLTool_";
  protected final String TEXT_634 = ",final java.util.Map<String,String> valueMap_";
  protected final String TEXT_635 = ",org.dom4j.Element subTreeRootParent_";
  protected final String TEXT_636 = ",final int[] orders_";
  protected final String TEXT_637 = ",final boolean bl_";
  protected final String TEXT_638 = ") throws java.lang.Exception {";
  protected final String TEXT_639 = NL + "\t\t\t\t\treturn ";
  protected final String TEXT_640 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_641 = NL + "\t\t\t\tpublic org.dom4j.Element generateCodeDom4j_group";
  protected final String TEXT_642 = "(final NestXMLTool_";
  protected final String TEXT_643 = " nestXMLTool_";
  protected final String TEXT_644 = ",final java.util.Map<String,String> valueMap_";
  protected final String TEXT_645 = ",org.dom4j.Element subTreeRootParent_";
  protected final String TEXT_646 = ",final int[] orders_";
  protected final String TEXT_647 = ") throws java.lang.Exception {";
  protected final String TEXT_648 = NL + "\t\t\t\t\treturn ";
  protected final String TEXT_649 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_650 = NL + "\t\t\t\tpublic org.dom4j.Element generateCodeDom4j_Loop(final NestXMLTool_";
  protected final String TEXT_651 = " nestXMLTool_";
  protected final String TEXT_652 = ",final java.util.Map<String,String> valueMap_";
  protected final String TEXT_653 = ",org.dom4j.Element subTreeRootParent_";
  protected final String TEXT_654 = ",final int[] orders_";
  protected final String TEXT_655 = ",final boolean bl_";
  protected final String TEXT_656 = ") throws java.lang.Exception {";
  protected final String TEXT_657 = NL + "\t\t\t\t\treturn ";
  protected final String TEXT_658 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_659 = NL + "\t\t\t\t\t\t\tpublic StringBuffer generateCodeNull_rootEmptySpace";
  protected final String TEXT_660 = "(StringBuffer buf_";
  protected final String TEXT_661 = ",java.io.BufferedWriter out_";
  protected final String TEXT_662 = ",String[] startTabs_";
  protected final String TEXT_663 = ",String[] endTabs_";
  protected final String TEXT_664 = ",java.util.Map<String, String> valueMap_";
  protected final String TEXT_665 = ")throws IOException{\t\t";
  protected final String TEXT_666 = NL + "\t\t\t\t\t\t\t\treturn buf_";
  protected final String TEXT_667 = ";" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_668 = NL + "\t\t\t\t\t\t\tpublic boolean generateCodeNull_conditMain";
  protected final String TEXT_669 = "_";
  protected final String TEXT_670 = "(java.util.Map<String,String> valueMap_";
  protected final String TEXT_671 = "){" + NL + "\t\t\t\t\t\t\t \treturn false";
  protected final String TEXT_672 = NL + "\t\t\t\t\t\t\t\t\t\t|| valueMap_";
  protected final String TEXT_673 = ".get(\"";
  protected final String TEXT_674 = "\") != null";
  protected final String TEXT_675 = NL + "\t\t\t\t\t\t\t;}";
  protected final String TEXT_676 = NL + "\t\t\t\t\t\t\t;}";
  protected final String TEXT_677 = NL + "\t\t\t\t\t\t\tpublic StringBuffer generateCodeNull_emptySpace";
  protected final String TEXT_678 = "(StringBuffer buf_";
  protected final String TEXT_679 = ",java.util.Map<String, String> valueMap_";
  protected final String TEXT_680 = ",String[] groupBuffer_";
  protected final String TEXT_681 = "){";
  protected final String TEXT_682 = NL + "\t\t\t\t\t\t\t\treturn buf_";
  protected final String TEXT_683 = ";" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_684 = NL + "\t\t\t\t\t\t\tpublic boolean generateCodeNull_conditGroup";
  protected final String TEXT_685 = "_";
  protected final String TEXT_686 = "(java.util.Map<String,String> valueMap_";
  protected final String TEXT_687 = "){" + NL + "\t\t\t\t\t\t\t \treturn false";
  protected final String TEXT_688 = NL + "\t\t\t\t\t\t\t\t\t\t|| valueMap_";
  protected final String TEXT_689 = ".get(\"";
  protected final String TEXT_690 = "\") != null";
  protected final String TEXT_691 = NL + "\t\t\t\t\t\t\t;}";
  protected final String TEXT_692 = NL + "\t\t\t\t\t\t\t;}";
  protected final String TEXT_693 = NL + "\t\t\t\t\t\t\tpublic boolean generateCodeNull_conditLoop_";
  protected final String TEXT_694 = "(java.util.Map<String,String> valueMap_";
  protected final String TEXT_695 = "){" + NL + "\t\t\t\t\t\t\t \treturn false";
  protected final String TEXT_696 = NL + "\t\t\t\t\t\t\t\t\t\t|| valueMap_";
  protected final String TEXT_697 = ".get(\"";
  protected final String TEXT_698 = "\") != null";
  protected final String TEXT_699 = NL + "\t\t\t\t\t\t\t;}";
  protected final String TEXT_700 = NL + "\t\t\t\t\t\t\t;}";
  protected final String TEXT_701 = NL + "\t\t\t\t\t\t\tpublic void generateCodeNull_loopEmptySpace(StringBuffer buf_";
  protected final String TEXT_702 = ",java.io.BufferedWriter out_";
  protected final String TEXT_703 = ",String[] endTabs_";
  protected final String TEXT_704 = ",java.util.Map<String, String> valueMap_";
  protected final String TEXT_705 = "){\t";
  protected final String TEXT_706 = NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_707 = NL + NL + "\t\t\t}" + NL + "\t\t\tAdvancedXMLUtil_";
  protected final String TEXT_708 = " advancedXMLUtil_";
  protected final String TEXT_709 = "=new AdvancedXMLUtil_";
  protected final String TEXT_710 = "();";
  protected final String TEXT_711 = NL;

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
        
        public List<XMLNode> getNextSiblings(){
            List<XMLNode> result = new ArrayList<XMLNode>();
            if(parent!=null && parent.elements!=null){
                for(XMLNode tmpNode: parent.elements){
                    if(order < tmpNode.order){
                        result.add(tmpNode);
                    }
                }
            }
            return result;
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
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String cid_original = cid;
cid = cid_original.replace("tAdvancedFileOutputXML","tAFOX");
List< ? extends IConnection> conns = node.getIncomingConnections();


    stringBuffer.append(TEXT_1);
    
//XMLTool
class XMLTool{
	public boolean advancedSeparator = false;
	public String thousandsSeparator = null;
 	public String decimalSeparator =null;
	public String connName = null;
	public String cid = null;
	public boolean isAppend = false;
	
	public void getValue(XMLNode node){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(node.relatedColumn.getLabel());
    stringBuffer.append(TEXT_4);
    
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

    stringBuffer.append(TEXT_5);
    
		if(column.isNullable()){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_8);
    
		}
		
        if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        	if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( thousandsSeparator);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_12);
    
    		} else {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_15);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_17);
    
	   		}
        } else if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_20);
    
        }else if(javaType == JavaTypesManager.DATE){
            if( column.getPattern() != null && column.getPattern().trim().length() != 0 ){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_24);
    
            }else{

    stringBuffer.append(TEXT_25);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    
           }
        }else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_28);
    
        }else if(isAppend && "id_Document".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
        }else{

    stringBuffer.append(TEXT_33);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    
		}
		if(column.isNullable()){
			
    stringBuffer.append(TEXT_36);
     
			if(isNotSetDefault == false){
				
    stringBuffer.append(column.getDefault());
    
			}else{
				
    stringBuffer.append(TEXT_37);
    
			}
		}

    stringBuffer.append(TEXT_38);
    
	}
}

abstract class TouchXMLNode {
	protected String cid = null;
	
	abstract void getXMLNode(String currEleName);
	
	abstract void getXMLElement(String currEleName);
	
	abstract void putCurrentElementByNameWithoutNamespacePrefix(String currEleName,XMLNode node,int index);
	
	abstract void putCurrentElementByName(String currEleName,XMLNode node);
	
	abstract void putCurrentElementByNull(String currEleName);
	
	abstract void putCurrentElementByParentWithoutNamespacePrefix(String currEleName,String parentName,XMLNode node,int index);
	
	abstract void putCurrentElementByParent(String currEleName,String parentName,XMLNode node);
	
	abstract void putSubTreeRootParentByCurrentElement(String currEleName);
	
	abstract void putSubTreeRootParentByNull();
	
	abstract void putSubTreeRootParentByTempElem();
	
	abstract void putDocument();
	
	abstract void putSubTreeRootParentByRootGroup();
	
	abstract void putSubTreeRootParentByFirstGroup();
	
	abstract void putSubTreeRootParentByGroup(int i);
	
	abstract void putSubTreeRootParentByGroupList(int i);
	
	abstract void putSubTreeRootParentByLoop();
}

//get mean reference
//put mean declare,assign action
class ReferenceTouchXMLNode extends TouchXMLNode {

	void getXMLNode(String currEleName) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    
	}
	
	void getXMLElement(String currEleName) {
		getXMLNode(currEleName);
	}

	void putCurrentElementByNameWithoutNamespacePrefix(String currEleName,XMLNode node,int index) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_44);
    
	}
	
	void putCurrentElementByName(String currEleName,XMLNode node) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_48);
    
	}

	void putCurrentElementByNull(String currEleName) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
	}
	
	void putCurrentElementByParentWithoutNamespacePrefix(String currEleName,String parentName,XMLNode node,int index) {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_57);
    
	}
	
	void putCurrentElementByParent(String currEleName,String parentName,XMLNode node) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_63);
    
	}
	
	void putSubTreeRootParentByCurrentElement(String currEleName) {

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
	}
	
	void putSubTreeRootParentByNull() {

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
	}
	
	void putSubTreeRootParentByTempElem() {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    
	}
	
	void putDocument() {
		//do nothing
	}
	
	void putSubTreeRootParentByRootGroup() {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
	}
	
	void putSubTreeRootParentByFirstGroup() {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
	}
	
	void putSubTreeRootParentByGroup(int i) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
	}
	
	void putSubTreeRootParentByGroupList(int i) {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_85);
    
	}
	
	void putSubTreeRootParentByLoop() {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
	}
}

class MappingTouchXMLNode extends TouchXMLNode {

	void getXMLNode(String currEleName) {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_91);
    
	}
	
	void getXMLElement(String currEleName) {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_94);
    
	}
	
	void putCurrentElementByNameWithoutNamespacePrefix(String currEleName,XMLNode node,int index) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_98);
    
	}
	
	void putCurrentElementByName(String currEleName,XMLNode node) {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_102);
    
	}
	
	void putCurrentElementByNull(String currEleName) {
		//do nothing
	}
	
	void putCurrentElementByParentWithoutNamespacePrefix(String currEleName,String parentName,XMLNode node,int index) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_105);
    getXMLNode(parentName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_107);
    
	}
	
	void putCurrentElementByParent(String currEleName,String parentName,XMLNode node) {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_110);
    getXMLNode(parentName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_112);
    
	}
	
	void putSubTreeRootParentByCurrentElement(String currEleName) {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    getXMLNode(currEleName);
    stringBuffer.append(TEXT_115);
    
	}
	
	void putSubTreeRootParentByNull() {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
	}
	
	void putSubTreeRootParentByTempElem() {

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
	}
	
	void putDocument() {

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    
	}
	
	void putSubTreeRootParentByRootGroup() {

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
	}
	
	void putSubTreeRootParentByFirstGroup() {

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
	}
	
	void putSubTreeRootParentByGroup(int i) {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
	}
	
	void putSubTreeRootParentByGroupList(int i) {

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_136);
    
	}
	
	void putSubTreeRootParentByLoop() {

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
	}
}

    stringBuffer.append(TEXT_140);
    
//65535 limit
class BigMethodHelper {
	protected String cid = null;
	protected boolean isOptimizeCodeForXMLNode = false;
	protected int xmlNodeOptNum = 100;
	protected int index = -1;
	
	protected String generateId = "";
	
	public BigMethodHelper() {
		initIsOptimizeCodeForXMLNode();
	}
	
	public void setGenerateId(String generateId) {
		this.generateId = generateId; 
	}
	
	public void resetIndex() {
		index = -1;
	}
	
	public TouchXMLNode getTouchXMLNode() {
		if(isOptimizeCodeForXMLNode) {
			return new MappingTouchXMLNode();
		}
		return new ReferenceTouchXMLNode();
	}
	
	public void initIsOptimizeCodeForXMLNode(){
		String xmlNodeOptNumStr = ElementParameterParser.getValue(node, "__XMLNODE_OPT_NUM__");
		if(xmlNodeOptNumStr!=null && !"".equals(xmlNodeOptNumStr) && !"\"\"".equals(xmlNodeOptNumStr)){
			xmlNodeOptNum  = Integer.parseInt(xmlNodeOptNumStr);
		}
		
        List<Map<String, String>> rootTable =
        	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
        List<Map<String, String>> groupTable =
        	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
        List<Map<String, String>> loopTable =
        	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
        
        int elementNumber = getElementNumber(rootTable) + getElementNumber(groupTable) + getElementNumber(loopTable);
        if(elementNumber > xmlNodeOptNum) {
			isOptimizeCodeForXMLNode = true;
        }
	}
	
	private int getElementNumber(List<Map<String, String>> nodeTable) {
		if(nodeTable == null) {
			return 0;
		}
		
		int result = 0;
		for(Map<String,String> node : nodeTable) {
			if(node == null) {
				continue;
			}
			
			if("attri".equals(node.get("ATTRIBUTE")) || "ns".equals(node.get("ATTRIBUTE"))) {
				continue;
			}
			
			result++;
		}
		
		return result;
	}
	
	public void generateClassNameWithRBlock() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    
		}
	}
	
	public void generateLeftBlock() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_144);
    
		}
	}
	
	public void generateMethod() {
		if(isOptimizeCodeForXMLNode) {
			if(index == -1) {

    stringBuffer.append(TEXT_145);
    stringBuffer.append((index+1)/xmlNodeOptNum);
    stringBuffer.append(TEXT_146);
    
			} else if((index+1)%xmlNodeOptNum==0){

    stringBuffer.append(TEXT_147);
    stringBuffer.append((index+1)/xmlNodeOptNum);
    stringBuffer.append(TEXT_148);
    
			}
			index++;
		}
	}
	
	public void generateMethodCall() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_149);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    
			int count = index + 1;
			for(int i = 0; i < count; i++) {
				if(i%xmlNodeOptNum==0){

    stringBuffer.append(TEXT_156);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(i/xmlNodeOptNum);
    stringBuffer.append(TEXT_159);
    
				}
			}
		}
	}
	
}

    stringBuffer.append(TEXT_160);
    
// ------------------- *** Dom4j generation mode start *** ------------------- //
class GenerateToolByDom4j{
	String cid = null;
	boolean allowEmpty = false;
	boolean bAddEmptyAttr = false, bAddUnmappedAttr = false;
	boolean isSaveDocAsNode = false;
	boolean outputAsXSD = false;
	XMLTool tool = null;
	boolean isAppend = false;
	
	//opt for big xml config tree
	BigMethodHelper bigMethodHelper = null;
	TouchXMLNode touchXMLNode = null;
	
	public GenerateToolByDom4j() {
		bigMethodHelper = new BigMethodHelper();
		touchXMLNode = bigMethodHelper.getTouchXMLNode();
	}
	
	public void generateCode(XMLNode node, String currEleName, String parentName){
		if(!("ELEMENT").equals(node.type)){
			return;
		}
		
		bigMethodHelper.setGenerateId(currEleName);
		//start the class
		bigMethodHelper.generateClassNameWithRBlock();
		
		bigMethodHelper.resetIndex();
		
		generateMainCode(node,currEleName,parentName);
		
		//end the last method
		bigMethodHelper.generateLeftBlock();
		
		//end the class
		bigMethodHelper.generateLeftBlock();
		
		bigMethodHelper.generateMethodCall();
	}
	
	public void generateMainCode(XMLNode node, String currEleName, String parentName){
		if(("ELEMENT").equals(node.type)){
			bigMethodHelper.generateMethod();
			
			createElement(currEleName,node,parentName);
			setText(currEleName,node);
			for(XMLNode ns:node.namespaces){
				addNameSpace(currEleName,ns);
			}
			for(XMLNode attri:node.attributes){
				addAttribute(currEleName,attri);
			}
			if(node.name.indexOf(":")>0){

    stringBuffer.append(TEXT_161);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_163);
    
			}
			int index = 0;
			for(XMLNode child:node.elements){
				if(0==(child.special & 1)){
					generateMainCode(child,currEleName+"_"+index++,currEleName);
				}
			}
			if(node.relatedColumn != null && (node.special & 2)==0 && (node.special & 1)==0){
				if(isAppend && !outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_164);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_165);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_166);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_167);
    touchXMLNode.getXMLNode(parentName);
    stringBuffer.append(TEXT_168);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_169);
    
				}
			}
		}
	}
	private void createElement(String currEleName, XMLNode node, String parentName){
		int index = node.name.indexOf(":");
		if(5==(node.special & 5)){
			int currPos = node.getCurrGroupPos();
			touchXMLNode.putCurrentElementByNull(currEleName);
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_170);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_172);
    touchXMLNode.putCurrentElementByNameWithoutNamespacePrefix(currEleName,node,index);
    stringBuffer.append(TEXT_173);
    touchXMLNode.putCurrentElementByName(currEleName,node);
    stringBuffer.append(TEXT_174);
    
			}else{

    stringBuffer.append(TEXT_175);
    touchXMLNode.putCurrentElementByName(currEleName,node);
    
			}
			if(isAppend){

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_184);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    
				List<XMLNode> nextSiblings = node.getNextSiblings();

    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
				if(nextSiblings.size() > 0) {

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
				}
				
				for(XMLNode sibling : nextSiblings) {

    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(sibling.name);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    
				}

    stringBuffer.append(TEXT_209);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_212);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_213);
    
			}else{

    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(node.getNodeInsertIndex() );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_223);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_226);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_227);
    
			}
		}else{
			touchXMLNode.putCurrentElementByNull(currEleName);
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_228);
    touchXMLNode.getXMLElement(parentName);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_230);
    touchXMLNode.putCurrentElementByParentWithoutNamespacePrefix(currEleName,parentName,node,index);
    stringBuffer.append(TEXT_231);
    touchXMLNode.putCurrentElementByParent(currEleName,parentName,node);
    stringBuffer.append(TEXT_232);
    
			}else{

    stringBuffer.append(TEXT_233);
    touchXMLNode.putCurrentElementByParent(currEleName,parentName,node);
    
			}
		}
		if(0!=(node.special & 2)){

    stringBuffer.append(TEXT_234);
    touchXMLNode.putSubTreeRootParentByCurrentElement(currEleName);
    
		}
	}
	private void setText(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_235);
    tool.getValue(node); 
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_238);
    tool.getValue(node);
    stringBuffer.append(TEXT_239);
    
				if(outputAsXSD){

    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_242);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_243);
    
				}
			}else{
				if("id_Document".equals(node.relatedColumn.getTalendType())) {

    stringBuffer.append(TEXT_244);
    tool.getValue(node); 
    stringBuffer.append(TEXT_245);
    
						if (isSaveDocAsNode) {

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    tool.getValue(node);
    stringBuffer.append(TEXT_250);
    
						} else {

    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    tool.getValue(node);
    stringBuffer.append(TEXT_255);
    
						}

    stringBuffer.append(TEXT_256);
    
				} else {

    stringBuffer.append(TEXT_257);
    tool.getValue(node); 
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_260);
    tool.getValue(node);
    stringBuffer.append(TEXT_261);
    
				}
				if(outputAsXSD){

    stringBuffer.append(TEXT_262);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_263);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_264);
    
				}
			}
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_268);
    
		}
	}
	private void addAttribute(String currEleName, XMLNode node){
		if (node.relatedColumn != null){
        
    stringBuffer.append(TEXT_269);
    tool.getValue(node);
    stringBuffer.append(TEXT_270);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_272);
    tool.getValue(node);
    stringBuffer.append(TEXT_273);
     if (bAddEmptyAttr) { 
    stringBuffer.append(TEXT_274);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_276);
    }
		} else { 
		  if (node.defaultValue != null && !("").equals(node.defaultValue) ){
          
    stringBuffer.append(TEXT_277);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_280);
    
		  } else if (bAddUnmappedAttr){
		  
    stringBuffer.append(TEXT_281);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_283);
    
		  }
		}
	}
	private void addNameSpace(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_284);
    tool.getValue(node);
    stringBuffer.append(TEXT_285);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_287);
    tool.getValue(node);
    stringBuffer.append(TEXT_288);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_289);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_290);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_291);
    tool.getValue(node);
    stringBuffer.append(TEXT_292);
    
			}

    stringBuffer.append(TEXT_293);
    
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_294);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(node.path );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_297);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_298);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_299);
    touchXMLNode.getXMLNode(currEleName);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_301);
    
			}
		}
	}
}

//----------** add by wliu dom4j to genenrate get function for node **-------//
class GenerateExprCmpByDom4j{
	String cid = null;
	XMLTool tool = null;
	XMLNode groupNode = null;
	boolean needEmptyNode = true;
	boolean isSaveDocAsNode = false;
	public void generateCode(XMLNode node, String parentName){
		String tmpPath = node.path.replaceFirst(groupNode.path,"");
		String[] arrNames = tmpPath.split("/");
		if(node==groupNode){

    stringBuffer.append(TEXT_302);
    
		}
		
		if(node.relatedColumn != null){

    stringBuffer.append(TEXT_303);
    
			if(!needEmptyNode){

    stringBuffer.append(TEXT_304);
    tool.getValue(node); 
    stringBuffer.append(TEXT_305);
    generateCmnExpr(arrNames, parentName,cid); 
    stringBuffer.append(TEXT_306);
    			}
    generateCmnExpr(arrNames, parentName,cid); 
    stringBuffer.append(TEXT_307);
    
 if(isSaveDocAsNode && "id_Document".equals(node.relatedColumn.getTalendType())){
 
    stringBuffer.append(TEXT_308);
    generateCmnExpr(arrNames, parentName,cid); 
    stringBuffer.append(TEXT_309);
    generateCmnExpr(arrNames, parentName,cid); 
    stringBuffer.append(TEXT_310);
    tool.getValue(node); 
    stringBuffer.append(TEXT_311);
    
}else{

    stringBuffer.append(TEXT_312);
    generateCmnExpr(arrNames, parentName,cid); 
    stringBuffer.append(TEXT_313);
    generateCmnExpr(arrNames, parentName,cid); 
    stringBuffer.append(TEXT_314);
    tool.getValue(node); 
    stringBuffer.append(TEXT_315);
    
}

    if(!needEmptyNode){
    stringBuffer.append(TEXT_316);
    }
    stringBuffer.append(TEXT_317);
    
		}
		
		//first generate the attribute comparision	
		if(node.attributes!=null){
			for(XMLNode attri:node.attributes){
				if(attri.relatedColumn !=null){

    stringBuffer.append(TEXT_318);
    
					if(!needEmptyNode){

    stringBuffer.append(TEXT_319);
    tool.getValue(attri); 
    stringBuffer.append(TEXT_320);
    generateCmnExpr(arrNames, parentName,cid); 
    stringBuffer.append(TEXT_321);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_322);
    					}
    generateCmnExpr(arrNames, parentName,cid); 
    stringBuffer.append(TEXT_323);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_324);
    generateCmnExpr(arrNames, parentName,cid); 
    stringBuffer.append(TEXT_325);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_326);
    generateCmnExpr(arrNames, parentName,cid); 
    stringBuffer.append(TEXT_327);
    stringBuffer.append(attri.name );
    stringBuffer.append(TEXT_328);
    tool.getValue(attri); 
    stringBuffer.append(TEXT_329);
    
					if(!needEmptyNode){
    stringBuffer.append(TEXT_330);
    }

    stringBuffer.append(TEXT_331);
    
				}
			}
		}
		
		if(node.elements!=null){
			for(XMLNode child:node.elements){
				if(!child.isMainNode()){
					generateCode(child,parentName);
				}
			}
		}		
	}
	
	private void generateCmnExpr(String[] arrNames, String parentName,String cid){
	
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(parentName );
    stringBuffer.append(TEXT_334);
    
		for(int i=1;arrNames != null && i<arrNames.length; i++){
			if(i!=1){
			
    stringBuffer.append(TEXT_335);
    stringBuffer.append(arrNames[i]);
    stringBuffer.append(TEXT_336);
    
			}else{
			
    stringBuffer.append(TEXT_337);
    stringBuffer.append(arrNames[i]);
    stringBuffer.append(TEXT_338);
    
			}
		}
		
    stringBuffer.append(TEXT_339);
    
	}
}

// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Null generation mode start *** ------------------- //
class GenerateToolByNull{
	String cid = null;
	boolean allowEmpty = false;
	boolean bAddEmptyAttr = false, bAddUnmappedAttr = false;
	boolean outputAsXSD = false;
	XMLTool tool = null;
	
	boolean isCompact = false;
	
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

    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(node.getCurrGroupPos());
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    
					}else{// root
    					int num = node.path.split("/").length-2;
    					if(!outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(num);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    
						}else{

    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
						}
					}
					mainChild = null;
				}
				if(!child.isMainNode()){ //make the main node output last
					if(!outputAsXSD && !allowEmpty 
						&& (child.relatedColumn != null || child.childrenColumnList.size()>0
							 || child.hasDefaultValue == true ) ){

    stringBuffer.append(TEXT_354);
    
                    	for(IMetadataColumn column : child.childrenColumnList){
                    		
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_357);
    
                    	}
                    	if(child.hasDefaultValue == true){
    stringBuffer.append(TEXT_358);
    }
    stringBuffer.append(TEXT_359);
    
						if(isCompact==false)
							generateCode(child,emptySpace+"  ");
						else
							generateCode(child,emptySpace);

    stringBuffer.append(TEXT_360);
    
            		}else{
            			if(isCompact==false)
            				generateCode(child,emptySpace+"  ");
            			else
            				generateCode(child,emptySpace);
            		}
				}
			}

			if(!node.isMainNode()){ // is not main node
				endElement(node,emptySpace);
			}
		}
	}
	private void startElement(XMLNode node, String emptySpace){

    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(isCompact?"":"\\n");
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_366);
    
		if(outputAsXSD && node.parent==null){

    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    
		}
		for(XMLNode ns:node.namespaces){
			addNameSpace(ns);
		}
		for(XMLNode attri:node.attributes){
			addAttribute(attri);
		}
		if(outputAsXSD && node.relatedColumn != null){

    stringBuffer.append(TEXT_372);
    tool.getValue(node); 
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    
		}

    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    
	}
	
	public void endElement(XMLNode node, String emptySpace){
		if(node.elements.size()>0){

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(isCompact?"":"\\n");
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_382);
    
		}else{

    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_385);
    
		}
	}
	private void setText(XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_386);
    tool.getValue(node);
    stringBuffer.append(TEXT_387);
    tool.getValue(node);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    tool.getValue(node);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    tool.getValue(node);
    stringBuffer.append(TEXT_392);
    
			}else{

    stringBuffer.append(TEXT_393);
    tool.getValue(node);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    tool.getValue(node);
    stringBuffer.append(TEXT_396);
    
			}
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_397);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_402);
    
		}
	}
	private void addAttribute(XMLNode node){
		if (node.relatedColumn != null){
        
    stringBuffer.append(TEXT_403);
    tool.getValue(node); 
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_406);
    tool.getValue(node);
    stringBuffer.append(TEXT_407);
     if (bAddEmptyAttr){
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_410);
    }
		} else {
		  if (node.defaultValue != null && !("").equals(node.defaultValue)){
          
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_414);
    
		  } else if (bAddUnmappedAttr){
		  
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_417);
    
		  }
		}
	}
	private void addNameSpace(XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_418);
    tool.getValue(node);
    stringBuffer.append(TEXT_419);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    tool.getValue(node);
    stringBuffer.append(TEXT_422);
    
			}else{

    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_425);
    tool.getValue(node);
    stringBuffer.append(TEXT_426);
    
			}

    stringBuffer.append(TEXT_427);
    
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_430);
    
			}else{

    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_434);
    
			}
		}
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

    stringBuffer.append(TEXT_435);
    
if (conns == null || conns.isEmpty()) {
	return "";			
} else {
	IConnection conn = conns.get(0);

	if (!conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
		return "";
	}
}
List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);

	if (metadata != null) {
		String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
		String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
		String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
		String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
		String dtdRootName = ElementParameterParser.getValue(node, "__DTD_NAME__");
		String dtdFileName = ElementParameterParser.getValue(node, "__DTD_SYSTEMID__");
		String xslType = ElementParameterParser.getValue(node, "__XSL_TYPE__");
		String xslHref = ElementParameterParser.getValue(node, "__XSL_HREF__");
		boolean split = "true".equals(ElementParameterParser.getValue(node, "__SPLIT__"));
		boolean trim = "true".equals(ElementParameterParser.getValue(node, "__TRIM__"));
		boolean isMerge= ("true").equals(ElementParameterParser.getValue(node, "__MERGE__"));
		boolean isCompact = ("true").equals(ElementParameterParser.getValue(node, "__PRETTY_COMPACT__"));
		boolean needFileValid = ("true").equals(ElementParameterParser.getValue(node, "__FILE_VALID__"));
		boolean needDTDValid = ("true").equals(ElementParameterParser.getValue(node, "__DTD_VALID__"));
		boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
		boolean needXSLValid = ("true").equals(ElementParameterParser.getValue(node, "__XSL_VALID__"));
		List<Map<String, String>> rootTable = 
		(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
		List<Map<String, String>> groupTable = 
		(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
		List<Map<String, String>> loopTable = 
		(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
		
		if(isMerge){
		    mode = "Dom4j";
		}

		if (!useStream) {
		
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    if (isMerge) {
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    } else {
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    }
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    if (("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))) {
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    }

			if (isMerge) {
			
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_472);
    
			}

			if (split) {
			
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    
			}
		} else {
		
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    
		}//***************************the part of the output stream end************************************************
		
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    
		if(!useStream && isMerge){
		
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    
		}
		
    stringBuffer.append(TEXT_494);
    
		// *** generation mode init ***
		if (("Dom4j").equals(mode)) {
		
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    if (!useStream && isMerge) {//append mode and the code of file path
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_513);
    if(groupTable.size()>0){
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    }
    stringBuffer.append(TEXT_516);
    } else {	
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_518);
    
			}

			if (!isMerge) {
				if (needFileValid) {
					if (needDTDValid) {
					
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(dtdRootName );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(dtdFileName );
    stringBuffer.append(TEXT_522);
    } else if (needXSLValid) {
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(xslType );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(xslHref );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_530);
    
					}
				}
			}

			if (isCompact==true) {//generate compact file
			
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    } else {	
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    
			}
			
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_536);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_539);
    
			int groupSize = 0;

			if (groupTable != null && groupTable.size() > 0) {
				for (java.util.Map<String, String> tmpMap : groupTable) {
					if (tmpMap.get("ATTRIBUTE").equals("main")) {
						groupSize++;
					}
				}
			}
			
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(groupSize + 1);
    stringBuffer.append(TEXT_542);
    
		} else if (("Null").equals(mode)) {
		
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    
			if (loopTable.size() > 0) {
				String emptyspace = "";
				String endPath = loopTable.get(0).get("PATH");
				String[] endTabs = endPath.split("/");

				for (int len = 1; len < endTabs.length-1; len++) {
				
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(endTabs[len]);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(isCompact?"":"\\n");
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(endTabs[len]);
    stringBuffer.append(TEXT_552);
    
					if (isCompact == false) {//generate pretty file
						emptyspace += "  ";
					}
				}
			}
			
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    
			int rootSize = 0;

			if (rootTable != null && rootTable.size() > 0) {
				for (java.util.Map<String, String> tmpMap : rootTable) {
					if (tmpMap.get("ATTRIBUTE").equals("main")) {
						rootSize++;
					}
				}
			}
			
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_561);
    stringBuffer.append(rootSize);
    stringBuffer.append(TEXT_562);
    if (!useStream) {// the part of file path---the old code
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_566);
    } else {// the part of output stream
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_568);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_569);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_572);
    }
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    
			if (needFileValid) {
				if (needDTDValid) {
				
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(dtdRootName );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(dtdFileName );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    } else if (needXSLValid) {
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(xslType );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(xslHref);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    
				}
			}
		}
    	if(conns!=null && conns.size()>0){
    		IConnection conn = conns.get(0);
    		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){ 
    		
                String allowEmpty = ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__");
                String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
        		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
        		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
        		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
        		String outputAsXSD = ElementParameterParser.getValue(node, "__OUTPUT_AS_XSD__");
        		boolean isSaveDocAsNode = ("true").equals(ElementParameterParser.getValue(node,"__ADD_DOCUMENT_AS_NODE__"));
        		boolean bAddEmptyAttr = "true".equals(ElementParameterParser.getValue(node, "__ADD_EMPTY_ATTRIBUTE__"));
                boolean bAddUnmappedAttr = "true".equals(ElementParameterParser.getValue(node, "__ADD_UNMAPPED_ATTRIBUTE__"));
        		int schemaOptNum=100;
				String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
				if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
					schemaOptNum  = Integer.parseInt(schemaOptNumStr);
				} 
        		
        		// init tool
                XMLTool tool = new XMLTool();
                tool.connName = NodeUtil.getPrivateConnClassName(conn);
                tool.advancedSeparator=advancedSeparator;
                tool.thousandsSeparator=thousandsSeparator;
                tool.decimalSeparator=decimalSeparator;
                tool.cid=cid;
                boolean isAppend = !useStream && isMerge;
                tool.isAppend = isAppend;
                
                // change tables to a tree 
				Object[] treeObjs = getTree(rootTable, groupTable, loopTable, metadata.getListColumns());
				
				if(treeObjs == null || treeObjs.length == 0){
					return "";
				}
				
            	List<XMLNode> mainList = (ArrayList<XMLNode>)treeObjs[0];
                List<XMLNode> groupList = (ArrayList<XMLNode>)treeObjs[1];
                XMLNode root = mainList.get(0);                
                XMLNode loop = (XMLNode)treeObjs[2];
                
                if(!"true".equals(allowEmpty) && !(groupTable.size()>0 && isAppend)){
                	removeEmptyElement(root);
                }
                
                List<List<XMLNode>> groupbyNodeList = new ArrayList<List<XMLNode>>();
                for(XMLNode group:groupList){
                	groupbyNodeList.add(getGroupByNodeList(group));
                }
          		if(metadata.getListColumns().size()> schemaOptNum){

    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    
					int colNum = 0;
					for(IMetadataColumn column :metadata.getListColumns()){
						if(colNum%schemaOptNum==0){

    stringBuffer.append(TEXT_589);
    stringBuffer.append(colNum/schemaOptNum);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(tool.connName);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(tool.connName);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    if(tool.isAppend){
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_594);
    
						}

    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_597);
     tool.getValue(column); 
    stringBuffer.append(TEXT_598);
    
						if((colNum+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_599);
    
						}
					colNum++;
					}
						if(colNum>0&&(colNum%schemaOptNum)>0){

    stringBuffer.append(TEXT_600);
    
						}
						if((groupTable.size()>0 && "Dom4j".equals(mode)&&(useStream || !isMerge))||("Null".equals(mode))){
							for(int groupNum=0;groupNum<groupList.size();groupNum++){
								XMLNode groupRootNode = groupList.get(groupNum);
								int nodeNum=0;
								for(int j=0;j<groupbyNodeList.get(groupNum).size();j++){
									XMLNode attr = groupbyNodeList.get(groupNum).get(j);
									if(attr.relatedColumn!=null){
										if(nodeNum%schemaOptNum==0){

    stringBuffer.append(TEXT_601);
    stringBuffer.append(groupNum);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(nodeNum/schemaOptNum);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    
										}

    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(groupNum);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(groupNum);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_612);
    tool.getValue(attr);
    stringBuffer.append(TEXT_613);
    tool.getValue(attr);
    stringBuffer.append(TEXT_614);
    
										if((nodeNum+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_615);
    
										}
										nodeNum++;
									}
											
								}
								if(nodeNum>0&&(nodeNum%schemaOptNum)>0){

    stringBuffer.append(TEXT_616);
    
								}
							for(int j=0;j<groupbyNodeList.get(groupNum).size();j++){
									XMLNode attr = groupbyNodeList.get(groupNum).get(j);
									if(j%schemaOptNum==0){

    stringBuffer.append(TEXT_617);
    stringBuffer.append(groupNum);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(j/schemaOptNum);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    
									}

    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(groupNum);
    stringBuffer.append(TEXT_624);
    tool.getValue(attr);
    stringBuffer.append(TEXT_625);
    
										if((j+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_626);
    
										}
							}
								if(groupbyNodeList.get(groupNum).size()>0&&(groupbyNodeList.get(groupNum).size()%schemaOptNum)>0){

    stringBuffer.append(TEXT_627);
    
								}
							}
						}
						if(("Dom4j").equals(mode)){
							//init the generate tool.
							GenerateToolByDom4j generateToolByDom4j = new GenerateToolByDom4j();
							if(!useStream && ("true").equals(outputAsXSD)){ // add a new prerequisite:useStream to ignore generating the xsd file
								generateToolByDom4j.outputAsXSD = true;
							}
							if(("true").equals(allowEmpty)){
								generateToolByDom4j.allowEmpty = true;
							}
							generateToolByDom4j.bAddEmptyAttr = bAddEmptyAttr;
							generateToolByDom4j.bAddUnmappedAttr = bAddUnmappedAttr;
							generateToolByDom4j.isSaveDocAsNode = isSaveDocAsNode;
							generateToolByDom4j.cid = cid;
							generateToolByDom4j.touchXMLNode.cid = cid;
							generateToolByDom4j.bigMethodHelper.cid = cid;
							generateToolByDom4j.tool = tool;
							if( groupTable.size()>0){
								if((!useStream && isMerge)){
									generateToolByDom4j.isAppend= true;
									for( int i=0; i<groupList.size();i++){
										XMLNode groupNode= groupList.get(i);
										GenerateExprCmpByDom4j generateExprCmpByDom4j = new GenerateExprCmpByDom4j();
										generateExprCmpByDom4j.tool = tool;
										generateExprCmpByDom4j.groupNode = groupNode;
										generateExprCmpByDom4j.isSaveDocAsNode = isSaveDocAsNode;
										generateExprCmpByDom4j.needEmptyNode = ("true").equals(allowEmpty);
										generateExprCmpByDom4j.cid=cid;
								

    stringBuffer.append(TEXT_628);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    generateExprCmpByDom4j.generateCode(groupNode, "tempElem"); 
    stringBuffer.append(TEXT_631);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_638);
     
					generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");

    stringBuffer.append(TEXT_639);
    generateToolByDom4j.touchXMLNode.getXMLElement("group"+i+"_");
    stringBuffer.append(TEXT_640);
    
								
									}
								}else{
									for(int i=0;i<groupList.size();i++){
										XMLNode groupRootNode = groupList.get(i);

    stringBuffer.append(TEXT_641);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_647);
    
				generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");

    stringBuffer.append(TEXT_648);
    generateToolByDom4j.touchXMLNode.getXMLElement("group"+i+"_");
    stringBuffer.append(TEXT_649);
    
									}
								}
							}
							if(loopTable!=null && loopTable.size()>0){

    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid );
    if(!useStream && isMerge && groupTable.size()>0){
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid );
    }
    stringBuffer.append(TEXT_656);
    
					generateToolByDom4j.generateCode(loop,"loop","subTreeRootParent");

    stringBuffer.append(TEXT_657);
    generateToolByDom4j.touchXMLNode.getXMLElement("loop");
    stringBuffer.append(TEXT_658);
    
							}
						}
						if("Null".equals(mode)){
							GenerateToolByNull generateToolByNull = new GenerateToolByNull();
						    if(!useStream && ("true").equals(outputAsXSD)){ // add a new prerequisite:useStream to ignore generating the xsd file
						    	generateToolByNull.outputAsXSD = true;
						    }
						    if(("true").equals(allowEmpty)){
						    	generateToolByNull.allowEmpty = true;
						    }
						    generateToolByNull.bAddEmptyAttr = bAddEmptyAttr;
						    generateToolByNull.bAddUnmappedAttr = bAddUnmappedAttr;
						    generateToolByNull.cid = cid;
						    generateToolByNull.tool = tool;
						    generateToolByNull.isCompact = isCompact;
						    String rootEmptySpace = "";
						    for(int i=0;i < mainList.size();i++){

    stringBuffer.append(TEXT_659);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    
								generateToolByNull.generateCode(mainList.get(i),rootEmptySpace);

    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    
								if(isCompact==false){//generate pretty file
									rootEmptySpace+="  ";
								}
								if(!generateToolByNull.outputAsXSD && !generateToolByNull.allowEmpty){
									if(mainList.get(i).relatedColumn != null || mainList.get(i).childrenColumnList.size()>0){
										int columnNum=0;
										for(IMetadataColumn column : mainList.get(i).childrenColumnList){
											if(columnNum%schemaOptNum==0){

    stringBuffer.append(TEXT_668);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(columnNum/schemaOptNum);
    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_671);
    
											}

    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_674);
    
											if((columnNum+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_675);
    
											}
											columnNum++;
										}
											if(columnNum>0&&(columnNum%schemaOptNum)>0){

    stringBuffer.append(TEXT_676);
    
											}
									}
								}
							}
							for(int i=0;i<groupList.size();i++){
								String emptySpace = "";
								if(isCompact==false){//generate pretty file
									for(int len = groupList.get(i).path.split("/").length-1;len>1;len--){
										emptySpace +="  ";
									}
								}

    stringBuffer.append(TEXT_677);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    
								generateToolByNull.generateCode(groupList.get(i),emptySpace);

    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    
								if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){
									if((groupList.get(i).relatedColumn != null || groupList.get(i).childrenColumnList.size()>0)){
										int columnNum=0;
										for(IMetadataColumn column : groupList.get(i).childrenColumnList){
											if(columnNum%schemaOptNum==0){

    stringBuffer.append(TEXT_684);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(columnNum/schemaOptNum);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    
											}

    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_690);
    
											if((columnNum+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_691);
    
											}
											columnNum++;
										}
											if(columnNum>0&&(columnNum%schemaOptNum)>0){

    stringBuffer.append(TEXT_692);
    
											}
									
									}
								}
							}
							if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){
								int columnNum=0;
									for(IMetadataColumn column : loop.childrenColumnList){
										if(columnNum%schemaOptNum==0){

    stringBuffer.append(TEXT_693);
    stringBuffer.append(columnNum/schemaOptNum);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_695);
    
										}

    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_698);
    
										if((columnNum+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_699);
    
										}
										columnNum++;
									}
										if(columnNum>0&&(columnNum%schemaOptNum)>0){

    stringBuffer.append(TEXT_700);
    
										}
									
									
							}
							String emptySpace = "";
							if(isCompact==false){//generate pretty file
								for(int len =loop.path.split("/").length-1;len>1;len--){
									emptySpace +="  ";
								}
							}

    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    
							 generateToolByNull.generateCode(loop,emptySpace);
							 generateToolByNull.endElement(loop,emptySpace);

    stringBuffer.append(TEXT_706);
    
						}

    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_710);
    
				}
			}
		}
	}
}

    stringBuffer.append(TEXT_711);
    return stringBuffer.toString();
  }
}

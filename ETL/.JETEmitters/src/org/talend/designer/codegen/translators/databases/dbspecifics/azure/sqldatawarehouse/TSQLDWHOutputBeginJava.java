package org.talend.designer.codegen.translators.databases.dbspecifics.azure.sqldatawarehouse;

import org.talend.core.model.metadata.IMetadataColumn;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TSQLDWHOutputBeginJava {
  protected static String nl;
  public static synchronized TSQLDWHOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSQLDWHOutputBeginJava result = new TSQLDWHOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "                if(log.is";
  protected final String TEXT_4 = "Enabled())";
  protected final String TEXT_5 = NL + "            log.";
  protected final String TEXT_6 = "(\"";
  protected final String TEXT_7 = " - \" ";
  protected final String TEXT_8 = " + (";
  protected final String TEXT_9 = ") ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "    \tclass BytesLimit65535_";
  protected final String TEXT_12 = "{" + NL + "    \t\tpublic void limitLog4jByte() throws Exception{" + NL + "    \t\t\t";
  protected final String TEXT_13 = NL + "            StringBuilder ";
  protected final String TEXT_14 = " = new StringBuilder();";
  protected final String TEXT_15 = NL + "            ";
  protected final String TEXT_16 = ".append(\"Parameters:\");";
  protected final String TEXT_17 = NL + "                    ";
  protected final String TEXT_18 = ".append(\"";
  protected final String TEXT_19 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_20 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_21 = NL + "                    ";
  protected final String TEXT_22 = ".append(\"";
  protected final String TEXT_23 = "\" + \" = \" + ";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "                ";
  protected final String TEXT_26 = ".append(\" | \");";
  protected final String TEXT_27 = NL + "    \t\t}" + NL + "    \t}" + NL + "    \t" + NL + "        new BytesLimit65535_";
  protected final String TEXT_28 = "().limitLog4jByte();";
  protected final String TEXT_29 = NL + "            StringBuilder ";
  protected final String TEXT_30 = " = new StringBuilder();    ";
  protected final String TEXT_31 = NL + "                    ";
  protected final String TEXT_32 = ".append(";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "                    if(";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = " == null){";
  protected final String TEXT_38 = NL + "                        ";
  protected final String TEXT_39 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_40 = NL + "                        ";
  protected final String TEXT_41 = ".append(";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ");" + NL + "                    }   ";
  protected final String TEXT_44 = NL + "                ";
  protected final String TEXT_45 = ".append(\"|\");";
  protected final String TEXT_46 = NL;
  protected final String TEXT_47 = NL + "int nb_line_";
  protected final String TEXT_48 = " = 0;" + NL + "int nb_line_update_";
  protected final String TEXT_49 = " = 0;" + NL + "int nb_line_inserted_";
  protected final String TEXT_50 = " = 0;" + NL + "int nb_line_deleted_";
  protected final String TEXT_51 = " = 0;" + NL + "int nb_line_rejected_";
  protected final String TEXT_52 = " = 0;" + NL + "" + NL + "int deletedCount_";
  protected final String TEXT_53 = "=0;" + NL + "int updatedCount_";
  protected final String TEXT_54 = "=0;" + NL + "int insertedCount_";
  protected final String TEXT_55 = "=0;" + NL + "int rejectedCount_";
  protected final String TEXT_56 = "=0;" + NL + "String dbschema_";
  protected final String TEXT_57 = " = null;" + NL + "String tableName_";
  protected final String TEXT_58 = " = null;" + NL + "boolean whetherReject_";
  protected final String TEXT_59 = " = false;" + NL + "" + NL + "java.util.Calendar calendar_";
  protected final String TEXT_60 = " = java.util.Calendar.getInstance();" + NL + "long year1_";
  protected final String TEXT_61 = " = TalendDate.parseDate(\"yyyy-MM-dd\",\"0001-01-01\").getTime();" + NL + "long year2_";
  protected final String TEXT_62 = " = TalendDate.parseDate(\"yyyy-MM-dd\",\"1753-01-01\").getTime();" + NL + "long year10000_";
  protected final String TEXT_63 = " = TalendDate.parseDate(\"yyyy-MM-dd HH:mm:ss\",\"9999-12-31 24:00:00\").getTime();" + NL + "long date_";
  protected final String TEXT_64 = ";" + NL + "" + NL + "java.util.Calendar calendar_datetimeoffset_";
  protected final String TEXT_65 = " = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone(\"UTC\"));" + NL;
  protected final String TEXT_66 = NL;
  protected final String TEXT_67 = NL + "        int updateKeyCount_";
  protected final String TEXT_68 = " = ";
  protected final String TEXT_69 = ";" + NL + "        if(updateKeyCount_";
  protected final String TEXT_70 = " < 1) {" + NL + "            throw new RuntimeException(\"For update, Schema must have a key\");" + NL + "        }";
  protected final String TEXT_71 = NL + "        int deleteKeyCount_";
  protected final String TEXT_72 = " = ";
  protected final String TEXT_73 = ";" + NL + "        if(deleteKeyCount_";
  protected final String TEXT_74 = " < 1) {" + NL + "            throw new RuntimeException(\"For delete, Schema must have a key\");" + NL + "        }";
  protected final String TEXT_75 = NL + "        int insertKeyCount_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ";" + NL + "        if(insertKeyCount_";
  protected final String TEXT_78 = " < 1) {" + NL + "            throw new RuntimeException(\"For insert if not exist, Schema must have a key\");" + NL + "        }";
  protected final String TEXT_79 = NL + "java.sql.Connection conn_";
  protected final String TEXT_80 = " = null;";
  protected final String TEXT_81 = NL + "String dbUser_";
  protected final String TEXT_82 = " = null;";
  protected final String TEXT_83 = NL + "\tdbschema_";
  protected final String TEXT_84 = " = (String)globalMap.get(\"";
  protected final String TEXT_85 = "\");" + NL + "\tconn_";
  protected final String TEXT_86 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_87 = "\");" + NL + "\t";
  protected final String TEXT_88 = NL + "\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_89 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\tif (null != dataSources_";
  protected final String TEXT_90 = ") {" + NL + "\t\t\tString dsAlias_";
  protected final String TEXT_91 = " = ";
  protected final String TEXT_92 = ";" + NL + "    \t\tif (dataSources_";
  protected final String TEXT_93 = ".get(dsAlias_";
  protected final String TEXT_94 = ") == null) {" + NL + "       \t\t\tthrow new RuntimeException(\"No DataSource with alias: \" + dsAlias_";
  protected final String TEXT_95 = " + \" available!\");" + NL + "          \t}" + NL + "    \t\tconn_";
  protected final String TEXT_96 = " = dataSources_";
  protected final String TEXT_97 = ".get(dsAlias_";
  protected final String TEXT_98 = ").getConnection();" + NL + "\t\t} else {" + NL + "\t";
  protected final String TEXT_99 = NL + "    dbschema_";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = ";";
  protected final String TEXT_102 = NL + "    String driverClass_";
  protected final String TEXT_103 = " = \"net.sourceforge.jtds.jdbc.Driver\";";
  protected final String TEXT_104 = NL + "    String driverClass_";
  protected final String TEXT_105 = " = \"com.microsoft.sqlserver.jdbc.SQLServerDriver\";";
  protected final String TEXT_106 = NL + "\t";
  protected final String TEXT_107 = NL + "    java.lang.Class.forName(driverClass_";
  protected final String TEXT_108 = ");" + NL + "    String port_";
  protected final String TEXT_109 = " = ";
  protected final String TEXT_110 = ";" + NL + "    String dbname_";
  protected final String TEXT_111 = " = ";
  protected final String TEXT_112 = " ;";
  protected final String TEXT_113 = NL + "    String url_";
  protected final String TEXT_114 = " = \"jdbc:jtds:sqlserver://\" + ";
  protected final String TEXT_115 = " ;";
  protected final String TEXT_116 = NL + "    String url_";
  protected final String TEXT_117 = " = \"jdbc:sqlserver://\" + ";
  protected final String TEXT_118 = " ;";
  protected final String TEXT_119 = " " + NL + "    if (!\"\".equals(port_";
  protected final String TEXT_120 = ")) {" + NL + "    \turl_";
  protected final String TEXT_121 = " += \":\" + ";
  protected final String TEXT_122 = ";" + NL + "    }" + NL + "    if (!\"\".equals(dbname_";
  protected final String TEXT_123 = ")) {";
  protected final String TEXT_124 = NL + "\t\t\t\turl_";
  protected final String TEXT_125 = " += \"//\" + ";
  protected final String TEXT_126 = "; " + NL + "\t";
  protected final String TEXT_127 = "\t\t    " + NL + "\t\t    \turl_";
  protected final String TEXT_128 = " += \";databaseName=\" + ";
  protected final String TEXT_129 = "; " + NL + "\t";
  protected final String TEXT_130 = NL + "    }" + NL + "    url_";
  protected final String TEXT_131 = " += \";applicationName=Talend;\" + ";
  protected final String TEXT_132 = ";" + NL + "    dbUser_";
  protected final String TEXT_133 = " = ";
  protected final String TEXT_134 = ";" + NL;
  protected final String TEXT_135 = NL;
  protected final String TEXT_136 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_137 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_138 = ");";
  protected final String TEXT_139 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_140 = " = ";
  protected final String TEXT_141 = "; ";
  protected final String TEXT_142 = NL + NL + "    String dbPwd_";
  protected final String TEXT_143 = " = decryptedPassword_";
  protected final String TEXT_144 = ";";
  protected final String TEXT_145 = "\t" + NL + "    conn_";
  protected final String TEXT_146 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_147 = ",dbUser_";
  protected final String TEXT_148 = ",dbPwd_";
  protected final String TEXT_149 = ");";
  protected final String TEXT_150 = NL + "\t";
  protected final String TEXT_151 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_152 = NL + "   int batchSize_";
  protected final String TEXT_153 = " = ";
  protected final String TEXT_154 = ";" + NL + "   int batchSizeCounter_";
  protected final String TEXT_155 = "=0;";
  protected final String TEXT_156 = NL + NL + "if(dbschema_";
  protected final String TEXT_157 = " == null || dbschema_";
  protected final String TEXT_158 = ".trim().length() == 0) {" + NL + "    tableName_";
  protected final String TEXT_159 = " = ";
  protected final String TEXT_160 = ";" + NL + "} else {" + NL + "    tableName_";
  protected final String TEXT_161 = " = dbschema_";
  protected final String TEXT_162 = " + \"].[\" + ";
  protected final String TEXT_163 = ";" + NL + "}";
  protected final String TEXT_164 = NL + "\tint count_";
  protected final String TEXT_165 = "=0;" + NL;
  protected final String TEXT_166 = NL + "            java.sql.Statement stmtDrop_";
  protected final String TEXT_167 = " = conn_";
  protected final String TEXT_168 = ".createStatement();";
  protected final String TEXT_169 = NL + "                              stmtDrop_";
  protected final String TEXT_170 = ".setQueryTimeout(Integer.valueOf(Integer.valueOf(";
  protected final String TEXT_171 = ")));";
  protected final String TEXT_172 = NL + "            stmtDrop_";
  protected final String TEXT_173 = ".execute(\"";
  protected final String TEXT_174 = "\" ";
  protected final String TEXT_175 = ");";
  protected final String TEXT_176 = NL + "            stmtDrop_";
  protected final String TEXT_177 = ".close();";
  protected final String TEXT_178 = NL + "                 conn_";
  protected final String TEXT_179 = ".commit();";
  protected final String TEXT_180 = NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_181 = " = conn_";
  protected final String TEXT_182 = ".createStatement();";
  protected final String TEXT_183 = NL + "                              stmtCreate_";
  protected final String TEXT_184 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_185 = "));";
  protected final String TEXT_186 = NL + "                    stmtCreate_";
  protected final String TEXT_187 = ".execute(((\"";
  protected final String TEXT_188 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_189 = ".";
  protected final String TEXT_190 = ", \"";
  protected final String TEXT_191 = "\")";
  protected final String TEXT_192 = ".toUpperCase()";
  protected final String TEXT_193 = ")+\")";
  protected final String TEXT_194 = "\"));";
  protected final String TEXT_195 = NL + "                stmtCreate_";
  protected final String TEXT_196 = ".execute(\"";
  protected final String TEXT_197 = ")\");";
  protected final String TEXT_198 = NL + "            stmtCreate_";
  protected final String TEXT_199 = ".close();";
  protected final String TEXT_200 = NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_201 = " = conn_";
  protected final String TEXT_202 = ".createStatement();";
  protected final String TEXT_203 = NL + "                              stmtCreate_";
  protected final String TEXT_204 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_205 = "));";
  protected final String TEXT_206 = NL + "                    stmtCreate_";
  protected final String TEXT_207 = ".execute(((\"";
  protected final String TEXT_208 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = ", \"";
  protected final String TEXT_211 = "\")";
  protected final String TEXT_212 = ".toUpperCase()";
  protected final String TEXT_213 = ")+\")";
  protected final String TEXT_214 = "\"));";
  protected final String TEXT_215 = NL + "                stmtCreate_";
  protected final String TEXT_216 = ".execute(\"";
  protected final String TEXT_217 = ")\");";
  protected final String TEXT_218 = NL + "            stmtCreate_";
  protected final String TEXT_219 = ".close();";
  protected final String TEXT_220 = NL;
  protected final String TEXT_221 = NL + "                    String keyCheckTable_";
  protected final String TEXT_222 = " = \"[Informix]\"+\"[\"+";
  protected final String TEXT_223 = "+\"][\"+";
  protected final String TEXT_224 = "+\"][\"+";
  protected final String TEXT_225 = "+\"][\"+";
  protected final String TEXT_226 = "+\"][\"+";
  protected final String TEXT_227 = "+\"]\"+ \"[checktable]\" + \"[\" + ";
  protected final String TEXT_228 = " + \"]\";";
  protected final String TEXT_229 = NL + "                    // [%connection%][checktable][tableName]" + NL + "                    String keyCheckTable_";
  protected final String TEXT_230 = " = conn_";
  protected final String TEXT_231 = " + \"[checktable]\" + \"[\" + ";
  protected final String TEXT_232 = " + \"]\";";
  protected final String TEXT_233 = NL + NL + "                if(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_234 = ")== null){//}" + NL + "" + NL + "                    synchronized (GlobalResource.resourceLockMap.get(keyCheckTable_";
  protected final String TEXT_235 = ")) {//}" + NL + "                        if(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_236 = ")== null){//}";
  protected final String TEXT_237 = NL + "                                java.sql.Statement isExistStmt_";
  protected final String TEXT_238 = " = conn_";
  protected final String TEXT_239 = ".createStatement();" + NL + "                                boolean whetherExist_";
  protected final String TEXT_240 = " = false;" + NL + "                                try {" + NL + "                                    isExistStmt_";
  protected final String TEXT_241 = ".execute(\"SELECT TOP 1 1 FROM [\" + tableName_";
  protected final String TEXT_242 = " + \"]\" );" + NL + "                                    whetherExist_";
  protected final String TEXT_243 = " = true;" + NL + "                                } catch (java.lang.Exception e){" + NL + "                                    whetherExist_";
  protected final String TEXT_244 = " = false;" + NL + "                                }" + NL + "                                isExistStmt_";
  protected final String TEXT_245 = ".close();";
  protected final String TEXT_246 = NL + "                                ";
  protected final String TEXT_247 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_248 = " = conn_";
  protected final String TEXT_249 = ".getMetaData();" + NL + "                                if(tableNameForSearch_";
  protected final String TEXT_250 = ".indexOf(\"\\\"\")==-1){" + NL + "                                    tableNameForSearch_";
  protected final String TEXT_251 = " = tableNameForSearch_";
  protected final String TEXT_252 = ".toUpperCase();" + NL + "                                }else{" + NL + "                                    tableNameForSearch_";
  protected final String TEXT_253 = " = tableNameForSearch_";
  protected final String TEXT_254 = ".replaceAll(\"\\\"\",\"\");" + NL + "                                }" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_255 = " = dbMetaData_";
  protected final String TEXT_256 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_257 = ", tableNameForSearch_";
  protected final String TEXT_258 = ", new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_259 = " = false;" + NL + "                                if(rsTable_";
  protected final String TEXT_260 = ".next()) {" + NL + "                                    whetherExist_";
  protected final String TEXT_261 = " = true;" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_262 = ".close();" + NL;
  protected final String TEXT_263 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_264 = " = conn_";
  protected final String TEXT_265 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_266 = " = dbMetaData_";
  protected final String TEXT_267 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_268 = " = false;" + NL + "                                while(rsTable_";
  protected final String TEXT_269 = ".next()) {" + NL + "                                    String table_";
  protected final String TEXT_270 = " = rsTable_";
  protected final String TEXT_271 = ".getString(\"TABLE_NAME\");" + NL + "                                    String schema_";
  protected final String TEXT_272 = " = rsTable_";
  protected final String TEXT_273 = ".getString(\"TABLE_SCHEM\");" + NL + "                                    if(table_";
  protected final String TEXT_274 = ".equals";
  protected final String TEXT_275 = "IgnoreCase";
  protected final String TEXT_276 = "(";
  protected final String TEXT_277 = ")" + NL + "                                        && (schema_";
  protected final String TEXT_278 = ".equals";
  protected final String TEXT_279 = "IgnoreCase";
  protected final String TEXT_280 = "(dbschema_";
  protected final String TEXT_281 = ") || dbschema_";
  protected final String TEXT_282 = ".trim().length() ==0)) {" + NL + "                                        whetherExist_";
  protected final String TEXT_283 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_284 = ".close();";
  protected final String TEXT_285 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_286 = " = conn_";
  protected final String TEXT_287 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_288 = " = dbMetaData_";
  protected final String TEXT_289 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_290 = " = false;" + NL + "                                while(rsTable_";
  protected final String TEXT_291 = ".next()) {" + NL + "                                    String table_";
  protected final String TEXT_292 = " = rsTable_";
  protected final String TEXT_293 = ".getString(\"TABLE_NAME\");" + NL + "                                    String schema_";
  protected final String TEXT_294 = " = rsTable_";
  protected final String TEXT_295 = ".getString(\"TABLE_SCHEM\");" + NL + "                                    if(table_";
  protected final String TEXT_296 = ".equals";
  protected final String TEXT_297 = "IgnoreCase";
  protected final String TEXT_298 = "((";
  protected final String TEXT_299 = ")";
  protected final String TEXT_300 = ".toUpperCase()";
  protected final String TEXT_301 = ")" + NL + "                                        && (schema_";
  protected final String TEXT_302 = ".equals";
  protected final String TEXT_303 = "IgnoreCase";
  protected final String TEXT_304 = "(dbschema_";
  protected final String TEXT_305 = ") || (dbschema_";
  protected final String TEXT_306 = ".trim().length() ==0 && dbUser_";
  protected final String TEXT_307 = ".equalsIgnoreCase(schema_";
  protected final String TEXT_308 = ")))) {" + NL + "                                        whetherExist_";
  protected final String TEXT_309 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_310 = ".close();";
  protected final String TEXT_311 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_312 = " = conn_";
  protected final String TEXT_313 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_314 = " = dbMetaData_";
  protected final String TEXT_315 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_316 = " = false;" + NL + "                                String defaultSchema_";
  protected final String TEXT_317 = " = \"public\";" + NL + "                                if(dbschema_";
  protected final String TEXT_318 = " == null || dbschema_";
  protected final String TEXT_319 = ".trim().length() == 0) {" + NL + "                                    java.sql.Statement stmtSchema_";
  protected final String TEXT_320 = " = conn_";
  protected final String TEXT_321 = ".createStatement();" + NL + "                                    java.sql.ResultSet rsSchema_";
  protected final String TEXT_322 = " = stmtSchema_";
  protected final String TEXT_323 = ".executeQuery(\"select current_schema() \");" + NL + "                                    while(rsSchema_";
  protected final String TEXT_324 = ".next()){" + NL + "                                        defaultSchema_";
  protected final String TEXT_325 = " = rsSchema_";
  protected final String TEXT_326 = ".getString(\"current_schema\");" + NL + "                                    }" + NL + "                                    rsSchema_";
  protected final String TEXT_327 = ".close();" + NL + "                                    stmtSchema_";
  protected final String TEXT_328 = ".close();" + NL + "                                }" + NL + "                                while(rsTable_";
  protected final String TEXT_329 = ".next()) {" + NL + "                                    String table_";
  protected final String TEXT_330 = " = rsTable_";
  protected final String TEXT_331 = ".getString(\"TABLE_NAME\");" + NL + "                                    String schema_";
  protected final String TEXT_332 = " = rsTable_";
  protected final String TEXT_333 = ".getString(\"TABLE_SCHEM\");" + NL + "                                    if(table_";
  protected final String TEXT_334 = ".equals";
  protected final String TEXT_335 = "IgnoreCase";
  protected final String TEXT_336 = "(";
  protected final String TEXT_337 = ")" + NL + "                                        && (schema_";
  protected final String TEXT_338 = ".equals";
  protected final String TEXT_339 = "IgnoreCase";
  protected final String TEXT_340 = "(dbschema_";
  protected final String TEXT_341 = ") || ((dbschema_";
  protected final String TEXT_342 = " ==null || dbschema_";
  protected final String TEXT_343 = ".trim().length() ==0) && defaultSchema_";
  protected final String TEXT_344 = ".equals";
  protected final String TEXT_345 = "IgnoreCase";
  protected final String TEXT_346 = "(schema_";
  protected final String TEXT_347 = ")))) {" + NL + "                                        whetherExist_";
  protected final String TEXT_348 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_349 = ".close();";
  protected final String TEXT_350 = NL + "\t\t\t\t            \tString tableForSearch_";
  protected final String TEXT_351 = " = ";
  protected final String TEXT_352 = ";" + NL + "\t\t\t\t            \tif(tableForSearch_";
  protected final String TEXT_353 = " != null){" + NL + "\t\t\t\t            \t\tif(tableForSearch_";
  protected final String TEXT_354 = ".startsWith(\"\\\"\") && tableForSearch_";
  protected final String TEXT_355 = ".endsWith(\"\\\"\")){" + NL + "\t\t\t\t            \t\t\ttableForSearch_";
  protected final String TEXT_356 = " =  tableForSearch_";
  protected final String TEXT_357 = ".substring(1,tableForSearch_";
  protected final String TEXT_358 = ".length()-1);" + NL + "\t\t\t\t            \t\t}else{" + NL + "\t\t\t\t            \t\t\ttableForSearch_";
  protected final String TEXT_359 = " =  tableForSearch_";
  protected final String TEXT_360 = ".toUpperCase();" + NL + "\t\t\t\t            \t\t}" + NL + "\t\t\t\t            \t}" + NL + "\t\t\t\t                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_361 = " = conn_";
  protected final String TEXT_362 = ".getMetaData();" + NL + "\t\t\t\t                java.sql.ResultSet rsTable_";
  protected final String TEXT_363 = " = dbMetaData_";
  protected final String TEXT_364 = ".getTables(null, conn_";
  protected final String TEXT_365 = ".getSchema(), tableForSearch_";
  protected final String TEXT_366 = ", new String[]{\"TABLE\"});" + NL + "\t\t\t\t                boolean whetherExist_";
  protected final String TEXT_367 = " = false;" + NL + "\t\t\t\t               \tif(rsTable_";
  protected final String TEXT_368 = ".next()) {" + NL + "\t\t\t\t\t\t\t\t\twhetherExist_";
  protected final String TEXT_369 = " = true;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t                rsTable_";
  protected final String TEXT_370 = ".close();" + NL + "\t\t\t\t            ";
  protected final String TEXT_371 = NL + "\t\t\t\t                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_372 = " = conn_";
  protected final String TEXT_373 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_374 = " = dbMetaData_";
  protected final String TEXT_375 = ".getTables(null, schemaForSearch_";
  protected final String TEXT_376 = ", null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_377 = " = false;" + NL + "                                while(rsTable_";
  protected final String TEXT_378 = ".next()) {" + NL + "                                    if(rsTable_";
  protected final String TEXT_379 = ".getString(\"TABLE_NAME\").equalsIgnoreCase(tableForSearch_";
  protected final String TEXT_380 = ")) {" + NL + "                                        whetherExist_";
  protected final String TEXT_381 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_382 = ".close();";
  protected final String TEXT_383 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_384 = " = conn_";
  protected final String TEXT_385 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_386 = " = dbMetaData_";
  protected final String TEXT_387 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_388 = " = false;" + NL + "                                while(rsTable_";
  protected final String TEXT_389 = ".next()) {" + NL + "                                    String table_";
  protected final String TEXT_390 = " = rsTable_";
  protected final String TEXT_391 = ".getString(\"TABLE_NAME\");" + NL + "                                    if(table_";
  protected final String TEXT_392 = ".equalsIgnoreCase(";
  protected final String TEXT_393 = ")) {" + NL + "                                        whetherExist_";
  protected final String TEXT_394 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_395 = ".close();";
  protected final String TEXT_396 = NL + "                                if(!whetherExist_";
  protected final String TEXT_397 = ") {" + NL + "                                    java.sql.Statement stmtCreate_";
  protected final String TEXT_398 = " = conn_";
  protected final String TEXT_399 = ".createStatement();";
  protected final String TEXT_400 = NL + "                                                      stmtCreate_";
  protected final String TEXT_401 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_402 = "));";
  protected final String TEXT_403 = NL + "                                            stmtCreate_";
  protected final String TEXT_404 = ".execute(((\"";
  protected final String TEXT_405 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_406 = ".";
  protected final String TEXT_407 = ", \"";
  protected final String TEXT_408 = "\")";
  protected final String TEXT_409 = ".toUpperCase()";
  protected final String TEXT_410 = ")+\")";
  protected final String TEXT_411 = "\"));";
  protected final String TEXT_412 = NL + "                                        stmtCreate_";
  protected final String TEXT_413 = ".execute(\"";
  protected final String TEXT_414 = ")\");";
  protected final String TEXT_415 = NL + "                                    stmtCreate_";
  protected final String TEXT_416 = ".close();" + NL + "                                }";
  protected final String TEXT_417 = NL + "                                if(whetherExist_";
  protected final String TEXT_418 = ") {" + NL + "                                    java.sql.Statement stmtDrop_";
  protected final String TEXT_419 = " = conn_";
  protected final String TEXT_420 = ".createStatement();";
  protected final String TEXT_421 = NL + "                                                      stmtDrop_";
  protected final String TEXT_422 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_423 = "));";
  protected final String TEXT_424 = NL + "                                    stmtDrop_";
  protected final String TEXT_425 = ".execute(\"";
  protected final String TEXT_426 = "\" ";
  protected final String TEXT_427 = ");";
  protected final String TEXT_428 = NL + "                                    stmtDrop_";
  protected final String TEXT_429 = ".close();";
  protected final String TEXT_430 = NL + "                                            conn_";
  protected final String TEXT_431 = ".commit();";
  protected final String TEXT_432 = NL + "                                }" + NL + "                                java.sql.Statement stmtCreate_";
  protected final String TEXT_433 = " = conn_";
  protected final String TEXT_434 = ".createStatement();";
  protected final String TEXT_435 = NL + "                                                  stmtCreate_";
  protected final String TEXT_436 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_437 = "));";
  protected final String TEXT_438 = NL + "                                        stmtCreate_";
  protected final String TEXT_439 = ".execute(((\"";
  protected final String TEXT_440 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_441 = ".";
  protected final String TEXT_442 = ", \"";
  protected final String TEXT_443 = "\")";
  protected final String TEXT_444 = ".toUpperCase()";
  protected final String TEXT_445 = ")+\")";
  protected final String TEXT_446 = "\"));";
  protected final String TEXT_447 = NL + "                                    stmtCreate_";
  protected final String TEXT_448 = ".execute(\"";
  protected final String TEXT_449 = ")\");";
  protected final String TEXT_450 = NL + "                                stmtCreate_";
  protected final String TEXT_451 = ".close();";
  protected final String TEXT_452 = NL + "                            GlobalResource.resourceMap.put(keyCheckTable_";
  protected final String TEXT_453 = ", true);" + NL + "            //{{{" + NL + "                        } // end of if" + NL + "                    } // end synchronized" + NL + "                }";
  protected final String TEXT_454 = NL + "            java.sql.Statement stmtClear_";
  protected final String TEXT_455 = " = conn_";
  protected final String TEXT_456 = ".createStatement();";
  protected final String TEXT_457 = NL + "                              stmtClear_";
  protected final String TEXT_458 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_459 = "));";
  protected final String TEXT_460 = NL + "            stmtClear_";
  protected final String TEXT_461 = ".executeUpdate(\"";
  protected final String TEXT_462 = "\");";
  protected final String TEXT_463 = NL + "            stmtClear_";
  protected final String TEXT_464 = ".close();";
  protected final String TEXT_465 = NL + "            java.sql.Statement stmtTruncCount_";
  protected final String TEXT_466 = " = conn_";
  protected final String TEXT_467 = ".createStatement();";
  protected final String TEXT_468 = NL + "                              stmtTruncCount_";
  protected final String TEXT_469 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_470 = "));";
  protected final String TEXT_471 = NL + "            java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_472 = " = stmtTruncCount_";
  protected final String TEXT_473 = ".executeQuery(\"";
  protected final String TEXT_474 = "\");" + NL + "            int rsTruncCountNumber_";
  protected final String TEXT_475 = " = 0;" + NL + "            if(rsTruncCount_";
  protected final String TEXT_476 = ".next()) {" + NL + "                rsTruncCountNumber_";
  protected final String TEXT_477 = " = rsTruncCount_";
  protected final String TEXT_478 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_479 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_480 = ".close();" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_481 = " = conn_";
  protected final String TEXT_482 = ".createStatement();";
  protected final String TEXT_483 = NL + "                              stmtTrunc_";
  protected final String TEXT_484 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_485 = "));";
  protected final String TEXT_486 = NL + "                conn_";
  protected final String TEXT_487 = ".commit();";
  protected final String TEXT_488 = NL + "            stmtTrunc_";
  protected final String TEXT_489 = ".executeUpdate(\"";
  protected final String TEXT_490 = "\");";
  protected final String TEXT_491 = NL + "                if(!conn_";
  protected final String TEXT_492 = ".getAutoCommit()){" + NL + "                    conn_";
  protected final String TEXT_493 = ".commit();" + NL + "                }";
  protected final String TEXT_494 = NL + "            deletedCount_";
  protected final String TEXT_495 = " += rsTruncCountNumber_";
  protected final String TEXT_496 = ";" + NL + "            stmtTrunc_";
  protected final String TEXT_497 = ".close();";
  protected final String TEXT_498 = NL + "            java.sql.Statement stmtTruncCount_";
  protected final String TEXT_499 = " = conn_";
  protected final String TEXT_500 = ".createStatement();" + NL + "            java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_501 = " = stmtTruncCount_";
  protected final String TEXT_502 = ".executeQuery(\"";
  protected final String TEXT_503 = "\");" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_504 = " = conn_";
  protected final String TEXT_505 = ".createStatement();";
  protected final String TEXT_506 = NL + "                conn_";
  protected final String TEXT_507 = ".commit();";
  protected final String TEXT_508 = NL + "            stmtTrunc_";
  protected final String TEXT_509 = ".executeUpdate(\"";
  protected final String TEXT_510 = "\");";
  protected final String TEXT_511 = NL + "            while(rsTruncCount_";
  protected final String TEXT_512 = ".next()) {" + NL + "                deletedCount_";
  protected final String TEXT_513 = " += rsTruncCount_";
  protected final String TEXT_514 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_515 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_516 = ".close();" + NL + "            stmtTrunc_";
  protected final String TEXT_517 = ".close();";
  protected final String TEXT_518 = NL + "\t\tresourceMap.put(\"conn_";
  protected final String TEXT_519 = "\", conn_";
  protected final String TEXT_520 = ");" + NL + "\t";
  protected final String TEXT_521 = NL + "        conn_";
  protected final String TEXT_522 = ".setAutoCommit(false);" + NL + "        int commitEvery_";
  protected final String TEXT_523 = " = ";
  protected final String TEXT_524 = ";" + NL + "        int commitCounter_";
  protected final String TEXT_525 = " = 0;" + NL;
  protected final String TEXT_526 = NL + "        String insert_";
  protected final String TEXT_527 = " = \"INSERT INTO [\" + tableName_";
  protected final String TEXT_528 = " + \"] (";
  protected final String TEXT_529 = ") VALUES (";
  protected final String TEXT_530 = ")\";";
  protected final String TEXT_531 = NL + "        java.sql.PreparedStatement pstmt_";
  protected final String TEXT_532 = " = conn_";
  protected final String TEXT_533 = ".prepareStatement(insert_";
  protected final String TEXT_534 = ");";
  protected final String TEXT_535 = NL;
  protected final String TEXT_536 = NL + "\t\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_537 = " = null;" + NL + "\t\tString keyPsmt_";
  protected final String TEXT_538 = " = conn_";
  protected final String TEXT_539 = " + \"[psmt]\" + \"[\" + ";
  protected final String TEXT_540 = " + \"]\";" + NL + "                        pstmt_";
  protected final String TEXT_541 = " = SharedDBPreparedStatement.getSharedPreparedStatement(conn_";
  protected final String TEXT_542 = ",insert_";
  protected final String TEXT_543 = ",keyPsmt_";
  protected final String TEXT_544 = ");";
  protected final String TEXT_545 = NL + "        String update_";
  protected final String TEXT_546 = " = \"UPDATE [\" + tableName_";
  protected final String TEXT_547 = " + \"] SET ";
  protected final String TEXT_548 = " WHERE ";
  protected final String TEXT_549 = "\";" + NL + "        java.sql.PreparedStatement pstmt_";
  protected final String TEXT_550 = " = conn_";
  protected final String TEXT_551 = ".prepareStatement(update_";
  protected final String TEXT_552 = ");";
  protected final String TEXT_553 = NL + "        java.sql.PreparedStatement pstmt_";
  protected final String TEXT_554 = " = conn_";
  protected final String TEXT_555 = ".prepareStatement(\"SELECT COUNT(1) FROM [\" + tableName_";
  protected final String TEXT_556 = " + \"] WHERE ";
  protected final String TEXT_557 = "\");" + NL + "        String insert_";
  protected final String TEXT_558 = " = \"INSERT INTO [\" + tableName_";
  protected final String TEXT_559 = " + \"] (";
  protected final String TEXT_560 = ") VALUES (";
  protected final String TEXT_561 = ")\";" + NL + "        java.sql.PreparedStatement pstmtInsert_";
  protected final String TEXT_562 = " = conn_";
  protected final String TEXT_563 = ".prepareStatement(insert_";
  protected final String TEXT_564 = ");" + NL + "        String update_";
  protected final String TEXT_565 = " = \"UPDATE [\" + tableName_";
  protected final String TEXT_566 = " + \"] SET ";
  protected final String TEXT_567 = " WHERE ";
  protected final String TEXT_568 = "\";" + NL + "        java.sql.PreparedStatement pstmtUpdate_";
  protected final String TEXT_569 = " = conn_";
  protected final String TEXT_570 = ".prepareStatement(update_";
  protected final String TEXT_571 = ");";
  protected final String TEXT_572 = NL + "        String update_";
  protected final String TEXT_573 = " = \"UPDATE [\" + tableName_";
  protected final String TEXT_574 = " + \"] SET ";
  protected final String TEXT_575 = " WHERE ";
  protected final String TEXT_576 = "\";" + NL + "        java.sql.PreparedStatement pstmtUpdate_";
  protected final String TEXT_577 = " = conn_";
  protected final String TEXT_578 = ".prepareStatement(update_";
  protected final String TEXT_579 = ");" + NL + "        String insert_";
  protected final String TEXT_580 = " = \"INSERT INTO [\" + tableName_";
  protected final String TEXT_581 = " + \"] (";
  protected final String TEXT_582 = ") VALUES (";
  protected final String TEXT_583 = ")\";" + NL + "        java.sql.PreparedStatement pstmtInsert_";
  protected final String TEXT_584 = " = conn_";
  protected final String TEXT_585 = ".prepareStatement(insert_";
  protected final String TEXT_586 = ");";
  protected final String TEXT_587 = NL + "        String delete_";
  protected final String TEXT_588 = " = \"DELETE FROM [\" + tableName_";
  protected final String TEXT_589 = " + \"] WHERE ";
  protected final String TEXT_590 = "\";" + NL + "        java.sql.PreparedStatement pstmt_";
  protected final String TEXT_591 = " = conn_";
  protected final String TEXT_592 = ".prepareStatement(delete_";
  protected final String TEXT_593 = ");";
  protected final String TEXT_594 = NL + "        java.sql.PreparedStatement pstmt_";
  protected final String TEXT_595 = " = conn_";
  protected final String TEXT_596 = ".prepareStatement(\"SELECT COUNT(1) FROM [\" + tableName_";
  protected final String TEXT_597 = " + \"] WHERE ";
  protected final String TEXT_598 = "\");" + NL + "        String insert_";
  protected final String TEXT_599 = " = \"INSERT INTO [\" + tableName_";
  protected final String TEXT_600 = " + \"] (";
  protected final String TEXT_601 = ") VALUES (";
  protected final String TEXT_602 = ")\";" + NL + "        java.sql.PreparedStatement pstmtInsert_";
  protected final String TEXT_603 = " = conn_";
  protected final String TEXT_604 = ".prepareStatement(insert_";
  protected final String TEXT_605 = ");";
  protected final String TEXT_606 = NL + NL + "    class BufferLine_";
  protected final String TEXT_607 = " {";
  protected final String TEXT_608 = NL + "                ";
  protected final String TEXT_609 = " ";
  protected final String TEXT_610 = ";";
  protected final String TEXT_611 = NL + NL + "        public BufferLine_";
  protected final String TEXT_612 = "(";
  protected final String TEXT_613 = NL + "                    ,";
  protected final String TEXT_614 = NL + "                ";
  protected final String TEXT_615 = " ";
  protected final String TEXT_616 = NL + "        ){";
  protected final String TEXT_617 = NL + "                    this.";
  protected final String TEXT_618 = " = ";
  protected final String TEXT_619 = ";";
  protected final String TEXT_620 = NL + "        }" + NL + "    }" + NL + "" + NL + "    java.util.List<BufferLine_";
  protected final String TEXT_621 = "> sInsertColValueList";
  protected final String TEXT_622 = " = new java.util.ArrayList();" + NL + "    BufferLine_";
  protected final String TEXT_623 = " sInsertColValue";
  protected final String TEXT_624 = " = null;" + NL + "" + NL + "    StringBuilder extendInsertValueStmt_";
  protected final String TEXT_625 = " = new StringBuilder();" + NL + "    for(int i=0;i < ";
  protected final String TEXT_626 = ";i++){" + NL + "         extendInsertValueStmt_";
  protected final String TEXT_627 = ".append(\"(";
  protected final String TEXT_628 = ")\");" + NL + "         if (i!=";
  protected final String TEXT_629 = "-1) extendInsertValueStmt_";
  protected final String TEXT_630 = ".append(\",\");" + NL + "    }" + NL + "" + NL + "\tString insert_";
  protected final String TEXT_631 = " = \"INSERT INTO \"+";
  protected final String TEXT_632 = "+\" (";
  protected final String TEXT_633 = ") VALUES \" + extendInsertValueStmt_";
  protected final String TEXT_634 = ".toString();" + NL + "" + NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_635 = " =  conn_";
  protected final String TEXT_636 = ".prepareStatement(insert_";
  protected final String TEXT_637 = ");" + NL + "" + NL + "    String insertColName";
  protected final String TEXT_638 = " = \"";
  protected final String TEXT_639 = "\";" + NL + "    String insertColValue";
  protected final String TEXT_640 = " =  \"";
  protected final String TEXT_641 = "\";" + NL + "    int rowCount";
  protected final String TEXT_642 = " = 0;";
  protected final String TEXT_643 = NL + "        StringBuffer query_";
  protected final String TEXT_644 = " = null;" + NL + "       \t";
  protected final String TEXT_645 = NL + "\t\t \tString[] insertSQLSplits_";
  protected final String TEXT_646 = " = insert_";
  protected final String TEXT_647 = ".split(\"\\\\?\");";
  protected final String TEXT_648 = NL + "\t\t\tupdate_";
  protected final String TEXT_649 = " += \" \";" + NL + "\t    \tString[] updateSQLSplits_";
  protected final String TEXT_650 = " = update_";
  protected final String TEXT_651 = ".split(\"\\\\?\");";
  protected final String TEXT_652 = NL + "\t\t\tupdate_";
  protected final String TEXT_653 = " += \" \";" + NL + "\t\t\tString[] updateSQLSplits_";
  protected final String TEXT_654 = " = update_";
  protected final String TEXT_655 = ".split(\"\\\\?\");" + NL + "\t\t\tString[] insertSQLSplits_";
  protected final String TEXT_656 = " = insert_";
  protected final String TEXT_657 = ".split(\"\\\\?\");";
  protected final String TEXT_658 = NL + "\t\t\tdelete_";
  protected final String TEXT_659 = " += \" \";" + NL + "\t\t   \tString[] deleteSQLSplits_";
  protected final String TEXT_660 = " = delete_";
  protected final String TEXT_661 = ".split(\"\\\\?\");";
  protected final String TEXT_662 = NL + "\t\t\treplace_";
  protected final String TEXT_663 = " += \" \";" + NL + "\t\t\tString[] replaceSQLSplits_";
  protected final String TEXT_664 = " = replace_";
  protected final String TEXT_665 = ".split(\"\\\\?\");";
  protected final String TEXT_666 = NL + "\t\t\tinsertIgnore_";
  protected final String TEXT_667 = " += \" \";" + NL + "\t\t\tString[] insertIgnoreSQLSplits_";
  protected final String TEXT_668 = " = insertIgnore_";
  protected final String TEXT_669 = ".split(\"\\\\?\");";
  protected final String TEXT_670 = NL + "\t\t \tString[] insertSQLSplits_";
  protected final String TEXT_671 = " = insert_";
  protected final String TEXT_672 = ".split(\"\\\\?\");";
  protected final String TEXT_673 = NL + " \tboolean isShareIdentity_";
  protected final String TEXT_674 = " = globalMap.get(\"shareIdentitySetting_";
  protected final String TEXT_675 = "\") != null && (Boolean)globalMap.get(\"shareIdentitySetting_";
  protected final String TEXT_676 = "\") == true;";
  protected final String TEXT_677 = NL + "        java.sql.Statement stmt_";
  protected final String TEXT_678 = " = conn_";
  protected final String TEXT_679 = ".createStatement();";
  protected final String TEXT_680 = NL + "\t        if ( !isShareIdentity_";
  protected final String TEXT_681 = " ) {" + NL + "\t        \tstmt_";
  protected final String TEXT_682 = ".execute(\"SET IDENTITY_INSERT [\"+ tableName_";
  protected final String TEXT_683 = " +\"] ON\");" + NL + "\t        }";
  protected final String TEXT_684 = NL + "     \t\tstmt_";
  protected final String TEXT_685 = ".execute(\"SET IDENTITY_INSERT [\"+ tableName_";
  protected final String TEXT_686 = " +\"] ON\");" + NL + "     \t";
  protected final String TEXT_687 = NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_688 = " =null;" + NL + "\tjava.sql.PreparedStatement pstmtInsert_";
  protected final String TEXT_689 = " =null;" + NL + "\tjava.sql.PreparedStatement pstmtUpdate_";
  protected final String TEXT_690 = " =null;" + NL + "\t";
  protected final String TEXT_691 = NL + "\t\tStringBuffer query_";
  protected final String TEXT_692 = " = null;" + NL + "\t\t";
  protected final String TEXT_693 = NL + "\t\t \tString[] insertSQLSplits_";
  protected final String TEXT_694 = " = null;";
  protected final String TEXT_695 = NL + "\t    \tString[] updateSQLSplits_";
  protected final String TEXT_696 = " =  null;";
  protected final String TEXT_697 = NL + "\t\t\tString[] updateSQLSplits_";
  protected final String TEXT_698 = " = null;" + NL + "\t\t\tString[] insertSQLSplits_";
  protected final String TEXT_699 = " = null;";
  protected final String TEXT_700 = NL + "\t\t   \tString[] deleteSQLSplits_";
  protected final String TEXT_701 = " = null;";
  protected final String TEXT_702 = NL + "\t\t\tString[] replaceSQLSplits_";
  protected final String TEXT_703 = " = null;";
  protected final String TEXT_704 = NL + "\t\t\tString[] insertIgnoreSQLSplits_";
  protected final String TEXT_705 = " = null;";
  protected final String TEXT_706 = NL + "\t\t \tString[] insertSQLSplits_";
  protected final String TEXT_707 = " = null;";
  protected final String TEXT_708 = NL;

    public static final String INSERT_COLUMN_NAME = "insertColName";
    public static final String INSERT_VALUE_STMT = "insertValueStmt";
    public static final String UPDATE_SET_STMT = "updateSetStmt";
    public static final String UPDATE_WHERE_STMT = "updateWhereStmt";
    public static final String DELETE_WHERE_STMT = "deleteWhereStmt";
    public static final String FIRST_UPDATE_KEY = "firstUpdateKeyColumn";
    public static final String FIRST_DELETE_KEY = "firstDeleteKeyColumn";
    public static final String FIRST_INSERT_COLUMN = "firstInsertColumn";
    public static final String FIRST_UPDATE_COLUMN = "firstUpdateColumn";
    public static final int NORMAL_TYPE = 0;
    public static final int INSERT_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final String ACCESS = "access_id";
    public static final String AS400 = "as400_id";
    public static final String DB2 = "ibmdb2_id";
    public static final String FIREBIRD = "firebird_id";
    public static final String GREENPLUM = "greenplum_id";
    public static final String HSQLDB = "hsqldb_id";
    public static final String HIVE = "hive_id";
    public static final String INFORMIX = "informix_id";
    public static final String INGRES = "ingres_id";
    public static final String VECTORWISE = "vectorwise_id";
    public static final String INTERBASE = "interbase_id";
    public static final String JAVADB = "javadb_id";
    public static final String MAXDB = "maxdb_id";
    public static final String MSSQL = "id_MSSQL";
    public static final String MYSQL = "mysql_id";
    public static final String NETEZZA = "netezza_id";
    public static final String ORACLE = "oracle_id";
    public static final String PARACCEL = "paraccel_id";
    public static final String POSTGRESQL = "postgres_id";
    public static final String REDSHIFT = "redshift_id";
    public static final String POSTGREPLUS = "postgresplus_id";
    public static final String SQLITE = "sqlite_id";
    public static final String SYBASE = "sybase_id";
    public static final String SNOWFLAKE = "snowflake_id";
    public static final String TERADATA = "teradata_id";
    public static final String VERTICA = "vertica_id";
    public static final String ODBC = "MSODBC";
    public static final String JDBC = "JDBC";
    public static final String EXASOL = "Exasol_id";
    public static final String SAPHANA = "saphana_id";
    private static Map<String, Manager> managerMap = new HashMap<String, Manager>();
    public class Column {
        IMetadataColumn column;
        String name;
        String dataType;
        String operator;
        String columnName;
        String sqlStmt;
        String value;
        boolean addCol;
        boolean isKey;
        boolean isAutoIncrement;
        int startValue;
        int step;
        boolean isUpdateKey;
        boolean isDeleteKey;
        boolean insertable = true;
        boolean updatable = true;
        List<Column> replacement = new ArrayList<Column>();
        
        boolean isDynamic = false;
        
        public Column(String colName, String sqlStmt, boolean addCol) {
            this.column = null;
            this.name = colName;
            this.columnName = colName;
            this.sqlStmt = sqlStmt;
            this.value = "?";
            this.addCol = addCol;
        }
        public Column(IMetadataColumn column) {
            this.column = column;
            this.name = column.getLabel();
            this.sqlStmt = "?";
            this.value = "?";
            this.addCol = false;
            this.columnName = column.getOriginalDbColumnName();
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            this(column, isKey, useFieldOptions, fieldOption);
            if(isSpecifyIdentityKey) {
                if(column.getLabel().equals(identityKey)) {
                    isAutoIncrement = false;
                    this.startValue = startValue;
                    this.step = step;
                }
            }
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption) {
            this(column);
            this.isKey = isKey;
            if(useFieldOptions) {
                this.isUpdateKey = fieldOption.get("UPDATE_KEY").equals("true");
                this.isDeleteKey = fieldOption.get("DELETE_KEY").equals("true");
                this.insertable = fieldOption.get("INSERTABLE").equals("true");
                this.updatable = fieldOption.get("UPDATABLE").equals("true");                
            } else {
                this.insertable = true;
                if (isKey) {
                    this.isUpdateKey = true;
                    this.isDeleteKey = true;
                    this.updatable = false;
                }
                else {
                    this.isUpdateKey = false;
                    this.isDeleteKey = false;
                    this.updatable = true;
                }                
            }
        }
        public boolean isReplaced() {
            return replacement.size() > 0;
        }
        public void replace(Column column) {
            this.replacement.add(column);
        }
        public List<Column> getReplacement() {
            return this.replacement;
        }
        public void setColumn(IMetadataColumn column) {
            this.column = column;
        }
        public IMetadataColumn getColumn() {
            return this.column;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }
        public String getColumnName() {
            return this.columnName;
        }
        public void setIsAddCol(boolean isadd) {
            this.addCol = isadd;
        }
        public boolean isAddCol() {
            return this.addCol;
        }
        public void setSqlStmt(String sql) {
            this.sqlStmt = sql;
        }
        public String getSqlStmt() {
            if(this.getColumn()!=null) {
                if (this.getColumn().getTalendType().equals("id_Geometry")) {
                    
                    if ("MDSYS.SDO_GEOMETRY".equalsIgnoreCase(this.getColumn().getType())) {
                        return "?";
                    } else {
                        return "GeomFromText(?, ?)";    // For PostGIS
                    }
                } else {
                    return this.sqlStmt;
                }
            } else {
                return this.sqlStmt;
            }
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }
        public void setDataType(String dataType) {
            this.dataType = dataType;
        }
        public String getDataType() {
            return dataType;
        }
        public void setOperator(String operator) {
            this.operator = operator;
        }
        public String getOperator() {
            return operator;
        }
        public boolean isAutoIncrement() {
            return this.isAutoIncrement;
        }
        public void setAutoIncrement(boolean isAutoIncrement) {
            this.isAutoIncrement = isAutoIncrement;
        }
        public int getStartValue() {
            return this.startValue;
        }
        public void setStartValue(int startValue) {
            this.startValue = startValue;
        }
        public int getStep() {
            return this.step;
        }
        public void setStep(int step) {
            this.step = step;
        }
        public boolean isKey() {
            return this.isKey;
        }
        public void setKey(boolean isKey) {
            this.isKey = isKey;
        }
        public boolean isUpdateKey() {
            return this.isUpdateKey;
        }
        public void setUpdateKey(boolean isUpdateKey) {
            this.isUpdateKey = isUpdateKey;
        }
        public boolean isDeleteKey() {
            return this.isDeleteKey;
        }
        public void setDeleteKey(boolean isDeleteKey) {
            this.isDeleteKey = isDeleteKey;
        }
        public boolean isInsertable() {
            return this.insertable;
        }
        public void setInsertable(boolean insertable) {
            this.insertable = insertable;
        }
        public boolean isUpdatable() {
            return this.updatable;
        }
        public void setUpdatable(boolean updatable) {
            this.updatable = updatable;
        }
        
        public boolean isDynamic() {
            return isDynamic;
        }
        
        public void setDynamic(boolean isDynamic) {
            this.isDynamic = isDynamic;
        }
    }
        
    public Column getColumn(IMetadataColumn column) {
        return new Column(column);
    }

    public Column getColumn(String colName, String sqlStmt, boolean addCol) {
        return new Column(colName, sqlStmt, addCol);
    }
    
    public Column getColumn(IMetadataColumn column, boolean isKey, boolean useFieldsOptions, Map<String, String> fieldOption) {
        return new Column(column, isKey, useFieldsOptions, fieldOption);
    }

    public abstract class Manager {
        
        protected INode node;// add the Node, it will be more convenient
        public void setNode(INode node) {
           this.node = node;
        }
        
        protected String cid;        
        protected abstract String getDBMSId();
        protected abstract String getLProtectedChar();
        protected abstract String getRProtectedChar();        
        public Manager() {}
        public Manager(String cid) {
            this.cid = cid;
        }
      protected  String getLProtectedChar(String columName) {
          return getLProtectedChar();
      }
      protected  String getRProtectedChar(String columName) {
          return getRProtectedChar();        
      }
      protected boolean contaionsSpaces(String columnName) {
          if (columnName != null) {
              if (columnName.startsWith("\" + ") && columnName.endsWith(" + \"")) {
                  return false;
              }
              
              if (columnName.contains(" ")) {
                  return true;
              }
              // minus are also a problem
              if (columnName.contains("-")) {
                  return true;
              }
          }
          return false;
      }

        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(1) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }
        public String getDeleteTableSQL() {
            StringBuilder deleteTableSQL = new StringBuilder();
            deleteTableSQL.append("DELETE FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return deleteTableSQL.toString();
        }
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return truncateTableSQL.toString();
        }
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE " + getRProtectedChar());
            return truncate_reuse_stroage_TableSQL.toString();
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else if(ORACLE.equalsIgnoreCase(getDBMSId()) && dataType.matches("TIMESTAMP WITH TIME ZONE")){
                            createSQL.append("TIMESTAMP("+length+") WITH TIME ZONE");
                        }else{                            
                            createSQL.append(dataType);
                        }
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (((MYSQL.equalsIgnoreCase(getDBMSId()))||(AS400.equalsIgnoreCase(getDBMSId())))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else if ((SNOWFLAKE.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("NUMBER".equalsIgnoreCase(dataType)))||("VARCHAR".equalsIgnoreCase(dataType))
                                    || ("CHAR".equalsIgnoreCase(dataType))||(("CHARACTER".equalsIgnoreCase(dataType)))||("STRING".equalsIgnoreCase(dataType))|| ("TEXT".equalsIgnoreCase(dataType))
                                    ||(("BINARY".equalsIgnoreCase(dataType)))||("VARBINARY".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            // move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                            if(MYSQL.equalsIgnoreCase(getDBMSId()) ) {
                                String columnStr = getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() );
                                int index = pkList.indexOf(columnStr);
                                if(index !=-1){
                                    for (int i=index;i>0;i--) {
                                        pkList.set(i, pkList.get(i-1));
                                    }
                                    pkList.set(0, columnStr);
                                }
                            }
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            if(DB2.equalsIgnoreCase(getDBMSId())&&column.isKey()){
                            	createSQL.append(" not null ");
                            }else{
                                createSQL.append(setNullable(column.getColumn().isNullable()));
                            }
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
        
        protected String getLengthStringRepresentation(String dataType, Integer length) {
        	return String.valueOf(length);
    	}
    
        protected String getAutoIncrement(int startValue, int step) {
            if(SYBASE.equalsIgnoreCase(getDBMSId()) || EXASOL.equalsIgnoreCase(getDBMSId())){
                return " IDENTITY NOT NULL";
            } else if(MYSQL.equalsIgnoreCase(getDBMSId()) ) {
                return " AUTO_INCREMENT";
            } else if(DB2.equalsIgnoreCase(getDBMSId())){
                return " Generated by default AS IDENTITY(START WITH "+startValue+", INCREMENT BY "+step+", NO CACHE )";
            } else if(TERADATA.equalsIgnoreCase(getDBMSId())){
                return " generated by default as identity (start with " + startValue + " increment by " + step + " no cycle) not null";
            }else {
                return " IDENTITY (" + startValue + ", " + step + ") NOT NULL";
            }
        }
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return "";
            }
        }
        protected String setDefaultValue(String defaultValue, String columnType) {
            if (defaultValue == null || defaultValue.equals("\"\"") || defaultValue.equals("")) {
                return " ";
            } else if ((defaultValue.startsWith("\"") || defaultValue.startsWith("'"))
                    && (defaultValue.endsWith("\"") || defaultValue.endsWith("'"))) {
                return " default '" + defaultValue.substring(1, defaultValue.length() - 1) + "' ";
            } else if (defaultValue.equalsIgnoreCase("null")) {
                return " default null ";
            } else {
                return " default " + defaultValue + " ";
            }
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() + ", " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();
        }

        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            List<Column> stmtStructure = createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
            if(isSpecifyIdentityKey) {
                for(Column column : stmtStructure) {
                    if(column.name.equals(identityKey)) {
                        column.setAutoIncrement(true);
                        column.setStartValue(startValue);
                        column.setStep(step);
                        break;
                    }
                }
            }
            return stmtStructure;
        }
        
        private boolean dynamicColumnIsReplaced = false;
        
        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols) {
            List<Column> stmtStructure = new ArrayList<Column>();            
            for(IMetadataColumn column : columnList) {
                Map<String, String> fieldOption = null;
                if(fieldOptions != null && fieldOptions.size() > 0) {
                    for(Map<String, String> tmpFieldOption : fieldOptions) {
                        if(column.getLabel().equals(tmpFieldOption.get("SCHEMA_COLUMN"))) {
                            fieldOption = tmpFieldOption;
                            break;
                        }
                    }
                }
                
                Column skeletonColumn = getColumn(column, column.isKey(), useFieldOptions, fieldOption);
                skeletonColumn.setOperator("=");
                skeletonColumn.setDataType(column.getType());
                stmtStructure.add(skeletonColumn);
                
                if("id_Dynamic".equals(column.getTalendType())) {
                    skeletonColumn.setDynamic(true);
                }
            }
            
            dynamicColumnIsReplaced = false;
            
            if(addCols != null && addCols.size() > 0) {
                for(IMetadataColumn column : columnList) {
                    for(Map<String, String> additionColumn : addCols) {
                        if(additionColumn.get("REFCOL").equals(column.getLabel())) {
                            int stmtIndex = 0;
                            for(Column stmtStr : stmtStructure){          
                                if(stmtStr.getName().equals(additionColumn.get("REFCOL"))) {
                                    break;
                                }
                                stmtIndex++;
                            }           
                            if(additionColumn.get("POS").equals("AFTER")) {
                                Column insertAfter = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertAfter.setDataType(additionColumn.get("DATATYPE"));
                                insertAfter.setOperator("=");
                                stmtStructure.add(stmtIndex+1, insertAfter);
                            } else if(additionColumn.get("POS").equals("BEFORE")) {
                                Column insertBefore = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertBefore.setDataType(additionColumn.get("DATATYPE"));
                                insertBefore.setOperator("=");
                                stmtStructure.add(stmtIndex, insertBefore);
                            } else if(additionColumn.get("POS").equals("REPLACE")) {
                                Column replacementCol = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                replacementCol.setDataType(additionColumn.get("DATATYPE"));
                                replacementCol.setOperator("=");                                
                                Column replacedCol = (Column) stmtStructure.get(stmtIndex);
                                replacementCol.setKey(replacedCol.isKey());
                                replacementCol.setUpdateKey(replacedCol.isUpdateKey());
                                replacementCol.setDeleteKey(replacedCol.isDeleteKey());
                                replacementCol.setUpdatable(replacedCol.isUpdatable());
                                replacementCol.setInsertable(replacedCol.isInsertable());
                                replacedCol.replace(replacementCol);
                                
                                if(replacedCol.isDynamic()) {
                                    dynamicColumnIsReplaced = true;
                                }
                            }                            
                        }
                    }
                }
            }
            
            return stmtStructure;
        }
        
        public boolean isDynamicColumnReplaced() {
            return dynamicColumnIsReplaced;
        }
        
        public Map<String, StringBuilder> createProcessSQL(List<Column> stmtStructure) {
            Map<String, StringBuilder> actionSQLMap = new HashMap<String, StringBuilder>();
            if(stmtStructure==null || stmtStructure.size() < 1) {
                actionSQLMap.put(INSERT_COLUMN_NAME, new StringBuilder());
                actionSQLMap.put(INSERT_VALUE_STMT, new StringBuilder());
                actionSQLMap.put(UPDATE_SET_STMT, new StringBuilder());
                actionSQLMap.put(UPDATE_WHERE_STMT, new StringBuilder());
                actionSQLMap.put(DELETE_WHERE_STMT, new StringBuilder());
                actionSQLMap.put(FIRST_UPDATE_KEY, new StringBuilder());
                actionSQLMap.put(FIRST_DELETE_KEY, new StringBuilder());
                actionSQLMap.put(FIRST_INSERT_COLUMN, new StringBuilder());
                actionSQLMap.put(FIRST_UPDATE_COLUMN, new StringBuilder());
            } else {
                for(Column column : stmtStructure) {
                    if(column.isReplaced()) {
                        List<Column> replacedColumns = column.getReplacement();
                        for(Column replacedColumn : replacedColumns) {
                            actionSQLMap = processSQLClause(replacedColumn, actionSQLMap);
                        }
                    } else {
                        actionSQLMap = processSQLClause(column, actionSQLMap);        
                    }
                }
            }
            return actionSQLMap;
        }
        
        private boolean isSpecifyIdentityKey = false;
        
        public void setIsSpecifyIdentityKey(boolean isSpecifyIdentityKey) {
            this.isSpecifyIdentityKey = isSpecifyIdentityKey;
        }
        
        private Map<String, StringBuilder> processSQLClause(Column column, Map<String, StringBuilder> actionSQLMap) {
            StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);
            if(insertColName == null) {
                insertColName = new StringBuilder();
            }
            StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);
            if(insertValueStmt == null) {
                insertValueStmt = new StringBuilder();
            }
            StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);
            if(updateSetStmt == null) {
                updateSetStmt = new StringBuilder(); 
            }
            StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
            if(updateWhereStmt == null) {
                updateWhereStmt = new StringBuilder();
            }
            StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
            if(deleteWhereStmt == null) {
                deleteWhereStmt = new StringBuilder();
            }
            StringBuilder firstUpdateKeyColumn = actionSQLMap.get(FIRST_UPDATE_KEY);
            if(firstUpdateKeyColumn == null) {
                firstUpdateKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstDeleteKeyColumn = actionSQLMap.get(FIRST_DELETE_KEY);
            if(firstDeleteKeyColumn == null) {
                firstDeleteKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstInsertColumn = actionSQLMap.get(FIRST_INSERT_COLUMN);
            if(firstInsertColumn == null) {
                firstInsertColumn = new StringBuilder("true");
            }
            StringBuilder firstUpdateColumn = actionSQLMap.get(FIRST_UPDATE_COLUMN);
            if(firstUpdateColumn == null) {
                firstUpdateColumn = new StringBuilder("true");
            }
            String suffix = null;
            String separate = null;
            String identityKey = ElementParameterParser.getValue(node, "__IDENTITY_FIELD__");
            if(!(isSpecifyIdentityKey && (column.getName().equals(identityKey))) && column.isInsertable() && !column.isDynamic()) {
                if(firstInsertColumn.toString().equals("true")) {
                    suffix = "";
                    firstInsertColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                insertColName.append(suffix);
                insertColName.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()));
                insertValueStmt.append(suffix);
                insertValueStmt.append(column.getSqlStmt());
            }
            if(column.isUpdatable() && !column.isDynamic()) {
                if(firstUpdateColumn.toString().equals("true")) {
                    suffix = "";
                    firstUpdateColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                updateSetStmt.append(suffix);
                updateSetStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " " + column.getOperator() + " " + column.getSqlStmt());
            }
            if(column.isDeleteKey() && !column.isDynamic()) {
                if(firstDeleteKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstDeleteKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                deleteWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(deleteWhereStmt, column);                 
            }
            if(column.isUpdateKey() && !column.isDynamic()) {
                if(firstUpdateKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstUpdateKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                updateWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(updateWhereStmt, column);                
                                            
            }
            actionSQLMap.put(INSERT_COLUMN_NAME, insertColName);
            actionSQLMap.put(INSERT_VALUE_STMT, insertValueStmt);
            actionSQLMap.put(UPDATE_SET_STMT, updateSetStmt);
            actionSQLMap.put(UPDATE_WHERE_STMT, updateWhereStmt);
            actionSQLMap.put(DELETE_WHERE_STMT, deleteWhereStmt);
            actionSQLMap.put(FIRST_UPDATE_KEY, firstUpdateKeyColumn);
            actionSQLMap.put(FIRST_DELETE_KEY, firstDeleteKeyColumn);
            actionSQLMap.put(FIRST_INSERT_COLUMN, firstInsertColumn);
            actionSQLMap.put(FIRST_UPDATE_COLUMN, firstUpdateColumn);
            return actionSQLMap;
        }
        public String getGenerateType(String typeToGenerate) {
            if(typeToGenerate.equals("byte[]")) {
                typeToGenerate = "Bytes";
            } else if(typeToGenerate.equals("java.util.Date")) {
                typeToGenerate = "Date";
            } else if(typeToGenerate.equals("Integer")) {
                typeToGenerate = "Int";
            } else if(typeToGenerate.equals("List")) {  
                typeToGenerate = "Object";                 
            } else {
                typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
            return typeToGenerate;
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType) {
            return generateSetStmt(typeToGenerate, dbType, column, index, incomingConnName, cid, actionType, null); 
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                    
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic + ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");                
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }
            else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();            
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType) {
            return generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, actionType, null); 
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        // @Deprecated : see bug8551
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt) {
            String replaceStr = null;
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " +  replaceStr + ")";
            }else {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ")";
            }
            
                
        }
        
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit);
        }
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            String replaceStr = null;
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                    if (index == 1 && dynCol == null) {
                        return  stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +  replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                    } else {
                        return  stmt + cid + ".append(" +  replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                    }
            }else {
                if (index == 1 && dynCol == null) {
                    return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                } else {
                    return stmt + cid + ".append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                }
            }
        }
        
        //feature:2880 @6980 in debug mode
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit, replaceFixedStr);
        }
        
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if (index == 1 && dynCol == null) {
                return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +replaceFixedStr+ ").append("+sqlSplit+cid+"["+index+"])";
            } else {
                return stmt + cid + ".append(" +replaceFixedStr+").append("+sqlSplit+cid+"["+dynamicIndex+"])";
            }
        }
        
        //extract a method for feature:2880, it is a default implement, need every tDBOutput to implement it, if it really want to support the "whereNULL" issue
        //@see: the implement of MSSQLManager
        //feature:2880 @6980
        //i.e: 
        //1.select * FROM user where ((true = true AND name is NULL) OR name = ?);
        //2.select * FROM user where ((true = false AND name is NULL) OR name = ?);
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;

            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn()!=null && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
        // for feature:2880, it will consider the "whereNULL" issue in the generated code.
        // @Deprecated: because the "index" with a small problem when increase it.
        private String generateSetStmt_4_whereSupportNull(String typeToGenerate, Column column, int index,
                String incomingConnName, String cid, int actionType) {

            boolean whereSupportNull = false;

            // if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }

            StringBuilder setStmt = new StringBuilder();

            // the 3 conditions are important
            if (column.isUpdateKey() && whereSupportNull && column.getColumn().isNullable()) {
                setStmt.append(generateSetBooleanForNullableKeyStmt(column, index, incomingConnName, cid, NORMAL_TYPE));
            }

            // the old behave
            setStmt.append(generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, NORMAL_TYPE));

            return setStmt.toString();
        }

        protected String generateSetBooleanForNullableKeyStmt(String dynCol,Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            //TODO generate setXXXX code according to each db .
            setStmt.append(prefix + cid + ".setInt(" + dynamicIndex + ",  ((" + incomingConnName + "." + column.getName() + "==null)?1:0));\r\n");
            return setStmt.toString();
        } 
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            return generateSetBooleanForNullableKeyStmt(null, column, index, incomingConnName, cid, actionType);
        }     
        
        public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, 
                String fieldDelimiter, 
                String newLineChar,
                String nullIndicator) {
        return null;
            
        }
        
        public String generateCode4TabelExist() {
            boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
            String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
            StringBuilder code = new StringBuilder();  
            code.append("String tableNameForSearch_" + cid + "= " + getTableName4Search(useExistingConnection, connection) + ";\r\n");
            if (hasSchema()) {
                code.append("String dbschemaForSearch_" + cid + "= null;\r\n");
                code.append("if(dbschema_" + cid + "== null || dbschema_" + cid + ".trim().length() == 0) {\r\n");
                code.append("dbschemaForSearch_" + cid + "= " + getUserName4Search(useExistingConnection, connection)+ ";\r\n");
                code.append("} else {\r\n");
                code.append("dbschemaForSearch_" + cid + "= " + getShemaName4Search(useExistingConnection, connection)+ ";\r\n");
                code.append("}\r\n");
            }
            return code.toString();
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + " + ElementParameterParser.getValue(node,"__TABLE__") +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }

        /*
         * maybe some db need add getLProtectedChar() and getRProtectedChar() to schema name.
         * this because of some db default add getLProtectedChar() and getRProtectedChar() to schema when create table. e.g:db2
         * 
         * in fact the db add getLProtectedChar() and getRProtectedChar() to scheam when create table that is wrong
        */
        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }   
        
        protected boolean hasSchema() {
            return false;
        }
        
    }
    
    public class AS400Manager extends Manager {
        public AS400Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return AS400;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class AccessManager extends Manager {
        public AccessManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ACCESS;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }   
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else {
                if (typeToGenerate.equals("Long")) {
                    setStmt.append(prefix + cid + ".setBigDecimal(" + index + ",new BigDecimal(" + incomingConnName + "." + column.getName() + "));\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class DB2Manager extends Manager {
        public DB2Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return DB2;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }       
        
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " IMMEDIATE");
            return truncateTableSQL.toString();
        }
        
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE IMMEDIATE");
            return truncate_reuse_stroage_TableSQL.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            // try to build a sql like 
            // update customers a 
            // set (city_name,customer_type)=(select b.city_name,b.customer_type 
            //        from tmp_cust_city b 
            //        where b.customer_id=a.customer_id) // wheresub
            //        where exists (select 1 
            //        from tmp_cust_city b
            //        where b.customer_id=a.customer_id
            //        )
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class FirebirdManager extends Manager {
        public FirebirdManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return FIREBIRD;
        }
        protected String getLProtectedChar() {
            return " ";
        }
        protected String getRProtectedChar() {
            return " ";
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if ((MYSQL.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            
            // add VectorWise option
            if (VECTORWISE.equalsIgnoreCase(getDBMSId())){
                createSQL.append("WITH STRUCTURE = VECTORWISE");
            }
            
            return createSQL.toString();
        }
                
    }
    
    public class HSQLDBManager extends Manager {
        String [] hsqldbKeyWords = {};
        public HSQLDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HSQLDB;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHSQLDBKeyword (String keyword) {
            for (int i=0 ; i < hsqldbKeyWords.length ; i++){
                if (hsqldbKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isHSQLDBKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isHSQLDBKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
    }
    
    public class HiveManager extends Manager {
        String [] hiveKeyWords = {};
        public HiveManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HIVE;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHiveKeyword (String keyword) {
            for (int i=0 ; i < hiveKeyWords.length ; i++){
                if (hiveKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isHiveKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isHiveKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
    }
    
    public class InformixManager extends Manager {
        public InformixManager(String cid) {
            super(cid);
        }
        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(*) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }        
        protected String getDBMSId() {
            return INFORMIX;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class IngresManager extends Manager {
        boolean isTrimSpace = true;
        public IngresManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INGRES;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }  
        protected boolean getTrimSpace() {
            return isTrimSpace;
        }
        protected boolean setTrimSpace(boolean isTrimSpace) {
            this.isTrimSpace = isTrimSpace;
            return isTrimSpace;
        }
        
        public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, String fieldDelimiter, 
                String recordDelimiter, String nullIndicator) {     
            StringBuilder copyBulkSQL = new StringBuilder();
            copyBulkSQL.append("COPY TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            copyBulkSQL.append(" (\"+");                
            int counter = 0;
            for(IMetadataColumn column : columnList) {
                counter++;
                // add each table field and separator
                copyBulkSQL.append( 
                "\n\"\\n" +
                  column.getOriginalDbColumnName() 
                + "="
                + (!getTrimSpace() && ("VARCHAR".equalsIgnoreCase(column.getType()) || "NVARCHAR".equalsIgnoreCase(column.getType()) || "TEXT".equalsIgnoreCase(column.getType())) ? "text(0)" : "char(0)"));
            
                // add these only if not last entry
                if (counter < columnList.size()){
                    copyBulkSQL.append(
                    //convertDelim(fieldDelimiter)
                    "\"+field_delimiter_"+cid +"+\""
                    + (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
                    + " ,"
                    + "\""
                    + "+"
                    );
                } else {
                    copyBulkSQL.append(
                    recordDelimiter
                    + (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
                    );
                    copyBulkSQL.append(")");
                }       
            } 
            return copyBulkSQL.toString();
        } 

        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("MODIFY " + getLProtectedChar() + "\" + tableName_" 
            + cid + " + \"\\\" TO TRUNCATED");
            return truncateTableSQL.toString();
        }                       
    }
    
    public class VectorWiseManager extends IngresManager {
        public VectorWiseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VECTORWISE;
        }
    }   
    
    public class InterbaseManager extends Manager {
        public InterbaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INTERBASE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class JavaDBManager extends Manager {
        public JavaDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JAVADB;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class MaxDBManager extends Manager {
        public MaxDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MAXDB;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MSSQLManager extends Manager {
        public MSSQLManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MSSQL;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        } 
       
        protected String getColumnIsNullCondition() {
            return "0x1";
        }
        
        protected String generateSetBooleanForNullableKeyStmt(String dynCol,Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setBoolean(" + dynamicIndex + ", (" + incomingConnName + "." + column.getName()
                    + "==null));\r\n");
            return setStmt.toString();
        } 
        
        public String generateSetStmt(String typeToGenerate, String ignoreDateOutOfRange, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                String dbType = column.getColumn().getType();
                if(dbType==null || "".equals(dbType)){
                    MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
                    dbType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                }
                if("true".equals(ignoreDateOutOfRange) &&("DATE".equals(dbType) || "DATETIME2".equals(dbType) || "DATETIMEOFFSET".equals(dbType))){                    
                    String pattern = column.getColumn().getPattern();
                    setStmt.append("if(" + incomingConnName + "." + column.getName() +"!=null && "+ incomingConnName + "." + column.getName() + ".getTime() < year2_"+cid+"){");
                    if("DATETIMEOFFSET".equals(dbType)) {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDatetimeoffset("+incomingConnName+"."+column.getName()+"));\r\n");
                    } else {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDate("+pattern+", "+incomingConnName+"."+column.getName()+"));\r\n");
                    }
                    setStmt.append("}else{\r\n");
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                    if("DATETIMEOFFSET".equals(dbType)) {
                        setStmt.append(",calendar_datetimeoffset_").append(cid);
                    }
                    setStmt.append(");\r\n");
                    setStmt.append("}\r\n");
                }else if("TIME".equals(dbType)){//TDI-30431 begin
                    String timePattern = column.getColumn().getPattern();
                    //Compatible with Time,Date and String,it will fail if Time contain fractional seconds.(Solution:Use sqljdbc.jar and setTime() instead)
                    //setStmt.append(prefix + cid + ".setString(" + index + dynamic + "," + incomingConnName + "." + column.getName()+".toString()");// For Time and String
                    setStmt.append(prefix + cid + ".setString(" + index + dynamic + ","
                                    + incomingConnName + "." + column.getName()
                                    +" instanceof java.util.Date ? new java.text.SimpleDateFormat("+timePattern+").format("
                                    + incomingConnName + "." + column.getName()+") : "
                                    + incomingConnName + "." + column.getName()+".toString()");//Compatible with tFileInputDelimiter Date Type and Time and String
                    setStmt.append(");\r\n");
                }else{//TDI-30431 end
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                    if("DATETIMEOFFSET".equals(dbType)) {
                        setStmt.append(",calendar_datetimeoffset_").append(cid);
                    }
                    setStmt.append(");\r\n");
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        //bug 0016707 fixed:when set INT IDENTITY in schema and use "Specify identity field". the INT IDENTITY in schema by ignored  
                        if(column.isAutoIncrement()) {
                            length = column.getStartValue();
                            precision =  column.getStep();
                            if ("INT IDENTITY".equals(column.column.getType())) {
                                column.setAutoIncrement(false);
                            } 
                        }
                        // end bug0016707
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if ((MYSQL.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + getLengthStringRepresentation(dataType, length));
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + getLengthStringRepresentation(dataType, length));
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
        
        protected String getLengthStringRepresentation(String dataType, Integer length) {
	        if (("VARCHAR".equalsIgnoreCase(dataType) && length > 8000) || ("NVARCHAR".equalsIgnoreCase(dataType) && length > 4000)
	                || ("VARBINARY".equalsIgnoreCase(dataType) && length > 8000)) {
	            return "MAX";
	        }
	        return String.valueOf(length);
	    }
    }
    
    public class MysqlManager extends Manager {
        public MysqlManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MYSQL;
        }
        protected String getLProtectedChar() {
            return "`";
        }
        protected String getRProtectedChar() {
            return "`";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE){
                prefix = "pstmt_";
            }else if(actionType == INSERT_TYPE){
                prefix = "pstmtInsert_";
            }else if(actionType == UPDATE_TYPE){
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();

            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                //also check if DBType is year
                boolean isDBTypeEqualsYear = column.getColumn().getType().equalsIgnoreCase("year");
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append("date_" + cid + " = " + incomingConnName + "." + column.getName() + ".getTime();\r\n");
                if (isDBTypeEqualsYear) {
                    setStmt.append("java.util.Calendar yearCalendar_" + cid + " = new java.util.GregorianCalendar();\r\n");
                    setStmt.append("yearCalendar_" + cid + ".setTimeInMillis(date_" + cid + ");\r\n");
                    setStmt.append("\r\n");
                    setStmt.append("int yearValue_" + cid + " = yearCalendar_" + cid + ".get(java.util.Calendar.YEAR);\r\n");
                    setStmt.append("if (yearValue_" + cid + " > 2155 || yearValue_" + cid + " < 1901) { \r\n");
                    setStmt.append("\t" + prefix + cid + ".setInt(" + index + ", 0);\r\n");
                } else {
                    setStmt.append("if(date_" + cid + " < year1_" + cid + " || date_" + cid + " >= year10000_" + cid + ") {\r\n");
                    setStmt.append(prefix + cid + ".setString(" + index + ", \"0000-00-00 00:00:00\");\r\n");
                }
                setStmt.append("} else {");

                if (isDBTypeEqualsYear) {
                    setStmt.append("\t" + prefix + cid + ".setInt(" + index + ", yearValue_" + cid + ");\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(date_" + cid + "));\r\n");
                }
                setStmt.append("}\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");

            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }

    public class NetezzaManager extends Manager {
        public NetezzaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return NETEZZA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                String dateType="Timestamp";
                if("TIME".equalsIgnoreCase(column.getColumn().getType())){
                    dateType = "Time";
                }
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".set"+dateType+"(" + index + dynamic + ", new java.sql."+dateType+"(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class OracleManager extends Manager {
          private String[] oracleKeyWords= {
                    "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
                    "ADD","CONNECT","DISTINCT" ,
                    "ALL","BY","CREATE","DROP",
                    "ALTER","CHAR","CURRENT","ELSE",
                    "AND","CHECK","DATE","EXCLUSIVE",
                    "ANY","CLUSTER","DECIMAL"," EXISTS",
                    "AS","COLUMN","DEFAULT","FILE",
                    "ASC","COMMENT","DELETE","FLOAT",
                    "FOR","LONG","PCTFREE","SUCCESSFUL",
                    "FROM","MAXEXTENTS","PRIOR","SYNONYM",
                    "GRANT","MINUS","PRIVILEGES","SYSDATE",
                    "GROUP","MODE","PUBLIC","TABLE",
                    "HAVING","MODIFY","RAW","THEN",
                    "IDENTIFIED","NETWORK","RENAME","TO",
                    "IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
                    "IN","NOCOMPRESS","REVOKE","UID",
                    "INCREMENT","NOT","ROW","UNION",
                    "INDEX","NOWAIT","ROWID","UNIQUE",
                    "INITIAL","NULL","ROWNUM","UPDATE",
                    "INSERT","NUMBER","ROWS","USER",
                    "INTEGER","OF","SELECT","VALIDATE",
                    "INTERSECT","OFFLINE","SESSION","VALUES",
                    "INTO","ON","SET","VARCHAR",
                    "IS","ONLINE","SHARE","VARCHAR2",
                    "LEVEL","OPTION","SIZE","VIEW",
                    "LIKE","OR","SMALLINT","WHENEVER",
                    "LOCK","ORDER","START","WHERE","WITH"
                    };
        public OracleManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ORACLE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isOracleKeyword (String keyword) {
            for (int i=0 ; i < oracleKeyWords.length ; i++){
                if (oracleKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
        private String dbVersion = "";
        public void setDbVersion(String dbVersion){
            this.dbVersion = dbVersion;  
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }        
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
        	return generateSetStmt(typeToGenerate, column.getColumn().getType(), column, index, incomingConnName, cid, actionType, dynamic);
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            if(dbType == null){
            	dbType = "";
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");
                }
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if( typeToGenerate.equals("String")&& dbType.toLowerCase().equals("char")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == \"\0\"){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            }
            else if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                boolean isTSWithTZ = dbType.matches("TIMESTAMP WITH TIME ZONE");
                if(isTSWithTZ && ("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_12".equals(dbVersion) || "ORACLE_10".equals(dbVersion))){
                    setStmt.append("if("+ incomingConnName + "." + column.getName() + " instanceof TalendTimestampWithTZ){\r\n");
                    setStmt.append("((oracle.jdbc.OraclePreparedStatement)" + prefix + cid + ").setTIMESTAMPTZ(" + index + dynamic +  ", new oracle.sql.TIMESTAMPTZ(conn_" + cid + ", ((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getTimestamp(),((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getCalendar()));\r\n");
                    setStmt.append("}else{");
                    setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    setStmt.append("}");
                }else if ("Date".equalsIgnoreCase(dbType)) {
                    if (!"true".equals(ElementParameterParser.getValue(node, "__USE_TIMESTAMP_FOR_DATE_TYPE__"))) {
                        setStmt.append(prefix + cid + ".setDate(" + index + dynamic +  ", new java.sql.Date(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    } else {
                        setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()),java.sql.Types.DATE);\r\n");
                    }
                } else {
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n"); 
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic +  ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic +  ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic +  ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && (dbType.equals("XMLTYPE")||dbType.equals("CLOB")))) {
                setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ",  clobTypeUtil_" + cid + ".getCLOB(" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ",  blobTypeUtil_" + cid + ".getBLOB(" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
            }else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            boolean convertToUppercase = ("true").equals(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
            if(convertToUppercase){
                return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ").toUpperCase()" +" + \"" + getRProtectedChar() + "\"";
            }else{
                return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
            }
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;
            String columnName = column.getColumnName();
            String dataType = column.getDataType();
            if(dataType!=null)
            {
            boolean trimChar = ("true").equals(ElementParameterParser.getValue(node,"__TRIM_CHAR__"));
            if(trimChar && "char".equals(dataType.toLowerCase()))
            {
                columnName = "trim("+columnName+")";
            }
            }
            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn()!=null && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
    }
    
    public class PostgreManager extends Manager {
        public PostgreManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGRESQL;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            String dbType = column.getColumn().getType();
            StringBuilder setStmt = new StringBuilder();
            if(dbType.equals("UUID") && (typeToGenerate.equals("String") || typeToGenerate.equals("Object"))) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");
            } else if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else if(dbType.equals("UUID") && (typeToGenerate.equals("String") || typeToGenerate.equals("Object"))) {
                setStmt.append(prefix + cid + ".setObject(" + index + ", " + incomingConnName + "." + column.getName() + ", java.sql.Types.OTHER);\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class RedshiftManager extends PostgreManager {
         public RedshiftManager(String cid) {
             super(cid);
         }
         
         protected String getDBMSId() {
             return REDSHIFT;
         }
         
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if(("DECIMAL".equalsIgnoreCase(dataType) || "NUMERIC".equalsIgnoreCase(dataType)) 
                        	&& (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                            && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {
                        	
                        } else { 
	                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
	                            if (!precisionIgnored) {
	                                prefix = "(";
	                                suffix = ") ";
	                                createSQL.append(prefix + precision);
	                            }
	                            if (!lengthIgnored) {
	                                prefix = (prefix.equals("") ? "(" : prefix);
	                                suffix = (suffix.equals("") ? ") " : suffix);
	                                if (precisionIgnored) {
	                                    createSQL.append(prefix);
	                                    comma = "";
	                                } else {
	                                    comma = ",";
	                                }
	                                createSQL.append(comma + length);
	                            }
	                            createSQL.append(suffix);
	                        } else {
	                            if (!lengthIgnored) {
	                                if (column.getColumn().getLength() == null) {                                  
	                                } else { 
	                                    prefix = "(";
	                                    suffix = ") ";
	                                    createSQL.append(prefix + length);                                    
	                                }
	                            }
	                            if (!precisionIgnored) {
	                                prefix = (prefix.equals("") ? "(" : prefix);
	                                suffix = (suffix.equals("") ? ") " : suffix);
	                                if (lengthIgnored) {
	                                    createSQL.append(prefix);
	                                    comma = "";
	                                } else {
	                                    comma = ",";
	                                }
	                                createSQL.append(comma + precision);
	                            }
	                            if (column.getColumn().getLength() == null) {
	                            } else {
	                                createSQL.append(suffix);
	                            }
	                        }
	                    }
                            
                        if(column.isAutoIncrement()) {
                            // move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class GreenplumManager extends PostgrePlusManager {
         public GreenplumManager(String cid) {
             super(cid);
         }
         protected String getDBMSId() {
             return GREENPLUM;
         }
    }
    public class PostgrePlusManager extends Manager {
        public PostgrePlusManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGREPLUS;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class SQLiteManager extends Manager {
        public SQLiteManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SQLITE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class SybaseManager extends Manager {
         private String[] sybaseKeyWords= {
                 "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
                "ADD","CONNECT","COUNT","DISTINCT" ,
                "ALL","BY","CREATE","DROP",
                "ALTER","CHAR","CURRENT","ELSE",
                "AND","CHECK","DATE","EXCLUSIVE",
                "ANY","CLUSTER","DECIMAL"," EXISTS",
                "AS","COLUMN","DEFAULT","FILE",
                "ASC","COMMENT","DELETE","FLOAT",
                "FOR","LONG","PCTFREE","SUCCESSFUL",
                "FROM","FALSE","MAXEXTENTS","PRIOR","SYNONYM",
                "GRANT","MINUS","PRIVILEGES","SYSDATE",
                "GROUP","MODE","PUBLIC","TABLE",
                "HAVING","MODIFY","RAW","THEN",
                "IDENTIFIED","NETWORK","RENAME","TO",
                "IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
                "IN","NOCOMPRESS","REVOKE","UID",
                "INCREMENT","NOT","ROW","UNION",
                "INDEX","NOWAIT","ROWID","UNIQUE",
                "INITIAL","NULL","ROWNUM","UPDATE",
                "INSERT","NUMBER","ROWS","USER",
                "INTEGER","OF","SELECT","VALIDATE",
                "INTERSECT","OFFLINE","SESSION","VALUES",
                "INTO","ON","SET","VARCHAR",
                "IS","ONLINE","SHARE",
                "LEVEL","OPTION","SIZE","VIEW",
                "LIKE","OR","SMALLINT","WHENEVER",
                "LOCK","ORDER","START","WHERE","WITH"
                 
         };
        public SybaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SYBASE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected boolean isSybaseKeyword (String keyword) {
            for (int i=0 ; i < sybaseKeyWords.length ; i++){
                if (sybaseKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSybaseKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isSybaseKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return " null ";
            }
        }        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        

        /**
         * This method is added for differences between sybase and common databases on BigDecimal.
         * Reference issue is TDI-7505.
         * */
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("BigDecimal")){
                if(column.getColumn().getPrecision()!=null && column.getColumn().getLength()!=null){
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                    setStmt.append("((com.sybase.jdbc3.jdbc.SybPreparedStatement)"+prefix + cid + ").set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() +","+column.getColumn().getLength() +","+column.getColumn().getPrecision()+ ");\r\n");
                    setStmt.append("} else {\r\n");
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                    setStmt.append("}\r\n");
                }else{
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                }
                
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class TeradataManager extends Manager {
        public TeradataManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return TERADATA;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        } 
                
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            String dbType = column.getColumn().getType();
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BINARY);\r\n");                
                }
            } else if(typeToGenerate.equals("Byte")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TINYINT);\r\n");                
            } else if(typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.SMALLINT);\r\n");                
            } else if(typeToGenerate.equals("Long")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BIGINT);\r\n");                
            } else if(typeToGenerate.equals("Integer")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
                }
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                    
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if ((typeToGenerate.equals("String")) && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setAsciiStream(" + index + ", new java.io.ByteArrayInputStream(" + incomingConnName + "." + column.getName() + ".toString().getBytes()), (" + incomingConnName + "." + column.getName() + ".toString().getBytes()).length);\r\n");                
            } else if ((typeToGenerate.equals("Bytes")) && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");    
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            
            String tableType = ElementParameterParser.getValue(node, "__CREATE_TABLE_TYPE__");
            
            createSQL.append("CREATE " + tableType + " TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if ((MYSQL.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class VerticaManager extends Manager {
        public VerticaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VERTICA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else {
                if(typeToGenerate.equals("Int")) {
                    setStmt.append(prefix + cid + ".setLong(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");                 
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }  
        public String getCreateTableSQL(List<Column> columnList){

            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";

                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                    createSQL.append(suffix);
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        
        }
        
    }
    
    public class ODBCManager extends Manager {
        public ODBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ODBC;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class JDBCManager extends Manager {
        String lChar = "";
        String rChar = "";
        public JDBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JDBC;
        }
        protected String getLProtectedChar() {
            return lChar;
        }
        protected String getRProtectedChar() {
            return rChar;
        }        
        public void setLProtectedChar(String lChar){
            this.lChar = lChar;
        }
        public void setRProtectedChar(String rChar){
            this.rChar = rChar;
        }
    }    
    public class SAPHanaManager extends Manager {

        private String[] sapHanaReservedWords = { "ALL", "ALTER", "AS", "BEFORE", "BEGIN", "BOTH", "CASE", "CHAR", "CONDITION",
                "CONNECT", "CROSS", "CUBE", "CURRENT_CONNECTION", "CURRENT_DATE", "CURRENT_SCHEMA", "CURRENT_TIME",
                "CURRENT_TIMESTAMP", "CURRENT_USER", "CURRENT_UTCDATE", "CURRENT_UTCTIME", "CURRENT_UTCTIMESTAMP", "CURRVAL",
                "CURSOR", "DECLARE", "DISTINCT", "ELSE", "ELSEIF", "ELSIF", "END", "EXCEPT", "EXCEPTION", "EXEC", "FOR", "FROM",
                "FULL", "GROUP", "HAVING", "IF", "IN", "INNER", "INOUT", "INTERSECT", "INTO", "IS", "JOIN", "LEADING", "LEFT",
                "LIMIT", "LOOP", "MINUS", "NATURAL", "NEXTVAL", "NULL", "ON", "ORDER", "OUT", "PRIOR", "RETURN", "RETURNS",
                "REVERSE", "RIGHT", "ROLLUP", "ROWID", "SELECT", "SET", "SQL", "START", "SYSDATE", "SYSTIME", "SYSTIMESTAMP",
                "SYSUUID", "TOP", "TRAILING", "UNION", "USING", "UTCDATE", "UTCTIME", "UTCTIMESTAMP", "VALUES", "WHEN", "WHERE",
                "WHILE", "WITH" };

        public SAPHanaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SAPHANA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isSapHanaReservedWords (String keyword) {
            for (int i=0 ; i < sapHanaReservedWords.length ; i++){
                if (sapHanaReservedWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSapHanaReservedWords(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            return getLProtectedChar(keyword);
        }    
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            String table_type = ElementParameterParser.getValue(node,"__TABLE_TYPE__");
            createSQL.append("CREATE "+table_type+" TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                            if (!precisionIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + precision);
                            }
                            if (!lengthIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (precisionIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + length);
                            }
                            createSQL.append(suffix);
                        } else {
                            if (!lengthIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + length);                                    
                            }
                            if (!precisionIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (lengthIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + precision);
                            }
                            createSQL.append(suffix);
                        }                            
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }

    }    
    
    public class ExasolManager extends Manager{
    
		private String[] keywords = { "ABS", "ACOS", "ADD_DAYS", "ADD_HOURS",
				"ADD_MINUTES", "ADD_MONTHS", "ADD_SECONDS", "ADD_WEEKS",
				"ADD_YEARS", "ADMIN", "ALIGN", "ALWAYS", "ANALYZE", "ANSI",
				"ASCII", "ASIN", "ASSIGNMENT", "ASYMMETRIC", "ATAN", "ATAN2",
				"ATOMIC", "AUDIT", "AUTHENTICATED", "AUTO", "AVG", "BACKUP",
				"BERNOULLI", "BIT_AND", "BIT_CHECK", "BIT_LENGTH", "BIT_NOT",
				"BIT_OR", "BIT_SET", "BIT_TO_NUM", "BIT_XOR", "BREADTH",
				"CEIL", "CEILING", "CHANGE", "CHARACTERS", "CHARACTER_LENGTH",
				"CHR", "CLEAR", "COBOL", "COLOGNE_PHONETIC", "COMMENT",
				"COMMENTS", "COMMITTED", "CONCAT", "CONNECT", "CONVERT_TZ",
				"CORR", "COS", "COSH", "COT", "COUNT", "COVAR_POP",
				"COVAR_SAMP", "CREATED", "CROSS", "CURDATE", "DATABASE",
				"DATE_TRUNC", "DAYS_BETWEEN", "DECODE", "DEFAULTS", "DEGREES",
				"DELIMIT", "DELIMITER", "DENSE_RANK", "DEPTH", "DIAGNOSTICS",
				"DICTIONARY", "DISTRIBUTE", "DISTRIBUTION", "DIV", "DOWN",
				"DUMP", "EDIT_DISTANCE", "EMITS", "ENCODING", "ESTIMATE",
				"EVALUATE", "EXA", "EXCLUDE", "EXCLUDING", "EXP", "EXPRESSION",
				"FIRST_VALUE", "FLOOR", "FLUSH", "FOREIGN", "FORTRAN",
				"FROM_POSIX_TIME", "GREATEST", "GROUPING_ID", "HANDLER", "HAS",
				"HASH", "HASH_MD5", "HASH_SHA", "HASH_SHA1", "HASH_TIGER",
				"HIERARCHY", "HOURS_BETWEEN", "IDENTIFIED", "IGNORE",
				"INCLUDING", "INITIALLY", "INSTR", "INVALID", "ISOLATION",
				"IS_BOOLEAN", "IS_DATE", "IS_DSINTERVAL", "IS_NUMBER",
				"IS_TIMESTAMP", "IS_YMINTERVAL", "JAVA", "JAVASCRIPT", "KEEP",
				"KEY", "KEYS", "KILL", "LAG", "LANGUAGE", "LAST_VALUE",
				"LCASE", "LEAD", "LEAST", "LENGTH", "LINK", "LN", "LOCATE",
				"LOCK", "LOG10", "LOG2", "LOGS", "LONG", "LOWER", "LPAD",
				"LTRIM", "LUA", "MAX", "MAXIMAL", "MEDIAN", "MID", "MIN",
				"MINUTES_BETWEEN", "MONTHS_BETWEEN", "MUMPS", "NEVER", "NICE",
				"NORMALIZED", "NOW", "NULLIFZERO", "NULLS", "NUMTODSINTERVAL",
				"NUMTOYMINTERVAL", "NVL", "OCTETS", "OCTET_LENGTH", "OFFSET",
				"OPTIMIZE", "ORA", "OWNER", "PADDING", "PARTITION", "PASCAL",
				"PERCENTILE_CONT", "PERCENTILE_DISC", "PI", "PLI",
				"POSIX_TIME", "POWER", "PRECISION", "PRELOAD", "PRIMARY",
				"PRIORITY", "PRIVILEGE", "PYTHON", "QUERY_CACHE",
				"QUERY_TIMEOUT", "R", "RADIANS", "RAND", "RANK",
				"RATIO_TO_REPORT", "RECOMPRESS", "RECORD", "REGEXP_INSTR",
				"REGEXP_REPLACE", "REGEXP_SUBSTR", "REGR_AVGX", "REGR_AVGY",
				"REGR_COUNT", "REGR_INTERCEPT", "REGR_R2", "REGR_SLOPE",
				"REGR_SXX", "REGR_SXY", "REGR_SYY", "REJECT", "REORGANIZE",
				"REPEATABLE", "REVERSE", "ROLE", "ROUND", "ROWID",
				"ROW_NUMBER", "RPAD", "RTRIM", "SCALAR", "SCHEMAS", "SCHEME",
				"SECONDS_BETWEEN", "SECURE", "SERIALIZABLE", "SHUT", "SIGN",
				"SIMPLE", "SIN", "SINH", "SIZE", "SKIP", "SOUNDEX", "SQRT",
				"STATISTICS", "STDDEV", "STDDEV_POP", "STDDEV_SAMP", "ST_AREA",
				"ST_BOUNDARY", "ST_BUFFER", "ST_CENTROID", "ST_CONTAINS",
				"ST_CONVEXHULL", "ST_CROSSES", "ST_DIFFERENCE", "ST_DIMENSION",
				"ST_DISJOINT", "ST_DISTANCE", "ST_ENDPOINT", "ST_ENVELOPE",
				"ST_EQUALS", "ST_EXTERIORRING", "ST_FORCE2D", "ST_GEOMETRYN",
				"ST_GEOMETRYTYPE", "ST_INTERIORRINGN", "ST_INTERSECTION",
				"ST_INTERSECTS", "ST_ISCLOSED", "ST_ISEMPTY", "ST_ISRING",
				"ST_ISSIMPLE", "ST_LENGTH", "ST_NUMGEOMETRIES",
				"ST_NUMINTERIORRINGS", "ST_NUMPOINTS", "ST_OVERLAPS",
				"ST_POINTN", "ST_SETSRID", "ST_STARTPOINT", "ST_SYMDIFFERENCE",
				"ST_TOUCHES", "ST_TRANSFORM", "ST_UNION", "ST_WITHIN", "ST_X",
				"ST_Y", "SUBSTR", "SUM", "SYMMETRIC", "SYS_CONNECT_BY_PATH",
				"SYS_GUID", "TABLES", "TABLESAMPLE", "TAN", "TANH", "TASKS",
				"TIES", "TIME_ZONE", "TIME_ZONE_BEHAVIOR", "TO_CHAR",
				"TO_DATE", "TO_DSINTERVAL", "TO_NUMBER", "TO_TIMESTAMP",
				"TO_YMINTERVAL", "TRANSLATE", "TRUNC", "TYPE", "UCASE",
				"UNBOUNDED", "UNCOMMITTED", "UNDO", "UNICODE", "UNICODECHR",
				"UNLIMITED", "UPPER", "UTF8", "VARIANCE", "VARYING", "VAR_POP",
				"VAR_SAMP", "WEEK", "WRITE", "YEARS_BETWEEN", "ZEROIFNULL" };
				
        public ExasolManager(String cid) {
            super(cid);
        }

        protected boolean isReservedWord(String keyword) {
            for (int i=0 ; i < keywords.length ; i++){
                if (keywords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }

        protected String getDBMSId() {
            return EXASOL;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected String getLProtectedChar(String name) {
        	if (contaionsSpaces(name) || isReservedWord(name)) {
	            return "\\\"";
        	} else {
        		return "";
        	}
        }
        protected String getRProtectedChar(String name) {
        	if (contaionsSpaces(name) || isReservedWord(name)) {
	            return "\\\"";
        	} else {
        		return "";
        	}
        }  
    }
    
    public class SQLDWHManager extends MSSQLManager{
        
        public SQLDWHManager(String cid) {
            super(cid);
        }
        
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP EXTERNAL TABLE " + getLProtectedChar() + "\" + ext_tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE EXTERNAL TABLE " + getLProtectedChar() + "\" + ext_tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        //bug 0016707 fixed:when set INT IDENTITY in schema and use "Specify identity field". the INT IDENTITY in schema by ignored  
                        if(column.isAutoIncrement()) {
                            length = column.getStartValue();
                            precision =  column.getStep();
                            if ("INT IDENTITY".equals(column.column.getType())) {
                                column.setAutoIncrement(false);
                            } 
                        }
                        // end bug0016707
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if ((MYSQL.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + getLengthStringRepresentation(dataType, length));
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + getLengthStringRepresentation(dataType, length));
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
        
    }
    
    public class UnDefinedManager extends Manager{
        
        private String dbmsId = "";
        
        public UnDefinedManager(String cid) {
            super(cid);
        }
        public void setDBMSId(String dbmsId){
            this.dbmsId = dbmsId;
        }
        protected String getDBMSId() {
            return this.dbmsId;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////////
    //the managers which only work for tELTJDBCOutput component, we add it to ignore the text quote which wrap the schema, table or column name.
    
    public class AS400ELTManager extends AS400Manager {
        public AS400ELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class AccessELTManager extends AccessManager {
        public AccessELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class DB2ELTManager extends DB2Manager {
        public DB2ELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class FirebirdELTManager extends FirebirdManager {
        public FirebirdELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class HSQLDBELTManager extends HSQLDBManager {
        public HSQLDBELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class HiveELTManager extends HiveManager {
        public HiveELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class InformixELTManager extends InformixManager {
        public InformixELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class IngresELTManager extends IngresManager {
        public IngresELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class VectorWiseELTManager extends VectorWiseManager {
        public VectorWiseELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class InterbaseELTManager extends InterbaseManager {
        public InterbaseELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class JavaDBELTManager extends JavaDBManager {
        public JavaDBELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MaxDBELTManager extends MaxDBManager {
        public MaxDBELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MSSQLELTManager extends MSSQLManager {
        public MSSQLELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MysqlELTManager extends MysqlManager {
        public MysqlELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class NetezzaELTManager extends NetezzaManager {
        public NetezzaELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class OracleELTManager extends OracleManager {
        public OracleELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class PostgrePlusELTManager extends PostgrePlusManager {
        public PostgrePlusELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class GreenplumELTManager extends GreenplumManager {
        public GreenplumELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class PostgreELTManager extends PostgreManager {
        public PostgreELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class RedshiftELTManager extends RedshiftManager {
        public RedshiftELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class SQLiteELTManager extends SQLiteManager {
        public SQLiteELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class SybaseELTManager extends SybaseManager {
        public SybaseELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class TeradataELTManager extends TeradataManager {
        public TeradataELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class VerticaELTManager extends VerticaManager {
        public VerticaELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class ExasolELTManager extends ExasolManager {
        public ExasolELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class SAPHanaELTManager extends SAPHanaManager {
        public SAPHanaELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public Manager getELTManager(String dbmsId, String cid) {
        Manager manager = managerMap.get(dbmsId + cid);
        if(manager == null) {
            if(dbmsId.equalsIgnoreCase(AS400)) {
                manager = new AS400ELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ACCESS)) {
                manager = new AccessELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(DB2)) {
                manager = new DB2ELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(FIREBIRD)) {
                manager = new FirebirdELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HSQLDB)) {
                manager = new HSQLDBELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HIVE)) {
                manager = new HiveELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INFORMIX)) {
                manager = new InformixELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INGRES)) {
                manager = new IngresELTManager(cid);         
            } else if(dbmsId.equalsIgnoreCase(VECTORWISE)) {
                manager = new VectorWiseELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INTERBASE)) {
                manager = new InterbaseELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JAVADB)) {
                manager = new JavaDBELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MAXDB)) {
                manager = new MaxDBELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MSSQL)) {
                manager = new MSSQLELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MYSQL)) {
                manager = new MysqlELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(NETEZZA)) {
                manager = new NetezzaELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ORACLE)) {
                manager = new OracleELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGREPLUS)) {
                manager = new PostgrePlusELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(GREENPLUM)) {
                manager = new GreenplumELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGRESQL)) {
                manager = new PostgreELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(REDSHIFT)) {
                manager = new RedshiftELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SQLITE)) {
                manager = new SQLiteELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SYBASE)) {
                manager = new SybaseELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(TERADATA)) {
                manager = new TeradataELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(VERTICA)) {
                manager = new VerticaELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(EXASOL)) {
                manager = new ExasolELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SAPHANA)) {
                manager = new SAPHanaELTManager(cid);
            } else {
                manager = new UnDefinedManager(cid);
                ((UnDefinedManager)manager).setDBMSId(dbmsId);
            }
        }
        managerMap.put(dbmsId + cid, manager);
        return manager;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    //ELT part end
    
    public Manager getManager(String dbmsId, String cid) {
        Manager manager = managerMap.get(dbmsId + cid);
        if(manager == null) {
            if(dbmsId.equalsIgnoreCase(AS400)) {
                manager = new AS400Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(ACCESS)) {
                manager = new AccessManager(cid);
            } else if(dbmsId.equalsIgnoreCase(DB2)) {
                manager = new DB2Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(FIREBIRD)) {
                manager = new FirebirdManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HSQLDB)) {
                manager = new HSQLDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HIVE)) {
                manager = new HiveManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INFORMIX)) {
                manager = new InformixManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INGRES)) {
                manager = new IngresManager(cid);         
            } else if(dbmsId.equalsIgnoreCase(VECTORWISE)) {
                manager = new VectorWiseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INTERBASE)) {
                manager = new InterbaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JAVADB)) {
                manager = new JavaDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MAXDB)) {
                manager = new MaxDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MSSQL)) {
                if(cid != null && cid.indexOf("DWHBulkExec") > -1){
                    manager = new SQLDWHManager(cid);
                }else{
                    manager = new MSSQLManager(cid); 
                }
            } else if(dbmsId.equalsIgnoreCase(MYSQL)) {
                manager = new MysqlManager(cid);
            } else if(dbmsId.equalsIgnoreCase(NETEZZA)) {
                manager = new NetezzaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ORACLE)) {
                manager = new OracleManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGREPLUS)) {
                manager = new PostgrePlusManager(cid);
            } else if(dbmsId.equalsIgnoreCase(GREENPLUM)) {
                manager = new GreenplumManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGRESQL)) {
                manager = new PostgreManager(cid);
            } else if(dbmsId.equalsIgnoreCase(REDSHIFT)) {
                manager = new RedshiftManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SQLITE)) {
                manager = new SQLiteManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SYBASE)) {
                manager = new SybaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(TERADATA)) {
                manager = new TeradataManager(cid);
            } else if(dbmsId.equalsIgnoreCase(VERTICA)) {
                manager = new VerticaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ODBC)) {
                manager = new ODBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JDBC)) {
                manager = new JDBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(EXASOL)) {
                manager = new ExasolManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SAPHANA)) {
                manager = new SAPHanaManager(cid);
            } else {
                manager = new UnDefinedManager(cid);
                ((UnDefinedManager)manager).setDBMSId(dbmsId);
            }
        }
        managerMap.put(dbmsId + cid, manager);
        return manager;
    }
    
    
    public Manager getManager(String dbmsId, String cid, INode node) {
        Manager manager = getManager(dbmsId, cid);
        manager.setNode(node);
        return manager;
    }
    
    public Manager getELTManager(String dbmsId, String cid, INode node) {
        Manager manager = getELTManager(dbmsId, cid);
        manager.setNode(node);
        return manager;
    }    
    
    public List<IMetadataColumn> getColumnList(INode node) {
        List<IMetadataColumn> columnList = null;
        List<IMetadataTable> metadatas = node.getMetadataList();
        if(metadatas != null && metadatas.size() > 0) {
            IMetadataTable metadata = metadatas.get(0);
            if(metadata != null) {
                columnList = metadata.getListColumns();
                if(metadata.isDynamicSchema() && columnList!=null) {
                    for(int i=columnList.size()-1; i>-1; i--) {
                        IMetadataColumn column = columnList.get(i);
                        if("id_Dynamic".equals(column.getTalendType())){
                            talendDynamicColumn = column;
                            break;
                        }
                    }
                }
            }
        }
        return columnList;
    }
    
    private IMetadataColumn talendDynamicColumn = null;
    
    public IMetadataColumn getDynamicColumn() {
        return talendDynamicColumn;
    }
    
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_3);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_4);
    
            }
            
    stringBuffer.append(TEXT_5);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_7);
    for(String message : messages){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        debug(str("Start to work."));
    }
    
    public void endWork(){
        debug(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
    
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
       			 if(log4jEnabled){
       			 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_16);
    
            java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
            ignoredParamsTypes.addAll(
                java.util.Arrays.asList(
                    org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                    org.talend.core.model.process.EParameterFieldType.LABEL,
                    org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                    org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                    org.talend.core.model.process.EParameterFieldType.IMAGE,
                    org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                    org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                    org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                    org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                    org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                    org.talend.core.model.process.EParameterFieldType.VERSION,
                    org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                    org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                    org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                    org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                    org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                    org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                    org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                    )
            );
            for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                    continue;
                }
                String name = ep.getName();
                if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                    String epName = "__" + name + "__";
                    String password = "";
                    if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                        password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                    }else{
                        String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                        if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                            passwordValue = "\"\"";
                        } 
                        password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                    } 
                    
    stringBuffer.append(TEXT_17);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_20);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    if(value.length()>10000){
                    value = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(value);
                    }
                    
    stringBuffer.append(TEXT_21);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_24);
    
                }   
                
    stringBuffer.append(TEXT_25);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_26);
    
            }
        }
		debug(var("log4jParamters"));
		
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_29);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_30);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_31);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_34);
    
                }else{
                
    stringBuffer.append(TEXT_35);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_43);
    
                }
                
    stringBuffer.append(TEXT_44);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_45);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    stringBuffer.append(TEXT_46);
    
class DBConnLogUtil extends BasicLogUtil{
	
	private DBConnLogUtil(){}
	
	protected DBConnLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logJDBCDriver(String driverClass){
		debug(str("Driver ClassName: "), driverClass, str("."));
	}
	
	public void connTry(String url, String dbUser){
		if(dbUser != null){
			debug(str("Connection attempts to '"), url, str("' with the username '"), dbUser, str("'."));
		}else{
			debug(str("Connection attempts to '"), url, str("'."));
		}
	}
	
	public void connDone(String url){
		debug(str("Connection to '"), url, str("' has succeeded."));
	}
	
	public void useExistConn(String url, String dbUser){
		if(dbUser != null){
			debug(str("Uses an existing connection with username '"), dbUser, str("'. Connection URL: "), url, str("."));
		}else{
			debug(str("Uses an existing connection. Connection URL: "), url, str("."));
		}
	}
	
	public void closeTry(String connCompID){
		if(connCompID == null){
			debug(str("Closing the connection to the database."));
		}else{
			debug(str("Closing the connection "), connCompID, str(" to the database."));
		}
	}
	
	public void closeDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection to the database has closed."));	
		}else{
			debug(str("Connection "), connCompID, str(" to the database has closed."));
		}
	}
}

class DBTableActionLogUtil extends BasicLogUtil{
	private DBTableActionLogUtil(){}
	
	protected DBTableActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void dropTry(String tableName){
		tableActionTry(tableName, str("Dropping"));
	}
	
	public void dropDone(String tableName){
		tableActionDone(tableName, str("Drop"));
	}
	
	public void createTry(String tableName){
		tableActionTry(tableName, str("Creating"));
	}
	
	public void createDone(String tableName){
		tableActionDone(tableName, str("Create"));
	}
	
	public void clearTry(String tableName){
		tableActionTry(tableName, str("Clearing"));
	}
	
	public void clearDone(String tableName){
		tableActionDone(tableName, str("Clear"));
	}
	
	public void truncateTry(String tableName){
		tableActionTry(tableName, str("Truncating"));
	}
	
	public void truncateDone(String tableName){
		tableActionDone(tableName, str("Truncate"));
	}
	
	public void truncateReuseStorageTry(String tableName){
		tableActionTry(tableName, str("Truncating reuse storage"));
	}
	
	public void truncateReuseStorageDone(String tableName){
		tableActionDone(tableName, str("Truncate reuse stroage"));
	}
	
	private void tableActionTry(String tableName, String action){
		debug(action, str(" table '"), tableName, str("'."));
	}
	
	private void tableActionDone(String tableName, String action){
		debug(action, str(" table '"), tableName, str("' has succeeded."));
	}
}

class DBCommitLogUtil extends BasicLogUtil{
	private DBCommitLogUtil(){}
	
	protected DBCommitLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logAutoCommit(String autoCommit){
		debug(str("Connection is set auto commit to '"), autoCommit, str("'."));
	}

	public void commitTry(String connCompID, String commitCount){
		if(commitCount == null && connCompID == null){
			debug(str("Connection starting to commit."));
		}else if(commitCount == null){
			debug(str("Connection "), connCompID, str(" starting to commit."));	
		}else if(connCompID == null){
			debug(str("Connection starting to commit "), commitCount, str(" record(s)."));
		}else{
			debug(str("Connection "), connCompID, str(" starting to commit "), commitCount, str(" record(s)."));
		}
	}
	
	public void commitDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection commit has succeeded."));
		}else{
			debug(str("Connection "), connCompID, (" commit has succeeded."));
		}
	}
}

class DBBatchLogUtil extends BasicLogUtil{
	private DBBatchLogUtil(){}
	
	protected DBBatchLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void executeTry(String action){
		debug(str("Executing the "), action, str(" batch."));
	}
	
	public void executeDone(String action){
		debug(str("The "), action, str(" batch execution has succeeded."));
	}
}

class DBDataActionLogUtil extends BasicLogUtil{
	private DBDataActionLogUtil(){}
	
	protected DBDataActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void inserting(String nbline){
		sqlAction(nbline, str("Inserting"));
	}
	
	public void deleting(String nbline){
		sqlAction(nbline, str("Deleting"));
	}
	
	public void updating(String nbline){
		sqlAction(nbline, str("Updating"));
	}
	
	public void replacing(String nbline){
		sqlAction(nbline, str("Replacing"));
	}
	
	public void insertingOnDuplicateKeyUpdating(String nbline){
		sqlAction(nbline, str("Inserting on duplicate key updating"));
	}
	
	public void insertingIgnore(String nbline){
		sqlAction(nbline, str("Inserting ignore"));
	}
	
	private void sqlAction(String nbline, String action){
		if(nbline == null){
			debug(action, str(" the record."));
		}else{
			debug(action, str(" the record "), nbline, str("."));
		}
	}
	
	public void sqlExecuteTry(String sql){
		debug(str("Executing '"), sql, str("'."));
	}
	
	public void sqlExecuteDone(String sql){
		debug(str("Execute '"), sql, str("' has succeeded."));
	}

	public void addingToBatch(String nbline, String batchAction){
		debug(str("Adding the record "), nbline, str(" to the "), batchAction, str(" batch."));
	}
}

class DBStateLogUtil extends BasicLogUtil{
	private DBStateLogUtil(){}
	
	protected DBStateLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logInsertedLines(String nbline){
		logFinishedLines(nbline, str("inserted"));
	}
	
	public void logUpdatedLines(String nbline){
		logFinishedLines(nbline, str("updated"));
	}
	
	public void logDeletedLines(String nbline){
		logFinishedLines(nbline, str("deleted"));
	}
	
	public void logRejectedLines(String nbline){
		logFinishedLines(nbline, str("rejected"));
	}
	
	private void logFinishedLines(String nbline, String action){
		debug(str("Has "), action, str(" "), nbline, str(" record(s)."));
	}
}	
class DBLogUtil extends LogUtil{
	DBConnLogUtil conn = null;
	DBTableActionLogUtil table = null;
	DBCommitLogUtil commit = null;
	DBBatchLogUtil batch = null;
	DBDataActionLogUtil data = null;
	DBStateLogUtil state = null;
	private DBLogUtil(){}
	
	protected DBLogUtil(org.talend.core.model.process.INode node){
		super(node);
		conn = new DBConnLogUtil(node);
    	table = new DBTableActionLogUtil(node);
    	commit = new DBCommitLogUtil(node);
    	batch = new DBBatchLogUtil(node);
    	data = new DBDataActionLogUtil(node);
    	state = new DBStateLogUtil(node);
	}
	
	public DBConnLogUtil conn(){
		return conn;
	}
	
	public DBTableActionLogUtil table(){
		return table;
	}
	
	public DBCommitLogUtil commit(){
		return commit;
	}
	
	public DBBatchLogUtil batch(){
		return batch;
	}
	
	public DBDataActionLogUtil data(){
		return data;
	}
	
	public DBStateLogUtil state(){
		return state;
	}
}
DBLogUtil dbLog = null;

    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    dbLog = new DBLogUtil(node);

    List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,"__ADD_COLS__" );

    boolean useFieldOptions = ("true").equals(ElementParameterParser.getValue(node, "__USE_FIELD_OPTIONS__"));

    List<Map<String, String>> fieldOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_OPTIONS__");

    String dbname= ElementParameterParser.getValue(node, "__DBNAME__");

    String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");

    String dbhost = ElementParameterParser.getValue(node, "__HOST__");

    String dbport = ElementParameterParser.getValue(node, "__PORT__");

    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");

    String dbuser= ElementParameterParser.getValue(node, "__USER__");

    String table = ElementParameterParser.getValue(node,"__TABLE__");

    String dbmsId = ElementParameterParser.getValue(node,"__MAPPING__");

    getManager(dbmsId, cid, node);//register the MSSQLManager

    String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

    String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");

    boolean isSpecifyIdentityField = ("true").equals(ElementParameterParser.getValue(node,"__SPECIFY_IDENTITY_FIELD__"));

    String identityField = ElementParameterParser.getValue(node, "__IDENTITY_FIELD__");

    int startValue = Integer.parseInt(ElementParameterParser.getValue(node, "__START_VALUE__"));

    int step = Integer.parseInt(ElementParameterParser.getValue(node, "__STEP__"));

    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

    boolean  identityInsert= "true".equals(ElementParameterParser.getValue(node, "__IDENTITY_INSERT__"));

    boolean isEnableDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DEBUG_MODE__"));
    boolean usingStatsLogs=cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB");
    boolean useBatchSize = "true".equals(ElementParameterParser.getValue(node,"__USE_BATCH_SIZE__"));
	String batchSize=ElementParameterParser.getValue(node,"__BATCH_SIZE__");

    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }

    boolean useBatch = useBatchSize && (rejectConnName == null)
                     && (
                          ("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)
                        );

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
List<IMetadataColumn> columnList = getColumnList(node);
List<Column> stmtStructure = null;
Manager manager = null;

boolean isDynamic = false;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
	isDynamic = metadata.isDynamicSchema();
}

if(columnList != null && columnList.size() > 0) {
	boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	if(isParallelize){
	    stmtStructure = getManager(dbmsId, cid).createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
	}else{
	    stmtStructure = getManager(dbmsId, cid).createColumnList(columnList, useFieldOptions, fieldOptions, addCols, isSpecifyIdentityField, identityField, startValue, step);
	}
    isDynamic = isDynamic && !getManager(dbmsId, cid).isDynamicColumnReplaced();
}
boolean isUseParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
boolean  isSpecifyIdentityKey = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_IDENTITY_FIELD__"));
if(isDynamic || isUseParallelize || identityInsert || (!"DROP_CREATE".equals(tableAction) && !"CREATE".equals(tableAction) && !"DROP_IF_EXISTS_AND_CREATE".equals(tableAction))){
	isSpecifyIdentityKey = false;
}
String identityKey = ElementParameterParser.getValue(node, "__IDENTITY_FIELD__");
getManager(dbmsId, cid, node).setIsSpecifyIdentityKey(isSpecifyIdentityKey);

    stringBuffer.append(TEXT_66);
    
if(("UPDATE").equals(dataAction) || ("INSERT_OR_UPDATE").equals(dataAction) || ("UPDATE_OR_INSERT").equals(dataAction)) {
    int updateKeyCount = 0;
    if(stmtStructure != null) {
        for(Column column : stmtStructure) {
            if(column.isUpdateKey() && !column.isDynamic()) {
                updateKeyCount++;
            }
        }
        
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(updateKeyCount);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
    }
} else if(("DELETE").equals(dataAction)) {
    int deleteKeyCount = 0;
    if(stmtStructure != null) {
        for(Column column : stmtStructure) {
            if(column.isDeleteKey() && !column.isDynamic()) {
                deleteKeyCount++;
            }
        }
        
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(deleteKeyCount);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
    }
} else if (("INSERT_IF_NOT_EXIST").equals(dataAction)){
	int insertKeyCount = 0;
    if(stmtStructure != null) {
        for(Column column : stmtStructure) {
            if(column.isUpdateKey() && !column.isDynamic()) {
                insertKeyCount++;
            }
        }
       
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(insertKeyCount);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
    }
}


// From "../templates/tMSSql/_tMSSqlConnection.javajet" ******start******

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
boolean isEnableDatasource = false;
if(cid.indexOf("tMSSqlOutput")>-1 || cid.indexOf("tMSSqlSP")>-1 ){
	isEnableDatasource = true;
}

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    
if(useExistingConnection) {
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;
	String schema = "dbschema_" + connection;
	
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(schema);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_87);
    dbLog.conn().useExistConn("conn_"+cid+".getMetaData().getURL()", "conn_"+cid+".getMetaData().getUserName()");
    
} else {
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));   
	String driver = ElementParameterParser.getValue(node, "__DRIVER__");
	if(isEnableDatasource && specify_alias){
		String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");
		
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
	}
    
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_101);
    
    if(driver.equals("JTDS")) {
    
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
    } else {
    
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
     
    }
    
    stringBuffer.append(TEXT_106);
    dbLog.conn().logJDBCDriver(dbLog.var("driverClass"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_112);
    
    if(driver.equals("JTDS")) {
    
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_115);
    
    } else {
    
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_118);
    
    }
    
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
			if(driver.equals("JTDS")) {
	
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_126);
    
			} else {
	
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_129);
    
			}
	
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_134);
    
    String passwordFieldName = "__PASS__";
    
    stringBuffer.append(TEXT_135);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_138);
    } else {
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    dbLog.conn().connTry(dbLog.var("url"), dbLog.var("dbUser"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    dbLog.conn().connDone(dbLog.var("url"));
    stringBuffer.append(TEXT_150);
    
	if(isEnableDatasource && specify_alias){
	
    stringBuffer.append(TEXT_151);
    
	}
}


// From "../templates/tMSSql/_tMSSqlConnection.javajet" ******end******


dbLog.commit().logAutoCommit("conn_"+cid+".getAutoCommit()");
if (useBatch) {

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
}

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_163);
    

if(columnList != null && columnList.size()>0) {
if(!isDynamic) {
	
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
//issue 0010346 Parallelization crash with "Drop table if exists and create"
Boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
boolean convertToUppercase_tableAction = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
if (!isParallelize) {
//end issue 0010346 Parallelization crash with "Drop table if exists and create"
	
	manager = getManager(dbmsId, cid);
    
    String ending="";
    
	//TODO need to remove it as it seems not useful now
    if("VECTORWISE".equalsIgnoreCase(dbmsId)) {
        ending="WITH STRUCTURE = VECTORWISE";
    }
	
    boolean useCascade = "true".equals(ElementParameterParser.getValue(node,"__USE_CASCADE__"));
    
    //bugfix: TDI-31650
    boolean setQueryTimeOut = false;
    String queryTimeOutInSeconds = null;
    if(SYBASE.equalsIgnoreCase(dbmsId)){
        setQueryTimeOut = "true".equals(ElementParameterParser.getValue(node,"__SET_QUERY_TIMEOUT__"));
        queryTimeOutInSeconds = ElementParameterParser.getValue(node,"__QUERY_TIMEOUT_IN_SECONDS__");
    }

    if(!("NONE").equals(tableAction)) {
        if(("DROP_CREATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_171);
    
               }
             
    dbLog.table().dropTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_174);
    stringBuffer.append((useCascade ? " + \" cascade\"" : ""));
    stringBuffer.append(TEXT_175);
    dbLog.table().dropDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
                if (TERADATA.equalsIgnoreCase(dbmsId)) {
            
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    
                }
            
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_185);
    
               }
             
    dbLog.table().createTry(dbLog.var("tableName"));
    
            if(isDynamic) {
                List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                if(conns_dynamic!=null && conns_dynamic.size()>0){
                    String query=manager.getCreateTableSQL(stmtStructure);
                    
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_189);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_191);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_194);
    
                }
            } else {
            
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_197);
    
            }
            
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
        } else if(("CREATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_205);
    
               }
             
    dbLog.table().createTry(dbLog.var("tableName"));
    
            if(isDynamic) {
                List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                if(conns_dynamic!=null && conns_dynamic.size()>0){
                    String query=manager.getCreateTableSQL(stmtStructure);
                    
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_210);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_211);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_212);
    }
    stringBuffer.append(TEXT_213);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_214);
    
                }
            } else {
            
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_217);
    
            }
            
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
        } else if(("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction)) {
            boolean tableNameCaseSensitive=false;
            if(DB2.equalsIgnoreCase(dbmsId)||POSTGRESQL.equalsIgnoreCase(dbmsId)||GREENPLUM.equalsIgnoreCase(dbmsId)||POSTGREPLUS.equalsIgnoreCase(dbmsId)){
                tableNameCaseSensitive=true;
            }
            
    
            //to fixed: bug8422
            if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
            
    stringBuffer.append(TEXT_220);
    //bug22719: informix use independent connection, should remove this code after use shared connection
                if(INFORMIX.equalsIgnoreCase(dbmsId)){
                    String dbnameKey = ElementParameterParser.getValue(node, "__DBNAME__");
                    String dbserverKey = ElementParameterParser.getValue(node, "__DBSERVER__");
                    String dbhostKey = ElementParameterParser.getValue(node, "__HOST__");
                    String dbportKey = ElementParameterParser.getValue(node, "__PORT__");
                    String tableSchemaKey = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
                    
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(dbhostKey);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(dbportKey);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(dbnameKey);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(dbserverKey);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(tableSchemaKey);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_228);
    }else{
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_232);
    }
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    
            }
            
    
                            /*
                            case multi connection access the same db, that maybe have a locked in System table(e.g mssql).
                            so in mssql use "Select" checked the table whether exist.
                            */
                            //TODO we will use like "select" sql intead of use system table to checked table?
                            if(MSSQL.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    
                            } else if (ORACLE.equalsIgnoreCase(dbmsId) || SAPHANA.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_246);
    stringBuffer.append(manager.generateCode4TabelExist());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    
                            } else if ( SYBASE.equalsIgnoreCase(dbmsId)
                                        || INFORMIX.equalsIgnoreCase(dbmsId) ) {
                            
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_275);
    }
    stringBuffer.append(TEXT_276);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_279);
    }
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
                            } else if( DB2.equalsIgnoreCase(dbmsId) || TERADATA.equalsIgnoreCase(dbmsId)){
                            
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_297);
    }
    stringBuffer.append(TEXT_298);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_299);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_300);
    }
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_303);
    }
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    
                            } else if (GREENPLUM.equalsIgnoreCase(dbmsId) || POSTGRESQL.equalsIgnoreCase(dbmsId) || POSTGREPLUS.equalsIgnoreCase(dbmsId) || VERTICA.equalsIgnoreCase(dbmsId)) {
                            
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_335);
    }
    stringBuffer.append(TEXT_336);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_339);
    }
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_345);
    }
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    
                            } else if(EXASOL.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(table);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    
                            } else if(REDSHIFT.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    
                            } else {
                            
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    
                            }
                            
    
                            if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {
                            
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    
                                       if(setQueryTimeOut){
                                            
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_402);
    
                                       }
                                     
    dbLog.table().createTry(dbLog.var("tableName"));
    
                                    if(isDynamic) {
                                        List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                                        if(conns_dynamic!=null && conns_dynamic.size()>0){
                                            String query=manager.getCreateTableSQL(stmtStructure);
                                            
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_406);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_407);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_408);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_409);
    }
    stringBuffer.append(TEXT_410);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_411);
    
                                        }
                                    } else {
                                    
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_414);
    
                                    }
                                    
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    
                            } else {
                            
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    
                                       if(setQueryTimeOut){
                                            
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_423);
    
                                       }
                                     
    dbLog.table().dropTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_426);
    stringBuffer.append((useCascade ? " + \" cascade\"" : ""));
    stringBuffer.append(TEXT_427);
    dbLog.table().dropDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    
                                        if (TERADATA.equalsIgnoreCase(dbmsId)) {
                                    
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    
                                        }
                                    
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    
                                   if(setQueryTimeOut){
                                        
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_437);
    
                                   }
                                 
    dbLog.table().createTry(dbLog.var("tableName"));
    
                                if(isDynamic) {
                                    List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                                    if(conns_dynamic!=null && conns_dynamic.size()>0){
                                        String query=manager.getCreateTableSQL(stmtStructure);
                                        
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_441);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_442);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_443);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_444);
    }
    stringBuffer.append(TEXT_445);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_446);
    
                                    }
                                } else {
                                
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_449);
    
                                }
                                
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    
                            }
                            
    
            //to fixed: bug8422
            if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
            
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    
            }
            
    
        } else if(("CLEAR").equals(tableAction)) {
        
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_459);
    
               }
             
    dbLog.table().clearTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(manager.getDeleteTableSQL());
    stringBuffer.append(TEXT_462);
    dbLog.table().clearDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    
        }else if(("TRUNCATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_470);
    
               }
             
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_485);
    
               }
             
    dbLog.table().truncateTry(dbLog.var("tableName"));
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    }
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(manager.getTruncateTableSQL());
    stringBuffer.append(TEXT_490);
    if(INFORMIX.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_491);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    }
    dbLog.table().truncateDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    
        } else if(("TRUNCATE_REUSE_STORAGE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    dbLog.table().truncateReuseStorageTry(dbLog.var("tableName"));
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    }
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(manager.getTruncateReuseStroageTableSQL());
    stringBuffer.append(TEXT_510);
    dbLog.table().truncateReuseStorageDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    
        }
    }
//issue 0010346 Parallelization crash with "Drop table if exists and create"
}
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    
   
   if(!useExistingConnection) {
	
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    
    if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
        
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    
    }
}


    Map<String, StringBuilder> actionSQLMap = getManager(dbmsId, cid).createProcessSQL(stmtStructure);
    StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);
    StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);
    StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);
    StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
    StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);

    if(("INSERT").equals(dataAction)) {
        
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_529);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_530);
    
//to fixed: bug8422
if(!usingStatsLogs){
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    }
    stringBuffer.append(TEXT_535);
    
//to fixed: bug8422
//to fixed: bug18928,in bug 8422 if a statement is created,it will be used for many times,but it's not thread-safty.Now give one statement for each thread.
if(usingStatsLogs){ 
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    }
    
    } else if (("UPDATE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_548);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    
    } else if (("INSERT_OR_UPDATE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_560);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_567);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    
    } else if (("UPDATE_OR_INSERT").equals(dataAction)) {
        
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_575);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_582);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    
    } else if (("DELETE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(deleteWhereStmt.toString());
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    
    } else if (("INSERT_IF_NOT_EXIST").equals(dataAction)) {
    	
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_601);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    
    }else if("SINGLE_INSERT".equals(dataAction)){
    
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    
        for(Column column : stmtStructure) {
            if(!column.isReplaced() && !column.isAddCol() && column.isInsertable()) {
            	if(isSpecifyIdentityKey && (column.getName().equals(identityKey))) {
                   	continue;
               	}
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                
    stringBuffer.append(TEXT_608);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_610);
    
            }
        }
        
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    
        int count = 0;
        for(Column column : stmtStructure) {
            if(!column.isReplaced() && !column.isAddCol() && column.isInsertable()) {
            	if(isSpecifyIdentityKey && (column.getName().equals(identityKey))) {
                   	continue;
               	}
                if(count != 0) {
                    
    stringBuffer.append(TEXT_613);
    
                }
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                
    stringBuffer.append(TEXT_614);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(column.getName());
    
                count++;
            }
        }
        
    stringBuffer.append(TEXT_616);
    
            for(Column column : stmtStructure) {
                if(!column.isReplaced() && !column.isAddCol() && column.isInsertable()) {
                	if(isSpecifyIdentityKey && (column.getName().equals(identityKey))) {
                   		continue;
               		}
                    
    stringBuffer.append(TEXT_617);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_618);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_619);
    
                }
            }
            
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_628);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    }
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    
	     if(("INSERT").equals(dataAction) || ("INSERT_IGNORE").equals(dataAction)) {

    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    
		} else if (("UPDATE").equals(dataAction)) {

    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    		
		} else if (("INSERT_OR_UPDATE").equals(dataAction) || ("UPDATE_OR_INSERT").equals(dataAction)) {

    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    
		} else if (("DELETE").equals(dataAction)) {

    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    		
		} else if (("REPLACE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    
		} else if (("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    
		}else if (("INSERT_IF_NOT_EXIST").equals(dataAction)) {//MSSQL

    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    
		}

    
    	}
	} //end isDynamic

    if (useExistingConnection) {
    	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
 
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_675);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_676);
    
 	}
    if(identityInsert ) {
        
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    
        if (useExistingConnection) {
        	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
        
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    
        } else {
     	
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    
        }
    }
}
if(isDynamic) {

    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_690);
    if(isEnableDebug) {
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_692);
    
	     if(("INSERT").equals(dataAction) || ("INSERT_IGNORE").equals(dataAction)) {

    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    
		} else if (("UPDATE").equals(dataAction)) {

    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_696);
    		
		} else if (("INSERT_OR_UPDATE").equals(dataAction) || ("UPDATE_OR_INSERT").equals(dataAction)) {

    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    
		} else if (("DELETE").equals(dataAction)) {

    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    		
		} else if (("REPLACE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_703);
    
		} else if (("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    
		}else if (("INSERT_IF_NOT_EXIST").equals(dataAction)) {//MSSQL

    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_707);
    
		}

    
	}
}

    stringBuffer.append(TEXT_708);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.databases.dbspecifics.oracle;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.utils.NodeUtil;

public class TOracleOutputEndJava
{
  protected static String nl;
  public static synchronized TOracleOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleOutputEndJava result = new TOracleOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "                if(log.is";
  protected final String TEXT_5 = "Enabled())";
  protected final String TEXT_6 = NL + "            log.";
  protected final String TEXT_7 = "(\"";
  protected final String TEXT_8 = " - \" ";
  protected final String TEXT_9 = " + (";
  protected final String TEXT_10 = ") ";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "    \tclass BytesLimit65535_";
  protected final String TEXT_13 = "{" + NL + "    \t\tpublic void limitLog4jByte() throws Exception{" + NL + "    \t\t\t";
  protected final String TEXT_14 = NL + "            StringBuilder ";
  protected final String TEXT_15 = " = new StringBuilder();";
  protected final String TEXT_16 = NL + "            ";
  protected final String TEXT_17 = ".append(\"Parameters:\");";
  protected final String TEXT_18 = NL + "                    ";
  protected final String TEXT_19 = ".append(\"";
  protected final String TEXT_20 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_21 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_22 = NL + "                    ";
  protected final String TEXT_23 = ".append(\"";
  protected final String TEXT_24 = "\" + \" = \" + ";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "                ";
  protected final String TEXT_27 = ".append(\" | \");";
  protected final String TEXT_28 = NL + "    \t\t}" + NL + "    \t}" + NL + "    \t" + NL + "        new BytesLimit65535_";
  protected final String TEXT_29 = "().limitLog4jByte();";
  protected final String TEXT_30 = NL + "            StringBuilder ";
  protected final String TEXT_31 = " = new StringBuilder();    ";
  protected final String TEXT_32 = NL + "                    ";
  protected final String TEXT_33 = ".append(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "                    if(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = " == null){";
  protected final String TEXT_39 = NL + "                        ";
  protected final String TEXT_40 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_41 = NL + "                        ";
  protected final String TEXT_42 = ".append(";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = ");" + NL + "                    }   ";
  protected final String TEXT_45 = NL + "                ";
  protected final String TEXT_46 = ".append(\"|\");";
  protected final String TEXT_47 = NL;
  protected final String TEXT_48 = NL + "\t";
  protected final String TEXT_49 = NL + "\t     \t// TODO unable to parse integer: ";
  protected final String TEXT_50 = NL + "\t     \t// TODO error: ";
  protected final String TEXT_51 = NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\t\tjava.sql.Statement stmtCreateGeoColumns_";
  protected final String TEXT_53 = " = conn_";
  protected final String TEXT_54 = ".createStatement();" + NL + "" + NL + "\t\t// Delete geometry columns entry if already exists." + NL + "\t\tString deleteGeometryColumns_";
  protected final String TEXT_55 = " = \"DELETE FROM user_sdo_geom_metadata \"" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t+ \"WHERE TABLE_NAME='\" + ";
  protected final String TEXT_56 = " + \"'\";" + NL + "\t\t";
  protected final String TEXT_57 = NL + "\t\tstmtCreateGeoColumns_";
  protected final String TEXT_58 = ".execute(deleteGeometryColumns_";
  protected final String TEXT_59 = ");" + NL + "\t\t";
  protected final String TEXT_60 = NL + NL + "\t\tfor (String column: geometryColumnToExtends.keySet()) {" + NL + "\t\t    com.vividsolutions.jts.geom.Envelope extend = geometryColumnToExtends.get(column);" + NL + "" + NL + "\t\t\t// Create new entry in geometry columns table" + NL + "\t        String insertGeometryColumns_";
  protected final String TEXT_61 = " = \"INSERT INTO user_sdo_geom_metadata (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID) VALUES ('\"" + NL + "\t        \t\t\t\t\t\t\t\t\t\t+ ";
  protected final String TEXT_62 = " + \"','\" + column.toUpperCase(java.util.Locale.US) + \"', \"" + NL + "\t        \t\t\t\t\t\t\t\t\t\t+ \"MDSYS.SDO_DIM_ARRAY(MDSYS.SDO_DIM_ELEMENT('x', \" + extend.getMinX() + \", \" + extend.getMaxX() + \", ";
  protected final String TEXT_63 = "), \"" + NL + "\t        \t\t\t\t\t\t\t\t\t\t+ \"MDSYS.SDO_DIM_ELEMENT('y', \" + extend.getMinY() + \", \" + extend.getMaxY() + \", ";
  protected final String TEXT_64 = ")), \"" + NL + "\t        \t\t\t\t\t\t\t\t\t\t+ ";
  protected final String TEXT_65 = " +\")\";" + NL + "\t\t\t";
  protected final String TEXT_66 = NL + "\t    \tstmtCreateGeoColumns_";
  protected final String TEXT_67 = ".execute(insertGeometryColumns_";
  protected final String TEXT_68 = ");" + NL + "\t\t\t";
  protected final String TEXT_69 = NL + "    \t}" + NL + "" + NL + "        stmtCreateGeoColumns_";
  protected final String TEXT_70 = ".close();" + NL + "\t";
  protected final String TEXT_71 = NL + "\t\tfor (String geometryColumnName: geometryColumnToExtends.keySet()) {" + NL + "" + NL + "\t\t\tString index_name = \"spatialidx_\"+";
  protected final String TEXT_72 = "+\"_\" + geometryColumnName;" + NL + "\t\t\tif (index_name.length() > 30) {" + NL + "\t\t\t\tindex_name = index_name.substring(0, 29);" + NL + "\t\t\t}" + NL + "" + NL + "\t    \tjava.sql.Statement stmtCreateIndex_";
  protected final String TEXT_73 = " = conn_";
  protected final String TEXT_74 = ".createStatement();" + NL + "\t\t\t// Drop spatial index if exists" + NL + "\t\t\tString dropIndex_";
  protected final String TEXT_75 = " = \"DROP INDEX \"+index_name;" + NL + "\t        try {" + NL + "\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\tstmtCreateIndex_";
  protected final String TEXT_77 = ".execute(dropIndex_";
  protected final String TEXT_78 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t}" + NL + "\t\t\tcatch (java.sql.SQLException e_";
  protected final String TEXT_80 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t}" + NL + "" + NL + "\t\t\t// Create spatial index using GIST on geometry columns" + NL + "\t\t\tString createIndex_";
  protected final String TEXT_82 = " = \"CREATE INDEX \"+index_name + \" \"" + NL + "\t\t\t\t\t\t+ \"ON \" + ";
  protected final String TEXT_83 = " + \"(\" + geometryColumnName + \") \"" + NL + "\t\t\t\t\t\t+ \"INDEXTYPE IS MDSYS.SPATIAL_INDEX\";" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t        stmtCreateIndex_";
  protected final String TEXT_85 = ".execute(createIndex_";
  protected final String TEXT_86 = ");" + NL + "\t\t\t";
  protected final String TEXT_87 = NL + "\t        stmtCreateIndex_";
  protected final String TEXT_88 = ".close();" + NL + "\t    }" + NL + "\t";
  protected final String TEXT_89 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_90 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_91 = ".close();" + NL + "" + NL + "        }" + NL + "        if(pstmtInsert_";
  protected final String TEXT_92 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_93 = ".close();" + NL + "" + NL + "        }" + NL + "        if(pstmt_";
  protected final String TEXT_94 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_95 = ".close();" + NL + "" + NL + "        }";
  protected final String TEXT_96 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_97 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_98 = ".close();" + NL + "" + NL + "        }" + NL + "        if(pstmtInsert_";
  protected final String TEXT_99 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_100 = ".close();" + NL + "" + NL + "        }";
  protected final String TEXT_101 = NL + "            try {" + NL + "            \tif (pstmt_";
  protected final String TEXT_102 = " != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\t\tpstmt_";
  protected final String TEXT_104 = ".executeBatch();" + NL + "\t\t\t\t\t";
  protected final String TEXT_105 = NL + "        \t    }" + NL + "            }catch (java.sql.BatchUpdateException e_";
  protected final String TEXT_106 = "){" + NL + "\t\t        java.sql.SQLException ne_";
  protected final String TEXT_107 = " = e_";
  protected final String TEXT_108 = ".getNextException(),sqle_";
  protected final String TEXT_109 = "=null;" + NL + "\t\t    \tString errormessage_";
  protected final String TEXT_110 = ";" + NL + "\t\t\t\tif (ne_";
  protected final String TEXT_111 = " != null) {" + NL + "\t\t\t\t\t// build new exception to provide the original cause" + NL + "\t\t\t\t\tsqle_";
  protected final String TEXT_112 = " = new java.sql.SQLException(e_";
  protected final String TEXT_113 = ".getMessage() + \"\\ncaused by: \" + ne_";
  protected final String TEXT_114 = ".getMessage(), ne_";
  protected final String TEXT_115 = ".getSQLState(), ne_";
  protected final String TEXT_116 = ".getErrorCode(), ne_";
  protected final String TEXT_117 = ");" + NL + "\t\t\t\t\terrormessage_";
  protected final String TEXT_118 = " = sqle_";
  protected final String TEXT_119 = ".getMessage();" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\terrormessage_";
  protected final String TEXT_120 = " = e_";
  protected final String TEXT_121 = ".getMessage();" + NL + "\t\t\t\t}" + NL + "            \t";
  protected final String TEXT_122 = NL + "\t\t    \t\tif (ne_";
  protected final String TEXT_123 = " != null) {" + NL + "\t\t    \t\t\tthrow(sqle_";
  protected final String TEXT_124 = ");" + NL + "\t\t    \t\t}else{" + NL + "\t\t            \tthrow(e_";
  protected final String TEXT_125 = ");" + NL + "\t\t            }" + NL + "            \t";
  protected final String TEXT_126 = NL + "                \tSystem.err.println(errormessage_";
  protected final String TEXT_127 = ");" + NL + "            \t";
  protected final String TEXT_128 = NL + "        \t}" + NL + "        \tif (pstmt_";
  protected final String TEXT_129 = " != null) {" + NL + "            \ttmp_batchUpdateCount_";
  protected final String TEXT_130 = " = pstmt_";
  protected final String TEXT_131 = ".getUpdateCount();" + NL + "    \t    \t";
  protected final String TEXT_132 = NL + "    \t    \t\tinsertedCount_";
  protected final String TEXT_133 = NL + "    \t    \t";
  protected final String TEXT_134 = NL + "    \t    \t\tupdatedCount_";
  protected final String TEXT_135 = NL + "    \t    \t";
  protected final String TEXT_136 = NL + "    \t    \t    deletedCount_";
  protected final String TEXT_137 = NL + "    \t    \t";
  protected final String TEXT_138 = NL + "    \t    \t+= (tmp_batchUpdateCount_";
  protected final String TEXT_139 = "!=-1?tmp_batchUpdateCount_";
  protected final String TEXT_140 = ":0);" + NL + "            }";
  protected final String TEXT_141 = NL + "        if(pstmt_";
  protected final String TEXT_142 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_144 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_145 = NL + "\t\t\t\tSharedDBPreparedStatement.releasePreparedStatement(keyPsmt_";
  protected final String TEXT_146 = ");" + NL + "\t\t\t";
  protected final String TEXT_147 = NL + "        }";
  protected final String TEXT_148 = NL + "\t\tif(commitCounter_";
  protected final String TEXT_149 = " > 0) {" + NL + "\t\t\t";
  protected final String TEXT_150 = NL + "\t\t    conn_";
  protected final String TEXT_151 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_152 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_153 = NL + "\t\t";
  protected final String TEXT_154 = NL + "\t\tconn_";
  protected final String TEXT_155 = " .close();" + NL + "\t\t";
  protected final String TEXT_156 = NL + "\t\tresourceMap.put(\"finish_";
  protected final String TEXT_157 = "\", true);" + NL + "   \t";
  protected final String TEXT_158 = NL + NL + NL + "\t";
  protected final String TEXT_159 = NL + "\tnb_line_deleted_";
  protected final String TEXT_160 = "=nb_line_deleted_";
  protected final String TEXT_161 = "+ deletedCount_";
  protected final String TEXT_162 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_163 = "=nb_line_update_";
  protected final String TEXT_164 = " + updatedCount_";
  protected final String TEXT_165 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_166 = "=nb_line_inserted_";
  protected final String TEXT_167 = " + insertedCount_";
  protected final String TEXT_168 = ";" + NL + "\tnb_line_rejected_";
  protected final String TEXT_169 = "=nb_line_rejected_";
  protected final String TEXT_170 = " + rejectedCount_";
  protected final String TEXT_171 = ";" + NL + "\t";
  protected final String TEXT_172 = NL + "    \tif (globalMap.get(\"";
  protected final String TEXT_173 = "_NB_LINE\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_174 = "_NB_LINE\",nb_line_";
  protected final String TEXT_175 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_176 = "_NB_LINE\",(Integer)globalMap.get(\"";
  protected final String TEXT_177 = "_NB_LINE\") + nb_line_";
  protected final String TEXT_178 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_179 = "_NB_LINE_UPDATED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_180 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_181 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_182 = "_NB_LINE_UPDATED\",(Integer)globalMap.get(\"";
  protected final String TEXT_183 = "_NB_LINE_UPDATED\") + nb_line_update_";
  protected final String TEXT_184 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_185 = "_NB_LINE_INSERTED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_186 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_187 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_188 = "_NB_LINE_INSERTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_189 = "_NB_LINE_INSERTED\") + nb_line_inserted_";
  protected final String TEXT_190 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_191 = "_NB_LINE_DELETED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_192 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_193 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_194 = "_NB_LINE_DELETED\",(Integer)globalMap.get(\"";
  protected final String TEXT_195 = "_NB_LINE_DELETED\") + nb_line_deleted_";
  protected final String TEXT_196 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_197 = "_NB_LINE_REJECTED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_198 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_199 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_200 = "_NB_LINE_REJECTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_201 = "_NB_LINE_REJECTED\") + nb_line_rejected_";
  protected final String TEXT_202 = ");" + NL + "        }" + NL + "\t";
  protected final String TEXT_203 = NL + "        globalMap.put(\"";
  protected final String TEXT_204 = "_NB_LINE\",nb_line_";
  protected final String TEXT_205 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_206 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_207 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_208 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_209 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_210 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_211 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_212 = "_NB_LINE_REJECTED\", nb_line_rejected_";
  protected final String TEXT_213 = ");" + NL + "    " + NL + "\t";
  protected final String TEXT_214 = NL + NL;
  protected final String TEXT_215 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    
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
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_5);
    
            }
            
    stringBuffer.append(TEXT_6);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_8);
    for(String message : messages){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    
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
    
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
       			 if(log4jEnabled){
       			 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_17);
    
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
                    
    stringBuffer.append(TEXT_18);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_21);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    if(value.length()>10000){
                    value = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(value);
                    }
                    
    stringBuffer.append(TEXT_22);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_25);
    
                }   
                
    stringBuffer.append(TEXT_26);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_27);
    
            }
        }
		debug(var("log4jParamters"));
		
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_30);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_31);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_32);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_35);
    
                }else{
                
    stringBuffer.append(TEXT_36);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_44);
    
                }
                
    stringBuffer.append(TEXT_45);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_46);
    
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

    stringBuffer.append(TEXT_47);
    
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

    stringBuffer.append(TEXT_48);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	dbLog = new DBLogUtil(node);

	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

	String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");

	boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");

	String dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");

	String tableName = ElementParameterParser.getValue(node,"__TABLE__");

	String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");

	boolean useSpatialOptions = ("true").equals(ElementParameterParser.getValue(node,"__USE_SPATIAL_OPTIONS__"));

	boolean createSpatialIndex = ("true").equals(ElementParameterParser.getValue(node,"__SPATIAL_INDEX__"));

	String indexAccuracy = ElementParameterParser.getValue(node, "__SPATIAL_INDEX_ACCURACY__");

	String useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
    String useBatchAndUseConn = ElementParameterParser.getValue(node,"__USE_BATCH_AND_USE_CONN__");

    String batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");

	String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    
	INode connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(), connection);
	
    boolean isUseBatchByDBVersion = (!useExistingConnection && !"ORACLE_8".equalsIgnoreCase(dbVersion)) 
		|| (useExistingConnection && (connectionNode==null || (connectionNode!=null && !"ORACLE_8".equalsIgnoreCase(connectionNode.getUniqueName()))));

    boolean useBatch = true;
    if(useExistingConnection){
        useBatch = rejectConnName == null && isUseBatchByDBVersion && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) && ("true").equals(useBatchAndUseConn);
    }else{
        useBatch = rejectConnName == null && isUseBatchByDBVersion && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) && ("true").equals(useBatchSize);
    }

	List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();
    }

    if (useSpatialOptions && (("DROP_CREATE").equals(tableAction) || ("CREATE").equals(tableAction)
    		|| ("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction))) {

	    int targetSRID = -1;
	    try {
	      	targetSRID = Integer.parseInt(ElementParameterParser.getValue(node,"__SRID__"));
	    }
	    catch (NumberFormatException e) {
		
    stringBuffer.append(TEXT_49);
    stringBuffer.append(ElementParameterParser.getValue(node,"__SRID__"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(e.getMessage());
    stringBuffer.append(TEXT_51);
    
	     	e.printStackTrace();
	    }
		
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(tableName.toUpperCase(java.util.Locale.US) );
    stringBuffer.append(TEXT_56);
    dbLog.data().sqlExecuteTry(dbLog.var("deleteGeometryColumns"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    dbLog.data().sqlExecuteDone(dbLog.var("deleteGeometryColumns"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(tableName.toUpperCase(java.util.Locale.US) );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(indexAccuracy );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(indexAccuracy );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(targetSRID < 0 ? "\"NULL\"" : targetSRID );
    stringBuffer.append(TEXT_65);
    dbLog.data().sqlExecuteTry(dbLog.var("insertGeometryColumns"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    dbLog.data().sqlExecuteDone(dbLog.var("insertGeometryColumns"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
	}
	if (createSpatialIndex && useSpatialOptions) {
	
    stringBuffer.append(TEXT_71);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    dbLog.data().sqlExecuteTry(dbLog.var("dropIndex"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    dbLog.data().sqlExecuteDone(dbLog.var("dropIndex"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    dbLog.logIgnoredException("e_"+cid+".getMessage()");
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_83);
    dbLog.data().sqlExecuteTry(dbLog.var("createIndex"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    dbLog.data().sqlExecuteDone(dbLog.var("createIndex"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
	}



    if(("INSERT_OR_UPDATE").equals(dataAction)) {
    
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    
    } else if(("UPDATE_OR_INSERT").equals(dataAction)) {
    
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    
    } else { // dataAction equals "INSERT" or "UPDATE" or "DELETE"
    	if (useBatch) {
        
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
            	if(("true").equals(dieOnError)) {
           		
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
            	}else {
    			    dbLog.logPrintedException("errormessage_"+cid);
    				
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
            	}
            	
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    
    	    	if (("INSERT").equals(dataAction)) {
    	    	
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
    	    	}else if (("UPDATE").equals(dataAction)) {
    	    	
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
    	    	}else if (("DELETE").equals(dataAction)) {
    	    	
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
    	    	}
    	    	
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
        }
       	
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    
			//to fixed: bug8422
			if(!(cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
			
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    
			}else{
			
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
			}
			
    stringBuffer.append(TEXT_147);
    
    }

	if(!useExistingConnection){
		if(!("").equals(commitEvery) && !("0").equals(commitEvery)){
		
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    dbLog.commit().commitTry(null, dbLog.var("commitCounter"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    dbLog.commit().commitDone(null);
    stringBuffer.append(TEXT_152);
    
		}
		
    stringBuffer.append(TEXT_153);
    dbLog.conn().closeTry(null);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    dbLog.conn().closeDone(null);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
	}
    
    stringBuffer.append(TEXT_158);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    
	boolean isEnableParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	if (isEnableParallelize) {
	
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
	} else {
	
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
	}
	if (("INSERT").equals(dataAction)) {
		dbLog.state().logInsertedLines(dbLog.var("nb_line_inserted"));
	}else if (("UPDATE").equals(dataAction)) {
		dbLog.state().logUpdatedLines(dbLog.var("nb_line_update"));
	}else if (("DELETE").equals(dataAction)) {
		dbLog.state().logDeletedLines(dbLog.var("nb_line_deleted"));
	}else if("UPDATE_OR_INSERT".equals(dataAction)){
		dbLog.state().logUpdatedLines(dbLog.var("nb_line_update"));
		dbLog.state().logInsertedLines(dbLog.var("nb_line_inserted"));
	}else if("INSERT_OR_UPDATE".equals(dataAction)){
		dbLog.state().logInsertedLines(dbLog.var("nb_line_inserted"));
		dbLog.state().logUpdatedLines(dbLog.var("nb_line_update"));
	}
	if(rejectConnName != null) {
		dbLog.state().logRejectedLines(dbLog.var("nb_line_rejected"));
	}
	
    stringBuffer.append(TEXT_214);
    stringBuffer.append(TEXT_215);
    return stringBuffer.toString();
  }
}

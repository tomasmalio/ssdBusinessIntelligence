package org.talend.designer.codegen.translators.databases.dbspecifics.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TOracleConnectionBeginJava
{
  protected static String nl;
  public static synchronized TOracleConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleConnectionBeginJava result = new TOracleConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\tString driverClass_";
  protected final String TEXT_3 = " = \"";
  protected final String TEXT_4 = "\";" + NL + "\t\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\t\t\tSharedDBConnectionLog4j.initLogger(log,\"";
  protected final String TEXT_7 = "\");";
  protected final String TEXT_8 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ".getDBConnection(\"";
  protected final String TEXT_13 = "\",url_";
  protected final String TEXT_14 = ",dbUser_";
  protected final String TEXT_15 = " , dbPwd_";
  protected final String TEXT_16 = " , sharedConnectionName_";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\tconn_";
  protected final String TEXT_19 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_20 = ",dbUser_";
  protected final String TEXT_21 = ",dbPwd_";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Connection is set auto commit to '";
  protected final String TEXT_25 = "'.\");";
  protected final String TEXT_26 = NL + "\t\t\tconn_";
  protected final String TEXT_27 = ".setAutoCommit(";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t                java.security.Security.insertProviderAt(new oracle.security.pki.OraclePKIProvider(), 3);" + NL + "\t            ";
  protected final String TEXT_30 = NL + "        String url_";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "        String url_";
  protected final String TEXT_34 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_35 = " + \":\" + ";
  protected final String TEXT_36 = " + \":\" + ";
  protected final String TEXT_37 = ";";
  protected final String TEXT_38 = NL + "        String url_";
  protected final String TEXT_39 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_40 = " + \")(port=\" + ";
  protected final String TEXT_41 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_42 = " + \")))\";";
  protected final String TEXT_43 = NL + "        String url_";
  protected final String TEXT_44 = " = \"jdbc:oracle:oci8:@\" + ";
  protected final String TEXT_45 = ";";
  protected final String TEXT_46 = NL + "\t\t\tString url_";
  protected final String TEXT_47 = "=";
  protected final String TEXT_48 = ";" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "    \tglobalMap.put(\"connectionType_\" + \"";
  protected final String TEXT_50 = "\", \"";
  protected final String TEXT_51 = "\");";
  protected final String TEXT_52 = NL + "\t\t\tSharedDBConnectionLog4j.initLogger(log,\"";
  protected final String TEXT_53 = "\");";
  protected final String TEXT_54 = NL + "\t\tString sharedConnectionName_";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = ";";
  protected final String TEXT_57 = NL + "\t\t\tconn_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = ".getDBConnection(\"";
  protected final String TEXT_60 = "\",url_";
  protected final String TEXT_61 = ",sharedConnectionName_";
  protected final String TEXT_62 = ");" + NL;
  protected final String TEXT_63 = NL + NL + "\t\t\t\tconn_";
  protected final String TEXT_64 = " = ";
  protected final String TEXT_65 = ".getDBConnection(\"";
  protected final String TEXT_66 = "\",url_";
  protected final String TEXT_67 = ",dbUser_";
  protected final String TEXT_68 = " , dbPwd_";
  protected final String TEXT_69 = " , sharedConnectionName_";
  protected final String TEXT_70 = ");" + NL;
  protected final String TEXT_71 = NL + "\t\t\tconn_";
  protected final String TEXT_72 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "\t\t\tconn_";
  protected final String TEXT_75 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_76 = ",dbUser_";
  protected final String TEXT_77 = ",dbPwd_";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "\t\t\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_80 = " = new java.util.Properties();";
  protected final String TEXT_81 = NL + "\t\t\t    if(dbUser_";
  protected final String TEXT_82 = "!=null && dbPwd_";
  protected final String TEXT_83 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_84 = ")&& !\"\".equals(dbPwd_";
  protected final String TEXT_85 = ")){" + NL + "\t\t\t        atnParamsPrope_";
  protected final String TEXT_86 = ".put(\"user\",dbUser_";
  protected final String TEXT_87 = ");" + NL + "\t\t\t        atnParamsPrope_";
  protected final String TEXT_88 = ".put(\"password\",dbPwd_";
  protected final String TEXT_89 = ");" + NL + "\t\t\t\t}";
  protected final String TEXT_90 = NL + "\t\t\t    atnParamsPrope_";
  protected final String TEXT_91 = ".put(\"user\",dbUser_";
  protected final String TEXT_92 = ");" + NL + "\t\t\t    atnParamsPrope_";
  protected final String TEXT_93 = ".put(\"password\",dbPwd_";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "                System.setProperty(\"jsse.enableCBCProtection\",\"false\");";
  protected final String TEXT_96 = NL + "\t\t\tif(";
  protected final String TEXT_97 = " != null && !\"\\\"\\\"\".equals(";
  protected final String TEXT_98 = ") && !\"\".equals(";
  protected final String TEXT_99 = ")){" + NL + "                atnParamsPrope_";
  protected final String TEXT_100 = ".load(new java.io.ByteArrayInputStream(";
  protected final String TEXT_101 = ".replace(\"&\", \"\\n\").getBytes()));" + NL + "            }";
  protected final String TEXT_102 = NL + "             if(atnParamsPrope_";
  protected final String TEXT_103 = ".getProperty(\"javax.net.ssl.trustStoreType\")==null){" + NL + "                 atnParamsPrope_";
  protected final String TEXT_104 = ".put(\"javax.net.ssl.trustStoreType\",\"PKCS12\");" + NL + "             }" + NL + "             atnParamsPrope_";
  protected final String TEXT_105 = ".put(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = " " + NL + "                 String trustStorePwd_";
  protected final String TEXT_108 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "                 String trustStorePwd_";
  protected final String TEXT_111 = " = ";
  protected final String TEXT_112 = "; ";
  protected final String TEXT_113 = NL + "             if(trustStorePwd_";
  protected final String TEXT_114 = "!=null && trustStorePwd_";
  protected final String TEXT_115 = ".length()>0){" + NL + "                 atnParamsPrope_";
  protected final String TEXT_116 = ".put(\"javax.net.ssl.trustStorePassword\", trustStorePwd_";
  protected final String TEXT_117 = ");" + NL + "             }";
  protected final String TEXT_118 = NL + "                 if(atnParamsPrope_";
  protected final String TEXT_119 = ".getProperty(\"javax.net.ssl.keyStoreType\")==null){" + NL + "                     atnParamsPrope_";
  protected final String TEXT_120 = ".put(\"javax.net.ssl.keyStoreType\",\"PKCS12\");" + NL + "                 }" + NL + "                 atnParamsPrope_";
  protected final String TEXT_121 = ".put(\"javax.net.ssl.keyStore\", ";
  protected final String TEXT_122 = ");" + NL + "    ";
  protected final String TEXT_123 = NL + "    ";
  protected final String TEXT_124 = " " + NL + "                      String keyStorePwd_";
  protected final String TEXT_125 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "                      String keyStorePwd_";
  protected final String TEXT_128 = " = ";
  protected final String TEXT_129 = "; ";
  protected final String TEXT_130 = NL + "                 if(keyStorePwd_";
  protected final String TEXT_131 = "!=null && keyStorePwd_";
  protected final String TEXT_132 = ".length()>0){" + NL + "                     atnParamsPrope_";
  protected final String TEXT_133 = ".put(\"javax.net.ssl.keyStorePassword\",keyStorePwd_";
  protected final String TEXT_134 = ");" + NL + "                 }";
  protected final String TEXT_135 = NL + "         " + NL + "\t\t\tconn_";
  protected final String TEXT_136 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_137 = ", atnParamsPrope_";
  protected final String TEXT_138 = ");";
  protected final String TEXT_139 = NL + "        globalMap.put(\"localServiceName_\" + \"";
  protected final String TEXT_140 = "\",";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = NL + "        globalMap.put(\"rac_url_\" + \"";
  protected final String TEXT_143 = "\", ";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = NL + "        globalMap.put(\"host_\" + \"";
  protected final String TEXT_146 = "\",";
  protected final String TEXT_147 = ");" + NL + "        globalMap.put(\"port_\" + \"";
  protected final String TEXT_148 = "\",";
  protected final String TEXT_149 = ");" + NL + "        globalMap.put(\"dbname_\" + \"";
  protected final String TEXT_150 = "\",";
  protected final String TEXT_151 = ");";
  protected final String TEXT_152 = NL + NL + "\t";
  protected final String TEXT_153 = NL + NL + "\tString dbUser_";
  protected final String TEXT_154 = " = ";
  protected final String TEXT_155 = ";";
  protected final String TEXT_156 = NL + "\t" + NL + "\t";
  protected final String TEXT_157 = NL + "\t\tString dbPwd_";
  protected final String TEXT_158 = " = null;" + NL + "\t";
  protected final String TEXT_159 = NL + "\t\t";
  protected final String TEXT_160 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_161 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_162 = ");";
  protected final String TEXT_163 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_164 = " = ";
  protected final String TEXT_165 = "; ";
  protected final String TEXT_166 = NL + "\t\tString dbPwd_";
  protected final String TEXT_167 = " = decryptedPassword_";
  protected final String TEXT_168 = ";" + NL + "\t";
  protected final String TEXT_169 = NL + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_170 = " = null;" + NL + "\t";
  protected final String TEXT_171 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_172 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_173 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_174 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_175 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_176 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_177 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_178 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_179 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_180 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_181 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_183 = " - Written records count: \" + nb_line_";
  protected final String TEXT_184 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_186 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_187 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_188 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_189 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_190 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_191 = " - Writing the record \" + nb_line_";
  protected final String TEXT_192 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_193 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_194 = " - Processing the record \" + nb_line_";
  protected final String TEXT_195 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_196 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_197 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_198 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_199 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_200 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_201 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_202 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_203 = " - Uses an existing connection ";
  protected final String TEXT_204 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_205 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_206 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_207 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_208 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_209 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_210 = NL + "\t\t\tconn_";
  protected final String TEXT_211 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_212 = ", dbUser_";
  protected final String TEXT_213 = ", dbPwd_";
  protected final String TEXT_214 = ");" + NL + "\t\t\t";
  protected final String TEXT_215 = NL + "\t\t\tconn_";
  protected final String TEXT_216 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_217 = NL + "\t\t\tconn_";
  protected final String TEXT_218 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_219 = NL + "\t\t\tconn_";
  protected final String TEXT_220 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_221 = NL + "\t\t\t\tconn_";
  protected final String TEXT_222 = ".setAutoCommit(";
  protected final String TEXT_223 = ");" + NL + "\t\t\t";
  protected final String TEXT_224 = NL + "\t\t\t\tlog.";
  protected final String TEXT_225 = "(\"";
  protected final String TEXT_226 = " - \" + ";
  protected final String TEXT_227 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_228 = NL + "\t    \t\tlog.";
  protected final String TEXT_229 = "(\"";
  protected final String TEXT_230 = "\");" + NL + "\t\t\t";
  protected final String TEXT_231 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_232 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_233 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_234 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_235 = ": pstmt_";
  protected final String TEXT_236 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_237 = " += (countEach_";
  protected final String TEXT_238 = " < 0 ? 0 : ";
  protected final String TEXT_239 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_240 = NL + "\t";
  protected final String TEXT_241 = NL + "\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_242 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\tif (dataSources_";
  protected final String TEXT_243 = " == null) {";
  protected final String TEXT_244 = NL + "\t\t";
  protected final String TEXT_245 = NL + "\t\t";
  protected final String TEXT_246 = NL + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_247 = "\", conn_";
  protected final String TEXT_248 = ");";
  protected final String TEXT_249 = NL + "\t} else {" + NL + "\t\tString dsAlias_";
  protected final String TEXT_250 = " = ";
  protected final String TEXT_251 = ";" + NL + "\t\tif (dataSources_";
  protected final String TEXT_252 = ".get(dsAlias_";
  protected final String TEXT_253 = ") == null) {" + NL + "   \t\t\tthrow new Exception(\"No DataSource with alias: \" + dsAlias_";
  protected final String TEXT_254 = " + \" available!\");" + NL + "      \t}" + NL + "\t\tconn_";
  protected final String TEXT_255 = " = dataSources_";
  protected final String TEXT_256 = ".get(dsAlias_";
  protected final String TEXT_257 = ").getConnection();" + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_258 = "\", conn_";
  protected final String TEXT_259 = ");" + NL + "\t}";
  protected final String TEXT_260 = NL + "\tif (null != conn_";
  protected final String TEXT_261 = ") {" + NL + "\t\t";
  protected final String TEXT_262 = NL + "\t}";
  protected final String TEXT_263 = NL + NL + "\tglobalMap.put(\"conn_\" + \"";
  protected final String TEXT_264 = "\",conn_";
  protected final String TEXT_265 = ");";
  protected final String TEXT_266 = NL + "  \tglobalMap.put(\"dbschema_\" + \"";
  protected final String TEXT_267 = "\",conn_";
  protected final String TEXT_268 = ".getMetaData().getUserName());";
  protected final String TEXT_269 = NL + "\tglobalMap.put(\"dbschema_\" + \"";
  protected final String TEXT_270 = "\", ";
  protected final String TEXT_271 = ");";
  protected final String TEXT_272 = NL + "\tglobalMap.put(\"username_\" + \"";
  protected final String TEXT_273 = "\",";
  protected final String TEXT_274 = ");" + NL + "\tglobalMap.put(\"password_\" + \"";
  protected final String TEXT_275 = "\",dbPwd_";
  protected final String TEXT_276 = ");";
  protected final String TEXT_277 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	class DefaultConnectionUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected boolean isLog4jEnabled;
	    
	    public void beforeComponentProcess(INode node){
	    }
	    
		public void createURL(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
		
		public void classForName(INode node){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
		}
		
		//for example, postgresql jdbc and redshift jdbc both can process the url : jdbc:postgresql://, 
		//we need to adjust the register order to make sure to use postgresql jdbc to process it
		public void adjustDriverRegisterOrderForConflcit() {
		
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");
			String shareDBClass = "SharedDBConnection";
			if(isLog4jEnabled){
				shareDBClass = "SharedDBConnectionLog4j";

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(shareDBClass);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		}
		
		public void createConnection(INode node) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
		}
		
		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_25);
    
			}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_28);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    
    class ConnectionUtil extends DefaultConnectionUtil{
    
        public void beforeComponentProcess(INode node){
            super.beforeComponentProcess(node);
            cid = node.getUniqueName();
            String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__");
            String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
			if("ORACLE_RAC".equals(connectionType) && "ORACLE_12".equals(dbVersion)){
	            boolean useSSL = "true".equals(ElementParameterParser.getValue(node,"__USE_SSL__"));
	            if( useSSL){
	            
    stringBuffer.append(TEXT_29);
    
	            }
			}
	    }

	public void createURL(INode node) {
			super.createURL(node);

    
    		String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
			String jdbcURL = ElementParameterParser.getValue(node, "__JDBC_URL__");
    		String localServiceName = ElementParameterParser.getValue(node, "__LOCAL_SERVICE_NAME__");
    		String rac_url = ElementParameterParser.getValue(node, "__RAC_URL__");
			if("ORACLE_RAC".equals(connectionType)) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(rac_url);
    stringBuffer.append(TEXT_32);
    
    		} else if(("ORACLE_SID").equals(connectionType)) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_37);
    
    		} else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_42);
    
    		} else if(("ORACLE_OCI").equals(connectionType)) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(localServiceName);
    stringBuffer.append(TEXT_45);
    
			}else if(("ORACLE_WALLET").equals(connectionType)){
			
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(jdbcURL);
    stringBuffer.append(TEXT_48);
    
			}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(connectionType);
    stringBuffer.append(TEXT_51);
    
		}

		public String getDirverClassName(INode node){
			String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__");
			if("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_12".equals(dbVersion) ){
			    return "oracle.jdbc.OracleDriver";
			}else {
				return "oracle.jdbc.driver.OracleDriver";
			}
		}



		public void useShareConnection(INode node) {
		String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");
		String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
		String shareDBClass = "SharedDBConnection";
		if(isLog4jEnabled){
			shareDBClass = "SharedDBConnectionLog4j";

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
		}

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_56);
    
			if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(shareDBClass);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
			} else {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(shareDBClass);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
			}

    
		}

		public void createConnection(INode node) {
		//dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
		String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
		boolean useSSL = false;
		String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__");
		if("ORACLE_RAC".equals(connectionType) && "ORACLE_12".equals(dbVersion)){
		    useSSL = "true".equals(ElementParameterParser.getValue(node,"__USE_SSL__"));
		}
		boolean disableCDCProtection="true".equals(ElementParameterParser.getValue(node,"__DISABLE_CBC_PROTECTION__"));
			if((("ORACLE_WALLET").equals(connectionType))) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
			} else if(!useSSL && (dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties))) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
			} else {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
            if("ORACLE_RAC".equals(connectionType) && useSSL){

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
			}else{

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
		    }
		    if(disableCDCProtection && useSSL){

    stringBuffer.append(TEXT_95);
    
		    }

    stringBuffer.append(TEXT_96);
    stringBuffer.append( dbproperties );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( dbproperties );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( dbproperties );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_101);
    
         String passwordFieldName = null;

    
         if(useSSL){
             String trustStorePath = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_TRUSTSTORE__");
             String trustStorePwd = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_PASSWORD__");
             boolean needClientAuth = "true".equals(ElementParameterParser.getValue(node,"__NEED_CLIENT_AUTH__"));
             String keyStorePath = ElementParameterParser.getValue(node,"__SSL_KEYSTORE__");
             String keyStorePwd = ElementParameterParser.getValue(node,"__SSL_KEYSTORE_PASSWORD__");

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(trustStorePath );
    stringBuffer.append(TEXT_106);
    
             passwordFieldName = "__SSL_TRUSTSERVER_PASSWORD__";

    
             if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_109);
    
             } else {

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_112);
    
             }

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
             if(needClientAuth){

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(keyStorePath );
    stringBuffer.append(TEXT_122);
    
                 passwordFieldName = "__SSL_KEYSTORE_PASSWORD__";

    stringBuffer.append(TEXT_123);
    
                 if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_126);
    
                 } else {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_129);
    
                 }

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
             }
         }

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
			}

    
		}

		public void afterComponentProcess(INode node){

    
	    	String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
    		String localServiceName = ElementParameterParser.getValue(node, "__LOCAL_SERVICE_NAME__");
			if(("ORACLE_OCI").equals(connectionType)) {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(localServiceName);
    stringBuffer.append(TEXT_141);
    
    		} else if("ORACLE_RAC".equals(connectionType)){
	    		String rac_url = ElementParameterParser.getValue(node, "__RAC_URL__");

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(rac_url);
    stringBuffer.append(TEXT_144);
        		}else {

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_151);
    
    		}

    
	    }
	}//end class
	connUtil = new ConnectionUtil();

    //----------------------------component codes-----------------------------------------
    stringBuffer.append(TEXT_152);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    if(dbschema == null||dbschema.trim().length()==0) {
    	 dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
    }
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHARED_CONNECTION__"));

    
	connUtil.beforeComponentProcess(node);
	connUtil.createURL(node);

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_155);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_156);
    if(dbpass != null && dbpass.trim().length() == 0) {
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    } else {
		String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_159);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_162);
    } else {
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    
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
			
    stringBuffer.append(TEXT_171);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_172);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_173);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_176);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_179);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_182);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_187);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_189);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_190);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_193);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_196);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    if (cid.contains("tImpala") || cid.contains("tHive")) {
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_204);
    } else {
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    }
    stringBuffer.append(TEXT_209);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    
			connect_end();
		}

		public void connect_begin(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"debug",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"debug",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_223);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_224);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_227);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_228);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_230);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_239);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	connUtil.adjustDriverRegisterOrderForConflcit();
	
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_240);
    connUtil.useShareConnection(node);
    
	} else {
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){

    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    
		}

    stringBuffer.append(TEXT_244);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_245);
    
		log4jCodeGenerateUtil.debugConnectionParams(node);
		log4jCodeGenerateUtil.connect_begin();
		connUtil.createConnection(node);
		log4jCodeGenerateUtil.connect_end();
		
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
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
    
		}
	}

    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_262);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    
	String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
	if(("ORACLE_WALLET").equals(connectionType)&&(dbschema==null||"".equals(dbschema)||"\"\"".equals(dbschema))) {

    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    
	}else{

    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_271);
    
	}

    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(TEXT_277);
    return stringBuffer.toString();
  }
}

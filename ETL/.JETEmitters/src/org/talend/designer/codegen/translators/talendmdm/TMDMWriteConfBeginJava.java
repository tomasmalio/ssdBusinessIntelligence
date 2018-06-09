package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TMDMWriteConfBeginJava
{
  protected static String nl;
  public static synchronized TMDMWriteConfBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMWriteConfBeginJava result = new TMDMWriteConfBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "                if(log.is";
  protected final String TEXT_3 = "Enabled())";
  protected final String TEXT_4 = NL + "            log.";
  protected final String TEXT_5 = "(\"";
  protected final String TEXT_6 = " - \" ";
  protected final String TEXT_7 = " + (";
  protected final String TEXT_8 = ") ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "    \tclass BytesLimit65535_";
  protected final String TEXT_11 = "{" + NL + "    \t\tpublic void limitLog4jByte() throws Exception{" + NL + "    \t\t\t";
  protected final String TEXT_12 = NL + "            StringBuilder ";
  protected final String TEXT_13 = " = new StringBuilder();";
  protected final String TEXT_14 = NL + "            ";
  protected final String TEXT_15 = ".append(\"Parameters:\");";
  protected final String TEXT_16 = NL + "                    ";
  protected final String TEXT_17 = ".append(\"";
  protected final String TEXT_18 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_19 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_20 = NL + "                    ";
  protected final String TEXT_21 = ".append(\"";
  protected final String TEXT_22 = "\" + \" = \" + ";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "                ";
  protected final String TEXT_25 = ".append(\" | \");";
  protected final String TEXT_26 = NL + "    \t\t}" + NL + "    \t}" + NL + "    \t" + NL + "        new BytesLimit65535_";
  protected final String TEXT_27 = "().limitLog4jByte();";
  protected final String TEXT_28 = NL + "            StringBuilder ";
  protected final String TEXT_29 = " = new StringBuilder();    ";
  protected final String TEXT_30 = NL + "                    ";
  protected final String TEXT_31 = ".append(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "                    if(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = " == null){";
  protected final String TEXT_37 = NL + "                        ";
  protected final String TEXT_38 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_39 = NL + "                        ";
  protected final String TEXT_40 = ".append(";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ");" + NL + "                    }   ";
  protected final String TEXT_43 = NL + "                ";
  protected final String TEXT_44 = ".append(\"|\");";
  protected final String TEXT_45 = NL + NL + "int nb_line_";
  protected final String TEXT_46 = " = 0;" + NL + "int nb_line_rejected_";
  protected final String TEXT_47 = " = 0;";
  protected final String TEXT_48 = NL + "        class Util_";
  protected final String TEXT_49 = "{" + NL + "            public org.talend.mdm.webservice.WSUpdateMetadataItem makeUpdateMeteItm(String taskID,org.talend.mdm.webservice.WSItemPK wspk){" + NL + "                org.talend.mdm.webservice.WSUpdateMetadataItem wsUpdateMetadataItem = new org.talend.mdm.webservice.WSUpdateMetadataItem();" + NL + "                wsUpdateMetadataItem.setTaskId(taskID);" + NL + "                wsUpdateMetadataItem.setWsItemPK(wspk);" + NL + "                return wsUpdateMetadataItem;" + NL + "            }" + NL + "            public org.talend.mdm.webservice.WSUpdateMetadataItem[] makeUpdateMeteItms(java.util.List<String> taskIDs,org.talend.mdm.webservice.WSItemPK[] wspks){" + NL + "                java.util.List<org.talend.mdm.webservice.WSUpdateMetadataItem> wsUpdateMetadataItems = new java.util.ArrayList<org.talend.mdm.webservice.WSUpdateMetadataItem>();" + NL + "                int i = 0;" + NL + "                for(org.talend.mdm.webservice.WSItemPK wspk : wspks){" + NL + "                    wsUpdateMetadataItems.add(makeUpdateMeteItm(taskIDs.get(i),wspk));" + NL + "                    i++;" + NL + "                }" + NL + "                return wsUpdateMetadataItems.toArray(new org.talend.mdm.webservice.WSUpdateMetadataItem[wsUpdateMetadataItems.size()]);" + NL + "            }" + NL + "        }" + NL + "        Util_";
  protected final String TEXT_50 = " util_";
  protected final String TEXT_51 = " = new Util_";
  protected final String TEXT_52 = "();";
  protected final String TEXT_53 = NL + "            java.util.List <org.talend.mdm.webservice.WSPutItemWithReport> miList_";
  protected final String TEXT_54 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItemWithReport>();";
  protected final String TEXT_55 = NL + "            java.util.List <org.talend.mdm.webservice.WSPutItem> miList_";
  protected final String TEXT_56 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItem>();";
  protected final String TEXT_57 = NL + "            java.util.List<String> taskIDs_";
  protected final String TEXT_58 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_59 = NL;
  protected final String TEXT_60 = NL + "class TimeoutUtil_";
  protected final String TEXT_61 = " {" + NL + "    public static final String CONNECTION_TIMEOUT_KEY = \"javax.xml.ws.client.connectionTimeout\";" + NL + "    public static final String RECEIVE_TIMEOUT_KEY = \"javax.xml.ws.client.receiveTimeout\";" + NL + "    public static final String CONNECTION_TIME_VALUE = \"ws_client_connection_timeout\";" + NL + "    public static final String RECEIVE_TIME_VALUE = \"ws_client_receive_timeout\";" + NL + "" + NL + "    public int getWSClientTimeout(String property) throws Exception {" + NL + "        int defaultTimeout = 60000;" + NL + "        String inputTimeout = System.getProperty(property);" + NL + "        if (inputTimeout != null) {" + NL + "            try {" + NL + "                int timeout = Integer.parseInt(inputTimeout);" + NL + "                if (timeout > 0) {" + NL + "                    return timeout;" + NL + "                }" + NL + "            } catch (Exception exception) {" + NL + "                throw new RuntimeException(\"Webservice \" + property + \" property value '\" + inputTimeout + \"' is invalid\", exception);" + NL + "            }" + NL + "        }" + NL + "        return defaultTimeout;" + NL + "    }" + NL + "}" + NL + "TimeoutUtil_";
  protected final String TEXT_62 = " timeoutUtil_";
  protected final String TEXT_63 = " = new TimeoutUtil_";
  protected final String TEXT_64 = "();" + NL;
  protected final String TEXT_65 = NL + "    String murl_";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = ";" + NL + "    if(murl_";
  protected final String TEXT_68 = ".endsWith(\"?wsdl\")) {" + NL + "       murl_";
  protected final String TEXT_69 = " = murl_";
  protected final String TEXT_70 = ".substring(0, murl_";
  protected final String TEXT_71 = ".length() - 5);" + NL + "    }";
  protected final String TEXT_72 = NL + "    org.talend.mdm.webservice.TMDMService_Service service_service_";
  protected final String TEXT_73 = " = new org.talend.mdm.webservice.TMDMService_Service(null);" + NL + "    org.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_74 = " = service_service_";
  protected final String TEXT_75 = ".getTMDMPort();" + NL + "    javax.xml.ws.BindingProvider stub_";
  protected final String TEXT_76 = " = (javax.xml.ws.BindingProvider) service_";
  protected final String TEXT_77 = ";" + NL + "    java.util.Map<String, Object> context_";
  protected final String TEXT_78 = " = stub_";
  protected final String TEXT_79 = ".getRequestContext();" + NL + "    context_";
  protected final String TEXT_80 = ".put(javax.xml.ws.BindingProvider.SESSION_MAINTAIN_PROPERTY, false);" + NL + "    context_";
  protected final String TEXT_81 = ".put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, ";
  protected final String TEXT_82 = ");" + NL + "    context_";
  protected final String TEXT_83 = ".put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, murl_";
  protected final String TEXT_84 = ");" + NL + "    context_";
  protected final String TEXT_85 = ".put(TimeoutUtil_";
  protected final String TEXT_86 = ".CONNECTION_TIMEOUT_KEY, timeoutUtil_";
  protected final String TEXT_87 = ".getWSClientTimeout(TimeoutUtil_";
  protected final String TEXT_88 = ".CONNECTION_TIME_VALUE));" + NL + "    context_";
  protected final String TEXT_89 = ".put(TimeoutUtil_";
  protected final String TEXT_90 = ".RECEIVE_TIMEOUT_KEY, timeoutUtil_";
  protected final String TEXT_91 = ".getWSClientTimeout(TimeoutUtil_";
  protected final String TEXT_92 = ".RECEIVE_TIME_VALUE));";
  protected final String TEXT_93 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_94 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_97 = " = ";
  protected final String TEXT_98 = "; ";
  protected final String TEXT_99 = NL + "    context_";
  protected final String TEXT_100 = ".put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, decryptedPassword_";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "    String murl_";
  protected final String TEXT_103 = " = (String)globalMap.get(\"mdmUrl_";
  protected final String TEXT_104 = "\");" + NL + "    if(murl_";
  protected final String TEXT_105 = ".endsWith(\"?wsdl\")) {" + NL + "        murl_";
  protected final String TEXT_106 = " = murl_";
  protected final String TEXT_107 = ".substring(0, murl_";
  protected final String TEXT_108 = ".length() - 5);" + NL + "    }" + NL + "    String username_";
  protected final String TEXT_109 = " = (String)globalMap.get(\"username_";
  protected final String TEXT_110 = "\");" + NL + "    String password_";
  protected final String TEXT_111 = " = (String)globalMap.get(\"password_";
  protected final String TEXT_112 = "\");" + NL;
  protected final String TEXT_113 = NL + "    org.talend.mdm.webservice.TMDMService_Service service_service_";
  protected final String TEXT_114 = " = new org.talend.mdm.webservice.TMDMService_Service(null);" + NL + "    org.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_115 = " = service_service_";
  protected final String TEXT_116 = ".getTMDMPort();" + NL + "    javax.xml.ws.BindingProvider stub_";
  protected final String TEXT_117 = " = (javax.xml.ws.BindingProvider) service_";
  protected final String TEXT_118 = ";" + NL + "    java.util.Map<String, Object> context_";
  protected final String TEXT_119 = " = stub_";
  protected final String TEXT_120 = ".getRequestContext();" + NL + "    context_";
  protected final String TEXT_121 = ".put(javax.xml.ws.BindingProvider.SESSION_MAINTAIN_PROPERTY, false);" + NL + "    context_";
  protected final String TEXT_122 = ".put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, murl_";
  protected final String TEXT_123 = ");" + NL + "    context_";
  protected final String TEXT_124 = ".put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, username_";
  protected final String TEXT_125 = ");" + NL + "    context_";
  protected final String TEXT_126 = ".put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, password_";
  protected final String TEXT_127 = ");" + NL + "    context_";
  protected final String TEXT_128 = ".put(TimeoutUtil_";
  protected final String TEXT_129 = ".CONNECTION_TIMEOUT_KEY, timeoutUtil_";
  protected final String TEXT_130 = ".getWSClientTimeout(TimeoutUtil_";
  protected final String TEXT_131 = ".CONNECTION_TIME_VALUE));" + NL + "    context_";
  protected final String TEXT_132 = ".put(TimeoutUtil_";
  protected final String TEXT_133 = ".RECEIVE_TIMEOUT_KEY, timeoutUtil_";
  protected final String TEXT_134 = ".getWSClientTimeout(TimeoutUtil_";
  protected final String TEXT_135 = ".RECEIVE_TIME_VALUE));";
  protected final String TEXT_136 = NL + "    String connKey_";
  protected final String TEXT_137 = " = \"";
  protected final String TEXT_138 = "_\" + Thread.currentThread().getThreadGroup().getName();" + NL + "    String transKey_";
  protected final String TEXT_139 = " = \"";
  protected final String TEXT_140 = "_\" + Thread.currentThread().getThreadGroup().getName();" + NL + "    org.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_141 = " = (org.talend.mdm.webservice.TMDMService)globalMap.get(connKey_";
  protected final String TEXT_142 = ");" + NL + "    if(service_";
  protected final String TEXT_143 = " == null){" + NL + "        String murl_";
  protected final String TEXT_144 = " = (String)globalMap.get(\"mdmUrl_";
  protected final String TEXT_145 = "\");" + NL + "        if(murl_";
  protected final String TEXT_146 = ".endsWith(\"?wsdl\")) {" + NL + "            murl_";
  protected final String TEXT_147 = " = murl_";
  protected final String TEXT_148 = ".substring(0, murl_";
  protected final String TEXT_149 = ".length() - 5);" + NL + "        }" + NL + "        String username_";
  protected final String TEXT_150 = " = (String)globalMap.get(\"username_";
  protected final String TEXT_151 = "\");" + NL + "        String password_";
  protected final String TEXT_152 = " = (String)globalMap.get(\"password_";
  protected final String TEXT_153 = "\");" + NL;
  protected final String TEXT_154 = NL + "        org.talend.mdm.webservice.TMDMService_Service service_service_";
  protected final String TEXT_155 = " = new org.talend.mdm.webservice.TMDMService_Service(null);" + NL + "        service_";
  protected final String TEXT_156 = " = service_service_";
  protected final String TEXT_157 = ".getTMDMPort();" + NL + "        javax.xml.ws.BindingProvider stub_";
  protected final String TEXT_158 = " = (javax.xml.ws.BindingProvider) service_";
  protected final String TEXT_159 = ";" + NL + "        java.util.Map<String, Object> context_";
  protected final String TEXT_160 = " = stub_";
  protected final String TEXT_161 = ".getRequestContext();" + NL + "        context_";
  protected final String TEXT_162 = ".put(javax.xml.ws.BindingProvider.SESSION_MAINTAIN_PROPERTY, true);" + NL + "        context_";
  protected final String TEXT_163 = ".put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, murl_";
  protected final String TEXT_164 = ");" + NL + "        context_";
  protected final String TEXT_165 = ".put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, username_";
  protected final String TEXT_166 = ");" + NL + "        context_";
  protected final String TEXT_167 = ".put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, password_";
  protected final String TEXT_168 = ");" + NL + "        context_";
  protected final String TEXT_169 = ".put(TimeoutUtil_";
  protected final String TEXT_170 = ".CONNECTION_TIMEOUT_KEY, timeoutUtil_";
  protected final String TEXT_171 = ".getWSClientTimeout(TimeoutUtil_";
  protected final String TEXT_172 = ".CONNECTION_TIME_VALUE));" + NL + "        context_";
  protected final String TEXT_173 = ".put(TimeoutUtil_";
  protected final String TEXT_174 = ".RECEIVE_TIMEOUT_KEY, timeoutUtil_";
  protected final String TEXT_175 = ".getWSClientTimeout(TimeoutUtil_";
  protected final String TEXT_176 = ".RECEIVE_TIME_VALUE));";
  protected final String TEXT_177 = NL + NL + "        if((Boolean)globalMap.get(\"useTransaction_";
  protected final String TEXT_178 = "\")) {" + NL + "            String turl_";
  protected final String TEXT_179 = " = com.talend.mdm.transaction.client.MDMTransactionClient.getMDMTransactionURL(murl_";
  protected final String TEXT_180 = ", true);" + NL + "            com.talend.mdm.transaction.client.MDMTransaction mdmTransaction_";
  protected final String TEXT_181 = " = (com.talend.mdm.transaction.client.MDMTransaction)globalMap.get(transKey_";
  protected final String TEXT_182 = ");" + NL + "            if(mdmTransaction_";
  protected final String TEXT_183 = " == null){" + NL + "                Boolean transInitStart_";
  protected final String TEXT_184 = " = false;" + NL + "                synchronized(globalMap){" + NL + "                    if(globalMap.containsKey(transKey_";
  protected final String TEXT_185 = " + \"_initStart\")){" + NL + "                        transInitStart_";
  protected final String TEXT_186 = " = true;" + NL + "                    }else{" + NL + "                        globalMap.put(transKey_";
  protected final String TEXT_187 = " + \"_initStart\", true);" + NL + "                    }" + NL + "                }" + NL + "                if(transInitStart_";
  protected final String TEXT_188 = " == false){" + NL + "                    if((Boolean)globalMap.get(\"useClientTranId_";
  protected final String TEXT_189 = "\")){" + NL + "                        List<String> cookies_";
  protected final String TEXT_190 = " = com.talend.mdm.transaction.client.MDMTransactionClient.getCookies(turl_";
  protected final String TEXT_191 = ",username_";
  protected final String TEXT_192 = ",password_";
  protected final String TEXT_193 = ");" + NL + "                        mdmTransaction_";
  protected final String TEXT_194 = " = new com.talend.mdm.transaction.client.MDMTransaction();" + NL + "                        mdmTransaction_";
  protected final String TEXT_195 = ".setUrl(turl_";
  protected final String TEXT_196 = ");" + NL + "                        mdmTransaction_";
  protected final String TEXT_197 = ".setId(\"";
  protected final String TEXT_198 = "_\" + java.util.UUID.randomUUID());" + NL + "                        mdmTransaction_";
  protected final String TEXT_199 = ".setUsername(username_";
  protected final String TEXT_200 = ");" + NL + "                        mdmTransaction_";
  protected final String TEXT_201 = ".setPassword(password_";
  protected final String TEXT_202 = ");" + NL + "                        mdmTransaction_";
  protected final String TEXT_203 = ".setCookies(cookies_";
  protected final String TEXT_204 = ");" + NL + "                    }else{";
  protected final String TEXT_205 = NL + "                        mdmTransaction_";
  protected final String TEXT_206 = " = com.talend.mdm.transaction.client.MDMTransactionClient.newTransaction(turl_";
  protected final String TEXT_207 = ",username_";
  protected final String TEXT_208 = ",password_";
  protected final String TEXT_209 = ");" + NL + "                    }" + NL + "                }else{" + NL + "                    while(mdmTransaction_";
  protected final String TEXT_210 = " == null){" + NL + "                        Thread.sleep(10);" + NL + "                        mdmTransaction_";
  protected final String TEXT_211 = " = (com.talend.mdm.transaction.client.MDMTransaction)globalMap.get(transKey_";
  protected final String TEXT_212 = ");" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                java.util.List<org.apache.cxf.headers.Header> soapHeaders_";
  protected final String TEXT_213 = " = new java.util.ArrayList<org.apache.cxf.headers.Header>();" + NL + "                javax.xml.namespace.QName qName_";
  protected final String TEXT_214 = " = new javax.xml.namespace.QName(\"http://www.talend.com/mdm\", \"transaction-id\");" + NL + "                org.apache.cxf.databinding.DataBinding dataBinding_";
  protected final String TEXT_215 = " = new org.apache.cxf.jaxb.JAXBDataBinding(String.class);" + NL + "                soapHeaders_";
  protected final String TEXT_216 = ".add(new org.apache.cxf.headers.Header(qName_";
  protected final String TEXT_217 = ", mdmTransaction_";
  protected final String TEXT_218 = ".getId(), dataBinding_";
  protected final String TEXT_219 = "));" + NL + "                context_";
  protected final String TEXT_220 = ".put(org.apache.cxf.headers.Header.HEADER_LIST, soapHeaders_";
  protected final String TEXT_221 = ");" + NL + "" + NL + "                java.util.Map<String, java.util.List<String>> httpHeaders_";
  protected final String TEXT_222 = " = new java.util.HashMap<String, java.util.List<String>>();" + NL + "                httpHeaders_";
  protected final String TEXT_223 = ".put(\"Cookie\", mdmTransaction_";
  protected final String TEXT_224 = ".getCookies());" + NL + "                context_";
  protected final String TEXT_225 = ".put(org.apache.cxf.message.Message.PROTOCOL_HEADERS, httpHeaders_";
  protected final String TEXT_226 = ");" + NL + "" + NL + "                globalMap.put(transKey_";
  protected final String TEXT_227 = ", mdmTransaction_";
  protected final String TEXT_228 = ");";
  protected final String TEXT_229 = NL + "            }" + NL + "        }" + NL + "        service_";
  protected final String TEXT_230 = ".ping(new org.talend.mdm.webservice.WSPing());";
  protected final String TEXT_231 = NL + "        globalMap.put(connKey_";
  protected final String TEXT_232 = ", service_";
  protected final String TEXT_233 = ");" + NL + "    }";
  protected final String TEXT_234 = NL + NL + "org.talend.mdm.webservice.WSDataClusterPK dataCluster_";
  protected final String TEXT_235 = " = new org.talend.mdm.webservice.WSDataClusterPK(";
  protected final String TEXT_236 = " + \"";
  protected final String TEXT_237 = "\");" + NL + "org.talend.mdm.webservice.WSDataModelPK dataModel_";
  protected final String TEXT_238 = " = new org.talend.mdm.webservice.WSDataModelPK(";
  protected final String TEXT_239 = ");" + NL + "" + NL + "String input_";
  protected final String TEXT_240 = ";" + NL + "" + NL + "java.util.List<org.talend.mdm.webservice.WSItemPK> wspks_";
  protected final String TEXT_241 = ";" + NL + "org.talend.mdm.webservice.WSItemPK wspk_";
  protected final String TEXT_242 = ";" + NL;
  protected final String TEXT_243 = NL + "    java.util.Queue<String> queue_";
  protected final String TEXT_244 = " = new java.util.concurrent.ConcurrentLinkedQueue<String>();";
  protected final String TEXT_245 = NL + "        java.util.List<java.util.Map<String,String>> xmlFlowList_";
  protected final String TEXT_246 = " = java.util.Collections.synchronizedList(new java.util.ArrayList<java.util.Map<String,String>>());" + NL + "        int flowNum_";
  protected final String TEXT_247 = " = 0;";
  protected final String TEXT_248 = NL + "    class ThreadXMLField_";
  protected final String TEXT_249 = " extends Thread {" + NL + "        java.util.Queue<String> queue;" + NL + "        java.util.List<java.util.Map<String,String>> flows;" + NL + "        java.lang.Exception lastException;" + NL + "        String currentComponent;" + NL + "" + NL + "        ThreadXMLField_";
  protected final String TEXT_250 = "(java.util.Queue q) {" + NL + "            this.queue = q;" + NL + "            globalMap.put(\"queue_";
  protected final String TEXT_251 = "\", queue);" + NL + "            lastException = null;" + NL + "        }" + NL + "" + NL + "        ThreadXMLField_";
  protected final String TEXT_252 = "(java.util.Queue q, java.util.List<java.util.Map<String,String>> l) {" + NL + "            this.queue = q;" + NL + "            this.flows = l;" + NL + "            lastException = null;" + NL + "            globalMap.put(\"queue_";
  protected final String TEXT_253 = "\", queue);" + NL + "            globalMap.put(\"flows_";
  protected final String TEXT_254 = "\", flows);" + NL + "        }" + NL + "" + NL + "        public java.lang.Exception getLastException() {" + NL + "            return this.lastException;" + NL + "        }" + NL + "        public String getCurrentComponent() {" + NL + "            return this.currentComponent;" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void run() {" + NL + "            try {";
  protected final String TEXT_255 = NL + "                ";
  protected final String TEXT_256 = "Process(globalMap);" + NL + "            } catch (TalendException te) {" + NL + "                this.lastException = te.getException();" + NL + "                this.currentComponent = te.getCurrentComponent();" + NL + "                globalMap.put(\"";
  protected final String TEXT_257 = "_FINISH\" + (this.queue==null?\"\":this.queue.hashCode()), \"true\");" + NL + "            }" + NL + "        }" + NL + "    }";
  protected final String TEXT_258 = NL + "        ThreadXMLField_";
  protected final String TEXT_259 = " txf_";
  protected final String TEXT_260 = " = new ThreadXMLField_";
  protected final String TEXT_261 = "(queue_";
  protected final String TEXT_262 = ", xmlFlowList_";
  protected final String TEXT_263 = ");";
  protected final String TEXT_264 = NL + "        ThreadXMLField_";
  protected final String TEXT_265 = " txf_";
  protected final String TEXT_266 = " = new ThreadXMLField_";
  protected final String TEXT_267 = "(queue_";
  protected final String TEXT_268 = ");";
  protected final String TEXT_269 = NL + "    txf_";
  protected final String TEXT_270 = ".start();";
  protected final String TEXT_271 = NL + "        java.util.List<java.util.Map<String,String>> xmlFlowList_";
  protected final String TEXT_272 = " = (java.util.List<java.util.Map<String,String>>)globalMap.get(\"flows_";
  protected final String TEXT_273 = "\");" + NL + "        int flowNum_";
  protected final String TEXT_274 = " = 0;";
  protected final String TEXT_275 = NL + "    java.util.Queue<String> queue_";
  protected final String TEXT_276 = " = (java.util.Queue<String>) globalMap.get(\"queue_";
  protected final String TEXT_277 = "\");";
  protected final String TEXT_278 = NL + "    String readFinishMarkWithPipeId_";
  protected final String TEXT_279 = " = \"";
  protected final String TEXT_280 = "_FINISH\"+(queue_";
  protected final String TEXT_281 = "==null?\"\":queue_";
  protected final String TEXT_282 = ".hashCode());" + NL + "    while(!globalMap.containsKey(readFinishMarkWithPipeId_";
  protected final String TEXT_283 = ") || !queue_";
  protected final String TEXT_284 = ".isEmpty()) {" + NL + "        if (!queue_";
  protected final String TEXT_285 = ".isEmpty()) {";
  protected final String TEXT_286 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_3);
    
            }
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_6);
    for(String message : messages){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
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
    
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
       			 if(log4jEnabled){
       			 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_15);
    
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
                    
    stringBuffer.append(TEXT_16);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_19);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    if(value.length()>10000){
                    value = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(value);
                    }
                    
    stringBuffer.append(TEXT_20);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_23);
    
                }   
                
    stringBuffer.append(TEXT_24);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_25);
    
            }
        }
		debug(var("log4jParamters"));
		
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_28);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_29);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_30);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_33);
    
                }else{
                
    stringBuffer.append(TEXT_34);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_42);
    
                }
                
    stringBuffer.append(TEXT_43);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_44);
    
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

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
LogUtil logUtil = new LogUtil(node);
String cid = node.getUniqueName();
String virtualcid = cid;
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
if(destination!=null && !"".equals(destination)){
    cid = destination;
}

boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
String conn = "TMDMService_" + connection;
String trans = "mdmTrans_" + connection;
String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
String username = ElementParameterParser.getValue(node, "__USERNAME__");

String dataModel = ElementParameterParser.getValue(node, "__DATAMODEL__");
String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
boolean isProvisioning = "\"PROVISIONING\"".equalsIgnoreCase(dataCluster);

boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));

boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));
boolean usePartialDelete = ("true").equals(ElementParameterParser.getValue(node,"__PARTIAL_DELETE__"));

boolean storeFlow = ("true").equals(ElementParameterParser.getValue(node, "__STORE_FLOW__"));
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    if(!usePartialUpdate){
    if(addTaskID){
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    }
    if(isMassInsert){
        if(!isStaging && withReport){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
        }else{
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
        }
        if(addTaskID){
    
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
        }
    }
}
    stringBuffer.append(TEXT_59);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    if(!useExistingConn){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
     logUtil.debug("\"Initializing web service from URL: \" + murl_" + cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
     String passwordFieldName = "__PASSWORD__"; 
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_95);
    } else {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_98);
    }
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    }else if(isProvisioning){
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_112);
     logUtil.debug("\"Initializing web service from URL: \" + murl_" + cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    }else{
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(trans);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_153);
     logUtil.debug("\"Initializing web service from URL: \" + murl_" + cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
     logUtil.debug("\"Got service successfully with key=\" + connKey_" + cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
     logUtil.debug("\"Attempt to get a remote transaction from url: \" + murl_" + cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
     logUtil.debug("\"Got transaction successfully with key=\" + transKey_" + cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    //For TDI-26109
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    }
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(isStaging?"#STAGING":"");
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(dataModel );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    
INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
String virtualSourceCid = sourceNode.getUniqueName();
INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
String startNodeCid = null;
if(startNode != null){
    startNodeCid = startNode.getUniqueName();
}
IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){

    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    
    if(storeFlow){
    
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    
    }
    
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_257);
    if(storeFlow){
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    }else{
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    }
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    
}else{
    if(storeFlow){
    
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    
    }
    
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_277);
    
}

    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(TEXT_286);
    return stringBuffer.toString();
  }
}

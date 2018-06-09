package org.talend.designer.codegen.translators.business.microsoft_crm;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;

public class TMicrosoftCrmOutputBeginJava
{
  protected static String nl;
  public static synchronized TMicrosoftCrmOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftCrmOutputBeginJava result = new TMicrosoftCrmOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint reConnMaxNum_";
  protected final String TEXT_3 = "=";
  protected final String TEXT_4 = ";" + NL + "\treConnMaxNum_";
  protected final String TEXT_5 = " = reConnMaxNum_";
  protected final String TEXT_6 = " >= 0 ? reConnMaxNum_";
  protected final String TEXT_7 = " : 0;";
  protected final String TEXT_8 = NL + "          ";
  protected final String TEXT_9 = "class CrmEntityHelper{" + NL + "      private com.microsoft.schemas.xrm._2011.contracts.services.IOrganizationService iorgService;" + NL + "      public CrmEntityHelper(){}" + NL + "      public CrmEntityHelper(com.microsoft.schemas.xrm._2011.contracts.services.IOrganizationService iorgService){" + NL + "             this.iorgService = iorgService;" + NL + "      }" + NL + "      public void setIOrgService(com.microsoft.schemas.xrm._2011.contracts.services.IOrganizationService iorgService){" + NL + "             this.iorgService = iorgService;" + NL + "      }" + NL + "      public com.microsoft.schemas.xrm._2011.contracts.services.IOrganizationService getIOrgService(){" + NL + "            return this.iorgService;" + NL + "      }" + NL + "" + NL + "      public com.microsoft.schemas.xrm._2011.contracts.Entity buildEntity(java.util.Map<String, Object> attrMap){" + NL + "             com.microsoft.schemas.xrm._2011.contracts.Entity" + NL + "                           entity = new com.microsoft.schemas.xrm._2011.contracts.Entity();" + NL + "             com.microsoft.schemas.xrm._2011.contracts.AttributeCollection" + NL + "                           attrColl = new com.microsoft.schemas.xrm._2011.contracts.AttributeCollection();" + NL + "             java.util.List<org.datacontract.schemas._2004._07.system_collections.KeyValuePairOfstringanyType>" + NL + "                          kvPairList = new java.util.ArrayList<org.datacontract.schemas._2004._07.system_collections.KeyValuePairOfstringanyType>();" + NL + "             java.util.Set<java.util.Map.Entry<String, Object>> set = attrMap.entrySet();" + NL + "             for(java.util.Map.Entry<String, Object> entry: set){" + NL + "                String key = entry.getKey();" + NL + "                Object value = entry.getValue();" + NL + "                if(\"Id\".equals(key)){" + NL + "                    com.microsoft.schemas._2003._10.serialization.Guid guid = new com.microsoft.schemas._2003._10.serialization.Guid();" + NL + "                    if(value instanceof java.lang.String){" + NL + "                        guid.setValue((String)value);" + NL + "                    }else{" + NL + "                        guid.setValue(value.toString());" + NL + "                    }" + NL + "                    entity.setId(guid);" + NL + "                }else{" + NL + "                    org.datacontract.schemas._2004._07.system_collections.KeyValuePairOfstringanyType" + NL + "                           kvPair = new org.datacontract.schemas._2004._07.system_collections.KeyValuePairOfstringanyType();" + NL + "                           kvPair.setKey(key);" + NL + "                           kvPair.setValue(value);" + NL + "                           kvPairList.add(kvPair);" + NL + "                }" + NL + "             }" + NL + "             attrColl.getKeyValuePairOfstringanyTypes().addAll(kvPairList);" + NL + "             entity.setAttributes(attrColl);" + NL + "             return entity;" + NL + "      }" + NL + "" + NL + "      public void createEntity(String entityName,java.util.Map<String, Object> attrMap){" + NL + "             com.microsoft.schemas.xrm._2011.contracts.Entity entity = buildEntity(attrMap);" + NL + "             entity.setLogicalName(entityName);" + NL + "             try{" + NL + "                 this.iorgService.create(entity);" + NL + "             }catch(Exception e){" + NL + "                 e.printStackTrace();" + NL + "             }" + NL + "      }" + NL + "" + NL + "      public void deleteEntity(String entityName, String guid){" + NL + "             com.microsoft.schemas._2003._10.serialization.Guid" + NL + "                 guidObj = new com.microsoft.schemas._2003._10.serialization.Guid();" + NL + "                 guidObj.setValue(guid);" + NL + "             try{" + NL + "                 this.iorgService.delete(entityName, guidObj);" + NL + "             }catch(Exception e){" + NL + "                 e.printStackTrace();" + NL + "             }" + NL + "      }" + NL + "" + NL + "      public void updateEntity(String entityName,java.util.Map<String, Object> attrMap){" + NL + "             com.microsoft.schemas.xrm._2011.contracts.Entity entity = buildEntity(attrMap);" + NL + "             entity.setLogicalName(entityName);" + NL + "             try{" + NL + "                 this.iorgService.update(entity);" + NL + "             }catch(Exception e){" + NL + "                 e.printStackTrace();" + NL + "             }" + NL + "      }" + NL + "}" + NL + "" + NL + "class XmlHelper{" + NL + "    public String parseXml(org.dom4j.Document document, String xpath){" + NL + "        @SuppressWarnings(\"unchecked\")" + NL + "        List<org.dom4j.Node> nodeList = document.selectNodes(xpath);" + NL + "        org.dom4j.Node node = nodeList.get(0);" + NL + "        return node.getStringValue();" + NL + "    }" + NL + "}" + NL;
  protected final String TEXT_10 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_11 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "; ";
  protected final String TEXT_16 = NL + "           System.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "            com.talend.microsoft.crm._2015_.utils.MsCrmWsdl" + NL + "                                 msCrmWsdl_";
  protected final String TEXT_19 = " = new com.talend.microsoft.crm._2015_.utils.MsCrmWsdl(";
  protected final String TEXT_20 = NL + "                                 ";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = NL + "                                 );" + NL + "            com.talend.microsoft.crm._2015_.utils.DynamicsCRMConnector" + NL + "                                crmConnector_";
  protected final String TEXT_23 = " = new com.talend.microsoft.crm._2015_.utils.DynamicsCRMConnector(";
  protected final String TEXT_24 = NL + "                                ";
  protected final String TEXT_25 = ", decryptedPassword_";
  protected final String TEXT_26 = ", msCrmWsdl_";
  protected final String TEXT_27 = NL + "                                );" + NL + "           com.microsoft.schemas.xrm._2011.contracts.services.IOrganizationService" + NL + "                                           iorgService_";
  protected final String TEXT_28 = " = crmConnector_";
  protected final String TEXT_29 = ".getOrganizationService();";
  protected final String TEXT_30 = NL + NL + "CrmEntityHelper crmEntityHelper_";
  protected final String TEXT_31 = " = new CrmEntityHelper(iorgService_";
  protected final String TEXT_32 = ");" + NL + "XmlHelper xmlHelper_";
  protected final String TEXT_33 = " = new XmlHelper();" + NL + "int nb_line_";
  protected final String TEXT_34 = " = 0;" + NL + "" + NL + "final String guid_xpath_";
  protected final String TEXT_35 = " = \"//entity_reference/guid\";" + NL + "final String logical_name_xpath_";
  protected final String TEXT_36 = " = \"//entity_reference/logical_name\";" + NL + "final String name_xpath_";
  protected final String TEXT_37 = " = \"//entity_reference/name\";";
  protected final String TEXT_38 = NL + "\tint nb_line_";
  protected final String TEXT_39 = " = 0;" + NL + "\t";
  protected final String TEXT_40 = NL + "\t\tString entitySetName_";
  protected final String TEXT_41 = "=";
  protected final String TEXT_42 = ";" + NL + "\t";
  protected final String TEXT_43 = NL + "\t\tString entitySetName_";
  protected final String TEXT_44 = "=\"";
  protected final String TEXT_45 = "\";" + NL + "\t";
  protected final String TEXT_46 = NL + "                    if(true){" + NL + "                        throw new RuntimeException(\"No key column is specified in the schema!\");" + NL + "                    }";
  protected final String TEXT_47 = NL + NL + "\t";
  protected final String TEXT_48 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_49 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_52 = " = ";
  protected final String TEXT_53 = "; ";
  protected final String TEXT_54 = NL + NL + "\t";
  protected final String TEXT_55 = NL + "    org.talend.ms.crm.odata.ClientConfiguration clientConfig_";
  protected final String TEXT_56 = " = org.talend.ms.crm.odata.ClientConfigurationFactory" + NL + "            .buildNtlmClientConfiguration(";
  protected final String TEXT_57 = ", decryptedPassword_";
  protected final String TEXT_58 = ", ";
  protected final String TEXT_59 = ", ";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\t\t    org.talend.ms.crm.odata.ClientConfiguration clientConfig_";
  protected final String TEXT_62 = " = org.talend.ms.crm.odata.ClientConfigurationFactory" + NL + "                    .buildOAuthNativeClientConfiguration(";
  protected final String TEXT_63 = ", ";
  protected final String TEXT_64 = ", decryptedPassword_";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = ");" + NL + "\t\t";
  protected final String TEXT_67 = NL + "    \t\torg.talend.ms.crm.odata.ClientConfiguration clientConfig_";
  protected final String TEXT_68 = " = org.talend.ms.crm.odata.ClientConfigurationFactory" + NL + "                    .buildOAuthWebClientConfiguration(";
  protected final String TEXT_69 = ", ";
  protected final String TEXT_70 = ",";
  protected final String TEXT_71 = ", decryptedPassword_";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = ");" + NL + "\t\t";
  protected final String TEXT_75 = NL + NL + "\tclientConfig_";
  protected final String TEXT_76 = ".setTimeout(";
  protected final String TEXT_77 = ");" + NL + "\tclientConfig_";
  protected final String TEXT_78 = ".setMaxRetry(reConnMaxNum_";
  protected final String TEXT_79 = ",";
  protected final String TEXT_80 = ");" + NL + "\tclientConfig_";
  protected final String TEXT_81 = ".setReuseHttpClient(";
  protected final String TEXT_82 = ");" + NL + "\torg.talend.ms.crm.odata.DynamicsCRMClient client_";
  protected final String TEXT_83 = " = new org.talend.ms.crm.odata.DynamicsCRMClient(clientConfig_";
  protected final String TEXT_84 = ",";
  protected final String TEXT_85 = ",entitySetName_";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "\tint nb_line_";
  protected final String TEXT_88 = " = 0;" + NL + "\t";
  protected final String TEXT_89 = NL + "\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.SimpleLog\");" + NL + "    System.setProperty(\"org.apache.commons.logging.simplelog.showdatetime\", \"true\");" + NL + "    System.setProperty(\"org.apache.commons.logging.simplelog.log.httpclient.wire\", \"debug\");" + NL + "    System.setProperty(\"org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient\", \"debug\");" + NL + "\t";
  protected final String TEXT_90 = NL + "\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\t";
  protected final String TEXT_91 = NL + NL + "\t";
  protected final String TEXT_92 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_93 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_96 = " = ";
  protected final String TEXT_97 = "; ";
  protected final String TEXT_98 = NL + NL + "\t";
  protected final String TEXT_99 = NL + "\t\t\torg.apache.commons.httpclient.auth.AuthPolicy.registerAuthScheme(org.apache.commons.httpclient.auth.AuthPolicy.NTLM, org.talend.mscrm.login.ntlm.JCIFS_NTLMScheme.class);" + NL + "" + NL + "\t\t\tcom.microsoft.crm4.webserviceTest.CrmServiceStub service_";
  protected final String TEXT_100 = " = new com.microsoft.crm4.webserviceTest.CrmServiceStub(";
  protected final String TEXT_101 = ");" + NL + "\t\t\torg.apache.axis2.client.Options options_";
  protected final String TEXT_102 = " = service_";
  protected final String TEXT_103 = "._getServiceClient().getOptions();" + NL + "\t\t\torg.apache.axis2.transport.http.HttpTransportProperties.Authenticator auth_";
  protected final String TEXT_104 = " = new org.apache.axis2.transport.http.HttpTransportProperties.Authenticator();" + NL + "" + NL + "\t\t\tList<String> authSchemes_";
  protected final String TEXT_105 = " = new java.util.ArrayList<String>();" + NL + "\t\t\tauthSchemes_";
  protected final String TEXT_106 = ".add(org.apache.axis2.transport.http.HttpTransportProperties.Authenticator.NTLM);" + NL + "\t\t\tauth_";
  protected final String TEXT_107 = " .setAuthSchemes(authSchemes_";
  protected final String TEXT_108 = ");" + NL + "" + NL + "            auth_";
  protected final String TEXT_109 = " .setUsername(";
  protected final String TEXT_110 = ");" + NL + "            auth_";
  protected final String TEXT_111 = " .setPassword(decryptedPassword_";
  protected final String TEXT_112 = ");" + NL + "            auth_";
  protected final String TEXT_113 = " .setHost(";
  protected final String TEXT_114 = ");" + NL + "            auth_";
  protected final String TEXT_115 = " .setPort(";
  protected final String TEXT_116 = ");" + NL + "            auth_";
  protected final String TEXT_117 = " .setDomain(";
  protected final String TEXT_118 = ");" + NL + "            auth_";
  protected final String TEXT_119 = " .setPreemptiveAuthentication(false);" + NL + "" + NL + "            options_";
  protected final String TEXT_120 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, auth_";
  protected final String TEXT_121 = ");" + NL + "            options_";
  protected final String TEXT_122 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.REUSE_HTTP_CLIENT, \"";
  protected final String TEXT_123 = "\");" + NL + "" + NL + "            options_";
  protected final String TEXT_124 = " .setUserName(";
  protected final String TEXT_125 = ");" + NL + "            options_";
  protected final String TEXT_126 = " .setPassword(decryptedPassword_";
  protected final String TEXT_127 = ");" + NL + "            options_";
  protected final String TEXT_128 = " .setTimeOutInMilliSeconds(Long.valueOf(";
  protected final String TEXT_129 = "));" + NL + "" + NL + "            options_";
  protected final String TEXT_130 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.SO_TIMEOUT,new Integer(";
  protected final String TEXT_131 = "));" + NL + "            options_";
  protected final String TEXT_132 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.CONNECTION_TIMEOUT, new Integer(";
  protected final String TEXT_133 = "));" + NL + "" + NL + "            com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument catd_";
  protected final String TEXT_134 = " = com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument.Factory.newInstance();" + NL + "            com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken token_";
  protected final String TEXT_135 = " = com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken.Factory.newInstance();" + NL + "            token_";
  protected final String TEXT_136 = ".setAuthenticationType(0);" + NL + "            token_";
  protected final String TEXT_137 = ".setOrganizationName(";
  protected final String TEXT_138 = ");" + NL + "            catd_";
  protected final String TEXT_139 = ".setCrmAuthenticationToken(token_";
  protected final String TEXT_140 = ");";
  protected final String TEXT_141 = NL + "        \tcom.microsoft.crm4.webserviceTest.CrmServiceStub service_";
  protected final String TEXT_142 = " = new com.microsoft.crm4.webserviceTest.CrmServiceStub(\"https://\" + ";
  protected final String TEXT_143 = " + \"/MSCrmServices/2007/CrmService.asmx\");" + NL + "\t\t\torg.apache.axis2.client.Options options_";
  protected final String TEXT_144 = " = service_";
  protected final String TEXT_145 = "._getServiceClient().getOptions();" + NL + "        \torg.talend.mscrm.login.passport.MsDynamicsWrapper msDynamicsWrapper_";
  protected final String TEXT_146 = " = new org.talend.mscrm.login.passport.MsDynamicsWrapper(";
  protected final String TEXT_147 = ",";
  protected final String TEXT_148 = ",";
  protected final String TEXT_149 = ",decryptedPassword_";
  protected final String TEXT_150 = ");" + NL + "\t\t\tmsDynamicsWrapper_";
  protected final String TEXT_151 = ".connect();" + NL + "\t\t\tString crmTicket_";
  protected final String TEXT_152 = " = msDynamicsWrapper_";
  protected final String TEXT_153 = ".getCrmTicket();" + NL + "" + NL + "        \toptions_";
  protected final String TEXT_154 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.REUSE_HTTP_CLIENT, \"";
  protected final String TEXT_155 = "\");" + NL + "        \toptions_";
  protected final String TEXT_156 = " .setTimeOutInMilliSeconds(Long.valueOf(";
  protected final String TEXT_157 = "));" + NL + "" + NL + "            options_";
  protected final String TEXT_158 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.SO_TIMEOUT,new Integer(";
  protected final String TEXT_159 = "));" + NL + "            options_";
  protected final String TEXT_160 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.CONNECTION_TIMEOUT, new Integer(";
  protected final String TEXT_161 = "));" + NL + "" + NL + "        \tcom.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument catd_";
  protected final String TEXT_162 = " = com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument.Factory.newInstance();" + NL + "            com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken token_";
  protected final String TEXT_163 = " = com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken.Factory.newInstance();" + NL + "            token_";
  protected final String TEXT_164 = ".setAuthenticationType(1);" + NL + "            token_";
  protected final String TEXT_165 = ".setOrganizationName(";
  protected final String TEXT_166 = ");" + NL + "            token_";
  protected final String TEXT_167 = ".setCrmTicket(crmTicket_";
  protected final String TEXT_168 = ");" + NL + "            catd_";
  protected final String TEXT_169 = ".setCrmAuthenticationToken(token_";
  protected final String TEXT_170 = ");" + NL + "    \t";
  protected final String TEXT_171 = NL + "    \torg.talend.ms.crm.MSCRMClient client_";
  protected final String TEXT_172 = " = new org.talend.ms.crm.MSCRMClient(";
  protected final String TEXT_173 = ", decryptedPassword_";
  protected final String TEXT_174 = ", ";
  protected final String TEXT_175 = ");" + NL + "\t\tclient_";
  protected final String TEXT_176 = ".setTimeout(";
  protected final String TEXT_177 = ");" + NL + "\t\tclient_";
  protected final String TEXT_178 = ".setReuseHttpClient(";
  protected final String TEXT_179 = ");" + NL + "\t\tclient_";
  protected final String TEXT_180 = ".setMaxConnectionRetries(reConnMaxNum_";
  protected final String TEXT_181 = ");" + NL + "\t\tclient_";
  protected final String TEXT_182 = ".setAttemptsInterval(";
  protected final String TEXT_183 = ");" + NL + "\t\tcom.microsoft.schemas.xrm._2011.contracts.OrganizationServiceStub serviceStub_";
  protected final String TEXT_184 = " = client_";
  protected final String TEXT_185 = ".getOnlineConnection(";
  protected final String TEXT_186 = ");";
  protected final String TEXT_187 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    String authenticationType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
    String crmVersion = ElementParameterParser.getValue(node, "__MS_CRM_VERSION__");

    boolean isMsCrm2015OnPremise = "ON_PREMISE".equals(authenticationType) && "CRM_2015".equals(crmVersion);
    
    String attemptConnTimes = ElementParameterParser.getValue(node, "__MAX_RECONN_ATTEMPS__");
	String attemptsInterval = ElementParameterParser.getValue(node, "__ATTEMPS_INTERVAL_TIME__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(attemptConnTimes);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
    if(isMsCrm2015OnPremise){
       
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    
    String domainUserName = ElementParameterParser.getValue(node, "__USERNAME__");

    String passwordFieldName = "__PASSWORD__";
    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_12);
    } else {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    }
    

    String organizationWsdl = ElementParameterParser.getValue(node, "__ORGANIZATION_WSDL__");
    String securityServiceWsdl = ElementParameterParser.getValue(node, "__SECURITY_SERVICE_URL__");
    String certificatePath = ElementParameterParser.getValue(node, "__CERTIFICATE_PATH__");

    if(certificatePath != null && !"".equals(certificatePath) && !"\"\"".equals(certificatePath)){
        
    stringBuffer.append(TEXT_16);
    stringBuffer.append( certificatePath );
    stringBuffer.append(TEXT_17);
    
    }
        
    stringBuffer.append(TEXT_18);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    stringBuffer.append( organizationWsdl );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( securityServiceWsdl );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    stringBuffer.append( domainUserName );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_29);
    
 
    stringBuffer.append(TEXT_30);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_37);
    
    }else{
        String crmOnlineVersion = ElementParameterParser.getValue(node, "__API_VERSION__");
    	  boolean isOnline2016WithOdata="ONLINE".equals(authenticationType) && "API_2016_ODATA".equals(crmOnlineVersion);
    	  boolean isMsCrm2016OnPremise = "ON_PREMISE".equals(authenticationType) && "CRM_2016".equals(crmVersion);    	  
    	  if(isOnline2016WithOdata || isMsCrm2016OnPremise){
    	  
    
    String domain = ElementParameterParser.getValue(node, "__DOMAIN__");
    String host = ElementParameterParser.getValue(node, "__HOST__");
	String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
	String onlineRegisterApp = ElementParameterParser.getValue(node, "__ONLINE_REGISTERED_APP__");
	String userName = ElementParameterParser.getValue(node, "__USERNAME__");
	String serviceURL = ElementParameterParser.getValue(node, "__SERVICE_ROOT_URL__");
	String applicationId = ElementParameterParser.getValue(node, "__APPLICATION_ID__");
	String clientSecret = ElementParameterParser.getValue(node, "__CLIENT_SECRET__");
	String authority = ElementParameterParser.getValue(node, "__AUTHORITY__");
	
	String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
	boolean reuseHttpClient = ("true").equals(ElementParameterParser.getValue(node,"__REUSE_HTTP_CLIENT__"));
	
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
	String passwordFieldName = "__PASSWORD__";
	String entitySetName = ElementParameterParser.getValue(node, "__ENTITYSET__").trim();
 	String customEntityName = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
 	if("CustomEntitySet".equals(entitySetName)){
	
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(customEntityName);
    stringBuffer.append(TEXT_42);
    
	}else{
	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(entitySetName);
    stringBuffer.append(TEXT_45);
    	
	}
	 String action = ElementParameterParser.getValue(node,"__ACTION__");
	 if("update".equals(action)){
	    List<IMetadataTable> metadatas = node.getMetadataList();
	    if ((metadatas!=null)&&(metadatas.size()>0)) {
	        IMetadataTable metadata = metadatas.get(0);
	        if (metadata!=null) {
			      List<IMetadataColumn> columns = metadata.getListColumns();
			      int sizeColumns = columns.size();
			      boolean hasKeyColumn=false;
			      for(int i = 0; i < sizeColumns; i++){
	        		    IMetadataColumn column = columns.get(i);
                   if(column.isKey()){
                        hasKeyColumn = true;
                        break;
                    }
                }
                if(!hasKeyColumn){
                
    stringBuffer.append(TEXT_46);
    
                }
            }
        }
    }
	
    stringBuffer.append(TEXT_47);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_50);
    } else {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    
    if(isMsCrm2016OnPremise) {
    
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_60);
    
    } else {
    	if("NATIVE".equals(onlineRegisterApp)){
		
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(applicationId);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(authority);
    stringBuffer.append(TEXT_66);
    
		}
		else {
			String permission = "org.talend.ms.crm.odata.ClientConfiguration.WebAppPermission.";
			permission += ("WEB_DELEGATED".equals(onlineRegisterApp)) ?  "DELEGATED" : "APPLICATION";
		
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(applicationId);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(clientSecret);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(authority);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(permission);
    stringBuffer.append(TEXT_74);
    
		}
    }
    
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(serviceURL);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
    	  }else{
        
    
	String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
	String endpointURL = ElementParameterParser.getValue(node, "__ENDPOINTURL__");
	String orgName = ElementParameterParser.getValue(node, "__ORGNAME__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");

	String domain = ElementParameterParser.getValue(node, "__DOMAIN__");
	String host = ElementParameterParser.getValue(node, "__HOST__");
	String port = ElementParameterParser.getValue(node, "__PORT__");
	String timeoutSecTemp = ElementParameterParser.getValue(node, "__TIMEOUT__");
	String timeoutSec = (timeoutSecTemp!=null&&!("").equals(timeoutSecTemp))?timeoutSecTemp:"2";
	int timeout = (int)(Double.valueOf(timeoutSec) * 1000);
	boolean reuseHttpClient = ("true").equals(ElementParameterParser.getValue(node,"__REUSE_HTTP_CLIENT__"));
	boolean debug = ("true").equals(ElementParameterParser.getValue(node,"__DEBUG__"));
	boolean isAPI2011 = ("API_2011").equals(ElementParameterParser.getValue(node,"__API_VERSION__"));
	String discWSDL = ElementParameterParser.getValue(node, "__DISC_WSDL__");
	
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    if(debug){
    stringBuffer.append(TEXT_89);
    }else{
    stringBuffer.append(TEXT_90);
    }

	String passwordFieldName = "__PASSWORD__";
	
    stringBuffer.append(TEXT_91);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_94);
    } else {
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    
	if(!isAPI2011 || ("ON_PREMISE").equals(authType)){
		if(("ON_PREMISE").equals(authType)){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(endpointURL);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    }else if(("ONLINE").equals(authType)){
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    }
    }else{
    
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(discWSDL);
    stringBuffer.append(TEXT_186);
    
    }
    
        }
    }

    stringBuffer.append(TEXT_187);
    return stringBuffer.toString();
  }
}

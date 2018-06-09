package org.talend.designer.codegen.translators.business.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TLDAPConnectionBeginJava
{
  protected static String nl;
  public static synchronized TLDAPConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPConnectionBeginJava result = new TLDAPConnectionBeginJava();
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
  protected final String TEXT_29 = NL + " ";
  protected final String TEXT_30 = NL + "java.util.Hashtable env_";
  protected final String TEXT_31 = " = new java.util.Hashtable();" + NL + "env_";
  protected final String TEXT_32 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, \"com.sun.jndi.ldap.LdapCtxFactory\");" + NL + "env_";
  protected final String TEXT_33 = ".put(javax.naming.Context.REFERRAL, \"";
  protected final String TEXT_34 = "\");" + NL + "env_";
  protected final String TEXT_35 = ".put(\"java.naming.ldap.derefAliases\",\"";
  protected final String TEXT_36 = "\");" + NL + "env_";
  protected final String TEXT_37 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_38 = "+\":\"+";
  protected final String TEXT_39 = "+\"/\"+";
  protected final String TEXT_40 = ");" + NL + "env_";
  protected final String TEXT_41 = ".put(\"com.sun.jndi.ldap.connect.pool\", \"true\");";
  protected final String TEXT_42 = NL + "\tenv_";
  protected final String TEXT_43 = ".put(javax.naming.Context.SECURITY_PROTOCOL, \"ssl\");" + NL + "\tenv_";
  protected final String TEXT_44 = ".put(\"java.naming.ldap.factory.socket\", \"talend.ssl.AdvancedSocketFactory\");";
  protected final String TEXT_45 = NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_47 = " - Adnanced CA trusting all certs.\");" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\ttalend.ssl.AdvancedSocketFactory.alwaysTrust();";
  protected final String TEXT_49 = NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_51 = " - Advanced CA using a store CA file and Keystore password.\");" + NL + "\t\t\t\tlog.debug(\"Store CA : '\" + ";
  protected final String TEXT_52 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePath(";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\t\t\t";
  protected final String TEXT_56 = NL + "        ";
  protected final String TEXT_57 = " " + NL + "                \tfinal String decryptedPwd_";
  protected final String TEXT_58 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "                \tfinal String decryptedPwd_";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = "; ";
  protected final String TEXT_63 = NL + "\t\t\t" + NL + "\t\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePassword(decryptedPwd_";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL;
  protected final String TEXT_66 = NL;
  protected final String TEXT_67 = NL + "\tlog.info(\"";
  protected final String TEXT_68 = " - Connection attempt to '\"+ ";
  protected final String TEXT_69 = " + \"'.\");";
  protected final String TEXT_70 = NL;
  protected final String TEXT_71 = NL + "\t";
  protected final String TEXT_72 = NL + "\tlog.info(\"";
  protected final String TEXT_73 = " - Authentication using username and password.\");" + NL + "\t";
  protected final String TEXT_74 = NL + "\t" + NL + "\t";
  protected final String TEXT_75 = NL + "  ";
  protected final String TEXT_76 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_77 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = "; ";
  protected final String TEXT_82 = NL;
  protected final String TEXT_83 = NL + "\t\tenv_";
  protected final String TEXT_84 = ".put(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");// \"none\",\"simple\",\"strong\"";
  protected final String TEXT_85 = NL + "    env_";
  protected final String TEXT_86 = ".put(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_87 = ");" + NL + "    env_";
  protected final String TEXT_88 = ".put(javax.naming.Context.SECURITY_CREDENTIALS, decryptedPassword_";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL;
  protected final String TEXT_91 = "javax.naming.ldap.InitialLdapContext";
  protected final String TEXT_92 = " ctx_";
  protected final String TEXT_93 = " = new javax.naming.ldap.InitialLdapContext(env_";
  protected final String TEXT_94 = ", null);" + NL;
  protected final String TEXT_95 = NL + "\tjavax.naming.ldap.StartTlsRequest tldsReq_";
  protected final String TEXT_96 = " = new javax.naming.ldap.StartTlsRequest();" + NL + "  javax.naming.ldap.StartTlsResponse tls_";
  protected final String TEXT_97 = " =(javax.naming.ldap.StartTlsResponse)ctx_";
  protected final String TEXT_98 = ".extendedOperation(tldsReq_";
  protected final String TEXT_99 = ");" + NL + "  javax.net.ssl.SSLSession session_";
  protected final String TEXT_100 = " = tls_";
  protected final String TEXT_101 = ".negotiate((javax.net.ssl.SSLSocketFactory)talend.ssl.AdvancedSocketFactory.getDefault());" + NL + "  ";
  protected final String TEXT_102 = NL + "  ctx_";
  protected final String TEXT_103 = ".addToEnvironment(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");" + NL + "  ctx_";
  protected final String TEXT_104 = ".addToEnvironment(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_105 = ");" + NL + "  ctx_";
  protected final String TEXT_106 = ".addToEnvironment(javax.naming.Context.SECURITY_CREDENTIALS, decryptedPassword_";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "  globalMap.put(\"tls_";
  protected final String TEXT_109 = "\",tls_";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL;
  protected final String TEXT_112 = NL + "\tlog.info(\"";
  protected final String TEXT_113 = " - Connection to '\"+";
  protected final String TEXT_114 = " + \"' has succeeded.\");";
  protected final String TEXT_115 = NL + NL + "globalMap.put(\"conn_";
  protected final String TEXT_116 = "\",ctx_";
  protected final String TEXT_117 = ");" + NL + "globalMap.put(\"connBaseDN_";
  protected final String TEXT_118 = "\",";
  protected final String TEXT_119 = ");";

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
	
    stringBuffer.append(TEXT_29);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
String host=ElementParameterParser.getValue(node, "__HOST__");
String port=ElementParameterParser.getValue(node, "__PORT__");
String protocol=ElementParameterParser.getValue(node, "__PROTOCOL__");
String advanced=ElementParameterParser.getValue(node, "__ADVANCEDCA__");
String storepath=ElementParameterParser.getValue(node, "__STORECA__");
String storepwd = ElementParameterParser.getValue(node, "__STORECAPWD__");
boolean useAuth = ("true").equals(ElementParameterParser.getValue(node, "__AUTHENTIFICATION__"));
boolean alwaysTrust = ("true").equals(ElementParameterParser.getValue(node, "__ALWAYS_TRUST__"));
String user =ElementParameterParser.getValue(node, "__USER__");

String referrals=ElementParameterParser.getValue(node, "__REFERRALS__");
String aliases=ElementParameterParser.getValue(node, "__ALIASES__");
String baseDN=ElementParameterParser.getValue(node, "__BASEDN__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(referrals);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(aliases);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(baseDN);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
if(("LDAPS").equals(protocol)){

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
}
if(("LDAPS").equals(protocol) || ("TLS").equals(protocol)){
	if(("true").equals(advanced)){
		if(alwaysTrust) {

    stringBuffer.append(TEXT_45);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    
		} else {

    stringBuffer.append(TEXT_49);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(storepath );
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(storepath);
    stringBuffer.append(TEXT_54);
    
			if(storepwd !=null && storepwd.length() !=0 ){
    stringBuffer.append(TEXT_55);
    
                String passwordFieldName = "__STORECAPWD__";
                
    stringBuffer.append(TEXT_56);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_59);
    } else {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
			}
		}
	}
}

    stringBuffer.append(TEXT_65);
    stringBuffer.append(TEXT_66);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    if(useAuth){
    stringBuffer.append(TEXT_71);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    
  String passwordFieldName = "__PASS__";
  
    stringBuffer.append(TEXT_75);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_78);
    } else {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_81);
    }
    }
    stringBuffer.append(TEXT_82);
    
	//the authentication is being performed after establishment of the TLS session
	if(!"TLS".equals(protocol)){
		//we only keep the logic like before now, we may need to move it in the "useAuth" block.

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
		if(useAuth){

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
		}
	}

    stringBuffer.append(TEXT_90);
    if(!cid.contains("tLDAPInput")){
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
if("TLS".equals(protocol)){

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    if(useAuth){
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    }
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
}

    stringBuffer.append(TEXT_111);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(baseDN);
    stringBuffer.append(TEXT_119);
    return stringBuffer.toString();
  }
}

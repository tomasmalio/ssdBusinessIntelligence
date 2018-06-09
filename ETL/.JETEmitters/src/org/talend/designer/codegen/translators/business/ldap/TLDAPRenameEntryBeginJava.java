package org.talend.designer.codegen.translators.business.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TLDAPRenameEntryBeginJava
{
  protected static String nl;
  public static synchronized TLDAPRenameEntryBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPRenameEntryBeginJava result = new TLDAPRenameEntryBeginJava();
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
  protected final String TEXT_30 = NL + "\tjava.util.Hashtable env_";
  protected final String TEXT_31 = " = new java.util.Hashtable();" + NL + "\tenv_";
  protected final String TEXT_32 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, \"com.sun.jndi.ldap.LdapCtxFactory\");" + NL + "\tenv_";
  protected final String TEXT_33 = ".put(javax.naming.Context.REFERRAL, \"";
  protected final String TEXT_34 = "\");" + NL + "\tenv_";
  protected final String TEXT_35 = ".put(\"java.naming.ldap.derefAliases\",\"";
  protected final String TEXT_36 = "\");";
  protected final String TEXT_37 = NL + "\tenv_";
  protected final String TEXT_38 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_39 = "+\":\"+";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\tenv_";
  protected final String TEXT_42 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_43 = "+\":\"+";
  protected final String TEXT_44 = "+\"/\"+";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = NL + "\tenv_";
  protected final String TEXT_47 = ".put(javax.naming.Context.SECURITY_PROTOCOL, \"ssl\");" + NL + "\tenv_";
  protected final String TEXT_48 = ".put(\"java.naming.ldap.factory.socket\", \"talend.ssl.AdvancedSocketFactory\");";
  protected final String TEXT_49 = NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_51 = " - Adnanced CA trusting all certs.\");" + NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\ttalend.ssl.AdvancedSocketFactory.alwaysTrust();";
  protected final String TEXT_53 = NL + "\t\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_55 = " - Advanced CA using a store CA file and Keystore password.\");" + NL + "\t\t\t\t\tlog.debug(\"Store CA : '\" + ";
  protected final String TEXT_56 = " + \"'.\");" + NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePath(";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "\t\t\t\t";
  protected final String TEXT_60 = NL + "            ";
  protected final String TEXT_61 = " " + NL + "                    \tfinal String decryptedPwd_";
  protected final String TEXT_62 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "                    \tfinal String decryptedPwd_";
  protected final String TEXT_65 = " = ";
  protected final String TEXT_66 = "; ";
  protected final String TEXT_67 = "\t\t\t\t" + NL + "    \t\t\t\t" + NL + "\t\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePassword(decryptedPwd_";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + NL + "\t";
  protected final String TEXT_70 = NL;
  protected final String TEXT_71 = NL + "\tlog.info(\"";
  protected final String TEXT_72 = " - Connection attempt to '\"+ ";
  protected final String TEXT_73 = " + \"'.\");";
  protected final String TEXT_74 = NL;
  protected final String TEXT_75 = NL + "\t";
  protected final String TEXT_76 = NL + "\tlog.info(\"";
  protected final String TEXT_77 = " - Authentication using username and password.\");" + NL + "\t";
  protected final String TEXT_78 = NL + "\t" + NL + "\t";
  protected final String TEXT_79 = NL + "  ";
  protected final String TEXT_80 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_81 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = "; ";
  protected final String TEXT_86 = NL;
  protected final String TEXT_87 = NL + "\t\tenv_";
  protected final String TEXT_88 = ".put(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");// \"none\",\"simple\",\"strong\"";
  protected final String TEXT_89 = NL + "    env_";
  protected final String TEXT_90 = ".put(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_91 = ");" + NL + "    env_";
  protected final String TEXT_92 = ".put(javax.naming.Context.SECURITY_CREDENTIALS, decryptedPassword_";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = NL;
  protected final String TEXT_95 = "javax.naming.ldap.InitialLdapContext";
  protected final String TEXT_96 = " ctx_";
  protected final String TEXT_97 = " = new javax.naming.ldap.InitialLdapContext(env_";
  protected final String TEXT_98 = ", null);" + NL;
  protected final String TEXT_99 = NL + "\tjavax.naming.ldap.StartTlsRequest tldsReq_";
  protected final String TEXT_100 = " = new javax.naming.ldap.StartTlsRequest();" + NL + "  javax.naming.ldap.StartTlsResponse tls_";
  protected final String TEXT_101 = " =(javax.naming.ldap.StartTlsResponse)ctx_";
  protected final String TEXT_102 = ".extendedOperation(tldsReq_";
  protected final String TEXT_103 = ");" + NL + "  javax.net.ssl.SSLSession session_";
  protected final String TEXT_104 = " = tls_";
  protected final String TEXT_105 = ".negotiate((javax.net.ssl.SSLSocketFactory)talend.ssl.AdvancedSocketFactory.getDefault());" + NL + "  ";
  protected final String TEXT_106 = NL + "  ctx_";
  protected final String TEXT_107 = ".addToEnvironment(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");" + NL + "  ctx_";
  protected final String TEXT_108 = ".addToEnvironment(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_109 = ");" + NL + "  ctx_";
  protected final String TEXT_110 = ".addToEnvironment(javax.naming.Context.SECURITY_CREDENTIALS, decryptedPassword_";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "  globalMap.put(\"tls_";
  protected final String TEXT_113 = "\",tls_";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL;
  protected final String TEXT_116 = NL + "\tlog.info(\"";
  protected final String TEXT_117 = " - Connection to '\"+";
  protected final String TEXT_118 = " + \"' has succeeded.\");";
  protected final String TEXT_119 = NL + "\t";
  protected final String TEXT_120 = NL + "javax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_121 = " = (javax.naming.ldap.InitialLdapContext)globalMap.get(\"";
  protected final String TEXT_122 = "\");" + NL + "\t";
  protected final String TEXT_123 = NL + "\t\tif(ctx_";
  protected final String TEXT_124 = "!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_125 = " - Uses an existing connection ,connection URL is: '\" + ctx_";
  protected final String TEXT_126 = ".getEnvironment().get(javax.naming.Context.PROVIDER_URL) + \"'.\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_127 = NL + "boolean whetherReject_";
  protected final String TEXT_128 = " = false;" + NL + "class LDAPRenameEntryUtil_";
  protected final String TEXT_129 = " {" + NL + "\t" + NL + "\tprivate java.util.Map<String, javax.naming.directory.Attributes> childs = new java.util.HashMap();" + NL + "\tprivate java.util.List<String> paths = new java.util.ArrayList();" + NL + "\t" + NL + "\tpublic void renameWithChilds(String oldName, String newName, javax.naming.ldap.InitialLdapContext ldapCtx) throws java.lang.Exception {" + NL + "\t\tthis.list(oldName, ldapCtx);" + NL + "\t\t" + NL + "\t\tthis.destroySubcontext(paths, ldapCtx);" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t\tldapCtx.rename(oldName, newName);" + NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\tthis.createSubcontext(paths, paths, childs, ldapCtx);" + NL + "\t\t\t" + NL + "\t\t\tthrow e;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tjava.util.List<String> newPaths = new java.util.ArrayList();" + NL + "\t\tfor (String childName : paths) {" + NL + "\t\t\tnewPaths.add(childName.replaceAll(oldName, newName));" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tthis.createSubcontext(newPaths, paths, childs, ldapCtx);" + NL + "\t}" + NL + "\tpublic void list(String rootName, javax.naming.ldap.InitialLdapContext ldapCtx) throws java.lang.Exception {" + NL + "\t\tjavax.naming.NamingEnumeration nern =ldapCtx.list(rootName);" + NL + "\t\twhile(nern.hasMore()){" + NL + "\t\t\tjavax.naming.NameClassPair nameCP= (javax.naming.NameClassPair)nern.next();" + NL + "\t\t\tchilds.put(nameCP.getName()+\",\"+rootName, ldapCtx.getAttributes(nameCP.getName()+\",\"+rootName));" + NL + "\t\t\tlist(nameCP.getName()+\",\"+rootName, ldapCtx);" + NL + "\t\t\tpaths.add(nameCP.getName()+\",\"+rootName);" + NL + "\t\t} " + NL + "\t}" + NL + "\t" + NL + "\tpublic void destroySubcontext(java.util.List<String> paths, javax.naming.ldap.InitialLdapContext ldapCtx)throws java.lang.Exception {" + NL + "\t\tfor (String childName : paths) {" + NL + "\t\t\tldapCtx.destroySubcontext(childName);" + NL + "\t\t}" + NL + "\t}" + NL + "\t\t" + NL + "\tpublic void createSubcontext(java.util.List<String> newPaths, java.util.List<String> oldPaths," + NL + "\t\t\t\t\t\t\t java.util.Map<String, javax.naming.directory.Attributes> childs, " + NL + "\t\t\t\t\t\t\tjavax.naming.ldap.InitialLdapContext ldapCtx)throws java.lang.Exception {" + NL + "\t\tfor (int i=newPaths.size(); i>0; i-- ) {" + NL + "\t\t\tldapCtx.createSubcontext(newPaths.get(i-1), childs.get(oldPaths.get(i-1)));" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "}" + NL + NL + NL + NL;
  protected final String TEXT_130 = NL;

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
	String baseDN=ElementParameterParser.getValue(node, "__BASEDN__");
	
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String exConn= "conn_" + connection;
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if(("false").equals(useExistingConn)){
	String host=ElementParameterParser.getValue(node, "__HOST__");
	String port=ElementParameterParser.getValue(node, "__PORT__");
	String protocol=ElementParameterParser.getValue(node, "__PROTOCOL__");
	String advanced=ElementParameterParser.getValue(node, "__ADVANCEDCA__");
	boolean alwaysTrust = ("true").equals(ElementParameterParser.getValue(node, "__ALWAYS_TRUST__"));
	String storepath=ElementParameterParser.getValue(node, "__STORECA__");
	String storepwd = ElementParameterParser.getValue(node, "__STORECAPWD__");
	boolean useAuth = "true".equals(ElementParameterParser.getValue(node, "__AUTHENTIFICATION__"));
	String user =ElementParameterParser.getValue(node, "__USER__");

	String referrals=ElementParameterParser.getValue(node, "__REFERRALS__");
	String aliases=ElementParameterParser.getValue(node, "__ALIASES__");

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
    
	if(baseDN == null || baseDN.length()<=2){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_40);
    
	}else{

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(baseDN);
    stringBuffer.append(TEXT_45);
    
	}
    if(("LDAPS").equals(protocol)){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
	}
	if(("LDAPS").equals(protocol) || ("TLS").equals(protocol)){
		if(("true").equals(advanced)){
			if(alwaysTrust) {

    stringBuffer.append(TEXT_49);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    
			} else {

    stringBuffer.append(TEXT_53);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(storepath );
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(storepath);
    stringBuffer.append(TEXT_58);
    
				if(storepwd !=null && storepwd.length() !=0 ){
    stringBuffer.append(TEXT_59);
    
                    String passwordFieldName = "__STORECAPWD__";
                    
    stringBuffer.append(TEXT_60);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_63);
    } else {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
				}
			}
		}
    }

    stringBuffer.append(TEXT_69);
    stringBuffer.append(TEXT_70);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    if(useAuth){
    stringBuffer.append(TEXT_75);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    
  String passwordFieldName = "__PASS__";
  
    stringBuffer.append(TEXT_79);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_82);
    } else {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_85);
    }
    }
    stringBuffer.append(TEXT_86);
    
	//the authentication is being performed after establishment of the TLS session
	if(!"TLS".equals(protocol)){
		//we only keep the logic like before now, we may need to move it in the "useAuth" block.

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
		if(useAuth){

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
		}
	}

    stringBuffer.append(TEXT_94);
    if(!cid.contains("tLDAPInput")){
    stringBuffer.append(TEXT_95);
    }
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
if("TLS".equals(protocol)){

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    if(useAuth){
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
}

    stringBuffer.append(TEXT_115);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    
}else{

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(exConn);
    stringBuffer.append(TEXT_122);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    }
    
}

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(TEXT_130);
    return stringBuffer.toString();
  }
}

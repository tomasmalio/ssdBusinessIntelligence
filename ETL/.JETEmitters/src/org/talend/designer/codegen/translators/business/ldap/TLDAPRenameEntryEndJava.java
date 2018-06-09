package org.talend.designer.codegen.translators.business.ldap;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TLDAPRenameEntryEndJava
{
  protected static String nl;
  public static synchronized TLDAPRenameEntryEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPRenameEntryEndJava result = new TLDAPRenameEntryEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t         log.info(\"";
  protected final String TEXT_2 = " - Closing the TLS connection.\");";
  protected final String TEXT_3 = NL + "        tls_";
  protected final String TEXT_4 = ".close();" + NL;
  protected final String TEXT_5 = NL + "\t         log.info(\"";
  protected final String TEXT_6 = " - TLS connection closed.\");";
  protected final String TEXT_7 = NL + "\t";
  protected final String TEXT_8 = NL + "\t\tlog.info(\"";
  protected final String TEXT_9 = " - Closing the connection to the server.\");" + NL + "\t";
  protected final String TEXT_10 = NL + "\tctx_";
  protected final String TEXT_11 = ".close();" + NL + "\t";
  protected final String TEXT_12 = NL + "\t\tlog.info(\"";
  protected final String TEXT_13 = " - Connection to the server closed.\");" + NL + "\t";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");

    
if(("false").equals(useExistingConn)){
    String protocol=ElementParameterParser.getValue(node, "__PROTOCOL__");
    
    if("TLS".equals(protocol)){
        if(isLog4jEnabled){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
        }

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
        if(isLog4jEnabled){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
        }
    }

    stringBuffer.append(TEXT_7);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    }
    
}

    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}

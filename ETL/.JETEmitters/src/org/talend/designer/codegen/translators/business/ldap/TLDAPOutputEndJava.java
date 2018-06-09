package org.talend.designer.codegen.translators.business.ldap;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TLDAPOutputEndJava
{
  protected static String nl;
  public static synchronized TLDAPOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPOutputEndJava result = new TLDAPOutputEndJava();
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
  protected final String TEXT_14 = NL + "globalMap.put(\"";
  protected final String TEXT_15 = "_NB_LINE\", nb_line_";
  protected final String TEXT_16 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_17 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\tlog.info(\"";
  protected final String TEXT_20 = " - Written records count: \" + nb_line_";
  protected final String TEXT_21 = " + \".\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    }
    return stringBuffer.toString();
  }
}

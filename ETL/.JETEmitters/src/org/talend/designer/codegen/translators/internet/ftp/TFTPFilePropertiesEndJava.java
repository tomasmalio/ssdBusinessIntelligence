package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.IConnectionCategory;

public class TFTPFilePropertiesEndJava
{
  protected static String nl;
  public static synchronized TFTPFilePropertiesEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFilePropertiesEndJava result = new TFTPFilePropertiesEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\tlog.info(\"";
  protected final String TEXT_3 = " - Closing the connection to the server.\");" + NL + "\t";
  protected final String TEXT_4 = NL + "\tsession_";
  protected final String TEXT_5 = ".disconnect(); " + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tlog.info(\"";
  protected final String TEXT_7 = " - Connection to the server closed.\");" + NL + "\t";
  protected final String TEXT_8 = "  ";
  protected final String TEXT_9 = NL + "\t";
  protected final String TEXT_10 = NL + "\t\tlog.info(\"";
  protected final String TEXT_11 = " - Closing the connection to the server.\");" + NL + "\t";
  protected final String TEXT_12 = NL + "\tftp_";
  protected final String TEXT_13 = ".disconnect();" + NL + "\t";
  protected final String TEXT_14 = NL + "\t\tlog.info(\"";
  protected final String TEXT_15 = " - Connection to the server closed.\");" + NL + "\t";
  protected final String TEXT_16 = NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_18 = " - Closing the connection to the server.\");" + NL + "\t\t\t\t";
  protected final String TEXT_19 = NL + "    \t\t    ftp_";
  protected final String TEXT_20 = ".quit();" + NL + "\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_22 = " - Connection to the server closed.\");" + NL + "\t\t\t\t";
  protected final String TEXT_23 = "  " + NL + "\t\t\t} catch (java.net.SocketException se_";
  protected final String TEXT_24 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_26 = " - \" + se_";
  protected final String TEXT_27 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_28 = " " + NL + "        \t//ignore failure" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_29 = NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_31 = " - Closing the connection to the server.\");" + NL + "\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\tftp_";
  protected final String TEXT_33 = ".quit();" + NL + "\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_35 = " - Connection to the server closed.\");" + NL + "\t\t\t";
  protected final String TEXT_36 = "  ";
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String ignoreFailureAtQuit= ElementParameterParser.getValue(node,"__IGNORE_FAILURE_AT_QUIT__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
boolean bUseExistingConn = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
boolean sftp = false;
boolean ftps = false;

String outputConnName = null;
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

if (conns != null) {
  if (conns.size() > 0) {
    for (int i = 0; i < conns.size(); i++) {
      IConnection connTemp = conns.get(i);
      if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        outputConnName = connTemp.getName();
        break;
      }
    }
  }
}

if (outputConnName == null) {
  return "";
}

if (bUseExistingConn) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();

  for (INode n : nodeList) {
    if (n.getUniqueName().equals(connection)) {
      sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
      ftps = ("true").equals(ElementParameterParser.getValue(n, "__FTPS__"));
    }
  }
} else {
  sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
  ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__"));
}

if (sftp && !bUseExistingConn) { // *** sftp *** //

    stringBuffer.append(TEXT_1);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    
} else if (ftps && !bUseExistingConn) {

    stringBuffer.append(TEXT_9);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    
} else {// *** ftp *** //
	if (!bUseExistingConn) {
    	if (("true").equals(ignoreFailureAtQuit)) {
    
    stringBuffer.append(TEXT_16);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    } else {
    stringBuffer.append(TEXT_29);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    
		}
  	}
}

    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}

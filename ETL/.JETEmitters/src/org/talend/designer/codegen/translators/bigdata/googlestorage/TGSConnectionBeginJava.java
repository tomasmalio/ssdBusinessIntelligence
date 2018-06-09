package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGSConnectionBeginJava
{
  protected static String nl;
  public static synchronized TGSConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSConnectionBeginJava result = new TGSConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_3 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = "; ";
  protected final String TEXT_8 = NL + "\t   " + NL + "org.jets3t.service.Jets3tProperties jets3tProperties = new org.jets3t.service.Jets3tProperties();" + NL + "jets3tProperties.setProperty(\"httpclient.useragent\", \"";
  protected final String TEXT_9 = "\");" + NL + "org.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_10 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_11 = ",decryptedPassword_";
  protected final String TEXT_12 = ");" + NL + "org.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_13 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_14 = ",\" ";
  protected final String TEXT_15 = "\", null, jets3tProperties);" + NL + "service_";
  protected final String TEXT_16 = ".getAccountOwner();" + NL + "globalMap.put(\"service_\" + \"";
  protected final String TEXT_17 = "\",service_";
  protected final String TEXT_18 = ");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
String passwordFieldName = "__SECRET_KEY__";
final String AWSTracker = org.talend.core.utils.TrackerUtil.getAWSTracker();
final String GoogleTracker = org.talend.core.utils.TrackerUtil.getGoogleTracker();

    stringBuffer.append(TEXT_1);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_4);
    } else {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(AWSTracker);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(GoogleTracker);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}

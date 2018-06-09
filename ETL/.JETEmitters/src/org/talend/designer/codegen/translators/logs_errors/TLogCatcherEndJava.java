package org.talend.designer.codegen.translators.logs_errors;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TLogCatcherEndJava
{
  protected static String nl;
  public static synchronized TLogCatcherEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogCatcherEndJava result = new TLogCatcherEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t}" + NL + "} catch (Exception e_";
  protected final String TEXT_2 = ") {" + NL + "\tlogIgnoredError(String.format(\"";
  protected final String TEXT_3 = " - tLogCatcher failed to process log message(s) due to internal error: %s\", e_";
  protected final String TEXT_4 = "), e_";
  protected final String TEXT_5 = ");" + NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}

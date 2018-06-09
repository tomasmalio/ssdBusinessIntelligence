package org.talend.designer.codegen.translators.logs_errors;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TDieMainJava
{
  protected static String nl;
  public static synchronized TDieMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDieMainJava result = new TDieMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\ttry {";
  protected final String TEXT_3 = NL + "\t\t\t\t";
  protected final String TEXT_4 = ".addMessage(\"tDie\", \"";
  protected final String TEXT_5 = "\", ";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_9 = "Process(globalMap);" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_11 = "_DIE_PRIORITY\", ";
  protected final String TEXT_12 = ");" + NL + "\tSystem.err.println(";
  protected final String TEXT_13 = ");" + NL + "\t";
  protected final String TEXT_14 = NL + "\t\tlog.error(\"";
  protected final String TEXT_15 = " - The die message: \"+";
  protected final String TEXT_16 = ");" + NL + "\t";
  protected final String TEXT_17 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_18 = "_DIE_MESSAGE\", ";
  protected final String TEXT_19 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_20 = "_DIE_MESSAGES\", ";
  protected final String TEXT_21 = ");" + NL + "\t" + NL + "\t} catch (Exception | Error e_";
  protected final String TEXT_22 = ") {" + NL + "\t\tlogIgnoredError(String.format(\"";
  protected final String TEXT_23 = " - tDie failed to log message due to internal error: %s\", e_";
  protected final String TEXT_24 = "), e_";
  protected final String TEXT_25 = ");" + NL + "\t}" + NL + "\t" + NL + "\tcurrentComponent = \"";
  protected final String TEXT_26 = "\";" + NL + "\tstatus = \"failure\";";
  protected final String TEXT_27 = NL + "    \terrorCode = new Integer(";
  protected final String TEXT_28 = ");" + NL + "        ((java.util.Map)threadLocal.get()).put(\"errorCode\", new Integer(";
  protected final String TEXT_29 = "));" + NL + "        ((java.util.Map)threadLocal.get()).put(\"status\", \"failure\");" + NL + "        globalMap.put(\"";
  protected final String TEXT_30 = "_DIE_CODE\", errorCode);";
  protected final String TEXT_31 = NL + "        errorCode = new Integer(";
  protected final String TEXT_32 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_33 = "_DIE_CODE\", errorCode);        ";
  protected final String TEXT_34 = NL + "    ";
  protected final String TEXT_35 = NL + "\t";
  protected final String TEXT_36 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_37 = " - Exiting the VM.\");" + NL + "\t";
  protected final String TEXT_38 = NL + "\tSystem.exit(";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\tif(true){\t" + NL + "\t    throw new TDieException();" + NL + "\t}";
  protected final String TEXT_41 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();
	boolean exitJVM = ("true").equals(ElementParameterParser.getValue(node, "__EXIT_JVM__"));
	String code = ElementParameterParser.getValue(node, "__CODE__");
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    
	if (node.getProcess().getNodesOfType("tLogCatcher").size() > 0) {
		List<INode> logCatchers = (List<INode>)node.getProcess().getNodesOfType("tLogCatcher");
		for (INode logCatcher : logCatchers) {
			if (("true").equals(ElementParameterParser.getValue(logCatcher, "__CATCH_TDIE__"))) {
				
    stringBuffer.append(TEXT_3);
    stringBuffer.append(logCatcher.getUniqueName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PRIORITY__") );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MESSAGE__") );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CODE__") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(logCatcher.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_9);
    
			}
		}
	}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PRIORITY__") );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MESSAGE__") );
    stringBuffer.append(TEXT_13);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MESSAGE__") );
    stringBuffer.append(TEXT_16);
    
	}
	
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MESSAGE__") );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MESSAGE__") );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
    if(isRunInMultiThread ){
    
    stringBuffer.append(TEXT_27);
    stringBuffer.append(code );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(code );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    
        }else {
    
    stringBuffer.append(TEXT_31);
    stringBuffer.append(code );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
        }
    
    stringBuffer.append(TEXT_34);
     if(exitJVM) {
    stringBuffer.append(TEXT_35);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
	}
	
    stringBuffer.append(TEXT_38);
    stringBuffer.append(code );
    stringBuffer.append(TEXT_39);
    }else{
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}

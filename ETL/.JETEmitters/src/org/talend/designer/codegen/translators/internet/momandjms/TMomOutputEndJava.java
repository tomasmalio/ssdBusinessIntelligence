package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TMomOutputEndJava
{
  protected static String nl;
  public static synchronized TMomOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputEndJava result = new TMomOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t \tglobalMap.put(\"producer_";
  protected final String TEXT_3 = "\",producer_";
  protected final String TEXT_4 = ");" + NL + "\t\t \tglobalMap.put(\"session_";
  protected final String TEXT_5 = "\",session_";
  protected final String TEXT_6 = ");" + NL + "\t\t \tglobalMap.put(\"connection_";
  protected final String TEXT_7 = "\",connection_";
  protected final String TEXT_8 = ");" + NL + "\t\t ";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Committing the session...\");" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\tsession_";
  protected final String TEXT_12 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Commit successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Closing connection...\");" + NL + "\t\t\t";
  protected final String TEXT_17 = " // if no commmit or rollback component exists - close session" + NL + " \t\t\tSystem.out.println(\"Closing connection\");" + NL + "            session_";
  protected final String TEXT_18 = ".close();" + NL + "            connection_";
  protected final String TEXT_19 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_21 = " - Closed successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "                log.info(\"";
  protected final String TEXT_23 = " - Closing producer...\");";
  protected final String TEXT_24 = NL + "            producer_";
  protected final String TEXT_25 = ".close();";
  protected final String TEXT_26 = NL + "                log.info(\"";
  protected final String TEXT_27 = " - Closed successfully.\");";
  protected final String TEXT_28 = NL + "\t\tresourceMap.put(\"finish_";
  protected final String TEXT_29 = "\", true); " + NL + "\t";
  protected final String TEXT_30 = NL + "\t\tglobalMap.put(\"qMgr_";
  protected final String TEXT_31 = "\",qMgr_";
  protected final String TEXT_32 = ");" + NL + "\t";
  protected final String TEXT_33 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_34 = " - Disconnecting connection...\");" + NL + "\t\t";
  protected final String TEXT_35 = NL + "\t\tSystem.out.println(\"Disconnecting queue\");" + NL + "\t\tremoteQ_";
  protected final String TEXT_36 = ".close();" + NL + "\t\t";
  protected final String TEXT_37 = NL + "\t\t\tSystem.out.println(\"Disconnecting queue manager\");" + NL + "\t\t\tqMgr_";
  protected final String TEXT_38 = ".disconnect();" + NL + "\t\t";
  protected final String TEXT_39 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_40 = " - Disconnected successfully.\");" + NL + "\t\t";
  protected final String TEXT_41 = NL + "\tlog.info(\"";
  protected final String TEXT_42 = " - Written records count: \"+ nb_line_";
  protected final String TEXT_43 = " + \" .\");";
  protected final String TEXT_44 = NL + NL + "    globalMap.put(\"";
  protected final String TEXT_45 = "_NB_LINE\",nb_line_";
  protected final String TEXT_46 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean isUseExistConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
String cid = node.getUniqueName();
String serverType=ElementParameterParser.getValue(node, "__SERVER__");
boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");

List<? extends INode> commitNodes=node.getProcess().getNodesOfType("tMomCommit");
List<? extends INode> rollBackNodes=node.getProcess().getNodesOfType("tMomRollback");

boolean isCommitRollback = false;
for(INode cNode:commitNodes){
	String cNodeName = ElementParameterParser.getValue(cNode,"__CONNECTION__");
	if(cid.equals(cNodeName) || (isUseExistConnection && connectionComponentName.equals(cNodeName))){
		isCommitRollback = true;
		break;
	}
}
if(!isCommitRollback){
	for(INode rNode:rollBackNodes){
		String rNodeName = ElementParameterParser.getValue(rNode,"__CONNECTION__");
		if(cid.equals(rNodeName) || (isUseExistConnection && connectionComponentName.equals(rNodeName))){
			isCommitRollback = true;
			break;
		}
	}
}
final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 

if (isUseExistConnection) {
	for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
		if (pNode.getUniqueName().equals(connectionComponentName)) {
			transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
			serverType=ElementParameterParser.getValue(pNode, "__SERVER__");
		}	
	}
}

if(("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)){
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
	if( ("JBoss").equals(serverType) || ( ("ActiveMQ").equals(serverType)) ){
		 if (isCommitRollback && transacted) {
		 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
		 }
		// if no commmit or rollback component exists and set transacted - commit session
		if(!isCommitRollback && transacted){
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			}
		}
        if (!isCommitRollback && !isUseExistConnection) {
        	if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    	
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
			}
            if (isLog4jEnabled) {
            
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
            }
            
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
            if (isLog4jEnabled) {
            
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
            }
		}
	}
	if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
	
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
	}
}else{//server judgement   /***WebSphere MQ*****/
	if (transacted) {
	
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
	} else {
		if (!isUseExistConnection && isLog4jEnabled && !isCommitRollback) {
		
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
		}
		
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
		if(!isUseExistConnection && !isCommitRollback){
		
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
		}
		if (!isUseExistConnection && isLog4jEnabled && !isCommitRollback) {
		
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
		}
	}
}
if (isLog4jEnabled) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.cloud.amazon.sqs;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TSQSOutputMainJava
{
  protected static String nl;
  public static synchronized TSQSOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSQSOutputMainJava result = new TSQSOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tsendMsgRequest_";
  protected final String TEXT_3 = " = new com.amazonaws.services.sqs.model.";
  protected final String TEXT_4 = "();" + NL + "\t\t\t\tsendMsgRequest_";
  protected final String TEXT_5 = ".setQueueUrl(";
  protected final String TEXT_6 = ");" + NL + "\t\t\t\tnbline_";
  protected final String TEXT_7 = "++;";
  protected final String TEXT_8 = NL + "\t\t\t\t\tcom.amazonaws.services.sqs.model.SendMessageBatchRequestEntry entry_";
  protected final String TEXT_9 = " = new com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry();" + NL + "\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\t\tentry_";
  protected final String TEXT_11 = ".setMessageBody(";
  protected final String TEXT_12 = ".Body);" + NL + "\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\t\tsendMsgRequest_";
  protected final String TEXT_14 = ".setMessageBody(";
  protected final String TEXT_15 = ".Body);\t\t\t\t\t\t\t" + NL + "\t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\t\tentry_";
  protected final String TEXT_17 = ".setMessageDeduplicationId(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ");" + NL + "\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\t        sendMsgRequest_";
  protected final String TEXT_21 = ".setMessageDeduplicationId(";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t\tentry_";
  protected final String TEXT_25 = ".setMessageGroupId(";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = ");" + NL + "\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t        sendMsgRequest_";
  protected final String TEXT_29 = ".setMessageGroupId(";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\t\tif(";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = " != null){" + NL + "\t\t\t\t\t\t\t\tcom.amazonaws.services.sqs.model.MessageAttributeValue ";
  protected final String TEXT_35 = "_";
  protected final String TEXT_36 = "_messageAttributeValue = new com.amazonaws.services.sqs.model.MessageAttributeValue();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_37 = "_";
  protected final String TEXT_38 = "_messageAttributeValue.setDataType(\"";
  protected final String TEXT_39 = "\");";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_41 = "_";
  protected final String TEXT_42 = "_messageAttributeValue.setBinaryValue(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = "));";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = "_messageAttributeValue.setStringValue(String.valueOf(";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = "));";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\t\t\t\tentry_";
  protected final String TEXT_51 = ".addMessageAttributesEntry(\"";
  protected final String TEXT_52 = "\", ";
  protected final String TEXT_53 = "_";
  protected final String TEXT_54 = "_messageAttributeValue);" + NL + "\t";
  protected final String TEXT_55 = NL + "\t\t\t\t\t\t\t\t\tsendMsgRequest_";
  protected final String TEXT_56 = ".addMessageAttributesEntry(\"";
  protected final String TEXT_57 = "\", ";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = "_messageAttributeValue);" + NL + "\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\t\t\t}" + NL + "\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\tentry_";
  protected final String TEXT_62 = ".setId(String.valueOf(nbline_";
  protected final String TEXT_63 = "));" + NL + "    \t\t\t\tentries_";
  protected final String TEXT_64 = ".add(entry_";
  protected final String TEXT_65 = ");" + NL + "    \t\t\t\tif(entries_";
  protected final String TEXT_66 = ".size() >0 && entries_";
  protected final String TEXT_67 = ".size() >= ";
  protected final String TEXT_68 = "){" + NL + "    \t\t\t\t\tsendMsgRequest_";
  protected final String TEXT_69 = ".setEntries(entries_";
  protected final String TEXT_70 = ");" + NL + "\t";
  protected final String TEXT_71 = NL + "\t\t\t\t\t\t\tlog.debug(\"Sending the message with batch request\" );" + NL + "\t";
  protected final String TEXT_72 = NL + "    \t\t\t\t\tcom.amazonaws.services.sqs.model.SendMessageBatchResult sendMsgResult_";
  protected final String TEXT_73 = " = conn_";
  protected final String TEXT_74 = ".sendMessageBatch(sendMsgRequest_";
  protected final String TEXT_75 = ");" + NL + "    \t\t\t\t\tresultSuccessEntries_";
  protected final String TEXT_76 = " =  sendMsgResult_";
  protected final String TEXT_77 = ".getSuccessful();" + NL + "    \t\t\t\t\tresultErrorEntries_";
  protected final String TEXT_78 = " =  sendMsgResult_";
  protected final String TEXT_79 = ".getFailed();" + NL + "    \t\t\t\t\tnb_success_";
  protected final String TEXT_80 = " = nb_success_";
  protected final String TEXT_81 = " + resultSuccessEntries_";
  protected final String TEXT_82 = ".size();" + NL + "    \t\t\t\t\tnb_reject_";
  protected final String TEXT_83 = " = nb_reject_";
  protected final String TEXT_84 = " + resultErrorEntries_";
  protected final String TEXT_85 = ".size();" + NL + "\t";
  protected final String TEXT_86 = "\t" + NL + "                \t\t\tlog.debug(\"";
  protected final String TEXT_87 = " - \"+resultSuccessEntries_";
  protected final String TEXT_88 = ".size()+\" messages were sent successfully:\");" + NL + "                \t\t\tfor(com.amazonaws.services.sqs.model.SendMessageBatchResultEntry resultEntry_";
  protected final String TEXT_89 = ":resultSuccessEntries_";
  protected final String TEXT_90 = "){" + NL + "                \t\t\t\tlog.debug(\"";
  protected final String TEXT_91 = " - Message Start: \");" + NL + "                    \t\t\tlog.debug(\"";
  protected final String TEXT_92 = " - MessageId: \" + resultEntry_";
  protected final String TEXT_93 = ".getMessageId());" + NL + "                    \t\t\tlog.debug(\"";
  protected final String TEXT_94 = " - MD5OfBody: \" + resultEntry_";
  protected final String TEXT_95 = ".getMD5OfMessageBody());" + NL + "                    \t\t\tlog.debug(\"";
  protected final String TEXT_96 = " - Message End \");" + NL + "                    \t\t}" + NL + "                    \t\tlog.debug(\"";
  protected final String TEXT_97 = " - \"+resultErrorEntries_";
  protected final String TEXT_98 = ".size()+\" messages were sent failed:\");" + NL + "                \t\t\tfor(com.amazonaws.services.sqs.model.BatchResultErrorEntry resultErrorEntry_";
  protected final String TEXT_99 = ":resultErrorEntries_";
  protected final String TEXT_100 = "){" + NL + "                \t\t\t\tlog.debug(\"";
  protected final String TEXT_101 = " - Error row number: \" + resultErrorEntry_";
  protected final String TEXT_102 = ".getId());" + NL + "                    \t\t\tlog.debug(\"";
  protected final String TEXT_103 = " - Error code: \" + resultErrorEntry_";
  protected final String TEXT_104 = ".getCode());" + NL + "                    \t\t\tlog.debug(\"";
  protected final String TEXT_105 = " - Error message: \" + resultErrorEntry_";
  protected final String TEXT_106 = ".getMessage());" + NL + "                    \t\t}" + NL + "\t";
  protected final String TEXT_107 = NL + "\t\t\t\t\t\tentries_";
  protected final String TEXT_108 = ".clear();" + NL + "\t\t\t\t\t}" + NL + "\t";
  protected final String TEXT_109 = NL + "\t\t\t\t\t\tlog.debug(\"Sending the message\" );" + NL + "\t";
  protected final String TEXT_110 = NL + "    \t\t\t\tcom.amazonaws.services.sqs.model.SendMessageResult sendMsgResult_";
  protected final String TEXT_111 = " = conn_";
  protected final String TEXT_112 = ".sendMessage(sendMsgRequest_";
  protected final String TEXT_113 = ");" + NL + "    \t\t\t\tnb_success_";
  protected final String TEXT_114 = "++;" + NL + "\t";
  protected final String TEXT_115 = "\t" + NL + "            \t\t\tlog.debug(\"";
  protected final String TEXT_116 = " - Message Start: \");" + NL + "            \t\t\tlog.debug(\"";
  protected final String TEXT_117 = " - MessageId: \" + sendMsgResult_";
  protected final String TEXT_118 = ".getMessageId());" + NL + "            \t\t\tlog.debug(\"";
  protected final String TEXT_119 = " - MD5OfBody: \" + sendMsgResult_";
  protected final String TEXT_120 = ".getMD5OfMessageBody());" + NL + "            \t\t\tlog.debug(\"";
  protected final String TEXT_121 = " - Message End \");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String queueUrl = ElementParameterParser.getValue(node,"__QUEUE_URL__");
    boolean dieOnError = "true".equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    boolean useBatch = "true".equals(ElementParameterParser.getValue(node,"__USE_BATCH__"));
    String batchSize = ElementParameterParser.getValue(node,"__BATCH_SIZE__");
    String messageGroupId = ElementParameterParser.getValue(node,"__GROUP_ID__");
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		List<IMetadataColumn> columns = metadata.getListColumns();
		List< ? extends IConnection> conns = node.getIncomingConnections();
		if((conns!=null)&&(conns.size()>0)) {
			IConnection conn = conns.get(0);		
			if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN)||conn.getLineStyle().equals(EConnectionType.FLOW_MERGE)){
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(useBatch?"SendMessageBatchRequest":"SendMessageRequest");
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(queueUrl);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
				if(useBatch){
	
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
				}
				for (int i = 0; i < columns.size(); i++) {
					IMetadataColumn column = columns.get(i);
					if (column.getLabel().equals("Body")) {
						if(useBatch){
	
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_12);
    
						}else{
	
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_15);
     
						}
					}else if (column.getLabel().equalsIgnoreCase("MessageDeduplicationId")){
						if(useBatch){
	
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_19);
    
						}else{
						
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    
						}
					}else if (column.getLabel().equalsIgnoreCase("MessageGroupId")){
						if(useBatch){
	
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_27);
    
						}else{
						
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_31);
    
						}
					}else{
						String dataType=null;;
						if ("id_String".equals(column.getTalendType())) {
							dataType="String";
						}else if (JavaTypesManager.isNumber(column.getTalendType())){
							dataType="Number";
						}else if ("id_byte[]".equals(column.getTalendType())){
							dataType="Binary";
						}
						if(dataType!=null){
	
    stringBuffer.append(TEXT_32);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dataType);
    stringBuffer.append(TEXT_39);
    
								if ("Binary".equals(dataType)){
    
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_44);
    
								}else{ 
    
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_49);
    
								}
								if(useBatch){
	
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_54);
    
								}else{
	
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_59);
     
								}
    
    stringBuffer.append(TEXT_60);
    
						}
					}
				}
				if(useBatch){
	
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
						if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_71);
    
						}
	
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
						if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
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
    
						}
	
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
				}else{
					if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_109);
    
					}
	
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
					if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
					}
				}
			}
		}
	}
	
    return stringBuffer.toString();
  }
}

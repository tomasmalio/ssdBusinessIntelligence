package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGSCopyMainJava
{
  protected static String nl;
  public static synchronized TGSCopyMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSCopyMainJava result = new TGSCopyMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_3 = " = null;" + NL + "\ttry {" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\t\tservice_";
  protected final String TEXT_5 = " = (org.jets3t.service.impl.rest.httpclient.GoogleStorageService)globalMap.get(\"service_";
  protected final String TEXT_6 = "\");" + NL + "\t\t\t";
  protected final String TEXT_7 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Get an free connection from \" + \"";
  protected final String TEXT_9 = "\" + \".\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t" + NL + "\t       \t";
  protected final String TEXT_11 = NL + "\t" + NL + "\t\t   ";
  protected final String TEXT_12 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_13 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = "; ";
  protected final String TEXT_18 = NL + "\t" + NL + "\t\t\torg.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_19 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_20 = ",decryptedPassword_";
  protected final String TEXT_21 = ");" + NL + "\t\t\tservice_";
  protected final String TEXT_22 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_23 = ",\" ";
  protected final String TEXT_24 = "\",null);" + NL + "\t\t\tservice_";
  protected final String TEXT_25 = ".getAccountOwner();" + NL + "\t\t";
  protected final String TEXT_26 = NL + "\t\tString targetFolder_";
  protected final String TEXT_27 = "=";
  protected final String TEXT_28 = ";" + NL + "\t\tif(targetFolder_";
  protected final String TEXT_29 = ".length()>0 && !targetFolder_";
  protected final String TEXT_30 = ".endsWith(\"/\")){" + NL + "\t\t\ttargetFolder_";
  protected final String TEXT_31 = "=targetFolder_";
  protected final String TEXT_32 = "+\"/\";" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\t\torg.jets3t.service.model.GSObject[] objects_";
  protected final String TEXT_34 = " = service_";
  protected final String TEXT_35 = ".listObjects(";
  protected final String TEXT_36 = ",";
  protected final String TEXT_37 = ",null);" + NL + "\t\t\tfor (org.jets3t.service.model.GSObject objectSummary_";
  protected final String TEXT_38 = " : objects_";
  protected final String TEXT_39 = ") {" + NL + "\t\t\t\tString srcObjectKey_";
  protected final String TEXT_40 = "=objectSummary_";
  protected final String TEXT_41 = ".getKey();" + NL + "\t\t\t\torg.jets3t.service.model.GSObject tarObj_";
  protected final String TEXT_42 = "=service_";
  protected final String TEXT_43 = ".getObject(";
  protected final String TEXT_44 = ", objectSummary_";
  protected final String TEXT_45 = ".getKey());" + NL + "\t\t\t\ttarObj_";
  protected final String TEXT_46 = ".setKey(targetFolder_";
  protected final String TEXT_47 = "+objectSummary_";
  protected final String TEXT_48 = ".getKey());" + NL + "\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\tservice_";
  protected final String TEXT_50 = ".copyObject(";
  protected final String TEXT_51 = ", srcObjectKey_";
  protected final String TEXT_52 = ", ";
  protected final String TEXT_53 = ",tarObj_";
  protected final String TEXT_54 = " , false);" + NL + "\t\t\t\t";
  protected final String TEXT_55 = "\t\t" + NL + "\t\t\t\t\tservice_";
  protected final String TEXT_56 = ".moveObject(";
  protected final String TEXT_57 = ", srcObjectKey_";
  protected final String TEXT_58 = ", ";
  protected final String TEXT_59 = ", tarObj_";
  protected final String TEXT_60 = ", false);" + NL + "\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\ttarObj_";
  protected final String TEXT_62 = ".closeDataInputStream();" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_63 = NL + "\t\t\torg.jets3t.service.model.GSObject tarObj_";
  protected final String TEXT_64 = " = service_";
  protected final String TEXT_65 = ".getObject(";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ");" + NL + "\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\ttarObj_";
  protected final String TEXT_69 = ".setKey(targetFolder_";
  protected final String TEXT_70 = "+";
  protected final String TEXT_71 = ");" + NL + "\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\ttarObj_";
  protected final String TEXT_73 = ".setKey(targetFolder_";
  protected final String TEXT_74 = "+tarObj_";
  protected final String TEXT_75 = ".getKey());" + NL + "\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\tservice_";
  protected final String TEXT_77 = ".copyObject(";
  protected final String TEXT_78 = ", ";
  protected final String TEXT_79 = ", ";
  protected final String TEXT_80 = ",tarObj_";
  protected final String TEXT_81 = " , false);" + NL + "\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\tservice_";
  protected final String TEXT_83 = ".moveObject(";
  protected final String TEXT_84 = ", ";
  protected final String TEXT_85 = ", ";
  protected final String TEXT_86 = ", tarObj_";
  protected final String TEXT_87 = ", false);" + NL + "\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\ttarObj_";
  protected final String TEXT_89 = ".closeDataInputStream();" + NL + "\t\t";
  protected final String TEXT_90 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_91 = "_SOURCE_BUCKET\",";
  protected final String TEXT_92 = "); " + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_93 = "_SOURCE_OBJECTKEY\",";
  protected final String TEXT_94 = "); " + NL + "" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_95 = "_DESTINATION_BUCKETNAME\", ";
  protected final String TEXT_96 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_97 = "_DESTINATION_FOLDER\", ";
  protected final String TEXT_98 = ");" + NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_99 = ") {" + NL + "\t\t";
  protected final String TEXT_100 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_101 = ");" + NL + "\t\t";
  protected final String TEXT_102 = NL + "\t\t\tif(e_";
  protected final String TEXT_103 = " instanceof org.jets3t.service.ServiceException){" + NL + "\t\t\t\torg.jets3t.service.ServiceException servError_";
  protected final String TEXT_104 = " = (org.jets3t.service.ServiceException)e_";
  protected final String TEXT_105 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_107 = " - Exception in component ";
  protected final String TEXT_108 = ":\" + servError_";
  protected final String TEXT_109 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_111 = ":\");" + NL + "\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_112 = ".getMessage());" + NL + "\t\t\t\tif(servError_";
  protected final String TEXT_113 = ".getErrorCode()!=null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_115 = " - \" + servError_";
  protected final String TEXT_116 = ".getErrorCode());" + NL + "\t\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_118 = ".getErrorCode());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(servError_";
  protected final String TEXT_119 = ".getErrorMessage()!=null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_121 = " - \" + servError_";
  protected final String TEXT_122 = ".getErrorMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_124 = ".getErrorMessage());" + NL + "\t\t\t\t}" + NL + "\t" + NL + "\t\t\t}else{" + NL + "\t\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_126 = " - \" + e_";
  protected final String TEXT_127 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_129 = ".getMessage());" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_130 = NL + "\t\t\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_131 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_132 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_133 = NL + "\t}" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	boolean isSourceFolder=("true").equals(ElementParameterParser.getValue(node,"__IS_SOUCE_FOLDER__"));
	String srcBucketName=ElementParameterParser.getValue(node,"__SOURCE_BUCKET__");
	String sourceObjectKey = ElementParameterParser.getValue(node,"__SOURCE_OBJECTKEY__");
	String targetBucket=ElementParameterParser.getValue(node,"__TARGET_BUCKET__");
	String targetFolder=ElementParameterParser.getValue(node,"__TARGET_FOLDER__");
	String newObjectKey = ElementParameterParser.getValue(node,"__NEW_OBJECTKEY__");
	String actionType = ElementParameterParser.getValue(node,"__ACTION_TYPE__");
	boolean isRename = ("true").equals(ElementParameterParser.getValue(node,"__RENAME__"));
	
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
		if(("true").equals(useExistingConn)) {
			String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_6);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_9);
    
			}
		}else{
		
    stringBuffer.append(TEXT_10);
    
			String passwordFieldName = "__SECRET_KEY__";
			final String GoogleTracker = org.talend.core.utils.TrackerUtil.getGoogleTracker();
	       	
    stringBuffer.append(TEXT_11);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_14);
    } else {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(GoogleTracker);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    		
		}
		
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(targetFolder);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
		if(isSourceFolder){
		
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(sourceObjectKey);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
				if("COPY".equals(actionType) ){
				
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
				}else{
				
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
				}
				
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
		}else{
		
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(sourceObjectKey);
    stringBuffer.append(TEXT_67);
    
			if(isRename){
			
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(newObjectKey);
    stringBuffer.append(TEXT_71);
    
			}else{
			
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
			}
			if("COPY".equals(actionType) ){
			
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(sourceObjectKey);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
			}else{
			
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(sourceObjectKey);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
			}
			
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
		}
		
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(sourceObjectKey);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(targetFolder);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
		if (("true").equals(dieOnError)) {
		
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
		} else {
		
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
				}
				
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
					}
					
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
					}
					
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
				}
				
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
		}
		if(!("true").equals(useExistingConn)) {
		
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
		}
		
    stringBuffer.append(TEXT_133);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.cloud;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TCloudStartBeginJava
{
  protected static String nl;
  public static synchronized TCloudStartBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCloudStartBeginJava result = new TCloudStartBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tif(true) {" + NL + "\t\t\tthrow new Exception(\"The instance count must be a numeric.\");" + NL + "\t\t}";
  protected final String TEXT_3 = NL + "\t        " + NL + "\t";
  protected final String TEXT_4 = NL + "\t" + NL + "\t";
  protected final String TEXT_5 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_6 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = "; ";
  protected final String TEXT_11 = NL + "   \torg.jclouds.compute.ComputeServiceContext context_";
  protected final String TEXT_12 = " = org.jclouds.ContextBuilder.newBuilder(\"";
  protected final String TEXT_13 = "\").credentials(";
  protected final String TEXT_14 = ", decryptedPassword_";
  protected final String TEXT_15 = ").buildView(org.jclouds.compute.ComputeServiceContext.class);" + NL + "\torg.jclouds.compute.ComputeService client_";
  protected final String TEXT_16 = " = context_";
  protected final String TEXT_17 = ".getComputeService();" + NL + "" + NL + "\tboolean hasToCreateNode_";
  protected final String TEXT_18 = " = true;" + NL + "\tjava.util.Set<? extends org.jclouds.compute.domain.NodeMetadata> nodes_";
  protected final String TEXT_19 = " = null;" + NL;
  protected final String TEXT_20 = NL + "        nodes_";
  protected final String TEXT_21 = " = client_";
  protected final String TEXT_22 = ".listNodesDetailsMatching(new com.google.common.base.Predicate<org.jclouds.compute.domain.NodeMetadata>() {" + NL + "             @Override" + NL + "             public boolean apply(org.jclouds.compute.domain.NodeMetadata nodeMetadata) {" + NL + "                 if (";
  protected final String TEXT_23 = ".equals(nodeMetadata.getName())) {" + NL + "                     return true;" + NL + "                 }" + NL + "                 return false;" + NL + "             }" + NL + "        });" + NL + "        String instanceId = null;" + NL + "        for (org.jclouds.compute.domain.NodeMetadata d : nodes_";
  protected final String TEXT_24 = ") {";
  protected final String TEXT_25 = NL + "                 log.warn(";
  protected final String TEXT_26 = " + \" (\" + d.getId() + \") is \" + d.getStatus() + \".\");";
  protected final String TEXT_27 = NL + "                System.out.println(";
  protected final String TEXT_28 = " + \" (\" + d.getId() + \") is \" + d.getStatus() + \".\");";
  protected final String TEXT_29 = NL + "            if (org.jclouds.compute.domain.NodeMetadata.Status.SUSPENDED.equals(d.getStatus())) {" + NL + "                instanceId = d.getId();" + NL + "            }" + NL + "            if (org.jclouds.compute.domain.NodeMetadata.Status.RUNNING.equals(d.getStatus())) {" + NL + "                hasToCreateNode_";
  protected final String TEXT_30 = " = false;" + NL + "            }" + NL + "        }" + NL + "        if (instanceId != null) {";
  protected final String TEXT_31 = NL + "                log.warn(\"Starting \" + ";
  protected final String TEXT_32 = " + \" (\" + instanceId + \")...\");";
  protected final String TEXT_33 = NL + "                System.out.println(\"Starting \" + ";
  protected final String TEXT_34 = " + \" (\" + instanceId + \")...\");";
  protected final String TEXT_35 = NL + "            try {" + NL + "                client_";
  protected final String TEXT_36 = ".resumeNode(instanceId);" + NL + "                hasToCreateNode_";
  protected final String TEXT_37 = " = false;" + NL + "           \t} catch(com.google.common.util.concurrent.UncheckedExecutionException e_";
  protected final String TEXT_38 = ") {" + NL + "           \t\tboolean ignoreException_";
  protected final String TEXT_39 = " = false;" + NL + "           \t\tif(e_";
  protected final String TEXT_40 = ".getCause()!=null && (e_";
  protected final String TEXT_41 = ".getCause() instanceof java.lang.NullPointerException)) {" + NL + "           \t\t\tif(\"name\".equals(e_";
  protected final String TEXT_42 = ".getCause().getMessage())) {" + NL + "           \t\t\t\tignoreException_";
  protected final String TEXT_43 = " = true;" + NL + "           \t\t\t    ";
  protected final String TEXT_44 = NL + "                            log.error(\"Some exception happen when get the running instance information object, you can avoid it by setting the key pair\");";
  protected final String TEXT_45 = NL + "                            System.err.println(\"Some exception happen when get the running instance information object, you can avoid it by setting the key pair\");";
  protected final String TEXT_46 = NL + "           \t\t\t}" + NL + "           \t\t}" + NL + "           \t\tif(!ignoreException_";
  protected final String TEXT_47 = ") {" + NL + "           \t\t\tthrow e_";
  protected final String TEXT_48 = ";" + NL + "           \t\t}" + NL + "           \t}" + NL + "        }";
  protected final String TEXT_49 = NL + "    if(hasToCreateNode_";
  protected final String TEXT_50 = "){";
  protected final String TEXT_51 = NL + "    \t\torg.jclouds.aws.ec2.features.AWSKeyPairApi keyPairClient_";
  protected final String TEXT_52 = " = context_";
  protected final String TEXT_53 = ".unwrapApi(org.jclouds.aws.ec2.AWSEC2Api.class).getKeyPairApi().get();" + NL + "    \t\torg.jclouds.ec2.domain.KeyPair result_";
  protected final String TEXT_54 = " = keyPairClient_";
  protected final String TEXT_55 = ".createKeyPairInRegion(";
  protected final String TEXT_56 = ", ";
  protected final String TEXT_57 = ");" + NL + "    \t\tjava.io.FileWriter fstream_";
  protected final String TEXT_58 = " = new java.io.FileWriter(";
  protected final String TEXT_59 = " + \"/\" + ";
  protected final String TEXT_60 = " +\".pem\");" + NL + "    \t\tjava.io.BufferedWriter out_";
  protected final String TEXT_61 = " = new java.io.BufferedWriter(fstream_";
  protected final String TEXT_62 = ");" + NL + "    \t\tout_";
  protected final String TEXT_63 = ".write(result_";
  protected final String TEXT_64 = ".getKeyMaterial());" + NL + "    \t\tout_";
  protected final String TEXT_65 = ".close();";
  protected final String TEXT_66 = NL + "    \t\torg.jclouds.aws.ec2.compute.AWSEC2TemplateOptions options_";
  protected final String TEXT_67 = " = new org.jclouds.aws.ec2.compute.AWSEC2TemplateOptions();";
  protected final String TEXT_68 = NL + "\t\t    options_";
  protected final String TEXT_69 = ".overrideLoginPrivateKey(result_";
  protected final String TEXT_70 = ".getKeyMaterial());";
  protected final String TEXT_71 = NL + "\t    options_";
  protected final String TEXT_72 = ".as(";
  protected final String TEXT_73 = ".class)" + NL + "\t    .";
  protected final String TEXT_74 = NL + "\t    ";
  protected final String TEXT_75 = NL + "\t\t\t    \t.mapNewVolumeToDeviceName(";
  protected final String TEXT_76 = ", ";
  protected final String TEXT_77 = ", ";
  protected final String TEXT_78 = ")";
  protected final String TEXT_79 = NL + "\t\t\t\t    .mapEBSSnapshotToDeviceName(";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = ", ";
  protected final String TEXT_82 = ", ";
  protected final String TEXT_83 = ")";
  protected final String TEXT_84 = NL + "\t\t\t\t    .mapEphemeralDeviceToDeviceName(";
  protected final String TEXT_85 = ", ";
  protected final String TEXT_86 = ")";
  protected final String TEXT_87 = NL + "\t;" + NL + "\t" + NL + "    \torg.jclouds.compute.domain.Template template_";
  protected final String TEXT_88 = " = context_";
  protected final String TEXT_89 = ".getComputeService().templateBuilder()" + NL + "\t    \t.imageId(";
  protected final String TEXT_90 = " +\"/\" + ";
  protected final String TEXT_91 = ")" + NL + "\t\t    .hardwareId(org.jclouds.ec2.domain.InstanceType.";
  protected final String TEXT_92 = ")" + NL + "\t\t    .locationId(";
  protected final String TEXT_93 = ")" + NL + "\t\t    .options(options_";
  protected final String TEXT_94 = ").build();" + NL + "\t" + NL + "" + NL + "    \ttry {" + NL + "\t    \tnodes_";
  protected final String TEXT_95 = " = context_";
  protected final String TEXT_96 = ".getComputeService().createNodesInGroup(";
  protected final String TEXT_97 = ".toLowerCase(), ";
  protected final String TEXT_98 = ", template_";
  protected final String TEXT_99 = ");" + NL + "\t    } catch(com.google.common.util.concurrent.UncheckedExecutionException e_";
  protected final String TEXT_100 = ") {" + NL + "\t\t    boolean ignoreException_";
  protected final String TEXT_101 = " = false;" + NL + "\t\t    if(e_";
  protected final String TEXT_102 = ".getCause()!=null && (e_";
  protected final String TEXT_103 = ".getCause() instanceof java.lang.NullPointerException)) {" + NL + "\t\t\t    if(\"name\".equals(e_";
  protected final String TEXT_104 = ".getCause().getMessage())) {" + NL + "\t\t\t\t    ignoreException_";
  protected final String TEXT_105 = " = true;" + NL + "\t\t\t\t    ";
  protected final String TEXT_106 = NL + "                        log.error(\"Some exception happen when get the running instance information object, you can avoid it by setting the key pair\");";
  protected final String TEXT_107 = NL + "                        System.err.println(\"Some exception happen when get the running instance information object, you can avoid it by setting the key pair\");";
  protected final String TEXT_108 = NL + "\t\t\t    }" + NL + "\t\t    }" + NL + "\t\t" + NL + "\t\t    if(!ignoreException_";
  protected final String TEXT_109 = ") {" + NL + "\t\t\t    throw e_";
  protected final String TEXT_110 = ";" + NL + "\t\t    }" + NL + "\t    }" + NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_111 = "_NODE_GROUP\", ";
  protected final String TEXT_112 = ".toLowerCase());" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_113 = "_NODES\", nodes_";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

	String accesskey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	String provider = ElementParameterParser.getValue(node, "__PROVIDER__");
	String imageId = ElementParameterParser.getValue(node, "__IMAGE_ID__");
	String region = ElementParameterParser.getValue(node, "__REGION__");
	String zone = ElementParameterParser.getValue(node, "__ZONE__");
	int instanceCount = 0;
	String instanceName = ElementParameterParser.getValue(node, "__INSTANCE_NAME__");
	String type = ElementParameterParser.getValue(node, "__TYPE__");
	boolean proceedWithKeyPair = "true".equals(ElementParameterParser.getValue(node, "__PROCEED_WITH_KEYPAIR__"));
	String keypairOption = ElementParameterParser.getValue(node, "__KEYPAIR_OPTION__");
	String keypair = ElementParameterParser.getValue(node, "__KEYPAIR__");
	String keypairFolder = ElementParameterParser.getValue(node, "__KEYPAIR_FOLDER__");
	List<Map<String, String>> securityGroups = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SECURITY_GROUPS__");
	List<Map<String, String>> volumes = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__VOLUMES__");
	
	String providerId = "";
	if("AWS_EC2".equals(provider)) {
		providerId = "aws-ec2";
	}
	
	String securityGroupsString = null;
	if(securityGroups.size() > 0){
		boolean isFirstGroup = true;
		for(Map<String, String> item : securityGroups){
			if(isFirstGroup) {
				isFirstGroup = false;
				securityGroupsString = item.get("GROUP");
			} else {
				securityGroupsString += " ," + item.get("GROUP");
			}
		} 
	}
	
	try {
		instanceCount = Integer.parseInt(ElementParameterParser.getValue(node, "__INSTANCE_COUNT__"));
	} catch (Exception e) {
		

    stringBuffer.append(TEXT_2);
    
	}

    stringBuffer.append(TEXT_3);
    
	String passwordFieldName = "__SECRET_KEY__";
	
    stringBuffer.append(TEXT_4);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_7);
    } else {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(providerId);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(accesskey);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
    if(instanceCount == 1) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(instanceName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(instanceName);
    stringBuffer.append(TEXT_26);
    } else { 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(instanceName);
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(instanceName);
    stringBuffer.append(TEXT_32);
    } else { 
    stringBuffer.append(TEXT_33);
    stringBuffer.append(instanceName);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
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
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_44);
    } else { 
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
    }

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
	    if(proceedWithKeyPair && "CREATE_KEYPAIR".equals(keypairOption)) {

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(keypair);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(keypairFolder);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(keypair);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
	    }

    	if("AWS_EC2".equals(provider)) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
	    }
	    if(proceedWithKeyPair && "CREATE_KEYPAIR".equals(keypairOption)) {

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
	    }

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append("AWS_EC2".equals(provider)?"org.jclouds.aws.ec2.compute.AWSEC2TemplateOptions":"");
    stringBuffer.append(TEXT_73);
    stringBuffer.append((proceedWithKeyPair?("USE_EXISTING".equals(keypairOption)?"keyPair("+keypair+")":"keyPair(result_"+cid+".getKeyName())"):"noKeyPair()"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(securityGroupsString!=null?".securityGroups("+securityGroupsString+")":"");
    
	    for(Map<String, String> volume : volumes) { //1
			String volume_type = volume.get("VOLUME_TYPE");
		    	if("ROOT".equals(volume_type)) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(volume.get("DEVICE"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(volume.get("SIZE"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append("true".equals(volume.get("DELETE_ON_TERMINATION")));
    stringBuffer.append(TEXT_78);
    
			    } else if("EBS".equals(volume_type)) {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(volume.get("DEVICE"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(volume.get("SNAPSHOT_ID"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(volume.get("SIZE"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append("true".equals(volume.get("DELETE_ON_TERMINATION")));
    stringBuffer.append(TEXT_83);
    
			    } else if("EPHEMERAL".equals(volume_type)) {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(volume.get("DEVICE"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(volume.get("VIRTUAL_NAME"));
    stringBuffer.append(TEXT_86);
    
			    }
	    }

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(imageId);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(zone);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(instanceName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(instanceCount);
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
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_106);
    } else { 
    stringBuffer.append(TEXT_107);
    }
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(instanceName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(TEXT_115);
    return stringBuffer.toString();
  }
}

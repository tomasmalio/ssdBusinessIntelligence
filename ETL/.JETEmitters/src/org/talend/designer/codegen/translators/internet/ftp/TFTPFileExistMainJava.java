package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPFileExistMainJava
{
  protected static String nl;
  public static synchronized TFTPFileExistMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFileExistMainJava result = new TFTPFileExistMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tString remoteDir_";
  protected final String TEXT_2 = " = (";
  protected final String TEXT_3 = ").replaceAll(\"\\\\\\\\\",\"/\");" + NL + "\t\ttry{" + NL + "\t\t\tif (c_";
  protected final String TEXT_4 = ".stat(remoteDir_";
  protected final String TEXT_5 = " + \"/\" + ";
  protected final String TEXT_6 = ").getAtimeString() != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_8 = " - '\" + ";
  protected final String TEXT_9 = " + \"' exists in the remote directory '\"+ ";
  protected final String TEXT_10 = " + \"' .\");" + NL + "\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_12 = "_EXISTS\", true);" + NL + "\t\t\t}" + NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_14 = " - '\" + ";
  protected final String TEXT_15 = " + \"' doesn't exist in the remote directory '\"+ ";
  protected final String TEXT_16 = " + \"' .\");" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_18 = "_EXISTS\", false);" + NL + "\t\t}" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_19 = "_FILENAME\", ";
  protected final String TEXT_20 = ");" + NL + "\t";
  protected final String TEXT_21 = NL + "\t\tString remoteDir_";
  protected final String TEXT_22 = " = (";
  protected final String TEXT_23 = ").replaceAll(\"\\\\\\\\\",\"/\");" + NL + "\t\tString directoryname_";
  protected final String TEXT_24 = " = (";
  protected final String TEXT_25 = ").replaceAll(\"\\\\\\\\\",\"/\");" + NL + "\t\ttry{" + NL + "\t\t\tif (c_";
  protected final String TEXT_26 = ".stat(remoteDir_";
  protected final String TEXT_27 = " + \"/\" + directoryname_";
  protected final String TEXT_28 = ").getAtimeString() != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_30 = " - '\" + ";
  protected final String TEXT_31 = " + \"' exists in the remote directory '\"+ ";
  protected final String TEXT_32 = " + \"' .\");" + NL + "\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_34 = "_EXISTS\", true);" + NL + "\t\t\t}" + NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_36 = " - '\" + ";
  protected final String TEXT_37 = " + \"' doesn't exist in the remote directory '\"+ ";
  protected final String TEXT_38 = " + \"' .\");" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_40 = "_EXISTS\", false);" + NL + "\t\t}" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_41 = "_DIRECTORYNAME\", ";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\t//change working dir and save root" + NL + "\tString remoteDir_";
  protected final String TEXT_44 = " = (";
  protected final String TEXT_45 = ").replaceAll(\"\\\\\\\\\",\"/\");" + NL + "\tString rootDir_";
  protected final String TEXT_46 = " = ftp_";
  protected final String TEXT_47 = ".printWorkingDirectory();" + NL + "\tboolean cwdSuccess_";
  protected final String TEXT_48 = " = ftp_";
  protected final String TEXT_49 = ".changeWorkingDirectory(remoteDir_";
  protected final String TEXT_50 = ");" + NL + "" + NL + "\tif (!cwdSuccess_";
  protected final String TEXT_51 = ") {" + NL + "\t\tthrow new RuntimeException(\"Failed to change remote directory. \" + ftp_";
  protected final String TEXT_52 = ".getReplyString());" + NL + "\t}";
  protected final String TEXT_53 = NL + "\t\tString fileName_";
  protected final String TEXT_54 = " = (";
  protected final String TEXT_55 = ").replaceAll(\"\\\\\\\\\",\"/\");" + NL + "\t\tString dirName_";
  protected final String TEXT_56 = " = null;" + NL + "\t\tboolean dirExist_";
  protected final String TEXT_57 = " = false;" + NL + "\t\tboolean needDirChange_";
  protected final String TEXT_58 = " = false;" + NL + "\t\tString[] allFileNames_";
  protected final String TEXT_59 = " = null;" + NL + "" + NL + "\t\tif (fileName_";
  protected final String TEXT_60 = ".contains(\"/\")) {" + NL + "\t\t\tneedDirChange_";
  protected final String TEXT_61 = " = true;" + NL + "\t\t\t//change directory if exist" + NL + "\t\t\tdirName_";
  protected final String TEXT_62 = " = fileName_";
  protected final String TEXT_63 = ".substring(0, fileName_";
  protected final String TEXT_64 = ".lastIndexOf(\"/\"));" + NL + "\t\t\tfileName_";
  protected final String TEXT_65 = " = fileName_";
  protected final String TEXT_66 = ".substring(fileName_";
  protected final String TEXT_67 = ".lastIndexOf('/') + 1, fileName_";
  protected final String TEXT_68 = ".length());" + NL + "" + NL + "\t\t\tdirExist_";
  protected final String TEXT_69 = " = ftp_";
  protected final String TEXT_70 = ".changeWorkingDirectory(dirName_";
  protected final String TEXT_71 = ");" + NL + "\t\t\tif (!dirExist_";
  protected final String TEXT_72 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t\tlog.warn(\"Directory \" + dirName_";
  protected final String TEXT_74 = " + \" doesn't exist. Can't seek for file \" + fileName_";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tif (!needDirChange_";
  protected final String TEXT_77 = " || dirExist_";
  protected final String TEXT_78 = ") {" + NL + "\t\t\tallFileNames_";
  protected final String TEXT_79 = " = java.util.Arrays.stream(ftp_";
  protected final String TEXT_80 = ".listFiles()).filter(org.apache.commons.net.ftp.FTPFile::isFile).map(org.apache.commons.net.ftp.FTPFile::getName)" + NL + "\t\t\t\t.filter(fileName_";
  protected final String TEXT_81 = "::equals).toArray(String[]::new);" + NL + "\t\t}" + NL + "" + NL + "\t\tboolean fileExist_";
  protected final String TEXT_82 = " = (null != allFileNames_";
  protected final String TEXT_83 = ") && (allFileNames_";
  protected final String TEXT_84 = ".length > 0);" + NL + "" + NL + "\t\tif (fileExist_";
  protected final String TEXT_85 = ") {" + NL + "\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_87 = " - '\" + ";
  protected final String TEXT_88 = " + \"' exists in the remote directory '\"+ ";
  protected final String TEXT_89 = " + \"' .\");" + NL + "\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_91 = "_EXISTS\", true);" + NL + "\t\t} else {" + NL + "\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_93 = " - '\" + ";
  protected final String TEXT_94 = " + \"' doesn't exist in the remote directory '\"+ ";
  protected final String TEXT_95 = " + \"' .\");" + NL + "\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_97 = "_EXISTS\", false);" + NL + "\t\t}" + NL + "" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_98 = "_FILENAME\", ";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = NL + "\t\tString directoryname_";
  protected final String TEXT_101 = " = (";
  protected final String TEXT_102 = ").replaceAll(\"\\\\\\\\\",\"/\");" + NL + "\t\t" + NL + "\t\tboolean isDirExists_";
  protected final String TEXT_103 = " = ftp_";
  protected final String TEXT_104 = ".changeWorkingDirectory(directoryname_";
  protected final String TEXT_105 = ");" + NL + "\t\t" + NL + "\t\tif (isDirExists_";
  protected final String TEXT_106 = ") {" + NL + "\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_108 = " - '\" + ";
  protected final String TEXT_109 = " + \"' exists in the remote directory '\"+ ";
  protected final String TEXT_110 = " + \"' .\");" + NL + "\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_112 = "_EXISTS\", true);" + NL + "\t\t} else {" + NL + "\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_114 = " - '\" + ";
  protected final String TEXT_115 = " + \"' doesn't exist in the remote directory '\"+ ";
  protected final String TEXT_116 = " + \"' .\");" + NL + "\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_118 = "_EXISTS\", false);" + NL + "\t\t}" + NL + "" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_119 = "_DIRECTORYNAME\", ";
  protected final String TEXT_120 = ");";
  protected final String TEXT_121 = NL + "\tftp_";
  protected final String TEXT_122 = ".changeWorkingDirectory(rootDir_";
  protected final String TEXT_123 = ");";
  protected final String TEXT_124 = NL + "\t\tString remoteDir_";
  protected final String TEXT_125 = " = (";
  protected final String TEXT_126 = ").replaceAll(\"\\\\\\\\\",\"/\");" + NL + "\t\tif (ftp_";
  protected final String TEXT_127 = ".exists";
  protected final String TEXT_128 = "(remoteDir_";
  protected final String TEXT_129 = " + \"/\" + ";
  protected final String TEXT_130 = ")) {" + NL + "\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_132 = " - '\" + ";
  protected final String TEXT_133 = " + \"' exists in the remote directory '\"+ ";
  protected final String TEXT_134 = " + \"' .\");" + NL + "\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_136 = "_EXISTS\", true);" + NL + "\t\t} else {" + NL + "\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_138 = " - '\" + ";
  protected final String TEXT_139 = " + \"' doesn't exist in the remote directory '\"+ ";
  protected final String TEXT_140 = " + \"' .\");" + NL + "\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_142 = "_EXISTS\", false);" + NL + "\t\t}" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_143 = "_FILENAME\", ";
  protected final String TEXT_144 = ");" + NL + "\t";
  protected final String TEXT_145 = NL + "\t\tString remoteDir_";
  protected final String TEXT_146 = " = (";
  protected final String TEXT_147 = ").replaceAll(\"\\\\\\\\\",\"/\");" + NL + "\t\tString directoryname_";
  protected final String TEXT_148 = " = (";
  protected final String TEXT_149 = ").replaceAll(\"\\\\\\\\\",\"/\");" + NL + "\t\tif (ftp_";
  protected final String TEXT_150 = ".exists";
  protected final String TEXT_151 = "(remoteDir_";
  protected final String TEXT_152 = " + \"/\" + directoryname_";
  protected final String TEXT_153 = ")) {" + NL + "\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_155 = " - '\" + ";
  protected final String TEXT_156 = " + \"' exists in the remote directory '\"+ ";
  protected final String TEXT_157 = " + \"' .\");" + NL + "\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_159 = "_EXISTS\", true);" + NL + "\t\t} else {" + NL + "\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_161 = " - '\" + ";
  protected final String TEXT_162 = " + \"' doesn't exist in the remote directory '\"+ ";
  protected final String TEXT_163 = " + \"' .\");" + NL + "\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_165 = "_EXISTS\", false);" + NL + "\t\t}" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_166 = "_DIRECTORYNAME\", ";
  protected final String TEXT_167 = ");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
boolean isFileType = "FILE".equals(ElementParameterParser.getValue(node, "__TARGETTYPE__"));
String remoteDir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String directoryname = ElementParameterParser.getValue(node, "__DIRECTORYNAME__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean sftp = false;
boolean ftps = false;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if (("true").equals(useExistingConn)) {
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

if (sftp) { // *** sftp *** //
	if (isFileType) {
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_6);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_20);
    } else {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(directoryname );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(directoryname );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(directoryname );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(directoryname );
    stringBuffer.append(TEXT_42);
    }
} else if (ftps) { // *** ftps *** //

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    
	if (isFileType) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    if (isLog4jEnabled) { 
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_95);
    }
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_99);
    
	} else {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(directoryname );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(directoryname );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(directoryname );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(directoryname );
    stringBuffer.append(TEXT_120);
    
	}

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    
} else { // *** ftp *** //
	if (isFileType){
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append("File" );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_130);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_144);
    } else {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(directoryname );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append("Directory" );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(directoryname );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(directoryname );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_163);
    }
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(directoryname );
    stringBuffer.append(TEXT_167);
    }
}
    return stringBuffer.toString();
  }
}

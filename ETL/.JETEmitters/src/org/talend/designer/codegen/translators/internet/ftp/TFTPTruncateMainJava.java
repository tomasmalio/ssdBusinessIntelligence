package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPTruncateMainJava
{
  protected static String nl;
  public static synchronized TFTPTruncateMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPTruncateMainJava result = new TFTPTruncateMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_3 = "_CURRENT_STATUS\", \"No file truncated.\");" + NL + "\t\tjava.util.Set<String> keySet";
  protected final String TEXT_4 = " = map";
  protected final String TEXT_5 = ".keySet(); " + NL + "\t\tfor (String key";
  protected final String TEXT_6 = " : keySet";
  protected final String TEXT_7 = ") {     " + NL + "    \t\tString filemask";
  protected final String TEXT_8 = " = key";
  protected final String TEXT_9 = "; " + NL + "\t    \tString dir";
  protected final String TEXT_10 = " = null;" + NL + "    \t    ";
  protected final String TEXT_11 = NL + "       \t\t\tString mask";
  protected final String TEXT_12 = " = filemask";
  protected final String TEXT_13 = ".replaceAll(\"\\\\\\\\\", \"/\") ;" + NL + "\t        ";
  protected final String TEXT_14 = NL + "\t\t        String mask";
  protected final String TEXT_15 = " = filemask";
  protected final String TEXT_16 = ";" + NL + "        \t";
  protected final String TEXT_17 = NL + "\t    \tint i";
  protected final String TEXT_18 = " = mask";
  protected final String TEXT_19 = ".lastIndexOf('/');" + NL + "\t\t\tif (i";
  protected final String TEXT_20 = "!=-1) {" + NL + "\t\t\t\tdir";
  protected final String TEXT_21 = " = mask";
  protected final String TEXT_22 = ".substring(0, i";
  protected final String TEXT_23 = "); " + NL + "\t\t\t\tmask";
  protected final String TEXT_24 = " = mask";
  protected final String TEXT_25 = ".substring(i";
  protected final String TEXT_26 = "+1); " + NL + "    \t\t}";
  protected final String TEXT_27 = "    \t" + NL + "    \t    ";
  protected final String TEXT_28 = NL + "        \t    mask";
  protected final String TEXT_29 = " = org.apache.oro.text.GlobCompiler.globToPerl5(mask";
  protected final String TEXT_30 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t        ";
  protected final String TEXT_31 = NL + "\t\t\tjava.util.Vector listings";
  protected final String TEXT_32 = " = c_";
  protected final String TEXT_33 = ".ls(";
  protected final String TEXT_34 = ");" + NL + "\t\t\tfor (int m";
  protected final String TEXT_35 = " = 0; m";
  protected final String TEXT_36 = " < listings";
  protected final String TEXT_37 = ".size(); m";
  protected final String TEXT_38 = "++) { " + NL + "\t\t\t\tString filePath";
  protected final String TEXT_39 = " =  ((com.jcraft.jsch.ChannelSftp.LsEntry) listings";
  protected final String TEXT_40 = ".elementAt(m";
  protected final String TEXT_41 = ")).getFilename() ;" + NL + "\t\t\t\tif ( filePath";
  protected final String TEXT_42 = ".matches(mask";
  protected final String TEXT_43 = ")) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tc_";
  protected final String TEXT_44 = ".put(new java.io.ByteArrayInputStream(new byte[]{}), ";
  protected final String TEXT_45 = "+\"/\"+filePath";
  protected final String TEXT_46 = ");" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_47 = "_CURRENT_STATUS\", \"File truncate OK.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_49 = " - '\" + filePath";
  protected final String TEXT_50 = "  + \"' truncate ok.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t\t} catch (com.jcraft.jsch.SftpException se) {" + NL + "                \t\tglobalMap.put(\"";
  protected final String TEXT_52 = "_CURRENT_STATUS\", \"File truncate fail.\");" + NL + "    \t                throw se;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tnb_file_";
  protected final String TEXT_53 = "++;" + NL + "\t\t\t\t}" + NL + "\t\t\t}\t     " + NL + "   \t\t}  ";
  protected final String TEXT_54 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_55 = "_CURRENT_STATUS\", \"No file truncated.\");" + NL + "\t\t\tjava.util.Set<String> keySet";
  protected final String TEXT_56 = " = map";
  protected final String TEXT_57 = ".keySet(); " + NL + "\t\t\tfor (String key";
  protected final String TEXT_58 = " : keySet";
  protected final String TEXT_59 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\tString filemask";
  protected final String TEXT_61 = " = key";
  protected final String TEXT_62 = ";";
  protected final String TEXT_63 = NL + "\t\t\t\t\t\tfilemask";
  protected final String TEXT_64 = " = ";
  protected final String TEXT_65 = " + \"/\" + filemask";
  protected final String TEXT_66 = ";";
  protected final String TEXT_67 = NL + "\t\t\t\tString dir";
  protected final String TEXT_68 = " = null;" + NL + "\t\t\t\tString mask";
  protected final String TEXT_69 = " = null;";
  protected final String TEXT_70 = NL + "\t\t\t\t\tmask";
  protected final String TEXT_71 = " = filemask";
  protected final String TEXT_72 = ".replaceAll(\"\\\\\\\\\", \"/\") ;";
  protected final String TEXT_73 = NL + "\t\t\t\t\tmask";
  protected final String TEXT_74 = " = filemask";
  protected final String TEXT_75 = ";";
  protected final String TEXT_76 = NL + "\t\t\t\tint i";
  protected final String TEXT_77 = " = mask";
  protected final String TEXT_78 = ".lastIndexOf('/');" + NL + "" + NL + "\t\t\t\tif (i";
  protected final String TEXT_79 = "!=-1) {" + NL + "\t\t\t\t\tdir";
  protected final String TEXT_80 = " = mask";
  protected final String TEXT_81 = ".substring(0, i";
  protected final String TEXT_82 = ");" + NL + "\t\t\t\t\tmask";
  protected final String TEXT_83 = " = mask";
  protected final String TEXT_84 = ".substring(i";
  protected final String TEXT_85 = "+1);" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tif (dir";
  protected final String TEXT_86 = " != null && !\"\".equals(dir";
  protected final String TEXT_87 = ")) {" + NL + "\t\t\t\t\tboolean doesDirExist_";
  protected final String TEXT_88 = " = ftp_";
  protected final String TEXT_89 = ".changeWorkingDirectory(dir";
  protected final String TEXT_90 = ");" + NL + "\t\t\t\t\tif (!doesDirExist_";
  protected final String TEXT_91 = ") {";
  protected final String TEXT_92 = NL + "\t\t\t\t\t\t\tlog.warn(\"Directory \" + dir";
  protected final String TEXT_93 = " + \" does not exist. Filemask \" + filemask";
  protected final String TEXT_94 = " + \" ignored\");";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\tbreak; //skip filemask with not existing dir" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_96 = NL + "\t\t\t\t\tmask";
  protected final String TEXT_97 = " = org.apache.oro.text.GlobCompiler.globToPerl5(mask";
  protected final String TEXT_98 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);";
  protected final String TEXT_99 = NL + "\t\t\t\torg.apache.commons.net.ftp.FTPFile[] filesInDirectory_";
  protected final String TEXT_100 = " = null;" + NL + "\t\t\t\tboolean getFileNamesFailed_";
  protected final String TEXT_101 = " = false;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tfilesInDirectory_";
  protected final String TEXT_102 = " = ftp_";
  protected final String TEXT_103 = ".listFiles();" + NL + "\t\t\t\t} catch(java.io.IOException e_";
  protected final String TEXT_104 = ") {" + NL + "\t\t\t\t\tgetFileNamesFailed_";
  protected final String TEXT_105 = " = true;";
  protected final String TEXT_106 = NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_107 = " - \" + e_";
  protected final String TEXT_108 = ".getMessage());";
  protected final String TEXT_109 = NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tif (getFileNamesFailed_";
  protected final String TEXT_110 = ") {";
  protected final String TEXT_111 = NL + "\t\t\t\t\t\tlog.warn(\"Can't get file names from \" + dir";
  protected final String TEXT_112 = " + \". Filemask \" + filemask";
  protected final String TEXT_113 = " + \" ignored\");";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\tSystem.err.println(\"Can't get file names from \" + dir";
  protected final String TEXT_115 = " + \". Filemask \" + filemask";
  protected final String TEXT_116 = " + \" ignored\");";
  protected final String TEXT_117 = NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t\t\tfor (org.apache.commons.net.ftp.FTPFile file_";
  protected final String TEXT_119 = " : filesInDirectory_";
  protected final String TEXT_120 = ") {" + NL + "\t\t\t\t\t\tString fileName_";
  protected final String TEXT_121 = " = file_";
  protected final String TEXT_122 = ".getName();" + NL + "\t\t\t\t\t\tif (fileName_";
  protected final String TEXT_123 = ".matches(mask";
  protected final String TEXT_124 = ")) {" + NL + "\t\t\t\t\t\t\tboolean successTruncated_";
  protected final String TEXT_125 = " = false;" + NL + "\t\t\t\t\t\t\t\tif (file_";
  protected final String TEXT_126 = ".isFile()) {" + NL + "\t\t\t\t\t\t\t\t\tsuccessTruncated_";
  protected final String TEXT_127 = " = ftp_";
  protected final String TEXT_128 = ".storeFile(fileName_";
  protected final String TEXT_129 = ", new java.io.ByteArrayInputStream(new byte[]{}));" + NL + "\t\t\t\t\t\t\t\t\tif (successTruncated_";
  protected final String TEXT_130 = ") {" + NL + "\t\t\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_131 = "_CURRENT_STATUS\", \"File truncate OK.\");" + NL + "\t\t\t\t\t\t\t\t\t\tnb_file_";
  protected final String TEXT_132 = "++;" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_133 = NL + "\t\t\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_134 = " - File '\" + fileName_";
  protected final String TEXT_135 = "  + \"' was truncated from the remote directory \" + ";
  protected final String TEXT_136 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t\tString responceFTPMessage = ftp_";
  protected final String TEXT_138 = ".getReplyString();" + NL + "\t\t\t\t\t\t\t\t\t\tString errorMessageDeleteFail = \"";
  protected final String TEXT_139 = " - File '\" + fileName_";
  protected final String TEXT_140 = "  + \"' was not truncated. Error message: \" + responceFTPMessage;" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\t\t\t\t\t\t\t\tlog.error(errorMessageDeleteFail);" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\t\t\t\t\t\t\t\t\tSystem.err.println(errorMessageDeleteFail);" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_144 = "_CURRENT_STATUS\", \"File truncate fail.\");" + NL + "\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(errorMessageDeleteFail);" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_145 = NL + "\t\t\tftp_";
  protected final String TEXT_146 = ".changeWorkingDirectory(rootWorkDir_";
  protected final String TEXT_147 = ");";
  protected final String TEXT_148 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_149 = "_CURRENT_STATUS\", \"No file truncated.\");" + NL + "    \tjava.util.Set<String> keySet";
  protected final String TEXT_150 = " = map";
  protected final String TEXT_151 = ".keySet(); " + NL + "\t    try {" + NL + "\t\t\tfor (String key";
  protected final String TEXT_152 = " : keySet";
  protected final String TEXT_153 = ") {     " + NL + "\t\t\t\tString filemask";
  protected final String TEXT_154 = " = key";
  protected final String TEXT_155 = "; " + NL + "\t\t\t\tString dir";
  protected final String TEXT_156 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_157 = NL + "    \t    \t\tString mask";
  protected final String TEXT_158 = " = filemask";
  protected final String TEXT_159 = ".replaceAll(\"\\\\\\\\\", \"/\") ;" + NL + "\t\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\t\t\tString mask";
  protected final String TEXT_161 = " = filemask";
  protected final String TEXT_162 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_163 = NL + "\t\t    \tint i";
  protected final String TEXT_164 = " = mask";
  protected final String TEXT_165 = ".lastIndexOf('/');" + NL + "\t\t\t\tif (i";
  protected final String TEXT_166 = "!=-1) {" + NL + "\t\t\t\t\tdir";
  protected final String TEXT_167 = " = mask";
  protected final String TEXT_168 = ".substring(0, i";
  protected final String TEXT_169 = "); " + NL + "\t\t\t\t\tmask";
  protected final String TEXT_170 = " = mask";
  protected final String TEXT_171 = ".substring(i";
  protected final String TEXT_172 = "+1); " + NL + "\t    \t\t}" + NL + "\t\t\t\tif (dir";
  protected final String TEXT_173 = "!=null && !\"\".equals(dir";
  protected final String TEXT_174 = ")) ftp_";
  protected final String TEXT_175 = ".chdir(dir";
  protected final String TEXT_176 = ");" + NL + "\t\t        ";
  protected final String TEXT_177 = NL + "    \t\t\t\tmask";
  protected final String TEXT_178 = " = org.apache.oro.text.GlobCompiler.globToPerl5(mask";
  protected final String TEXT_179 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t\t       \t";
  protected final String TEXT_180 = NL + "\t\t\t\tString[] listings";
  protected final String TEXT_181 = " = ftp_";
  protected final String TEXT_182 = ".dir(null, false);" + NL + "\t\t\t\tfor (int m";
  protected final String TEXT_183 = " = 0; m";
  protected final String TEXT_184 = " < listings";
  protected final String TEXT_185 = ".length; m";
  protected final String TEXT_186 = "++) {" + NL + "\t\t\t\t\tif (listings";
  protected final String TEXT_187 = "[m";
  protected final String TEXT_188 = "].matches(mask";
  protected final String TEXT_189 = ")) {" + NL + "\t\t\t\t\t\tftp_";
  protected final String TEXT_190 = ".put(new ByteArrayInputStream(new byte[]{}), listings";
  protected final String TEXT_191 = "[m";
  protected final String TEXT_192 = "]);" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_193 = "_CURRENT_STATUS\", \"File truncate OK.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_195 = " - '\" + listings";
  protected final String TEXT_196 = "[m";
  protected final String TEXT_197 = "] + \"' truncate ok.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_198 = NL + "\t\t\t\t\t\tnb_file_";
  protected final String TEXT_199 = "++;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t   \t\t}" + NL + "\t\t}catch(com.enterprisedt.net.ftp.FTPException e){" + NL + "   \t\t\tglobalMap.put(\"";
  protected final String TEXT_200 = "_CURRENT_STATUS\", \"File truncate fail.\");" + NL + "\t   \t\tthrow e;" + NL + "   \t\t}" + NL + "\t\tftp_";
  protected final String TEXT_201 = ".chdir(root";
  protected final String TEXT_202 = ");";
  protected final String TEXT_203 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	boolean sftp = false;
	boolean ftps = false;
	boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
	boolean useGlob = ("true").equals(ElementParameterParser.getValue(node, "__PERL5_REGEX__"));
	if(("true").equals(useExistingConn)){
		List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();
		for(INode n : nodeList){
			if(n.getUniqueName().equals(connection)){
				sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
				ftps = ("true").equals(ElementParameterParser.getValue(n, "__FTPS__"));
			}
		}
	}else{
		sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
		ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__"));
	}
	if(sftp){  /* sftp */ 

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    if(!useGlob) {//perl5 mode not support windows(\) path separator at the mask string
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    }else{
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			//bug TDI-19189 make regex to match the file name with Regular Expressions  

    stringBuffer.append(TEXT_27);
    if(!useGlob) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
	} else if (ftps) {  /* ftps */ 

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
     /*prepare filemask*/ 
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
					if ("false".equals(useExistingConn) || !moveToCurrentDir) {
						String remoteDirReplaced = remotedir.replaceAll("\\\\", "/");

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(remoteDirReplaced );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    
					}

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    
				if(!useGlob) { //perl5 mode not support windows(\) path separator at the mask string

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
				} else {

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    
						if (isLog4jEnabled) {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    
						}

    stringBuffer.append(TEXT_95);
    
				if(!useGlob) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    
				}

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
					if(isLog4jEnabled) {

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
					}

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    
					if (isLog4jEnabled) {

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    
					} else {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    
					}

    stringBuffer.append(TEXT_117);
     /*search files matches to filemask and truncate them*/ 
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_141);
    } else { 
    stringBuffer.append(TEXT_142);
    }
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
     /*return to root dir for next filemask*/ 
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    
	} else {  /* ftp */ 

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    if(!useGlob) {//perl5 mode not support windows(\) path separator at the mask string
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    }else{
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    if(!useGlob) {
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    }
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    }
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    }
    stringBuffer.append(TEXT_203);
    return stringBuffer.toString();
  }
}

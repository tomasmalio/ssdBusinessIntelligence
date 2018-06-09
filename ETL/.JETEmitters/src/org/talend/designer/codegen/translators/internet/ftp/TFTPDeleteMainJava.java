package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPDeleteMainJava
{
  protected static String nl;
  public static synchronized TFTPDeleteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPDeleteMainJava result = new TFTPDeleteMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\ttry{" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_3 = "_CURRENT_STATUS\", \"No file deleted.\");" + NL + "\t\tjava.util.Set<String> keySet";
  protected final String TEXT_4 = " = map";
  protected final String TEXT_5 = ".keySet(); ";
  protected final String TEXT_6 = NL + "\t\t\tfor (String key";
  protected final String TEXT_7 = " : keySet";
  protected final String TEXT_8 = ") {     " + NL + "\t\t\t\tString filemask";
  protected final String TEXT_9 = " = key";
  protected final String TEXT_10 = "; " + NL + "\t\t    \tString dir";
  protected final String TEXT_11 = " = null;" + NL + "        \t\t";
  protected final String TEXT_12 = NL + "\t\t        \tString mask";
  protected final String TEXT_13 = " = filemask";
  protected final String TEXT_14 = ".replaceAll(\"\\\\\\\\\", \"/\") ;" + NL + "        \t\t";
  protected final String TEXT_15 = NL + "\t\t       \tString mask";
  protected final String TEXT_16 = " = filemask";
  protected final String TEXT_17 = ";" + NL + "        \t\t";
  protected final String TEXT_18 = NL + "\t\t    \tint i";
  protected final String TEXT_19 = " = mask";
  protected final String TEXT_20 = ".lastIndexOf('/');" + NL + "\t\t\t\tif (i";
  protected final String TEXT_21 = "!=-1) {" + NL + "\t\t\t\t\tdir";
  protected final String TEXT_22 = " = mask";
  protected final String TEXT_23 = ".substring(0, i";
  protected final String TEXT_24 = "); " + NL + "\t\t\t\t\tmask";
  protected final String TEXT_25 = " = mask";
  protected final String TEXT_26 = ".substring(i";
  protected final String TEXT_27 = "+1); " + NL + "    \t\t\t}";
  protected final String TEXT_28 = " " + NL + "\t\t        ";
  protected final String TEXT_29 = NL + "        \t\t\tmask";
  protected final String TEXT_30 = " = org.apache.oro.text.GlobCompiler.globToPerl5(mask";
  protected final String TEXT_31 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t\t        ";
  protected final String TEXT_32 = NL + "\t\t\t\tjava.util.Vector listings";
  protected final String TEXT_33 = " = c_";
  protected final String TEXT_34 = ".ls(";
  protected final String TEXT_35 = ");" + NL + "\t\t\t\tfor (int m";
  protected final String TEXT_36 = " = 0; m";
  protected final String TEXT_37 = " < listings";
  protected final String TEXT_38 = ".size(); m";
  protected final String TEXT_39 = "++) { " + NL + "\t\t\t\t\tString filePath";
  protected final String TEXT_40 = " =  ((com.jcraft.jsch.ChannelSftp.LsEntry) listings";
  protected final String TEXT_41 = ".elementAt(m";
  protected final String TEXT_42 = ")).getFilename() ;" + NL + "\t\t\t\t\tif ( filePath";
  protected final String TEXT_43 = ".matches(mask";
  protected final String TEXT_44 = ")) {" + NL + "\t\t\t\t\t\ttry {";
  protected final String TEXT_45 = "\t\t\t" + NL + "\t\t\t\t\t\t\t \tc_";
  protected final String TEXT_46 = ".rm((";
  protected final String TEXT_47 = ")+\"/\"+ filePath";
  protected final String TEXT_48 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_50 = " - File '\" + filePath";
  protected final String TEXT_51 = "  + \"' was deleted from the remote directory \" + ";
  protected final String TEXT_52 = " + \".\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\t\t \tc_";
  protected final String TEXT_54 = ".rmdir((";
  protected final String TEXT_55 = ")+\"/\"+ filePath";
  protected final String TEXT_56 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_58 = " - Directory '\" + filePath";
  protected final String TEXT_59 = "  + \"' was deleted from the remote directory \" + ";
  protected final String TEXT_60 = " + \".\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\t\t\t globalMap.put(\"";
  protected final String TEXT_62 = "_CURRENT_STATUS\", \"File deleted.\");" + NL + "\t\t\t\t\t\t} catch (com.jcraft.jsch.SftpException e_";
  protected final String TEXT_63 = ") {" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_64 = "_CURRENT_STATUS\", \"Deleting file action error\");" + NL + "            \t           throw e_";
  protected final String TEXT_65 = ";" + NL + "                \t\t}" + NL + "\t\t\t\t\t\tnb_file_";
  protected final String TEXT_66 = "++;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}\t     " + NL + "\t\t\t}  " + NL + "" + NL + "" + NL + "   " + NL + "    ";
  protected final String TEXT_67 = NL + "\t\t\tfor (String key";
  protected final String TEXT_68 = " : keySet";
  protected final String TEXT_69 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\tString filemask";
  protected final String TEXT_71 = " = key";
  protected final String TEXT_72 = ";";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\tfilemask";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = " + \"/\" + filemask";
  protected final String TEXT_76 = ";";
  protected final String TEXT_77 = NL + "\t\t\t\tString dir";
  protected final String TEXT_78 = " = null;" + NL + "\t\t\t\tString mask";
  protected final String TEXT_79 = " = null;";
  protected final String TEXT_80 = NL + "\t\t\t\t\tmask";
  protected final String TEXT_81 = " = filemask";
  protected final String TEXT_82 = ".replaceAll(\"\\\\\\\\\", \"/\") ;";
  protected final String TEXT_83 = NL + "\t\t\t\t\tmask";
  protected final String TEXT_84 = " = filemask";
  protected final String TEXT_85 = ";";
  protected final String TEXT_86 = NL + "\t\t\t\tint i";
  protected final String TEXT_87 = " = mask";
  protected final String TEXT_88 = ".lastIndexOf('/');" + NL + "" + NL + "\t\t\t\tif (i";
  protected final String TEXT_89 = "!=-1) {" + NL + "\t\t\t\t\tdir";
  protected final String TEXT_90 = " = mask";
  protected final String TEXT_91 = ".substring(0, i";
  protected final String TEXT_92 = ");" + NL + "\t\t\t\t\tmask";
  protected final String TEXT_93 = " = mask";
  protected final String TEXT_94 = ".substring(i";
  protected final String TEXT_95 = "+1);" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tif (dir";
  protected final String TEXT_96 = " != null && !\"\".equals(dir";
  protected final String TEXT_97 = ")) {" + NL + "\t\t\t\t\tboolean doesDirExist_";
  protected final String TEXT_98 = " = ftp_";
  protected final String TEXT_99 = ".changeWorkingDirectory(dir";
  protected final String TEXT_100 = ");" + NL + "\t\t\t\t\tif (!doesDirExist_";
  protected final String TEXT_101 = ") {";
  protected final String TEXT_102 = NL + "\t\t\t\t\t\t\tlog.warn(\"Directory \" + dir";
  protected final String TEXT_103 = " + \" does not exist. Filemask \" + filemask";
  protected final String TEXT_104 = " + \" ignored\");";
  protected final String TEXT_105 = NL + "\t\t\t\t\t\tbreak; //skip filemask with not existing dir" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_106 = NL + "\t\t\t\t\tmask";
  protected final String TEXT_107 = " = org.apache.oro.text.GlobCompiler.globToPerl5(mask";
  protected final String TEXT_108 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);";
  protected final String TEXT_109 = NL + "\t\t\t\torg.apache.commons.net.ftp.FTPFile[] filesInDirectory_";
  protected final String TEXT_110 = " = null;" + NL + "\t\t\t\tboolean getFileNamesFailed_";
  protected final String TEXT_111 = " = false;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tfilesInDirectory_";
  protected final String TEXT_112 = " = ftp_";
  protected final String TEXT_113 = ".listFiles();" + NL + "\t\t\t\t} catch(java.io.IOException e_";
  protected final String TEXT_114 = ") {" + NL + "\t\t\t\t\tgetFileNamesFailed_";
  protected final String TEXT_115 = " = true;";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_117 = " - \" + e_";
  protected final String TEXT_118 = ".getMessage());";
  protected final String TEXT_119 = NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tif (getFileNamesFailed_";
  protected final String TEXT_120 = ") {";
  protected final String TEXT_121 = NL + "\t\t\t\t\t\tlog.warn(\"Can't get file names from \" + dir";
  protected final String TEXT_122 = " + \". Filemask \" + filemask";
  protected final String TEXT_123 = " + \" ignored\");";
  protected final String TEXT_124 = NL + "\t\t\t\t\t\tSystem.err.println(\"Can't get file names from \" + dir";
  protected final String TEXT_125 = " + \". Filemask \" + filemask";
  protected final String TEXT_126 = " + \" ignored\");";
  protected final String TEXT_127 = NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\t\tfor (org.apache.commons.net.ftp.FTPFile file_";
  protected final String TEXT_129 = " : filesInDirectory_";
  protected final String TEXT_130 = ") {" + NL + "\t\t\t\t\t\tString fileName_";
  protected final String TEXT_131 = " = file_";
  protected final String TEXT_132 = ".getName();" + NL + "\t\t\t\t\t\tif (fileName_";
  protected final String TEXT_133 = ".matches(mask";
  protected final String TEXT_134 = ")) {" + NL + "\t\t\t\t\t\t\tboolean successDeleted_";
  protected final String TEXT_135 = " = false;";
  protected final String TEXT_136 = NL + "\t\t\t\t\t\t\t\t\tif (file_";
  protected final String TEXT_137 = ".isFile()) {" + NL + "\t\t\t\t\t\t\t\t\t\tsuccessDeleted_";
  protected final String TEXT_138 = " = ftp_";
  protected final String TEXT_139 = ".deleteFile(fileName_";
  protected final String TEXT_140 = ");" + NL + "\t\t\t\t\t\t\t\t\t\tif (successDeleted_";
  protected final String TEXT_141 = ") {" + NL + "\t\t\t\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_142 = "_CURRENT_STATUS\", \"File deleted.\");" + NL + "\t\t\t\t\t\t\t\t\t\t\tnb_file_";
  protected final String TEXT_143 = "++;" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_145 = " - File '\" + fileName_";
  protected final String TEXT_146 = "  + \"' was deleted from the remote directory \" + ";
  protected final String TEXT_147 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_148 = NL + "\t\t\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t\t\tString responceFTPMessage = ftp_";
  protected final String TEXT_149 = ".getReplyString();" + NL + "\t\t\t\t\t\t\t\t\t\t\tString errorMessageDeleteFail = \"";
  protected final String TEXT_150 = " - File '\" + fileName_";
  protected final String TEXT_151 = "  + \"' was not deleted. Error message: \" + responceFTPMessage;" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tlog.error(errorMessageDeleteFail);" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_153 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tSystem.err.println(errorMessageDeleteFail);" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_154 = NL + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_155 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(errorMessageDeleteFail);" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_156 = NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_157 = NL + "\t\t\t\t\t\t\t\t\tif (file_";
  protected final String TEXT_158 = ".isDirectory()) {" + NL + "\t\t\t\t\t\t\t\t\t\tsuccessDeleted_";
  protected final String TEXT_159 = " = ftp_";
  protected final String TEXT_160 = ".removeDirectory(fileName_";
  protected final String TEXT_161 = ");" + NL + "\t\t\t\t\t\t\t\t\t\tif (successDeleted_";
  protected final String TEXT_162 = ") {" + NL + "\t\t\t\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_163 = "_CURRENT_STATUS\", \"File deleted.\");" + NL + "\t\t\t\t\t\t\t\t\t\t\tnb_file_";
  protected final String TEXT_164 = "++;" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_165 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_166 = " - Directory '\" + fileName_";
  protected final String TEXT_167 = "  + \"' was deleted from the remote directory \" + ";
  protected final String TEXT_168 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t\t\tString responceFTPMessage = ftp_";
  protected final String TEXT_170 = ".getReplyString();" + NL + "\t\t\t\t\t\t\t\t\t\t\tString errorMessageDeleteFail = \"";
  protected final String TEXT_171 = " - Directory '\" + fileName_";
  protected final String TEXT_172 = "  + \"' was not deleted. Error message: \" + responceFTPMessage;" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_173 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tlog.error(errorMessageDeleteFail);" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_174 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tSystem.err.println(errorMessageDeleteFail);" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_175 = NL + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_176 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(errorMessageDeleteFail);" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_177 = NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_178 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_179 = NL + "\t\t\tftp_";
  protected final String TEXT_180 = ".changeWorkingDirectory(rootWorkDir_";
  protected final String TEXT_181 = ");";
  protected final String TEXT_182 = NL + "\t\t    try {" + NL + "\t\t\t\tfor (String key";
  protected final String TEXT_183 = " : keySet";
  protected final String TEXT_184 = ") {     " + NL + "\t\t\t\t\tString filemask";
  protected final String TEXT_185 = " = key";
  protected final String TEXT_186 = "; " + NL + "\t\t\t\t   \tString dir";
  protected final String TEXT_187 = " = null;" + NL + "\t\t\t        ";
  protected final String TEXT_188 = NL + "\t\t\t\t        String mask";
  protected final String TEXT_189 = " = filemask";
  protected final String TEXT_190 = ".replaceAll(\"\\\\\\\\\", \"/\") ;" + NL + "\t\t\t\t\t";
  protected final String TEXT_191 = NL + "\t\t\t\t\tString mask";
  protected final String TEXT_192 = " = filemask";
  protected final String TEXT_193 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\t\tint i";
  protected final String TEXT_195 = " = mask";
  protected final String TEXT_196 = ".lastIndexOf('/');" + NL + "\t\t\t\t\tif (i";
  protected final String TEXT_197 = "!=-1) {" + NL + "\t\t\t\t\t\tdir";
  protected final String TEXT_198 = " = mask";
  protected final String TEXT_199 = ".substring(0, i";
  protected final String TEXT_200 = "); " + NL + "\t\t\t\t\t\tmask";
  protected final String TEXT_201 = " = mask";
  protected final String TEXT_202 = ".substring(i";
  protected final String TEXT_203 = "+1); " + NL + "    \t\t\t\t}" + NL + "\t\t\t    \tif (dir";
  protected final String TEXT_204 = "!=null && !\"\".equals(dir";
  protected final String TEXT_205 = ")) ftp_";
  protected final String TEXT_206 = ".chdir(dir";
  protected final String TEXT_207 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_208 = NL + "        \t\t\t    mask";
  protected final String TEXT_209 = " = org.apache.oro.text.GlobCompiler.globToPerl5(mask";
  protected final String TEXT_210 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t\t\t        ";
  protected final String TEXT_211 = NL + "\t\t\t    \tString[] fileName_";
  protected final String TEXT_212 = " = null;" + NL + "\t\t\t    \tboolean dirFailed_";
  protected final String TEXT_213 = " = false;" + NL + "\t\t\t    \ttry{" + NL + "    \t\t\t\t\tfileName_";
  protected final String TEXT_214 = " = ftp_";
  protected final String TEXT_215 = ".dir(null,false);" + NL + "\t\t\t\t   \t}catch(com.enterprisedt.net.ftp.FTPException e_";
  protected final String TEXT_216 = "){" + NL + "\t\t\t    \t\tdirFailed_";
  protected final String TEXT_217 = " = true;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_218 = NL + "\t\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_219 = " - \" + e_";
  protected final String TEXT_220 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_221 = NL + "\t\t\t    \t}" + NL + "\t\t\t    \tif((fileName_";
  protected final String TEXT_222 = " == null) || dirFailed_";
  protected final String TEXT_223 = " || (fileName_";
  protected final String TEXT_224 = ".length <= 0)){" + NL + "\t\t\t\t\t\tcom.enterprisedt.net.ftp.FTPFile[] fileList_";
  protected final String TEXT_225 = " = ftp_";
  protected final String TEXT_226 = ".dirDetails(null);" + NL + "\t\t\t\t\t\tfileName_";
  protected final String TEXT_227 = " = new String[fileList_";
  protected final String TEXT_228 = ".length];" + NL + "\t\t\t\t\t\tfor (int i_";
  protected final String TEXT_229 = " = 0 ; i_";
  protected final String TEXT_230 = " < fileList_";
  protected final String TEXT_231 = ".length ; i_";
  protected final String TEXT_232 = "++){" + NL + "\t\t\t\t\t\t\tfileName_";
  protected final String TEXT_233 = "[i_";
  protected final String TEXT_234 = "] = fileList_";
  protected final String TEXT_235 = "[i_";
  protected final String TEXT_236 = "].getName();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tfor (String file_";
  protected final String TEXT_237 = " : fileName_";
  protected final String TEXT_238 = ") {" + NL + "\t\t\t\t\t\tif (file_";
  protected final String TEXT_239 = ".matches(mask";
  protected final String TEXT_240 = ")) {";
  protected final String TEXT_241 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tftp_";
  protected final String TEXT_242 = ".delete(file_";
  protected final String TEXT_243 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_244 = NL + "\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_245 = " - File '\" + file_";
  protected final String TEXT_246 = "  + \"' was deleted from the remote directory \" + ";
  protected final String TEXT_247 = " + \".\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_248 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_249 = NL + "\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_250 = " - Directory '\" + file_";
  protected final String TEXT_251 = "  + \"' was deleted from the remote directory \" + ";
  protected final String TEXT_252 = " + \".\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_253 = NL + "\t\t\t\t\t\t\t\tftp_";
  protected final String TEXT_254 = ".rmdir(file_";
  protected final String TEXT_255 = ");";
  protected final String TEXT_256 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_257 = "_CURRENT_STATUS\", \"File deleted.\");" + NL + "\t\t\t\t\t\t\tnb_file_";
  protected final String TEXT_258 = "++;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "   \t\t\t\t}" + NL + "\t\t   \t}catch(com.enterprisedt.net.ftp.FTPException e_";
  protected final String TEXT_259 = "){" + NL + "   \t\t\t\tglobalMap.put(\"";
  protected final String TEXT_260 = "_CURRENT_STATUS\", \"Deleting file action error\");" + NL + "   \t\t\t\tthrow e_";
  protected final String TEXT_261 = ";" + NL + "\t\t   \t}" + NL + "\t\t   ftp_";
  protected final String TEXT_262 = ".chdir(root";
  protected final String TEXT_263 = ");";
  protected final String TEXT_264 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_265 = "){";
  protected final String TEXT_266 = NL + "    \t\tthrow(e_";
  protected final String TEXT_267 = ");";
  protected final String TEXT_268 = NL + "\t\t\t";
  protected final String TEXT_269 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_270 = " - \" + e_";
  protected final String TEXT_271 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_272 = NL + "\t\t\tSystem.err.print(e_";
  protected final String TEXT_273 = ".getMessage());";
  protected final String TEXT_274 = NL + "\t}";
  protected final String TEXT_275 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
	boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
	String targetType = ElementParameterParser.getValue(node, "__TARGET_TYPE__");
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	boolean sftp = false;
	boolean ftps = false;
	boolean usePerl5 = ("true").equals(ElementParameterParser.getValue(node, "__PERL5_REGEX__"));
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

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
		if(sftp){// *** sftp *** //

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    if(!usePerl5) {//perl5 mode not support windows(\) path separator at the mask string
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    }else{
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    }
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    
				//bug TDI-19189 make regex to match the file name with Regular Expressions  

    stringBuffer.append(TEXT_28);
    if(!usePerl5) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    
							if("FILE".equals(targetType)){

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_52);
    }
    
							}else{

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_60);
    }
    
							}

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
		}else if (ftps) { // *** ftps *** //

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
     /*prepare filemask*/ 
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
					if ("false".equals(useExistingConn) || !moveToCurrentDir) {
						String remoteDirReplaced = remotedir.replaceAll("\\\\", "/");

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(remoteDirReplaced );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    
					}

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    
				if(!usePerl5) { //perl5 mode not support windows(\) path separator at the mask string

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    
				} else {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    
				}

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    
						if (isLog4jEnabled) {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    
						}

    stringBuffer.append(TEXT_105);
    
				if(!usePerl5) {

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    
				}

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
					if(isLog4jEnabled) {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
					}

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    
					if (isLog4jEnabled) {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    
					} else {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    
					}

    stringBuffer.append(TEXT_127);
     /*search files matches to filemask and delete them*/ 
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    
								if("FILE".equals(targetType)){

    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_152);
    } else { 
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    if (("true").equals(dieOnError)) { 
    stringBuffer.append(TEXT_155);
     } 
    stringBuffer.append(TEXT_156);
    
								}else{

    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_173);
    } else { 
    stringBuffer.append(TEXT_174);
    }
    stringBuffer.append(TEXT_175);
    if (("true").equals(dieOnError)) { 
    stringBuffer.append(TEXT_176);
     } 
    stringBuffer.append(TEXT_177);
    
								}

    stringBuffer.append(TEXT_178);
     /*return to root dir for next filemask*/ 
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    
		}else {// *** ftp *** //

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
    if(!usePerl5) {//perl5 mode not support windows(\) path separator at the mask string
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    }else{
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    if(!usePerl5) {
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    }
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    }
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    
							if("FILE".equals(targetType)){

    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_247);
    }
    
							}else{

    stringBuffer.append(TEXT_248);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_252);
    }
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    
							}

    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    
		}

    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    
		if(("true").equals(dieOnError)){

    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    
		}else{

    stringBuffer.append(TEXT_268);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    }
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    
		}

    stringBuffer.append(TEXT_274);
    stringBuffer.append(TEXT_275);
    return stringBuffer.toString();
  }
}

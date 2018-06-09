package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TFTPGetBeginJava
{
  protected static String nl;
  public static synchronized TFTPGetBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPGetBeginJava result = new TFTPGetBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + " ";
  protected final String TEXT_30 = NL + "int nb_file_";
  protected final String TEXT_31 = " = 0;";
  protected final String TEXT_32 = NL + "  java.util.Properties props_";
  protected final String TEXT_33 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_34 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_35 = ");" + NL + "  props_";
  protected final String TEXT_36 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_37 = ");" + NL + "  props_";
  protected final String TEXT_38 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_39 = ");" + NL + "  ";
  protected final String TEXT_40 = " " + NL + "  String decryptedProxyPassword_";
  protected final String TEXT_41 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "  String decryptedProxyPassword_";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = "; ";
  protected final String TEXT_46 = NL + NL + "  props_";
  protected final String TEXT_47 = ".put(\"java.net.socks.password\", decryptedProxyPassword_";
  protected final String TEXT_48 = ");        ";
  protected final String TEXT_49 = "  " + NL + "\tfinal java.util.List<String> msg_";
  protected final String TEXT_50 = " = new java.util.ArrayList<String>();" + NL + "" + NL + "\t";
  protected final String TEXT_51 = NL + "\t\t\tclass MyUserInfo_";
  protected final String TEXT_52 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "\t\t\t" + NL + "\t\t        ";
  protected final String TEXT_53 = " " + NL + "              \t\tString decryptedPassphrase_";
  protected final String TEXT_54 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "              \t\tString decryptedPassphrase_";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = "; ";
  protected final String TEXT_59 = NL + "\t\t\t" + NL + "\t\t\t\tString passphrase_";
  protected final String TEXT_60 = " = decryptedPassphrase_";
  protected final String TEXT_61 = ";" + NL + "" + NL + "\t\t\t\tpublic String getPassphrase() { return passphrase_";
  protected final String TEXT_62 = "; }" + NL + "" + NL + "\t\t\t\tpublic String getPassword() { return null; } " + NL + "" + NL + "\t\t\t\tpublic boolean promptPassword(String arg0) { return true; } " + NL + "" + NL + "\t\t\t\tpublic boolean promptPassphrase(String arg0) { return true; } " + NL + "" + NL + "\t\t\t\tpublic boolean promptYesNo(String arg0) { return true; } " + NL + "" + NL + "\t\t\t\tpublic void showMessage(String arg0) { } " + NL + "" + NL + "\t\t\t\tpublic String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "\t\t\t\tboolean[] echo) {" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_63 = " " + NL + "            \t" + NL + "            \t";
  protected final String TEXT_64 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_65 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_68 = " = ";
  protected final String TEXT_69 = "; ";
  protected final String TEXT_70 = NL + "            \t" + NL + "\t\t\t\t\tString[] password_";
  protected final String TEXT_71 = " = {decryptedPassword_";
  protected final String TEXT_72 = "};" + NL + "\t\t\t\t\treturn password_";
  protected final String TEXT_73 = ";" + NL + "\t\t\t\t}" + NL + "\t\t\t}; " + NL + "" + NL + "\t\t\tfinal com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_74 = " = new MyUserInfo_";
  protected final String TEXT_75 = "();";
  protected final String TEXT_76 = NL + NL + "\t\t\tclass MyProgressMonitor_";
  protected final String TEXT_77 = " implements com.jcraft.jsch.SftpProgressMonitor {" + NL + "" + NL + "\t\t\t\tprivate long percent = -1;" + NL + "" + NL + "\t\t\t\tpublic void init(int op, String src, String dest, long max) {}" + NL + "" + NL + "\t\t\t\tpublic boolean count(long count) {return true;}" + NL + "" + NL + "\t\t\t\tpublic void end() {}" + NL + "\t\t\t} " + NL + "" + NL + "\t\t\tclass SFTPGetter_";
  protected final String TEXT_78 = " {" + NL + "" + NL + "\t\t\t\tprivate com.jcraft.jsch.ChannelSftp cnlSFTP = null;" + NL + "" + NL + "\t\t\t\tprivate com.jcraft.jsch.SftpProgressMonitor monitor = null;" + NL + "" + NL + "\t\t\t\tprivate int count = 0;" + NL + "" + NL + "\t\t\t\tpublic void getAllFiles(String remoteDirectory, String localDirectory) throws com.jcraft.jsch.SftpException {" + NL + "      " + NL + "\t\t\t\t\tchdir(remoteDirectory);" + NL + "\t\t\t\t\tjava.util.Vector sftpFiles = cnlSFTP.ls(\".\");" + NL + "" + NL + "\t\t\t\t\tfor (Object sftpFile : sftpFiles) {" + NL + "\t\t\t\t\t\tcom.jcraft.jsch.ChannelSftp.LsEntry lsEntry = (com.jcraft.jsch.ChannelSftp.LsEntry) sftpFile;" + NL + "\t\t\t\t\t\tcom.jcraft.jsch.SftpATTRS attrs = lsEntry.getAttrs();" + NL + "" + NL + "\t\t\t\t\t\tif ((\".\").equals(lsEntry.getFilename()) || (\"..\").equals(lsEntry.getFilename())) {" + NL + "\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\tif (attrs.isDir()) {" + NL + "\t\t\t\t\t\t\tjava.io.File localFile = new java.io.File(localDirectory + \"/\" + lsEntry.getFilename());" + NL + "\t\t\t\t\t\t\tif (!localFile.exists()) {" + NL + "\t\t\t\t\t\t\t\tlocalFile.mkdir();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tgetAllFiles(remoteDirectory + \"/\" + lsEntry.getFilename(), localDirectory + \"/\" + lsEntry.getFilename());" + NL + "\t\t\t\t\t\t\tchdir(remoteDirectory);" + NL + "\t\t\t\t\t\t} else if (!attrs.isLink()) {" + NL + "\t\t\t\t\t\t\tdownloadFile(localDirectory, lsEntry.getFilename());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void getFiles(String remoteDirectory, String localDirectory, String maskStr) throws com.jcraft.jsch.SftpException {" + NL + "      " + NL + "\t\t\t\t\tchdir(remoteDirectory);" + NL + "\t\t\t\t\tjava.util.Vector sftpFiles = cnlSFTP.ls(\".\");" + NL + "" + NL + "\t\t\t\t\tfor (Object sftpFile : sftpFiles) {" + NL + "\t\t\t\t\t\tcom.jcraft.jsch.ChannelSftp.LsEntry lsEntry = (com.jcraft.jsch.ChannelSftp.LsEntry) sftpFile;" + NL + "\t\t\t\t\t\tcom.jcraft.jsch.SftpATTRS attrs = lsEntry.getAttrs();" + NL + "" + NL + "\t\t\t\t\t\tif ((\".\").equals(lsEntry.getFilename()) || (\"..\").equals(lsEntry.getFilename())) {" + NL + "\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\tif (!attrs.isDir() && !attrs.isLink()) {" + NL + "" + NL + "\t\t\t\t\t\t\tif (lsEntry.getFilename().matches(maskStr)) {" + NL + "            \t\t\t\t\tdownloadFile(localDirectory, lsEntry.getFilename());" + NL + "          \t\t\t\t\t}" + NL + "        \t\t\t\t}" + NL + "      \t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void chdir(String path) throws com.jcraft.jsch.SftpException{" + NL + "\t\t\t\t\tif (!\".\".equals(path)) {" + NL + "\t\t\t\t\t\tcnlSFTP.cd(path);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic String pwd() throws com.jcraft.jsch.SftpException{" + NL + "\t\t\t\t\treturn cnlSFTP.pwd();" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tprivate void downloadFile(String localFileName, String remoteFileName) throws com.jcraft.jsch.SftpException {" + NL + "" + NL + "\t\t\t\t\ttry {" + NL + "        \t\t\t\tcnlSFTP.get(remoteFileName, localFileName, monitor,";
  protected final String TEXT_79 = "          " + NL + "            \t\t\t\tcom.jcraft.jsch.ChannelSftp.OVERWRITE";
  protected final String TEXT_80 = NL + "            \t\t\t\tcom.jcraft.jsch.ChannelSftp.APPEND";
  protected final String TEXT_81 = NL + "            \t\t\t\tcom.jcraft.jsch.ChannelSftp.RESUME";
  protected final String TEXT_82 = NL + "\t\t\t\t\t);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_84 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_85 = NL + "        \t\t\t\tmsg_";
  protected final String TEXT_86 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");" + NL + "        \t\t\t\t";
  protected final String TEXT_87 = NL + "          \t\t\t\t\tSystem.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");" + NL + "        \t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t    \tglobalMap.put(\"";
  protected final String TEXT_89 = "_CURRENT_STATUS\", \"File transfer OK.\");" + NL + "\t\t\t      \t} catch (com.jcraft.jsch.SftpException e){" + NL + "" + NL + "        \t\t\t\tif (e.id == com.jcraft.jsch.ChannelSftp.SSH_FX_FAILURE || e.id == com.jcraft.jsch.ChannelSftp.SSH_FX_BAD_MESSAGE) {" + NL + "\t\t\t\t\t\t\tmsg_";
  protected final String TEXT_90 = ".add(\"file [\" + remoteFileName + \"] downloaded unsuccessfully.\");" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_91 = "_CURRENT_STATUS\", \"File transfer fail.\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t        throw e;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tcount++;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL;
  protected final String TEXT_92 = NL + "\t\t\t\tcom.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_93 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_94 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t\tif(c_";
  protected final String TEXT_96 = "!=null && c_";
  protected final String TEXT_97 = ".getSession()!=null) {" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_98 = " - Use an existing connection.Connection username: \" + c_";
  protected final String TEXT_99 = ".getSession().getUserName() + \", Connection hostname: \" + c_";
  protected final String TEXT_100 = ".getSession().getHost() + \", Connection port: \" + c_";
  protected final String TEXT_101 = ".getSession().getPort() + \".\"); " + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\tif(c_";
  protected final String TEXT_103 = ".getHome()!=null && !c_";
  protected final String TEXT_104 = ".getHome().equals(c_";
  protected final String TEXT_105 = ".pwd())){" + NL + "\t\t\t  \t\tc_";
  protected final String TEXT_106 = ".cd(c_";
  protected final String TEXT_107 = ".getHome());" + NL + "\t\t\t  \t}";
  protected final String TEXT_108 = "    " + NL + "\t\t\t\tcom.jcraft.jsch.JSch jsch_";
  protected final String TEXT_109 = "=new com.jcraft.jsch.JSch(); " + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_112 = " - SFTP authentication using a public key.\");" + NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_113 = " - Private key: '\" + ";
  protected final String TEXT_114 = " + \"'.\");" + NL + "\t\t\t\t\t  ";
  protected final String TEXT_115 = NL + "    \t\t\t\tjsch_";
  protected final String TEXT_116 = ".addIdentity(";
  protected final String TEXT_117 = ", defaultUserInfo_";
  protected final String TEXT_118 = ".getPassphrase());" + NL + "\t\t\t    ";
  protected final String TEXT_119 = NL + "\t\t\t    " + NL + "\t\t\t\tcom.jcraft.jsch.Session session_";
  protected final String TEXT_120 = "=jsch_";
  protected final String TEXT_121 = ".getSession(";
  protected final String TEXT_122 = ", ";
  protected final String TEXT_123 = ", ";
  protected final String TEXT_124 = ");" + NL + "\t\t\t\tsession_";
  protected final String TEXT_125 = ".setConfig(\"PreferredAuthentications\", \"publickey,password,keyboard-interactive,gssapi-with-mic\");" + NL + "" + NL + "\t\t\t    ";
  protected final String TEXT_126 = NL + "\t\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_128 = " - SFTP authentication using a password.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_129 = NL + "\t\t\t\t\t" + NL + "        \t\t\t";
  protected final String TEXT_130 = " " + NL + "                \t" + NL + "                \t";
  protected final String TEXT_131 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_132 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_133 = ");";
  protected final String TEXT_134 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_135 = " = ";
  protected final String TEXT_136 = "; ";
  protected final String TEXT_137 = NL + "                \t" + NL + "\t\t\t\t      session_";
  protected final String TEXT_138 = ".setPassword(decryptedPassword_";
  protected final String TEXT_139 = "); " + NL + "\t\t\t    ";
  protected final String TEXT_140 = NL + NL + "\t\t\t\tsession_";
  protected final String TEXT_141 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_142 = "); " + NL + "\t\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\t  \tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "\t\t\t\t  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_144 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "\t\t\t\t  \t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "\t\t\t\t  \t\t\tproxy_";
  protected final String TEXT_145 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "\t\t\t\t  \t\t}" + NL + "\t\t\t\t  \t\tsession_";
  protected final String TEXT_146 = ".setProxy(proxy_";
  protected final String TEXT_147 = ");" + NL + "\t\t\t\t  \t}" + NL + "\t\t\t\t";
  protected final String TEXT_148 = NL + "\t\t\t\t";
  protected final String TEXT_149 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_150 = " - Attempt to connect to '\" + ";
  protected final String TEXT_151 = " + \"' with username: '\" + ";
  protected final String TEXT_152 = " + \"'.\");" + NL + "\t\t\t\t";
  protected final String TEXT_153 = NL + "\t\t\t    session_";
  protected final String TEXT_154 = ".connect();" + NL + "\t\t\t    com.jcraft.jsch. Channel channel_";
  protected final String TEXT_155 = "=session_";
  protected final String TEXT_156 = ".openChannel(\"sftp\");" + NL + "\t\t\t    channel_";
  protected final String TEXT_157 = ".connect();" + NL + "\t\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_159 = " - Connect to '\" + ";
  protected final String TEXT_160 = " + \"' has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_162 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_163 = ";" + NL + "\t\t\t    " + NL + "\t\t\t    ";
  protected final String TEXT_164 = NL + "\t\t\t    \tc_";
  protected final String TEXT_165 = ".setFilenameEncoding(";
  protected final String TEXT_166 = ");" + NL + "\t\t\t    ";
  protected final String TEXT_167 = NL + "\t\t\tcom.jcraft.jsch.SftpProgressMonitor monitor_";
  protected final String TEXT_168 = " = new MyProgressMonitor_";
  protected final String TEXT_169 = "();" + NL + "\t\t\tSFTPGetter_";
  protected final String TEXT_170 = " getter_";
  protected final String TEXT_171 = " = new SFTPGetter_";
  protected final String TEXT_172 = "();" + NL + "\t\t\tgetter_";
  protected final String TEXT_173 = ".cnlSFTP = c_";
  protected final String TEXT_174 = ";" + NL + "\t\t\tgetter_";
  protected final String TEXT_175 = ".monitor = monitor_";
  protected final String TEXT_176 = ";" + NL + "\t\t\tString remotedir_";
  protected final String TEXT_177 = " = ";
  protected final String TEXT_178 = ";" + NL + "\t\t\tif (!\".\".equals(remotedir_";
  protected final String TEXT_179 = ")) {" + NL + "\t\t\t\tc_";
  protected final String TEXT_180 = ".cd(remotedir_";
  protected final String TEXT_181 = ");" + NL + "\t\t\t}";
  protected final String TEXT_182 = "  " + NL + "\tfinal com.enterprisedt.net.ftp.TransferCompleteStrings msg_";
  protected final String TEXT_183 = " = new com.enterprisedt.net.ftp.TransferCompleteStrings();" + NL + "" + NL + "\tclass FTPGetter_";
  protected final String TEXT_184 = " {" + NL + "\t\tprivate com.enterprisedt.net.ftp.FTPClient ftpClient = null;" + NL + "\t    private int count = 0;" + NL + "" + NL + "    \tpublic void getAllFiles(String remoteDirectory, String localDirectory) throws java.io.IOException, " + NL + "\t\tcom.enterprisedt.net.ftp.FTPException, java.text.ParseException {" + NL + "" + NL + "\t\t\tchdir(remoteDirectory);" + NL + "\t\t\tString path = ftpClient.pwd();" + NL + "\t\t\tString[] ftpFileNames = null;" + NL + "\t\t\tcom.enterprisedt.net.ftp.FTPFile[] ftpFiles = null;" + NL + "" + NL + "\t\t\ttry{" + NL + "\t\t\t//use dir() for Bug9562 with FTP server in AS400" + NL + "\t\t\t\tftpFileNames = ftpClient.dir(null, false);" + NL + "\t        //Bug 13272, the same as getFiles()." + NL + "    \t\t} catch (com.enterprisedt.net.ftp.FTPException e){" + NL + "\t\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_186 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_187 = NL + "        \t\tftpFileNames = null;" + NL + "\t\t        ftpFiles = ftpClient.dirDetails(\".\");" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t//if dirDetails(...) doesn't work, then use dir(...), distinguish file type by FTPException" + NL + "" + NL + "\t\t\tif ((ftpFiles == null) && (ftpFileNames != null)){" + NL + "\t        \t//if the file is folder, catch the FTPException and recur" + NL + "    \t    \tfor (String ftpFileName : ftpFileNames){" + NL + "        \t\t\ttry {" + NL + "            \t\t\tdownloadFile(localDirectory + \"/\" + ftpFileName,ftpFileName);" + NL + "          \t\t\t} catch (com.enterprisedt.net.ftp.FTPException e) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_188 = NL + "\t\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_189 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_190 = NL + "      \t\t      \t\tjava.io.File localFile = new java.io.File(localDirectory + \"/\" + ftpFileName);" + NL + "" + NL + "        \t    \t\tif (!localFile.exists()) {" + NL + "        \t      \t\t\tlocalFile.mkdir();" + NL + "        \t    \t\t}" + NL + "\t\t\t\t\t\tgetAllFiles(path + \"/\" + ftpFileName, localDirectory + \"/\" + ftpFileName);" + NL + "\t\t\t\t\t\tchdir(path);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tfor (com.enterprisedt.net.ftp.FTPFile ftpFile : ftpFiles) {" + NL + "" + NL + "\t\t\t\t\tif (ftpFile.isDir()) {" + NL + "\t\t\t\t\t\tif ((!(\".\").equals(ftpFile.getName())) && (!(\"..\").equals(ftpFile.getName()))) {" + NL + "\t\t\t\t\t\t\tjava.io.File localFile = new java.io.File(localDirectory + \"/\" + ftpFile.getName());" + NL + "" + NL + "\t\t\t\t\t\t\tif (!localFile.exists()) {" + NL + "\t\t\t\t                localFile.mkdir();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tgetAllFiles(path + \"/\" + ftpFile.getName(), localDirectory + \"/\" + ftpFile.getName());" + NL + "\t\t\t\t\t\t\tchdir(path);" + NL + "\t\t\t            }" + NL + "\t\t\t\t\t} else if (!ftpFile.isLink()) {" + NL + "\t\t\t            downloadFile(localDirectory + \"/\" + ftpFile.getName(),ftpFile.getName());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void getFiles(String remoteDirectory, String localDirectory, String maskStr) throws java.io.IOException," + NL + "\t\tcom.enterprisedt.net.ftp.FTPException, java.text.ParseException {" + NL + "\t\t\tchdir(remoteDirectory);" + NL + "\t\t\tString[] ftpFileNames = null;" + NL + "\t\t\tcom.enterprisedt.net.ftp.FTPFile[] ftpFiles = null;" + NL + "" + NL + "\t\t\ttry {" + NL + "\t\t\t\t//use dir() for Bug9562 with FTP server in AS400 (the same way as getAllFiles())" + NL + "\t\t        ftpFileNames = ftpClient.dir(null, false);" + NL + "        \t\t//Bug 13272, if dir() throw exception, use dirDetails()." + NL + "\t\t\t} catch (com.enterprisedt.net.ftp.FTPException e){" + NL + "\t\t\t";
  protected final String TEXT_191 = NL + "\t\t\t\tlog.warn(\"";
  protected final String TEXT_192 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_193 = NL + "\t        ftpFileNames = null;" + NL + "    \t    ftpFiles = ftpClient.dirDetails(\".\");" + NL + "      \t\t}" + NL + "\t\t\t//if dirDetails(...) doesn't work, then use dir(...), but can not distinguish file type" + NL + "" + NL + "\t\t\tif ((ftpFiles == null) && (ftpFileNames != null)){" + NL + "\t\t\t\tfor (String ftpFileName : ftpFileNames) {" + NL + "\t\t\t\t\tif (ftpFileName.matches(maskStr)) {" + NL + "\t\t\t\t\t\tdownloadFile(localDirectory + \"/\" + ftpFileName,ftpFileName);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} else{" + NL + "" + NL + "\t\t        for (com.enterprisedt.net.ftp.FTPFile ftpFile : ftpFiles) {" + NL + "" + NL + "\t\t\t\t\tif (!ftpFile.isDir() && !ftpFile.isLink()) {" + NL + "\t\t\t\t\t\tString fileName = ftpFile.getName();" + NL + "" + NL + "\t\t\t            if (fileName.matches(maskStr)) {" + NL + "            \t\t\t\tdownloadFile(localDirectory + \"/\" + fileName,fileName);" + NL + "\t\t\t            }" + NL + "          \t\t\t}" + NL + "        \t\t}" + NL + "      \t\t}" + NL + "\t\t}" + NL + "" + NL + "\t    public void chdir(String path) throws java.io.IOException,  com.enterprisedt.net.ftp.FTPException{" + NL + "\t\t\tif (!\".\".equals(path)) {" + NL + "\t\t\t\tftpClient.chdir(path);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic String pwd() throws java.io.IOException,  com.enterprisedt.net.ftp.FTPException{" + NL + "\t\t\treturn ftpClient.pwd();" + NL + "\t\t}" + NL + "" + NL + "\t\tprivate void downloadFile(String localFileName, String remoteFileName) throws java.io.IOException, com.enterprisedt.net.ftp.FTPException {" + NL + "\t\t\tjava.io.File localFile = new java.io.File(localFileName);" + NL + "" + NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\t\tjava.io.FileOutputStream fout = new java.io.FileOutputStream(localFile, true);" + NL + "\t\t\t        ftpClient.get(fout, remoteFileName);" + NL + "\t\t\t\t\t";
  protected final String TEXT_195 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_196 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_197 = NL + "          \t\t\tmsg_";
  protected final String TEXT_198 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_199 = NL + "\t\t\t            System.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");" + NL + "          \t\t\t";
  protected final String TEXT_200 = NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_201 = "_CURRENT_STATUS\", \"File transfer OK.\");";
  protected final String TEXT_202 = NL + "        \t\t\tif (!localFile.exists()) {" + NL + "\t\t\t\t\t\tftpClient.get(localFileName, remoteFileName);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_203 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_204 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_205 = NL + "\t\t\t            msg_";
  protected final String TEXT_206 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");" + NL + "            \t\t\t";
  protected final String TEXT_207 = NL + "\t\t\t\t\t\t\tSystem.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");" + NL + "\t\t\t            ";
  protected final String TEXT_208 = NL + "            \t\t\tglobalMap.put(\"";
  protected final String TEXT_209 = "_CURRENT_STATUS\", \"File transfer OK.\");" + NL + "\t\t\t\t\t} else { ";
  protected final String TEXT_210 = NL + "                               log.info(\"";
  protected final String TEXT_211 = " - file [\"+ remoteFileName +\"] exit transmission.\");";
  protected final String TEXT_212 = NL + "\t\t\t\t\t\tmsg_";
  protected final String TEXT_213 = ".add(\"file [\"+ remoteFileName +\"] exit transmission.\");" + NL + "\t\t\t            globalMap.put(\"";
  protected final String TEXT_214 = "_CURRENT_STATUS\", \"No file transfered.\");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_215 = NL + "\t\t\t\t\tftpClient.get(localFileName, remoteFileName);" + NL + "\t\t\t\t\t";
  protected final String TEXT_216 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_217 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_218 = NL + "\t\t\t\t\tmsg_";
  protected final String TEXT_219 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\t\t\t\tSystem.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_221 = NL + "\t\t\t\t\tif (localFile.exists()) {" + NL + "\t\t\t\t\t\tlong ftpSize = ftpClient.size(remoteFileName);" + NL + "\t\t\t            long localSize = localFile.length();" + NL + "" + NL + "\t\t\t            if (ftpSize != localSize) {" + NL + "\t\t\t\t\t\t\tftpClient.get(localFileName, remoteFileName);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_222 = NL + "\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_223 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_224 = NL + "            \t\t\t\tmsg_";
  protected final String TEXT_225 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_226 = NL + "\t\t\t\t\t\t\t\tSystem.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_227 = NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_228 = "_CURRENT_STATUS\", \"File transfer OK.\");" + NL + "\t\t\t            } else {" + NL + "\t\t\t                 ";
  protected final String TEXT_229 = NL + "                                    log.info(\"";
  protected final String TEXT_230 = " - file [\"+ remoteFileName +\"] exit transmission.\");";
  protected final String TEXT_231 = NL + "            \t\t\t\tmsg_";
  protected final String TEXT_232 = ".add(\"file [\"+ remoteFileName +\"] exit transmission.\");" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_233 = "_CURRENT_STATUS\", \"No file transfered.\");" + NL + "\t\t\t            }" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tftpClient.get(localFileName, remoteFileName);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_234 = NL + "\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_235 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_236 = NL + "\t\t\t\t \t\tmsg_";
  protected final String TEXT_237 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_238 = NL + "\t\t\t\t\t\t\tSystem.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");" + NL + "\t\t\t            ";
  protected final String TEXT_239 = NL + "            \t\t\tglobalMap.put(\"";
  protected final String TEXT_240 = "_CURRENT_STATUS\", \"File transfer OK.\");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_241 = NL + "\t\t\t} catch (com.enterprisedt.net.ftp.FTPException e) {" + NL + "\t\t        msg_";
  protected final String TEXT_242 = ".add(\"file [\" + remoteFileName + \"] downloaded unsuccessfully.\");" + NL + "        \t\tglobalMap.put(\"";
  protected final String TEXT_243 = "_CURRENT_STATUS\", \"File transfer fail.\");" + NL + "        \t\tthrow e;" + NL + "      \t\t}" + NL + "\t\t      count++;" + NL + "    \t}" + NL + "\t}" + NL + "\tcom.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_244 = " = null;" + NL;
  protected final String TEXT_245 = NL + "\t    ftp_";
  protected final String TEXT_246 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_247 = "\");" + NL + "  \t\t";
  protected final String TEXT_248 = NL + "  \t\t\tString rootDir_";
  protected final String TEXT_249 = " = ftp_";
  protected final String TEXT_250 = ".pwd();" + NL + "\t  \t";
  protected final String TEXT_251 = NL + "\t\t";
  protected final String TEXT_252 = NL + "\t\t\tif(ftp_";
  protected final String TEXT_253 = "!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_254 = " - Uses an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_255 = ".getRemoteHost() + \", Connection port: \" + ftp_";
  protected final String TEXT_256 = ".getRemotePort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_257 = NL + "\t";
  protected final String TEXT_258 = "    " + NL + "    \tftp_";
  protected final String TEXT_259 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "\t    ftp_";
  protected final String TEXT_260 = ".setRemoteHost(";
  protected final String TEXT_261 = ");" + NL + "    \tftp_";
  protected final String TEXT_262 = ".setRemotePort(";
  protected final String TEXT_263 = ");" + NL + "" + NL + "\t    ";
  protected final String TEXT_264 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_265 = " - \" + ";
  protected final String TEXT_266 = ");" + NL + "\t\t";
  protected final String TEXT_267 = NL + "    \t\tftp_";
  protected final String TEXT_268 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);";
  protected final String TEXT_269 = NL + "    \t\tftp_";
  protected final String TEXT_270 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);";
  protected final String TEXT_271 = NL + "\t    ftp_";
  protected final String TEXT_272 = ".setControlEncoding(";
  protected final String TEXT_273 = ");" + NL + "\t\t";
  protected final String TEXT_274 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_275 = " - Attempt to connect to '\" + ";
  protected final String TEXT_276 = " + \"' with username '\" +";
  protected final String TEXT_277 = "+ \"'.\");" + NL + "\t\t";
  protected final String TEXT_278 = NL + "\t    ftp_";
  protected final String TEXT_279 = ".connect();" + NL + "\t    " + NL + "\t\t";
  protected final String TEXT_280 = " " + NL + "    \t" + NL + "    \t";
  protected final String TEXT_281 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_282 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_283 = ");";
  protected final String TEXT_284 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_285 = " = ";
  protected final String TEXT_286 = "; ";
  protected final String TEXT_287 = NL + "\t    " + NL + "    \tftp_";
  protected final String TEXT_288 = ".login(";
  protected final String TEXT_289 = ", decryptedPassword_";
  protected final String TEXT_290 = ");  " + NL + "\t\t";
  protected final String TEXT_291 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_292 = " - Connect to '\" + ";
  protected final String TEXT_293 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_294 = "  " + NL + "\t";
  protected final String TEXT_295 = NL + "\tmsg_";
  protected final String TEXT_296 = ".clearAll();" + NL + "\tFTPGetter_";
  protected final String TEXT_297 = " getter_";
  protected final String TEXT_298 = " = new FTPGetter_";
  protected final String TEXT_299 = "();" + NL + "\tgetter_";
  protected final String TEXT_300 = ".ftpClient = ftp_";
  protected final String TEXT_301 = ";" + NL + "\tString remotedir_";
  protected final String TEXT_302 = " = ";
  protected final String TEXT_303 = ";" + NL + "\tif (!\".\".equals(remotedir_";
  protected final String TEXT_304 = ")) {" + NL + "\t\tftp_";
  protected final String TEXT_305 = ".chdir(remotedir_";
  protected final String TEXT_306 = ");" + NL + "\t}";
  protected final String TEXT_307 = NL + "\tclass FTPSGetter_";
  protected final String TEXT_308 = " {" + NL + "\t\tprivate org.apache.commons.net.ftp.FTPClient ftpClient = null;" + NL + "\t\tprivate int count = 0;" + NL + "" + NL + "\t\tpublic void getAllFiles(String remoteDirectory, String localDirectory)" + NL + "\t\tthrows IllegalStateException, IOException, java.io.FileNotFoundException {" + NL + "" + NL + "\t\t\tchdir(remoteDirectory);" + NL + "\t\t\tString path = ftpClient.printWorkingDirectory();" + NL + "\t\t\torg.apache.commons.net.ftp.FTPFile[] ftpFiles = null;" + NL + "\t\t\tftpFiles = ftpClient.listFiles();" + NL + "" + NL + "\t\t\tfor (org.apache.commons.net.ftp.FTPFile ftpFile : ftpFiles) {" + NL + "" + NL + "\t\t\t\tif (ftpFile.isDirectory()) {" + NL + "" + NL + "\t\t\t\t\tif ((!(\".\").equals(ftpFile.getName())) && (!(\"..\").equals(ftpFile.getName()))) {" + NL + "\t\t\t\t\t\tjava.io.File localFile = new java.io.File(localDirectory + \"/\" + ftpFile.getName());" + NL + "" + NL + "\t\t\t\t\t\tif (!localFile.exists()) {" + NL + "\t\t\t\t\t\t\tlocalFile.mkdir();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tgetAllFiles(path + \"/\" + ftpFile.getName(), localDirectory + \"/\" + ftpFile.getName());" + NL + "\t\t\t\t\t\tchdir(path);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else if (!ftpFile.isSymbolicLink()) {" + NL + "\t\t\t\t\tdownloadFile(localDirectory + \"/\" + ftpFile.getName(),ftpFile.getName());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void getFiles(String remoteDirectory, String localDirectory, String maskStr) " + NL + "\t\tthrows IllegalStateException, IOException, java.io.FileNotFoundException {" + NL + "" + NL + "\t\t\tchdir(remoteDirectory);" + NL + "\t\t\torg.apache.commons.net.ftp.FTPFile[] ftpFiles = null;" + NL + "\t\t\tftpFiles = ftpClient.listFiles(\".\");" + NL + "" + NL + "\t\t\tfor(org.apache.commons.net.ftp.FTPFile ftpFile : ftpFiles) {" + NL + "" + NL + "\t\t\t\tif (ftpFile.isFile()) {" + NL + "\t\t\t\t\tString fileName = ftpFile.getName();" + NL + "" + NL + "\t\t\t\t\tif (fileName.matches(maskStr)) {" + NL + "\t\t\t\t\t\tdownloadFile(localDirectory + \"/\" + fileName,fileName);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void chdir(String path) " + NL + "\t\tthrows IllegalStateException, IOException {" + NL + "\t\t\tif (!\".\".equals(path)) {" + NL + "\t\t\t\tftpClient.changeWorkingDirectory(path);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic String pwd() " + NL + "\t\tthrows IllegalStateException, IOException {" + NL + "\t\t\treturn ftpClient.printWorkingDirectory();" + NL + "\t\t}" + NL + "" + NL + "\t\tprivate void downloadFile(String localFileName, String remoteFileName) " + NL + "\t\tthrows IllegalStateException, java.io.FileNotFoundException, IOException {" + NL + "\t\t\ttry (java.io.FileOutputStream localFos = new java.io.FileOutputStream(localFileName)) {" + NL + "\t\t\t\tftpClient.retrieveFile(remoteFileName, localFos);" + NL + "\t\t\t\t";
  protected final String TEXT_309 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_310 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_311 = NL + "\t\t\t\tcount++;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\torg.apache.commons.net.ftp.FTPSClient ftp_";
  protected final String TEXT_312 = " =null;";
  protected final String TEXT_313 = NL + "\t\t";
  protected final String TEXT_314 = NL + "\t\t";
  protected final String TEXT_315 = NL + NL + "\tclass MyTrust_";
  protected final String TEXT_316 = " {" + NL + "" + NL + "\t\tprivate javax.net.ssl.TrustManager[] getTrustManagers() " + NL + "\t\tthrows java.security.KeyStoreException, java.security.NoSuchAlgorithmException, " + NL + "\t\t\tjava.security.cert.CertificateException, java.security.UnrecoverableKeyException," + NL + "\t\t\tjava.io.IOException {" + NL + "\t\t\tjava.security.KeyStore ks = java.security.KeyStore.getInstance(\"JKS\");" + NL;
  protected final String TEXT_317 = " " + NL + "\t\t\t\tString decryptedKeyStorePassword_";
  protected final String TEXT_318 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_319 = ");";
  protected final String TEXT_320 = NL + "\t\t\t\tString decryptedKeyStorePassword_";
  protected final String TEXT_321 = " = ";
  protected final String TEXT_322 = "; ";
  protected final String TEXT_323 = NL + "\t\t\tks.load(new java.io.FileInputStream(";
  protected final String TEXT_324 = "), decryptedKeyStorePassword_";
  protected final String TEXT_325 = ".toCharArray());" + NL + "\t\t\tjavax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "\t\t\ttmf.init(ks);" + NL + "\t\t\treturn tmf.getTrustManagers();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t\tclass SSLSessionReuseFTPSClient_";
  protected final String TEXT_326 = " extends org.apache.commons.net.ftp.FTPSClient {" + NL + "" + NL + "\t\tpublic SSLSessionReuseFTPSClient_";
  protected final String TEXT_327 = "(boolean isImplicit, javax.net.ssl.SSLContext context) {" + NL + "\t\t\tsuper(isImplicit, context);" + NL + "\t\t}" + NL + "" + NL + "\t\t// changed to support TLS session resumption" + NL + "\t\t@Override" + NL + "\t\tprotected void _prepareDataSocket_(final java.net.Socket socket) throws IOException {" + NL + "\t\t\tif(socket instanceof javax.net.ssl.SSLSocket) {" + NL + "\t\t\t\tfinal javax.net.ssl.SSLSession session = ((javax.net.ssl.SSLSocket) _socket_).getSession();" + NL + "\t\t\t\tfinal javax.net.ssl.SSLSessionContext context = session.getSessionContext();" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tfinal java.lang.reflect.Field sessionHostPortCache = context.getClass().getDeclaredField(\"sessionHostPortCache\");" + NL + "\t\t\t\t\tsessionHostPortCache.setAccessible(true);" + NL + "\t\t\t\t\tfinal Object cache = sessionHostPortCache.get(context);" + NL + "\t\t\t\t\tfinal java.lang.reflect.Method putMethod = cache.getClass().getDeclaredMethod(\"put\", Object.class, Object.class);" + NL + "\t\t\t\t\tputMethod.setAccessible(true);" + NL + "\t\t\t\t\tfinal java.lang.reflect.Method getHostMethod = socket.getClass().getDeclaredMethod(\"getHost\");" + NL + "\t\t\t\t\tgetHostMethod.setAccessible(true);" + NL + "\t\t\t\t\tObject host = getHostMethod.invoke(socket);" + NL + "\t\t\t\t\tfinal String key = String.format(\"%s:%s\", host, String.valueOf(socket.getPort())).toLowerCase(java.util.Locale.ROOT);" + NL + "\t\t\t\t\tputMethod.invoke(cache, key, session);" + NL + "\t\t\t\t} catch(Exception e) {";
  protected final String TEXT_328 = NL + "\t\t\t\t\t\tlog.error(\"Can't adapt ftps client to support TLS session resumption\");";
  protected final String TEXT_329 = NL + "\t\t\t\t\tthrow new RuntimeException(e);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t\tjavax.net.ssl.SSLContext sslContext_";
  protected final String TEXT_330 = " = null;" + NL + "\t\tjavax.net.ssl.TrustManager[] trustManager_";
  protected final String TEXT_331 = " = null;" + NL + "\t\tjavax.net.ssl.SSLSocketFactory sslSocketFactory_";
  protected final String TEXT_332 = " = null;" + NL + "" + NL + "\t\tMyTrust_";
  protected final String TEXT_333 = " myTrust_";
  protected final String TEXT_334 = " = null;" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t\tsslContext_";
  protected final String TEXT_335 = " = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "\t\t\tmyTrust_";
  protected final String TEXT_336 = " = new MyTrust_";
  protected final String TEXT_337 = "();" + NL + "\t\t\ttrustManager_";
  protected final String TEXT_338 = " = myTrust_";
  protected final String TEXT_339 = ".getTrustManagers();" + NL + "\t\t\tsslContext_";
  protected final String TEXT_340 = ".init(null, trustManager_";
  protected final String TEXT_341 = ", new java.security.SecureRandom());" + NL + "\t\t\tsslSocketFactory_";
  protected final String TEXT_342 = " = sslContext_";
  protected final String TEXT_343 = ".getSocketFactory();" + NL + "\t\t\tftp_";
  protected final String TEXT_344 = " = new SSLSessionReuseFTPSClient_";
  protected final String TEXT_345 = "(";
  protected final String TEXT_346 = ", sslContext_";
  protected final String TEXT_347 = ");" + NL + "\t\t\tftp_";
  protected final String TEXT_348 = ".setControlEncoding(";
  protected final String TEXT_349 = ");" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_350 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_351 = " -FTPS security Mode is ";
  protected final String TEXT_352 = ".\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_353 = " - Attempt to connect to '\" + ";
  protected final String TEXT_354 = " + \"' with username '\" + ";
  protected final String TEXT_355 = "+ \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_356 = NL + "\t\t\tftp_";
  protected final String TEXT_357 = ".connect(";
  protected final String TEXT_358 = ",";
  protected final String TEXT_359 = ");" + NL + "\t\t\t";
  protected final String TEXT_360 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_361 = " - Connect to '\" + ";
  protected final String TEXT_362 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_363 = NL;
  protected final String TEXT_364 = NL + NL + "\t\t\t";
  protected final String TEXT_365 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_366 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_367 = ");";
  protected final String TEXT_368 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_369 = " = ";
  protected final String TEXT_370 = "; ";
  protected final String TEXT_371 = NL + NL + "\t\t\tboolean isLoginSuccessful_";
  protected final String TEXT_372 = " = ftp_";
  protected final String TEXT_373 = ".login(";
  protected final String TEXT_374 = ", decryptedPassword_";
  protected final String TEXT_375 = ");" + NL + "" + NL + "\t\t\tif (!isLoginSuccessful_";
  protected final String TEXT_376 = ") {" + NL + "\t\t\t\tthrow new RuntimeException(\"Login failed\");" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tftp_";
  protected final String TEXT_377 = ".setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);" + NL + "\t\t\tftp_";
  protected final String TEXT_378 = ".execPROT(";
  protected final String TEXT_379 = ");" + NL + "\t\t\tftp_";
  protected final String TEXT_380 = ".execPBSZ(";
  protected final String TEXT_381 = ");" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\t";
  protected final String TEXT_382 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_383 = " - Can't create connection: \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_384 = NL + "\t\t\t\tthrow e;";
  protected final String TEXT_385 = NL + "\t\t\t\te.printStackTrace();";
  protected final String TEXT_386 = NL + "\t\t}";
  protected final String TEXT_387 = NL + "\t\t\tftp_";
  protected final String TEXT_388 = ".enterLocalPassiveMode();";
  protected final String TEXT_389 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_390 = " - Using the passive mode.\");";
  protected final String TEXT_391 = NL + "\t\t";
  protected final String TEXT_392 = NL + "\t\tString rootDir_";
  protected final String TEXT_393 = " = null;" + NL + "\t\tftp_";
  protected final String TEXT_394 = " = (org.apache.commons.net.ftp.FTPSClient)globalMap.get(\"";
  protected final String TEXT_395 = "\");";
  protected final String TEXT_396 = NL + "\t\t\trootDir_";
  protected final String TEXT_397 = " = ftp_";
  protected final String TEXT_398 = ".printWorkingDirectory();";
  protected final String TEXT_399 = NL + "\t\t\tif(ftp_";
  protected final String TEXT_400 = "!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_401 = " - Use an existing connection.Connection hostname: \" + ftp_";
  protected final String TEXT_402 = ".getRemoteAddress().toString() + \", Connection port: \" + ftp_";
  protected final String TEXT_403 = ".getRemotePort() + \".\"); " + NL + "\t\t\t}";
  protected final String TEXT_404 = NL + "\t\tFTPSGetter_";
  protected final String TEXT_405 = " getter_";
  protected final String TEXT_406 = " = null;" + NL + "\t\tString remotedir_";
  protected final String TEXT_407 = " = null;" + NL + "\t\t" + NL + "\t\tgetter_";
  protected final String TEXT_408 = " = new FTPSGetter_";
  protected final String TEXT_409 = "();" + NL + "\t\tgetter_";
  protected final String TEXT_410 = ".ftpClient = ftp_";
  protected final String TEXT_411 = ";" + NL + "\t\tremotedir_";
  protected final String TEXT_412 = " = ";
  protected final String TEXT_413 = ";" + NL + "\t\tif (!\".\".equals(remotedir_";
  protected final String TEXT_414 = ")) {" + NL + "\t\t\tboolean cwdSuccess_";
  protected final String TEXT_415 = " = ftp_";
  protected final String TEXT_416 = ".changeWorkingDirectory(remotedir_";
  protected final String TEXT_417 = ");" + NL + "" + NL + "\t\t\tif (!cwdSuccess_";
  protected final String TEXT_418 = ") {" + NL + "\t\t\t\tthrow new RuntimeException(\"Failed to change remote directory. \" + ftp_";
  protected final String TEXT_419 = ".getReplyString());" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_420 = NL + "java.util.List<String> maskList_";
  protected final String TEXT_421 = " = new java.util.ArrayList<String>();" + NL;
  protected final String TEXT_422 = "    " + NL + "  maskList_";
  protected final String TEXT_423 = ".add(";
  protected final String TEXT_424 = ");       ";
  protected final String TEXT_425 = "  " + NL + "    ftp_";
  protected final String TEXT_426 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.BINARY);";
  protected final String TEXT_427 = "  " + NL + "    ftp_";
  protected final String TEXT_428 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.ASCII);";
  protected final String TEXT_429 = NL + "String localdir_";
  protected final String TEXT_430 = "  = ";
  protected final String TEXT_431 = ";  " + NL + "//create folder if local direcotry (assigned by property) not exists" + NL + "java.io.File dirHandle_";
  protected final String TEXT_432 = " = new java.io.File(localdir_";
  protected final String TEXT_433 = ");" + NL + "" + NL + "if (!dirHandle_";
  protected final String TEXT_434 = ".exists()) {" + NL + "  dirHandle_";
  protected final String TEXT_435 = ".mkdirs();" + NL + "}" + NL + "String root_";
  protected final String TEXT_436 = " = getter_";
  protected final String TEXT_437 = ".pwd();";
  protected final String TEXT_438 = NL + "if (\"/\".equals(root_";
  protected final String TEXT_439 = ")) {" + NL + "\troot_";
  protected final String TEXT_440 = " = \".\";" + NL + "}" + NL;
  protected final String TEXT_441 = NL + "\tlog.info(\"";
  protected final String TEXT_442 = " - Downloading files from the server.\");";
  protected final String TEXT_443 = NL + "for (String maskStr_";
  protected final String TEXT_444 = " : maskList_";
  protected final String TEXT_445 = ") { ";
  protected final String TEXT_446 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_29);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String ftpsPort = ElementParameterParser.getValue(node, "__FTPS_PORT__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");

boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
boolean use_encoding = "true".equals(ElementParameterParser.getValue(node, "__USE_ENCODING__"));

String overwrite = ElementParameterParser.getValue(node, "__OVERWRITE__");
String sftpoverwrite =ElementParameterParser.getValue(node, "__SFTPOVERWRITE__");
String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");  
String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String authMethod = ElementParameterParser.getValue(node,"__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node,"__PRIVATEKEY__");

List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");

String keystoreFile = ElementParameterParser.getValue(node,"__KEYSTORE_FILE__");

boolean append = "true".equals(ElementParameterParser.getValue(node, "__APPEND__"));
String connectMode = ElementParameterParser.getValue(node,"__CONNECT_MODE__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
boolean bPrintMsg = "true".equals(ElementParameterParser.getValue(node, "__PRINT_MESSAGE__"));
String securityMode = ElementParameterParser.getValue(node, "__SECURITY_MODE__");
boolean sftp = false;
boolean ftps = false;
String protectionLevel = ElementParameterParser.getValue(node, "__FTPS_PROT__");
String protectionBufferSize = ElementParameterParser.getValue(node, "__FTPS_PROTECTION_BUFF_SIZE__");

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String passwordFieldName = "";

if ("true".equals(useExistingConn)) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();

  for(INode n : nodeList) {
    if (n.getUniqueName().equals(connection)) {
      sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
      ftps = ("true").equals(ElementParameterParser.getValue(n, "__FTPS__"));
    }
  }
} else {
  sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
  ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__"));
}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.

if (useProxy){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_39);
    
passwordFieldName = "__PROXY_PASSWORD__";
if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_42);
    } else {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
} 

if (sftp) { // *** sftp *** //

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
		if ("false".equals(useExistingConn)) {
  
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    
                passwordFieldName = "__PASSPHRASE__";
                if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
                
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_55);
    } else {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
            	passwordFieldName = "__PASSWORD__";
            	
    stringBuffer.append(TEXT_63);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_66);
    } else {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    
		}
  
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
          				if (("overwrite").equals(sftpoverwrite)){
          
    stringBuffer.append(TEXT_79);
    
         				} else if (("append").equals(sftpoverwrite)){
          
    stringBuffer.append(TEXT_80);
    
          				} else if (("resume").equals(sftpoverwrite)){
          
    stringBuffer.append(TEXT_81);
    
          				}
          
    stringBuffer.append(TEXT_82);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    
			if ("true".equals(useExistingConn)){
				String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_94);
    if(isLog4jEnabled){
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
    }
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
			} else{
  
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    if ("PUBLICKEY".equals(authMethod)){
    stringBuffer.append(TEXT_110);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(privateKey);
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    if("PASSWORD".equals(authMethod)){
    stringBuffer.append(TEXT_126);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    }
    stringBuffer.append(TEXT_129);
    
                	passwordFieldName = "__PASSWORD__";
                	
    stringBuffer.append(TEXT_130);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_133);
    } else {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    if (!useProxy) {
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_152);
    }
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_160);
    }
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    if(use_encoding) {
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_166);
    }
    
			}
  
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    
} else if (!ftps) { // *** ftp *** //

    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    }
    stringBuffer.append(TEXT_190);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    if (append) {
    stringBuffer.append(TEXT_194);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    }
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_199);
    }
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    
		        } else if ("never".equals(overwrite)){
        
    stringBuffer.append(TEXT_202);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    }
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_207);
    }
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_210);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_211);
    }
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    
				} else if ("always".equals(overwrite)){
        
    stringBuffer.append(TEXT_215);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    }
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_220);
    }
    
				} else if ("size_differ".equals(overwrite)) {
        
    stringBuffer.append(TEXT_221);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_226);
    }
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_229);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_230);
    }
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    }
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_238);
    }
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    
		        }
        
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
      
	if ("true".equals(useExistingConn)){
    	String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_247);
    if(!moveToCurrentDir){
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    }
    stringBuffer.append(TEXT_251);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    }
    stringBuffer.append(TEXT_257);
    } else {
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_263);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_266);
    }
    	if (("ACTIVE").equals(connectMode)){
	    
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    
	    }else{
    
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    
    	}
    
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_273);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_277);
    }
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    
    	passwordFieldName = "__PASSWORD__";
    	
    stringBuffer.append(TEXT_280);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_283);
    } else {
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_286);
    }
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_293);
    }
    stringBuffer.append(TEXT_294);
    } 
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    
} else { // *** ftps *** //

    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    }
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_312);
    
	if ("false".equals(useExistingConn)){

    stringBuffer.append(TEXT_313);
     /* create connection */ 
    stringBuffer.append(TEXT_314);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    
			passwordFieldName = "__KEYSTORE_PASS__";
			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_319);
    
			} else {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_322);
    
			}

    stringBuffer.append(TEXT_323);
    stringBuffer.append(keystoreFile);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    
					if (isLog4jEnabled) {

    stringBuffer.append(TEXT_328);
    
					}

    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append("IMPLICIT".equals(securityMode));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_349);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(securityMode);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_355);
    }
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(ftpsPort );
    stringBuffer.append(TEXT_359);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_362);
    }
    stringBuffer.append(TEXT_363);
    
			passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_364);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_367);
    } else {
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_370);
    }
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(protectionLevel );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(protectionBufferSize );
    stringBuffer.append(TEXT_381);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    }
    
			if (dieOnError) {

    stringBuffer.append(TEXT_384);
    
			} else {

    stringBuffer.append(TEXT_385);
    
			}

    stringBuffer.append(TEXT_386);
    
		if ("PASSIVE".equals(connectMode)) {

    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    
			}
		}
	} else {
		String conn= "conn_" + connection;

    stringBuffer.append(TEXT_391);
     /* get connection from globalMap*/ 
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_395);
    
		if (!moveToCurrentDir) {

    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    
		}
		if(isLog4jEnabled) {

    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    
		}
	}

    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_419);
    
}
// *** share code *** //

    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_421);
    
for (int i = 0; i < files.size(); i++) {
  Map<String, String> line = files.get(i);

    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_424);
    
}

if (!sftp && !ftps) { // *** ftp *** //
  if ("binary".equalsIgnoreCase(ElementParameterParser.getValue(node, "__MODE__"))) {
  
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_426);
    
  }else {  
  
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_428);
    
  }
}

    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
     /*avoid sending CWD when remotedir is "."*/
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_440);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    }
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(TEXT_446);
    return stringBuffer.toString();
  }
}

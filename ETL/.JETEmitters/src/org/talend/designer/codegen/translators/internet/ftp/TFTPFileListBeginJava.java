package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TFTPFileListBeginJava
{
  protected static String nl;
  public static synchronized TFTPFileListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFileListBeginJava result = new TFTPFileListBeginJava();
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
  protected final String TEXT_30 = NL + "\tjava.util.List<String> maskList_";
  protected final String TEXT_31 = " = new java.util.ArrayList<String>();" + NL;
  protected final String TEXT_32 = NL + "\tmaskList_";
  protected final String TEXT_33 = ".add(\"*\");";
  protected final String TEXT_34 = " " + NL + "\t\tmaskList_";
  protected final String TEXT_35 = ".add(";
  protected final String TEXT_36 = "); ";
  protected final String TEXT_37 = NL + "\tjava.util.Properties props_";
  protected final String TEXT_38 = " = System.getProperties();" + NL + "\tprops_";
  protected final String TEXT_39 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_40 = ");" + NL + "\tprops_";
  protected final String TEXT_41 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_42 = ");" + NL + "\tprops_";
  protected final String TEXT_43 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_44 = ");" + NL + "\t";
  protected final String TEXT_45 = " " + NL + "\tString decryptedProxyPassword_";
  protected final String TEXT_46 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + " \tString decryptedProxyPassword_";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = "; ";
  protected final String TEXT_51 = NL + NL + "\tprops_";
  protected final String TEXT_52 = ".put(\"java.net.socks.password\", decryptedProxyPassword_";
  protected final String TEXT_53 = ");\t\t";
  protected final String TEXT_54 = NL + "\t\tclass MyUserInfo_";
  protected final String TEXT_55 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_56 = " " + NL + "\t\t\t\tString decryptedPassphrase_";
  protected final String TEXT_57 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_58 = ");" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\tString decryptedPassphrase_";
  protected final String TEXT_60 = " = ";
  protected final String TEXT_61 = "; " + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t" + NL + "\t\t\tString passphrase_";
  protected final String TEXT_63 = " = decryptedPassphrase_";
  protected final String TEXT_64 = ";" + NL + "" + NL + "\t\t\tpublic String getPassphrase() { return passphrase_";
  protected final String TEXT_65 = "; }" + NL + "" + NL + "\t\t\tpublic String getPassword() { return null; } " + NL + "" + NL + "\t\t\tpublic boolean promptPassword(String arg0) { return true; } " + NL + "" + NL + "\t\t\tpublic boolean promptPassphrase(String arg0) { return true; } " + NL + "" + NL + "\t\t\tpublic boolean promptYesNo(String arg0) { return true; } " + NL + "" + NL + "\t\t\tpublic void showMessage(String arg0) { } " + NL + "" + NL + "\t\t\tpublic String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "\t\t\tboolean[] echo) {" + NL + "\t\t\t";
  protected final String TEXT_66 = " " + NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_67 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_68 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = "; ";
  protected final String TEXT_73 = NL + "\t\t\t" + NL + "\t\t\t\tString[] password_";
  protected final String TEXT_74 = " = {decryptedPassword_";
  protected final String TEXT_75 = "};" + NL + "\t\t\t\treturn password_";
  protected final String TEXT_76 = ";" + NL + "\t\t\t}" + NL + "\t\t}; " + NL + "\t\tfinal com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_77 = " = new MyUserInfo_";
  protected final String TEXT_78 = "();" + NL + "\t\tcom.jcraft.jsch.JSch jsch_";
  protected final String TEXT_79 = "=new com.jcraft.jsch.JSch(); " + NL + "" + NL + "\t\t";
  protected final String TEXT_80 = NL + "\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_82 = " - SFTP authentication using a public key.\");" + NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_83 = " - Private key: '\" + ";
  protected final String TEXT_84 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\tjsch_";
  protected final String TEXT_86 = ".addIdentity(";
  protected final String TEXT_87 = ", defaultUserInfo_";
  protected final String TEXT_88 = ".getPassphrase());" + NL + "\t\t";
  protected final String TEXT_89 = NL + "\t\t" + NL + "\t\tcom.jcraft.jsch.Session session_";
  protected final String TEXT_90 = "=jsch_";
  protected final String TEXT_91 = ".getSession(";
  protected final String TEXT_92 = ", ";
  protected final String TEXT_93 = ", ";
  protected final String TEXT_94 = ");" + NL + "\t\tsession_";
  protected final String TEXT_95 = ".setConfig(\"PreferredAuthentications\", \"publickey,password,keyboard-interactive,gssapi-with-mic\");" + NL + "" + NL + "\t\t";
  protected final String TEXT_96 = NL + "\t\t\t";
  protected final String TEXT_97 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_98 = " - SFTP authentication using a password.\");" + NL + "\t\t\t";
  protected final String TEXT_99 = " " + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_100 = " " + NL + "" + NL + "\t\t\t";
  protected final String TEXT_101 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_102 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_103 = ");";
  protected final String TEXT_104 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = "; ";
  protected final String TEXT_107 = NL + NL + "\t\t\tsession_";
  protected final String TEXT_108 = ".setPassword(decryptedPassword_";
  protected final String TEXT_109 = "); " + NL + "\t\t";
  protected final String TEXT_110 = NL + "\t\tsession_";
  protected final String TEXT_111 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_112 = "); " + NL + "\t\t";
  protected final String TEXT_113 = NL + "\t\tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "\t\t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_114 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "\t\t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "\t\t\t\tproxy_";
  protected final String TEXT_115 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "\t\t\t}" + NL + "\t\t\tsession_";
  protected final String TEXT_116 = ".setProxy(proxy_";
  protected final String TEXT_117 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_118 = NL + "\t\t";
  protected final String TEXT_119 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_120 = " - Attempt to connect to '\" + ";
  protected final String TEXT_121 = " + \"' with username '\" + ";
  protected final String TEXT_122 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_123 = NL + "\t\tsession_";
  protected final String TEXT_124 = ".connect();" + NL + "\t\tcom.jcraft.jsch. Channel channel_";
  protected final String TEXT_125 = "=session_";
  protected final String TEXT_126 = ".openChannel(\"sftp\");" + NL + "\t\tchannel_";
  protected final String TEXT_127 = ".connect();" + NL + "\t\t";
  protected final String TEXT_128 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_129 = " - Connect to '\" + ";
  protected final String TEXT_130 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_131 = NL + "\t\tcom.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_132 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_133 = ";" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_134 = NL + "\t\t\tc_";
  protected final String TEXT_135 = ".setFilenameEncoding(";
  protected final String TEXT_136 = ");" + NL + "\t\t";
  protected final String TEXT_137 = NL;
  protected final String TEXT_138 = "\t" + NL + "\t\tcom.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_139 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_140 = "\");" + NL + "\t\t";
  protected final String TEXT_141 = NL + "\t\t\tif(c_";
  protected final String TEXT_142 = "!=null && c_";
  protected final String TEXT_143 = ".getSession()!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_144 = " - Use an existing connection. Connection username: \" + c_";
  protected final String TEXT_145 = ".getSession().getUserName() + \", Connection hostname: \" + c_";
  protected final String TEXT_146 = ".getSession().getHost() + \", Connection port: \" + c_";
  protected final String TEXT_147 = ".getSession().getPort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_148 = NL + "\t\tif(c_";
  protected final String TEXT_149 = ".getHome()!=null && !c_";
  protected final String TEXT_150 = ".getHome().equals(c_";
  protected final String TEXT_151 = ".pwd())){" + NL + "\t  \t\tc_";
  protected final String TEXT_152 = ".cd(c_";
  protected final String TEXT_153 = ".getHome());" + NL + "\t  \t}";
  protected final String TEXT_154 = NL + "\tString remotedir_";
  protected final String TEXT_155 = " = ";
  protected final String TEXT_156 = ".replaceAll(\"\\\\\\\\\", \"/\");" + NL + "\tjava.util.Vector<com.jcraft.jsch.ChannelSftp.LsEntry> vector_";
  protected final String TEXT_157 = " = c_";
  protected final String TEXT_158 = ".ls(remotedir_";
  protected final String TEXT_159 = ");" + NL + "\tcom.jcraft.jsch.ChannelSftp.LsEntry[] sftpFiles_";
  protected final String TEXT_160 = " = vector_";
  protected final String TEXT_161 = ".toArray(new com.jcraft.jsch.ChannelSftp.LsEntry[0]);" + NL + "\tint nb_file_";
  protected final String TEXT_162 = " = 0;  " + NL + "\tList<String> fileListTemp_";
  protected final String TEXT_163 = " = new java.util.ArrayList<String>();" + NL + "" + NL + "\tfor (String filemask_";
  protected final String TEXT_164 = " : maskList_";
  protected final String TEXT_165 = ") {" + NL + "\t\tjava.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_166 = " = java.util.regex.Pattern.compile(filemask_";
  protected final String TEXT_167 = ".replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\"));" + NL + "\t" + NL + "\t\tfor (com.jcraft.jsch.ChannelSftp.LsEntry filemaskTemp_";
  protected final String TEXT_168 = " : sftpFiles_";
  protected final String TEXT_169 = ") {" + NL + "\t\t\tif (fileNamePattern_";
  protected final String TEXT_170 = ".matcher(filemaskTemp_";
  protected final String TEXT_171 = ".getFilename()).matches()) {" + NL + "\t\t\t\tfileListTemp_";
  protected final String TEXT_172 = ".add(filemaskTemp_";
  protected final String TEXT_173 = ".getFilename());" + NL + "\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t";
  protected final String TEXT_174 = NL + "\t\tlog.info(\"";
  protected final String TEXT_175 = " - Listing files from server.\");" + NL + "\t";
  protected final String TEXT_176 = NL + "\tfor (String sftpFile_";
  protected final String TEXT_177 = " : fileListTemp_";
  protected final String TEXT_178 = ") {" + NL + "" + NL + "\tif ((\".\").equals(sftpFile_";
  protected final String TEXT_179 = ") || (\"..\").equals(sftpFile_";
  protected final String TEXT_180 = ")) {" + NL + "\t  continue;" + NL + "\t}" + NL + "\tString currentFileName_";
  protected final String TEXT_181 = " = sftpFile_";
  protected final String TEXT_182 = "; " + NL + "\tString currentFilePath_";
  protected final String TEXT_183 = " = remotedir_";
  protected final String TEXT_184 = ";" + NL + "\tif(!remotedir_";
  protected final String TEXT_185 = ".endsWith(\"/\")&&!remotedir_";
  protected final String TEXT_186 = ".endsWith(\"\\\\\")){" + NL + "\t\tcurrentFilePath_";
  protected final String TEXT_187 = " += \"/\";" + NL + "\t}" + NL + "\tcurrentFilePath_";
  protected final String TEXT_188 = " += sftpFile_";
  protected final String TEXT_189 = ";" + NL + "\t";
  protected final String TEXT_190 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_191 = " - List file : '\" + currentFilePath_";
  protected final String TEXT_192 = " + \"' .\");" + NL + "\t";
  protected final String TEXT_193 = " " + NL + "\tglobalMap.put(\"";
  protected final String TEXT_194 = "_CURRENT_FILE\", currentFileName_";
  protected final String TEXT_195 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_196 = "_CURRENT_FILEPATH\", currentFilePath_";
  protected final String TEXT_197 = ");" + NL + "\tnb_file_";
  protected final String TEXT_198 = "++;" + NL;
  protected final String TEXT_199 = NL + "\t\t";
  protected final String TEXT_200 = NL + NL + "\tclass MyTrust_";
  protected final String TEXT_201 = " {" + NL + "" + NL + "\t\tprivate javax.net.ssl.TrustManager[] getTrustManagers() " + NL + "\t\tthrows java.security.KeyStoreException, java.security.NoSuchAlgorithmException, " + NL + "\t\t\tjava.security.cert.CertificateException, java.security.UnrecoverableKeyException," + NL + "\t\t\tjava.io.IOException {" + NL + "\t\t\tjava.security.KeyStore ks = java.security.KeyStore.getInstance(\"JKS\");" + NL;
  protected final String TEXT_202 = " " + NL + "\t\t\t\tString decryptedKeyStorePassword_";
  protected final String TEXT_203 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_204 = ");";
  protected final String TEXT_205 = NL + "\t\t\t\tString decryptedKeyStorePassword_";
  protected final String TEXT_206 = " = ";
  protected final String TEXT_207 = "; ";
  protected final String TEXT_208 = NL + "\t\t\tks.load(new java.io.FileInputStream(";
  protected final String TEXT_209 = "), decryptedKeyStorePassword_";
  protected final String TEXT_210 = ".toCharArray());" + NL + "\t\t\tjavax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "\t\t\ttmf.init(ks);" + NL + "\t\t\treturn tmf.getTrustManagers();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t\tclass SSLSessionReuseFTPSClient_";
  protected final String TEXT_211 = " extends org.apache.commons.net.ftp.FTPSClient {" + NL + "" + NL + "\t\tpublic SSLSessionReuseFTPSClient_";
  protected final String TEXT_212 = "(boolean isImplicit, javax.net.ssl.SSLContext context) {" + NL + "\t\t\tsuper(isImplicit, context);" + NL + "\t\t}" + NL + "" + NL + "\t\t// changed to support TLS session resumption" + NL + "\t\t@Override" + NL + "\t\tprotected void _prepareDataSocket_(final java.net.Socket socket) throws IOException {" + NL + "\t\t\tif(socket instanceof javax.net.ssl.SSLSocket) {" + NL + "\t\t\t\tfinal javax.net.ssl.SSLSession session = ((javax.net.ssl.SSLSocket) _socket_).getSession();" + NL + "\t\t\t\tfinal javax.net.ssl.SSLSessionContext context = session.getSessionContext();" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tfinal java.lang.reflect.Field sessionHostPortCache = context.getClass().getDeclaredField(\"sessionHostPortCache\");" + NL + "\t\t\t\t\tsessionHostPortCache.setAccessible(true);" + NL + "\t\t\t\t\tfinal Object cache = sessionHostPortCache.get(context);" + NL + "\t\t\t\t\tfinal java.lang.reflect.Method putMethod = cache.getClass().getDeclaredMethod(\"put\", Object.class, Object.class);" + NL + "\t\t\t\t\tputMethod.setAccessible(true);" + NL + "\t\t\t\t\tfinal java.lang.reflect.Method getHostMethod = socket.getClass().getDeclaredMethod(\"getHost\");" + NL + "\t\t\t\t\tgetHostMethod.setAccessible(true);" + NL + "\t\t\t\t\tObject host = getHostMethod.invoke(socket);" + NL + "\t\t\t\t\tfinal String key = String.format(\"%s:%s\", host, String.valueOf(socket.getPort())).toLowerCase(java.util.Locale.ROOT);" + NL + "\t\t\t\t\tputMethod.invoke(cache, key, session);" + NL + "\t\t\t\t} catch(Exception e) {";
  protected final String TEXT_213 = NL + "\t\t\t\t\t\tlog.error(\"Can't adapt ftps client to support TLS session resumption\");";
  protected final String TEXT_214 = NL + "\t\t\t\t\tthrow new RuntimeException(e);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t\tjavax.net.ssl.SSLContext sslContext_";
  protected final String TEXT_215 = " = null;" + NL + "\t\tjavax.net.ssl.TrustManager[] trustManager_";
  protected final String TEXT_216 = " = null;" + NL + "\t\tjavax.net.ssl.SSLSocketFactory sslSocketFactory_";
  protected final String TEXT_217 = " = null;" + NL + "\t\torg.apache.commons.net.ftp.FTPSClient ftp_";
  protected final String TEXT_218 = " =null;" + NL + "\t\tMyTrust_";
  protected final String TEXT_219 = " myTrust_";
  protected final String TEXT_220 = " = null;" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tsslContext_";
  protected final String TEXT_221 = " = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "\t\t\tmyTrust_";
  protected final String TEXT_222 = " = new MyTrust_";
  protected final String TEXT_223 = "();" + NL + "\t\t\ttrustManager_";
  protected final String TEXT_224 = " = myTrust_";
  protected final String TEXT_225 = ".getTrustManagers();" + NL + "\t\t\tsslContext_";
  protected final String TEXT_226 = ".init(null, trustManager_";
  protected final String TEXT_227 = ", new java.security.SecureRandom());" + NL + "\t\t\tsslSocketFactory_";
  protected final String TEXT_228 = " = sslContext_";
  protected final String TEXT_229 = ".getSocketFactory();" + NL + "\t\t\tftp_";
  protected final String TEXT_230 = " = new SSLSessionReuseFTPSClient_";
  protected final String TEXT_231 = "(";
  protected final String TEXT_232 = ", sslContext_";
  protected final String TEXT_233 = ");" + NL + "\t\t\tftp_";
  protected final String TEXT_234 = ".setControlEncoding(";
  protected final String TEXT_235 = ");" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_236 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_237 = " -FTPS security Mode is ";
  protected final String TEXT_238 = ".\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_239 = " - Attempt to connect to '\" + ";
  protected final String TEXT_240 = " + \"' with username '\" + ";
  protected final String TEXT_241 = "+ \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_242 = NL + "\t\t\tftp_";
  protected final String TEXT_243 = ".connect(";
  protected final String TEXT_244 = ",";
  protected final String TEXT_245 = ");";
  protected final String TEXT_246 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_247 = " - Connect to '\" + ";
  protected final String TEXT_248 = " + \"' has succeeded.\");";
  protected final String TEXT_249 = NL + NL + "\t\t\t";
  protected final String TEXT_250 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_251 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_252 = ");";
  protected final String TEXT_253 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_254 = " = ";
  protected final String TEXT_255 = "; ";
  protected final String TEXT_256 = NL + NL + "\t\t\tboolean isLoginSuccessful_";
  protected final String TEXT_257 = " = ftp_";
  protected final String TEXT_258 = ".login(";
  protected final String TEXT_259 = ", decryptedPassword_";
  protected final String TEXT_260 = ");" + NL + "" + NL + "\t\t\tif (!isLoginSuccessful_";
  protected final String TEXT_261 = ") {" + NL + "\t\t\t\tthrow new RuntimeException(\"Login failed\");" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tftp_";
  protected final String TEXT_262 = ".execPROT(";
  protected final String TEXT_263 = ");" + NL + "\t\t\tftp_";
  protected final String TEXT_264 = ".execPBSZ(";
  protected final String TEXT_265 = ");" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\t";
  protected final String TEXT_266 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_267 = " - Can't create connection: \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_268 = NL + "\t\t\tthrow e;" + NL + "\t\t}";
  protected final String TEXT_269 = NL + "\t\t\tftp_";
  protected final String TEXT_270 = ".enterLocalPassiveMode();";
  protected final String TEXT_271 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_272 = " - Using the passive mode.\");";
  protected final String TEXT_273 = NL + "\t\torg.apache.commons.net.ftp.FTPSClient ftp_";
  protected final String TEXT_274 = " = (org.apache.commons.net.ftp.FTPSClient) globalMap.get(\"";
  protected final String TEXT_275 = "\");" + NL + "\t\tString rootDir_";
  protected final String TEXT_276 = " = ftp_";
  protected final String TEXT_277 = ".printWorkingDirectory();";
  protected final String TEXT_278 = NL + "\tint nb_file_";
  protected final String TEXT_279 = " = 0;" + NL + "\torg.apache.commons.net.ftp.FTPFile[] ftpFiles_";
  protected final String TEXT_280 = " = null;" + NL + "\tList<org.apache.commons.net.ftp.FTPFile> fileListTemp_";
  protected final String TEXT_281 = " = new java.util.ArrayList<>();" + NL + "" + NL + "\t";
  protected final String TEXT_282 = NL + "\tString remotedir_";
  protected final String TEXT_283 = " = (";
  protected final String TEXT_284 = ").replaceAll(\"\\\\\\\\\",\"/\");" + NL + "\tboolean cwdSuccess_";
  protected final String TEXT_285 = " = ftp_";
  protected final String TEXT_286 = ".changeWorkingDirectory(remotedir_";
  protected final String TEXT_287 = ");" + NL + "" + NL + "\tif (!cwdSuccess_";
  protected final String TEXT_288 = ") {" + NL + "\t\tthrow new RuntimeException(\"Failed to change remote directory. \" + ftp_";
  protected final String TEXT_289 = ".getReplyString());" + NL + "\t}" + NL + "" + NL + "\tftpFiles_";
  protected final String TEXT_290 = " = ftp_";
  protected final String TEXT_291 = ".listFiles();";
  protected final String TEXT_292 = NL + "\t";
  protected final String TEXT_293 = NL + "\tftp_";
  protected final String TEXT_294 = ".changeWorkingDirectory(rootDir_";
  protected final String TEXT_295 = ");";
  protected final String TEXT_296 = NL + "\t";
  protected final String TEXT_297 = NL + "\tfor (String filemask_";
  protected final String TEXT_298 = " : maskList_";
  protected final String TEXT_299 = ") {" + NL + "\t\tjava.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_300 = " = java.util.regex.Pattern.compile(filemask_";
  protected final String TEXT_301 = ".replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\"));" + NL + "\t" + NL + "\t\tfor (org.apache.commons.net.ftp.FTPFile ftpFile_";
  protected final String TEXT_302 = " : ftpFiles_";
  protected final String TEXT_303 = ") {" + NL + "\t\t\tif (fileNamePattern_";
  protected final String TEXT_304 = ".matcher(ftpFile_";
  protected final String TEXT_305 = ".getName()).matches()) {" + NL + "\t\t\t\tfileListTemp_";
  protected final String TEXT_306 = ".add(ftpFile_";
  protected final String TEXT_307 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\tString currentFilePath_";
  protected final String TEXT_308 = " = remotedir_";
  protected final String TEXT_309 = ";" + NL + "\tif(!remotedir_";
  protected final String TEXT_310 = ".endsWith(\"/\")&&!remotedir_";
  protected final String TEXT_311 = ".endsWith(\"\\\\\")){" + NL + "\t\tcurrentFilePath_";
  protected final String TEXT_312 = " += \"/\";" + NL + "\t}" + NL + "" + NL + "\tfor (int i = 0; i < fileListTemp_";
  protected final String TEXT_313 = ".size(); i++) {" + NL + "\t\torg.apache.commons.net.ftp.FTPFile ftpFile_";
  protected final String TEXT_314 = " = fileListTemp_";
  protected final String TEXT_315 = ".get(i);" + NL + "\t\tString currentFileName_";
  protected final String TEXT_316 = " = null;";
  protected final String TEXT_317 = NL + "\t\t\tcurrentFileName_";
  protected final String TEXT_318 = " = ftpFile_";
  protected final String TEXT_319 = ".toString();";
  protected final String TEXT_320 = NL + "\t\t\tcurrentFileName_";
  protected final String TEXT_321 = " = ftpFile_";
  protected final String TEXT_322 = ".getName();";
  protected final String TEXT_323 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_324 = " - List file : '\" + currentFilePath_";
  protected final String TEXT_325 = " + \"' .\");";
  protected final String TEXT_326 = " " + NL + "\t\t";
  protected final String TEXT_327 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_328 = "_CURRENT_FILE\", currentFileName_";
  protected final String TEXT_329 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_330 = "_CURRENT_FILEPATH\", currentFilePath_";
  protected final String TEXT_331 = " + currentFileName_";
  protected final String TEXT_332 = ");" + NL + "\t\tnb_file_";
  protected final String TEXT_333 = "++;";
  protected final String TEXT_334 = NL + "\tint nb_file_";
  protected final String TEXT_335 = " = 0;" + NL + "\tcom.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_336 = " =null;" + NL + "" + NL + "\t";
  protected final String TEXT_337 = NL + "\t\tftp_";
  protected final String TEXT_338 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_339 = "\");" + NL + "\t\t";
  protected final String TEXT_340 = NL + "\t\t\tif(ftp_";
  protected final String TEXT_341 = "!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_342 = " - Use an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_343 = ".getRemoteHost() + \", Connection port: \" + ftp_";
  protected final String TEXT_344 = ".getRemotePort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_345 = NL + "\t\t";
  protected final String TEXT_346 = NL + "\t\t\tString rootDir_";
  protected final String TEXT_347 = " = ftp_";
  protected final String TEXT_348 = ".pwd();" + NL + "\t\t";
  protected final String TEXT_349 = NL + "\t";
  protected final String TEXT_350 = "\t" + NL + "\t\tftp_";
  protected final String TEXT_351 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "\t\tftp_";
  protected final String TEXT_352 = ".setRemoteHost(";
  protected final String TEXT_353 = ");" + NL + "\t\tftp_";
  protected final String TEXT_354 = ".setRemotePort(";
  protected final String TEXT_355 = ");" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_356 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_357 = " - \" + ";
  protected final String TEXT_358 = ");" + NL + "\t\t";
  protected final String TEXT_359 = NL + "\t\t";
  protected final String TEXT_360 = NL + "\t\t  ftp_";
  protected final String TEXT_361 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);" + NL + "\t\t";
  protected final String TEXT_362 = NL + "\t\t  ftp_";
  protected final String TEXT_363 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);" + NL + "\t\t";
  protected final String TEXT_364 = NL + "\t\t";
  protected final String TEXT_365 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_366 = " - Attempt to connect to '\" + ";
  protected final String TEXT_367 = " + \"' with username '\" +";
  protected final String TEXT_368 = "+ \"'.\");" + NL + "\t\t";
  protected final String TEXT_369 = NL + "\t\tftp_";
  protected final String TEXT_370 = ".setControlEncoding(";
  protected final String TEXT_371 = ");" + NL + "\t\tftp_";
  protected final String TEXT_372 = ".connect();  " + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_373 = " " + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_374 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_375 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_376 = ");";
  protected final String TEXT_377 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_378 = " = ";
  protected final String TEXT_379 = "; ";
  protected final String TEXT_380 = NL + "\t\t" + NL + "\t\tftp_";
  protected final String TEXT_381 = ".login(";
  protected final String TEXT_382 = ", decryptedPassword_";
  protected final String TEXT_383 = "); " + NL + "\t\t";
  protected final String TEXT_384 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_385 = " - Connect to '\" + ";
  protected final String TEXT_386 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_387 = NL + "\t";
  protected final String TEXT_388 = NL + "\tString remotedir_";
  protected final String TEXT_389 = " = (";
  protected final String TEXT_390 = ").replaceAll(\"\\\\\\\\\",\"/\");" + NL + "\tftp_";
  protected final String TEXT_391 = ".chdir(remotedir_";
  protected final String TEXT_392 = ");" + NL + "\tString[] fileList_";
  protected final String TEXT_393 = ";" + NL + "" + NL + "\tif (";
  protected final String TEXT_394 = ") {" + NL + "\t\tfileList_";
  protected final String TEXT_395 = " = ftp_";
  protected final String TEXT_396 = ".dir(null, true);" + NL + "\t} else {" + NL + "\t\tfileList_";
  protected final String TEXT_397 = " = ftp_";
  protected final String TEXT_398 = ".dir(null, false);" + NL + "\t}";
  protected final String TEXT_399 = NL + "\t\t\tftp_";
  protected final String TEXT_400 = ".chdir(rootDir_";
  protected final String TEXT_401 = ");";
  protected final String TEXT_402 = NL + "\tList<String> fileListTemp_";
  protected final String TEXT_403 = " = new java.util.ArrayList<String>();" + NL + "" + NL + "\tfor (String filemask_";
  protected final String TEXT_404 = " : maskList_";
  protected final String TEXT_405 = ") {" + NL + "\t\tjava.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_406 = " = java.util.regex.Pattern.compile(filemask_";
  protected final String TEXT_407 = ".replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\"));" + NL + "\t" + NL + "\t\tfor (String filemaskTemp_";
  protected final String TEXT_408 = " : fileList_";
  protected final String TEXT_409 = ") {" + NL + "\t\t\tif (fileNamePattern_";
  protected final String TEXT_410 = ".matcher(filemaskTemp_";
  protected final String TEXT_411 = ").matches()) {" + NL + "\t\t\t\tfileListTemp_";
  protected final String TEXT_412 = ".add(filemaskTemp_";
  protected final String TEXT_413 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\tint i_";
  protected final String TEXT_414 = " = -1;" + NL + "" + NL + "\t";
  protected final String TEXT_415 = NL + "\t\tlog.info(\"";
  protected final String TEXT_416 = " - Listing files from server.\");" + NL + "\t";
  protected final String TEXT_417 = " " + NL + "\twhile (++i_";
  protected final String TEXT_418 = " < fileListTemp_";
  protected final String TEXT_419 = ".size()) {" + NL + "\t\tString currentFileName_";
  protected final String TEXT_420 = " = fileListTemp_";
  protected final String TEXT_421 = ".get(i_";
  protected final String TEXT_422 = "); " + NL + "\t\tString currentFilePath_";
  protected final String TEXT_423 = " = remotedir_";
  protected final String TEXT_424 = ";" + NL + "\t\tif(!remotedir_";
  protected final String TEXT_425 = ".endsWith(\"/\")&&!remotedir_";
  protected final String TEXT_426 = ".endsWith(\"\\\\\")){" + NL + "\t\t\tcurrentFilePath_";
  protected final String TEXT_427 = " += \"/\";" + NL + "\t\t}" + NL + "\t\tcurrentFilePath_";
  protected final String TEXT_428 = " += fileListTemp_";
  protected final String TEXT_429 = ".get(i_";
  protected final String TEXT_430 = ");" + NL + "\t\t";
  protected final String TEXT_431 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_432 = " - List file : '\" + currentFilePath_";
  protected final String TEXT_433 = " + \"' .\");" + NL + "\t\t";
  protected final String TEXT_434 = " " + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_435 = "_CURRENT_FILE\", currentFileName_";
  protected final String TEXT_436 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_437 = "_CURRENT_FILEPATH\", currentFilePath_";
  protected final String TEXT_438 = ");" + NL + "\t\tnb_file_";
  protected final String TEXT_439 = "++;";
  protected final String TEXT_440 = NL;

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
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String ftpsPort = ElementParameterParser.getValue(node, "__FTPS_PORT__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");

boolean use_encoding = "true".equals(ElementParameterParser.getValue(node, "__USE_ENCODING__"));

String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
boolean dirFull = ("true").equals(ElementParameterParser.getValue(node, "__DIR_FULL__"));
String cid = node.getUniqueName();
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");

boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");

String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");  
List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String conn= "conn_" + connection;
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
boolean sftp = false;
boolean ftps = false;
String protectionLevel = ElementParameterParser.getValue(node, "__FTPS_PROT__");
String protectionBufferSize = ElementParameterParser.getValue(node, "__FTPS_PROTECTION_BUFF_SIZE__");

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
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String passwordFieldName = "";


    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
if (files.size() == 0) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
} else {
  for (int i = 0; i < files.size(); i++) {
	Map<String, String> line = files.get(i);
	
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_36);
    
  }
}

//The following part support the socks proxy for FTP, FTPS and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.
if (useProxy) {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_44);
    
passwordFieldName = "__PROXY_PASSWORD__";
if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_47);
    } else {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
}

if (sftp) {// *** sftp *** //

	if (("false").equals(useExistingConn)) {
	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
			passwordFieldName = "__PASSPHRASE__";
			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
			
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_58);
    } else {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    
			passwordFieldName = "__PASSWORD__";
			
    stringBuffer.append(TEXT_66);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_69);
    } else {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_72);
    }
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
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_80);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(privateKey);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_96);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    }
    stringBuffer.append(TEXT_99);
    
			passwordFieldName = "__PASSWORD__";
			
    stringBuffer.append(TEXT_100);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_103);
    } else {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_106);
    }
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
    if (!useProxy) {
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_122);
    }
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    if(use_encoding) {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    
	} else {
  
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_140);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
	}
  
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
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
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    }
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    
} else if (ftps) { // *** ftps *** //
	if (("false").equals(useExistingConn)) {
		String keystoreFile = ElementParameterParser.getValue(node, "__KEYSTORE_FILE__");
		String securityMode = ElementParameterParser.getValue(node, "__SECURITY_MODE__");

    stringBuffer.append(TEXT_199);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    
			passwordFieldName = "__KEYSTORE_PASS__";
			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_204);
    
			} else {

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_207);
    
			}

    stringBuffer.append(TEXT_208);
    stringBuffer.append(keystoreFile);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    
					if (isLog4jEnabled) {

    stringBuffer.append(TEXT_213);
    
					}

    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append("IMPLICIT".equals(securityMode));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_235);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(securityMode);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_241);
    }
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(ftpsPort );
    stringBuffer.append(TEXT_245);
    
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_248);
    
			}

			passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_249);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_252);
    } else {
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_255);
    }
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(protectionLevel );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(protectionBufferSize );
    stringBuffer.append(TEXT_265);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    }
    stringBuffer.append(TEXT_268);
    
		if ("PASSIVE".equals(connectMode)) {

    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    
			}
		}
	} else {

    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    
	}

    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    /*read files*/ 
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    
	if ("true".equals(useExistingConn) && !moveToCurrentDir) {

    stringBuffer.append(TEXT_292);
    /*return to previous dir */
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    
	}

    stringBuffer.append(TEXT_296);
    /*prepare masks*/ 
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    
		if (dirFull) {

    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    
		} else {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    
		}

		if(isLog4jEnabled) {

    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    
		}

    stringBuffer.append(TEXT_326);
    /*set to globalMap*/ 
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    
} else { // *** ftp *** //

    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    if (("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_339);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    }
    stringBuffer.append(TEXT_345);
    if(!moveToCurrentDir){
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    }
    stringBuffer.append(TEXT_349);
    } else {
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_355);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_358);
    }
    stringBuffer.append(TEXT_359);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    } else {
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    }
    stringBuffer.append(TEXT_364);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_368);
    }
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    
		passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_373);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_376);
    } else {
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_379);
    }
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_386);
    }
    stringBuffer.append(TEXT_387);
    }
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(dirFull );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    
	if (("true").equals(useExistingConn)) {
		if(!moveToCurrentDir){

    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    	
		}
	}

    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_414);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    }
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    }
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    }
    stringBuffer.append(TEXT_440);
    return stringBuffer.toString();
  }
}

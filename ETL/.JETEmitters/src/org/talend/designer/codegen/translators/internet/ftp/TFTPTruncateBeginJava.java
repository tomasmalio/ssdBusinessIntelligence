package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TFTPTruncateBeginJava
{
  protected static String nl;
  public static synchronized TFTPTruncateBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPTruncateBeginJava result = new TFTPTruncateBeginJava();
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
  protected final String TEXT_30 = NL + "\tjava.util.Properties props_";
  protected final String TEXT_31 = " = System.getProperties();" + NL + "\tprops_";
  protected final String TEXT_32 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_33 = ");" + NL + "\tprops_";
  protected final String TEXT_34 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_35 = ");" + NL + "\tprops_";
  protected final String TEXT_36 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_37 = ");" + NL + "\t";
  protected final String TEXT_38 = " " + NL + "  String decryptedProxyPassword_";
  protected final String TEXT_39 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "  String decryptedProxyPassword_";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = "; ";
  protected final String TEXT_44 = NL + "\t" + NL + "\tprops_";
  protected final String TEXT_45 = ".put(\"java.net.socks.password\", decryptedProxyPassword_";
  protected final String TEXT_46 = ");        ";
  protected final String TEXT_47 = NL + "\tint nb_file_";
  protected final String TEXT_48 = " = 0;" + NL;
  protected final String TEXT_49 = NL + "\t\tclass MyUserInfo_";
  protected final String TEXT_50 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_51 = " " + NL + "          \t\tString decryptedPassphrase_";
  protected final String TEXT_52 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "          \t\tString decryptedPassphrase_";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = "; ";
  protected final String TEXT_57 = NL + "\t\t" + NL + "\t\t\tString passphrase_";
  protected final String TEXT_58 = " = decryptedPassphrase_";
  protected final String TEXT_59 = ";" + NL + "\t\t\tpublic String getPassphrase() { return passphrase_";
  protected final String TEXT_60 = "; }" + NL + "" + NL + "\t\t\tpublic String getPassword() { return null; } " + NL + "\t\t\tpublic boolean promptPassword(String arg0) { return true; } " + NL + "\t\t\tpublic boolean promptPassphrase(String arg0) { return true; } " + NL + "\t\t\tpublic boolean promptYesNo(String arg0) { return true; } " + NL + "\t\t\tpublic void showMessage(String arg0) { } " + NL + "" + NL + "\t\t\tpublic String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "\t\t\t\tboolean[] echo) {" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_61 = " " + NL + "    \t" + NL + "\t\t\t";
  protected final String TEXT_62 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_63 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = "; ";
  protected final String TEXT_68 = NL + "\t\t\t" + NL + "\t\t\t\tString[] password_";
  protected final String TEXT_69 = " = {decryptedPassword_";
  protected final String TEXT_70 = "};" + NL + "\t\t\t\treturn password_";
  protected final String TEXT_71 = ";" + NL + "\t\t\t}" + NL + "\t\t}; " + NL + "\t\tfinal com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_72 = " = new MyUserInfo_";
  protected final String TEXT_73 = "();" + NL + "\t\tcom.jcraft.jsch.JSch jsch_";
  protected final String TEXT_74 = "=new com.jcraft.jsch.JSch(); " + NL + "" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_77 = " - SFTP authentication using a public key.\");" + NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_78 = " - Private key: '\" + ";
  protected final String TEXT_79 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\tjsch_";
  protected final String TEXT_81 = ".addIdentity(";
  protected final String TEXT_82 = ", defaultUserInfo_";
  protected final String TEXT_83 = ".getPassphrase());" + NL + "    \t";
  protected final String TEXT_84 = NL + "    \t" + NL + "\t\tcom.jcraft.jsch.Session session_";
  protected final String TEXT_85 = "=jsch_";
  protected final String TEXT_86 = ".getSession(";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ");" + NL + "\t\tsession_";
  protected final String TEXT_90 = ".setConfig(\"PreferredAuthentications\", \"publickey,password,keyboard-interactive,gssapi-with-mic\");" + NL + "" + NL + "\t\t";
  protected final String TEXT_91 = " " + NL + "\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_93 = " - SFTP authentication using a password.\");" + NL + "\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_95 = " " + NL + "    \t" + NL + "\t\t\t";
  protected final String TEXT_96 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_97 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = "; ";
  protected final String TEXT_102 = NL + "\t\t\t" + NL + "      \t\tsession_";
  protected final String TEXT_103 = ".setPassword(decryptedPassword_";
  protected final String TEXT_104 = "); " + NL + "    \t";
  protected final String TEXT_105 = NL + "\t\tsession_";
  protected final String TEXT_106 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_107 = "); " + NL + "\t\t";
  protected final String TEXT_108 = NL + "\t\t\tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "\t\t\t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_109 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "\t\t\t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "\t\t\t\t\tproxy_";
  protected final String TEXT_110 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "\t\t\t\t}" + NL + "\t\t\t\tsession_";
  protected final String TEXT_111 = ".setProxy(proxy_";
  protected final String TEXT_112 = ");" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_113 = NL + "\t\t";
  protected final String TEXT_114 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_115 = " - Attempt to connect to '\" + ";
  protected final String TEXT_116 = " + \"' with username '\" + ";
  protected final String TEXT_117 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_118 = NL + "\t    session_";
  protected final String TEXT_119 = ".connect();" + NL + "\t    com.jcraft.jsch. Channel channel_";
  protected final String TEXT_120 = "=session_";
  protected final String TEXT_121 = ".openChannel(\"sftp\");" + NL + "\t    channel_";
  protected final String TEXT_122 = ".connect();" + NL + "\t\t";
  protected final String TEXT_123 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_124 = " - Connect to '\" + ";
  protected final String TEXT_125 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_126 = NL + "\t    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_127 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_128 = ";" + NL + "\t    " + NL + "\t    ";
  protected final String TEXT_129 = NL + "\t    \tc_";
  protected final String TEXT_130 = ".setFilenameEncoding(";
  protected final String TEXT_131 = ");" + NL + "\t    ";
  protected final String TEXT_132 = NL + "\t";
  protected final String TEXT_133 = "    " + NL + "\t    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_134 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_135 = "\");" + NL + "\t\t";
  protected final String TEXT_136 = NL + "\t\t\tif(c_";
  protected final String TEXT_137 = "!=null && c_";
  protected final String TEXT_138 = ".getSession()!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_139 = " - Use an existing connection.Connection username: \" + c_";
  protected final String TEXT_140 = ".getSession().getUserName() + \", Connection hostname: \" + c_";
  protected final String TEXT_141 = ".getSession().getHost() + \", Connection port: \" + c_";
  protected final String TEXT_142 = ".getSession().getPort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_143 = NL + "\t    if(c_";
  protected final String TEXT_144 = ".getHome()!=null && !c_";
  protected final String TEXT_145 = ".getHome().equals(c_";
  protected final String TEXT_146 = ".pwd())){" + NL + "\t  \t\tc_";
  protected final String TEXT_147 = ".cd(c_";
  protected final String TEXT_148 = ".getHome());" + NL + "\t  \t}" + NL + "\t";
  protected final String TEXT_149 = " " + NL + "\tjava.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_150 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "" + NL + "\t";
  protected final String TEXT_151 = "    " + NL + "\t    java.util.Map<String,String> map";
  protected final String TEXT_152 = " = new java.util.HashMap<String,String>();" + NL + "\t    map";
  protected final String TEXT_153 = ".put(";
  protected final String TEXT_154 = ",\"\");" + NL + "\t    list";
  protected final String TEXT_155 = ".add(map";
  protected final String TEXT_156 = ");" + NL + "\t";
  protected final String TEXT_157 = NL;
  protected final String TEXT_158 = NL + "    \tlog.info(\"";
  protected final String TEXT_159 = " - Truncating file from the server.\");";
  protected final String TEXT_160 = NL + "\tfor (java.util.Map<String, String> map";
  protected final String TEXT_161 = " : list";
  protected final String TEXT_162 = ") {" + NL;
  protected final String TEXT_163 = NL + "\t\t";
  protected final String TEXT_164 = NL + NL + "\tclass MyTrust_";
  protected final String TEXT_165 = " {" + NL + "" + NL + "\t\tprivate javax.net.ssl.TrustManager[] getTrustManagers() " + NL + "\t\tthrows java.security.KeyStoreException, java.security.NoSuchAlgorithmException, " + NL + "\t\t\tjava.security.cert.CertificateException, java.security.UnrecoverableKeyException," + NL + "\t\t\tjava.io.IOException {" + NL + "\t\t\tjava.security.KeyStore ks = java.security.KeyStore.getInstance(\"JKS\");" + NL;
  protected final String TEXT_166 = " " + NL + "\t\t\t\tString decryptedKeyStorePassword_";
  protected final String TEXT_167 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_168 = ");";
  protected final String TEXT_169 = NL + "\t\t\t\tString decryptedKeyStorePassword_";
  protected final String TEXT_170 = " = ";
  protected final String TEXT_171 = "; ";
  protected final String TEXT_172 = NL + "\t\t\tks.load(new java.io.FileInputStream(";
  protected final String TEXT_173 = "), decryptedKeyStorePassword_";
  protected final String TEXT_174 = ".toCharArray());" + NL + "\t\t\tjavax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "\t\t\ttmf.init(ks);" + NL + "\t\t\treturn tmf.getTrustManagers();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t\tclass SSLSessionReuseFTPSClient_";
  protected final String TEXT_175 = " extends org.apache.commons.net.ftp.FTPSClient {" + NL + "" + NL + "\t\tpublic SSLSessionReuseFTPSClient_";
  protected final String TEXT_176 = "(boolean isImplicit, javax.net.ssl.SSLContext context) {" + NL + "\t\t\tsuper(isImplicit, context);" + NL + "\t\t}" + NL + "" + NL + "\t\t// changed to support TLS session resumption" + NL + "\t\t@Override" + NL + "\t\tprotected void _prepareDataSocket_(final java.net.Socket socket) throws IOException {" + NL + "\t\t\tif(socket instanceof javax.net.ssl.SSLSocket) {" + NL + "\t\t\t\tfinal javax.net.ssl.SSLSession session = ((javax.net.ssl.SSLSocket) _socket_).getSession();" + NL + "\t\t\t\tfinal javax.net.ssl.SSLSessionContext context = session.getSessionContext();" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tfinal java.lang.reflect.Field sessionHostPortCache = context.getClass().getDeclaredField(\"sessionHostPortCache\");" + NL + "\t\t\t\t\tsessionHostPortCache.setAccessible(true);" + NL + "\t\t\t\t\tfinal Object cache = sessionHostPortCache.get(context);" + NL + "\t\t\t\t\tfinal java.lang.reflect.Method putMethod = cache.getClass().getDeclaredMethod(\"put\", Object.class, Object.class);" + NL + "\t\t\t\t\tputMethod.setAccessible(true);" + NL + "\t\t\t\t\tfinal java.lang.reflect.Method getHostMethod = socket.getClass().getDeclaredMethod(\"getHost\");" + NL + "\t\t\t\t\tgetHostMethod.setAccessible(true);" + NL + "\t\t\t\t\tObject host = getHostMethod.invoke(socket);" + NL + "\t\t\t\t\tfinal String key = String.format(\"%s:%s\", host, String.valueOf(socket.getPort())).toLowerCase(java.util.Locale.ROOT);" + NL + "\t\t\t\t\tputMethod.invoke(cache, key, session);" + NL + "\t\t\t\t} catch(Exception e) {";
  protected final String TEXT_177 = NL + "\t\t\t\t\t\tlog.error(\"Can't adapt ftps client to support TLS session resumption\");";
  protected final String TEXT_178 = NL + "\t\t\t\t\tthrow new RuntimeException(e);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t\tjavax.net.ssl.SSLContext sslContext_";
  protected final String TEXT_179 = " = null;" + NL + "\t\tjavax.net.ssl.TrustManager[] trustManager_";
  protected final String TEXT_180 = " = null;" + NL + "\t\tjavax.net.ssl.SSLSocketFactory sslSocketFactory_";
  protected final String TEXT_181 = " = null;" + NL + "\t\torg.apache.commons.net.ftp.FTPSClient ftp_";
  protected final String TEXT_182 = " =null;" + NL + "\t\tMyTrust_";
  protected final String TEXT_183 = " myTrust_";
  protected final String TEXT_184 = " = null;" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tsslContext_";
  protected final String TEXT_185 = " = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "\t\t\tmyTrust_";
  protected final String TEXT_186 = " = new MyTrust_";
  protected final String TEXT_187 = "();" + NL + "\t\t\ttrustManager_";
  protected final String TEXT_188 = " = myTrust_";
  protected final String TEXT_189 = ".getTrustManagers();" + NL + "\t\t\tsslContext_";
  protected final String TEXT_190 = ".init(null, trustManager_";
  protected final String TEXT_191 = ", new java.security.SecureRandom());" + NL + "\t\t\tsslSocketFactory_";
  protected final String TEXT_192 = " = sslContext_";
  protected final String TEXT_193 = ".getSocketFactory();" + NL + "\t\t\tftp_";
  protected final String TEXT_194 = " = new SSLSessionReuseFTPSClient_";
  protected final String TEXT_195 = "(";
  protected final String TEXT_196 = ", sslContext_";
  protected final String TEXT_197 = ");" + NL + "\t\t\tftp_";
  protected final String TEXT_198 = ".setControlEncoding(";
  protected final String TEXT_199 = ");" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_200 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_201 = " -FTPS security Mode is ";
  protected final String TEXT_202 = ".\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_203 = " - Attempt to connect to '\" + ";
  protected final String TEXT_204 = " + \"' with username '\" + ";
  protected final String TEXT_205 = "+ \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_206 = NL + "\t\t\tftp_";
  protected final String TEXT_207 = ".connect(";
  protected final String TEXT_208 = ",";
  protected final String TEXT_209 = ");";
  protected final String TEXT_210 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_211 = " - Connect to '\" + ";
  protected final String TEXT_212 = " + \"' has succeeded.\");";
  protected final String TEXT_213 = NL + NL + "\t\t\t";
  protected final String TEXT_214 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_215 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_216 = ");";
  protected final String TEXT_217 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_218 = " = ";
  protected final String TEXT_219 = "; ";
  protected final String TEXT_220 = NL + NL + "\t\t\tboolean isLoginSuccessful_";
  protected final String TEXT_221 = " = ftp_";
  protected final String TEXT_222 = ".login(";
  protected final String TEXT_223 = ", decryptedPassword_";
  protected final String TEXT_224 = ");" + NL + "" + NL + "\t\t\tif (!isLoginSuccessful_";
  protected final String TEXT_225 = ") {" + NL + "\t\t\t\tthrow new RuntimeException(\"Login failed\");" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tftp_";
  protected final String TEXT_226 = ".execPROT(";
  protected final String TEXT_227 = ");" + NL + "\t\t\tftp_";
  protected final String TEXT_228 = ".execPBSZ(";
  protected final String TEXT_229 = ");" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_231 = " - Can't create connection: \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_232 = NL + "\t\t\tthrow e;" + NL + "\t\t}";
  protected final String TEXT_233 = NL + "\t\t\tftp_";
  protected final String TEXT_234 = ".enterLocalPassiveMode();";
  protected final String TEXT_235 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_236 = " - Using the passive mode.\");";
  protected final String TEXT_237 = NL + "\t\torg.apache.commons.net.ftp.FTPSClient ftp_";
  protected final String TEXT_238 = " = (org.apache.commons.net.ftp.FTPSClient) globalMap.get(\"";
  protected final String TEXT_239 = "\");";
  protected final String TEXT_240 = NL + "\t\t\tboolean cwdSuccess_";
  protected final String TEXT_241 = " = ftp_";
  protected final String TEXT_242 = ".changeWorkingDirectory(";
  protected final String TEXT_243 = ");" + NL + "" + NL + "\t\t\tif (!cwdSuccess_";
  protected final String TEXT_244 = ") {" + NL + "\t\t\t\tthrow new RuntimeException(\"Failed to change remote directory. \" + ftp_";
  protected final String TEXT_245 = ".getReplyString());" + NL + "\t\t\t}";
  protected final String TEXT_246 = NL + "\t";
  protected final String TEXT_247 = NL + "\tString rootWorkDir_";
  protected final String TEXT_248 = " = ftp_";
  protected final String TEXT_249 = ".printWorkingDirectory();\t" + NL + "\tjava.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_250 = " = new java.util.ArrayList<java.util.Map<String,String>>();";
  protected final String TEXT_251 = NL + "\t\t\t\tjava.util.Map<String,String> map";
  protected final String TEXT_252 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\t\tmap";
  protected final String TEXT_253 = ".put(";
  protected final String TEXT_254 = ",\"\");" + NL + "\t\t\t\tlist";
  protected final String TEXT_255 = ".add(map";
  protected final String TEXT_256 = ");";
  protected final String TEXT_257 = "  " + NL + "\tfor (java.util.Map<String, String> map";
  protected final String TEXT_258 = " : list";
  protected final String TEXT_259 = ") { ";
  protected final String TEXT_260 = NL + "\tcom.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_261 = " = null;" + NL + "" + NL + "\t";
  protected final String TEXT_262 = NL + "\t\tftp_";
  protected final String TEXT_263 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_264 = "\");" + NL + "\t\t";
  protected final String TEXT_265 = NL + "\t\t\tif(ftp_";
  protected final String TEXT_266 = "!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_267 = " - Use an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_268 = ".getRemoteHost() + \", Connection port: \" + ftp_";
  protected final String TEXT_269 = ".getRemotePort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_270 = NL + "\t\t";
  protected final String TEXT_271 = NL + "\t\t  String rootDir_";
  protected final String TEXT_272 = " = ftp_";
  protected final String TEXT_273 = ".pwd();" + NL + "\t\t";
  protected final String TEXT_274 = NL + "\t";
  protected final String TEXT_275 = "    " + NL + "\t    ftp_";
  protected final String TEXT_276 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "\t    ftp_";
  protected final String TEXT_277 = ".setRemoteHost(";
  protected final String TEXT_278 = ");" + NL + "\t    ftp_";
  protected final String TEXT_279 = ".setRemotePort(";
  protected final String TEXT_280 = ");" + NL + "" + NL + "\t    ";
  protected final String TEXT_281 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_282 = " - \" + ";
  protected final String TEXT_283 = ");" + NL + "\t\t";
  protected final String TEXT_284 = NL + "\t    ";
  protected final String TEXT_285 = NL + "\t      ftp_";
  protected final String TEXT_286 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);" + NL + "\t    ";
  protected final String TEXT_287 = NL + "\t      ftp_";
  protected final String TEXT_288 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);" + NL + "\t    ";
  protected final String TEXT_289 = NL + "    \tftp_";
  protected final String TEXT_290 = ".setControlEncoding(";
  protected final String TEXT_291 = ");" + NL + "\t\t";
  protected final String TEXT_292 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_293 = " - Attempt to connect to '\" + ";
  protected final String TEXT_294 = " + \"' with username '\" +";
  protected final String TEXT_295 = "+ \"'.\");" + NL + "\t\t";
  protected final String TEXT_296 = NL + "\t    ftp_";
  protected final String TEXT_297 = ".connect();" + NL + "\t    " + NL + "\t    ";
  protected final String TEXT_298 = " " + NL + "\t" + NL + "\t\t";
  protected final String TEXT_299 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_300 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_301 = ");";
  protected final String TEXT_302 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_303 = " = ";
  protected final String TEXT_304 = "; ";
  protected final String TEXT_305 = NL + "\t\t\t" + NL + "\t    ftp_";
  protected final String TEXT_306 = ".login(";
  protected final String TEXT_307 = ", decryptedPassword_";
  protected final String TEXT_308 = ");" + NL + "\t\t";
  protected final String TEXT_309 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_310 = " - Connect to '\" + ";
  protected final String TEXT_311 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_312 = "   " + NL + "  \t";
  protected final String TEXT_313 = " " + NL + "\tjava.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_314 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "" + NL + "\t";
  protected final String TEXT_315 = "    " + NL + "\t\tjava.util.Map<String,String> map";
  protected final String TEXT_316 = " = new java.util.HashMap<String,String>();" + NL + "\t\tmap";
  protected final String TEXT_317 = ".put(";
  protected final String TEXT_318 = ",\"\");" + NL + "\t\tlist";
  protected final String TEXT_319 = ".add(map";
  protected final String TEXT_320 = ");       " + NL + "\t";
  protected final String TEXT_321 = NL + "\tString remotedir";
  protected final String TEXT_322 = " = ";
  protected final String TEXT_323 = ";" + NL + "\tftp_";
  protected final String TEXT_324 = ".chdir(remotedir";
  protected final String TEXT_325 = ");" + NL + "\tString root";
  protected final String TEXT_326 = " = ftp_";
  protected final String TEXT_327 = ".pwd();" + NL + "" + NL + "\t";
  protected final String TEXT_328 = NL + "\t\tlog.info(\"";
  protected final String TEXT_329 = " - Truncating file from the server.\");" + NL + "\t";
  protected final String TEXT_330 = NL + "\tfor (java.util.Map<String, String> map";
  protected final String TEXT_331 = " : list";
  protected final String TEXT_332 = ") {";
  protected final String TEXT_333 = NL;

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

boolean use_encoding = "true".equals(ElementParameterParser.getValue(node, "__USE_ENCODING__"));

String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String authMethod = ElementParameterParser.getValue(node,"__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node,"__PRIVATEKEY__");

List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");  
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");

String connectMode = ElementParameterParser.getValue(node,"__CONNECT_MODE__");
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

//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.
if (useProxy) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_37);
    
passwordFieldName = "__PROXY_PASSWORD__";
if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_40);
    } else {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
      
if (sftp) {// *** sftp *** //

	if (("false").equals(useExistingConn)) {
	
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
            passwordFieldName = "__PASSPHRASE__";
            if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
            
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_53);
    } else {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
			passwordFieldName = "__PASSWORD__";
			
    stringBuffer.append(TEXT_61);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_64);
    } else {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_75);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(privateKey);
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_91);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(TEXT_94);
    
			passwordFieldName = "__PASSWORD__";
			
    stringBuffer.append(TEXT_95);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_98);
    } else {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    if (!useProxy) {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_125);
    }
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    if(use_encoding) {
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    
	} else {
	
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_135);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    }
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
	}
	
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    for (int i = 0; i < files.size(); i++) {
    	Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_153);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_156);
    }
    stringBuffer.append(TEXT_157);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    }
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    
} else if (ftps) { // *** ftps *** //
	 /* creating connection */ 
	if (("false").equals(useExistingConn)) {
		String keystoreFile = ElementParameterParser.getValue(node, "__KEYSTORE_FILE__");
		String securityMode = ElementParameterParser.getValue(node, "__SECURITY_MODE__");

    stringBuffer.append(TEXT_163);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    
			passwordFieldName = "__KEYSTORE_PASS__";
			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_168);
    
			} else {

    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_171);
    
			}

    stringBuffer.append(TEXT_172);
    stringBuffer.append(keystoreFile);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    
					if (isLog4jEnabled) {

    stringBuffer.append(TEXT_177);
    
					}

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append("IMPLICIT".equals(securityMode));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_199);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(securityMode);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_205);
    }
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(ftpsPort );
    stringBuffer.append(TEXT_209);
    
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_212);
    
			}

			passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_213);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_216);
    } else {
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(protectionLevel );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(protectionBufferSize );
    stringBuffer.append(TEXT_229);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    }
    stringBuffer.append(TEXT_232);
    
		if ("PASSIVE".equals(connectMode)) {

    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    
			}
		}
	} else {

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_239);
    
		if (moveToCurrentDir) {

    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    
		}
	}

    stringBuffer.append(TEXT_246);
     /*store real pwd*/ 
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    
			for (int i = 0; i < files.size(); i++) {
				Map<String, String> line = files.get(i);

    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_253);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_256);
    
			}

    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
     /* start main loop */ 
    
} else {// *** ftp *** //

    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    if (("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_264);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_270);
    if(!moveToCurrentDir){
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    }
    stringBuffer.append(TEXT_274);
    } else {
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_280);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_283);
    }
    stringBuffer.append(TEXT_284);
     if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    } else {
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    }
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_291);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_295);
    }
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    
		passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_298);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_301);
    } else {
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_304);
    }
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_311);
    }
    stringBuffer.append(TEXT_312);
    }
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    for (int i = 0; i < files.size(); i++) {
    	Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_317);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_320);
    }
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    }
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    }
    stringBuffer.append(TEXT_333);
    return stringBuffer.toString();
  }
}

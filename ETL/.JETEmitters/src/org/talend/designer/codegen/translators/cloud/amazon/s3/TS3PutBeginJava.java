package org.talend.designer.codegen.translators.cloud.amazon.s3;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TS3PutBeginJava
{
  protected static String nl;
  public static synchronized TS3PutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3PutBeginJava result = new TS3PutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_4 = " = (com.amazonaws.services.s3.AmazonS3Client)globalMap.get(\"";
  protected final String TEXT_5 = "\");" + NL + "\t\t";
  protected final String TEXT_6 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Get an free connection from \" + \"";
  protected final String TEXT_8 = "\" + \".\");" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t    ";
  protected final String TEXT_10 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Creating new connection.\");" + NL + "\t\t";
  protected final String TEXT_12 = NL + "    " + NL + "    \t\t";
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + NL + "\t\t\tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_20 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_21 = ",decryptedPassword_";
  protected final String TEXT_22 = ");" + NL + "\t\t\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_23 = " = new com.amazonaws.internal.StaticCredentialsProvider(credentials_";
  protected final String TEXT_24 = ");" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_26 = " = new com.amazonaws.auth.InstanceProfileCredentialsProvider();" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t\t\tString masterKey_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = "; " + NL + "\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_30 = " = new javax.crypto.spec.SecretKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(masterKey_";
  protected final String TEXT_31 = ".getBytes(\"UTF-8\")), \"AES\");" + NL + "\t\t\tcom.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_32 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(symmetricKey_";
  protected final String TEXT_33 = ");" + NL + "\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_34 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_35 = ");" + NL + "\t\t";
  protected final String TEXT_36 = NL + "\t\t\t";
  protected final String TEXT_37 = " " + NL + "\t\t\tfinal String kms_cmk_";
  protected final String TEXT_38 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_39 = ");" + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\tfinal String kms_cmk_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = "; " + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t" + NL + "\t\t\tcom.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_44 = " = new com.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider(kms_cmk_";
  protected final String TEXT_45 = ");" + NL + "\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t";
  protected final String TEXT_47 = " " + NL + "\t\t\t\tfinal String smk_";
  protected final String TEXT_48 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_49 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\tfinal String smk_";
  protected final String TEXT_51 = " = ";
  protected final String TEXT_52 = "; " + NL + "\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t" + NL + "\t\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_54 = " = new javax.crypto.spec.SecretKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(smk_";
  protected final String TEXT_55 = ".getBytes(\"UTF-8\")), \"AES\");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_56 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(symmetricKey_";
  protected final String TEXT_57 = ");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_58 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_59 = ");" + NL + "\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\tjava.io.File keyFile_";
  protected final String TEXT_61 = " = new java.io.File(";
  protected final String TEXT_62 = ");" + NL + "\t\t\t\tjava.io.FileInputStream keyfis_";
  protected final String TEXT_63 = " = null;" + NL + "\t\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_64 = " = null;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t        keyfis_";
  protected final String TEXT_65 = " = new java.io.FileInputStream(keyFile_";
  protected final String TEXT_66 = ");" + NL + "\t\t\t        byte[] encodedPrivateKey_";
  protected final String TEXT_67 = " = new byte[(int)keyFile_";
  protected final String TEXT_68 = ".length()];" + NL + "\t\t\t        keyfis_";
  protected final String TEXT_69 = ".read(encodedPrivateKey_";
  protected final String TEXT_70 = ");" + NL + "\t\t\t        symmetricKey_";
  protected final String TEXT_71 = " = new javax.crypto.spec.SecretKeySpec(encodedPrivateKey_";
  protected final String TEXT_72 = ", \"AES\");" + NL + "\t\t        } finally {" + NL + "\t\t        \tif(keyfis_";
  protected final String TEXT_73 = "!=null) {" + NL + "\t\t        \t\tkeyfis_";
  protected final String TEXT_74 = ".close();" + NL + "\t\t        \t}" + NL + "\t\t        }" + NL + "\t\t        " + NL + "\t\t        com.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_75 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(symmetricKey_";
  protected final String TEXT_76 = ");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_77 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_78 = ");" + NL + "\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\tjava.io.File filePublicKey_";
  protected final String TEXT_80 = " = new java.io.File(";
  protected final String TEXT_81 = ");" + NL + "\t\t\tjava.io.FileInputStream fis_";
  protected final String TEXT_82 = " = null;" + NL + "\t\t\tbyte[] encodedPublicKey_";
  protected final String TEXT_83 = " = null;" + NL + "\t\t\ttry {" + NL + "\t\t        fis_";
  protected final String TEXT_84 = " = new java.io.FileInputStream(filePublicKey_";
  protected final String TEXT_85 = ");" + NL + "\t\t        encodedPublicKey_";
  protected final String TEXT_86 = " = new byte[(int) filePublicKey_";
  protected final String TEXT_87 = ".length()];" + NL + "\t\t        fis_";
  protected final String TEXT_88 = ".read(encodedPublicKey_";
  protected final String TEXT_89 = ");" + NL + "\t        } finally {" + NL + "\t        \tif(fis_";
  protected final String TEXT_90 = "!=null) {" + NL + "\t        \t\tfis_";
  protected final String TEXT_91 = ".close();" + NL + "\t        \t}" + NL + "\t        }" + NL + "\t" + NL + "\t        java.io.File filePrivateKey_";
  protected final String TEXT_92 = " = new java.io.File(";
  protected final String TEXT_93 = ");" + NL + "\t        byte[] encodedPrivateKey_";
  protected final String TEXT_94 = " = null;" + NL + "\t        try {" + NL + "\t\t        fis_";
  protected final String TEXT_95 = " = new java.io.FileInputStream(filePrivateKey_";
  protected final String TEXT_96 = ");" + NL + "\t\t        encodedPrivateKey_";
  protected final String TEXT_97 = " = new byte[(int) filePrivateKey_";
  protected final String TEXT_98 = ".length()];" + NL + "\t\t        fis_";
  protected final String TEXT_99 = ".read(encodedPrivateKey_";
  protected final String TEXT_100 = ");" + NL + "\t        } finally {" + NL + "\t        \tif(fis_";
  protected final String TEXT_101 = "!=null) {" + NL + "\t        \t\tfis_";
  protected final String TEXT_102 = ".close();" + NL + "\t        \t}" + NL + "\t        }" + NL + "\t" + NL + "\t        java.security.KeyFactory keyFactory_";
  protected final String TEXT_103 = " = java.security.KeyFactory.getInstance(\"";
  protected final String TEXT_104 = "\");" + NL + "\t        " + NL + "\t        java.security.spec.X509EncodedKeySpec publicKeySpec_";
  protected final String TEXT_105 = " = new java.security.spec.X509EncodedKeySpec(" + NL + "\t                encodedPublicKey_";
  protected final String TEXT_106 = ");" + NL + "\t        java.security.PublicKey publicKey_";
  protected final String TEXT_107 = " = keyFactory_";
  protected final String TEXT_108 = ".generatePublic(publicKeySpec_";
  protected final String TEXT_109 = ");" + NL + "\t" + NL + "\t        java.security.spec.PKCS8EncodedKeySpec privateKeySpec_";
  protected final String TEXT_110 = " = new java.security.spec.PKCS8EncodedKeySpec(" + NL + "\t                encodedPrivateKey_";
  protected final String TEXT_111 = ");" + NL + "\t        java.security.PrivateKey privateKey_";
  protected final String TEXT_112 = " = keyFactory_";
  protected final String TEXT_113 = ".generatePrivate(privateKeySpec_";
  protected final String TEXT_114 = ");" + NL + "\t" + NL + "\t        java.security.KeyPair asymmetricKey_";
  protected final String TEXT_115 = " = new java.security.KeyPair(publicKey_";
  protected final String TEXT_116 = ", privateKey_";
  protected final String TEXT_117 = ");" + NL + "\t        " + NL + "\t        com.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_118 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(asymmetricKey_";
  protected final String TEXT_119 = ");" + NL + "\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_120 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_121 = ");" + NL + "\t\t";
  protected final String TEXT_122 = NL + "\t\tcom.amazonaws.ClientConfiguration cc_";
  protected final String TEXT_123 = " = new com.amazonaws.ClientConfiguration();" + NL + "\t\tcc_";
  protected final String TEXT_124 = ".setUserAgent(\"";
  protected final String TEXT_125 = "\");" + NL + "\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\t\tint scketSendBufferSizeHints_";
  protected final String TEXT_127 = " = 0;" + NL + "\t\t\t\t\tint socketReceiveBufferSizeHints_";
  protected final String TEXT_128 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_129 = NL + "\t\t\t\t\tscketSendBufferSizeHints_";
  protected final String TEXT_130 = " = ";
  protected final String TEXT_131 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_132 = NL + "\t\t\t\t\tsocketReceiveBufferSizeHints_";
  protected final String TEXT_133 = " = ";
  protected final String TEXT_134 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_136 = ".setProtocol(com.amazonaws.Protocol.";
  protected final String TEXT_137 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_139 = ".set";
  protected final String TEXT_140 = "(";
  protected final String TEXT_141 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\t\tcc_";
  protected final String TEXT_143 = ".setSocketBufferSizeHints(scketSendBufferSizeHints_";
  protected final String TEXT_144 = ",socketReceiveBufferSizeHints_";
  protected final String TEXT_145 = ");" + NL + "\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\tint sessionDurationSeconds_";
  protected final String TEXT_147 = " = ";
  protected final String TEXT_148 = " * 60;" + NL + "\t\t\tcom.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder stsBuilder_";
  protected final String TEXT_149 = " = " + NL + "\t\t\t\t\tnew com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder(";
  protected final String TEXT_150 = ", ";
  protected final String TEXT_151 = ").withLongLivedCredentialsProvider(credentialsProvider_";
  protected final String TEXT_152 = ")" + NL + "\t\t\t\t\t.withRoleSessionDurationSeconds(sessionDurationSeconds_";
  protected final String TEXT_153 = ");" + NL + "\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t\tstsBuilder_";
  protected final String TEXT_155 = ".withServiceEndpoint(";
  protected final String TEXT_156 = ");" + NL + "\t\t\t";
  protected final String TEXT_157 = NL + "\t\t\tstsBuilder_";
  protected final String TEXT_158 = ".withClientConfiguration(cc_";
  protected final String TEXT_159 = ");" + NL + "\t\t\t" + NL + "\t\t\tcredentialsProvider_";
  protected final String TEXT_160 = " = stsBuilder_";
  protected final String TEXT_161 = ".build();" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_162 = NL + "\t\t\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_163 = " = new com.amazonaws.services.s3.AmazonS3EncryptionClient(" + NL + "\t\t\t\t\tcredentialsProvider_";
  protected final String TEXT_164 = "," + NL + "\t\t\t\t\tencryptionMaterialsProvider_";
  protected final String TEXT_165 = ", " + NL + "\t\t\t\t\tcc_";
  protected final String TEXT_166 = "," + NL + "\t\t\t\t\tnew com.amazonaws.services.s3.model.CryptoConfiguration()" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\t.withAwsKmsRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_168 = "))" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t);" + NL + "\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_171 = " = new com.amazonaws.services.s3.AmazonS3Client(" + NL + "\t\t\t\t\tcredentialsProvider_";
  protected final String TEXT_172 = "," + NL + "\t\t\t\t\tcc_";
  protected final String TEXT_173 = NL + "\t\t\t\t);" + NL + "\t\t\t";
  protected final String TEXT_174 = NL + "\t\t\tconn_";
  protected final String TEXT_175 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_176 = "));" + NL + "\t\t";
  protected final String TEXT_177 = NL + "\t\t\tconn_";
  protected final String TEXT_178 = ".setEndpoint(";
  protected final String TEXT_179 = ");" + NL + "\t\t";
  protected final String TEXT_180 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_181 = " - Creating new connection successfully.\");" + NL + "\t\t";
  protected final String TEXT_182 = NL + "\tString key_";
  protected final String TEXT_183 = " = ";
  protected final String TEXT_184 = ";" + NL + "\t" + NL + "\tint partSizeInBytes_";
  protected final String TEXT_185 = " = ";
  protected final String TEXT_186 = " * 1024 * 1024;" + NL + "\t" + NL + "\tObject fileOrStream_";
  protected final String TEXT_187 = " = ";
  protected final String TEXT_188 = ";" + NL + "\t" + NL + "\tboolean useStream_";
  protected final String TEXT_189 = " = false;" + NL + "\tjava.io.InputStream uploadStream_";
  protected final String TEXT_190 = " = null;" + NL + "\t" + NL + "\ttry{" + NL + "\t\t";
  protected final String TEXT_191 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_192 = " - Uploading an object with key:\" + key_";
  protected final String TEXT_193 = ");" + NL + "\t\t";
  protected final String TEXT_194 = NL + "\t\t" + NL + "\t\tif(fileOrStream_";
  protected final String TEXT_195 = " instanceof String){" + NL + "\t\t    useStream_";
  protected final String TEXT_196 = " = false;" + NL + "\t\t}else if(fileOrStream_";
  protected final String TEXT_197 = " instanceof java.io.InputStream){" + NL + "\t\t    useStream_";
  protected final String TEXT_198 = " = true;" + NL + "\t\t}" + NL + "\t\t" + NL + "    com.amazonaws.services.s3.model.ObjectMetadata objectMetadata_";
  protected final String TEXT_199 = " = new com.amazonaws.services.s3.model.ObjectMetadata();" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_200 = NL + "\t\t\t\t";
  protected final String TEXT_201 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_202 = " - No KMS - Normal SSE\");" + NL + "\t\t\t\t";
  protected final String TEXT_203 = NL + "\t\t\tobjectMetadata_";
  protected final String TEXT_204 = ".setSSEAlgorithm(com.amazonaws.services.s3.model.ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);" + NL + "\t\t";
  protected final String TEXT_205 = NL + "\t\t" + NL + "\t\tif(!useStream_";
  protected final String TEXT_206 = ") {" + NL + "\t\t\t\tjava.io.File inputFile_";
  protected final String TEXT_207 = " = new java.io.File((String)fileOrStream_";
  protected final String TEXT_208 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\tlong multipart_upload_threshold_";
  protected final String TEXT_209 = " = 5 * 1024 * 1024;" + NL + "\t\t\t\t" + NL + "    \t\tcom.amazonaws.services.s3.transfer.TransferManager tm_";
  protected final String TEXT_210 = " = com.amazonaws.services.s3.transfer.TransferManagerBuilder" + NL + "    \t\t\t.standard()" + NL + "    \t\t\t.withMinimumUploadPartSize((long)partSizeInBytes_";
  protected final String TEXT_211 = ")" + NL + "    \t\t\t.withMultipartUploadThreshold(multipart_upload_threshold_";
  protected final String TEXT_212 = ")" + NL + "    \t\t\t.withS3Client(conn_";
  protected final String TEXT_213 = ")" + NL + "    \t\t\t.build();" + NL + "    \t\t\t" + NL + "  \t\t\tcom.amazonaws.services.s3.model.PutObjectRequest putRequest_";
  protected final String TEXT_214 = " = new com.amazonaws.services.s3.model.PutObjectRequest(";
  protected final String TEXT_215 = ", key_";
  protected final String TEXT_216 = ", inputFile_";
  protected final String TEXT_217 = ").withMetadata(objectMetadata_";
  protected final String TEXT_218 = ");" + NL + "  \t\t" + NL + "  \t\t\t";
  protected final String TEXT_219 = NL;
  protected final String TEXT_220 = NL + "\t";
  protected final String TEXT_221 = "\t" + NL + "\t\tlog.info(\"";
  protected final String TEXT_222 = " - KMS-Enabled - kmsid=\"+";
  protected final String TEXT_223 = ");" + NL + "\t";
  protected final String TEXT_224 = NL + "\t";
  protected final String TEXT_225 = NL + "\t\t";
  protected final String TEXT_226 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_227 = " - No KMS key - use default\");" + NL + "\t\t";
  protected final String TEXT_228 = NL + "\t\tputRequest_";
  protected final String TEXT_229 = ".setSSEAwsKeyManagementParams(new com.amazonaws.services.s3.model.SSEAwsKeyManagementParams ());" + NL + "\t";
  protected final String TEXT_230 = NL + "\t\t";
  protected final String TEXT_231 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_232 = " - Key found - use key\");" + NL + "\t\t";
  protected final String TEXT_233 = NL + "\t\tputRequest_";
  protected final String TEXT_234 = ".setSSEAwsKeyManagementParams(new com.amazonaws.services.s3.model.SSEAwsKeyManagementParams (";
  protected final String TEXT_235 = "));" + NL + "\t";
  protected final String TEXT_236 = NL + "  \t\t" + NL + "  \t\t\tcom.amazonaws.services.s3.transfer.Upload upload_";
  protected final String TEXT_237 = " = tm_";
  protected final String TEXT_238 = ".upload(putRequest_";
  protected final String TEXT_239 = ");" + NL + "  \t\t" + NL + "  \t\t\tupload_";
  protected final String TEXT_240 = ".waitForCompletion();" + NL + "\t\t} else {" + NL + "\t\t\t\tjava.io.InputStream sourceStream_";
  protected final String TEXT_241 = " = ((java.io.InputStream)fileOrStream_";
  protected final String TEXT_242 = ");" + NL + "\t\t\t\t" + NL + "  \t\t\tclass S3StreamUtil {" + NL + "    \t    public int getLength(byte[] output) {" + NL + "    \t\t    for (int i = output.length - 1; i > 0; i--) {" + NL + "    \t\t\t    if (output[i] != 0) {" + NL + "    \t\t\t\t    return i + 1;" + NL + "    \t\t\t    }" + NL + "    \t\t    }" + NL + "    \t\t    return 0;" + NL + "    \t    }" + NL + "      \t}" + NL + "      \t" + NL + "      \tS3StreamUtil streamUtil_";
  protected final String TEXT_243 = " = new S3StreamUtil();" + NL + "    \t\tbyte[] buffer_";
  protected final String TEXT_244 = " = new byte[partSizeInBytes_";
  protected final String TEXT_245 = "];" + NL + "    \t\tsourceStream_";
  protected final String TEXT_246 = ".read(buffer_";
  protected final String TEXT_247 = ");" + NL + "    \t\tlong curPartSize_";
  protected final String TEXT_248 = " = streamUtil_";
  protected final String TEXT_249 = ".getLength(buffer_";
  protected final String TEXT_250 = ");" + NL + "    \t\tboolean multiUpload_";
  protected final String TEXT_251 = " = curPartSize_";
  protected final String TEXT_252 = " == partSizeInBytes_";
  protected final String TEXT_253 = ";" + NL + "    \t\t" + NL + "    \t\tif(!multiUpload_";
  protected final String TEXT_254 = ") {" + NL + "    \t\t\t\tobjectMetadata_";
  protected final String TEXT_255 = ".setContentLength(curPartSize_";
  protected final String TEXT_256 = ");" + NL + "    \t\t\t\tuploadStream_";
  protected final String TEXT_257 = " = new java.io.ByteArrayInputStream(buffer_";
  protected final String TEXT_258 = ",0,Long.valueOf(curPartSize_";
  protected final String TEXT_259 = ").intValue());" + NL + "    \t\t\t\tcom.amazonaws.services.s3.model.PutObjectRequest putRequest_";
  protected final String TEXT_260 = " = new com.amazonaws.services.s3.model.PutObjectRequest(";
  protected final String TEXT_261 = ", key_";
  protected final String TEXT_262 = ", uploadStream_";
  protected final String TEXT_263 = ", objectMetadata_";
  protected final String TEXT_264 = ");" + NL + "    \t\t\t\t" + NL + "    \t\t\t\t";
  protected final String TEXT_265 = NL;
  protected final String TEXT_266 = NL + "\t";
  protected final String TEXT_267 = "\t" + NL + "\t\tlog.info(\"";
  protected final String TEXT_268 = " - KMS-Enabled - kmsid=\"+";
  protected final String TEXT_269 = ");" + NL + "\t";
  protected final String TEXT_270 = NL + "\t";
  protected final String TEXT_271 = NL + "\t\t";
  protected final String TEXT_272 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_273 = " - No KMS key - use default\");" + NL + "\t\t";
  protected final String TEXT_274 = NL + "\t\tputRequest_";
  protected final String TEXT_275 = ".setSSEAwsKeyManagementParams(new com.amazonaws.services.s3.model.SSEAwsKeyManagementParams ());" + NL + "\t";
  protected final String TEXT_276 = NL + "\t\t";
  protected final String TEXT_277 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_278 = " - Key found - use key\");" + NL + "\t\t";
  protected final String TEXT_279 = NL + "\t\tputRequest_";
  protected final String TEXT_280 = ".setSSEAwsKeyManagementParams(new com.amazonaws.services.s3.model.SSEAwsKeyManagementParams (";
  protected final String TEXT_281 = "));" + NL + "\t";
  protected final String TEXT_282 = NL + "    \t\t\t\t" + NL + "    \t\t\t\tconn_";
  protected final String TEXT_283 = ".putObject(putRequest_";
  protected final String TEXT_284 = ");" + NL + "    \t\t} else {" + NL + "    \t\t\t\tuploadStream_";
  protected final String TEXT_285 = " = new java.io.ByteArrayInputStream(buffer_";
  protected final String TEXT_286 = ");" + NL + "      \t\t\tjava.util.List<com.amazonaws.services.s3.model.PartETag> partTags_";
  protected final String TEXT_287 = " = new java.util.ArrayList<com.amazonaws.services.s3.model.PartETag>();" + NL + "      \t\t\tcom.amazonaws.services.s3.model.InitiateMultipartUploadRequest putRequest_";
  protected final String TEXT_288 = " = new com.amazonaws.services.s3.model.InitiateMultipartUploadRequest(";
  protected final String TEXT_289 = ", key_";
  protected final String TEXT_290 = ", objectMetadata_";
  protected final String TEXT_291 = ");" + NL + "      \t\t\t" + NL + "      \t\t\t";
  protected final String TEXT_292 = NL;
  protected final String TEXT_293 = NL + "\t";
  protected final String TEXT_294 = "\t" + NL + "\t\tlog.info(\"";
  protected final String TEXT_295 = " - KMS-Enabled - kmsid=\"+";
  protected final String TEXT_296 = ");" + NL + "\t";
  protected final String TEXT_297 = NL + "\t";
  protected final String TEXT_298 = NL + "\t\t";
  protected final String TEXT_299 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_300 = " - No KMS key - use default\");" + NL + "\t\t";
  protected final String TEXT_301 = NL + "\t\tputRequest_";
  protected final String TEXT_302 = ".setSSEAwsKeyManagementParams(new com.amazonaws.services.s3.model.SSEAwsKeyManagementParams ());" + NL + "\t";
  protected final String TEXT_303 = NL + "\t\t";
  protected final String TEXT_304 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_305 = " - Key found - use key\");" + NL + "\t\t";
  protected final String TEXT_306 = NL + "\t\tputRequest_";
  protected final String TEXT_307 = ".setSSEAwsKeyManagementParams(new com.amazonaws.services.s3.model.SSEAwsKeyManagementParams (";
  protected final String TEXT_308 = "));" + NL + "\t";
  protected final String TEXT_309 = NL + "      \t\t\t" + NL + "      \t\t\tcom.amazonaws.services.s3.model.InitiateMultipartUploadResult initResponse_";
  protected final String TEXT_310 = " = conn_";
  protected final String TEXT_311 = ".initiateMultipartUpload(putRequest_";
  protected final String TEXT_312 = ");" + NL + "      \t\t\tString uploadId_";
  protected final String TEXT_313 = " = initResponse_";
  protected final String TEXT_314 = ".getUploadId();" + NL + "      \t\t\tint partNumber_";
  protected final String TEXT_315 = " = 1;" + NL + "      \t\t\tboolean streamHasNext_";
  protected final String TEXT_316 = " = true;" + NL + "      \t\t\tbyte[] probeAvailability_";
  protected final String TEXT_317 = " = new byte[1];" + NL + "      \t\t\ttry {" + NL + "  \t\t\t\t\t\t\twhile (streamHasNext_";
  protected final String TEXT_318 = ") {" + NL + "        \t\t\t\t\t\tcom.amazonaws.services.s3.model.UploadPartRequest uploadRequest_";
  protected final String TEXT_319 = " = new com.amazonaws.services.s3.model.UploadPartRequest()" + NL + "                    \t.withBucketName(";
  protected final String TEXT_320 = ")" + NL + "                    \t.withKey(key_";
  protected final String TEXT_321 = ").withUploadId(uploadId_";
  protected final String TEXT_322 = ")" + NL + "                    \t.withPartNumber(partNumber_";
  protected final String TEXT_323 = ").withPartSize(curPartSize_";
  protected final String TEXT_324 = ");" + NL + "            \t\t    uploadRequest_";
  protected final String TEXT_325 = ".setInputStream(uploadStream_";
  protected final String TEXT_326 = ");" + NL + "            \t\t    streamHasNext_";
  protected final String TEXT_327 = " = sourceStream_";
  protected final String TEXT_328 = ".read(probeAvailability_";
  protected final String TEXT_329 = ") != -1;" + NL + "            \t\t    if(!streamHasNext_";
  protected final String TEXT_330 = "){" + NL + "                    \t    uploadRequest_";
  protected final String TEXT_331 = ".setLastPart(true);" + NL + "                    \t}" + NL + "" + NL + "                \t\tpartTags_";
  protected final String TEXT_332 = ".add(conn_";
  protected final String TEXT_333 = ".uploadPart(uploadRequest_";
  protected final String TEXT_334 = ").getPartETag());" + NL + "                  \t    partNumber_";
  protected final String TEXT_335 = "++;" + NL + "" + NL + "          \t\t     \tif(uploadStream_";
  protected final String TEXT_336 = "!=null){" + NL + "      \t\t         \t\t\tuploadStream_";
  protected final String TEXT_337 = ".close();" + NL + "          \t\t     \t}" + NL + "          \t\t     \tbuffer_";
  protected final String TEXT_338 = " = new byte[partSizeInBytes_";
  protected final String TEXT_339 = "];" + NL + "          \t\t     \tsourceStream_";
  protected final String TEXT_340 = ".read(buffer_";
  protected final String TEXT_341 = ",1,partSizeInBytes_";
  protected final String TEXT_342 = "-1);" + NL + "          \t\t     \tbuffer_";
  protected final String TEXT_343 = "[0] = probeAvailability_";
  protected final String TEXT_344 = "[0];" + NL + "          \t\t     \tprobeAvailability_";
  protected final String TEXT_345 = " = new byte[1];" + NL + "          \t\t     \tcurPartSize_";
  protected final String TEXT_346 = " = streamUtil_";
  protected final String TEXT_347 = ".getLength(buffer_";
  protected final String TEXT_348 = ");" + NL + "          \t\t     \tuploadStream_";
  protected final String TEXT_349 = " = new java.io.ByteArrayInputStream(buffer_";
  protected final String TEXT_350 = ");" + NL + "        \t\t\t\t}" + NL + "        \t\t\t\t" + NL + "            \t\tcom.amazonaws.services.s3.model.CompleteMultipartUploadRequest compRequest_";
  protected final String TEXT_351 = " = new com.amazonaws.services.s3.model.CompleteMultipartUploadRequest(";
  protected final String TEXT_352 = ", key_";
  protected final String TEXT_353 = "," + NL + "                        uploadId_";
  protected final String TEXT_354 = ", partTags_";
  protected final String TEXT_355 = ");" + NL + "            \t\tconn_";
  protected final String TEXT_356 = ".completeMultipartUpload(compRequest_";
  protected final String TEXT_357 = ");" + NL + "            } catch (java.lang.Exception uploadException_";
  protected final String TEXT_358 = ") {" + NL + "  \t\t\t\t\t\t\tconn_";
  protected final String TEXT_359 = ".abortMultipartUpload(new com.amazonaws.services.s3.model.AbortMultipartUploadRequest(";
  protected final String TEXT_360 = ", key_";
  protected final String TEXT_361 = ", uploadId_";
  protected final String TEXT_362 = "));" + NL + "    \t\t\t\t\t\tthrow uploadException_";
  protected final String TEXT_363 = ";" + NL + "            }" + NL + "    \t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_364 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_365 = " - Upload the object successfully.\");" + NL + "\t\t";
  protected final String TEXT_366 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_367 = "){" + NL + "\t\t";
  protected final String TEXT_368 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_369 = ");" + NL + "\t\t";
  protected final String TEXT_370 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_371 = " - \" + e_";
  protected final String TEXT_372 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_373 = NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_374 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_375 = NL + "\t}finally{" + NL + "\t\tif(useStream_";
  protected final String TEXT_376 = " && uploadStream_";
  protected final String TEXT_377 = "!=null){" + NL + "    \tuploadStream_";
  protected final String TEXT_378 = ".close();" + NL + "    }" + NL + "\t    " + NL + "\t\t";
  protected final String TEXT_379 = NL + "\t\tif(conn_";
  protected final String TEXT_380 = " !=null){" + NL + "\t\t\tconn_";
  protected final String TEXT_381 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_382 = NL + "\t}     ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
	
    String cid = node.getUniqueName();
    String bucket = ElementParameterParser.getValue(node,"__BUCKET__");
    String key = ElementParameterParser.getValue(node,"__KEY__");
    String file = ElementParameterParser.getValue(node,"__FILE__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String partSizeMb = ElementParameterParser.getValue(node, "__PART_SIZE__");
    String kmsid = ElementParameterParser.getValue(node, "__KMSID__");
	
	boolean enableKMS = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_KMS__"));
	
	if(partSizeMb == null) {
		partSizeMb = "5";
	}
	
	boolean enableServerSideEncryption = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_SERVER_SIDE_ENCRYPTION__"));
	
	
    stringBuffer.append(TEXT_2);
    
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	boolean configClient = "true".equals(ElementParameterParser.getValue(node, "__CONFIG_CLIENT__"));
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	List<Map<String,String>> clientConfiguration = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CLIENT_CONFIGURATION__");
	String region = ElementParameterParser.getValue(node,"__REGION__");
	
	boolean useRegionEndpoint 	= "true".equals(ElementParameterParser.getValue(node, "__USE_REGION_ENDPOINT__"));
	String regionEndpoint 		= ElementParameterParser.getValue(node,"__REGION_ENDPOINT__");
	
	boolean assumeRole = "true".equals(ElementParameterParser.getValue(node, "__ASSUME_ROLE__"));
	String arn = ElementParameterParser.getValue(node,"__ARN__");
	String roleSessionName = ElementParameterParser.getValue(node,"__ROLE_SESSION_NAME__");
	
	boolean setStsEndpoint = "true".equals(ElementParameterParser.getValue(node,"__SET_STS_ENDPOINT__"));
	String stsEndpoint = ElementParameterParser.getValue(node,"__STS_ENDPOINT__");
	
	String sessionDuration = ElementParameterParser.getValue(node,"__SESSION_DURATION__");
	if(sessionDuration == null || sessionDuration.isEmpty()) {
		sessionDuration = "15";
	}
	
	boolean set_region = (region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region));
	final String AWSTracker = org.talend.core.utils.TrackerUtil.getAWSTracker();
	
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;;
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_5);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_8);
    
		}
	}else{
	
    stringBuffer.append(TEXT_9);
    
	    if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		}
		
		boolean inherit_credentials = "true".equals(ElementParameterParser.getValue(node, "__INHERIT_CREDENTIALS__"));
		if(!inherit_credentials) {
	    	String passwordFieldName = "__SECRET_KEY__";
	    	
    stringBuffer.append(TEXT_12);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
		} else {
		
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
		}
		
		boolean encrypt = "true".equals(ElementParameterParser.getValue(node,"__ENCRYPT__"));
		
		//work for tRedshiftOutputBulk
		String encrypted_key = ElementParameterParser.getValue(node,"__ENCRYPTED_KEY__");
		
		//work for s3 components
		String key_type = ElementParameterParser.getValue(node,"__KEY_TYPE__");
		String algorithm_symmetric_master_key = ElementParameterParser.getValue(node,"__ALGORITHM_SYMMETRIC_MASTER_KEY__");
		String algorithm_asymmetric_master_key = ElementParameterParser.getValue(node,"__ALGORITHM_ASYMMETRIC_MASTER_KEY__");
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		
		String encrypted_key_x509 = ElementParameterParser.getValue(node,"__ENCRYPTED_KEY_X509__");
		String public_key = ElementParameterParser.getValue(node,"__PUBLIC_KEY__");
		String private_key = ElementParameterParser.getValue(node,"__PRIVATE_KEY__");
		
		if(encrypt && cid.startsWith("tRedshift")) {
		
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(encrypted_key);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
		} else if(encrypt && "KMS_CMK".equals(key_type)) {//KMS
		
    stringBuffer.append(TEXT_36);
    if (ElementParameterParser.canEncrypt(node, "__ENCRYPTED_KEY_CMK__")) {
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, "__ENCRYPTED_KEY_CMK__"));
    stringBuffer.append(TEXT_39);
    } else {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append( ElementParameterParser.getValue(node, "__ENCRYPTED_KEY_CMK__"));
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
		} else if(encrypt && "SYMMETRIC_MASTER_KEY".equals(key_type)) {//symmetric master key
			if("AES".equals(algorithm_symmetric_master_key) && "BASE64".equals(encoding)) {
			
    stringBuffer.append(TEXT_46);
    if (ElementParameterParser.canEncrypt(node, "__ENCRYPTED_KEY_BASE64__")) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, "__ENCRYPTED_KEY_BASE64__"));
    stringBuffer.append(TEXT_49);
    } else {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append( ElementParameterParser.getValue(node, "__ENCRYPTED_KEY_BASE64__"));
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
			} else if("AES".equals(algorithm_symmetric_master_key) && "X509".equals(encoding)) {
			
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(encrypted_key_x509);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
			}
		} else if(encrypt && "ASYMMETRIC_MASTER_KEY".equals(key_type)) {//asymmetric master key
		
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(public_key);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
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
    stringBuffer.append(private_key);
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
    stringBuffer.append(algorithm_asymmetric_master_key);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
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
		
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(AWSTracker);
    stringBuffer.append(TEXT_125);
    
		if(configClient && clientConfiguration.size()>0){
			boolean setBuffer = false;
			for(Map<String,String> map :clientConfiguration){
				String client_parameter = map.get("CLIENT_PARAMETER");
				String value = map.get("VALUE");
				if(!setBuffer && ("SocketSendBufferSizeHints".equals(client_parameter) || "SocketReceiveBufferSizeHints".equals(client_parameter))){
					setBuffer=true;
					
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
				}
				if("SocketSendBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_131);
    
				}else if("SocketReceiveBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_134);
    
				}else if("Protocol".equals(client_parameter)){
				
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(value.toUpperCase().replaceAll("\"",""));
    stringBuffer.append(TEXT_137);
    
				}else{
				
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(client_parameter);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_141);
    
				}
			}
			if(setBuffer){
			
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
			}
			
		}
		
		if(assumeRole) {
		
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(sessionDuration);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(arn);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(roleSessionName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
			if(setStsEndpoint) {
			
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(stsEndpoint);
    stringBuffer.append(TEXT_156);
    
			}
			
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
		}
			if(encrypt) {
			
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    if("KMS_CMK".equals(key_type) && set_region) {
    stringBuffer.append(TEXT_167);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    
			} else {
			
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
			}
		if(set_region){
		
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_176);
    
		}
		if(useRegionEndpoint && regionEndpoint != null && !regionEndpoint.isEmpty()){
		
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(regionEndpoint);
    stringBuffer.append(TEXT_179);
    
		}
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
		}
	}
	
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(partSizeMb);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
		}
		
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
		if(!enableKMS && enableServerSideEncryption){
		
    stringBuffer.append(TEXT_200);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
				}
				
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    
		}
		
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(TEXT_219);
    if(enableKMS){ /* KMS is enabled, so test for default or presence of key */

    stringBuffer.append(TEXT_220);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(kmsid);
    stringBuffer.append(TEXT_223);
    
	}
	
    stringBuffer.append(TEXT_224);
    
	if("\"\"".equals(kmsid)){
	
    stringBuffer.append(TEXT_225);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    
		}
		
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    
	} else {
	
    stringBuffer.append(TEXT_230);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
		}
		
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(kmsid);
    stringBuffer.append(TEXT_235);
    
	}
	
    
}

    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(TEXT_265);
    if(enableKMS){ /* KMS is enabled, so test for default or presence of key */

    stringBuffer.append(TEXT_266);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(kmsid);
    stringBuffer.append(TEXT_269);
    
	}
	
    stringBuffer.append(TEXT_270);
    
	if("\"\"".equals(kmsid)){
	
    stringBuffer.append(TEXT_271);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    
		}
		
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    
	} else {
	
    stringBuffer.append(TEXT_276);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    
		}
		
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(kmsid);
    stringBuffer.append(TEXT_281);
    
	}
	
    
}

    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(TEXT_292);
    if(enableKMS){ /* KMS is enabled, so test for default or presence of key */

    stringBuffer.append(TEXT_293);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(kmsid);
    stringBuffer.append(TEXT_296);
    
	}
	
    stringBuffer.append(TEXT_297);
    
	if("\"\"".equals(kmsid)){
	
    stringBuffer.append(TEXT_298);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    
		}
		
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    
	} else {
	
    stringBuffer.append(TEXT_303);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    
		}
		
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(kmsid);
    stringBuffer.append(TEXT_308);
    
	}
	
    
}

    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    
		}
		
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    
		if (("true").equals(dieOnError)) {
		
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    
		} else {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    
			}
			
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    
		}
		
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    
		if(!("true").equals(useExistingConn)) {
		
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    
		}
		
    stringBuffer.append(TEXT_382);
    return stringBuffer.toString();
  }
}

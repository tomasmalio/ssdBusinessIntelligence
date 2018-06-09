package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TEDIFACTtoXMLMainJava
{
  protected static String nl;
  public static synchronized TEDIFACTtoXMLMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TEDIFACTtoXMLMainJava result = new TEDIFACTtoXMLMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "String modelURI_";
  protected final String TEXT_3 = " = \"urn:org.milyn.edi.unedifact:\"+\"";
  protected final String TEXT_4 = "\"+\"-mapping:1.4-SNAPSHOT\";" + NL + "" + NL + "org.milyn.edisax.unedifact.UNEdifactInterchangeParser parser_";
  protected final String TEXT_5 = " = new org.milyn.edisax.unedifact.UNEdifactInterchangeParser();" + NL + "" + NL + "routines.system.Document d_";
  protected final String TEXT_6 = "=new routines.system.Document();" + NL + "java.io.FileInputStream fis_";
  protected final String TEXT_7 = " = new java.io.FileInputStream(";
  protected final String TEXT_8 = ");" + NL + "" + NL + "try {" + NL + "\torg.milyn.edisax.registry.DefaultMappingsRegistry mappingsRegistry_";
  protected final String TEXT_9 = " = new org.milyn.edisax.registry.DefaultMappingsRegistry();" + NL + "\tmappingsRegistry_";
  protected final String TEXT_10 = ".addModelReferences(modelURI_";
  protected final String TEXT_11 = ", new java.net.URI(\"/\"));" + NL + "\tparser_";
  protected final String TEXT_12 = ".setMappingsRegistry(mappingsRegistry_";
  protected final String TEXT_13 = ");" + NL + "\tparser_";
  protected final String TEXT_14 = ".setFeature(org.milyn.edisax.EDIParser.FEATURE_IGNORE_NEWLINES, ";
  protected final String TEXT_15 = ");" + NL + "\tparser_";
  protected final String TEXT_16 = ".setFeature(org.milyn.edisax.EDIParser.FEATURE_IGNORE_EMPTY_NODES, false);" + NL + "\torg.dom4j.io.SAXContentHandler handler_";
  protected final String TEXT_17 = " = new org.dom4j.io.SAXContentHandler();" + NL + "\tparser_";
  protected final String TEXT_18 = ".setContentHandler(new routines.system.xml.sax.NamespaceFilter(handler_";
  protected final String TEXT_19 = ", new routines.system.xml.sax.NamespaceFilter.Matcher() {" + NL + "\t\tpublic boolean matches(String uri) {" + NL + "\t\t\treturn uri.startsWith(\"urn:org.milyn.edi.\");" + NL + "\t\t}" + NL + "\t}));" + NL + "\tparser_";
  protected final String TEXT_20 = ".parse(new org.xml.sax.InputSource(fis_";
  protected final String TEXT_21 = "));" + NL + "" + NL + "\td_";
  protected final String TEXT_22 = ".setDocument((org.dom4j.Document)handler_";
  protected final String TEXT_23 = ".getDocument());" + NL + "" + NL + "} catch (org.milyn.SmooksException sE_";
  protected final String TEXT_24 = ") {";
  protected final String TEXT_25 = NL + "\t\tthrow sE_";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + "\t\tSystem.err.println(sE_";
  protected final String TEXT_28 = ".getMessage());";
  protected final String TEXT_29 = NL + "} catch (java.lang.Exception dE_";
  protected final String TEXT_30 = ") {";
  protected final String TEXT_31 = NL + "\t\tthrow dE_";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "\t\tSystem.err.println(dE_";
  protected final String TEXT_34 = ".getMessage());";
  protected final String TEXT_35 = NL + "} finally {" + NL + "\tfis_";
  protected final String TEXT_36 = ".close();" + NL + "}";
  protected final String TEXT_37 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = "=d_";
  protected final String TEXT_40 = ";";
  protected final String TEXT_41 = NL + NL + NL;
  protected final String TEXT_42 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();
	
	String version = ElementParameterParser.getValue(node, "__EDI_VERSION__");
	String filename = ElementParameterParser.getValue(node, "__EDI_FILE__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String ignoreNewLines = ElementParameterParser.getValue(node, "__IGNORE_NEW_LINE__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append("true".equals(ignoreNewLines)?"true":"false");
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
	if ("true".equals(dieOnError)) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
	} else {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
	}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
	if ("true".equals(dieOnError)) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
	} else {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
	}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    

List< ? extends IConnection> conns = node.getOutgoingConnections();

if (conns!=null) {
    if (conns.size()>0) {
		for (int i=0;i<conns.size();i++) {
			IConnection conn = conns.get(i);
			if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				List<IMetadataTable> metadatas = node.getMetadataList();
				if ((metadatas!=null)&&(metadatas.size()>0)) {
					IMetadataTable metadata = metadatas.get(0);
					List<IMetadataColumn> listColumns = metadata.getListColumns();
					int sizeListColumns = listColumns.size();
					for (int j=0; j<sizeListColumns; j++) {
						IMetadataColumn column = listColumns.get(j);
						if("id_Document".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
						}
					}
				}
			}
		}
	}
}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    return stringBuffer.toString();
  }
}

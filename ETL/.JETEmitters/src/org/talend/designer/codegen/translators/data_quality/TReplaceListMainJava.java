package org.talend.designer.codegen.translators.data_quality;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;

public class TReplaceListMainJava
{
  protected static String nl;
  public static synchronized TReplaceListMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TReplaceListMainJava result = new TReplaceListMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\tString inputFlow_";
  protected final String TEXT_3 = "_";
  protected final String TEXT_4 = " = (null != ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ") ? String.valueOf(";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = ") : null;" + NL + "" + NL + "\t\t\tif (null != inputFlow_";
  protected final String TEXT_9 = "_";
  protected final String TEXT_10 = ") {" + NL + "\t\t\t\tfor(Object o:replace_";
  protected final String TEXT_11 = ".keySet()){" + NL + "\t\t\t\t\tif(o.getClass().getSimpleName() .equals(\"";
  protected final String TEXT_12 = "\")){" + NL + "\t\t\t\t\t\tString search";
  protected final String TEXT_13 = " = String.valueOf(o);" + NL + "\t\t\t\t\t\tif(replace_";
  protected final String TEXT_14 = ".get(o)==null||replace_";
  protected final String TEXT_15 = ".get(o).getClass().getSimpleName() .equals(\"";
  protected final String TEXT_16 = "\")){" + NL + "\t\t\t\t\t\t\tString replace";
  protected final String TEXT_17 = " = (null!=replace_";
  protected final String TEXT_18 = ".get(o))?String.valueOf(replace_";
  protected final String TEXT_19 = ".get(o)):\"\";" + NL + "\t\t\t\t\t\t\tinputFlow_";
  protected final String TEXT_20 = "_";
  protected final String TEXT_21 = " = inputFlow_";
  protected final String TEXT_22 = "_";
  protected final String TEXT_23 = ".replaceAll(";
  protected final String TEXT_24 = "\"(?i)\" + ";
  protected final String TEXT_25 = "search";
  protected final String TEXT_26 = ",replace";
  protected final String TEXT_27 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\tif (null == inputFlow_";
  protected final String TEXT_29 = "_";
  protected final String TEXT_30 = ") {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = " = null;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\telse {";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " = new java.util.Date(inputFlow_";
  protected final String TEXT_36 = "_";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " = new BigDecimal(inputFlow_";
  protected final String TEXT_41 = "_";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = " = new Character(inputFlow_";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = ".toCharArray()[0]);";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = ".valueOf(inputFlow_";
  protected final String TEXT_52 = "_";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "\t\t\t\t\t\t}";
  protected final String TEXT_55 = NL;
  protected final String TEXT_56 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<Map<String, String>> columnOptions =
    (List<Map<String,String>>)ElementParameterParser.getObjectValue(
        node,
        "__COLUMN_OPTIONS__"
    );


List<IMetadataTable> metadatas = node.getMetadataList();
if (metadatas != null && metadatas.size() > 0) {
    List<IConnection> inputConnections;
    String main = null;
    inputConnections = (List<IConnection>) node.getIncomingConnections();
    for (IConnection connection : inputConnections) {
        if (connection == null) {
            continue;
        }

        if (connection.getLineStyle() == EConnectionType.FLOW_MAIN) {
            main = connection.getName();
            continue;
        }
    }

    IMetadataTable metadata = metadatas.get(0);

    int column_num = 0;
    for (Map<String, String> columnOption: columnOptions) {
        if (("true").equals(columnOption.get("REPLACE"))) {
        	IMetadataColumn column = metadata.getListColumns().get(column_num);
        	String testType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
        	// Don't know why javaType.isGenerateWithCanonicalName() returns "true" when it's java.util.Date, so need to handle the name
        	if("java.util.Date".equals(testType)){
        		testType = "Date";
        	}
            String columnName = metadata.getListColumns().get(column_num).getLabel();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(main);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(main);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(testType);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(testType);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_23);
    if(("true").equals(columnOption.get("CASE_INSENSITIVE"))) {
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
        }
        column_num++;
    }
    
    //output
        for(Map<String,String> columnOption: columnOptions){
            if (("true").equals(columnOption.get("REPLACE"))){
            	for (IMetadataColumn column : metadata.getListColumns()) { 
	            	if(column.getLabel().equals(columnOption.get("SCHEMA_COLUMN"))) {
	        			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
	                	String columnname = column.getLabel();

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnname);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(main);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(columnname);
    stringBuffer.append(TEXT_32);
    
							if("java.util.Date".equals(typeToGenerate)){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(main);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnname);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(columnname);
    stringBuffer.append(TEXT_37);
    
							}else if("BigDecimal".equals(typeToGenerate)){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(main);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(columnname);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(columnname);
    stringBuffer.append(TEXT_42);
    
							}else if("Character".equals(typeToGenerate)){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(main);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(columnname);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(columnname);
    stringBuffer.append(TEXT_47);
    
							}else{

    stringBuffer.append(TEXT_48);
    stringBuffer.append(main);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(columnname);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(columnname);
    stringBuffer.append(TEXT_53);
    
							}

    stringBuffer.append(TEXT_54);
    
						break;
					} // if
				} // for
            }
       }
    
    

    stringBuffer.append(TEXT_55);
    
}

    stringBuffer.append(TEXT_56);
    return stringBuffer.toString();
  }
}

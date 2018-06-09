package org.talend.designer.codegen.translators.generic.component;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;

public class ComponentProcess_data_end
{
  protected static String nl;
  public static synchronized ComponentProcess_data_end create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponentProcess_data_end result = new ComponentProcess_data_end();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t} //end of data processing while block" + NL + "\tif (writer_";
  protected final String TEXT_2 = " instanceof org.talend.components.api.component.runtime.WriterWithFeedback) {" + NL + "    \t((org.talend.components.api.component.runtime.WriterWithFeedback) writer_";
  protected final String TEXT_3 = ").cleanWrites();" + NL + "    }" + NL + "\t";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
boolean hasInput = !NodeUtil.getIncomingConnections(node, IConnectionCategory.DATA).isEmpty();
if(hasInput){
	boolean hasMainIrToRow = false;
    boolean hasRejectIrToRow = false;
	List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    if (outgoingConns!=null){
        for (int i = 0; i < outgoingConns.size(); i++) {
            IConnection outgoingConn = outgoingConns.get(i);
            if ("MAIN".equals(outgoingConn.getConnectorName())) {
                hasMainIrToRow = true;
            }
            if ("REJECT".equals(outgoingConn.getConnectorName())) {
                hasRejectIrToRow = true;
            }
        }
    }
    // Generate the code to handle the incoming records.
    IConnection inputConn = null;
    List< ? extends IConnection> inputConns = node.getIncomingConnections();
    if(inputConns!=null) {
	   	for (IConnection conn : inputConns) {
	   		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	   			inputConn = conn;
	    	}
	   	}
   	}

   	boolean hasValidInput = inputConn!=null;

   	IMetadataTable metadata;
    List<IMetadataTable> metadatas = node.getMetadataList();
    boolean haveValidNodeMetadata = ((metadatas != null) && (metadatas.size() > 0) && (metadata = metadatas.get(0)) != null);
    if(haveValidNodeMetadata && hasValidInput) {
    	List<IMetadataColumn> input_columnList = inputConn.getMetadataTable().getListColumns();

        if (input_columnList!=null && !input_columnList.isEmpty() && (hasMainIrToRow || hasRejectIrToRow)) {
	
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
		}
	}
}

    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}

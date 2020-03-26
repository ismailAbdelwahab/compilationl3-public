package fg;
import nasm.*;
import util.graph.*;
import java.util.*;
import java.io.*;

public class Fg implements NasmVisitor <Void> {
    public Nasm nasm;
    public Graph graph;
    Map< NasmInst, Node> inst2Node;
    Map< Node, NasmInst> node2Inst;
    Map< String, NasmInst> label2Inst;

    private final Node[] nodeArray;

    public Fg(Nasm nasm){
        this.nasm = nasm;
        this.inst2Node = new HashMap< NasmInst, Node>();
        this.node2Inst = new HashMap< Node, NasmInst>();
        this.label2Inst = new HashMap< String, NasmInst>();
        this.graph = new Graph();

        /* Create a vertex for every nasm instruction */
        for( NasmInst inst : nasm.listeInst ){
            Node node = this.graph.newNode();
            putDataInMaps( inst, node );
        }
        // Get the array of nodes :
        this.nodeArray = this.graph.nodeArray();
        /* Start the visit of instructions to create edges */
        for (NasmInst inst : nasm.listeInst )
            inst.accept( this );
    }

    public void affiche(String baseFileName){
	String fileName;
	PrintStream out = System.out;

	if (baseFileName != null){
	    try {
		baseFileName = baseFileName;
		fileName = baseFileName + ".fg";
		out = new PrintStream(fileName);
	    }
	    
	    catch (IOException e) {
		System.err.println("Error: " + e.getMessage());
	    }
	}
	
	for(NasmInst nasmInst : nasm.listeInst){
	    Node n = this.inst2Node.get(nasmInst);
	    out.print(n + " : ( ");
	    for(NodeList q=n.succ(); q!=null; q=q.tail) {
		out.print(q.head.toString());
		out.print(" ");
	    }
	    out.println(")\t" + nasmInst);
	}
    }
/* **************** Manage Maps ************************** */
    private void putDataInMaps(NasmInst inst, Node node ){
        putInst2Node( inst, node );
        putNode2Inst( node, inst );
        putLabelIfExist( inst );
    }
    private void putLabelIfExist(NasmInst inst){
        if( inst.label != null ){
            NasmLabel label = (NasmLabel) inst.label;
            this.label2Inst.put( label.val , inst);
        }
    }
    private void putInst2Node(NasmInst inst, Node node){
        this.inst2Node.put( inst, node);
    }
    private void putNode2Inst(Node node, NasmInst inst){
        this.node2Inst.put(node, inst);
    }
/* ************** Manage edges ********************** */
    private void addEdgeToNextInstruction( NasmInst inst ){
        Node currentNode = inst2Node.get( inst );
        if( currentNode.label()+1 >= nodeArray.length )
            return; // No more instructions after the current one
        Node nextNode =  this.nodeArray[ currentNode.label()+1 ];
        graph.addEdge( currentNode, nextNode);
    }
/* **************** Visit  ************************** */
    /* *********** Classic vertices **************** */
    public Void visit(NasmAdd inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    public Void visit(NasmDiv inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    public Void visit(NasmMul inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    public Void visit(NasmOr inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    public Void visit(NasmCmp inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    public Void visit(NasmNot inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    public Void visit(NasmPop inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    public Void visit(NasmRet inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    public Void visit(NasmXor inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    public Void visit(NasmAnd inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    public Void visit(NasmMov inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    public Void visit(NasmPush inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    public Void visit(NasmSub inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    public Void visit(NasmEmpty inst){
        addEdgeToNextInstruction( inst );
        return null;
    }
    /* *********** Jump vertices *********************/
    public Void visit(NasmCall inst){return null;}
    public Void visit(NasmJe inst){return null;}
    public Void visit(NasmJle inst){return null;}
    public Void visit(NasmJne inst){return null;}
    public Void visit(NasmInst inst){return null;}
    public Void visit(NasmJge inst){return null;}
    public Void visit(NasmJl inst){return null;}
    public Void visit(NasmJg inst){return null;}
    public Void visit(NasmJmp inst){return null;}

    public Void visit(NasmAddress operand){return null;}
    public Void visit(NasmConstant operand){return null;}
    public Void visit(NasmLabel operand){return null;}
    public Void visit(NasmRegister operand){return null;}


}

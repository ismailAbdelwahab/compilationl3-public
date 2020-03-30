package ig;

import fg.*;
import nasm.*;
import util.graph.*;
import util.intset.*;

import java.io.*;

public class Ig {
    public Graph graph;
    public FgSolution fgs;
    public int regNb;
    public Nasm nasm;
    public Node int2Node[];

    private int[] pre_colors;
    private ColorGraph colorGraph;

    
    public Ig(FgSolution fgs){
	this.fgs = fgs;
 	this.graph = new Graph();
	this.nasm = fgs.nasm;
	this.regNb = this.nasm.getTempCounter()+1;
	this.int2Node = new Node[regNb];

	this.build();
	pre_colors = getPrecoloredTemporaries();
	colorGraph = new ColorGraph(graph, regNb, pre_colors);

	allocateRegisters();
    }
    /////////////// Construction //////////////////////////////////////////////////
    public void build(){
        for( int i=0 ; i<regNb ; i++ )
            int2Node[i] = graph.newNode();
        for( NasmInst inst : nasm.listeInst ){
            IntSet inInst  = fgs.in.get(  inst );
            IntSet outInst = fgs.out.get( inst );
            buildFromIntSet( inInst  );
            buildFromIntSet( outInst );
        }
    }
    private void buildFromIntSet(IntSet set ){
        if( set.getSize() <= 1 ) return; // No couples possible
        for( int r=0 ; r<regNb ; r++ ) // For all registers "r"
            if( set.isMember( r ) ) // r is in SET
                for (int r_prime=r+1; r_prime<regNb; r_prime++ ) // find r_prime != r
                    if( set.isMember(r_prime) ) // r_prime is in SET
                        graph.addNOEdge( int2Node[r], int2Node[r_prime] ); // add edges
    }
    /////////////////////////////////////////////////////////////////////////////////
    ///////////////// Pre colored Temporaries ///////////////////////////////////////
    public int[] getPrecoloredTemporaries(){
        int[] preColoredTemperaries= new int[this.regNb];
        for ( NasmInst inst : nasm.listeInst ){
            if( inst.destination instanceof NasmRegister )
                treatNasmRegister( (NasmRegister) inst.destination , preColoredTemperaries);
            if( inst.source instanceof NasmRegister )
                treatNasmRegister( (NasmRegister) inst.source      , preColoredTemperaries);
        }
    	return preColoredTemperaries;
    }
    private void treatNasmRegister(NasmRegister register, int[] colors ){
        if( register.isGeneralRegister() )
            if( register.color != Nasm.REG_UNK )
                colors[register.val] = register.color;
    }
    /////////////////////////////////////////////////////////////////////////////////


    public void allocateRegisters(){
        int[] colors  = colorGraph.couleur;
        for( NasmInst inst : nasm.listeInst ){
            if( inst.destination instanceof NasmRegister )
                allocateColorToRegister( (NasmRegister) inst.destination, colors);
            if( inst.source instanceof NasmRegister )
                allocateColorToRegister( (NasmRegister) inst.source     , colors);
        }
    }
    private void allocateColorToRegister(NasmRegister register, int[] colors){
        if( register!=null && register.isGeneralRegister() )
            if( register.color == Nasm.REG_UNK )
                register.colorRegister( colors[register.val] );
    }

    ///////////////////////// AFFICHE //////////////////////////////////////////////////////
    public void affiche(String baseFileName){
	String fileName;
	PrintStream out = System.out;
	
	if (baseFileName != null){
	    try {
		baseFileName = baseFileName;
		fileName = baseFileName + ".ig";
		out = new PrintStream(fileName);
	    }
	    
	    catch (IOException e) {
		System.err.println("Error: " + e.getMessage());
	    }
	}
	
	for(int i = 0; i < regNb; i++){
	    Node n = this.int2Node[i];
	    out.print(n + " : ( ");
	    for(NodeList q=n.succ(); q!=null; q=q.tail) {
		out.print(q.head.toString());
		out.print(" ");
	    }
	    out.println(")");
	}
    }
}
	    
    

    
    

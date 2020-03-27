package fg;
import nasm.*;
import util.graph.Node;
import util.graph.NodeList;
import util.intset.*;
import java.io.*;
import java.util.*;

public class FgSolution {
	private int DEFAULT_INTSET_SIZE = 30;
	int iterNum = 0;
	public Nasm nasm;
	Fg fg;
	public Map<NasmInst, IntSet> use;
	public Map<NasmInst, IntSet> def;
	public Map<NasmInst, IntSet> in;
	public Map<NasmInst, IntSet> out;
	private HashMap<NasmInst, IntSet> inTEMP;
	private HashMap<NasmInst, IntSet> outTEMP;


	public FgSolution(Nasm nasm, Fg fg) {
		this.nasm = nasm;
		this.fg = fg;
		this.use = new HashMap<NasmInst, IntSet>();
		this.def = new HashMap<NasmInst, IntSet>();
		this.in = new HashMap<NasmInst, IntSet>();
		this.out = new HashMap<NasmInst, IntSet>();
		this.inTEMP = new HashMap<NasmInst, IntSet>();
		this.outTEMP = new HashMap<NasmInst, IntSet>();

		/* ***** use and def ******* */
		for (NasmInst inst : fg.nasm.listeInst)
			initUseAndDef( inst );
		/* ***** in and out   ********** */
		initializeAllIntSet( fg.nasm.listeInst );
		computeInAndOut( fg.nasm.listeInst );
	}

	/* ************* Use and Def ************************** */
	private int extractRegisterNumber( NasmOperand op ){
		return ((NasmRegister) op).val;
	}
	private void addRegisterNumberToSet(IntSet set, NasmOperand op ){
		set.add( extractRegisterNumber( op ) );
	}
	private void initUseAndDef(NasmInst inst) {
		IntSet defSet = new IntSet( DEFAULT_INTSET_SIZE );
		IntSet useSet = new IntSet( DEFAULT_INTSET_SIZE );
		/////////////// DEF part ////////////////////////////////////////
		if ( inst.destDef ){
			if( inst.destination.isGeneralRegister() )
				addRegisterNumberToSet( defSet, inst.destination);
			/* can destination be an address ??
			else if (inst.destination instanceof NasmAddress) {
				NasmAddress adr = (NasmAddress) inst.destination;
				if( isRegisterAndGeneral(adr.base) )
					addRegisterNumberToSet( defSet, adr.base );
				if( isRegisterAndGeneral(adr.offset) )
					addRegisterNumberToSet( defSet, adr.offset );
			}
			 */
		}
		if ( inst.srcDef ){
			if( inst.source.isGeneralRegister() )
				addRegisterNumberToSet( defSet, inst.source);
			else if (inst.source instanceof NasmAddress) {
				NasmAddress adr = (NasmAddress) inst.source;
				if( adr.base.isGeneralRegister() ) // Check the base
					addRegisterNumberToSet( defSet, adr.base );
				if( adr.offset.isGeneralRegister() ) //Check the offset
					addRegisterNumberToSet( defSet, adr.offset );
			}
		}
		/////////////// USE part ////////////////////////////////////////
		if( inst.destUse && inst.destination.isGeneralRegister() ){
			useSet.add( extractRegisterNumber(inst.destination) );
		}
		if( inst.srcUse && inst.source.isGeneralRegister() ){
			useSet.add( extractRegisterNumber(inst.source) );
		}
		this.def.put(inst , defSet);
		this.use.put( inst, useSet);
	}
	/* **************************************************** */
	/* ************* In and Out**************************** */
	private void initializeAllIntSet(List<NasmInst> insts){
		for ( NasmInst inst : insts ){
			this.in.put( inst, new IntSet(DEFAULT_INTSET_SIZE));
			this.out.put( inst, new IntSet(DEFAULT_INTSET_SIZE));
			this.inTEMP.put( inst, new IntSet(DEFAULT_INTSET_SIZE));
			this.outTEMP.put( inst, new IntSet(DEFAULT_INTSET_SIZE));
		}
	}
	private void copyInAndOutInTEMPS(NasmInst inst){
		this.inTEMP.replace( inst, this.in.get(inst).copy() );
		this.outTEMP.replace( inst, this.out.get(inst).copy() );
	}
	private void updateIn( NasmInst inst ){
		IntSet newIn = this.out.get( inst ).copy();
		newIn.minus( this.def.get(inst) );
		newIn.union( this.use.get(inst) );
		this.in.replace( inst, newIn );
		/*
		IntSet useInst = this.use.get( inst ).copy(); // use(s)
		IntSet outInst = this.out.get( inst ).copy(); // out(s)
		IntSet defInst = this.def.get( inst ).copy(); // def(s)
		IntSet outMinusDef = outInst.minus( defInst );// out(s) - def(s)
		IntSet newIn = useInst.union( outMinusDef );  // use(s) U [out(s) - def(s)]
		this.in.put( inst , newIn );
		 */
	}
	private void updateOut( NasmInst inst ){
		// Get the pred() of "inst":
		Node instructionNode = fg.inst2Node.get(inst);
		NodeList predecessors = instructionNode.pred();
		// For every predecessors:
		while ( predecessors != null ){
			// Get the "in" of the parent instruction:
			NasmInst parentInstruction = fg.node2Inst.get( predecessors.head );
			// Make a Union with the "in" of "inst"
			this.out.get( parentInstruction ).union( this.in.get(inst) );
			// Go to the next successor:
			predecessors = predecessors.tail;
		}
	}
	private void computeInAndOut(List<NasmInst> insts) {
		do {
			for( NasmInst inst : insts ){
				copyInAndOutInTEMPS( inst );
				updateIn( inst );
				updateOut( inst );
			}
			this.iterNum++;
		}while( ! areTEMPSConvergentToInAndOut(insts) );
	}
	private boolean areTEMPSConvergentToInAndOut(List<NasmInst> insts){
		for( NasmInst inst : insts ){
			if( ! this.inTEMP.get(inst).equal( this.in.get(inst) ) )
				return false;
			if( ! this.outTEMP.get(inst).equal( this.out.get(inst) ) )
				return false;
		}
		return true;
	}
	/* **************************************************** */


	/* ************* Affiche ************************** */
	public void affiche(String baseFileName) {
		String fileName;
		PrintStream out = System.out;

		if (baseFileName != null) {
			try {
				baseFileName = baseFileName;
				fileName = baseFileName + ".fgs";
				out = new PrintStream(fileName);
			} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}

		out.println("iter num = " + iterNum);
		for (NasmInst nasmInst : this.nasm.listeInst) {
			out.println("use = " + this.use.get(nasmInst) + " def = " + this.def.get(nasmInst) + "\tin = " + this.in.get(nasmInst) + "\t \tout = " + this.out.get(nasmInst) + "\t \t" + nasmInst);
		}
	}
}
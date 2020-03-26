package fg;
import nasm.*;
import util.intset.*;
import java.io.*;
import java.util.*;

public class FgSolution {
	int iterNum = 0;
	public Nasm nasm;
	Fg fg;
	public Map<NasmInst, IntSet> use;
	public Map<NasmInst, IntSet> def;
	public Map<NasmInst, IntSet> in;
	public Map<NasmInst, IntSet> out;

	public FgSolution(Nasm nasm, Fg fg) {
		this.nasm = nasm;
		this.fg = fg;
		this.use = new HashMap<NasmInst, IntSet>();
		this.def = new HashMap<NasmInst, IntSet>();
		this.in = new HashMap<NasmInst, IntSet>();
		this.out = new HashMap<NasmInst, IntSet>();

		/* ***** use() and def() ******* */
		for (NasmInst inst : fg.nasm.listeInst)
			initUseAndDef( inst );
		/* *****   ********** */

	}

	private int extractRegisterNumber( NasmOperand op ){
		return ((NasmRegister) op).val;
	}
	private void addRegisterNumberToSet(IntSet set, NasmOperand op ){
		set.add( extractRegisterNumber( op ) );
	}
	private boolean isRegisterAndGeneral(NasmOperand op ){
		return op instanceof NasmRegister && op.isGeneralRegister();
	}

	private void initUseAndDef(NasmInst inst) {
		IntSet defSet = new IntSet(4);
		IntSet useSet = new IntSet(4);
		if ( inst.destDef ){
			if( isRegisterAndGeneral(inst.destination) )
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
		if( inst.destUse && inst.destination.isGeneralRegister() ){
			useSet.add( extractRegisterNumber(inst.destination) );
		}
		if ( inst.srcDef ){
			if( isRegisterAndGeneral(inst.source) )
				addRegisterNumberToSet( defSet, inst.source);
			else if (inst.source instanceof NasmAddress) {
				NasmAddress adr = (NasmAddress) inst.source;
				if( isRegisterAndGeneral(adr.base) )
					addRegisterNumberToSet( defSet, adr.base );
				if( isRegisterAndGeneral(adr.offset) )
					addRegisterNumberToSet( defSet, adr.offset );
			}
		}
		if( inst.srcUse && inst.source.isGeneralRegister() ){
			useSet.add( extractRegisterNumber(inst.source) );
		}
		this.def.put(inst , defSet);
		this.use.put( inst, useSet);
	}

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
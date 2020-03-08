import sa.*;
import ts.Ts;

enum CONTEXT{
    GLOBAL,
    LOCAL,
    PARAM;
    public boolean isGlobal(){ return this == GLOBAL; }
    public boolean isLocal(){ return this == LOCAL; }
    public boolean isParam(){ return this == PARAM; }
}

public class Sa2ts extends SaDepthFirstVisitor {
    private Ts globalTable;
    private Ts currentLocalTable;
    private CONTEXT context;

    public Sa2ts(SaNode root){
        this.globalTable = new Ts();
        this.currentLocalTable = null;
        context = CONTEXT.GLOBAL;
        root.accept(this);
    }

    public Ts getTableGlobale() { return globalTable; }

    private boolean isVariableNotInTable(Ts table, String varName ){
        return table.getVar( varName ) == null ;
    }
    private boolean isFunctionNotInGlobalTable( String functionName ){
        return globalTable.getFct( functionName ) == null ;
    }

    public Void visit(SaDecVar node){
        System.out.println("trying to start SaDecVar is it null ???");
        String varName = node.getNom();
        System.out.println("Starting SaDecVar for variable: "+ varName);
        if( context.isGlobal() ){
            if( isVariableNotInTable(globalTable, varName) )
                node.tsItem = globalTable.addVar( varName, 1 );
            else {
                System.err.println("{GLOBAL} TABLE ERROR: [" + varName + "] variable already exists.");
                System.exit(1);
            }
        }
        else if( context.isLocal() ){
            if( isVariableNotInTable(currentLocalTable, varName) )
                node.tsItem = currentLocalTable.addVar(varName, 1);
            else {
                System.err.println("{LOCAL} TABLE ERROR: [" + varName + "] {simple variable} already exists.");
                System.exit(1);
            }
        }
        else if ( context.isParam() ){
            if( isVariableNotInTable(currentLocalTable, varName) )
                node.tsItem = currentLocalTable.addParam(varName);
            else {
                System.err.println("{LOCAL} TABLE ERROR: [" + varName + "] {parameter} already exists.");
                System.exit(1);
            }
        }
        return null;
    }

    public Void visit(SaDecTab node){
        String varName = node.getNom();
        int varSize = node.getTaille();
        if( context.isGlobal() ){
            if( isVariableNotInTable(globalTable, varName) )
                node.tsItem = globalTable.addVar( varName, varSize );
            else {
                System.err.println("{GLOBAL} TABLE ERROR: [" + varName + "] {array variable} already exists.");
                System.exit(1);
            }
        }
        else if( context.isLocal() || context.isParam() ){
            System.err.println("ERROR: Array cannot be declared in {Non-Global} context.");
            System.exit( 1 );
        }
        return null;
    }

    public Void visit(SaDecFonc node){
        System.out.println("Trying to declare function");
        String functionName = node.getNom();
        System.out.println("Starting to declare fiunction: ["+functionName+"]");
        if ( context.isGlobal() ){
            if( isFunctionNotInGlobalTable( functionName ) ){
                Ts functionTable = new Ts();
                this.currentLocalTable = functionTable;
                int nbParameters = (node.getParametres() == null) ? 0 : node.getParametres().length();
                /////////////////////////////////////////////////// Treat parameters
                this.context = CONTEXT.PARAM;
                System.out.println(">>>>>> Starting to define {Params} for function: ["+functionName+"]");
                SaLDec function_parameters = node.getParametres();
                if (function_parameters != null )
                    node.getParametres().accept( this );
                System.out.println("<<<<<< End of definition of {Params} for function: ["+functionName+"]");
                /*
                SaLDec remaining_parameters = node.getParametres();
                while ( remaining_parameters.getTete() != null ){
                    SaDecVar parameter = (SaDecVar) remaining_parameters.getTete();
                    visit( parameter );
                    remaining_parameters = remaining_parameters.getQueue();
                }
                 */
                //////////////////////////////////////////////////// Treat variables
                this.context = CONTEXT.LOCAL;
                System.out.println("####>>> Starting to define {variables} for function:["+functionName+"]");
                SaLDec function_variables = node.getVariable();
                if( function_variables != null ) // if there is at least one variable:
                    function_variables.accept( this );
                System.out.println("<<<#### End of definition of {variables} for function:["+functionName+"]");
                /*

                SaLDec remaining_variables = node.getVariable();
                while( remaining_variables.getTete() != null ){
                    SaDecVar variable = (SaDecVar) remaining_variables.getTete();
                    visit( variable );
                    remaining_variables = remaining_variables.getQueue();
                }
                 */
                //////////////////////////////////////////////////////////// TREAT the body of the function
                // Symbole table does not care about the body of function ? as there is no decalaration in there.
                /*
                System.out.println("##>>>>Starting to define {BODY ??} for function:"+functionName);
                node.getCorps().accept( this );
                System.out.println("<<<<##End of definition of {BODY ??} for function:"+functionName);
                 */
                /////////////////////////////////////////////////////// Add function to global table

                System.out.println("Adding :["+functionName+"] into global table.");
                node.tsItem = globalTable.addFct(functionName,nbParameters, functionTable, node );
                System.out.println("Added function done.");
            }else {
                System.err.println("Function [" + functionName + "] is already defined in {Global table}.");
                System.exit(1);
            }
        }
        else if( context.isLocal() ){
            System.err.println("Declaration of function cannot be in {LOCAL Context}");
            System.exit( 1 );
        }
        else if (context.isParam() ){
            System.err.println("Declaration of function cannot be in {Parameter Context}");
            System.exit( 1 );
        }
        ///// Reset variables to be in global context:
        this.currentLocalTable = null;
        this.context = CONTEXT.GLOBAL;
        return null;
    }

    public Void visit(SaVarSimple node){
        String varName = node.getNom();
        if( ( context.isLocal()||context.isParam() ) &&
                currentLocalTable.getVar( varName ) == null &&
                globalTable.getVar( varName ) == null){
            System.err.println("{Variable}["+ varName +"] not declared in {Local/Param context} nor in {Global context}.");
            System.exit( 1 );
        }
        else if( context.isGlobal() &&
                 globalTable.getVar( varName ) == null ){
            System.err.println("{Variable}["+ varName +"] not declared in {Global context}.");
            System.exit( 1 );
        }
        return null;
    }

    public Void visit(SaVarIndicee node){
        String varName = node.getNom();
        if( node.getIndice() == null ) { // Check that array variable has an index
            System.err.println("Error: {Array variable}[" + varName + "], must be used with an index.");
            System.exit(1);
        }
        if( context.isGlobal() && globalTable.getVar(varName) == null ) {
            System.err.println("{Array variable}[" + varName + "] not declared in {Global context}.");
            System.exit(1);
        }
        return null;
    }

    public Void visit(SaAppel node){
        String functionCalled = node.getNom();
        int nbGivenArgs = node.getArguments().length();
        if( globalTable.getFct( functionCalled ) == null ) {
            System.err.println("Error:{function called}[" + functionCalled + "] is not defined in {Global table}.");
            System.exit(1);
        }
        node.tsItem = globalTable.getFct( functionCalled );
        if (node.tsItem.nbArgs < nbGivenArgs) {
            System.err.println("Too many arguments given in {function call of}:[" + functionCalled + "].");
            System.exit(1);
        }
        if (node.tsItem.nbArgs > nbGivenArgs) {
            System.err.println("Too few arguments given in {function call of}:[" + functionCalled + "].");
            System.exit(1);
        }
        return null;
    }
}

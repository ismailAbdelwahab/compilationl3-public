import sa.*;
import ts.Ts;

/**
 * Enumeration that gives out the current context of the SaNode we are visiting.
 */
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
        this.context = CONTEXT.GLOBAL;
        root.accept(this);
    }

    public Ts getTableGlobale() { return globalTable; }

    /**
     * @param table The Ts table to search in.
     * @param varName The name of the variable to search.
     * @return True if "varName" is found in "table", False otherwise.
     */
    private boolean isVariableNotInTable(Ts table, String varName ){
        return table.getVar( varName ) == null ;
    }

    /**
     * @param functionName The function we are searching.
     * @return True if "functionName" is found in "this.globalTable"
     */
    private boolean isFunctionNotInGlobalTable( String functionName ){
        return globalTable.getFct( functionName ) == null ;
    }

    public Void visit(SaDecVar node){
        System.out.println("SaDecVar node  name =>"+node.getNom());
        String varName = node.getNom();
        if( context.isGlobal() ){
            if( isVariableNotInTable(globalTable, varName) )
                node.tsItem = globalTable.addVar( varName, 1 );
            else {
                System.err.println("{GLOBAL} TABLE ERROR: [" + varName + "] variable already exists.");
                System.exit(1);
            }
        }
        else if( context.isLocal() ){
            if( isVariableNotInTable(currentLocalTable, varName) ) {
                node.tsItem = currentLocalTable.addVar(varName, 1);
                System.out.println("SA2TS : SaDecVar : " + varName + "// tsItem=> " + node.tsItem);
            }
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
        System.out.println("Sa2TS SaDecFond ==> fonc name = "+node.getNom());
        String functionName = node.getNom();
        if ( context.isGlobal() ){
            if( isFunctionNotInGlobalTable( functionName ) ){
                Ts functionTable = new Ts();
                this.currentLocalTable = functionTable;
                int nbParameters = (node.getParametres() == null) ? 0 : node.getParametres().length();
                SaLDec function_parameters = node.getParametres();
                SaLDec function_variables = node.getVariable();
                /////////////////////////////////////////////////// Handle parameters
                this.context = CONTEXT.PARAM;
                if (function_parameters != null )
                    function_parameters.accept( this );
                /////////////////////////////////////////////////// Handle variables
                this.context = CONTEXT.LOCAL;
                if( function_variables != null )
                    function_variables.accept( this );

                //node.getCorps().accept( this ); // TODO check if we have to do this or not
                //////////////////////////////////////////////////// Add function to global table
                node.tsItem = globalTable.addFct(functionName,nbParameters, functionTable, node );
            }else {
                System.err.println("Function [" + functionName + "] is already defined in {Global table}.");
                System.exit(1);
            }
        }
        else if( context.isLocal() || context.isParam() ){
            System.err.println("Declaration of function cannot be in {Local or Param Context}");
            System.exit( 1 );
        }
        /////// Reset variables to be in global context:
        this.currentLocalTable = null;
        this.context = CONTEXT.GLOBAL;
        return null;
    }

    public Void visit(SaVarSimple node){
        String varName = node.getNom();
        System.out.println("SA2TS SaVarSimple node ==> "+node.getNom());
        if( (context.isLocal()||context.isParam()) && // Context is [A] Local OR [B] Param
                currentLocalTable.getVar( varName ) == null && // Var must be: [1] a Local variable OR [2] a Parameter
                globalTable.getVar( varName ) == null){        //                  OR [3] a Global variable
            System.err.println("{Variable}["+ varName +"] not declared in {Local/Param context} nor in {Global context}.");
            System.exit( 1 );
        }
        else if( context.isGlobal() &&                // Context is [C] Global
                 globalTable.getVar( varName ) == null ){ // Var must be Global.
            System.err.println("{Variable}["+ varName +"] not declared in {Global context}.");
            System.exit( 1 );
        }


        if ( context.isGlobal() )
            node.tsItem = globalTable.getVar( varName );
        else if ( context.isParam() || context.isLocal() )
            node.tsItem = currentLocalTable.getVar( varName );
        return null;
    }

    public Void visit(SaVarIndicee node){
        String varName = node.getNom();
        if( node.getIndice() == null ) {
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

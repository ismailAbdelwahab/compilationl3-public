package util.graph;

import util.intset.*;
import java.util.*;

public class ColorGraph {
    public  Graph          G;
    public  int            R;
    public  int            K;
    private Stack<Integer> stack;
    public  IntSet         removed;
    public  IntSet         spill;
    public  int[]          couleur;
    public  Node[]         int2Node;
    static  int            NOCOLOR = -1;

    private int NB_PRECOLORED_NODES = 0;

    public ColorGraph(Graph G, int K, int[] phi){
	this.G       = G;
	this.K       = K;
	stack        = new Stack<Integer>();
	R            = G.nodeCount();
	couleur      = new int[R];
	removed      = new IntSet(R);
	spill        = new IntSet(R);
	int2Node     = G.nodeArray();
	for(int v=0; v < R; v++){
	    int preColor = phi[v];
	    if(preColor >= 0 && preColor < K) {
            couleur[v] = phi[v];
            NB_PRECOLORED_NODES++; // Used to count the number of pre-colored nodes
	    }
	    else
		    couleur[v] = NOCOLOR;
	}
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    /* associe une couleur à tous les sommets se trouvant dans la pile */
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public void selection() {
        while( stack.size() != 0 ){
            int s = stack.pop();
            IntSet C = couleursVoisins( s );
            if( C.getSize() != this.K )
                couleur[s] = choisisCouleur( C );
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/
    /* récupère les couleurs des voisins de t */
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public IntSet couleursVoisins(int t) {
        IntSet neighboursColor = new IntSet(this.K);
        Node node = int2Node[t];
        NodeList neighbours = node.succ();
        while( neighbours != null ){
            int neighbour_key = neighbours.head.mykey;
            neighboursColor.add( couleur[neighbour_key] );

            neighbours = neighbours.tail;
        }
        return  neighboursColor;
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/
    /* recherche une couleur absente de colorSet */
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public int choisisCouleur(IntSet colorSet) {
        for( int color=0; color<this.K; color++ )
            if( !colorSet.isMember(color) ) return color;
        return -1;
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/
    /* calcule le nombre de voisins du sommet t */
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public int nbVoisins(int t) {
        int NB_Neighbours = 0;
        NodeList neighbours = int2Node[t].succ();
        while( neighbours != null ){
            Node neighbour = neighbours.head;
            if( !removed.isMember(neighbour.mykey) )
                NB_Neighbours++;
            neighbours = neighbours.tail;
        }
        return NB_Neighbours;
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    /* simplifie le graphe d'interférence g                                                                        */
    /* la simplification consiste à enlever du graphe les temporaires qui ont moins de k voisins                   */
    /* et à les mettre dans une pile                                                                               */
    /* à la fin du processus, le graphe peut ne pas être vide, il s'agit des temporaires qui ont au moins k voisin */
    /*-------------------------------------------------------------------------------------------------------------*/

    public int simplification() {
        boolean modif = true;
        int N = this.R - NB_PRECOLORED_NODES;
        while( stack.size()!=this.R  && modif ){
            modif = false;
            for( int s=0; s<this.R; s++ )
                if( this.couleur[s] == NOCOLOR && nbVoisins(s) < this.K ) {
                    stack.push( s );
                    removed.add( s );
                    modif = true;
                }
        }
        return 0;
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public void overflow(){
        while( stack.size() != this.R ){
            int s = choose_vertex();
            stack.push( s );
            removed.add( s );
            spill.add( s);
            simplification();
        }

    }
    private int choose_vertex(){
        int vertex;
        for( vertex=0;  vertex < this.R; vertex++ ){
            if( !stack.contains(vertex) )
                return vertex;
        }
        return -1;
    }


    /*-------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------*/

    public void coloration() {
	this.simplification();
	this.overflow();
	this.selection();
    }

    void affiche() {
	System.out.println("vertex\tcolor");
	for(int i = 0; i < R; i++){
	    System.out.println(i + "\t" + couleur[i]);
	}
    }
    
    

}

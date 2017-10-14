package jgrapht;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.jgrapht.alg.*;
import org.jgrapht.alg.interfaces.MinimumVertexCoverAlgorithm.VertexCover;
import org.jgrapht.alg.vertexcover.*;
import org.jgrapht.alg.vertexcover.ClarksonTwoApproxVCImpl;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

/**
 *
 * @author Lucas Tedeschi (41406133) e Rubens Gondek (41411978)
 * Turma 6N
 */
public class ProjetinhoJGRAPHT {
    
    public static void main(String[] args) {
        
        //Printando nome dos integrantes do trabalho
        System.out.println("Integrantes: \n- Lucas Rezende Tedeschi\n---- TIA: 41406133"
                + "\n- Rubens Gondek\n---- TIA: 41411978");
        
        //Printando tema do trabalho
        System.out.println("\n\nPROJETINHO PARA SENTIR O GOSTO DO JGRAPHT");
        System.out.println("--------------------------------------------------------------------\n");
        
        //Criação do grafo utilizando o SimpleGraph da biblioteca JGraphT
        SimpleGraph<String, DefaultEdge> g;
        g = new SimpleGraph<>(DefaultEdge.class);
        
        //Criação de todos os vértices
        String x1 = "x1";
        String x2 = "x2";
        String x3 = "x3";
        String x4 = "x4";
        String x5 = "x5";
        String y1 = "y1";
        String y2 = "y2";
        String y3 = "y3";
        String y4 = "y4";
        String y5 = "y5";
        
        //Adicionando os vértices criados
        g.addVertex(x1);
        g.addVertex(x2);
        g.addVertex(x3);
        g.addVertex(x4);
        g.addVertex(x5);
        g.addVertex(y1);
        g.addVertex(y2);
        g.addVertex(y3);
        g.addVertex(y4);
        g.addVertex(y5);
        
        //Criando as arestas com os vértices já adicionados do grafo
        g.addEdge(x1, y2);
        g.addEdge(x1, y3);
        g.addEdge(x2, y1);
        g.addEdge(x2, y2);
        g.addEdge(x2, y4);
        g.addEdge(x2, y5);
        g.addEdge(x3, y2);
        g.addEdge(x3, y3);
        g.addEdge(x4, y2);
        g.addEdge(x4, y3);
        g.addEdge(x5, y4);
        g.addEdge(x5, y5);

        //Printando no console todos os vértices
        Set<String> v = g.vertexSet();
        System.out.println("Vértices do grafo: " + v + "\n");

        //Printando no console o grau de cada vértice
        for (String item : v) {
            System.out.println("Grau do vértice " + item + ": " + g.degreeOf(item));
        }
        
        //Criando os subconjuntos do grafo que é bipartido
        Set<String> p1 = new HashSet<>(Arrays.asList(x1, x2, x3, x4, x5));
        Set<String> p2 = new HashSet<>(Arrays.asList(y1, y2, y3, y4, y5));

        //Instanciando algoritmo de HoperoftKarp para calcular emparelhamento máximo de um grafo bipartido
        HopcroftKarpBipartiteMatching<String, DefaultEdge> emparelhamento = 
            new HopcroftKarpBipartiteMatching<>(g, p1, p2);
        
        //Gerando emparelhamento máximo através do método já implementado getMatching no JGraphT
        Set<DefaultEdge> match = emparelhamento.getMatching();

        //Printando no console o emparelhamento máximo
        System.out.println("\n- Emparelhamento máximo (Algoritmo Hoperoft Karp):\n---- " + match);
        
        //Instanciando algoritmo para calcular a cobertura mínima de um grafo
        RecursiveExactVCImpl<String, DefaultEdge> coberturaMinima = 
                new RecursiveExactVCImpl<>();
        
        //Gerando cobertura mínima através do método já implementado getVertexCover no JGraphT
        VertexCover<String> vertexCover = coberturaMinima.getVertexCover(g);
        
        //Printando no console a cobertura mínima
        System.out.println("\n- Cobertura mínima: \n---- " + vertexCover);
    }
}

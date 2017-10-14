/*
 * (C) Copyright 2003-2017, by Barak Naveh and Contributors.
 *
 * JGraphT : a free Java graph-theory library
 *
 * This program and the accompanying materials are dual-licensed under
 * either
 *
 * (a) the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation, or (at your option) any
 * later version.
 *
 * or (per the licensee's choosing)
 *
 * (b) the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation.
 */
package org.jgrapht.graph;

import org.jgrapht.*;

/**
 * An undirected weighted graph which is also {@link org.jgrapht.ListenableGraph}.
 *
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 *
 * @see DefaultListenableGraph
 */
public class ListenableUndirectedWeightedGraph<V, E>
    extends ListenableUndirectedGraph<V, E>
    implements WeightedGraph<V, E>
{
    private static final long serialVersionUID = 3690762799613949747L;

    /**
     * Creates a new listenable undirected weighted graph.
     *
     * @param edgeClass class on which to base factory for edges
     */
    public ListenableUndirectedWeightedGraph(Class<? extends E> edgeClass)
    {
        this(new SimpleWeightedGraph<>(edgeClass));
    }

    /**
     * Creates a new listenable undirected weighted graph.
     *
     * @param base the backing graph.
     */
    public ListenableUndirectedWeightedGraph(WeightedGraph<V, E> base)
    {
        super((UndirectedGraph<V, E>) base);
    }
}

// End ListenableUndirectedWeightedGraph.java

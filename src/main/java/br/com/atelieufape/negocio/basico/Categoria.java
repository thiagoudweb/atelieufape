package br.com.atelieufape.negocio.basico;

import java.util.Arrays;
import java.util.List;

public class Categoria {

    public static final String ROUPA = "Roupa";
    public static final String CALCADO = "Calçado";
    public static final String ACESSORIO = "Acessório";

    public static final List<String> CATEGORIAS_PERMITIDAS = Arrays.asList(ROUPA, CALCADO, ACESSORIO);
}
package br.com.livroandroid.carros.domain;

/**
 * Created by rlech on 9/26/2015.
 */
import android.content.Context;
import android.util.Log;

import br.com.livroandroid.carros.R;
import livroandroid.lib.utils.FileUtils;
import livroandroid.lib.utils.XMLUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarroService {
    public static List<Carro> getCarros(Context context, int tipo) {
        String tipoString = context.getString(tipo);
        List<Carro> carros = new ArrayList<Carro>();
        for (int i = 0; i < 20; i++) {
            Carro c = new Carro();
            c.nome = "Carro " + tipoString + ": " + i;	// Nome dinâmico conforme o tipo
            c.desc = "Desc " + i;
            c.urlFoto = "http://www.livroandroid.com.br/livro/carros/esportivos/Ferrari_FF.png";
            carros.add(c);
        }
        return carros;
    }
}



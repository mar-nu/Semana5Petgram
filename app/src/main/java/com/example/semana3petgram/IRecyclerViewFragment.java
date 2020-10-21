package com.example.semana3petgram;

import java.util.ArrayList;

public interface IRecyclerViewFragment {

    public void generarLinearLayoutVertical();

    public MascotaAdapter crearAdaptador (ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV (MascotaAdapter adapter);

}

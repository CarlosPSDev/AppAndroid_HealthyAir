package com.riluca.healthyair.ui.quienes_somos;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.riluca.healthyair.R;

public class QuienesActivity extends AppCompatActivity {


    ImageView ivFoto;
    TextView tvNombre;
    TextView tvDescripcion;
    String[] nombres;
    String[] descripciones;
    int desarrolladoractual;
    float x1, x2;
    float y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quienes);

        ivFoto = findViewById(R.id.ivFoto);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        tvNombre = findViewById(R.id.tvNombre);
        nombres = new String[3];
        descripciones = new String[3];

        rellenarArrays();
        desarrolladoractual = 1;
        rellenarViews();
    }

    public void rellenarViews() {

        tvNombre.setText(nombres[desarrolladoractual - 1]);
        tvDescripcion.setText(descripciones[desarrolladoractual - 1]);
        switch (desarrolladoractual) {
            case 1:
                ivFoto.setImageResource(R.drawable.carlos);
                break;
            case 2:
                ivFoto.setImageResource(R.drawable.me);
                break;
            case 3:
                ivFoto.setImageResource(R.drawable.ricardo);
                break;
        }
    }

    public void rellenarArrays() {

        nombres[0] = getResources().getString(R.string.nombre_desarrollador_1);
        nombres[1] = getResources().getString(R.string.nombre_desarrollador_2);
        nombres[2] = getResources().getString(R.string.nombre_desarrollador_3);

        descripciones[0] = getResources().getString(R.string.descripcion_desarrollador_1);
        descripciones[1] = getResources().getString(R.string.descripcion_desarrollador_2);
        descripciones[2] = getResources().getString(R.string.descripcion_desarrollador_3);

    }

    // Metodo onTouchEvent
    //Es un swap
    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {
            // Cuando pongo el dedo en la pantalla, me coge las cordenadas de X e Y
            case MotionEvent.ACTION_DOWN: {
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            }
            // Cuando suelto la pantalla con el dedo, me coge las nuevas cordenadas X e Y
            case MotionEvent.ACTION_UP: {
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                //Si la cordenada x inicial es menor que donde la he soltado, me muevo de izquierda a derecha
                if (x1 < x2) {
                    desarrolladoractual--;
                    if (desarrolladoractual == 0) {
                        desarrolladoractual = 3;
                    }
                    rellenarViews();
                }

                if (x1 > x2) {
                    desarrolladoractual++;
                    if (desarrolladoractual == 4) {
                        desarrolladoractual = 1;
                    }
                    rellenarViews();
                }
                break;
            }
        }
        return false;
    }


}
